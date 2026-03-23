package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;

public final class HolderScheduleCardEmptyBinding implements ViewBinding {
    public final MaterialButton btnCreate;
    public final ConstraintLayout emptyLayout;
    private final ShadowLayout rootView;
    public final AppCompatTextView textEmptyTitle;

    private HolderScheduleCardEmptyBinding(ShadowLayout shadowLayout, MaterialButton materialButton, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView) {
        this.rootView = shadowLayout;
        this.btnCreate = materialButton;
        this.emptyLayout = constraintLayout;
        this.textEmptyTitle = appCompatTextView;
    }

    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static HolderScheduleCardEmptyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderScheduleCardEmptyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_schedule_card_empty, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderScheduleCardEmptyBinding bind(View view) {
        int i = R.id.btn_create;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.emptyLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.textEmptyTitle;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                if (appCompatTextView != null) {
                    return new HolderScheduleCardEmptyBinding((ShadowLayout) view, materialButton, constraintLayout, appCompatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
