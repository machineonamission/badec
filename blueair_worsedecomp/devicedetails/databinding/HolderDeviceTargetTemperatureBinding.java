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
import com.blueair.viewcore.view.AccessibleSeekBar;

public final class HolderDeviceTargetTemperatureBinding implements ViewBinding {
    public final ConstraintLayout contentContainer;
    public final TextView endTemp;
    public final TextView progressText;
    private final FrameLayout rootView;
    public final AccessibleSeekBar seekbar;
    public final TextView startTemp;
    public final TextView title;

    private HolderDeviceTargetTemperatureBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, TextView textView, TextView textView2, AccessibleSeekBar accessibleSeekBar, TextView textView3, TextView textView4) {
        this.rootView = frameLayout;
        this.contentContainer = constraintLayout;
        this.endTemp = textView;
        this.progressText = textView2;
        this.seekbar = accessibleSeekBar;
        this.startTemp = textView3;
        this.title = textView4;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceTargetTemperatureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceTargetTemperatureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_target_temperature, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceTargetTemperatureBinding bind(View view) {
        int i = R.id.content_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.end_temp;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.progressText;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.seekbar;
                    AccessibleSeekBar accessibleSeekBar = (AccessibleSeekBar) ViewBindings.findChildViewById(view, i);
                    if (accessibleSeekBar != null) {
                        i = R.id.start_temp;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.title;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                return new HolderDeviceTargetTemperatureBinding((FrameLayout) view, constraintLayout, textView, textView2, accessibleSeekBar, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
