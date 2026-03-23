package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentDeviceC3TemperatureBinding implements ViewBinding {
    public final AppCompatImageView backBtn;
    public final LinearLayout contentBack;
    public final ConstraintLayout contentContainer;
    public final View divider;
    public final Guideline endGuideline;
    private final FrameLayout rootView;
    public final MaterialButton saveBtn;
    public final AppCompatImageView selectC;
    public final AppCompatImageView selectF;
    public final Guideline startGuideline;
    public final TextView title;
    public final TextView titleTempC;
    public final TextView titleTempF;

    private DialogfragmentDeviceC3TemperatureBinding(FrameLayout frameLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, ConstraintLayout constraintLayout, View view, Guideline guideline, MaterialButton materialButton, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, Guideline guideline2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = frameLayout;
        this.backBtn = appCompatImageView;
        this.contentBack = linearLayout;
        this.contentContainer = constraintLayout;
        this.divider = view;
        this.endGuideline = guideline;
        this.saveBtn = materialButton;
        this.selectC = appCompatImageView2;
        this.selectF = appCompatImageView3;
        this.startGuideline = guideline2;
        this.title = textView;
        this.titleTempC = textView2;
        this.titleTempF = textView3;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogfragmentDeviceC3TemperatureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogfragmentDeviceC3TemperatureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_device_c3_temperature, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r1 = com.blueair.devicedetails.R.id.divider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.DialogfragmentDeviceC3TemperatureBinding bind(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.blueair.devicedetails.R.id.back_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.appcompat.widget.AppCompatImageView r5 = (androidx.appcompat.widget.AppCompatImageView) r5
            if (r5 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.content_back
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.content_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.divider
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r8 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.end_guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.constraintlayout.widget.Guideline r9 = (androidx.constraintlayout.widget.Guideline) r9
            if (r9 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.save_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            com.google.android.material.button.MaterialButton r10 = (com.google.android.material.button.MaterialButton) r10
            if (r10 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.select_c
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.appcompat.widget.AppCompatImageView r11 = (androidx.appcompat.widget.AppCompatImageView) r11
            if (r11 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.select_f
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.appcompat.widget.AppCompatImageView r12 = (androidx.appcompat.widget.AppCompatImageView) r12
            if (r12 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.start_guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.constraintlayout.widget.Guideline r13 = (androidx.constraintlayout.widget.Guideline) r13
            if (r13 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.title_temp_c
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.title_temp_f
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x008d
            com.blueair.devicedetails.databinding.DialogfragmentDeviceC3TemperatureBinding r3 = new com.blueair.devicedetails.databinding.DialogfragmentDeviceC3TemperatureBinding
            r4 = r0
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r3
        L_0x008d:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.DialogfragmentDeviceC3TemperatureBinding.bind(android.view.View):com.blueair.devicedetails.databinding.DialogfragmentDeviceC3TemperatureBinding");
    }
}
