package com.blueair.auth;

import com.blueair.auth.retrofit.BlueLoginDetails;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.AuthService$getCloudJwt$2$2", f = "AuthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AuthService.kt */
final class AuthService$getCloudJwt$2$2 extends SuspendLambda implements Function2<Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AuthService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthService$getCloudJwt$2$2(AuthService authService, Continuation<? super AuthService$getCloudJwt$2$2> continuation) {
        super(2, continuation);
        this.this$0 = authService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AuthService$getCloudJwt$2$2 authService$getCloudJwt$2$2 = new AuthService$getCloudJwt$2$2(this.this$0, continuation);
        authService$getCloudJwt$2$2.L$0 = obj;
        return authService$getCloudJwt$2$2;
    }

    public final Object invoke(Throwable th, Continuation<? super Unit> continuation) {
        return ((AuthService$getCloudJwt$2$2) create(th, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Throwable th = (Throwable) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.Forest.e(th, "Failed to login to cloud", new Object[0]);
            this.this$0.setBlueLoginDetails(new BlueLoginDetails((String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
