package com.blueair.graph.view;

import android.view.View;
import com.blueair.graph.utils.ChartTimeScale;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GraphRangeSelector$$ExternalSyntheticLambda4 implements View.OnClickListener {
    public final /* synthetic */ GraphRangeSelector f$0;
    public final /* synthetic */ ChartTimeScale f$1;

    public /* synthetic */ GraphRangeSelector$$ExternalSyntheticLambda4(GraphRangeSelector graphRangeSelector, ChartTimeScale chartTimeScale) {
        this.f$0 = graphRangeSelector;
        this.f$1 = chartTimeScale;
    }

    public final void onClick(View view) {
        GraphRangeSelector.updateTimeScale$lambda$4(this.f$0, this.f$1, view);
    }
}
