package com.blueair.android.viewmodel;

import com.blueair.core.model.Device;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.DevSettingsViewModel$testWelcomeHome$1", f = "DevSettingsViewModel.kt", i = {}, l = {348, 349}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DevSettingsViewModel.kt */
final class DevSettingsViewModel$testWelcomeHome$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Device $device;
    final /* synthetic */ boolean $isEnter;
    final /* synthetic */ boolean $isMinRadius;
    int label;
    final /* synthetic */ DevSettingsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DevSettingsViewModel$testWelcomeHome$1(DevSettingsViewModel devSettingsViewModel, Device device, boolean z, boolean z2, Continuation<? super DevSettingsViewModel$testWelcomeHome$1> continuation) {
        super(2, continuation);
        this.this$0 = devSettingsViewModel;
        this.$device = device;
        this.$isMinRadius = z;
        this.$isEnter = z2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DevSettingsViewModel$testWelcomeHome$1(this.this$0, this.$device, this.$isMinRadius, this.$isEnter, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DevSettingsViewModel$testWelcomeHome$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0056, code lost:
        if (com.blueair.devicemanager.WelcomeHomeBroadcastReceiver.Companion.handleWelcomeHome(r11.this$0.getDeviceManager(), r11.this$0.getAnalyticsService(), r11.this$0.getScheduleService(), r11.$device.getUid(), r11.$isMinRadius, r11.$isEnter, r11) == r0) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0058, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        if (kotlinx.coroutines.DelayKt.delay(3000, r11) == r0) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0059
        L_0x0012:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x002f
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r11
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r11.label = r3
            r3 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.delay(r3, r12)
            if (r12 != r0) goto L_0x002f
            goto L_0x0058
        L_0x002f:
            com.blueair.devicemanager.WelcomeHomeBroadcastReceiver$Companion r3 = com.blueair.devicemanager.WelcomeHomeBroadcastReceiver.Companion
            com.blueair.android.viewmodel.DevSettingsViewModel r12 = r11.this$0
            com.blueair.devicemanager.DeviceManager r4 = r12.getDeviceManager()
            com.blueair.android.viewmodel.DevSettingsViewModel r12 = r11.this$0
            com.blueair.core.service.AnalyticsService r5 = r12.getAnalyticsService()
            com.blueair.android.viewmodel.DevSettingsViewModel r12 = r11.this$0
            com.blueair.devicemanager.DeviceScheduleService r6 = r12.getScheduleService()
            com.blueair.core.model.Device r12 = r11.$device
            java.lang.String r7 = r12.getUid()
            boolean r8 = r11.$isMinRadius
            boolean r9 = r11.$isEnter
            r10 = r11
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r11.label = r2
            java.lang.Object r12 = r3.handleWelcomeHome(r4, r5, r6, r7, r8, r9, r10)
            if (r12 != r0) goto L_0x0059
        L_0x0058:
            return r0
        L_0x0059:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.DevSettingsViewModel$testWelcomeHome$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
