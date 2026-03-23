package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;

public final class ProgressButtonBinding implements ViewBinding {
    public final ImageView image;
    public final ProgressBar progressBar;
    private final View rootView;

    private ProgressButtonBinding(View view, ImageView imageView, ProgressBar progressBar2) {
        this.rootView = view;
        this.image = imageView;
        this.progressBar = progressBar2;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static ProgressButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.progress_button, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    public static ProgressButtonBinding bind(View view) {
        int i = R.id.image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.progressBar;
            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i);
            if (progressBar2 != null) {
                return new ProgressButtonBinding(view, imageView, progressBar2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
