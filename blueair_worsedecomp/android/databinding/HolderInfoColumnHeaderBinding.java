package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blueair.android.R;

public final class HolderInfoColumnHeaderBinding implements ViewBinding {
    public final FrameLayout regularSettingLayout;
    private final FrameLayout rootView;
    public final TextView tvTitle;
    public final View vBg;
    public final View vBottom;
    public final View vTop;

    private HolderInfoColumnHeaderBinding(FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView, View view, View view2, View view3) {
        this.rootView = frameLayout;
        this.regularSettingLayout = frameLayout2;
        this.tvTitle = textView;
        this.vBg = view;
        this.vBottom = view2;
        this.vTop = view3;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HolderInfoColumnHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderInfoColumnHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_info_column_header, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r0 = com.blueair.android.R.id.v_bg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.blueair.android.R.id.v_bottom;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        r0 = com.blueair.android.R.id.v_top;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.android.databinding.HolderInfoColumnHeaderBinding bind(android.view.View r7) {
        /*
            r1 = r7
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            int r0 = com.blueair.android.R.id.tv_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            r3 = r2
            android.widget.TextView r3 = (android.widget.TextView) r3
            if (r3 == 0) goto L_0x002d
            int r0 = com.blueair.android.R.id.v_bg
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            if (r4 == 0) goto L_0x002d
            int r0 = com.blueair.android.R.id.v_bottom
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            if (r5 == 0) goto L_0x002d
            int r0 = com.blueair.android.R.id.v_top
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            if (r6 == 0) goto L_0x002d
            com.blueair.android.databinding.HolderInfoColumnHeaderBinding r0 = new com.blueair.android.databinding.HolderInfoColumnHeaderBinding
            r2 = r1
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r0
        L_0x002d:
            android.content.res.Resources r7 = r7.getResources()
            java.lang.String r7 = r7.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.databinding.HolderInfoColumnHeaderBinding.bind(android.view.View):com.blueair.android.databinding.HolderInfoColumnHeaderBinding");
    }
}
