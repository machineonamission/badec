package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.CreateUpdateWelcomeHomeViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SimpleStatusBar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public abstract class ActivityWelcomeHomeConfigBinding extends ViewDataBinding {
    public final AppCompatImageButton btnBack;
    public final AppCompatImageButton btnClose;
    public final MaterialButton btnDeleteHome;
    public final MaterialButton btnSave;
    public final ConstraintLayout clHome;
    public final MaterialCardView cvHome;
    public final AppCompatImageButton gpsBtn;
    public final Group groupLocationInfo;
    public final AppCompatImageView imInfo;
    public final AppCompatImageView ivWelcomeHome;
    public final LinearLayout llTransport;
    @Bindable
    protected CreateUpdateWelcomeHomeViewModel mVm;
    public final FrameLayout mapContainer;
    public final ProgressBlockerView progressView;
    public final ConstraintLayout rootLayout;
    public final SimpleStatusBar statusBar;
    public final AppCompatTextView tvAddress;
    public final AppCompatTextView tvArriveDesp;
    public final AppCompatCheckBox tvBicycle;
    public final AppCompatCheckBox tvCar;
    public final AppCompatTextView tvCity;
    public final AppCompatCheckBox tvCommute;
    public final AppCompatTextView tvHowArrive;
    public final AppCompatTextView tvName;
    public final AppCompatTextView tvSearchOnMap;
    public final AppCompatCheckBox tvWalk;
    public final TextView tvWelcomeHome;

    public abstract void setVm(CreateUpdateWelcomeHomeViewModel createUpdateWelcomeHomeViewModel);

    protected ActivityWelcomeHomeConfigBinding(Object obj, View view, int i, AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2, MaterialButton materialButton, MaterialButton materialButton2, ConstraintLayout constraintLayout, MaterialCardView materialCardView, AppCompatImageButton appCompatImageButton3, Group group, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, FrameLayout frameLayout, ProgressBlockerView progressBlockerView, ConstraintLayout constraintLayout2, SimpleStatusBar simpleStatusBar, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatCheckBox appCompatCheckBox, AppCompatCheckBox appCompatCheckBox2, AppCompatTextView appCompatTextView3, AppCompatCheckBox appCompatCheckBox3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatCheckBox appCompatCheckBox4, TextView textView) {
        super(obj, view, i);
        this.btnBack = appCompatImageButton;
        this.btnClose = appCompatImageButton2;
        this.btnDeleteHome = materialButton;
        this.btnSave = materialButton2;
        this.clHome = constraintLayout;
        this.cvHome = materialCardView;
        this.gpsBtn = appCompatImageButton3;
        this.groupLocationInfo = group;
        this.imInfo = appCompatImageView;
        this.ivWelcomeHome = appCompatImageView2;
        this.llTransport = linearLayout;
        this.mapContainer = frameLayout;
        this.progressView = progressBlockerView;
        this.rootLayout = constraintLayout2;
        this.statusBar = simpleStatusBar;
        this.tvAddress = appCompatTextView;
        this.tvArriveDesp = appCompatTextView2;
        this.tvBicycle = appCompatCheckBox;
        this.tvCar = appCompatCheckBox2;
        this.tvCity = appCompatTextView3;
        this.tvCommute = appCompatCheckBox3;
        this.tvHowArrive = appCompatTextView4;
        this.tvName = appCompatTextView5;
        this.tvSearchOnMap = appCompatTextView6;
        this.tvWalk = appCompatCheckBox4;
        this.tvWelcomeHome = textView;
    }

    public CreateUpdateWelcomeHomeViewModel getVm() {
        return this.mVm;
    }

    public static ActivityWelcomeHomeConfigBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWelcomeHomeConfigBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityWelcomeHomeConfigBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_welcome_home_config, viewGroup, z, obj);
    }

    public static ActivityWelcomeHomeConfigBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWelcomeHomeConfigBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityWelcomeHomeConfigBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_welcome_home_config, (ViewGroup) null, false, obj);
    }

    public static ActivityWelcomeHomeConfigBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWelcomeHomeConfigBinding bind(View view, Object obj) {
        return (ActivityWelcomeHomeConfigBinding) bind(obj, view, R.layout.activity_welcome_home_config);
    }
}
