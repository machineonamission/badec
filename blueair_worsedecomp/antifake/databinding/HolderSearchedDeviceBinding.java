package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;

public final class HolderSearchedDeviceBinding implements ViewBinding {
    public final TextView bluetoothStatus;
    public final AppCompatImageView deviceImg;
    public final TextView deviceName;
    public final TextView filterLeftLabel;
    public final TextView filterLeftValue;
    public final TextView macLabel;
    public final TextView macNumber;
    public final TextView modelName;
    public final TextView offlineLabel;
    public final ConstraintLayout root;
    private final ConstraintLayout rootView;
    public final TextView wickLeftLabel;
    public final TextView wickLeftValue;

    private HolderSearchedDeviceBinding(ConstraintLayout constraintLayout, TextView textView, AppCompatImageView appCompatImageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, ConstraintLayout constraintLayout2, TextView textView9, TextView textView10) {
        this.rootView = constraintLayout;
        this.bluetoothStatus = textView;
        this.deviceImg = appCompatImageView;
        this.deviceName = textView2;
        this.filterLeftLabel = textView3;
        this.filterLeftValue = textView4;
        this.macLabel = textView5;
        this.macNumber = textView6;
        this.modelName = textView7;
        this.offlineLabel = textView8;
        this.root = constraintLayout2;
        this.wickLeftLabel = textView9;
        this.wickLeftValue = textView10;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderSearchedDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderSearchedDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_searched_device, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderSearchedDeviceBinding bind(View view) {
        View view2 = view;
        int i = R.id.bluetooth_status;
        TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
        if (textView != null) {
            i = R.id.device_img;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view2, i);
            if (appCompatImageView != null) {
                i = R.id.device_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                if (textView2 != null) {
                    i = R.id.filter_left_label;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                    if (textView3 != null) {
                        i = R.id.filter_left_value;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                        if (textView4 != null) {
                            i = R.id.mac_label;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                            if (textView5 != null) {
                                i = R.id.mac_number;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i);
                                if (textView6 != null) {
                                    i = R.id.model_name;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i);
                                    if (textView7 != null) {
                                        i = R.id.offline_label;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, i);
                                        if (textView8 != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) view2;
                                            i = R.id.wick_left_label;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, i);
                                            if (textView9 != null) {
                                                i = R.id.wick_left_value;
                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                if (textView10 != null) {
                                                    return new HolderSearchedDeviceBinding(constraintLayout, textView, appCompatImageView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, constraintLayout, textView9, textView10);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
