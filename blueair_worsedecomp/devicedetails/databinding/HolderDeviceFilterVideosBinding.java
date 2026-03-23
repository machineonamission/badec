package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceFilterVideosBinding implements ViewBinding {
    public final AppCompatImageButton iconPlay;
    public final AppCompatImageView iconPlayBg;
    public final Guideline leftGuideline;
    public final Guideline rightGuideline;
    private final ConstraintLayout rootView;
    public final TextView videoSummary;
    public final AppCompatImageView videoThumbnail;
    public final ConstraintLayout videoThumbnailRoot;
    public final TextView videoTitle;

    private HolderDeviceFilterVideosBinding(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, AppCompatImageView appCompatImageView, Guideline guideline, Guideline guideline2, TextView textView, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout2, TextView textView2) {
        this.rootView = constraintLayout;
        this.iconPlay = appCompatImageButton;
        this.iconPlayBg = appCompatImageView;
        this.leftGuideline = guideline;
        this.rightGuideline = guideline2;
        this.videoSummary = textView;
        this.videoThumbnail = appCompatImageView2;
        this.videoThumbnailRoot = constraintLayout2;
        this.videoTitle = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceFilterVideosBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceFilterVideosBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_filter_videos, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceFilterVideosBinding bind(View view) {
        int i = R.id.icon_play;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.icon_play_bg;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.left_guideline;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline != null) {
                    i = R.id.right_guideline;
                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline2 != null) {
                        i = R.id.video_summary;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.video_thumbnail;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                            if (appCompatImageView2 != null) {
                                i = R.id.video_thumbnail_root;
                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout != null) {
                                    i = R.id.video_title;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        return new HolderDeviceFilterVideosBinding((ConstraintLayout) view, appCompatImageButton, appCompatImageView, guideline, guideline2, textView, appCompatImageView2, constraintLayout, textView2);
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
