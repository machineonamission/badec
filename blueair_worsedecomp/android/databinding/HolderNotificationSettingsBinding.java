package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;
import com.blueair.viewcore.view.SwitchCompat;

public final class HolderNotificationSettingsBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final SwitchCompat typeSwitch;
    public final TextView typeText;

    private HolderNotificationSettingsBinding(ConstraintLayout constraintLayout, SwitchCompat switchCompat, TextView textView) {
        this.rootView = constraintLayout;
        this.typeSwitch = switchCompat;
        this.typeText = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderNotificationSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderNotificationSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_notification_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderNotificationSettingsBinding bind(View view) {
        int i = R.id.type_switch;
        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
        if (switchCompat != null) {
            i = R.id.type_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new HolderNotificationSettingsBinding((ConstraintLayout) view, switchCompat, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
