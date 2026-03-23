package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.dd.ShadowLayout;

public final class HolderScannedDeviceBinding implements ViewBinding {
    public final ConstraintLayout clRoot;
    public final TextView connectedLabel;
    public final AppCompatImageView deviceImg;
    public final Group groupMac;
    public final TextView macNumber;
    public final TextView macNumberTitle;
    public final TextView model;
    public final TextView name;
    private final ShadowLayout rootView;
    public final ShadowLayout slRoot;
    public final TextView tvOnlineStatus;

    private HolderScannedDeviceBinding(ShadowLayout shadowLayout, ConstraintLayout constraintLayout, TextView textView, AppCompatImageView appCompatImageView, Group group, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ShadowLayout shadowLayout2, TextView textView6) {
        this.rootView = shadowLayout;
        this.clRoot = constraintLayout;
        this.connectedLabel = textView;
        this.deviceImg = appCompatImageView;
        this.groupMac = group;
        this.macNumber = textView2;
        this.macNumberTitle = textView3;
        this.model = textView4;
        this.name = textView5;
        this.slRoot = shadowLayout2;
        this.tvOnlineStatus = textView6;
    }

    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static HolderScannedDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderScannedDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_scanned_device, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderScannedDeviceBinding bind(View view) {
        int i = R.id.cl_root;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.connected_label;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.device_img;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView != null) {
                    i = R.id.group_mac;
                    Group group = (Group) ViewBindings.findChildViewById(view, i);
                    if (group != null) {
                        i = R.id.mac_number;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.mac_number_title;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.model;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.name;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        ShadowLayout shadowLayout = (ShadowLayout) view;
                                        i = R.id.tv_onlineStatus;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            return new HolderScannedDeviceBinding(shadowLayout, constraintLayout, textView, appCompatImageView, group, textView2, textView3, textView4, textView5, shadowLayout, textView6);
                                        }
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
