package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentClassicFailRingBinding implements ViewBinding {
    public final MaterialButton buttonNextClassic;
    public final View dividerOne;
    public final View dividerTwo;
    public final ImageView imageFailRingFadedClassic;
    public final ImageView imageFailRingFlashingClassic;
    public final ImageView imageFailSolidRingClassic;
    public final RadioButton radioBtnFailRingFlashingClassic;
    public final RadioButton radioBtnFailRingSolidClassic;
    public final RadioButton radioBtnFailWifiSolidClassic;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView textAddDeviceSubtitle;
    public final TextView textAddDeviceTitle;

    private FragmentClassicFailRingBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, View view, View view2, ImageView imageView, ImageView imageView2, ImageView imageView3, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, ConstraintLayout constraintLayout2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.buttonNextClassic = materialButton;
        this.dividerOne = view;
        this.dividerTwo = view2;
        this.imageFailRingFadedClassic = imageView;
        this.imageFailRingFlashingClassic = imageView2;
        this.imageFailSolidRingClassic = imageView3;
        this.radioBtnFailRingFlashingClassic = radioButton;
        this.radioBtnFailRingSolidClassic = radioButton2;
        this.radioBtnFailWifiSolidClassic = radioButton3;
        this.rootLayout = constraintLayout2;
        this.textAddDeviceSubtitle = textView;
        this.textAddDeviceTitle = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassicFailRingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentClassicFailRingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_classic_fail_ring, viewGroup, false);
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
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.adddevice.databinding.FragmentClassicFailRingBinding bind(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.blueair.adddevice.R.id.buttonNextClassic
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.google.android.material.button.MaterialButton r5 = (com.google.android.material.button.MaterialButton) r5
            if (r5 == 0) goto L_0x0080
            int r1 = com.blueair.adddevice.R.id.divider_one
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r6 == 0) goto L_0x0080
            int r1 = com.blueair.adddevice.R.id.divider_two
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r7 == 0) goto L_0x0080
            int r1 = com.blueair.adddevice.R.id.imageFailRingFadedClassic
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0080
            int r1 = com.blueair.adddevice.R.id.imageFailRingFlashingClassic
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0080
            int r1 = com.blueair.adddevice.R.id.imageFailSolidRingClassic
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x0080
            int r1 = com.blueair.adddevice.R.id.radioBtnFailRingFlashingClassic
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.RadioButton r11 = (android.widget.RadioButton) r11
            if (r11 == 0) goto L_0x0080
            int r1 = com.blueair.adddevice.R.id.radioBtnFailRingSolidClassic
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.RadioButton r12 = (android.widget.RadioButton) r12
            if (r12 == 0) goto L_0x0080
            int r1 = com.blueair.adddevice.R.id.radioBtnFailWifiSolidClassic
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.RadioButton r13 = (android.widget.RadioButton) r13
            if (r13 == 0) goto L_0x0080
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            int r1 = com.blueair.adddevice.R.id.textAddDeviceSubtitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0080
            int r1 = com.blueair.adddevice.R.id.textAddDeviceTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x0080
            com.blueair.adddevice.databinding.FragmentClassicFailRingBinding r3 = new com.blueair.adddevice.databinding.FragmentClassicFailRingBinding
            r14 = r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r3
        L_0x0080:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.databinding.FragmentClassicFailRingBinding.bind(android.view.View):com.blueair.adddevice.databinding.FragmentClassicFailRingBinding");
    }
}
