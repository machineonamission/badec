package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ShadowedRecyclerViewLayout;
import com.google.android.material.button.MaterialButton;

public final class ActivityDeviceSettingsBinding implements ViewBinding {
    public final LinearLayout bottomBar;
    public final AppCompatImageButton btnBack;
    public final MaterialButton buttonDeleteProduct;
    public final MaterialButton buttonWarranty;
    public final NestedScrollView recyclerViewContainer;
    public final ShadowedRecyclerViewLayout recyclerViewSettingsContainer;
    private final ConstraintLayout rootView;
    public final View separator;
    public final AppCompatTextView tvTitle;

    private ActivityDeviceSettingsBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, AppCompatImageButton appCompatImageButton, MaterialButton materialButton, MaterialButton materialButton2, NestedScrollView nestedScrollView, ShadowedRecyclerViewLayout shadowedRecyclerViewLayout, View view, AppCompatTextView appCompatTextView) {
        this.rootView = constraintLayout;
        this.bottomBar = linearLayout;
        this.btnBack = appCompatImageButton;
        this.buttonDeleteProduct = materialButton;
        this.buttonWarranty = materialButton2;
        this.recyclerViewContainer = nestedScrollView;
        this.recyclerViewSettingsContainer = shadowedRecyclerViewLayout;
        this.separator = view;
        this.tvTitle = appCompatTextView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDeviceSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityDeviceSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_device_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r0 = com.blueair.devicedetails.R.id.separator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.ActivityDeviceSettingsBinding bind(android.view.View r12) {
        /*
            int r0 = com.blueair.devicedetails.R.id.bottom_bar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x005e
            int r0 = com.blueair.devicedetails.R.id.btnBack
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r5 = r1
            androidx.appcompat.widget.AppCompatImageButton r5 = (androidx.appcompat.widget.AppCompatImageButton) r5
            if (r5 == 0) goto L_0x005e
            int r0 = com.blueair.devicedetails.R.id.buttonDeleteProduct
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r6 = r1
            com.google.android.material.button.MaterialButton r6 = (com.google.android.material.button.MaterialButton) r6
            if (r6 == 0) goto L_0x005e
            int r0 = com.blueair.devicedetails.R.id.buttonWarranty
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r7 = r1
            com.google.android.material.button.MaterialButton r7 = (com.google.android.material.button.MaterialButton) r7
            if (r7 == 0) goto L_0x005e
            int r0 = com.blueair.devicedetails.R.id.recycler_view_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r8 = r1
            androidx.core.widget.NestedScrollView r8 = (androidx.core.widget.NestedScrollView) r8
            if (r8 == 0) goto L_0x005e
            int r0 = com.blueair.devicedetails.R.id.recyclerViewSettingsContainer
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r9 = r1
            com.blueair.viewcore.view.ShadowedRecyclerViewLayout r9 = (com.blueair.viewcore.view.ShadowedRecyclerViewLayout) r9
            if (r9 == 0) goto L_0x005e
            int r0 = com.blueair.devicedetails.R.id.separator
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r10 == 0) goto L_0x005e
            int r0 = com.blueair.devicedetails.R.id.tv_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            androidx.appcompat.widget.AppCompatTextView r11 = (androidx.appcompat.widget.AppCompatTextView) r11
            if (r11 == 0) goto L_0x005e
            com.blueair.devicedetails.databinding.ActivityDeviceSettingsBinding r2 = new com.blueair.devicedetails.databinding.ActivityDeviceSettingsBinding
            r3 = r12
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r2
        L_0x005e:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.ActivityDeviceSettingsBinding.bind(android.view.View):com.blueair.devicedetails.databinding.ActivityDeviceSettingsBinding");
    }
}
