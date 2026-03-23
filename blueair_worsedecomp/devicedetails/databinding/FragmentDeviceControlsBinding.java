package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ShadowedRecyclerViewLayout;

public final class FragmentDeviceControlsBinding implements ViewBinding {
    public final Button btnCloseControlsHint;
    public final ConstraintLayout controlsHintContainer;
    public final TextView controlsHintText;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final ShadowedRecyclerViewLayout rvControlGroup;
    public final ShadowedRecyclerViewLayout rvFilterGroup;
    public final RecyclerView rvLightGroup;
    public final RecyclerView rvModeButtons;
    public final RecyclerView rvScheduleGroup;

    private FragmentDeviceControlsBinding(ConstraintLayout constraintLayout, Button button, ConstraintLayout constraintLayout2, TextView textView, ConstraintLayout constraintLayout3, ShadowedRecyclerViewLayout shadowedRecyclerViewLayout, ShadowedRecyclerViewLayout shadowedRecyclerViewLayout2, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3) {
        this.rootView = constraintLayout;
        this.btnCloseControlsHint = button;
        this.controlsHintContainer = constraintLayout2;
        this.controlsHintText = textView;
        this.rootLayout = constraintLayout3;
        this.rvControlGroup = shadowedRecyclerViewLayout;
        this.rvFilterGroup = shadowedRecyclerViewLayout2;
        this.rvLightGroup = recyclerView;
        this.rvModeButtons = recyclerView2;
        this.rvScheduleGroup = recyclerView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDeviceControlsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentDeviceControlsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_device_controls, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentDeviceControlsBinding bind(View view) {
        int i = R.id.btn_close_controls_hint;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.controls_hint_container;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.controls_hint_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                    i = R.id.rv_control_group;
                    ShadowedRecyclerViewLayout shadowedRecyclerViewLayout = (ShadowedRecyclerViewLayout) ViewBindings.findChildViewById(view, i);
                    if (shadowedRecyclerViewLayout != null) {
                        i = R.id.rv_filter_group;
                        ShadowedRecyclerViewLayout shadowedRecyclerViewLayout2 = (ShadowedRecyclerViewLayout) ViewBindings.findChildViewById(view, i);
                        if (shadowedRecyclerViewLayout2 != null) {
                            i = R.id.rv_light_group;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                            if (recyclerView != null) {
                                i = R.id.rv_mode_buttons;
                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                if (recyclerView2 != null) {
                                    i = R.id.rv_schedule_group;
                                    RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                    if (recyclerView3 != null) {
                                        return new FragmentDeviceControlsBinding(constraintLayout2, button, constraintLayout, textView, constraintLayout2, shadowedRecyclerViewLayout, shadowedRecyclerViewLayout2, recyclerView, recyclerView2, recyclerView3);
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
