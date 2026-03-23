package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class HolderDeviceFilterV2Binding implements ViewBinding {
    public final MaterialButton btnBuy;
    public final MaterialButton btnReplace;
    public final ConstraintLayout contentContainer;
    public final Group groupLife;
    public final Group groupProgress;
    public final ImageView ivInfo;
    public final ImageView leadingIcon;
    public final LinearProgressIndicator progressIndicator;
    public final AppCompatTextView progressText;
    private final ConstraintLayout rootView;
    public final TextView title;

    private HolderDeviceFilterV2Binding(ConstraintLayout constraintLayout, MaterialButton materialButton, MaterialButton materialButton2, ConstraintLayout constraintLayout2, Group group, Group group2, ImageView imageView, ImageView imageView2, LinearProgressIndicator linearProgressIndicator, AppCompatTextView appCompatTextView, TextView textView) {
        this.rootView = constraintLayout;
        this.btnBuy = materialButton;
        this.btnReplace = materialButton2;
        this.contentContainer = constraintLayout2;
        this.groupLife = group;
        this.groupProgress = group2;
        this.ivInfo = imageView;
        this.leadingIcon = imageView2;
        this.progressIndicator = linearProgressIndicator;
        this.progressText = appCompatTextView;
        this.title = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceFilterV2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceFilterV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_filter_v2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceFilterV2Binding bind(View view) {
        int i = R.id.btn_buy;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.btn_replace;
            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.group_life;
                Group group = (Group) ViewBindings.findChildViewById(view, i);
                if (group != null) {
                    i = R.id.group_progress;
                    Group group2 = (Group) ViewBindings.findChildViewById(view, i);
                    if (group2 != null) {
                        i = R.id.iv_info;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.leading_icon;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.progress_indicator;
                                LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(view, i);
                                if (linearProgressIndicator != null) {
                                    i = R.id.progress_text;
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                    if (appCompatTextView != null) {
                                        i = R.id.title;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            return new HolderDeviceFilterV2Binding(constraintLayout, materialButton, materialButton2, constraintLayout, group, group2, imageView, imageView2, linearProgressIndicator, appCompatTextView, textView);
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
