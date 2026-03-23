package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.R;
import com.blueair.viewcore.databinding.StateLoadingFailedBinding;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SwitchCompat;

public abstract class DialogNotificationCenterBinding extends ViewDataBinding {
    public final ImageButton closeButton;
    public final ConstraintLayout contentContainer;
    public final LinearLayout groupTypeAll;
    public final LinearLayout groupTypeProductAlerts;
    public final LinearLayout groupTypeProductAlertsLimit;
    public final TextView permissionPromptBar;
    public final ProgressBlockerView progressView;
    public final RecyclerView rvSettings;
    public final TextView screenTitle;
    public final StateLoadingFailedBinding stateLoadingFailed;
    public final SwitchCompat switchTypeAll;
    public final SwitchCompat switchTypeProductAlerts;
    public final TextView tvTypeAll;
    public final TextView tvTypeProductAlerts;
    public final TextView tvTypeProductAlertsLimit;

    protected DialogNotificationCenterBinding(Object obj, View view, int i, ImageButton imageButton, ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, ProgressBlockerView progressBlockerView, RecyclerView recyclerView, TextView textView2, StateLoadingFailedBinding stateLoadingFailedBinding, SwitchCompat switchCompat, SwitchCompat switchCompat2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.closeButton = imageButton;
        this.contentContainer = constraintLayout;
        this.groupTypeAll = linearLayout;
        this.groupTypeProductAlerts = linearLayout2;
        this.groupTypeProductAlertsLimit = linearLayout3;
        this.permissionPromptBar = textView;
        this.progressView = progressBlockerView;
        this.rvSettings = recyclerView;
        this.screenTitle = textView2;
        this.stateLoadingFailed = stateLoadingFailedBinding;
        this.switchTypeAll = switchCompat;
        this.switchTypeProductAlerts = switchCompat2;
        this.tvTypeAll = textView3;
        this.tvTypeProductAlerts = textView4;
        this.tvTypeProductAlertsLimit = textView5;
    }

    public static DialogNotificationCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogNotificationCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogNotificationCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_notification_center, viewGroup, z, obj);
    }

    public static DialogNotificationCenterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogNotificationCenterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogNotificationCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_notification_center, (ViewGroup) null, false, obj);
    }

    public static DialogNotificationCenterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogNotificationCenterBinding bind(View view, Object obj) {
        return (DialogNotificationCenterBinding) bind(obj, view, R.layout.dialog_notification_center);
    }
}
