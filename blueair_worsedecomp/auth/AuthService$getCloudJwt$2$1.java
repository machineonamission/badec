package com.blueair.auth;

import com.auth0.android.jwt.DecodeException;
import com.auth0.android.jwt.JWT;
import com.blueair.auth.retrofit.BlueLoginDetails;
import com.blueair.sdk.BugfenderSdk;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "result", "Lcom/blueair/auth/retrofit/BlueLoginDetails;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.AuthService$getCloudJwt$2$1", f = "AuthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AuthService.kt */
final class AuthService$getCloudJwt$2$1 extends SuspendLambda implements Function2<BlueLoginDetails, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AuthService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthService$getCloudJwt$2$1(AuthService authService, Continuation<? super AuthService$getCloudJwt$2$1> continuation) {
        super(2, continuation);
        this.this$0 = authService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AuthService$getCloudJwt$2$1 authService$getCloudJwt$2$1 = new AuthService$getCloudJwt$2$1(this.this$0, continuation);
        authService$getCloudJwt$2$1.L$0 = obj;
        return authService$getCloudJwt$2$1;
    }

    public final Object invoke(BlueLoginDetails blueLoginDetails, Continuation<? super Unit> continuation) {
        return ((AuthService$getCloudJwt$2$1) create(blueLoginDetails, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        BlueLoginDetails blueLoginDetails = (BlueLoginDetails) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.setBlueLoginDetails(blueLoginDetails);
            try {
                BugfenderSdk.INSTANCE.setDeviceString("uid", new JWT(blueLoginDetails.getAccess_token()).getClaim("client_id").asString());
            } catch (DecodeException e) {
                Timber.Forest.e(e, "Failed to decode aws access token: " + blueLoginDetails.getAccess_token().length(), new Object[0]);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
