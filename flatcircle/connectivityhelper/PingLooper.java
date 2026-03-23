package io.flatcircle.connectivityhelper;

import com.foobot.liblabclient.core.WsDefinition;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001cH\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lio/flatcircle/connectivityhelper/PingLooper;", "Lkotlinx/coroutines/CoroutineScope;", "connectionMonitors", "", "Lio/flatcircle/connectivityhelper/ConnectionStateMonitor;", "pingResultHandler", "Lio/flatcircle/connectivityhelper/PingResultHandler;", "endpoint", "", "(Ljava/util/List;Lio/flatcircle/connectivityhelper/PingResultHandler;Ljava/lang/String;)V", "getConnectionMonitors", "()Ljava/util/List;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getEndpoint", "()Ljava/lang/String;", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "job$delegate", "Lkotlin/Lazy;", "pingJob", "getPingResultHandler", "()Lio/flatcircle/connectivityhelper/PingResultHandler;", "cancel", "", "doPings", "connectivityhelper_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: PingLooper.kt */
public final class PingLooper implements CoroutineScope {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PingLooper.class), WsDefinition.JOB, "getJob()Lkotlinx/coroutines/Job;"))};
    private final List<ConnectionStateMonitor> connectionMonitors;
    private final String endpoint;
    private final Lazy job$delegate = LazyKt.lazy(PingLooper$job$2.INSTANCE);
    /* access modifiers changed from: private */
    public Job pingJob;
    private final PingResultHandler pingResultHandler;

    private final Job getJob() {
        Lazy lazy = this.job$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Job) lazy.getValue();
    }

    public PingLooper(List<ConnectionStateMonitor> list, PingResultHandler pingResultHandler2, String str) {
        Intrinsics.checkParameterIsNotNull(list, "connectionMonitors");
        Intrinsics.checkParameterIsNotNull(pingResultHandler2, "pingResultHandler");
        Intrinsics.checkParameterIsNotNull(str, "endpoint");
        this.connectionMonitors = list;
        this.pingResultHandler = pingResultHandler2;
        this.endpoint = str;
    }

    public final List<ConnectionStateMonitor> getConnectionMonitors() {
        return this.connectionMonitors;
    }

    public final PingResultHandler getPingResultHandler() {
        return this.pingResultHandler;
    }

    public final String getEndpoint() {
        return this.endpoint;
    }

    public CoroutineContext getCoroutineContext() {
        return Dispatchers.getIO().plus(getJob());
    }

    public final void doPings() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new PingLooper$doPings$1(this, (Continuation) null), 3, (Object) null);
    }

    public final void cancel() {
        Job job = this.pingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }
}
