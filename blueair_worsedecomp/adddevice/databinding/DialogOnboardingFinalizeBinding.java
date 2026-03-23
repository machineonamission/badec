package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.adddevice.R;
import com.blueair.viewcore.view.AbsorbInsetFrameLayout;
import com.blueair.viewcore.view.SimpleStatusBar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class DialogOnboardingFinalizeBinding implements ViewBinding {
    public final MaterialButton btnAddAnother;
    public final AppCompatImageButton btnBack;
    public final MaterialButton btnContinue;
    public final ConstraintLayout clRoot;
    public final AppCompatImageButton closeButton;
    public final Group groupSuccess;
    public final AppCompatTextView headerMsg;
    public final AppCompatTextView headerTitle;
    public final LottieAnimationView icon;
    public final LinearProgressIndicator progressIndicator;
    private final AbsorbInsetFrameLayout rootView;
    public final SimpleStatusBar statusBar;
    public final TextView text;
    public final TextView title;

    private DialogOnboardingFinalizeBinding(AbsorbInsetFrameLayout absorbInsetFrameLayout, MaterialButton materialButton, AppCompatImageButton appCompatImageButton, MaterialButton materialButton2, ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton2, Group group, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, LottieAnimationView lottieAnimationView, LinearProgressIndicator linearProgressIndicator, SimpleStatusBar simpleStatusBar, TextView textView, TextView textView2) {
        this.rootView = absorbInsetFrameLayout;
        this.btnAddAnother = materialButton;
        this.btnBack = appCompatImageButton;
        this.btnContinue = materialButton2;
        this.clRoot = constraintLayout;
        this.closeButton = appCompatImageButton2;
        this.groupSuccess = group;
        this.headerMsg = appCompatTextView;
        this.headerTitle = appCompatTextView2;
        this.icon = lottieAnimationView;
        this.progressIndicator = linearProgressIndicator;
        this.statusBar = simpleStatusBar;
        this.text = textView;
        this.title = textView2;
    }

    public AbsorbInsetFrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogOnboardingFinalizeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogOnboardingFinalizeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_onboarding_finalize, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogOnboardingFinalizeBinding bind(View view) {
        View view2 = view;
        int i = R.id.btn_addAnother;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view2, i);
        if (materialButton != null) {
            i = R.id.btnBack;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view2, i);
            if (appCompatImageButton != null) {
                i = R.id.btn_continue;
                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view2, i);
                if (materialButton2 != null) {
                    i = R.id.cl_root;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                    if (constraintLayout != null) {
                        i = R.id.close_button;
                        AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) ViewBindings.findChildViewById(view2, i);
                        if (appCompatImageButton2 != null) {
                            i = R.id.group_success;
                            Group group = (Group) ViewBindings.findChildViewById(view2, i);
                            if (group != null) {
                                i = R.id.header_msg;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view2, i);
                                if (appCompatTextView != null) {
                                    i = R.id.header_title;
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view2, i);
                                    if (appCompatTextView2 != null) {
                                        i = R.id.icon;
                                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view2, i);
                                        if (lottieAnimationView != null) {
                                            i = R.id.progress_indicator;
                                            LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(view2, i);
                                            if (linearProgressIndicator != null) {
                                                i = R.id.statusBar;
                                                SimpleStatusBar simpleStatusBar = (SimpleStatusBar) ViewBindings.findChildViewById(view2, i);
                                                if (simpleStatusBar != null) {
                                                    i = R.id.text;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                                                    if (textView != null) {
                                                        i = R.id.title;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                        if (textView2 != null) {
                                                            return new DialogOnboardingFinalizeBinding((AbsorbInsetFrameLayout) view2, materialButton, appCompatImageButton, materialButton2, constraintLayout, appCompatImageButton2, group, appCompatTextView, appCompatTextView2, lottieAnimationView, linearProgressIndicator, simpleStatusBar, textView, textView2);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
