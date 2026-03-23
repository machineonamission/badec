package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public abstract class DialogfragmentDeviceNFilterBinding extends ViewDataBinding {
    public final TextView availableFilters;
    public final MaterialButton btnAntiFake;
    public final MaterialButton btnPurchase;
    public final MaterialButton btnResetFilter;
    public final MaterialButton btnSubscribe;
    public final TextView buyNewFilter;
    public final ImageButton closeBtn;
    public final ConstraintLayout contentContainer;
    public final TextView discountHint;
    public final Guideline endGuideline;
    public final RecyclerView filterList;
    public final ImageView filterScrollLeft;
    public final ImageView filterScrollRight;
    public final AppCompatImageButton iconPlay;
    public final ProgressBlockerView progressView;
    public final Group replaceGroup;
    public final ScrollView scrollView;
    public final Guideline startGuideline;
    public final TextView title;
    public final TextView videoSummary;
    public final AppCompatImageView videoThumbnail;
    public final TextView whyIsThisImportant;

    protected DialogfragmentDeviceNFilterBinding(Object obj, View view, int i, TextView textView, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, MaterialButton materialButton4, TextView textView2, ImageButton imageButton, ConstraintLayout constraintLayout, TextView textView3, Guideline guideline, RecyclerView recyclerView, ImageView imageView, ImageView imageView2, AppCompatImageButton appCompatImageButton, ProgressBlockerView progressBlockerView, Group group, ScrollView scrollView2, Guideline guideline2, TextView textView4, TextView textView5, AppCompatImageView appCompatImageView, TextView textView6) {
        super(obj, view, i);
        this.availableFilters = textView;
        this.btnAntiFake = materialButton;
        this.btnPurchase = materialButton2;
        this.btnResetFilter = materialButton3;
        this.btnSubscribe = materialButton4;
        this.buyNewFilter = textView2;
        this.closeBtn = imageButton;
        this.contentContainer = constraintLayout;
        this.discountHint = textView3;
        this.endGuideline = guideline;
        this.filterList = recyclerView;
        this.filterScrollLeft = imageView;
        this.filterScrollRight = imageView2;
        this.iconPlay = appCompatImageButton;
        this.progressView = progressBlockerView;
        this.replaceGroup = group;
        this.scrollView = scrollView2;
        this.startGuideline = guideline2;
        this.title = textView4;
        this.videoSummary = textView5;
        this.videoThumbnail = appCompatImageView;
        this.whyIsThisImportant = textView6;
    }

    public static DialogfragmentDeviceNFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceNFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentDeviceNFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_n_filter, viewGroup, z, obj);
    }

    public static DialogfragmentDeviceNFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceNFilterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentDeviceNFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_n_filter, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentDeviceNFilterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceNFilterBinding bind(View view, Object obj) {
        return (DialogfragmentDeviceNFilterBinding) bind(obj, view, R.layout.dialogfragment_device_n_filter);
    }
}
