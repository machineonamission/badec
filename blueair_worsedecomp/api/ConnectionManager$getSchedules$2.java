package com.blueair.api;

import com.blueair.api.client.CanManageSchedule;
import com.blueair.core.model.DeviceSchedule;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$getSchedules$2 extends FunctionReferenceImpl implements Function2<CanManageSchedule, Continuation<? super ApiResult<List<? extends DeviceSchedule>>>, Object>, SuspendFunction {
    public static final ConnectionManager$getSchedules$2 INSTANCE = new ConnectionManager$getSchedules$2();

    ConnectionManager$getSchedules$2() {
        super(2, CanManageSchedule.class, "getSchedules", "getSchedules(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanManageSchedule canManageSchedule, Continuation<? super ApiResult<List<DeviceSchedule>>> continuation) {
        return canManageSchedule.getSchedules(continuation);
    }
}
