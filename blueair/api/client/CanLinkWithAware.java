package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H¦@¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\n¨\u0006\fÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/api/client/CanLinkWithAware;", "Lcom/blueair/api/client/DeviceClient;", "getLink", "Lio/flatcircle/coroutinehelper/ApiResult;", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setLink", "Lcom/blueair/api/restapi/SimpleResponse;", "linkedUid", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLink", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface CanLinkWithAware extends DeviceClient {
   Object deleteLink(String var1, Continuation var2);

   Object getLink(Continuation var1);

   Object setLink(String var1, Continuation var2);
}
