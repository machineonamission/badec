package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.blueair.adddevice.DeviceInformationLegacy;
import com.blueair.adddevice.model.AddDeviceState;
import com.blueair.auth.LocationService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b&\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u0016H@¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0002JZ\u0010\u001a\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00162\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020!2\u001c\u0010\"\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0$\u0012\u0006\u0012\u0004\u0018\u00010%0#H@¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\u0010H\u0002J\b\u0010(\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006*"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceProgressFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "otaCheckTask", "Ljava/lang/Runnable;", "otaCheckInitTask", "handler", "Landroid/os/Handler;", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "tryAddDeviceToBackend", "attempts", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPause", "addDeviceOnBackend", "retryWithBackoff", "T", "times", "initialDelay", "", "maxDelay", "factor", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(IJJDLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initOTAChecking", "handleOTAUpdateCheck", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceProgressFragment.kt */
public abstract class AddDeviceProgressFragment extends AddDeviceBaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(AddDeviceProgressFragment.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long OTA_CHECK_TIME_DELAY = 5000;
    private static final long OTA_CHECK_TIME_LIMIT = 25000;
    /* access modifiers changed from: private */
    public static boolean backendAddingDeviceBusy;
    /* access modifiers changed from: private */
    public Handler handler;
    private final Lazy locationService$delegate;
    /* access modifiers changed from: private */
    public final Runnable otaCheckInitTask = new AddDeviceProgressFragment$$ExternalSyntheticLambda9(this);
    private final Runnable otaCheckTask = new AddDeviceProgressFragment$$ExternalSyntheticLambda8(this);

    public AddDeviceProgressFragment() {
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AddDeviceProgressFragment$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationService$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, LocationService.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceProgressFragment$Companion;", "", "<init>", "()V", "OTA_CHECK_TIME_DELAY", "", "OTA_CHECK_TIME_LIMIT", "backendAddingDeviceBusy", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceProgressFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public static final void otaCheckTask$lambda$0(AddDeviceProgressFragment addDeviceProgressFragment) {
        addDeviceProgressFragment.handleOTAUpdateCheck();
    }

    /* access modifiers changed from: private */
    public static final void otaCheckInitTask$lambda$1(AddDeviceProgressFragment addDeviceProgressFragment) {
        addDeviceProgressFragment.initOTAChecking();
    }

    /* access modifiers changed from: private */
    public final LocationService getLocationService() {
        return (LocationService) this.locationService$delegate.getValue();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.handler = new Handler();
    }

    public void onResume() {
        super.onResume();
        Handler handler2 = null;
        AddDeviceBaseFragment.showLoading$default(this, false, 1, (Object) null);
        getAsyncSubs().add(getAddService().getPerformBackendAddObserver().observeOn(AndroidSchedulers.mainThread()).subscribe(new AddDeviceProgressFragment$$ExternalSyntheticLambda5(new AddDeviceProgressFragment$$ExternalSyntheticLambda4(this)), new AddDeviceProgressFragment$$ExternalSyntheticLambda7(new AddDeviceProgressFragment$$ExternalSyntheticLambda6())));
        if (getAddService().getState().isReadyForOta()) {
            Timber.Forest.d("onResume() : isReadyForOta", new Object[0]);
            Handler handler3 = this.handler;
            if (handler3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("handler");
            } else {
                handler2 = handler3;
            }
            handler2.post(this.otaCheckInitTask);
        }
        if (!backendAddingDeviceBusy && getAddService().getState().isReadyForBackendAdding()) {
            addDeviceOnBackend();
        }
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$4(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$3(AddDeviceProgressFragment addDeviceProgressFragment, AddDeviceState addDeviceState) {
        Intrinsics.checkNotNullParameter(addDeviceState, "state");
        Timber.Forest forest = Timber.Forest;
        forest.d("stateReadyForBackendObserver success, state = " + addDeviceState, new Object[0]);
        FragmentActivity activity = addDeviceProgressFragment.getActivity();
        if (activity != null) {
            ViewUtils.INSTANCE.showSnackbar((Activity) activity, R.string.adding_device_switching_wifi_message, (ViewUtils.MessageType) ViewUtils.MessageType.INFO.INSTANCE);
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(addDeviceProgressFragment, (CoroutineContext) null, (CoroutineStart) null, new AddDeviceProgressFragment$onResume$1$2(addDeviceProgressFragment, (Continuation<? super AddDeviceProgressFragment$onResume$1$2>) null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$6(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$5(Throwable th) {
        Timber.Forest.e(th);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005e, code lost:
        if (kotlinx.coroutines.DelayKt.delay(com.mapbox.maps.plugin.locationcomponent.LocationComponentConstants.MAX_ANIMATION_DURATION_MS, r0) == r1) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006b, code lost:
        if (tryAddDeviceToBackend(r7 + 1, r0) != r1) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006d, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object tryAddDeviceToBackend(int r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment$tryAddDeviceToBackend$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment$tryAddDeviceToBackend$1 r0 = (com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment$tryAddDeviceToBackend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment$tryAddDeviceToBackend$1 r0 = new com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment$tryAddDeviceToBackend$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            int r7 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006e
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0037:
            int r7 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0061
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = 10
            if (r7 > r8) goto L_0x0071
            io.flatcircle.connectivityhelper.NetUtil r8 = io.flatcircle.connectivityhelper.NetUtil.INSTANCE
            android.content.Context r2 = r6.getContext()
            boolean r8 = r8.isProbablyOnline((android.content.Context) r2)
            if (r8 == 0) goto L_0x0054
            r6.addDeviceOnBackend()
            goto L_0x0082
        L_0x0054:
            r0.I$0 = r7
            r0.label = r4
            r4 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r4, r0)
            if (r8 != r1) goto L_0x0061
            goto L_0x006d
        L_0x0061:
            int r8 = r7 + 1
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r7 = r6.tryAddDeviceToBackend(r8, r0)
            if (r7 != r1) goto L_0x006e
        L_0x006d:
            return r1
        L_0x006e:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0071:
            timber.log.Timber$Forest r7 = timber.log.Timber.Forest
            r8 = 0
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.String r0 = "tryAddDeviceToBackend : 10 attempts made, could not connect to internet."
            r7.w(r0, r8)
            com.blueair.adddevice.service.AddDeviceService r7 = r6.getAddService()
            r7.addOnBackendFail()
        L_0x0082:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment.tryAddDeviceToBackend(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object tryAddDeviceToBackend$default(AddDeviceProgressFragment addDeviceProgressFragment, int i, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = 0;
            }
            return addDeviceProgressFragment.tryAddDeviceToBackend(i, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryAddDeviceToBackend");
    }

    public void onPause() {
        Timber.Forest.d("onPause", new Object[0]);
        hideLoading();
        super.onPause();
    }

    private final void addDeviceOnBackend() {
        AddDeviceState state = getAddService().getState();
        Timber.Forest forest = Timber.Forest;
        forest.d("addDeviceOnBackend: thread = " + Thread.currentThread() + ", this = " + this + ", backendAddingDeviceBusy = " + backendAddingDeviceBusy + ", isReadyForBackendAdding = " + state.isReadyForBackendAdding() + ", state = " + state, new Object[0]);
        DeviceInformationLegacy deviceInfo = state.getDeviceInfo();
        if (!backendAddingDeviceBusy && state.isReadyForBackendAdding() && deviceInfo != null) {
            Timber.Forest.d("addDeviceOnBackend: addDevice", new Object[0]);
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AddDeviceProgressFragment$addDeviceOnBackend$1(this, deviceInfo, (Continuation<? super AddDeviceProgressFragment$addDeviceOnBackend$1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c1 A[SYNTHETIC, Splitter:B:25:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x015a A[PHI: r3 
      PHI: (r3v1 ? extends java.lang.Object) = (r3v2 ? extends java.lang.Object), (r3v3 ? extends java.lang.Object), (r3v3 ? extends java.lang.Object) binds: [B:37:0x0114, B:41:0x0158, B:30:0x00dd] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.lang.Object retryWithBackoff(int r22, long r23, long r25, double r27, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r29, kotlin.coroutines.Continuation<? super T> r30) {
        /*
            r21 = this;
            r0 = r30
            boolean r1 = r0 instanceof com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment$retryWithBackoff$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment$retryWithBackoff$1 r1 = (com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment$retryWithBackoff$1) r1
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
            com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment$retryWithBackoff$1 r1 = new com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment$retryWithBackoff$1
            r2 = r21
            r1.<init>(r2, r0)
        L_0x001f:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r6 = 3
            r7 = 2
            r8 = 1
            if (r4 == 0) goto L_0x00a3
            if (r4 == r8) goto L_0x0076
            if (r4 == r7) goto L_0x004e
            if (r4 != r6) goto L_0x0046
            double r3 = r1.D$0
            long r3 = r1.J$1
            long r3 = r1.J$0
            int r3 = r1.I$0
            java.lang.Object r3 = r1.L$1
            kotlin.jvm.internal.Ref$LongRef r3 = (kotlin.jvm.internal.Ref.LongRef) r3
            java.lang.Object r1 = r1.L$0
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            kotlin.ResultKt.throwOnFailure(r0)
            return r0
        L_0x0046:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004e:
            int r4 = r1.I$4
            int r4 = r1.I$3
            int r4 = r1.I$2
            int r9 = r1.I$1
            double r10 = r1.D$0
            long r12 = r1.J$1
            long r14 = r1.J$0
            int r6 = r1.I$0
            java.lang.Object r7 = r1.L$1
            kotlin.jvm.internal.Ref$LongRef r7 = (kotlin.jvm.internal.Ref.LongRef) r7
            java.lang.Object r8 = r1.L$0
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r6
            r22 = r12
            r13 = r9
            r19 = r10
            r11 = r1
            r1 = r8
            r8 = r19
        L_0x0073:
            r10 = r7
            goto L_0x011f
        L_0x0076:
            int r4 = r1.I$4
            int r6 = r1.I$3
            int r7 = r1.I$2
            int r8 = r1.I$1
            double r9 = r1.D$0
            long r11 = r1.J$1
            long r13 = r1.J$0
            int r15 = r1.I$0
            java.lang.Object r5 = r1.L$1
            kotlin.jvm.internal.Ref$LongRef r5 = (kotlin.jvm.internal.Ref.LongRef) r5
            r18 = r0
            java.lang.Object r0 = r1.L$0
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            kotlin.ResultKt.throwOnFailure(r18)     // Catch:{ IOException -> 0x0094 }
            return r18
        L_0x0094:
            r18 = r5
            r5 = r4
            r4 = r7
            r7 = r18
            r19 = r13
            r13 = r8
            r8 = r15
            r14 = r19
            r18 = r3
            goto L_0x00f5
        L_0x00a3:
            r18 = r0
            kotlin.ResultKt.throwOnFailure(r18)
            kotlin.jvm.internal.Ref$LongRef r0 = new kotlin.jvm.internal.Ref$LongRef
            r0.<init>()
            r4 = r23
            r0.element = r4
            int r6 = r22 + -1
            r8 = r27
            r10 = r0
            r11 = r1
            r13 = r6
            r12 = 0
            r0 = r22
            r6 = r25
            r1 = r29
        L_0x00bf:
            if (r12 >= r13) goto L_0x013d
            r11.L$0 = r1     // Catch:{ IOException -> 0x00e2 }
            r11.L$1 = r10     // Catch:{ IOException -> 0x00e2 }
            r11.I$0 = r0     // Catch:{ IOException -> 0x00e2 }
            r11.J$0 = r4     // Catch:{ IOException -> 0x00e2 }
            r11.J$1 = r6     // Catch:{ IOException -> 0x00e2 }
            r11.D$0 = r8     // Catch:{ IOException -> 0x00e2 }
            r11.I$1 = r13     // Catch:{ IOException -> 0x00e2 }
            r11.I$2 = r12     // Catch:{ IOException -> 0x00e2 }
            r11.I$3 = r12     // Catch:{ IOException -> 0x00e2 }
            r14 = 0
            r11.I$4 = r14     // Catch:{ IOException -> 0x00e3 }
            r15 = 1
            r11.label = r15     // Catch:{ IOException -> 0x00e3 }
            java.lang.Object r0 = r1.invoke(r11)     // Catch:{ IOException -> 0x00e3 }
            if (r0 != r3) goto L_0x00e1
            goto L_0x015a
        L_0x00e1:
            return r0
        L_0x00e2:
            r14 = 0
        L_0x00e3:
            r19 = r4
            r5 = r14
            r14 = r19
            r18 = r3
            r4 = r12
            r19 = r8
            r8 = r0
            r0 = r1
            r1 = r11
            r11 = r6
            r7 = r10
            r6 = r4
            r9 = r19
        L_0x00f5:
            long r2 = r7.element
            r1.L$0 = r0
            r1.L$1 = r7
            r1.I$0 = r8
            r1.J$0 = r14
            r1.J$1 = r11
            r1.D$0 = r9
            r1.I$1 = r13
            r1.I$2 = r4
            r1.I$3 = r6
            r1.I$4 = r5
            r5 = 2
            r1.label = r5
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.delay(r2, r1)
            r3 = r18
            if (r2 != r3) goto L_0x0117
            goto L_0x015a
        L_0x0117:
            r22 = r11
            r11 = r1
            r1 = r0
            r0 = r8
            r8 = r9
            goto L_0x0073
        L_0x011f:
            long r5 = r10.element
            double r5 = (double) r5
            double r5 = r5 * r8
            long r5 = (long) r5
            r24 = r0
            r25 = r1
            r0 = r22
            long r5 = kotlin.ranges.RangesKt.coerceAtMost((long) r5, (long) r0)
            r10.element = r5
            r17 = 1
            int r12 = r4 + 1
            r2 = r21
            r6 = r0
            r4 = r14
            r0 = r24
            r1 = r25
            goto L_0x00bf
        L_0x013d:
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r11.L$0 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r11.L$1 = r2
            r11.I$0 = r0
            r11.J$0 = r4
            r11.J$1 = r6
            r11.D$0 = r8
            r0 = 3
            r11.label = r0
            java.lang.Object r0 = r1.invoke(r11)
            if (r0 != r3) goto L_0x015b
        L_0x015a:
            return r3
        L_0x015b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment.retryWithBackoff(int, long, long, double, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object retryWithBackoff$default(AddDeviceProgressFragment addDeviceProgressFragment, int i, long j, long j2, double d, Function1 function1, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = Integer.MAX_VALUE;
            }
            if ((i2 & 2) != 0) {
                j = 1000;
            }
            if ((i2 & 4) != 0) {
                j2 = 1200000;
            }
            if ((i2 & 8) != 0) {
                d = 1.5d;
            }
            double d2 = d;
            long j3 = j2;
            long j4 = j;
            return addDeviceProgressFragment.retryWithBackoff(i, j4, j3, d2, function1, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: retryWithBackoff");
    }

    private final void initOTAChecking() {
        Timber.Forest.d("initOTAChecking()", new Object[0]);
        handleOTAUpdateCheck();
    }

    private final void handleOTAUpdateCheck() {
        Timber.Forest.d("handleOTAUpdateCheck()", new Object[0]);
        getAsyncSubs().add(getAddService().otaUpdateRunningCheckAsync().subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).timeout(OTA_CHECK_TIME_LIMIT, TimeUnit.MILLISECONDS).subscribe(new AddDeviceProgressFragment$$ExternalSyntheticLambda1(new AddDeviceProgressFragment$$ExternalSyntheticLambda0(this)), new AddDeviceProgressFragment$$ExternalSyntheticLambda3(new AddDeviceProgressFragment$$ExternalSyntheticLambda2(this))));
    }

    /* access modifiers changed from: private */
    public static final void handleOTAUpdateCheck$lambda$11(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit handleOTAUpdateCheck$lambda$10(AddDeviceProgressFragment addDeviceProgressFragment, Boolean bool) {
        Timber.Forest forest = Timber.Forest;
        forest.d("handleOTAUpdateCheck : otaUpdateRunningCheckAsync: otaCheckCompleted = " + addDeviceProgressFragment.getAddService().getState().getOtaCheckCompleted() + ", isOTAUpdateRunningAsync: isRunning = " + bool + ", otaCheckAttempts = " + addDeviceProgressFragment.getAddService().getState().getOtaCheckAttempt(), new Object[0]);
        AddDeviceState state = addDeviceProgressFragment.getAddService().getState();
        DeviceInformationLegacy deviceInfo = state.getDeviceInfo();
        if (deviceInfo != null && bool.booleanValue()) {
            addDeviceProgressFragment.getAddService().updateDeviceStatusLocalToOtaUpdating(deviceInfo.getId());
        }
        Handler handler2 = null;
        if (!state.getOtaCheckCompleted()) {
            Handler handler3 = addDeviceProgressFragment.handler;
            if (handler3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("handler");
            } else {
                handler2 = handler3;
            }
            handler2.postDelayed(addDeviceProgressFragment.otaCheckTask, 5000);
        } else {
            Timber.Forest.d("handleOTAUpdateCheck : otaUpdateRunningCheckAsync: state.otaCheckCompleted == true", new Object[0]);
            DeviceInformationLegacy deviceInfo2 = state.getDeviceInfo();
            if (deviceInfo2 != null) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(addDeviceProgressFragment, (CoroutineContext) null, (CoroutineStart) null, new AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1(addDeviceProgressFragment, deviceInfo2, state, (Continuation<? super AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1>) null), 3, (Object) null);
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void handleOTAUpdateCheck$lambda$13(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit handleOTAUpdateCheck$lambda$12(AddDeviceProgressFragment addDeviceProgressFragment, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "t");
        Timber.Forest forest = Timber.Forest;
        forest.e("handleOTAUpdateCheck : otaUpdateRunningCheckAsync failed, otaCheckCompleted = " + addDeviceProgressFragment.getAddService().getState().getOtaCheckCompleted() + TokenParser.SP + th, new Object[0]);
        return Unit.INSTANCE;
    }
}
