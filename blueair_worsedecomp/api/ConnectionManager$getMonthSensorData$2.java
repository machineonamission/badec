package com.blueair.api;

import com.blueair.api.client.CanGetSensorData;
import com.blueair.core.model.IndoorDatapoint;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$getMonthSensorData$2 extends FunctionReferenceImpl implements Function3<CanGetSensorData, Long, Continuation<? super ApiResult<List<? extends IndoorDatapoint>>>, Object>, SuspendFunction {
    public static final ConnectionManager$getMonthSensorData$2 INSTANCE = new ConnectionManager$getMonthSensorData$2();

    ConnectionManager$getMonthSensorData$2() {
        super(3, CanGetSensorData.class, "getMonthSensorPoints", "getMonthSensorPoints(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanGetSensorData canGetSensorData, long j, Continuation<? super ApiResult<List<IndoorDatapoint>>> continuation) {
        return canGetSensorData.getMonthSensorPoints(j, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CanGetSensorData) obj, ((Number) obj2).longValue(), (Continuation<? super ApiResult<List<IndoorDatapoint>>>) (Continuation) obj3);
    }
}
