package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;

public final class ActivityFilterVideoBinding implements ViewBinding {
    public final AppCompatImageButton closeIcon;
    public final ProgressBlockerView progressView;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final VideoView videoView;

    private ActivityFilterVideoBinding(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, ProgressBlockerView progressBlockerView, ConstraintLayout constraintLayout2, VideoView videoView2) {
        this.rootView = constraintLayout;
        this.closeIcon = appCompatImageButton;
        this.progressView = progressBlockerView;
        this.rootLayout = constraintLayout2;
        this.videoView = videoView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFilterVideoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityFilterVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_filter_video, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityFilterVideoBinding bind(View view) {
        int i = R.id.close_icon;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.progress_view;
            ProgressBlockerView progressBlockerView = (ProgressBlockerView) ViewBindings.findChildViewById(view, i);
            if (progressBlockerView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.video_view;
                VideoView videoView2 = (VideoView) ViewBindings.findChildViewById(view, i);
                if (videoView2 != null) {
                    return new ActivityFilterVideoBinding(constraintLayout, appCompatImageButton, progressBlockerView, constraintLayout, videoView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
