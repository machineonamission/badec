package com.blueair.auth;

import com.blueair.auth.GigyaService;
import com.blueair.auth.retrofit.GigyaApi;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.GigyaService$doGigyaDataCentersHaveEmailAddress$2", f = "GigyaService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GigyaService.kt */
final class GigyaService$doGigyaDataCentersHaveEmailAddress$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $email;
    int label;
    final /* synthetic */ GigyaService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GigyaService$doGigyaDataCentersHaveEmailAddress$2(GigyaService gigyaService, String str, Continuation<? super GigyaService$doGigyaDataCentersHaveEmailAddress$2> continuation) {
        super(2, continuation);
        this.this$0 = gigyaService;
        this.$email = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GigyaService$doGigyaDataCentersHaveEmailAddress$2(this.this$0, this.$email, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((GigyaService$doGigyaDataCentersHaveEmailAddress$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String callId;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = "";
            PreferencesHelper.INSTANCE.set(this.this$0.getSecurePrefs().getBackend(), PrefKeys.GigyaCallId, str, Reflection.getOrCreateKotlinClass(String.class));
            GigyaService gigyaService = this.this$0;
            String str2 = this.$email;
            for (GigyaServer gigyaServer : this.this$0.dataCenterList) {
                gigyaService.gigyaBaseUrl = gigyaServer.getUrl();
                try {
                    Response<GigyaApi.UserResponse> execute = gigyaService.getGigyaApi().checkDataCenterForId(str2, gigyaServer.getApiKey()).execute();
                    Timber.Forest forest = Timber.Forest;
                    forest.d("Gigya user check: dc=" + gigyaServer.getCountryCode() + ", id=" + str2 + ", response = " + execute.body(), new Object[0]);
                    GigyaApi.UserResponse body = execute.body();
                    Boolean isAvailable = body != null ? body.isAvailable() : null;
                    if (isAvailable != null && !isAvailable.booleanValue()) {
                        GigyaApi.UserResponse body2 = execute.body();
                        if (!(body2 == null || (callId = body2.getCallId()) == null)) {
                            PreferencesHelper.INSTANCE.set(gigyaService.getSecurePrefs().getBackend(), PrefKeys.GigyaCallId, callId, Reflection.getOrCreateKotlinClass(String.class));
                        }
                        gigyaService.saveUserGigyaServer(gigyaServer);
                        Timber.Forest forest2 = Timber.Forest;
                        forest2.d("Gigya user found: dc=" + gigyaServer.getCountryCode() + ", id=" + str2 + " response=" + execute, new Object[0]);
                        return Boxing.boxBoolean(true);
                    }
                } catch (Throwable th) {
                    if (!(th instanceof GigyaService.GigyaException)) {
                        Timber.Forest forest3 = Timber.Forest;
                        forest3.e(th, "Gigya error [send(accounts.isAvailableLoginID)] " + th.getLocalizedMessage(), new Object[0]);
                        String localizedMessage = th.getLocalizedMessage();
                        if (localizedMessage != null) {
                            str = localizedMessage;
                        }
                        gigyaService.reportError("send(accounts.isAvailableLoginID)", "-1", str);
                    } else {
                        Timber.Forest forest4 = Timber.Forest;
                        StringBuilder sb = new StringBuilder("Gigya error [send(accounts.isAvailableLoginID)] ");
                        GigyaService.GigyaException gigyaException = th;
                        sb.append(gigyaException.getError().getErrorCode());
                        sb.append(" | ");
                        sb.append(gigyaException.getError().getLocalizedMessage());
                        sb.append(" | ");
                        sb.append(gigyaException.getError().getData());
                        forest4.e(th, sb.toString(), new Object[0]);
                        gigyaService.reportError("send(accounts.isAvailableLoginID)", gigyaException);
                    }
                    throw th;
                }
            }
            Timber.Forest forest5 = Timber.Forest;
            forest5.d("Gigya user not found in all datacenters (id=" + this.$email + ')', new Object[0]);
            return Boxing.boxBoolean(false);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
