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

public final class FragmentSearchDeviceBinding implements ViewBinding {
    public final LinearLayout bottomBar;
    public final MaterialButton btnCustomerSupport;
    public final TextView btnDeviceNotFound;
    public final RecyclerView deviceList;
    public final TextView hintText;
    public final ProgressBlockerView progressView;
    private final ConstraintLayout rootView;

    private FragmentSearchDeviceBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, MaterialButton materialButton, TextView textView, RecyclerView recyclerView, TextView textView2, ProgressBlockerView progressBlockerView) {
        this.rootView = constraintLayout;
        this.bottomBar = linearLayout;
        this.btnCustomerSupport = materialButton;
        this.btnDeviceNotFound = textView;
        this.deviceList = recyclerView;
        this.hintText = textView2;
        this.progressView = progressBlockerView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSearchDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSearchDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_search_device, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentSearchDeviceBinding bind(View view) {
        int i = R.id.bottom_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.btn_customer_support;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.btn_device_not_found;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.device_list;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = R.id.hint_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.progress_view;
                            ProgressBlockerView progressBlockerView = (ProgressBlockerView) ViewBindings.findChildViewById(view, i);
                            if (progressBlockerView != null) {
                                return new FragmentSearchDeviceBinding((ConstraintLayout) view, linearLayout, materialButton, textView, recyclerView, textView2, progressBlockerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
