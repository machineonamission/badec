package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.blueair.viewcore.R;

public final class SimpleTextWithFamilyWeight500Binding implements ViewBinding {
    private final AppCompatTextView rootView;
    public final AppCompatTextView tvText;

    private SimpleTextWithFamilyWeight500Binding(AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.rootView = appCompatTextView;
        this.tvText = appCompatTextView2;
    }

    public AppCompatTextView getRoot() {
        return this.rootView;
    }

    public static SimpleTextWithFamilyWeight500Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SimpleTextWithFamilyWeight500Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.simple_text_with_family_weight500, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SimpleTextWithFamilyWeight500Binding bind(View view) {
        if (view != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) view;
            return new SimpleTextWithFamilyWeight500Binding(appCompatTextView, appCompatTextView);
        }
        throw new NullPointerException("rootView");
    }
}
