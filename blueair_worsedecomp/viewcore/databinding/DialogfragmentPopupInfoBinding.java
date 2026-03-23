package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.viewcore.R;

public abstract class DialogfragmentPopupInfoBinding extends ViewDataBinding {
    public final ConstraintLayout contentContainer;
    public final TextView contentMessage;
    public final TextView contentTitle;
    public final Button doneBtn;
    public final ScrollView scrollView;
    public final View separator;
    public final TextView title;

    protected DialogfragmentPopupInfoBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, TextView textView2, Button button, ScrollView scrollView2, View view2, TextView textView3) {
        super(obj, view, i);
        this.contentContainer = constraintLayout;
        this.contentMessage = textView;
        this.contentTitle = textView2;
        this.doneBtn = button;
        this.scrollView = scrollView2;
        this.separator = view2;
        this.title = textView3;
    }

    public static DialogfragmentPopupInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentPopupInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentPopupInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_popup_info, viewGroup, z, obj);
    }

    public static DialogfragmentPopupInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentPopupInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentPopupInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_popup_info, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentPopupInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentPopupInfoBinding bind(View view, Object obj) {
        return (DialogfragmentPopupInfoBinding) bind(obj, view, R.layout.dialogfragment_popup_info);
    }
}
