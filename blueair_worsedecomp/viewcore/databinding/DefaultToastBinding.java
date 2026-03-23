package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blueair.viewcore.R;

public final class DefaultToastBinding implements ViewBinding {
    private final TextView rootView;

    private DefaultToastBinding(TextView textView) {
        this.rootView = textView;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static DefaultToastBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DefaultToastBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.default_toast, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DefaultToastBinding bind(View view) {
        if (view != null) {
            return new DefaultToastBinding((TextView) view);
        }
        throw new NullPointerException("rootView");
    }
}
