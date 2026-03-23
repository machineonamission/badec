package com.blueair.outdoor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.outdoor.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public final class DialogAssignProductBinding implements ViewBinding {
    public final MaterialButton btnAssign;
    public final ImageButton btnClose;
    public final TextView chooseProducts;
    public final TextView description;
    public final RecyclerView deviceList;
    public final TextView locationName;
    public final ProgressBlockerView progressView;
    private final LinearLayout rootView;
    public final TextView title;

    private DialogAssignProductBinding(LinearLayout linearLayout, MaterialButton materialButton, ImageButton imageButton, TextView textView, TextView textView2, RecyclerView recyclerView, TextView textView3, ProgressBlockerView progressBlockerView, TextView textView4) {
        this.rootView = linearLayout;
        this.btnAssign = materialButton;
        this.btnClose = imageButton;
        this.chooseProducts = textView;
        this.description = textView2;
        this.deviceList = recyclerView;
        this.locationName = textView3;
        this.progressView = progressBlockerView;
        this.title = textView4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogAssignProductBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogAssignProductBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_assign_product, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogAssignProductBinding bind(View view) {
        int i = R.id.btn_assign;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.btn_close;
            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
            if (imageButton != null) {
                i = R.id.choose_products;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.description;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.device_list;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                        if (recyclerView != null) {
                            i = R.id.location_name;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.progress_view;
                                ProgressBlockerView progressBlockerView = (ProgressBlockerView) ViewBindings.findChildViewById(view, i);
                                if (progressBlockerView != null) {
                                    i = R.id.title;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        return new DialogAssignProductBinding((LinearLayout) view, materialButton, imageButton, textView, textView2, recyclerView, textView3, progressBlockerView, textView4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
