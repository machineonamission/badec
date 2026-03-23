package com.blueair.devicemanager;

import android.content.Context;
import com.blueair.api.utils.ProgressListener;
import com.blueair.core.model.IssueType;
import com.blueair.core.model.LogLength;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager", f = "DeviceManager.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {2304, 2304, 2304}, m = "uploadLog", n = {"context", "type", "length", "description", "listener", "context", "type", "length", "description", "listener", "context", "type", "length", "description", "listener"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$uploadLog$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$uploadLog$1(DeviceManager deviceManager, Continuation<? super DeviceManager$uploadLog$1> continuation) {
        super(continuation);
        this.this$0 = deviceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.uploadLog((Context) null, (IssueType) null, (LogLength) null, (String) null, (ProgressListener) null, this);
    }
}
