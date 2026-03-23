package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentSenseFailWifiBinding implements ViewBinding {
    public final MaterialButton buttonNextSense;
    public final View dividerOne;
    public final View dividerTwo;
    public final View dividerZero;
    public final ImageView imageBackgroundOne;
    public final ImageView imageBackgroundTwo;
    public final ImageView imageFailFlashingFasterSense;
    public final ImageView imageFailFlashingSlowerSense;
    public final RadioButton radioBtnWifiFlashingSense;
    public final RadioButton radioBtnWifiPulsingSense;
    public final ConstraintLayout rootLayout;
    private final ScrollView rootView;
    public final ScrollView scrollable;
    public final TextView textAddDeviceSubtitle;
    public final TextView textAddDeviceTitle;

    private FragmentSenseFailWifiBinding(ScrollView scrollView, MaterialButton materialButton, View view, View view2, View view3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RadioButton radioButton, RadioButton radioButton2, ConstraintLayout constraintLayout, ScrollView scrollView2, TextView textView, TextView textView2) {
        this.rootView = scrollView;
        this.buttonNextSense = materialButton;
        this.dividerOne = view;
        this.dividerTwo = view2;
        this.dividerZero = view3;
        this.imageBackgroundOne = imageView;
        this.imageBackgroundTwo = imageView2;
        this.imageFailFlashingFasterSense = imageView3;
        this.imageFailFlashingSlowerSense = imageView4;
        this.radioBtnWifiFlashingSense = radioButton;
        this.radioBtnWifiPulsingSense = radioButton2;
        this.rootLayout = constraintLayout;
        this.scrollable = scrollView2;
        this.textAddDeviceSubtitle = textView;
        this.textAddDeviceTitle = textView2;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentSenseFailWifiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSenseFailWifiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_sense_fail_wifi, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.blueair.adddevice.R.id.divider_one;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r1 = com.blueair.adddevice.R.id.divider_two;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
        r1 = com.blueair.adddevice.R.id.divider_zero;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.adddevice.databinding.FragmentSenseFailWifiBinding bind(android.view.View r19) {
        /*
            r0 = r19
            int r1 = com.blueair.adddevice.R.id.buttonNextSense
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.google.android.material.button.MaterialButton r5 = (com.google.android.material.button.MaterialButton) r5
            if (r5 == 0) goto L_0x0095
            int r1 = com.blueair.adddevice.R.id.divider_one
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r6 == 0) goto L_0x0095
            int r1 = com.blueair.adddevice.R.id.divider_two
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r7 == 0) goto L_0x0095
            int r1 = com.blueair.adddevice.R.id.divider_zero
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r8 == 0) goto L_0x0095
            int r1 = com.blueair.adddevice.R.id.imageBackgroundOne
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0095
            int r1 = com.blueair.adddevice.R.id.imageBackgroundTwo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x0095
            int r1 = com.blueair.adddevice.R.id.imageFailFlashingFasterSense
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x0095
            int r1 = com.blueair.adddevice.R.id.imageFailFlashingSlowerSense
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x0095
            int r1 = com.blueair.adddevice.R.id.radioBtnWifiFlashingSense
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.RadioButton r13 = (android.widget.RadioButton) r13
            if (r13 == 0) goto L_0x0095
            int r1 = com.blueair.adddevice.R.id.radioBtnWifiPulsingSense
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.RadioButton r14 = (android.widget.RadioButton) r14
            if (r14 == 0) goto L_0x0095
            int r1 = com.blueair.adddevice.R.id.rootLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            androidx.constraintlayout.widget.ConstraintLayout r15 = (androidx.constraintlayout.widget.ConstraintLayout) r15
            if (r15 == 0) goto L_0x0095
            r4 = r0
            android.widget.ScrollView r4 = (android.widget.ScrollView) r4
            int r1 = com.blueair.adddevice.R.id.textAddDeviceSubtitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x0095
            int r1 = com.blueair.adddevice.R.id.textAddDeviceTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x0095
            com.blueair.adddevice.databinding.FragmentSenseFailWifiBinding r3 = new com.blueair.adddevice.databinding.FragmentSenseFailWifiBinding
            r16 = r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r3
        L_0x0095:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.databinding.FragmentSenseFailWifiBinding.bind(android.view.View):com.blueair.adddevice.databinding.FragmentSenseFailWifiBinding");
    }
}
