package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceScheduleCustomTypeV2Binding implements ViewBinding {
    public final ImageView btnClose;
    public final LinearLayout descriptionContainer;
    public final RadioButton radioButtonCustom;
    public final RadioButton radioButtonPrevious;
    public final RadioGroup radioGroupCustomScheduleSettings;
    private final ConstraintLayout rootView;
    public final TextView textviewCustomScheduleDescription;

    private HolderDeviceScheduleCustomTypeV2Binding(ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, TextView textView) {
        this.rootView = constraintLayout;
        this.btnClose = imageView;
        this.descriptionContainer = linearLayout;
        this.radioButtonCustom = radioButton;
        this.radioButtonPrevious = radioButton2;
        this.radioGroupCustomScheduleSettings = radioGroup;
        this.textviewCustomScheduleDescription = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceScheduleCustomTypeV2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceScheduleCustomTypeV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_schedule_custom_type_v2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceScheduleCustomTypeV2Binding bind(View view) {
        int i = R.id.btn_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.description_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.radio_button_custom;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
                if (radioButton != null) {
                    i = R.id.radio_button_previous;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
                    if (radioButton2 != null) {
                        i = R.id.radio_group_custom_schedule_settings;
                        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
                        if (radioGroup != null) {
                            i = R.id.textview_custom_schedule_description;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                return new HolderDeviceScheduleCustomTypeV2Binding((ConstraintLayout) view, imageView, linearLayout, radioButton, radioButton2, radioGroup, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
