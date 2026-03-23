package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.CloudNetworkClient$buildHttpClient$builder$1$1", f = "NetworkClient.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NetworkClient.kt */
final class CloudNetworkClient$buildHttpClient$builder$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;
    final /* synthetic */ CloudNetworkClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudNetworkClient$buildHttpClient$builder$1$1(CloudNetworkClient cloudNetworkClient, Continuation<? super CloudNetworkClient$buildHttpClient$builder$1$1> continuation) {
        super(2, continuation);
        this.this$0 = cloudNetworkClient;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CloudNetworkClient$buildHttpClient$builder$1$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((CloudNetworkClient$buildHttpClient$builder$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object cloudJwt = this.this$0.getAuthService().getCloudJwt(this);
            return cloudJwt == coroutine_suspended ? coroutine_suspended : cloudJwt;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
