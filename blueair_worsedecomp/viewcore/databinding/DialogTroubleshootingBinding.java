package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;

public final class DialogTroubleshootingBinding implements ViewBinding {
    public final MaterialButton btnTryAgain;
    public final AppCompatImageButton closeButton;
    public final LinearLayout llContainer;
    public final NestedScrollView nsvContainer;
    private final LinearLayout rootView;
    public final RecyclerView rvList;
    public final AppCompatTextView screenTitle;
    public final AppCompatTextView tvCantSeeMsg;
    public final AppCompatTextView tvFooter;
    public final AppCompatTextView tvHeader;
    public final View vTop;

    private DialogTroubleshootingBinding(LinearLayout linearLayout, MaterialButton materialButton, AppCompatImageButton appCompatImageButton, LinearLayout linearLayout2, NestedScrollView nestedScrollView, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, View view) {
        this.rootView = linearLayout;
        this.btnTryAgain = materialButton;
        this.closeButton = appCompatImageButton;
        this.llContainer = linearLayout2;
        this.nsvContainer = nestedScrollView;
        this.rvList = recyclerView;
        this.screenTitle = appCompatTextView;
        this.tvCantSeeMsg = appCompatTextView2;
        this.tvFooter = appCompatTextView3;
        this.tvHeader = appCompatTextView4;
        this.vTop = view;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogTroubleshootingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogTroubleshootingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_troubleshooting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        r0 = com.blueair.viewcore.R.id.v_top;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.viewcore.databinding.DialogTroubleshootingBinding bind(android.view.View r14) {
        /*
            int r0 = com.blueair.viewcore.R.id.btn_tryAgain
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r4 = r1
            com.google.android.material.button.MaterialButton r4 = (com.google.android.material.button.MaterialButton) r4
            if (r4 == 0) goto L_0x0074
            int r0 = com.blueair.viewcore.R.id.close_button
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r5 = r1
            androidx.appcompat.widget.AppCompatImageButton r5 = (androidx.appcompat.widget.AppCompatImageButton) r5
            if (r5 == 0) goto L_0x0074
            int r0 = com.blueair.viewcore.R.id.ll_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r6 = r1
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x0074
            int r0 = com.blueair.viewcore.R.id.nsv_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r7 = r1
            androidx.core.widget.NestedScrollView r7 = (androidx.core.widget.NestedScrollView) r7
            if (r7 == 0) goto L_0x0074
            int r0 = com.blueair.viewcore.R.id.rv_list
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r8 = r1
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            if (r8 == 0) goto L_0x0074
            int r0 = com.blueair.viewcore.R.id.screen_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r9 = r1
            androidx.appcompat.widget.AppCompatTextView r9 = (androidx.appcompat.widget.AppCompatTextView) r9
            if (r9 == 0) goto L_0x0074
            int r0 = com.blueair.viewcore.R.id.tv_cantSeeMsg
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r10 = r1
            androidx.appcompat.widget.AppCompatTextView r10 = (androidx.appcompat.widget.AppCompatTextView) r10
            if (r10 == 0) goto L_0x0074
            int r0 = com.blueair.viewcore.R.id.tv_footer
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r11 = r1
            androidx.appcompat.widget.AppCompatTextView r11 = (androidx.appcompat.widget.AppCompatTextView) r11
            if (r11 == 0) goto L_0x0074
            int r0 = com.blueair.viewcore.R.id.tv_header
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r12 = r1
            androidx.appcompat.widget.AppCompatTextView r12 = (androidx.appcompat.widget.AppCompatTextView) r12
            if (r12 == 0) goto L_0x0074
            int r0 = com.blueair.viewcore.R.id.v_top
            android.view.View r13 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            if (r13 == 0) goto L_0x0074
            com.blueair.viewcore.databinding.DialogTroubleshootingBinding r2 = new com.blueair.viewcore.databinding.DialogTroubleshootingBinding
            r3 = r14
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r2
        L_0x0074:
            android.content.res.Resources r14 = r14.getResources()
            java.lang.String r14 = r14.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r14 = r1.concat(r14)
            r0.<init>(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.viewcore.databinding.DialogTroubleshootingBinding.bind(android.view.View):com.blueair.viewcore.databinding.DialogTroubleshootingBinding");
    }
}
