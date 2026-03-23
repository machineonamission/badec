package com.blueair.graph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.blueair.graph.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.github.mikephil.charting.charts.LineChart;

public final class GraphHBinding implements ViewBinding {
    public final Barrier barrierLabelYStart;
    public final Barrier barrierLegendBottom;
    public final View dividerH1;
    public final View dividerH2;
    public final View dividerH3;
    public final View dividerH4;
    public final View dividerH5;
    public final View dividerHBottom;
    public final View dividerHTop;
    public final TextView graphTitle;
    public final FrameLayout graphTitleContainer;
    public final Group groupAqi;
    public final Group groupHum;
    public final Group groupTmp;
    public final TextView labelYHum1;
    public final TextView labelYHum2;
    public final TextView labelYHum3;
    public final TextView labelYHum4;
    public final TextView labelYHum5;
    public final TextView labelYHum6;
    public final TextView labelYHum7;
    public final TextView labelYTmp1;
    public final TextView labelYTmp2;
    public final TextView labelYTmp3;
    public final TextView labelYTmp4;
    public final TextView labelYTmp5;
    public final TextView labelYTmp6;
    public final TextView labelYTmp7;
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
    public final RadioGroup radioGroupTimeScale;
    public final RadioButton rbDay;
    public final RadioButton rbMonth;
    public final RadioButton rbWeek;
    public final View rgSeparator1;
    public final View rgSeparator2;
    private final ConstraintLayout rootView;
    public final View scrollIndicator;
    public final FrameLayout scrollIndicatorTrack;
    public final TextView timeLabel;

