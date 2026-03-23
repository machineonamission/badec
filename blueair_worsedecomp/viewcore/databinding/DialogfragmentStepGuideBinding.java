package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;

public abstract class DialogfragmentStepGuideBinding extends ViewDataBinding {
    public final ImageButton btnBack;
    public final AppCompatImageButton btnClose;
    public final MaterialButton btnNext;
    public final AppCompatTextView txtStepDescription;
    public final AppCompatTextView txtStepTitle;

    protected DialogfragmentStepGuideBinding(Object obj, View view, int i, ImageButton imageButton, AppCompatImageButton appCompatImageButton, MaterialButton materialButton, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.btnBack = imageButton;
        this.btnClose = appCompatImageButton;
        this.btnNext = materialButton;
        this.txtStepDescription = appCompatTextView;
        this.txtStepTitle = appCompatTextView2;
    }

    public static DialogfragmentStepGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentStepGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentStepGuideBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_step_guide, viewGroup, z, obj);
    }

    public static DialogfragmentStepGuideBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentStepGuideBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentStepGuideBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_step_guide, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentStepGuideBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentStepGuideBinding bind(View view, Object obj) {
        return (DialogfragmentStepGuideBinding) bind(obj, view, R.layout.dialogfragment_step_guide);
    }
}
