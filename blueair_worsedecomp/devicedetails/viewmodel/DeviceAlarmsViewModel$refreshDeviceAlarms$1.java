package com.blueair.devicedetails.viewmodel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel$refreshDeviceAlarms$1", f = "DeviceAlarmsViewModel.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceAlarmsViewModel.kt */
final class DeviceAlarmsViewModel$refreshDeviceAlarms$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DeviceAlarmsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceAlarmsViewModel$refreshDeviceAlarms$1(DeviceAlarmsViewModel deviceAlarmsViewModel, Continuation<? super DeviceAlarmsViewModel$refreshDeviceAlarms$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceAlarmsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceAlarmsViewModel$refreshDeviceAlarms$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceAlarmsViewModel$refreshDeviceAlarms$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel$refreshDeviceAlarms$1$1", f = "DeviceAlarmsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel$refreshDeviceAlarms$1$1  reason: invalid class name */
    /* compiled from: DeviceAlarmsViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(deviceAlarmsViewModel, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0043, code lost:
            if (kotlin.collections.CollectionsKt.filterNotNull(r1.getAlarms()).isEmpty() == false) goto L_0x0047;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r3.label
                if (r0 != 0) goto L_0x005b
                kotlin.ResultKt.throwOnFailure(r4)
                com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel r4 = r3
                com.blueair.devicemanager.DeviceManager r4 = r4.getDeviceManager()
                java.util.List r4 = r4.getDevices()
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.Collection r0 = (java.util.Collection) r0
                java.util.Iterator r4 = r4.iterator()
            L_0x0021:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto L_0x004d
                java.lang.Object r1 = r4.next()
                com.blueair.core.model.Device r1 = (com.blueair.core.model.Device) r1
                boolean r2 = r1 instanceof com.blueair.core.model.HasAlarm
                if (r2 == 0) goto L_0x0046
                com.blueair.core.model.HasAlarm r1 = (com.blueair.core.model.HasAlarm) r1
                java.util.List r2 = r1.getAlarms()
                java.lang.Iterable r2 = (java.lang.Iterable) r2
                java.util.List r2 = kotlin.collections.CollectionsKt.filterNotNull(r2)
                java.util.Collection r2 = (java.util.Collection) r2
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L_0x0046
                goto L_0x0047
            L_0x0046:
                r1 = 0
            L_0x0047:
                if (r1 == 0) goto L_0x0021
                r0.add(r1)
                goto L_0x0021
            L_0x004d:
                java.util.List r0 = (java.util.List) r0
                com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel r4 = r3
                androidx.lifecycle.MutableLiveData r4 = r4.getLvDeviceAlarms()
                r4.postValue(r0)
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            L_0x005b:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel$refreshDeviceAlarms$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final DeviceAlarmsViewModel deviceAlarmsViewModel = this.this$0;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
