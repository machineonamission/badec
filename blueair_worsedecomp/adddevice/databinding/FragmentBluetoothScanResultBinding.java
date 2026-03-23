package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.blueair.viewcore.view.ProgressBlockerView;

public final class FragmentBluetoothScanResultBinding implements ViewBinding {
    public final AppCompatTextView btnHelp;
    public final Group groupTitle;
    public final RecyclerView listview;
    public final ProgressBlockerView progressView;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final FrameLayout scanningFragment;
    public final AppCompatTextView tvTitle;

    private FragmentBluetoothScanResultBinding(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, Group group, RecyclerView recyclerView, ProgressBlockerView progressBlockerView, ConstraintLayout constraintLayout2, FrameLayout frameLayout, AppCompatTextView appCompatTextView2) {
        this.rootView = constraintLayout;
        this.btnHelp = appCompatTextView;
        this.groupTitle = group;
        this.listview = recyclerView;
        this.progressView = progressBlockerView;
        this.rootLayout = constraintLayout2;
        this.scanningFragment = frameLayout;
        this.tvTitle = appCompatTextView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBluetoothScanResultBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentBluetoothScanResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bluetooth_scan_result, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentBluetoothScanResultBinding bind(View view) {
        int i = R.id.btn_help;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
        if (appCompatTextView != null) {
            i = R.id.group_title;
            Group group = (Group) ViewBindings.findChildViewById(view, i);
            if (group != null) {
                i = R.id.listview;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                if (recyclerView != null) {
                    i = R.id.progressView;
                    ProgressBlockerView progressBlockerView = (ProgressBlockerView) ViewBindings.findChildViewById(view, i);
                    if (progressBlockerView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = R.id.scanning_fragment;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null) {
                            i = R.id.tv_title;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                            if (appCompatTextView2 != null) {
                                return new FragmentBluetoothScanResultBinding(constraintLayout, appCompatTextView, group, recyclerView, progressBlockerView, constraintLayout, frameLayout, appCompatTextView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
