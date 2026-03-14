package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.R;
import com.blueair.android.util.SimpleScrollingPagerIndicator;
import com.blueair.android.viewmodel.OutdoorViewModel;

public abstract class FragmentOutdoorBinding extends ViewDataBinding {
   @Bindable
   protected OutdoorViewModel mOutdoorViewModel;
   public final TextView outdoorTitle;
   public final SimpleScrollingPagerIndicator pageDots;
   public final RecyclerView rvLocation;

   protected FragmentOutdoorBinding(Object var1, View var2, int var3, TextView var4, SimpleScrollingPagerIndicator var5, RecyclerView var6) {
      super(var1, var2, var3);
      this.outdoorTitle = var4;
      this.pageDots = var5;
      this.rvLocation = var6;
   }

   public static FragmentOutdoorBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentOutdoorBinding bind(View var0, Object var1) {
      return (FragmentOutdoorBinding)bind(var1, var0, R.layout.fragment_outdoor);
   }

   public static FragmentOutdoorBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentOutdoorBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentOutdoorBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentOutdoorBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_outdoor, var1, var2, var3);
   }

   @Deprecated
   public static FragmentOutdoorBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentOutdoorBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_outdoor, (ViewGroup)null, false, var1);
   }

   public OutdoorViewModel getOutdoorViewModel() {
      return this.mOutdoorViewModel;
   }

   public abstract void setOutdoorViewModel(OutdoorViewModel var1);
}
