package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;

public final class HolderDeviceHModeButtonsBinding implements ViewBinding {
    public final RecyclerView modeButtons;
    private final FrameLayout rootView;
    public final View separator;
    public final TextView standbyHint;
    public final HolderDeviceNModeButtonBinding standbyModeRoot;

    private HolderDeviceHModeButtonsBinding(FrameLayout frameLayout, RecyclerView recyclerView, View view, TextView textView, HolderDeviceNModeButtonBinding holderDeviceNModeButtonBinding) {
        this.rootView = frameLayout;
        this.modeButtons = recyclerView;
        this.separator = view;
        this.standbyHint = textView;
        this.standbyModeRoot = holderDeviceNModeButtonBinding;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceHModeButtonsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceHModeButtonsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_h_mode_buttons, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.blueair.devicedetails.R.id.separator;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        r0 = com.blueair.devicedetails.R.id.standby_mode_root;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.HolderDeviceHModeButtonsBinding bind(android.view.View r8) {
        /*
            int r0 = com.blueair.devicedetails.R.id.mode_buttons
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            if (r4 == 0) goto L_0x0033
            int r0 = com.blueair.devicedetails.R.id.separator
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r5 == 0) goto L_0x0033
            int r0 = com.blueair.devicedetails.R.id.standby_hint
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0033
            int r0 = com.blueair.devicedetails.R.id.standby_mode_root
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r1 == 0) goto L_0x0033
            com.blueair.devicedetails.databinding.HolderDeviceNModeButtonBinding r7 = com.blueair.devicedetails.databinding.HolderDeviceNModeButtonBinding.bind(r1)
            com.blueair.devicedetails.databinding.HolderDeviceHModeButtonsBinding r2 = new com.blueair.devicedetails.databinding.HolderDeviceHModeButtonsBinding
            r3 = r8
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            r2.<init>(r3, r4, r5, r6, r7)
            return r2
        L_0x0033:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.HolderDeviceHModeButtonsBinding.bind(android.view.View):com.blueair.devicedetails.databinding.HolderDeviceHModeButtonsBinding");
    }
}
