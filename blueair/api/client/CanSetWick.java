package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\fH¦@¢\u0006\u0002\u0010\r¨\u0006\u000eÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/api/client/CanSetWick;", "Lcom/blueair/api/client/DeviceClient;", "setWickDryEnabled", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/api/restapi/SimpleResponse;", "value", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelWickDryMode", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setWickDryOn", "setWickDryDurationAndOn", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface CanSetWick extends DeviceClient {
   Object cancelWickDryMode(Continuation var1);

   Object setWickDryDurationAndOn(int var1, Continuation var2);

   Object setWickDryEnabled(boolean var1, Continuation var2);

   Object setWickDryOn(boolean var1, Continuation var2);
}
