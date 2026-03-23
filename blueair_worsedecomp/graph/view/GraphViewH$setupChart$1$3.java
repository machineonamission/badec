package com.blueair.graph.view;

import android.view.MotionEvent;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\"\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J,\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0018"}, d2 = {"com/blueair/graph/view/GraphViewH$setupChart$1$3", "Lcom/github/mikephil/charting/listener/OnChartGestureListener;", "onChartGestureStart", "", "me", "Landroid/view/MotionEvent;", "lastPerformedGesture", "Lcom/github/mikephil/charting/listener/ChartTouchListener$ChartGesture;", "onChartGestureEnd", "onChartTranslate", "dX", "", "dY", "onChartScale", "scaleX", "scaleY", "onChartFling", "me1", "me2", "velocityX", "velocityY", "onChartSingleTapped", "onChartDoubleTapped", "onChartLongPressed", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GraphViewH.kt */
public final class GraphViewH$setupChart$1$3 implements OnChartGestureListener {
    final /* synthetic */ GraphViewH this$0;

    public void onChartDoubleTapped(MotionEvent motionEvent) {
    }

    public void onChartFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
    }

    public void onChartLongPressed(MotionEvent motionEvent) {
    }

    public void onChartScale(MotionEvent motionEvent, float f, float f2) {
    }

    public void onChartSingleTapped(MotionEvent motionEvent) {
    }

    GraphViewH$setupChart$1$3(GraphViewH graphViewH) {
        this.this$0 = graphViewH;
    }

    public void onChartGestureStart(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture) {
        this.this$0.scrollIndicatorPreviousDx = 0.0f;
    }

    public void onChartGestureEnd(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture) {
        this.this$0.highlightCenterEntry();
    }

    public void onChartTranslate(MotionEvent motionEvent, float f, float f2) {
        float abs = (Math.abs(f) - Math.abs(this.this$0.scrollIndicatorPreviousDx)) * ((float) (f < 0.0f ? -1 : 1));
        this.this$0.scrollIndicatorPreviousDx = f;
        GraphViewH graphViewH = this.this$0;
        graphViewH.setScrollIndicatorPosition(graphViewH.scrollIndicatorPosition + (abs / this.this$0.chart.getScaleX()));
        if (Math.abs(abs) > 1.0f) {
            this.this$0.highlightCenterEntry();
        }
    }
}
