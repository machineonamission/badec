package com.blueair.api;

import com.blueair.api.client.CanManageSchedule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$deleteSchedule$2 extends FunctionReferenceImpl implements Function3<CanManageSchedule, String, Continuation<? super Unit>, Object>, SuspendFunction {
    public static final ConnectionManager$deleteSchedule$2 INSTANCE = new ConnectionManager$deleteSchedule$2();

    ConnectionManager$deleteSchedule$2() {
        super(3, CanManageSchedule.class, "deleteSchedule", "deleteSchedule(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanManageSchedule canManageSchedule, String str, Continuation<? super Unit> continuation) {
        return canManageSchedule.deleteSchedule(str, continuation);
    }
}
