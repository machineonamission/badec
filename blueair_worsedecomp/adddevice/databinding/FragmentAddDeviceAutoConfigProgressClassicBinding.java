package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.adddevice.R;

public final class FragmentAddDeviceAutoConfigProgressClassicBinding implements ViewBinding {
    public final LottieAnimationView imageAuto;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView textAddDeviceTitle;

    private FragmentAddDeviceAutoConfigProgressClassicBinding(ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout2, TextView textView) {
        this.rootView = constraintLayout;
        this.imageAuto = lottieAnimationView;
        this.rootLayout = constraintLayout2;
        this.textAddDeviceTitle = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAddDeviceAutoConfigProgressClassicBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentAddDeviceAutoConfigProgressClassicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_device_auto_config_progress_classic, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentAddDeviceAutoConfigProgressClassicBinding bind(View view) {
        int i = R.id.imageAuto;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
        if (lottieAnimationView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i2 = R.id.textAddDeviceTitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i2);
            if (textView != null) {
                return new FragmentAddDeviceAutoConfigProgressClassicBinding(constraintLayout, lottieAnimationView, constraintLayout, textView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
