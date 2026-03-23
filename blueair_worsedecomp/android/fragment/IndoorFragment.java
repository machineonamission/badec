package com.blueair.android.fragment;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.blueair.android.adapter.DeviceListAdapter;
import com.blueair.android.databinding.FragmentIndoorBinding;
import com.blueair.android.dialog.RateUsDialogFragment;
import com.blueair.android.viewmodel.IndoorViewModel;
import com.blueair.core.model.AmplitudeEvent;
import com.blueair.core.model.AmplitudeEventKt;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasAlarm;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.InAppReviewEvent;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.model.UserInfoItem;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.util.LocationPermissionTracker;
import com.blueair.core.util.LocationUtils;
import com.blueair.core.util.TimezoneUtils;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.blueair.devicedetails.activity.DevicesAlarmListActivity;
import com.blueair.devicedetails.dialog.DeviceDetailsDialogFragment;
import com.blueair.devicedetails.dialog.DeviceDetailsV2DialogFragment;
import com.blueair.devicedetails.util.DeviceDetailsLauncher;
import com.blueair.sdk.GooglePlayAppReviewSdk;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.BlockerDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.dialog.TroubleshootingDialog;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.fragment.BaseFragmentInterface;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import com.dd.ShadowLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 w2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00020\u0005:\u0001wB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\tH\u0016J\b\u0010Q\u001a\u00020RH\u0016J\u0012\u0010S\u001a\u00020%2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\u0010\u0010V\u001a\u00020%2\u0006\u0010W\u001a\u00020UH\u0016J$\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\u001a\u0010^\u001a\u00020%2\u0006\u0010_\u001a\u00020Y2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\b\u0010`\u001a\u00020%H\u0016J\b\u0010a\u001a\u00020%H\u0002J\u0006\u0010b\u001a\u00020%J\b\u0010c\u001a\u00020\tH\u0003J\u0010\u0010d\u001a\u00020%2\u0006\u0010e\u001a\u00020fH\u0002J\b\u0010g\u001a\u00020%H\u0002J\u001e\u0010h\u001a\u00020%2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020f0j2\u0006\u0010k\u001a\u00020\tH\u0002J\b\u0010l\u001a\u00020%H\u0016J\u001a\u0010m\u001a\u00020%2\u0006\u0010n\u001a\u00020)2\b\u0010o\u001a\u0004\u0018\u00010fH\u0016J\"\u0010p\u001a\u00020%2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020r2\b\u0010t\u001a\u0004\u0018\u00010NH\u0017J\b\u0010u\u001a\u00020%H\u0002J\b\u0010v\u001a\u00020%H\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148VX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R!\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(8BX\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+R!\u0010.\u001a\b\u0012\u0004\u0012\u00020/0(8BX\u0002¢\u0006\f\n\u0004\b1\u0010-\u001a\u0004\b0\u0010+R!\u00102\u001a\b\u0012\u0004\u0012\u00020)0(8BX\u0002¢\u0006\f\n\u0004\b4\u0010-\u001a\u0004\b3\u0010+R!\u00105\u001a\b\u0012\u0004\u0012\u00020)0(8BX\u0002¢\u0006\f\n\u0004\b7\u0010-\u001a\u0004\b6\u0010+R!\u00108\u001a\b\u0012\u0004\u0012\u00020)0(8BX\u0002¢\u0006\f\n\u0004\b:\u0010-\u001a\u0004\b9\u0010+R\u000e\u0010;\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020=8BX\u0002¢\u0006\f\n\u0004\b@\u0010\u0018\u001a\u0004\b>\u0010?R\u001b\u0010A\u001a\u00020B8BX\u0002¢\u0006\f\n\u0004\bE\u0010\u0018\u001a\u0004\bC\u0010DR\u000e\u0010F\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010H\u001a\u0004\u0018\u00010I8BX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0010\u0012\f\u0012\n O*\u0004\u0018\u00010N0N0MX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020N0MX\u0004¢\u0006\u0002\n\u0000¨\u0006x"}, d2 = {"Lcom/blueair/android/fragment/IndoorFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/android/viewmodel/IndoorViewModel;", "Lcom/blueair/devicedetails/util/DeviceDetailsLauncher;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "Lcom/blueair/viewcore/fragment/BaseFragmentInterface;", "<init>", "()V", "forceRefresh", "", "lastBleRequest", "", "indoorBinding", "Lcom/blueair/android/databinding/FragmentIndoorBinding;", "viewModel", "getViewModel", "()Lcom/blueair/android/viewmodel/IndoorViewModel;", "setViewModel", "(Lcom/blueair/android/viewmodel/IndoorViewModel;)V", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "rxSubs$delegate", "Lkotlin/Lazy;", "locationPermissionTracker", "Lcom/blueair/core/util/LocationPermissionTracker;", "getLocationPermissionTracker", "()Lcom/blueair/core/util/LocationPermissionTracker;", "locationPermissionTracker$delegate", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "showProgress", "", "shouldShowProgress", "deviceSelectPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/core/model/Device;", "getDeviceSelectPublisher", "()Lio/reactivex/subjects/PublishSubject;", "deviceSelectPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "autoModePublisher", "Lcom/blueair/core/model/HasFanSpeed;", "getAutoModePublisher", "autoModePublisher$delegate", "nightModePublisher", "getNightModePublisher", "nightModePublisher$delegate", "standByModePublisher", "getStandByModePublisher", "standByModePublisher$delegate", "offlineClickPublisher", "getOfflineClickPublisher", "offlineClickPublisher$delegate", "shouldCheckRateUsAndWelcomeHome", "networkSnack", "Lcom/google/android/material/snackbar/Snackbar;", "getNetworkSnack", "()Lcom/google/android/material/snackbar/Snackbar;", "networkSnack$delegate", "adapter", "Lcom/blueair/android/adapter/DeviceListAdapter;", "getAdapter", "()Lcom/blueair/android/adapter/DeviceListAdapter;", "adapter$delegate", "firstNotEmptyDeviceListLiveData", "initialSetupCallFinished", "blockerDialog", "Landroidx/fragment/app/DialogFragment;", "getBlockerDialog", "()Landroidx/fragment/app/DialogFragment;", "launcherConnectDevice", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "devicesAlarmLauncher", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "observeViewModel", "connectDevice", "isBluetoothEnabled", "showHelpUsImprove", "trigger", "", "requestInAppReview", "showDstPrompt", "nullTimezoneDeviceIdList", "", "isTriggeredByLocal", "onResume", "openDeviceDetails", "device", "actionType", "onActivityResult", "requestCode", "", "resultCode", "data", "handleDeviceDetailsDialogClosed", "onDestroy", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: IndoorFragment.kt */
public final class IndoorFragment extends BaseFragment<IndoorViewModel> implements DeviceDetailsLauncher, ProgressFragment, BaseFragmentInterface<IndoorViewModel> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final int $stable = 8;
    @Deprecated
    public static final String BLUEAIR_URL = "https://www.blueair.com";
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final int REQUEST_BLE_DELTA_MILLIS = 20000;
    /* access modifiers changed from: private */
    public static final int REQUEST_CODE_CONNECT_PRODUCT = ViewUtils.INSTANCE.genRequestCode();
    /* access modifiers changed from: private */
    public static final int REQUEST_CODE_DEVICE_DETAILS_DIALOG_CLOSED = ViewUtils.INSTANCE.genRequestCode();
    @Deprecated
    public static final int REQUEST_CODE_ENABLE_BT = 1230;
    private final Lazy adapter$delegate;
    private final LazyPublishSubject autoModePublisher$delegate;
    private final LazyPublishSubject deviceSelectPublisher$delegate;
    private final ActivityResultLauncher<Intent> devicesAlarmLauncher;
    private boolean firstNotEmptyDeviceListLiveData;
    private boolean forceRefresh;
    private FragmentIndoorBinding indoorBinding;
    private boolean initialSetupCallFinished;
    private long lastBleRequest;
    private final ActivityResultLauncher<Intent> launcherConnectDevice;
    private final Lazy locationPermissionTracker$delegate;
    private final Lazy networkSnack$delegate;
    private final LazyPublishSubject nightModePublisher$delegate;
    private final LazyPublishSubject offlineClickPublisher$delegate;
    private ProgressBlockerView progressBlockerView;
    private final Lazy rxSubs$delegate = LazyKt.lazy(new IndoorFragment$$ExternalSyntheticLambda16());
    private boolean shouldCheckRateUsAndWelcomeHome;
    private final LazyPublishSubject standByModePublisher$delegate;
    public IndoorViewModel viewModel;

    static {
        Class<IndoorFragment> cls = IndoorFragment.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "locationPermissionTracker", "getLocationPermissionTracker()Lcom/blueair/core/util/LocationPermissionTracker;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "deviceSelectPublisher", "getDeviceSelectPublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "autoModePublisher", "getAutoModePublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "nightModePublisher", "getNightModePublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "standByModePublisher", "getStandByModePublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "offlineClickPublisher", "getOfflineClickPublisher()Lio/reactivex/subjects/PublishSubject;", 0))};
    }

    /* access modifiers changed from: private */
    public static final void devicesAlarmLauncher$lambda$4(ActivityResult activityResult) {
    }

    public IndoorFragment() {
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new IndoorFragment$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationPermissionTracker$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, LocationPermissionTracker.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
        this.deviceSelectPublisher$delegate = new LazyPublishSubject();
        this.autoModePublisher$delegate = new LazyPublishSubject();
        this.nightModePublisher$delegate = new LazyPublishSubject();
        this.standByModePublisher$delegate = new LazyPublishSubject();
        this.offlineClickPublisher$delegate = new LazyPublishSubject();
        this.shouldCheckRateUsAndWelcomeHome = true;
        this.networkSnack$delegate = LazyKt.lazy(new IndoorFragment$$ExternalSyntheticLambda17(this));
        this.adapter$delegate = LazyKt.lazy(new IndoorFragment$$ExternalSyntheticLambda18(this));
        this.firstNotEmptyDeviceListLiveData = true;
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new IndoorFragment$$ExternalSyntheticLambda19(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.launcherConnectDevice = registerForActivityResult;
        ActivityResultLauncher<Intent> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new IndoorFragment$$ExternalSyntheticLambda20());
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.devicesAlarmLauncher = registerForActivityResult2;
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

    public IndoorViewModel getViewModel() {
        IndoorViewModel indoorViewModel = this.viewModel;
        if (indoorViewModel != null) {
            return indoorViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(IndoorViewModel indoorViewModel) {
        Intrinsics.checkNotNullParameter(indoorViewModel, "<set-?>");
        this.viewModel = indoorViewModel;
    }

    /* access modifiers changed from: private */
    public static final CompositeDisposable rxSubs_delegate$lambda$0() {
        return new CompositeDisposable();
    }

    public CompositeDisposable getRxSubs() {
        return (CompositeDisposable) this.rxSubs$delegate.getValue();
    }

    private final LocationPermissionTracker getLocationPermissionTracker() {
        return (LocationPermissionTracker) this.locationPermissionTracker$delegate.getValue();
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

    private final PublishSubject<Device> getDeviceSelectPublisher() {
        return this.deviceSelectPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[1]);
    }

    private final PublishSubject<HasFanSpeed> getAutoModePublisher() {
        return this.autoModePublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[2]);
    }

    private final PublishSubject<Device> getNightModePublisher() {
        return this.nightModePublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[3]);
    }

    private final PublishSubject<Device> getStandByModePublisher() {
        return this.standByModePublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[4]);
    }

    private final PublishSubject<Device> getOfflineClickPublisher() {
        return this.offlineClickPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[5]);
    }

    private final Snackbar getNetworkSnack() {
        return (Snackbar) this.networkSnack$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Snackbar networkSnack_delegate$lambda$1(IndoorFragment indoorFragment) {
        return Snackbar.make(indoorFragment.requireActivity().findViewById(16908290), (CharSequence) indoorFragment.getString(R.string.connection_lost), -2);
    }

    /* access modifiers changed from: private */
    public static final DeviceListAdapter adapter_delegate$lambda$2(IndoorFragment indoorFragment) {
        return new DeviceListAdapter(indoorFragment.getDeviceSelectPublisher(), indoorFragment.getStandByModePublisher(), indoorFragment.getOfflineClickPublisher());
    }

    /* access modifiers changed from: private */
    public final DeviceListAdapter getAdapter() {
        return (DeviceListAdapter) this.adapter$delegate.getValue();
    }

    private final DialogFragment getBlockerDialog() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<DialogFragment> cls = DialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DialogFragment", "getSimpleName(...)");
        Fragment findFragmentByTag = childFragmentManager.findFragmentByTag("DialogFragment");
        if (!(findFragmentByTag instanceof DialogFragment)) {
            findFragmentByTag = null;
        }
        return (DialogFragment) findFragmentByTag;
    }

    /* access modifiers changed from: private */
    public static final void launcherConnectDevice$lambda$3(IndoorFragment indoorFragment, ActivityResult activityResult) {
        if (indoorFragment.getViewModel().isUserLoggedIn()) {
            indoorFragment.connectDevice();
        }
    }

    public ConstraintLayout getRootView() {
        FragmentIndoorBinding fragmentIndoorBinding = this.indoorBinding;
        if (fragmentIndoorBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indoorBinding");
            fragmentIndoorBinding = null;
        }
        ConstraintLayout constraintLayout = fragmentIndoorBinding.layoutMain;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "layoutMain");
        return constraintLayout;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z = true;
        if (bundle != null) {
            z = bundle.getBoolean("SHOULD_CHECK_RATE_US_AND_WELCOME_HOME", true);
        }
        this.shouldCheckRateUsAndWelcomeHome = z;
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        bundle.putBoolean("SHOULD_CHECK_RATE_US_AND_WELCOME_HOME", this.shouldCheckRateUsAndWelcomeHome);
        super.onSaveInstanceState(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentIndoorBinding inflate = FragmentIndoorBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        inflate.setIndoorViewModel((IndoorViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(IndoorViewModel.class)));
        IndoorViewModel indoorViewModel = inflate.getIndoorViewModel();
        if (indoorViewModel != null) {
            setViewModel(indoorViewModel);
            inflate.listDevices.setAdapter(getAdapter());
            RecyclerView.ItemAnimator itemAnimator = inflate.listDevices.getItemAnimator();
            SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
            this.indoorBinding = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indoorBinding");
                inflate = null;
            }
            View root = inflate.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            return root;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        FragmentIndoorBinding fragmentIndoorBinding = this.indoorBinding;
        FragmentIndoorBinding fragmentIndoorBinding2 = null;
        if (fragmentIndoorBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indoorBinding");
            fragmentIndoorBinding = null;
        }
        fragmentIndoorBinding.ivAddFooter.setOnClickListener(new IndoorFragment$$ExternalSyntheticLambda5(this));
        FragmentIndoorBinding fragmentIndoorBinding3 = this.indoorBinding;
        if (fragmentIndoorBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indoorBinding");
            fragmentIndoorBinding3 = null;
        }
        fragmentIndoorBinding3.btnAddProduct.setOnClickListener(new IndoorFragment$$ExternalSyntheticLambda6(this));
        observeViewModel();
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new IndoorFragment$onViewCreated$3(this, (Continuation<? super IndoorFragment$onViewCreated$3>) null), 3, (Object) null);
        FragmentIndoorBinding fragmentIndoorBinding4 = this.indoorBinding;
        if (fragmentIndoorBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indoorBinding");
        } else {
            fragmentIndoorBinding2 = fragmentIndoorBinding4;
        }
        fragmentIndoorBinding2.slAlarm.setOnClickListener(new IndoorFragment$$ExternalSyntheticLambda7(this));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$6(IndoorFragment indoorFragment, View view) {
        indoorFragment.connectDevice();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$7(IndoorFragment indoorFragment, View view) {
        indoorFragment.connectDevice();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$8(IndoorFragment indoorFragment, View view) {
        ActivityResultLauncher<Intent> activityResultLauncher = indoorFragment.devicesAlarmLauncher;
        DevicesAlarmListActivity.Companion companion = DevicesAlarmListActivity.Companion;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        activityResultLauncher.launch(companion.intent(context));
    }

    public void onStart() {
        super.onStart();
        if (getViewModel().shouldShowInAppReview()) {
            requestInAppReview();
        }
    }

    private final void observeViewModel() {
        LiveData<Boolean> networkAvailable = getViewModel().getNetworkAvailable();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(networkAvailable, viewLifecycleOwner, new IndoorFragment$$ExternalSyntheticLambda21(this));
        LiveData<List<Pair<Device, IndoorDatapoint>>> liveDevicesWithLatestDataPoint = getViewModel().getLiveDevicesWithLatestDataPoint();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(liveDevicesWithLatestDataPoint, viewLifecycleOwner2, new IndoorFragment$$ExternalSyntheticLambda22(this));
        LiveData<List<Device>> liveDevices = getViewModel().getLiveDevices();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(liveDevices, viewLifecycleOwner3, new IndoorFragment$$ExternalSyntheticLambda1(this));
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(getViewModel().getNullTimezoneDeviceIdList(), viewLifecycleOwner4, new IndoorFragment$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$9(IndoorFragment indoorFragment, boolean z) {
        if (z) {
            indoorFragment.getNetworkSnack().dismiss();
            indoorFragment.getAdapter().setForceOffline(false);
            indoorFragment.getViewModel().refreshDeviceList(true);
        } else {
            indoorFragment.getNetworkSnack().show();
            indoorFragment.getAdapter().setForceOffline(true);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$13(IndoorFragment indoorFragment, List list) {
        int i;
        Intrinsics.checkNotNullParameter(list, "it");
        indoorFragment.getAdapter().setCurrentList(list);
        Collection collection = list;
        if (!collection.isEmpty()) {
            FragmentActivity activity = indoorFragment.getActivity();
            boolean hasWindowFocus = activity != null ? activity.hasWindowFocus() : true;
            if (System.currentTimeMillis() - indoorFragment.lastBleRequest > 20000 && hasWindowFocus && indoorFragment.getViewModel().containsIcpDevice()) {
                if (!indoorFragment.isBluetoothEnabled()) {
                    Timber.Forest.w("ble not enabled", new Object[0]);
                    indoorFragment.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), REQUEST_CODE_ENABLE_BT);
                }
                LocationUtils locationUtils = LocationUtils.INSTANCE;
                Context requireContext = indoorFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                if (!locationUtils.isLocationPermissionGranted(requireContext)) {
                    indoorFragment.getLocationPermissionTracker().requestLocationPermissionDialogOnly(indoorFragment, new IndoorFragment$$ExternalSyntheticLambda14());
                }
                indoorFragment.lastBleRequest = System.currentTimeMillis();
            }
        }
        Iterator it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Device device = (Device) ((Pair) it.next()).getFirst();
            if (device instanceof HasAlarm) {
                Iterable<DeviceAlarm> alarms = ((HasAlarm) device).getAlarms();
                if (!(alarms instanceof Collection) || !((Collection) alarms).isEmpty()) {
                    i = 0;
                    for (DeviceAlarm deviceAlarm : alarms) {
                        if (deviceAlarm != null && deviceAlarm.getEnabled() && (i = i + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                } else {
                    i = 0;
                }
                i2 += i;
            }
        }
        FragmentIndoorBinding fragmentIndoorBinding = indoorFragment.indoorBinding;
        FragmentIndoorBinding fragmentIndoorBinding2 = null;
        if (fragmentIndoorBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indoorBinding");
            fragmentIndoorBinding = null;
        }
        ShadowLayout shadowLayout = fragmentIndoorBinding.slAlarm;
        Intrinsics.checkNotNullExpressionValue(shadowLayout, "slAlarm");
        ViewExtensionsKt.show(shadowLayout, false);
        FragmentIndoorBinding fragmentIndoorBinding3 = indoorFragment.indoorBinding;
        if (fragmentIndoorBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indoorBinding");
            fragmentIndoorBinding3 = null;
        }
        TextView textView = fragmentIndoorBinding3.tvAlarmValue;
        String string = indoorFragment.getString(R.string.schedule_active);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        FragmentIndoorBinding fragmentIndoorBinding4 = indoorFragment.indoorBinding;
        if (fragmentIndoorBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indoorBinding");
            fragmentIndoorBinding4 = null;
        }
        ConstraintLayout constraintLayout = fragmentIndoorBinding4.emptyLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "emptyLayout");
        ViewExtensionsKt.show(constraintLayout, list.isEmpty());
        FragmentIndoorBinding fragmentIndoorBinding5 = indoorFragment.indoorBinding;
        if (fragmentIndoorBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indoorBinding");
        } else {
            fragmentIndoorBinding2 = fragmentIndoorBinding5;
        }
        AppCompatImageView appCompatImageView = fragmentIndoorBinding2.ivAddFooter;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "ivAddFooter");
        ViewExtensionsKt.show(appCompatImageView, !collection.isEmpty());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$13$lambda$10() {
        DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_location_service, R.string.permission_request_message_location_service);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$17(IndoorFragment indoorFragment, List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        if (indoorFragment.firstNotEmptyDeviceListLiveData && !list.isEmpty()) {
            indoorFragment.firstNotEmptyDeviceListLiveData = false;
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                Device device = (Device) next;
                if ((device instanceof HasBlueCloudFunctions) && StringsKt.isBlank(device.getTimeZone())) {
                    arrayList.add(next);
                }
            }
            Iterable<Device> iterable = (List) arrayList;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Device uid : iterable) {
                arrayList2.add(uid.getUid());
            }
            indoorFragment.showDstPrompt((List) arrayList2, true);
        }
        if (indoorFragment.shouldCheckRateUsAndWelcomeHome) {
            indoorFragment.shouldCheckRateUsAndWelcomeHome = false;
            indoorFragment.getViewModel().runWhAndRateUsLogic(list, new IndoorFragment$$ExternalSyntheticLambda11(indoorFragment), (Function0<Unit>) null);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$17$lambda$16(IndoorFragment indoorFragment) {
        indoorFragment.showHelpUsImprove(AmplitudeEventKt.TRIGGER_T1);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$18(IndoorFragment indoorFragment, List list) {
        Intrinsics.checkNotNull(list);
        indoorFragment.showDstPrompt(list, false);
        return Unit.INSTANCE;
    }

    public final void connectDevice() {
        if (getViewModel().isUserLoggedIn()) {
            Actions actions = Actions.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            startActivityForResult(actions.openAddDeviceIntent(requireContext), REQUEST_CODE_CONNECT_PRODUCT);
            return;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = this.launcherConnectDevice;
        Actions actions2 = Actions.INSTANCE;
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
        activityResultLauncher.launch(Actions.openWelcomeIntent$default(actions2, requireContext2, false, 2, (Object) null));
    }

    private final boolean isBluetoothEnabled() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    private final void showHelpUsImprove(String str) {
        RateUsDialogFragment.Companion.newInstance(getViewModel().isInChina(), str).show(getChildFragmentManager(), "RateUs");
    }

    private final void requestInAppReview() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            GooglePlayAppReviewSdk.INSTANCE.createAppReviewManager(activity).requestInAppReview(new IndoorFragment$$ExternalSyntheticLambda0(getAnalytics()));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit requestInAppReview$lambda$20$lambda$19(AnalyticsService analyticsService) {
        analyticsService.amplitudeLog((AmplitudeEvent) new InAppReviewEvent());
        return Unit.INSTANCE;
    }

    private final void showDstPrompt(List<String> list, boolean z) {
        List<String> list2 = list;
        boolean z2 = z;
        Timber.Forest forest = Timber.Forest;
        forest.d("showDstPrompt: " + list2 + ", " + z2, new Object[0]);
        if (!z2) {
            this.initialSetupCallFinished = true;
            DialogFragment blockerDialog = getBlockerDialog();
            if (blockerDialog != null) {
                blockerDialog.dismiss();
            }
        }
        if (!list2.isEmpty()) {
            if (getViewModel().getHasConfirmedDstPromptDialog()) {
                IndoorViewModel viewModel2 = getViewModel();
                TimeZone timeZone = TimeZone.getDefault();
                Intrinsics.checkNotNullExpressionValue(timeZone, "getDefault(...)");
                viewModel2.ensureDeviceTimezone(list2, timeZone, requireContext());
                return;
            }
            TimezoneUtils timezoneUtils = TimezoneUtils.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            TimeZone timeZone2 = TimeZone.getDefault();
            Intrinsics.checkNotNullExpressionValue(timeZone2, "getDefault(...)");
            TimeZone ensureValidTimezone = timezoneUtils.ensureValidTimezone(requireContext, timeZone2);
            int i = ensureValidTimezone.inDaylightTime(new Date()) ? R.string.dst_prompt_dialog_content_in_dst : R.string.dst_prompt_dialog_content_not_in_dst;
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
                ConfirmationDialogLeftAligned newInstance$default = ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.dst_prompt_dialog_title, (Integer) null, i, Integer.valueOf(R.string.confirm), (Integer) null, false, false, false, false, (String[]) null, (String) null, new IndoorFragment$$ExternalSyntheticLambda3(this, z2, ensureValidTimezone), 2016, (Object) null);
                newInstance$default.setCancelable(false);
                newInstance$default.setViewBinder(new IndoorFragment$$ExternalSyntheticLambda4(newInstance$default, ensureValidTimezone));
                newInstance$default.show(childFragmentManager, "ConfirmationDialogLeftAligned");
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Unit showDstPrompt$lambda$28$lambda$25(IndoorFragment indoorFragment, boolean z, TimeZone timeZone, boolean z2) {
        TimeZone timeZone2 = timeZone;
        if (z2) {
            indoorFragment.getViewModel().setHasConfirmedDstPromptDialog(true);
            IndoorFragment indoorFragment2 = indoorFragment;
            if (!z || indoorFragment2.initialSetupCallFinished) {
                List value = indoorFragment2.getViewModel().getNullTimezoneDeviceIdList().getValue();
                if (value != null && !value.isEmpty()) {
                    indoorFragment2.getViewModel().ensureDeviceTimezone(value, timeZone2, (Context) null);
                }
                if (!Intrinsics.areEqual((Object) timeZone2, (Object) TimeZone.getDefault())) {
                    int i = timeZone2.useDaylightTime() ? R.string.dst_prompt_dialog_content_timezone_not_found_dst : R.string.dst_prompt_dialog_content_timezone_not_found_not_dst;
                    FragmentManager childFragmentManager = indoorFragment2.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                    Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
                    Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
                    if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
                        ConfirmationDialogLeftAligned.Companion companion = ConfirmationDialogLeftAligned.Companion;
                        int i2 = R.string.prompt;
                        Integer valueOf = Integer.valueOf(R.string.close);
                        String id = timeZone2.getID();
                        Intrinsics.checkNotNullExpressionValue(id, "getID(...)");
                        ConfirmationDialogLeftAligned.Companion.newInstance$default(companion, i2, (Integer) null, i, valueOf, (Integer) null, false, false, false, false, new String[]{id}, (String) null, (Function1) null, 3552, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
                    }
                }
            } else {
                FragmentManager childFragmentManager2 = indoorFragment2.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
                Class<BlockerDialogFragment> cls2 = BlockerDialogFragment.class;
                Intrinsics.checkNotNullExpressionValue("BlockerDialogFragment", "getSimpleName(...)");
                if (!(childFragmentManager2.findFragmentByTag("BlockerDialogFragment") instanceof BlockerDialogFragment) && !childFragmentManager2.isStateSaved()) {
                    BlockerDialogFragment blockerDialogFragment = new BlockerDialogFragment();
                    blockerDialogFragment.setCancelable(false);
                    blockerDialogFragment.show(childFragmentManager2, "BlockerDialogFragment");
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit showDstPrompt$lambda$28$lambda$27$lambda$26(ConfirmationDialogLeftAligned confirmationDialogLeftAligned, TimeZone timeZone, TextView textView, TextView textView2, TextView textView3, MaterialButton materialButton, MaterialButton materialButton2) {
        Intrinsics.checkNotNullParameter(textView, "title");
        Intrinsics.checkNotNullParameter(textView2, "subTitle");
        Intrinsics.checkNotNullParameter(textView3, "body");
        Intrinsics.checkNotNullParameter(materialButton, "positiveBtn");
        Intrinsics.checkNotNullParameter(materialButton2, "negativeBtn");
        String obj = textView3.getText().toString();
        StringBuilder sb = new StringBuilder("<b>");
        TimezoneUtils timezoneUtils = TimezoneUtils.INSTANCE;
        Context requireContext = confirmationDialogLeftAligned.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        sb.append(timezoneUtils.getDisplayName(requireContext, timeZone));
        sb.append("</b>");
        Spanned fromHtml = HtmlCompat.fromHtml(StringsKt.replace$default(obj, "%s", sb.toString(), false, 4, (Object) null), 0);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(...)");
        textView3.setText(fromHtml);
        return Unit.INSTANCE;
    }

    public void onResume() {
        super.onResume();
        getViewModel().refreshDeviceList(!getHasBeenPaused() || this.forceRefresh);
        this.forceRefresh = false;
        CompositeDisposable rxSubs = getRxSubs();
        Observable<Device> throttleFirst = getDeviceSelectPublisher().throttleFirst(1, TimeUnit.SECONDS);
        Intrinsics.checkNotNullExpressionValue(throttleFirst, "throttleFirst(...)");
        rxSubs.add(RxExtensionsKt.subscribeAndLogE(throttleFirst, new IndoorFragment$$ExternalSyntheticLambda8(this)));
        CompositeDisposable rxSubs2 = getRxSubs();
        Observable<HasFanSpeed> throttleLatest = getAutoModePublisher().throttleLatest(1000, TimeUnit.MILLISECONDS);
        Intrinsics.checkNotNullExpressionValue(throttleLatest, "throttleLatest(...)");
        rxSubs2.add(RxExtensionsKt.subscribeAndLogE(throttleLatest, new IndoorFragment$$ExternalSyntheticLambda9(this)));
        CompositeDisposable rxSubs3 = getRxSubs();
        Observable<Device> throttleLatest2 = getNightModePublisher().throttleLatest(1000, TimeUnit.MILLISECONDS);
        Intrinsics.checkNotNullExpressionValue(throttleLatest2, "throttleLatest(...)");
        rxSubs3.add(RxExtensionsKt.subscribeAndLogE(throttleLatest2, new IndoorFragment$$ExternalSyntheticLambda10(this)));
        CompositeDisposable rxSubs4 = getRxSubs();
        Observable<Device> throttleLatest3 = getStandByModePublisher().throttleLatest(1000, TimeUnit.MILLISECONDS);
        Intrinsics.checkNotNullExpressionValue(throttleLatest3, "throttleLatest(...)");
        rxSubs4.add(RxExtensionsKt.subscribeAndLogE(throttleLatest3, new IndoorFragment$$ExternalSyntheticLambda12(this)));
        CompositeDisposable rxSubs5 = getRxSubs();
        Observable<Device> throttleLatest4 = getOfflineClickPublisher().throttleLatest(1000, TimeUnit.MILLISECONDS);
        Intrinsics.checkNotNullExpressionValue(throttleLatest4, "throttleLatest(...)");
        rxSubs5.add(RxExtensionsKt.subscribeAndLogE(throttleLatest4, new IndoorFragment$$ExternalSyntheticLambda13(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$29(IndoorFragment indoorFragment, Device device) {
        Intrinsics.checkNotNull(device);
        DeviceDetailsLauncher.CC.openDeviceDetails$default(indoorFragment, device, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$30(IndoorFragment indoorFragment, HasFanSpeed hasFanSpeed) {
        if (hasFanSpeed instanceof HasCombo3in1MainMode) {
            indoorFragment.getViewModel().setMainMode((HasCombo3in1MainMode) hasFanSpeed, MainMode.COOL);
        } else if (hasFanSpeed instanceof HasMode) {
            indoorFragment.getViewModel().setToMode((HasMode) hasFanSpeed, Mode.AUTO);
        } else {
            IndoorViewModel viewModel2 = indoorFragment.getViewModel();
            Intrinsics.checkNotNull(hasFanSpeed);
            viewModel2.autoModeChanged(hasFanSpeed, hasFanSpeed.getAutoMode());
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$31(IndoorFragment indoorFragment, Device device) {
        if (device instanceof HasCombo3in1MainMode) {
            indoorFragment.getViewModel().setMainMode((HasCombo3in1MainMode) device, MainMode.AirPurify);
        } else if (device instanceof HasMode) {
            indoorFragment.getViewModel().setToMode((HasMode) device, Mode.NIGHT);
        } else {
            IndoorViewModel viewModel2 = indoorFragment.getViewModel();
            Intrinsics.checkNotNull(device);
            viewModel2.g4NightModeChanged(device);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$32(IndoorFragment indoorFragment, Device device) {
        IndoorViewModel viewModel2 = indoorFragment.getViewModel();
        Intrinsics.checkNotNull(device);
        viewModel2.standByChanged(device);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$34(IndoorFragment indoorFragment, Device device) {
        FragmentManager childFragmentManager = indoorFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<TroubleshootingDialog> cls = TroubleshootingDialog.class;
        Intrinsics.checkNotNullExpressionValue(TroubleshootingDialog.REQUEST_KEY, "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag(TroubleshootingDialog.REQUEST_KEY) instanceof TroubleshootingDialog) && !childFragmentManager.isStateSaved()) {
            TroubleshootingDialog.Companion.newInstance(TroubleshootingDialog.ACTION_TYPE_DEVICE_OFFLINE, device).show(childFragmentManager, TroubleshootingDialog.REQUEST_KEY);
            childFragmentManager.executePendingTransactions();
        }
        return Unit.INSTANCE;
    }

    public void openDeviceDetails(Device device, String str) {
        DialogFragment dialogFragment;
        Intrinsics.checkNotNullParameter(device, "device");
        CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS().getViewModelStore().clear();
        UserInfoCollectionsManager.INSTANCE.addRecord(UserInfoItem.DEVICE_MAC, device.getMac(), false);
        UserInfoCollectionsManager userInfoCollectionsManager = UserInfoCollectionsManager.INSTANCE;
        UserInfoItem userInfoItem = UserInfoItem.DEVICE_SERIAL;
        userInfoCollectionsManager.addRecord(userInfoItem, device.getUid() + '_' + device.getSerial(), false);
        UserInfoCollectionsManager.addRecord$default(UserInfoCollectionsManager.INSTANCE, UserInfoItem.DEVICE_SENSOR_DATA, "", false, 4, (Object) null);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (DeviceKt.useV2UI(device)) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            String uid = device.getUid();
            if ((childFragmentManager.findFragmentByTag(uid) instanceof DeviceDetailsV2DialogFragment) || childFragmentManager.isStateSaved()) {
                dialogFragment = null;
            } else {
                dialogFragment = DeviceDetailsV2DialogFragment.Companion.newInstance(device, str);
                dialogFragment.show(childFragmentManager, uid);
            }
            DeviceDetailsV2DialogFragment deviceDetailsV2DialogFragment = (DeviceDetailsV2DialogFragment) dialogFragment;
            if (deviceDetailsV2DialogFragment != null) {
                FragmentKt.setFragmentResultListener(deviceDetailsV2DialogFragment, DeviceDetailsV2DialogFragment.REQUEST_KEY_DEVICE_DETAILS_CLOSED, new IndoorFragment$$ExternalSyntheticLambda15(this));
                return;
            }
            return;
        }
        Fragment findFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag(DeviceDetailsDialogFragment.TAG);
        if (findFragmentByTag != null) {
            Intrinsics.checkNotNull(findFragmentByTag, "null cannot be cast to non-null type com.blueair.devicedetails.dialog.DeviceDetailsDialogFragment");
            ((DeviceDetailsDialogFragment) findFragmentByTag).dismiss();
        }
        DeviceDetailsDialogFragment newInstance = DeviceDetailsDialogFragment.Companion.newInstance(device, str);
        newInstance.setTargetFragment(this, REQUEST_CODE_DEVICE_DETAILS_DIALOG_CLOSED);
        newInstance.show(activity.getSupportFragmentManager(), DeviceDetailsDialogFragment.TAG);
    }

    /* access modifiers changed from: private */
    public static final Unit openDeviceDetails$lambda$38$lambda$36(IndoorFragment indoorFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "data");
        indoorFragment.handleDeviceDetailsDialogClosed();
        return Unit.INSTANCE;
    }

    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.forceRefresh = this.forceRefresh || i == REQUEST_CODE_CONNECT_PRODUCT;
        if (i == REQUEST_CODE_DEVICE_DETAILS_DIALOG_CLOSED) {
            handleDeviceDetailsDialogClosed();
        }
    }

    private final void handleDeviceDetailsDialogClosed() {
        if (getViewModel().shouldShowRateUsT2()) {
            showHelpUsImprove(AmplitudeEventKt.TRIGGER_T2);
        } else if (getViewModel().shouldShowRateUsT3()) {
            showHelpUsImprove(AmplitudeEventKt.TRIGGER_T3);
        }
        if (Intrinsics.areEqual((Object) getViewModel().getNetworkAvailable().getValue(), (Object) false)) {
            getNetworkSnack().show();
        }
    }

    public void onDestroy() {
        clearProgressFragment();
        super.onDestroy();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/blueair/android/fragment/IndoorFragment$Companion;", "", "<init>", "()V", "REQUEST_CODE_ENABLE_BT", "", "REQUEST_BLE_DELTA_MILLIS", "BLUEAIR_URL", "", "REQUEST_CODE_CONNECT_PRODUCT", "getREQUEST_CODE_CONNECT_PRODUCT", "()I", "REQUEST_CODE_DEVICE_DETAILS_DIALOG_CLOSED", "getREQUEST_CODE_DEVICE_DETAILS_DIALOG_CLOSED", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorFragment.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getREQUEST_CODE_CONNECT_PRODUCT() {
            return IndoorFragment.REQUEST_CODE_CONNECT_PRODUCT;
        }

        public final int getREQUEST_CODE_DEVICE_DETAILS_DIALOG_CLOSED() {
            return IndoorFragment.REQUEST_CODE_DEVICE_DETAILS_DIALOG_CLOSED;
        }
    }
}
