package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.github.barteksc.pdfviewer.PDFView;

public final class ActivityUserManualBinding implements ViewBinding {
    public final AppCompatImageButton btnBack;
    public final AppCompatImageButton closeBtn;
    public final PDFView pdfView;
    public final ProgressBlockerView progressView;
    private final ConstraintLayout rootView;
    public final AppCompatTextView title;
    public final AppCompatTextView tvSubtitle;

    private ActivityUserManualBinding(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2, PDFView pDFView, ProgressBlockerView progressBlockerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.rootView = constraintLayout;
        this.btnBack = appCompatImageButton;
        this.closeBtn = appCompatImageButton2;
        this.pdfView = pDFView;
        this.progressView = progressBlockerView;
        this.title = appCompatTextView;
        this.tvSubtitle = appCompatTextView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityUserManualBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityUserManualBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_user_manual, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityUserManualBinding bind(View view) {
        int i = R.id.btnBack;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.close_btn;
            AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
            if (appCompatImageButton2 != null) {
                i = R.id.pdf_view;
                PDFView pDFView = (PDFView) ViewBindings.findChildViewById(view, i);
                if (pDFView != null) {
                    i = R.id.progressView;
                    ProgressBlockerView progressBlockerView = (ProgressBlockerView) ViewBindings.findChildViewById(view, i);
                    if (progressBlockerView != null) {
                        i = R.id.title;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                        if (appCompatTextView != null) {
                            i = R.id.tv_subtitle;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                            if (appCompatTextView2 != null) {
                                return new ActivityUserManualBinding((ConstraintLayout) view, appCompatImageButton, appCompatImageButton2, pDFView, progressBlockerView, appCompatTextView, appCompatTextView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
