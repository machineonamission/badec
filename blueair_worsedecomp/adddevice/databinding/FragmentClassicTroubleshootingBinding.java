package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public abstract class FragmentClassicTroubleshootingBinding extends ViewDataBinding {
    public final MaterialButton btnNext;
    public final ImageView imgWifiBlinking;
    public final ImageView imgWifiFading;
    public final ImageView imgWifiFadingFast;
    public final ImageView imgWifiSolid;
    public final RadioButton radioBtnWifiBlinking;
    public final RadioButton radioBtnWifiFading;
    public final RadioButton radioBtnWifiFadingFast;
    public final RadioButton radioBtnWifiSolid;
    public final ScrollView scrollable;
    public final TextView txtError;
    public final TextView txtHint;
    public final TextView txtTitle;

    protected FragmentClassicTroubleshootingBinding(Object obj, View view, int i, MaterialButton materialButton, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.btnNext = materialButton;
        this.imgWifiBlinking = imageView;
        this.imgWifiFading = imageView2;
        this.imgWifiFadingFast = imageView3;
        this.imgWifiSolid = imageView4;
        this.radioBtnWifiBlinking = radioButton;
        this.radioBtnWifiFading = radioButton2;
        this.radioBtnWifiFadingFast = radioButton3;
        this.radioBtnWifiSolid = radioButton4;
        this.scrollable = scrollView;
        this.txtError = textView;
        this.txtHint = textView2;
        this.txtTitle = textView3;
    }

    public static FragmentClassicTroubleshootingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClassicTroubleshootingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentClassicTroubleshootingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_classic_troubleshooting, viewGroup, z, obj);
    }

    public static FragmentClassicTroubleshootingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClassicTroubleshootingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentClassicTroubleshootingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_classic_troubleshooting, (ViewGroup) null, false, obj);
    }

    public static FragmentClassicTroubleshootingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClassicTroubleshootingBinding bind(View view, Object obj) {
        return (FragmentClassicTroubleshootingBinding) bind(obj, view, R.layout.fragment_classic_troubleshooting);
    }
}
