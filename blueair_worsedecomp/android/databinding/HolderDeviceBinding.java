package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blueair.android.R;
import com.blueair.viewcore.view.SimpleIconTextView;
import com.blueair.viewcore.view.SwitchCompat;
import com.dd.ShadowLayout;

public final class HolderDeviceBinding implements ViewBinding {
    public final View airQualityIndicator;
    public final Barrier barrierQuality;
    public final ImageView childLockIcon;
    public final ImageView deviceImg;
    public final TextView deviceName;
    public final Flow flowStatus;
    public final ConstraintLayout foregroundLayout;
    public final SimpleIconTextView itvAlarm;
    public final View ivDegreeIndicator;
    public final ImageView ivOfflineInfo;
    public final ImageView ivTimer;
    public final AppCompatImageView ivWarning;
    public final LinearLayout llMode1;
    public final LinearLayout llMode2;
    public final LinearLayout llTimer;
    public final ImageView modeIcon1;
    public final ImageView modeIcon2;
    public final AppCompatTextView modeText1;
    public final AppCompatTextView modeText2;
    private final ShadowLayout rootView;
    public final TextView safetySwitchText;
    public final ShadowLayout shadowLayout;
    public final SwitchCompat standbySwitch;
    public final TextView tvAirFilterStatus;
    public final TextView tvAirQuality;
    public final TextView tvDegree;
    public final AppCompatTextView tvTimer;
    public final TextView tvWickFilterStatus;

    private HolderDeviceBinding(ShadowLayout shadowLayout2, View view, Barrier barrier, ImageView imageView, ImageView imageView2, TextView textView, Flow flow, ConstraintLayout constraintLayout, SimpleIconTextView simpleIconTextView, View view2, ImageView imageView3, ImageView imageView4, AppCompatImageView appCompatImageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView5, ImageView imageView6, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView2, ShadowLayout shadowLayout3, SwitchCompat switchCompat, TextView textView3, TextView textView4, TextView textView5, AppCompatTextView appCompatTextView3, TextView textView6) {
        this.rootView = shadowLayout2;
        this.airQualityIndicator = view;
        this.barrierQuality = barrier;
        this.childLockIcon = imageView;
        this.deviceImg = imageView2;
        this.deviceName = textView;
        this.flowStatus = flow;
        this.foregroundLayout = constraintLayout;
        this.itvAlarm = simpleIconTextView;
        this.ivDegreeIndicator = view2;
        this.ivOfflineInfo = imageView3;
        this.ivTimer = imageView4;
        this.ivWarning = appCompatImageView;
        this.llMode1 = linearLayout;
        this.llMode2 = linearLayout2;
        this.llTimer = linearLayout3;
        this.modeIcon1 = imageView5;
        this.modeIcon2 = imageView6;
        this.modeText1 = appCompatTextView;
        this.modeText2 = appCompatTextView2;
        this.safetySwitchText = textView2;
        this.shadowLayout = shadowLayout3;
        this.standbySwitch = switchCompat;
        this.tvAirFilterStatus = textView3;
        this.tvAirQuality = textView4;
        this.tvDegree = textView5;
        this.tvTimer = appCompatTextView3;
        this.tvWickFilterStatus = textView6;
    }

    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        r1 = com.blueair.android.R.id.iv_degree_indicator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.android.databinding.HolderDeviceBinding bind(android.view.View r31) {
        /*
            r0 = r31
            int r1 = com.blueair.android.R.id.air_quality_indicator
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r4 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.barrier_quality
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.Barrier r5 = (androidx.constraintlayout.widget.Barrier) r5
            if (r5 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.child_lock_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.device_img
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.device_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.flow_status
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.constraintlayout.helper.widget.Flow r9 = (androidx.constraintlayout.helper.widget.Flow) r9
            if (r9 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.foregroundLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            if (r10 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.itv_alarm
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            com.blueair.viewcore.view.SimpleIconTextView r11 = (com.blueair.viewcore.view.SimpleIconTextView) r11
            if (r11 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.iv_degree_indicator
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r12 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.iv_offline_info
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.iv_timer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.iv_warning
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            androidx.appcompat.widget.AppCompatImageView r15 = (androidx.appcompat.widget.AppCompatImageView) r15
            if (r15 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.ll_mode1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.LinearLayout r16 = (android.widget.LinearLayout) r16
            if (r16 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.ll_mode2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.LinearLayout r17 = (android.widget.LinearLayout) r17
            if (r17 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.ll_timer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.LinearLayout r18 = (android.widget.LinearLayout) r18
            if (r18 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.mode_icon_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.ImageView r19 = (android.widget.ImageView) r19
            if (r19 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.mode_icon_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.ImageView r20 = (android.widget.ImageView) r20
            if (r20 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.mode_text_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            androidx.appcompat.widget.AppCompatTextView r21 = (androidx.appcompat.widget.AppCompatTextView) r21
            if (r21 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.mode_text_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            androidx.appcompat.widget.AppCompatTextView r22 = (androidx.appcompat.widget.AppCompatTextView) r22
            if (r22 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.safety_switch_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x0133
            r3 = r0
            com.dd.ShadowLayout r3 = (com.dd.ShadowLayout) r3
            int r1 = com.blueair.android.R.id.standby_switch
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            com.blueair.viewcore.view.SwitchCompat r25 = (com.blueair.viewcore.view.SwitchCompat) r25
            if (r25 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.tv_air_filterStatus
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            android.widget.TextView r26 = (android.widget.TextView) r26
            if (r26 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.tv_air_quality
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            android.widget.TextView r27 = (android.widget.TextView) r27
            if (r27 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.tv_degree
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            android.widget.TextView r28 = (android.widget.TextView) r28
            if (r28 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.tv_timer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r29 = r2
            androidx.appcompat.widget.AppCompatTextView r29 = (androidx.appcompat.widget.AppCompatTextView) r29
            if (r29 == 0) goto L_0x0133
            int r1 = com.blueair.android.R.id.tv_wick_filterStatus
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r30 = r2
            android.widget.TextView r30 = (android.widget.TextView) r30
            if (r30 == 0) goto L_0x0133
            com.blueair.android.databinding.HolderDeviceBinding r2 = new com.blueair.android.databinding.HolderDeviceBinding
            r24 = r3
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return r2
        L_0x0133:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.databinding.HolderDeviceBinding.bind(android.view.View):com.blueair.android.databinding.HolderDeviceBinding");
    }
}
