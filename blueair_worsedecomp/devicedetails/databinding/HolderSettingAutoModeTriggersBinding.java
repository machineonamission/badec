package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderSettingAutoModeTriggersBinding implements ViewBinding {
    public final RadioButton autoModePmButton;
    public final RadioButton autoModePmTvocButton;
    public final TextView autoTitle;
    public final RadioGroup buttonGroupAutoMode;
    public final RadioGroup buttonGroupNightMode;
    public final Guideline leftGuideline;
    public final RadioButton nightModePmButton;
    public final RadioButton nightModePmTvocButton;
    public final TextView nightTitle;
    public final Guideline rightGuideline;
    private final ConstraintLayout rootView;
    public final TextView settingSummary;
    public final TextView settingTitle;

    private HolderSettingAutoModeTriggersBinding(ConstraintLayout constraintLayout, RadioButton radioButton, RadioButton radioButton2, TextView textView, RadioGroup radioGroup, RadioGroup radioGroup2, Guideline guideline, RadioButton radioButton3, RadioButton radioButton4, TextView textView2, Guideline guideline2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.autoModePmButton = radioButton;
        this.autoModePmTvocButton = radioButton2;
        this.autoTitle = textView;
        this.buttonGroupAutoMode = radioGroup;
        this.buttonGroupNightMode = radioGroup2;
        this.leftGuideline = guideline;
        this.nightModePmButton = radioButton3;
        this.nightModePmTvocButton = radioButton4;
        this.nightTitle = textView2;
        this.rightGuideline = guideline2;
        this.settingSummary = textView3;
        this.settingTitle = textView4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderSettingAutoModeTriggersBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderSettingAutoModeTriggersBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_setting_auto_mode_triggers, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderSettingAutoModeTriggersBinding bind(View view) {
        View view2 = view;
        int i = R.id.auto_mode_pm_button;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view2, i);
        if (radioButton != null) {
            i = R.id.auto_mode_pm_tvoc_button;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view2, i);
            if (radioButton2 != null) {
                i = R.id.auto_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                if (textView != null) {
                    i = R.id.buttonGroup_auto_mode;
                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view2, i);
                    if (radioGroup != null) {
                        i = R.id.buttonGroup_night_mode;
                        RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(view2, i);
                        if (radioGroup2 != null) {
                            i = R.id.left_guideline;
                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view2, i);
                            if (guideline != null) {
                                i = R.id.night_mode_pm_button;
                                RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view2, i);
                                if (radioButton3 != null) {
                                    i = R.id.night_mode_pm_tvoc_button;
                                    RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view2, i);
                                    if (radioButton4 != null) {
                                        i = R.id.night_title;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                                        if (textView2 != null) {
                                            i = R.id.right_guideline;
                                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view2, i);
                                            if (guideline2 != null) {
                                                i = R.id.setting_summary;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                if (textView3 != null) {
                                                    i = R.id.setting_title;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                    if (textView4 != null) {
                                                        return new HolderSettingAutoModeTriggersBinding((ConstraintLayout) view2, radioButton, radioButton2, textView, radioGroup, radioGroup2, guideline, radioButton3, radioButton4, textView2, guideline2, textView3, textView4);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
