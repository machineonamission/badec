package com.blueair.database.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.database.repository.DeviceScheduleRepository", f = "DeviceScheduleRepository.kt", i = {}, l = {33}, m = "getSchedules", n = {}, s = {})
/* compiled from: DeviceScheduleRepository.kt */
final class DeviceScheduleRepository$getSchedules$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceScheduleRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceScheduleRepository$getSchedules$1(DeviceScheduleRepository deviceScheduleRepository, Continuation<? super DeviceScheduleRepository$getSchedules$1> continuation) {
        super(continuation);
        this.this$0 = deviceScheduleRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getSchedules(this);
    }
}
