package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentRateUsBinding implements ViewBinding {
    public final MaterialButton buttonImproveNegative;
    public final MaterialButton buttonImprovePositive;
    public final MaterialButton buttonRateCancel;
    public final MaterialButton buttonRateRedirect;
    public final ImageView imClose;
    public final ImageView imRateUs;
    private final ScrollView rootView;
    public final ScrollView scrollable;
    public final TextView textDescription;
    public final LinearLayout viewHelpUsImprove;
    public final LinearLayout viewRateUs;

    private DialogfragmentRateUsBinding(ScrollView scrollView, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, MaterialButton materialButton4, ImageView imageView, ImageView imageView2, ScrollView scrollView2, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.rootView = scrollView;
        this.buttonImproveNegative = materialButton;
        this.buttonImprovePositive = materialButton2;
        this.buttonRateCancel = materialButton3;
        this.buttonRateRedirect = materialButton4;
        this.imClose = imageView;
        this.imRateUs = imageView2;
        this.scrollable = scrollView2;
        this.textDescription = textView;
        this.viewHelpUsImprove = linearLayout;
        this.viewRateUs = linearLayout2;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static DialogfragmentRateUsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogfragmentRateUsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_rate_us, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogfragmentRateUsBinding bind(View view) {
        int i = R.id.buttonImproveNegative;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.buttonImprovePositive;
            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton2 != null) {
                i = R.id.buttonRateCancel;
                MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton3 != null) {
                    i = R.id.buttonRateRedirect;
                    MaterialButton materialButton4 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                    if (materialButton4 != null) {
                        i = R.id.imClose;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.imRateUs;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                ScrollView scrollView = (ScrollView) view;
                                i = R.id.textDescription;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.viewHelpUsImprove;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout != null) {
                                        i = R.id.viewRateUs;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout2 != null) {
                                            return new DialogfragmentRateUsBinding(scrollView, materialButton, materialButton2, materialButton3, materialButton4, imageView, imageView2, scrollView, textView, linearLayout, linearLayout2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
