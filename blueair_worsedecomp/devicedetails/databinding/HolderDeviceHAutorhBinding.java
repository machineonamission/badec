package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;

public final class HolderDeviceHAutorhBinding implements ViewBinding {
    public final ConstraintLayout contentContainer;
    public final ImageView endIcon;
    public final TextView progressText;
    private final FrameLayout rootView;
    public final AccessibleSeekBar seekbar;
    public final Group seekbarGroup;
    public final ImageView startIcon;
    public final TextView title;

    private HolderDeviceHAutorhBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, AccessibleSeekBar accessibleSeekBar, Group group, ImageView imageView2, TextView textView2) {
        this.rootView = frameLayout;
        this.contentContainer = constraintLayout;
        this.endIcon = imageView;
        this.progressText = textView;
        this.seekbar = accessibleSeekBar;
        this.seekbarGroup = group;
        this.startIcon = imageView2;
        this.title = textView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceHAutorhBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceHAutorhBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_h_autorh, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceHAutorhBinding bind(View view) {
        int i = R.id.content_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.end_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.progressText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.seekbar;
                    AccessibleSeekBar accessibleSeekBar = (AccessibleSeekBar) ViewBindings.findChildViewById(view, i);
                    if (accessibleSeekBar != null) {
                        i = R.id.seekbar_group;
                        Group group = (Group) ViewBindings.findChildViewById(view, i);
                        if (group != null) {
                            i = R.id.start_icon;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    return new HolderDeviceHAutorhBinding((FrameLayout) view, constraintLayout, imageView, textView, accessibleSeekBar, group, imageView2, textView2);
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
