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
import com.blueair.viewcore.view.AccessibleSeekBar;

public final class HolderIcpManualModeBinding implements ViewBinding {
    public final TextView clearAirMinView;
    public final TextView clearAirMsgView;
    public final AppCompatImageView decreaseFanSpeedBg;
    public final AppCompatImageView decreaseImageview;
    public final AccessibleSeekBar fanSpeedSeekbar;
    public final TextView fanspeed1;
    public final TextView fanspeed2;
    public final TextView fanspeed3;
    public final AppCompatImageView germshieldIcon;
    public final ConstraintLayout germshieldRoot;
    public final TextView germshieldTitle;
    public final AppCompatImageView increaseFanSpeedBg;
    public final AppCompatImageView increaseImageview;
    public final Guideline leftGuideline;
    public final TextView modeTitle;
    public final Guideline rightGuideline;
    private final ConstraintLayout rootView;
    public final Guideline seekbarGuideline1;
    public final Guideline seekbarGuideline2;
    public final Guideline seekbarGuideline3;
    public final View separator;
    public final AppCompatImageView standbyBackground;
    public final AppCompatImageView standbyImageview;
    public final TextView standbyMessageView;
    public final TextView standbyTitleView;

    private HolderIcpManualModeBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AccessibleSeekBar accessibleSeekBar, TextView textView3, TextView textView4, TextView textView5, AppCompatImageView appCompatImageView3, ConstraintLayout constraintLayout2, TextView textView6, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, Guideline guideline, TextView textView7, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, View view, AppCompatImageView appCompatImageView6, AppCompatImageView appCompatImageView7, TextView textView8, TextView textView9) {
        this.rootView = constraintLayout;
        this.clearAirMinView = textView;
        this.clearAirMsgView = textView2;
        this.decreaseFanSpeedBg = appCompatImageView;
        this.decreaseImageview = appCompatImageView2;
        this.fanSpeedSeekbar = accessibleSeekBar;
        this.fanspeed1 = textView3;
        this.fanspeed2 = textView4;
        this.fanspeed3 = textView5;
        this.germshieldIcon = appCompatImageView3;
        this.germshieldRoot = constraintLayout2;
        this.germshieldTitle = textView6;
        this.increaseFanSpeedBg = appCompatImageView4;
        this.increaseImageview = appCompatImageView5;
        this.leftGuideline = guideline;
        this.modeTitle = textView7;
        this.rightGuideline = guideline2;
        this.seekbarGuideline1 = guideline3;
        this.seekbarGuideline2 = guideline4;
        this.seekbarGuideline3 = guideline5;
        this.separator = view;
        this.standbyBackground = appCompatImageView6;
        this.standbyImageview = appCompatImageView7;
        this.standbyMessageView = textView8;
        this.standbyTitleView = textView9;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderIcpManualModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderIcpManualModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_icp_manual_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00db, code lost:
        r1 = com.blueair.devicedetails.R.id.separator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.HolderIcpManualModeBinding bind(android.view.View r29) {
        /*
            r0 = r29
            int r1 = com.blueair.devicedetails.R.id.clear_air_min_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.clear_air_msg_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.decrease_fan_speed_bg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.appcompat.widget.AppCompatImageView r7 = (androidx.appcompat.widget.AppCompatImageView) r7
            if (r7 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.decrease_imageview
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.appcompat.widget.AppCompatImageView r8 = (androidx.appcompat.widget.AppCompatImageView) r8
            if (r8 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.fan_speed_seekbar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            com.blueair.viewcore.view.AccessibleSeekBar r9 = (com.blueair.viewcore.view.AccessibleSeekBar) r9
            if (r9 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.fanspeed_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.fanspeed_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.fanspeed_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.germshield_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.appcompat.widget.AppCompatImageView r13 = (androidx.appcompat.widget.AppCompatImageView) r13
            if (r13 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.germshield_root
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            if (r14 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.germshield_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.increase_fan_speed_bg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.appcompat.widget.AppCompatImageView r16 = (androidx.appcompat.widget.AppCompatImageView) r16
            if (r16 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.increase_imageview
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            androidx.appcompat.widget.AppCompatImageView r17 = (androidx.appcompat.widget.AppCompatImageView) r17
            if (r17 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.left_guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            androidx.constraintlayout.widget.Guideline r18 = (androidx.constraintlayout.widget.Guideline) r18
            if (r18 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.mode_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.right_guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            androidx.constraintlayout.widget.Guideline r20 = (androidx.constraintlayout.widget.Guideline) r20
            if (r20 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.seekbar_guideline_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            androidx.constraintlayout.widget.Guideline r21 = (androidx.constraintlayout.widget.Guideline) r21
            if (r21 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.seekbar_guideline_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            androidx.constraintlayout.widget.Guideline r22 = (androidx.constraintlayout.widget.Guideline) r22
            if (r22 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.seekbar_guideline_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            androidx.constraintlayout.widget.Guideline r23 = (androidx.constraintlayout.widget.Guideline) r23
            if (r23 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.separator
            android.view.View r24 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r24 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.standby_background
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            androidx.appcompat.widget.AppCompatImageView r25 = (androidx.appcompat.widget.AppCompatImageView) r25
            if (r25 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.standby_imageview
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            androidx.appcompat.widget.AppCompatImageView r26 = (androidx.appcompat.widget.AppCompatImageView) r26
            if (r26 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.standby_message_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            android.widget.TextView r27 = (android.widget.TextView) r27
            if (r27 == 0) goto L_0x011c
            int r1 = com.blueair.devicedetails.R.id.standby_title_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            android.widget.TextView r28 = (android.widget.TextView) r28
            if (r28 == 0) goto L_0x011c
            com.blueair.devicedetails.databinding.HolderIcpManualModeBinding r3 = new com.blueair.devicedetails.databinding.HolderIcpManualModeBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return r3
        L_0x011c:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.HolderIcpManualModeBinding.bind(android.view.View):com.blueair.devicedetails.databinding.HolderIcpManualModeBinding");
    }
}
