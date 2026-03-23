package com.blueair.api.client;

import com.blueair.api.client.BaseNetworkClient;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.Failure;
import io.flatcircle.coroutinehelper.Success;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/flatcircle/coroutinehelper/ApiResult;", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.BaseNetworkClient$awaitAllCalls$2", f = "NetworkClient.kt", i = {0, 0}, l = {94}, m = "invokeSuspend", n = {"$this$coroutineScope", "deferredJobs"}, s = {"L$0", "L$1"})
/* compiled from: NetworkClient.kt */
final class BaseNetworkClient$awaitAllCalls$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<List<? extends T>>>, Object> {
    final /* synthetic */ List<BaseNetworkClient.CallWithInput<T>> $calls;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BaseNetworkClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseNetworkClient$awaitAllCalls$2(List<BaseNetworkClient.CallWithInput<T>> list, BaseNetworkClient baseNetworkClient, Continuation<? super BaseNetworkClient$awaitAllCalls$2> continuation) {
        super(2, continuation);
        this.$calls = list;
        this.this$0 = baseNetworkClient;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BaseNetworkClient$awaitAllCalls$2 baseNetworkClient$awaitAllCalls$2 = new BaseNetworkClient$awaitAllCalls$2(this.$calls, this.this$0, continuation);
        baseNetworkClient$awaitAllCalls$2.L$0 = obj;
        return baseNetworkClient$awaitAllCalls$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<List<T>>> continuation) {
        return ((BaseNetworkClient$awaitAllCalls$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Iterable<BaseNetworkClient.CallWithInput> iterable = this.$calls;
            BaseNetworkClient baseNetworkClient = this.this$0;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (BaseNetworkClient.CallWithInput baseNetworkClient$awaitAllCalls$2$deferredJobs$1$1 : iterable) {
                arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BaseNetworkClient$awaitAllCalls$2$deferredJobs$1$1(baseNetworkClient, baseNetworkClient$awaitAllCalls$2$deferredJobs$1$1, (Continuation<? super BaseNetworkClient$awaitAllCalls$2$deferredJobs$1$1>) null), 3, (Object) null));
            }
            List list = (List) arrayList;
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(list);
            this.label = 1;
            obj = AwaitKt.awaitAll(list, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            List list2 = (List) this.L$1;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable<ApiResult> iterable2 = (List) obj;
        Collection arrayList2 = new ArrayList();
        for (Object next : iterable2) {
            if (((ApiResult) next).isFailure()) {
                arrayList2.add(next);
            }
        }
        for (ApiResult exceptionOrNull : (List) arrayList2) {
            Timber.Forest.w(exceptionOrNull.exceptionOrNull());
        }
        Collection arrayList3 = new ArrayList();
        for (Object next2 : iterable2) {
            if (((ApiResult) next2).isSuccess()) {
                arrayList3.add(next2);
            }
        }
        Iterable<ApiResult> iterable3 = (List) arrayList3;
        Collection arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable3, 10));
        for (ApiResult orNull : iterable3) {
            Object orNull2 = orNull.getOrNull();
            Intrinsics.checkNotNull(orNull2);
            arrayList4.add(orNull2);
        }
        List list3 = (List) arrayList4;
        if (!list3.isEmpty()) {
            return new Success(list3);
        }
        for (ApiResult apiResult : iterable2) {
            if (apiResult.isFailure()) {
                Throwable exceptionOrNull2 = apiResult.exceptionOrNull();
                Intrinsics.checkNotNull(exceptionOrNull2);
                return new Failure(exceptionOrNull2);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
