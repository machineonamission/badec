package com.blueair.graph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.blueair.graph.R;

public final class MarkerviewDotNewBinding implements ViewBinding {
    public final View dashedLine;
    public final View markerDot;
    private final FrameLayout rootView;

    private MarkerviewDotNewBinding(FrameLayout frameLayout, View view, View view2) {
        this.rootView = frameLayout;
        this.dashedLine = view;
        this.markerDot = view2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MarkerviewDotNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static MarkerviewDotNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.markerview_dot_new, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = com.blueair.graph.R.id.marker_dot;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.graph.databinding.MarkerviewDotNewBinding bind(android.view.View r3) {
        /*
            int r0 = com.blueair.graph.R.id.dashed_line
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            if (r1 == 0) goto L_0x0018
            int r0 = com.blueair.graph.R.id.marker_dot
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            if (r2 == 0) goto L_0x0018
            com.blueair.graph.databinding.MarkerviewDotNewBinding r0 = new com.blueair.graph.databinding.MarkerviewDotNewBinding
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            r0.<init>(r3, r1, r2)
            return r0
        L_0x0018:
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r3 = r3.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r3 = r1.concat(r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.databinding.MarkerviewDotNewBinding.bind(android.view.View):com.blueair.graph.databinding.MarkerviewDotNewBinding");
    }
}
