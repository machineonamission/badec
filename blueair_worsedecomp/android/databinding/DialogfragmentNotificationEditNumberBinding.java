package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.shawnlin.numberpicker.NumberPicker;

public abstract class DialogfragmentNotificationEditNumberBinding extends ViewDataBinding {
    public final Button btnCancel;
    public final Button btnSave;
    public final NumberPicker numberPicker;

    protected DialogfragmentNotificationEditNumberBinding(Object obj, View view, int i, Button button, Button button2, NumberPicker numberPicker2) {
        super(obj, view, i);
        this.btnCancel = button;
        this.btnSave = button2;
        this.numberPicker = numberPicker2;
    }

    public static DialogfragmentNotificationEditNumberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentNotificationEditNumberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentNotificationEditNumberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_notification_edit_number, viewGroup, z, obj);
    }

    public static DialogfragmentNotificationEditNumberBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentNotificationEditNumberBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentNotificationEditNumberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_notification_edit_number, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentNotificationEditNumberBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentNotificationEditNumberBinding bind(View view, Object obj) {
        return (DialogfragmentNotificationEditNumberBinding) bind(obj, view, R.layout.dialogfragment_notification_edit_number);
    }
}
