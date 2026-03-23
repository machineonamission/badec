package com.blueair.api.client;

import com.blueair.api.restapi.DeviceSparseOnAblServer;
import com.blueair.api.restapi.UserDevicesAblRestApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import retrofit2.Response;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesAblClient.kt */
final /* synthetic */ class UserDevicesAblClient$getDevices$sparseDevices$1 extends FunctionReferenceImpl implements Function2<String, Continuation<? super Response<List<? extends DeviceSparseOnAblServer>>>, Object>, SuspendFunction {
    UserDevicesAblClient$getDevices$sparseDevices$1(Object obj) {
        super(2, obj, UserDevicesAblRestApi.class, "getDeviceList", "getDeviceList(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(String str, Continuation<? super Response<List<DeviceSparseOnAblServer>>> continuation) {
        return ((UserDevicesAblRestApi) this.receiver).getDeviceList(str, continuation);
    }
}
