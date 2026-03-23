package com.blueair.devicedetails.fragment;

import com.blueair.core.model.SensorType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSensorsGraphFragment.kt */
final /* synthetic */ class DeviceSensorsGraphFragment$onViewCreated$1$5 extends FunctionReferenceImpl implements Function1<SensorType, Unit> {
    DeviceSensorsGraphFragment$onViewCreated$1$5(Object obj) {
        super(1, obj, DeviceSensorsGraphFragment.class, "showSensorData", "showSensorData(Lcom/blueair/core/model/SensorType;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SensorType) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SensorType sensorType) {
        Intrinsics.checkNotNullParameter(sensorType, "p0");
        ((DeviceSensorsGraphFragment) this.receiver).showSensorData(sensorType);
    }
}
