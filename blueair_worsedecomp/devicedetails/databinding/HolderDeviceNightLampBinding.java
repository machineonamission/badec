package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import com.blueair.viewcore.view.SwitchCompat;
import com.dd.ShadowLayout;

public final class HolderDeviceNightLampBinding implements ViewBinding {
    public final View clickView;
    public final ConstraintLayout contentContainer;
    public final SwitchCompat expendSwitch;
    public final Group expendedContent;
    public final ImageView leadingIcon;
    public final TextView progressText;
    private final ShadowLayout rootView;
    public final AccessibleSeekBar seekbar;
    public final View separator0;
    public final View separator100;
    public final ShadowLayout slContainer;
    public final AppCompatTextView title;
    public final TextView tvProgress0;
    public final TextView tvProgress100;

    private HolderDeviceNightLampBinding(ShadowLayout shadowLayout, View view, ConstraintLayout constraintLayout, SwitchCompat switchCompat, Group group, ImageView imageView, TextView textView, AccessibleSeekBar accessibleSeekBar, View view2, View view3, ShadowLayout shadowLayout2, AppCompatTextView appCompatTextView, TextView textView2, TextView textView3) {
        this.rootView = shadowLayout;
        this.clickView = view;
        this.contentContainer = constraintLayout;
        this.expendSwitch = switchCompat;
        this.expendedContent = group;
        this.leadingIcon = imageView;
        this.progressText = textView;
        this.seekbar = accessibleSeekBar;
        this.separator0 = view2;
        this.separator100 = view3;
        this.slContainer = shadowLayout2;
        this.title = appCompatTextView;
        this.tvProgress0 = textView2;
        this.tvProgress100 = textView3;
    }

    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceNightLampBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceNightLampBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_night_lamp, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004c, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0054, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_100;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.HolderDeviceNightLampBinding bind(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.blueair.devicedetails.R.id.click_view
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r4 == 0) goto L_0x0088
            int r1 = com.blueair.devicedetails.R.id.content_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x0088
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
            int r1 = com.blueair.devicedetails.R.id.leading_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0088
            int r1 = com.blueair.devicedetails.R.id.progress_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0088
            int r1 = com.blueair.devicedetails.R.id.seekbar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            com.blueair.viewcore.view.AccessibleSeekBar r10 = (com.blueair.viewcore.view.AccessibleSeekBar) r10
            if (r10 == 0) goto L_0x0088
            int r1 = com.blueair.devicedetails.R.id.separator_0
            android.view.View r11 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r11 == 0) goto L_0x0088
            int r1 = com.blueair.devicedetails.R.id.separator_100
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r12 == 0) goto L_0x0088
            r3 = r0
            com.dd.ShadowLayout r3 = (com.dd.ShadowLayout) r3
            int r1 = com.blueair.devicedetails.R.id.title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            androidx.appcompat.widget.AppCompatTextView r14 = (androidx.appcompat.widget.AppCompatTextView) r14
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
            com.blueair.devicedetails.databinding.HolderDeviceNightLampBinding r2 = new com.blueair.devicedetails.databinding.HolderDeviceNightLampBinding
            r13 = r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.HolderDeviceNightLampBinding.bind(android.view.View):com.blueair.devicedetails.databinding.HolderDeviceNightLampBinding");
    }
}
