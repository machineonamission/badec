package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public final class ActivityAddDeviceLegacyBinding implements ViewBinding {
    public final AppBarLayout addDeviceAppbar;
    public final Toolbar addDeviceToolbar;
    public final AppCompatImageButton btnBack;
    public final AppCompatImageButton btnClose;
    public final CollapsingToolbarLayout collapsingToolbar;
    public final FrameLayout contentFragment;
    public final AppCompatTextView headerMsg;
    public final AppCompatTextView headerTitle;
    public final CoordinatorLayout layoutAddDeviceCoordinator;
    public final ConstraintLayout layoutExpandedToolbar;
    private final FrameLayout rootView;
    public final AppCompatTextView tvFirst;
    public final AppCompatTextView tvNext;

    private ActivityAddDeviceLegacyBinding(FrameLayout frameLayout, AppBarLayout appBarLayout, Toolbar toolbar, AppCompatImageButton appCompatImageButton, AppCompatImageButton appCompatImageButton2, CollapsingToolbarLayout collapsingToolbarLayout, FrameLayout frameLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, CoordinatorLayout coordinatorLayout, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.rootView = frameLayout;
        this.addDeviceAppbar = appBarLayout;
        this.addDeviceToolbar = toolbar;
        this.btnBack = appCompatImageButton;
        this.btnClose = appCompatImageButton2;
        this.collapsingToolbar = collapsingToolbarLayout;
        this.contentFragment = frameLayout2;
        this.headerMsg = appCompatTextView;
        this.headerTitle = appCompatTextView2;
        this.layoutAddDeviceCoordinator = coordinatorLayout;
        this.layoutExpandedToolbar = constraintLayout;
        this.tvFirst = appCompatTextView3;
        this.tvNext = appCompatTextView4;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAddDeviceLegacyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityAddDeviceLegacyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_add_device_legacy, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityAddDeviceLegacyBinding bind(View view) {
        View view2 = view;
        int i = R.id.add_device_appbar;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view2, i);
        if (appBarLayout != null) {
            i = R.id.add_device_toolbar;
            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, i);
            if (toolbar != null) {
                i = R.id.btnBack;
                AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view2, i);
                if (appCompatImageButton != null) {
                    i = R.id.btnClose;
                    AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) ViewBindings.findChildViewById(view2, i);
                    if (appCompatImageButton2 != null) {
                        i = R.id.collapsing_toolbar;
                        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) ViewBindings.findChildViewById(view2, i);
                        if (collapsingToolbarLayout != null) {
                            i = R.id.content_fragment;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, i);
                            if (frameLayout != null) {
                                i = R.id.header_msg;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view2, i);
                                if (appCompatTextView != null) {
                                    i = R.id.header_title;
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view2, i);
                                    if (appCompatTextView2 != null) {
                                        i = R.id.layout_add_device_coordinator;
                                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view2, i);
                                        if (coordinatorLayout != null) {
                                            i = R.id.layout_expanded_toolbar;
                                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                            if (constraintLayout != null) {
                                                i = R.id.tv_first;
                                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(view2, i);
                                                if (appCompatTextView3 != null) {
                                                    i = R.id.tv_next;
                                                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.findChildViewById(view2, i);
                                                    if (appCompatTextView4 != null) {
                                                        return new ActivityAddDeviceLegacyBinding((FrameLayout) view2, appBarLayout, toolbar, appCompatImageButton, appCompatImageButton2, collapsingToolbarLayout, frameLayout, appCompatTextView, appCompatTextView2, coordinatorLayout, constraintLayout, appCompatTextView3, appCompatTextView4);
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
