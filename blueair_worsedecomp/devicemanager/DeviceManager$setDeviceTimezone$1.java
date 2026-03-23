package com.blueair.devicemanager;

import android.content.Context;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.ResponseBody;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager", f = "DeviceManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {2258, 2258}, m = "setDeviceTimezone", n = {"deviceIdList", "timezone", "context", "validTimezone", "deviceIdList", "timezone", "context", "validTimezone"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$setDeviceTimezone$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$setDeviceTimezone$1(DeviceManager deviceManager, Continuation<? super DeviceManager$setDeviceTimezone$1> continuation) {
        super(continuation);
        this.this$0 = deviceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setDeviceTimezone((List<String>) null, (TimeZone) null, (Context) null, (Continuation<? super ApiResult<ResponseBody>>) this);
    }
}
