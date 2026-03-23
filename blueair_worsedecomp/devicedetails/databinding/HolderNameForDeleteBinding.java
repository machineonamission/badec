package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;

public final class HolderNameForDeleteBinding implements ViewBinding {
    private final AppCompatTextView rootView;

    private HolderNameForDeleteBinding(AppCompatTextView appCompatTextView) {
        this.rootView = appCompatTextView;
    }

    public AppCompatTextView getRoot() {
        return this.rootView;
    }

    public static HolderNameForDeleteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderNameForDeleteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_name_for_delete, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderNameForDeleteBinding bind(View view) {
        if (view != null) {
            return new HolderNameForDeleteBinding((AppCompatTextView) view);
        }
        throw new NullPointerException("rootView");
    }
}
