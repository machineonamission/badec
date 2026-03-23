package com.blueair.api.client;

import com.blueair.api.restapi.UserDevicesAblRestApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import retrofit2.Response;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesAblClient.kt */
final /* synthetic */ class UserDevicesAblClient$removeDevice$2 extends FunctionReferenceImpl implements Function3<String, String, Continuation<? super Response<Object>>, Object>, SuspendFunction {
    UserDevicesAblClient$removeDevice$2(Object obj) {
        super(3, obj, UserDevicesAblRestApi.class, "removeDevice", "removeDevice(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(String str, String str2, Continuation<? super Response<Object>> continuation) {
        return ((UserDevicesAblRestApi) this.receiver).removeDevice(str, str2, continuation);
    }
}
