package com.blueair.api.client;

import com.blueair.core.model.WelcomeHomeLocation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(
   d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\t¨\u0006\nÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/api/client/CanManageWelcomeHome;", "Lcom/blueair/api/client/DeviceClient;", "createUpdateWelcomeHome", "Lio/flatcircle/coroutinehelper/ApiResult;", "", "location", "Lcom/blueair/core/model/WelcomeHomeLocation;", "(Lcom/blueair/core/model/WelcomeHomeLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWelcomeHome", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface CanManageWelcomeHome extends DeviceClient {
   Object createUpdateWelcomeHome(WelcomeHomeLocation var1, Continuation var2);

   Object deleteWelcomeHome(Continuation var1);
}
