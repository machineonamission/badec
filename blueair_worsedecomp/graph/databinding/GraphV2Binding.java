package com.blueair.graph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.blueair.graph.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.github.mikephil.charting.charts.LineChart;

public final class GraphV2Binding implements ViewBinding {
    public final Barrier barrierLabelYStart;
    public final ConstraintLayout clLegendAqi;
    public final ConstraintLayout clLegendHum;
    public final View dividerH1;
    public final View dividerH2;
    public final View dividerH3;
    public final View dividerH4;
    public final View dividerH5;
    public final View dividerH6;
    public final View dividerH7;
    public final View dividerHBottom;
    public final View dividerHHidden;
    public final View dividerHTop;
    public final View gradientHum;
    public final Group groupAqi;
    public final Group groupHum;
    public final Group groupTmp;
    public final TextView labelYAqi1;
    public final TextView labelYAqi2;
    public final TextView labelYAqi3;
    public final TextView labelYAqi4;
    public final TextView labelYAqi5;
    public final TextView labelYHum1;
    public final TextView labelYHum2;
    public final TextView labelYHum3;
    public final TextView labelYHum4;
    public final TextView labelYTmp1;
    public final TextView labelYTmp2;
    public final TextView labelYTmp3;
    public final TextView labelYTmp4;
    public final TextView labelYTmp5;
    public final TextView labelYTmp6;
    public final TextView legendAqi1;
    public final TextView legendAqi2;
    public final TextView legendAqi3;
    public final TextView legendAqi4;
    public final TextView legendAqi5;
    public final TextView legendHum1;
    public final TextView legendHum2;
    public final TextView legendHum3;
    public final View legendYAqi1;
    public final View legendYAqi2;
    public final View legendYAqi3;
    public final View legendYAqi4;
    public final View legendYAqi5;
    public final View legendYHum1;
    public final View legendYHum2;
    public final View legendYHum3;
    public final LineChart lineChart;
    public final ProgressBlockerView progressView;
    private final ConstraintLayout rootView;
    public final View scrollIndicator;
    public final FrameLayout scrollIndicatorTrack;
    public final TextView timeLabel;

