package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;

public final class HolderDeviceGermShieldStatusBinding implements ViewBinding {
    public final TextView attributeTitle;
    public final AppCompatImageView germshieldIcon;
    private final ConstraintLayout rootView;
    public final View separator;

    private HolderDeviceGermShieldStatusBinding(ConstraintLayout constraintLayout, TextView textView, AppCompatImageView appCompatImageView, View view) {
        this.rootView = constraintLayout;
        this.attributeTitle = textView;
        this.germshieldIcon = appCompatImageView;
        this.separator = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceGermShieldStatusBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceGermShieldStatusBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_germ_shield_status, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = com.blueair.devicedetails.R.id.separator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.HolderDeviceGermShieldStatusBinding bind(android.view.View r4) {
        /*
            int r0 = com.blueair.devicedetails.R.id.attribute_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0024
            int r0 = com.blueair.devicedetails.R.id.germshield_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            androidx.appcompat.widget.AppCompatImageView r2 = (androidx.appcompat.widget.AppCompatImageView) r2
            if (r2 == 0) goto L_0x0024
            int r0 = com.blueair.devicedetails.R.id.separator
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            if (r3 == 0) goto L_0x0024
            com.blueair.devicedetails.databinding.HolderDeviceGermShieldStatusBinding r0 = new com.blueair.devicedetails.databinding.HolderDeviceGermShieldStatusBinding
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r0.<init>(r4, r1, r2, r3)
            return r0
        L_0x0024:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.HolderDeviceGermShieldStatusBinding.bind(android.view.View):com.blueair.devicedetails.databinding.HolderDeviceGermShieldStatusBinding");
    }
}
