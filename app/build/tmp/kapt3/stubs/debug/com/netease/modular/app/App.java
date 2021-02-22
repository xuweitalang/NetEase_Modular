package com.netease.modular.app;

import java.lang.System;

/**
 * @author chenxz
 * @date 2018/12/22
 * @desc
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/netease/modular/app/App;", "Landroid/app/Application;", "()V", "TAG", "", "mActivityLifecycleCallbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "refWatcher", "Lcom/squareup/leakcanary/RefWatcher;", "initLeakCanary", "", "initRouter", "onCreate", "Companion", "app_debug"})
public final class App extends android.app.Application {
    private final java.lang.String TAG = "App";
    private com.squareup.leakcanary.RefWatcher refWatcher;
    private final android.app.Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.netease.modular.app.App.Companion Companion = null;
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    private final void initLeakCanary() {
    }
    
    private final void initRouter() {
    }
    
    public App() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/netease/modular/app/App$Companion;", "", "()V", "getRefWatcher", "Lcom/squareup/leakcanary/RefWatcher;", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final com.squareup.leakcanary.RefWatcher getRefWatcher(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}