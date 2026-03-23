package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;

public final class HolderVerificationBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final AppCompatImageView verificationImage;
    public final TextView verificationInfo;
    public final TextView verificationTitle;

    private HolderVerificationBinding(LinearLayout linearLayout, AppCompatImageView appCompatImageView, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.verificationImage = appCompatImageView;
        this.verificationInfo = textView;
        this.verificationTitle = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HolderVerificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderVerificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_verification, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderVerificationBinding bind(View view) {
        int i = R.id.verification_image;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.verification_info;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.verification_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new HolderVerificationBinding((LinearLayout) view, appCompatImageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
