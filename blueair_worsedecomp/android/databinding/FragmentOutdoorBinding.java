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

    public abstract void setOutdoorViewModel(OutdoorViewModel outdoorViewModel);

    protected FragmentOutdoorBinding(Object obj, View view, int i, TextView textView, SimpleScrollingPagerIndicator simpleScrollingPagerIndicator, RecyclerView recyclerView) {
        super(obj, view, i);
        this.outdoorTitle = textView;
        this.pageDots = simpleScrollingPagerIndicator;
        this.rvLocation = recyclerView;
    }

    public OutdoorViewModel getOutdoorViewModel() {
        return this.mOutdoorViewModel;
    }

    public static FragmentOutdoorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOutdoorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentOutdoorBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_outdoor, viewGroup, z, obj);
    }

    public static FragmentOutdoorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOutdoorBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentOutdoorBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_outdoor, (ViewGroup) null, false, obj);
    }

    public static FragmentOutdoorBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOutdoorBinding bind(View view, Object obj) {
        return (FragmentOutdoorBinding) bind(obj, view, R.layout.fragment_outdoor);
    }
}
