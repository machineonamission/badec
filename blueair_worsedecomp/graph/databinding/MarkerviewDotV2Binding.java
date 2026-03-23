package com.blueair.graph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.blueair.graph.R;

public final class MarkerviewDotV2Binding implements ViewBinding {
    public final ImageView markerDot;
    private final ImageView rootView;

    private MarkerviewDotV2Binding(ImageView imageView, ImageView imageView2) {
        this.rootView = imageView;
        this.markerDot = imageView2;
    }

    public ImageView getRoot() {
        return this.rootView;
    }

    public static MarkerviewDotV2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static MarkerviewDotV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.markerview_dot_v2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MarkerviewDotV2Binding bind(View view) {
        if (view != null) {
            ImageView imageView = (ImageView) view;
            return new MarkerviewDotV2Binding(imageView, imageView);
        }
        throw new NullPointerException("rootView");
    }
}
