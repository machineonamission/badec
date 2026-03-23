package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.blueair.antifake.R;

public final class FragmentScanVerifyingBinding implements ViewBinding {
    private final FrameLayout rootView;

    private FragmentScanVerifyingBinding(FrameLayout frameLayout) {
        this.rootView = frameLayout;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentScanVerifyingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentScanVerifyingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_scan_verifying, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentScanVerifyingBinding bind(View view) {
        if (view != null) {
            return new FragmentScanVerifyingBinding((FrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }
}
