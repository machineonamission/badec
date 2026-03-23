package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.Device;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$onComplete$1$1", f = "DeviceCreateEditScheduleViewModel.kt", i = {0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5}, l = {649, 651, 656, 658, 659, 661}, m = "invokeSuspend", n = {"deviceSchedule", "deviceSchedule", "allSchedules", "deviceSchedule", "allSchedules", "deviceSchedule", "allSchedules", "latestDevice", "deviceSchedule", "allSchedules", "latestDevice", "deviceSchedule", "allSchedules", "latestDevice"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* compiled from: DeviceCreateEditScheduleViewModel.kt */
final class DeviceCreateEditScheduleViewModel$onComplete$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Device $it;
    final /* synthetic */ Function2<Boolean, Boolean, Unit> $onComplete;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DeviceCreateEditScheduleViewModel this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceCreateEditScheduleViewModel.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$State[] r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$State r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.State.MODIFY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$State r1 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.State.NEW     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$onComplete$1$1.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceCreateEditScheduleViewModel$onComplete$1$1(DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel, Device device, Function2<? super Boolean, ? super Boolean, Unit> function2, Continuation<? super DeviceCreateEditScheduleViewModel$onComplete$1$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceCreateEditScheduleViewModel;
        this.$it = device;
        this.$onComplete = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceCreateEditScheduleViewModel$onComplete$1$1(this.this$0, this.$it, this.$onComplete, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceCreateEditScheduleViewModel$onComplete$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007a, code lost:
        if (r11 == r0) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ae, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$onComplete$1$1.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$onComplete$1$1.AnonymousClass1>) null), r10) == r0) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b4, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00db, code lost:
        r11 = (com.blueair.core.model.Device) r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00dd, code lost:
        if (r11 != null) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00df, code lost:
        r11 = r10.$it;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00e1, code lost:
        r6 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$onComplete$1$1.WhenMappings.$EnumSwitchMapping$0[r10.this$0.getState().ordinal()];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ef, code lost:
        if (r6 == 1) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f1, code lost:
        if (r6 != 2) goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f3, code lost:
        r10.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5);
        r10.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1);
        r10.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11);
        r10.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0115, code lost:
        if (r10.this$0.getDeviceScheduleService().createSchedule(r11, r5, r10) != r0) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0118, code lost:
        r2 = r1;
        r4 = r5;
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0121, code lost:
        throw new kotlin.NoWhenBranchMatchedException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0122, code lost:
        r10.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5);
        r10.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1);
        r10.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11);
        r10.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x014a, code lost:
        if (r10.this$0.getDeviceScheduleService().updateSchedule(r11, r5, r10.this$0.getEditingSchedule(), r10) != r0) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x014d, code lost:
        r6 = r10.this$0;
        r7 = r10.$onComplete;
        r10.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4);
        r10.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2);
        r10.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1);
        r10.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x017a, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$onComplete$1$1.AnonymousClass2((kotlin.coroutines.Continuation<? super com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$onComplete$1$1.AnonymousClass2>) null), r10) != r0) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x017c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x017f, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 2
            r3 = 0
            r4 = 1
            switch(r1) {
                case 0: goto L_0x0057;
                case 1: goto L_0x004f;
                case 2: goto L_0x0043;
                case 3: goto L_0x0036;
                case 4: goto L_0x0025;
                case 5: goto L_0x0025;
                case 6: goto L_0x0014;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0014:
            java.lang.Object r0 = r10.L$2
            com.blueair.core.model.Device r0 = (com.blueair.core.model.Device) r0
            java.lang.Object r0 = r10.L$1
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r10.L$0
            com.blueair.core.model.DeviceSchedule r0 = (com.blueair.core.model.DeviceSchedule) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x017d
        L_0x0025:
            java.lang.Object r1 = r10.L$2
            com.blueair.core.model.Device r1 = (com.blueair.core.model.Device) r1
            java.lang.Object r2 = r10.L$1
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r4 = r10.L$0
            com.blueair.core.model.DeviceSchedule r4 = (com.blueair.core.model.DeviceSchedule) r4
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x014d
        L_0x0036:
            java.lang.Object r1 = r10.L$1
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r5 = r10.L$0
            com.blueair.core.model.DeviceSchedule r5 = (com.blueair.core.model.DeviceSchedule) r5
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00db
        L_0x0043:
            java.lang.Object r0 = r10.L$1
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r10.L$0
            com.blueair.core.model.DeviceSchedule r0 = (com.blueair.core.model.DeviceSchedule) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00b2
        L_0x004f:
            java.lang.Object r1 = r10.L$0
            com.blueair.core.model.DeviceSchedule r1 = (com.blueair.core.model.DeviceSchedule) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x007e
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r11)
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r11 = r10.this$0
            com.blueair.core.model.DeviceSchedule r1 = r11.toDeviceSchedule()
            if (r1 != 0) goto L_0x0065
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0065:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r11 = r10.this$0
            com.blueair.devicemanager.DeviceScheduleService r11 = r11.getDeviceScheduleService()
            java.lang.String r5 = r1.getDeviceId()
            r6 = r10
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r10.L$0 = r1
            r10.label = r4
            java.lang.Object r11 = r11.getSchedulesFor(r5, r6)
            if (r11 != r0) goto L_0x007e
            goto L_0x017c
        L_0x007e:
            java.util.List r11 = (java.util.List) r11
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r5 = r10.this$0
            boolean r5 = r5.hasOverlap(r11)
            if (r5 == 0) goto L_0x00b5
            kotlinx.coroutines.MainCoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$onComplete$1$1$1 r5 = new com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$onComplete$1$1$1
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r6 = r10.this$0
            kotlin.jvm.functions.Function2<java.lang.Boolean, java.lang.Boolean, kotlin.Unit> r7 = r10.$onComplete
            r5.<init>(r6, r7, r3)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r3 = r10
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r10.L$0 = r1
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r10.L$1 = r11
            r10.label = r2
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r4, r5, r3)
            if (r11 != r0) goto L_0x00b2
            goto L_0x017c
        L_0x00b2:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00b5:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r5 = r10.this$0
            com.blueair.devicemanager.DeviceManager r5 = r5.getDeviceManager()
            com.blueair.core.model.Device r6 = r10.$it
            java.lang.String r6 = r6.getUid()
            r7 = r10
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r10.L$0 = r1
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r10.L$1 = r8
            r8 = 3
            r10.label = r8
            java.lang.Object r5 = r5.getDatabaseDevice(r6, r7)
            if (r5 != r0) goto L_0x00d7
            goto L_0x017c
        L_0x00d7:
            r9 = r1
            r1 = r11
            r11 = r5
            r5 = r9
        L_0x00db:
            com.blueair.core.model.Device r11 = (com.blueair.core.model.Device) r11
            if (r11 != 0) goto L_0x00e1
            com.blueair.core.model.Device r11 = r10.$it
        L_0x00e1:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r6 = r10.this$0
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$State r6 = r6.getState()
            int[] r7 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$onComplete$1$1.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r7[r6]
            if (r6 == r4) goto L_0x0122
            if (r6 != r2) goto L_0x011c
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r2 = r10.this$0
            com.blueair.devicemanager.DeviceScheduleService r2 = r2.getDeviceScheduleService()
            r4 = r10
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r10.L$0 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r10.L$1 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r10.L$2 = r6
            r6 = 5
            r10.label = r6
            java.lang.Object r2 = r2.createSchedule(r11, r5, r4)
            if (r2 != r0) goto L_0x0118
            goto L_0x017c
        L_0x0118:
            r2 = r1
            r4 = r5
            r1 = r11
            goto L_0x014d
        L_0x011c:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        L_0x0122:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r2 = r10.this$0
            com.blueair.devicemanager.DeviceScheduleService r2 = r2.getDeviceScheduleService()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r4 = r10.this$0
            com.blueair.core.model.DeviceScheduleMerged r4 = r4.getEditingSchedule()
            r6 = r10
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r10.L$0 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r10.L$1 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r10.L$2 = r7
            r7 = 4
            r10.label = r7
            java.lang.Object r2 = r2.updateSchedule(r11, r5, r4, r6)
            if (r2 != r0) goto L_0x0118
            goto L_0x017c
        L_0x014d:
            kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$onComplete$1$1$2 r5 = new com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$onComplete$1$1$2
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel r6 = r10.this$0
            kotlin.jvm.functions.Function2<java.lang.Boolean, java.lang.Boolean, kotlin.Unit> r7 = r10.$onComplete
            r5.<init>(r6, r7, r3)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r3 = r10
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r10.L$0 = r4
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r10.L$1 = r2
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r10.L$2 = r1
            r1 = 6
            r10.label = r1
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r5, r3)
            if (r11 != r0) goto L_0x017d
        L_0x017c:
            return r0
        L_0x017d:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$onComplete$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
