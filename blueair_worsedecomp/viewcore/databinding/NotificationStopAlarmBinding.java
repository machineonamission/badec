package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;

public final class NotificationStopAlarmBinding implements ViewBinding {
    public final TextView body;
    public final Button btnStop;
    private final LinearLayout rootView;
    public final TextView title;

    private NotificationStopAlarmBinding(LinearLayout linearLayout, TextView textView, Button button, TextView textView2) {
        this.rootView = linearLayout;
        this.body = textView;
        this.btnStop = button;
        this.title = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NotificationStopAlarmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NotificationStopAlarmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.notification_stop_alarm, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NotificationStopAlarmBinding bind(View view) {
        int i = R.id.body;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.btn_stop;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = R.id.title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new NotificationStopAlarmBinding((LinearLayout) view, textView, button, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
