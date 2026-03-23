package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class SensorItemBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView sensorAltVal;
    public final ImageView sensorColor;
    public final TextView sensorLabel;
    public final LinearLayout sensorLayout;
    public final TextView sensorVal;

    private SensorItemBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, TextView textView2, LinearLayout linearLayout2, TextView textView3) {
        this.rootView = linearLayout;
        this.sensorAltVal = textView;
        this.sensorColor = imageView;
        this.sensorLabel = textView2;
        this.sensorLayout = linearLayout2;
        this.sensorVal = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SensorItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SensorItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.sensor_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SensorItemBinding bind(View view) {
        int i = R.id.sensor_alt_val;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.sensor_color;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.sensor_label;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    i = R.id.sensor_val;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new SensorItemBinding(linearLayout, textView, imageView, textView2, linearLayout, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
