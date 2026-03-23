package com.blueair.adddevice.fragment.legacy;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment$onViewCreated$2", f = "AddDeviceManualUserValidateFragment.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {125, 125, 127}, m = "invokeSuspend", n = {"it", "status", "legacyOta", "$i$a$-also-AddDeviceManualUserValidateFragment$onViewCreated$2$1", "it", "status", "legacyOta", "$i$a$-also-AddDeviceManualUserValidateFragment$onViewCreated$2$1", "it", "status", "legacyOta", "$i$a$-also-AddDeviceManualUserValidateFragment$onViewCreated$2$1"}, s = {"L$2", "L$3", "L$4", "I$0", "L$2", "L$3", "L$4", "I$0", "L$2", "L$3", "L$4", "I$0"})
/* compiled from: AddDeviceManualUserValidateFragment.kt */
final class AddDeviceManualUserValidateFragment$onViewCreated$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ AddDeviceManualUserValidateFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceManualUserValidateFragment$onViewCreated$2(AddDeviceManualUserValidateFragment addDeviceManualUserValidateFragment, Continuation<? super AddDeviceManualUserValidateFragment$onViewCreated$2> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceManualUserValidateFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceManualUserValidateFragment$onViewCreated$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddDeviceManualUserValidateFragment$onViewCreated$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 0
            r6 = 1
            if (r1 == 0) goto L_0x006c
            if (r1 == r6) goto L_0x004f
            if (r1 == r3) goto L_0x0034
            if (r1 != r2) goto L_0x002c
            java.lang.Object r0 = r14.L$4
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            java.lang.Object r0 = r14.L$3
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            java.lang.Object r0 = r14.L$2
            com.blueair.adddevice.DeviceInformationLegacy r0 = (com.blueair.adddevice.DeviceInformationLegacy) r0
            java.lang.Object r0 = r14.L$1
            com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment r0 = (com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment) r0
            java.lang.Object r1 = r14.L$0
            com.blueair.adddevice.DeviceInformationLegacy r1 = (com.blueair.adddevice.DeviceInformationLegacy) r1
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x011d
        L_0x002c:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0034:
            int r1 = r14.I$0
            java.lang.Object r3 = r14.L$4
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            java.lang.Object r7 = r14.L$3
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r8 = r14.L$2
            com.blueair.adddevice.DeviceInformationLegacy r8 = (com.blueair.adddevice.DeviceInformationLegacy) r8
            java.lang.Object r9 = r14.L$1
            com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment r9 = (com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment) r9
            java.lang.Object r10 = r14.L$0
            com.blueair.adddevice.DeviceInformationLegacy r10 = (com.blueair.adddevice.DeviceInformationLegacy) r10
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00e2
        L_0x004f:
            int r1 = r14.I$0
            java.lang.Object r7 = r14.L$4
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r8 = r14.L$3
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r9 = r14.L$2
            com.blueair.adddevice.DeviceInformationLegacy r9 = (com.blueair.adddevice.DeviceInformationLegacy) r9
            java.lang.Object r10 = r14.L$1
            com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment r10 = (com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment) r10
            java.lang.Object r11 = r14.L$0
            com.blueair.adddevice.DeviceInformationLegacy r11 = (com.blueair.adddevice.DeviceInformationLegacy) r11
            kotlin.ResultKt.throwOnFailure(r15)
            r13 = r11
            r11 = r10
            r10 = r13
            goto L_0x00b9
        L_0x006c:
            kotlin.ResultKt.throwOnFailure(r15)
            com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment r15 = r14.this$0
            com.blueair.adddevice.service.AddDeviceService r15 = r15.getAddService()
            com.blueair.adddevice.model.AddDeviceState r15 = r15.getState()
            com.blueair.adddevice.DeviceInformationLegacy r15 = r15.getDeviceInfo()
            if (r15 == 0) goto L_0x0124
            com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment r10 = r14.this$0
            com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment$onViewCreated$2$1$status$1 r1 = new com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment$onViewCreated$2$1$status$1
            r1.<init>(r10, r15, r4)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment$onViewCreated$2$1$legacyOta$1 r7 = new com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment$onViewCreated$2$1$legacyOta$1
            r7.<init>(r10, r15, r4)
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            com.blueair.auth.LocationService r8 = r10.getLocationService()
            boolean r8 = r8.isInChina()
            if (r8 != 0) goto L_0x0124
            r14.L$0 = r15
            r14.L$1 = r10
            r14.L$2 = r15
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r14.L$3 = r8
            r14.L$4 = r7
            r14.I$0 = r5
            r14.label = r6
            java.lang.Object r8 = r1.invoke(r14)
            if (r8 != r0) goto L_0x00b3
            goto L_0x011b
        L_0x00b3:
            r9 = r15
            r11 = r10
            r10 = r9
            r15 = r8
            r8 = r1
            r1 = r5
        L_0x00b9:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 != 0) goto L_0x0124
            r14.L$0 = r10
            r14.L$1 = r11
            r14.L$2 = r9
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r14.L$3 = r15
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r14.L$4 = r15
            r14.I$0 = r1
            r14.label = r3
            java.lang.Object r15 = r7.invoke(r14)
            if (r15 != r0) goto L_0x00de
            goto L_0x011b
        L_0x00de:
            r3 = r7
            r7 = r8
            r8 = r9
            r9 = r11
        L_0x00e2:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 != 0) goto L_0x0124
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.String r11 = "Manual onboarding: device status is not online!"
            java.lang.Object[] r12 = new java.lang.Object[r5]
            r15.i(r11, r12)
            com.blueair.devicemanager.DeviceManager r15 = r9.getDeviceManager()
            java.lang.String r11 = r8.getId()
            r14.L$0 = r10
            r14.L$1 = r9
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r14.L$2 = r8
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r14.L$3 = r7
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r14.L$4 = r3
            r14.I$0 = r1
            r14.label = r2
            java.lang.Object r15 = r15.removeAblDeviceRemote(r11, r14)
            if (r15 != r0) goto L_0x011c
        L_0x011b:
            return r0
        L_0x011c:
            r0 = r9
        L_0x011d:
            com.blueair.adddevice.service.AddDeviceService r15 = r0.getAddService()
            com.blueair.adddevice.service.AddDeviceService.restartOnboarding$default(r15, r5, r6, r4)
        L_0x0124:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment$onViewCreated$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
