package com.blueair.graph.view;

import androidx.lifecycle.Observer;
import com.blueair.graph.utils.ChartTimeScale;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GraphView$$ExternalSyntheticLambda7 implements Observer {
    public final /* synthetic */ GraphView f$0;

    public /* synthetic */ GraphView$$ExternalSyntheticLambda7(GraphView graphView) {
        this.f$0 = graphView;
    }

    public final void onChanged(Object obj) {
        GraphView.attachLifeCycle$lambda$6(this.f$0, (ChartTimeScale) obj);
    }
}
