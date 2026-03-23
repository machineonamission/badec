package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.ProgressBlockerView;

public abstract class FragmentWebviewBinding extends ViewDataBinding {
    public final ProgressBlockerView progressView;
    public final ConstraintLayout webContainer;
    public final WebView webView;

    protected FragmentWebviewBinding(Object obj, View view, int i, ProgressBlockerView progressBlockerView, ConstraintLayout constraintLayout, WebView webView2) {
        super(obj, view, i);
        this.progressView = progressBlockerView;
        this.webContainer = constraintLayout;
        this.webView = webView2;
    }

    public static FragmentWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentWebviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_webview, viewGroup, z, obj);
    }

    public static FragmentWebviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWebviewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentWebviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_webview, (ViewGroup) null, false, obj);
    }

    public static FragmentWebviewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWebviewBinding bind(View view, Object obj) {
        return (FragmentWebviewBinding) bind(obj, view, R.layout.fragment_webview);
    }
}
