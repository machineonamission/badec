package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import com.blueair.viewcore.view.FanView;

public final class DialogfragmentDeviceOscillationSettingsBinding implements ViewBinding {
    public final TextView angleLevel1;
    public final TextView angleLevel2;
    public final TextView angleLevel3;
    public final TextView angleLevel4;
    public final TextView angleLevel5;
    public final AccessibleSeekBar angleSeekbar;
    public final TextView angleTitle;
    public final AppCompatImageView arrowLeft;
    public final AppCompatImageView arrowRight;
    public final AppCompatImageView arrowStraight;
    public final Button cancelBtn;
    public final AppCompatImageView centerBackground;
    public final ConstraintLayout contentAngle;
    public final ConstraintLayout contentAngleAnimator;
    public final ConstraintLayout contentContainer;
    public final ConstraintLayout contentOscillationSpeed;
    public final AppCompatImageView deviceImage;
    public final Button doneBtn;
    public final AppCompatImageView fanDirection;
    public final FanView fanView;
    public final TextView oscillationDiagramAngle;
    public final TextView oscillationSpeedTitle;
    public final RadioGroup radioGroup;
    private final FrameLayout rootView;
    public final View separator;
    public final View separator2;
    public final View separatorAngle1;
    public final View separatorAngle2;
    public final View separatorAngle3;
    public final View separatorAngle4;
    public final View separatorAngle5;
    public final RadioButton speed1;
    public final RadioButton speed2;
    public final RadioButton speed3;
    public final TextView title;

