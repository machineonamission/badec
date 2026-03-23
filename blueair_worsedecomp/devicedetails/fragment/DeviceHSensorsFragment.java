package com.blueair.devicedetails.fragment;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewbinding.ViewBinding;
import com.blueair.auth.GigyaService;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.OutdoorPollutants;
import com.blueair.core.model.SensorType;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.devicedetails.databinding.FragmentDeviceHSensorsBinding;
import com.blueair.devicedetails.databinding.FragmentDeviceHSensorsHasWickBinding;
import com.blueair.devicedetails.databinding.GraphTabItemBinding;
import com.blueair.devicedetails.dialog.DeviceHHumidityLevelsDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel;
import com.blueair.graph.utils.GraphUiUtils;
import com.blueair.graph.view.GraphViewH;
import com.blueair.viewcore.R;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.tabs.TabLayout;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.Typography;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\u001eH\u0002J\b\u0010.\u001a\u00020*H\u0002J\u0018\u0010/\u001a\u0002002\u0006\u0010\u001f\u001a\u00020 2\u0006\u00101\u001a\u000202H\u0003J\u0018\u00103\u001a\u00020*2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u001cH\u0002J\u0010\u00107\u001a\u0002002\u0006\u00108\u001a\u000200H\u0002J\b\u00109\u001a\u00020*H\u0016J\u0010\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020\u001cH\u0016R\u001a\u0010\u0005\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceHSensorsFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;)V", "binding", "Landroidx/viewbinding/ViewBinding;", "groupAqi", "Landroidx/constraintlayout/widget/Group;", "graph", "Lcom/blueair/graph/view/GraphViewH;", "graphTabs", "Lcom/google/android/material/tabs/TabLayout;", "humidityData", "Landroid/widget/TextView;", "temperatureData", "particleData", "aqiData", "particleTitle", "contentTemp", "Landroidx/constraintlayout/widget/ConstraintLayout;", "contentHum", "sensorDataSubscribed", "", "previousGraphDataType", "Lcom/blueair/graph/view/GraphViewH$DataType;", "device", "Lcom/blueair/core/model/HasSensorData;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setGraphDataType", "dataType", "setupGraphTabs", "getSensorTitle", "", "sensorType", "Lcom/blueair/core/model/SensorType;", "updateTabItem", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "selected", "getColor", "id", "onResume", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceHSensorsFragment.kt */
public final class DeviceHSensorsFragment extends BaseFragment<DeviceSensorsViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_DEVICE = "KEY_DEVICE";
    /* access modifiers changed from: private */
    public static final String TAG = Reflection.getOrCreateKotlinClass(DeviceHSensorsFragment.class).getSimpleName();
    private TextView aqiData;
    private ViewBinding binding;
    private ConstraintLayout contentHum;
    private ConstraintLayout contentTemp;
    /* access modifiers changed from: private */
    public HasSensorData device;
    /* access modifiers changed from: private */
    public GraphViewH graph;
    private TabLayout graphTabs;
    private Group groupAqi;
    private TextView humidityData;
    private TextView particleData;
    private TextView particleTitle;
    private GraphViewH.DataType previousGraphDataType;
    private boolean sensorDataSubscribed;
    private TextView temperatureData;
    public DeviceSensorsViewModel viewModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceHSensorsFragment.kt */
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
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.fragment.DeviceHSensorsFragment.WhenMappings.<clinit>():void");
        }
    }

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceHSensorsFragment$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "KEY_DEVICE", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceHSensorsFragment;", "device", "Lcom/blueair/core/model/HasSensorData;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceHSensorsFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return DeviceHSensorsFragment.TAG;
        }

        public final DeviceHSensorsFragment newInstance(HasSensorData hasSensorData) {
            Intrinsics.checkNotNullParameter(hasSensorData, "device");
            DeviceHSensorsFragment deviceHSensorsFragment = new DeviceHSensorsFragment();
            deviceHSensorsFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("KEY_DEVICE", hasSensorData)));
            return deviceHSensorsFragment;
        }
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
        ViewBinding viewBinding;
        ViewBinding viewBinding2;
        LayoutInflater layoutInflater2 = layoutInflater;
        ViewGroup viewGroup2 = viewGroup;
        Intrinsics.checkNotNullParameter(layoutInflater2, "inflater");
        setViewModel((DeviceSensorsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DeviceSensorsViewModel.class)));
        Bundle arguments = getArguments();
        HasSensorData hasSensorData = arguments != null ? (HasSensorData) arguments.getParcelable("KEY_DEVICE") : null;
        if (hasSensorData != null) {
            this.device = hasSensorData;
            if (hasSensorData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
                hasSensorData = null;
            }
            if (hasSensorData instanceof HasWick) {
                FragmentDeviceHSensorsHasWickBinding inflate = FragmentDeviceHSensorsHasWickBinding.inflate(layoutInflater2, viewGroup2, false);
                Group group = inflate.groupAqi;
                Intrinsics.checkNotNullExpressionValue(group, "groupAqi");
                this.groupAqi = group;
                GraphViewH graphViewH = inflate.deviceGraph;
                Intrinsics.checkNotNullExpressionValue(graphViewH, "deviceGraph");
                this.graph = graphViewH;
                TabLayout tabLayout = inflate.graphTabs;
                Intrinsics.checkNotNullExpressionValue(tabLayout, "graphTabs");
                this.graphTabs = tabLayout;
                TextView textView = inflate.humidityData;
                Intrinsics.checkNotNullExpressionValue(textView, "humidityData");
                this.humidityData = textView;
                TextView textView2 = inflate.temperatureData;
                Intrinsics.checkNotNullExpressionValue(textView2, "temperatureData");
                this.temperatureData = textView2;
                TextView textView3 = inflate.particleData;
                Intrinsics.checkNotNullExpressionValue(textView3, "particleData");
                this.particleData = textView3;
                TextView textView4 = inflate.aqiData;
                Intrinsics.checkNotNullExpressionValue(textView4, "aqiData");
                this.aqiData = textView4;
                TextView textView5 = inflate.particleTitle;
                Intrinsics.checkNotNullExpressionValue(textView5, "particleTitle");
                this.particleTitle = textView5;
                ConstraintLayout constraintLayout = inflate.contentTemperature;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "contentTemperature");
                this.contentTemp = constraintLayout;
                ConstraintLayout constraintLayout2 = inflate.contentHumidity;
                Intrinsics.checkNotNullExpressionValue(constraintLayout2, "contentHumidity");
                this.contentHum = constraintLayout2;
                View view = inflate.separator2;
                Intrinsics.checkNotNullExpressionValue(view, "separator2");
                HasSensorData hasSensorData2 = this.device;
                if (hasSensorData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("device");
                    hasSensorData2 = null;
                }
                ViewExtensionsKt.show(view, hasSensorData2 instanceof DeviceHumidifier);
                Intrinsics.checkNotNull(inflate);
                viewBinding = inflate;
            } else {
                FragmentDeviceHSensorsBinding inflate2 = FragmentDeviceHSensorsBinding.inflate(layoutInflater2, viewGroup2, false);
                Group group2 = inflate2.groupAqi;
                Intrinsics.checkNotNullExpressionValue(group2, "groupAqi");
                this.groupAqi = group2;
                GraphViewH graphViewH2 = inflate2.deviceGraph;
                Intrinsics.checkNotNullExpressionValue(graphViewH2, "deviceGraph");
                this.graph = graphViewH2;
                TabLayout tabLayout2 = inflate2.graphTabs;
                Intrinsics.checkNotNullExpressionValue(tabLayout2, "graphTabs");
                this.graphTabs = tabLayout2;
                TextView textView6 = inflate2.humidityData;
                Intrinsics.checkNotNullExpressionValue(textView6, "humidityData");
                this.humidityData = textView6;
                TextView textView7 = inflate2.temperatureData;
                Intrinsics.checkNotNullExpressionValue(textView7, "temperatureData");
                this.temperatureData = textView7;
                TextView textView8 = inflate2.particleData;
                Intrinsics.checkNotNullExpressionValue(textView8, "particleData");
                this.particleData = textView8;
                TextView textView9 = inflate2.aqiData;
                Intrinsics.checkNotNullExpressionValue(textView9, "aqiData");
                this.aqiData = textView9;
                TextView textView10 = inflate2.particleTitle;
                Intrinsics.checkNotNullExpressionValue(textView10, "particleTitle");
                this.particleTitle = textView10;
                ConstraintLayout constraintLayout3 = inflate2.contentTemperature;
                Intrinsics.checkNotNullExpressionValue(constraintLayout3, "contentTemperature");
                this.contentTemp = constraintLayout3;
                ConstraintLayout constraintLayout4 = inflate2.contentHumidity;
                Intrinsics.checkNotNullExpressionValue(constraintLayout4, "contentHumidity");
                this.contentHum = constraintLayout4;
                Intrinsics.checkNotNull(inflate2);
                viewBinding = inflate2;
            }
            this.binding = viewBinding;
            HasSensorData hasSensorData3 = this.device;
            if (hasSensorData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
                hasSensorData3 = null;
            }
            if (hasSensorData3 instanceof DeviceHumidifier) {
                TabLayout tabLayout3 = this.graphTabs;
                if (tabLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
                    tabLayout3 = null;
                }
                ViewExtensionsKt.hide(tabLayout3);
            } else if (hasSensorData3 instanceof DevicePet20) {
                ConstraintLayout constraintLayout5 = this.contentTemp;
                if (constraintLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentTemp");
                    constraintLayout5 = null;
                }
                ViewExtensionsKt.hide(constraintLayout5);
                ConstraintLayout constraintLayout6 = this.contentHum;
                if (constraintLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentHum");
                    constraintLayout6 = null;
                }
                ViewExtensionsKt.hide(constraintLayout6);
                TextView textView11 = this.particleTitle;
                if (textView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("particleTitle");
                    textView11 = null;
                }
                textView11.setText(R.string.indoor_aqi);
            }
            DeviceSensorsViewModel viewModel2 = getViewModel();
            HasSensorData hasSensorData4 = this.device;
            if (hasSensorData4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
                hasSensorData4 = null;
            }
            viewModel2.init(hasSensorData4, true);
            ViewBinding viewBinding3 = this.binding;
            if (viewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewBinding2 = null;
            } else {
                viewBinding2 = viewBinding3;
            }
            View root = viewBinding2.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            return root;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        setupGraphTabs();
        Group group = this.groupAqi;
        TextView textView = null;
        if (group == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groupAqi");
            group = null;
        }
        ViewExtensionsKt.show(group, getViewModel().getSupportPM25());
        HasSensorData hasSensorData = this.device;
        if (hasSensorData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            hasSensorData = null;
        }
        boolean z = hasSensorData instanceof DevicePet20;
        if (z) {
            TextView textView2 = this.particleData;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("particleData");
                textView2 = null;
            }
            com.blueair.viewcore.ViewExtensionsKt.unbold(textView2);
            TextView textView3 = this.aqiData;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aqiData");
                textView3 = null;
            }
            com.blueair.viewcore.ViewExtensionsKt.unbold(textView3);
            TextView textView4 = this.particleTitle;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("particleTitle");
                textView4 = null;
            }
            float textSize = textView4.getTextSize();
            TextView textView5 = this.particleData;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("particleData");
                textView5 = null;
            }
            textView5.setTextSize(textSize);
            TextView textView6 = this.aqiData;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aqiData");
                textView6 = null;
            }
            textView6.setTextSize(textSize);
            if (Build.VERSION.SDK_INT >= 26) {
                TextView textView7 = this.particleData;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("particleData");
                    textView7 = null;
                }
                TextView textView8 = this.particleData;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("particleData");
                    textView8 = null;
                }
                textView7.setAutoSizeTextTypeUniformWithConfiguration(textView8.getAutoSizeMinTextSize(), MathKt.roundToInt(textSize), 1, 0);
                TextView textView9 = this.aqiData;
                if (textView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aqiData");
                    textView9 = null;
                }
                TextView textView10 = this.aqiData;
                if (textView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aqiData");
                } else {
                    textView = textView10;
                }
                textView9.setAutoSizeTextTypeUniformWithConfiguration(textView.getAutoSizeMinTextSize(), MathKt.roundToInt(textSize), 1, 0);
            }
        }
        IndoorAirRatingRanges indoorAirRatings = getViewModel().getIndoorAirRatings();
        getViewModel().getLiveSelectedSensorHistoricalData().observe(getViewLifecycleOwner(), new DeviceHSensorsFragment$sam$androidx_lifecycle_Observer$0(new DeviceHSensorsFragment$$ExternalSyntheticLambda7(this)));
        getViewModel().getLiveSelectedSensorRealTimeData().observe(getViewLifecycleOwner(), new DeviceHSensorsFragment$sam$androidx_lifecycle_Observer$0(new DeviceHSensorsFragment$$ExternalSyntheticLambda8(this)));
        getViewModel().getLiveDeviceLatestData().observe(getViewLifecycleOwner(), new DeviceHSensorsFragment$sam$androidx_lifecycle_Observer$0(new DeviceHSensorsFragment$$ExternalSyntheticLambda9(this, z, indoorAirRatings)));
        getViewModel().getDisableSensorCards().observe(getViewLifecycleOwner(), new DeviceHSensorsFragment$sam$androidx_lifecycle_Observer$0(new DeviceHSensorsFragment$$ExternalSyntheticLambda10(this, z, indoorAirRatings)));
        getViewModel().getLiveDevice().observe(getViewLifecycleOwner(), new DeviceHSensorsFragment$sam$androidx_lifecycle_Observer$0(new DeviceHSensorsFragment$$ExternalSyntheticLambda11(this)));
        getViewModel().getLiveAqiData().observe(getViewLifecycleOwner(), new DeviceHSensorsFragment$sam$androidx_lifecycle_Observer$0(new DeviceHSensorsFragment$$ExternalSyntheticLambda2(this, z)));
    }

    private static final void onViewCreated$updateHumText(DeviceHSensorsFragment deviceHSensorsFragment, Float f) {
        String str;
        TextView textView = deviceHSensorsFragment.humidityData;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("humidityData");
            textView = null;
        }
        if (f == null) {
            str = GigyaService.DEFAULT_USER_NAME;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(MathKt.roundToInt(f.floatValue()));
            sb.append('%');
            str = sb.toString();
        }
        textView.setText(str);
    }

    private static final void onViewCreated$updateTmpText(DeviceHSensorsFragment deviceHSensorsFragment, Float f, boolean z) {
        TextView textView = null;
        if (f == null) {
            TextView textView2 = deviceHSensorsFragment.temperatureData;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("temperatureData");
            } else {
                textView = textView2;
            }
            textView.setText(GigyaService.DEFAULT_USER_NAME);
            return;
        }
        int roundToInt = MathKt.roundToInt(z ? f.floatValue() : DeviceData.Companion.convertCelsiusToFahrenheit(f.floatValue()));
        TextView textView3 = deviceHSensorsFragment.temperatureData;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("temperatureData");
        } else {
            textView = textView3;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(roundToInt);
        sb.append(Typography.degree);
        sb.append(z ? 'C' : 'F');
        textView.setText(sb.toString());
    }

    private static final void onViewCreated$updateParticleText(DeviceHSensorsFragment deviceHSensorsFragment, boolean z, IndoorAirRatingRanges indoorAirRatingRanges, TextView textView, List<? extends SensorType> list, IndoorDatapoint indoorDatapoint) {
        IndoorAirRatingRanges.Companion companion = IndoorAirRatingRanges.Companion;
        HasSensorData hasSensorData = deviceHSensorsFragment.device;
        TextView textView2 = null;
        if (hasSensorData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            hasSensorData = null;
        }
        SensorType first = companion.instance(hasSensorData).voteWorstRating(list, indoorDatapoint).getFirst();
        Float valueFor = indoorDatapoint != null ? indoorDatapoint.valueFor(first) : null;
        if (valueFor == null) {
            textView.setText(GigyaService.DEFAULT_USER_NAME);
            TextView textView3 = deviceHSensorsFragment.particleData;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("particleData");
            } else {
                textView2 = textView3;
            }
            TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(textView2, z ? GraphUiUtils.INSTANCE.getSeverityDot8Null() : 0, 0, z ? 0 : GraphUiUtils.INSTANCE.getSeverityDot8Null(), 0);
            return;
        }
        int coerceIn = RangesKt.coerceIn(indoorAirRatingRanges.getRangePosition(valueFor.floatValue(), first), 0, GraphUiUtils.INSTANCE.getSeverityDots8().size() - 1);
        int intValue = GraphUiUtils.INSTANCE.getSeverityDots8().get(coerceIn).intValue();
        int i = z ? intValue : 0;
        if (z) {
            intValue = 0;
        }
        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, i, 0, intValue, 0);
        textView.setText(z ? deviceHSensorsFragment.getResources().getStringArray(R.array.severity_strings)[coerceIn] : String.valueOf(MathKt.roundToInt(valueFor.floatValue())));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r6 = r6.getCalculatedAQI();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void onViewCreated$updateOutdoorAqiValueText(boolean r3, com.blueair.devicedetails.fragment.DeviceHSensorsFragment r4, android.widget.TextView r5, com.blueair.core.model.IOutdoorPollutants r6, boolean r7) {
        /*
            if (r6 == 0) goto L_0x0012
            java.lang.Double r6 = r6.getCalculatedAQI()
            if (r6 == 0) goto L_0x0012
            double r0 = r6.doubleValue()
            float r6 = (float) r0
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            goto L_0x0013
        L_0x0012:
            r6 = 0
        L_0x0013:
            r0 = 0
            if (r6 != 0) goto L_0x0022
            if (r7 != 0) goto L_0x0019
            return
        L_0x0019:
            com.blueair.graph.utils.GraphUiUtils r4 = com.blueair.graph.utils.GraphUiUtils.INSTANCE
            int r4 = r4.getSeverityDot8Null()
            java.lang.String r6 = "-"
            goto L_0x006f
        L_0x0022:
            com.blueair.core.util.OutdoorAirRatingRanges r7 = com.blueair.core.util.OutdoorAirRatingRanges.INSTANCE
            float r1 = r6.floatValue()
            com.blueair.core.model.PollutantType$AQI r2 = com.blueair.core.model.PollutantType.AQI.INSTANCE
            com.blueair.core.model.PollutantType r2 = (com.blueair.core.model.PollutantType) r2
            int r7 = r7.getPollutantRangePosition(r1, r2)
            com.blueair.graph.utils.GraphUiUtils r1 = com.blueair.graph.utils.GraphUiUtils.INSTANCE
            java.util.List r1 = r1.getSeverityDots8()
            int r1 = r1.size()
            int r1 = r1 + -1
            int r7 = kotlin.ranges.RangesKt.coerceIn((int) r7, (int) r0, (int) r1)
            com.blueair.graph.utils.GraphUiUtils r1 = com.blueair.graph.utils.GraphUiUtils.INSTANCE
            java.util.List r1 = r1.getSeverityDots8()
            java.lang.Object r1 = r1.get(r7)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            if (r3 == 0) goto L_0x0064
            android.content.res.Resources r4 = r4.getResources()
            int r6 = com.blueair.viewcore.R.array.severity_strings
            java.lang.String[] r4 = r4.getStringArray(r6)
            r4 = r4[r7]
            java.lang.String r6 = "get(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            goto L_0x006d
        L_0x0064:
            float r4 = r6.floatValue()
            int r4 = (int) r4
            java.lang.String r4 = java.lang.String.valueOf(r4)
        L_0x006d:
            r6 = r4
            r4 = r1
        L_0x006f:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
            if (r3 == 0) goto L_0x0078
            r6 = r4
            goto L_0x0079
        L_0x0078:
            r6 = r0
        L_0x0079:
            if (r3 == 0) goto L_0x007c
            r4 = r0
        L_0x007c:
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds((android.widget.TextView) r5, (int) r6, (int) r0, (int) r4, (int) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.fragment.DeviceHSensorsFragment.onViewCreated$updateOutdoorAqiValueText(boolean, com.blueair.devicedetails.fragment.DeviceHSensorsFragment, android.widget.TextView, com.blueair.core.model.IOutdoorPollutants, boolean):void");
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(DeviceHSensorsFragment deviceHSensorsFragment, List list) {
        Timber.Forest forest = Timber.Forest;
        forest.d("liveSelectedSensorHistoricalData: " + list.size(), new Object[0]);
        GraphViewH graphViewH = deviceHSensorsFragment.graph;
        if (graphViewH == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graph");
            graphViewH = null;
        }
        Intrinsics.checkNotNull(list);
        graphViewH.updateHistoricalData(list);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(DeviceHSensorsFragment deviceHSensorsFragment, List list) {
        Timber.Forest forest = Timber.Forest;
        forest.d("liveSelectedSensorRealTimeData: " + list.size(), new Object[0]);
        GraphViewH graphViewH = deviceHSensorsFragment.graph;
        if (graphViewH == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graph");
            graphViewH = null;
        }
        Intrinsics.checkNotNull(list);
        graphViewH.updateRealTimeData(list);
        return Unit.INSTANCE;
    }

    private static final void onViewCreated$updateSensorCards(DeviceHSensorsFragment deviceHSensorsFragment, boolean z, IndoorAirRatingRanges indoorAirRatingRanges, DeviceData deviceData) {
        IndoorDatapoint indoorDatapoint;
        List<IndoorDatapoint> rawDataPoints;
        Object obj;
        HasSensorData hasSensorData = null;
        if (deviceData == null || (rawDataPoints = deviceData.getRawDataPoints()) == null) {
            indoorDatapoint = null;
        } else {
            Iterator it = rawDataPoints.iterator();
            if (!it.hasNext()) {
                obj = null;
            } else {
                obj = it.next();
                if (it.hasNext()) {
                    long timeInSeconds = ((IndoorDatapoint) obj).getTimeInSeconds();
                    do {
                        Object next = it.next();
                        long timeInSeconds2 = ((IndoorDatapoint) next).getTimeInSeconds();
                        if (timeInSeconds < timeInSeconds2) {
                            obj = next;
                            timeInSeconds = timeInSeconds2;
                        }
                    } while (it.hasNext());
                }
            }
            indoorDatapoint = (IndoorDatapoint) obj;
        }
        if (indoorDatapoint == null || Intrinsics.areEqual((Object) deviceHSensorsFragment.getViewModel().getDisableSensorCards().getValue(), (Object) true)) {
            onViewCreated$updateHumText(deviceHSensorsFragment, (Float) null);
            onViewCreated$updateTmpText(deviceHSensorsFragment, (Float) null, deviceHSensorsFragment.getViewModel().isTempCelsius());
            TextView textView = deviceHSensorsFragment.particleData;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("particleData");
                textView = null;
            }
            IndoorAirRatingRanges.Companion companion = IndoorAirRatingRanges.Companion;
            HasSensorData hasSensorData2 = deviceHSensorsFragment.device;
            if (hasSensorData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
            } else {
                hasSensorData = hasSensorData2;
            }
            onViewCreated$updateParticleText(deviceHSensorsFragment, z, indoorAirRatingRanges, textView, companion.getAirRatingSensors(hasSensorData), (IndoorDatapoint) null);
            return;
        }
        HasSensorData hasSensorData3 = deviceHSensorsFragment.device;
        if (hasSensorData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            hasSensorData3 = null;
        }
        if (!(hasSensorData3 instanceof DevicePet20)) {
            onViewCreated$updateHumText(deviceHSensorsFragment, indoorDatapoint.getHum());
            onViewCreated$updateTmpText(deviceHSensorsFragment, indoorDatapoint.getTmp(), deviceHSensorsFragment.getViewModel().isTempCelsius());
        }
        TextView textView2 = deviceHSensorsFragment.particleData;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("particleData");
            textView2 = null;
        }
        IndoorAirRatingRanges.Companion companion2 = IndoorAirRatingRanges.Companion;
        HasSensorData hasSensorData4 = deviceHSensorsFragment.device;
        if (hasSensorData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
        } else {
            hasSensorData = hasSensorData4;
        }
        onViewCreated$updateParticleText(deviceHSensorsFragment, z, indoorAirRatingRanges, textView2, companion2.getAirRatingSensors(hasSensorData), indoorDatapoint);
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$5(DeviceHSensorsFragment deviceHSensorsFragment, boolean z, IndoorAirRatingRanges indoorAirRatingRanges, DeviceData deviceData) {
        onViewCreated$updateSensorCards(deviceHSensorsFragment, z, indoorAirRatingRanges, deviceData);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$6(DeviceHSensorsFragment deviceHSensorsFragment, boolean z, IndoorAirRatingRanges indoorAirRatingRanges, Boolean bool) {
        onViewCreated$updateSensorCards(deviceHSensorsFragment, z, indoorAirRatingRanges, deviceHSensorsFragment.getViewModel().getLiveDeviceLatestData().getValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$9(DeviceHSensorsFragment deviceHSensorsFragment, HasSensorData hasSensorData) {
        GraphViewH.DataType dataType;
        Intrinsics.checkNotNull(hasSensorData);
        deviceHSensorsFragment.device = hasSensorData;
        deviceHSensorsFragment.getViewModel().updateDevice(hasSensorData);
        Device device2 = hasSensorData;
        boolean isStandByOn = DeviceKt.isStandByOn(device2);
        if (hasSensorData instanceof DeviceHumidifier) {
            dataType = new GraphViewH.DataType.HUM(hasSensorData);
        } else if (hasSensorData instanceof HasHumMode) {
            dataType = (isStandByOn || !((HasHumMode) hasSensorData).getHumMode()) ? new GraphViewH.DataType.AQI(hasSensorData, SensorType.PM25) : new GraphViewH.DataType.HUM(hasSensorData);
        } else if (hasSensorData instanceof HasCombo3in1MainMode) {
            dataType = (isStandByOn || !((HasMainMode) hasSensorData).isInMainMode(MainMode.HEAT)) ? new GraphViewH.DataType.AQI(hasSensorData, SensorType.PM25) : new GraphViewH.DataType.TMP(hasSensorData, DeviceKt.isCelsiusUnit(device2));
        } else {
            dataType = new GraphViewH.DataType.AQI(hasSensorData, SensorType.PM25);
        }
        if (!Intrinsics.areEqual((Object) deviceHSensorsFragment.previousGraphDataType, (Object) dataType)) {
            deviceHSensorsFragment.previousGraphDataType = dataType;
            deviceHSensorsFragment.setGraphDataType(dataType);
            if (!deviceHSensorsFragment.sensorDataSubscribed) {
                deviceHSensorsFragment.sensorDataSubscribed = true;
                deviceHSensorsFragment.getViewModel().getRealTimeDataListener().observe(deviceHSensorsFragment.getViewLifecycleOwner(), new DeviceHSensorsFragment$$ExternalSyntheticLambda5());
                deviceHSensorsFragment.getViewModel().getHistoricalDataListener().observe(deviceHSensorsFragment.getViewLifecycleOwner(), new DeviceHSensorsFragment$$ExternalSyntheticLambda6());
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$9$lambda$7(Object obj) {
        Timber.Forest forest = Timber.Forest;
        forest.d("realTimeDataListener: thread = " + Thread.currentThread(), new Object[0]);
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$9$lambda$8(Object obj) {
        Timber.Forest forest = Timber.Forest;
        forest.d("historicalDataListener: thread = " + Thread.currentThread(), new Object[0]);
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$10(DeviceHSensorsFragment deviceHSensorsFragment, boolean z, AqiData aqiData2) {
        TextView textView = deviceHSensorsFragment.aqiData;
        OutdoorPollutants outdoorPollutants = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aqiData");
            textView = null;
        }
        if (aqiData2 != null) {
            outdoorPollutants = aqiData2.getPollutants();
        }
        onViewCreated$updateOutdoorAqiValueText(z, deviceHSensorsFragment, textView, outdoorPollutants, true);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setGraphDataType(com.blueair.graph.view.GraphViewH.DataType r7) {
        /*
            r6 = this;
            com.blueair.graph.view.GraphViewH r0 = r6.graph
            java.lang.String r1 = "graph"
            r2 = 0
            if (r0 != 0) goto L_0x000b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x000b:
            r0.setDataType(r7)
            com.blueair.core.model.SensorType r0 = r7.toSensorType()
            com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel r3 = r6.getViewModel()
            r4 = 0
            r5 = 2
            com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel.selectSensor$default(r3, r0, r4, r5, r2)
            boolean r7 = r7 instanceof com.blueair.graph.view.GraphViewH.DataType.HUM
            if (r7 == 0) goto L_0x0044
            com.blueair.core.model.HasSensorData r7 = r6.device
            if (r7 != 0) goto L_0x0029
            java.lang.String r7 = "device"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r7 = r2
        L_0x0029:
            boolean r7 = r7 instanceof com.blueair.core.model.DeviceHumidifier
            if (r7 == 0) goto L_0x0044
            com.blueair.graph.view.GraphViewH r7 = r6.graph
            if (r7 != 0) goto L_0x0035
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r7 = r2
        L_0x0035:
            int r1 = com.blueair.viewcore.R.string.humidity_levels
            java.lang.String r1 = r6.getString(r1)
            com.blueair.devicedetails.fragment.DeviceHSensorsFragment$$ExternalSyntheticLambda4 r3 = new com.blueair.devicedetails.fragment.DeviceHSensorsFragment$$ExternalSyntheticLambda4
            r3.<init>(r6)
            r7.setTitle(r1, r3)
            goto L_0x004f
        L_0x0044:
            com.blueair.graph.view.GraphViewH r7 = r6.graph
            if (r7 != 0) goto L_0x004c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r7 = r2
        L_0x004c:
            r7.setTitle(r2, r2)
        L_0x004f:
            com.google.android.material.tabs.TabLayout r7 = r6.graphTabs
            java.lang.String r1 = "graphTabs"
            if (r7 != 0) goto L_0x0059
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r7 = r2
        L_0x0059:
            android.view.View r7 = (android.view.View) r7
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L_0x0093
            com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel r7 = r6.getViewModel()
            java.util.List r7 = r7.getSupportedSensorTabs()
            int r7 = r7.indexOf(r0)
            if (r7 < 0) goto L_0x0088
            com.google.android.material.tabs.TabLayout r0 = r6.graphTabs
            if (r0 != 0) goto L_0x0077
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0077:
            com.google.android.material.tabs.TabLayout r3 = r6.graphTabs
            if (r3 != 0) goto L_0x007f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x0080
        L_0x007f:
            r2 = r3
        L_0x0080:
            com.google.android.material.tabs.TabLayout$Tab r7 = r2.getTabAt(r7)
            r0.selectTab(r7)
            return
        L_0x0088:
            com.google.android.material.tabs.TabLayout r7 = r6.graphTabs
            if (r7 != 0) goto L_0x0090
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r7 = r2
        L_0x0090:
            r7.selectTab(r2)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.fragment.DeviceHSensorsFragment.setGraphDataType(com.blueair.graph.view.GraphViewH$DataType):void");
    }

    /* access modifiers changed from: private */
    public static final void setGraphDataType$lambda$12(DeviceHSensorsFragment deviceHSensorsFragment, View view) {
        FragmentManager childFragmentManager = deviceHSensorsFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<DeviceHHumidityLevelsDialogFragment> cls = DeviceHHumidityLevelsDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeviceHHumidityLevelsDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("DeviceHHumidityLevelsDialogFragment") instanceof DeviceHHumidityLevelsDialogFragment) && !childFragmentManager.isStateSaved()) {
            DeviceHHumidityLevelsDialogFragment.Companion.newInstance().show(childFragmentManager, "DeviceHHumidityLevelsDialogFragment");
        }
    }

    private final void setupGraphTabs() {
        TabLayout tabLayout = this.graphTabs;
        TabLayout tabLayout2 = null;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
            tabLayout = null;
        }
        if (tabLayout.getVisibility() == 0) {
            int i = 0;
            for (Object next : getViewModel().getSupportedSensorTabs()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SensorType sensorType = (SensorType) next;
                TabLayout tabLayout3 = this.graphTabs;
                if (tabLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
                    tabLayout3 = null;
                }
                TabLayout.Tab newTab = tabLayout3.newTab();
                Intrinsics.checkNotNullExpressionValue(newTab, "newTab(...)");
                GraphTabItemBinding inflate = GraphTabItemBinding.inflate(LayoutInflater.from(getContext()));
                TextView textView = inflate.text;
                HasSensorData hasSensorData = this.device;
                if (hasSensorData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("device");
                    hasSensorData = null;
                }
                textView.setText(getSensorTitle(hasSensorData, sensorType));
                boolean z = true;
                if (sensorType == SensorType.HUM) {
                    ImageButton imageButton = inflate.infoIcon;
                    Intrinsics.checkNotNullExpressionValue(imageButton, "infoIcon");
                    ViewExtensionsKt.show$default(imageButton, false, 1, (Object) null);
                    inflate.infoIcon.setOnClickListener(new DeviceHSensorsFragment$$ExternalSyntheticLambda3(this, sensorType, newTab));
                }
                ImageButton imageButton2 = inflate.infoIcon;
                Intrinsics.checkNotNullExpressionValue(imageButton2, "infoIcon");
                View view = imageButton2;
                if (sensorType != SensorType.HUM) {
                    z = false;
                }
                ViewExtensionsKt.show(view, z);
                Intrinsics.checkNotNullExpressionValue(inflate, "apply(...)");
                newTab.setTag(sensorType);
                newTab.setCustomView((View) inflate.getRoot());
                newTab.view.setBackground((Drawable) null);
                newTab.view.setPadding(14, 0, 14, 0);
                TabLayout tabLayout4 = this.graphTabs;
                if (tabLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
                    tabLayout4 = null;
                }
                tabLayout4.addTab(newTab);
                ViewCompat.setAccessibilityDelegate(newTab.view, new DeviceHSensorsFragment$setupGraphTabs$1$2(this, i));
                i = i2;
            }
            TabLayout tabLayout5 = this.graphTabs;
            if (tabLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
                tabLayout5 = null;
            }
            tabLayout5.selectTab((TabLayout.Tab) null);
            TabLayout tabLayout6 = this.graphTabs;
            if (tabLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
            } else {
                tabLayout2 = tabLayout6;
            }
            tabLayout2.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new DeviceHSensorsFragment$setupGraphTabs$2(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void setupGraphTabs$lambda$17$lambda$15$lambda$14(DeviceHSensorsFragment deviceHSensorsFragment, SensorType sensorType, TabLayout.Tab tab, View view) {
        TabLayout tabLayout = deviceHSensorsFragment.graphTabs;
        TabLayout tabLayout2 = null;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
            tabLayout = null;
        }
        TabLayout tabLayout3 = deviceHSensorsFragment.graphTabs;
        if (tabLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
            tabLayout3 = null;
        }
        TabLayout.Tab tabAt = tabLayout.getTabAt(tabLayout3.getSelectedTabPosition());
        if ((tabAt != null ? tabAt.getTag() : null) == sensorType) {
            FragmentManager childFragmentManager = deviceHSensorsFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<DeviceHHumidityLevelsDialogFragment> cls = DeviceHHumidityLevelsDialogFragment.class;
            Intrinsics.checkNotNullExpressionValue("DeviceHHumidityLevelsDialogFragment", "getSimpleName(...)");
            if (!(childFragmentManager.findFragmentByTag("DeviceHHumidityLevelsDialogFragment") instanceof DeviceHHumidityLevelsDialogFragment) && !childFragmentManager.isStateSaved()) {
                DeviceHHumidityLevelsDialogFragment.Companion.newInstance().show(childFragmentManager, "DeviceHHumidityLevelsDialogFragment");
                return;
            }
            return;
        }
        TabLayout tabLayout4 = deviceHSensorsFragment.graphTabs;
        if (tabLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
        } else {
            tabLayout2 = tabLayout4;
        }
        tabLayout2.selectTab(tab);
    }

    private final int getSensorTitle(HasSensorData hasSensorData, SensorType sensorType) {
        boolean z = hasSensorData instanceof DevicePet20;
        switch (WhenMappings.$EnumSwitchMapping$0[sensorType.ordinal()]) {
            case 1:
                return z ? R.string.pet_sensor_pm1 : R.string.pm1_title_short;
            case 2:
                return z ? R.string.pet_sensor_pm25 : R.string.pm25_title;
            case 3:
                return z ? R.string.pet_sensor_pm10 : R.string.pm10_title_short;
            case 4:
                return z ? R.string.pet_sensor_tvoc : R.string.voc_title_short;
            case 5:
                return R.string.hcho_title;
            case 6:
                return R.string.humidity_levels;
            case 7:
                return R.string.indoor_temperature;
            case 8:
                return R.string.fan_title;
            case 9:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public final void updateTabItem(TabLayout.Tab tab, boolean z) {
        View customView = tab.getCustomView();
        Intrinsics.checkNotNull(customView);
        GraphTabItemBinding bind = GraphTabItemBinding.bind(customView);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        if (z) {
            bind.text.setTextColor(-1);
            bind.infoIcon.setImageTintList(ColorStateList.valueOf(-1));
            bind.getRoot().setBackgroundResource(R.drawable.rounded_square_marienblue_r1000);
            return;
        }
        bind.text.setTextColor(getColor(R.color.colorPrimaryText));
        bind.infoIcon.setImageTintList((ColorStateList) null);
        bind.getRoot().setBackgroundResource(R.drawable.rounded_square_outlined_r1000);
    }

    private final int getColor(int i) {
        return requireContext().getColor(i);
    }

    public void onResume() {
        super.onResume();
        getViewModel().refresh();
    }
}
