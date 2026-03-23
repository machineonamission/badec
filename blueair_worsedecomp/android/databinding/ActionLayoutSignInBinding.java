package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.viewbinding.ViewBinding;
import com.blueair.android.R;

public final class ActionLayoutSignInBinding implements ViewBinding {
    private final Button rootView;

    private ActionLayoutSignInBinding(Button button) {
        this.rootView = button;
    }

    public Button getRoot() {
        return this.rootView;
    }

    public static ActionLayoutSignInBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActionLayoutSignInBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.action_layout_sign_in, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActionLayoutSignInBinding bind(View view) {
        if (view != null) {
            return new ActionLayoutSignInBinding((Button) view);
        }
        throw new NullPointerException("rootView");
    }
}
