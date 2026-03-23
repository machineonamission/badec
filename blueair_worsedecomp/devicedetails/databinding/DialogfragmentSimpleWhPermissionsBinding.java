package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentSimpleWhPermissionsBinding implements ViewBinding {
    public final MaterialButton btnBack;
    public final AppCompatTextView btnGtsAutostart;
    public final AppCompatTextView btnGtsPowerManagement;
    public final MaterialButton btnNext;
    public final LinearLayout containerThirdPage;
    public final AppCompatImageView ivClose;
    public final FrameLayout llTitle;
    private final LinearLayout rootView;
    public final AppCompatTextView tvAutostart;
    public final AppCompatTextView tvPermissionsTitle;
    public final AppCompatTextView tvPowerDesp;

    private DialogfragmentSimpleWhPermissionsBinding(LinearLayout linearLayout, MaterialButton materialButton, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, MaterialButton materialButton2, LinearLayout linearLayout2, AppCompatImageView appCompatImageView, FrameLayout frameLayout, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5) {
        this.rootView = linearLayout;
        this.btnBack = materialButton;
        this.btnGtsAutostart = appCompatTextView;
        this.btnGtsPowerManagement = appCompatTextView2;
        this.btnNext = materialButton2;
        this.containerThirdPage = linearLayout2;
        this.ivClose = appCompatImageView;
        this.llTitle = frameLayout;
        this.tvAutostart = appCompatTextView3;
        this.tvPermissionsTitle = appCompatTextView4;
        this.tvPowerDesp = appCompatTextView5;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogfragmentSimpleWhPermissionsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogfragmentSimpleWhPermissionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_simple_wh_permissions, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogfragmentSimpleWhPermissionsBinding bind(View view) {
        int i = R.id.btn_back;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.btn_gts_autostart;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
            if (appCompatTextView != null) {
                i = R.id.btn_gts_power_management;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                if (appCompatTextView2 != null) {
                    i = R.id.btn_next;
                    MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                    if (materialButton2 != null) {
                        i = R.id.container_third_page;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.iv_close;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                            if (appCompatImageView != null) {
                                i = R.id.ll_title;
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                if (frameLayout != null) {
                                    i = R.id.tv_autostart;
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                    if (appCompatTextView3 != null) {
                                        i = R.id.tv_permissions_title;
                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                        if (appCompatTextView4 != null) {
                                            i = R.id.tv_powerDesp;
                                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                            if (appCompatTextView5 != null) {
                                                return new DialogfragmentSimpleWhPermissionsBinding((LinearLayout) view, materialButton, appCompatTextView, appCompatTextView2, materialButton2, linearLayout, appCompatImageView, frameLayout, appCompatTextView3, appCompatTextView4, appCompatTextView5);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
