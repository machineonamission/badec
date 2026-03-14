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

   protected FragmentPoliciesBinding(Object var1, View var2, int var3, TextView var4, Guideline var5, AppCompatImageView var6, ConstraintLayout var7, TextView var8, Guideline var9, View var10, ConstraintLayout var11) {
      super(var1, var2, var3);
      this.icpNo = var4;
      this.privacyLeftGuideline = var5;
      this.privacyPolicyArrow = var6;
      this.privacyPolicyClickview = var7;
      this.privacyPolicyTitle = var8;
      this.privacyRightGuideline = var9;
      this.privacySeparator = var10;
      this.rootLayout = var11;
   }

   public static FragmentPoliciesBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentPoliciesBinding bind(View var0, Object var1) {
      return (FragmentPoliciesBinding)bind(var1, var0, R.layout.fragment_policies);
   }

   public static FragmentPoliciesBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentPoliciesBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentPoliciesBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentPoliciesBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_policies, var1, var2, var3);
   }

   @Deprecated
   public static FragmentPoliciesBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentPoliciesBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_policies, (ViewGroup)null, false, var1);
   }

   public HomeViewModel getHomeViewModel() {
      return this.mHomeViewModel;
   }

   public abstract void setHomeViewModel(HomeViewModel var1);
}
