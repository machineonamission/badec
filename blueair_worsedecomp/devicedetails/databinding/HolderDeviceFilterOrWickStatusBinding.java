package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class HolderDeviceFilterOrWickStatusBinding implements ViewBinding {
    public final MaterialButton buyNew;
    public final TextView expiredText;
    public final FrameLayout holderDeviceHWickStatus;
    public final MaterialButton howToReplace;
    public final ImageView iconLeft;
    public final TextView lifetime;
    public final TextView lifetimeValue;
    public final LinearProgressIndicator progressBar;
    private final FrameLayout rootView;
    public final TextView title;

    private HolderDeviceFilterOrWickStatusBinding(FrameLayout frameLayout, MaterialButton materialButton, TextView textView, FrameLayout frameLayout2, MaterialButton materialButton2, ImageView imageView, TextView textView2, TextView textView3, LinearProgressIndicator linearProgressIndicator, TextView textView4) {
        this.rootView = frameLayout;
        this.buyNew = materialButton;
        this.expiredText = textView;
        this.holderDeviceHWickStatus = frameLayout2;
        this.howToReplace = materialButton2;
        this.iconLeft = imageView;
        this.lifetime = textView2;
        this.lifetimeValue = textView3;
        this.progressBar = linearProgressIndicator;
        this.title = textView4;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceFilterOrWickStatusBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceFilterOrWickStatusBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_filter_or_wick_status, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceFilterOrWickStatusBinding bind(View view) {
        int i = R.id.buy_new;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.expiredText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                FrameLayout frameLayout = (FrameLayout) view;
                i = R.id.how_to_replace;
                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton2 != null) {
                    i = R.id.icon_left;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.lifetime;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.lifetime_value;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.progress_bar;
                                LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(view, i);
                                if (linearProgressIndicator != null) {
                                    i = R.id.title;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        return new HolderDeviceFilterOrWickStatusBinding(frameLayout, materialButton, textView, frameLayout, materialButton2, imageView, textView2, textView3, linearProgressIndicator, textView4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
