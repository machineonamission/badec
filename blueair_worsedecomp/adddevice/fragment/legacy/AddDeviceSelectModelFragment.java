package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.adddevice.adapter.DeviceModel;
import com.blueair.adddevice.adapter.SelectDeviceModelAdapter;
import com.blueair.adddevice.adapter.SelectDeviceModelAdapterKt;
import com.blueair.adddevice.fragment.RegionMismatchFragment;
import com.blueair.adddevice.service.AddDeviceService;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.bluetooth.utils.BluetoothUtils;
import com.blueair.core.AblEnvironment;
import com.blueair.core.model.AmplitudeEvent;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.OnboardingStartedEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.util.LocationPermissionTracker;
import com.blueair.core.util.LocationUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.dialog.ConfirmationDialogCenteredKt;
import com.blueair.viewcore.dialog.DialogUtils;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.android.DIPropertyDelegateProvider;
import org.kodein.di.android.x.ClosestKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\b\u0010H\u001a\u00020IH\u0016J\u0010\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020&H\u0002J\u0010\u0010L\u001a\u00020I2\u0006\u0010M\u001a\u00020NH\u0002J\b\u0010O\u001a\u00020IH\u0016J\b\u0010P\u001a\u00020IH\u0016J\"\u0010Q\u001a\u00020I2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020S2\b\u0010U\u001a\u0004\u0018\u00010VH\u0017J\u001a\u0010W\u001a\u0002072\u0006\u0010X\u001a\u00020Y2\b\b\u0002\u0010Z\u001a\u000207H\u0002J\b\u0010[\u001a\u000207H\u0003J\"\u0010\\\u001a\u00020I2\u0006\u0010]\u001a\u00020S2\u0006\u0010^\u001a\u00020S2\b\b\u0002\u0010_\u001a\u000207H\u0002J-\u0010`\u001a\u00020I2\u0006\u0010R\u001a\u00020S2\u000e\u0010a\u001a\n\u0012\u0006\b\u0001\u0012\u00020>0=2\u0006\u0010b\u001a\u00020cH\u0017¢\u0006\u0002\u0010dR\u001b\u0010\u0005\u001a\u00020\u00068VX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R!\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%8BX\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u001b\u0010+\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b/\u0010\n\u001a\u0004\b-\u0010.R\u0010\u00100\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u001b\u00101\u001a\u0002028BX\u0002¢\u0006\f\n\u0004\b5\u0010\n\u001a\u0004\b3\u00104R\u001b\u00106\u001a\u0002078BX\u0002¢\u0006\f\n\u0004\b:\u0010\n\u001a\u0004\b8\u00109R(\u0010;\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020> ?*\n\u0012\u0004\u0012\u00020>\u0018\u00010=0=0<X\u0004¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceSelectModelFragment;", "Landroidx/fragment/app/Fragment;", "Lorg/kodein/di/DIAware;", "<init>", "()V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "addService", "Lcom/blueair/adddevice/service/AddDeviceService;", "getAddService", "()Lcom/blueair/adddevice/service/AddDeviceService;", "addService$delegate", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "getAnalyticsService", "()Lcom/blueair/core/service/AnalyticsService;", "analyticsService$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "locationPermissionTracker", "Lcom/blueair/core/util/LocationPermissionTracker;", "getLocationPermissionTracker", "()Lcom/blueair/core/util/LocationPermissionTracker;", "locationPermissionTracker$delegate", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "deviceModelSelectPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/adddevice/adapter/DeviceModel;", "getDeviceModelSelectPublisher", "()Lio/reactivex/subjects/PublishSubject;", "deviceModelSelectPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "adapter", "Lcom/blueair/adddevice/adapter/SelectDeviceModelAdapter;", "getAdapter", "()Lcom/blueair/adddevice/adapter/SelectDeviceModelAdapter;", "adapter$delegate", "selectedDeviceModel", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "rxSubs$delegate", "regionMismatch", "", "getRegionMismatch", "()Z", "regionMismatch$delegate", "requestBluetoothPermissionsLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "kotlin.jvm.PlatformType", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "openDeviceOnBoarding", "model", "logOnboardingStartEvent", "deviceType", "Lcom/blueair/core/model/DeviceType;", "onPause", "onDestroy", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "isWifiPermissionsEnabled", "activity", "Landroid/app/Activity;", "isIcp", "isBluetoothPermissionsEnabled", "showPermissionDialog", "titleTextResId", "bodyTextResId", "isLocation", "onRequestPermissionsResult", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceSelectModelFragment.kt */
public final class AddDeviceSelectModelFragment extends Fragment implements DIAware {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int GRIDVIEW_NUMBER_OF_COLUMNS = 2;
    /* access modifiers changed from: private */
    public static final int REQUEST_CODE_LOGIN = ViewUtils.INSTANCE.genRequestCode();
    private final Lazy adapter$delegate = LazyKt.lazy(new AddDeviceSelectModelFragment$$ExternalSyntheticLambda2(this));
    private final Lazy addService$delegate;
    private final Lazy analyticsService$delegate;
    private final Lazy authService$delegate;
    private final LazyPublishSubject deviceModelSelectPublisher$delegate = new LazyPublishSubject();
    private final Lazy di$delegate;
    private final Lazy locationPermissionTracker$delegate;
    private final Lazy locationService$delegate;
    private final Lazy regionMismatch$delegate = LazyKt.lazy(new AddDeviceSelectModelFragment$$ExternalSyntheticLambda4(this));
    private final ActivityResultLauncher<String[]> requestBluetoothPermissionsLauncher;
    private final Lazy rxSubs$delegate = LazyKt.lazy(new AddDeviceSelectModelFragment$$ExternalSyntheticLambda3());
    private DeviceModel selectedDeviceModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceSelectModelFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.blueair.adddevice.adapter.DeviceModel[] r0 = com.blueair.adddevice.adapter.DeviceModel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.adddevice.adapter.DeviceModel r1 = com.blueair.adddevice.adapter.DeviceModel.CLASSIC     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.adddevice.adapter.DeviceModel r1 = com.blueair.adddevice.adapter.DeviceModel.SENSE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.adddevice.adapter.DeviceModel r1 = com.blueair.adddevice.adapter.DeviceModel.AWARE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.adddevice.adapter.DeviceModel r1 = com.blueair.adddevice.adapter.DeviceModel.ICP     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.adddevice.fragment.legacy.AddDeviceSelectModelFragment.WhenMappings.<clinit>():void");
        }
    }

    static {
        Class<AddDeviceSelectModelFragment> cls = AddDeviceSelectModelFragment.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "di", "getDi()Lorg/kodein/di/DI;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "addService", "getAddService()Lcom/blueair/adddevice/service/AddDeviceService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "analyticsService", "getAnalyticsService()Lcom/blueair/core/service/AnalyticsService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "locationPermissionTracker", "getLocationPermissionTracker()Lcom/blueair/core/util/LocationPermissionTracker;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "deviceModelSelectPublisher", "getDeviceModelSelectPublisher()Lio/reactivex/subjects/PublishSubject;", 0))};
    }

    public AddDeviceSelectModelFragment() {
        DIPropertyDelegateProvider<Object> closestDI = ClosestKt.closestDI((Fragment) this);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.di$delegate = closestDI.provideDelegate(this, kPropertyArr[0]);
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AddDeviceSelectModelFragment$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.addService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, AddDeviceService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new AddDeviceSelectModelFragment$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.analyticsService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, AnalyticsService.class), (Object) null).provideDelegate(this, kPropertyArr[2]);
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new AddDeviceSelectModelFragment$special$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken3, LocationService.class), (Object) null).provideDelegate(this, kPropertyArr[3]);
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new AddDeviceSelectModelFragment$special$$inlined$instance$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationPermissionTracker$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken4, LocationPermissionTracker.class), (Object) null).provideDelegate(this, kPropertyArr[4]);
        JVMTypeToken<?> typeToken5 = TypeTokensJVMKt.typeToken(new AddDeviceSelectModelFragment$special$$inlined$instance$default$5().getSuperType());
        Intrinsics.checkNotNull(typeToken5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.authService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken5, AuthService.class), (Object) null).provideDelegate(this, kPropertyArr[5]);
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new AddDeviceSelectModelFragment$$ExternalSyntheticLambda5(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.requestBluetoothPermissionsLauncher = registerForActivityResult;
    }

    public DIContext<?> getDiContext() {
        return DIAware.DefaultImpls.getDiContext(this);
    }

    public DITrigger getDiTrigger() {
        return DIAware.DefaultImpls.getDiTrigger(this);
    }

    public DI getDi() {
        return (DI) this.di$delegate.getValue();
    }

    private final AddDeviceService getAddService() {
        return (AddDeviceService) this.addService$delegate.getValue();
    }

    private final AnalyticsService getAnalyticsService() {
        return (AnalyticsService) this.analyticsService$delegate.getValue();
    }

    private final LocationService getLocationService() {
        return (LocationService) this.locationService$delegate.getValue();
    }

    private final LocationPermissionTracker getLocationPermissionTracker() {
        return (LocationPermissionTracker) this.locationPermissionTracker$delegate.getValue();
    }

    private final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    private final PublishSubject<DeviceModel> getDeviceModelSelectPublisher() {
        return this.deviceModelSelectPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[6]);
    }

    private final SelectDeviceModelAdapter getAdapter() {
        return (SelectDeviceModelAdapter) this.adapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final SelectDeviceModelAdapter adapter_delegate$lambda$0(AddDeviceSelectModelFragment addDeviceSelectModelFragment) {
        return new SelectDeviceModelAdapter(addDeviceSelectModelFragment.getLocationService(), addDeviceSelectModelFragment.getDeviceModelSelectPublisher());
    }

    private final CompositeDisposable getRxSubs() {
        return (CompositeDisposable) this.rxSubs$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final CompositeDisposable rxSubs_delegate$lambda$1() {
        return new CompositeDisposable();
    }

    private final boolean getRegionMismatch() {
        return ((Boolean) this.regionMismatch$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean regionMismatch_delegate$lambda$2(AddDeviceSelectModelFragment addDeviceSelectModelFragment) {
        CharSequence ablRegion;
        if (!AblEnvironment.INSTANCE.isUAT() && !addDeviceSelectModelFragment.getLocationService().isInChina() && (ablRegion = addDeviceSelectModelFragment.getLocationService().getAblRegion()) != null && ablRegion.length() != 0 && !Intrinsics.areEqual((Object) addDeviceSelectModelFragment.getAuthService().getAblHomeHost(), (Object) AblEnvironment.INSTANCE.getBaseUrl()) && !Intrinsics.areEqual((Object) addDeviceSelectModelFragment.getLocationService().getAblRegion(), (Object) StringsKt.substringBefore$default(StringsKt.substringAfter$default(addDeviceSelectModelFragment.getAuthService().getAblHomeHost(), "https://api-", (String) null, 2, (Object) null), ".", (String) null, 2, (Object) null))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final void requestBluetoothPermissionsLauncher$lambda$4(AddDeviceSelectModelFragment addDeviceSelectModelFragment, Map map) {
        Iterable values = map.values();
        boolean z = true;
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
        if (!BluetoothUtils.INSTANCE.shouldShowBluetoothRequestPermissionDialog(addDeviceSelectModelFragment) && !z) {
            showPermissionDialog$default(addDeviceSelectModelFragment, R.string.bluetooth_permission_dialog_title, R.string.bluetooth_permission_12, false, 4, (Object) null);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(com.blueair.adddevice.R.layout.fragment_add_device_select_model, viewGroup, false);
        ((RecyclerView) inflate.findViewById(com.blueair.adddevice.R.id.rv_list)).setAdapter(getAdapter());
        FragmentActivity activity = getActivity();
        if (!(activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null)) {
            OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, getViewLifecycleOwner(), false, new AddDeviceSelectModelFragment$$ExternalSyntheticLambda7(this), 2, (Object) null);
        }
        return inflate;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$5(AddDeviceSelectModelFragment addDeviceSelectModelFragment, OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "$this$addCallback");
        if (!Intrinsics.areEqual((Object) addDeviceSelectModelFragment.getAdapter().getDeviceList(), (Object) addDeviceSelectModelFragment.getAdapter().getDefaultModelList())) {
            addDeviceSelectModelFragment.getAdapter().setDeviceList(addDeviceSelectModelFragment.getAdapter().getDefaultModelList());
        }
        return Unit.INSTANCE;
    }

    public void onResume() {
        super.onResume();
        CompositeDisposable rxSubs = getRxSubs();
        Observable filterRapidClicks = RxExtensionsKt.filterRapidClicks(RxExtensionsKt.uiThread(getDeviceModelSelectPublisher()));
        Intrinsics.checkNotNullExpressionValue(filterRapidClicks, "filterRapidClicks(...)");
        rxSubs.add(RxExtensionsKt.subscribeAndLogE(filterRapidClicks, new AddDeviceSelectModelFragment$$ExternalSyntheticLambda1(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$7(AddDeviceSelectModelFragment addDeviceSelectModelFragment, DeviceModel deviceModel) {
        FragmentActivity activity = addDeviceSelectModelFragment.getActivity();
        if (activity != null) {
            if (addDeviceSelectModelFragment.getAddService().isUserLoggedIn()) {
                Intrinsics.checkNotNull(deviceModel);
                addDeviceSelectModelFragment.openDeviceOnBoarding(deviceModel);
            } else {
                addDeviceSelectModelFragment.selectedDeviceModel = deviceModel;
                addDeviceSelectModelFragment.startActivityForResult(Actions.openWelcomeIntent$default(Actions.INSTANCE, activity, false, 2, (Object) null), REQUEST_CODE_LOGIN);
            }
        }
        return Unit.INSTANCE;
    }

    private final void openDeviceOnBoarding(DeviceModel deviceModel) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (!SelectDeviceModelAdapterKt.legacy(deviceModel) || !getRegionMismatch()) {
            int i = WhenMappings.$EnumSwitchMapping$0[deviceModel.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4 && isWifiPermissionsEnabled(activity, true) && isBluetoothPermissionsEnabled()) {
                            logOnboardingStartEvent(DeviceType.Icp.INSTANCE);
                            getAddService().selectDevice(40);
                        }
                    } else if (isWifiPermissionsEnabled$default(this, activity, false, 2, (Object) null)) {
                        logOnboardingStartEvent(DeviceType.Aware.INSTANCE);
                        getAddService().selectDevice(1);
                    }
                } else if (isWifiPermissionsEnabled$default(this, activity, false, 2, (Object) null)) {
                    logOnboardingStartEvent(DeviceType.Sense.INSTANCE);
                    getAddService().selectDevice(2);
                }
            } else if (isWifiPermissionsEnabled$default(this, activity, false, 2, (Object) null)) {
                logOnboardingStartEvent(DeviceType.Classic.INSTANCE);
                getAddService().selectDevice(3);
            }
        } else {
            RegionMismatchFragment.Companion.newInstance().show(activity.getSupportFragmentManager(), (String) null);
        }
    }

    private final void logOnboardingStartEvent(DeviceType deviceType) {
        getAnalyticsService().amplitudeLog((AmplitudeEvent) new OnboardingStartedEvent(deviceType.getName()));
    }

    public void onPause() {
        getRxSubs().clear();
        super.onPause();
    }

    public void onDestroy() {
        getRxSubs().clear();
        super.onDestroy();
    }

    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int i, int i2, Intent intent) {
        DeviceModel deviceModel;
        super.onActivityResult(i, i2, intent);
        if (i == REQUEST_CODE_LOGIN && getAddService().isUserLoggedIn() && (deviceModel = this.selectedDeviceModel) != null) {
            openDeviceOnBoarding(deviceModel);
        }
    }

    static /* synthetic */ boolean isWifiPermissionsEnabled$default(AddDeviceSelectModelFragment addDeviceSelectModelFragment, Activity activity, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return addDeviceSelectModelFragment.isWifiPermissionsEnabled(activity, z);
    }

    private final boolean isWifiPermissionsEnabled(Activity activity, boolean z) {
        int i;
        DialogFragment dialogFragment;
        int i2;
        if (z && Build.VERSION.SDK_INT >= 31) {
            return true;
        }
        Context context = activity;
        if (!LocationUtils.INSTANCE.isLocationEnabled(context)) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<ConfirmationDialogCentered> cls = ConfirmationDialogCentered.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogCentered", "getSimpleName(...)");
            if ((childFragmentManager.findFragmentByTag("ConfirmationDialogCentered") instanceof ConfirmationDialogCentered) || childFragmentManager.isStateSaved()) {
                dialogFragment = null;
            } else {
                if (Build.VERSION.SDK_INT <= 26) {
                    i2 = R.string.enable_loc_wifi_android_o;
                } else {
                    i2 = R.string.enable_loc_wifi;
                }
                dialogFragment = ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, 0, Integer.valueOf(i2), R.string.enable_locations, Integer.valueOf(R.string.btn_cancel), false, false, false, (String[]) null, 224, (Object) null);
                dialogFragment.show(childFragmentManager, "ConfirmationDialogCentered");
            }
            ConfirmationDialogCentered confirmationDialogCentered = (ConfirmationDialogCentered) dialogFragment;
            if (confirmationDialogCentered != null) {
                FragmentKt.setFragmentResultListener(confirmationDialogCentered, ConfirmationDialogCenteredKt.CONFIRMATION_REQUEST_KEY, new AddDeviceSelectModelFragment$$ExternalSyntheticLambda0(this));
            }
            return false;
        } else if (LocationUtils.INSTANCE.isLocationPermissionGranted(context)) {
            return true;
        } else {
            if (getLocationPermissionTracker().shouldShowLocationRequestPermissionDialog((Fragment) this)) {
                showPermissionDialog(R.string.wh_location_permission_dialog_title, R.string.location_permission_connect_12, true);
            } else {
                if (Build.VERSION.SDK_INT >= 31) {
                    i = R.string.location_permission_connect_12;
                } else {
                    i = R.string.location_permission_connect;
                }
                showPermissionDialog(R.string.wh_location_permission_dialog_title, i, true);
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static final Unit isWifiPermissionsEnabled$lambda$12(AddDeviceSelectModelFragment addDeviceSelectModelFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.getBoolean(ConfirmationDialogCenteredKt.IS_CONFIRMED_KEY)) {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            intent.setFlags(268435456);
            addDeviceSelectModelFragment.startActivity(intent);
        }
        return Unit.INSTANCE;
    }

    private final boolean isBluetoothPermissionsEnabled() {
        BluetoothUtils bluetoothUtils = BluetoothUtils.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        if (bluetoothUtils.hasBluetoothPermissions(requireContext)) {
            return true;
        }
        DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_bluetooth, R.string.permission_request_message_bluetooth);
        this.requestBluetoothPermissionsLauncher.launch(new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE"});
        return false;
    }

    static /* synthetic */ void showPermissionDialog$default(AddDeviceSelectModelFragment addDeviceSelectModelFragment, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        addDeviceSelectModelFragment.showPermissionDialog(i, i2, z);
    }

    private final void showPermissionDialog(int i, int i2, boolean z) {
        ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, Integer.valueOf(i), Integer.valueOf(i2), R.string.btn_goto_settings, Integer.valueOf(R.string.btn_cancel), true, false, false, (String[]) null, 224, (Object) null).show(getChildFragmentManager(), (String) null);
        getChildFragmentManager().setFragmentResultListener(ConfirmationDialogCenteredKt.CONFIRMATION_REQUEST_KEY, this, new AddDeviceSelectModelFragment$$ExternalSyntheticLambda6(this, z));
    }

    /* access modifiers changed from: private */
    public static final void showPermissionDialog$lambda$16(AddDeviceSelectModelFragment addDeviceSelectModelFragment, boolean z, String str, Bundle bundle) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.getBoolean(ConfirmationDialogCenteredKt.IS_CONFIRMED_KEY)) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setFlags(268435456);
            StringBuilder sb = new StringBuilder("package:");
            Context context = addDeviceSelectModelFragment.getContext();
            Unit unit = null;
            sb.append(context != null ? context.getPackageName() : null);
            intent.setData(Uri.parse(sb.toString()));
            try {
                Result.Companion companion = Result.Companion;
                if (z) {
                    addDeviceSelectModelFragment.getLocationPermissionTracker().requestLocationPermission(addDeviceSelectModelFragment, new AddDeviceSelectModelFragment$$ExternalSyntheticLambda8());
                    unit = Unit.INSTANCE;
                } else {
                    Context context2 = addDeviceSelectModelFragment.getContext();
                    if (context2 != null) {
                        context2.startActivity(intent);
                        unit = Unit.INSTANCE;
                    }
                }
                obj = Result.m9366constructorimpl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m9366constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m9369exceptionOrNullimpl(obj) != null) {
                ViewUtils viewUtils = ViewUtils.INSTANCE;
                FragmentActivity requireActivity = addDeviceSelectModelFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
                viewUtils.showSnackbar((Activity) requireActivity, R.string.bluetooth_permission_12, (ViewUtils.MessageType) ViewUtils.MessageType.INFO.INSTANCE);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Unit showPermissionDialog$lambda$16$lambda$14$lambda$13() {
        DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_location_connect, R.string.permission_request_message_location_connect);
        return Unit.INSTANCE;
    }

    @Deprecated(message = "Deprecated in Java")
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        if (i == 10101 && ArraysKt.contains(iArr, -1)) {
            int length = strArr.length;
            int i2 = 0;
            while (i2 < length && shouldShowRequestPermissionRationale(strArr[i2])) {
                i2++;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceSelectModelFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceSelectModelFragment;", "GRIDVIEW_NUMBER_OF_COLUMNS", "", "REQUEST_CODE_LOGIN", "getREQUEST_CODE_LOGIN", "()I", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceSelectModelFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddDeviceSelectModelFragment newInstance() {
            return new AddDeviceSelectModelFragment();
        }

        public final int getREQUEST_CODE_LOGIN() {
            return AddDeviceSelectModelFragment.REQUEST_CODE_LOGIN;
        }
    }
}
