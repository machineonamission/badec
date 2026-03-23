package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;

public final class SwipeLeftLayoutBinding implements ViewBinding {
    public final AppCompatImageView automodeImageview;
    public final LinearLayout automodeRoot;
    public final TextView automodeTitleview;
    public final AppCompatImageView nightmodeImageview;
    public final LinearLayout nightmodeRoot;
    public final TextView nightmodeTitleview;
    private final ConstraintLayout rootView;

    private SwipeLeftLayoutBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, TextView textView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout2, TextView textView2) {
        this.rootView = constraintLayout;
        this.automodeImageview = appCompatImageView;
        this.automodeRoot = linearLayout;
        this.automodeTitleview = textView;
        this.nightmodeImageview = appCompatImageView2;
        this.nightmodeRoot = linearLayout2;
        this.nightmodeTitleview = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SwipeLeftLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SwipeLeftLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.swipe_left_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SwipeLeftLayoutBinding bind(View view) {
        int i = R.id.automode_imageview;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.automode_root;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.automode_titleview;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.nightmode_imageview;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageView2 != null) {
                        i = R.id.nightmode_root;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = R.id.nightmode_titleview;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new SwipeLeftLayoutBinding((ConstraintLayout) view, appCompatImageView, linearLayout, textView, appCompatImageView2, linearLayout2, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
