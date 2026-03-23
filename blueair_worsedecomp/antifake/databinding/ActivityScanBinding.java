package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.antifake.R;

public final class ActivityScanBinding implements ViewBinding {
    public final AppCompatImageView btnBack;
    public final AppCompatImageView btnInfo;
    public final ConstraintLayout containerScanner;
    public final ConstraintLayout main;
    public final PreviewView previewView;
    public final LottieAnimationView progressView;
    private final ConstraintLayout rootView;
    public final TextView scanTip;
    public final TextView titleScan;

    private ActivityScanBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, PreviewView previewView2, LottieAnimationView lottieAnimationView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.btnBack = appCompatImageView;
        this.btnInfo = appCompatImageView2;
        this.containerScanner = constraintLayout2;
        this.main = constraintLayout3;
        this.previewView = previewView2;
        this.progressView = lottieAnimationView;
        this.scanTip = textView;
        this.titleScan = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityScanBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityScanBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_scan, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityScanBinding bind(View view) {
        int i = R.id.btn_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.btn_info;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView2 != null) {
                i = R.id.container_scanner;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                    i = R.id.previewView;
                    PreviewView previewView2 = (PreviewView) ViewBindings.findChildViewById(view, i);
                    if (previewView2 != null) {
                        i = R.id.progress_view;
                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                        if (lottieAnimationView != null) {
                            i = R.id.scan_tip;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.title_scan;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    return new ActivityScanBinding(constraintLayout2, appCompatImageView, appCompatImageView2, constraintLayout, constraintLayout2, previewView2, lottieAnimationView, textView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