    private GraphHBinding(ConstraintLayout constraintLayout, Barrier barrier, Barrier barrier2, View view, View view2, View view3, View view4, View view5, View view6, View view7, TextView textView, FrameLayout frameLayout, Group group, Group group2, Group group3, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, View view8, View view9, View view10, View view11, View view12, View view13, View view14, View view15, LineChart lineChart2, ProgressBlockerView progressBlockerView, RadioGroup radioGroup, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, View view16, View view17, View view18, FrameLayout frameLayout2, TextView textView24) {
        this.rootView = constraintLayout;
        this.barrierLabelYStart = barrier;
        this.barrierLegendBottom = barrier2;
        this.dividerH1 = view;
        this.dividerH2 = view2;
        this.dividerH3 = view3;
        this.dividerH4 = view4;
        this.dividerH5 = view5;
        this.dividerHBottom = view6;
        this.dividerHTop = view7;
        this.graphTitle = textView;
        this.graphTitleContainer = frameLayout;
        this.groupAqi = group;
        this.groupHum = group2;
        this.groupTmp = group3;
        this.labelYHum1 = textView2;
        this.labelYHum2 = textView3;
        this.labelYHum3 = textView4;
        this.labelYHum4 = textView5;
        this.labelYHum5 = textView6;
        this.labelYHum6 = textView7;
        this.labelYHum7 = textView8;
        this.labelYTmp1 = textView9;
        this.labelYTmp2 = textView10;
        this.labelYTmp3 = textView11;
        this.labelYTmp4 = textView12;
        this.labelYTmp5 = textView13;
        this.labelYTmp6 = textView14;
        this.labelYTmp7 = textView15;
        this.legendAqi1 = textView16;
        this.legendAqi2 = textView17;
        this.legendAqi3 = textView18;
        this.legendAqi4 = textView19;
        this.legendAqi5 = textView20;
        this.legendHum1 = textView21;
        this.legendHum2 = textView22;
        this.legendHum3 = textView23;
        this.legendYAqi1 = view8;
        this.legendYAqi2 = view9;
        this.legendYAqi3 = view10;
        this.legendYAqi4 = view11;
        this.legendYAqi5 = view12;
        this.legendYHum1 = view13;
        this.legendYHum2 = view14;
        this.legendYHum3 = view15;
        this.lineChart = lineChart2;
        this.progressView = progressBlockerView;
        this.radioGroupTimeScale = radioGroup;
        this.rbDay = radioButton;
        this.rbMonth = radioButton2;
        this.rbWeek = radioButton3;
        this.rgSeparator1 = view16;
        this.rgSeparator2 = view17;
        this.scrollIndicator = view18;
        this.scrollIndicatorTrack = frameLayout2;
        this.timeLabel = textView24;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GraphHBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static GraphHBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.graph_h, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x021a, code lost:
        r1 = com.blueair.graph.R.id.rg_separator_1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0222, code lost:
        r1 = com.blueair.graph.R.id.rg_separator_2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x022a, code lost:
        r1 = com.blueair.graph.R.id.scroll_indicator;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        r1 = com.blueair.graph.R.id.divider_h_4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r1 = com.blueair.graph.R.id.divider_h_5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        r1 = com.blueair.graph.R.id.divider_h_bottom;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        r1 = com.blueair.graph.R.id.divider_h_top;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r1 = com.blueair.graph.R.id.divider_h_1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        r1 = com.blueair.graph.R.id.divider_h_2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0192, code lost:
        r1 = com.blueair.graph.R.id.legend_y_aqi_1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x019a, code lost:
        r1 = com.blueair.graph.R.id.legend_y_aqi_2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01a2, code lost:
        r1 = com.blueair.graph.R.id.legend_y_aqi_3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01aa, code lost:
        r1 = com.blueair.graph.R.id.legend_y_aqi_4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01b2, code lost:
        r1 = com.blueair.graph.R.id.legend_y_aqi_5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01ba, code lost:
        r1 = com.blueair.graph.R.id.legend_y_hum_1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01c2, code lost:
        r1 = com.blueair.graph.R.id.legend_y_hum_2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01ca, code lost:
        r1 = com.blueair.graph.R.id.legend_y_hum_3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        r1 = com.blueair.graph.R.id.divider_h_3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.graph.databinding.GraphHBinding bind(android.view.View r60) {
        /*
            r0 = r60
            int r1 = com.blueair.graph.R.id.barrier_label_y_start
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.Barrier r5 = (androidx.constraintlayout.widget.Barrier) r5
            if (r5 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.barrier_legend_bottom
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.constraintlayout.widget.Barrier r6 = (androidx.constraintlayout.widget.Barrier) r6
            if (r6 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.divider_h_1
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r7 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.divider_h_2
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r8 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.divider_h_3
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r9 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.divider_h_4
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r10 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.divider_h_5
            android.view.View r11 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r11 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.divider_h_bottom
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r12 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.divider_h_top
            android.view.View r13 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r13 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.graph_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.graph_title_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.FrameLayout r15 = (android.widget.FrameLayout) r15
            if (r15 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.group_aqi
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.constraintlayout.widget.Group r16 = (androidx.constraintlayout.widget.Group) r16
            if (r16 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.group_hum
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            androidx.constraintlayout.widget.Group r17 = (androidx.constraintlayout.widget.Group) r17
            if (r17 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.group_tmp
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            androidx.constraintlayout.widget.Group r18 = (androidx.constraintlayout.widget.Group) r18
            if (r18 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.label_y_hum_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.label_y_hum_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.label_y_hum_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.label_y_hum_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.label_y_hum_5
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.label_y_hum_6
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.label_y_hum_7
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            android.widget.TextView r25 = (android.widget.TextView) r25
            if (r25 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.label_y_tmp_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            android.widget.TextView r26 = (android.widget.TextView) r26
            if (r26 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.label_y_tmp_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            android.widget.TextView r27 = (android.widget.TextView) r27
            if (r27 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.label_y_tmp_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            android.widget.TextView r28 = (android.widget.TextView) r28
            if (r28 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.label_y_tmp_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r29 = r2
            android.widget.TextView r29 = (android.widget.TextView) r29
            if (r29 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.label_y_tmp_5
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r30 = r2
            android.widget.TextView r30 = (android.widget.TextView) r30
            if (r30 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.label_y_tmp_6
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r31 = r2
            android.widget.TextView r31 = (android.widget.TextView) r31
            if (r31 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.label_y_tmp_7
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r32 = r2
            android.widget.TextView r32 = (android.widget.TextView) r32
            if (r32 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.legend_aqi_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r33 = r2
            android.widget.TextView r33 = (android.widget.TextView) r33
            if (r33 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.legend_aqi_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r34 = r2
            android.widget.TextView r34 = (android.widget.TextView) r34
            if (r34 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.legend_aqi_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r35 = r2
            android.widget.TextView r35 = (android.widget.TextView) r35
            if (r35 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.legend_aqi_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r36 = r2
            android.widget.TextView r36 = (android.widget.TextView) r36
            if (r36 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.legend_aqi_5
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r37 = r2
            android.widget.TextView r37 = (android.widget.TextView) r37
            if (r37 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.legend_hum_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r38 = r2
            android.widget.TextView r38 = (android.widget.TextView) r38
            if (r38 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.legend_hum_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r39 = r2
            android.widget.TextView r39 = (android.widget.TextView) r39
            if (r39 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.legend_hum_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r40 = r2
            android.widget.TextView r40 = (android.widget.TextView) r40
            if (r40 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.legend_y_aqi_1
            android.view.View r41 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r41 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.legend_y_aqi_2
            android.view.View r42 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r42 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.legend_y_aqi_3
            android.view.View r43 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r43 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.legend_y_aqi_4
            android.view.View r44 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r44 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.legend_y_aqi_5
            android.view.View r45 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r45 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.legend_y_hum_1
            android.view.View r46 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r46 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.legend_y_hum_2
            android.view.View r47 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r47 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.legend_y_hum_3
            android.view.View r48 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r48 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.lineChart
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r49 = r2
            com.github.mikephil.charting.charts.LineChart r49 = (com.github.mikephil.charting.charts.LineChart) r49
            if (r49 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.progressView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r50 = r2
            com.blueair.viewcore.view.ProgressBlockerView r50 = (com.blueair.viewcore.view.ProgressBlockerView) r50
            if (r50 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.radio_group_time_scale
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r51 = r2
            android.widget.RadioGroup r51 = (android.widget.RadioGroup) r51
            if (r51 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.rb_day
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r52 = r2
            android.widget.RadioButton r52 = (android.widget.RadioButton) r52
            if (r52 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.rb_month
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r53 = r2
            android.widget.RadioButton r53 = (android.widget.RadioButton) r53
            if (r53 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.rb_week
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r54 = r2
            android.widget.RadioButton r54 = (android.widget.RadioButton) r54
            if (r54 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.rg_separator_1
            android.view.View r55 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r55 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.rg_separator_2
            android.view.View r56 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r56 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.scroll_indicator
            android.view.View r57 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r57 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.scroll_indicator_track
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r58 = r2
            android.widget.FrameLayout r58 = (android.widget.FrameLayout) r58
            if (r58 == 0) goto L_0x0253
            int r1 = com.blueair.graph.R.id.time_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r59 = r2
            android.widget.TextView r59 = (android.widget.TextView) r59
            if (r59 == 0) goto L_0x0253
            com.blueair.graph.databinding.GraphHBinding r3 = new com.blueair.graph.databinding.GraphHBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59)
            return r3
        L_0x0253:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.databinding.GraphHBinding.bind(android.view.View):com.blueair.graph.databinding.GraphHBinding");
    }
}
