package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.dd.ShadowLayout;

public final class HolderDeviceSensorCardBinding implements ViewBinding {
    public final ImageView aqiIcon;
    public final TextView aqiValue;
    public final ConstraintLayout cardContainer;
    private final ShadowLayout rootView;
    public final ImageView sensorIcon;
    public final TextView sensorLabel;

    private HolderDeviceSensorCardBinding(ShadowLayout shadowLayout, ImageView imageView, TextView textView, ConstraintLayout constraintLayout, ImageView imageView2, TextView textView2) {
        this.rootView = shadowLayout;
        this.aqiIcon = imageView;
        this.aqiValue = textView;
        this.cardContainer = constraintLayout;
        this.sensorIcon = imageView2;
        this.sensorLabel = textView2;
    }

    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceSensorCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceSensorCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_sensor_card, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceSensorCardBinding bind(View view) {
        int i = R.id.aqi_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.aqi_value;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.card_container;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.sensor_icon;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.sensor_label;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new HolderDeviceSensorCardBinding((ShadowLayout) view, imageView, textView, constraintLayout, imageView2, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
