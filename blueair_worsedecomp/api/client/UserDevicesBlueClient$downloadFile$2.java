package com.blueair.api.client;

import io.flatcircle.coroutinehelper.ApiResult;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lio/flatcircle/coroutinehelper/ApiResult;", "Ljava/io/InputStream;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.UserDevicesBlueClient$downloadFile$2", f = "UserDevicesBlueClient.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: UserDevicesBlueClient.kt */
final class UserDevicesBlueClient$downloadFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<InputStream>>, Object> {
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ UserDevicesBlueClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserDevicesBlueClient$downloadFile$2(String str, UserDevicesBlueClient userDevicesBlueClient, Continuation<? super UserDevicesBlueClient$downloadFile$2> continuation) {
        super(2, continuation);
        this.$url = str;
        this.this$0 = userDevicesBlueClient;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserDevicesBlueClient$downloadFile$2(this.$url, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<InputStream>> continuation) {
        return ((UserDevicesBlueClient$downloadFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                Response execute = this.this$0.getOkHttpClient().newCall(new Request.Builder().url(this.$url).build()).execute();
                ApiResult.Companion companion = ApiResult.Companion;
                ResponseBody body = execute.body();
                return companion.success(body != null ? body.byteStream() : null);
            } catch (Exception e) {
                return ApiResult.Companion.fail(e);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
