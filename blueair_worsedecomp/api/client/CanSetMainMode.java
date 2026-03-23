package com.blueair.api.client;

import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0013\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0010H¦@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0010H¦@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H¦@¢\u0006\u0002\u0010\u0019J&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H¦@¢\u0006\u0002\u0010\u0019¨\u0006\u001bÀ\u0006\u0003"}, d2 = {"Lcom/blueair/api/client/CanSetMainMode;", "Lcom/blueair/api/client/DeviceClient;", "setMainMode", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/api/restapi/SimpleResponse;", "value", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setApSubMode", "overwriteMainMode", "", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setApFanSpeed", "setHeatSubMode", "setHeatFanSpeed", "setHeatAutoTmp", "", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHeatEcoTmp", "setCoolSubMode", "setCoolFanSpeed", "setCoolAutoPresets", "tag", "presets", "", "(I[DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCoolEcoPresets", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceClient.kt */
public interface CanSetMainMode extends DeviceClient {
    Object setApFanSpeed(int i, Continuation<? super ApiResult<SimpleResponse>> continuation);

    Object setApSubMode(int i, boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation);

    Object setCoolAutoPresets(int i, double[] dArr, Continuation<? super ApiResult<SimpleResponse>> continuation);

    Object setCoolEcoPresets(int i, double[] dArr, Continuation<? super ApiResult<SimpleResponse>> continuation);

    Object setCoolFanSpeed(int i, Continuation<? super ApiResult<SimpleResponse>> continuation);

    Object setCoolSubMode(int i, Continuation<? super ApiResult<SimpleResponse>> continuation);

    Object setHeatAutoTmp(double d, Continuation<? super ApiResult<SimpleResponse>> continuation);

    Object setHeatEcoTmp(double d, Continuation<? super ApiResult<SimpleResponse>> continuation);

    Object setHeatFanSpeed(int i, Continuation<? super ApiResult<SimpleResponse>> continuation);

    Object setHeatSubMode(int i, Continuation<? super ApiResult<SimpleResponse>> continuation);

    Object setMainMode(int i, Continuation<? super ApiResult<SimpleResponse>> continuation);
}
