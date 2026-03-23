package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentAddDeviceManualUserValidateBinding implements ViewBinding {
    public final MaterialButton buttonNo;
    public final MaterialButton buttonYes;
    public final ImageView imageAuto;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView textAddDeviceSubtitle;
    public final TextView textAddDeviceSubtitleThree;
    public final TextView textAddDeviceSubtitleTwo;
    public final TextView textAddDeviceTitle;

    private FragmentAddDeviceManualUserValidateBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, MaterialButton materialButton2, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.buttonNo = materialButton;
        this.buttonYes = materialButton2;
        this.imageAuto = imageView;
        this.rootLayout = constraintLayout2;
        this.textAddDeviceSubtitle = textView;
        this.textAddDeviceSubtitleThree = textView2;
        this.textAddDeviceSubtitleTwo = textView3;
        this.textAddDeviceTitle = textView4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAddDeviceManualUserValidateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentAddDeviceManualUserValidateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_device_manual_user_validate, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentAddDeviceManualUserValidateBinding bind(View view) {
        int i = R.id.buttonNo;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.buttonYes;
            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton2 != null) {
                i = R.id.imageAuto;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.textAddDeviceSubtitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.textAddDeviceSubtitleThree;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.textAddDeviceSubtitleTwo;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.textAddDeviceTitle;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    return new FragmentAddDeviceManualUserValidateBinding(constraintLayout, materialButton, materialButton2, imageView, constraintLayout, textView, textView2, textView3, textView4);
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
