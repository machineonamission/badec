package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;

public abstract class DialogfragmentDeviceSetTimezoneBinding extends ViewDataBinding {
    public final Button closeButton;
    public final ConstraintLayout contentContainer;
    public final TextView currentTimezoneLabel;
    public final TextView localTimezoneLabel;
    public final TextView noResultsView;
    public final ProgressBlockerView progressView;
    public final Button saveButton;
    public final TextView screenTitle;
    public final EditText searchBar;
    public final ImageButton searchClearBtn;
    public final View separator1;
    public final View separator2;
    public final RecyclerView timezoneList;

    protected DialogfragmentDeviceSetTimezoneBinding(Object obj, View view, int i, Button button, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, ProgressBlockerView progressBlockerView, Button button2, TextView textView4, EditText editText, ImageButton imageButton, View view2, View view3, RecyclerView recyclerView) {
        super(obj, view, i);
        this.closeButton = button;
        this.contentContainer = constraintLayout;
        this.currentTimezoneLabel = textView;
        this.localTimezoneLabel = textView2;
        this.noResultsView = textView3;
        this.progressView = progressBlockerView;
        this.saveButton = button2;
        this.screenTitle = textView4;
        this.searchBar = editText;
        this.searchClearBtn = imageButton;
        this.separator1 = view2;
        this.separator2 = view3;
        this.timezoneList = recyclerView;
    }

    public static DialogfragmentDeviceSetTimezoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceSetTimezoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentDeviceSetTimezoneBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_set_timezone, viewGroup, z, obj);
    }

    public static DialogfragmentDeviceSetTimezoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceSetTimezoneBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentDeviceSetTimezoneBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_set_timezone, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentDeviceSetTimezoneBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceSetTimezoneBinding bind(View view, Object obj) {
        return (DialogfragmentDeviceSetTimezoneBinding) bind(obj, view, R.layout.dialogfragment_device_set_timezone);
    }
}
