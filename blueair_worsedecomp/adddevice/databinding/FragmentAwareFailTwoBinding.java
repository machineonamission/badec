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

public final class FragmentAwareFailTwoBinding implements ViewBinding {
    public final MaterialButton buttonNextAware;
    public final View dividerOne;
    public final ImageView imageFailBlueFlash;
    public final ImageView imageFailOrangeFlash;
    public final RadioButton radioBtnBlueFlash;
    public final RadioButton radioBtnOrangeFlash;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView textAddDeviceSubtitle;
    public final TextView textAddDeviceTitle;

    private FragmentAwareFailTwoBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, View view, ImageView imageView, ImageView imageView2, RadioButton radioButton, RadioButton radioButton2, ConstraintLayout constraintLayout2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.buttonNextAware = materialButton;
        this.dividerOne = view;
        this.imageFailBlueFlash = imageView;
        this.imageFailOrangeFlash = imageView2;
        this.radioBtnBlueFlash = radioButton;
        this.radioBtnOrangeFlash = radioButton2;
        this.rootLayout = constraintLayout2;
        this.textAddDeviceSubtitle = textView;
        this.textAddDeviceTitle = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAwareFailTwoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentAwareFailTwoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_aware_fail_two, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.blueair.adddevice.R.id.divider_one;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.adddevice.databinding.FragmentAwareFailTwoBinding bind(android.view.View r13) {
        /*
            int r0 = com.blueair.adddevice.R.id.buttonNextAware
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            com.google.android.material.button.MaterialButton r4 = (com.google.android.material.button.MaterialButton) r4
            if (r4 == 0) goto L_0x005f
            int r0 = com.blueair.adddevice.R.id.divider_one
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r5 == 0) goto L_0x005f
            int r0 = com.blueair.adddevice.R.id.imageFailBlueFlash
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x005f
            int r0 = com.blueair.adddevice.R.id.imageFailOrangeFlash
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x005f
            int r0 = com.blueair.adddevice.R.id.radioBtnBlueFlash
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            android.widget.RadioButton r8 = (android.widget.RadioButton) r8
            if (r8 == 0) goto L_0x005f
            int r0 = com.blueair.adddevice.R.id.radioBtnOrangeFlash
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            android.widget.RadioButton r9 = (android.widget.RadioButton) r9
            if (r9 == 0) goto L_0x005f
            r3 = r13
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            int r0 = com.blueair.adddevice.R.id.textAddDeviceSubtitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x005f
            int r0 = com.blueair.adddevice.R.id.textAddDeviceTitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x005f
            com.blueair.adddevice.databinding.FragmentAwareFailTwoBinding r2 = new com.blueair.adddevice.databinding.FragmentAwareFailTwoBinding
            r10 = r3
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r2
        L_0x005f:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.databinding.FragmentAwareFailTwoBinding.bind(android.view.View):com.blueair.adddevice.databinding.FragmentAwareFailTwoBinding");
    }
}
