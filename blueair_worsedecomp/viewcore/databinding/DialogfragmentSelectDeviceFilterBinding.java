package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.viewcore.R;

public abstract class DialogfragmentSelectDeviceFilterBinding extends ViewDataBinding {
    public final ImageButton closeBtn;
    public final ConstraintLayout contentContainer;
    public final Guideline endGuideline;
    public final RecyclerView filterList;
    public final ImageView filterScrollLeft;
    public final ImageView filterScrollRight;
    public final Guideline startGuideline;
    public final TextView title;

    protected DialogfragmentSelectDeviceFilterBinding(Object obj, View view, int i, ImageButton imageButton, ConstraintLayout constraintLayout, Guideline guideline, RecyclerView recyclerView, ImageView imageView, ImageView imageView2, Guideline guideline2, TextView textView) {
        super(obj, view, i);
        this.closeBtn = imageButton;
        this.contentContainer = constraintLayout;
        this.endGuideline = guideline;
        this.filterList = recyclerView;
        this.filterScrollLeft = imageView;
        this.filterScrollRight = imageView2;
        this.startGuideline = guideline2;
        this.title = textView;
    }

    public static DialogfragmentSelectDeviceFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentSelectDeviceFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentSelectDeviceFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_select_device_filter, viewGroup, z, obj);
    }

    public static DialogfragmentSelectDeviceFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentSelectDeviceFilterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentSelectDeviceFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_select_device_filter, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentSelectDeviceFilterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentSelectDeviceFilterBinding bind(View view, Object obj) {
        return (DialogfragmentSelectDeviceFilterBinding) bind(obj, view, R.layout.dialogfragment_select_device_filter);
    }
}
