package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.dd.ShadowLayout;

public final class DialogDeleteAlarmBinding implements ViewBinding {
    public final AppCompatEditText etName;
    public final ConstraintLayout rootLayout;
    private final ShadowLayout rootView;
    public final RecyclerView rvList;
    public final ShadowLayout slRoot;

    private DialogDeleteAlarmBinding(ShadowLayout shadowLayout, AppCompatEditText appCompatEditText, ConstraintLayout constraintLayout, RecyclerView recyclerView, ShadowLayout shadowLayout2) {
        this.rootView = shadowLayout;
        this.etName = appCompatEditText;
        this.rootLayout = constraintLayout;
        this.rvList = recyclerView;
        this.slRoot = shadowLayout2;
    }

    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static DialogDeleteAlarmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogDeleteAlarmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_delete_alarm, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogDeleteAlarmBinding bind(View view) {
        int i = R.id.et_name;
        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, i);
        if (appCompatEditText != null) {
            i = R.id.root_layout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.rv_list;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                if (recyclerView != null) {
                    ShadowLayout shadowLayout = (ShadowLayout) view;
                    return new DialogDeleteAlarmBinding(shadowLayout, appCompatEditText, constraintLayout, recyclerView, shadowLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
