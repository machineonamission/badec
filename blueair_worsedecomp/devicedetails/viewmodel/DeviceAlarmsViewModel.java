package com.blueair.devicedetails.viewmodel;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.core.model.HasAlarm;
import com.blueair.core.util.NetworkMonitor;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0018\u001a\u00020\u0019J&\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\rH@¢\u0006\u0002\u0010\u001fJ\u001e\u0010 \u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u001dH@¢\u0006\u0002\u0010\"R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceAlarmsViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "lvDeviceAlarms", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/blueair/core/model/HasAlarm;", "getLvDeviceAlarms", "()Landroidx/lifecycle/MutableLiveData;", "_networkAvailable", "", "networkMonitor", "Lcom/blueair/core/util/NetworkMonitor;", "getNetworkMonitor", "()Lcom/blueair/core/util/NetworkMonitor;", "networkMonitor$delegate", "Lkotlin/Lazy;", "networkAvailable", "Landroidx/lifecycle/LiveData;", "getNetworkAvailable", "()Landroidx/lifecycle/LiveData;", "refreshDeviceAlarms", "", "updateAlarmSwitch", "hasAlarm", "deviceAlarm", "Lcom/blueair/core/model/DeviceAlarm;", "checked", "(Lcom/blueair/core/model/HasAlarm;Lcom/blueair/core/model/DeviceAlarm;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "alarmToDelete", "(Lcom/blueair/core/model/HasAlarm;Lcom/blueair/core/model/DeviceAlarm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAlarmsViewModel.kt */
public final class DeviceAlarmsViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DeviceAlarmsViewModel.class, "networkMonitor", "getNetworkMonitor()Lcom/blueair/core/util/NetworkMonitor;", 0))};
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _networkAvailable = new MutableLiveData<>();
    private final MutableLiveData<List<HasAlarm>> lvDeviceAlarms = new MutableLiveData<>();
    private final Lazy networkMonitor$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceAlarmsViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new DeviceAlarmsViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.networkMonitor$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, NetworkMonitor.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    public final MutableLiveData<List<HasAlarm>> getLvDeviceAlarms() {
        return this.lvDeviceAlarms;
    }

    /* access modifiers changed from: private */
    public final NetworkMonitor getNetworkMonitor() {
        return (NetworkMonitor) this.networkMonitor$delegate.getValue();
    }

    public final LiveData<Boolean> getNetworkAvailable() {
        return this._networkAvailable;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel$1", f = "DeviceAlarmsViewModel.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel$1  reason: invalid class name */
    /* compiled from: DeviceAlarmsViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DeviceAlarmsViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<Boolean> connectivityStatus = this.this$0.getNetworkMonitor().getConnectivityStatus();
                final DeviceAlarmsViewModel deviceAlarmsViewModel = this.this$0;
                this.label = 1;
                if (connectivityStatus.collect(new FlowCollector() {
                    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                        return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        deviceAlarmsViewModel._networkAvailable.postValue(Boxing.boxBoolean(z));
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
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

    public final void refreshDeviceAlarms() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new DeviceAlarmsViewModel$refreshDeviceAlarms$1(this, (Continuation<? super DeviceAlarmsViewModel$refreshDeviceAlarms$1>) null), 3, (Object) null);
    }

    /* JADX WARNING: type inference failed for: r5v2, types: [java.lang.Object, com.blueair.core.model.Device] */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x010f, code lost:
        if (r8.setAlarm(r7, r1 + 1, r11, r2) != r4) goto L_0x0112;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateAlarmSwitch(com.blueair.core.model.HasAlarm r24, com.blueair.core.model.DeviceAlarm r25, boolean r26, kotlin.coroutines.Continuation<? super kotlin.Unit> r27) {
        /*
            r23 = this;
            r0 = r25
            r1 = r27
            boolean r2 = r1 instanceof com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel$updateAlarmSwitch$1
            if (r2 == 0) goto L_0x001a
            r2 = r1
            com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel$updateAlarmSwitch$1 r2 = (com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel$updateAlarmSwitch$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x001a
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            r3 = r23
            goto L_0x0021
        L_0x001a:
            com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel$updateAlarmSwitch$1 r2 = new com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel$updateAlarmSwitch$1
            r3 = r23
            r2.<init>(r3, r1)
        L_0x0021:
            java.lang.Object r1 = r2.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r2.label
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L_0x006e
            if (r5 == r7) goto L_0x0056
            if (r5 != r6) goto L_0x004e
            int r0 = r2.I$0
            boolean r0 = r2.Z$0
            java.lang.Object r0 = r2.L$4
            com.blueair.core.model.DeviceAlarm r0 = (com.blueair.core.model.DeviceAlarm) r0
            java.lang.Object r0 = r2.L$3
            com.blueair.core.model.Device r0 = (com.blueair.core.model.Device) r0
            java.lang.Object r0 = r2.L$2
            com.blueair.core.model.HasAlarm r0 = (com.blueair.core.model.HasAlarm) r0
            java.lang.Object r0 = r2.L$1
            com.blueair.core.model.DeviceAlarm r0 = (com.blueair.core.model.DeviceAlarm) r0
            java.lang.Object r0 = r2.L$0
            com.blueair.core.model.HasAlarm r0 = (com.blueair.core.model.HasAlarm) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0112
        L_0x004e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0056:
            int r0 = r2.I$0
            boolean r5 = r2.Z$0
            java.lang.Object r7 = r2.L$2
            com.blueair.core.model.HasAlarm r7 = (com.blueair.core.model.HasAlarm) r7
            java.lang.Object r8 = r2.L$1
            com.blueair.core.model.DeviceAlarm r8 = (com.blueair.core.model.DeviceAlarm) r8
            java.lang.Object r9 = r2.L$0
            com.blueair.core.model.HasAlarm r9 = (com.blueair.core.model.HasAlarm) r9
            kotlin.ResultKt.throwOnFailure(r1)
            r12 = r5
            r5 = r1
            r1 = r0
            r0 = r8
            goto L_0x00a5
        L_0x006e:
            kotlin.ResultKt.throwOnFailure(r1)
            java.util.List r1 = r24.getAlarms()
            int r1 = r1.indexOf(r0)
            r5 = -1
            if (r1 != r5) goto L_0x007f
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x007f:
            com.blueair.devicemanager.DeviceManager r5 = r3.getDeviceManager()
            java.lang.String r8 = r24.getUid()
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r24)
            r2.L$0 = r9
            r2.L$1 = r0
            r9 = r24
            r2.L$2 = r9
            r10 = r26
            r2.Z$0 = r10
            r2.I$0 = r1
            r2.label = r7
            java.lang.Object r5 = r5.getDatabaseDevice(r8, r2)
            if (r5 != r4) goto L_0x00a3
            goto L_0x0111
        L_0x00a3:
            r7 = r9
            r12 = r10
        L_0x00a5:
            com.blueair.core.model.Device r5 = (com.blueair.core.model.Device) r5
            boolean r8 = r5 instanceof com.blueair.core.model.HasAlarm
            if (r8 == 0) goto L_0x00bf
            r7 = r5
            com.blueair.core.model.HasAlarm r7 = (com.blueair.core.model.HasAlarm) r7
            java.util.List r8 = r7.getAlarms()
            java.lang.Object r8 = kotlin.collections.CollectionsKt.getOrNull(r8, r1)
            com.blueair.core.model.DeviceAlarm r8 = (com.blueair.core.model.DeviceAlarm) r8
            if (r8 != 0) goto L_0x00bd
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00bd:
            r10 = r8
            goto L_0x00c0
        L_0x00bf:
            r10 = r0
        L_0x00c0:
            com.blueair.devicemanager.DeviceManager r8 = r3.getDeviceManager()
            int r11 = r1 + 1
            r19 = 253(0xfd, float:3.55E-43)
            r20 = 0
            r13 = r11
            r11 = 0
            r14 = r13
            r13 = 0
            r15 = r14
            r14 = 0
            r16 = r15
            r15 = 0
            r17 = r16
            r16 = 0
            r18 = r17
            r17 = 0
            r21 = r18
            r18 = 0
            r22 = r21
            com.blueair.core.model.DeviceAlarm r11 = com.blueair.core.model.DeviceAlarm.copy$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r2.L$0 = r9
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r2.L$1 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r2.L$2 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r2.L$3 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r2.L$4 = r0
            r2.Z$0 = r12
            r2.I$0 = r1
            r2.label = r6
            r13 = r22
            java.lang.Object r0 = r8.setAlarm(r7, r13, r11, r2)
            if (r0 != r4) goto L_0x0112
        L_0x0111:
            return r4
        L_0x0112:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel.updateAlarmSwitch(com.blueair.core.model.HasAlarm, com.blueair.core.model.DeviceAlarm, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r10v3, types: [java.lang.Object, com.blueair.core.model.Device] */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d0, code lost:
        if (getDeviceManager().setAlarm(r9, r8 + 1, (com.blueair.core.model.DeviceAlarm) null, r0) != r1) goto L_0x00d3;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object delete(com.blueair.core.model.HasAlarm r8, com.blueair.core.model.DeviceAlarm r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel$delete$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel$delete$1 r0 = (com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel$delete$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel$delete$1 r0 = new com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel$delete$1
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x005a
            if (r2 == r4) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            int r8 = r0.I$0
            java.lang.Object r8 = r0.L$3
            com.blueair.core.model.Device r8 = (com.blueair.core.model.Device) r8
            java.lang.Object r8 = r0.L$2
            com.blueair.core.model.HasAlarm r8 = (com.blueair.core.model.HasAlarm) r8
            java.lang.Object r8 = r0.L$1
            com.blueair.core.model.DeviceAlarm r8 = (com.blueair.core.model.DeviceAlarm) r8
            java.lang.Object r8 = r0.L$0
            com.blueair.core.model.HasAlarm r8 = (com.blueair.core.model.HasAlarm) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00d3
        L_0x0040:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0048:
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$2
            com.blueair.core.model.HasAlarm r9 = (com.blueair.core.model.HasAlarm) r9
            java.lang.Object r2 = r0.L$1
            com.blueair.core.model.DeviceAlarm r2 = (com.blueair.core.model.DeviceAlarm) r2
            java.lang.Object r4 = r0.L$0
            com.blueair.core.model.HasAlarm r4 = (com.blueair.core.model.HasAlarm) r4
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0091
        L_0x005a:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.List r10 = r8.getAlarms()
            int r10 = r10.indexOf(r9)
            r2 = -1
            if (r10 != r2) goto L_0x006b
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x006b:
            com.blueair.devicemanager.DeviceManager r2 = r7.getDeviceManager()
            java.lang.String r5 = r8.getUid()
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$0 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$1 = r6
            r0.L$2 = r8
            r0.I$0 = r10
            r0.label = r4
            java.lang.Object r2 = r2.getDatabaseDevice(r5, r0)
            if (r2 != r1) goto L_0x008c
            goto L_0x00d2
        L_0x008c:
            r4 = r8
            r8 = r10
            r10 = r2
            r2 = r9
            r9 = r4
        L_0x0091:
            com.blueair.core.model.Device r10 = (com.blueair.core.model.Device) r10
            boolean r5 = r10 instanceof com.blueair.core.model.HasAlarm
            if (r5 == 0) goto L_0x00a9
            r9 = r10
            com.blueair.core.model.HasAlarm r9 = (com.blueair.core.model.HasAlarm) r9
            java.util.List r5 = r9.getAlarms()
            java.lang.Object r5 = kotlin.collections.CollectionsKt.getOrNull(r5, r8)
            com.blueair.core.model.DeviceAlarm r5 = (com.blueair.core.model.DeviceAlarm) r5
            if (r5 != 0) goto L_0x00a9
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00a9:
            com.blueair.devicemanager.DeviceManager r5 = r7.getDeviceManager()
            int r6 = r8 + 1
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r0.L$0 = r4
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$1 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$2 = r2
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$3 = r10
            r0.I$0 = r8
            r0.label = r3
            r8 = 0
            java.lang.Object r8 = r5.setAlarm(r9, r6, r8, r0)
            if (r8 != r1) goto L_0x00d3
        L_0x00d2:
            return r1
        L_0x00d3:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel.delete(com.blueair.core.model.HasAlarm, com.blueair.core.model.DeviceAlarm, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
