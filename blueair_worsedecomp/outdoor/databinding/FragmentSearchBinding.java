package com.blueair.outdoor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.outdoor.R;

public final class FragmentSearchBinding implements ViewBinding {
    public final Button cancelBtn;
    public final Guideline endGuideline;
    public final TextView headerTextView;
    public final TextView noResultsTextView;
    private final ConstraintLayout rootView;
    public final EditText searchBar;
    public final ImageButton searchClearBtn;
    public final RecyclerView searchResults;
    public final Guideline startGuideline;
    public final Guideline topGuideline;

    private FragmentSearchBinding(ConstraintLayout constraintLayout, Button button, Guideline guideline, TextView textView, TextView textView2, EditText editText, ImageButton imageButton, RecyclerView recyclerView, Guideline guideline2, Guideline guideline3) {
        this.rootView = constraintLayout;
        this.cancelBtn = button;
        this.endGuideline = guideline;
        this.headerTextView = textView;
        this.noResultsTextView = textView2;
        this.searchBar = editText;
        this.searchClearBtn = imageButton;
        this.searchResults = recyclerView;
        this.startGuideline = guideline2;
        this.topGuideline = guideline3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSearchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_search, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentSearchBinding bind(View view) {
        int i = R.id.cancel_btn;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.end_guideline;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline != null) {
                i = R.id.headerTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.noResultsTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.search_bar;
                        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText != null) {
                            i = R.id.search_clear_btn;
                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
                            if (imageButton != null) {
                                i = R.id.search_results;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                if (recyclerView != null) {
                                    i = R.id.start_guideline;
                                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline2 != null) {
                                        i = R.id.top_guideline;
                                        Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                        if (guideline3 != null) {
                                            return new FragmentSearchBinding((ConstraintLayout) view, button, guideline, textView, textView2, editText, imageButton, recyclerView, guideline2, guideline3);
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
