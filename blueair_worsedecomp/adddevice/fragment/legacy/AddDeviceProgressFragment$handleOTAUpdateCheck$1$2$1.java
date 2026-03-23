package com.blueair.adddevice.fragment.legacy;

import com.blueair.adddevice.DeviceInformationLegacy;
import com.blueair.adddevice.model.AddDeviceState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1", f = "AddDeviceProgressFragment.kt", i = {0, 0, 1, 1, 2, 2}, l = {222, 223, 226}, m = "invokeSuspend", n = {"status", "legacyOta", "status", "legacyOta", "status", "legacyOta"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
/* compiled from: AddDeviceProgressFragment.kt */
final class AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeviceInformationLegacy $it;
    final /* synthetic */ AddDeviceState $state;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AddDeviceProgressFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1(AddDeviceProgressFragment addDeviceProgressFragment, DeviceInformationLegacy deviceInformationLegacy, AddDeviceState addDeviceState, Continuation<? super AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceProgressFragment;
        this.$it = deviceInformationLegacy;
        this.$state = addDeviceState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1(this.this$0, this.$it, this.$state, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00cd, code lost:
        if (r9.this$0.getDeviceManager().removeAblDeviceRemote(r9.$it.getId(), r9) == r0) goto L_0x00cf;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            r4 = 3
            if (r1 == 0) goto L_0x003e
            if (r1 == r3) goto L_0x0032
            if (r1 == r2) goto L_0x0026
            if (r1 != r4) goto L_0x001e
            java.lang.Object r0 = r9.L$1
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            java.lang.Object r0 = r9.L$0
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00d0
        L_0x001e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0026:
            java.lang.Object r1 = r9.L$1
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            java.lang.Object r2 = r9.L$0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x009a
        L_0x0032:
            java.lang.Object r1 = r9.L$1
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            java.lang.Object r3 = r9.L$0
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x007c
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r10)
            com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1$status$1 r10 = new com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1$status$1
            com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment r1 = r9.this$0
            com.blueair.adddevice.DeviceInformationLegacy r5 = r9.$it
            r6 = 0
            r10.<init>(r1, r5, r6)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1$legacyOta$1 r1 = new com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1$legacyOta$1
            com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment r5 = r9.this$0
            com.blueair.adddevice.DeviceInformationLegacy r7 = r9.$it
            r1.<init>(r5, r7, r6)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment r5 = r9.this$0
            boolean r6 = r5 instanceof com.blueair.adddevice.fragment.legacy.AddDeviceAutoConfigProgressFragment
            if (r6 == 0) goto L_0x00eb
            com.blueair.auth.LocationService r5 = r5.getLocationService()
            boolean r5 = r5.isInChina()
            if (r5 != 0) goto L_0x00eb
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r9.L$0 = r5
            r9.L$1 = r1
            r9.label = r3
            java.lang.Object r3 = r10.invoke(r9)
            if (r3 != r0) goto L_0x0079
            goto L_0x00cf
        L_0x0079:
            r8 = r3
            r3 = r10
            r10 = r8
        L_0x007c:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x00eb
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r9.L$0 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r9.L$1 = r10
            r9.label = r2
            java.lang.Object r10 = r1.invoke(r9)
            if (r10 != r0) goto L_0x0099
            goto L_0x00cf
        L_0x0099:
            r2 = r3
        L_0x009a:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x00eb
            timber.log.Timber$Forest r10 = timber.log.Timber.Forest
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r5 = "Automatic onboarding: device status is not online!"
            r10.i(r5, r3)
            com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment r10 = r9.this$0
            com.blueair.devicemanager.DeviceManager r10 = r10.getDeviceManager()
            com.blueair.adddevice.DeviceInformationLegacy r3 = r9.$it
            java.lang.String r3 = r3.getId()
            r5 = r9
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r9.L$0 = r2
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r9.L$1 = r1
            r9.label = r4
            java.lang.Object r10 = r10.removeAblDeviceRemote(r3, r5)
            if (r10 != r0) goto L_0x00d0
        L_0x00cf:
            return r0
        L_0x00d0:
            com.blueair.adddevice.model.AddDeviceState r10 = r9.$state
            int r10 = r10.getDeviceType()
            if (r10 != r4) goto L_0x00e2
            com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment r10 = r9.this$0
            com.blueair.adddevice.service.AddDeviceService r10 = r10.getAddService()
            r10.troubleshoot()
            goto L_0x00eb
        L_0x00e2:
            com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment r10 = r9.this$0
            com.blueair.adddevice.service.AddDeviceService r10 = r10.getAddService()
            r10.autoConfigFail()
        L_0x00eb:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
