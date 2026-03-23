package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SeekProgressBar;

public final class HolderDeviceEtaBinding implements ViewBinding {
    public final TextView clearAirMinView;
    public final TextView clearAirMsgView;
    public final Guideline leftGuideline;
    public final SeekProgressBar progress;
    public final Guideline rightGuideline;
    private final ConstraintLayout rootView;

    private HolderDeviceEtaBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, Guideline guideline, SeekProgressBar seekProgressBar, Guideline guideline2) {
        this.rootView = constraintLayout;
        this.clearAirMinView = textView;
        this.clearAirMsgView = textView2;
        this.leftGuideline = guideline;
        this.progress = seekProgressBar;
        this.rightGuideline = guideline2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceEtaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceEtaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_eta, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceEtaBinding bind(View view) {
        int i = R.id.clear_air_min_view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.clear_air_msg_view;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.left_guideline;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline != null) {
                    i = R.id.progress;
                    SeekProgressBar seekProgressBar = (SeekProgressBar) ViewBindings.findChildViewById(view, i);
                    if (seekProgressBar != null) {
                        i = R.id.right_guideline;
                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline2 != null) {
                            return new HolderDeviceEtaBinding((ConstraintLayout) view, textView, textView2, guideline, seekProgressBar, guideline2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
