package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.ShadowedRecyclerViewLayout;

public final class DropDownListBinding implements ViewBinding {
    private final ShadowedRecyclerViewLayout rootView;
    public final ShadowedRecyclerViewLayout srvl;

    private DropDownListBinding(ShadowedRecyclerViewLayout shadowedRecyclerViewLayout, ShadowedRecyclerViewLayout shadowedRecyclerViewLayout2) {
        this.rootView = shadowedRecyclerViewLayout;
        this.srvl = shadowedRecyclerViewLayout2;
    }

    public ShadowedRecyclerViewLayout getRoot() {
        return this.rootView;
    }

    public static DropDownListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DropDownListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.drop_down_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DropDownListBinding bind(View view) {
        if (view != null) {
            ShadowedRecyclerViewLayout shadowedRecyclerViewLayout = (ShadowedRecyclerViewLayout) view;
            return new DropDownListBinding(shadowedRecyclerViewLayout, shadowedRecyclerViewLayout);
        }
        throw new NullPointerException("rootView");
    }
}
