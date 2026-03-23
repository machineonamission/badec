package com.blueair.graph.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.core.model.SimpleDatapoint;
import com.blueair.graph.databinding.RangeSelectBinding;
import com.blueair.graph.utils.ChartTimeScale;
import com.blueair.graph.utils.GraphUtils;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.projectodd.stilts.stomp.protocol.StompFrame;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\u000eJ\u0010\u0010/\u001a\u00020)2\u0006\u0010.\u001a\u00020\u000eH\u0002J\u0006\u00100\u001a\u00020)J\u000e\u00101\u001a\u00020)2\u0006\u0010.\u001a\u00020\u000eR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u001d\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u001f\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b \u0010\u0018R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b%\u0010'¨\u00062"}, d2 = {"Lcom/blueair/graph/view/GraphRangeSelector;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_liveScale", "Landroidx/lifecycle/MutableLiveData;", "Lcom/blueair/graph/utils/ChartTimeScale;", "liveScale", "Landroidx/lifecycle/LiveData;", "getLiveScale", "()Landroidx/lifecycle/LiveData;", "binding", "Lcom/blueair/graph/databinding/RangeSelectBinding;", "timeButton", "Lcom/google/android/material/button/MaterialButton;", "getTimeButton", "()Lcom/google/android/material/button/MaterialButton;", "rangeDay", "getRangeDay", "rangeWeek", "getRangeWeek", "rangeMonth", "getRangeMonth", "rangeClose", "getRangeClose", "rangeSelectLayout", "Landroid/view/View;", "getRangeSelectLayout", "()Landroid/view/View;", "isExpanded", "", "()Z", "reset", "", "updateTime", "point", "Lcom/blueair/core/model/SimpleDatapoint;", "updateTimeScale", "timeScale", "updateScale", "hideRangeSelector", "showRangeSelector", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GraphRangeSelector.kt */
public final class GraphRangeSelector extends FrameLayout {
    private final MutableLiveData<ChartTimeScale> _liveScale = new MutableLiveData<>();
    private final RangeSelectBinding binding;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GraphRangeSelector.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.graph.utils.ChartTimeScale[] r0 = com.blueair.graph.utils.ChartTimeScale.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.graph.utils.ChartTimeScale r1 = com.blueair.graph.utils.ChartTimeScale.MONTH     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.graph.utils.ChartTimeScale r1 = com.blueair.graph.utils.ChartTimeScale.WEEK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.graph.utils.ChartTimeScale r1 = com.blueair.graph.utils.ChartTimeScale.DAY     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.view.GraphRangeSelector.WhenMappings.<clinit>():void");
        }
    }

    public final LiveData<ChartTimeScale> getLiveScale() {
        return this._liveScale;
    }

    public final MaterialButton getTimeButton() {
        MaterialButton materialButton = this.binding.timeButton;
        Intrinsics.checkNotNullExpressionValue(materialButton, "timeButton");
        return materialButton;
    }

    public final MaterialButton getRangeDay() {
        MaterialButton materialButton = this.binding.rangeDay;
        Intrinsics.checkNotNullExpressionValue(materialButton, "rangeDay");
        return materialButton;
    }

    public final MaterialButton getRangeWeek() {
        MaterialButton materialButton = this.binding.rangeWeek;
        Intrinsics.checkNotNullExpressionValue(materialButton, "rangeWeek");
        return materialButton;
    }

    public final MaterialButton getRangeMonth() {
        MaterialButton materialButton = this.binding.rangeMonth;
        Intrinsics.checkNotNullExpressionValue(materialButton, "rangeMonth");
        return materialButton;
    }

    public final MaterialButton getRangeClose() {
        MaterialButton materialButton = this.binding.rangeClose;
        Intrinsics.checkNotNullExpressionValue(materialButton, "rangeClose");
        return materialButton;
    }

    public final View getRangeSelectLayout() {
        ConstraintLayout constraintLayout = this.binding.rangeSelectLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "rangeSelectLayout");
        return constraintLayout;
    }

    public final boolean isExpanded() {
        return getRangeSelectLayout().getVisibility() == 0;
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(GraphRangeSelector graphRangeSelector, View view) {
        graphRangeSelector.updateScale(ChartTimeScale.MONTH);
        graphRangeSelector.hideRangeSelector();
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(GraphRangeSelector graphRangeSelector, View view) {
        graphRangeSelector.updateScale(ChartTimeScale.WEEK);
        graphRangeSelector.hideRangeSelector();
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$2(GraphRangeSelector graphRangeSelector, View view) {
        graphRangeSelector.updateScale(ChartTimeScale.DAY);
        graphRangeSelector.hideRangeSelector();
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$3(GraphRangeSelector graphRangeSelector, View view) {
        graphRangeSelector.hideRangeSelector();
    }

    public final void reset() {
        MaterialButton timeButton = getTimeButton();
        GraphUtils graphUtils = GraphUtils.INSTANCE;
        long currentTimeMillis = System.currentTimeMillis();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        timeButton.setText(GraphUtils.getStringDate$default(graphUtils, currentTimeMillis, context, false, 4, (Object) null));
        if (isExpanded()) {
            hideRangeSelector();
        }
    }

    public final void updateTime(SimpleDatapoint simpleDatapoint) {
        Intrinsics.checkNotNullParameter(simpleDatapoint, "point");
        MaterialButton timeButton = getTimeButton();
        GraphUtils graphUtils = GraphUtils.INSTANCE;
        long timeInMillis = simpleDatapoint.getTimeInMillis();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        timeButton.setText(GraphUtils.getStringDate$default(graphUtils, timeInMillis, context, false, 4, (Object) null));
        if (isExpanded()) {
            hideRangeSelector();
        }
    }

    public final void updateTimeScale(ChartTimeScale chartTimeScale) {
        Intrinsics.checkNotNullParameter(chartTimeScale, "timeScale");
        getTimeButton().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda4(this, chartTimeScale));
    }

    /* access modifiers changed from: private */
    public static final void updateTimeScale$lambda$4(GraphRangeSelector graphRangeSelector, ChartTimeScale chartTimeScale, View view) {
        graphRangeSelector.showRangeSelector(chartTimeScale);
    }

    private final void updateScale(ChartTimeScale chartTimeScale) {
        this._liveScale.postValue(chartTimeScale);
    }

    public final void hideRangeSelector() {
        getRangeSelectLayout().setVisibility(4);
        getTimeButton().setVisibility(0);
    }

    public final void showRangeSelector(ChartTimeScale chartTimeScale) {
        Intrinsics.checkNotNullParameter(chartTimeScale, "timeScale");
        getTimeButton().setVisibility(4);
        int i = WhenMappings.$EnumSwitchMapping$0[chartTimeScale.ordinal()] == 1 ? 1 : 0;
        int i2 = WhenMappings.$EnumSwitchMapping$0[chartTimeScale.ordinal()] == 2 ? 1 : 0;
        int i3 = WhenMappings.$EnumSwitchMapping$0[chartTimeScale.ordinal()] == 3 ? 1 : 0;
        getRangeMonth().setTypeface((Typeface) null, i);
        getRangeMonth().setTextSize(0, getRangeMonth().getResources().getDimension(i == 1 ? R.dimen.text_small : R.dimen.text_xsmall));
        getRangeWeek().setTypeface((Typeface) null, i2);
        getRangeWeek().setTextSize(0, getRangeWeek().getResources().getDimension(i2 == 1 ? R.dimen.text_small : R.dimen.text_xsmall));
        getRangeDay().setTypeface((Typeface) null, i3);
        getRangeDay().setTextSize(0, getRangeDay().getResources().getDimension(i3 == 1 ? R.dimen.text_small : R.dimen.text_xsmall));
        getRangeSelectLayout().setVisibility(0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraphRangeSelector(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        RangeSelectBinding inflate = RangeSelectBinding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        reset();
        getRangeMonth().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda0(this));
        getRangeWeek().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda1(this));
        getRangeDay().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda2(this));
        getRangeClose().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda3(this));
        getTimeButton().setAccessibilityDelegate(new View.AccessibilityDelegate() {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                Intrinsics.checkNotNullParameter(view, StompFrame.Header.HOST);
                Intrinsics.checkNotNullParameter(accessibilityNodeInfo, "info");
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                CharSequence text = view.getResources().getText(R.string.show_range_selector_action_description);
                Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                accessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, text));
            }
        });
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraphRangeSelector(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        RangeSelectBinding inflate = RangeSelectBinding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        reset();
        getRangeMonth().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda0(this));
        getRangeWeek().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda1(this));
        getRangeDay().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda2(this));
        getRangeClose().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda3(this));
        getTimeButton().setAccessibilityDelegate(new View.AccessibilityDelegate() {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                Intrinsics.checkNotNullParameter(view, StompFrame.Header.HOST);
                Intrinsics.checkNotNullParameter(accessibilityNodeInfo, "info");
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                CharSequence text = view.getResources().getText(R.string.show_range_selector_action_description);
                Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                accessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, text));
            }
        });
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraphRangeSelector(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        RangeSelectBinding inflate = RangeSelectBinding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        reset();
        getRangeMonth().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda0(this));
        getRangeWeek().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda1(this));
        getRangeDay().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda2(this));
        getRangeClose().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda3(this));
        getTimeButton().setAccessibilityDelegate(new View.AccessibilityDelegate() {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                Intrinsics.checkNotNullParameter(view, StompFrame.Header.HOST);
                Intrinsics.checkNotNullParameter(accessibilityNodeInfo, "info");
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                CharSequence text = view.getResources().getText(R.string.show_range_selector_action_description);
                Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                accessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, text));
            }
        });
    }
}
