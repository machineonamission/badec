package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceHScheduleCustomTypeBinding implements ViewBinding {
    public final RadioButton radioButtonCustom;
    public final RadioButton radioButtonPrevious;
    public final RadioGroup radioGroupCustomScheduleSettings;
    private final ConstraintLayout rootView;
    public final TextView textviewCustomSchedule;
    public final TextView textviewCustomScheduleDescription;

    private HolderDeviceHScheduleCustomTypeBinding(ConstraintLayout constraintLayout, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.radioButtonCustom = radioButton;
        this.radioButtonPrevious = radioButton2;
        this.radioGroupCustomScheduleSettings = radioGroup;
        this.textviewCustomSchedule = textView;
        this.textviewCustomScheduleDescription = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceHScheduleCustomTypeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceHScheduleCustomTypeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_h_schedule_custom_type, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceHScheduleCustomTypeBinding bind(View view) {
        int i = R.id.radio_button_custom;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
        if (radioButton != null) {
            i = R.id.radio_button_previous;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
            if (radioButton2 != null) {
                i = R.id.radio_group_custom_schedule_settings;
                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
                if (radioGroup != null) {
                    i = R.id.textview_custom_schedule;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.textview_custom_schedule_description;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new HolderDeviceHScheduleCustomTypeBinding((ConstraintLayout) view, radioButton, radioButton2, radioGroup, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
