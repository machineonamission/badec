package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.blueair.android.activity.AccountLinkingActivity;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.FilterInfo;
import com.blueair.core.model.I18nConfig;
import com.blueair.devicedetails.activity.FilterVideoActivity;
import com.blueair.devicedetails.adapter.DeviceFilterPageAdapter;
import com.blueair.devicedetails.databinding.BottomSheetFilterOrderBinding;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceFilterPageBinding;
import com.blueair.devicedetails.dialog.FilterSelectionDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.devicedetails.viewmodel.FilterLifeResetResult;
import com.blueair.push.NotificationService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.utils.ToastUtils;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0017J\u0012\u0010*\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010+\u001a\u00020'H\u0016J\b\u0010,\u001a\u00020'H\u0016J\u0012\u0010-\u001a\u00020.2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J$\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u00105\u001a\u00020'2\u0006\u00106\u001a\u0002002\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u00107\u001a\u00020'H\u0016J\u0010\u00108\u001a\u00020'2\u0006\u00109\u001a\u00020\u0016H\u0016J\b\u0010:\u001a\u00020'H\u0002J\b\u0010;\u001a\u00020'H\u0002J\b\u0010<\u001a\u00020'H\u0002J\b\u0010=\u001a\u00020'H\u0002J\b\u0010>\u001a\u00020'H\u0002J\b\u0010?\u001a\u00020'H\u0002J\b\u0010@\u001a\u00020'H\u0002R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00188BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b\u001e\u0010\u001aR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#¨\u0006B"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceFilterPageDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "_screenName", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceFilterPageBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "device", "Lcom/blueair/core/model/Device;", "filterConfig", "Lcom/blueair/core/model/FilterConfig;", "fromNotification", "", "openFilterVideoPublisher", "Lio/reactivex/subjects/PublishSubject;", "getOpenFilterVideoPublisher", "()Lio/reactivex/subjects/PublishSubject;", "openFilterVideoPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "openFilterSelectionPublisher", "getOpenFilterSelectionPublisher", "openFilterSelectionPublisher$delegate", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceFilterPageAdapter;", "getAdapter", "()Lcom/blueair/devicedetails/adapter/DeviceFilterPageAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onStart", "onStop", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "showProgress", "shouldShowProgress", "bindViewModel", "showDeviceOfflinePrompt", "onResetFilterClick", "onOrderFilterClick", "showFilterPurchaseOptionDialog", "onFilterOneTimePurchase", "onFilterSubscription", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceFilterPageDialogFragment.kt */
public final class DeviceFilterPageDialogFragment extends BaseDialogFragment<DeviceDetailsViewModel> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_FROM_NOTIFICATION = "EXTRA_FROM_NOTIFICATION";
    private String _screenName;
    private final Lazy adapter$delegate = LazyKt.lazy(new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda3(this));
    private Device device;
    private FilterConfig filterConfig;
    private boolean fromNotification;
    private final LazyPublishSubject openFilterSelectionPublisher$delegate = new LazyPublishSubject();
    private final LazyPublishSubject openFilterVideoPublisher$delegate = new LazyPublishSubject();
    private DialogfragmentDeviceFilterPageBinding viewDataBinding;
    public DeviceDetailsViewModel viewModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterPageDialogFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.devicedetails.viewmodel.FilterLifeResetResult[] r0 = com.blueair.devicedetails.viewmodel.FilterLifeResetResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.devicedetails.viewmodel.FilterLifeResetResult r1 = com.blueair.devicedetails.viewmodel.FilterLifeResetResult.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.devicedetails.viewmodel.FilterLifeResetResult r1 = com.blueair.devicedetails.viewmodel.FilterLifeResetResult.FAILED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.devicedetails.viewmodel.FilterLifeResetResult r1 = com.blueair.devicedetails.viewmodel.FilterLifeResetResult.DEVICE_OFFLINE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.DeviceFilterPageDialogFragment.WhenMappings.<clinit>():void");
        }
    }

    static {
        Class<DeviceFilterPageDialogFragment> cls = DeviceFilterPageDialogFragment.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "openFilterVideoPublisher", "getOpenFilterVideoPublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "openFilterSelectionPublisher", "getOpenFilterSelectionPublisher()Lio/reactivex/subjects/PublishSubject;", 0))};
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceFilterPageDialogFragment$Companion;", "", "<init>", "()V", "EXTRA_FROM_NOTIFICATION", "", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceFilterPageDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "fromNotification", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterPageDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DeviceFilterPageDialogFragment newInstance$default(Companion companion, Device device, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.newInstance(device, z);
        }

        public final DeviceFilterPageDialogFragment newInstance(Device device, boolean z) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeviceFilterPageDialogFragment deviceFilterPageDialogFragment = new DeviceFilterPageDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("screen_name", z ? AnalyticEvent.ScreenViewEvent.NOTIFICATIONS_FILTER : AnalyticEvent.ScreenViewEvent.DEVICE_DETAILS_FILTER);
            bundle.putParcelable("device", device);
            bundle.putBoolean(DeviceFilterPageDialogFragment.EXTRA_FROM_NOTIFICATION, z);
            deviceFilterPageDialogFragment.setArguments(bundle);
            return deviceFilterPageDialogFragment;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this._screenName;
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

    private final PublishSubject<Boolean> getOpenFilterVideoPublisher() {
        return this.openFilterVideoPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final PublishSubject<Device> getOpenFilterSelectionPublisher() {
        return this.openFilterSelectionPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[1]);
    }

    private final DeviceFilterPageAdapter getAdapter() {
        return (DeviceFilterPageAdapter) this.adapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final DeviceFilterPageAdapter adapter_delegate$lambda$0(DeviceFilterPageDialogFragment deviceFilterPageDialogFragment) {
        return new DeviceFilterPageAdapter(deviceFilterPageDialogFragment.getOpenFilterVideoPublisher(), deviceFilterPageDialogFragment.getOpenFilterSelectionPublisher());
    }

    @Deprecated(message = "Deprecated in Java")
    public void onActivityCreated(Bundle bundle) {
        Window window;
        WindowManager.LayoutParams attributes;
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null && (attributes = window.getAttributes()) != null) {
            attributes.windowAnimations = R.style.dialog_animation;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.DialogTheme);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r2 = r2.getWindowManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStart() {
        /*
            r3 = this;
            super.onStart()
            android.app.Dialog r0 = r3.getDialog()
            if (r0 == 0) goto L_0x003a
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            android.view.Window r2 = r0.getWindow()
            if (r2 == 0) goto L_0x001f
            android.view.WindowManager r2 = r2.getWindowManager()
            if (r2 == 0) goto L_0x001f
            android.view.Display r2 = r2.getDefaultDisplay()
            goto L_0x0020
        L_0x001f:
            r2 = 0
        L_0x0020:
            if (r2 == 0) goto L_0x0025
            r2.getSize(r1)
        L_0x0025:
            android.view.Window r1 = r0.getWindow()
            if (r1 == 0) goto L_0x002f
            r2 = -1
            r1.setLayout(r2, r2)
        L_0x002f:
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L_0x003a
            r1 = 80
            r0.setGravity(r1)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.DeviceFilterPageDialogFragment.onStart():void");
    }

    public void onStop() {
        Window window;
        WindowManager.LayoutParams attributes;
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null || (attributes = window.getAttributes()) == null)) {
            attributes.windowAnimations = R.style.dialog_animation_exit_only;
        }
        super.onStop();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Window window;
        Timber.Forest.d("DialogFragment: onCreateDialog", new Object[0]);
        Dialog dialog = new Dialog(requireContext());
        Bundle arguments = getArguments();
        Device device2 = null;
        this._screenName = arguments != null ? arguments.getString("screen_name") : null;
        Bundle arguments2 = getArguments();
        Device device3 = arguments2 != null ? (Device) arguments2.getParcelable("device") : null;
        if (device3 != null) {
            this.device = device3;
            DeviceConfigProvider deviceConfigProvider = DeviceConfigProvider.INSTANCE;
            Device device4 = this.device;
            if (device4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
            } else {
                device2 = device4;
            }
            this.filterConfig = deviceConfigProvider.getFilterConfig(device2, DeviceFilterType.FILTER);
            Bundle arguments3 = getArguments();
            this.fromNotification = arguments3 != null ? arguments3.getBoolean(EXTRA_FROM_NOTIFICATION) : this.fromNotification;
            Timber.Forest forest = Timber.Forest;
            forest.d("onCreateDialog: dialog = " + dialog, new Object[0]);
            FragmentActivity activity = getActivity();
            if (!(activity == null || (window = dialog.getWindow()) == null)) {
                window.setBackgroundDrawable(ContextCompat.getDrawable(activity, R.drawable.top_rounded_rectangle_white));
            }
            return dialog;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x008c, code lost:
        r11 = r11.getFilters();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r11, android.view.ViewGroup r12, android.os.Bundle r13) {
        /*
            r10 = this;
            java.lang.String r13 = "inflater"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r13)
            r13 = 0
            com.blueair.devicedetails.databinding.DialogfragmentDeviceFilterPageBinding r11 = com.blueair.devicedetails.databinding.DialogfragmentDeviceFilterPageBinding.inflate(r11, r12, r13)
            java.lang.String r12 = "inflate(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            r12 = r10
            com.blueair.viewcore.dialog.BaseDialogFragment r12 = (com.blueair.viewcore.dialog.BaseDialogFragment) r12
            androidx.lifecycle.ViewModelStoreOwner r12 = (androidx.lifecycle.ViewModelStoreOwner) r12
            androidx.lifecycle.ViewModelProvider r0 = new androidx.lifecycle.ViewModelProvider
            r0.<init>((androidx.lifecycle.ViewModelStoreOwner) r12)
            java.lang.Class<com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel> r12 = com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel.class
            androidx.lifecycle.ViewModel r12 = r0.get(r12)
            com.blueair.viewcore.viewmodel.BaseViewModel r12 = (com.blueair.viewcore.viewmodel.BaseViewModel) r12
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r12 = (com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel) r12
            r11.setDeviceDetailViewModel(r12)
            r12 = r10
            androidx.lifecycle.LifecycleOwner r12 = (androidx.lifecycle.LifecycleOwner) r12
            r11.setLifecycleOwner(r12)
            r10.viewDataBinding = r11
            java.lang.String r12 = "viewDataBinding"
            r0 = 0
            if (r11 != 0) goto L_0x0037
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            r11 = r0
        L_0x0037:
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r11 = r11.getDeviceDetailViewModel()
            if (r11 == 0) goto L_0x00f8
            r10.setViewModel((com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel) r11)
            timber.log.Timber$Forest r11 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "onViewCreated: viewModel = "
            r1.<init>(r2)
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r2 = r10.getViewModel()
            r1.append(r2)
            java.lang.String r2 = ",  device = "
            r1.append(r2)
            com.blueair.core.model.Device r2 = r10.device
            java.lang.String r3 = "device"
            if (r2 != 0) goto L_0x005f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r2 = r0
        L_0x005f:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r13 = new java.lang.Object[r13]
            r11.d(r1, r13)
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r11 = r10.getViewModel()
            com.blueair.core.model.Device r13 = r10.device
            if (r13 != 0) goto L_0x0077
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r13 = r0
        L_0x0077:
            r11.setDevice(r13)
            com.blueair.devicedetails.adapter.DeviceFilterPageAdapter r4 = r10.getAdapter()
            com.blueair.core.model.Device r11 = r10.device
            if (r11 != 0) goto L_0x0087
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r5 = r0
            goto L_0x0088
        L_0x0087:
            r5 = r11
        L_0x0088:
            com.blueair.core.model.FilterConfig r11 = r10.filterConfig
            if (r11 == 0) goto L_0x009a
            java.util.List r11 = r11.getFilters()
            if (r11 == 0) goto L_0x009a
            java.lang.Object r11 = kotlin.collections.CollectionsKt.firstOrNull(r11)
            com.blueair.core.model.FilterInfo r11 = (com.blueair.core.model.FilterInfo) r11
            r6 = r11
            goto L_0x009b
        L_0x009a:
            r6 = r0
        L_0x009b:
            com.blueair.viewcore.utils.DeviceConfigProvider r11 = com.blueair.viewcore.utils.DeviceConfigProvider.INSTANCE
            com.blueair.core.model.FilterConfig r13 = r10.filterConfig
            boolean r7 = r11.hasBuyFilterLink(r13)
            com.blueair.devicedetails.dialog.DeviceFilterPageDialogFragment$onCreateView$2 r11 = new com.blueair.devicedetails.dialog.DeviceFilterPageDialogFragment$onCreateView$2
            r11.<init>(r10)
            r8 = r11
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            com.blueair.devicedetails.dialog.DeviceFilterPageDialogFragment$onCreateView$3 r11 = new com.blueair.devicedetails.dialog.DeviceFilterPageDialogFragment$onCreateView$3
            r11.<init>(r10)
            r9 = r11
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r4.setDevice(r5, r6, r7, r8, r9)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceFilterPageBinding r11 = r10.viewDataBinding
            if (r11 != 0) goto L_0x00be
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            r11 = r0
        L_0x00be:
            androidx.appcompat.widget.Toolbar r11 = r11.toolbar
            android.view.Menu r11 = r11.getMenu()
            int r13 = com.blueair.devicedetails.R.id.action_close
            android.view.MenuItem r11 = r11.findItem(r13)
            com.blueair.devicedetails.dialog.DeviceFilterPageDialogFragment$$ExternalSyntheticLambda7 r13 = new com.blueair.devicedetails.dialog.DeviceFilterPageDialogFragment$$ExternalSyntheticLambda7
            r13.<init>(r10)
            r11.setOnMenuItemClickListener(r13)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceFilterPageBinding r11 = r10.viewDataBinding
            if (r11 != 0) goto L_0x00da
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            r11 = r0
        L_0x00da:
            androidx.recyclerview.widget.RecyclerView r11 = r11.filterWidgets
            com.blueair.devicedetails.adapter.DeviceFilterPageAdapter r13 = r10.getAdapter()
            androidx.recyclerview.widget.RecyclerView$Adapter r13 = (androidx.recyclerview.widget.RecyclerView.Adapter) r13
            r11.setAdapter(r13)
            com.blueair.devicedetails.databinding.DialogfragmentDeviceFilterPageBinding r11 = r10.viewDataBinding
            if (r11 != 0) goto L_0x00ed
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r12)
            goto L_0x00ee
        L_0x00ed:
            r0 = r11
        L_0x00ee:
            android.view.View r11 = r0.getRoot()
            java.lang.String r12 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            return r11
        L_0x00f8:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Required value was null."
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.DeviceFilterPageDialogFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    /* access modifiers changed from: private */
    public static final boolean onCreateView$lambda$4(DeviceFilterPageDialogFragment deviceFilterPageDialogFragment, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "it");
        deviceFilterPageDialogFragment.dismiss();
        return true;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("onViewCreated: viewModel = ");
        sb.append(getViewModel());
        sb.append(",  device = ");
        Device device2 = this.device;
        Device device3 = null;
        if (device2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            device2 = null;
        }
        sb.append(device2);
        forest.d(sb.toString(), new Object[0]);
        DeviceDetailsViewModel viewModel2 = getViewModel();
        Device device4 = this.device;
        if (device4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
        } else {
            device3 = device4;
        }
        viewModel2.setDeviceId(device3.getUid());
        bindViewModel();
    }

    public void onResume() {
        super.onResume();
        CompositeDisposable rxSubs = getRxSubs();
        Observable filterRapidClicks = RxExtensionsKt.filterRapidClicks(getOpenFilterVideoPublisher());
        Intrinsics.checkNotNullExpressionValue(filterRapidClicks, "filterRapidClicks(...)");
        rxSubs.add(RxExtensionsKt.subscribeAndLogE(filterRapidClicks, new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda4(this)));
        CompositeDisposable rxSubs2 = getRxSubs();
        Observable filterRapidClicks2 = RxExtensionsKt.filterRapidClicks(getOpenFilterSelectionPublisher());
        Intrinsics.checkNotNullExpressionValue(filterRapidClicks2, "filterRapidClicks(...)");
        rxSubs2.add(RxExtensionsKt.subscribeAndLogE(filterRapidClicks2, new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda5(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$5(DeviceFilterPageDialogFragment deviceFilterPageDialogFragment, Boolean bool) {
        Timber.Forest forest = Timber.Forest;
        forest.v("open video " + bool, new Object[0]);
        DeviceConfigProvider deviceConfigProvider = DeviceConfigProvider.INSTANCE;
        FilterConfig filterConfig2 = deviceFilterPageDialogFragment.filterConfig;
        String awsLinkValue = deviceConfigProvider.getAwsLinkValue(filterConfig2 != null ? filterConfig2.getVideo() : null);
        CharSequence charSequence = awsLinkValue;
        if (!(charSequence == null || charSequence.length() == 0)) {
            FilterVideoActivity.Companion companion = FilterVideoActivity.Companion;
            Context requireContext = deviceFilterPageDialogFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            companion.launch(requireContext, awsLinkValue);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$7(DeviceFilterPageDialogFragment deviceFilterPageDialogFragment, Device device2) {
        Timber.Forest forest = Timber.Forest;
        forest.v("open filter select screen: " + device2, new Object[0]);
        FragmentManager childFragmentManager = deviceFilterPageDialogFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<FilterSelectionDialogFragment> cls = FilterSelectionDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("FilterSelectionDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("FilterSelectionDialogFragment") instanceof FilterSelectionDialogFragment) && !childFragmentManager.isStateSaved()) {
            FilterSelectionDialogFragment.Companion companion = FilterSelectionDialogFragment.Companion;
            Intrinsics.checkNotNull(device2);
            companion.newInstance(device2).show(childFragmentManager, "FilterSelectionDialogFragment");
        }
        return Unit.INSTANCE;
    }

    public void showProgress(boolean z) {
        DialogfragmentDeviceFilterPageBinding dialogfragmentDeviceFilterPageBinding = this.viewDataBinding;
        if (dialogfragmentDeviceFilterPageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceFilterPageBinding = null;
        }
        ProgressBlockerView progressBlockerView = dialogfragmentDeviceFilterPageBinding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        ViewExtensionsKt.show(progressBlockerView, z);
    }

    private final void bindViewModel() {
        LiveData<Device> liveDevice = getViewModel().getLiveDevice();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(liveDevice, viewLifecycleOwner, new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda8(this));
        getViewModel().getResetFilterLifeResult().observe(getViewLifecycleOwner(), new DeviceFilterPageDialogFragment$sam$androidx_lifecycle_Observer$0(new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda9(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$8(DeviceFilterPageDialogFragment deviceFilterPageDialogFragment, Device device2) {
        Timber.Forest forest = Timber.Forest;
        forest.v("liveDevice = " + device2, new Object[0]);
        deviceFilterPageDialogFragment.getViewModel().setDevice(device2);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$10(DeviceFilterPageDialogFragment deviceFilterPageDialogFragment, FilterLifeResetResult filterLifeResetResult) {
        DeviceFilterPageDialogFragment deviceFilterPageDialogFragment2 = deviceFilterPageDialogFragment;
        if (filterLifeResetResult != null) {
            deviceFilterPageDialogFragment2.showProgress(false);
            int i = WhenMappings.$EnumSwitchMapping$0[filterLifeResetResult.ordinal()];
            if (i == 1) {
                DeviceDetailsDialogFragment.Companion.setJumpToAction(NotificationService.ACTION_TYPE_FILTER_STATUS);
                ToastUtils toastUtils = ToastUtils.INSTANCE;
                Context requireContext = deviceFilterPageDialogFragment2.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                toastUtils.showCenterToast(requireContext, R.string.reset_successful, 1);
                FragmentKt.setFragmentResult(deviceFilterPageDialogFragment2, "REQUEST_KEY_HANDLE_ACTION", BundleKt.bundleOf());
                deviceFilterPageDialogFragment2.dismiss();
            } else if (i == 2) {
                FragmentManager childFragmentManager = deviceFilterPageDialogFragment2.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                if (!(childFragmentManager.findFragmentByTag(AccountLinkingActivity.STATE_FAILED) instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
                    ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.reset_failed, (Integer) null, R.string.troubleshotting_reset_filter_internal_error, Integer.valueOf(R.string.snackbar_ok), (Integer) null, false, false, false, true, (String[]) null, (String) null, (Function1) null, 3808, (Object) null).show(childFragmentManager, AccountLinkingActivity.STATE_FAILED);
                }
            } else if (i == 3) {
                deviceFilterPageDialogFragment2.showDeviceOfflinePrompt();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return Unit.INSTANCE;
    }

    private final void showDeviceOfflinePrompt() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        if (!(childFragmentManager.findFragmentByTag("DEVICE_OFFLINE") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.prompt, (Integer) null, R.string.device_offline_retry_prompt, Integer.valueOf(R.string.snackbar_ok), (Integer) null, false, false, false, true, (String[]) null, (String) null, (Function1) null, 3808, (Object) null).show(childFragmentManager, "DEVICE_OFFLINE");
        }
    }

    /* access modifiers changed from: private */
    public final void onResetFilterClick() {
        Device device2 = this.device;
        if (device2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            device2 = null;
        }
        if (device2.getConnectivityStatus() == ConnectivityStatus.ONLINE) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
                ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.reset_filter_life, (Integer) null, R.string.reset_filter_life_confirm_msg, Integer.valueOf(R.string.confirm), Integer.valueOf(R.string.btn_cancel), false, false, false, true, (String[]) null, (String) null, new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda6(this), 1632, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
                return;
            }
            return;
        }
        showDeviceOfflinePrompt();
    }

    /* access modifiers changed from: private */
    public static final Unit onResetFilterClick$lambda$13$lambda$12(DeviceFilterPageDialogFragment deviceFilterPageDialogFragment, boolean z) {
        if (z) {
            deviceFilterPageDialogFragment.showProgress(true);
            DeviceDetailsViewModel viewModel2 = deviceFilterPageDialogFragment.getViewModel();
            Device device2 = deviceFilterPageDialogFragment.device;
            if (device2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
                device2 = null;
            }
            viewModel2.resetFilterLife(device2, DeviceFilterType.FILTER);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void onOrderFilterClick() {
        boolean z;
        List<FilterInfo> filters;
        boolean z2;
        List<FilterInfo> filters2;
        boolean z3;
        FilterConfig filterConfig2 = this.filterConfig;
        boolean z4 = true;
        if (filterConfig2 != null && (filters2 = filterConfig2.getFilters()) != null) {
            Iterable iterable = filters2;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CharSequence ipConfigValue = DeviceConfigProvider.INSTANCE.getIpConfigValue(((FilterInfo) it.next()).getLinkPurchase());
                    if (ipConfigValue == null || ipConfigValue.length() == 0) {
                        z3 = true;
                        continue;
                    } else {
                        z3 = false;
                        continue;
                    }
                    if (!z3) {
                        z = true;
                        break;
                    }
                }
            }
        }
        z = false;
        FilterConfig filterConfig3 = this.filterConfig;
        if (filterConfig3 != null && (filters = filterConfig3.getFilters()) != null) {
            Iterable iterable2 = filters;
            if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                Iterator it2 = iterable2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CharSequence ipConfigValue2 = DeviceConfigProvider.INSTANCE.getIpConfigValue(((FilterInfo) it2.next()).getLinkSubscribe());
                    if (ipConfigValue2 == null || ipConfigValue2.length() == 0) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                    if (!z2) {
                        break;
                    }
                }
            }
        }
        z4 = false;
        if (z && z4) {
            showFilterPurchaseOptionDialog();
        } else if (z && !z4) {
            onFilterOneTimePurchase();
        } else if (!z && z4) {
            onFilterSubscription();
        }
    }

    private final void showFilterPurchaseOptionDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), R.style.BottomSheetDialog);
        BottomSheetFilterOrderBinding inflate = BottomSheetFilterOrderBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.buttonFilterOneTimePurchase.setOnClickListener(new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda0(this, bottomSheetDialog));
        inflate.buttonFilterSubscription.setOnClickListener(new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda1(this, bottomSheetDialog));
        inflate.btnCancel.setOnClickListener(new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda2(bottomSheetDialog));
        bottomSheetDialog.setContentView((View) inflate.getRoot());
        bottomSheetDialog.show();
    }

    /* access modifiers changed from: private */
    public static final void showFilterPurchaseOptionDialog$lambda$16(DeviceFilterPageDialogFragment deviceFilterPageDialogFragment, BottomSheetDialog bottomSheetDialog, View view) {
        deviceFilterPageDialogFragment.onFilterOneTimePurchase();
        bottomSheetDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void showFilterPurchaseOptionDialog$lambda$17(DeviceFilterPageDialogFragment deviceFilterPageDialogFragment, BottomSheetDialog bottomSheetDialog, View view) {
        deviceFilterPageDialogFragment.onFilterSubscription();
        bottomSheetDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void showFilterPurchaseOptionDialog$lambda$18(BottomSheetDialog bottomSheetDialog, View view) {
        bottomSheetDialog.dismiss();
    }

    private final void onFilterOneTimePurchase() {
        List<FilterInfo> filters;
        String str;
        Object obj;
        Device device2;
        FilterConfig filterConfig2 = this.filterConfig;
        if (filterConfig2 != null && (filters = filterConfig2.getFilters()) != null) {
            Iterator it = filters.iterator();
            String str2 = null;
            while (true) {
                if (!it.hasNext()) {
                    str = str2;
                    obj = null;
                    break;
                }
                obj = it.next();
                str = DeviceConfigProvider.INSTANCE.getIpConfigValue(((FilterInfo) obj).getLinkPurchase());
                CharSequence charSequence = str;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    break;
                }
                str2 = str;
            }
            FilterInfo filterInfo = (FilterInfo) obj;
            if (filterInfo != null) {
                DeviceDetailsViewModel viewModel2 = getViewModel();
                Device device3 = this.device;
                if (device3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("device");
                    device2 = null;
                } else {
                    device2 = device3;
                }
                DeviceFilterType deviceFilterType = DeviceFilterType.FILTER;
                String value$default = I18nConfig.getValue$default(filterInfo.getName(), (Locale) null, 1, (Object) null);
                if (value$default == null) {
                    value$default = "";
                }
                viewModel2.analyticsLogFilterClickEvent(device2, true, false, deviceFilterType, value$default, this.fromNotification);
                if (str != null) {
                    DeviceDetailsViewModel viewModel3 = getViewModel();
                    Context requireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                    String string = getString(R.string.order_filter);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    viewModel3.openFilterUrl(requireContext, str, string);
                }
            }
        }
    }

    private final void onFilterSubscription() {
        List<FilterInfo> filters;
        String str;
        Object obj;
        Device device2;
        FilterConfig filterConfig2 = this.filterConfig;
        if (filterConfig2 != null && (filters = filterConfig2.getFilters()) != null) {
            Iterator it = filters.iterator();
            String str2 = null;
            while (true) {
                if (!it.hasNext()) {
                    str = str2;
                    obj = null;
                    break;
                }
                obj = it.next();
                str = DeviceConfigProvider.INSTANCE.getIpConfigValue(((FilterInfo) obj).getLinkSubscribe());
                CharSequence charSequence = str;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    break;
                }
                str2 = str;
            }
            FilterInfo filterInfo = (FilterInfo) obj;
            if (filterInfo != null) {
                DeviceDetailsViewModel viewModel2 = getViewModel();
                Device device3 = this.device;
                if (device3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("device");
                    device2 = null;
                } else {
                    device2 = device3;
                }
                DeviceFilterType deviceFilterType = DeviceFilterType.FILTER;
                String value$default = I18nConfig.getValue$default(filterInfo.getName(), (Locale) null, 1, (Object) null);
                if (value$default == null) {
                    value$default = "";
                }
                viewModel2.analyticsLogFilterClickEvent(device2, false, false, deviceFilterType, value$default, this.fromNotification);
                if (str != null) {
                    DeviceDetailsViewModel viewModel3 = getViewModel();
                    Context requireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                    String string = getString(R.string.order_filter);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    viewModel3.openFilterUrl(requireContext, str, string);
                }
            }
        }
    }
}
