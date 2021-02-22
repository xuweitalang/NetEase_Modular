// Generated by view binder compiler. Do not edit!
package com.netease.modular.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.netease.modular.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnDemo;

  @NonNull
  public final Button btnLogin;

  @NonNull
  public final Button btnOrder;

  private FragmentHomeBinding(@NonNull LinearLayout rootView, @NonNull Button btnDemo,
      @NonNull Button btnLogin, @NonNull Button btnOrder) {
    this.rootView = rootView;
    this.btnDemo = btnDemo;
    this.btnLogin = btnLogin;
    this.btnOrder = btnOrder;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_demo;
      Button btnDemo = rootView.findViewById(id);
      if (btnDemo == null) {
        break missingId;
      }

      id = R.id.btn_login;
      Button btnLogin = rootView.findViewById(id);
      if (btnLogin == null) {
        break missingId;
      }

      id = R.id.btn_order;
      Button btnOrder = rootView.findViewById(id);
      if (btnOrder == null) {
        break missingId;
      }

      return new FragmentHomeBinding((LinearLayout) rootView, btnDemo, btnLogin, btnOrder);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
