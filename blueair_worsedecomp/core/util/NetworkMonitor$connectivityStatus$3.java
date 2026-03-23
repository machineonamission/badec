package com.blueair.core.util;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.core.util.NetworkMonitor$connectivityStatus$3", f = "NetworkMonitor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NetworkMonitor.kt */
final class NetworkMonitor$connectivityStatus$3 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;

    NetworkMonitor$connectivityStatus$3(Continuation<? super NetworkMonitor$connectivityStatus$3> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NetworkMonitor$connectivityStatus$3 networkMonitor$connectivityStatus$3 = new NetworkMonitor$connectivityStatus$3(continuation);
        networkMonitor$connectivityStatus$3.Z$0 = ((Boolean) obj).booleanValue();
        return networkMonitor$connectivityStatus$3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) (Continuation) obj2);
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((NetworkMonitor$connectivityStatus$3) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z = this.Z$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.Forest forest = Timber.Forest;
            forest.i("Connectivity status: " + z, new Object[0]);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
