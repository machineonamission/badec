package com.blueair.outdoor.service;

import com.blueair.core.model.TrackedLocation;
import com.blueair.sdk.KlaviyoProfileLocationData;
import com.blueair.sdk.KlaviyoSdk;
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
@DebugMetadata(c = "com.blueair.outdoor.service.OutdoorService$downloadTrackedLocations$2", f = "OutdoorService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OutdoorService.kt */
final class OutdoorService$downloadTrackedLocations$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OutdoorService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutdoorService$downloadTrackedLocations$2(OutdoorService outdoorService, Continuation<? super OutdoorService$downloadTrackedLocations$2> continuation) {
        super(2, continuation);
        this.this$0 = outdoorService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OutdoorService$downloadTrackedLocations$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OutdoorService$downloadTrackedLocations$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            TrackedLocation databaseCurrentLocation = this.this$0.getDatabaseCurrentLocation();
            if (databaseCurrentLocation != null) {
                KlaviyoSdk.INSTANCE.setProfileLocation(new KlaviyoProfileLocationData(this.this$0.authService.getUsername(), databaseCurrentLocation.getCountryCode(), databaseCurrentLocation.getStateName(), databaseCurrentLocation.getCityName()));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
