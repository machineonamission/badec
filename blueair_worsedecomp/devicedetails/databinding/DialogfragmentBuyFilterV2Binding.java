package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public abstract class DialogfragmentBuyFilterV2Binding extends ViewDataBinding {
    public final MaterialButton btnPurchase;
    public final MaterialButton btnSubscribe;
    public final AppCompatImageButton closeBtn;
    public final ConstraintLayout contentContainer;
    public final TextView discountHint;
    public final Guideline endGuideline;
    public final RecyclerView filterList;
    public final ProgressBlockerView progressView;
    public final Guideline startGuideline;
    public final AppCompatTextView title;
    public final View vTop;

    protected DialogfragmentBuyFilterV2Binding(Object obj, View view, int i, MaterialButton materialButton, MaterialButton materialButton2, AppCompatImageButton appCompatImageButton, ConstraintLayout constraintLayout, TextView textView, Guideline guideline, RecyclerView recyclerView, ProgressBlockerView progressBlockerView, Guideline guideline2, AppCompatTextView appCompatTextView, View view2) {
        super(obj, view, i);
        this.btnPurchase = materialButton;
        this.btnSubscribe = materialButton2;
        this.closeBtn = appCompatImageButton;
        this.contentContainer = constraintLayout;
        this.discountHint = textView;
        this.endGuideline = guideline;
        this.filterList = recyclerView;
        this.progressView = progressBlockerView;
        this.startGuideline = guideline2;
        this.title = appCompatTextView;
        this.vTop = view2;
    }

    public static DialogfragmentBuyFilterV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentBuyFilterV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentBuyFilterV2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_buy_filter_v2, viewGroup, z, obj);
    }

    public static DialogfragmentBuyFilterV2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentBuyFilterV2Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentBuyFilterV2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_buy_filter_v2, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentBuyFilterV2Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentBuyFilterV2Binding bind(View view, Object obj) {
        return (DialogfragmentBuyFilterV2Binding) bind(obj, view, R.layout.dialogfragment_buy_filter_v2);
    }
}
