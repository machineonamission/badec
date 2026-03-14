package com.blueair.api.client;

import com.blueair.core.model.DeviceSchedule;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00100\u0003H¦@¢\u0006\u0002\u0010\u0011¨\u0006\u0012À\u0006\u0003"},
   d2 = {"Lcom/blueair/api/client/CanManageSchedule;", "Lcom/blueair/api/client/DeviceClient;", "createSchedule", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lokhttp3/ResponseBody;", "schedule", "Lcom/blueair/core/model/DeviceSchedule;", "(Lcom/blueair/core/model/DeviceSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSchedule", "", "scheduleId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSchedule", "", "getSchedules", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface CanManageSchedule extends DeviceClient {
   Object createSchedule(DeviceSchedule var1, Continuation var2);

   Object deleteSchedule(String var1, Continuation var2);

   Object getSchedules(Continuation var1);

   Object updateSchedule(DeviceSchedule var1, Continuation var2);
}
