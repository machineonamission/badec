package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class HolderDeviceAutoDryBinding implements ViewBinding {
    public final MaterialButton btnCancel;
    public final ConstraintLayout clContainer;
    public final TextView durationText;
    public final Group expendedContent;
    public final ImageView infoIcon;
    public final ImageView leadingIcon;
    public final LinearProgressIndicator progressIndicator;
    private final ShadowLayout rootView;
    public final TextView title;
    public final TextView tvLeft;

    private HolderDeviceAutoDryBinding(ShadowLayout shadowLayout, MaterialButton materialButton, ConstraintLayout constraintLayout, TextView textView, Group group, ImageView imageView, ImageView imageView2, LinearProgressIndicator linearProgressIndicator, TextView textView2, TextView textView3) {
        this.rootView = shadowLayout;
        this.btnCancel = materialButton;
        this.clContainer = constraintLayout;
        this.durationText = textView;
        this.expendedContent = group;
        this.infoIcon = imageView;
        this.leadingIcon = imageView2;
        this.progressIndicator = linearProgressIndicator;
        this.title = textView2;
        this.tvLeft = textView3;
    }

    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceAutoDryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceAutoDryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_auto_dry, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceAutoDryBinding bind(View view) {
        int i = R.id.btn_cancel;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.cl_container;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.duration_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.expended_content;
                    Group group = (Group) ViewBindings.findChildViewById(view, i);
                    if (group != null) {
                        i = R.id.info_icon;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.leading_icon;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.progress_indicator;
                                LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(view, i);
                                if (linearProgressIndicator != null) {
                                    i = R.id.title;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.tv_left;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            return new HolderDeviceAutoDryBinding((ShadowLayout) view, materialButton, constraintLayout, textView, group, imageView, imageView2, linearProgressIndicator, textView2, textView3);
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
