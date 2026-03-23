package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentAddDeviceManualUserValidateClassicBinding implements ViewBinding {
    public final ImageView bgCountdown;
    public final MaterialButton buttonNo;
    public final MaterialButton buttonYes;
    public final Group groupButtons;
    public final ConstraintLayout rootLayout;
    private final ScrollView rootView;
    public final ScrollView scrollable;
    public final TextView textAddDeviceSubtitle;
    public final TextView textAddDeviceSubtitleThree;
    public final TextView textAddDeviceSubtitleTwo;
    public final TextView textAddDeviceTitle;
    public final TextView txtCountdown;

    private FragmentAddDeviceManualUserValidateClassicBinding(ScrollView scrollView, ImageView imageView, MaterialButton materialButton, MaterialButton materialButton2, Group group, ConstraintLayout constraintLayout, ScrollView scrollView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = scrollView;
        this.bgCountdown = imageView;
        this.buttonNo = materialButton;
        this.buttonYes = materialButton2;
        this.groupButtons = group;
        this.rootLayout = constraintLayout;
        this.scrollable = scrollView2;
        this.textAddDeviceSubtitle = textView;
        this.textAddDeviceSubtitleThree = textView2;
        this.textAddDeviceSubtitleTwo = textView3;
        this.textAddDeviceTitle = textView4;
        this.txtCountdown = textView5;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentAddDeviceManualUserValidateClassicBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentAddDeviceManualUserValidateClassicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_device_manual_user_validate_classic, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentAddDeviceManualUserValidateClassicBinding bind(View view) {
        int i = R.id.bgCountdown;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.buttonNo;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.buttonYes;
                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton2 != null) {
                    i = R.id.group_buttons;
                    Group group = (Group) ViewBindings.findChildViewById(view, i);
                    if (group != null) {
                        i = R.id.rootLayout;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            ScrollView scrollView = (ScrollView) view;
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
                                            i = R.id.txtCountdown;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                return new FragmentAddDeviceManualUserValidateClassicBinding(scrollView, imageView, materialButton, materialButton2, group, constraintLayout, scrollView, textView, textView2, textView3, textView4, textView5);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
