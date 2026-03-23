package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;

public final class HolderDeviceCOnOffButtonBinding implements ViewBinding {
    public final ConstraintLayout contentContainer;
    private final FrameLayout rootView;
    public final SwitchCompat switchBtn;
    public final TextView title;

    private HolderDeviceCOnOffButtonBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, SwitchCompat switchCompat, TextView textView) {
        this.rootView = frameLayout;
        this.contentContainer = constraintLayout;
        this.switchBtn = switchCompat;
        this.title = textView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceCOnOffButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceCOnOffButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_c_on_off_button, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceCOnOffButtonBinding bind(View view) {
        int i = R.id.content_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.switch_btn;
            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
            if (switchCompat != null) {
                i = R.id.title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new HolderDeviceCOnOffButtonBinding((FrameLayout) view, constraintLayout, switchCompat, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
