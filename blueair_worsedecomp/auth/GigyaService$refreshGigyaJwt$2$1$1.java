package com.blueair.auth;

import com.blueair.auth.GigyaService;
import com.gigya.android.sdk.GigyaCallback;
import com.gigya.android.sdk.api.GigyaApiResponse;
import com.gigya.android.sdk.network.GigyaError;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t²\u0006\n\u0010\n\u001a\u00020\u000bX\u0002"}, d2 = {"com/blueair/auth/GigyaService$refreshGigyaJwt$2$1$1", "Lcom/gigya/android/sdk/GigyaCallback;", "Lcom/gigya/android/sdk/api/GigyaApiResponse;", "onSuccess", "", "response", "onError", "e", "Lcom/gigya/android/sdk/network/GigyaError;", "auth_otherRelease", "logoutService", "Lcom/blueair/auth/LogOutService;"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GigyaService.kt */
public final class GigyaService$refreshGigyaJwt$2$1$1 extends GigyaCallback<GigyaApiResponse> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(GigyaService$refreshGigyaJwt$2$1$1.class, "logoutService", "<v#0>", 0))};
    final /* synthetic */ Continuation<String> $continuation;
    final /* synthetic */ GigyaService this$0;

    GigyaService$refreshGigyaJwt$2$1$1(GigyaService gigyaService, Continuation<? super String> continuation) {
        this.this$0 = gigyaService;
        this.$continuation = continuation;
    }

    public void onSuccess(GigyaApiResponse gigyaApiResponse) {
        Intrinsics.checkNotNullParameter(gigyaApiResponse, "response");
        Object obj = gigyaApiResponse.asMap().get("id_token");
        String obj2 = obj != null ? obj.toString() : null;
        if (obj2 != null) {
            this.this$0.setGigyaJwt(obj2);
        }
        Continuation<String> continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m9366constructorimpl(obj2));
    }

    public void onError(GigyaError gigyaError) {
        Intrinsics.checkNotNullParameter(gigyaError, "e");
        if (gigyaError.getErrorCode() == 403005) {
            JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new GigyaService$refreshGigyaJwt$2$1$1$onError$$inlined$instance$default$1().getSuperType());
            Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
            onError$lambda$0(DIAwareKt.Instance(this.this$0, new GenericJVMTypeTokenDelegate(typeToken, LogOutService.class), (Object) null).provideDelegate((Object) null, $$delegatedProperties[0])).logOutRegistered(LogoutReason.GIGYA_SESSION_INVALID);
        }
        Continuation<String> continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m9366constructorimpl(ResultKt.createFailure(new GigyaService.GigyaException(gigyaError))));
    }

    private static final LogOutService onError$lambda$0(Lazy<LogOutService> lazy) {
        return lazy.getValue();
    }
}
