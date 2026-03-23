package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class DialogConnectionTipsBinding implements ViewBinding {
    public final Guideline bottomGuideline;
    public final MaterialButton confirmButton;
    public final TextView contentText1;
    public final TextView contentText2;
    public final TextView contentText3;
    public final TextView contentText4;
    public final TextView contentText5;
    public final ImageView dot1;
    public final ImageView dot2;
    public final ImageView dot3;
    public final ImageView dot4;
    public final ImageView dot5;
    public final Guideline endGuideline;
    private final ConstraintLayout rootView;
    public final Guideline startGuideline;
    public final TextView title;
    public final Guideline topGuideline;

    private DialogConnectionTipsBinding(ConstraintLayout constraintLayout, Guideline guideline, MaterialButton materialButton, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, Guideline guideline2, Guideline guideline3, TextView textView6, Guideline guideline4) {
        this.rootView = constraintLayout;
        this.bottomGuideline = guideline;
        this.confirmButton = materialButton;
        this.contentText1 = textView;
        this.contentText2 = textView2;
        this.contentText3 = textView3;
        this.contentText4 = textView4;
        this.contentText5 = textView5;
        this.dot1 = imageView;
        this.dot2 = imageView2;
        this.dot3 = imageView3;
        this.dot4 = imageView4;
        this.dot5 = imageView5;
        this.endGuideline = guideline2;
        this.startGuideline = guideline3;
        this.title = textView6;
        this.topGuideline = guideline4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogConnectionTipsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogConnectionTipsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_connection_tips, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogConnectionTipsBinding bind(View view) {
        View view2 = view;
        int i = R.id.bottom_guideline;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view2, i);
        if (guideline != null) {
            i = R.id.confirm_button;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view2, i);
            if (materialButton != null) {
                i = R.id.content_text1;
                TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                if (textView != null) {
                    i = R.id.content_text2;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                    if (textView2 != null) {
                        i = R.id.content_text3;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                        if (textView3 != null) {
                            i = R.id.content_text4;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                            if (textView4 != null) {
                                i = R.id.content_text5;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                                if (textView5 != null) {
                                    i = R.id.dot_1;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
                                    if (imageView != null) {
                                        i = R.id.dot_2;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                        if (imageView2 != null) {
                                            i = R.id.dot_3;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                            if (imageView3 != null) {
                                                i = R.id.dot_4;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                if (imageView4 != null) {
                                                    i = R.id.dot_5;
                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                    if (imageView5 != null) {
                                                        i = R.id.end_guideline;
                                                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view2, i);
                                                        if (guideline2 != null) {
                                                            i = R.id.start_guideline;
                                                            Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view2, i);
                                                            if (guideline3 != null) {
                                                                i = R.id.title;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                if (textView6 != null) {
                                                                    i = R.id.top_guideline;
                                                                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view2, i);
                                                                    if (guideline4 != null) {
                                                                        return new DialogConnectionTipsBinding((ConstraintLayout) view2, guideline, materialButton, textView, textView2, textView3, textView4, textView5, imageView, imageView2, imageView3, imageView4, imageView5, guideline2, guideline3, textView6, guideline4);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
