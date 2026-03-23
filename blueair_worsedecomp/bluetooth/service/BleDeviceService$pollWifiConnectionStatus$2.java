package com.blueair.bluetooth.service;

import com.blueair.bluetooth.espressif.Provision;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.bluetooth.service.BleDeviceService$pollWifiConnectionStatus$2", f = "BleDeviceService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BleDeviceService.kt */
final class BleDeviceService$pollWifiConnectionStatus$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BleDeviceService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BleDeviceService$pollWifiConnectionStatus$2(BleDeviceService bleDeviceService, Continuation<? super BleDeviceService$pollWifiConnectionStatus$2> continuation) {
        super(2, continuation);
        this.this$0 = bleDeviceService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BleDeviceService$pollWifiConnectionStatus$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BleDeviceService$pollWifiConnectionStatus$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Provision provision = new Provision(this.this$0.getSession());
            final BleDeviceService bleDeviceService = this.this$0;
            provision.pollForWifiConnectionStatus(new Provision.WifiStateListener() {
                /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
                    jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x006c: MOVE  (r4v2 java.lang.CharSequence) = (r8v1 java.lang.String)
                    	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
                    	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
                    	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
                    	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
                    	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
                    	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
                    	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
                    	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
                    */
                public void onWifiStateUpdated(espressif.WifiConstants.WifiStationState r6, espressif.WifiConstants.WifiConnectFailedReason r7, java.lang.Exception r8) {
                    /*
                        r5 = this;
                        timber.log.Timber$Forest r0 = timber.log.Timber.Forest
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        java.lang.String r2 = "pollWifiConnectionStatus: state = "
                        r1.<init>(r2)
                        r1.append(r6)
                        java.lang.String r2 = ", failedReason = "
                        r1.append(r2)
                        r1.append(r7)
                        java.lang.String r1 = r1.toString()
                        r2 = 0
                        java.lang.Object[] r3 = new java.lang.Object[r2]
                        r0.d(r1, r3)
                        if (r8 == 0) goto L_0x002c
                        timber.log.Timber$Forest r0 = timber.log.Timber.Forest
                        r1 = r8
                        java.lang.Throwable r1 = (java.lang.Throwable) r1
                        java.lang.String r3 = "pollWifiConnectionStatus failed"
                        java.lang.Object[] r2 = new java.lang.Object[r2]
                        r0.e(r1, r3, r2)
                    L_0x002c:
                        espressif.WifiConstants$WifiStationState r0 = espressif.WifiConstants.WifiStationState.Connected
                        if (r6 != r0) goto L_0x003a
                        com.blueair.bluetooth.service.BleDeviceService r6 = r1
                        com.blueair.bluetooth.service.BleDeviceState$WifiConnected r7 = com.blueair.bluetooth.service.BleDeviceState.WifiConnected.INSTANCE
                        com.blueair.bluetooth.service.BleDeviceState r7 = (com.blueair.bluetooth.service.BleDeviceState) r7
                        r6.updateState(r7)
                        return
                    L_0x003a:
                        espressif.WifiConstants$WifiStationState r0 = espressif.WifiConstants.WifiStationState.ConnectionFailed
                        if (r6 == r0) goto L_0x0046
                        espressif.WifiConstants$WifiStationState r0 = espressif.WifiConstants.WifiStationState.Disconnected
                        if (r6 == r0) goto L_0x0046
                        if (r8 == 0) goto L_0x0045
                        goto L_0x0046
                    L_0x0045:
                        return
                    L_0x0046:
                        r6 = 0
                        if (r7 == 0) goto L_0x004e
                        java.lang.String r7 = r7.name()
                        goto L_0x004f
                    L_0x004e:
                        r7 = r6
                    L_0x004f:
                        if (r8 == 0) goto L_0x0056
                        java.lang.String r8 = r8.getMessage()
                        goto L_0x0057
                    L_0x0056:
                        r8 = r6
                    L_0x0057:
                        com.blueair.bluetooth.service.BleDeviceService r0 = r1
                        com.blueair.bluetooth.service.BleDeviceError r1 = new com.blueair.bluetooth.service.BleDeviceError
                        com.blueair.bluetooth.service.BleDeviceState$PollingWifiConfigStatus r2 = com.blueair.bluetooth.service.BleDeviceState.PollingWifiConfigStatus.INSTANCE
                        com.blueair.bluetooth.service.BleDeviceState r2 = (com.blueair.bluetooth.service.BleDeviceState) r2
                        r3 = r7
                        java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                        if (r3 == 0) goto L_0x008c
                        int r4 = r3.length()
                        if (r4 != 0) goto L_0x006b
                        goto L_0x008c
                    L_0x006b:
                        r4 = r8
                        java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                        if (r4 == 0) goto L_0x008c
                        int r4 = r4.length()
                        if (r4 != 0) goto L_0x0077
                        goto L_0x008c
                    L_0x0077:
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder
                        r6.<init>()
                        r6.append(r7)
                        java.lang.String r7 = " -- "
                        r6.append(r7)
                        r6.append(r8)
                        java.lang.String r6 = r6.toString()
                        goto L_0x00a4
                    L_0x008c:
                        if (r3 == 0) goto L_0x0097
                        int r3 = r3.length()
                        if (r3 != 0) goto L_0x0095
                        goto L_0x0097
                    L_0x0095:
                        r6 = r7
                        goto L_0x00a4
                    L_0x0097:
                        r7 = r8
                        java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                        if (r7 == 0) goto L_0x00a4
                        int r7 = r7.length()
                        if (r7 != 0) goto L_0x00a3
                        goto L_0x00a4
                    L_0x00a3:
                        r6 = r8
                    L_0x00a4:
                        r1.<init>(r2, r6)
                        r0.updateError(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.blueair.bluetooth.service.BleDeviceService$pollWifiConnectionStatus$2.AnonymousClass1.onWifiStateUpdated(espressif.WifiConstants$WifiStationState, espressif.WifiConstants$WifiConnectFailedReason, java.lang.Exception):void");
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
