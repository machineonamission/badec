package com.blueair.adddevice.fragment.legacy;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.airboxlab.icp.sdk.BlueAirManager;
import com.blueair.adddevice.R;
import com.blueair.adddevice.databinding.FragmentAddDeviceAutoStepTwoIcpBinding;
import com.blueair.adddevice.dialog.CannotFindIcpDialog;
import com.blueair.adddevice.service.AddDeviceService;
import com.blueair.devicemanager.IcpDevice;
import com.blueair.devicemanager.IcpDeviceConnection;
import com.blueair.devicemanager.IcpDeviceInfo;
import com.blueair.devicemanager.IcpDeviceManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.subjects.BehaviorSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0006H\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010\"\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\b\u0010$\u001a\u00020\u0016H\u0002J\b\u0010%\u001a\u00020\u0016H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/IcpPairDeviceFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "reconnectAction", "Lio/reactivex/subjects/BehaviorSubject;", "", "shouldReconnectOnConnect", "Ljava/util/concurrent/atomic/AtomicBoolean;", "blueAirManager", "Lcom/airboxlab/icp/sdk/BlueAirManager;", "getBlueAirManager", "()Lcom/airboxlab/icp/sdk/BlueAirManager;", "blueAirManager$delegate", "Lkotlin/Lazy;", "icpDeviceManager", "Lcom/blueair/devicemanager/IcpDeviceManager;", "binding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceAutoStepTwoIcpBinding;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "showWhiteProgressIndicator", "", "shouldShow", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onCreate", "onResume", "scanAndPair", "pairingFailed", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: IcpPairDeviceFragment.kt */
public final class IcpPairDeviceFragment extends AddDeviceBaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(IcpPairDeviceFragment.class, "blueAirManager", "getBlueAirManager()Lcom/airboxlab/icp/sdk/BlueAirManager;", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private FragmentAddDeviceAutoStepTwoIcpBinding binding;
    private final Lazy blueAirManager$delegate;
    private IcpDeviceManager icpDeviceManager;
    private BehaviorSubject<Boolean> reconnectAction;
    private AtomicBoolean shouldReconnectOnConnect = new AtomicBoolean(true);

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IcpPairDeviceFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.devicemanager.IcpDeviceManager$IcpDeviceConnectionState[] r0 = com.blueair.devicemanager.IcpDeviceManager.IcpDeviceConnectionState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.devicemanager.IcpDeviceManager$IcpDeviceConnectionState r1 = com.blueair.devicemanager.IcpDeviceManager.IcpDeviceConnectionState.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.devicemanager.IcpDeviceManager$IcpDeviceConnectionState r1 = com.blueair.devicemanager.IcpDeviceManager.IcpDeviceConnectionState.CONNECTING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.devicemanager.IcpDeviceManager$IcpDeviceConnectionState r1 = com.blueair.devicemanager.IcpDeviceManager.IcpDeviceConnectionState.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.fragment.legacy.IcpPairDeviceFragment.WhenMappings.<clinit>():void");
        }
    }

    public IcpPairDeviceFragment() {
        BehaviorSubject<Boolean> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        this.reconnectAction = create;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new IcpPairDeviceFragment$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.blueAirManager$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, BlueAirManager.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
    }

    private final BlueAirManager getBlueAirManager() {
        return (BlueAirManager) this.blueAirManager$delegate.getValue();
    }

    public ConstraintLayout getRootView() {
        FragmentAddDeviceAutoStepTwoIcpBinding fragmentAddDeviceAutoStepTwoIcpBinding = this.binding;
        if (fragmentAddDeviceAutoStepTwoIcpBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAddDeviceAutoStepTwoIcpBinding = null;
        }
        ConstraintLayout root = fragmentAddDeviceAutoStepTwoIcpBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    static /* synthetic */ void showWhiteProgressIndicator$default(IcpPairDeviceFragment icpPairDeviceFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        icpPairDeviceFragment.showWhiteProgressIndicator(z);
    }

    private final void showWhiteProgressIndicator(boolean z) {
        FragmentAddDeviceAutoStepTwoIcpBinding fragmentAddDeviceAutoStepTwoIcpBinding = this.binding;
        if (fragmentAddDeviceAutoStepTwoIcpBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAddDeviceAutoStepTwoIcpBinding = null;
        }
        fragmentAddDeviceAutoStepTwoIcpBinding.connectingProgress.setVisibility(z ? 0 : 8);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentAddDeviceAutoStepTwoIcpBinding inflate = FragmentAddDeviceAutoStepTwoIcpBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        ConstraintLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        FragmentAddDeviceAutoStepTwoIcpBinding fragmentAddDeviceAutoStepTwoIcpBinding = this.binding;
        FragmentAddDeviceAutoStepTwoIcpBinding fragmentAddDeviceAutoStepTwoIcpBinding2 = null;
        if (fragmentAddDeviceAutoStepTwoIcpBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAddDeviceAutoStepTwoIcpBinding = null;
        }
        fragmentAddDeviceAutoStepTwoIcpBinding.imageAuto.setBackgroundResource(R.drawable.device_icp_knob);
        FragmentAddDeviceAutoStepTwoIcpBinding fragmentAddDeviceAutoStepTwoIcpBinding3 = this.binding;
        if (fragmentAddDeviceAutoStepTwoIcpBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAddDeviceAutoStepTwoIcpBinding3 = null;
        }
        Drawable background = fragmentAddDeviceAutoStepTwoIcpBinding3.imageAuto.getBackground();
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        ((AnimationDrawable) background).start();
        FragmentAddDeviceAutoStepTwoIcpBinding fragmentAddDeviceAutoStepTwoIcpBinding4 = this.binding;
        if (fragmentAddDeviceAutoStepTwoIcpBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentAddDeviceAutoStepTwoIcpBinding2 = fragmentAddDeviceAutoStepTwoIcpBinding4;
        }
        fragmentAddDeviceAutoStepTwoIcpBinding2.buttonNext.setOnClickListener(new IcpPairDeviceFragment$$ExternalSyntheticLambda7(this));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(IcpPairDeviceFragment icpPairDeviceFragment, View view) {
        FragmentAddDeviceAutoStepTwoIcpBinding fragmentAddDeviceAutoStepTwoIcpBinding = null;
        showWhiteProgressIndicator$default(icpPairDeviceFragment, false, 1, (Object) null);
        FragmentAddDeviceAutoStepTwoIcpBinding fragmentAddDeviceAutoStepTwoIcpBinding2 = icpPairDeviceFragment.binding;
        if (fragmentAddDeviceAutoStepTwoIcpBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentAddDeviceAutoStepTwoIcpBinding = fragmentAddDeviceAutoStepTwoIcpBinding2;
        }
        fragmentAddDeviceAutoStepTwoIcpBinding.buttonNext.setEnabled(false);
        icpPairDeviceFragment.scanAndPair();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.icpDeviceManager = new IcpDeviceManager(getBlueAirManager());
    }

    public void onResume() {
        super.onResume();
        IcpDeviceManager icpDeviceManager2 = this.icpDeviceManager;
        IcpDeviceManager icpDeviceManager3 = null;
        if (icpDeviceManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icpDeviceManager");
            icpDeviceManager2 = null;
        }
        Disposable subscribe = icpDeviceManager2.getConnectionStateObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(new IcpPairDeviceFragment$$ExternalSyntheticLambda9(new IcpPairDeviceFragment$$ExternalSyntheticLambda8(this)));
        IcpDeviceManager icpDeviceManager4 = this.icpDeviceManager;
        if (icpDeviceManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icpDeviceManager");
            icpDeviceManager4 = null;
        }
        Disposable subscribe2 = icpDeviceManager4.getDeviceInfoObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(new IcpPairDeviceFragment$$ExternalSyntheticLambda11(new IcpPairDeviceFragment$$ExternalSyntheticLambda10(this)), new IcpPairDeviceFragment$$ExternalSyntheticLambda1(new IcpPairDeviceFragment$$ExternalSyntheticLambda12()));
        IcpDeviceManager icpDeviceManager5 = this.icpDeviceManager;
        if (icpDeviceManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icpDeviceManager");
        } else {
            icpDeviceManager3 = icpDeviceManager5;
        }
        getAsyncSubs().addAll(subscribe, subscribe2, icpDeviceManager3.getBleClientStateObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(new IcpPairDeviceFragment$$ExternalSyntheticLambda3(new IcpPairDeviceFragment$$ExternalSyntheticLambda2(this))));
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$2(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$1(IcpPairDeviceFragment icpPairDeviceFragment, IcpDeviceConnection icpDeviceConnection) {
        Timber.Forest forest = Timber.Forest;
        forest.d("deviceConnection = " + icpDeviceConnection, new Object[0]);
        int i = WhenMappings.$EnumSwitchMapping$0[icpDeviceConnection.getConnectionState().ordinal()];
        if (i == 1) {
            icpPairDeviceFragment.showWhiteProgressIndicator(false);
            icpPairDeviceFragment.reconnectAction.onNext(true);
        } else if (i == 2) {
            showWhiteProgressIndicator$default(icpPairDeviceFragment, false, 1, (Object) null);
        } else if (i != 3) {
            icpPairDeviceFragment.pairingFailed();
        } else {
            icpPairDeviceFragment.showWhiteProgressIndicator(false);
            Timber.Forest.i("Pairing failed: Reason Disconnected", new Object[0]);
            icpPairDeviceFragment.pairingFailed();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$4(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$3(IcpPairDeviceFragment icpPairDeviceFragment, IcpDeviceInfo icpDeviceInfo) {
        Timber.Forest forest = Timber.Forest;
        forest.d("deviceInfoObservable: " + icpDeviceInfo, new Object[0]);
        icpPairDeviceFragment.shouldReconnectOnConnect.set(false);
        icpPairDeviceFragment.showWhiteProgressIndicator(false);
        AddDeviceService addService = icpPairDeviceFragment.getAddService();
        Intrinsics.checkNotNull(icpDeviceInfo);
        addService.icpPairingCompleted(icpDeviceInfo);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$6(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$5(Throwable th) {
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$8(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$7(IcpPairDeviceFragment icpPairDeviceFragment, IcpDeviceManager.BluetoothClientState bluetoothClientState) {
        FragmentAddDeviceAutoStepTwoIcpBinding fragmentAddDeviceAutoStepTwoIcpBinding = icpPairDeviceFragment.binding;
        if (fragmentAddDeviceAutoStepTwoIcpBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAddDeviceAutoStepTwoIcpBinding = null;
        }
        fragmentAddDeviceAutoStepTwoIcpBinding.buttonNext.setEnabled(bluetoothClientState == IcpDeviceManager.BluetoothClientState.READY);
        return Unit.INSTANCE;
    }

    private final void scanAndPair() {
        IcpDeviceManager icpDeviceManager2 = this.icpDeviceManager;
        if (icpDeviceManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icpDeviceManager");
            icpDeviceManager2 = null;
        }
        Disposable subscribe = icpDeviceManager2.pair().subscribeOn(AndroidSchedulers.mainThread()).subscribe(new IcpPairDeviceFragment$$ExternalSyntheticLambda4(new IcpPairDeviceFragment$$ExternalSyntheticLambda0(this)), new IcpPairDeviceFragment$$ExternalSyntheticLambda6(new IcpPairDeviceFragment$$ExternalSyntheticLambda5(this)));
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        DisposableKt.addTo(subscribe, getAsyncSubs());
    }

    /* access modifiers changed from: private */
    public static final void scanAndPair$lambda$10(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit scanAndPair$lambda$9(IcpPairDeviceFragment icpPairDeviceFragment, IcpDevice icpDevice) {
        Timber.Forest forest = Timber.Forest;
        forest.d("Pairing initiated with icp device: " + icpDevice, new Object[0]);
        if (icpDevice == null) {
            Timber.Forest.i("Pairing failed: Reason: No icp device found nearby", new Object[0]);
            icpPairDeviceFragment.pairingFailed();
        } else {
            Timber.Forest forest2 = Timber.Forest;
            forest2.d("Device Paired: " + icpDevice.getName() + "; " + icpDevice.getMacAddress() + ", " + icpDevice.getUuid(), new Object[0]);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void scanAndPair$lambda$13(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit scanAndPair$lambda$12(IcpPairDeviceFragment icpPairDeviceFragment, Throwable th) {
        Timber.Forest forest = Timber.Forest;
        forest.e("Pairing failed, Reason: Scan error: " + th, new Object[0]);
        icpPairDeviceFragment.pairingFailed();
        FragmentTransaction beginTransaction = icpPairDeviceFragment.getParentFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        Fragment findFragmentByTag = icpPairDeviceFragment.getParentFragmentManager().findFragmentByTag("dialog");
        if (findFragmentByTag != null) {
            beginTransaction.remove(findFragmentByTag);
        }
        beginTransaction.addToBackStack((String) null);
        CannotFindIcpDialog.Companion.newInstance().show(beginTransaction, "dialog");
        return Unit.INSTANCE;
    }

    private final void pairingFailed() {
        Timber.Forest.w("Pairing failed...", new Object[0]);
        showWhiteProgressIndicator(false);
        FragmentAddDeviceAutoStepTwoIcpBinding fragmentAddDeviceAutoStepTwoIcpBinding = this.binding;
        if (fragmentAddDeviceAutoStepTwoIcpBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAddDeviceAutoStepTwoIcpBinding = null;
        }
        fragmentAddDeviceAutoStepTwoIcpBinding.buttonNext.setEnabled(true);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/IcpPairDeviceFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/IcpPairDeviceFragment;", "deviceModelType", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IcpPairDeviceFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IcpPairDeviceFragment newInstance(int i) {
            IcpPairDeviceFragment icpPairDeviceFragment = new IcpPairDeviceFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AddDeviceBaseFragment.ARG_DEVICE_MODEL_TYPE, i);
            icpPairDeviceFragment.setArguments(bundle);
            return icpPairDeviceFragment;
        }
    }
}
