package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;

public final class ScanInfoBinding implements ViewBinding {
    public final LinearLayout contentContainer;
    private final LinearLayout rootView;
    public final RecyclerView scanResultList;
    public final RecyclerView verificationList;

    private ScanInfoBinding(LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, RecyclerView recyclerView2) {
        this.rootView = linearLayout;
        this.contentContainer = linearLayout2;
        this.scanResultList = recyclerView;
        this.verificationList = recyclerView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ScanInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ScanInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.scan_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ScanInfoBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.scan_result_list;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = R.id.verification_list;
            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView2 != null) {
                return new ScanInfoBinding(linearLayout, linearLayout, recyclerView, recyclerView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
