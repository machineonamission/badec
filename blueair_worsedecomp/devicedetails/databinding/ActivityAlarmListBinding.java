package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AbsorbInsetFrameLayout;
import com.blueair.viewcore.view.SimpleStatusBar;
import com.google.android.material.button.MaterialButton;

public final class ActivityAlarmListBinding implements ViewBinding {
    public final LinearLayout bottomBar;
    public final AppCompatImageButton btnBack;
    public final MaterialButton btnCreate;
    public final AppCompatImageButton btnMore;
    public final ConstraintLayout contentContainer;
    public final ConstraintLayout emptyContainer;
    public final AppCompatImageButton epBtnBack;
    public final AppCompatImageButton epBtnClose;
    public final MaterialButton epBtnCreate;
    public final TextView epTvAlarmDesc;
    public final AppCompatTextView epTvTitle;
    private final AbsorbInsetFrameLayout rootView;
    public final RecyclerView rvList;
    public final View separator;
    public final SimpleStatusBar statusBar;
    public final SimpleStatusBar statusBarEmpty;
    public final AppCompatTextView tvSubtitle;
    public final AppCompatTextView tvTitle;

    private ActivityAlarmListBinding(AbsorbInsetFrameLayout absorbInsetFrameLayout, LinearLayout linearLayout, AppCompatImageButton appCompatImageButton, MaterialButton materialButton, AppCompatImageButton appCompatImageButton2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageButton appCompatImageButton3, AppCompatImageButton appCompatImageButton4, MaterialButton materialButton2, TextView textView, AppCompatTextView appCompatTextView, RecyclerView recyclerView, View view, SimpleStatusBar simpleStatusBar, SimpleStatusBar simpleStatusBar2, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.rootView = absorbInsetFrameLayout;
        this.bottomBar = linearLayout;
        this.btnBack = appCompatImageButton;
        this.btnCreate = materialButton;
        this.btnMore = appCompatImageButton2;
        this.contentContainer = constraintLayout;
        this.emptyContainer = constraintLayout2;
        this.epBtnBack = appCompatImageButton3;
        this.epBtnClose = appCompatImageButton4;
        this.epBtnCreate = materialButton2;
        this.epTvAlarmDesc = textView;
        this.epTvTitle = appCompatTextView;
        this.rvList = recyclerView;
        this.separator = view;
        this.statusBar = simpleStatusBar;
        this.statusBarEmpty = simpleStatusBar2;
        this.tvSubtitle = appCompatTextView2;
        this.tvTitle = appCompatTextView3;
    }

    public AbsorbInsetFrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAlarmListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityAlarmListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_alarm_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
        r1 = com.blueair.devicedetails.R.id.separator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.ActivityAlarmListBinding bind(android.view.View r22) {
        /*
            r0 = r22
            int r1 = com.blueair.devicedetails.R.id.bottom_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            if (r5 == 0) goto L_0x00c8
            int r1 = com.blueair.devicedetails.R.id.btnBack
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.appcompat.widget.AppCompatImageButton r6 = (androidx.appcompat.widget.AppCompatImageButton) r6
            if (r6 == 0) goto L_0x00c8
            int r1 = com.blueair.devicedetails.R.id.btn_create
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            com.google.android.material.button.MaterialButton r7 = (com.google.android.material.button.MaterialButton) r7
            if (r7 == 0) goto L_0x00c8
            int r1 = com.blueair.devicedetails.R.id.btnMore
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.appcompat.widget.AppCompatImageButton r8 = (androidx.appcompat.widget.AppCompatImageButton) r8
            if (r8 == 0) goto L_0x00c8
            int r1 = com.blueair.devicedetails.R.id.content_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            if (r9 == 0) goto L_0x00c8
            int r1 = com.blueair.devicedetails.R.id.empty_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            if (r10 == 0) goto L_0x00c8
            int r1 = com.blueair.devicedetails.R.id.ep_btn_back
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.appcompat.widget.AppCompatImageButton r11 = (androidx.appcompat.widget.AppCompatImageButton) r11
            if (r11 == 0) goto L_0x00c8
            int r1 = com.blueair.devicedetails.R.id.ep_btn_close
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.appcompat.widget.AppCompatImageButton r12 = (androidx.appcompat.widget.AppCompatImageButton) r12
            if (r12 == 0) goto L_0x00c8
            int r1 = com.blueair.devicedetails.R.id.ep_btn_create
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            com.google.android.material.button.MaterialButton r13 = (com.google.android.material.button.MaterialButton) r13
            if (r13 == 0) goto L_0x00c8
            int r1 = com.blueair.devicedetails.R.id.ep_tv_alarm_desc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00c8
            int r1 = com.blueair.devicedetails.R.id.ep_tv_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            androidx.appcompat.widget.AppCompatTextView r15 = (androidx.appcompat.widget.AppCompatTextView) r15
            if (r15 == 0) goto L_0x00c8
            int r1 = com.blueair.devicedetails.R.id.rv_list
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.recyclerview.widget.RecyclerView r16 = (androidx.recyclerview.widget.RecyclerView) r16
            if (r16 == 0) goto L_0x00c8
            int r1 = com.blueair.devicedetails.R.id.separator
            android.view.View r17 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r17 == 0) goto L_0x00c8
            int r1 = com.blueair.devicedetails.R.id.status_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            com.blueair.viewcore.view.SimpleStatusBar r18 = (com.blueair.viewcore.view.SimpleStatusBar) r18
            if (r18 == 0) goto L_0x00c8
            int r1 = com.blueair.devicedetails.R.id.status_bar_empty
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            com.blueair.viewcore.view.SimpleStatusBar r19 = (com.blueair.viewcore.view.SimpleStatusBar) r19
            if (r19 == 0) goto L_0x00c8
            int r1 = com.blueair.devicedetails.R.id.tv_subtitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            androidx.appcompat.widget.AppCompatTextView r20 = (androidx.appcompat.widget.AppCompatTextView) r20
            if (r20 == 0) goto L_0x00c8
            int r1 = com.blueair.devicedetails.R.id.tv_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            androidx.appcompat.widget.AppCompatTextView r21 = (androidx.appcompat.widget.AppCompatTextView) r21
            if (r21 == 0) goto L_0x00c8
            com.blueair.devicedetails.databinding.ActivityAlarmListBinding r3 = new com.blueair.devicedetails.databinding.ActivityAlarmListBinding
            r4 = r0
            com.blueair.viewcore.view.AbsorbInsetFrameLayout r4 = (com.blueair.viewcore.view.AbsorbInsetFrameLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r3
        L_0x00c8:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.ActivityAlarmListBinding.bind(android.view.View):com.blueair.devicedetails.databinding.ActivityAlarmListBinding");
    }
}
