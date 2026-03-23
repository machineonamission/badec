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

public final class HolderDeviceBrightnessV2Binding implements ViewBinding {
    public final View clickView;
    public final ConstraintLayout contentContainer;
    public final SwitchCompat expendSwitch;
    public final Group expendedContent;
    public final ImageView leadingIcon;
    public final TextView progressText;
    private final ConstraintLayout rootView;
    public final AccessibleSeekBar seekbar;
    public final View separatorEnd;
    public final View separatorStart;
    public final TextView title;
    public final TextView tvProgress0;
    public final TextView tvProgress100;

    private HolderDeviceBrightnessV2Binding(ConstraintLayout constraintLayout, View view, ConstraintLayout constraintLayout2, SwitchCompat switchCompat, Group group, ImageView imageView, TextView textView, AccessibleSeekBar accessibleSeekBar, View view2, View view3, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.clickView = view;
        this.contentContainer = constraintLayout2;
        this.expendSwitch = switchCompat;
        this.expendedContent = group;
        this.leadingIcon = imageView;
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

    public static HolderDeviceBrightnessV2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceBrightnessV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_brightness_v2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r0 = com.blueair.devicedetails.R.id.separator_end;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        r0 = com.blueair.devicedetails.R.id.separator_start;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.HolderDeviceBrightnessV2Binding bind(android.view.View r15) {
        /*
            int r0 = com.blueair.devicedetails.R.id.click_view
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            if (r3 == 0) goto L_0x007a
            r2 = r15
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            int r0 = com.blueair.devicedetails.R.id.expend_switch
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r5 = r1
            com.blueair.viewcore.view.SwitchCompat r5 = (com.blueair.viewcore.view.SwitchCompat) r5
            if (r5 == 0) goto L_0x007a
            int r0 = com.blueair.devicedetails.R.id.expended_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r6 = r1
            androidx.constraintlayout.widget.Group r6 = (androidx.constraintlayout.widget.Group) r6
            if (r6 == 0) goto L_0x007a
            int r0 = com.blueair.devicedetails.R.id.leading_icon
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x007a
            int r0 = com.blueair.devicedetails.R.id.progress_text
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x007a
            int r0 = com.blueair.devicedetails.R.id.seekbar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r9 = r1
            com.blueair.viewcore.view.AccessibleSeekBar r9 = (com.blueair.viewcore.view.AccessibleSeekBar) r9
            if (r9 == 0) goto L_0x007a
            int r0 = com.blueair.devicedetails.R.id.separator_end
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            if (r10 == 0) goto L_0x007a
            int r0 = com.blueair.devicedetails.R.id.separator_start
            android.view.View r11 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            if (r11 == 0) goto L_0x007a
            int r0 = com.blueair.devicedetails.R.id.title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x007a
            int r0 = com.blueair.devicedetails.R.id.tv_progress_0
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r13 = r1
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x007a
            int r0 = com.blueair.devicedetails.R.id.tv_progress_100
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r14 = r1
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x007a
            com.blueair.devicedetails.databinding.HolderDeviceBrightnessV2Binding r1 = new com.blueair.devicedetails.databinding.HolderDeviceBrightnessV2Binding
            r4 = r2
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r1
        L_0x007a:
            android.content.res.Resources r15 = r15.getResources()
            java.lang.String r15 = r15.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r15 = r1.concat(r15)
            r0.<init>(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.HolderDeviceBrightnessV2Binding.bind(android.view.View):com.blueair.devicedetails.databinding.HolderDeviceBrightnessV2Binding");
    }
}
