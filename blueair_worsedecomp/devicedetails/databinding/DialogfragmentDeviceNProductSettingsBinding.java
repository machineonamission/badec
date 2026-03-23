package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;

public abstract class DialogfragmentDeviceNProductSettingsBinding extends ViewDataBinding {
    public final ImageButton closeBtn;
    public final ConstraintLayout contentContainer;
    public final Button doneBtn;
    public final View separator;
    public final RecyclerView settingsList;
    public final TextView title;

    protected DialogfragmentDeviceNProductSettingsBinding(Object obj, View view, int i, ImageButton imageButton, ConstraintLayout constraintLayout, Button button, View view2, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.closeBtn = imageButton;
        this.contentContainer = constraintLayout;
        this.doneBtn = button;
        this.separator = view2;
        this.settingsList = recyclerView;
        this.title = textView;
    }

    public static DialogfragmentDeviceNProductSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceNProductSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentDeviceNProductSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_n_product_settings, viewGroup, z, obj);
    }

    public static DialogfragmentDeviceNProductSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceNProductSettingsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentDeviceNProductSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_n_product_settings, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentDeviceNProductSettingsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceNProductSettingsBinding bind(View view, Object obj) {
        return (DialogfragmentDeviceNProductSettingsBinding) bind(obj, view, R.layout.dialogfragment_device_n_product_settings);
    }
}
