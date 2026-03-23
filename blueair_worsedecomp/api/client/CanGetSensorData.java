package com.blueair.api.client;

import com.blueair.core.model.IndoorDatapoint;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u0005J\"\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u00032\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/blueair/api/client/CanGetSensorData;", "Lcom/blueair/api/client/DeviceClient;", "getLatestSensorPoint", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/core/model/IndoorDatapoint;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMonthSensorPoints", "", "fromTime", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceClient.kt */
public interface CanGetSensorData extends DeviceClient {
    Object getLatestSensorPoint(Continuation<? super ApiResult<IndoorDatapoint>> continuation);

    Object getMonthSensorPoints(long j, Continuation<? super ApiResult<List<IndoorDatapoint>>> continuation);
}
