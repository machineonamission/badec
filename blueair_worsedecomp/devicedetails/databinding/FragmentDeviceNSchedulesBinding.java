package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentDeviceNSchedulesBinding implements ViewBinding {
    public final MaterialButton addSchedule;
    private final FrameLayout rootView;
    public final RecyclerView scheduleList;
    public final TextView title;

    private FragmentDeviceNSchedulesBinding(FrameLayout frameLayout, MaterialButton materialButton, RecyclerView recyclerView, TextView textView) {
        this.rootView = frameLayout;
        this.addSchedule = materialButton;
        this.scheduleList = recyclerView;
        this.title = textView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDeviceNSchedulesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentDeviceNSchedulesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_device_n_schedules, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentDeviceNSchedulesBinding bind(View view) {
        int i = R.id.add_schedule;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.schedule_list;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = R.id.title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new FragmentDeviceNSchedulesBinding((FrameLayout) view, materialButton, recyclerView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
