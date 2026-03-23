package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentWhExploreBinding implements ViewBinding {
    public final MaterialButton buttonNeverShow;
    public final MaterialButton buttonProceed;
    public final MaterialButton buttonTryLater;
    public final ImageView imClose;
    public final ImageView imWelcomeHome;
    private final LinearLayout rootView;

    private DialogfragmentWhExploreBinding(LinearLayout linearLayout, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, ImageView imageView, ImageView imageView2) {
        this.rootView = linearLayout;
        this.buttonNeverShow = materialButton;
        this.buttonProceed = materialButton2;
        this.buttonTryLater = materialButton3;
        this.imClose = imageView;
        this.imWelcomeHome = imageView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogfragmentWhExploreBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogfragmentWhExploreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_wh_explore, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogfragmentWhExploreBinding bind(View view) {
        int i = R.id.buttonNeverShow;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.buttonProceed;
            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton2 != null) {
                i = R.id.buttonTryLater;
                MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton3 != null) {
                    i = R.id.imClose;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.imWelcomeHome;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            return new DialogfragmentWhExploreBinding((LinearLayout) view, materialButton, materialButton2, materialButton3, imageView, imageView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
