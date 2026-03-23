package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentAddDeviceSetupTextClassicBinding implements ViewBinding {
    public final MaterialButton buttonNext;
    public final ConstraintLayout rootLayout;
    private final ScrollView rootView;
    public final ScrollView scrollable;
    public final TextView textAddDeviceSubtitle;
    public final TextView textAddDeviceTitle;
    public final TextView textBulletFour;
    public final TextView textBulletOne;
    public final TextView textBulletThree;
    public final TextView textBulletTwo;
    public final TextView textWrongWifi;

    private FragmentAddDeviceSetupTextClassicBinding(ScrollView scrollView, MaterialButton materialButton, ConstraintLayout constraintLayout, ScrollView scrollView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = scrollView;
        this.buttonNext = materialButton;
        this.rootLayout = constraintLayout;
        this.scrollable = scrollView2;
        this.textAddDeviceSubtitle = textView;
        this.textAddDeviceTitle = textView2;
        this.textBulletFour = textView3;
        this.textBulletOne = textView4;
        this.textBulletThree = textView5;
        this.textBulletTwo = textView6;
        this.textWrongWifi = textView7;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentAddDeviceSetupTextClassicBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentAddDeviceSetupTextClassicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_device_setup_text_classic, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentAddDeviceSetupTextClassicBinding bind(View view) {
        int i = R.id.buttonNext;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.rootLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                ScrollView scrollView = (ScrollView) view;
                i = R.id.textAddDeviceSubtitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.textAddDeviceTitle;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.textBulletFour;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.textBulletOne;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.textBulletThree;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = R.id.textBulletTwo;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView6 != null) {
                                        i = R.id.textWrongWifi;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView7 != null) {
                                            return new FragmentAddDeviceSetupTextClassicBinding(scrollView, materialButton, constraintLayout, scrollView, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
