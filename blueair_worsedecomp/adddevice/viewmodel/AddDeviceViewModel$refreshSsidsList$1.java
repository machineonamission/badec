package com.blueair.adddevice.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.viewmodel.AddDeviceViewModel$refreshSsidsList$1", f = "AddDeviceViewModel.kt", i = {}, l = {476}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddDeviceViewModel.kt */
final class AddDeviceViewModel$refreshSsidsList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ AddDeviceViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceViewModel$refreshSsidsList$1(AddDeviceViewModel addDeviceViewModel, Continuation<? super AddDeviceViewModel$refreshSsidsList$1> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceViewModel$refreshSsidsList$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddDeviceViewModel$refreshSsidsList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 1
            if (r1 == 0) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            java.lang.Object r0 = r10.L$0
            kotlinx.coroutines.flow.MutableStateFlow r0 = (kotlinx.coroutines.flow.MutableStateFlow) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x003c
        L_0x0013:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r11)
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r11 = r10.this$0
            kotlinx.coroutines.flow.MutableStateFlow r11 = r11._ssids
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r1 = r10.this$0
            com.blueair.bluetooth.service.BleDeviceService r1 = r1.selectedBleDeviceService
            if (r1 == 0) goto L_0x003f
            r3 = r10
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r10.L$0 = r11
            r10.label = r2
            java.lang.Object r1 = r1.wifiScanSync(r3)
            if (r1 != r0) goto L_0x003a
            return r0
        L_0x003a:
            r0 = r11
            r11 = r1
        L_0x003c:
            java.util.List r11 = (java.util.List) r11
            goto L_0x0043
        L_0x003f:
            r0 = 0
            r9 = r0
            r0 = r11
            r11 = r9
        L_0x0043:
            if (r11 != 0) goto L_0x0049
            java.util.List r11 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0049:
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r11 = r11.iterator()
        L_0x0056:
            boolean r3 = r11.hasNext()
            if (r3 == 0) goto L_0x007e
            java.lang.Object r3 = r11.next()
            r4 = r3
            com.blueair.core.model.Ssid r4 = (com.blueair.core.model.Ssid) r4
            java.lang.String r5 = r4.getSsid()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x0056
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0072
            goto L_0x0056
        L_0x0072:
            int r4 = r4.getRssi()
            r5 = -90
            if (r4 <= r5) goto L_0x0056
            r1.add(r3)
            goto L_0x0056
        L_0x007e:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.HashSet r11 = new java.util.HashSet
            r11.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x0090:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00ab
            java.lang.Object r4 = r1.next()
            r5 = r4
            com.blueair.core.model.Ssid r5 = (com.blueair.core.model.Ssid) r5
            java.lang.String r5 = r5.getSsid()
            boolean r5 = r11.add(r5)
            if (r5 == 0) goto L_0x0090
            r3.add(r4)
            goto L_0x0090
        L_0x00ab:
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            kotlin.jvm.internal.StringCompanionObject r11 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.util.Comparator r11 = kotlin.text.StringsKt.getCASE_INSENSITIVE_ORDER(r11)
            com.blueair.adddevice.viewmodel.AddDeviceViewModel$refreshSsidsList$1$invokeSuspend$$inlined$compareBy$1 r1 = new com.blueair.adddevice.viewmodel.AddDeviceViewModel$refreshSsidsList$1$invokeSuspend$$inlined$compareBy$1
            r1.<init>(r11)
            java.util.Comparator r1 = (java.util.Comparator) r1
            java.util.List r11 = kotlin.collections.CollectionsKt.sortedWith(r3, r1)
            r0.setValue(r11)
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r11 = r10.this$0
            int r11 = r11.wifiListRefreshCount
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r0 = r10.this$0
            int r11 = r11 + r2
            r0.wifiListRefreshCount = r11
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r11 = r10.this$0
            java.util.List r11 = r11.logEvents
            java.lang.Object r11 = kotlin.collections.CollectionsKt.lastOrNull(r11)
            boolean r11 = r11 instanceof com.blueair.core.model.AnalyticEvent.OnboardingLogEvent.WifiList
            if (r11 == 0) goto L_0x00e6
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r11 = r10.this$0
            java.util.List r11 = r11.logEvents
            kotlin.collections.CollectionsKt.dropLast(r11, r2)
        L_0x00e6:
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r3 = r10.this$0
            int r4 = r3.wifiListRefreshCount
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r11 = r10.this$0
            kotlinx.coroutines.flow.MutableStateFlow r11 = r11._ssids
            java.lang.Object r11 = r11.getValue()
            java.util.List r11 = (java.util.List) r11
            int r5 = r11.size()
            r7 = 4
            r8 = 0
            r6 = 0
            com.blueair.adddevice.viewmodel.AddDeviceViewModel.logStep3WifiList$default(r3, r4, r5, r6, r7, r8)
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r11 = r10.this$0
            kotlinx.coroutines.flow.MutableStateFlow r11 = r11._isRefreshingSsids
            r0 = 0
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            r11.setValue(r0)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.viewmodel.AddDeviceViewModel$refreshSsidsList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
