package com.blueair.devicedetails.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Brightness;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasSafetySwitch;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.model.SmartSubMode;
import com.blueair.core.model.TimerState;
import com.blueair.core.service.AnalyticsService;
import com.blueair.devicedetails.adapter.DeviceAttributesAdapter;
import com.blueair.devicedetails.databinding.FragmentDeviceAttributesBinding;
import com.blueair.devicedetails.dialog.DeviceFanPresetDialogFragment;
import com.blueair.devicedetails.dialog.DeviceFilterPageDialogFragment;
import com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment;
import com.blueair.devicedetails.dialog.DeviceOscillationSettingsDialogFragment;
import com.blueair.devicedetails.dialog.DeviceSetTimezoneDialogFragment;
import com.blueair.devicedetails.util.AttributeAction;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.PopupInfoDialogFragment;
import com.blueair.viewcore.dialog.TroubleshootingDialog;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.snackbar.Snackbar;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import io.flatcircle.connectivityhelper.NetUtil;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
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

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 H2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001HB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\n\u00106\u001a\u0004\u0018\u000107H\u0016J$\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u001a\u0010@\u001a\u0002032\u0006\u0010A\u001a\u0002092\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010B\u001a\u000203H\u0016J\u0010\u0010C\u001a\u0002052\u0006\u0010D\u001a\u00020\u001fH\u0002J\u001e\u0010E\u001a\u0002032\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010F\u001a\b\u0012\u0004\u0012\u0002030GH\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R%\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0'8BX\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u001b\u0010-\u001a\u00020.8BX\u0002¢\u0006\f\n\u0004\b1\u0010\u000b\u001a\u0004\b/\u00100¨\u0006I"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceAttributesFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "<init>", "()V", "networkSnack", "Lcom/google/android/material/snackbar/Snackbar;", "getNetworkSnack", "()Lcom/google/android/material/snackbar/Snackbar;", "networkSnack$delegate", "Lkotlin/Lazy;", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "getAnalyticsService", "()Lcom/blueair/core/service/AnalyticsService;", "analyticsService$delegate", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "deviceAttributesBinding", "Lcom/blueair/devicedetails/databinding/FragmentDeviceAttributesBinding;", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "actionType", "", "attributeActionPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/devicedetails/util/AttributeAction;", "getAttributeActionPublisher", "()Lio/reactivex/subjects/PublishSubject;", "attributeActionPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceAttributesAdapter;", "getAdapter", "()Lcom/blueair/devicedetails/adapter/DeviceAttributesAdapter;", "adapter$delegate", "showProgress", "", "shouldShowProgress", "", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "hasDeviceAttributesChanged", "liveDevice", "shouldDoDbAndApiCall", "call", "Lkotlin/Function0;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAttributesFragment.kt */
public final class DeviceAttributesFragment extends BaseFragment<DeviceDetailsViewModel> implements ProgressFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_ACTION_TYPE = "key_action_type";
    public static final String KEY_DEVICE = "key_device";
    public static final long THROTTLE_LONG_MILLISECONDS = 1000;
    public static final long THROTTLE_SHORT_MILLISECONDS = 300;
    private String actionType;
    private final Lazy adapter$delegate;
    private final Lazy analyticsService$delegate;
    private final LazyPublishSubject attributeActionPublisher$delegate;
    private Device device;
    private FragmentDeviceAttributesBinding deviceAttributesBinding;
    private final Lazy networkSnack$delegate = LazyKt.lazy(new DeviceAttributesFragment$$ExternalSyntheticLambda1(this));
    private ProgressBlockerView progressBlockerView;
    public DeviceDetailsViewModel viewModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttributesFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|5|6|(2:7|8)|9|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0019 */
        static {
            /*
                com.blueair.core.model.MainMode[] r0 = com.blueair.core.model.MainMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.blueair.core.model.MainMode r2 = com.blueair.core.model.MainMode.COOL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.blueair.core.model.MainMode r3 = com.blueair.core.model.MainMode.AirPurify     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.MainMode r3 = com.blueair.core.model.MainMode.HEAT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r4 = 3
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                com.blueair.core.model.ApSubMode[] r0 = com.blueair.core.model.ApSubMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.ApSubMode r3 = com.blueair.core.model.ApSubMode.AUTO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.blueair.core.model.ApSubMode r1 = com.blueair.core.model.ApSubMode.ECO     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.fragment.DeviceAttributesFragment.WhenMappings.<clinit>():void");
        }
    }

    static {
        Class<DeviceAttributesFragment> cls = DeviceAttributesFragment.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "analyticsService", "getAnalyticsService()Lcom/blueair/core/service/AnalyticsService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "attributeActionPublisher", "getAttributeActionPublisher()Lio/reactivex/subjects/PublishSubject;", 0))};
    }

    public DeviceAttributesFragment() {
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new DeviceAttributesFragment$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.analyticsService$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, AnalyticsService.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
        this.attributeActionPublisher$delegate = new LazyPublishSubject();
        this.adapter$delegate = LazyKt.lazy(new DeviceAttributesFragment$$ExternalSyntheticLambda2(this));
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

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceAttributesFragment$Companion;", "", "<init>", "()V", "KEY_DEVICE", "", "KEY_ACTION_TYPE", "THROTTLE_SHORT_MILLISECONDS", "", "THROTTLE_LONG_MILLISECONDS", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceAttributesFragment;", "device", "Lcom/blueair/core/model/Device;", "actionType", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttributesFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DeviceAttributesFragment newInstance$default(Companion companion, Device device, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.newInstance(device, str);
        }

        public final DeviceAttributesFragment newInstance(Device device, String str) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeviceAttributesFragment deviceAttributesFragment = new DeviceAttributesFragment();
            deviceAttributesFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(DeviceAttributesFragment.KEY_DEVICE, device), TuplesKt.to(DeviceAttributesFragment.KEY_ACTION_TYPE, str)));
            return deviceAttributesFragment;
        }
    }

    private final Snackbar getNetworkSnack() {
        return (Snackbar) this.networkSnack$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Snackbar networkSnack_delegate$lambda$0(DeviceAttributesFragment deviceAttributesFragment) {
        FragmentDeviceAttributesBinding fragmentDeviceAttributesBinding = deviceAttributesFragment.deviceAttributesBinding;
        if (fragmentDeviceAttributesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceAttributesBinding");
            fragmentDeviceAttributesBinding = null;
        }
        return Snackbar.make((View) fragmentDeviceAttributesBinding.getRoot(), (CharSequence) deviceAttributesFragment.getString(R.string.connection_lost), -2);
    }

    private final AnalyticsService getAnalyticsService() {
        return (AnalyticsService) this.analyticsService$delegate.getValue();
    }

    public DeviceDetailsViewModel getViewModel() {
        DeviceDetailsViewModel deviceDetailsViewModel = this.viewModel;
        if (deviceDetailsViewModel != null) {
            return deviceDetailsViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(DeviceDetailsViewModel deviceDetailsViewModel) {
        Intrinsics.checkNotNullParameter(deviceDetailsViewModel, "<set-?>");
        this.viewModel = deviceDetailsViewModel;
    }

    public ProgressBlockerView getProgressBlockerView() {
        return this.progressBlockerView;
    }

    public void setProgressBlockerView(ProgressBlockerView progressBlockerView2) {
        this.progressBlockerView = progressBlockerView2;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final void setDevice(Device device2) {
        this.device = device2;
    }

    private final PublishSubject<AttributeAction<?>> getAttributeActionPublisher() {
        return this.attributeActionPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[1]);
    }

    /* access modifiers changed from: private */
    public static final DeviceAttributesAdapter adapter_delegate$lambda$1(DeviceAttributesFragment deviceAttributesFragment) {
        return new DeviceAttributesAdapter(deviceAttributesFragment.getAttributeActionPublisher());
    }

    /* access modifiers changed from: private */
    public final DeviceAttributesAdapter getAdapter() {
        return (DeviceAttributesAdapter) this.adapter$delegate.getValue();
    }

    public void showProgress(boolean z) {
        ProgressFragment.CC.showProgress$default(this, getContext(), z, (Integer) null, 4, (Object) null);
    }

    public ConstraintLayout getRootView() {
        FragmentDeviceAttributesBinding fragmentDeviceAttributesBinding = this.deviceAttributesBinding;
        if (fragmentDeviceAttributesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceAttributesBinding");
            fragmentDeviceAttributesBinding = null;
        }
        return fragmentDeviceAttributesBinding.layoutMain;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentDeviceAttributesBinding inflate = FragmentDeviceAttributesBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.deviceAttributesBinding = inflate;
        setViewModel((DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DeviceDetailsViewModel.class)));
        Bundle arguments = getArguments();
        FragmentDeviceAttributesBinding fragmentDeviceAttributesBinding = null;
        this.device = arguments != null ? (Device) arguments.getParcelable(KEY_DEVICE) : null;
        Bundle arguments2 = getArguments();
        this.actionType = arguments2 != null ? arguments2.getString(KEY_ACTION_TYPE) : null;
        Device device2 = this.device;
        if (device2 != null) {
            getViewModel().setDeviceId(device2.getUid());
        }
        FragmentDeviceAttributesBinding fragmentDeviceAttributesBinding2 = this.deviceAttributesBinding;
        if (fragmentDeviceAttributesBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceAttributesBinding");
            fragmentDeviceAttributesBinding2 = null;
        }
        RecyclerView.ItemAnimator itemAnimator = fragmentDeviceAttributesBinding2.recyclerViewAttributes.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        FragmentDeviceAttributesBinding fragmentDeviceAttributesBinding3 = this.deviceAttributesBinding;
        if (fragmentDeviceAttributesBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceAttributesBinding");
            fragmentDeviceAttributesBinding3 = null;
        }
        fragmentDeviceAttributesBinding3.recyclerViewAttributes.setAdapter(getAdapter());
        FragmentDeviceAttributesBinding fragmentDeviceAttributesBinding4 = this.deviceAttributesBinding;
        if (fragmentDeviceAttributesBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceAttributesBinding");
        } else {
            fragmentDeviceAttributesBinding = fragmentDeviceAttributesBinding4;
        }
        ConstraintLayout root = fragmentDeviceAttributesBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        LiveData<Device> liveDevice = getViewModel().getLiveDevice();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(liveDevice, viewLifecycleOwner, new DeviceAttributesFragment$$ExternalSyntheticLambda5(this));
        LiveData<Boolean> networkAvailable = getViewModel().getNetworkAvailable();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(networkAvailable, viewLifecycleOwner2, new DeviceAttributesFragment$$ExternalSyntheticLambda6(this));
        getViewModel().getAutoModeFirstClicked().observe(getViewLifecycleOwner(), new DeviceAttributesFragment$sam$androidx_lifecycle_Observer$0(new DeviceAttributesFragment$$ExternalSyntheticLambda7(this)));
        if (this.device instanceof HasSensorData) {
            getViewModel().getLiveLatestDataPoint().observe(getViewLifecycleOwner(), new DeviceAttributesFragment$sam$androidx_lifecycle_Observer$0(new DeviceAttributesFragment$$ExternalSyntheticLambda8(this)));
        }
        Device device2 = this.device;
        if (device2 != null && DeviceKt.supportDisinfection(device2)) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new DeviceAttributesFragment$onViewCreated$5(this, (Continuation<? super DeviceAttributesFragment$onViewCreated$5>) null), 3, (Object) null);
        }
        if (this.device instanceof HasTimer) {
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new DeviceAttributesFragment$onViewCreated$6(this, (Continuation<? super DeviceAttributesFragment$onViewCreated$6>) null), 3, (Object) null);
        }
        if (this.device instanceof HasWick) {
            Job unused3 = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new DeviceAttributesFragment$onViewCreated$7(this, (Continuation<? super DeviceAttributesFragment$onViewCreated$7>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(DeviceAttributesFragment deviceAttributesFragment, Device device2) {
        Intrinsics.checkNotNull(device2);
        if (deviceAttributesFragment.hasDeviceAttributesChanged(device2)) {
            deviceAttributesFragment.getAdapter().setDevice(device2);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$4(DeviceAttributesFragment deviceAttributesFragment, boolean z) {
        if (z) {
            deviceAttributesFragment.getNetworkSnack().dismiss();
            deviceAttributesFragment.getAdapter().setForceOffline(false);
        } else {
            deviceAttributesFragment.getNetworkSnack().show();
            deviceAttributesFragment.getAdapter().setForceOffline(true);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$6(DeviceAttributesFragment deviceAttributesFragment, Boolean bool) {
        if (bool.booleanValue()) {
            FragmentManager childFragmentManager = deviceAttributesFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
                ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.humidity_target, (Integer) null, deviceAttributesFragment.device instanceof DeviceCombo2in1 ? R.string.prompt_target_humidity_2in1 : R.string.prompt_target_humidity, Integer.valueOf(R.string.snackbar_ok), (Integer) null, false, false, false, true, (String[]) null, (String) null, (Function1) null, 3808, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$7(DeviceAttributesFragment deviceAttributesFragment, IndoorDatapoint indoorDatapoint) {
        Timber.Forest forest = Timber.Forest;
        forest.d("liveLatestDataPoint = " + indoorDatapoint, new Object[0]);
        deviceAttributesFragment.getAdapter().setLatestDatapoint(indoorDatapoint);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0059, code lost:
        if (r0.equals(com.blueair.push.NotificationService.ACTION_TYPE_FILTER) == false) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0062, code lost:
        if (r0.equals(com.blueair.push.NotificationService.ACTION_TYPE_FILTER_PURCHASE) != false) goto L_0x0064;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
            r5 = this;
            super.onResume()
            io.reactivex.disposables.CompositeDisposable r0 = r5.getRxSubs()
            io.reactivex.subjects.PublishSubject r1 = r5.getAttributeActionPublisher()
            r2 = 300(0x12c, double:1.48E-321)
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            io.reactivex.Observable r1 = r1.throttleLatest(r2, r4)
            java.lang.String r2 = "throttleLatest(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.blueair.devicedetails.fragment.DeviceAttributesFragment$$ExternalSyntheticLambda3 r2 = new com.blueair.devicedetails.fragment.DeviceAttributesFragment$$ExternalSyntheticLambda3
            r2.<init>(r5)
            io.reactivex.disposables.Disposable r1 = com.jacquessmuts.rxextensions.RxExtensionsKt.subscribeAndLogE(r1, r2)
            r0.add(r1)
            java.lang.String r0 = r5.actionType
            if (r0 == 0) goto L_0x0070
            int r1 = r0.hashCode()
            r2 = -2123968024(0xffffffff8166d1e8, float:-4.2394929E-38)
            r3 = 0
            if (r1 == r2) goto L_0x005c
            r2 = -1274492040(0xffffffffb408cb78, float:-1.2740009E-7)
            if (r1 == r2) goto L_0x0053
            r2 = 590772454(0x233678e6, float:9.891841E-18)
            if (r1 == r2) goto L_0x003d
            goto L_0x0070
        L_0x003d:
            java.lang.String r1 = "wick_purchase"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0046
            goto L_0x0070
        L_0x0046:
            io.reactivex.subjects.PublishSubject r0 = r5.getAttributeActionPublisher()
            com.blueair.devicedetails.util.AttributeAction$OpenWickPageAction r1 = new com.blueair.devicedetails.util.AttributeAction$OpenWickPageAction
            r1.<init>(r3)
            r0.onNext(r1)
            goto L_0x0070
        L_0x0053:
            java.lang.String r1 = "filter"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0064
            goto L_0x0070
        L_0x005c:
            java.lang.String r1 = "filter_purchase"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0070
        L_0x0064:
            io.reactivex.subjects.PublishSubject r0 = r5.getAttributeActionPublisher()
            com.blueair.devicedetails.util.AttributeAction$OpenFilterPageAction r1 = new com.blueair.devicedetails.util.AttributeAction$OpenFilterPageAction
            r1.<init>(r3)
            r0.onNext(r1)
        L_0x0070:
            r0 = 0
            r5.actionType = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.fragment.DeviceAttributesFragment.onResume():void");
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$28(DeviceAttributesFragment deviceAttributesFragment, AttributeAction attributeAction) {
        Timber.Forest forest = Timber.Forest;
        forest.v("throttleLatest action: " + attributeAction, new Object[0]);
        Device device2 = deviceAttributesFragment.getAdapter().getDevice();
        if (device2 == null) {
            device2 = deviceAttributesFragment.device;
        }
        if (device2 != null) {
            deviceAttributesFragment.shouldDoDbAndApiCall(device2, new DeviceAttributesFragment$$ExternalSyntheticLambda4(attributeAction, device2, deviceAttributesFragment));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$28$lambda$27$lambda$26(AttributeAction attributeAction, Device device2, DeviceAttributesFragment deviceAttributesFragment) {
        DialogFragment dialogFragment;
        AttributeAction attributeAction2 = attributeAction;
        Device device3 = device2;
        if (attributeAction2 instanceof AttributeAction.FanSpeedAction) {
            if (device3 instanceof HasCombo3in1MainMode) {
                int serverValue = ((FanSpeedEnum) ((AttributeAction.FanSpeedAction) attributeAction2).getValue()).toServerValue((HasFanSpeed) device3);
                int i = WhenMappings.$EnumSwitchMapping$0[((HasMainMode) device3).mainMode().ordinal()];
                if (i == 1) {
                    deviceAttributesFragment.getViewModel().setCoolFanSpeed(device3, serverValue);
                } else if (i == 2) {
                    deviceAttributesFragment.getViewModel().setApFanSpeed(device3, serverValue);
                } else if (i != 3) {
                    Unit unit = Unit.INSTANCE;
                } else {
                    deviceAttributesFragment.getViewModel().setHeatFanSpeed(device3, serverValue);
                }
            } else {
                deviceAttributesFragment.getViewModel().fanspeedSliderChanged(device3, (FanSpeedEnum) ((AttributeAction.FanSpeedAction) attributeAction2).getValue());
            }
        } else if (attributeAction2 instanceof AttributeAction.AutoModeAction) {
            deviceAttributesFragment.getViewModel().autoModeChanged(device3, ((Boolean) ((AttributeAction.AutoModeAction) attributeAction2).getValue()).booleanValue());
        } else {
            DialogFragment dialogFragment2 = null;
            if (attributeAction2 instanceof AttributeAction.AutoRhInfoAction) {
                FragmentManager childFragmentManager = deviceAttributesFragment.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                Class<PopupInfoDialogFragment> cls = PopupInfoDialogFragment.class;
                Intrinsics.checkNotNullExpressionValue("PopupInfoDialogFragment", "getSimpleName(...)");
                if (!(childFragmentManager.findFragmentByTag("PopupInfoDialogFragment") instanceof PopupInfoDialogFragment) && !childFragmentManager.isStateSaved()) {
                    PopupInfoDialogFragment.Companion.newInstance(R.string.humidity_target, (Integer) null, device3 instanceof DeviceCombo2in1 ? R.string.target_humidity_info_2in1 : R.string.target_humidity_info).show(childFragmentManager, "PopupInfoDialogFragment");
                }
            } else if (attributeAction2 instanceof AttributeAction.AutoRhAction) {
                deviceAttributesFragment.getViewModel().autorhChanged(device3, ((Number) ((AttributeAction.AutoRhAction) attributeAction2).getValue()).intValue());
            } else if (attributeAction2 instanceof AttributeAction.BrightnessAction) {
                deviceAttributesFragment.getViewModel().brightnessChanged(device3, (Brightness) ((AttributeAction.BrightnessAction) attributeAction2).getValue());
            } else if (attributeAction2 instanceof AttributeAction.BrightnessPercentageAction) {
                deviceAttributesFragment.getViewModel().brightnessChanged(device3, ((Number) ((AttributeAction.BrightnessPercentageAction) attributeAction2).getValue()).intValue());
            } else if (Intrinsics.areEqual((Object) attributeAction2, (Object) AttributeAction.ChildLockAction.INSTANCE)) {
                deviceAttributesFragment.getViewModel().childLockChanged(device3);
            } else if (Intrinsics.areEqual((Object) attributeAction2, (Object) AttributeAction.DisinfectionModeAction.INSTANCE)) {
                deviceAttributesFragment.getViewModel().disinfectionChanged(device3);
            } else if (Intrinsics.areEqual((Object) attributeAction2, (Object) AttributeAction.EcoModeAction.INSTANCE)) {
                deviceAttributesFragment.getViewModel().ecoModeChanged(device3);
            } else if (Intrinsics.areEqual((Object) attributeAction2, (Object) AttributeAction.GsnmSwitchAction.INSTANCE)) {
                deviceAttributesFragment.getViewModel().gsnmChanged(device3);
            } else if (Intrinsics.areEqual((Object) attributeAction2, (Object) AttributeAction.ManualModeAction.INSTANCE)) {
                deviceAttributesFragment.getViewModel().setManualMode(device3);
            } else if (Intrinsics.areEqual((Object) attributeAction2, (Object) AttributeAction.NightModeAction.INSTANCE)) {
                deviceAttributesFragment.getViewModel().g4NightModeChanged(device3);
            } else if (Intrinsics.areEqual((Object) attributeAction2, (Object) AttributeAction.OpenDisinfectionInfoAction.INSTANCE)) {
                FragmentManager childFragmentManager2 = deviceAttributesFragment.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
                Class<ConfirmationDialogLeftAligned> cls2 = ConfirmationDialogLeftAligned.class;
                Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
                if (!(childFragmentManager2.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager2.isStateSaved()) {
                    ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.disinfection, (Integer) null, R.string.disinfection_description, Integer.valueOf(R.string.close), (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 4032, (Object) null).show(childFragmentManager2, "ConfirmationDialogLeftAligned");
                }
            } else if (attributeAction2 instanceof AttributeAction.OpenFilterInfoAction) {
                FragmentManager childFragmentManager3 = deviceAttributesFragment.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager3, "getChildFragmentManager(...)");
                Class<PopupInfoDialogFragment> cls3 = PopupInfoDialogFragment.class;
                Intrinsics.checkNotNullExpressionValue("PopupInfoDialogFragment", "getSimpleName(...)");
                if (!(childFragmentManager3.findFragmentByTag("PopupInfoDialogFragment") instanceof PopupInfoDialogFragment) && !childFragmentManager3.isStateSaved()) {
                    PopupInfoDialogFragment.Companion.newInstance(R.string.filter_status, Integer.valueOf(R.string.filter_maintenance), ((device3 instanceof DeviceNewClassic) || (device3 instanceof DevicePet20)) ? R.string.filter_maintenance_description_nc : R.string.filter_maintenance_description).show(childFragmentManager3, "PopupInfoDialogFragment");
                }
            } else if (!(attributeAction2 instanceof AttributeAction.OpenFilterPageAction)) {
                AttributeAction attributeAction3 = attributeAction2;
                if (Intrinsics.areEqual((Object) attributeAction3, (Object) AttributeAction.OpenGermShieldInfoAction.INSTANCE)) {
                    FragmentManager childFragmentManager4 = deviceAttributesFragment.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager4, "getChildFragmentManager(...)");
                    Class<ConfirmationDialogLeftAligned> cls4 = ConfirmationDialogLeftAligned.class;
                    Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
                    if (!(childFragmentManager4.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager4.isStateSaved()) {
                        ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.germ_shield_plus, (Integer) null, R.string.germ_shield_plus_mode_description, Integer.valueOf(R.string.close), (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 4032, (Object) null).show(childFragmentManager4, "ConfirmationDialogLeftAligned");
                    }
                } else if (Intrinsics.areEqual((Object) attributeAction3, (Object) AttributeAction.StandbyModeAction.INSTANCE)) {
                    deviceAttributesFragment.getViewModel().standByChanged(device3);
                } else if (Intrinsics.areEqual((Object) attributeAction3, (Object) AttributeAction.TimeZoneAction.INSTANCE)) {
                    FragmentManager childFragmentManager5 = deviceAttributesFragment.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager5, "getChildFragmentManager(...)");
                    Class<DeviceSetTimezoneDialogFragment> cls5 = DeviceSetTimezoneDialogFragment.class;
                    Intrinsics.checkNotNullExpressionValue("DeviceSetTimezoneDialogFragment", "getSimpleName(...)");
                    if (!(childFragmentManager5.findFragmentByTag("DeviceSetTimezoneDialogFragment") instanceof DeviceSetTimezoneDialogFragment) && !childFragmentManager5.isStateSaved()) {
                        DeviceSetTimezoneDialogFragment.Companion.newInstance(device3).show(childFragmentManager5, "DeviceSetTimezoneDialogFragment");
                    }
                } else if (Intrinsics.areEqual((Object) attributeAction3, (Object) AttributeAction.TroubleShootAction.INSTANCE)) {
                    FragmentManager childFragmentManager6 = deviceAttributesFragment.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager6, "getChildFragmentManager(...)");
                    Class<TroubleshootingDialog> cls6 = TroubleshootingDialog.class;
                    Intrinsics.checkNotNullExpressionValue(TroubleshootingDialog.REQUEST_KEY, "getSimpleName(...)");
                    if (!(childFragmentManager6.findFragmentByTag(TroubleshootingDialog.REQUEST_KEY) instanceof TroubleshootingDialog) && !childFragmentManager6.isStateSaved()) {
                        TroubleshootingDialog.Companion.newInstance(TroubleshootingDialog.ACTION_TYPE_DEVICE_OFFLINE, device3).show(childFragmentManager6, TroubleshootingDialog.REQUEST_KEY);
                        childFragmentManager6.executePendingTransactions();
                    }
                    deviceAttributesFragment.getAnalyticsService().event(new AnalyticEvent.TAP_TROUBLESHOOTING());
                    Unit unit2 = Unit.INSTANCE;
                } else if (Intrinsics.areEqual((Object) attributeAction3, (Object) AttributeAction.OpenWickInfoAction.INSTANCE)) {
                    FragmentManager childFragmentManager7 = deviceAttributesFragment.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager7, "getChildFragmentManager(...)");
                    Class<PopupInfoDialogFragment> cls7 = PopupInfoDialogFragment.class;
                    Intrinsics.checkNotNullExpressionValue("PopupInfoDialogFragment", "getSimpleName(...)");
                    if (!(childFragmentManager7.findFragmentByTag("PopupInfoDialogFragment") instanceof PopupInfoDialogFragment) && !childFragmentManager7.isStateSaved()) {
                        PopupInfoDialogFragment.Companion.newInstance(R.string.wick_status, Integer.valueOf(R.string.wick_maintenance), R.string.wick_maintenance_description).show(childFragmentManager7, "PopupInfoDialogFragment");
                    }
                } else if (attributeAction3 instanceof AttributeAction.OpenWickPageAction) {
                    FragmentManager parentFragmentManager = deviceAttributesFragment.getParentFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
                    Class<DeviceNFilterDialogFragment> cls8 = DeviceNFilterDialogFragment.class;
                    Intrinsics.checkNotNullExpressionValue("DeviceNFilterDialogFragment", "getSimpleName(...)");
                    if (!(parentFragmentManager.findFragmentByTag("DeviceNFilterDialogFragment") instanceof DeviceNFilterDialogFragment) && !parentFragmentManager.isStateSaved()) {
                        DeviceNFilterDialogFragment.Companion.newInstance$default(DeviceNFilterDialogFragment.Companion, device3, (String) null, DeviceFilterType.WICK, ((Boolean) ((AttributeAction.OpenWickPageAction) attributeAction3).getValue()).booleanValue(), false, 16, (Object) null).show(parentFragmentManager, "DeviceNFilterDialogFragment");
                    }
                } else if (attributeAction3 instanceof AttributeAction.OpenTimerInfoAction) {
                    FragmentManager childFragmentManager8 = deviceAttributesFragment.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager8, "getChildFragmentManager(...)");
                    Class<PopupInfoDialogFragment> cls9 = PopupInfoDialogFragment.class;
                    Intrinsics.checkNotNullExpressionValue("PopupInfoDialogFragment", "getSimpleName(...)");
                    if (!(childFragmentManager8.findFragmentByTag("PopupInfoDialogFragment") instanceof PopupInfoDialogFragment) && !childFragmentManager8.isStateSaved()) {
                        PopupInfoDialogFragment.Companion.newInstance(R.string.timer, (Integer) null, R.string.timer_description).show(childFragmentManager8, "PopupInfoDialogFragment");
                    }
                } else if (attributeAction3 instanceof AttributeAction.TimerStateAction) {
                    deviceAttributesFragment.getViewModel().timerStatusChanged(device3, ((TimerState) ((AttributeAction.TimerStateAction) attributeAction3).getValue()).getValue());
                } else if (attributeAction3 instanceof AttributeAction.TimerDurationAction) {
                    deviceAttributesFragment.getViewModel().timerDurationChanged(device3, ((Number) ((AttributeAction.TimerDurationAction) attributeAction3).getValue()).intValue());
                } else if (attributeAction3 instanceof AttributeAction.OpenDryModeInfoAction) {
                    FragmentManager childFragmentManager9 = deviceAttributesFragment.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager9, "getChildFragmentManager(...)");
                    Class<DialogFragment> cls10 = DialogFragment.class;
                    Intrinsics.checkNotNullExpressionValue("DialogFragment", "getSimpleName(...)");
                    if (!(childFragmentManager9.findFragmentByTag("DialogFragment") instanceof DialogFragment) && !childFragmentManager9.isStateSaved()) {
                        if (device3 instanceof DeviceCombo2in1) {
                            dialogFragment = ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.dry_mode, (Integer) null, R.string.dry_mode_description_2in1_short, Integer.valueOf(R.string.add_device_success_btn_okay), (Integer) null, false, false, false, true, (String[]) null, (String) null, (Function1) null, 3808, (Object) null);
                        } else {
                            dialogFragment = PopupInfoDialogFragment.Companion.newInstance(R.string.dry_mode, (Integer) null, R.string.dry_mode_description);
                        }
                        dialogFragment.show(childFragmentManager9, "DialogFragment");
                    }
                } else if (attributeAction3 instanceof AttributeAction.DryModeCancelAction) {
                    deviceAttributesFragment.getViewModel().wickDryCanceled(device3);
                } else if (Intrinsics.areEqual((Object) attributeAction3, (Object) AttributeAction.OscillationEnableAction.INSTANCE)) {
                    deviceAttributesFragment.getViewModel().oscillationStateChanged(device3);
                } else if (Intrinsics.areEqual((Object) attributeAction3, (Object) AttributeAction.OscillationSettingAction.INSTANCE)) {
                    FragmentManager childFragmentManager10 = deviceAttributesFragment.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager10, "getChildFragmentManager(...)");
                    Class<DeviceOscillationSettingsDialogFragment> cls11 = DeviceOscillationSettingsDialogFragment.class;
                    Intrinsics.checkNotNullExpressionValue("DeviceOscillationSettingsDialogFragment", "getSimpleName(...)");
                    if (!(childFragmentManager10.findFragmentByTag("DeviceOscillationSettingsDialogFragment") instanceof DeviceOscillationSettingsDialogFragment) && !childFragmentManager10.isStateSaved()) {
                        DeviceOscillationSettingsDialogFragment.Companion.newInstance(device3).show(childFragmentManager10, "DeviceOscillationSettingsDialogFragment");
                    }
                } else if (attributeAction3 instanceof AttributeAction.MainModeAction) {
                    deviceAttributesFragment.getViewModel().setMainMode(device3, ((MainMode) ((AttributeAction.MainModeAction) attributeAction3).getValue()).getValue());
                } else if (attributeAction3 instanceof AttributeAction.ApSubModeAction) {
                    if (device3 instanceof DevicePet20) {
                        deviceAttributesFragment.getViewModel().setApSubMode(device3, ((ApSubMode) ((AttributeAction.ApSubModeAction) attributeAction3).getValue()).getValue(), true);
                    } else if (device3 instanceof DeviceCombo3in1) {
                        int i2 = WhenMappings.$EnumSwitchMapping$0[((DeviceCombo3in1) device3).mainMode().ordinal()];
                        if (i2 == 1) {
                            deviceAttributesFragment.getViewModel().setCoolSubMode(device3, ((ApSubMode) ((AttributeAction.ApSubModeAction) attributeAction3).getValue()).getValue());
                        } else if (i2 == 2) {
                            DeviceDetailsViewModel.setApSubMode$default(deviceAttributesFragment.getViewModel(), device3, ((ApSubMode) ((AttributeAction.ApSubModeAction) attributeAction3).getValue()).getValue(), false, 4, (Object) null);
                        } else if (i2 != 3) {
                            Unit unit3 = Unit.INSTANCE;
                        } else {
                            deviceAttributesFragment.getViewModel().setHeatSubMode(device3, ((ApSubMode) ((AttributeAction.ApSubModeAction) attributeAction3).getValue()).getValue());
                        }
                    }
                    Unit unit4 = Unit.INSTANCE;
                } else if (attributeAction3 instanceof AttributeAction.SmartSubModeAction) {
                    AttributeAction.SmartSubModeAction smartSubModeAction = (AttributeAction.SmartSubModeAction) attributeAction3;
                    if (((SmartSubMode) smartSubModeAction.getValue()) == SmartSubMode.AUTO_OFF) {
                        FragmentManager childFragmentManager11 = deviceAttributesFragment.getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager11, "getChildFragmentManager(...)");
                        Class<ConfirmationDialogLeftAligned> cls12 = ConfirmationDialogLeftAligned.class;
                        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
                        if (!(childFragmentManager11.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager11.isStateSaved()) {
                            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.prompt, (Integer) null, R.string.prompt_turn_off_smart_auto, Integer.valueOf(R.string.snackbar_ok), Integer.valueOf(R.string.btn_cancel), false, false, false, true, (String[]) null, (String) null, new DeviceAttributesFragment$$ExternalSyntheticLambda0(deviceAttributesFragment, device3, attributeAction3), 1632, (Object) null).show(childFragmentManager11, "ConfirmationDialogLeftAligned");
                        }
                    } else {
                        deviceAttributesFragment.getViewModel().setSmartSubMode(device3, ((SmartSubMode) smartSubModeAction.getValue()).getValue());
                    }
                } else {
                    DeviceAttributesFragment deviceAttributesFragment2 = deviceAttributesFragment;
                    if (attributeAction3 instanceof AttributeAction.PeelingAction) {
                        deviceAttributesFragment2.getViewModel().setTare(device3);
                        FragmentManager childFragmentManager12 = deviceAttributesFragment2.getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager12, "getChildFragmentManager(...)");
                        Class<ConfirmationDialogLeftAligned> cls13 = ConfirmationDialogLeftAligned.class;
                        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
                        if (!(childFragmentManager12.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager12.isStateSaved()) {
                            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.prompt, (Integer) null, R.string.prompt_peeling_in_progress, Integer.valueOf(R.string.snackbar_ok), (Integer) null, false, false, false, true, (String[]) null, (String) null, (Function1) null, 3808, (Object) null).show(childFragmentManager12, "ConfirmationDialogLeftAligned");
                        }
                    } else if (attributeAction3 instanceof AttributeAction.TargetTemperatureAction) {
                        if (device3 instanceof HasCombo3in1MainMode) {
                            int i3 = WhenMappings.$EnumSwitchMapping$1[((HasCombo3in1MainMode) device3).currentSubMode().ordinal()];
                            if (i3 == 1) {
                                deviceAttributesFragment2.getViewModel().setHeatAutoTmp(device3, ((Number) ((AttributeAction.TargetTemperatureAction) attributeAction3).getValue()).doubleValue());
                            } else if (i3 != 2) {
                                Unit unit5 = Unit.INSTANCE;
                            } else {
                                deviceAttributesFragment2.getViewModel().setHeatEcoTmp(device3, ((Number) ((AttributeAction.TargetTemperatureAction) attributeAction3).getValue()).doubleValue());
                            }
                        }
                        Unit unit6 = Unit.INSTANCE;
                    } else if (attributeAction3 instanceof AttributeAction.OpenFanPresetPageAction) {
                        FragmentManager childFragmentManager13 = deviceAttributesFragment2.getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager13, "getChildFragmentManager(...)");
                        Class<DeviceFanPresetDialogFragment> cls14 = DeviceFanPresetDialogFragment.class;
                        Intrinsics.checkNotNullExpressionValue("DeviceFanPresetDialogFragment", "getSimpleName(...)");
                        if (!(childFragmentManager13.findFragmentByTag("DeviceFanPresetDialogFragment") instanceof DeviceFanPresetDialogFragment) && !childFragmentManager13.isStateSaved()) {
                            DeviceFanPresetDialogFragment.Companion.newInstance(device3).show(childFragmentManager13, "DeviceFanPresetDialogFragment");
                        }
                    } else if (attributeAction3 instanceof AttributeAction.OpenHinsInfoAction) {
                        FragmentManager childFragmentManager14 = deviceAttributesFragment2.getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager14, "getChildFragmentManager(...)");
                        Class<ConfirmationDialogLeftAligned> cls15 = ConfirmationDialogLeftAligned.class;
                        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
                        if (!(childFragmentManager14.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager14.isStateSaved()) {
                            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, ((Boolean) ((AttributeAction.OpenHinsInfoAction) attributeAction3).getValue()).booleanValue() ? R.string.photon_pure_night : R.string.photon_pure, (Integer) null, R.string.photon_pure_description, Integer.valueOf(R.string.close), (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 4032, (Object) null).show(childFragmentManager14, "ConfirmationDialogLeftAligned");
                        }
                    } else if (attributeAction3 instanceof AttributeAction.HinsLockAction) {
                        if (((Boolean) ((AttributeAction.HinsLockAction) attributeAction3).getValue()).booleanValue()) {
                            deviceAttributesFragment2.getViewModel().hinsNightModeChanged(device3);
                        } else {
                            deviceAttributesFragment2.getViewModel().hinsModeChanged(device3);
                        }
                    } else if (attributeAction3 instanceof AttributeAction.ModeAction) {
                        deviceAttributesFragment2.getViewModel().setMode(device3, ((Mode) ((AttributeAction.ModeAction) attributeAction3).getValue()).getValue());
                    } else if (attributeAction3 instanceof AttributeAction.HumModeAction) {
                        deviceAttributesFragment2.getViewModel().humModeChanged(device3);
                    } else {
                        Unit unit7 = Unit.INSTANCE;
                    }
                }
            } else if (DeviceKt.useNewFilterConfig(device3)) {
                FragmentManager parentFragmentManager2 = deviceAttributesFragment.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager2, "getParentFragmentManager(...)");
                Class<DeviceNFilterDialogFragment> cls16 = DeviceNFilterDialogFragment.class;
                Intrinsics.checkNotNullExpressionValue("DeviceNFilterDialogFragment", "getSimpleName(...)");
                if (!(parentFragmentManager2.findFragmentByTag("DeviceNFilterDialogFragment") instanceof DeviceNFilterDialogFragment) && !parentFragmentManager2.isStateSaved()) {
                    dialogFragment2 = DeviceNFilterDialogFragment.Companion.newInstance$default(DeviceNFilterDialogFragment.Companion, device3, (String) null, DeviceFilterType.FILTER, ((Boolean) ((AttributeAction.OpenFilterPageAction) attributeAction2).getValue()).booleanValue(), false, 16, (Object) null);
                    dialogFragment2.show(parentFragmentManager2, "DeviceNFilterDialogFragment");
                }
                BaseDialogFragment baseDialogFragment = (BaseDialogFragment) dialogFragment2;
            } else {
                FragmentManager parentFragmentManager3 = deviceAttributesFragment.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager3, "getParentFragmentManager(...)");
                Class<DeviceFilterPageDialogFragment> cls17 = DeviceFilterPageDialogFragment.class;
                Intrinsics.checkNotNullExpressionValue("DeviceFilterPageDialogFragment", "getSimpleName(...)");
                if (!(parentFragmentManager3.findFragmentByTag("DeviceFilterPageDialogFragment") instanceof DeviceFilterPageDialogFragment) && !parentFragmentManager3.isStateSaved()) {
                    dialogFragment2 = DeviceFilterPageDialogFragment.Companion.newInstance$default(DeviceFilterPageDialogFragment.Companion, device3, false, 2, (Object) null);
                    dialogFragment2.show(parentFragmentManager3, "DeviceFilterPageDialogFragment");
                }
                BaseDialogFragment baseDialogFragment2 = (BaseDialogFragment) dialogFragment2;
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$28$lambda$27$lambda$26$lambda$22$lambda$21(DeviceAttributesFragment deviceAttributesFragment, Device device2, AttributeAction attributeAction, boolean z) {
        if (z) {
            deviceAttributesFragment.getViewModel().setSmartSubMode(device2, ((SmartSubMode) ((AttributeAction.SmartSubModeAction) attributeAction).getValue()).getValue());
        } else {
            deviceAttributesFragment.getAdapter().notifySubAutoChanged();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:327:0x0503, code lost:
        if (java.util.Arrays.equals(r2.getCoolEcoPresets(), r15.getCoolEcoPresets()) != false) goto L_0x053a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x02d8  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0321  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0324 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x037b  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x037e  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0381  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x038a  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x038f  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0393  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0396  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x039f  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x03b5  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x03be  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x03c1 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x0404  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0407  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x040c  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x0410  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x0413 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0454  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0457  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x045c  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0460  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0463 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x0548  */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x054b  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x054e  */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x0557  */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x055c  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x0560  */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x0563  */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x056c  */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x057d  */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0580  */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x0583  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x058c  */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x0591  */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x0595  */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x0598  */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x05a1  */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x05b4  */
    /* JADX WARNING: Removed duplicated region for block: B:374:0x05b7  */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x05ba  */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x05c3  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x05c8  */
    /* JADX WARNING: Removed duplicated region for block: B:381:0x05cc  */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x05cf  */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x05d8  */
    /* JADX WARNING: Removed duplicated region for block: B:387:0x05eb  */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x05ee  */
    /* JADX WARNING: Removed duplicated region for block: B:390:0x05f1  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x05fa  */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x05ff  */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x0603  */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x0606  */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x060f  */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x0622  */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x0625  */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x0628  */
    /* JADX WARNING: Removed duplicated region for block: B:405:0x0631  */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x0636  */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x063a  */
    /* JADX WARNING: Removed duplicated region for block: B:411:0x063d  */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x0646  */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x0659  */
    /* JADX WARNING: Removed duplicated region for block: B:416:0x065c  */
    /* JADX WARNING: Removed duplicated region for block: B:418:0x065f  */
    /* JADX WARNING: Removed duplicated region for block: B:419:0x0668  */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x066d  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x0671  */
    /* JADX WARNING: Removed duplicated region for block: B:425:0x0674  */
    /* JADX WARNING: Removed duplicated region for block: B:426:0x067d  */
    /* JADX WARNING: Removed duplicated region for block: B:429:0x0690  */
    /* JADX WARNING: Removed duplicated region for block: B:430:0x0693  */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x0696  */
    /* JADX WARNING: Removed duplicated region for block: B:433:0x069f  */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x06a4  */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x06a8  */
    /* JADX WARNING: Removed duplicated region for block: B:439:0x06ab  */
    /* JADX WARNING: Removed duplicated region for block: B:440:0x06b4  */
    /* JADX WARNING: Removed duplicated region for block: B:443:0x06c7  */
    /* JADX WARNING: Removed duplicated region for block: B:444:0x06ca  */
    /* JADX WARNING: Removed duplicated region for block: B:446:0x06cd  */
    /* JADX WARNING: Removed duplicated region for block: B:447:0x06d6  */
    /* JADX WARNING: Removed duplicated region for block: B:450:0x06db  */
    /* JADX WARNING: Removed duplicated region for block: B:451:0x06df  */
    /* JADX WARNING: Removed duplicated region for block: B:453:0x06e2  */
    /* JADX WARNING: Removed duplicated region for block: B:454:0x06eb  */
    /* JADX WARNING: Removed duplicated region for block: B:457:0x06fe  */
    /* JADX WARNING: Removed duplicated region for block: B:458:0x0701  */
    /* JADX WARNING: Removed duplicated region for block: B:460:0x0704  */
    /* JADX WARNING: Removed duplicated region for block: B:461:0x070d  */
    /* JADX WARNING: Removed duplicated region for block: B:464:0x0712  */
    /* JADX WARNING: Removed duplicated region for block: B:465:0x0715  */
    /* JADX WARNING: Removed duplicated region for block: B:467:0x0718  */
    /* JADX WARNING: Removed duplicated region for block: B:468:0x0721  */
    /* JADX WARNING: Removed duplicated region for block: B:471:0x0728 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean hasDeviceAttributesChanged(com.blueair.core.model.Device r36) {
        /*
            r35 = this;
            r0 = r36
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r1 = r35.getAdapter()
            com.blueair.core.model.Device r1 = r1.getDevice()
            boolean r2 = r1 instanceof com.blueair.core.model.HasFanSpeed
            if (r2 == 0) goto L_0x0011
            com.blueair.core.model.HasFanSpeed r1 = (com.blueair.core.model.HasFanSpeed) r1
            goto L_0x0012
        L_0x0011:
            r1 = 0
        L_0x0012:
            boolean r2 = r0 instanceof com.blueair.core.model.HasFanSpeed
            if (r2 == 0) goto L_0x001a
            r2 = r0
            com.blueair.core.model.HasFanSpeed r2 = (com.blueair.core.model.HasFanSpeed) r2
            goto L_0x001b
        L_0x001a:
            r2 = 0
        L_0x001b:
            if (r1 == 0) goto L_0x0022
            com.blueair.core.model.AutoMode r4 = r1.getAutoMode()
            goto L_0x0023
        L_0x0022:
            r4 = 0
        L_0x0023:
            if (r2 == 0) goto L_0x002a
            com.blueair.core.model.AutoMode r5 = r2.getAutoMode()
            goto L_0x002b
        L_0x002a:
            r5 = 0
        L_0x002b:
            if (r4 == r5) goto L_0x002f
            r4 = 1
            goto L_0x0030
        L_0x002f:
            r4 = 0
        L_0x0030:
            if (r1 == 0) goto L_0x0037
            com.blueair.core.model.FanSpeedEnum r5 = r1.getFanSpeedEnum()
            goto L_0x0038
        L_0x0037:
            r5 = 0
        L_0x0038:
            if (r2 == 0) goto L_0x003f
            com.blueair.core.model.FanSpeedEnum r8 = r2.getFanSpeedEnum()
            goto L_0x0040
        L_0x003f:
            r8 = 0
        L_0x0040:
            if (r5 == r8) goto L_0x0044
            r5 = 1
            goto L_0x0045
        L_0x0044:
            r5 = 0
        L_0x0045:
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r8 = r35.getAdapter()
            com.blueair.core.model.Device r8 = r8.getDevice()
            boolean r9 = r8 instanceof com.blueair.core.model.HasStandBy
            if (r9 == 0) goto L_0x0054
            com.blueair.core.model.HasStandBy r8 = (com.blueair.core.model.HasStandBy) r8
            goto L_0x0055
        L_0x0054:
            r8 = 0
        L_0x0055:
            if (r8 == 0) goto L_0x0060
            boolean r8 = r8.isStandByOn()
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            goto L_0x0061
        L_0x0060:
            r8 = 0
        L_0x0061:
            boolean r9 = r0 instanceof com.blueair.core.model.HasStandBy
            if (r9 == 0) goto L_0x0069
            r9 = r0
            com.blueair.core.model.HasStandBy r9 = (com.blueair.core.model.HasStandBy) r9
            goto L_0x006a
        L_0x0069:
            r9 = 0
        L_0x006a:
            if (r9 == 0) goto L_0x0075
            boolean r9 = r9.isStandByOn()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            goto L_0x0076
        L_0x0075:
            r9 = 0
        L_0x0076:
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r9 = r35.getAdapter()
            com.blueair.core.model.Device r9 = r9.getDevice()
            boolean r10 = r9 instanceof com.blueair.core.model.HasEcoMode
            if (r10 == 0) goto L_0x0089
            com.blueair.core.model.HasEcoMode r9 = (com.blueair.core.model.HasEcoMode) r9
            goto L_0x008a
        L_0x0089:
            r9 = 0
        L_0x008a:
            if (r9 == 0) goto L_0x0095
            boolean r9 = r9.isEcoModeOn()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            goto L_0x0096
        L_0x0095:
            r9 = 0
        L_0x0096:
            boolean r10 = r0 instanceof com.blueair.core.model.HasEcoMode
            if (r10 == 0) goto L_0x009e
            r10 = r0
            com.blueair.core.model.HasEcoMode r10 = (com.blueair.core.model.HasEcoMode) r10
            goto L_0x009f
        L_0x009e:
            r10 = 0
        L_0x009f:
            if (r10 == 0) goto L_0x00aa
            boolean r10 = r10.isEcoModeOn()
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            goto L_0x00ab
        L_0x00aa:
            r10 = 0
        L_0x00ab:
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r10 = r35.getAdapter()
            com.blueair.core.model.Device r10 = r10.getDevice()
            boolean r11 = r10 instanceof com.blueair.core.model.HasHinsMode
            if (r11 == 0) goto L_0x00be
            com.blueair.core.model.HasHinsMode r10 = (com.blueair.core.model.HasHinsMode) r10
            goto L_0x00bf
        L_0x00be:
            r10 = 0
        L_0x00bf:
            if (r10 == 0) goto L_0x00ca
            boolean r10 = r10.isHinsModeOn()
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            goto L_0x00cb
        L_0x00ca:
            r10 = 0
        L_0x00cb:
            boolean r11 = r0 instanceof com.blueair.core.model.HasHinsMode
            if (r11 == 0) goto L_0x00d3
            r12 = r0
            com.blueair.core.model.HasHinsMode r12 = (com.blueair.core.model.HasHinsMode) r12
            goto L_0x00d4
        L_0x00d3:
            r12 = 0
        L_0x00d4:
            if (r12 == 0) goto L_0x00df
            boolean r12 = r12.isHinsModeOn()
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
            goto L_0x00e0
        L_0x00df:
            r12 = 0
        L_0x00e0:
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r12 = r35.getAdapter()
            com.blueair.core.model.Device r12 = r12.getDevice()
            boolean r13 = r12 instanceof com.blueair.core.model.HasHinsMode
            if (r13 == 0) goto L_0x00f3
            com.blueair.core.model.HasHinsMode r12 = (com.blueair.core.model.HasHinsMode) r12
            goto L_0x00f4
        L_0x00f3:
            r12 = 0
        L_0x00f4:
            if (r12 == 0) goto L_0x00ff
            boolean r12 = r12.isHinsNightModeOn()
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
            goto L_0x0100
        L_0x00ff:
            r12 = 0
        L_0x0100:
            if (r11 == 0) goto L_0x0106
            r11 = r0
            com.blueair.core.model.HasHinsMode r11 = (com.blueair.core.model.HasHinsMode) r11
            goto L_0x0107
        L_0x0106:
            r11 = 0
        L_0x0107:
            if (r11 == 0) goto L_0x0112
            boolean r11 = r11.isHinsNightModeOn()
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)
            goto L_0x0113
        L_0x0112:
            r11 = 0
        L_0x0113:
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r11)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r12 = r35.getAdapter()
            com.blueair.core.model.Device r12 = r12.getDevice()
            boolean r13 = r12 instanceof com.blueair.core.model.HasG4NightMode
            if (r13 == 0) goto L_0x0126
            com.blueair.core.model.HasG4NightMode r12 = (com.blueair.core.model.HasG4NightMode) r12
            goto L_0x0127
        L_0x0126:
            r12 = 0
        L_0x0127:
            if (r12 == 0) goto L_0x0132
            boolean r12 = r12.isG4NightModeOn()
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
            goto L_0x0133
        L_0x0132:
            r12 = 0
        L_0x0133:
            boolean r13 = r0 instanceof com.blueair.core.model.HasG4NightMode
            if (r13 == 0) goto L_0x013b
            r13 = r0
            com.blueair.core.model.HasG4NightMode r13 = (com.blueair.core.model.HasG4NightMode) r13
            goto L_0x013c
        L_0x013b:
            r13 = 0
        L_0x013c:
            if (r13 == 0) goto L_0x0147
            boolean r13 = r13.isG4NightModeOn()
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)
            goto L_0x0148
        L_0x0147:
            r13 = 0
        L_0x0148:
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r1 == 0) goto L_0x0153
            java.lang.Integer r1 = r1.getFilterLife()
            goto L_0x0154
        L_0x0153:
            r1 = 0
        L_0x0154:
            if (r2 == 0) goto L_0x015b
            java.lang.Integer r2 = r2.getFilterLife()
            goto L_0x015c
        L_0x015b:
            r2 = 0
        L_0x015c:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r2 = r35.getAdapter()
            com.blueair.core.model.Device r2 = r2.getDevice()
            boolean r13 = r2 instanceof com.blueair.core.model.HasSafetySwitch
            if (r13 == 0) goto L_0x016f
            com.blueair.core.model.HasSafetySwitch r2 = (com.blueair.core.model.HasSafetySwitch) r2
            goto L_0x0170
        L_0x016f:
            r2 = 0
        L_0x0170:
            if (r2 == 0) goto L_0x017b
            boolean r2 = r2.isSafetySwitchOn()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x017c
        L_0x017b:
            r2 = 0
        L_0x017c:
            boolean r13 = r0 instanceof com.blueair.core.model.HasSafetySwitch
            if (r13 == 0) goto L_0x0184
            r13 = r0
            com.blueair.core.model.HasSafetySwitch r13 = (com.blueair.core.model.HasSafetySwitch) r13
            goto L_0x0185
        L_0x0184:
            r13 = 0
        L_0x0185:
            if (r13 == 0) goto L_0x0190
            boolean r13 = r13.isSafetySwitchOn()
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)
            goto L_0x0191
        L_0x0190:
            r13 = 0
        L_0x0191:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r13)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r13 = r35.getAdapter()
            com.blueair.core.model.Device r13 = r13.getDevice()
            boolean r14 = r13 instanceof com.blueair.core.model.HasGermShieldMode
            if (r14 == 0) goto L_0x01a4
            com.blueair.core.model.HasGermShieldMode r13 = (com.blueair.core.model.HasGermShieldMode) r13
            goto L_0x01a5
        L_0x01a4:
            r13 = 0
        L_0x01a5:
            if (r13 == 0) goto L_0x01b0
            boolean r13 = r13.isGermShieldModeOn()
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)
            goto L_0x01b1
        L_0x01b0:
            r13 = 0
        L_0x01b1:
            boolean r14 = r0 instanceof com.blueair.core.model.HasGermShieldMode
            if (r14 == 0) goto L_0x01b9
            r15 = r0
            com.blueair.core.model.HasGermShieldMode r15 = (com.blueair.core.model.HasGermShieldMode) r15
            goto L_0x01ba
        L_0x01b9:
            r15 = 0
        L_0x01ba:
            if (r15 == 0) goto L_0x01c5
            boolean r15 = r15.isGermShieldModeOn()
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)
            goto L_0x01c6
        L_0x01c5:
            r15 = 0
        L_0x01c6:
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r15)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r15 = r35.getAdapter()
            com.blueair.core.model.Device r15 = r15.getDevice()
            boolean r3 = r15 instanceof com.blueair.core.model.HasGermShieldMode
            if (r3 == 0) goto L_0x01d9
            com.blueair.core.model.HasGermShieldMode r15 = (com.blueair.core.model.HasGermShieldMode) r15
            goto L_0x01da
        L_0x01d9:
            r15 = 0
        L_0x01da:
            if (r15 == 0) goto L_0x01e1
            java.lang.Boolean r3 = r15.isGermShieldNightModeOn()
            goto L_0x01e2
        L_0x01e1:
            r3 = 0
        L_0x01e2:
            if (r14 == 0) goto L_0x01e8
            r14 = r0
            com.blueair.core.model.HasGermShieldMode r14 = (com.blueair.core.model.HasGermShieldMode) r14
            goto L_0x01e9
        L_0x01e8:
            r14 = 0
        L_0x01e9:
            if (r14 == 0) goto L_0x01f0
            java.lang.Boolean r14 = r14.isGermShieldNightModeOn()
            goto L_0x01f1
        L_0x01f0:
            r14 = 0
        L_0x01f1:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r14)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r14 = r35.getAdapter()
            com.blueair.core.model.Device r14 = r14.getDevice()
            boolean r15 = r14 instanceof com.blueair.core.model.HasBrightness
            if (r15 == 0) goto L_0x0204
            com.blueair.core.model.HasBrightness r14 = (com.blueair.core.model.HasBrightness) r14
            goto L_0x0205
        L_0x0204:
            r14 = 0
        L_0x0205:
            if (r14 == 0) goto L_0x0210
            int r14 = r14.getBrightness()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            goto L_0x0211
        L_0x0210:
            r14 = 0
        L_0x0211:
            boolean r15 = r0 instanceof com.blueair.core.model.HasBrightness
            if (r15 == 0) goto L_0x0219
            r15 = r0
            com.blueair.core.model.HasBrightness r15 = (com.blueair.core.model.HasBrightness) r15
            goto L_0x021a
        L_0x0219:
            r15 = 0
        L_0x021a:
            if (r15 == 0) goto L_0x0225
            int r15 = r15.getBrightness()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x0226
        L_0x0225:
            r15 = 0
        L_0x0226:
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r15)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r15 = r35.getAdapter()
            com.blueair.core.model.Device r15 = r15.getDevice()
            if (r15 == 0) goto L_0x0239
            com.blueair.core.model.ConnectivityStatus r15 = r15.getConnectivityStatus()
            goto L_0x023a
        L_0x0239:
            r15 = 0
        L_0x023a:
            r16 = 1
            com.blueair.core.model.ConnectivityStatus r6 = r0.getConnectivityStatus()
            if (r15 == r6) goto L_0x0245
            r6 = r16
            goto L_0x0246
        L_0x0245:
            r6 = 0
        L_0x0246:
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r15 = r35.getAdapter()
            com.blueair.core.model.Device r15 = r15.getDevice()
            if (r15 == 0) goto L_0x025f
            int r15 = r15.getUpdateProgress()
            r17 = 0
            int r7 = r0.getUpdateProgress()
            if (r15 != r7) goto L_0x0261
            r7 = r16
            goto L_0x0263
        L_0x025f:
            r17 = 0
        L_0x0261:
            r7 = r17
        L_0x0263:
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r15 = r35.getAdapter()
            com.blueair.core.model.Device r15 = r15.getDevice()
            boolean r15 = r15 instanceof com.blueair.core.model.HasDisinfection
            if (r15 == 0) goto L_0x02af
            boolean r15 = r0 instanceof com.blueair.core.model.HasDisinfection
            if (r15 == 0) goto L_0x02af
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r15 = r35.getAdapter()
            com.blueair.core.model.Device r15 = r15.getDevice()
            r18 = r1
            boolean r1 = r15 instanceof com.blueair.core.model.HasDisinfection
            if (r1 == 0) goto L_0x0284
            com.blueair.core.model.HasDisinfection r15 = (com.blueair.core.model.HasDisinfection) r15
            goto L_0x0285
        L_0x0284:
            r15 = 0
        L_0x0285:
            if (r15 == 0) goto L_0x02ac
            java.lang.Boolean r1 = r15.getDisinfection()
            r19 = r0
            com.blueair.core.model.HasDisinfection r19 = (com.blueair.core.model.HasDisinfection) r19
            r20 = r2
            java.lang.Boolean r2 = r19.getDisinfection()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x02a9
            java.lang.Integer r1 = r15.getDisinfectLeftTime()
            java.lang.Integer r2 = r19.getDisinfectLeftTime()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 != 0) goto L_0x02b2
        L_0x02a9:
            r1 = r16
            goto L_0x02b4
        L_0x02ac:
            r20 = r2
            goto L_0x02b2
        L_0x02af:
            r18 = r1
            goto L_0x02ac
        L_0x02b2:
            r1 = r17
        L_0x02b4:
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r2 = r35.getAdapter()
            com.blueair.core.model.Device r2 = r2.getDevice()
            boolean r15 = r2 instanceof com.blueair.core.model.HasChildLock
            if (r15 == 0) goto L_0x02c3
            com.blueair.core.model.HasChildLock r2 = (com.blueair.core.model.HasChildLock) r2
            goto L_0x02c4
        L_0x02c3:
            r2 = 0
        L_0x02c4:
            if (r2 == 0) goto L_0x02cf
            boolean r2 = r2.isChildLockOn()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x02d0
        L_0x02cf:
            r2 = 0
        L_0x02d0:
            boolean r15 = r0 instanceof com.blueair.core.model.HasChildLock
            if (r15 == 0) goto L_0x02d8
            r15 = r0
            com.blueair.core.model.HasChildLock r15 = (com.blueair.core.model.HasChildLock) r15
            goto L_0x02d9
        L_0x02d8:
            r15 = 0
        L_0x02d9:
            if (r15 == 0) goto L_0x02e4
            boolean r15 = r15.isChildLockOn()
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)
            goto L_0x02e5
        L_0x02e4:
            r15 = 0
        L_0x02e5:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r15)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r15 = r35.getAdapter()
            com.blueair.core.model.Device r15 = r15.getDevice()
            if (r15 == 0) goto L_0x02f8
            java.lang.String r15 = r15.getTimeZone()
            goto L_0x02f9
        L_0x02f8:
            r15 = 0
        L_0x02f9:
            r19 = r1
            java.lang.String r1 = r0.getTimeZone()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r1)
            r15 = r35
            com.blueair.devicedetails.fragment.DeviceAttributesFragment r15 = (com.blueair.devicedetails.fragment.DeviceAttributesFragment) r15
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r15 = r35.getAdapter()
            com.blueair.core.model.Device r15 = r15.getDevice()
            r21 = r1
            boolean r1 = r15 instanceof com.blueair.core.model.HasWick
            if (r1 == 0) goto L_0x0318
            com.blueair.core.model.HasWick r15 = (com.blueair.core.model.HasWick) r15
            goto L_0x0319
        L_0x0318:
            r15 = 0
        L_0x0319:
            boolean r1 = r0 instanceof com.blueair.core.model.HasWick
            if (r1 == 0) goto L_0x0321
            r1 = r0
            com.blueair.core.model.HasWick r1 = (com.blueair.core.model.HasWick) r1
            goto L_0x0322
        L_0x0321:
            r1 = 0
        L_0x0322:
            if (r15 == 0) goto L_0x036b
            if (r1 == 0) goto L_0x036b
            r22 = r1
            int r1 = r15.getWickUsage()
            r23 = r2
            int r2 = r22.getWickUsage()
            if (r1 != r2) goto L_0x0368
            boolean r1 = r15.getWickdryOn()
            boolean r2 = r22.getWickdryOn()
            if (r1 != r2) goto L_0x0368
            int r1 = r15.getWickdryLeftTime()
            int r2 = r22.getWickdryLeftTime()
            if (r1 != r2) goto L_0x0368
            long r1 = r15.getWickdryLeftTimeUpdateTime()
            long r24 = r22.getWickdryLeftTimeUpdateTime()
            int r1 = (r1 > r24 ? 1 : (r1 == r24 ? 0 : -1))
            if (r1 != 0) goto L_0x0368
            boolean r1 = r15.getWickdryEnabled()
            boolean r2 = r22.getWickdryEnabled()
            if (r1 != r2) goto L_0x0368
            boolean r1 = r15.getWaterShortage()
            boolean r2 = r22.getWaterShortage()
            if (r1 == r2) goto L_0x036d
        L_0x0368:
            r1 = r16
            goto L_0x036f
        L_0x036b:
            r23 = r2
        L_0x036d:
            r1 = r17
        L_0x036f:
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r2 = r35.getAdapter()
            com.blueair.core.model.Device r2 = r2.getDevice()
            boolean r15 = r2 instanceof com.blueair.core.model.HasAutoRh
            if (r15 == 0) goto L_0x037e
            com.blueair.core.model.HasAutoRh r2 = (com.blueair.core.model.HasAutoRh) r2
            goto L_0x037f
        L_0x037e:
            r2 = 0
        L_0x037f:
            if (r2 == 0) goto L_0x038a
            int r2 = r2.getAutoRh()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x038b
        L_0x038a:
            r2 = 0
        L_0x038b:
            boolean r15 = r0 instanceof com.blueair.core.model.HasAutoRh
            if (r15 == 0) goto L_0x0393
            r15 = r0
            com.blueair.core.model.HasAutoRh r15 = (com.blueair.core.model.HasAutoRh) r15
            goto L_0x0394
        L_0x0393:
            r15 = 0
        L_0x0394:
            if (r15 == 0) goto L_0x039f
            int r15 = r15.getAutoRh()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x03a0
        L_0x039f:
            r15 = 0
        L_0x03a0:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r15)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r15 = r35.getAdapter()
            com.blueair.core.model.Device r15 = r15.getDevice()
            r22 = r1
            boolean r1 = r15 instanceof com.blueair.core.model.HasTimer
            if (r1 == 0) goto L_0x03b5
            com.blueair.core.model.HasTimer r15 = (com.blueair.core.model.HasTimer) r15
            goto L_0x03b6
        L_0x03b5:
            r15 = 0
        L_0x03b6:
            boolean r1 = r0 instanceof com.blueair.core.model.HasTimer
            if (r1 == 0) goto L_0x03be
            r1 = r0
            com.blueair.core.model.HasTimer r1 = (com.blueair.core.model.HasTimer) r1
            goto L_0x03bf
        L_0x03be:
            r1 = 0
        L_0x03bf:
            if (r15 == 0) goto L_0x03f4
            if (r1 == 0) goto L_0x03f4
            r24 = r1
            int r1 = r15.getTimerStatus()
            r25 = r2
            int r2 = r24.getTimerStatus()
            if (r1 != r2) goto L_0x03f1
            int r1 = r15.getTimerDuration()
            int r2 = r24.getTimerDuration()
            if (r1 != r2) goto L_0x03f1
            int r1 = r15.getTimerLeftTime()
            int r2 = r24.getTimerLeftTime()
            if (r1 != r2) goto L_0x03f1
            long r1 = r15.getTimerLeftTimeUpdateTime()
            long r26 = r24.getTimerLeftTimeUpdateTime()
            int r1 = (r1 > r26 ? 1 : (r1 == r26 ? 0 : -1))
            if (r1 == 0) goto L_0x03f6
        L_0x03f1:
            r1 = r16
            goto L_0x03f8
        L_0x03f4:
            r25 = r2
        L_0x03f6:
            r1 = r17
        L_0x03f8:
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r2 = r35.getAdapter()
            com.blueair.core.model.Device r2 = r2.getDevice()
            boolean r15 = r2 instanceof com.blueair.core.model.HasOscillation
            if (r15 == 0) goto L_0x0407
            com.blueair.core.model.HasOscillation r2 = (com.blueair.core.model.HasOscillation) r2
            goto L_0x0408
        L_0x0407:
            r2 = 0
        L_0x0408:
            boolean r15 = r0 instanceof com.blueair.core.model.HasOscillation
            if (r15 == 0) goto L_0x0410
            r15 = r0
            com.blueair.core.model.HasOscillation r15 = (com.blueair.core.model.HasOscillation) r15
            goto L_0x0411
        L_0x0410:
            r15 = 0
        L_0x0411:
            if (r2 == 0) goto L_0x0444
            if (r15 == 0) goto L_0x0444
            r24 = r1
            int r1 = r2.getOscillationState()
            r26 = r2
            int r2 = r15.getOscillationState()
            if (r1 != r2) goto L_0x0441
            int r1 = r26.getOscillationAngle()
            int r2 = r15.getOscillationAngle()
            if (r1 != r2) goto L_0x0441
            int r1 = r26.getOscillationDirection()
            int r2 = r15.getOscillationDirection()
            if (r1 != r2) goto L_0x0441
            int r1 = r26.getOscillationFanSpeed()
            int r2 = r15.getOscillationFanSpeed()
            if (r1 == r2) goto L_0x0446
        L_0x0441:
            r1 = r16
            goto L_0x0448
        L_0x0444:
            r24 = r1
        L_0x0446:
            r1 = r17
        L_0x0448:
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r2 = r35.getAdapter()
            com.blueair.core.model.Device r2 = r2.getDevice()
            boolean r15 = r2 instanceof com.blueair.core.model.HasMainMode
            if (r15 == 0) goto L_0x0457
            com.blueair.core.model.HasMainMode r2 = (com.blueair.core.model.HasMainMode) r2
            goto L_0x0458
        L_0x0457:
            r2 = 0
        L_0x0458:
            boolean r15 = r0 instanceof com.blueair.core.model.HasMainMode
            if (r15 == 0) goto L_0x0460
            r15 = r0
            com.blueair.core.model.HasMainMode r15 = (com.blueair.core.model.HasMainMode) r15
            goto L_0x0461
        L_0x0460:
            r15 = 0
        L_0x0461:
            if (r2 == 0) goto L_0x0536
            if (r15 == 0) goto L_0x0536
            r26 = r1
            int r1 = r2.getMainMode()
            r27 = r3
            int r3 = r15.getMainMode()
            if (r1 != r3) goto L_0x0533
            int r1 = r2.getApSubMode()
            int r3 = r15.getApSubMode()
            if (r1 == r3) goto L_0x047f
            goto L_0x0533
        L_0x047f:
            boolean r1 = r2 instanceof com.blueair.core.model.HasCombo3in1MainMode
            if (r1 == 0) goto L_0x0506
            boolean r1 = r15 instanceof com.blueair.core.model.HasCombo3in1MainMode
            if (r1 == 0) goto L_0x0506
            com.blueair.core.model.HasCombo3in1MainMode r2 = (com.blueair.core.model.HasCombo3in1MainMode) r2
            int r1 = r2.getApFanSpeed()
            com.blueair.core.model.HasCombo3in1MainMode r15 = (com.blueair.core.model.HasCombo3in1MainMode) r15
            int r3 = r15.getApFanSpeed()
            if (r1 != r3) goto L_0x0533
            int r1 = r2.getHeatSubMode()
            int r3 = r15.getHeatSubMode()
            if (r1 != r3) goto L_0x0533
            int r1 = r2.getHeatFanSpeed()
            int r3 = r15.getHeatFanSpeed()
            if (r1 != r3) goto L_0x0533
            double r28 = r2.getHeatAutoTmp()
            double r30 = r15.getHeatAutoTmp()
            int r1 = (r28 > r30 ? 1 : (r28 == r30 ? 0 : -1))
            if (r1 != 0) goto L_0x0533
            double r28 = r2.getHeatEcoTmp()
            double r30 = r15.getHeatEcoTmp()
            int r1 = (r28 > r30 ? 1 : (r28 == r30 ? 0 : -1))
            if (r1 != 0) goto L_0x0533
            int r1 = r2.getCoolSubMode()
            int r3 = r15.getCoolSubMode()
            if (r1 != r3) goto L_0x0533
            int r1 = r2.getCoolFanSpeed()
            int r3 = r15.getCoolFanSpeed()
            if (r1 != r3) goto L_0x0533
            int r1 = r2.getCoolAutoTag()
            int r3 = r15.getCoolAutoTag()
            if (r1 != r3) goto L_0x0533
            double[] r1 = r2.getCoolAutoPresets()
            double[] r3 = r15.getCoolAutoPresets()
            boolean r1 = java.util.Arrays.equals(r1, r3)
            if (r1 == 0) goto L_0x0533
            int r1 = r2.getCoolEcoTag()
            int r3 = r15.getCoolEcoTag()
            if (r1 != r3) goto L_0x0533
            double[] r1 = r2.getCoolEcoPresets()
            double[] r2 = r15.getCoolEcoPresets()
            boolean r1 = java.util.Arrays.equals(r1, r2)
            if (r1 != 0) goto L_0x053a
            goto L_0x0533
        L_0x0506:
            boolean r1 = r2 instanceof com.blueair.core.model.HasDehumidifierMainMode
            if (r1 == 0) goto L_0x051d
            boolean r1 = r15 instanceof com.blueair.core.model.HasDehumidifierMainMode
            if (r1 == 0) goto L_0x051d
            com.blueair.core.model.HasDehumidifierMainMode r2 = (com.blueair.core.model.HasDehumidifierMainMode) r2
            int r1 = r2.getDehSubMode()
            com.blueair.core.model.HasDehumidifierMainMode r15 = (com.blueair.core.model.HasDehumidifierMainMode) r15
            int r2 = r15.getDehSubMode()
            if (r1 == r2) goto L_0x053a
            goto L_0x0533
        L_0x051d:
            boolean r1 = r2 instanceof com.blueair.core.model.HasPetMainMode
            if (r1 == 0) goto L_0x053a
            boolean r1 = r15 instanceof com.blueair.core.model.HasPetMainMode
            if (r1 == 0) goto L_0x053a
            com.blueair.core.model.HasPetMainMode r2 = (com.blueair.core.model.HasPetMainMode) r2
            int r1 = r2.getSmartSubMode()
            com.blueair.core.model.HasPetMainMode r15 = (com.blueair.core.model.HasPetMainMode) r15
            int r2 = r15.getSmartSubMode()
            if (r1 == r2) goto L_0x053a
        L_0x0533:
            r1 = r16
            goto L_0x053c
        L_0x0536:
            r26 = r1
            r27 = r3
        L_0x053a:
            r1 = r17
        L_0x053c:
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r2 = r35.getAdapter()
            com.blueair.core.model.Device r2 = r2.getDevice()
            boolean r3 = r2 instanceof com.blueair.core.model.HasTemperatureUnit
            if (r3 == 0) goto L_0x054b
            com.blueair.core.model.HasTemperatureUnit r2 = (com.blueair.core.model.HasTemperatureUnit) r2
            goto L_0x054c
        L_0x054b:
            r2 = 0
        L_0x054c:
            if (r2 == 0) goto L_0x0557
            int r2 = r2.getTemperatureUnit()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0558
        L_0x0557:
            r2 = 0
        L_0x0558:
            boolean r3 = r0 instanceof com.blueair.core.model.HasTemperatureUnit
            if (r3 == 0) goto L_0x0560
            r3 = r0
            com.blueair.core.model.HasTemperatureUnit r3 = (com.blueair.core.model.HasTemperatureUnit) r3
            goto L_0x0561
        L_0x0560:
            r3 = 0
        L_0x0561:
            if (r3 == 0) goto L_0x056c
            int r3 = r3.getTemperatureUnit()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x056d
        L_0x056c:
            r3 = 0
        L_0x056d:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r3 = r35.getAdapter()
            com.blueair.core.model.Device r3 = r3.getDevice()
            boolean r15 = r3 instanceof com.blueair.core.model.HasMode
            if (r15 == 0) goto L_0x0580
            com.blueair.core.model.HasMode r3 = (com.blueair.core.model.HasMode) r3
            goto L_0x0581
        L_0x0580:
            r3 = 0
        L_0x0581:
            if (r3 == 0) goto L_0x058c
            int r3 = r3.getMode()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x058d
        L_0x058c:
            r3 = 0
        L_0x058d:
            boolean r15 = r0 instanceof com.blueair.core.model.HasMode
            if (r15 == 0) goto L_0x0595
            r15 = r0
            com.blueair.core.model.HasMode r15 = (com.blueair.core.model.HasMode) r15
            goto L_0x0596
        L_0x0595:
            r15 = 0
        L_0x0596:
            if (r15 == 0) goto L_0x05a1
            int r15 = r15.getMode()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x05a2
        L_0x05a1:
            r15 = 0
        L_0x05a2:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r15)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r15 = r35.getAdapter()
            com.blueair.core.model.Device r15 = r15.getDevice()
            r28 = r1
            boolean r1 = r15 instanceof com.blueair.core.model.HasHumMode
            if (r1 == 0) goto L_0x05b7
            com.blueair.core.model.HasHumMode r15 = (com.blueair.core.model.HasHumMode) r15
            goto L_0x05b8
        L_0x05b7:
            r15 = 0
        L_0x05b8:
            if (r15 == 0) goto L_0x05c3
            boolean r1 = r15.getHumMode()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x05c4
        L_0x05c3:
            r1 = 0
        L_0x05c4:
            boolean r15 = r0 instanceof com.blueair.core.model.HasHumMode
            if (r15 == 0) goto L_0x05cc
            r15 = r0
            com.blueair.core.model.HasHumMode r15 = (com.blueair.core.model.HasHumMode) r15
            goto L_0x05cd
        L_0x05cc:
            r15 = 0
        L_0x05cd:
            if (r15 == 0) goto L_0x05d8
            boolean r15 = r15.getHumMode()
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)
            goto L_0x05d9
        L_0x05d8:
            r15 = 0
        L_0x05d9:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r15)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r15 = r35.getAdapter()
            com.blueair.core.model.Device r15 = r15.getDevice()
            r29 = r1
            boolean r1 = r15 instanceof com.blueair.core.model.HasWaterLevel
            if (r1 == 0) goto L_0x05ee
            com.blueair.core.model.HasWaterLevel r15 = (com.blueair.core.model.HasWaterLevel) r15
            goto L_0x05ef
        L_0x05ee:
            r15 = 0
        L_0x05ef:
            if (r15 == 0) goto L_0x05fa
            int r1 = r15.getWaterLevel()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x05fb
        L_0x05fa:
            r1 = 0
        L_0x05fb:
            boolean r15 = r0 instanceof com.blueair.core.model.HasWaterLevel
            if (r15 == 0) goto L_0x0603
            r15 = r0
            com.blueair.core.model.HasWaterLevel r15 = (com.blueair.core.model.HasWaterLevel) r15
            goto L_0x0604
        L_0x0603:
            r15 = 0
        L_0x0604:
            if (r15 == 0) goto L_0x060f
            int r15 = r15.getWaterLevel()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x0610
        L_0x060f:
            r15 = 0
        L_0x0610:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r15)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r15 = r35.getAdapter()
            com.blueair.core.model.Device r15 = r15.getDevice()
            r30 = r1
            boolean r1 = r15 instanceof com.blueair.core.model.HasWaterTank
            if (r1 == 0) goto L_0x0625
            com.blueair.core.model.HasWaterTank r15 = (com.blueair.core.model.HasWaterTank) r15
            goto L_0x0626
        L_0x0625:
            r15 = 0
        L_0x0626:
            if (r15 == 0) goto L_0x0631
            boolean r1 = r15.getWaterTankFailure()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x0632
        L_0x0631:
            r1 = 0
        L_0x0632:
            boolean r15 = r0 instanceof com.blueair.core.model.HasWaterTank
            if (r15 == 0) goto L_0x063a
            r15 = r0
            com.blueair.core.model.HasWaterTank r15 = (com.blueair.core.model.HasWaterTank) r15
            goto L_0x063b
        L_0x063a:
            r15 = 0
        L_0x063b:
            if (r15 == 0) goto L_0x0646
            boolean r15 = r15.getWaterTankFailure()
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)
            goto L_0x0647
        L_0x0646:
            r15 = 0
        L_0x0647:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r15)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r15 = r35.getAdapter()
            com.blueair.core.model.Device r15 = r15.getDevice()
            r31 = r1
            boolean r1 = r15 instanceof com.blueair.core.model.HasDetectCat
            if (r1 == 0) goto L_0x065c
            com.blueair.core.model.HasDetectCat r15 = (com.blueair.core.model.HasDetectCat) r15
            goto L_0x065d
        L_0x065c:
            r15 = 0
        L_0x065d:
            if (r15 == 0) goto L_0x0668
            boolean r1 = r15.getDetectCat()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x0669
        L_0x0668:
            r1 = 0
        L_0x0669:
            boolean r15 = r0 instanceof com.blueair.core.model.HasDetectCat
            if (r15 == 0) goto L_0x0671
            r15 = r0
            com.blueair.core.model.HasDetectCat r15 = (com.blueair.core.model.HasDetectCat) r15
            goto L_0x0672
        L_0x0671:
            r15 = 0
        L_0x0672:
            if (r15 == 0) goto L_0x067d
            boolean r15 = r15.getDetectCat()
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)
            goto L_0x067e
        L_0x067d:
            r15 = 0
        L_0x067e:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r15)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r15 = r35.getAdapter()
            com.blueair.core.model.Device r15 = r15.getDevice()
            r32 = r1
            boolean r1 = r15 instanceof com.blueair.core.model.HasCleanAirEta
            if (r1 == 0) goto L_0x0693
            com.blueair.core.model.HasCleanAirEta r15 = (com.blueair.core.model.HasCleanAirEta) r15
            goto L_0x0694
        L_0x0693:
            r15 = 0
        L_0x0694:
            if (r15 == 0) goto L_0x069f
            int r1 = r15.getCleanAirEta()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x06a0
        L_0x069f:
            r1 = 0
        L_0x06a0:
            boolean r15 = r0 instanceof com.blueair.core.model.HasCleanAirEta
            if (r15 == 0) goto L_0x06a8
            r15 = r0
            com.blueair.core.model.HasCleanAirEta r15 = (com.blueair.core.model.HasCleanAirEta) r15
            goto L_0x06a9
        L_0x06a8:
            r15 = 0
        L_0x06a9:
            if (r15 == 0) goto L_0x06b4
            int r15 = r15.getCleanAirEta()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x06b5
        L_0x06b4:
            r15 = 0
        L_0x06b5:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r15)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r15 = r35.getAdapter()
            com.blueair.core.model.Device r15 = r15.getDevice()
            r33 = r1
            boolean r1 = r15 instanceof com.blueair.core.model.HasDisplayMode
            if (r1 == 0) goto L_0x06ca
            com.blueair.core.model.HasDisplayMode r15 = (com.blueair.core.model.HasDisplayMode) r15
            goto L_0x06cb
        L_0x06ca:
            r15 = 0
        L_0x06cb:
            if (r15 == 0) goto L_0x06d6
            int r1 = r15.getPanelDisplayMode()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x06d7
        L_0x06d6:
            r1 = 0
        L_0x06d7:
            boolean r15 = r0 instanceof com.blueair.core.model.HasDisplayMode
            if (r15 == 0) goto L_0x06df
            r15 = r0
            com.blueair.core.model.HasDisplayMode r15 = (com.blueair.core.model.HasDisplayMode) r15
            goto L_0x06e0
        L_0x06df:
            r15 = 0
        L_0x06e0:
            if (r15 == 0) goto L_0x06eb
            int r15 = r15.getPanelDisplayMode()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x06ec
        L_0x06eb:
            r15 = 0
        L_0x06ec:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r15)
            com.blueair.devicedetails.adapter.DeviceAttributesAdapter r15 = r35.getAdapter()
            com.blueair.core.model.Device r15 = r15.getDevice()
            r34 = r1
            boolean r1 = r15 instanceof com.blueair.core.model.HasGestureRecognition
            if (r1 == 0) goto L_0x0701
            com.blueair.core.model.HasGestureRecognition r15 = (com.blueair.core.model.HasGestureRecognition) r15
            goto L_0x0702
        L_0x0701:
            r15 = 0
        L_0x0702:
            if (r15 == 0) goto L_0x070d
            boolean r1 = r15.getHoverEnabled()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x070e
        L_0x070d:
            r1 = 0
        L_0x070e:
            boolean r15 = r0 instanceof com.blueair.core.model.HasGestureRecognition
            if (r15 == 0) goto L_0x0715
            com.blueair.core.model.HasGestureRecognition r0 = (com.blueair.core.model.HasGestureRecognition) r0
            goto L_0x0716
        L_0x0715:
            r0 = 0
        L_0x0716:
            if (r0 == 0) goto L_0x0721
            boolean r0 = r0.getHoverEnabled()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0722
        L_0x0721:
            r0 = 0
        L_0x0722:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r0)
            if (r4 != 0) goto L_0x0766
            if (r5 != 0) goto L_0x0766
            if (r8 == 0) goto L_0x0766
            if (r9 == 0) goto L_0x0766
            if (r12 == 0) goto L_0x0766
            if (r18 == 0) goto L_0x0766
            if (r20 == 0) goto L_0x0766
            if (r13 == 0) goto L_0x0766
            if (r27 == 0) goto L_0x0766
            if (r14 == 0) goto L_0x0766
            if (r6 != 0) goto L_0x0766
            if (r7 == 0) goto L_0x0766
            if (r19 != 0) goto L_0x0766
            if (r23 == 0) goto L_0x0766
            if (r21 == 0) goto L_0x0766
            if (r10 == 0) goto L_0x0766
            if (r11 == 0) goto L_0x0766
            if (r22 != 0) goto L_0x0766
            if (r25 == 0) goto L_0x0766
            if (r24 != 0) goto L_0x0766
            if (r26 != 0) goto L_0x0766
            if (r28 != 0) goto L_0x0766
            if (r2 == 0) goto L_0x0766
            if (r3 == 0) goto L_0x0766
            if (r29 == 0) goto L_0x0766
            if (r30 == 0) goto L_0x0766
            if (r31 == 0) goto L_0x0766
            if (r32 == 0) goto L_0x0766
            if (r33 == 0) goto L_0x0766
            if (r34 == 0) goto L_0x0766
            if (r0 != 0) goto L_0x0765
            goto L_0x0766
        L_0x0765:
            return r17
        L_0x0766:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.fragment.DeviceAttributesFragment.hasDeviceAttributesChanged(com.blueair.core.model.Device):boolean");
    }

    private final void shouldDoDbAndApiCall(Device device2, Function0<Unit> function0) {
        if (device2 instanceof HasSafetySwitch) {
            Context context = getContext();
            if (context != null && !NetUtil.INSTANCE.isProbablyOnline(context)) {
                return;
            }
            if (ViewUtils.INSTANCE.shouldShowFilterDoorPopup((HasSafetySwitch) device2)) {
                ConfirmationDialogCentered.Companion companion = ConfirmationDialogCentered.Companion;
                FragmentManager parentFragmentManager = getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
                companion.showFilterDoorOpenDialog(parentFragmentManager);
                return;
            }
            function0.invoke();
            return;
        }
        function0.invoke();
    }
}
