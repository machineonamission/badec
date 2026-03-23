package com.blueair.bluetooth.service;

import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.bluetooth.service.BleDeviceService", f = "BleDeviceService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {665, 678}, m = "startPollDeviceBounded", n = {"publisher", "pollingDisposable", "isException", "startTime", "MAX_WAIT_TIME", "failCount", "FAIL_DELAY", "FAILCOUNT_MAX", "publisher", "pollingDisposable", "json", "isException", "startTime", "MAX_WAIT_TIME", "failCount", "FAIL_DELAY", "FAILCOUNT_MAX"}, s = {"L$0", "L$1", "I$0", "J$0", "J$1", "I$1", "J$2", "I$2", "L$0", "L$1", "L$2", "I$0", "J$0", "J$1", "I$1", "J$2", "I$2"})
/* compiled from: BleDeviceService.kt */
final class BleDeviceService$startPollDeviceBounded$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BleDeviceService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BleDeviceService$startPollDeviceBounded$1(BleDeviceService bleDeviceService, Continuation<? super BleDeviceService$startPollDeviceBounded$1> continuation) {
        super(continuation);
        this.this$0 = bleDeviceService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startPollDeviceBounded((PublishSubject<String>) null, (Disposable) null, this);
    }
}
