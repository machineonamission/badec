package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;

public abstract class ActivityDeviceReplaceFilterBinding extends ViewDataBinding {
    public final AppCompatImageButton btnBack;
    public final MaterialButton btnResetFilter;
    public final AppCompatImageButton closeBtn;
    public final ConstraintLayout contentContainer;
    public final Guideline endGuideline;
    public final Group groupUserManual;
    public final AppCompatImageButton iconPlay;
    public final AppCompatImageView ivUserManual;
    public final ProgressBlockerView progressView;
    public final ScrollView scrollView;
    public final ShadowLayout slReplaceFilter;
    public final ShadowLayout slUserManual;
    public final Guideline startGuideline;
    public final AppCompatTextView title;
    public final AppCompatTextView tvManualInfo;
    public final TextView tvReadManual;
    public final AppCompatTextView tvSubtitle;
    public final AppCompatTextView tvUserManual;
    public final TextView tvWatchVideo;
    public final TextView videoSummary;
    public final ShapeableImageView videoThumbnail;
    public final TextView whyIsThisImportant;

    protected ActivityDeviceReplaceFilterBinding(Object obj, View view, int i, AppCompatImageButton appCompatImageButton, MaterialButton materialButton, AppCompatImageButton appCompatImageButton2, ConstraintLayout constraintLayout, Guideline guideline, Group group, AppCompatImageButton appCompatImageButton3, AppCompatImageView appCompatImageView, ProgressBlockerView progressBlockerView, ScrollView scrollView2, ShadowLayout shadowLayout, ShadowLayout shadowLayout2, Guideline guideline2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, TextView textView2, TextView textView3, ShapeableImageView shapeableImageView, TextView textView4) {
        super(obj, view, i);
        this.btnBack = appCompatImageButton;
        this.btnResetFilter = materialButton;
        this.closeBtn = appCompatImageButton2;
        this.contentContainer = constraintLayout;
        this.endGuideline = guideline;
        this.groupUserManual = group;
        this.iconPlay = appCompatImageButton3;
        this.ivUserManual = appCompatImageView;
        this.progressView = progressBlockerView;
        this.scrollView = scrollView2;
        this.slReplaceFilter = shadowLayout;
        this.slUserManual = shadowLayout2;
        this.startGuideline = guideline2;
        this.title = appCompatTextView;
        this.tvManualInfo = appCompatTextView2;
        this.tvReadManual = textView;
        this.tvSubtitle = appCompatTextView3;
        this.tvUserManual = appCompatTextView4;
        this.tvWatchVideo = textView2;
        this.videoSummary = textView3;
        this.videoThumbnail = shapeableImageView;
        this.whyIsThisImportant = textView4;
    }

    public static ActivityDeviceReplaceFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDeviceReplaceFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityDeviceReplaceFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_device_replace_filter, viewGroup, z, obj);
    }

    public static ActivityDeviceReplaceFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDeviceReplaceFilterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityDeviceReplaceFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_device_replace_filter, (ViewGroup) null, false, obj);
    }

    public static ActivityDeviceReplaceFilterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDeviceReplaceFilterBinding bind(View view, Object obj) {
        return (ActivityDeviceReplaceFilterBinding) bind(obj, view, R.layout.activity_device_replace_filter);
    }
}
