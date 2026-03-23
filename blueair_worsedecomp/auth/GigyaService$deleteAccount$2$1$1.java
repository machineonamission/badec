package com.blueair.auth;

import com.blueair.auth.GigyaService;
import com.gigya.android.sdk.GigyaCallback;
import com.gigya.android.sdk.api.GigyaApiResponse;
import com.gigya.android.sdk.network.GigyaError;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/blueair/auth/GigyaService$deleteAccount$2$1$1", "Lcom/gigya/android/sdk/GigyaCallback;", "Lcom/gigya/android/sdk/api/GigyaApiResponse;", "onSuccess", "", "response", "onError", "e", "Lcom/gigya/android/sdk/network/GigyaError;", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GigyaService.kt */
public final class GigyaService$deleteAccount$2$1$1 extends GigyaCallback<GigyaApiResponse> {
    final /* synthetic */ Continuation<Unit> $continuation;

    GigyaService$deleteAccount$2$1$1(Continuation<? super Unit> continuation) {
        this.$continuation = continuation;
    }

    public void onSuccess(GigyaApiResponse gigyaApiResponse) {
        Intrinsics.checkNotNullParameter(gigyaApiResponse, "response");
        Timber.Forest.w(String.valueOf(gigyaApiResponse), new Object[0]);
        Continuation<Unit> continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m9366constructorimpl(Unit.INSTANCE));
    }

    public void onError(GigyaError gigyaError) {
        Intrinsics.checkNotNullParameter(gigyaError, "e");
        Timber.Forest.e("Error while deleting account: %s", gigyaError.toString());
        Continuation<Unit> continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m9366constructorimpl(ResultKt.createFailure(new GigyaService.GigyaException(gigyaError))));
    }
}
