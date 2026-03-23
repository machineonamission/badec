package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.adddevice.R;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class DialogConnectInstructionsBinding implements ViewBinding {
    public final AppCompatImageButton btnBack;
    public final AppCompatImageButton closeButton;
    public final TextView contentTextview;
    public final AppCompatTextView contentTitleTextview;
    public final AppCompatImageView ivDevice;
    public final AppCompatImageView ivIndicator;
    public final LottieAnimationView lavAnim;
    public final LinearProgressIndicator progressIndicator;
    private final LinearLayout rootView;
    public final AppCompatTextView screenTitle;
    public final AppCompatTextView tvSubtitle;

    private DialogConnectInstructionsBinding(LinearLayout linearLayout, AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2, TextView textView, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LottieAnimationView lottieAnimationView, LinearProgressIndicator linearProgressIndicator, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.rootView = linearLayout;
        this.btnBack = appCompatImageButton;
        this.closeButton = appCompatImageButton2;
        this.contentTextview = textView;
        this.contentTitleTextview = appCompatTextView;
        this.ivDevice = appCompatImageView;
        this.ivIndicator = appCompatImageView2;
        this.lavAnim = lottieAnimationView;
        this.progressIndicator = linearProgressIndicator;
        this.screenTitle = appCompatTextView2;
        this.tvSubtitle = appCompatTextView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogConnectInstructionsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogConnectInstructionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_connect_instructions, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogConnectInstructionsBinding bind(View view) {
        int i = R.id.btnBack;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.close_button;
            AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
            if (appCompatImageButton2 != null) {
                i = R.id.content_textview;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.content_title_textview;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                    if (appCompatTextView != null) {
                        i = R.id.iv_device;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageView != null) {
                            i = R.id.iv_indicator;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                            if (appCompatImageView2 != null) {
                                i = R.id.lav_anim;
                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                if (lottieAnimationView != null) {
                                    i = R.id.progress_indicator;
                                    LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(view, i);
                                    if (linearProgressIndicator != null) {
                                        i = R.id.screen_title;
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                        if (appCompatTextView2 != null) {
                                            i = R.id.tv_subtitle;
                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                            if (appCompatTextView3 != null) {
                                                return new DialogConnectInstructionsBinding((LinearLayout) view, appCompatImageButton, appCompatImageButton2, textView, appCompatTextView, appCompatImageView, appCompatImageView2, lottieAnimationView, linearProgressIndicator, appCompatTextView2, appCompatTextView3);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
