package com.blueair.devicedetails.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.fragment.DeviceControlsFragment$onViewCreated$4", f = "DeviceControlsFragment.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceControlsFragment.kt */
final class DeviceControlsFragment$onViewCreated$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DeviceControlsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceControlsFragment$onViewCreated$4(DeviceControlsFragment deviceControlsFragment, Continuation<? super DeviceControlsFragment$onViewCreated$4> continuation) {
        super(2, continuation);
        this.this$0 = deviceControlsFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceControlsFragment$onViewCreated$4(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceControlsFragment$onViewCreated$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: type inference failed for: r8v11, types: [com.blueair.core.model.Device] */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027 A[RETURN] */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0028
        L_0x000f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r8)
        L_0x001a:
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r7.label = r2
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r3, r8)
            if (r8 != r0) goto L_0x0028
            return r0
        L_0x0028:
            com.blueair.devicedetails.fragment.DeviceControlsFragment r8 = r7.this$0
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r8 = r8.getViewModel()
            com.blueair.core.model.Device r8 = r8.getDevice()
            boolean r1 = r8 instanceof com.blueair.core.model.HasTimer
            r3 = 0
            if (r1 == 0) goto L_0x003a
            com.blueair.core.model.HasTimer r8 = (com.blueair.core.model.HasTimer) r8
            goto L_0x003b
        L_0x003a:
            r8 = r3
        L_0x003b:
            if (r8 == 0) goto L_0x0062
            com.blueair.devicedetails.fragment.DeviceControlsFragment r1 = r7.this$0
            r4 = 2
            com.blueair.core.model.TimerState[] r4 = new com.blueair.core.model.TimerState[r4]
            r5 = 0
            com.blueair.core.model.TimerState r6 = com.blueair.core.model.TimerState.START
            r4[r5] = r6
            com.blueair.core.model.TimerState r5 = com.blueair.core.model.TimerState.RESUME
            r4[r2] = r5
            java.util.Set r4 = kotlin.collections.SetsKt.setOf(r4)
            com.blueair.core.model.TimerState r8 = r8.timerStatus()
            boolean r8 = r4.contains(r8)
            if (r8 == 0) goto L_0x0062
            com.blueair.devicedetails.adapter.DeviceControlsAdapter r8 = r1.getAdapterFilter()
            com.blueair.devicedetails.util.DeviceControl r1 = com.blueair.devicedetails.util.DeviceControl.TIMER
            r8.notifyItemChanged(r1)
        L_0x0062:
            com.blueair.devicedetails.fragment.DeviceControlsFragment r8 = r7.this$0
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r8 = r8.getViewModel()
            com.blueair.core.model.Device r8 = r8.getDevice()
            boolean r1 = r8 instanceof com.blueair.core.model.HasAirRefresh
            if (r1 == 0) goto L_0x0073
            com.blueair.core.model.HasAirRefresh r8 = (com.blueair.core.model.HasAirRefresh) r8
            goto L_0x0074
        L_0x0073:
            r8 = r3
        L_0x0074:
            if (r8 == 0) goto L_0x0089
            com.blueair.devicedetails.fragment.DeviceControlsFragment r1 = r7.this$0
            com.blueair.core.model.AirRefreshState r4 = com.blueair.core.model.AirRefreshState.START
            boolean r8 = r8.isInAirRefreshStatus(r4)
            if (r8 == 0) goto L_0x0089
            com.blueair.devicedetails.adapter.DeviceControlsAdapter r8 = r1.getAdapterSchedule()
            com.blueair.devicedetails.util.DeviceControl r1 = com.blueair.devicedetails.util.DeviceControl.AUTO_REFRESH
            r8.notifyItemChanged(r1)
        L_0x0089:
            com.blueair.devicedetails.fragment.DeviceControlsFragment r8 = r7.this$0
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r8 = r8.getViewModel()
            com.blueair.core.model.Device r8 = r8.getDevice()
            boolean r1 = r8 instanceof com.blueair.core.model.HasWick
            if (r1 == 0) goto L_0x009a
            r3 = r8
            com.blueair.core.model.HasWick r3 = (com.blueair.core.model.HasWick) r3
        L_0x009a:
            if (r3 == 0) goto L_0x001a
            com.blueair.devicedetails.fragment.DeviceControlsFragment r8 = r7.this$0
            boolean r1 = r3.getWickdryOn()
            if (r1 == 0) goto L_0x001a
            boolean r1 = r3 instanceof com.blueair.core.model.HasWickDryDuration
            if (r1 == 0) goto L_0x00b3
            com.blueair.devicedetails.adapter.DeviceControlsAdapter r8 = r8.getAdapterLight()
            com.blueair.devicedetails.util.DeviceControl r1 = com.blueair.devicedetails.util.DeviceControl.WICK_DRYING
            r8.notifyItemChanged(r1)
            goto L_0x001a
        L_0x00b3:
            com.blueair.devicedetails.adapter.DeviceControlsAdapter r8 = r8.getAdapterSchedule()
            com.blueair.devicedetails.util.DeviceControl r1 = com.blueair.devicedetails.util.DeviceControl.AUTO_DRY
            r8.notifyItemChanged(r1)
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.fragment.DeviceControlsFragment$onViewCreated$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
