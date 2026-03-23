package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import com.blueair.viewcore.view.SwitchCompat;

public final class HolderDeviceFanspeedV2Binding implements ViewBinding {
    public final ConstraintLayout clIndicator;
    public final View clickView;
    public final ConstraintLayout contentContainer;
    public final LinearLayout etaContainer;
    public final ImageView etaIcon;
    public final TextView etaText;
    public final TextView etaValue;
    public final SwitchCompat expendSwitch;
    public final Group expendedContent;
    public final ImageView leadingIcon;
    public final TextView progressText;
    private final ConstraintLayout rootView;
    public final AccessibleSeekBar seekbar;
    public final View separator0;
    public final View separator1;
    public final View separator2;
    public final View separator3;
    public final View separator4;
    public final TextView title;
    public final TextView tvProgress0;
    public final TextView tvProgress1;
    public final TextView tvProgress2;
    public final TextView tvProgress3;
    public final TextView tvProgress4;

    private HolderDeviceFanspeedV2Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, View view, ConstraintLayout constraintLayout3, LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, SwitchCompat switchCompat, Group group, ImageView imageView2, TextView textView3, AccessibleSeekBar accessibleSeekBar, View view2, View view3, View view4, View view5, View view6, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = constraintLayout;
        this.clIndicator = constraintLayout2;
        this.clickView = view;
        this.contentContainer = constraintLayout3;
        this.etaContainer = linearLayout;
        this.etaIcon = imageView;
        this.etaText = textView;
        this.etaValue = textView2;
        this.expendSwitch = switchCompat;
        this.expendedContent = group;
        this.leadingIcon = imageView2;
        this.progressText = textView3;
        this.seekbar = accessibleSeekBar;
        this.separator0 = view2;
        this.separator1 = view3;
        this.separator2 = view4;
        this.separator3 = view5;
        this.separator4 = view6;
        this.title = textView4;
        this.tvProgress0 = textView5;
        this.tvProgress1 = textView6;
        this.tvProgress2 = textView7;
        this.tvProgress3 = textView8;
        this.tvProgress4 = textView9;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceFanspeedV2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceFanspeedV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_fanspeed_v2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007c, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008c, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0094, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.blueair.devicedetails.R.id.click_view;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009c, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.HolderDeviceFanspeedV2Binding bind(android.view.View r28) {
        /*
            r0 = r28
            int r1 = com.blueair.devicedetails.R.id.cl_indicator
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.click_view
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r6 == 0) goto L_0x00f3
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            int r1 = com.blueair.devicedetails.R.id.eta_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.eta_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.eta_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.eta_value
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.expend_switch
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            com.blueair.viewcore.view.SwitchCompat r12 = (com.blueair.viewcore.view.SwitchCompat) r12
            if (r12 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.expended_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.constraintlayout.widget.Group r13 = (androidx.constraintlayout.widget.Group) r13
            if (r13 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.leading_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.progress_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.seekbar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            com.blueair.viewcore.view.AccessibleSeekBar r16 = (com.blueair.viewcore.view.AccessibleSeekBar) r16
            if (r16 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.separator_0
            android.view.View r17 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r17 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.separator_1
            android.view.View r18 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r18 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.separator_2
            android.view.View r19 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r19 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.separator_3
            android.view.View r20 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r20 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.separator_4
            android.view.View r21 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r21 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.tv_progress_0
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.tv_progress_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.tv_progress_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            android.widget.TextView r25 = (android.widget.TextView) r25
            if (r25 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.tv_progress_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            android.widget.TextView r26 = (android.widget.TextView) r26
            if (r26 == 0) goto L_0x00f3
            int r1 = com.blueair.devicedetails.R.id.tv_progress_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            android.widget.TextView r27 = (android.widget.TextView) r27
            if (r27 == 0) goto L_0x00f3
            com.blueair.devicedetails.databinding.HolderDeviceFanspeedV2Binding r3 = new com.blueair.devicedetails.databinding.HolderDeviceFanspeedV2Binding
            r7 = r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return r3
        L_0x00f3:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.HolderDeviceFanspeedV2Binding.bind(android.view.View):com.blueair.devicedetails.databinding.HolderDeviceFanspeedV2Binding");
    }
}
