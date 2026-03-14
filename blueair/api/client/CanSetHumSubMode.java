package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\t¨\u0006\nÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/api/client/CanSetHumSubMode;", "Lcom/blueair/api/client/DeviceClient;", "setHumSubMode", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/api/restapi/SimpleResponse;", "value", "", "cancelWickDry", "", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface CanSetHumSubMode extends DeviceClient {
   Object setHumSubMode(int var1, boolean var2, Continuation var3);
}
