package com.blueair.adddevice.fragment;

import com.blueair.core.model.BluetoothDevice;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.BluetoothScanResultFragment$connectBleDevice$2", f = "BluetoothScanResultFragment.kt", i = {0, 1, 1}, l = {336, 350}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "connectResult"}, s = {"L$0", "L$0", "Z$0"})
/* compiled from: BluetoothScanResultFragment.kt */
final class BluetoothScanResultFragment$connectBleDevice$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $attempt;
    final /* synthetic */ BluetoothDevice $device;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ BluetoothScanResultFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BluetoothScanResultFragment$connectBleDevice$2(BluetoothScanResultFragment bluetoothScanResultFragment, BluetoothDevice bluetoothDevice, int i, Continuation<? super BluetoothScanResultFragment$connectBleDevice$2> continuation) {
        super(2, continuation);
        this.this$0 = bluetoothScanResultFragment;
        this.$device = bluetoothDevice;
        this.$attempt = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BluetoothScanResultFragment$connectBleDevice$2 bluetoothScanResultFragment$connectBleDevice$2 = new BluetoothScanResultFragment$connectBleDevice$2(this.this$0, this.$device, this.$attempt, continuation);
        bluetoothScanResultFragment$connectBleDevice$2.L$0 = obj;
        return bluetoothScanResultFragment$connectBleDevice$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BluetoothScanResultFragment$connectBleDevice$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c2, code lost:
        if (kotlinx.coroutines.DelayKt.delay(com.google.android.gms.location.DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM, r10) == r0) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00c4, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004f, code lost:
        if (r11 == r0) goto L_0x00c4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.L$0
            r1 = r0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r10.label
            r7 = 0
            r8 = 2
            r9 = 1
            if (r2 == 0) goto L_0x0025
            if (r2 == r9) goto L_0x0021
            if (r2 != r8) goto L_0x0019
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00c5
        L_0x0019:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0052
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()
            r2 = r11
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.blueair.adddevice.fragment.BluetoothScanResultFragment$connectBleDevice$2$connectResult$1 r11 = new com.blueair.adddevice.fragment.BluetoothScanResultFragment$connectBleDevice$2$connectResult$1
            com.blueair.adddevice.fragment.BluetoothScanResultFragment r3 = r10.this$0
            r11.<init>(r3, r7)
            r4 = r11
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r5 = 2
            r6 = 0
            r3 = 0
            kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r1, r2, r3, r4, r5, r6)
            r2 = r10
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r10.L$0 = r3
            r10.label = r9
            java.lang.Object r11 = r11.await(r2)
            if (r11 != r0) goto L_0x0052
            goto L_0x00c4
        L_0x0052:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "deviceSelectPublisher: connectAndEstablishSessionForBleDeviceSync result = "
            r3.<init>(r4)
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r2.d(r3, r4)
            com.blueair.adddevice.fragment.BluetoothScanResultFragment r2 = r10.this$0
            com.blueair.adddevice.dialog.ConnectInstructionsDialog r2 = r2.connectInstructionsDialog
            if (r2 == 0) goto L_0x00d8
            boolean r2 = r2.isVisible()
            if (r2 != r9) goto L_0x00d8
            if (r11 == 0) goto L_0x00ab
            com.blueair.adddevice.fragment.BluetoothScanResultFragment r11 = r10.this$0
            com.blueair.adddevice.adapter.ScannedDevicesAdapter r11 = r11.getAdapter()
            com.blueair.adddevice.model.BluetoothConnectingInfo r0 = new com.blueair.adddevice.model.BluetoothConnectingInfo
            com.blueair.core.model.BluetoothDevice r1 = r10.$device
            java.lang.String r1 = r1.getMac()
            com.blueair.adddevice.model.BluetoothConnectingState$Connected r2 = com.blueair.adddevice.model.BluetoothConnectingState.Connected.INSTANCE
            com.blueair.adddevice.model.BluetoothConnectingState r2 = (com.blueair.adddevice.model.BluetoothConnectingState) r2
            r0.<init>(r1, r2)
            r11.setConnectingInfo(r0)
            com.blueair.adddevice.fragment.BluetoothScanResultFragment r11 = r10.this$0
            com.blueair.adddevice.dialog.ConnectInstructionsDialog r11 = r11.connectInstructionsDialog
            if (r11 == 0) goto L_0x00a1
            r11.dismissAllowingStateLoss()
        L_0x00a1:
            com.blueair.adddevice.fragment.BluetoothScanResultFragment r11 = r10.this$0
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r11 = r11.getViewModel()
            r11.gotoWifiList()
            goto L_0x00d5
        L_0x00ab:
            int r2 = r10.$attempt
            if (r2 >= r8) goto L_0x00d0
            r2 = r10
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r10.L$0 = r1
            r10.Z$0 = r11
            r10.label = r8
            r3 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r3, r2)
            if (r11 != r0) goto L_0x00c5
        L_0x00c4:
            return r0
        L_0x00c5:
            com.blueair.adddevice.fragment.BluetoothScanResultFragment r11 = r10.this$0
            com.blueair.core.model.BluetoothDevice r0 = r10.$device
            int r1 = r10.$attempt
            int r1 = r1 + r9
            r11.connectBleDevice(r0, r1)
            goto L_0x00d5
        L_0x00d0:
            com.blueair.adddevice.fragment.BluetoothScanResultFragment r11 = r10.this$0
            r11.onSelectionLost()
        L_0x00d5:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00d8:
            com.blueair.adddevice.fragment.BluetoothScanResultFragment r11 = r10.this$0
            com.blueair.adddevice.adapter.ScannedDevicesAdapter r11 = r11.getAdapter()
            r11.setConnectingInfo(r7)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.fragment.BluetoothScanResultFragment$connectBleDevice$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
