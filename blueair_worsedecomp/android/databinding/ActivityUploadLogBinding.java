package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public final class ActivityUploadLogBinding implements ViewBinding {
    public final AppCompatImageButton btnBack;
    public final MaterialButton btnClear;
    public final MaterialButton btnUpload;
    public final TextInputEditText descriptionValue;
    public final TextView dropdownIssueType;
    public final TextView dropdownLength;
    public final EditText etMaxLogSize;
    public final TextInputLayout inputDescription;
    public final TextView labelIssueType;
    public final TextView labelLength;
    public final TextView labelMaxLogSize;
    public final TextView labelMaxLogSizeUnit;
    private final ConstraintLayout rootView;
    public final TextView tvCurrentLogSize;
    public final TextView tvProgress;
    public final AppCompatTextView tvTitle;

    private ActivityUploadLogBinding(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, MaterialButton materialButton, MaterialButton materialButton2, TextInputEditText textInputEditText, TextView textView, TextView textView2, EditText editText, TextInputLayout textInputLayout, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, AppCompatTextView appCompatTextView) {
        this.rootView = constraintLayout;
        this.btnBack = appCompatImageButton;
        this.btnClear = materialButton;
        this.btnUpload = materialButton2;
        this.descriptionValue = textInputEditText;
        this.dropdownIssueType = textView;
        this.dropdownLength = textView2;
        this.etMaxLogSize = editText;
        this.inputDescription = textInputLayout;
        this.labelIssueType = textView3;
        this.labelLength = textView4;
        this.labelMaxLogSize = textView5;
        this.labelMaxLogSizeUnit = textView6;
        this.tvCurrentLogSize = textView7;
        this.tvProgress = textView8;
        this.tvTitle = appCompatTextView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityUploadLogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityUploadLogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_upload_log, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityUploadLogBinding bind(View view) {
        View view2 = view;
        int i = R.id.btn_back;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view2, i);
        if (appCompatImageButton != null) {
            i = R.id.btn_clear;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view2, i);
            if (materialButton != null) {
                i = R.id.btn_upload;
                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view2, i);
                if (materialButton2 != null) {
                    i = R.id.description_value;
                    TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view2, i);
                    if (textInputEditText != null) {
                        i = R.id.dropdown_issue_type;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                        if (textView != null) {
                            i = R.id.dropdown_length;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                            if (textView2 != null) {
                                i = R.id.et_max_log_size;
                                EditText editText = (EditText) ViewBindings.findChildViewById(view2, i);
                                if (editText != null) {
                                    i = R.id.input_description;
                                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view2, i);
                                    if (textInputLayout != null) {
                                        i = R.id.label_issue_type;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                        if (textView3 != null) {
                                            i = R.id.label_length;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                                            if (textView4 != null) {
                                                i = R.id.label_max_log_size;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                if (textView5 != null) {
                                                    i = R.id.label_max_log_size_unit;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                    if (textView6 != null) {
                                                        i = R.id.tv_current_log_size;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                        if (textView7 != null) {
                                                            i = R.id.tv_progress;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                            if (textView8 != null) {
                                                                i = R.id.tv_title;
                                                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view2, i);
                                                                if (appCompatTextView != null) {
                                                                    return new ActivityUploadLogBinding((ConstraintLayout) view2, appCompatImageButton, materialButton, materialButton2, textInputEditText, textView, textView2, editText, textInputLayout, textView3, textView4, textView5, textView6, textView7, textView8, appCompatTextView);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
