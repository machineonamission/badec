package com.blueair.devicedetails.viewmodel;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.devicemanager.DeviceScheduleService;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u001a\u0010\u001d\u001a\u00020\u00192\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00190\u001fJ\u001e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u001cH@¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0015H@¢\u0006\u0002\u0010&R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "deviceScheduleService", "Lcom/blueair/devicemanager/DeviceScheduleService;", "getDeviceScheduleService", "()Lcom/blueair/devicemanager/DeviceScheduleService;", "deviceScheduleService$delegate", "Lkotlin/Lazy;", "schedules", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/blueair/core/model/DeviceScheduleMerged;", "getSchedules", "()Landroidx/lifecycle/MutableLiveData;", "listenToDeviceScheduleLiveData", "", "refreshDeviceSchedule", "localOnly", "", "getLatestDevice", "onResult", "Lkotlin/Function1;", "updateScheduleSwitch", "scheduleMerged", "paused", "(Lcom/blueair/core/model/DeviceScheduleMerged;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "scheduleToDelete", "(Lcom/blueair/core/model/DeviceScheduleMerged;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSchedulesViewModel.kt */
public final class DeviceSchedulesViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DeviceSchedulesViewModel.class, "deviceScheduleService", "getDeviceScheduleService()Lcom/blueair/devicemanager/DeviceScheduleService;", 0))};
    public Device device;
    private final Lazy deviceScheduleService$delegate;
    private final MutableLiveData<List<DeviceScheduleMerged>> schedules = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceSchedulesViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new DeviceSchedulesViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.deviceScheduleService$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, DeviceScheduleService.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
    }

    public final Device getDevice() {
        Device device2 = this.device;
        if (device2 != null) {
            return device2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("device");
        return null;
    }

    public final void setDevice(Device device2) {
        Intrinsics.checkNotNullParameter(device2, "<set-?>");
        this.device = device2;
    }

    /* access modifiers changed from: private */
    public final DeviceScheduleService getDeviceScheduleService() {
        return (DeviceScheduleService) this.deviceScheduleService$delegate.getValue();
    }

    public final MutableLiveData<List<DeviceScheduleMerged>> getSchedules() {
        return this.schedules;
    }

    /* access modifiers changed from: private */
    public final void listenToDeviceScheduleLiveData() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new DeviceSchedulesViewModel$listenToDeviceScheduleLiveData$1(this, (Continuation<? super DeviceSchedulesViewModel$listenToDeviceScheduleLiveData$1>) null), 3, (Object) null);
    }

    public final void refreshDeviceSchedule(boolean z) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new DeviceSchedulesViewModel$refreshDeviceSchedule$1(z, this, (Continuation<? super DeviceSchedulesViewModel$refreshDeviceSchedule$1>) null), 3, (Object) null);
    }

    public final void getLatestDevice(Function1<? super Device, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onResult");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceSchedulesViewModel$getLatestDevice$1(this, function1, (Continuation<? super DeviceSchedulesViewModel$getLatestDevice$1>) null), 2, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d1, code lost:
        if (r4.updateSchedule(r0, r6, r7, r1) != r3) goto L_0x00d4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateScheduleSwitch(com.blueair.core.model.DeviceScheduleMerged r22, boolean r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            r21 = this;
            r0 = r24
            boolean r1 = r0 instanceof com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel$updateScheduleSwitch$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel$updateScheduleSwitch$1 r1 = (com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel$updateScheduleSwitch$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r21
            goto L_0x001f
        L_0x0018:
            com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel$updateScheduleSwitch$1 r1 = new com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel$updateScheduleSwitch$1
            r2 = r21
            r1.<init>(r2, r0)
        L_0x001f:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x0059
            if (r4 == r6) goto L_0x004a
            if (r4 != r5) goto L_0x0042
            boolean r3 = r1.Z$0
            java.lang.Object r3 = r1.L$2
            com.blueair.core.model.Device r3 = (com.blueair.core.model.Device) r3
            java.lang.Object r3 = r1.L$1
            com.blueair.core.model.DeviceSchedule r3 = (com.blueair.core.model.DeviceSchedule) r3
            java.lang.Object r1 = r1.L$0
            com.blueair.core.model.DeviceScheduleMerged r1 = (com.blueair.core.model.DeviceScheduleMerged) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00d4
        L_0x0042:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004a:
            boolean r4 = r1.Z$0
            java.lang.Object r6 = r1.L$1
            com.blueair.core.model.DeviceSchedule r6 = (com.blueair.core.model.DeviceSchedule) r6
            java.lang.Object r7 = r1.L$0
            com.blueair.core.model.DeviceScheduleMerged r7 = (com.blueair.core.model.DeviceScheduleMerged) r7
            kotlin.ResultKt.throwOnFailure(r0)
            r14 = r4
            goto L_0x00ab
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r0)
            java.util.List r0 = r22.getSchedule()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0069
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0069:
            java.util.List r0 = r22.getSchedule()
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r0)
            r7 = r0
            com.blueair.core.model.DeviceSchedule r7 = (com.blueair.core.model.DeviceSchedule) r7
            r19 = 1983(0x7bf, float:2.779E-42)
            r20 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r14 = r23
            com.blueair.core.model.DeviceSchedule r0 = com.blueair.core.model.DeviceSchedule.copy$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            com.blueair.devicemanager.DeviceManager r4 = r2.getDeviceManager()
            com.blueair.core.model.Device r7 = r2.getDevice()
            java.lang.String r7 = r7.getUid()
            r8 = r22
            r1.L$0 = r8
            r1.L$1 = r0
            r1.Z$0 = r14
            r1.label = r6
            java.lang.Object r4 = r4.getDatabaseDevice(r7, r1)
            if (r4 != r3) goto L_0x00a8
            goto L_0x00d3
        L_0x00a8:
            r6 = r0
            r0 = r4
            r7 = r8
        L_0x00ab:
            com.blueair.core.model.Device r0 = (com.blueair.core.model.Device) r0
            if (r0 != 0) goto L_0x00b3
            com.blueair.core.model.Device r0 = r2.getDevice()
        L_0x00b3:
            com.blueair.devicemanager.DeviceScheduleService r4 = r2.getDeviceScheduleService()
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r1.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r1.L$1 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r1.L$2 = r8
            r1.Z$0 = r14
            r1.label = r5
            java.lang.Object r0 = r4.updateSchedule(r0, r6, r7, r1)
            if (r0 != r3) goto L_0x00d4
        L_0x00d3:
            return r3
        L_0x00d4:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel.updateScheduleSwitch(com.blueair.core.model.DeviceScheduleMerged, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object delete(DeviceScheduleMerged deviceScheduleMerged, Continuation<? super Unit> continuation) {
        Object deleteMergedSchedule = getDeviceScheduleService().deleteMergedSchedule(getDevice(), deviceScheduleMerged, continuation);
        return deleteMergedSchedule == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? deleteMergedSchedule : Unit.INSTANCE;
    }
}
