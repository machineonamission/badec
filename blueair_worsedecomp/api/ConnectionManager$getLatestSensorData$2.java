package com.blueair.api;

import com.blueair.api.client.CanGetSensorData;
import com.blueair.core.model.IndoorDatapoint;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$getLatestSensorData$2 extends FunctionReferenceImpl implements Function2<CanGetSensorData, Continuation<? super ApiResult<IndoorDatapoint>>, Object>, SuspendFunction {
    public static final ConnectionManager$getLatestSensorData$2 INSTANCE = new ConnectionManager$getLatestSensorData$2();

    ConnectionManager$getLatestSensorData$2() {
        super(2, CanGetSensorData.class, "getLatestSensorPoint", "getLatestSensorPoint(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanGetSensorData canGetSensorData, Continuation<? super ApiResult<IndoorDatapoint>> continuation) {
        return canGetSensorData.getLatestSensorPoint(continuation);
    }
}
