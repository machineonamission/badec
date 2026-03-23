package com.blueair.adddevice.viewmodel;

import android.app.Application;
import com.blueair.auth.AuthService;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.HasSKU;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0015\u001a\u00020\u0016H@¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH@¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH@¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH@¢\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010$\u001a\u00020\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/blueair/adddevice/viewmodel/FinalizeViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "startTimestamp", "", "hasAnalyticsed", "", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "value", "Lcom/blueair/core/model/HasSKU;", "device", "getDevice", "()Lcom/blueair/core/model/HasSKU;", "setPushToken", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commitDeviceName", "deviceUuid", "", "deviceName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commitDeviceTimezone", "timezone", "Ljava/util/TimeZone;", "(Ljava/lang/String;Ljava/util/TimeZone;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureInitialOnline", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resubscribeMqttRt5s", "notifyAnalytics", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FinalizeViewModel.kt */
public final class FinalizeViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(FinalizeViewModel.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))};
    private final Lazy authService$delegate;
    private HasSKU device;
    private boolean hasAnalyticsed;
    private long startTimestamp = System.currentTimeMillis();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinalizeViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new FinalizeViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.authService$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, AuthService.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
    }

    private final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    public final HasSKU getDevice() {
        return this.device;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setPushToken(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.blueair.adddevice.viewmodel.FinalizeViewModel$setPushToken$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.blueair.adddevice.viewmodel.FinalizeViewModel$setPushToken$1 r0 = (com.blueair.adddevice.viewmodel.FinalizeViewModel$setPushToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.blueair.adddevice.viewmodel.FinalizeViewModel$setPushToken$1 r0 = new com.blueair.adddevice.viewmodel.FinalizeViewModel$setPushToken$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "setPushToken() done"
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r5) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x002d }
            goto L_0x0051
        L_0x002d:
            r8 = move-exception
            goto L_0x005d
        L_0x002f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r8)
            timber.log.Timber$Forest r8 = timber.log.Timber.Forest     // Catch:{ all -> 0x002d }
            java.lang.String r2 = "setPushToken()"
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x002d }
            r8.d(r2, r6)     // Catch:{ all -> 0x002d }
            com.blueair.auth.AuthService r8 = r7.getAuthService()     // Catch:{ all -> 0x002d }
            r0.label = r5     // Catch:{ all -> 0x002d }
            r2 = 0
            java.lang.Object r8 = com.blueair.auth.AuthService.setPushToken$default(r8, r2, r0, r5, r2)     // Catch:{ all -> 0x002d }
            if (r8 != r1) goto L_0x0051
            return r1
        L_0x0051:
            io.flatcircle.coroutinehelper.ApiResult r8 = (io.flatcircle.coroutinehelper.ApiResult) r8     // Catch:{ all -> 0x002d }
            timber.log.Timber$Forest r8 = timber.log.Timber.Forest
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r8.d(r3, r0)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x005d:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r0.d(r3, r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.viewmodel.FinalizeViewModel.setPushToken(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object commitDeviceName(java.lang.String r10, java.lang.String r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r9 = this;
            java.lang.String r0 = "commitDeviceName: deviceUuid = "
            boolean r1 = r12 instanceof com.blueair.adddevice.viewmodel.FinalizeViewModel$commitDeviceName$1
            if (r1 == 0) goto L_0x0016
            r1 = r12
            com.blueair.adddevice.viewmodel.FinalizeViewModel$commitDeviceName$1 r1 = (com.blueair.adddevice.viewmodel.FinalizeViewModel$commitDeviceName$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r12 = r1.label
            int r12 = r12 - r3
            r1.label = r12
            goto L_0x001b
        L_0x0016:
            com.blueair.adddevice.viewmodel.FinalizeViewModel$commitDeviceName$1 r1 = new com.blueair.adddevice.viewmodel.FinalizeViewModel$commitDeviceName$1
            r1.<init>(r9, r12)
        L_0x001b:
            java.lang.Object r12 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            java.lang.String r4 = ") done"
            java.lang.String r5 = ", "
            java.lang.String r6 = "commitDeviceName("
            r7 = 1
            r8 = 0
            if (r3 == 0) goto L_0x0044
            if (r3 != r7) goto L_0x003c
            java.lang.Object r10 = r1.L$1
            r11 = r10
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r10 = r1.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0092 }
            goto L_0x0073
        L_0x003c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r12)
            timber.log.Timber$Forest r12 = timber.log.Timber.Forest     // Catch:{ all -> 0x0092 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0092 }
            r3.<init>(r0)     // Catch:{ all -> 0x0092 }
            r3.append(r10)     // Catch:{ all -> 0x0092 }
            java.lang.String r0 = ", deviceName = "
            r3.append(r0)     // Catch:{ all -> 0x0092 }
            r3.append(r11)     // Catch:{ all -> 0x0092 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0092 }
            java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ all -> 0x0092 }
            r12.d(r0, r3)     // Catch:{ all -> 0x0092 }
            com.blueair.devicemanager.DeviceManager r12 = r9.getDeviceManager()     // Catch:{ all -> 0x0092 }
            r1.L$0 = r10     // Catch:{ all -> 0x0092 }
            r1.L$1 = r11     // Catch:{ all -> 0x0092 }
            r1.label = r7     // Catch:{ all -> 0x0092 }
            java.lang.Object r12 = r12.setDeviceName((java.lang.String) r10, (java.lang.String) r11, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r1)     // Catch:{ all -> 0x0092 }
            if (r12 != r2) goto L_0x0073
            return r2
        L_0x0073:
            timber.log.Timber$Forest r12 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            r0.append(r10)
            r0.append(r5)
            r0.append(r11)
            r0.append(r4)
            java.lang.String r10 = r0.toString()
            java.lang.Object[] r11 = new java.lang.Object[r8]
            r12.d(r10, r11)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0092:
            r12 = move-exception
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r6)
            r1.append(r10)
            r1.append(r5)
            r1.append(r11)
            r1.append(r4)
            java.lang.String r10 = r1.toString()
            java.lang.Object[] r11 = new java.lang.Object[r8]
            r0.d(r10, r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.viewmodel.FinalizeViewModel.commitDeviceName(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.util.TimeZone} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object commitDeviceTimezone(java.lang.String r10, java.util.TimeZone r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r9 = this;
            java.lang.String r0 = "commitDeviceTimezone: deviceUuid = "
            boolean r1 = r12 instanceof com.blueair.adddevice.viewmodel.FinalizeViewModel$commitDeviceTimezone$1
            if (r1 == 0) goto L_0x0016
            r1 = r12
            com.blueair.adddevice.viewmodel.FinalizeViewModel$commitDeviceTimezone$1 r1 = (com.blueair.adddevice.viewmodel.FinalizeViewModel$commitDeviceTimezone$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r12 = r1.label
            int r12 = r12 - r3
            r1.label = r12
            goto L_0x001b
        L_0x0016:
            com.blueair.adddevice.viewmodel.FinalizeViewModel$commitDeviceTimezone$1 r1 = new com.blueair.adddevice.viewmodel.FinalizeViewModel$commitDeviceTimezone$1
            r1.<init>(r9, r12)
        L_0x001b:
            java.lang.Object r12 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            java.lang.String r4 = ") done"
            java.lang.String r5 = ", "
            java.lang.String r6 = "commitDeviceTimezone("
            r7 = 1
            r8 = 0
            if (r3 == 0) goto L_0x0044
            if (r3 != r7) goto L_0x003c
            java.lang.Object r10 = r1.L$1
            r11 = r10
            java.util.TimeZone r11 = (java.util.TimeZone) r11
            java.lang.Object r10 = r1.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x009a }
            goto L_0x0079
        L_0x003c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r12)
            timber.log.Timber$Forest r12 = timber.log.Timber.Forest     // Catch:{ all -> 0x009a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
            r3.<init>(r0)     // Catch:{ all -> 0x009a }
            r3.append(r10)     // Catch:{ all -> 0x009a }
            java.lang.String r0 = ", timezone = "
            r3.append(r0)     // Catch:{ all -> 0x009a }
            r3.append(r11)     // Catch:{ all -> 0x009a }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x009a }
            java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ all -> 0x009a }
            r12.d(r0, r3)     // Catch:{ all -> 0x009a }
            com.blueair.devicemanager.DeviceManager r12 = r9.getDeviceManager()     // Catch:{ all -> 0x009a }
            android.app.Application r0 = r9.getApplication()     // Catch:{ all -> 0x009a }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ all -> 0x009a }
            r1.L$0 = r10     // Catch:{ all -> 0x009a }
            r1.L$1 = r11     // Catch:{ all -> 0x009a }
            r1.label = r7     // Catch:{ all -> 0x009a }
            java.lang.Object r12 = r12.setDeviceTimezone((java.lang.String) r10, (java.util.TimeZone) r11, (android.content.Context) r0, (kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<okhttp3.ResponseBody>>) r1)     // Catch:{ all -> 0x009a }
            if (r12 != r2) goto L_0x0079
            return r2
        L_0x0079:
            io.flatcircle.coroutinehelper.ApiResult r12 = (io.flatcircle.coroutinehelper.ApiResult) r12     // Catch:{ all -> 0x009a }
            timber.log.Timber$Forest r12 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            r0.append(r10)
            r0.append(r5)
            r0.append(r11)
            r0.append(r4)
            java.lang.String r10 = r0.toString()
            java.lang.Object[] r11 = new java.lang.Object[r8]
            r12.d(r10, r11)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x009a:
            r12 = move-exception
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r6)
            r1.append(r10)
            r1.append(r5)
            r1.append(r11)
            r1.append(r4)
            java.lang.String r10 = r1.toString()
            java.lang.Object[] r11 = new java.lang.Object[r8]
            r0.d(r10, r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.viewmodel.FinalizeViewModel.commitDeviceTimezone(java.lang.String, java.util.TimeZone, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r13v22, types: [int] */
    /* JADX WARNING: type inference failed for: r13v26, types: [int] */
    /* JADX WARNING: type inference failed for: r13v28, types: [int] */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a5, code lost:
        timber.log.Timber.Forest.d("ensureInitialOnline(" + r13 + ") started", new java.lang.Object[0]);
        r14 = 0;
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bf, code lost:
        r8 = getDeviceManager();
        r0.L$0 = r13;
        r0.I$0 = r14;
        r0.I$1 = r2;
        r0.label = 2;
        r2 = r8.getBlueDeviceStatus(r13, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d0, code lost:
        if (r2 != r1) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d4, code lost:
        r11 = r2;
        r2 = r13;
        r13 = r14;
        r14 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r14 = (java.lang.Boolean) ((io.flatcircle.coroutinehelper.ApiResult) r14).getOrNull();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e0, code lost:
        if (r14 == null) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e2, code lost:
        r14 = r14.booleanValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e7, code lost:
        r14 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e8, code lost:
        r13 = r13 + 1;
        timber.log.Timber.Forest.d("ensureInitialOnline: checkCount=" + r13 + ", result=" + r14, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0109, code lost:
        if (r14 != false) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x010b, code lost:
        if (r13 < 6) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x010e, code lost:
        r0.L$0 = r2;
        r0.I$0 = r13;
        r0.I$1 = r14;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x011d, code lost:
        if (kotlinx.coroutines.DelayKt.delay(5000, r0) != r1) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0120, code lost:
        r11 = r14;
        r14 = r13;
        r13 = r2;
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0125, code lost:
        timber.log.Timber.Forest.d("ensureInitialOnline: call initial", new java.lang.Object[0]);
        r5 = getDeviceManager();
        r0.L$0 = r2;
        r0.I$0 = r13;
        r0.I$1 = r14;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x013f, code lost:
        if (r5.checkInitialOnline(r2, r0) != r1) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0142, code lost:
        r11 = r2;
        r2 = r13;
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        timber.log.Timber.Forest.d("ensureInitialOnline: call initial done", new java.lang.Object[0]);
        r0.L$0 = r13;
        r0.I$0 = r2;
        r0.I$1 = r14;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x015d, code lost:
        if (kotlinx.coroutines.DelayKt.delay(100, r0) != r1) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0160, code lost:
        r5 = getDeviceManager();
        r0.L$0 = r13;
        r0.L$1 = r12;
        r0.I$0 = r2;
        r0.I$1 = r14;
        r0.label = 6;
        r14 = r5.getDatabaseDevice(r13, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0172, code lost:
        if (r14 != r1) goto L_0x0175;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0174, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0175, code lost:
        r0 = r13;
        r13 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0179, code lost:
        if ((r14 instanceof com.blueair.core.model.HasSKU) == false) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x017b, code lost:
        r14 = (com.blueair.core.model.HasSKU) r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x017e, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x017f, code lost:
        r13.device = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0181, code lost:
        timber.log.Timber.Forest.d("ensureInitialOnline(" + r0 + ") done", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0199, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object ensureInitialOnline(java.lang.String r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.blueair.adddevice.viewmodel.FinalizeViewModel$ensureInitialOnline$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.blueair.adddevice.viewmodel.FinalizeViewModel$ensureInitialOnline$1 r0 = (com.blueair.adddevice.viewmodel.FinalizeViewModel$ensureInitialOnline$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.blueair.adddevice.viewmodel.FinalizeViewModel$ensureInitialOnline$1 r0 = new com.blueair.adddevice.viewmodel.FinalizeViewModel$ensureInitialOnline$1
            r0.<init>(r12, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 6
            java.lang.String r4 = ") done"
            r5 = 1
            r6 = 0
            java.lang.String r7 = "ensureInitialOnline("
            switch(r2) {
                case 0: goto L_0x0094;
                case 1: goto L_0x008c;
                case 2: goto L_0x007d;
                case 3: goto L_0x006a;
                case 4: goto L_0x0057;
                case 5: goto L_0x0048;
                case 6: goto L_0x0033;
                default: goto L_0x002b;
            }
        L_0x002b:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0033:
            int r13 = r0.I$1
            int r13 = r0.I$0
            java.lang.Object r13 = r0.L$1
            com.blueair.adddevice.viewmodel.FinalizeViewModel r13 = (com.blueair.adddevice.viewmodel.FinalizeViewModel) r13
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0044 }
            goto L_0x0177
        L_0x0044:
            r13 = move-exception
            r2 = r0
            goto L_0x019d
        L_0x0048:
            int r13 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0066 }
            r14 = r13
            r13 = r5
            goto L_0x0160
        L_0x0057:
            int r13 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0066 }
            r14 = r13
            r13 = r5
            goto L_0x0145
        L_0x0066:
            r13 = move-exception
            r2 = r5
            goto L_0x019d
        L_0x006a:
            int r13 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0079 }
            r14 = r2
            r2 = r13
            r13 = r8
            goto L_0x00bf
        L_0x0079:
            r13 = move-exception
            r2 = r8
            goto L_0x019d
        L_0x007d:
            int r13 = r0.I$1
            int r13 = r0.I$0
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0089 }
            goto L_0x00d8
        L_0x0089:
            r13 = move-exception
            goto L_0x019d
        L_0x008c:
            java.lang.Object r13 = r0.L$0
            java.lang.String r13 = (java.lang.String) r13
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x019a }
            goto L_0x00a5
        L_0x0094:
            kotlin.ResultKt.throwOnFailure(r14)
            r0.L$0 = r13     // Catch:{ all -> 0x019a }
            r0.label = r5     // Catch:{ all -> 0x019a }
            r8 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r14 = kotlinx.coroutines.DelayKt.delay(r8, r0)     // Catch:{ all -> 0x019a }
            if (r14 != r1) goto L_0x00a5
            goto L_0x0174
        L_0x00a5:
            timber.log.Timber$Forest r14 = timber.log.Timber.Forest     // Catch:{ all -> 0x019a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x019a }
            r2.<init>(r7)     // Catch:{ all -> 0x019a }
            r2.append(r13)     // Catch:{ all -> 0x019a }
            java.lang.String r8 = ") started"
            r2.append(r8)     // Catch:{ all -> 0x019a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x019a }
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ all -> 0x019a }
            r14.d(r2, r8)     // Catch:{ all -> 0x019a }
            r14 = r6
            r2 = r14
        L_0x00bf:
            com.blueair.devicemanager.DeviceManager r8 = r12.getDeviceManager()     // Catch:{ all -> 0x019a }
            r0.L$0 = r13     // Catch:{ all -> 0x019a }
            r0.I$0 = r14     // Catch:{ all -> 0x019a }
            r0.I$1 = r2     // Catch:{ all -> 0x019a }
            r2 = 2
            r0.label = r2     // Catch:{ all -> 0x019a }
            java.lang.Object r2 = r8.getBlueDeviceStatus(r13, r0)     // Catch:{ all -> 0x019a }
            if (r2 != r1) goto L_0x00d4
            goto L_0x0174
        L_0x00d4:
            r11 = r2
            r2 = r13
            r13 = r14
            r14 = r11
        L_0x00d8:
            io.flatcircle.coroutinehelper.ApiResult r14 = (io.flatcircle.coroutinehelper.ApiResult) r14     // Catch:{ all -> 0x0089 }
            java.lang.Object r14 = r14.getOrNull()     // Catch:{ all -> 0x0089 }
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ all -> 0x0089 }
            if (r14 == 0) goto L_0x00e7
            boolean r14 = r14.booleanValue()     // Catch:{ all -> 0x0089 }
            goto L_0x00e8
        L_0x00e7:
            r14 = r6
        L_0x00e8:
            int r13 = r13 + r5
            timber.log.Timber$Forest r8 = timber.log.Timber.Forest     // Catch:{ all -> 0x0089 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0089 }
            r9.<init>()     // Catch:{ all -> 0x0089 }
            java.lang.String r10 = "ensureInitialOnline: checkCount="
            r9.append(r10)     // Catch:{ all -> 0x0089 }
            r9.append(r13)     // Catch:{ all -> 0x0089 }
            java.lang.String r10 = ", result="
            r9.append(r10)     // Catch:{ all -> 0x0089 }
            r9.append(r14)     // Catch:{ all -> 0x0089 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0089 }
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ all -> 0x0089 }
            r8.d(r9, r10)     // Catch:{ all -> 0x0089 }
            if (r14 != 0) goto L_0x0125
            if (r13 < r3) goto L_0x010e
            goto L_0x0125
        L_0x010e:
            r0.L$0 = r2     // Catch:{ all -> 0x0089 }
            r0.I$0 = r13     // Catch:{ all -> 0x0089 }
            r0.I$1 = r14     // Catch:{ all -> 0x0089 }
            r8 = 3
            r0.label = r8     // Catch:{ all -> 0x0089 }
            r8 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r8, r0)     // Catch:{ all -> 0x0089 }
            if (r8 != r1) goto L_0x0120
            goto L_0x0174
        L_0x0120:
            r11 = r14
            r14 = r13
            r13 = r2
            r2 = r11
            goto L_0x00bf
        L_0x0125:
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest     // Catch:{ all -> 0x0089 }
            java.lang.String r8 = "ensureInitialOnline: call initial"
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ all -> 0x0089 }
            r5.d(r8, r9)     // Catch:{ all -> 0x0089 }
            com.blueair.devicemanager.DeviceManager r5 = r12.getDeviceManager()     // Catch:{ all -> 0x0089 }
            r0.L$0 = r2     // Catch:{ all -> 0x0089 }
            r0.I$0 = r13     // Catch:{ all -> 0x0089 }
            r0.I$1 = r14     // Catch:{ all -> 0x0089 }
            r8 = 4
            r0.label = r8     // Catch:{ all -> 0x0089 }
            java.lang.Object r5 = r5.checkInitialOnline(r2, r0)     // Catch:{ all -> 0x0089 }
            if (r5 != r1) goto L_0x0142
            goto L_0x0174
        L_0x0142:
            r11 = r2
            r2 = r13
            r13 = r11
        L_0x0145:
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest     // Catch:{ all -> 0x019a }
            java.lang.String r8 = "ensureInitialOnline: call initial done"
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ all -> 0x019a }
            r5.d(r8, r9)     // Catch:{ all -> 0x019a }
            r0.L$0 = r13     // Catch:{ all -> 0x019a }
            r0.I$0 = r2     // Catch:{ all -> 0x019a }
            r0.I$1 = r14     // Catch:{ all -> 0x019a }
            r5 = 5
            r0.label = r5     // Catch:{ all -> 0x019a }
            r8 = 100
            java.lang.Object r5 = kotlinx.coroutines.DelayKt.delay(r8, r0)     // Catch:{ all -> 0x019a }
            if (r5 != r1) goto L_0x0160
            goto L_0x0174
        L_0x0160:
            com.blueair.devicemanager.DeviceManager r5 = r12.getDeviceManager()     // Catch:{ all -> 0x019a }
            r0.L$0 = r13     // Catch:{ all -> 0x019a }
            r0.L$1 = r12     // Catch:{ all -> 0x019a }
            r0.I$0 = r2     // Catch:{ all -> 0x019a }
            r0.I$1 = r14     // Catch:{ all -> 0x019a }
            r0.label = r3     // Catch:{ all -> 0x019a }
            java.lang.Object r14 = r5.getDatabaseDevice(r13, r0)     // Catch:{ all -> 0x019a }
            if (r14 != r1) goto L_0x0175
        L_0x0174:
            return r1
        L_0x0175:
            r0 = r13
            r13 = r12
        L_0x0177:
            boolean r1 = r14 instanceof com.blueair.core.model.HasSKU     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x017e
            com.blueair.core.model.HasSKU r14 = (com.blueair.core.model.HasSKU) r14     // Catch:{ all -> 0x0044 }
            goto L_0x017f
        L_0x017e:
            r14 = 0
        L_0x017f:
            r13.device = r14     // Catch:{ all -> 0x0044 }
            timber.log.Timber$Forest r13 = timber.log.Timber.Forest
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r7)
            r14.append(r0)
            r14.append(r4)
            java.lang.String r14 = r14.toString()
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r13.d(r14, r0)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x019a:
            r14 = move-exception
            r2 = r13
            r13 = r14
        L_0x019d:
            timber.log.Timber$Forest r14 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r7)
            r0.append(r2)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r6]
            r14.d(r0, r1)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.viewmodel.FinalizeViewModel.ensureInitialOnline(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void resubscribeMqttRt5s(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceUuid");
        getDeviceManager().resubscribeMqttRt5s(str);
    }

    public final void notifyAnalytics() {
        Timber.Forest forest = Timber.Forest;
        forest.d("notifyAnalytics: hasAnalyticsed = " + this.hasAnalyticsed, new Object[0]);
        if (!this.hasAnalyticsed) {
            this.hasAnalyticsed = true;
            long currentTimeMillis = System.currentTimeMillis();
            long j = (currentTimeMillis - this.startTimestamp) / ((long) 1000);
            Timber.Forest forest2 = Timber.Forest;
            forest2.d("notifyAnalytics: durationInSeconds = " + j + ", finalizedTimeStamp = " + currentTimeMillis + ", startTimestamp = " + this.startTimestamp, new Object[0]);
            getAnalyticsService().event(new AnalyticEvent.BT_FINALIZE((int) j));
        }
    }
}
