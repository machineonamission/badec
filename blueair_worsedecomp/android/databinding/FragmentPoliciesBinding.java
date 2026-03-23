package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.blueair.android.viewmodel.HomeViewModel;

public abstract class FragmentPoliciesBinding extends ViewDataBinding {
    public final TextView icpNo;
    @Bindable
    protected HomeViewModel mHomeViewModel;
    public final Guideline privacyLeftGuideline;
    public final AppCompatImageView privacyPolicyArrow;
    public final ConstraintLayout privacyPolicyClickview;
    public final TextView privacyPolicyTitle;
    public final Guideline privacyRightGuideline;
    public final View privacySeparator;
    public final ConstraintLayout rootLayout;

    public abstract void setHomeViewModel(HomeViewModel homeViewModel);

    protected FragmentPoliciesBinding(Object obj, View view, int i, TextView textView, Guideline guideline, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout, TextView textView2, Guideline guideline2, View view2, ConstraintLayout constraintLayout2) {
        super(obj, view, i);
        this.icpNo = textView;
        this.privacyLeftGuideline = guideline;
        this.privacyPolicyArrow = appCompatImageView;
        this.privacyPolicyClickview = constraintLayout;
        this.privacyPolicyTitle = textView2;
        this.privacyRightGuideline = guideline2;
        this.privacySeparator = view2;
        this.rootLayout = constraintLayout2;
    }

    public HomeViewModel getHomeViewModel() {
        return this.mHomeViewModel;
    }

    public static FragmentPoliciesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPoliciesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentPoliciesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_policies, viewGroup, z, obj);
    }

    public static FragmentPoliciesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPoliciesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentPoliciesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_policies, (ViewGroup) null, false, obj);
    }

    public static FragmentPoliciesBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPoliciesBinding bind(View view, Object obj) {
        return (FragmentPoliciesBinding) bind(obj, view, R.layout.fragment_policies);
    }
}
