package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;

public final class HolderDeviceMainModeButtonsBinding implements ViewBinding {
    public final TextView heatHint;
    public final RecyclerView mainModeButtons;
    private final LinearLayout rootView;
    public final View separator;
    public final RecyclerView subModeButtons;

    private HolderDeviceMainModeButtonsBinding(LinearLayout linearLayout, TextView textView, RecyclerView recyclerView, View view, RecyclerView recyclerView2) {
        this.rootView = linearLayout;
        this.heatHint = textView;
        this.mainModeButtons = recyclerView;
        this.separator = view;
        this.subModeButtons = recyclerView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceMainModeButtonsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceMainModeButtonsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_main_mode_buttons, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.blueair.devicedetails.R.id.separator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.HolderDeviceMainModeButtonsBinding bind(android.view.View r8) {
        /*
            int r0 = com.blueair.devicedetails.R.id.heat_hint
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0032
            int r0 = com.blueair.devicedetails.R.id.main_mode_buttons
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r5 = r1
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            if (r5 == 0) goto L_0x0032
            int r0 = com.blueair.devicedetails.R.id.separator
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r6 == 0) goto L_0x0032
            int r0 = com.blueair.devicedetails.R.id.sub_mode_buttons
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r7 = r1
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            if (r7 == 0) goto L_0x0032
            com.blueair.devicedetails.databinding.HolderDeviceMainModeButtonsBinding r2 = new com.blueair.devicedetails.databinding.HolderDeviceMainModeButtonsBinding
            r3 = r8
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2.<init>(r3, r4, r5, r6, r7)
            return r2
        L_0x0032:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.HolderDeviceMainModeButtonsBinding.bind(android.view.View):com.blueair.devicedetails.databinding.HolderDeviceMainModeButtonsBinding");
    }
}
