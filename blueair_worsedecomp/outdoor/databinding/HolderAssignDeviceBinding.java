package com.blueair.outdoor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.outdoor.R;

public final class HolderAssignDeviceBinding implements ViewBinding {
    public final CheckBox checkBox;
    public final TextView deviceName;
    public final LinearLayout itemContainer;
    private final FrameLayout rootView;

    private HolderAssignDeviceBinding(FrameLayout frameLayout, CheckBox checkBox2, TextView textView, LinearLayout linearLayout) {
        this.rootView = frameLayout;
        this.checkBox = checkBox2;
        this.deviceName = textView;
        this.itemContainer = linearLayout;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HolderAssignDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderAssignDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_assign_device, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderAssignDeviceBinding bind(View view) {
        int i = R.id.check_box;
        CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, i);
        if (checkBox2 != null) {
            i = R.id.device_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.item_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    return new HolderAssignDeviceBinding((FrameLayout) view, checkBox2, textView, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
