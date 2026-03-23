package io.flatcircle.coroutinehelper;

import com.foobot.liblabclient.core.WsDefinition;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lio/flatcircle/coroutinehelper/DefaultCoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "job$delegate", "Lkotlin/Lazy;", "clearJobs", "", "coroutinehelper_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: CoroutineScopeDelegates.kt */
public class DefaultCoroutineScope implements CoroutineScope {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultCoroutineScope.class), WsDefinition.JOB, "getJob()Lkotlinx/coroutines/Job;"))};
    private final Lazy job$delegate = LazyKt.lazy(DefaultCoroutineScope$job$2.INSTANCE);

    public final Job getJob() {
        Lazy lazy = this.job$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Job) lazy.getValue();
    }

    public CoroutineContext getCoroutineContext() {
        return Dispatchers.getDefault().plus(getJob());
    }

    public final void clearJobs() {
        JobKt__JobKt.cancelChildren$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }
}
