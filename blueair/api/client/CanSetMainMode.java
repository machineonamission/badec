package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0013\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0002\u0010\tJ.\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u000fJ&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH¦@¢\u0006\u0002\u0010\u001cJ&\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH¦@¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u000f¨\u0006 À\u0006\u0003"},
   d2 = {"Lcom/blueair/api/client/CanSetMainMode;", "Lcom/blueair/api/client/DeviceClient;", "setMainMode", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/api/restapi/SimpleResponse;", "value", "", "type", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setApSubMode", "overwriteMainMode", "", "(IZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setApFanSpeed", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHeatSubMode", "setHeatFanSpeed", "setHeatAutoTmp", "", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHeatEcoTmp", "setCoolSubMode", "setCoolFanSpeed", "setCoolAutoPresets", "tag", "presets", "", "(I[DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCoolEcoPresets", "setCoolFanSpeedLevel", "setCoolAutoLevel", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface CanSetMainMode extends DeviceClient {
   Object setApFanSpeed(int var1, Continuation var2);

   Object setApSubMode(int var1, boolean var2, String var3, Continuation var4);

   Object setCoolAutoLevel(int var1, Continuation var2);

   Object setCoolAutoPresets(int var1, double[] var2, Continuation var3);

   Object setCoolEcoPresets(int var1, double[] var2, Continuation var3);

   Object setCoolFanSpeed(int var1, Continuation var2);

   Object setCoolFanSpeedLevel(int var1, Continuation var2);

   Object setCoolSubMode(int var1, Continuation var2);

   Object setHeatAutoTmp(double var1, Continuation var3);

   Object setHeatEcoTmp(double var1, Continuation var3);

   Object setHeatFanSpeed(int var1, Continuation var2);

   Object setHeatSubMode(int var1, Continuation var2);

   Object setMainMode(int var1, String var2, Continuation var3);
}