    private DialogfragmentDeviceOscillationSettingsBinding(FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, AccessibleSeekBar accessibleSeekBar, TextView textView6, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, Button button, AppCompatImageView appCompatImageView4, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, AppCompatImageView appCompatImageView5, Button button2, AppCompatImageView appCompatImageView6, FanView fanView2, TextView textView7, TextView textView8, RadioGroup radioGroup2, View view, View view2, View view3, View view4, View view5, View view6, View view7, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, TextView textView9) {
        this.rootView = frameLayout;
        this.angleLevel1 = textView;
        this.angleLevel2 = textView2;
        this.angleLevel3 = textView3;
        this.angleLevel4 = textView4;
        this.angleLevel5 = textView5;
        this.angleSeekbar = accessibleSeekBar;
        this.angleTitle = textView6;
        this.arrowLeft = appCompatImageView;
        this.arrowRight = appCompatImageView2;
        this.arrowStraight = appCompatImageView3;
        this.cancelBtn = button;
        this.centerBackground = appCompatImageView4;
        this.contentAngle = constraintLayout;
        this.contentAngleAnimator = constraintLayout2;
        this.contentContainer = constraintLayout3;
        this.contentOscillationSpeed = constraintLayout4;
        this.deviceImage = appCompatImageView5;
        this.doneBtn = button2;
        this.fanDirection = appCompatImageView6;
        this.fanView = fanView2;
        this.oscillationDiagramAngle = textView7;
        this.oscillationSpeedTitle = textView8;
        this.radioGroup = radioGroup2;
        this.separator = view;
        this.separator2 = view2;
        this.separatorAngle1 = view3;
        this.separatorAngle2 = view4;
        this.separatorAngle3 = view5;
        this.separatorAngle4 = view6;
        this.separatorAngle5 = view7;
        this.speed1 = radioButton;
        this.speed2 = radioButton2;
        this.speed3 = radioButton3;
        this.title = textView9;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogfragmentDeviceOscillationSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogfragmentDeviceOscillationSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_device_oscillation_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010b, code lost:
        r1 = com.blueair.devicedetails.R.id.separator;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0113, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011b, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_angle_1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0123, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_angle_2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012b, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_angle_3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0133, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_angle_4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013b, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_angle_5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.DialogfragmentDeviceOscillationSettingsBinding bind(android.view.View r39) {
        /*
            r0 = r39
            int r1 = com.blueair.devicedetails.R.id.angle_level_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.angle_level_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.angle_level_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.angle_level_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.angle_level_5
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.angle_seekbar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            com.blueair.viewcore.view.AccessibleSeekBar r10 = (com.blueair.viewcore.view.AccessibleSeekBar) r10
            if (r10 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.angle_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.arrow_left
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.appcompat.widget.AppCompatImageView r12 = (androidx.appcompat.widget.AppCompatImageView) r12
            if (r12 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.arrow_right
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.appcompat.widget.AppCompatImageView r13 = (androidx.appcompat.widget.AppCompatImageView) r13
            if (r13 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.arrow_straight
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            androidx.appcompat.widget.AppCompatImageView r14 = (androidx.appcompat.widget.AppCompatImageView) r14
            if (r14 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.cancel_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.Button r15 = (android.widget.Button) r15
            if (r15 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.center_background
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.appcompat.widget.AppCompatImageView r16 = (androidx.appcompat.widget.AppCompatImageView) r16
            if (r16 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.content_angle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            androidx.constraintlayout.widget.ConstraintLayout r17 = (androidx.constraintlayout.widget.ConstraintLayout) r17
            if (r17 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.content_angle_animator
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            androidx.constraintlayout.widget.ConstraintLayout r18 = (androidx.constraintlayout.widget.ConstraintLayout) r18
            if (r18 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.content_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            androidx.constraintlayout.widget.ConstraintLayout r19 = (androidx.constraintlayout.widget.ConstraintLayout) r19
            if (r19 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.content_oscillation_speed
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            androidx.constraintlayout.widget.ConstraintLayout r20 = (androidx.constraintlayout.widget.ConstraintLayout) r20
            if (r20 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.device_image
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            androidx.appcompat.widget.AppCompatImageView r21 = (androidx.appcompat.widget.AppCompatImageView) r21
            if (r21 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.done_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.Button r22 = (android.widget.Button) r22
            if (r22 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.fan_direction
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            androidx.appcompat.widget.AppCompatImageView r23 = (androidx.appcompat.widget.AppCompatImageView) r23
            if (r23 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.fan_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            com.blueair.viewcore.view.FanView r24 = (com.blueair.viewcore.view.FanView) r24
            if (r24 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.oscillation_diagram_angle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            android.widget.TextView r25 = (android.widget.TextView) r25
            if (r25 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.oscillation_speed_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            android.widget.TextView r26 = (android.widget.TextView) r26
            if (r26 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.radio_group
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            android.widget.RadioGroup r27 = (android.widget.RadioGroup) r27
            if (r27 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.separator
            android.view.View r28 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r28 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.separator_2
            android.view.View r29 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r29 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.separator_angle_1
            android.view.View r30 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r30 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.separator_angle_2
            android.view.View r31 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r31 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.separator_angle_3
            android.view.View r32 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r32 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.separator_angle_4
            android.view.View r33 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r33 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.separator_angle_5
            android.view.View r34 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r34 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.speed_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r35 = r2
            android.widget.RadioButton r35 = (android.widget.RadioButton) r35
            if (r35 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.speed_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r36 = r2
            android.widget.RadioButton r36 = (android.widget.RadioButton) r36
            if (r36 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.speed_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r37 = r2
            android.widget.RadioButton r37 = (android.widget.RadioButton) r37
            if (r37 == 0) goto L_0x017c
            int r1 = com.blueair.devicedetails.R.id.title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r38 = r2
            android.widget.TextView r38 = (android.widget.TextView) r38
            if (r38 == 0) goto L_0x017c
            com.blueair.devicedetails.databinding.DialogfragmentDeviceOscillationSettingsBinding r3 = new com.blueair.devicedetails.databinding.DialogfragmentDeviceOscillationSettingsBinding
            r4 = r0
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)
            return r3
        L_0x017c:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.DialogfragmentDeviceOscillationSettingsBinding.bind(android.view.View):com.blueair.devicedetails.databinding.DialogfragmentDeviceOscillationSettingsBinding");
    }
}
