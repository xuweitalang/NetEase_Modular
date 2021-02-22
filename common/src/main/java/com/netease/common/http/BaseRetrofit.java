package com.netease.common.http;

import com.netease.common.base.BaseApplication;
import com.netease.common.http.interceptor.HeaderInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求管理器
 */
public class RetrofitManager {

    private Retrofit mRetrofit;

    //构造器私有，这个工具类只有一个实例
    public RetrofitManager(String url) {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(HttpConstant.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(HttpConstant.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(HttpConstant.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor())
                .addInterceptor(new HeaderInterceptor())
                .retryOnConnectionFailure(true); // 错误重连
        mRetrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build();
    }


    /**
     * 静态内部类单例模式
     *
     * @return
     */
    public static RetrofitManager getInstance() {
        return RetrofitManager.Inner.retrofitManager;
    }

    private static class Inner {
        private static final RetrofitManager retrofitManager = new RetrofitManager("");
    }


    /**
     * 利用泛型传入接口class返回接口实例
     *
     * @param ser 类
     * @param <T> 类的类型
     * @return Observable
     */
    public <T> T create(Class<T> ser) {
        return mRetrofit.create(ser);
    }





    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            synchronized (BaseRetrofit.class) {
                if (retrofit == null) {
                    //添加一个log拦截器,打印所有的log
                    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                    //可以设置请求过滤的水平,body,basic,headers
                    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

                    //设置 请求的缓存的大小跟位置
                    File cacheFile = new File(BaseApplication.getContext().getCacheDir(), "cache");
                    Cache cache = new Cache(cacheFile, 1024 * 1024 * 50); //50Mb 缓存的大小

                    client = new OkHttpClient
                            .Builder()
//                          .cookieJar(new CookieJarImpl(new PersistentCookieStore(App.getContext()))); //cookie 相关
                            .addInterceptor(httpLoggingInterceptor) //日志,所有的请求响应
//                            .addInterceptor(new HeaderInterceptor(getRequestHeader())) // token过滤
//                            .addInterceptor(new ParameterInterceptor(getRequestParams()))  //公共参数添加
                            .addInterceptor(new CaheInterceptor(BaseApplication.getContext()))
                            //不加以下两行代码,https请求不到自签名的服务器
                            .sslSocketFactory(createSSLSocketFactory())//创建一个证书对象
                            .hostnameVerifier(new TrustAllHostnameVerifier())//校验名称,这个对象就是信任所有的主机,也就是信任所有https的请求
                            .cache(cache)  //添加缓存

                            .connectTimeout(15, TimeUnit.SECONDS)//连接超时时间
                            .readTimeout(15, TimeUnit.SECONDS)//读取超时时间
                            .writeTimeout(15, TimeUnit.SECONDS)//写入超时时间
                            .retryOnConnectionFailure(false)//连接不上是否重连,false不重连

                            .build();

                    // 获取retrofit的实例
                    retrofit = new Retrofit
                            .Builder()
                            .baseUrl(AppConfig.BASE_URL)  //baseUrl配置
                            .client(client)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterBodyFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }

}
