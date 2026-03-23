package com.blueair.api.client;

import com.blueair.api.restapi.MigrationDeviceAblRestApi;
import com.blueair.core.model.MigrationOtaResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import retrofit2.Response;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: MigrationUserDevicesAblClient.kt */
final /* synthetic */ class MigrationUserDevicesAblClient$isMigrationOtaRunning$2 extends FunctionReferenceImpl implements Function2<String, Continuation<? super Response<MigrationOtaResponse>>, Object>, SuspendFunction {
    MigrationUserDevicesAblClient$isMigrationOtaRunning$2(Object obj) {
        super(2, obj, MigrationDeviceAblRestApi.class, "isMigrationOtaRunning", "isMigrationOtaRunning(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(String str, Continuation<? super Response<MigrationOtaResponse>> continuation) {
        return ((MigrationDeviceAblRestApi) this.receiver).isMigrationOtaRunning(str, continuation);
    }
}
