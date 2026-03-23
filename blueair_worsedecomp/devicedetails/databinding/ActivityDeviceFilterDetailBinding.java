package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public abstract class ActivityDeviceFilterDetailBinding extends ViewDataBinding {
    public final TextView availableFilters;
    public final View bgFilterInfo;
    public final AppCompatImageButton btnBack;
    public final MaterialButton btnBuy;
    public final MaterialButton btnGetInstructions;
    public final MaterialButton btnResetFilter;
    public final MaterialButton btnVisit;
    public final AppCompatImageButton closeBtn;
    public final ConstraintLayout contentContainer;
    public final ShadowLayout cvFilterLife;
    public final ShadowLayout cvReplaceFilter;
    public final Guideline endGuideline;
    public final RecyclerView filterList;
    public final Group groupUserManual;
    public final ImageView iconPlay;
    public final ImageView ivInfo;
    public final ImageView leadingIcon;
    public final LinearProgressIndicator progressIndicator;
    public final ProgressBlockerView progressView;
    public final ScrollView scrollView;
    public final Guideline startGuideline;
    public final AppCompatTextView title;
    public final AppCompatTextView tvChangeFilter;
    public final AppCompatTextView tvFilterInfo;
    public final AppCompatTextView tvFilterLife;
    public final AppCompatTextView tvGuide;
    public final AppCompatTextView tvHowReplace;
    public final TextView tvProgress;
    public final AppCompatTextView tvSubtitle;
    public final ShapeableImageView videoThumbnail;

    protected ActivityDeviceFilterDetailBinding(Object obj, View view, int i, TextView textView, View view2, AppCompatImageButton appCompatImageButton, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, MaterialButton materialButton4, AppCompatImageButton appCompatImageButton2, ConstraintLayout constraintLayout, ShadowLayout shadowLayout, ShadowLayout shadowLayout2, Guideline guideline, RecyclerView recyclerView, Group group, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearProgressIndicator linearProgressIndicator, ProgressBlockerView progressBlockerView, ScrollView scrollView2, Guideline guideline2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, TextView textView2, AppCompatTextView appCompatTextView7, ShapeableImageView shapeableImageView) {
        super(obj, view, i);
        this.availableFilters = textView;
        this.bgFilterInfo = view2;
        this.btnBack = appCompatImageButton;
        this.btnBuy = materialButton;
        this.btnGetInstructions = materialButton2;
        this.btnResetFilter = materialButton3;
        this.btnVisit = materialButton4;
        this.closeBtn = appCompatImageButton2;
        this.contentContainer = constraintLayout;
        this.cvFilterLife = shadowLayout;
        this.cvReplaceFilter = shadowLayout2;
        this.endGuideline = guideline;
        this.filterList = recyclerView;
        this.groupUserManual = group;
        this.iconPlay = imageView;
        this.ivInfo = imageView2;
        this.leadingIcon = imageView3;
        this.progressIndicator = linearProgressIndicator;
        this.progressView = progressBlockerView;
        this.scrollView = scrollView2;
        this.startGuideline = guideline2;
        this.title = appCompatTextView;
        this.tvChangeFilter = appCompatTextView2;
        this.tvFilterInfo = appCompatTextView3;
        this.tvFilterLife = appCompatTextView4;
        this.tvGuide = appCompatTextView5;
        this.tvHowReplace = appCompatTextView6;
        this.tvProgress = textView2;
        this.tvSubtitle = appCompatTextView7;
        this.videoThumbnail = shapeableImageView;
    }

    public static ActivityDeviceFilterDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDeviceFilterDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityDeviceFilterDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_device_filter_detail, viewGroup, z, obj);
    }

    public static ActivityDeviceFilterDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDeviceFilterDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityDeviceFilterDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_device_filter_detail, (ViewGroup) null, false, obj);
    }

    public static ActivityDeviceFilterDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDeviceFilterDetailBinding bind(View view, Object obj) {
        return (ActivityDeviceFilterDetailBinding) bind(obj, view, R.layout.activity_device_filter_detail);
    }
}
