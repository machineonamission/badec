package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;

public final class HolderInfoRowHeaderBinding implements ViewBinding {
    public final FrameLayout regularSettingLayout;
    private final FrameLayout rootView;
    public final TextView tvTitle;

    private HolderInfoRowHeaderBinding(FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView) {
        this.rootView = frameLayout;
        this.regularSettingLayout = frameLayout2;
        this.tvTitle = textView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HolderInfoRowHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderInfoRowHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_info_row_header, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderInfoRowHeaderBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R.id.tv_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new HolderInfoRowHeaderBinding(frameLayout, frameLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
