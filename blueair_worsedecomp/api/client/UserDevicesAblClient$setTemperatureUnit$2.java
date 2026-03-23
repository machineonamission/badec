package com.blueair.api.client;

import com.blueair.api.restapi.TemperatureAttributeDto;
import com.blueair.api.restapi.UserDevicesAblRestApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import retrofit2.Response;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesAblClient.kt */
final /* synthetic */ class UserDevicesAblClient$setTemperatureUnit$2 extends FunctionReferenceImpl implements Function3<String, TemperatureAttributeDto, Continuation<? super Response<Unit>>, Object>, SuspendFunction {
    UserDevicesAblClient$setTemperatureUnit$2(Object obj) {
        super(3, obj, UserDevicesAblRestApi.class, "setTemperaturePreference", "setTemperaturePreference(Ljava/lang/String;Lcom/blueair/api/restapi/TemperatureAttributeDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(String str, TemperatureAttributeDto temperatureAttributeDto, Continuation<? super Response<Unit>> continuation) {
        return ((UserDevicesAblRestApi) this.receiver).setTemperaturePreference(str, temperatureAttributeDto, continuation);
    }
}
