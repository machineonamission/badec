package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceOfflineV2Binding implements ViewBinding {
    public final Button closeBtn;
    public final ConstraintLayout contentContainer;
    public final ImageView leadingIcon;
    public final TextView message;
    private final ConstraintLayout rootView;
    public final TextView title;
    public final Button troubleshootBtn;

    private HolderDeviceOfflineV2Binding(ConstraintLayout constraintLayout, Button button, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, TextView textView2, Button button2) {
        this.rootView = constraintLayout;
        this.closeBtn = button;
        this.contentContainer = constraintLayout2;
        this.leadingIcon = imageView;
        this.message = textView;
        this.title = textView2;
        this.troubleshootBtn = button2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceOfflineV2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceOfflineV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_offline_v2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceOfflineV2Binding bind(View view) {
        int i = R.id.close_btn;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.leading_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.message;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.troubleshoot_btn;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                        if (button2 != null) {
                            return new HolderDeviceOfflineV2Binding(constraintLayout, button, constraintLayout, imageView, textView, textView2, button2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
