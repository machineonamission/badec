package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.viewbinding.ViewBinding;
import com.blueair.android.R;

public final class ActionLayoutScanBinding implements ViewBinding {
    private final ImageButton rootView;

    private ActionLayoutScanBinding(ImageButton imageButton) {
        this.rootView = imageButton;
    }

    public ImageButton getRoot() {
        return this.rootView;
    }

    public static ActionLayoutScanBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActionLayoutScanBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.action_layout_scan, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActionLayoutScanBinding bind(View view) {
        if (view != null) {
            return new ActionLayoutScanBinding((ImageButton) view);
        }
        throw new NullPointerException("rootView");
    }
}
