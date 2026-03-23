package com.blueair.auth;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.LocationService$fetchRegion$1$1$1", f = "LocationService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LocationService.kt */
final class LocationService$fetchRegion$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $region;
    int label;
    final /* synthetic */ LocationService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocationService$fetchRegion$1$1$1(LocationService locationService, String str, Continuation<? super LocationService$fetchRegion$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = locationService;
        this.$region = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocationService$fetchRegion$1$1$1(this.this$0, this.$region, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LocationService$fetchRegion$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.setRegion(this.$region);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
