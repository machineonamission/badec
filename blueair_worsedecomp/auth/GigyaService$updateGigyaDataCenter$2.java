package com.blueair.auth;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/blueair/auth/GigyaServer;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.GigyaService$updateGigyaDataCenter$2", f = "GigyaService.kt", i = {}, l = {371}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GigyaService.kt */
final class GigyaService$updateGigyaDataCenter$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GigyaServer>, Object> {
    final /* synthetic */ String $ablRegion;
    int label;
    final /* synthetic */ GigyaService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GigyaService$updateGigyaDataCenter$2(GigyaService gigyaService, String str, Continuation<? super GigyaService$updateGigyaDataCenter$2> continuation) {
        super(2, continuation);
        this.this$0 = gigyaService;
        this.$ablRegion = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GigyaService$updateGigyaDataCenter$2(this.this$0, this.$ablRegion, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GigyaServer> continuation) {
        return ((GigyaService$updateGigyaDataCenter$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getLocationService().fetchBlueairRegion(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str = (String) obj;
        if (str == null) {
            String str2 = this.$ablRegion;
            if (str2 != null) {
                str = str2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
            } else {
                str = null;
            }
        }
        this.this$0.setClosestDataCenterForRegion(str);
        return CollectionsKt.first(this.this$0.dataCenterList);
    }
}
