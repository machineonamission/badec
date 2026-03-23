package com.blueair.graph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.blueair.graph.R;
import com.blueair.graph.view.GraphRangeSelector;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.github.mikephil.charting.charts.LineChart;
import com.google.android.material.button.MaterialButton;

public final class GraphBinding implements ViewBinding {
    public final MaterialButton buttonInfo;
    public final ConstraintLayout graphHeader;
    public final GraphRangeSelector graphRangeSelectorTop;
    public final View legendExcel;
    public final TextView legendExcelLabel;
    public final View legendGood;
    public final TextView legendGoodLabel;
    public final Group legendLabels;
    public final ConstraintLayout legendLayout;
    public final View legendMod;
    public final TextView legendModLabel;
    public final TextView legendOutdoor;
    public final Group legendOutdoorGroup;
    public final View legendOutdoorSpacer;
    public final View legendPoll;
    public final TextView legendPollLabel;
    public final View legendVpoll;
    public final TextView legendVpollLabel;
    public final LineChart lineChart;
    public final ProgressBlockerView progressView;
    private final ConstraintLayout rootView;
    public final View scrollIndicator;
    public final FrameLayout scrollIndicatorRoot;
    public final TextView severityLabel;
    public final TextView valueLabel;

    private GraphBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, ConstraintLayout constraintLayout2, GraphRangeSelector graphRangeSelector, View view, TextView textView, View view2, TextView textView2, Group group, ConstraintLayout constraintLayout3, View view3, TextView textView3, TextView textView4, Group group2, View view4, View view5, TextView textView5, View view6, TextView textView6, LineChart lineChart2, ProgressBlockerView progressBlockerView, View view7, FrameLayout frameLayout, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.buttonInfo = materialButton;
        this.graphHeader = constraintLayout2;
        this.graphRangeSelectorTop = graphRangeSelector;
        this.legendExcel = view;
        this.legendExcelLabel = textView;
        this.legendGood = view2;
        this.legendGoodLabel = textView2;
        this.legendLabels = group;
        this.legendLayout = constraintLayout3;
        this.legendMod = view3;
        this.legendModLabel = textView3;
        this.legendOutdoor = textView4;
        this.legendOutdoorGroup = group2;
        this.legendOutdoorSpacer = view4;
        this.legendPoll = view5;
        this.legendPollLabel = textView5;
        this.legendVpoll = view6;
        this.legendVpollLabel = textView6;
        this.lineChart = lineChart2;
        this.progressView = progressBlockerView;
        this.scrollIndicator = view7;
        this.scrollIndicatorRoot = frameLayout;
        this.severityLabel = textView7;
        this.valueLabel = textView8;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GraphBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static GraphBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.graph, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
        r1 = com.blueair.graph.R.id.legend_good;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        r1 = com.blueair.graph.R.id.legend_mod;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        r1 = com.blueair.graph.R.id.legend_outdoor_spacer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0092, code lost:
        r1 = com.blueair.graph.R.id.legend_poll;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a6, code lost:
        r1 = com.blueair.graph.R.id.legend_vpoll;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d2, code lost:
        r1 = com.blueair.graph.R.id.scrollIndicator;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r1 = com.blueair.graph.R.id.legend_excel;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.graph.databinding.GraphBinding bind(android.view.View r29) {
        /*
            r0 = r29
            int r1 = com.blueair.graph.R.id.button_info
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.google.android.material.button.MaterialButton r5 = (com.google.android.material.button.MaterialButton) r5
            if (r5 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.graph_header
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.graph_range_selector_top
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            com.blueair.graph.view.GraphRangeSelector r7 = (com.blueair.graph.view.GraphRangeSelector) r7
            if (r7 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.legend_excel
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r8 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.legend_excel_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.legend_good
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r10 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.legend_good_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.legend_labels
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.constraintlayout.widget.Group r12 = (androidx.constraintlayout.widget.Group) r12
            if (r12 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.legend_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            if (r13 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.legend_mod
            android.view.View r14 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r14 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.legend_mod_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.legend_outdoor
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.legend_outdoor_group
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            androidx.constraintlayout.widget.Group r17 = (androidx.constraintlayout.widget.Group) r17
            if (r17 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.legend_outdoor_spacer
            android.view.View r18 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r18 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.legend_poll
            android.view.View r19 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r19 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.legend_poll_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.legend_vpoll
            android.view.View r21 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r21 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.legend_vpoll_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.lineChart
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            com.github.mikephil.charting.charts.LineChart r23 = (com.github.mikephil.charting.charts.LineChart) r23
            if (r23 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.progressView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            com.blueair.viewcore.view.ProgressBlockerView r24 = (com.blueair.viewcore.view.ProgressBlockerView) r24
            if (r24 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.scrollIndicator
            android.view.View r25 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r25 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.scrollIndicatorRoot
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            android.widget.FrameLayout r26 = (android.widget.FrameLayout) r26
            if (r26 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.severity_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            android.widget.TextView r27 = (android.widget.TextView) r27
            if (r27 == 0) goto L_0x0107
            int r1 = com.blueair.graph.R.id.value_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            android.widget.TextView r28 = (android.widget.TextView) r28
            if (r28 == 0) goto L_0x0107
            com.blueair.graph.databinding.GraphBinding r3 = new com.blueair.graph.databinding.GraphBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return r3
        L_0x0107:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.databinding.GraphBinding.bind(android.view.View):com.blueair.graph.databinding.GraphBinding");
    }
}
