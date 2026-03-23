package com.blueair.adddevice.service;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.service.AddDeviceService$migrationOtaCheck$2", f = "AddDeviceService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {823, 829, 836, 838}, m = "invokeSuspend", n = {"deviceInfo", "currentState", "it", "$i$a$-let-AddDeviceService$migrationOtaCheck$2$1", "deviceInfo", "currentState", "it", "nuDeviceInfoResult", "nuDeviceInfo", "nuCompatibility", "$i$a$-let-AddDeviceService$migrationOtaCheck$2$1", "deviceInfo", "currentState", "it", "nuDeviceInfoResult", "nuDeviceInfo", "migrationOtaCall", "nuCompatibility", "$i$a$-let-AddDeviceService$migrationOtaCheck$2$1", "deviceInfo", "currentState", "it", "nuDeviceInfoResult", "nuDeviceInfo", "migrationOtaCall", "nuCompatibility", "$i$a$-let-AddDeviceService$migrationOtaCheck$2$1"}, s = {"L$0", "L$1", "L$4", "I$0", "L$0", "L$1", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0"})
/* compiled from: AddDeviceService.kt */
final class AddDeviceService$migrationOtaCheck$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $onFailure;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ AddDeviceService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceService$migrationOtaCheck$2(AddDeviceService addDeviceService, Function1<? super String, Unit> function1, Continuation<? super AddDeviceService$migrationOtaCheck$2> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceService;
        this.$onFailure = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceService$migrationOtaCheck$2(this.this$0, this.$onFailure, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddDeviceService$migrationOtaCheck$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r46) {
        /*
            r45 = this;
            r0 = r45
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = ", nuDeviceInfo = "
            java.lang.String r4 = ", nuDeviceId = "
            java.lang.String r5 = "migration ota failed, response = "
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            r10 = 0
            if (r2 == 0) goto L_0x00ca
            if (r2 == r9) goto L_0x00aa
            if (r2 == r8) goto L_0x0078
            if (r2 == r7) goto L_0x004b
            if (r2 != r6) goto L_0x0043
            java.lang.Object r1 = r0.L$7
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r0.L$6
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Object r1 = r0.L$5
            com.blueair.core.model.DeviceDetailsOnAblServer r1 = (com.blueair.core.model.DeviceDetailsOnAblServer) r1
            java.lang.Object r1 = r0.L$4
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Object r1 = r0.L$3
            com.blueair.adddevice.DeviceInformationLegacy r1 = (com.blueair.adddevice.DeviceInformationLegacy) r1
            java.lang.Object r1 = r0.L$2
            com.blueair.adddevice.service.AddDeviceService r1 = (com.blueair.adddevice.service.AddDeviceService) r1
            java.lang.Object r2 = r0.L$1
            com.blueair.adddevice.model.AddDeviceState r2 = (com.blueair.adddevice.model.AddDeviceState) r2
            java.lang.Object r2 = r0.L$0
            com.blueair.adddevice.DeviceInformationLegacy r2 = (com.blueair.adddevice.DeviceInformationLegacy) r2
            kotlin.ResultKt.throwOnFailure(r46)
        L_0x0040:
            r3 = r1
            goto L_0x0264
        L_0x0043:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004b:
            int r2 = r0.I$0
            java.lang.Object r7 = r0.L$8
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r0.L$7
            io.flatcircle.coroutinehelper.ApiResult r8 = (io.flatcircle.coroutinehelper.ApiResult) r8
            java.lang.Object r9 = r0.L$6
            com.blueair.core.model.DeviceDetailsOnAblServer r9 = (com.blueair.core.model.DeviceDetailsOnAblServer) r9
            java.lang.Object r10 = r0.L$5
            io.flatcircle.coroutinehelper.ApiResult r10 = (io.flatcircle.coroutinehelper.ApiResult) r10
            java.lang.Object r12 = r0.L$4
            com.blueair.adddevice.DeviceInformationLegacy r12 = (com.blueair.adddevice.DeviceInformationLegacy) r12
            java.lang.Object r13 = r0.L$3
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            java.lang.Object r14 = r0.L$2
            com.blueair.adddevice.service.AddDeviceService r14 = (com.blueair.adddevice.service.AddDeviceService) r14
            java.lang.Object r15 = r0.L$1
            com.blueair.adddevice.model.AddDeviceState r15 = (com.blueair.adddevice.model.AddDeviceState) r15
            java.lang.Object r6 = r0.L$0
            com.blueair.adddevice.DeviceInformationLegacy r6 = (com.blueair.adddevice.DeviceInformationLegacy) r6
            kotlin.ResultKt.throwOnFailure(r46)
            r11 = r1
            r1 = r14
            goto L_0x01fc
        L_0x0078:
            int r2 = r0.I$0
            java.lang.Object r6 = r0.L$7
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r12 = r0.L$6
            com.blueair.core.model.DeviceDetailsOnAblServer r12 = (com.blueair.core.model.DeviceDetailsOnAblServer) r12
            java.lang.Object r13 = r0.L$5
            io.flatcircle.coroutinehelper.ApiResult r13 = (io.flatcircle.coroutinehelper.ApiResult) r13
            java.lang.Object r14 = r0.L$4
            com.blueair.adddevice.DeviceInformationLegacy r14 = (com.blueair.adddevice.DeviceInformationLegacy) r14
            java.lang.Object r15 = r0.L$3
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            java.lang.Object r7 = r0.L$2
            com.blueair.adddevice.service.AddDeviceService r7 = (com.blueair.adddevice.service.AddDeviceService) r7
            java.lang.Object r11 = r0.L$1
            com.blueair.adddevice.model.AddDeviceState r11 = (com.blueair.adddevice.model.AddDeviceState) r11
            java.lang.Object r8 = r0.L$0
            com.blueair.adddevice.DeviceInformationLegacy r8 = (com.blueair.adddevice.DeviceInformationLegacy) r8
            kotlin.ResultKt.throwOnFailure(r46)
            r9 = r7
            r7 = r6
            r6 = r8
            r8 = r9
            r9 = r46
            r22 = r11
            r10 = r13
            r13 = r15
            r15 = 2
            goto L_0x0167
        L_0x00aa:
            int r2 = r0.I$0
            java.lang.Object r6 = r0.L$4
            com.blueair.adddevice.DeviceInformationLegacy r6 = (com.blueair.adddevice.DeviceInformationLegacy) r6
            java.lang.Object r7 = r0.L$3
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r8 = r0.L$2
            com.blueair.adddevice.service.AddDeviceService r8 = (com.blueair.adddevice.service.AddDeviceService) r8
            java.lang.Object r11 = r0.L$1
            com.blueair.adddevice.model.AddDeviceState r11 = (com.blueair.adddevice.model.AddDeviceState) r11
            java.lang.Object r12 = r0.L$0
            com.blueair.adddevice.DeviceInformationLegacy r12 = (com.blueair.adddevice.DeviceInformationLegacy) r12
            kotlin.ResultKt.throwOnFailure(r46)
            r13 = r12
            r12 = r11
            r11 = r7
            r7 = r8
            r8 = r46
            goto L_0x0107
        L_0x00ca:
            kotlin.ResultKt.throwOnFailure(r46)
            com.blueair.adddevice.service.AddDeviceService r2 = r0.this$0
            com.blueair.adddevice.model.AddDeviceState r2 = r2.getState()
            com.blueair.adddevice.DeviceInformationLegacy r6 = r2.getDeviceInfo()
            com.blueair.adddevice.service.AddDeviceService r2 = r0.this$0
            com.blueair.adddevice.model.AddDeviceState r11 = r2.getState()
            if (r6 == 0) goto L_0x0354
            com.blueair.adddevice.service.AddDeviceService r2 = r0.this$0
            kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> r7 = r0.$onFailure
            com.blueair.devicemanager.DeviceManager r8 = r2.deviceManager
            java.lang.String r12 = r6.getId()
            r0.L$0 = r6
            r0.L$1 = r11
            r0.L$2 = r2
            r0.L$3 = r7
            r0.L$4 = r6
            r0.I$0 = r10
            r0.label = r9
            java.lang.Object r8 = r8.getAblDeviceInfo(r12, r0)
            if (r8 != r1) goto L_0x0102
        L_0x00ff:
            r11 = r1
            goto L_0x0263
        L_0x0102:
            r13 = r6
            r12 = r11
            r11 = r7
            r7 = r2
            r2 = r10
        L_0x0107:
            io.flatcircle.coroutinehelper.ApiResult r8 = (io.flatcircle.coroutinehelper.ApiResult) r8
            java.lang.Object r14 = r8.getOrNull()
            com.blueair.core.model.DeviceDetailsOnAblServer r14 = (com.blueair.core.model.DeviceDetailsOnAblServer) r14
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "addDevice: verifiedDeviceInfoData = "
            r9.<init>(r10)
            r9.append(r14)
            java.lang.String r9 = r9.toString()
            r46 = r6
            r10 = 0
            java.lang.Object[] r6 = new java.lang.Object[r10]
            r15.d(r9, r6)
            if (r14 == 0) goto L_0x012e
            java.lang.String r6 = r14.getCompatibility()
            goto L_0x012f
        L_0x012e:
            r6 = 0
        L_0x012f:
            if (r14 == 0) goto L_0x0351
            com.blueair.devicemanager.DeviceManager r9 = r7.deviceManager
            java.lang.String r10 = r46.getId()
            r0.L$0 = r13
            r0.L$1 = r12
            r0.L$2 = r7
            r0.L$3 = r11
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r46)
            r0.L$4 = r15
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$5 = r15
            r0.L$6 = r14
            r0.L$7 = r6
            r0.I$0 = r2
            r15 = 2
            r0.label = r15
            java.lang.Object r9 = r9.isMigrationOtaRunning(r10, r0)
            if (r9 != r1) goto L_0x015d
            goto L_0x00ff
        L_0x015d:
            r10 = r8
            r22 = r12
            r12 = r14
            r14 = r46
            r8 = r7
            r7 = r6
            r6 = r13
            r13 = r11
        L_0x0167:
            io.flatcircle.coroutinehelper.ApiResult r9 = (io.flatcircle.coroutinehelper.ApiResult) r9
            if (r7 == 0) goto L_0x02ce
            r11 = r7
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            java.lang.String r19 = "foobot"
            r46 = r10
            r10 = r19
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r23 = r1
            r19 = r14
            r1 = 0
            r14 = 0
            boolean r10 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r11, (java.lang.CharSequence) r10, (boolean) r14, (int) r15, (java.lang.Object) r1)
            r1 = 1
            if (r10 != r1) goto L_0x02ce
            com.blueair.core.model.DeviceDetailsOnAblServer r1 = r8.migrationOtaCheck((com.blueair.core.model.DeviceDetailsOnAblServer) r12, (io.flatcircle.coroutinehelper.ApiResult<com.blueair.core.model.MigrationOtaResponse>) r9)
            java.lang.String r10 = r1.getCompatibility()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r7)
            if (r10 == 0) goto L_0x0292
            timber.log.Timber$Forest r10 = timber.log.Timber.Forest
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r5)
            java.lang.Object r12 = r9.getOrNull()
            r11.append(r12)
            r11.append(r4)
            java.lang.String r12 = r6.getId()
            r11.append(r12)
            r11.append(r3)
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            r14 = 0
            java.lang.Object[] r12 = new java.lang.Object[r14]
            r10.d(r11, r12)
            com.blueair.devicemanager.DeviceManager r10 = r8.deviceManager
            java.lang.String r11 = r6.getId()
            r0.L$0 = r6
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r22)
            r0.L$1 = r12
            r0.L$2 = r8
            r0.L$3 = r13
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r19)
            r0.L$4 = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r46)
            r0.L$5 = r12
            r0.L$6 = r1
            r0.L$7 = r9
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$8 = r12
            r0.I$0 = r2
            r12 = 3
            r0.label = r12
            java.lang.Object r10 = r10.removeAblDeviceRemote(r11, r0)
            r11 = r23
            if (r10 != r11) goto L_0x01f2
            goto L_0x0263
        L_0x01f2:
            r10 = r9
            r9 = r1
            r1 = r8
            r8 = r10
            r10 = r46
            r12 = r19
            r15 = r22
        L_0x01fc:
            com.blueair.core.BuildEnvironment r14 = com.blueair.core.BuildEnvironment.INSTANCE
            boolean r14 = r14.isRelease()
            if (r14 != 0) goto L_0x0227
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r5)
            java.lang.Object r5 = r8.getOrNull()
            r14.append(r5)
            r14.append(r4)
            java.lang.String r4 = r6.getId()
            r14.append(r4)
            r14.append(r3)
            r14.append(r9)
            java.lang.String r3 = r14.toString()
            r13.invoke(r3)
        L_0x0227:
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$1 = r3
            r0.L$2 = r1
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r0.L$3 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$4 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$5 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$6 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$7 = r3
            r3 = 0
            r0.L$8 = r3
            r0.I$0 = r2
            r2 = 4
            r0.label = r2
            r2 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.delay(r2, r0)
            if (r2 != r11) goto L_0x0040
        L_0x0263:
            return r11
        L_0x0264:
            com.blueair.adddevice.model.AddDeviceState r4 = new com.blueair.adddevice.model.AddDeviceState
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r26 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r7 = 6
            r8 = 0
            com.blueair.adddevice.service.AddDeviceService.updateState$default(r3, r4, r5, r6, r7, r8)
            goto L_0x0351
        L_0x0292:
            r43 = 786431(0xbffff, float:1.102025E-39)
            r44 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 1
            r42 = 0
            com.blueair.adddevice.model.AddDeviceState r23 = com.blueair.adddevice.model.AddDeviceState.copy$default(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)
            r26 = 6
            r27 = 0
            r22 = r8
            com.blueair.adddevice.service.AddDeviceService.updateState$default(r22, r23, r24, r25, r26, r27)
            goto L_0x0351
        L_0x02ce:
            r7 = r8
            com.blueair.devicemanager.DeviceManager r1 = r7.deviceManager
            boolean r1 = r1.isProbablyInMigrationOta(r9)
            if (r1 == 0) goto L_0x0317
            r7.firmwareVersionCheck(r12)
            r43 = 786431(0xbffff, float:1.102025E-39)
            r44 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 1
            r42 = 0
            com.blueair.adddevice.model.AddDeviceState r23 = com.blueair.adddevice.model.AddDeviceState.copy$default(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)
            r26 = 6
            r27 = 0
            r22 = r7
            com.blueair.adddevice.service.AddDeviceService.updateState$default(r22, r23, r24, r25, r26, r27)
            goto L_0x0351
        L_0x0317:
            r43 = 786431(0xbffff, float:1.102025E-39)
            r44 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 1
            r42 = 0
            com.blueair.adddevice.model.AddDeviceState r23 = com.blueair.adddevice.model.AddDeviceState.copy$default(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)
            r26 = 6
            r27 = 0
            r22 = r7
            com.blueair.adddevice.service.AddDeviceService.updateState$default(r22, r23, r24, r25, r26, r27)
        L_0x0351:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0354:
            r18 = 0
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.service.AddDeviceService$migrationOtaCheck$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
