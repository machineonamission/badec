package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class HolderDeviceAutoRefreshBinding implements ViewBinding {
    public final ConstraintLayout autoRefreshContainer;
    public final MaterialButton btnCancel;
    public final Button btnCloseHint;
    public final LinearLayout contentContainer;
    public final TextView durationText;
    public final Group expendedContent;
    public final ConstraintLayout hintContainer;
    public final TextView hintText;
    public final ImageView infoIcon;
    public final ImageView leadingIcon;
    public final TextView leftTimeText;
    public final LinearProgressIndicator progressIndicator;
    private final LinearLayout rootView;
    public final TextView title;

    private HolderDeviceAutoRefreshBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, MaterialButton materialButton, Button button, LinearLayout linearLayout2, TextView textView, Group group, ConstraintLayout constraintLayout2, TextView textView2, ImageView imageView, ImageView imageView2, TextView textView3, LinearProgressIndicator linearProgressIndicator, TextView textView4) {
        this.rootView = linearLayout;
        this.autoRefreshContainer = constraintLayout;
        this.btnCancel = materialButton;
        this.btnCloseHint = button;
        this.contentContainer = linearLayout2;
        this.durationText = textView;
        this.expendedContent = group;
        this.hintContainer = constraintLayout2;
        this.hintText = textView2;
        this.infoIcon = imageView;
        this.leadingIcon = imageView2;
        this.leftTimeText = textView3;
        this.progressIndicator = linearProgressIndicator;
        this.title = textView4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceAutoRefreshBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceAutoRefreshBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_auto_refresh, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceAutoRefreshBinding bind(View view) {
        View view2 = view;
        int i = R.id.auto_refresh_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
        if (constraintLayout != null) {
            i = R.id.btn_cancel;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view2, i);
            if (materialButton != null) {
                i = R.id.btn_close_hint;
                Button button = (Button) ViewBindings.findChildViewById(view2, i);
                if (button != null) {
                    LinearLayout linearLayout = (LinearLayout) view2;
                    i = R.id.duration_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                    if (textView != null) {
                        i = R.id.expended_content;
                        Group group = (Group) ViewBindings.findChildViewById(view2, i);
                        if (group != null) {
                            i = R.id.hint_container;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                            if (constraintLayout2 != null) {
                                i = R.id.hint_text;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                                if (textView2 != null) {
                                    i = R.id.info_icon;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
                                    if (imageView != null) {
                                        i = R.id.leading_icon;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                        if (imageView2 != null) {
                                            i = R.id.left_time_text;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                            if (textView3 != null) {
                                                i = R.id.progress_indicator;
                                                LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(view2, i);
                                                if (linearProgressIndicator != null) {
                                                    i = R.id.title;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                    if (textView4 != null) {
                                                        return new HolderDeviceAutoRefreshBinding(linearLayout, constraintLayout, materialButton, button, linearLayout, textView, group, constraintLayout2, textView2, imageView, imageView2, textView3, linearProgressIndicator, textView4);
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
