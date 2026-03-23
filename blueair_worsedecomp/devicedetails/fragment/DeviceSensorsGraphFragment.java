package com.blueair.devicedetails.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.auth.GigyaService;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasDehumidifierMainMode;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.SensorType;
import com.blueair.core.model.SimpleDatapoint;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.devicedetails.databinding.FragmentDeviceSensorsGraphBinding;
import com.blueair.devicedetails.dialog.AboutAirQualityDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel;
import com.blueair.graph.utils.ChartTimeScale;
import com.blueair.graph.utils.GraphUiUtils;
import com.blueair.graph.view.GraphViewV2;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.view.IndoorAirStatusLabel;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import com.dd.ShadowLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import timber.log.Timber;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020)H\u0002J\"\u0010*\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010,\u001a\u00020%H\u0016J\u0010\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\u0011H\u0016R\u001a\u0010\u0005\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0004\n\u0002\u0010\u001b¨\u00060"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceSensorsGraphFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;)V", "deviceDetailsViewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "binding", "Lcom/blueair/devicedetails/databinding/FragmentDeviceSensorsGraphBinding;", "lastData", "Lcom/blueair/core/model/IndoorDatapoint;", "value", "", "isStandByOn", "setStandByOn", "(Z)V", "isOffline", "setOffline", "lastMainMode", "Lcom/blueair/core/model/MainMode;", "lastSensorMode", "", "Ljava/lang/Integer;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showSensorData", "selectedSensor", "Lcom/blueair/core/model/SensorType;", "updateAqiData", "dataPoint", "onResume", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSensorsGraphFragment.kt */
public final class DeviceSensorsGraphFragment extends BaseFragment<DeviceSensorsViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private FragmentDeviceSensorsGraphBinding binding;
    private DeviceDetailsViewModel deviceDetailsViewModel;
    private boolean isOffline;
    private boolean isStandByOn;
    private IndoorDatapoint lastData;
    private MainMode lastMainMode;
    private Integer lastSensorMode;
    public DeviceSensorsViewModel viewModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSensorsGraphFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.core.model.SensorType[] r0 = com.blueair.core.model.SensorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.HUM     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.TMP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM1     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM25     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM10     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.VOC     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.fragment.DeviceSensorsGraphFragment.WhenMappings.<clinit>():void");
        }
    }

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceSensorsGraphFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceSensorsGraphFragment;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSensorsGraphFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceSensorsGraphFragment newInstance() {
            return new DeviceSensorsGraphFragment();
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

    private final void setStandByOn(boolean z) {
        if (this.isStandByOn != z) {
            this.isStandByOn = z;
            updateAqiData((IndoorDatapoint) null, z, this.isOffline);
        }
    }

    private final void setOffline(boolean z) {
        if (this.isOffline != z) {
            this.isOffline = z;
            updateAqiData((IndoorDatapoint) null, this.isStandByOn, z);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        BaseFragment baseFragment = this;
        setViewModel((DeviceSensorsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS()).get(DeviceSensorsViewModel.class)));
        this.deviceDetailsViewModel = (DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS()).get(DeviceDetailsViewModel.class));
        FragmentDeviceSensorsGraphBinding inflate = FragmentDeviceSensorsGraphBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        ShadowLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        FragmentDeviceSensorsGraphBinding fragmentDeviceSensorsGraphBinding = this.binding;
        DeviceDetailsViewModel deviceDetailsViewModel2 = null;
        if (fragmentDeviceSensorsGraphBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceSensorsGraphBinding = null;
        }
        fragmentDeviceSensorsGraphBinding.clickView.setOnClickListener(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda0(fragmentDeviceSensorsGraphBinding));
        fragmentDeviceSensorsGraphBinding.expendSwitch.setOnCheckedChangeListener(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda5(fragmentDeviceSensorsGraphBinding, this));
        if (getViewModel().getSupportedSensors().size() > 1) {
            fragmentDeviceSensorsGraphBinding.dropdownMenuSensors.setOnClickListener(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda6(this, fragmentDeviceSensorsGraphBinding));
        } else {
            fragmentDeviceSensorsGraphBinding.dropdownMenuSensors.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        fragmentDeviceSensorsGraphBinding.dropdownMenuScale.setOnClickListener(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda7(fragmentDeviceSensorsGraphBinding, this));
        getViewModel().getLiveSelectedSensor().observe(getViewLifecycleOwner(), new DeviceSensorsGraphFragment$sam$androidx_lifecycle_Observer$0(new DeviceSensorsGraphFragment$onViewCreated$1$5(this)));
        getViewModel().getGraphExpended().observe(getViewLifecycleOwner(), new DeviceSensorsGraphFragment$sam$androidx_lifecycle_Observer$0(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda8(fragmentDeviceSensorsGraphBinding)));
        getViewModel().getLiveSelectedSensorHistoricalData().observe(getViewLifecycleOwner(), new DeviceSensorsGraphFragment$sam$androidx_lifecycle_Observer$0(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda9(this, fragmentDeviceSensorsGraphBinding)));
        getViewModel().getLiveSelectedSensorRealTimeData().observe(getViewLifecycleOwner(), new DeviceSensorsGraphFragment$sam$androidx_lifecycle_Observer$0(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda10(fragmentDeviceSensorsGraphBinding)));
        getViewModel().getLiveDeviceRealTimeData().observe(getViewLifecycleOwner(), new DeviceSensorsGraphFragment$sam$androidx_lifecycle_Observer$0(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda11(this)));
        DeviceDetailsViewModel deviceDetailsViewModel3 = this.deviceDetailsViewModel;
        if (deviceDetailsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceDetailsViewModel");
            deviceDetailsViewModel3 = null;
        }
        deviceDetailsViewModel3.getLiveDevice().observe(getViewLifecycleOwner(), new DeviceSensorsGraphFragment$sam$androidx_lifecycle_Observer$0(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda12(this)));
        DeviceDetailsViewModel deviceDetailsViewModel4 = this.deviceDetailsViewModel;
        if (deviceDetailsViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceDetailsViewModel");
        } else {
            deviceDetailsViewModel2 = deviceDetailsViewModel4;
        }
        deviceDetailsViewModel2.getDeviceOffline().observe(getViewLifecycleOwner(), new DeviceSensorsGraphFragment$sam$androidx_lifecycle_Observer$0(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda1(this)));
        fragmentDeviceSensorsGraphBinding.btnAbout.setOnClickListener(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda4(this));
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        TextView textView = fragmentDeviceSensorsGraphBinding.dropdownMenuSensors;
        Intrinsics.checkNotNullExpressionValue(textView, "dropdownMenuSensors");
        ViewUtils.setAccessibilityDelegate$default(viewUtils, textView, Reflection.getOrCreateKotlinClass(Spinner.class), (String) null, (Function2) null, 12, (Object) null);
        ViewUtils viewUtils2 = ViewUtils.INSTANCE;
        TextView textView2 = fragmentDeviceSensorsGraphBinding.dropdownMenuScale;
        Intrinsics.checkNotNullExpressionValue(textView2, "dropdownMenuScale");
        ViewUtils.setAccessibilityDelegate$default(viewUtils2, textView2, Reflection.getOrCreateKotlinClass(Spinner.class), (String) null, (Function2) null, 12, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$18$lambda$0(FragmentDeviceSensorsGraphBinding fragmentDeviceSensorsGraphBinding, View view) {
        fragmentDeviceSensorsGraphBinding.expendSwitch.setChecked(!fragmentDeviceSensorsGraphBinding.expendSwitch.isChecked());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001a, code lost:
        r1 = r1.btnAbout.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void onViewCreated$lambda$18$lambda$1(com.blueair.devicedetails.databinding.FragmentDeviceSensorsGraphBinding r1, com.blueair.devicedetails.fragment.DeviceSensorsGraphFragment r2, android.widget.CompoundButton r3, boolean r4) {
        /*
            androidx.constraintlayout.widget.Group r3 = r1.expendedContent
            java.lang.String r0 = "expendedContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            android.view.View r3 = (android.view.View) r3
            r0 = r4 ^ 1
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r3, r0)
            com.google.android.material.button.MaterialButton r3 = r1.btnAbout
            java.lang.String r0 = "btnAbout"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            android.view.View r3 = (android.view.View) r3
            r0 = 1
            if (r4 != 0) goto L_0x002b
            com.google.android.material.button.MaterialButton r1 = r1.btnAbout
            java.lang.CharSequence r1 = r1.getText()
            if (r1 == 0) goto L_0x002b
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r1 = r0
            goto L_0x002c
        L_0x002b:
            r1 = 0
        L_0x002c:
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r3, r1)
            com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel r1 = r2.getViewModel()
            androidx.lifecycle.MutableLiveData r1 = r1.getGraphExpended()
            r2 = r4 ^ 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r1.setValue(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.fragment.DeviceSensorsGraphFragment.onViewCreated$lambda$18$lambda$1(com.blueair.devicedetails.databinding.FragmentDeviceSensorsGraphBinding, com.blueair.devicedetails.fragment.DeviceSensorsGraphFragment, android.widget.CompoundButton, boolean):void");
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$18$lambda$4(DeviceSensorsGraphFragment deviceSensorsGraphFragment, FragmentDeviceSensorsGraphBinding fragmentDeviceSensorsGraphBinding, View view) {
        if (deviceSensorsGraphFragment.getViewModel().getSupportedSensors().size() > 1) {
            DialogUtils dialogUtils = DialogUtils.INSTANCE;
            TextView textView = fragmentDeviceSensorsGraphBinding.dropdownMenuSensors;
            Intrinsics.checkNotNullExpressionValue(textView, "dropdownMenuSensors");
            View view2 = textView;
            Iterable<SensorType> supportedSensors = deviceSensorsGraphFragment.getViewModel().getSupportedSensors();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(supportedSensors, 10));
            for (SensorType sensorName : supportedSensors) {
                String string = deviceSensorsGraphFragment.getString(GraphUiUtils.INSTANCE.getSensorName(sensorName));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                arrayList.add(string);
            }
            DialogUtils.showDropDownList$default(dialogUtils, view2, (List) arrayList, 0, 0, 0, 0, false, new DeviceSensorsGraphFragment$$ExternalSyntheticLambda2(deviceSensorsGraphFragment), 124, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$18$lambda$4$lambda$3(DeviceSensorsGraphFragment deviceSensorsGraphFragment, int i, String str) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        DeviceSensorsViewModel.selectSensor$default(deviceSensorsGraphFragment.getViewModel(), deviceSensorsGraphFragment.getViewModel().getSupportedSensors().get(i), false, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$18$lambda$7(FragmentDeviceSensorsGraphBinding fragmentDeviceSensorsGraphBinding, DeviceSensorsGraphFragment deviceSensorsGraphFragment, View view) {
        DialogUtils dialogUtils = DialogUtils.INSTANCE;
        TextView textView = fragmentDeviceSensorsGraphBinding.dropdownMenuScale;
        Intrinsics.checkNotNullExpressionValue(textView, "dropdownMenuScale");
        View view2 = textView;
        Iterable<Number> listOf = CollectionsKt.listOf(Integer.valueOf(R.string.day_label), Integer.valueOf(R.string.week_label), Integer.valueOf(R.string.month_label));
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
        for (Number intValue : listOf) {
            String string = deviceSensorsGraphFragment.getString(intValue.intValue());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            arrayList.add(string);
        }
        DialogUtils.showDropDownList$default(dialogUtils, view2, (List) arrayList, 0, 0, 0, 0, false, new DeviceSensorsGraphFragment$$ExternalSyntheticLambda3(fragmentDeviceSensorsGraphBinding), 124, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$18$lambda$7$lambda$6(FragmentDeviceSensorsGraphBinding fragmentDeviceSensorsGraphBinding, int i, String str) {
        Intrinsics.checkNotNullParameter(str, "item");
        fragmentDeviceSensorsGraphBinding.dropdownMenuScale.setText(str);
        fragmentDeviceSensorsGraphBinding.graph.setTimeScale((ChartTimeScale) ChartTimeScale.getEntries().get(i));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$18$lambda$8(FragmentDeviceSensorsGraphBinding fragmentDeviceSensorsGraphBinding, Boolean bool) {
        fragmentDeviceSensorsGraphBinding.expendSwitch.setChecked(!bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$18$lambda$10(DeviceSensorsGraphFragment deviceSensorsGraphFragment, FragmentDeviceSensorsGraphBinding fragmentDeviceSensorsGraphBinding, List list) {
        Timber.Forest forest = Timber.Forest;
        forest.d("liveSelectedSensorHistoricalData: " + list.size(), new Object[0]);
        List value = deviceSensorsGraphFragment.getViewModel().getLiveSelectedSensorRealTimeData().getValue();
        Object obj = null;
        if (value != null) {
            Iterator it = value.iterator();
            if (it.hasNext()) {
                obj = it.next();
                if (it.hasNext()) {
                    long timeInMillis = ((SimpleDatapoint) obj).getTimeInMillis();
                    do {
                        Object next = it.next();
                        long timeInMillis2 = ((SimpleDatapoint) next).getTimeInMillis();
                        if (timeInMillis < timeInMillis2) {
                            obj = next;
                            timeInMillis = timeInMillis2;
                        }
                    } while (it.hasNext());
                }
            }
            obj = (SimpleDatapoint) obj;
        }
        GraphViewV2 graphViewV2 = fragmentDeviceSensorsGraphBinding.graph;
        if (obj != null) {
            Intrinsics.checkNotNull(list);
            list = CollectionsKt.plus(list, obj);
        }
        Intrinsics.checkNotNull(list);
        graphViewV2.updateHistoricalData(list);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$18$lambda$11(FragmentDeviceSensorsGraphBinding fragmentDeviceSensorsGraphBinding, List list) {
        Timber.Forest forest = Timber.Forest;
        forest.d("liveSelectedSensorRealTimeData: " + list.size(), new Object[0]);
        GraphViewV2 graphViewV2 = fragmentDeviceSensorsGraphBinding.graph;
        Intrinsics.checkNotNull(list);
        graphViewV2.updateRealTimeData(list);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$18$lambda$12(DeviceSensorsGraphFragment deviceSensorsGraphFragment, DeviceData deviceData) {
        deviceSensorsGraphFragment.updateAqiData(deviceData.getLatestDatapoint(), deviceSensorsGraphFragment.isStandByOn, deviceSensorsGraphFragment.isOffline);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$18$lambda$14(DeviceSensorsGraphFragment deviceSensorsGraphFragment, Device device) {
        boolean z = false;
        if (device != null && DeviceKt.isStandByOn(device)) {
            z = true;
        }
        deviceSensorsGraphFragment.setStandByOn(z);
        HasSensorData hasSensorData = device instanceof HasSensorData ? (HasSensorData) device : null;
        if (hasSensorData != null) {
            deviceSensorsGraphFragment.getViewModel().updateDevice(hasSensorData);
        }
        if (device instanceof HasDehumidifierMainMode) {
            HasDehumidifierMainMode hasDehumidifierMainMode = (HasDehumidifierMainMode) device;
            if (hasDehumidifierMainMode.mainMode() != deviceSensorsGraphFragment.lastMainMode) {
                deviceSensorsGraphFragment.updateAqiData(deviceSensorsGraphFragment.lastData, deviceSensorsGraphFragment.isStandByOn, deviceSensorsGraphFragment.isOffline);
                deviceSensorsGraphFragment.lastMainMode = hasDehumidifierMainMode.mainMode();
            }
        }
        if (device instanceof DeviceBlue40) {
            DeviceBlue40 deviceBlue40 = (DeviceBlue40) device;
            int sensorMode = deviceBlue40.getSensorMode();
            Integer num = deviceSensorsGraphFragment.lastSensorMode;
            if (num == null || sensorMode != num.intValue()) {
                deviceSensorsGraphFragment.updateAqiData(deviceSensorsGraphFragment.lastData, deviceSensorsGraphFragment.isStandByOn, deviceSensorsGraphFragment.isOffline);
                deviceSensorsGraphFragment.lastSensorMode = Integer.valueOf(deviceBlue40.getSensorMode());
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$18$lambda$15(DeviceSensorsGraphFragment deviceSensorsGraphFragment, Boolean bool) {
        Intrinsics.checkNotNull(bool);
        deviceSensorsGraphFragment.setOffline(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$18$lambda$17(DeviceSensorsGraphFragment deviceSensorsGraphFragment, View view) {
        FragmentManager childFragmentManager = deviceSensorsGraphFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<AboutAirQualityDialogFragment> cls = AboutAirQualityDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("AboutAirQualityDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("AboutAirQualityDialogFragment") instanceof AboutAirQualityDialogFragment) && !childFragmentManager.isStateSaved()) {
            AboutAirQualityDialogFragment.Companion.newInstance().show(childFragmentManager, "AboutAirQualityDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public final void showSensorData(SensorType sensorType) {
        GraphViewV2.DataType dataType;
        int i;
        FragmentDeviceSensorsGraphBinding fragmentDeviceSensorsGraphBinding = this.binding;
        Integer num = null;
        if (fragmentDeviceSensorsGraphBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceSensorsGraphBinding = null;
        }
        fragmentDeviceSensorsGraphBinding.dropdownMenuSensors.setText(GraphUiUtils.INSTANCE.getSensorName(sensorType));
        int i2 = WhenMappings.$EnumSwitchMapping$0[sensorType.ordinal()];
        if (i2 == 1) {
            dataType = new GraphViewV2.DataType.HUM(getViewModel().getDevice());
        } else if (i2 != 2) {
            dataType = new GraphViewV2.DataType.AQI(getViewModel().getDevice(), sensorType);
        } else {
            dataType = new GraphViewV2.DataType.TMP(getViewModel().getDevice(), getViewModel().isTempCelsius());
        }
        fragmentDeviceSensorsGraphBinding.graph.setDataType(dataType);
        int i3 = WhenMappings.$EnumSwitchMapping$0[sensorType.ordinal()];
        if (i3 == 1) {
            num = Integer.valueOf(R.string.about_humidity);
        } else if (i3 == 3) {
            num = Integer.valueOf(R.string.about_pm_1);
        } else if (i3 == 4) {
            num = Integer.valueOf(R.string.about_pm_25);
        } else if (i3 == 5) {
            num = Integer.valueOf(R.string.about_pm_10);
        } else if (i3 == 6) {
            num = Integer.valueOf(R.string.about_tvoc);
        }
        if (num == null) {
            fragmentDeviceSensorsGraphBinding.btnAbout.setText("");
            MaterialButton materialButton = fragmentDeviceSensorsGraphBinding.btnAbout;
            Intrinsics.checkNotNullExpressionValue(materialButton, "btnAbout");
            ViewExtensionsKt.show(materialButton, false);
        } else {
            fragmentDeviceSensorsGraphBinding.btnAbout.setText(num.intValue());
            MaterialButton materialButton2 = fragmentDeviceSensorsGraphBinding.btnAbout;
            Intrinsics.checkNotNullExpressionValue(materialButton2, "btnAbout");
            ViewExtensionsKt.show(materialButton2, !fragmentDeviceSensorsGraphBinding.expendSwitch.isChecked());
            MaterialButton materialButton3 = fragmentDeviceSensorsGraphBinding.btnAbout;
            int i4 = WhenMappings.$EnumSwitchMapping$0[sensorType.ordinal()];
            if (i4 == 1) {
                i = R.drawable.ic_hum;
            } else if (i4 == 3) {
                i = R.drawable.ic_pm1_primary;
            } else if (i4 == 4) {
                i = R.drawable.ic_pm25_primary;
            } else if (i4 == 5) {
                i = R.drawable.ic_pm10_primary;
            } else if (i4 != 6) {
                i = R.drawable.ic_pm25_primary;
            } else {
                i = R.drawable.ic_tvoc;
            }
            materialButton3.setIconResource(i);
        }
        updateAqiData(this.lastData, this.isStandByOn, this.isOffline);
    }

    private final void updateAqiData(IndoorDatapoint indoorDatapoint, boolean z, boolean z2) {
        Float valueFor;
        this.lastData = indoorDatapoint;
        FragmentDeviceSensorsGraphBinding fragmentDeviceSensorsGraphBinding = this.binding;
        IndoorAirStatusLabel indoorAirStatusLabel = null;
        if (fragmentDeviceSensorsGraphBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceSensorsGraphBinding = null;
        }
        if (z2) {
            fragmentDeviceSensorsGraphBinding.aqiIcon.setImageResource(GraphUiUtils.INSTANCE.getSeverityDot6Null());
            fragmentDeviceSensorsGraphBinding.aqiValue.setText(R.string.offline_label);
            fragmentDeviceSensorsGraphBinding.descriptionText.setText(R.string.offline_label);
        } else if (z) {
            fragmentDeviceSensorsGraphBinding.aqiIcon.setImageResource(GraphUiUtils.INSTANCE.getSeverityDot6Null());
            fragmentDeviceSensorsGraphBinding.aqiValue.setText(GigyaService.DEFAULT_USER_NAME);
            fragmentDeviceSensorsGraphBinding.descriptionText.setText(GigyaService.DEFAULT_USER_NAME);
        } else {
            DeviceDetailsViewModel deviceDetailsViewModel2 = this.deviceDetailsViewModel;
            if (deviceDetailsViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deviceDetailsViewModel");
                deviceDetailsViewModel2 = null;
            }
            Device device = deviceDetailsViewModel2.getDevice();
            if (device == null || (!(device instanceof DeviceHumidifier) && !(device instanceof DeviceHumidifier20) && !DeviceKt.isHumidifyModeOn(device) && (!(device instanceof HasDehumidifierMainMode) || !((HasDehumidifierMainMode) device).isInMainMode(MainMode.Dehumidification)))) {
                IndoorDatapoint indoorDatapoint2 = indoorDatapoint;
                IndoorAirStatusLabel fromDeviceAndSensorsAndDatapoint$default = IndoorAirStatusLabel.Companion.fromDeviceAndSensorsAndDatapoint$default(IndoorAirStatusLabel.Companion, indoorDatapoint2, getViewModel().getDevice(), IndoorAirRatingRanges.Companion.getAirRatingSensors(getViewModel().getDevice()), true, false, 16, (Object) null);
                SensorType selectedSensor = getViewModel().getSelectedSensor();
                if ((indoorDatapoint2 != null ? indoorDatapoint2.valueFor(selectedSensor) : null) != null) {
                    indoorAirStatusLabel = IndoorAirStatusLabel.Companion.fromDeviceAndSensorAndDatapoint(indoorDatapoint2, getViewModel().getDevice(), selectedSensor, true);
                }
                if (indoorAirStatusLabel == null) {
                    fragmentDeviceSensorsGraphBinding.descriptionText.setText(R.string.label_reading);
                } else {
                    fragmentDeviceSensorsGraphBinding.descriptionText.setText(getString(R.string.aqi_level_description, getString(GraphUiUtils.INSTANCE.getSensorName(selectedSensor)), Integer.valueOf((int) ((indoorDatapoint2 == null || (valueFor = indoorDatapoint2.valueFor(selectedSensor)) == null) ? 0.0f : valueFor.floatValue())), getString(indoorAirStatusLabel.getTextResId())));
                }
                indoorAirStatusLabel = fromDeviceAndSensorsAndDatapoint$default;
            } else {
                if ((indoorDatapoint != null ? indoorDatapoint.getHum() : null) != null) {
                    IndoorAirStatusLabel.Companion companion = IndoorAirStatusLabel.Companion;
                    HasSensorData device2 = getViewModel().getDevice();
                    Float hum = indoorDatapoint.getHum();
                    Intrinsics.checkNotNull(hum);
                    indoorAirStatusLabel = companion.fromValueAndSensor(device2, (double) hum.floatValue(), SensorType.HUM);
                }
            }
            if (indoorAirStatusLabel == null) {
                fragmentDeviceSensorsGraphBinding.aqiIcon.setImageResource(GraphUiUtils.INSTANCE.getSeverityDot6Null());
                fragmentDeviceSensorsGraphBinding.aqiValue.setText(R.string.label_reading);
            } else {
                fragmentDeviceSensorsGraphBinding.aqiIcon.setImageResource(indoorAirStatusLabel.getIndoorAirQualityIcon6());
                fragmentDeviceSensorsGraphBinding.aqiValue.setText(indoorAirStatusLabel.getLabelResId());
            }
        }
        fragmentDeviceSensorsGraphBinding.clickView.setContentDescription(fragmentDeviceSensorsGraphBinding.title.getText() + ", " + fragmentDeviceSensorsGraphBinding.aqiValue.getText());
    }

    public void onResume() {
        super.onResume();
        getViewModel().refresh();
    }
}
