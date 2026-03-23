package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.blueair.graph.view.GraphViewV2;
import com.blueair.viewcore.view.SwitchCompat;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;

public final class FragmentDeviceSensorsGraphBinding implements ViewBinding {
    public final ImageView aqiIcon;
    public final TextView aqiValue;
    public final MaterialButton btnAbout;
    public final View clickView;
    public final TextView descriptionText;
    public final TextView dropdownMenuScale;
    public final TextView dropdownMenuSensors;
    public final SwitchCompat expendSwitch;
    public final Group expendedContent;
    public final GraphViewV2 graph;
    public final ImageView leadingIcon;
    private final ShadowLayout rootView;
    public final TextView title;

    private FragmentDeviceSensorsGraphBinding(ShadowLayout shadowLayout, ImageView imageView, TextView textView, MaterialButton materialButton, View view, TextView textView2, TextView textView3, TextView textView4, SwitchCompat switchCompat, Group group, GraphViewV2 graphViewV2, ImageView imageView2, TextView textView5) {
        this.rootView = shadowLayout;
        this.aqiIcon = imageView;
        this.aqiValue = textView;
        this.btnAbout = materialButton;
        this.clickView = view;
        this.descriptionText = textView2;
        this.dropdownMenuScale = textView3;
        this.dropdownMenuSensors = textView4;
        this.expendSwitch = switchCompat;
        this.expendedContent = group;
        this.graph = graphViewV2;
        this.leadingIcon = imageView2;
        this.title = textView5;
    }

    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDeviceSensorsGraphBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentDeviceSensorsGraphBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_device_sensors_graph, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r1 = com.blueair.devicedetails.R.id.click_view;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.FragmentDeviceSensorsGraphBinding bind(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.blueair.devicedetails.R.id.aqi_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.aqi_value
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.btn_about
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            com.google.android.material.button.MaterialButton r7 = (com.google.android.material.button.MaterialButton) r7
            if (r7 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.click_view
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r8 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.description_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.dropdown_menu_scale
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.dropdown_menu_sensors
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.expend_switch
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            com.blueair.viewcore.view.SwitchCompat r12 = (com.blueair.viewcore.view.SwitchCompat) r12
            if (r12 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.expended_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.constraintlayout.widget.Group r13 = (androidx.constraintlayout.widget.Group) r13
            if (r13 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.graph
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            com.blueair.graph.view.GraphViewV2 r14 = (com.blueair.graph.view.GraphViewV2) r14
            if (r14 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.leading_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            if (r15 == 0) goto L_0x008d
            int r1 = com.blueair.devicedetails.R.id.title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x008d
            com.blueair.devicedetails.databinding.FragmentDeviceSensorsGraphBinding r3 = new com.blueair.devicedetails.databinding.FragmentDeviceSensorsGraphBinding
            r4 = r0
            com.dd.ShadowLayout r4 = (com.dd.ShadowLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r3
        L_0x008d:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.FragmentDeviceSensorsGraphBinding.bind(android.view.View):com.blueair.devicedetails.databinding.FragmentDeviceSensorsGraphBinding");
    }
}
