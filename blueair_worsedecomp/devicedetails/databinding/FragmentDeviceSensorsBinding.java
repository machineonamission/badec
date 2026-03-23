package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel;
import com.blueair.graph.view.FanHistoryGraphView;
import com.blueair.graph.view.IndoorGraphView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

public abstract class FragmentDeviceSensorsBinding extends ViewDataBinding {
    public final MaterialButton buttonCollapse;
    public final IndoorGraphView deviceGraph;
    public final ConstraintLayout deviceGraphFooter;
    public final FanHistoryGraphView fanGraph;
    public final TextView fanValue;
    @Bindable
    protected DeviceSensorsViewModel mDeviceSensorViewModel;
    public final TabLayout sensorTabs;
    public final View separator;

    public abstract void setDeviceSensorViewModel(DeviceSensorsViewModel deviceSensorsViewModel);

    protected FragmentDeviceSensorsBinding(Object obj, View view, int i, MaterialButton materialButton, IndoorGraphView indoorGraphView, ConstraintLayout constraintLayout, FanHistoryGraphView fanHistoryGraphView, TextView textView, TabLayout tabLayout, View view2) {
        super(obj, view, i);
        this.buttonCollapse = materialButton;
        this.deviceGraph = indoorGraphView;
        this.deviceGraphFooter = constraintLayout;
        this.fanGraph = fanHistoryGraphView;
        this.fanValue = textView;
        this.sensorTabs = tabLayout;
        this.separator = view2;
    }

    public DeviceSensorsViewModel getDeviceSensorViewModel() {
        return this.mDeviceSensorViewModel;
    }

    public static FragmentDeviceSensorsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDeviceSensorsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentDeviceSensorsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_device_sensors, viewGroup, z, obj);
    }

    public static FragmentDeviceSensorsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDeviceSensorsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentDeviceSensorsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_device_sensors, (ViewGroup) null, false, obj);
    }

    public static FragmentDeviceSensorsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDeviceSensorsBinding bind(View view, Object obj) {
        return (FragmentDeviceSensorsBinding) bind(obj, view, R.layout.fragment_device_sensors);
    }
}
