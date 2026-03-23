package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class HolderDeviceOfflineBinding implements ViewBinding {
    public final Guideline bottomGuideline;
    public final Guideline endGuideline;
    public final AppCompatImageView offlineImageview;
    private final ConstraintLayout rootView;
    public final View separator;
    public final Guideline startGuideline;
    public final TextView subtitle;
    public final TextView title;
    public final MaterialButton troubleshootBtn;

    private HolderDeviceOfflineBinding(ConstraintLayout constraintLayout, Guideline guideline, Guideline guideline2, AppCompatImageView appCompatImageView, View view, Guideline guideline3, TextView textView, TextView textView2, MaterialButton materialButton) {
        this.rootView = constraintLayout;
        this.bottomGuideline = guideline;
        this.endGuideline = guideline2;
        this.offlineImageview = appCompatImageView;
        this.separator = view;
        this.startGuideline = guideline3;
        this.subtitle = textView;
        this.title = textView2;
        this.troubleshootBtn = materialButton;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceOfflineBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceOfflineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_offline, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.blueair.devicedetails.R.id.separator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.HolderDeviceOfflineBinding bind(android.view.View r12) {
        /*
            int r0 = com.blueair.devicedetails.R.id.bottom_guideline
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            androidx.constraintlayout.widget.Guideline r4 = (androidx.constraintlayout.widget.Guideline) r4
            if (r4 == 0) goto L_0x005e
            int r0 = com.blueair.devicedetails.R.id.end_guideline
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r5 = r1
            androidx.constraintlayout.widget.Guideline r5 = (androidx.constraintlayout.widget.Guideline) r5
            if (r5 == 0) goto L_0x005e
            int r0 = com.blueair.devicedetails.R.id.offline_imageview
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r6 = r1
            androidx.appcompat.widget.AppCompatImageView r6 = (androidx.appcompat.widget.AppCompatImageView) r6
            if (r6 == 0) goto L_0x005e
            int r0 = com.blueair.devicedetails.R.id.separator
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r7 == 0) goto L_0x005e
            int r0 = com.blueair.devicedetails.R.id.start_guideline
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r8 = r1
            androidx.constraintlayout.widget.Guideline r8 = (androidx.constraintlayout.widget.Guideline) r8
            if (r8 == 0) goto L_0x005e
            int r0 = com.blueair.devicedetails.R.id.subtitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x005e
            int r0 = com.blueair.devicedetails.R.id.title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x005e
            int r0 = com.blueair.devicedetails.R.id.troubleshoot_btn
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            com.google.android.material.button.MaterialButton r11 = (com.google.android.material.button.MaterialButton) r11
            if (r11 == 0) goto L_0x005e
            com.blueair.devicedetails.databinding.HolderDeviceOfflineBinding r2 = new com.blueair.devicedetails.databinding.HolderDeviceOfflineBinding
            r3 = r12
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r2
        L_0x005e:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.HolderDeviceOfflineBinding.bind(android.view.View):com.blueair.devicedetails.databinding.HolderDeviceOfflineBinding");
    }
}
