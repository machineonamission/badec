package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.FanView;
import com.blueair.viewcore.view.SwitchCompat;

public final class HolderDeviceOscillationBinding implements ViewBinding {
    public final TextView angle;
    public final AppCompatImageView angleDirection;
    public final View arrow;
    public final ConstraintLayout contentAngleSetting;
    public final LinearLayout contentContainer;
    public final ConstraintLayout contentOscillationFanView;
    public final ConstraintLayout contentOscillationSettings;
    public final ConstraintLayout contentTitle;
    public final TextView direction;
    public final TextView directionTitle;
    public final AppCompatImageView fanDirection;
    public final FanView fanView;
    public final TextView oscillationAngleTitle;
    public final TextView oscillationSettingsTitle;
    private final FrameLayout rootView;
    public final View spacer1;
    public final View spacer2;
    public final TextView speed;
    public final TextView speedTitle;
    public final SwitchCompat switchBtn;
    public final TextView title;

    private HolderDeviceOscillationBinding(FrameLayout frameLayout, TextView textView, AppCompatImageView appCompatImageView, View view, ConstraintLayout constraintLayout, LinearLayout linearLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView2, TextView textView3, AppCompatImageView appCompatImageView2, FanView fanView2, TextView textView4, TextView textView5, View view2, View view3, TextView textView6, TextView textView7, SwitchCompat switchCompat, TextView textView8) {
        this.rootView = frameLayout;
        this.angle = textView;
        this.angleDirection = appCompatImageView;
        this.arrow = view;
        this.contentAngleSetting = constraintLayout;
        this.contentContainer = linearLayout;
        this.contentOscillationFanView = constraintLayout2;
        this.contentOscillationSettings = constraintLayout3;
        this.contentTitle = constraintLayout4;
        this.direction = textView2;
        this.directionTitle = textView3;
        this.fanDirection = appCompatImageView2;
        this.fanView = fanView2;
        this.oscillationAngleTitle = textView4;
        this.oscillationSettingsTitle = textView5;
        this.spacer1 = view2;
        this.spacer2 = view3;
        this.speed = textView6;
        this.speedTitle = textView7;
        this.switchBtn = switchCompat;
        this.title = textView8;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceOscillationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceOscillationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_oscillation, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009c, code lost:
        r1 = com.blueair.devicedetails.R.id.spacer_1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a4, code lost:
        r1 = com.blueair.devicedetails.R.id.spacer_2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r1 = com.blueair.devicedetails.R.id.arrow;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.HolderDeviceOscillationBinding bind(android.view.View r25) {
        /*
            r0 = r25
            int r1 = com.blueair.devicedetails.R.id.angle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.angle_direction
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.appcompat.widget.AppCompatImageView r6 = (androidx.appcompat.widget.AppCompatImageView) r6
            if (r6 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.arrow
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r7 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.content_angle_setting
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.content_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            if (r9 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.content_oscillation_fan_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            if (r10 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.content_oscillation_settings
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            if (r11 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.content_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            if (r12 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.direction
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.direction_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.fan_direction
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            androidx.appcompat.widget.AppCompatImageView r15 = (androidx.appcompat.widget.AppCompatImageView) r15
            if (r15 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.fan_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            com.blueair.viewcore.view.FanView r16 = (com.blueair.viewcore.view.FanView) r16
            if (r16 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.oscillation_angle_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.oscillation_settings_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.spacer_1
            android.view.View r19 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r19 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.spacer_2
            android.view.View r20 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r20 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.speed
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.speed_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.switch_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            com.blueair.viewcore.view.SwitchCompat r23 = (com.blueair.viewcore.view.SwitchCompat) r23
            if (r23 == 0) goto L_0x00e5
            int r1 = com.blueair.devicedetails.R.id.title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x00e5
            com.blueair.devicedetails.databinding.HolderDeviceOscillationBinding r3 = new com.blueair.devicedetails.databinding.HolderDeviceOscillationBinding
            r4 = r0
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r3
        L_0x00e5:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.HolderDeviceOscillationBinding.bind(android.view.View):com.blueair.devicedetails.databinding.HolderDeviceOscillationBinding");
    }
}
