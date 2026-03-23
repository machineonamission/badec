package io.flatcircle.connectivityhelper;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/CompletableJob;", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: PingLooper.kt */
final class PingLooper$job$2 extends Lambda implements Function0<CompletableJob> {
    public static final PingLooper$job$2 INSTANCE = new PingLooper$job$2();

    PingLooper$job$2() {
        super(0);
    }

    public final CompletableJob invoke() {
        return SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
    }
}
