package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SeekProgressBar;

public final class HolderDeviceDisinfectionStatusBinding implements ViewBinding {
    public final TextView attributeTitle;
    public final TextView disinfectionLeftTimeView;
    public final SeekProgressBar progress;
    private final ConstraintLayout rootView;
    public final View separator;

    private HolderDeviceDisinfectionStatusBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, SeekProgressBar seekProgressBar, View view) {
        this.rootView = constraintLayout;
        this.attributeTitle = textView;
        this.disinfectionLeftTimeView = textView2;
        this.progress = seekProgressBar;
        this.separator = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceDisinfectionStatusBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceDisinfectionStatusBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_disinfection_status, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.blueair.devicedetails.R.id.separator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.HolderDeviceDisinfectionStatusBinding bind(android.view.View r8) {
        /*
            int r0 = com.blueair.devicedetails.R.id.attribute_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0032
            int r0 = com.blueair.devicedetails.R.id.disinfection_left_time_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0032
            int r0 = com.blueair.devicedetails.R.id.progress
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r6 = r1
            com.blueair.viewcore.view.SeekProgressBar r6 = (com.blueair.viewcore.view.SeekProgressBar) r6
            if (r6 == 0) goto L_0x0032
            int r0 = com.blueair.devicedetails.R.id.separator
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r7 == 0) goto L_0x0032
            com.blueair.devicedetails.databinding.HolderDeviceDisinfectionStatusBinding r2 = new com.blueair.devicedetails.databinding.HolderDeviceDisinfectionStatusBinding
            r3 = r8
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.HolderDeviceDisinfectionStatusBinding.bind(android.view.View):com.blueair.devicedetails.databinding.HolderDeviceDisinfectionStatusBinding");
    }
}
