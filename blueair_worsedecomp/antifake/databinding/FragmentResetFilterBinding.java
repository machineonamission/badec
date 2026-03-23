package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public final class FragmentResetFilterBinding implements ViewBinding {
    public final MaterialButton btnCustomerSupport;
    public final MaterialButton btnFinish;
    public final MaterialButton btnHowToReplace;
    public final TextView btnManualReset;
    public final ProgressBlockerView connectingIcPending;
    public final AppCompatImageView connectingIcResult;
    public final ConstraintLayout connectingLine;
    public final TextView connectingText;
    public final ProgressBlockerView resettingIcPending;
    public final AppCompatImageView resettingIcResult;
    public final ConstraintLayout resettingLine;
    public final TextView resettingText;
    private final ConstraintLayout rootView;

    private FragmentResetFilterBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, TextView textView, ProgressBlockerView progressBlockerView, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, TextView textView2, ProgressBlockerView progressBlockerView2, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout3, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnCustomerSupport = materialButton;
        this.btnFinish = materialButton2;
        this.btnHowToReplace = materialButton3;
        this.btnManualReset = textView;
        this.connectingIcPending = progressBlockerView;
        this.connectingIcResult = appCompatImageView;
        this.connectingLine = constraintLayout2;
        this.connectingText = textView2;
        this.resettingIcPending = progressBlockerView2;
        this.resettingIcResult = appCompatImageView2;
        this.resettingLine = constraintLayout3;
        this.resettingText = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentResetFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentResetFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_reset_filter, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentResetFilterBinding bind(View view) {
        View view2 = view;
        int i = R.id.btn_customer_support;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view2, i);
        if (materialButton != null) {
            i = R.id.btn_finish;
            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view2, i);
            if (materialButton2 != null) {
                i = R.id.btn_how_to_replace;
                MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view2, i);
                if (materialButton3 != null) {
                    i = R.id.btn_manual_reset;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                    if (textView != null) {
                        i = R.id.connecting_ic_pending;
                        ProgressBlockerView progressBlockerView = (ProgressBlockerView) ViewBindings.findChildViewById(view2, i);
                        if (progressBlockerView != null) {
                            i = R.id.connecting_ic_result;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view2, i);
                            if (appCompatImageView != null) {
                                i = R.id.connecting_line;
                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                if (constraintLayout != null) {
                                    i = R.id.connecting_text;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                                    if (textView2 != null) {
                                        i = R.id.resetting_ic_pending;
                                        ProgressBlockerView progressBlockerView2 = (ProgressBlockerView) ViewBindings.findChildViewById(view2, i);
                                        if (progressBlockerView2 != null) {
                                            i = R.id.resetting_ic_result;
                                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view2, i);
                                            if (appCompatImageView2 != null) {
                                                i = R.id.resetting_line;
                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                if (constraintLayout2 != null) {
                                                    i = R.id.resetting_text;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                    if (textView3 != null) {
                                                        return new FragmentResetFilterBinding((ConstraintLayout) view2, materialButton, materialButton2, materialButton3, textView, progressBlockerView, appCompatImageView, constraintLayout, textView2, progressBlockerView2, appCompatImageView2, constraintLayout2, textView3);
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
