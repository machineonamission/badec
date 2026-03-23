package com.blueair.devicemanager;

import com.blueair.core.service.AnalyticsService;
import com.google.android.gms.location.Geofence;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.WelcomeHomeBroadcastReceiver$onReceive$1", f = "WelcomeHomeBroadcastReceiver.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {116}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "geofence", "deviceId", "$i$f$forEach", "$i$a$-forEach-WelcomeHomeBroadcastReceiver$onReceive$1$1", "isMinRadius"}, s = {"L$0", "L$5", "L$6", "L$7", "I$0", "I$1", "Z$1"})
/* compiled from: WelcomeHomeBroadcastReceiver.kt */
final class WelcomeHomeBroadcastReceiver$onReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lazy<AnalyticsService> $analyticsService$delegate;
    final /* synthetic */ Lazy<DeviceManager> $deviceManager$delegate;
    final /* synthetic */ boolean $isEnter;
    final /* synthetic */ Lazy<DeviceScheduleService> $scheduleService$delegate;
    final /* synthetic */ List<Geofence> $triggeringGeofenceList;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    boolean Z$0;
    boolean Z$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WelcomeHomeBroadcastReceiver$onReceive$1(List<Geofence> list, boolean z, Lazy<DeviceManager> lazy, Lazy<AnalyticsService> lazy2, Lazy<DeviceScheduleService> lazy3, Continuation<? super WelcomeHomeBroadcastReceiver$onReceive$1> continuation) {
        super(2, continuation);
        this.$triggeringGeofenceList = list;
        this.$isEnter = z;
        this.$deviceManager$delegate = lazy;
        this.$analyticsService$delegate = lazy2;
        this.$scheduleService$delegate = lazy3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WelcomeHomeBroadcastReceiver$onReceive$1(this.$triggeringGeofenceList, this.$isEnter, this.$deviceManager$delegate, this.$analyticsService$delegate, this.$scheduleService$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WelcomeHomeBroadcastReceiver$onReceive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            r7 = r18
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r7.label
            r9 = 1
            r10 = 0
            if (r0 == 0) goto L_0x0046
            if (r0 != r9) goto L_0x003e
            int r0 = r7.I$0
            boolean r1 = r7.Z$0
            java.lang.Object r2 = r7.L$7
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r2 = r7.L$6
            com.google.android.gms.location.Geofence r2 = (com.google.android.gms.location.Geofence) r2
            java.lang.Object r2 = r7.L$4
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r3 = r7.L$3
            kotlin.Lazy r3 = (kotlin.Lazy) r3
            java.lang.Object r4 = r7.L$2
            kotlin.Lazy r4 = (kotlin.Lazy) r4
            java.lang.Object r5 = r7.L$1
            kotlin.Lazy r5 = (kotlin.Lazy) r5
            java.lang.Object r6 = r7.L$0
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            kotlin.ResultKt.throwOnFailure(r19)
            r11 = r10
            r10 = r9
            r9 = r11
            r11 = r0
            r12 = r2
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r6 = r1
            goto L_0x00d4
        L_0x003e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r19)
            java.util.List<com.google.android.gms.location.Geofence> r0 = r7.$triggeringGeofenceList
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r7.$isEnter
            kotlin.Lazy<com.blueair.devicemanager.DeviceManager> r2 = r7.$deviceManager$delegate
            kotlin.Lazy<com.blueair.core.service.AnalyticsService> r3 = r7.$analyticsService$delegate
            kotlin.Lazy<com.blueair.devicemanager.DeviceScheduleService> r4 = r7.$scheduleService$delegate
            java.util.Iterator r5 = r0.iterator()
            r16 = r0
            r6 = r1
            r15 = r2
            r14 = r3
            r13 = r4
            r12 = r5
            r11 = r10
        L_0x0061:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x00da
            java.lang.Object r0 = r12.next()
            r1 = r0
            com.google.android.gms.location.Geofence r1 = (com.google.android.gms.location.Geofence) r1
            java.lang.String r2 = r1.getRequestId()
            java.lang.String r3 = "getRequestId(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.String r4 = "-min_radius"
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String r2 = kotlin.text.StringsKt.removeSuffix((java.lang.String) r2, (java.lang.CharSequence) r5)
            java.lang.String r5 = r1.getRequestId()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            r3 = 2
            r9 = 0
            boolean r5 = kotlin.text.StringsKt.endsWith$default(r5, r4, r10, r3, r9)
            r3 = r0
            com.blueair.devicemanager.WelcomeHomeBroadcastReceiver$Companion r0 = com.blueair.devicemanager.WelcomeHomeBroadcastReceiver.Companion
            r4 = r1
            com.blueair.devicemanager.DeviceManager r1 = com.blueair.devicemanager.WelcomeHomeBroadcastReceiver.onReceive$lambda$0(r15)
            r9 = r4
            r4 = r2
            com.blueair.core.service.AnalyticsService r2 = com.blueair.devicemanager.WelcomeHomeBroadcastReceiver.onReceive$lambda$1(r14)
            r17 = r3
            com.blueair.devicemanager.DeviceScheduleService r3 = com.blueair.devicemanager.WelcomeHomeBroadcastReceiver.onReceive$lambda$2(r13)
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r16)
            r7.L$0 = r10
            r7.L$1 = r15
            r7.L$2 = r14
            r7.L$3 = r13
            r7.L$4 = r12
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r17)
            r7.L$5 = r10
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r7.L$6 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r7.L$7 = r9
            r7.Z$0 = r6
            r7.I$0 = r11
            r9 = 0
            r7.I$1 = r9
            r7.Z$1 = r5
            r10 = 1
            r7.label = r10
            java.lang.Object r0 = r0.handleWelcomeHome(r1, r2, r3, r4, r5, r6, r7)
            if (r0 != r8) goto L_0x00d4
            return r8
        L_0x00d4:
            r7 = r10
            r10 = r9
            r9 = r7
            r7 = r18
            goto L_0x0061
        L_0x00da:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicemanager.WelcomeHomeBroadcastReceiver$onReceive$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
