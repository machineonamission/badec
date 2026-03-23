package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;

public final class HolderTroubleshootingStepBinding implements ViewBinding {
    public final AppCompatImageView ivIcon;
    public final ConstraintLayout root;
    private final ConstraintLayout rootView;
    public final AppCompatTextView tvContent;
    public final AppCompatTextView tvTitle;

    private HolderTroubleshootingStepBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.rootView = constraintLayout;
        this.ivIcon = appCompatImageView;
        this.root = constraintLayout2;
        this.tvContent = appCompatTextView;
        this.tvTitle = appCompatTextView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderTroubleshootingStepBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderTroubleshootingStepBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_troubleshooting_step, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderTroubleshootingStepBinding bind(View view) {
        int i = R.id.iv_icon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.tv_content;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
            if (appCompatTextView != null) {
                i = R.id.tv_title;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                if (appCompatTextView2 != null) {
                    return new HolderTroubleshootingStepBinding(constraintLayout, appCompatImageView, constraintLayout, appCompatTextView, appCompatTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
