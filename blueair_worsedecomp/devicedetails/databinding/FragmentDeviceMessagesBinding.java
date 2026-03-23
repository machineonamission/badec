package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;

public final class FragmentDeviceMessagesBinding implements ViewBinding {
    public final RecyclerView messageList;
    private final RecyclerView rootView;

    private FragmentDeviceMessagesBinding(RecyclerView recyclerView, RecyclerView recyclerView2) {
        this.rootView = recyclerView;
        this.messageList = recyclerView2;
    }

    public RecyclerView getRoot() {
        return this.rootView;
    }

    public static FragmentDeviceMessagesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentDeviceMessagesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_device_messages, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentDeviceMessagesBinding bind(View view) {
        if (view != null) {
            RecyclerView recyclerView = (RecyclerView) view;
            return new FragmentDeviceMessagesBinding(recyclerView, recyclerView);
        }
        throw new NullPointerException("rootView");
    }
}
