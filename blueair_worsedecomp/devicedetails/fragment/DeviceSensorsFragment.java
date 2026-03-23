package com.blueair.devicedetails.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.SensorType;
import com.blueair.core.service.AnalyticsService;
import com.blueair.devicedetails.databinding.FragmentDeviceSensorsBinding;
import com.blueair.devicedetails.databinding.SensorItemBinding;
import com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel;
import com.blueair.graph.view.FanHistoryGraphView;
import com.blueair.graph.view.GraphView;
import com.blueair.graph.view.IndoorGraphView;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010!\u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\fH\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0003J\b\u0010(\u001a\u00020\fH\u0002J\u0018\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u000eH\u0002J\u001e\u0010-\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u000101H\u0002J\u0012\u00102\u001a\u0004\u0018\u00010+2\u0006\u00103\u001a\u00020'H\u0002J\u0010\u00104\u001a\u00020\f2\u0006\u0010&\u001a\u00020'H\u0002J\u0012\u00105\u001a\u0004\u0018\u00010/2\u0006\u00106\u001a\u000207H\u0003R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceSensorsFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "<init>", "()V", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "getAnalyticsService", "()Lcom/blueair/core/service/AnalyticsService;", "analyticsService$delegate", "Lkotlin/Lazy;", "showProgress", "", "shouldShowProgress", "", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;)V", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/FragmentDeviceSensorsBinding;", "tabSelected", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "onDestroyView", "observeViewModel", "getSensorTitle", "", "sensorType", "Lcom/blueair/core/model/SensorType;", "initUi", "updateSelectedTab", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "selected", "updateTabs", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "outdoorDataPoint", "Lcom/blueair/core/model/AqiData;", "getTab", "sensor", "updateSensorInfo", "getIndoorDataForTimestamp", "unixTime", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSensorsFragment.kt */
public final class DeviceSensorsFragment extends BaseFragment<DeviceSensorsViewModel> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_DEVICE = "KEY_DEVICE";
    /* access modifiers changed from: private */
    public static final String TAG;
    private final Lazy analyticsService$delegate;
    /* access modifiers changed from: private */
    public boolean tabSelected;
    /* access modifiers changed from: private */
    public FragmentDeviceSensorsBinding viewDataBinding;
    public DeviceSensorsViewModel viewModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSensorsFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(2:17|18)|19|21) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|21) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.core.model.SensorType[] r0 = com.blueair.core.model.SensorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM1     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM25     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM10     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.VOC     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.HCHO     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.HUM     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.TMP     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.FAN     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.WEIGHT     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.fragment.DeviceSensorsFragment.WhenMappings.<clinit>():void");
        }
    }

    static {
        Class<DeviceSensorsFragment> cls = DeviceSensorsFragment.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "analyticsService", "getAnalyticsService()Lcom/blueair/core/service/AnalyticsService;", 0))};
        TAG = Reflection.getOrCreateKotlinClass(cls).getSimpleName();
    }

    public void showProgress(boolean z) {
    }

    public DeviceSensorsFragment() {
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new DeviceSensorsFragment$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.analyticsService$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, AnalyticsService.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceSensorsFragment$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "KEY_DEVICE", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceSensorsFragment;", "device", "Lcom/blueair/core/model/HasSensorData;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSensorsFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return DeviceSensorsFragment.TAG;
        }

        public final DeviceSensorsFragment newInstance(HasSensorData hasSensorData) {
            Intrinsics.checkNotNullParameter(hasSensorData, "device");
            DeviceSensorsFragment deviceSensorsFragment = new DeviceSensorsFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(DeviceSensorsFragment.KEY_DEVICE, hasSensorData);
            deviceSensorsFragment.setArguments(bundle);
            return deviceSensorsFragment;
        }
    }

    private final AnalyticsService getAnalyticsService() {
        return (AnalyticsService) this.analyticsService$delegate.getValue();
    }

    public DeviceSensorsViewModel getViewModel() {
        DeviceSensorsViewModel deviceSensorsViewModel = this.viewModel;
        if (deviceSensorsViewModel != null) {
            return deviceSensorsViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(DeviceSensorsViewModel deviceSensorsViewModel) {
        Intrinsics.checkNotNullParameter(deviceSensorsViewModel, "<set-?>");
        this.viewModel = deviceSensorsViewModel;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentDeviceSensorsBinding inflate = FragmentDeviceSensorsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.setDeviceSensorViewModel((DeviceSensorsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DeviceSensorsViewModel.class)));
        inflate.setLifecycleOwner(getViewLifecycleOwner());
        this.viewDataBinding = inflate;
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            inflate = null;
        }
        ViewGroup.LayoutParams layoutParams = inflate.getRoot().getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding2 = this.viewDataBinding;
        if (fragmentDeviceSensorsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding2 = null;
        }
        fragmentDeviceSensorsBinding2.getRoot().setLayoutParams(layoutParams);
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("onCreateView: viewDataBinding = ");
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding3 = this.viewDataBinding;
        if (fragmentDeviceSensorsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding3 = null;
        }
        sb.append(fragmentDeviceSensorsBinding3);
        sb.append(", root = ");
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding4 = this.viewDataBinding;
        if (fragmentDeviceSensorsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding4 = null;
        }
        sb.append(fragmentDeviceSensorsBinding4.getRoot());
        sb.append(", outdoorViewModel = ");
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding5 = this.viewDataBinding;
        if (fragmentDeviceSensorsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding5 = null;
        }
        sb.append(fragmentDeviceSensorsBinding5.getDeviceSensorViewModel());
        forest.d(sb.toString(), new Object[0]);
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding6 = this.viewDataBinding;
        if (fragmentDeviceSensorsBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding6 = null;
        }
        DeviceSensorsViewModel deviceSensorViewModel = fragmentDeviceSensorsBinding6.getDeviceSensorViewModel();
        if (deviceSensorViewModel != null) {
            setViewModel(deviceSensorViewModel);
            DeviceSensorsViewModel viewModel2 = getViewModel();
            Bundle arguments = getArguments();
            HasSensorData hasSensorData = arguments != null ? (HasSensorData) arguments.getParcelable(KEY_DEVICE) : null;
            if (hasSensorData != null) {
                DeviceSensorsViewModel.init$default(viewModel2, hasSensorData, false, 2, (Object) null);
                FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding7 = this.viewDataBinding;
                if (fragmentDeviceSensorsBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                } else {
                    fragmentDeviceSensorsBinding = fragmentDeviceSensorsBinding7;
                }
                View root = fragmentDeviceSensorsBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                return root;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        initUi();
        observeViewModel();
    }

    public void onResume() {
        super.onResume();
        getViewModel().refresh();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    private final void observeViewModel() {
        getViewModel().getLiveSelectedSensor().observe(getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda8(this));
        getViewModel().getLiveSelectedSensorHistoricalData().observe(getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda11(this));
        getViewModel().getLiveSelectedSensorRealTimeData().observe(getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda12(this));
        getViewModel().getHistoricalDataListener().observe(getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda13());
        getViewModel().getRealTimeDataListener().observe(getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda14());
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding = this.viewDataBinding;
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding2 = null;
        if (fragmentDeviceSensorsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding = null;
        }
        fragmentDeviceSensorsBinding.deviceGraph.getLiveSelectedDataPoint().observe(getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda1(this));
        if (getViewModel().getShowFanHistory()) {
            FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding3 = this.viewDataBinding;
            if (fragmentDeviceSensorsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                fragmentDeviceSensorsBinding3 = null;
            }
            fragmentDeviceSensorsBinding3.deviceGraph.getLiveScale().observe(getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda2(this));
            FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding4 = this.viewDataBinding;
            if (fragmentDeviceSensorsBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                fragmentDeviceSensorsBinding4 = null;
            }
            fragmentDeviceSensorsBinding4.deviceGraph.getLiveTimeStamps().observe(getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda3(this));
            FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding5 = this.viewDataBinding;
            if (fragmentDeviceSensorsBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                fragmentDeviceSensorsBinding5 = null;
            }
            fragmentDeviceSensorsBinding5.fanGraph.getLiveScale().observe(getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda4(this));
            getViewModel().getLiveFanSensorHistoricalData().observe(getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda5(this));
            getViewModel().getLiveFanSensorRealTimeData().observe(getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda9(this));
            FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding6 = this.viewDataBinding;
            if (fragmentDeviceSensorsBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                fragmentDeviceSensorsBinding2 = fragmentDeviceSensorsBinding6;
            }
            fragmentDeviceSensorsBinding2.fanGraph.getLiveSelectedDataPoint().observe(getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda10(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void observeViewModel$lambda$2(DeviceSensorsFragment deviceSensorsFragment, SensorType sensorType) {
        if (sensorType != null) {
            Timber.Forest forest = Timber.Forest;
            forest.d("selected sensor = " + sensorType, new Object[0]);
            FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding = deviceSensorsFragment.viewDataBinding;
            if (fragmentDeviceSensorsBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                fragmentDeviceSensorsBinding = null;
            }
            fragmentDeviceSensorsBinding.deviceGraph.setSensorType(sensorType);
            deviceSensorsFragment.updateSensorInfo(sensorType);
        }
    }

    /* access modifiers changed from: private */
    public static final void observeViewModel$lambda$3(DeviceSensorsFragment deviceSensorsFragment, List list) {
        Timber.Forest forest = Timber.Forest;
        forest.d("liveSelectedSensorHistoricalData: size = " + list.size() + ", thread = " + Thread.currentThread(), new Object[0]);
        LifecycleOwner viewLifecycleOwner = deviceSensorsFragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getIO(), (CoroutineStart) null, new DeviceSensorsFragment$observeViewModel$2$1(deviceSensorsFragment, list, (Continuation<? super DeviceSensorsFragment$observeViewModel$2$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void observeViewModel$lambda$4(DeviceSensorsFragment deviceSensorsFragment, List list) {
        Timber.Forest forest = Timber.Forest;
        forest.d("liveSelectedSensorRealTimeData: size = " + list.size() + ", time = " + Calendar.getInstance().getTime(), new Object[0]);
        LifecycleOwner viewLifecycleOwner = deviceSensorsFragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getIO(), (CoroutineStart) null, new DeviceSensorsFragment$observeViewModel$3$1(deviceSensorsFragment, list, (Continuation<? super DeviceSensorsFragment$observeViewModel$3$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void observeViewModel$lambda$5(Object obj) {
        Timber.Forest forest = Timber.Forest;
        forest.d("historicalDataListener: thread = " + Thread.currentThread(), new Object[0]);
    }

    /* access modifiers changed from: private */
    public static final void observeViewModel$lambda$6(Object obj) {
        Timber.Forest forest = Timber.Forest;
        forest.d("realTimeDataListener: thread = " + Thread.currentThread(), new Object[0]);
    }

    /* access modifiers changed from: private */
    public static final void observeViewModel$lambda$7(DeviceSensorsFragment deviceSensorsFragment, GraphView.SelectedPoint selectedPoint) {
        LifecycleOwner viewLifecycleOwner = deviceSensorsFragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getMain(), (CoroutineStart) null, new DeviceSensorsFragment$observeViewModel$6$1(selectedPoint, deviceSensorsFragment, (Continuation<? super DeviceSensorsFragment$observeViewModel$6$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void observeViewModel$lambda$8(DeviceSensorsFragment deviceSensorsFragment, GraphView.ScaleEvent scaleEvent) {
        Timber.Forest.d("deviceGraph.liveScale: scale = " + scaleEvent, new Object[0]);
        if (scaleEvent.getExplicit()) {
            FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding = deviceSensorsFragment.viewDataBinding;
            if (fragmentDeviceSensorsBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                fragmentDeviceSensorsBinding = null;
            }
            GraphView.updateScale$default(fragmentDeviceSensorsBinding.fanGraph, scaleEvent.getTimeScale(), false, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void observeViewModel$lambda$9(DeviceSensorsFragment deviceSensorsFragment, Set set) {
        Timber.Forest forest = Timber.Forest;
        forest.d("deviceGraphliveTimeStamps: timeStamps = " + set, new Object[0]);
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding = deviceSensorsFragment.viewDataBinding;
        if (fragmentDeviceSensorsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding = null;
        }
        FanHistoryGraphView fanHistoryGraphView = fragmentDeviceSensorsBinding.fanGraph;
        Intrinsics.checkNotNull(set);
        fanHistoryGraphView.setTimeStampFilter(set);
    }

    /* access modifiers changed from: private */
    public static final void observeViewModel$lambda$10(DeviceSensorsFragment deviceSensorsFragment, GraphView.ScaleEvent scaleEvent) {
        Timber.Forest.d("fanGraph.liveScale: scale = " + scaleEvent, new Object[0]);
        if (scaleEvent.getExplicit()) {
            FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding = deviceSensorsFragment.viewDataBinding;
            if (fragmentDeviceSensorsBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                fragmentDeviceSensorsBinding = null;
            }
            GraphView.updateScale$default(fragmentDeviceSensorsBinding.deviceGraph, scaleEvent.getTimeScale(), false, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void observeViewModel$lambda$11(DeviceSensorsFragment deviceSensorsFragment, List list) {
        Timber.Forest forest = Timber.Forest;
        forest.d("liveFanSensorHistoricalData: size = " + list.size() + ", thread = " + Thread.currentThread(), new Object[0]);
        LifecycleOwner viewLifecycleOwner = deviceSensorsFragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getIO(), (CoroutineStart) null, new DeviceSensorsFragment$observeViewModel$10$1(list, deviceSensorsFragment, (Continuation<? super DeviceSensorsFragment$observeViewModel$10$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void observeViewModel$lambda$12(DeviceSensorsFragment deviceSensorsFragment, List list) {
        Timber.Forest forest = Timber.Forest;
        forest.d("liveFanSensorRealTimeData: size = " + list.size() + ", thread = " + Thread.currentThread(), new Object[0]);
        LifecycleOwner viewLifecycleOwner = deviceSensorsFragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getIO(), (CoroutineStart) null, new DeviceSensorsFragment$observeViewModel$11$1(list, deviceSensorsFragment, (Continuation<? super DeviceSensorsFragment$observeViewModel$11$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void observeViewModel$lambda$13(DeviceSensorsFragment deviceSensorsFragment, GraphView.SelectedPoint selectedPoint) {
        Timber.Forest.d("fanGraph.liveSelectedDataPoint: explicit = " + selectedPoint.getExplicit(), new Object[0]);
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding = deviceSensorsFragment.viewDataBinding;
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding2 = null;
        if (fragmentDeviceSensorsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding = null;
        }
        fragmentDeviceSensorsBinding.fanValue.setText(String.valueOf(MathKt.roundToInt(selectedPoint.getPoint().getValue())));
        if (selectedPoint.getExplicit()) {
            FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding3 = deviceSensorsFragment.viewDataBinding;
            if (fragmentDeviceSensorsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                fragmentDeviceSensorsBinding2 = fragmentDeviceSensorsBinding3;
            }
            fragmentDeviceSensorsBinding2.deviceGraph.gotoTime(selectedPoint.getPoint().getTimeInMillis());
        }
    }

    private final int getSensorTitle(SensorType sensorType) {
        switch (WhenMappings.$EnumSwitchMapping$0[sensorType.ordinal()]) {
            case 1:
                return R.string.pm1_title_short;
            case 2:
                return R.string.pm25_title;
            case 3:
                return R.string.pm10_title_short;
            case 4:
                return R.string.voc_title_short;
            case 5:
                return R.string.hcho_title;
            case 6:
                return R.string.hum_expanded;
            case 7:
                return R.string.temp_expanded;
            case 8:
                return R.string.fan_title;
            case 9:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void initUi() {
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding = this.viewDataBinding;
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding2 = null;
        if (fragmentDeviceSensorsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding = null;
        }
        IndoorGraphView indoorGraphView = fragmentDeviceSensorsBinding.deviceGraph;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        indoorGraphView.attachLifeCycle(viewLifecycleOwner);
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding3 = this.viewDataBinding;
        if (fragmentDeviceSensorsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding3 = null;
        }
        FanHistoryGraphView fanHistoryGraphView = fragmentDeviceSensorsBinding3.fanGraph;
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        fanHistoryGraphView.attachLifeCycle(viewLifecycleOwner2);
        Iterator it = getViewModel().getSupportedSensors().iterator();
        int i = 0;
        while (true) {
            int i2 = 8;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SensorType sensorType = (SensorType) next;
            View inflate = LayoutInflater.from(getContext()).inflate(com.blueair.devicedetails.R.layout.sensor_item, (ViewGroup) null);
            FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding4 = this.viewDataBinding;
            if (fragmentDeviceSensorsBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                fragmentDeviceSensorsBinding4 = null;
            }
            TabLayout.Tab newTab = fragmentDeviceSensorsBinding4.sensorTabs.newTab();
            Intrinsics.checkNotNullExpressionValue(newTab, "newTab(...)");
            newTab.setCustomView(inflate);
            newTab.view.setBackground((Drawable) null);
            newTab.view.setPadding(12, 0, 12, 0);
            ((TextView) inflate.findViewById(com.blueair.devicedetails.R.id.sensor_label)).setText(getSensorTitle(sensorType));
            ImageView imageView = (ImageView) inflate.findViewById(com.blueair.devicedetails.R.id.sensor_color);
            if (!SetsKt.setOf(SensorType.HUM, SensorType.TMP).contains(sensorType)) {
                i2 = 0;
            }
            imageView.setVisibility(i2);
            FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding5 = this.viewDataBinding;
            if (fragmentDeviceSensorsBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                fragmentDeviceSensorsBinding5 = null;
            }
            fragmentDeviceSensorsBinding5.sensorTabs.addTab(newTab);
            ViewCompat.setAccessibilityDelegate(newTab.view, new DeviceSensorsFragment$initUi$1$1(this, i));
            i = i3;
        }
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding6 = this.viewDataBinding;
        if (fragmentDeviceSensorsBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding6 = null;
        }
        fragmentDeviceSensorsBinding6.sensorTabs.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new DeviceSensorsFragment$initUi$2(this));
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding7 = this.viewDataBinding;
        if (fragmentDeviceSensorsBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding7 = null;
        }
        int selectedTabPosition = fragmentDeviceSensorsBinding7.sensorTabs.getSelectedTabPosition();
        int sensorPos = getViewModel().getSensorPos(getViewModel().getSelectedSensor());
        if (selectedTabPosition == sensorPos) {
            FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding8 = this.viewDataBinding;
            if (fragmentDeviceSensorsBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                fragmentDeviceSensorsBinding8 = null;
            }
            TabLayout.Tab tabAt = fragmentDeviceSensorsBinding8.sensorTabs.getTabAt(selectedTabPosition);
            if (tabAt != null) {
                updateSelectedTab(tabAt, true);
            }
        } else {
            FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding9 = this.viewDataBinding;
            if (fragmentDeviceSensorsBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                fragmentDeviceSensorsBinding9 = null;
            }
            TabLayout.Tab tabAt2 = fragmentDeviceSensorsBinding9.sensorTabs.getTabAt(sensorPos);
            if (tabAt2 != null) {
                FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding10 = this.viewDataBinding;
                if (fragmentDeviceSensorsBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                    fragmentDeviceSensorsBinding10 = null;
                }
                fragmentDeviceSensorsBinding10.sensorTabs.selectTab(tabAt2);
            }
        }
        if (getViewModel().getShowFanHistory()) {
            FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding11 = this.viewDataBinding;
            if (fragmentDeviceSensorsBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                fragmentDeviceSensorsBinding11 = null;
            }
            fragmentDeviceSensorsBinding11.buttonCollapse.setVisibility(0);
        } else {
            FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding12 = this.viewDataBinding;
            if (fragmentDeviceSensorsBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                fragmentDeviceSensorsBinding12 = null;
            }
            fragmentDeviceSensorsBinding12.buttonCollapse.setVisibility(8);
        }
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding13 = this.viewDataBinding;
        if (fragmentDeviceSensorsBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding13 = null;
        }
        fragmentDeviceSensorsBinding13.buttonCollapse.setOnClickListener(new DeviceSensorsFragment$$ExternalSyntheticLambda6(this));
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding14 = this.viewDataBinding;
        if (fragmentDeviceSensorsBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            fragmentDeviceSensorsBinding2 = fragmentDeviceSensorsBinding14;
        }
        MaterialButton buttonInfo = fragmentDeviceSensorsBinding2.deviceGraph.getButtonInfo();
        if (buttonInfo != null) {
            buttonInfo.setOnClickListener(new DeviceSensorsFragment$$ExternalSyntheticLambda7(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$18(DeviceSensorsFragment deviceSensorsFragment, View view) {
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding = deviceSensorsFragment.viewDataBinding;
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding2 = null;
        if (fragmentDeviceSensorsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding = null;
        }
        if (fragmentDeviceSensorsBinding.fanGraph.getVisibility() == 0) {
            FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding3 = deviceSensorsFragment.viewDataBinding;
            if (fragmentDeviceSensorsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                fragmentDeviceSensorsBinding3 = null;
            }
            fragmentDeviceSensorsBinding3.fanGraph.setVisibility(8);
            FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding4 = deviceSensorsFragment.viewDataBinding;
            if (fragmentDeviceSensorsBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                fragmentDeviceSensorsBinding4 = null;
            }
            fragmentDeviceSensorsBinding4.fanValue.setVisibility(4);
            FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding5 = deviceSensorsFragment.viewDataBinding;
            if (fragmentDeviceSensorsBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                fragmentDeviceSensorsBinding2 = fragmentDeviceSensorsBinding5;
            }
            fragmentDeviceSensorsBinding2.buttonCollapse.setIconResource(R.drawable.ic_chevron_down_marineblue);
            return;
        }
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding6 = deviceSensorsFragment.viewDataBinding;
        if (fragmentDeviceSensorsBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding6 = null;
        }
        fragmentDeviceSensorsBinding6.fanGraph.setVisibility(0);
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding7 = deviceSensorsFragment.viewDataBinding;
        if (fragmentDeviceSensorsBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding7 = null;
        }
        fragmentDeviceSensorsBinding7.fanValue.setVisibility(0);
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding8 = deviceSensorsFragment.viewDataBinding;
        if (fragmentDeviceSensorsBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding8 = null;
        }
        fragmentDeviceSensorsBinding8.buttonCollapse.setIconResource(R.drawable.ic_chevron_up_marineblue);
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding9 = deviceSensorsFragment.viewDataBinding;
        if (fragmentDeviceSensorsBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            fragmentDeviceSensorsBinding2 = fragmentDeviceSensorsBinding9;
        }
        fragmentDeviceSensorsBinding2.fanGraph.post(new DeviceSensorsFragment$$ExternalSyntheticLambda0(deviceSensorsFragment));
        deviceSensorsFragment.getAnalyticsService().event(new AnalyticEvent.OPEN_FAN_HISTORY());
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$18$lambda$17(DeviceSensorsFragment deviceSensorsFragment) {
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding = deviceSensorsFragment.viewDataBinding;
        if (fragmentDeviceSensorsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding = null;
        }
        fragmentDeviceSensorsBinding.fanGraph.refresh();
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$20(DeviceSensorsFragment deviceSensorsFragment, View view) {
        int i;
        Integer num;
        FragmentManager childFragmentManager = deviceSensorsFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
            SensorType selectedSensor = deviceSensorsFragment.getViewModel().getSelectedSensor();
            DeviceSensorsFragment deviceSensorsFragment2 = deviceSensorsFragment;
            int sensorTitle = deviceSensorsFragment2.getSensorTitle(selectedSensor);
            switch (WhenMappings.$EnumSwitchMapping$0[selectedSensor.ordinal()]) {
                case 1:
                    i = R.string.pm1_descript;
                    break;
                case 2:
                    i = R.string.pm25_descript;
                    break;
                case 3:
                    i = R.string.pm10_descript;
                    break;
                case 4:
                    i = R.string.voc_descript;
                    break;
                case 5:
                    i = R.string.hcho_descript;
                    break;
                case 6:
                    i = R.string.humid_descript;
                    break;
                case 7:
                    i = R.string.temp_descript;
                    break;
                case 8:
                case 9:
                    i = 0;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            int i2 = i;
            int i3 = WhenMappings.$EnumSwitchMapping$0[selectedSensor.ordinal()];
            if (i3 == 1 || i3 == 2 || i3 == 3) {
                num = Integer.valueOf(R.string.f68g_m3);
            } else if (i3 == 4) {
                num = Integer.valueOf(R.string.voc_unit);
            } else if (i3 == 5) {
                num = Integer.valueOf(R.string.mg_m3);
            } else if (i3 != 7) {
                num = null;
            } else {
                num = Integer.valueOf(deviceSensorsFragment2.getViewModel().isTempCelsius() ? R.string.temperature_celsius : R.string.temperature_fahrenheit);
            }
            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, sensorTitle, num, i2, Integer.valueOf(R.string.close), (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 4032, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
        }
    }

    /* access modifiers changed from: private */
    public final void updateSelectedTab(TabLayout.Tab tab, boolean z) {
        Timber.Forest forest = Timber.Forest;
        forest.d("updateSelected: tab = " + tab.getPosition() + ", selected = " + z, new Object[0]);
        SensorItemBinding bind = SensorItemBinding.bind(tab.view);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        bind.sensorLabel.setSelected(z);
        bind.sensorVal.setSelected(z);
        bind.sensorAltVal.setSelected(z);
        LinearLayout linearLayout = bind.sensorLayout;
        linearLayout.setAlpha(z ? 1.0f : 0.9f);
        linearLayout.setSelected(z);
    }

    static /* synthetic */ void updateTabs$default(DeviceSensorsFragment deviceSensorsFragment, IndoorDatapoint indoorDatapoint, AqiData aqiData, int i, Object obj) {
        if ((i & 2) != 0) {
            aqiData = null;
        }
        deviceSensorsFragment.updateTabs(indoorDatapoint, aqiData);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f3, code lost:
        r3 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateTabs(com.blueair.core.model.IndoorDatapoint r10, com.blueair.core.model.AqiData r11) {
        /*
            r9 = this;
            boolean r0 = r9.tabSelected
            r1 = 0
            if (r0 == 0) goto L_0x0008
            r9.tabSelected = r1
            return
        L_0x0008:
            com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel r0 = r9.getViewModel()
            java.util.List r0 = r0.getSupportedSensors()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0016:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x01cf
            java.lang.Object r2 = r0.next()
            com.blueair.core.model.SensorType r2 = (com.blueair.core.model.SensorType) r2
            com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel r3 = r9.getViewModel()
            com.blueair.core.util.IndoorAirRatingRanges r3 = r3.getIndoorAirRatings()
            int[] r4 = com.blueair.devicedetails.fragment.DeviceSensorsFragment.WhenMappings.$EnumSwitchMapping$0
            int r5 = r2.ordinal()
            r4 = r4[r5]
            r5 = 0
            switch(r4) {
                case 1: goto L_0x00d5;
                case 2: goto L_0x00b7;
                case 3: goto L_0x0099;
                case 4: goto L_0x007b;
                case 5: goto L_0x005c;
                case 6: goto L_0x0054;
                case 7: goto L_0x004c;
                case 8: goto L_0x0044;
                case 9: goto L_0x003c;
                default: goto L_0x0036;
            }
        L_0x0036:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L_0x003c:
            if (r10 == 0) goto L_0x00f3
            java.lang.Float r3 = r10.getWeight()
            goto L_0x00f4
        L_0x0044:
            if (r10 == 0) goto L_0x00f3
            java.lang.Float r3 = r10.getFan()
            goto L_0x00f4
        L_0x004c:
            if (r10 == 0) goto L_0x00f3
            java.lang.Float r3 = r10.getTmp()
            goto L_0x00f4
        L_0x0054:
            if (r10 == 0) goto L_0x00f3
            java.lang.Float r3 = r10.getHum()
            goto L_0x00f4
        L_0x005c:
            if (r10 == 0) goto L_0x00f3
            java.lang.Float r4 = r10.getHcho()
            if (r4 == 0) goto L_0x00f3
            float r4 = r4.floatValue()
            double[] r3 = r3.getHchoRanges()
            double r6 = kotlin.collections.ArraysKt.last((double[]) r3)
            float r3 = (float) r6
            float r3 = kotlin.ranges.RangesKt.coerceAtMost((float) r4, (float) r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            goto L_0x00f4
        L_0x007b:
            if (r10 == 0) goto L_0x00f3
            java.lang.Float r4 = r10.getVoc()
            if (r4 == 0) goto L_0x00f3
            float r4 = r4.floatValue()
            double[] r3 = r3.getVocRanges()
            double r6 = kotlin.collections.ArraysKt.last((double[]) r3)
            float r3 = (float) r6
            float r3 = kotlin.ranges.RangesKt.coerceAtMost((float) r4, (float) r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            goto L_0x00f4
        L_0x0099:
            if (r10 == 0) goto L_0x00f3
            java.lang.Float r4 = r10.getPm10()
            if (r4 == 0) goto L_0x00f3
            float r4 = r4.floatValue()
            double[] r3 = r3.getPm10Ranges()
            double r6 = kotlin.collections.ArraysKt.last((double[]) r3)
            float r3 = (float) r6
            float r3 = kotlin.ranges.RangesKt.coerceAtMost((float) r4, (float) r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            goto L_0x00f4
        L_0x00b7:
            if (r10 == 0) goto L_0x00f3
            java.lang.Float r4 = r10.getPm25()
            if (r4 == 0) goto L_0x00f3
            float r4 = r4.floatValue()
            double[] r3 = r3.getPm25Ranges()
            double r6 = kotlin.collections.ArraysKt.last((double[]) r3)
            float r3 = (float) r6
            float r3 = kotlin.ranges.RangesKt.coerceAtMost((float) r4, (float) r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            goto L_0x00f4
        L_0x00d5:
            if (r10 == 0) goto L_0x00f3
            java.lang.Float r4 = r10.getPm1()
            if (r4 == 0) goto L_0x00f3
            float r4 = r4.floatValue()
            double[] r3 = r3.getPm1Ranges()
            double r6 = kotlin.collections.ArraysKt.last((double[]) r3)
            float r3 = (float) r6
            float r3 = kotlin.ranges.RangesKt.coerceAtMost((float) r4, (float) r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            goto L_0x00f4
        L_0x00f3:
            r3 = r5
        L_0x00f4:
            int[] r4 = com.blueair.devicedetails.fragment.DeviceSensorsFragment.WhenMappings.$EnumSwitchMapping$0
            int r6 = r2.ordinal()
            r4 = r4[r6]
            r6 = 2
            if (r4 == r6) goto L_0x0116
            r6 = 3
            if (r4 == r6) goto L_0x0103
            goto L_0x0128
        L_0x0103:
            if (r11 == 0) goto L_0x0128
            com.blueair.core.model.OutdoorPollutants r4 = r11.getPollutants()
            if (r4 == 0) goto L_0x0128
            com.blueair.core.model.Pollutant r4 = r4.getPm10()
            if (r4 == 0) goto L_0x0128
            java.lang.Double r5 = r4.getConcentration()
            goto L_0x0128
        L_0x0116:
            if (r11 == 0) goto L_0x0128
            com.blueair.core.model.OutdoorPollutants r4 = r11.getPollutants()
            if (r4 == 0) goto L_0x0128
            com.blueair.core.model.Pollutant r4 = r4.getPm25()
            if (r4 == 0) goto L_0x0128
            java.lang.Double r5 = r4.getConcentration()
        L_0x0128:
            com.google.android.material.tabs.TabLayout$Tab r4 = r9.getTab(r2)
            if (r4 == 0) goto L_0x0016
            com.google.android.material.tabs.TabLayout$TabView r4 = r4.view
            android.view.View r4 = (android.view.View) r4
            com.blueair.devicedetails.databinding.SensorItemBinding r4 = com.blueair.devicedetails.databinding.SensorItemBinding.bind(r4)
            java.lang.String r6 = "bind(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            android.widget.TextView r6 = r4.sensorVal
            java.lang.String r7 = "sensorVal"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            android.widget.TextView r7 = r4.sensorAltVal
            java.lang.String r8 = "sensorAltVal"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            android.widget.ImageView r4 = r4.sensorColor
            java.lang.String r8 = "sensorColor"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r8)
            java.lang.String r8 = r2.formatValue(r3)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r6.setText(r8)
            if (r3 == 0) goto L_0x019a
            com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel r6 = r9.getViewModel()
            com.blueair.core.util.IndoorAirRatingRanges r6 = r6.getIndoorAirRatings()
            float r8 = r3.floatValue()
            int r2 = r6.getRangePosition(r8, r2)
            if (r2 < 0) goto L_0x017a
            com.blueair.graph.utils.GraphUiUtils r6 = com.blueair.graph.utils.GraphUiUtils.INSTANCE
            java.util.List r6 = r6.getSeverityDots()
            int r6 = r6.size()
            if (r2 >= r6) goto L_0x017a
            goto L_0x0186
        L_0x017a:
            com.blueair.graph.utils.GraphUiUtils r2 = com.blueair.graph.utils.GraphUiUtils.INSTANCE
            java.util.List r2 = r2.getSeverityDots()
            int r2 = r2.size()
            int r2 = r2 + -1
        L_0x0186:
            com.blueair.graph.utils.GraphUiUtils r6 = com.blueair.graph.utils.GraphUiUtils.INSTANCE
            java.util.List r6 = r6.getSeverityDots()
            java.lang.Object r2 = r6.get(r2)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            r4.setImageResource(r2)
            goto L_0x019f
        L_0x019a:
            int r2 = com.blueair.viewcore.R.drawable.ic_marker_dot_good
            r4.setImageResource(r2)
        L_0x019f:
            if (r3 == 0) goto L_0x01c8
            if (r5 == 0) goto L_0x01c8
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "("
            r2.<init>(r3)
            double r3 = r5.doubleValue()
            int r3 = kotlin.math.MathKt.roundToInt((double) r3)
            r2.append(r3)
            r3 = 41
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r7.setText(r2)
            r7.setVisibility(r1)
            goto L_0x0016
        L_0x01c8:
            r2 = 8
            r7.setVisibility(r2)
            goto L_0x0016
        L_0x01cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.fragment.DeviceSensorsFragment.updateTabs(com.blueair.core.model.IndoorDatapoint, com.blueair.core.model.AqiData):void");
    }

    private final TabLayout.Tab getTab(SensorType sensorType) {
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding = this.viewDataBinding;
        if (fragmentDeviceSensorsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding = null;
        }
        return fragmentDeviceSensorsBinding.sensorTabs.getTabAt(getViewModel().getSensorPos(sensorType));
    }

    private final void updateSensorInfo(SensorType sensorType) {
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding = this.viewDataBinding;
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding2 = null;
        if (fragmentDeviceSensorsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentDeviceSensorsBinding = null;
        }
        MaterialButton buttonInfo = fragmentDeviceSensorsBinding.deviceGraph.getButtonInfo();
        if (buttonInfo != null) {
            ViewExtensionsKt.show$default(buttonInfo, false, 1, (Object) null);
        }
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding3 = this.viewDataBinding;
        if (fragmentDeviceSensorsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            fragmentDeviceSensorsBinding2 = fragmentDeviceSensorsBinding3;
        }
        MaterialButton buttonInfo2 = fragmentDeviceSensorsBinding2.deviceGraph.getButtonInfo();
        if (buttonInfo2 != null) {
            buttonInfo2.setText(getString(R.string.title_activity_about) + TokenParser.SP + getString(getSensorTitle(sensorType)));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.blueair.core.model.IndoorDatapoint getIndoorDataForTimestamp(long r12) {
        /*
            r11 = this;
            com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel r0 = r11.getViewModel()
            com.blueair.core.model.DeviceData r0 = r0.getLastDeviceHistoricalData()
            if (r0 == 0) goto L_0x0010
            java.util.List r0 = r0.getDatapoints()
            if (r0 != 0) goto L_0x0014
        L_0x0010:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0014:
            com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel r1 = r11.getViewModel()
            com.blueair.core.model.DeviceData r1 = r1.getLastDeviceRealTimeData()
            if (r1 == 0) goto L_0x0024
            java.util.List r1 = r1.getDatapoints()
            if (r1 != 0) goto L_0x0028
        L_0x0024:
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0028:
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x004a
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0034
            goto L_0x004a
        L_0x0034:
            java.lang.Object r2 = kotlin.collections.CollectionsKt.lastOrNull(r0)
            com.blueair.core.model.IndoorDatapoint r2 = (com.blueair.core.model.IndoorDatapoint) r2
            if (r2 == 0) goto L_0x0041
            long r2 = r2.getTimeInSeconds()
            goto L_0x0043
        L_0x0041:
            r2 = 0
        L_0x0043:
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r2 = r1
            goto L_0x004b
        L_0x004a:
            r2 = r0
        L_0x004b:
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
            boolean r3 = r2.hasNext()
            r4 = 0
            if (r3 != 0) goto L_0x005a
            r3 = r4
            goto L_0x008f
        L_0x005a:
            java.lang.Object r3 = r2.next()
            boolean r5 = r2.hasNext()
            if (r5 != 0) goto L_0x0065
            goto L_0x008f
        L_0x0065:
            r5 = r3
            com.blueair.core.model.IndoorDatapoint r5 = (com.blueair.core.model.IndoorDatapoint) r5
            long r5 = r5.getTimeInSeconds()
            long r5 = r12 - r5
            long r5 = java.lang.Math.abs(r5)
        L_0x0072:
            java.lang.Object r7 = r2.next()
            r8 = r7
            com.blueair.core.model.IndoorDatapoint r8 = (com.blueair.core.model.IndoorDatapoint) r8
            long r8 = r8.getTimeInSeconds()
            long r8 = r12 - r8
            long r8 = java.lang.Math.abs(r8)
            int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x0089
            r3 = r7
            r5 = r8
        L_0x0089:
            boolean r7 = r2.hasNext()
            if (r7 != 0) goto L_0x0072
        L_0x008f:
            com.blueair.core.model.IndoorDatapoint r3 = (com.blueair.core.model.IndoorDatapoint) r3
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "getIndoorDataForTimestamp: unixTime = "
            r5.<init>(r6)
            r5.append(r12)
            java.lang.String r12 = ", bestMatch = "
            r5.append(r12)
            if (r3 == 0) goto L_0x00ad
            long r12 = r3.getTimeInSeconds()
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            goto L_0x00ae
        L_0x00ad:
            r12 = r4
        L_0x00ae:
            r5.append(r12)
            java.lang.String r12 = ", latest historical = "
            r5.append(r12)
            java.lang.Object r12 = kotlin.collections.CollectionsKt.lastOrNull(r0)
            com.blueair.core.model.IndoorDatapoint r12 = (com.blueair.core.model.IndoorDatapoint) r12
            if (r12 == 0) goto L_0x00c7
            long r12 = r12.getTimeInSeconds()
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            goto L_0x00c8
        L_0x00c7:
            r12 = r4
        L_0x00c8:
            r5.append(r12)
            java.lang.String r12 = ", first realtime = "
            r5.append(r12)
            if (r1 == 0) goto L_0x00e2
            java.lang.Object r12 = kotlin.collections.CollectionsKt.firstOrNull(r1)
            com.blueair.core.model.IndoorDatapoint r12 = (com.blueair.core.model.IndoorDatapoint) r12
            if (r12 == 0) goto L_0x00e2
            long r12 = r12.getTimeInSeconds()
            java.lang.Long r4 = java.lang.Long.valueOf(r12)
        L_0x00e2:
            r5.append(r4)
            java.lang.String r12 = r5.toString()
            r13 = 0
            java.lang.Object[] r13 = new java.lang.Object[r13]
            r2.d(r12, r13)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.fragment.DeviceSensorsFragment.getIndoorDataForTimestamp(long):com.blueair.core.model.IndoorDatapoint");
    }
}
