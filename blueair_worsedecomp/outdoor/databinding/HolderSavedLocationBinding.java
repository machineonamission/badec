package com.blueair.outdoor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.blueair.outdoor.R;
import com.blueair.viewcore.view.AllQualityStatusView;

public final class HolderSavedLocationBinding implements ViewBinding {
    public final ConstraintLayout addressContainer;
    public final View aqiIcon;
    public final TextView aqiSeverity;
    public final TextView aqiValue;
    public final ConstraintLayout assignContainer;
    public final TextView assignProduct;
    public final TextView assignedProducts;
    public final Barrier barrier;
    public final Guideline bottomGuideline;
    public final TextView coordinateMismatch;
    public final ImageButton delete;
    public final Guideline leftGuideline;
    public final ConstraintLayout noDataContainer;
    public final TextView noDataTextCaption;
    public final TextView noDataTextHeader;
    public final TextView primaryText;
    public final FrameLayout progressBar;
    public final AllQualityStatusView qualityContainers;
    public final Guideline rightGuideline;
    private final ConstraintLayout rootView;
    public final Button saveBtn;
    public final ConstraintLayout saveContainer;
    public final TextView secondaryText;
    public final Guideline topGuideline;

    private HolderSavedLocationBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, View view, TextView textView, TextView textView2, ConstraintLayout constraintLayout3, TextView textView3, TextView textView4, Barrier barrier2, Guideline guideline, TextView textView5, ImageButton imageButton, Guideline guideline2, ConstraintLayout constraintLayout4, TextView textView6, TextView textView7, TextView textView8, FrameLayout frameLayout, AllQualityStatusView allQualityStatusView, Guideline guideline3, Button button, ConstraintLayout constraintLayout5, TextView textView9, Guideline guideline4) {
        this.rootView = constraintLayout;
        this.addressContainer = constraintLayout2;
        this.aqiIcon = view;
        this.aqiSeverity = textView;
        this.aqiValue = textView2;
        this.assignContainer = constraintLayout3;
        this.assignProduct = textView3;
        this.assignedProducts = textView4;
        this.barrier = barrier2;
        this.bottomGuideline = guideline;
        this.coordinateMismatch = textView5;
        this.delete = imageButton;
        this.leftGuideline = guideline2;
        this.noDataContainer = constraintLayout4;
        this.noDataTextCaption = textView6;
        this.noDataTextHeader = textView7;
        this.primaryText = textView8;
        this.progressBar = frameLayout;
        this.qualityContainers = allQualityStatusView;
        this.rightGuideline = guideline3;
        this.saveBtn = button;
        this.saveContainer = constraintLayout5;
        this.secondaryText = textView9;
        this.topGuideline = guideline4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderSavedLocationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderSavedLocationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_saved_location, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.blueair.outdoor.R.id.aqi_icon;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.outdoor.databinding.HolderSavedLocationBinding bind(android.view.View r28) {
        /*
            r0 = r28
            int r1 = com.blueair.outdoor.R.id.address_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.aqi_icon
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r6 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.aqi_severity
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.aqi_value
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.assign_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            if (r9 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.assign_product
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.assigned_products
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.barrier
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.constraintlayout.widget.Barrier r12 = (androidx.constraintlayout.widget.Barrier) r12
            if (r12 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.bottom_guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.constraintlayout.widget.Guideline r13 = (androidx.constraintlayout.widget.Guideline) r13
            if (r13 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.coordinate_mismatch
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.delete
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.ImageButton r15 = (android.widget.ImageButton) r15
            if (r15 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.left_guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.constraintlayout.widget.Guideline r16 = (androidx.constraintlayout.widget.Guideline) r16
            if (r16 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.no_data_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            androidx.constraintlayout.widget.ConstraintLayout r17 = (androidx.constraintlayout.widget.ConstraintLayout) r17
            if (r17 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.no_data_text_caption
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.no_data_text_header
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.primary_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.progress_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.FrameLayout r21 = (android.widget.FrameLayout) r21
            if (r21 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.quality_containers
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            com.blueair.viewcore.view.AllQualityStatusView r22 = (com.blueair.viewcore.view.AllQualityStatusView) r22
            if (r22 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.right_guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            androidx.constraintlayout.widget.Guideline r23 = (androidx.constraintlayout.widget.Guideline) r23
            if (r23 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.save_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.Button r24 = (android.widget.Button) r24
            if (r24 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.save_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            androidx.constraintlayout.widget.ConstraintLayout r25 = (androidx.constraintlayout.widget.ConstraintLayout) r25
            if (r25 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.secondary_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            android.widget.TextView r26 = (android.widget.TextView) r26
            if (r26 == 0) goto L_0x0111
            int r1 = com.blueair.outdoor.R.id.top_guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            androidx.constraintlayout.widget.Guideline r27 = (androidx.constraintlayout.widget.Guideline) r27
            if (r27 == 0) goto L_0x0111
            com.blueair.outdoor.databinding.HolderSavedLocationBinding r3 = new com.blueair.outdoor.databinding.HolderSavedLocationBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return r3
        L_0x0111:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.databinding.HolderSavedLocationBinding.bind(android.view.View):com.blueair.outdoor.databinding.HolderSavedLocationBinding");
    }
}
