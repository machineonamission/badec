package com.blueair.api;

import com.blueair.api.client.CanManageSchedule;
import com.blueair.core.model.DeviceSchedule;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$updateSchedule$2 extends FunctionReferenceImpl implements Function3<CanManageSchedule, DeviceSchedule, Continuation<? super ApiResult<Object>>, Object>, SuspendFunction {
    public static final ConnectionManager$updateSchedule$2 INSTANCE = new ConnectionManager$updateSchedule$2();

    ConnectionManager$updateSchedule$2() {
        super(3, CanManageSchedule.class, "updateSchedule", "updateSchedule(Lcom/blueair/core/model/DeviceSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanManageSchedule canManageSchedule, DeviceSchedule deviceSchedule, Continuation<? super ApiResult<Object>> continuation) {
        return canManageSchedule.updateSchedule(deviceSchedule, continuation);
    }
}
