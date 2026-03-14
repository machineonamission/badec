package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\b`\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J,\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0011J4\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0016J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0019J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007¨\u0006\u001bÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/api/client/CanSetOscillation;", "Lcom/blueair/api/client/DeviceClient;", "setOscillationState", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/api/restapi/SimpleResponse;", "value", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setOscillationParams", "angle", "direction", "fanSpeed", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calibrateOscillationPosition", "setDualOscillationState", "horizontal", "", "(ZILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureOscillationSwing", "state", "minAngle", "maxAngle", "(ZIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureOscillationFixed", "fixAngle", "(ZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setOscillationMode", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface CanSetOscillation extends DeviceClient {
   Object calibrateOscillationPosition(int var1, Continuation var2);

   Object configureOscillationFixed(boolean var1, int var2, int var3, Continuation var4);

   Object configureOscillationSwing(boolean var1, int var2, int var3, int var4, Continuation var5);

   Object setDualOscillationState(boolean var1, int var2, Continuation var3);

   Object setOscillationMode(int var1, Continuation var2);

   Object setOscillationParams(int var1, int var2, int var3, Continuation var4);

   Object setOscillationState(int var1, Continuation var2);
}
