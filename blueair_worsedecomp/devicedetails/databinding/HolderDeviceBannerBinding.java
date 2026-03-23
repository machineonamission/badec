package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceBannerBinding implements ViewBinding {
    public final Guideline bottomGuideline;
    public final ImageButton closeBtn;
    public final Guideline endGuideline;
    public final TextView message;
    private final FrameLayout rootView;
    public final Guideline startGuideline;
    public final TextView title;
    public final Guideline topGuideline;
    public final ImageView warningIcon;

    private HolderDeviceBannerBinding(FrameLayout frameLayout, Guideline guideline, ImageButton imageButton, Guideline guideline2, TextView textView, Guideline guideline3, TextView textView2, Guideline guideline4, ImageView imageView) {
        this.rootView = frameLayout;
        this.bottomGuideline = guideline;
        this.closeBtn = imageButton;
        this.endGuideline = guideline2;
        this.message = textView;
        this.startGuideline = guideline3;
        this.title = textView2;
        this.topGuideline = guideline4;
        this.warningIcon = imageView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceBannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_banner, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceBannerBinding bind(View view) {
        int i = R.id.bottom_guideline;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = R.id.close_btn;
            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
            if (imageButton != null) {
                i = R.id.end_guideline;
                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline2 != null) {
                    i = R.id.message;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.start_guideline;
                        Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline3 != null) {
                            i = R.id.title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.top_guideline;
                                Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline4 != null) {
                                    i = R.id.warning_icon;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView != null) {
                                        return new HolderDeviceBannerBinding((FrameLayout) view, guideline, imageButton, guideline2, textView, guideline3, textView2, guideline4, imageView);
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
