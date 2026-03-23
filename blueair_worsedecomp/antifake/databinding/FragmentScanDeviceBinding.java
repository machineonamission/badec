package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public final class FragmentScanDeviceBinding implements ViewBinding {
    public final MaterialButton btnCustomerSupport;
    public final RecyclerView deviceList;
    public final ProgressBlockerView progressView;
    private final ConstraintLayout rootView;
    public final TextView scanningMsg;
    public final TextView scanningSubtitle;
    public final ConstraintLayout scanningViewBottom;
    public final LinearLayout scanningViewCenter;

    private FragmentScanDeviceBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, RecyclerView recyclerView, ProgressBlockerView progressBlockerView, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, LinearLayout linearLayout) {
        this.rootView = constraintLayout;
        this.btnCustomerSupport = materialButton;
        this.deviceList = recyclerView;
        this.progressView = progressBlockerView;
        this.scanningMsg = textView;
        this.scanningSubtitle = textView2;
        this.scanningViewBottom = constraintLayout2;
        this.scanningViewCenter = linearLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentScanDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentScanDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_scan_device, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentScanDeviceBinding bind(View view) {
        int i = R.id.btn_customer_support;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.device_list;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = R.id.progressView;
                ProgressBlockerView progressBlockerView = (ProgressBlockerView) ViewBindings.findChildViewById(view, i);
                if (progressBlockerView != null) {
                    i = R.id.scanning_msg;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.scanning_subtitle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.scanning_view_bottom;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout != null) {
                                i = R.id.scanning_view_center;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    return new FragmentScanDeviceBinding((ConstraintLayout) view, materialButton, recyclerView, progressBlockerView, textView, textView2, constraintLayout, linearLayout);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
