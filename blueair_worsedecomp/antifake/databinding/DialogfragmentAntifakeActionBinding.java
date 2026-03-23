package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentAntifakeActionBinding implements ViewBinding {
    public final ImageButton backBtn;
    public final LinearLayout contentContainer;
    private final FrameLayout rootView;
    public final MaterialButton scanBtn;
    public final TextView title;
    public final FrameLayout titleBar;

    private DialogfragmentAntifakeActionBinding(FrameLayout frameLayout, ImageButton imageButton, LinearLayout linearLayout, MaterialButton materialButton, TextView textView, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.backBtn = imageButton;
        this.contentContainer = linearLayout;
        this.scanBtn = materialButton;
        this.title = textView;
        this.titleBar = frameLayout2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogfragmentAntifakeActionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogfragmentAntifakeActionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_antifake_action, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogfragmentAntifakeActionBinding bind(View view) {
        int i = R.id.back_btn;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = R.id.content_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.scan_btn;
                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton != null) {
                    i = R.id.title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.title_bar;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null) {
                            return new DialogfragmentAntifakeActionBinding((FrameLayout) view, imageButton, linearLayout, materialButton, textView, frameLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
