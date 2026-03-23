package com.blueair.api.client;

import com.blueair.api.restapi.RepairBody;
import com.blueair.api.restapi.UserDevicesAblRestApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import retrofit2.Response;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesAblClient.kt */
final /* synthetic */ class UserDevicesAblClient$repairDevice$result$1 extends FunctionReferenceImpl implements Function3<String, RepairBody, Continuation<? super Response<RepairBody>>, Object>, SuspendFunction {
    UserDevicesAblClient$repairDevice$result$1(Object obj) {
        super(3, obj, UserDevicesAblRestApi.class, "repairDevice", "repairDevice(Ljava/lang/String;Lcom/blueair/api/restapi/RepairBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(String str, RepairBody repairBody, Continuation<? super Response<RepairBody>> continuation) {
        return ((UserDevicesAblRestApi) this.receiver).repairDevice(str, repairBody, continuation);
    }
}
