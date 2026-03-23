package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.RadioGroup;

public final class HolderDeviceMainModeDehumBinding implements ViewBinding {
    public final RadioGroup radioGroup;
    public final RadioButton rbDehum;
    public final RadioButton rbPurify;
    private final RadioGroup rootView;

    private HolderDeviceMainModeDehumBinding(RadioGroup radioGroup2, RadioGroup radioGroup3, RadioButton radioButton, RadioButton radioButton2) {
        this.rootView = radioGroup2;
        this.radioGroup = radioGroup3;
        this.rbDehum = radioButton;
        this.rbPurify = radioButton2;
    }

    public RadioGroup getRoot() {
        return this.rootView;
    }

    public static HolderDeviceMainModeDehumBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceMainModeDehumBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_main_mode_dehum, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceMainModeDehumBinding bind(View view) {
        RadioGroup radioGroup2 = (RadioGroup) view;
        int i = R.id.rb_dehum;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
        if (radioButton != null) {
            i = R.id.rb_purify;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
            if (radioButton2 != null) {
                return new HolderDeviceMainModeDehumBinding(radioGroup2, radioGroup2, radioButton, radioButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
