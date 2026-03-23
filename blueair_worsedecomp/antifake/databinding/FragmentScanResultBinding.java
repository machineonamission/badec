package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.blueair.antifake.R;
import com.blueair.viewcore.databinding.StateLoadingFailedBinding;
import com.google.android.material.button.MaterialButton;

public final class FragmentScanResultBinding implements ViewBinding {
    public final Guideline bottomGuideline;
    public final MaterialButton btnCustomerSupport;
    public final TextView btnManualReset;
    public final MaterialButton btnResetFilter;
    public final View divider1;
    public final View divider2;
    public final Guideline endGuideline;
    public final Group groupCode;
    public final AppCompatImageView imageCodeStatus;
    public final TextView infoCodeStatus;
    private final ConstraintLayout rootView;
    public final TextView securityCode;
    public final Guideline startGuideline;
    public final StateLoadingFailedBinding stateLoadingFailed;
    public final TextView titleCodeStatus;
    public final TextView titleSecurityCode;
    public final Guideline topGuideline;

    private FragmentScanResultBinding(ConstraintLayout constraintLayout, Guideline guideline, MaterialButton materialButton, TextView textView, MaterialButton materialButton2, View view, View view2, Guideline guideline2, Group group, AppCompatImageView appCompatImageView, TextView textView2, TextView textView3, Guideline guideline3, StateLoadingFailedBinding stateLoadingFailedBinding, TextView textView4, TextView textView5, Guideline guideline4) {
        this.rootView = constraintLayout;
        this.bottomGuideline = guideline;
        this.btnCustomerSupport = materialButton;
        this.btnManualReset = textView;
        this.btnResetFilter = materialButton2;
        this.divider1 = view;
        this.divider2 = view2;
        this.endGuideline = guideline2;
        this.groupCode = group;
        this.imageCodeStatus = appCompatImageView;
        this.infoCodeStatus = textView2;
        this.securityCode = textView3;
        this.startGuideline = guideline3;
        this.stateLoadingFailed = stateLoadingFailedBinding;
        this.titleCodeStatus = textView4;
        this.titleSecurityCode = textView5;
        this.topGuideline = guideline4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentScanResultBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentScanResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_scan_result, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
        r1 = com.blueair.antifake.R.id.divider2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0081, code lost:
        r1 = com.blueair.antifake.R.id.state_loading_failed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r1 = com.blueair.antifake.R.id.divider1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.antifake.databinding.FragmentScanResultBinding bind(android.view.View r21) {
        /*
            r0 = r21
            int r1 = com.blueair.antifake.R.id.bottom_guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.Guideline r5 = (androidx.constraintlayout.widget.Guideline) r5
            if (r5 == 0) goto L_0x00ba
            int r1 = com.blueair.antifake.R.id.btn_customer_support
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.google.android.material.button.MaterialButton r6 = (com.google.android.material.button.MaterialButton) r6
            if (r6 == 0) goto L_0x00ba
            int r1 = com.blueair.antifake.R.id.btn_manual_reset
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x00ba
            int r1 = com.blueair.antifake.R.id.btn_reset_filter
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            com.google.android.material.button.MaterialButton r8 = (com.google.android.material.button.MaterialButton) r8
            if (r8 == 0) goto L_0x00ba
            int r1 = com.blueair.antifake.R.id.divider1
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r9 == 0) goto L_0x00ba
            int r1 = com.blueair.antifake.R.id.divider2
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r10 == 0) goto L_0x00ba
            int r1 = com.blueair.antifake.R.id.end_guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.constraintlayout.widget.Guideline r11 = (androidx.constraintlayout.widget.Guideline) r11
            if (r11 == 0) goto L_0x00ba
            int r1 = com.blueair.antifake.R.id.group_code
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.constraintlayout.widget.Group r12 = (androidx.constraintlayout.widget.Group) r12
            if (r12 == 0) goto L_0x00ba
            int r1 = com.blueair.antifake.R.id.image_code_status
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.appcompat.widget.AppCompatImageView r13 = (androidx.appcompat.widget.AppCompatImageView) r13
            if (r13 == 0) goto L_0x00ba
            int r1 = com.blueair.antifake.R.id.info_code_status
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00ba
            int r1 = com.blueair.antifake.R.id.security_code
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00ba
            int r1 = com.blueair.antifake.R.id.start_guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.constraintlayout.widget.Guideline r16 = (androidx.constraintlayout.widget.Guideline) r16
            if (r16 == 0) goto L_0x00ba
            int r1 = com.blueair.antifake.R.id.state_loading_failed
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x00ba
            com.blueair.viewcore.databinding.StateLoadingFailedBinding r17 = com.blueair.viewcore.databinding.StateLoadingFailedBinding.bind(r2)
            int r1 = com.blueair.antifake.R.id.title_code_status
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00ba
            int r1 = com.blueair.antifake.R.id.title_security_code
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00ba
            int r1 = com.blueair.antifake.R.id.top_guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            androidx.constraintlayout.widget.Guideline r20 = (androidx.constraintlayout.widget.Guideline) r20
            if (r20 == 0) goto L_0x00ba
            com.blueair.antifake.databinding.FragmentScanResultBinding r3 = new com.blueair.antifake.databinding.FragmentScanResultBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r3
        L_0x00ba:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.antifake.databinding.FragmentScanResultBinding.bind(android.view.View):com.blueair.antifake.databinding.FragmentScanResultBinding");
    }
}
