package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ShadowedRecyclerViewLayout;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentDeviceSetScheduleModeV2Binding implements ViewBinding {
    public final LinearLayout bottomBar;
    public final AppCompatImageView btnClose;
    public final MaterialButton btnDone;
    public final ConstraintLayout contentContainer;
    private final FrameLayout rootView;
    public final ShadowedRecyclerViewLayout rvControlGroup;
    public final RecyclerView rvModeButtons;
    public final NestedScrollView scrollable;
    public final View separator;
    public final ShadowLayout standbyContainer;
    public final ImageView standbyIcon;
    public final TextView standbyText;
    public final TextView title;

    private DialogfragmentDeviceSetScheduleModeV2Binding(FrameLayout frameLayout, LinearLayout linearLayout, AppCompatImageView appCompatImageView, MaterialButton materialButton, ConstraintLayout constraintLayout, ShadowedRecyclerViewLayout shadowedRecyclerViewLayout, RecyclerView recyclerView, NestedScrollView nestedScrollView, View view, ShadowLayout shadowLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.bottomBar = linearLayout;
        this.btnClose = appCompatImageView;
        this.btnDone = materialButton;
        this.contentContainer = constraintLayout;
        this.rvControlGroup = shadowedRecyclerViewLayout;
        this.rvModeButtons = recyclerView;
        this.scrollable = nestedScrollView;
        this.separator = view;
        this.standbyContainer = shadowLayout;
        this.standbyIcon = imageView;
        this.standbyText = textView;
        this.title = textView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogfragmentDeviceSetScheduleModeV2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogfragmentDeviceSetScheduleModeV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_device_set_schedule_mode_v2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        r1 = com.blueair.devicedetails.R.id.separator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.DialogfragmentDeviceSetScheduleModeV2Binding bind(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.blueair.devicedetails.R.id.bottom_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            if (r5 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.btn_close
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.appcompat.widget.AppCompatImageView r6 = (androidx.appcompat.widget.AppCompatImageView) r6
            if (r6 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.btn_done
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            com.google.android.material.button.MaterialButton r7 = (com.google.android.material.button.MaterialButton) r7
            if (r7 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.content_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.rv_control_group
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            com.blueair.viewcore.view.ShadowedRecyclerViewLayout r9 = (com.blueair.viewcore.view.ShadowedRecyclerViewLayout) r9
            if (r9 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.rv_mode_buttons
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            androidx.recyclerview.widget.RecyclerView r10 = (androidx.recyclerview.widget.RecyclerView) r10
            if (r10 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.scrollable
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.core.widget.NestedScrollView r11 = (androidx.core.widget.NestedScrollView) r11
            if (r11 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.separator
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r12 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.standby_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            com.dd.ShadowLayout r13 = (com.dd.ShadowLayout) r13
            if (r13 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.standby_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.standby_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x008d
            com.blueair.devicedetails.databinding.DialogfragmentDeviceSetScheduleModeV2Binding r3 = new com.blueair.devicedetails.databinding.DialogfragmentDeviceSetScheduleModeV2Binding
            r4 = r0
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r3
        L_0x008d:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.DialogfragmentDeviceSetScheduleModeV2Binding.bind(android.view.View):com.blueair.devicedetails.databinding.DialogfragmentDeviceSetScheduleModeV2Binding");
    }
}
