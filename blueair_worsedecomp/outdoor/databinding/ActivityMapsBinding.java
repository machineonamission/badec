package com.blueair.outdoor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.outdoor.R;
import com.blueair.outdoor.ui.adapters.LocationView;

public final class ActivityMapsBinding implements ViewBinding {
    public final ImageButton addLocationBtn;
    public final Barrier bottomBarrier;
    public final ImageButton closeBtn;
    public final ConstraintLayout constraintLayout;
    public final LocationView currentLocation;
    public final ImageButton gpsBtn;
    public final FrameLayout mapContainer;
    public final Guideline minimizedBottomGuideline;
    public final ImageView pin;
    public final Guideline rootBottomGuideline;
    public final Guideline rootLeftGuideline;
    public final Guideline rootRightGuideline;
    public final Guideline rootTopGuideline;
    private final ConstraintLayout rootView;
    public final Button savedLocationMaximizeButton;
    public final RecyclerView savedLocationRecyclerView;
    public final TextView searchBar;

    private ActivityMapsBinding(ConstraintLayout constraintLayout2, ImageButton imageButton, Barrier barrier, ImageButton imageButton2, ConstraintLayout constraintLayout3, LocationView locationView, ImageButton imageButton3, FrameLayout frameLayout, Guideline guideline, ImageView imageView, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Button button, RecyclerView recyclerView, TextView textView) {
        this.rootView = constraintLayout2;
        this.addLocationBtn = imageButton;
        this.bottomBarrier = barrier;
        this.closeBtn = imageButton2;
        this.constraintLayout = constraintLayout3;
        this.currentLocation = locationView;
        this.gpsBtn = imageButton3;
        this.mapContainer = frameLayout;
        this.minimizedBottomGuideline = guideline;
        this.pin = imageView;
        this.rootBottomGuideline = guideline2;
        this.rootLeftGuideline = guideline3;
        this.rootRightGuideline = guideline4;
        this.rootTopGuideline = guideline5;
        this.savedLocationMaximizeButton = button;
        this.savedLocationRecyclerView = recyclerView;
        this.searchBar = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMapsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityMapsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_maps, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMapsBinding bind(View view) {
        View view2 = view;
        int i = R.id.add_location_btn;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, i);
        if (imageButton != null) {
            i = R.id.bottom_barrier;
            Barrier barrier = (Barrier) ViewBindings.findChildViewById(view2, i);
            if (barrier != null) {
                i = R.id.close_btn;
                ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view2, i);
                if (imageButton2 != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view2;
                    i = R.id.current_location;
                    LocationView locationView = (LocationView) ViewBindings.findChildViewById(view2, i);
                    if (locationView != null) {
                        i = R.id.gps_btn;
                        ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view2, i);
                        if (imageButton3 != null) {
                            i = R.id.map_container;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, i);
                            if (frameLayout != null) {
                                i = R.id.minimized_bottom_guideline;
                                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view2, i);
                                if (guideline != null) {
                                    i = R.id.pin;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
                                    if (imageView != null) {
                                        i = R.id.root_bottom_guideline;
                                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view2, i);
                                        if (guideline2 != null) {
                                            i = R.id.root_left_guideline;
                                            Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view2, i);
                                            if (guideline3 != null) {
                                                i = R.id.root_right_guideline;
                                                Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view2, i);
                                                if (guideline4 != null) {
                                                    i = R.id.root_top_guideline;
                                                    Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view2, i);
                                                    if (guideline5 != null) {
                                                        i = R.id.saved_location_maximize_button;
                                                        Button button = (Button) ViewBindings.findChildViewById(view2, i);
                                                        if (button != null) {
                                                            i = R.id.saved_location_recycler_view;
                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, i);
                                                            if (recyclerView != null) {
                                                                i = R.id.search_bar;
                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                if (textView != null) {
                                                                    return new ActivityMapsBinding(constraintLayout2, imageButton, barrier, imageButton2, constraintLayout2, locationView, imageButton3, frameLayout, guideline, imageView, guideline2, guideline3, guideline4, guideline5, button, recyclerView, textView);
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