    private GraphV2Binding(ConstraintLayout constraintLayout, Barrier barrier, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, View view, View view2, View view3, View view4, View view5, View view6, View view7, View view8, View view9, View view10, View view11, Group group, Group group2, Group group3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, View view12, View view13, View view14, View view15, View view16, View view17, View view18, View view19, LineChart lineChart2, ProgressBlockerView progressBlockerView, View view20, FrameLayout frameLayout, TextView textView24) {
        this.rootView = constraintLayout;
        this.barrierLabelYStart = barrier;
        this.clLegendAqi = constraintLayout2;
        this.clLegendHum = constraintLayout3;
        this.dividerH1 = view;
        this.dividerH2 = view2;
        this.dividerH3 = view3;
        this.dividerH4 = view4;
        this.dividerH5 = view5;
        this.dividerH6 = view6;
        this.dividerH7 = view7;
        this.dividerHBottom = view8;
        this.dividerHHidden = view9;
        this.dividerHTop = view10;
        this.gradientHum = view11;
        this.groupAqi = group;
        this.groupHum = group2;
        this.groupTmp = group3;
        this.labelYAqi1 = textView;
        this.labelYAqi2 = textView2;
        this.labelYAqi3 = textView3;
        this.labelYAqi4 = textView4;
        this.labelYAqi5 = textView5;
        this.labelYHum1 = textView6;
        this.labelYHum2 = textView7;
        this.labelYHum3 = textView8;
        this.labelYHum4 = textView9;
        this.labelYTmp1 = textView10;
        this.labelYTmp2 = textView11;
        this.labelYTmp3 = textView12;
        this.labelYTmp4 = textView13;
        this.labelYTmp5 = textView14;
        this.labelYTmp6 = textView15;
        this.legendAqi1 = textView16;
        this.legendAqi2 = textView17;
        this.legendAqi3 = textView18;
        this.legendAqi4 = textView19;
        this.legendAqi5 = textView20;
        this.legendHum1 = textView21;
        this.legendHum2 = textView22;
        this.legendHum3 = textView23;
        this.legendYAqi1 = view12;
        this.legendYAqi2 = view13;
        this.legendYAqi3 = view14;
        this.legendYAqi4 = view15;
        this.legendYAqi5 = view16;
        this.legendYHum1 = view17;
        this.legendYHum2 = view18;
        this.legendYHum3 = view19;
        this.lineChart = lineChart2;
        this.progressView = progressBlockerView;
        this.scrollIndicator = view20;
        this.scrollIndicatorTrack = frameLayout;
        this.timeLabel = textView24;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GraphV2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static GraphV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.graph_v2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x020b, code lost:
        r1 = com.blueair.graph.R.id.scroll_indicator;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0033, code lost:
        r1 = com.blueair.graph.R.id.divider_h_3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        r1 = com.blueair.graph.R.id.divider_h_4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        r1 = com.blueair.graph.R.id.divider_h_5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004b, code lost:
        r1 = com.blueair.graph.R.id.divider_h_6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
        r1 = com.blueair.graph.R.id.divider_h_7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        r1 = com.blueair.graph.R.id.divider_h_bottom;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        r1 = com.blueair.graph.R.id.divider_h_hidden;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006b, code lost:
        r1 = com.blueair.graph.R.id.divider_h_top;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        r1 = com.blueair.graph.R.id.gradient_hum;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r1 = com.blueair.graph.R.id.divider_h_1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01b3, code lost:
        r1 = com.blueair.graph.R.id.legend_y_aqi_1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bb, code lost:
        r1 = com.blueair.graph.R.id.legend_y_aqi_2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01c3, code lost:
        r1 = com.blueair.graph.R.id.legend_y_aqi_3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01cb, code lost:
        r1 = com.blueair.graph.R.id.legend_y_aqi_4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01d3, code lost:
        r1 = com.blueair.graph.R.id.legend_y_aqi_5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002b, code lost:
        r1 = com.blueair.graph.R.id.divider_h_2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01db, code lost:
        r1 = com.blueair.graph.R.id.legend_y_hum_1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01e3, code lost:
        r1 = com.blueair.graph.R.id.legend_y_hum_2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01eb, code lost:
        r1 = com.blueair.graph.R.id.legend_y_hum_3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.graph.databinding.GraphV2Binding bind(android.view.View r58) {
        /*
            r0 = r58
            int r1 = com.blueair.graph.R.id.barrier_label_y_start
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.Barrier r5 = (androidx.constraintlayout.widget.Barrier) r5
            if (r5 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.cl_legend_aqi
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.cl_legend_hum
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.divider_h_1
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r8 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.divider_h_2
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r9 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.divider_h_3
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r10 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.divider_h_4
            android.view.View r11 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r11 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.divider_h_5
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r12 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.divider_h_6
            android.view.View r13 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r13 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.divider_h_7
            android.view.View r14 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r14 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.divider_h_bottom
            android.view.View r15 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r15 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.divider_h_hidden
            android.view.View r16 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r16 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.divider_h_top
            android.view.View r17 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r17 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.gradient_hum
            android.view.View r18 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r18 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.group_aqi
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            androidx.constraintlayout.widget.Group r19 = (androidx.constraintlayout.widget.Group) r19
            if (r19 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.group_hum
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            androidx.constraintlayout.widget.Group r20 = (androidx.constraintlayout.widget.Group) r20
            if (r20 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.group_tmp
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            androidx.constraintlayout.widget.Group r21 = (androidx.constraintlayout.widget.Group) r21
            if (r21 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.label_y_aqi_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.label_y_aqi_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.label_y_aqi_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.label_y_aqi_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            android.widget.TextView r25 = (android.widget.TextView) r25
            if (r25 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.label_y_aqi_5
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            android.widget.TextView r26 = (android.widget.TextView) r26
            if (r26 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.label_y_hum_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            android.widget.TextView r27 = (android.widget.TextView) r27
            if (r27 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.label_y_hum_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            android.widget.TextView r28 = (android.widget.TextView) r28
            if (r28 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.label_y_hum_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r29 = r2
            android.widget.TextView r29 = (android.widget.TextView) r29
            if (r29 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.label_y_hum_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r30 = r2
            android.widget.TextView r30 = (android.widget.TextView) r30
            if (r30 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.label_y_tmp_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r31 = r2
            android.widget.TextView r31 = (android.widget.TextView) r31
            if (r31 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.label_y_tmp_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r32 = r2
            android.widget.TextView r32 = (android.widget.TextView) r32
            if (r32 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.label_y_tmp_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r33 = r2
            android.widget.TextView r33 = (android.widget.TextView) r33
            if (r33 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.label_y_tmp_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r34 = r2
            android.widget.TextView r34 = (android.widget.TextView) r34
            if (r34 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.label_y_tmp_5
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r35 = r2
            android.widget.TextView r35 = (android.widget.TextView) r35
            if (r35 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.label_y_tmp_6
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r36 = r2
            android.widget.TextView r36 = (android.widget.TextView) r36
            if (r36 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.legend_aqi_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r37 = r2
            android.widget.TextView r37 = (android.widget.TextView) r37
            if (r37 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.legend_aqi_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r38 = r2
            android.widget.TextView r38 = (android.widget.TextView) r38
            if (r38 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.legend_aqi_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r39 = r2
            android.widget.TextView r39 = (android.widget.TextView) r39
            if (r39 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.legend_aqi_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r40 = r2
            android.widget.TextView r40 = (android.widget.TextView) r40
            if (r40 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.legend_aqi_5
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r41 = r2
            android.widget.TextView r41 = (android.widget.TextView) r41
            if (r41 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.legend_hum_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r42 = r2
            android.widget.TextView r42 = (android.widget.TextView) r42
            if (r42 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.legend_hum_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r43 = r2
            android.widget.TextView r43 = (android.widget.TextView) r43
            if (r43 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.legend_hum_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r44 = r2
            android.widget.TextView r44 = (android.widget.TextView) r44
            if (r44 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.legend_y_aqi_1
            android.view.View r45 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r45 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.legend_y_aqi_2
            android.view.View r46 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r46 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.legend_y_aqi_3
            android.view.View r47 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r47 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.legend_y_aqi_4
            android.view.View r48 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r48 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.legend_y_aqi_5
            android.view.View r49 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r49 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.legend_y_hum_1
            android.view.View r50 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r50 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.legend_y_hum_2
            android.view.View r51 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r51 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.legend_y_hum_3
            android.view.View r52 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r52 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.lineChart
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r53 = r2
            com.github.mikephil.charting.charts.LineChart r53 = (com.github.mikephil.charting.charts.LineChart) r53
            if (r53 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.progressView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r54 = r2
            com.blueair.viewcore.view.ProgressBlockerView r54 = (com.blueair.viewcore.view.ProgressBlockerView) r54
            if (r54 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.scroll_indicator
            android.view.View r55 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r55 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.scroll_indicator_track
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r56 = r2
            android.widget.FrameLayout r56 = (android.widget.FrameLayout) r56
            if (r56 == 0) goto L_0x0234
            int r1 = com.blueair.graph.R.id.time_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r57 = r2
            android.widget.TextView r57 = (android.widget.TextView) r57
            if (r57 == 0) goto L_0x0234
            com.blueair.graph.databinding.GraphV2Binding r3 = new com.blueair.graph.databinding.GraphV2Binding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57)
            return r3
        L_0x0234:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.databinding.GraphV2Binding.bind(android.view.View):com.blueair.graph.databinding.GraphV2Binding");
    }
}
