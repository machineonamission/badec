package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentSenseFailRingBinding implements ViewBinding {
    public final MaterialButton buttonNextSense;
    public final View dividerOne;
    public final View dividerThree;
    public final View dividerTwo;
    public final View dividerZero;
    public final ImageView imageBackgroundOne;
    public final ImageView imageBackgroundThree;
    public final ImageView imageBackgroundTwo;
    public final ImageView imageFailRingSolidWifiFlashingSense;
    public final ImageView imageFailRingWifiFadingSense;
    public final ImageView imageRingWifiSolidSense;
    public final AppCompatRadioButton radioBtnRingSolidWifiFlashingSense;
    public final RadioButton radioBtnRingWifiFadingSense;
    public final RadioButton radioBtnRingWifiSolidSense;
    public final ConstraintLayout rootLayout;
    private final ScrollView rootView;
    public final ScrollView scrollable;
    public final TextView textAddDeviceSubtitle;
    public final TextView textAddDeviceTitle;

    private FragmentSenseFailRingBinding(ScrollView scrollView, MaterialButton materialButton, View view, View view2, View view3, View view4, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, AppCompatRadioButton appCompatRadioButton, RadioButton radioButton, RadioButton radioButton2, ConstraintLayout constraintLayout, ScrollView scrollView2, TextView textView, TextView textView2) {
        this.rootView = scrollView;
        this.buttonNextSense = materialButton;
        this.dividerOne = view;
        this.dividerThree = view2;
        this.dividerTwo = view3;
        this.dividerZero = view4;
        this.imageBackgroundOne = imageView;
        this.imageBackgroundThree = imageView2;
        this.imageBackgroundTwo = imageView3;
        this.imageFailRingSolidWifiFlashingSense = imageView4;
        this.imageFailRingWifiFadingSense = imageView5;
        this.imageRingWifiSolidSense = imageView6;
        this.radioBtnRingSolidWifiFlashingSense = appCompatRadioButton;
        this.radioBtnRingWifiFadingSense = radioButton;
        this.radioBtnRingWifiSolidSense = radioButton2;
        this.rootLayout = constraintLayout;
        this.scrollable = scrollView2;
        this.textAddDeviceSubtitle = textView;
        this.textAddDeviceTitle = textView2;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentSenseFailRingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSenseFailRingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_sense_fail_ring, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.blueair.adddevice.R.id.divider_one;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r1 = com.blueair.adddevice.R.id.divider_three;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
        r1 = com.blueair.adddevice.R.id.divider_two;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        r1 = com.blueair.adddevice.R.id.divider_zero;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.adddevice.databinding.FragmentSenseFailRingBinding bind(android.view.View r23) {
        /*
            r0 = r23
            int r1 = com.blueair.adddevice.R.id.buttonNextSense
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.google.android.material.button.MaterialButton r5 = (com.google.android.material.button.MaterialButton) r5
            if (r5 == 0) goto L_0x00c2
            int r1 = com.blueair.adddevice.R.id.divider_one
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r6 == 0) goto L_0x00c2
            int r1 = com.blueair.adddevice.R.id.divider_three
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r7 == 0) goto L_0x00c2
            int r1 = com.blueair.adddevice.R.id.divider_two
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r8 == 0) goto L_0x00c2
            int r1 = com.blueair.adddevice.R.id.divider_zero
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r9 == 0) goto L_0x00c2
            int r1 = com.blueair.adddevice.R.id.imageBackgroundOne
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00c2
            int r1 = com.blueair.adddevice.R.id.imageBackgroundThree
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x00c2
            int r1 = com.blueair.adddevice.R.id.imageBackgroundTwo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x00c2
            int r1 = com.blueair.adddevice.R.id.imageFailRingSolidWifiFlashingSense
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x00c2
            int r1 = com.blueair.adddevice.R.id.imageFailRingWifiFadingSense
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x00c2
            int r1 = com.blueair.adddevice.R.id.imageRingWifiSolidSense
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            if (r15 == 0) goto L_0x00c2
            int r1 = com.blueair.adddevice.R.id.radioBtnRingSolidWifiFlashingSense
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.appcompat.widget.AppCompatRadioButton r16 = (androidx.appcompat.widget.AppCompatRadioButton) r16
            if (r16 == 0) goto L_0x00c2
            int r1 = com.blueair.adddevice.R.id.radioBtnRingWifiFadingSense
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.RadioButton r17 = (android.widget.RadioButton) r17
            if (r17 == 0) goto L_0x00c2
            int r1 = com.blueair.adddevice.R.id.radioBtnRingWifiSolidSense
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.RadioButton r18 = (android.widget.RadioButton) r18
            if (r18 == 0) goto L_0x00c2
            int r1 = com.blueair.adddevice.R.id.rootLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            androidx.constraintlayout.widget.ConstraintLayout r19 = (androidx.constraintlayout.widget.ConstraintLayout) r19
            if (r19 == 0) goto L_0x00c2
            r4 = r0
            android.widget.ScrollView r4 = (android.widget.ScrollView) r4
            int r1 = com.blueair.adddevice.R.id.textAddDeviceSubtitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00c2
            int r1 = com.blueair.adddevice.R.id.textAddDeviceTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x00c2
            com.blueair.adddevice.databinding.FragmentSenseFailRingBinding r3 = new com.blueair.adddevice.databinding.FragmentSenseFailRingBinding
            r20 = r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return r3
        L_0x00c2:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.databinding.FragmentSenseFailRingBinding.bind(android.view.View):com.blueair.adddevice.databinding.FragmentSenseFailRingBinding");
    }
}
