package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.blueair.antifake.R;
import com.google.android.material.button.MaterialButton;
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

public final class DialogfragmentManualResetFilterBinding implements ViewBinding {
    public final ImageButton btnBack;
    public final MaterialButton btnConfirm;
    public final TextView contentTitle;
    public final TextView customerSupportText;
    public final ScrollingPagerIndicator pageDots;
    public final ViewPager2 pager;
    private final LinearLayout rootView;
    public final TextView title;

    private DialogfragmentManualResetFilterBinding(LinearLayout linearLayout, ImageButton imageButton, MaterialButton materialButton, TextView textView, TextView textView2, ScrollingPagerIndicator scrollingPagerIndicator, ViewPager2 viewPager2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnBack = imageButton;
        this.btnConfirm = materialButton;
        this.contentTitle = textView;
        this.customerSupportText = textView2;
        this.pageDots = scrollingPagerIndicator;
        this.pager = viewPager2;
        this.title = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogfragmentManualResetFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogfragmentManualResetFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_manual_reset_filter, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogfragmentManualResetFilterBinding bind(View view) {
        int i = R.id.btn_back;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = R.id.btn_confirm;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.content_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.customer_support_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.page_dots;
                        ScrollingPagerIndicator scrollingPagerIndicator = (ScrollingPagerIndicator) ViewBindings.findChildViewById(view, i);
                        if (scrollingPagerIndicator != null) {
                            i = R.id.pager;
                            ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                            if (viewPager2 != null) {
                                i = R.id.title;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    return new DialogfragmentManualResetFilterBinding((LinearLayout) view, imageButton, materialButton, textView, textView2, scrollingPagerIndicator, viewPager2, textView3);
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
