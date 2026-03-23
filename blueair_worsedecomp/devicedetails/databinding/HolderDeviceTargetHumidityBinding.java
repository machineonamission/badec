package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import com.blueair.viewcore.view.SwitchCompat;

public final class HolderDeviceTargetHumidityBinding implements ViewBinding {
    public final View clickView;
    public final ConstraintLayout contentContainer;
    public final SwitchCompat expendSwitch;
    public final Group expendedContent;
    public final ImageView ivInfo;
    public final ImageView leadingIcon;
    public final TextView progressText;
    private final ConstraintLayout rootView;
    public final AccessibleSeekBar seekbar;
    public final View separatorEnd;
    public final View separatorStart;
    public final TextView title;
    public final TextView tvProgress0;
    public final TextView tvProgress100;

    private HolderDeviceTargetHumidityBinding(ConstraintLayout constraintLayout, View view, ConstraintLayout constraintLayout2, SwitchCompat switchCompat, Group group, ImageView imageView, ImageView imageView2, TextView textView, AccessibleSeekBar accessibleSeekBar, View view2, View view3, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.clickView = view;
        this.contentContainer = constraintLayout2;
        this.expendSwitch = switchCompat;
        this.expendedContent = group;
        this.ivInfo = imageView;
        this.leadingIcon = imageView2;
        this.progressText = textView;
        this.seekbar = accessibleSeekBar;
        this.separatorEnd = view2;
        this.separatorStart = view3;
        this.title = textView2;
        this.tvProgress0 = textView3;
        this.tvProgress100 = textView4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceTargetHumidityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceTargetHumidityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_target_humidity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_end;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_start;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.HolderDeviceTargetHumidityBinding bind(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.blueair.devicedetails.R.id.click_view
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r4 == 0) goto L_0x0088
            r3 = r0
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            int r1 = com.blueair.devicedetails.R.id.expend_switch
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.blueair.viewcore.view.SwitchCompat r6 = (com.blueair.viewcore.view.SwitchCompat) r6
            if (r6 == 0) goto L_0x0088
            int r1 = com.blueair.devicedetails.R.id.expended_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.constraintlayout.widget.Group r7 = (androidx.constraintlayout.widget.Group) r7
            if (r7 == 0) goto L_0x0088
            int r1 = com.blueair.devicedetails.R.id.iv_info
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0088
            int r1 = com.blueair.devicedetails.R.id.leading_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0088
            int r1 = com.blueair.devicedetails.R.id.progress_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0088
            int r1 = com.blueair.devicedetails.R.id.seekbar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            com.blueair.viewcore.view.AccessibleSeekBar r11 = (com.blueair.viewcore.view.AccessibleSeekBar) r11
            if (r11 == 0) goto L_0x0088
            int r1 = com.blueair.devicedetails.R.id.separator_end
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r12 == 0) goto L_0x0088
            int r1 = com.blueair.devicedetails.R.id.separator_start
            android.view.View r13 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r13 == 0) goto L_0x0088
            int r1 = com.blueair.devicedetails.R.id.title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0088
            int r1 = com.blueair.devicedetails.R.id.tv_progress_0
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0088
            int r1 = com.blueair.devicedetails.R.id.tv_progress_100
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x0088
            com.blueair.devicedetails.databinding.HolderDeviceTargetHumidityBinding r2 = new com.blueair.devicedetails.databinding.HolderDeviceTargetHumidityBinding
            r5 = r3
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r2
        L_0x0088:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.HolderDeviceTargetHumidityBinding.bind(android.view.View):com.blueair.devicedetails.databinding.HolderDeviceTargetHumidityBinding");
    }
}
