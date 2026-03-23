package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;
import com.google.android.material.button.MaterialButton;

public final class DialogBluetoothInstructionsBinding implements ViewBinding {
    public final ImageButton closeButton;
    public final MaterialButton nextButton;
    private final LinearLayout rootView;
    public final TextView screenTitle;

    private DialogBluetoothInstructionsBinding(LinearLayout linearLayout, ImageButton imageButton, MaterialButton materialButton, TextView textView) {
        this.rootView = linearLayout;
        this.closeButton = imageButton;
        this.nextButton = materialButton;
        this.screenTitle = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogBluetoothInstructionsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogBluetoothInstructionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_bluetooth_instructions, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogBluetoothInstructionsBinding bind(View view) {
        int i = R.id.close_button;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = R.id.next_button;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.screen_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new DialogBluetoothInstructionsBinding((LinearLayout) view, imageButton, materialButton, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
