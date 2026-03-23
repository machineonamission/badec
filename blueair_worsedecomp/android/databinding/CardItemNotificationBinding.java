package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blueair.android.R;
import com.google.android.material.button.MaterialButton;

public final class CardItemNotificationBinding implements ViewBinding {
    public final MaterialButton btnAdjust;
    public final MaterialButton btnBuyFilter;
    public final MaterialButton btnReplaceFilter;
    public final AppCompatImageView ivClose;
    public final AppCompatImageView ivDevice;
    public final View ivIndicator;
    private final ConstraintLayout rootView;
    public final AppCompatTextView tvDeviceName;
    public final AppCompatTextView tvMessage;
    public final AppCompatTextView tvState;

    private CardItemNotificationBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, View view, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.rootView = constraintLayout;
        this.btnAdjust = materialButton;
        this.btnBuyFilter = materialButton2;
        this.btnReplaceFilter = materialButton3;
        this.ivClose = appCompatImageView;
        this.ivDevice = appCompatImageView2;
        this.ivIndicator = view;
        this.tvDeviceName = appCompatTextView;
        this.tvMessage = appCompatTextView2;
        this.tvState = appCompatTextView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CardItemNotificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CardItemNotificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.card_item_notification, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r0 = com.blueair.android.R.id.iv_indicator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.android.databinding.CardItemNotificationBinding bind(android.view.View r13) {
        /*
            int r0 = com.blueair.android.R.id.btn_adjust
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            com.google.android.material.button.MaterialButton r4 = (com.google.android.material.button.MaterialButton) r4
            if (r4 == 0) goto L_0x0069
            int r0 = com.blueair.android.R.id.btn_buyFilter
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            com.google.android.material.button.MaterialButton r5 = (com.google.android.material.button.MaterialButton) r5
            if (r5 == 0) goto L_0x0069
            int r0 = com.blueair.android.R.id.btn_replaceFilter
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            com.google.android.material.button.MaterialButton r6 = (com.google.android.material.button.MaterialButton) r6
            if (r6 == 0) goto L_0x0069
            int r0 = com.blueair.android.R.id.iv_close
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            androidx.appcompat.widget.AppCompatImageView r7 = (androidx.appcompat.widget.AppCompatImageView) r7
            if (r7 == 0) goto L_0x0069
            int r0 = com.blueair.android.R.id.iv_device
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            androidx.appcompat.widget.AppCompatImageView r8 = (androidx.appcompat.widget.AppCompatImageView) r8
            if (r8 == 0) goto L_0x0069
            int r0 = com.blueair.android.R.id.iv_indicator
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r9 == 0) goto L_0x0069
            int r0 = com.blueair.android.R.id.tv_deviceName
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r10 = r1
            androidx.appcompat.widget.AppCompatTextView r10 = (androidx.appcompat.widget.AppCompatTextView) r10
            if (r10 == 0) goto L_0x0069
            int r0 = com.blueair.android.R.id.tv_message
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            androidx.appcompat.widget.AppCompatTextView r11 = (androidx.appcompat.widget.AppCompatTextView) r11
            if (r11 == 0) goto L_0x0069
            int r0 = com.blueair.android.R.id.tv_state
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r12 = r1
            androidx.appcompat.widget.AppCompatTextView r12 = (androidx.appcompat.widget.AppCompatTextView) r12
            if (r12 == 0) goto L_0x0069
            com.blueair.android.databinding.CardItemNotificationBinding r2 = new com.blueair.android.databinding.CardItemNotificationBinding
            r3 = r13
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r2
        L_0x0069:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.databinding.CardItemNotificationBinding.bind(android.view.View):com.blueair.android.databinding.CardItemNotificationBinding");
    }
}
