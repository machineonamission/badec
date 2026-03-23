package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public abstract class ActivityGoogleAppFlipBinding extends ViewDataBinding {
    public final MaterialButton btnAgree;
    public final MaterialButton btnCancel;
    public final ScrollView dataUsageContent;
    public final AppCompatImageView imgLogo;
    public final ProgressBlockerView loading;
    public final TextView reviewPolicy;
    public final TextView signedInAs;
    public final TextView title;
    public final TextView unlinkHint;

    protected ActivityGoogleAppFlipBinding(Object obj, View view, int i, MaterialButton materialButton, MaterialButton materialButton2, ScrollView scrollView, AppCompatImageView appCompatImageView, ProgressBlockerView progressBlockerView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.btnAgree = materialButton;
        this.btnCancel = materialButton2;
        this.dataUsageContent = scrollView;
        this.imgLogo = appCompatImageView;
        this.loading = progressBlockerView;
        this.reviewPolicy = textView;
        this.signedInAs = textView2;
        this.title = textView3;
        this.unlinkHint = textView4;
    }

    public static ActivityGoogleAppFlipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityGoogleAppFlipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityGoogleAppFlipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_google_app_flip, viewGroup, z, obj);
    }

    public static ActivityGoogleAppFlipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityGoogleAppFlipBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityGoogleAppFlipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_google_app_flip, (ViewGroup) null, false, obj);
    }

    public static ActivityGoogleAppFlipBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityGoogleAppFlipBinding bind(View view, Object obj) {
        return (ActivityGoogleAppFlipBinding) bind(obj, view, R.layout.activity_google_app_flip);
    }
}
