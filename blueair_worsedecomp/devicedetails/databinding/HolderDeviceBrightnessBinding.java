package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;

public final class HolderDeviceBrightnessBinding implements ViewBinding {
    public final AccessibleSeekBar brightnessSeekbar;
    public final Guideline leftGuideline;
    public final Guideline rightGuideline;
    private final ConstraintLayout rootView;
    public final View separator;
    public final TextView settingTitle;
    public final TextView settingValue;

    private HolderDeviceBrightnessBinding(ConstraintLayout constraintLayout, AccessibleSeekBar accessibleSeekBar, Guideline guideline, Guideline guideline2, View view, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.brightnessSeekbar = accessibleSeekBar;
        this.leftGuideline = guideline;
        this.rightGuideline = guideline2;
        this.separator = view;
        this.settingTitle = textView;
        this.settingValue = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceBrightnessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceBrightnessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_brightness, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.blueair.devicedetails.R.id.separator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.HolderDeviceBrightnessBinding bind(android.view.View r10) {
        /*
            int r0 = com.blueair.devicedetails.R.id.brightness_seekbar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            com.blueair.viewcore.view.AccessibleSeekBar r4 = (com.blueair.viewcore.view.AccessibleSeekBar) r4
            if (r4 == 0) goto L_0x0048
            int r0 = com.blueair.devicedetails.R.id.left_guideline
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r5 = r1
            androidx.constraintlayout.widget.Guideline r5 = (androidx.constraintlayout.widget.Guideline) r5
            if (r5 == 0) goto L_0x0048
            int r0 = com.blueair.devicedetails.R.id.right_guideline
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r6 = r1
            androidx.constraintlayout.widget.Guideline r6 = (androidx.constraintlayout.widget.Guideline) r6
            if (r6 == 0) goto L_0x0048
            int r0 = com.blueair.devicedetails.R.id.separator
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            if (r7 == 0) goto L_0x0048
            int r0 = com.blueair.devicedetails.R.id.setting_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0048
            int r0 = com.blueair.devicedetails.R.id.setting_value
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0048
            com.blueair.devicedetails.databinding.HolderDeviceBrightnessBinding r2 = new com.blueair.devicedetails.databinding.HolderDeviceBrightnessBinding
            r3 = r10
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r2
        L_0x0048:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.HolderDeviceBrightnessBinding.bind(android.view.View):com.blueair.devicedetails.databinding.HolderDeviceBrightnessBinding");
    }
}
