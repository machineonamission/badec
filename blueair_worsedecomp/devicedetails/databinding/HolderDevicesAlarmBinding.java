package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;

public final class HolderDevicesAlarmBinding implements ViewBinding {
    public final ImageView ivDevice;
    public final ImageView ivMore;
    public final HolderDeviceOfflineV2Binding layoutOffline;
    private final ConstraintLayout rootView;
    public final RecyclerView rvAlarms;
    public final TextView tvDeviceName;

    private HolderDevicesAlarmBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, HolderDeviceOfflineV2Binding holderDeviceOfflineV2Binding, RecyclerView recyclerView, TextView textView) {
        this.rootView = constraintLayout;
        this.ivDevice = imageView;
        this.ivMore = imageView2;
        this.layoutOffline = holderDeviceOfflineV2Binding;
        this.rvAlarms = recyclerView;
        this.tvDeviceName = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDevicesAlarmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDevicesAlarmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_devices_alarm, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.blueair.devicedetails.R.id.layout_offline;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.HolderDevicesAlarmBinding bind(android.view.View r9) {
        /*
            int r0 = com.blueair.devicedetails.R.id.iv_device
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0041
            int r0 = com.blueair.devicedetails.R.id.iv_more
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0041
            int r0 = com.blueair.devicedetails.R.id.layout_offline
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r1 == 0) goto L_0x0041
            com.blueair.devicedetails.databinding.HolderDeviceOfflineV2Binding r6 = com.blueair.devicedetails.databinding.HolderDeviceOfflineV2Binding.bind(r1)
            int r0 = com.blueair.devicedetails.R.id.rv_alarms
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            if (r7 == 0) goto L_0x0041
            int r0 = com.blueair.devicedetails.R.id.tv_deviceName
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0041
            com.blueair.devicedetails.databinding.HolderDevicesAlarmBinding r2 = new com.blueair.devicedetails.databinding.HolderDevicesAlarmBinding
            r3 = r9
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r2
        L_0x0041:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.HolderDevicesAlarmBinding.bind(android.view.View):com.blueair.devicedetails.databinding.HolderDevicesAlarmBinding");
    }
}
