package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public abstract class DialogfragmentDeviceNSetScheduleModeBinding extends ViewDataBinding {
    public final ImageButton backBtn;
    public final LinearLayout contentContainer;
    public final RecyclerView modeControls;
    public final MaterialButton saveBtn;
    public final TextView title;
    public final FrameLayout titleBar;

    protected DialogfragmentDeviceNSetScheduleModeBinding(Object obj, View view, int i, ImageButton imageButton, LinearLayout linearLayout, RecyclerView recyclerView, MaterialButton materialButton, TextView textView, FrameLayout frameLayout) {
        super(obj, view, i);
        this.backBtn = imageButton;
        this.contentContainer = linearLayout;
        this.modeControls = recyclerView;
        this.saveBtn = materialButton;
        this.title = textView;
        this.titleBar = frameLayout;
    }

    public static DialogfragmentDeviceNSetScheduleModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceNSetScheduleModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentDeviceNSetScheduleModeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_n_set_schedule_mode, viewGroup, z, obj);
    }

    public static DialogfragmentDeviceNSetScheduleModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceNSetScheduleModeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentDeviceNSetScheduleModeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_n_set_schedule_mode, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentDeviceNSetScheduleModeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceNSetScheduleModeBinding bind(View view, Object obj) {
        return (DialogfragmentDeviceNSetScheduleModeBinding) bind(obj, view, R.layout.dialogfragment_device_n_set_schedule_mode);
    }
}
