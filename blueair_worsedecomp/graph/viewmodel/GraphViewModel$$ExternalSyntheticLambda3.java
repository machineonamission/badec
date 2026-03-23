package com.blueair.graph.viewmodel;

import com.blueair.core.model.SensorType;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GraphViewModel$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ SensorType f$0;
    public final /* synthetic */ double[] f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ GraphViewModel$$ExternalSyntheticLambda3(SensorType sensorType, double[] dArr, boolean z) {
        this.f$0 = sensorType;
        this.f$1 = dArr;
        this.f$2 = z;
    }

    public final Object invoke(Object obj) {
        return Float.valueOf(GraphViewModel.updateIndoorRealTime$lambda$5(this.f$0, this.f$1, this.f$2, ((Float) obj).floatValue()));
    }
}
