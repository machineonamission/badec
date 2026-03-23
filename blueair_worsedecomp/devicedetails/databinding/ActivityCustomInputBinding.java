package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class ActivityCustomInputBinding extends ViewDataBinding {
    public final AppCompatImageButton btnBack;
    public final MaterialButton btnSave;
    public final TextInputEditText editText;
    public final TextInputLayout editTextLayout;
    public final AppCompatTextView tvTitle;

    protected ActivityCustomInputBinding(Object obj, View view, int i, AppCompatImageButton appCompatImageButton, MaterialButton materialButton, TextInputEditText textInputEditText, TextInputLayout textInputLayout, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.btnBack = appCompatImageButton;
        this.btnSave = materialButton;
        this.editText = textInputEditText;
        this.editTextLayout = textInputLayout;
        this.tvTitle = appCompatTextView;
    }

    public static ActivityCustomInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCustomInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityCustomInputBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_custom_input, viewGroup, z, obj);
    }

    public static ActivityCustomInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCustomInputBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityCustomInputBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_custom_input, (ViewGroup) null, false, obj);
    }

    public static ActivityCustomInputBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCustomInputBinding bind(View view, Object obj) {
        return (ActivityCustomInputBinding) bind(obj, view, R.layout.activity_custom_input);
    }
}
