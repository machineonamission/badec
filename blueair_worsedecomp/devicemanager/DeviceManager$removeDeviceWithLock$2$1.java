package com.blueair.devicemanager;

import com.blueair.core.model.Device;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$removeDeviceWithLock$2$1", f = "DeviceManager.kt", i = {0, 0, 0, 0, 0, 0}, l = {602}, m = "invokeSuspend", n = {"it", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-DeviceManager$removeDeviceWithLock$2$1$1"}, s = {"L$0", "L$1", "L$5", "L$6", "I$0", "I$1"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$removeDeviceWithLock$2$1 extends SuspendLambda implements Function2<List<? extends String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Device $device;
    int I$0;
    int I$1;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$removeDeviceWithLock$2$1(DeviceManager deviceManager, Device device, Continuation<? super DeviceManager$removeDeviceWithLock$2$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceManager;
        this.$device = device;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceManager$removeDeviceWithLock$2$1 deviceManager$removeDeviceWithLock$2$1 = new DeviceManager$removeDeviceWithLock$2$1(this.this$0, this.$device, continuation);
        deviceManager$removeDeviceWithLock$2$1.L$0 = obj;
        return deviceManager$removeDeviceWithLock$2$1;
    }

    public final Object invoke(List<String> list, Continuation<? super Unit> continuation) {
        return ((DeviceManager$removeDeviceWithLock$2$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00c8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0062  */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = r14.L$0
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r14.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            int r2 = r14.I$0
            java.lang.Object r5 = r14.L$6
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r14.L$4
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r14.L$3
            com.blueair.core.model.Device r6 = (com.blueair.core.model.Device) r6
            java.lang.Object r7 = r14.L$2
            com.blueair.devicemanager.DeviceManager r7 = (com.blueair.devicemanager.DeviceManager) r7
            java.lang.Object r8 = r14.L$1
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00c5
        L_0x002b:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r15)
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "devices linked to aware: "
            r2.<init>(r5)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r15.d(r2, r5)
            r15 = r0
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            com.blueair.devicemanager.DeviceManager r2 = r14.this$0
            com.blueair.core.model.Device r5 = r14.$device
            java.util.Iterator r6 = r15.iterator()
            r7 = r6
            r6 = r5
            r5 = r7
            r8 = r15
            r7 = r2
            r2 = r4
        L_0x005c:
            boolean r15 = r5.hasNext()
            if (r15 == 0) goto L_0x00c8
            java.lang.Object r15 = r5.next()
            r9 = r15
            java.lang.String r9 = (java.lang.String) r9
            r10 = 2
            kotlin.Pair[] r10 = new kotlin.Pair[r10]
            kotlin.Pair r11 = new kotlin.Pair
            com.blueair.database.DeviceField$AutoMode r12 = com.blueair.database.DeviceField.AutoMode.INSTANCE
            com.blueair.core.model.AutoMode r13 = com.blueair.core.model.AutoMode.OFF
            java.lang.String r13 = r13.toText()
            r11.<init>(r12, r13)
            r10[r4] = r11
            kotlin.Pair r11 = new kotlin.Pair
            com.blueair.database.DeviceField$LinkedDeviceUid r12 = com.blueair.database.DeviceField.LinkedDeviceUid.INSTANCE
            java.lang.String r13 = ""
            r11.<init>(r12, r13)
            r10[r3] = r11
            java.util.List r10 = kotlin.collections.CollectionsKt.listOf(r10)
            r7.updateDeviceFields(r9, r10)
            com.blueair.api.ConnectionManager r10 = r7.connection(r9)
            if (r10 == 0) goto L_0x005c
            r11 = r6
            com.blueair.core.model.DeviceAware r11 = (com.blueair.core.model.DeviceAware) r11
            java.lang.String r11 = r11.getUid()
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r14.L$0 = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r14.L$1 = r12
            r14.L$2 = r7
            r14.L$3 = r6
            r14.L$4 = r5
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r14.L$5 = r15
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r14.L$6 = r15
            r14.I$0 = r2
            r14.I$1 = r4
            r14.label = r3
            java.lang.Object r15 = r10.deleteLinkedUid(r11, r14)
            if (r15 != r1) goto L_0x00c5
            return r1
        L_0x00c5:
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            goto L_0x005c
        L_0x00c8:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicemanager.DeviceManager$removeDeviceWithLock$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
