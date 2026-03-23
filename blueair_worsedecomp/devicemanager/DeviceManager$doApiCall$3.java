package com.blueair.devicemanager;

import com.blueair.api.ConnectionManager;
import com.blueair.api.restapi.SimpleResponse;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.database.DeviceField;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager", f = "DeviceManager.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {429, 431}, m = "doApiCall", n = {"device", "fields", "analyticsEvent", "action", "connection", "device", "fields", "analyticsEvent", "action", "connection", "result"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$doApiCall$3 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$doApiCall$3(DeviceManager deviceManager, Continuation<? super DeviceManager$doApiCall$3> continuation) {
        super(continuation);
        this.this$0 = deviceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doApiCall((Device) null, (List<? extends Pair<? extends DeviceField<?>, ? extends Object>>) null, (AnalyticEvent) null, (Function2<? super ConnectionManager, ? super Continuation<? super ApiResult<SimpleResponse>>, ? extends Object>) null, this);
    }
}
