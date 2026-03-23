package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.R;
import com.dd.ShadowLayout;

public final class HolderLegacyDeviceEntryBinding implements ViewBinding {
    public final ConstraintLayout clRoot;
    public final LayoutLegacyDeviceBinding layoutAware;
    public final LayoutLegacyDeviceBinding layoutClassic;
    public final LayoutLegacyDeviceBinding layoutIcp;
    public final LayoutLegacyDeviceBinding layoutSense;
    public final TextView name;
    private final ShadowLayout rootView;
    public final ShadowLayout slRoot;
    public final TextView tvSelect;

    private HolderLegacyDeviceEntryBinding(ShadowLayout shadowLayout, ConstraintLayout constraintLayout, LayoutLegacyDeviceBinding layoutLegacyDeviceBinding, LayoutLegacyDeviceBinding layoutLegacyDeviceBinding2, LayoutLegacyDeviceBinding layoutLegacyDeviceBinding3, LayoutLegacyDeviceBinding layoutLegacyDeviceBinding4, TextView textView, ShadowLayout shadowLayout2, TextView textView2) {
        this.rootView = shadowLayout;
        this.clRoot = constraintLayout;
        this.layoutAware = layoutLegacyDeviceBinding;
        this.layoutClassic = layoutLegacyDeviceBinding2;
        this.layoutIcp = layoutLegacyDeviceBinding3;
        this.layoutSense = layoutLegacyDeviceBinding4;
        this.name = textView;
        this.slRoot = shadowLayout2;
        this.tvSelect = textView2;
    }

    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static HolderLegacyDeviceEntryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderLegacyDeviceEntryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_legacy_device_entry, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.blueair.adddevice.R.id.layout_aware;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.adddevice.databinding.HolderLegacyDeviceEntryBinding bind(android.view.View r12) {
        /*
            int r0 = com.blueair.adddevice.R.id.cl_root
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            if (r4 == 0) goto L_0x005b
            int r0 = com.blueair.adddevice.R.id.layout_aware
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r1 == 0) goto L_0x005b
            com.blueair.adddevice.databinding.LayoutLegacyDeviceBinding r5 = com.blueair.adddevice.databinding.LayoutLegacyDeviceBinding.bind(r1)
            int r0 = com.blueair.adddevice.R.id.layout_classic
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r1 == 0) goto L_0x005b
            com.blueair.adddevice.databinding.LayoutLegacyDeviceBinding r6 = com.blueair.adddevice.databinding.LayoutLegacyDeviceBinding.bind(r1)
            int r0 = com.blueair.adddevice.R.id.layout_icp
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r1 == 0) goto L_0x005b
            com.blueair.adddevice.databinding.LayoutLegacyDeviceBinding r7 = com.blueair.adddevice.databinding.LayoutLegacyDeviceBinding.bind(r1)
            int r0 = com.blueair.adddevice.R.id.layout_sense
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r1 == 0) goto L_0x005b
            com.blueair.adddevice.databinding.LayoutLegacyDeviceBinding r8 = com.blueair.adddevice.databinding.LayoutLegacyDeviceBinding.bind(r1)
            int r0 = com.blueair.adddevice.R.id.name
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x005b
            r3 = r12
            com.dd.ShadowLayout r3 = (com.dd.ShadowLayout) r3
            int r0 = com.blueair.adddevice.R.id.tv_select
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x005b
            com.blueair.adddevice.databinding.HolderLegacyDeviceEntryBinding r2 = new com.blueair.adddevice.databinding.HolderLegacyDeviceEntryBinding
            r10 = r3
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r2
        L_0x005b:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.databinding.HolderLegacyDeviceEntryBinding.bind(android.view.View):com.blueair.adddevice.databinding.HolderLegacyDeviceEntryBinding");
    }
}
