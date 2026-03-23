package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentWhPermissionsBinding implements ViewBinding {
    public final MaterialButton btnBack;
    public final TextView btnGtsAutostart;
    public final TextView btnGtsLocation;
    public final TextView btnGtsPowerManagement;
    public final MaterialButton btnNext;
    public final LinearLayout containerSecondPage;
    public final LinearLayout containerThirdPage;
    private final LinearLayout rootView;
    public final TextView tvPermissionsTitle;
    public final TextView tvScheduleAffect;

    private DialogfragmentWhPermissionsBinding(LinearLayout linearLayout, MaterialButton materialButton, TextView textView, TextView textView2, TextView textView3, MaterialButton materialButton2, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.btnBack = materialButton;
        this.btnGtsAutostart = textView;
        this.btnGtsLocation = textView2;
        this.btnGtsPowerManagement = textView3;
        this.btnNext = materialButton2;
        this.containerSecondPage = linearLayout2;
        this.containerThirdPage = linearLayout3;
        this.tvPermissionsTitle = textView4;
        this.tvScheduleAffect = textView5;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogfragmentWhPermissionsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogfragmentWhPermissionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_wh_permissions, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogfragmentWhPermissionsBinding bind(View view) {
        int i = R.id.btn_back;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.btn_gts_autostart;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.btn_gts_location;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.btn_gts_power_management;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.btn_next;
                        MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                        if (materialButton2 != null) {
                            i = R.id.container_second_page;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = R.id.container_third_page;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout2 != null) {
                                    i = R.id.tv_permissions_title;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.tv_schedule_affect;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            return new DialogfragmentWhPermissionsBinding((LinearLayout) view, materialButton, textView, textView2, textView3, materialButton2, linearLayout, linearLayout2, textView4, textView5);
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
