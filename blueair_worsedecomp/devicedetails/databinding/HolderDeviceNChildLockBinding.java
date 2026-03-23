package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;

public final class HolderDeviceNChildLockBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final SwitchCompat switchBtn;
    public final TextView title;

    private HolderDeviceNChildLockBinding(FrameLayout frameLayout, SwitchCompat switchCompat, TextView textView) {
        this.rootView = frameLayout;
        this.switchBtn = switchCompat;
        this.title = textView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceNChildLockBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceNChildLockBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_n_child_lock, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceNChildLockBinding bind(View view) {
        int i = R.id.switch_btn;
        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
        if (switchCompat != null) {
            i = R.id.title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new HolderDeviceNChildLockBinding((FrameLayout) view, switchCompat, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
