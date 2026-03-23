package com.blueair.devicedetails.viewmodel;

import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceSetTimezoneViewModel$setDeviceTimezone$1", f = "DeviceSetTimezoneViewModel.kt", i = {}, l = {55, 55, 55}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceSetTimezoneViewModel.kt */
final class DeviceSetTimezoneViewModel$setDeviceTimezone$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onSuccess;
    final /* synthetic */ TimeZone $timezone;
    int label;
    final /* synthetic */ DeviceSetTimezoneViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceSetTimezoneViewModel$setDeviceTimezone$1(DeviceSetTimezoneViewModel deviceSetTimezoneViewModel, TimeZone timeZone, Function0<Unit> function0, Continuation<? super DeviceSetTimezoneViewModel$setDeviceTimezone$1> continuation) {
        super(1, continuation);
        this.this$0 = deviceSetTimezoneViewModel;
        this.$timezone = timeZone;
        this.$onSuccess = function0;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new DeviceSetTimezoneViewModel$setDeviceTimezone$1(this.this$0, this.$timezone, this.$onSuccess, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((DeviceSetTimezoneViewModel$setDeviceTimezone$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0044, code lost:
        if (r9 == r0) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005b, code lost:
        if (r9 == r0) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0072, code lost:
        if (io.flatcircle.coroutinehelper.ApiResultKt.onFail((io.flatcircle.coroutinehelper.ApiResult) r9, new com.blueair.devicedetails.viewmodel.DeviceSetTimezoneViewModel$setDeviceTimezone$1.AnonymousClass2((kotlin.coroutines.Continuation<? super com.blueair.devicedetails.viewmodel.DeviceSetTimezoneViewModel$setDeviceTimezone$1.AnonymousClass2>) null), r8) == r0) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0074, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0026
            if (r1 == r4) goto L_0x0022
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0075
        L_0x0016:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005e
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0047
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r9)
            com.blueair.devicedetails.viewmodel.DeviceSetTimezoneViewModel r9 = r8.this$0
            com.blueair.devicemanager.DeviceManager r9 = r9.getDeviceManager()
            com.blueair.devicedetails.viewmodel.DeviceSetTimezoneViewModel r1 = r8.this$0
            com.blueair.core.model.Device r1 = r1.getDevice()
            java.lang.String r1 = r1.getUid()
            java.util.TimeZone r6 = r8.$timezone
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r8.label = r4
            java.lang.Object r9 = r9.setDeviceTimezone((java.lang.String) r1, (java.util.TimeZone) r6, (android.content.Context) r5, (kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<okhttp3.ResponseBody>>) r7)
            if (r9 != r0) goto L_0x0047
            goto L_0x0074
        L_0x0047:
            io.flatcircle.coroutinehelper.ApiResult r9 = (io.flatcircle.coroutinehelper.ApiResult) r9
            com.blueair.devicedetails.viewmodel.DeviceSetTimezoneViewModel$setDeviceTimezone$1$1 r1 = new com.blueair.devicedetails.viewmodel.DeviceSetTimezoneViewModel$setDeviceTimezone$1$1
            kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r8.$onSuccess
            r1.<init>(r4, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r4 = r8
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r8.label = r3
            java.lang.Object r9 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r9, r1, r4)
            if (r9 != r0) goto L_0x005e
            goto L_0x0074
        L_0x005e:
            io.flatcircle.coroutinehelper.ApiResult r9 = (io.flatcircle.coroutinehelper.ApiResult) r9
            com.blueair.devicedetails.viewmodel.DeviceSetTimezoneViewModel$setDeviceTimezone$1$2 r1 = new com.blueair.devicedetails.viewmodel.DeviceSetTimezoneViewModel$setDeviceTimezone$1$2
            com.blueair.devicedetails.viewmodel.DeviceSetTimezoneViewModel r3 = r8.this$0
            r1.<init>(r3, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r3 = r8
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r8.label = r2
            java.lang.Object r9 = io.flatcircle.coroutinehelper.ApiResultKt.onFail(r9, r1, r3)
            if (r9 != r0) goto L_0x0075
        L_0x0074:
            return r0
        L_0x0075:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceSetTimezoneViewModel$setDeviceTimezone$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
