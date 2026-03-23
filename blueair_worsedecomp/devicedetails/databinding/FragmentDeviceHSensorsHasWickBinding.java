package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.blueair.graph.view.GraphViewH;
import com.google.android.material.tabs.TabLayout;

public final class FragmentDeviceHSensorsHasWickBinding implements ViewBinding {
    public final TextView aqiData;
    public final TextView aqiTitle;
    public final ConstraintLayout contentAqi;
    public final ConstraintLayout contentHumidity;
    public final ConstraintLayout contentParticle;
    public final ConstraintLayout contentTemperature;
    public final GraphViewH deviceGraph;
    public final TabLayout graphTabs;
    public final Group groupAqi;
    public final TextView humidityData;
    public final TextView humidityTitle;
    public final TextView particleData;
    public final TextView particleTitle;
    private final ConstraintLayout rootView;
    public final View separator;
    public final View separator2;
    public final TextView temperatureData;
    public final TextView temperatureTitle;

    private FragmentDeviceHSensorsHasWickBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, GraphViewH graphViewH, TabLayout tabLayout, Group group, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view, View view2, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.aqiData = textView;
        this.aqiTitle = textView2;
        this.contentAqi = constraintLayout2;
        this.contentHumidity = constraintLayout3;
        this.contentParticle = constraintLayout4;
        this.contentTemperature = constraintLayout5;
        this.deviceGraph = graphViewH;
        this.graphTabs = tabLayout;
        this.groupAqi = group;
        this.humidityData = textView3;
        this.humidityTitle = textView4;
        this.particleData = textView5;
        this.particleTitle = textView6;
        this.separator = view;
        this.separator2 = view2;
        this.temperatureData = textView7;
        this.temperatureTitle = textView8;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDeviceHSensorsHasWickBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentDeviceHSensorsHasWickBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_device_h_sensors_has_wick, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        r1 = com.blueair.devicedetails.R.id.separator;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        r1 = com.blueair.devicedetails.R.id.separator2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.FragmentDeviceHSensorsHasWickBinding bind(android.view.View r22) {
        /*
            r0 = r22
            int r1 = com.blueair.devicedetails.R.id.aqi_data
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x00c4
            int r1 = com.blueair.devicedetails.R.id.aqi_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x00c4
            int r1 = com.blueair.devicedetails.R.id.content_aqi
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x00c4
            int r1 = com.blueair.devicedetails.R.id.content_humidity
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x00c4
            int r1 = com.blueair.devicedetails.R.id.content_particle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            if (r9 == 0) goto L_0x00c4
            int r1 = com.blueair.devicedetails.R.id.content_temperature
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            if (r10 == 0) goto L_0x00c4
            int r1 = com.blueair.devicedetails.R.id.device_graph
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            com.blueair.graph.view.GraphViewH r11 = (com.blueair.graph.view.GraphViewH) r11
            if (r11 == 0) goto L_0x00c4
            int r1 = com.blueair.devicedetails.R.id.graph_tabs
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            com.google.android.material.tabs.TabLayout r12 = (com.google.android.material.tabs.TabLayout) r12
            if (r12 == 0) goto L_0x00c4
            int r1 = com.blueair.devicedetails.R.id.group_aqi
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.constraintlayout.widget.Group r13 = (androidx.constraintlayout.widget.Group) r13
            if (r13 == 0) goto L_0x00c4
            int r1 = com.blueair.devicedetails.R.id.humidity_data
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00c4
            int r1 = com.blueair.devicedetails.R.id.humidity_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00c4
            int r1 = com.blueair.devicedetails.R.id.particle_data
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00c4
            int r1 = com.blueair.devicedetails.R.id.particle_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00c4
            int r1 = com.blueair.devicedetails.R.id.separator
            android.view.View r18 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r18 == 0) goto L_0x00c4
            int r1 = com.blueair.devicedetails.R.id.separator2
            android.view.View r19 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r19 == 0) goto L_0x00c4
            int r1 = com.blueair.devicedetails.R.id.temperature_data
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00c4
            int r1 = com.blueair.devicedetails.R.id.temperature_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00c4
            com.blueair.devicedetails.databinding.FragmentDeviceHSensorsHasWickBinding r3 = new com.blueair.devicedetails.databinding.FragmentDeviceHSensorsHasWickBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r3
        L_0x00c4:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.FragmentDeviceHSensorsHasWickBinding.bind(android.view.View):com.blueair.devicedetails.databinding.FragmentDeviceHSensorsHasWickBinding");
    }
}
