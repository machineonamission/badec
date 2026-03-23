package com.blueair.api.client;

import com.blueair.api.restapi.SimpleResponse;
import com.blueair.core.model.DeviceAlarm;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b`\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0002\u0010\tJ$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/blueair/api/client/CanSetAlarm;", "Lcom/blueair/api/client/DeviceClient;", "setAlarm", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/api/restapi/SimpleResponse;", "index", "", "alarm", "Lcom/blueair/core/model/DeviceAlarm;", "(ILcom/blueair/core/model/DeviceAlarm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "playAlarm", "sound", "volume", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopAlarm", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceClient.kt */
public interface CanSetAlarm extends DeviceClient {
    Object playAlarm(int i, int i2, Continuation<? super ApiResult<SimpleResponse>> continuation);

    Object setAlarm(int i, DeviceAlarm deviceAlarm, Continuation<? super ApiResult<SimpleResponse>> continuation);

    Object stopAlarm(Continuation<? super ApiResult<SimpleResponse>> continuation);
}
