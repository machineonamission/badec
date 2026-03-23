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

public final class HolderDeviceStandbyModeBinding implements ViewBinding {
    public final Guideline bottomGuideline;
    public final AppCompatImageView germshieldIcon;
    public final Guideline leftGuideline;
    public final Guideline rightGuideline;
    private final ConstraintLayout rootView;
    public final View separator;
    public final TextView standbyMessageView;

    private HolderDeviceStandbyModeBinding(ConstraintLayout constraintLayout, Guideline guideline, AppCompatImageView appCompatImageView, Guideline guideline2, Guideline guideline3, View view, TextView textView) {
        this.rootView = constraintLayout;
        this.bottomGuideline = guideline;
        this.germshieldIcon = appCompatImageView;
        this.leftGuideline = guideline2;
        this.rightGuideline = guideline3;
        this.separator = view;
        this.standbyMessageView = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceStandbyModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceStandbyModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_standby_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.blueair.devicedetails.R.id.separator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.HolderDeviceStandbyModeBinding bind(android.view.View r10) {
        /*
            int r0 = com.blueair.devicedetails.R.id.bottom_guideline
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            androidx.constraintlayout.widget.Guideline r4 = (androidx.constraintlayout.widget.Guideline) r4
            if (r4 == 0) goto L_0x0048
            int r0 = com.blueair.devicedetails.R.id.germshield_icon
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r5 = r1
            androidx.appcompat.widget.AppCompatImageView r5 = (androidx.appcompat.widget.AppCompatImageView) r5
            if (r5 == 0) goto L_0x0048
            int r0 = com.blueair.devicedetails.R.id.left_guideline
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r6 = r1
            androidx.constraintlayout.widget.Guideline r6 = (androidx.constraintlayout.widget.Guideline) r6
            if (r6 == 0) goto L_0x0048
            int r0 = com.blueair.devicedetails.R.id.right_guideline
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r7 = r1
            androidx.constraintlayout.widget.Guideline r7 = (androidx.constraintlayout.widget.Guideline) r7
            if (r7 == 0) goto L_0x0048
            int r0 = com.blueair.devicedetails.R.id.separator
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            if (r8 == 0) goto L_0x0048
            int r0 = com.blueair.devicedetails.R.id.standby_message_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0048
            com.blueair.devicedetails.databinding.HolderDeviceStandbyModeBinding r2 = new com.blueair.devicedetails.databinding.HolderDeviceStandbyModeBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.HolderDeviceStandbyModeBinding.bind(android.view.View):com.blueair.devicedetails.databinding.HolderDeviceStandbyModeBinding");
    }
}
