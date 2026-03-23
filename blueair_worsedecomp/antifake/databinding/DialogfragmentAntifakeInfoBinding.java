package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;

public final class DialogfragmentAntifakeInfoBinding implements ViewBinding {
    public final ImageButton closeBtn;
    private final LinearLayout rootView;
    public final NestedScrollView scrollable;
    public final TextView title;
    public final ConstraintLayout titleBar;

    private DialogfragmentAntifakeInfoBinding(LinearLayout linearLayout, ImageButton imageButton, NestedScrollView nestedScrollView, TextView textView, ConstraintLayout constraintLayout) {
        this.rootView = linearLayout;
        this.closeBtn = imageButton;
        this.scrollable = nestedScrollView;
        this.title = textView;
        this.titleBar = constraintLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogfragmentAntifakeInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogfragmentAntifakeInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_antifake_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogfragmentAntifakeInfoBinding bind(View view) {
        int i = R.id.close_btn;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = R.id.scrollable;
            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
            if (nestedScrollView != null) {
                i = R.id.title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.title_bar;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        return new DialogfragmentAntifakeInfoBinding((LinearLayout) view, imageButton, nestedScrollView, textView, constraintLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
