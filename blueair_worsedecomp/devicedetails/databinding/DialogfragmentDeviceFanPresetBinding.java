package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;
import io.apptik.widget.MultiSlider;

public final class DialogfragmentDeviceFanPresetBinding implements ViewBinding {
    public final MaterialButton btnApply;
    public final MaterialButton btnReset;
    public final ImageButton closeBtn;
    public final ConstraintLayout contentContainer;
    public final ConstraintLayout contentPresetDetail;
    public final TextView currentUpdateTemp;
    public final TextView fanPresetInfo;
    public final TextView fanSpeedTitle1;
    public final TextView fanSpeedTitle2;
    public final TextView fanSpeedTitle3;
    public final TextView fanSpeedTitle4;
    public final TextView fanSpeedTrigger;
    public final TextView maxTemp;
    public final TextView minTemp;
    public final MultiSlider rangeSlider;
    private final FrameLayout rootView;
    public final View separator1;
    public final View separator2;
    public final View separator3;
    public final View separator4;
    public final View separator5;
    public final TextView timerSelect1;
    public final TextView timerSelect2;
    public final TextView timerSelect3;
    public final TextView timerSelect4;
    public final TextView timerTriggerSelect;
    public final TextView title;

    private DialogfragmentDeviceFanPresetBinding(FrameLayout frameLayout, MaterialButton materialButton, MaterialButton materialButton2, ImageButton imageButton, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, MultiSlider multiSlider, View view, View view2, View view3, View view4, View view5, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15) {
        this.rootView = frameLayout;
        this.btnApply = materialButton;
        this.btnReset = materialButton2;
        this.closeBtn = imageButton;
        this.contentContainer = constraintLayout;
        this.contentPresetDetail = constraintLayout2;
        this.currentUpdateTemp = textView;
        this.fanPresetInfo = textView2;
        this.fanSpeedTitle1 = textView3;
        this.fanSpeedTitle2 = textView4;
        this.fanSpeedTitle3 = textView5;
        this.fanSpeedTitle4 = textView6;
        this.fanSpeedTrigger = textView7;
        this.maxTemp = textView8;
        this.minTemp = textView9;
        this.rangeSlider = multiSlider;
        this.separator1 = view;
        this.separator2 = view2;
        this.separator3 = view3;
        this.separator4 = view4;
        this.separator5 = view5;
        this.timerSelect1 = textView10;
        this.timerSelect2 = textView11;
        this.timerSelect3 = textView12;
        this.timerSelect4 = textView13;
        this.timerTriggerSelect = textView14;
        this.title = textView15;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogfragmentDeviceFanPresetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogfragmentDeviceFanPresetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_device_fan_preset, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ab, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b3, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bb, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c3, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cb, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.DialogfragmentDeviceFanPresetBinding bind(android.view.View r31) {
        /*
            r0 = r31
            int r1 = com.blueair.devicedetails.R.id.btn_apply
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.google.android.material.button.MaterialButton r5 = (com.google.android.material.button.MaterialButton) r5
            if (r5 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.btn_reset
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.google.android.material.button.MaterialButton r6 = (com.google.android.material.button.MaterialButton) r6
            if (r6 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.close_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageButton r7 = (android.widget.ImageButton) r7
            if (r7 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.content_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.content_preset_detail
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            if (r9 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.current_update_temp
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.fan_preset_info
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.fan_speed_title_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.fan_speed_title_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.fan_speed_title_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.fan_speed_title_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.fan_speed_trigger
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.max_temp
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.min_temp
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.range_slider
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            io.apptik.widget.MultiSlider r19 = (io.apptik.widget.MultiSlider) r19
            if (r19 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.separator_1
            android.view.View r20 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r20 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.separator_2
            android.view.View r21 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r21 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.separator_3
            android.view.View r22 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r22 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.separator_4
            android.view.View r23 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r23 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.separator_5
            android.view.View r24 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r24 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.timer_select_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            android.widget.TextView r25 = (android.widget.TextView) r25
            if (r25 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.timer_select_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            android.widget.TextView r26 = (android.widget.TextView) r26
            if (r26 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.timer_select_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            android.widget.TextView r27 = (android.widget.TextView) r27
            if (r27 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.timer_select_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            android.widget.TextView r28 = (android.widget.TextView) r28
            if (r28 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.timer_trigger_select
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r29 = r2
            android.widget.TextView r29 = (android.widget.TextView) r29
            if (r29 == 0) goto L_0x0124
            int r1 = com.blueair.devicedetails.R.id.title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r30 = r2
            android.widget.TextView r30 = (android.widget.TextView) r30
            if (r30 == 0) goto L_0x0124
            com.blueair.devicedetails.databinding.DialogfragmentDeviceFanPresetBinding r3 = new com.blueair.devicedetails.databinding.DialogfragmentDeviceFanPresetBinding
            r4 = r0
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return r3
        L_0x0124:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.DialogfragmentDeviceFanPresetBinding.bind(android.view.View):com.blueair.devicedetails.databinding.DialogfragmentDeviceFanPresetBinding");
    }
}
