package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blueair.viewcore.R;

public final class HolderDropDownItemBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView text;

    private HolderDropDownItemBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.text = textView2;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static HolderDropDownItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDropDownItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_drop_down_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDropDownItemBinding bind(View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new HolderDropDownItemBinding(textView, textView);
        }
        throw new NullPointerException("rootView");
    }
}
