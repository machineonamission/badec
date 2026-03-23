package com.blueair.api.client;

import com.blueair.api.model.DeviceInfoData;
import com.blueair.api.restapi.DeviceAttributeOnAbl;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H¦@¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H¦@¢\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000b\u001a\u00020\bH¦@¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/blueair/api/client/CanGetAttributes;", "Lcom/blueair/api/client/DeviceClient;", "getAttributes", "Lio/flatcircle/coroutinehelper/ApiResult;", "", "Lcom/blueair/api/restapi/DeviceAttributeOnAbl;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceInfoData", "Lcom/blueair/api/model/DeviceInfoData;", "setDeviceInfoData", "", "nuData", "(Lcom/blueair/api/model/DeviceInfoData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIsUpdating", "", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceClient.kt */
public interface CanGetAttributes extends DeviceClient {
    Object getAttributes(Continuation<? super ApiResult<List<DeviceAttributeOnAbl>>> continuation);

    Object getDeviceInfoData(Continuation<? super ApiResult<DeviceInfoData>> continuation);

    Object getIsUpdating(Continuation<? super ApiResult<Boolean>> continuation);

    Object setDeviceInfoData(DeviceInfoData deviceInfoData, Continuation<? super ApiResult<Object>> continuation);
}
