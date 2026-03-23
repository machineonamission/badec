package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class BottomSheetFilterOrderBinding implements ViewBinding {
    public final MaterialButton btnCancel;
    public final MaterialButton buttonFilterOneTimePurchase;
    public final MaterialButton buttonFilterSubscription;
    private final LinearLayout rootView;

    private BottomSheetFilterOrderBinding(LinearLayout linearLayout, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3) {
        this.rootView = linearLayout;
        this.btnCancel = materialButton;
        this.buttonFilterOneTimePurchase = materialButton2;
        this.buttonFilterSubscription = materialButton3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetFilterOrderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BottomSheetFilterOrderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_filter_order, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BottomSheetFilterOrderBinding bind(View view) {
        int i = R.id.btnCancel;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.buttonFilterOneTimePurchase;
            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton2 != null) {
                i = R.id.buttonFilterSubscription;
                MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton3 != null) {
                    return new BottomSheetFilterOrderBinding((LinearLayout) view, materialButton, materialButton2, materialButton3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
