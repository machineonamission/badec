package com.blueair.adddevice.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.adddevice.activity.AddDeviceActivityLegacy;
import com.blueair.adddevice.adapter.ScannedDevicesAdapter;
import com.blueair.adddevice.databinding.FragmentBluetoothScanResultBinding;
import com.blueair.adddevice.dialog.ConnectInstructionsDialog;
import com.blueair.adddevice.model.BluetoothConnectingInfo;
import com.blueair.adddevice.model.BluetoothConnectingState;
import com.blueair.adddevice.utils.AddDeviceUtils;
import com.blueair.adddevice.viewholder.BluetoothEnableHolder;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.auth.LocationService;
import com.blueair.bluetooth.service.BleDeviceError;
import com.blueair.bluetooth.service.BleDeviceState;
import com.blueair.bluetooth.utils.BluetoothUtils;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.Device;
import com.blueair.core.util.LocationPermissionTracker;
import com.blueair.core.util.LocationUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.TroubleshootingDialog;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.fragment.BaseFragmentInterface;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J$\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u001a\u0010L\u001a\u00020\u001a2\u0006\u0010M\u001a\u00020E2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010N\u001a\u00020\u001aH\u0016J\u0010\u0010O\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020&H\u0002J\u0018\u0010Q\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020&2\u0006\u0010R\u001a\u00020SH\u0002J\b\u0010T\u001a\u00020\u001aH\u0016J\b\u0010U\u001a\u00020\u001aH\u0016J\b\u0010V\u001a\u00020\u001aH\u0002J\b\u0010W\u001a\u00020\u001aH\u0002J\b\u0010X\u001a\u00020\u001aH\u0002J\u0010\u0010Y\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020&H\u0002J\u0012\u0010Z\u001a\u00020\u001a2\b\b\u0002\u0010[\u001a\u00020\u001cH\u0002J\u0016\u0010\\\u001a\u00020\u001a2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020&0^H\u0002J\b\u0010_\u001a\u00020\u001aH\u0002J\b\u0010`\u001a\u00020\u001aH\u0002J\b\u0010a\u001a\u00020\u001aH\u0003J-\u0010b\u001a\u00020\u001a2\u0006\u0010c\u001a\u00020S2\u000e\u0010d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0A2\u0006\u0010e\u001a\u00020fH\u0017¢\u0006\u0002\u0010gR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u0012\u001a\u0004\b!\u0010\"R!\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%8BX\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R!\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0%8BX\u0002¢\u0006\f\n\u0004\b-\u0010*\u001a\u0004\b,\u0010(R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u001b\u00105\u001a\u0002068BX\u0002¢\u0006\f\n\u0004\b9\u0010\u0012\u001a\u0004\b7\u00108R\u001b\u0010:\u001a\u00020;8BX\u0002¢\u0006\f\n\u0004\b>\u0010\u0012\u001a\u0004\b<\u0010=R(\u0010?\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b B*\n\u0012\u0004\u0012\u00020\b\u0018\u00010A0A0@X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010h\u001a\u00020iX\u0005¢\u0006\u0006\u001a\u0004\bj\u0010kR\u0018\u0010l\u001a\u00020\u0002X\u000f¢\u0006\f\u001a\u0004\bm\u0010n\"\u0004\bo\u0010p¨\u0006q"}, d2 = {"Lcom/blueair/adddevice/fragment/BluetoothScanResultFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "Lcom/blueair/viewcore/fragment/BaseFragmentInterface;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/adddevice/databinding/FragmentBluetoothScanResultBinding;", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "Lkotlin/Lazy;", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "showProgress", "", "shouldShowProgress", "", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "locationPermissionTracker", "Lcom/blueair/core/util/LocationPermissionTracker;", "getLocationPermissionTracker", "()Lcom/blueair/core/util/LocationPermissionTracker;", "locationPermissionTracker$delegate", "deviceSelectPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/core/model/BluetoothDevice;", "getDeviceSelectPublisher", "()Lio/reactivex/subjects/PublishSubject;", "deviceSelectPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "legacySelectPublisher", "getLegacySelectPublisher", "legacySelectPublisher$delegate", "deviceSelectedStateListening", "Lio/reactivex/disposables/Disposable;", "pendingConnectableDevice", "connectInstructionsDialog", "Lcom/blueair/adddevice/dialog/ConnectInstructionsDialog;", "connectJob", "Lkotlinx/coroutines/Job;", "adapter", "Lcom/blueair/adddevice/adapter/ScannedDevicesAdapter;", "getAdapter", "()Lcom/blueair/adddevice/adapter/ScannedDevicesAdapter;", "adapter$delegate", "bluetoothEnableHolder", "Lcom/blueair/adddevice/viewholder/BluetoothEnableHolder;", "getBluetoothEnableHolder", "()Lcom/blueair/adddevice/viewholder/BluetoothEnableHolder;", "bluetoothEnableHolder$delegate", "requestBluetoothPermissionsLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "deviceDetectJob", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "startConnectBleDevice", "device", "connectBleDevice", "attempt", "", "onPause", "onDestroy", "reset", "deselectDevice", "onSelectionLost", "showBluetoothTroubleshooting", "handleInitialState", "hasBluetoothEnabled", "showScanningResults", "devices", "", "checkHideScanningFragment", "checkTitleVisible", "showEnableLocationBluetooth", "onRequestPermissionsResult", "requestCode", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "viewModel", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "setViewModel", "(Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;)V", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BluetoothScanResultFragment.kt */
public final class BluetoothScanResultFragment extends BaseFragment<AddDeviceViewModel> implements ProgressFragment, BaseFragmentInterface<AddDeviceViewModel> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final /* synthetic */ AddDeviceFragment $$delegate_0 = new AddDeviceFragment();
    private final Lazy adapter$delegate;
    private FragmentBluetoothScanResultBinding binding;
    private final Lazy bluetoothEnableHolder$delegate;
    /* access modifiers changed from: private */
    public ConnectInstructionsDialog connectInstructionsDialog;
    private Job connectJob;
    private Job deviceDetectJob;
    private final LazyPublishSubject deviceSelectPublisher$delegate;
    private Disposable deviceSelectedStateListening;
    private final LazyPublishSubject legacySelectPublisher$delegate;
    private final Lazy locationPermissionTracker$delegate;
    private final Lazy locationService$delegate;
    /* access modifiers changed from: private */
    public BluetoothDevice pendingConnectableDevice;
    private ProgressBlockerView progressBlockerView;
    private final ActivityResultLauncher<String[]> requestBluetoothPermissionsLauncher;
    private final String screenName = AnalyticEvent.ScreenViewEvent.ADD_DEVICE_SCAN;

    static {
        Class<BluetoothScanResultFragment> cls = BluetoothScanResultFragment.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "locationPermissionTracker", "getLocationPermissionTracker()Lcom/blueair/core/util/LocationPermissionTracker;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "deviceSelectPublisher", "getDeviceSelectPublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "legacySelectPublisher", "getLegacySelectPublisher()Lio/reactivex/subjects/PublishSubject;", 0))};
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$19$lambda$16(DialogInterface dialogInterface, int i) {
    }

    public CompositeDisposable getRxSubs() {
        return this.$$delegate_0.getRxSubs();
    }

    public AddDeviceViewModel getViewModel() {
        return this.$$delegate_0.getViewModel();
    }

    public void setViewModel(AddDeviceViewModel addDeviceViewModel) {
        Intrinsics.checkNotNullParameter(addDeviceViewModel, "<set-?>");
        this.$$delegate_0.setViewModel(addDeviceViewModel);
    }

    public BluetoothScanResultFragment() {
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new BluetoothScanResultFragment$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, LocationService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.locationService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new BluetoothScanResultFragment$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationPermissionTracker$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, LocationPermissionTracker.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        this.deviceSelectPublisher$delegate = new LazyPublishSubject();
        this.legacySelectPublisher$delegate = new LazyPublishSubject();
        this.adapter$delegate = LazyKt.lazy(new BluetoothScanResultFragment$$ExternalSyntheticLambda4(this));
        this.bluetoothEnableHolder$delegate = LazyKt.lazy(new BluetoothScanResultFragment$$ExternalSyntheticLambda5(this));
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new BluetoothScanResultFragment$$ExternalSyntheticLambda6(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.requestBluetoothPermissionsLauncher = registerForActivityResult;
    }

    public void clearProgressFragment() {
        ProgressFragment.CC.$default$clearProgressFragment(this);
    }

    public void hideProgress(Context context) {
        ProgressFragment.CC.$default$hideProgress(this, context);
    }

    public void showProgress(Context context, boolean z, Integer num) {
        ProgressFragment.CC.$default$showProgress(this, context, z, num);
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    private final LocationService getLocationService() {
        return (LocationService) this.locationService$delegate.getValue();
    }

    public ProgressBlockerView getProgressBlockerView() {
        return this.progressBlockerView;
    }

    public void setProgressBlockerView(ProgressBlockerView progressBlockerView2) {
        this.progressBlockerView = progressBlockerView2;
    }

    public void showProgress(boolean z) {
        ProgressFragment.CC.showProgress$default(this, getContext(), z, (Integer) null, 4, (Object) null);
    }

    public ConstraintLayout getRootView() {
        FragmentBluetoothScanResultBinding fragmentBluetoothScanResultBinding = this.binding;
        if (fragmentBluetoothScanResultBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBluetoothScanResultBinding = null;
        }
        ConstraintLayout constraintLayout = fragmentBluetoothScanResultBinding.rootLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "rootLayout");
        return constraintLayout;
    }

    private final LocationPermissionTracker getLocationPermissionTracker() {
        return (LocationPermissionTracker) this.locationPermissionTracker$delegate.getValue();
    }

    private final PublishSubject<BluetoothDevice> getDeviceSelectPublisher() {
        return this.deviceSelectPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[2]);
    }

    private final PublishSubject<Boolean> getLegacySelectPublisher() {
        return this.legacySelectPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[3]);
    }

    /* access modifiers changed from: private */
    public final ScannedDevicesAdapter getAdapter() {
        return (ScannedDevicesAdapter) this.adapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final ScannedDevicesAdapter adapter_delegate$lambda$0(BluetoothScanResultFragment bluetoothScanResultFragment) {
        return new ScannedDevicesAdapter(bluetoothScanResultFragment.getDeviceSelectPublisher(), bluetoothScanResultFragment.getLegacySelectPublisher(), bluetoothScanResultFragment.getLocationService());
    }

    private final BluetoothEnableHolder getBluetoothEnableHolder() {
        return (BluetoothEnableHolder) this.bluetoothEnableHolder$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final BluetoothEnableHolder bluetoothEnableHolder_delegate$lambda$1(BluetoothScanResultFragment bluetoothScanResultFragment) {
        BluetoothEnableHolder.Companion companion = BluetoothEnableHolder.Companion;
        FragmentBluetoothScanResultBinding fragmentBluetoothScanResultBinding = bluetoothScanResultFragment.binding;
        if (fragmentBluetoothScanResultBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBluetoothScanResultBinding = null;
        }
        FrameLayout frameLayout = fragmentBluetoothScanResultBinding.scanningFragment;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "scanningFragment");
        return companion.newInstance(frameLayout);
    }

    /* access modifiers changed from: private */
    public static final void requestBluetoothPermissionsLauncher$lambda$5(BluetoothScanResultFragment bluetoothScanResultFragment, Map map) {
        boolean z;
        Object obj;
        Iterable values = map.values();
        if (!(values instanceof Collection) || !((Collection) values).isEmpty()) {
            Iterator it = values.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!((Boolean) it.next()).booleanValue()) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = true;
        Unit unit = null;
        if (BluetoothUtils.INSTANCE.shouldShowBluetoothRequestPermissionDialog(bluetoothScanResultFragment) || z) {
            handleInitialState$default(bluetoothScanResultFragment, false, 1, (Object) null);
            return;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        StringBuilder sb = new StringBuilder("package:");
        Context context = bluetoothScanResultFragment.getContext();
        sb.append(context != null ? context.getPackageName() : null);
        intent.setData(Uri.parse(sb.toString()));
        try {
            Result.Companion companion = Result.Companion;
            Context context2 = bluetoothScanResultFragment.getContext();
            if (context2 != null) {
                context2.startActivity(intent);
                unit = Unit.INSTANCE;
            }
            obj = Result.m9366constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m9366constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9369exceptionOrNullimpl(obj) != null) {
            ViewUtils viewUtils = ViewUtils.INSTANCE;
            FragmentActivity requireActivity = bluetoothScanResultFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            viewUtils.showSnackbar((Activity) requireActivity, R.string.bluetooth_permission_12, (ViewUtils.MessageType) ViewUtils.MessageType.INFO.INSTANCE);
        }
        Result.m9365boximpl(obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Timber.Forest.d("onCreateView", new Object[0]);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        setViewModel((AddDeviceViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(AddDeviceViewModel.class)));
        FragmentBluetoothScanResultBinding inflate = FragmentBluetoothScanResultBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        FragmentBluetoothScanResultBinding fragmentBluetoothScanResultBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        inflate.listview.setAdapter(getAdapter());
        FragmentBluetoothScanResultBinding fragmentBluetoothScanResultBinding2 = this.binding;
        if (fragmentBluetoothScanResultBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBluetoothScanResultBinding2 = null;
        }
        fragmentBluetoothScanResultBinding2.btnHelp.setOnClickListener(new BluetoothScanResultFragment$$ExternalSyntheticLambda1(this));
        FragmentBluetoothScanResultBinding fragmentBluetoothScanResultBinding3 = this.binding;
        if (fragmentBluetoothScanResultBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBluetoothScanResultBinding3 = null;
        }
        setProgressBlockerView(fragmentBluetoothScanResultBinding3.progressView);
        FragmentBluetoothScanResultBinding fragmentBluetoothScanResultBinding4 = this.binding;
        if (fragmentBluetoothScanResultBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBluetoothScanResultBinding = fragmentBluetoothScanResultBinding4;
        }
        ConstraintLayout root = fragmentBluetoothScanResultBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$8(BluetoothScanResultFragment bluetoothScanResultFragment, View view) {
        FragmentManager childFragmentManager = bluetoothScanResultFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<TroubleshootingDialog> cls = TroubleshootingDialog.class;
        Intrinsics.checkNotNullExpressionValue(TroubleshootingDialog.REQUEST_KEY, "getSimpleName(...)");
        DialogFragment dialogFragment = null;
        if (!(childFragmentManager.findFragmentByTag(TroubleshootingDialog.REQUEST_KEY) instanceof TroubleshootingDialog) && !childFragmentManager.isStateSaved()) {
            dialogFragment = TroubleshootingDialog.Companion.newInstance$default(TroubleshootingDialog.Companion, TroubleshootingDialog.ACTION_TYPE_BLUETOOTH_CANT_SEE, (Device) null, 2, (Object) null);
            dialogFragment.show(childFragmentManager, TroubleshootingDialog.REQUEST_KEY);
        }
        TroubleshootingDialog troubleshootingDialog = (TroubleshootingDialog) dialogFragment;
        if (troubleshootingDialog != null) {
            FragmentExtensionsKt.setFragmentResultListenerWithClear(troubleshootingDialog, TroubleshootingDialog.REQUEST_KEY, new BluetoothScanResultFragment$$ExternalSyntheticLambda0(bluetoothScanResultFragment));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$8$lambda$7(BluetoothScanResultFragment bluetoothScanResultFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.getBoolean(TroubleshootingDialog.ACTION_RETRY)) {
            FragmentBluetoothScanResultBinding fragmentBluetoothScanResultBinding = bluetoothScanResultFragment.binding;
            if (fragmentBluetoothScanResultBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentBluetoothScanResultBinding = null;
            }
            fragmentBluetoothScanResultBinding.scanningFragment.setVisibility(0);
            bluetoothScanResultFragment.getViewModel().resetScanResult();
        }
        return Unit.INSTANCE;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        Timber.Forest.d("onViewCreated", new Object[0]);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new BluetoothScanResultFragment$onViewCreated$1(this, (Continuation<? super BluetoothScanResultFragment$onViewCreated$1>) null), 3, (Object) null);
    }

    public void onResume() {
        super.onResume();
        Timber.Forest.d("onResume", new Object[0]);
        reset();
        getRxSubs().add(RxExtensionsKt.uiThread(getViewModel().getBluetoothConnectionStateObserver()).subscribe(new BluetoothScanResultFragment$$ExternalSyntheticLambda14(new BluetoothScanResultFragment$$ExternalSyntheticLambda11(this)), new BluetoothScanResultFragment$$ExternalSyntheticLambda16(new BluetoothScanResultFragment$$ExternalSyntheticLambda15())));
        CompositeDisposable rxSubs = getRxSubs();
        Observable filter = RxExtensionsKt.uiThread(getDeviceSelectPublisher()).throttleFirst(500, TimeUnit.MILLISECONDS).filter(new BluetoothScanResultFragment$$ExternalSyntheticLambda18(new BluetoothScanResultFragment$$ExternalSyntheticLambda17(this)));
        Intrinsics.checkNotNullExpressionValue(filter, "filter(...)");
        rxSubs.add(RxExtensionsKt.subscribeAndLogE(filter, new BluetoothScanResultFragment$$ExternalSyntheticLambda19(this)));
        CompositeDisposable rxSubs2 = getRxSubs();
        Observable filterRapidClicks = RxExtensionsKt.filterRapidClicks(getLegacySelectPublisher());
        Intrinsics.checkNotNullExpressionValue(filterRapidClicks, "filterRapidClicks(...)");
        rxSubs2.add(RxExtensionsKt.subscribeAndLogE(filterRapidClicks, new BluetoothScanResultFragment$$ExternalSyntheticLambda20(this)));
        handleInitialState$default(this, false, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$10(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$9(BluetoothScanResultFragment bluetoothScanResultFragment, Boolean bool) {
        Timber.Forest forest = Timber.Forest;
        forest.d("connectionChangedObserver: hasBluetooth = " + bool + ", hasSelectedBleDevice = " + bluetoothScanResultFragment.getViewModel().getHasSelectedBleDevice(), new Object[0]);
        if (!bool.booleanValue()) {
            if (bluetoothScanResultFragment.getViewModel().getHasSelectedBleDevice()) {
                bluetoothScanResultFragment.onSelectionLost();
            }
            bluetoothScanResultFragment.getViewModel().stopBluetoothScanning();
        }
        Intrinsics.checkNotNull(bool);
        bluetoothScanResultFragment.handleInitialState(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$12(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$11(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "t");
        Timber.Forest.e(th, "Connection Change Observer failed", new Object[0]);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final boolean onResume$lambda$14(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean onResume$lambda$13(BluetoothScanResultFragment bluetoothScanResultFragment, BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, "it");
        return bluetoothScanResultFragment.getAdapter().getConnectingInfo() == null;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$19(BluetoothScanResultFragment bluetoothScanResultFragment, BluetoothDevice bluetoothDevice) {
        BluetoothScanResultFragment bluetoothScanResultFragment2 = bluetoothScanResultFragment;
        BluetoothDevice bluetoothDevice2 = bluetoothDevice;
        Timber.Forest forest = Timber.Forest;
        forest.d("deviceSelectPublisher: device = " + bluetoothDevice2, new Object[0]);
        bluetoothScanResultFragment2.getViewModel().postAnalyticsEvent(new AnalyticEvent.BT_PRODUCT_SELECTED(bluetoothDevice2.getMac()));
        if (bluetoothDevice2.isUnknownSku()) {
            new AlertDialog.Builder(bluetoothScanResultFragment2.requireContext()).setTitle(R.string.update_the_app_title).setMessage(R.string.go_to_market_and_update_app).setPositiveButton(R.string.snackbar_ok, new BluetoothScanResultFragment$$ExternalSyntheticLambda10(bluetoothScanResultFragment2)).setNegativeButton(R.string.later, new BluetoothScanResultFragment$$ExternalSyntheticLambda12()).show();
        } else if (!Intrinsics.areEqual((Object) bluetoothDevice2.isOnline(), (Object) true)) {
            if (Intrinsics.areEqual((Object) bluetoothDevice2.isOnline(), (Object) false)) {
                FragmentManager childFragmentManager = bluetoothScanResultFragment2.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
                Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
                if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
                    ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.label_reconnect_your_device, (Integer) null, R.string.reconnect_device_msg, Integer.valueOf(R.string.confirmation_positive_default), Integer.valueOf(R.string.btn_cancel), false, false, false, false, (String[]) null, (String) null, new BluetoothScanResultFragment$$ExternalSyntheticLambda13(bluetoothScanResultFragment2, bluetoothDevice2), 1888, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
                }
            } else {
                Intrinsics.checkNotNull(bluetoothDevice2);
                bluetoothScanResultFragment.startConnectBleDevice(bluetoothDevice);
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$19$lambda$15(BluetoothScanResultFragment bluetoothScanResultFragment, DialogInterface dialogInterface, int i) {
        bluetoothScanResultFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(bluetoothScanResultFragment.getLocationService().getMarketLink())));
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$19$lambda$18$lambda$17(BluetoothScanResultFragment bluetoothScanResultFragment, BluetoothDevice bluetoothDevice, boolean z) {
        if (z) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(bluetoothScanResultFragment, (CoroutineContext) null, (CoroutineStart) null, new BluetoothScanResultFragment$onResume$4$3$1$1(bluetoothScanResultFragment, bluetoothDevice, (Continuation<? super BluetoothScanResultFragment$onResume$4$3$1$1>) null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$21(BluetoothScanResultFragment bluetoothScanResultFragment, Boolean bool) {
        Context context;
        if (bluetoothScanResultFragment.isAdded() && (context = bluetoothScanResultFragment.getContext()) != null) {
            context.startActivity(new Intent(context, AddDeviceActivityLegacy.class));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void startConnectBleDevice(BluetoothDevice bluetoothDevice) {
        DialogFragment dialogFragment;
        getViewModel().logStep0SelectDevice(bluetoothDevice);
        boolean z = true;
        if (!bluetoothDevice.getAutoButtonPressNeeded()) {
            getViewModel().logStep1ConnectionInstructions(bluetoothDevice, AnalyticEvent.OnboardingLogEvent.TYPE_NULL);
            connectBleDevice(bluetoothDevice, 1);
        } else if (bluetoothDevice.getConnectable()) {
            getViewModel().logStep1ConnectionInstructions(bluetoothDevice, AnalyticEvent.OnboardingLogEvent.CONNECT_TYPE_DETECT);
            connectBleDevice(bluetoothDevice, 1);
        } else {
            z = false;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<ConnectInstructionsDialog> cls = ConnectInstructionsDialog.class;
        Intrinsics.checkNotNullExpressionValue(ConnectInstructionsDialog.REQUEST_KEY, "getSimpleName(...)");
        if ((childFragmentManager.findFragmentByTag(ConnectInstructionsDialog.REQUEST_KEY) instanceof ConnectInstructionsDialog) || childFragmentManager.isStateSaved()) {
            dialogFragment = null;
        } else {
            ConnectInstructionsDialog newInstance = ConnectInstructionsDialog.Companion.newInstance(bluetoothDevice.getFamilyName(), bluetoothDevice.getHasNoAutoButton() ? ConnectInstructionsDialog.ACTION_FAN_SPEED : ConnectInstructionsDialog.ACTION_AUTO, bluetoothDevice, z);
            newInstance.setOnCountdown(new BluetoothScanResultFragment$$ExternalSyntheticLambda2(this, newInstance, bluetoothDevice));
            dialogFragment = newInstance;
            dialogFragment.show(childFragmentManager, ConnectInstructionsDialog.REQUEST_KEY);
        }
        ConnectInstructionsDialog connectInstructionsDialog2 = (ConnectInstructionsDialog) dialogFragment;
        if (connectInstructionsDialog2 != null) {
            this.pendingConnectableDevice = bluetoothDevice;
            this.connectInstructionsDialog = connectInstructionsDialog2;
            FragmentExtensionsKt.setFragmentResultListenerWithClear(connectInstructionsDialog2, ConnectInstructionsDialog.REQUEST_KEY, new BluetoothScanResultFragment$$ExternalSyntheticLambda3(this));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit startConnectBleDevice$lambda$25$lambda$24$lambda$23(BluetoothScanResultFragment bluetoothScanResultFragment, ConnectInstructionsDialog connectInstructionsDialog2, BluetoothDevice bluetoothDevice) {
        BluetoothDevice bluetoothDevice2 = bluetoothScanResultFragment.pendingConnectableDevice;
        if (bluetoothDevice2 != null) {
            connectInstructionsDialog2.getViewModel().logStep1ConnectionInstructions(bluetoothDevice, AnalyticEvent.OnboardingLogEvent.CONNECT_TYPE_FORCE);
            bluetoothScanResultFragment.connectBleDevice(bluetoothDevice2, 1);
            connectInstructionsDialog2.switchConnecting();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit startConnectBleDevice$lambda$27$lambda$26(BluetoothScanResultFragment bluetoothScanResultFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "<unused var>");
        bluetoothScanResultFragment.pendingConnectableDevice = null;
        bluetoothScanResultFragment.connectInstructionsDialog = null;
        Job job = bluetoothScanResultFragment.connectJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        bluetoothScanResultFragment.connectJob = null;
        if (!Intrinsics.areEqual((Object) bluetoothScanResultFragment.getViewModel().isSelectedBleDeviceConnected(), (Object) true)) {
            bluetoothScanResultFragment.deselectDevice();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void connectBleDevice(BluetoothDevice bluetoothDevice, int i) {
        Observable<BleDeviceState> selectBluetoothDevice = getViewModel().selectBluetoothDevice(bluetoothDevice, true);
        Timber.Forest forest = Timber.Forest;
        forest.d("connectBleDevice: device = " + bluetoothDevice + ", attempt = " + i + ", result = " + selectBluetoothDevice + ", hasSelectedBleDevice = " + getViewModel().getHasSelectedBleDevice(), new Object[0]);
        if (i >= 2 && selectBluetoothDevice != null) {
            Disposable subscribeAndLogE = RxExtensionsKt.subscribeAndLogE(RxExtensionsKt.uiThread(selectBluetoothDevice), new BluetoothScanResultFragment$$ExternalSyntheticLambda7(this));
            getRxSubs().add(subscribeAndLogE);
            this.deviceSelectedStateListening = subscribeAndLogE;
        }
        ConnectInstructionsDialog connectInstructionsDialog2 = this.connectInstructionsDialog;
        if (connectInstructionsDialog2 != null && connectInstructionsDialog2.isVisible()) {
            getAdapter().setConnectingInfo(new BluetoothConnectingInfo(bluetoothDevice.getMac(), BluetoothConnectingState.Connecting.INSTANCE));
        }
        this.connectJob = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain(), (CoroutineStart) null, new BluetoothScanResultFragment$connectBleDevice$2(this, bluetoothDevice, i, (Continuation<? super BluetoothScanResultFragment$connectBleDevice$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Unit connectBleDevice$lambda$30$lambda$29(BluetoothScanResultFragment bluetoothScanResultFragment, BleDeviceState bleDeviceState) {
        Intrinsics.checkNotNullParameter(bleDeviceState, "it");
        Timber.Forest forest = Timber.Forest;
        forest.d("deviceSelectPublisher: state = " + bleDeviceState, new Object[0]);
        if (Intrinsics.areEqual((Object) bleDeviceState, (Object) BleDeviceState.Disconnected.INSTANCE)) {
            bluetoothScanResultFragment.onSelectionLost();
            Disposable disposable = bluetoothScanResultFragment.deviceSelectedStateListening;
            if (disposable != null) {
                bluetoothScanResultFragment.getRxSubs().remove(disposable);
                disposable.dispose();
                bluetoothScanResultFragment.deviceSelectedStateListening = null;
            }
        }
        return Unit.INSTANCE;
    }

    public void onPause() {
        getViewModel().stopBluetoothScanning();
        this.deviceSelectedStateListening = null;
        super.onPause();
    }

    public void onDestroy() {
        clearProgressFragment();
        super.onDestroy();
    }

    private final void reset() {
        deselectDevice();
        getViewModel().reset();
        Job job = this.deviceDetectJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    private final void deselectDevice() {
        String str;
        if (getViewModel().getHasSelectedBleDevice()) {
            AddDeviceViewModel viewModel = getViewModel();
            BleDeviceError selectedBleDeviceError = getViewModel().getSelectedBleDeviceError();
            if (selectedBleDeviceError == null || (str = selectedBleDeviceError.getMessage()) == null) {
                str = "";
            }
            viewModel.postAnalyticsEvent(new AnalyticEvent.BT_PRODUCT_SELECTED_ERROR(str));
        }
        getAdapter().setConnectingInfo((BluetoothConnectingInfo) null);
        getViewModel().deselectBluetoothDevice();
        Disposable disposable = this.deviceSelectedStateListening;
        if (disposable != null) {
            getRxSubs().remove(disposable);
        }
        this.deviceSelectedStateListening = null;
    }

    /* access modifiers changed from: private */
    public final void onSelectionLost() {
        BluetoothDevice selectedUiDevice = getViewModel().getSelectedUiDevice();
        if (selectedUiDevice != null) {
            Timber.Forest forest = Timber.Forest;
            forest.d("onSelectionLost: " + selectedUiDevice, new Object[0]);
            deselectDevice();
            try {
                Timber.Forest.d("show connection lost dialog", new Object[0]);
                FragmentManager childFragmentManager = getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                if (!(childFragmentManager.findFragmentByTag("TroubleConnectingBluetooth") instanceof ConfirmationDialogLeftAligned)) {
                    FragmentManager childFragmentManager2 = getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
                    if (!(childFragmentManager2.findFragmentByTag("TroubleConnectingBluetooth") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager2.isStateSaved()) {
                        ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.label_trouble_connecting_bluetooth, (Integer) null, R.string.hint_trouble_connecting_bluetooth, Integer.valueOf(R.string.connection_to_purifier_try_again), Integer.valueOf(R.string.action_read_tips), false, false, false, false, (String[]) null, (String) null, new BluetoothScanResultFragment$$ExternalSyntheticLambda9(this, selectedUiDevice), 1888, (Object) null).show(childFragmentManager2, "TroubleConnectingBluetooth");
                    }
                }
            } catch (Throwable th) {
                Timber.Forest.e(th, "failed to show connection lost dialog", new Object[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onSelectionLost$lambda$33$lambda$32(BluetoothScanResultFragment bluetoothScanResultFragment, BluetoothDevice bluetoothDevice, boolean z) {
        ConnectInstructionsDialog connectInstructionsDialog2 = bluetoothScanResultFragment.connectInstructionsDialog;
        if (connectInstructionsDialog2 != null) {
            connectInstructionsDialog2.dismissAllowingStateLoss();
        }
        if (z) {
            bluetoothScanResultFragment.getViewModel().restart();
        } else {
            bluetoothScanResultFragment.showBluetoothTroubleshooting(bluetoothDevice);
        }
        return Unit.INSTANCE;
    }

    private final void showBluetoothTroubleshooting(BluetoothDevice bluetoothDevice) {
        DialogFragment dialogFragment;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<TroubleshootingDialog> cls = TroubleshootingDialog.class;
        Intrinsics.checkNotNullExpressionValue(TroubleshootingDialog.REQUEST_KEY, "getSimpleName(...)");
        if ((childFragmentManager.findFragmentByTag(TroubleshootingDialog.REQUEST_KEY) instanceof TroubleshootingDialog) || childFragmentManager.isStateSaved()) {
            dialogFragment = null;
        } else {
            dialogFragment = TroubleshootingDialog.Companion.newInstanceForBluetooth(bluetoothDevice);
            dialogFragment.show(childFragmentManager, TroubleshootingDialog.REQUEST_KEY);
            childFragmentManager.executePendingTransactions();
        }
        TroubleshootingDialog troubleshootingDialog = (TroubleshootingDialog) dialogFragment;
        if (troubleshootingDialog != null) {
            FragmentExtensionsKt.setFragmentResultListenerWithClear(troubleshootingDialog, TroubleshootingDialog.REQUEST_KEY, new BluetoothScanResultFragment$$ExternalSyntheticLambda21(this));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit showBluetoothTroubleshooting$lambda$35(BluetoothScanResultFragment bluetoothScanResultFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.getBoolean(TroubleshootingDialog.ACTION_RETRY)) {
            bluetoothScanResultFragment.reset();
            handleInitialState$default(bluetoothScanResultFragment, false, 1, (Object) null);
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ void handleInitialState$default(BluetoothScanResultFragment bluetoothScanResultFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = bluetoothScanResultFragment.getViewModel().isBluetoothEnabled();
        }
        bluetoothScanResultFragment.handleInitialState(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0065, code lost:
        if (r0.isLocationPermissionGranted(r7) != false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0084, code lost:
        if (r0.isLocationEnabled(r6) != false) goto L_0x0086;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleInitialState(boolean r11) {
        /*
            r10 = this;
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "handleInitialState: hasBluetoothEnabled = "
            r1.<init>(r2)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.d(r1, r3)
            com.blueair.adddevice.databinding.FragmentBluetoothScanResultBinding r0 = r10.binding
            java.lang.String r1 = "binding"
            r3 = 0
            if (r0 != 0) goto L_0x0021
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r3
        L_0x0021:
            android.widget.FrameLayout r0 = r0.scanningFragment
            r0.removeAllViews()
            com.blueair.adddevice.databinding.FragmentBluetoothScanResultBinding r0 = r10.binding
            if (r0 != 0) goto L_0x002e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r3
        L_0x002e:
            android.widget.FrameLayout r0 = r0.scanningFragment
            r0.setVisibility(r2)
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r0 = r10.getViewModel()
            androidx.lifecycle.MutableLiveData r0 = r0.getLvDeviceScanned()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)
            r0.setValue(r4)
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r4 = "btnHelp"
            java.lang.String r5 = "getContext(...)"
            r6 = 31
            if (r0 >= r6) goto L_0x0067
            com.blueair.core.util.LocationUtils r0 = com.blueair.core.util.LocationUtils.INSTANCE
            com.blueair.adddevice.databinding.FragmentBluetoothScanResultBinding r7 = r10.binding
            if (r7 != 0) goto L_0x0056
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r7 = r3
        L_0x0056:
            androidx.constraintlayout.widget.ConstraintLayout r7 = r7.getRoot()
            android.content.Context r7 = r7.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
            boolean r0 = r0.isLocationPermissionGranted(r7)
            if (r0 == 0) goto L_0x0109
        L_0x0067:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 >= r6) goto L_0x0086
            com.blueair.core.util.LocationUtils r0 = com.blueair.core.util.LocationUtils.INSTANCE
            com.blueair.adddevice.databinding.FragmentBluetoothScanResultBinding r6 = r10.binding
            if (r6 != 0) goto L_0x0075
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r6 = r3
        L_0x0075:
            androidx.constraintlayout.widget.ConstraintLayout r6 = r6.getRoot()
            android.content.Context r6 = r6.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
            boolean r0 = r0.isLocationEnabled(r6)
            if (r0 == 0) goto L_0x0109
        L_0x0086:
            com.blueair.bluetooth.utils.BluetoothUtils r0 = com.blueair.bluetooth.utils.BluetoothUtils.INSTANCE
            android.content.Context r5 = r10.requireContext()
            java.lang.String r6 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            boolean r0 = r0.hasBluetoothPermissions(r5)
            if (r0 == 0) goto L_0x0109
            if (r11 != 0) goto L_0x009a
            goto L_0x0109
        L_0x009a:
            timber.log.Timber$Forest r11 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = "startBluetoothScanning: childFragmentManager = "
            r0.<init>(r5)
            androidx.fragment.app.FragmentManager r5 = r10.getChildFragmentManager()
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r11.d(r0, r5)
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r11 = r10.getViewModel()
            r11.startBluetoothScanning()
            com.blueair.adddevice.databinding.FragmentBluetoothScanResultBinding r11 = r10.binding
            if (r11 != 0) goto L_0x00c2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r11 = r3
        L_0x00c2:
            androidx.appcompat.widget.AppCompatTextView r11 = r11.btnHelp
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r4)
            android.view.View r11 = (android.view.View) r11
            r0 = 1
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r11, r2, r0, r3)
            androidx.fragment.app.FragmentManager r11 = r10.getChildFragmentManager()
            java.lang.String r0 = "getChildFragmentManager(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            androidx.fragment.app.FragmentTransaction r11 = r11.beginTransaction()
            java.lang.String r0 = "beginTransaction()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            int r0 = com.blueair.adddevice.R.id.scanning_fragment
            com.blueair.adddevice.fragment.BluetoothScanningFragment$Companion r1 = com.blueair.adddevice.fragment.BluetoothScanningFragment.Companion
            com.blueair.adddevice.fragment.BluetoothScanningFragment r1 = r1.newInstance()
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            r11.replace((int) r0, (androidx.fragment.app.Fragment) r1, (java.lang.String) r3)
            r11.commit()
            kotlinx.coroutines.Job r11 = r10.deviceDetectJob
            if (r11 != 0) goto L_0x0130
            r4 = r10
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            com.blueair.adddevice.fragment.BluetoothScanResultFragment$handleInitialState$2 r11 = new com.blueair.adddevice.fragment.BluetoothScanResultFragment$handleInitialState$2
            r11.<init>(r10, r3)
            r7 = r11
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            kotlinx.coroutines.Job r11 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r4, r5, r6, r7, r8, r9)
            r10.deviceDetectJob = r11
            return
        L_0x0109:
            r10.showEnableLocationBluetooth()
            com.blueair.adddevice.databinding.FragmentBluetoothScanResultBinding r11 = r10.binding
            if (r11 != 0) goto L_0x0114
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x0115
        L_0x0114:
            r3 = r11
        L_0x0115:
            androidx.appcompat.widget.AppCompatTextView r11 = r3.btnHelp
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r4)
            android.view.View r11 = (android.view.View) r11
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r11)
            com.blueair.adddevice.adapter.ScannedDevicesAdapter r11 = r10.getAdapter()
            boolean r11 = r11.getHasEmptyState()
            if (r11 != 0) goto L_0x0130
            com.blueair.adddevice.viewmodel.AddDeviceViewModel r11 = r10.getViewModel()
            r11.resetScanResult()
        L_0x0130:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.fragment.BluetoothScanResultFragment.handleInitialState(boolean):void");
    }

    /* access modifiers changed from: private */
    public final void showScanningResults(List<BluetoothDevice> list) {
        Object obj;
        android.bluetooth.BluetoothDevice selectedBleDevice = getViewModel().getSelectedBleDevice();
        if (selectedBleDevice != null) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((BluetoothDevice) obj).getMac(), (Object) selectedBleDevice.getAddress())) {
                    break;
                }
            }
            if (obj == null) {
                onSelectionLost();
            }
        }
        getAdapter().setDevices(list);
        checkHideScanningFragment();
        checkTitleVisible();
        getViewModel().getLvDeviceScanned().setValue(Boolean.valueOf(!list.isEmpty()));
    }

    /* access modifiers changed from: private */
    public final void checkHideScanningFragment() {
        if (!getAdapter().getHasEmptyState()) {
            FragmentBluetoothScanResultBinding fragmentBluetoothScanResultBinding = this.binding;
            if (fragmentBluetoothScanResultBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentBluetoothScanResultBinding = null;
            }
            fragmentBluetoothScanResultBinding.scanningFragment.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void checkTitleVisible() {
        FragmentBluetoothScanResultBinding fragmentBluetoothScanResultBinding = this.binding;
        if (fragmentBluetoothScanResultBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBluetoothScanResultBinding = null;
        }
        Group group = fragmentBluetoothScanResultBinding.groupTitle;
        Intrinsics.checkNotNullExpressionValue(group, "groupTitle");
        group.setVisibility(!getAdapter().getHasEmptyState() ? 0 : 8);
    }

    private final void showEnableLocationBluetooth() {
        Pair pair;
        Timber.Forest.d("enableLocationPermission", new Object[0]);
        getBluetoothEnableHolder().getBinding().bleEnableBtn.setOnClickListener(new BluetoothScanResultFragment$$ExternalSyntheticLambda8(this));
        Context context = getContext();
        FragmentBluetoothScanResultBinding fragmentBluetoothScanResultBinding = null;
        if (context != null) {
            BluetoothEnableHolder bluetoothEnableHolder = getBluetoothEnableHolder();
            if (Build.VERSION.SDK_INT < 31) {
                LocationUtils locationUtils = LocationUtils.INSTANCE;
                FragmentBluetoothScanResultBinding fragmentBluetoothScanResultBinding2 = this.binding;
                if (fragmentBluetoothScanResultBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentBluetoothScanResultBinding2 = null;
                }
                Context context2 = fragmentBluetoothScanResultBinding2.rootLayout.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                if (!locationUtils.isLocationEnabled(context2)) {
                    pair = new Pair(context.getString(R.string.label_allow_nearby_devices), context.getString(R.string.msg_allow_nearby_devices));
                    bluetoothEnableHolder.update(pair);
                }
            }
            BluetoothUtils bluetoothUtils = BluetoothUtils.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            if (!bluetoothUtils.hasBluetoothPermissions(requireContext)) {
                pair = new Pair(context.getString(R.string.label_allow_nearby_devices), context.getString(R.string.msg_allow_nearby_devices));
            } else if (!getViewModel().isBluetoothEnabled()) {
                pair = new Pair(context.getString(R.string.label_turn_bluetooth_on), context.getString(R.string.msg_turn_bluetooth_on));
            } else {
                pair = new Pair(context.getString(R.string.label_allow_nearby_devices), context.getString(R.string.msg_allow_nearby_devices));
            }
            bluetoothEnableHolder.update(pair);
        }
        FragmentBluetoothScanResultBinding fragmentBluetoothScanResultBinding3 = this.binding;
        if (fragmentBluetoothScanResultBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBluetoothScanResultBinding = fragmentBluetoothScanResultBinding3;
        }
        FrameLayout frameLayout = fragmentBluetoothScanResultBinding.scanningFragment;
        View view = getBluetoothEnableHolder().itemView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getBluetoothEnableHolder().itemView.getLayoutParams());
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(view, layoutParams);
    }

    /* access modifiers changed from: private */
    public static final void showEnableLocationBluetooth$lambda$38(BluetoothScanResultFragment bluetoothScanResultFragment, View view) {
        AddDeviceUtils.INSTANCE.showEnableLocationBluetooth(bluetoothScanResultFragment, bluetoothScanResultFragment.getLocationPermissionTracker(), bluetoothScanResultFragment.requestBluetoothPermissionsLauncher);
    }

    @Deprecated(message = "Deprecated in Java")
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        handleInitialState$default(this, false, 1, (Object) null);
    }
}
