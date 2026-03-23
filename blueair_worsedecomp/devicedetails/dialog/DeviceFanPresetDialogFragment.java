package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceFanPresetBinding;
import com.blueair.devicedetails.dialog.DeviceTimerPickerDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.mapbox.maps.plugin.locationcomponent.LocationComponentConstants;
import io.apptik.widget.MultiSlider;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0013\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00101\u001a\u0002022\u0006\u00103\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00104\u001a\u000202H\u0002J\b\u00105\u001a\u000202H\u0002J\u0010\u00106\u001a\u0002022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u00107\u001a\u000202H\u0002J\u0010\u00108\u001a\u0002022\u0006\u00109\u001a\u00020%H\u0002J\u0010\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u0013H\u0002J\u0018\u0010<\u001a\u0002022\u0006\u0010;\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010=\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020>2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010@\u001a\u000202H\u0016J\u0010\u0010A\u001a\u0002022\u0006\u0010B\u001a\u00020\u0015H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X.¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013@BX\u000e¢\u0006\b\n\u0000\"\u0004\b'\u0010(¨\u0006D"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceFanPresetDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "device", "Lcom/blueair/core/model/Device;", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceFanPresetBinding;", "tmpDegreeTxt", "tmpUnitTxt", "tempSelectTvs", "", "Landroid/widget/TextView;", "drawableList", "", "value", "", "isEcoMode", "setEcoMode", "(Z)V", "minTemperatureApart", "maxTemperature", "minTemperature", "isTempC", "isReset", "tagList", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "currentPresetArray", "", "currentTag", "setCurrentTag", "(I)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "updateTriggerSelect", "updateResetBtnEnable", "updateCurrentTemp", "resetPresets", "validateTempArray", "oldTempArray", "getThumbValue", "index", "setThumbValue", "getTempSliderValue", "", "getTempValueFromSlider", "onStart", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceFanPresetDialogFragment.kt */
public final class DeviceFanPresetDialogFragment extends BaseDialogFragment<DeviceDetailsViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final double[] DEFAULT_PRESET_AUTO = {20.0d, 23.0d, 25.0d};
    private static final double[] DEFAULT_PRESET_ECO = {20.0d, 25.0d};
    private DialogfragmentDeviceFanPresetBinding binding;
    /* access modifiers changed from: private */
    public double[] currentPresetArray;
    private int currentTag;
    private Device device;
    private List<Integer> drawableList;
    private boolean isEcoMode;
    /* access modifiers changed from: private */
    public boolean isReset;
    private boolean isTempC = true;
    private int maxTemperature = 37;
    private int minTemperature = 15;
    private int minTemperatureApart = 2;
    private final String screenName;
    private List<String> tagList;
    private List<? extends TextView> tempSelectTvs;
    private String tmpDegreeTxt;
    private String tmpUnitTxt;
    public DeviceDetailsViewModel viewModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFanPresetDialogFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ApSubMode.values().length];
            try {
                iArr[ApSubMode.ECO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceFanPresetDialogFragment$Companion;", "", "<init>", "()V", "DEFAULT_PRESET_AUTO", "", "DEFAULT_PRESET_ECO", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceFanPresetDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFanPresetDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceFanPresetDialogFragment newInstance(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeviceFanPresetDialogFragment deviceFanPresetDialogFragment = new DeviceFanPresetDialogFragment();
            deviceFanPresetDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("device", device)));
            return deviceFanPresetDialogFragment;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    private final void setEcoMode(boolean z) {
        this.isEcoMode = z;
        this.maxTemperature = z ? 25 : 37;
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

    private final void setCurrentTag(int i) {
        this.currentTag = i;
        updateTriggerSelect();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        setStyle(0, R.style.DialogTheme);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R.style.dialog_animation);
            window.setGravity(80);
        }
        DialogfragmentDeviceFanPresetBinding inflate = DialogfragmentDeviceFanPresetBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        FrameLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        List<String> list;
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        Parcelable parcelable = requireArguments().getParcelable("device");
        if (parcelable != null) {
            Device device2 = (Device) parcelable;
            this.device = device2;
            if (device2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
                device2 = null;
            }
            HasCombo3in1MainMode hasCombo3in1MainMode = device2 instanceof HasCombo3in1MainMode ? (HasCombo3in1MainMode) device2 : null;
            if (hasCombo3in1MainMode != null) {
                setViewModel((DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DeviceDetailsViewModel.class)));
                getViewModel().setDeviceId(hasCombo3in1MainMode.getUid());
                Device device3 = hasCombo3in1MainMode;
                getViewModel().setDevice(device3);
                setEcoMode(hasCombo3in1MainMode.isInSubMode(ApSubMode.ECO));
                boolean isCelsiusUnit = DeviceKt.isCelsiusUnit(device3);
                this.isTempC = isCelsiusUnit;
                int i = 2;
                this.minTemperatureApart = isCelsiusUnit ? 2 : 4;
                DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding = this.binding;
                if (dialogfragmentDeviceFanPresetBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogfragmentDeviceFanPresetBinding = null;
                }
                int i2 = 0;
                dialogfragmentDeviceFanPresetBinding.fanPresetInfo.setText(getString(R.string.fan_preset_description, this.isTempC ? "2℃" : "4℉"));
                this.maxTemperature = getTempSliderValue((double) (this.isEcoMode ? 25 : 37));
                this.minTemperature = getTempSliderValue(15.0d);
                this.currentPresetArray = (double[]) (this.isEcoMode ? hasCombo3in1MainMode.getCoolEcoPresets() : hasCombo3in1MainMode.getCoolAutoPresets()).clone();
                Context requireContext = requireContext();
                String string = requireContext.getString(R.string.temperature_degree);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                this.tmpDegreeTxt = string;
                String string2 = requireContext.getString(this.isTempC ? R.string.temperature_unit_c : R.string.temperature_unit_f);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                this.tmpUnitTxt = string2;
                Iterable<Number> listOf = CollectionsKt.listOf(Integer.valueOf(R.string.room_temperature), Integer.valueOf(R.string.particle_matter));
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
                for (Number intValue : listOf) {
                    arrayList.add(requireContext.getString(intValue.intValue()));
                }
                this.tagList = (List) arrayList;
                String string3 = requireContext.getString(R.string.fan_speed);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding2 = this.binding;
                if (dialogfragmentDeviceFanPresetBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogfragmentDeviceFanPresetBinding2 = null;
                }
                TextView textView = dialogfragmentDeviceFanPresetBinding2.fanSpeedTitle1;
                DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding3 = this.binding;
                if (dialogfragmentDeviceFanPresetBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogfragmentDeviceFanPresetBinding3 = null;
                }
                TextView textView2 = dialogfragmentDeviceFanPresetBinding3.fanSpeedTitle2;
                DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding4 = this.binding;
                if (dialogfragmentDeviceFanPresetBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogfragmentDeviceFanPresetBinding4 = null;
                }
                TextView textView3 = dialogfragmentDeviceFanPresetBinding4.fanSpeedTitle3;
                DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding5 = this.binding;
                if (dialogfragmentDeviceFanPresetBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogfragmentDeviceFanPresetBinding5 = null;
                }
                int i3 = 0;
                for (Object next : CollectionsKt.listOf(textView, textView2, textView3, dialogfragmentDeviceFanPresetBinding5.fanSpeedTitle4)) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ((TextView) next).setText(string3 + TokenParser.SP + i4);
                    i3 = i4;
                }
                DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding6 = this.binding;
                if (dialogfragmentDeviceFanPresetBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogfragmentDeviceFanPresetBinding6 = null;
                }
                TextView textView4 = dialogfragmentDeviceFanPresetBinding6.timerSelect2;
                Intrinsics.checkNotNullExpressionValue(textView4, "timerSelect2");
                DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding7 = this.binding;
                if (dialogfragmentDeviceFanPresetBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogfragmentDeviceFanPresetBinding7 = null;
                }
                TextView textView5 = dialogfragmentDeviceFanPresetBinding7.timerSelect3;
                Intrinsics.checkNotNullExpressionValue(textView5, "timerSelect3");
                this.tempSelectTvs = CollectionsKt.listOf(textView4, textView5);
                this.drawableList = CollectionsKt.listOf(Integer.valueOf(R.drawable.multi_seekbar_thumb_silver_lake_blue), Integer.valueOf(R.drawable.multi_seekbar_thumb_steel_blue));
                setCurrentTag(this.isEcoMode ? hasCombo3in1MainMode.getCoolEcoTag() : hasCombo3in1MainMode.getCoolAutoTag());
                DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding8 = this.binding;
                if (dialogfragmentDeviceFanPresetBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogfragmentDeviceFanPresetBinding8 = null;
                }
                if (this.isEcoMode) {
                    TextView textView6 = dialogfragmentDeviceFanPresetBinding8.timerSelect4;
                    Intrinsics.checkNotNullExpressionValue(textView6, "timerSelect4");
                    ViewExtensionsKt.hide(textView6);
                    View view2 = dialogfragmentDeviceFanPresetBinding8.separator3;
                    Intrinsics.checkNotNullExpressionValue(view2, "separator3");
                    ViewExtensionsKt.hide(view2);
                    TextView textView7 = dialogfragmentDeviceFanPresetBinding8.fanSpeedTitle4;
                    Intrinsics.checkNotNullExpressionValue(textView7, "fanSpeedTitle4");
                    ViewExtensionsKt.hide(textView7);
                } else {
                    List<? extends TextView> list2 = this.tempSelectTvs;
                    if (list2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tempSelectTvs");
                        list2 = null;
                    }
                    this.tempSelectTvs = CollectionsKt.plus(list2, dialogfragmentDeviceFanPresetBinding8.timerSelect4);
                    List<Integer> list3 = this.drawableList;
                    if (list3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("drawableList");
                        list3 = null;
                    }
                    this.drawableList = CollectionsKt.plus(list3, Integer.valueOf(R.drawable.multi_seekbar_thumb_dark_cerulean));
                    TextView textView8 = dialogfragmentDeviceFanPresetBinding8.timerSelect4;
                    Intrinsics.checkNotNullExpressionValue(textView8, "timerSelect4");
                    ViewExtensionsKt.show(textView8, true);
                    View view3 = dialogfragmentDeviceFanPresetBinding8.separator3;
                    Intrinsics.checkNotNullExpressionValue(view3, "separator3");
                    ViewExtensionsKt.show(view3, true);
                    TextView textView9 = dialogfragmentDeviceFanPresetBinding8.fanSpeedTitle4;
                    Intrinsics.checkNotNullExpressionValue(textView9, "fanSpeedTitle4");
                    ViewExtensionsKt.show(textView9, true);
                }
                dialogfragmentDeviceFanPresetBinding8.currentUpdateTemp.setVisibility(4);
                TextView textView10 = dialogfragmentDeviceFanPresetBinding8.maxTemp;
                StringBuilder sb = new StringBuilder();
                sb.append(this.maxTemperature);
                String str = this.tmpDegreeTxt;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
                    str = null;
                }
                sb.append(str);
                String str2 = this.tmpUnitTxt;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
                    str2 = null;
                }
                sb.append(str2);
                textView10.setText(sb.toString());
                TextView textView11 = dialogfragmentDeviceFanPresetBinding8.minTemp;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.minTemperature);
                String str3 = this.tmpDegreeTxt;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
                    str3 = null;
                }
                sb2.append(str3);
                String str4 = this.tmpUnitTxt;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
                    str4 = null;
                }
                sb2.append(str4);
                textView11.setText(sb2.toString());
                dialogfragmentDeviceFanPresetBinding8.title.setText(this.isEcoMode ? R.string.eco_fan_preset : R.string.auto_fan_preset);
                dialogfragmentDeviceFanPresetBinding8.closeBtn.setOnClickListener(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda1(this));
                dialogfragmentDeviceFanPresetBinding8.btnReset.setOnClickListener(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda2(this));
                dialogfragmentDeviceFanPresetBinding8.btnApply.setOnClickListener(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda3(this, hasCombo3in1MainMode));
                MultiSlider multiSlider = dialogfragmentDeviceFanPresetBinding8.rangeSlider;
                multiSlider.setMin(this.minTemperature);
                multiSlider.setMax(this.maxTemperature);
                multiSlider.setStepsThumbsApart(1);
                multiSlider.clearThumbs();
                if (!this.isEcoMode) {
                    i = 3;
                }
                for (int i5 = 0; i5 < i; i5++) {
                    double[] dArr = this.currentPresetArray;
                    if (dArr == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentPresetArray");
                        dArr = null;
                    }
                    int tempSliderValue = getTempSliderValue(dArr[i5]);
                    List<? extends TextView> list4 = this.tempSelectTvs;
                    if (list4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tempSelectTvs");
                        list4 = null;
                    }
                    TextView textView12 = (TextView) list4.get(i5);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(tempSliderValue);
                    String str5 = this.tmpDegreeTxt;
                    if (str5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
                        str5 = null;
                    }
                    sb3.append(str5);
                    String str6 = this.tmpUnitTxt;
                    if (str6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
                        str6 = null;
                    }
                    sb3.append(str6);
                    textView12.setText(sb3.toString());
                    if (i5 == 0) {
                        DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding9 = this.binding;
                        if (dialogfragmentDeviceFanPresetBinding9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            dialogfragmentDeviceFanPresetBinding9 = null;
                        }
                        TextView textView13 = dialogfragmentDeviceFanPresetBinding9.timerSelect1;
                        StringBuilder sb4 = new StringBuilder("<");
                        sb4.append(tempSliderValue);
                        String str7 = this.tmpDegreeTxt;
                        if (str7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
                            str7 = null;
                        }
                        sb4.append(str7);
                        String str8 = this.tmpUnitTxt;
                        if (str8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
                            str8 = null;
                        }
                        sb4.append(str8);
                        textView13.setText(sb4.toString());
                    }
                    multiSlider.addThumb(tempSliderValue);
                }
                List<Integer> list5 = this.drawableList;
                if (list5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("drawableList");
                    list5 = null;
                }
                int i6 = 0;
                for (Object next2 : list5) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    int intValue2 = ((Number) next2).intValue();
                    MultiSlider.Thumb thumb = multiSlider.getThumb(i6);
                    thumb.setRange(AppCompatResources.getDrawable(multiSlider.getContext(), intValue2));
                    multiSlider.setOnClickListener(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda4(this, thumb));
                    i6 = i7;
                }
                multiSlider.setTrackDrawable(AppCompatResources.getDrawable(multiSlider.getContext(), this.isEcoMode ? R.drawable.multi_seekbar_thumb_dark_cerulean : R.drawable.multi_seekbar_thumb_oxford_blue));
                multiSlider.setOnTrackingChangeListener(new DeviceFanPresetDialogFragment$onViewCreated$2$4$2(this));
                multiSlider.setOnThumbValueChangeListener(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda5(this));
                List<? extends TextView> list6 = this.tempSelectTvs;
                if (list6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tempSelectTvs");
                    list6 = null;
                }
                for (Object next3 : list6) {
                    int i8 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    TextView textView14 = (TextView) next3;
                    textView14.setOnClickListener(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda6(this, hasCombo3in1MainMode, i2, textView14));
                    i2 = i8;
                }
                TextView textView15 = dialogfragmentDeviceFanPresetBinding8.timerTriggerSelect;
                List<String> list7 = this.tagList;
                if (list7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tagList");
                    list = null;
                } else {
                    list = list7;
                }
                textView15.setText(list.get(this.currentTag));
                textView15.setOnClickListener(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda7(this));
                updateResetBtnEnable();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$24$lambda$4(DeviceFanPresetDialogFragment deviceFanPresetDialogFragment, View view) {
        deviceFanPresetDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$24$lambda$5(DeviceFanPresetDialogFragment deviceFanPresetDialogFragment, View view) {
        deviceFanPresetDialogFragment.resetPresets();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$24$lambda$6(DeviceFanPresetDialogFragment deviceFanPresetDialogFragment, HasCombo3in1MainMode hasCombo3in1MainMode, View view) {
        double[] dArr = null;
        if (deviceFanPresetDialogFragment.isEcoMode) {
            DeviceDetailsViewModel viewModel2 = deviceFanPresetDialogFragment.getViewModel();
            Device device2 = hasCombo3in1MainMode;
            int i = deviceFanPresetDialogFragment.currentTag;
            double[] dArr2 = deviceFanPresetDialogFragment.currentPresetArray;
            if (dArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentPresetArray");
            } else {
                dArr = dArr2;
            }
            viewModel2.setCoolEcoPresets(device2, i, dArr);
        } else {
            DeviceDetailsViewModel viewModel3 = deviceFanPresetDialogFragment.getViewModel();
            Device device3 = hasCombo3in1MainMode;
            int i2 = deviceFanPresetDialogFragment.currentTag;
            double[] dArr3 = deviceFanPresetDialogFragment.currentPresetArray;
            if (dArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentPresetArray");
            } else {
                dArr = dArr3;
            }
            viewModel3.setCoolAutoPresets(device3, i2, dArr);
        }
        deviceFanPresetDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$24$lambda$11$lambda$9$lambda$8$lambda$7(DeviceFanPresetDialogFragment deviceFanPresetDialogFragment, MultiSlider.Thumb thumb, View view) {
        deviceFanPresetDialogFragment.updateCurrentTemp(thumb.getValue());
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$24$lambda$11$lambda$10(DeviceFanPresetDialogFragment deviceFanPresetDialogFragment, MultiSlider multiSlider, MultiSlider.Thumb thumb, int i, int i2) {
        List<? extends TextView> list = deviceFanPresetDialogFragment.tempSelectTvs;
        double[] dArr = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tempSelectTvs");
            list = null;
        }
        TextView textView = (TextView) list.get(i);
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        String str = deviceFanPresetDialogFragment.tmpDegreeTxt;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
            str = null;
        }
        sb.append(str);
        String str2 = deviceFanPresetDialogFragment.tmpUnitTxt;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
            str2 = null;
        }
        sb.append(str2);
        textView.setText(sb.toString());
        if (i == 0) {
            DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding = deviceFanPresetDialogFragment.binding;
            if (dialogfragmentDeviceFanPresetBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentDeviceFanPresetBinding = null;
            }
            TextView textView2 = dialogfragmentDeviceFanPresetBinding.timerSelect1;
            StringBuilder sb2 = new StringBuilder("<");
            sb2.append(i2);
            String str3 = deviceFanPresetDialogFragment.tmpDegreeTxt;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
                str3 = null;
            }
            sb2.append(str3);
            String str4 = deviceFanPresetDialogFragment.tmpUnitTxt;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
                str4 = null;
            }
            sb2.append(str4);
            textView2.setText(sb2.toString());
        }
        if (!deviceFanPresetDialogFragment.isReset) {
            double[] dArr2 = deviceFanPresetDialogFragment.currentPresetArray;
            if (dArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentPresetArray");
            } else {
                dArr = dArr2;
            }
            dArr[i] = deviceFanPresetDialogFragment.getTempValueFromSlider(i2);
        }
        deviceFanPresetDialogFragment.updateCurrentTemp(i2);
        deviceFanPresetDialogFragment.updateResetBtnEnable();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$24$lambda$18$lambda$17(DeviceFanPresetDialogFragment deviceFanPresetDialogFragment, HasCombo3in1MainMode hasCombo3in1MainMode, int i, TextView textView, View view) {
        List list;
        FragmentManager childFragmentManager = deviceFanPresetDialogFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<DeviceTimerPickerDialogFragment> cls = DeviceTimerPickerDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeviceTimerPickerDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("DeviceTimerPickerDialogFragment") instanceof DeviceTimerPickerDialogFragment) && !childFragmentManager.isStateSaved()) {
            String string = view.getContext().getString(R.string.temp_expanded);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            if (WhenMappings.$EnumSwitchMapping$0[hasCombo3in1MainMode.currentSubMode().ordinal()] == 1) {
                if (i == 0) {
                    list = CollectionsKt.toList(new IntRange(deviceFanPresetDialogFragment.minTemperature, deviceFanPresetDialogFragment.getThumbValue(1) - deviceFanPresetDialogFragment.minTemperatureApart));
                } else if (i != 1) {
                    list = CollectionsKt.toList(new IntRange(deviceFanPresetDialogFragment.minTemperature, deviceFanPresetDialogFragment.maxTemperature));
                } else {
                    list = CollectionsKt.toList(new IntRange(deviceFanPresetDialogFragment.getThumbValue(0) + deviceFanPresetDialogFragment.minTemperatureApart, deviceFanPresetDialogFragment.maxTemperature));
                }
            } else if (i == 0) {
                list = CollectionsKt.toList(new IntRange(deviceFanPresetDialogFragment.minTemperature, deviceFanPresetDialogFragment.getThumbValue(1) - deviceFanPresetDialogFragment.minTemperatureApart));
            } else if (i == 1) {
                list = CollectionsKt.toList(new IntRange(deviceFanPresetDialogFragment.getThumbValue(0) + deviceFanPresetDialogFragment.minTemperatureApart, deviceFanPresetDialogFragment.getThumbValue(2) - deviceFanPresetDialogFragment.minTemperatureApart));
            } else if (i != 2) {
                list = CollectionsKt.toList(new IntRange(deviceFanPresetDialogFragment.minTemperature, deviceFanPresetDialogFragment.maxTemperature));
            } else {
                list = CollectionsKt.toList(new IntRange(deviceFanPresetDialogFragment.getThumbValue(1) + deviceFanPresetDialogFragment.minTemperatureApart, deviceFanPresetDialogFragment.maxTemperature));
            }
            Collection collection = list;
            boolean isEmpty = collection.isEmpty();
            List list2 = collection;
            if (isEmpty) {
                list2 = CollectionsKt.listOf(Integer.valueOf(deviceFanPresetDialogFragment.getThumbValue(i)));
            }
            List list3 = (List) list2;
            Iterable<Number> iterable = list3;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Number intValue : iterable) {
                int intValue2 = intValue.intValue();
                StringBuilder sb = new StringBuilder();
                sb.append(intValue2);
                String str = deviceFanPresetDialogFragment.tmpDegreeTxt;
                String str2 = null;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
                    str = null;
                }
                sb.append(str);
                String str3 = deviceFanPresetDialogFragment.tmpUnitTxt;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
                } else {
                    str2 = str3;
                }
                sb.append(str2);
                arrayList.add(sb.toString());
            }
            List list4 = (List) arrayList;
            DeviceTimerPickerDialogFragment newInstance = DeviceTimerPickerDialogFragment.Companion.newInstance(string, list4, RangesKt.coerceAtLeast(list3.indexOf(Integer.valueOf(deviceFanPresetDialogFragment.getThumbValue(i))), 0), false);
            newInstance.setOnPickResult(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda0(textView, list4, deviceFanPresetDialogFragment, i, list3));
            newInstance.show(childFragmentManager, "DeviceTimerPickerDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$24$lambda$18$lambda$17$lambda$16$lambda$15$lambda$14(TextView textView, List list, DeviceFanPresetDialogFragment deviceFanPresetDialogFragment, int i, List list2, int i2) {
        textView.setText((CharSequence) list.get(i2));
        deviceFanPresetDialogFragment.setThumbValue(i, ((Number) list2.get(i2)).intValue());
        double[] dArr = deviceFanPresetDialogFragment.currentPresetArray;
        if (dArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentPresetArray");
            dArr = null;
        }
        dArr[i] = deviceFanPresetDialogFragment.getTempValueFromSlider(((Number) list2.get(i2)).intValue());
        deviceFanPresetDialogFragment.updateResetBtnEnable();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$24$lambda$23$lambda$22(DeviceFanPresetDialogFragment deviceFanPresetDialogFragment, View view) {
        FragmentManager childFragmentManager = deviceFanPresetDialogFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<DeviceTimerPickerDialogFragment> cls = DeviceTimerPickerDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeviceTimerPickerDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("DeviceTimerPickerDialogFragment") instanceof DeviceTimerPickerDialogFragment) && !childFragmentManager.isStateSaved()) {
            String string = deviceFanPresetDialogFragment.requireContext().getString(R.string.fan_speed_trigger);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            DeviceTimerPickerDialogFragment.Companion companion = DeviceTimerPickerDialogFragment.Companion;
            List<String> list = deviceFanPresetDialogFragment.tagList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagList");
                list = null;
            }
            DeviceTimerPickerDialogFragment newInstance = companion.newInstance(string, list, deviceFanPresetDialogFragment.currentTag, false);
            newInstance.setOnPickResult(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda8(deviceFanPresetDialogFragment));
            newInstance.show(childFragmentManager, "DeviceTimerPickerDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$24$lambda$23$lambda$22$lambda$21$lambda$20$lambda$19(DeviceFanPresetDialogFragment deviceFanPresetDialogFragment, int i) {
        deviceFanPresetDialogFragment.setCurrentTag(i);
        return Unit.INSTANCE;
    }

    private final void updateTriggerSelect() {
        boolean z = this.currentTag == 0;
        DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding = this.binding;
        List<String> list = null;
        if (dialogfragmentDeviceFanPresetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceFanPresetBinding = null;
        }
        ConstraintLayout constraintLayout = dialogfragmentDeviceFanPresetBinding.contentPresetDetail;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "contentPresetDetail");
        ViewExtensionsKt.show(constraintLayout, z);
        DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding2 = this.binding;
        if (dialogfragmentDeviceFanPresetBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceFanPresetBinding2 = null;
        }
        MaterialButton materialButton = dialogfragmentDeviceFanPresetBinding2.btnReset;
        Intrinsics.checkNotNullExpressionValue(materialButton, "btnReset");
        ViewExtensionsKt.show(materialButton, z);
        DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding3 = this.binding;
        if (dialogfragmentDeviceFanPresetBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceFanPresetBinding3 = null;
        }
        TextView textView = dialogfragmentDeviceFanPresetBinding3.timerTriggerSelect;
        List<String> list2 = this.tagList;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagList");
        } else {
            list = list2;
        }
        textView.setText(list.get(this.currentTag));
    }

    private final void updateResetBtnEnable() {
        DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding = this.binding;
        DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding2 = null;
        if (dialogfragmentDeviceFanPresetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceFanPresetBinding = null;
        }
        MaterialButton materialButton = dialogfragmentDeviceFanPresetBinding.btnReset;
        double[] dArr = this.currentPresetArray;
        if (dArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentPresetArray");
            dArr = null;
        }
        materialButton.setEnabled(!Arrays.equals(dArr, this.isEcoMode ? DEFAULT_PRESET_ECO : DEFAULT_PRESET_AUTO));
        DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding3 = this.binding;
        if (dialogfragmentDeviceFanPresetBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogfragmentDeviceFanPresetBinding2 = dialogfragmentDeviceFanPresetBinding3;
        }
        dialogfragmentDeviceFanPresetBinding2.btnReset.setPressed(false);
    }

    private final void updateCurrentTemp(int i) {
        DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding = this.binding;
        if (dialogfragmentDeviceFanPresetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceFanPresetBinding = null;
        }
        int width = dialogfragmentDeviceFanPresetBinding.rangeSlider.getWidth();
        DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding2 = this.binding;
        if (dialogfragmentDeviceFanPresetBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceFanPresetBinding2 = null;
        }
        int max = dialogfragmentDeviceFanPresetBinding2.rangeSlider.getMax();
        int i2 = this.minTemperature;
        float f = ((float) (i - i2)) / ((float) (max - i2));
        DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding3 = this.binding;
        if (dialogfragmentDeviceFanPresetBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceFanPresetBinding3 = null;
        }
        float paddingStart = (float) (width - dialogfragmentDeviceFanPresetBinding3.rangeSlider.getPaddingStart());
        DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding4 = this.binding;
        if (dialogfragmentDeviceFanPresetBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceFanPresetBinding4 = null;
        }
        int paddingEnd = (int) ((paddingStart - (((float) dialogfragmentDeviceFanPresetBinding4.rangeSlider.getPaddingEnd()) * f)) * f);
        DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding5 = this.binding;
        if (dialogfragmentDeviceFanPresetBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceFanPresetBinding5 = null;
        }
        ViewGroup.LayoutParams layoutParams = dialogfragmentDeviceFanPresetBinding5.currentUpdateTemp.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginStart(paddingEnd);
        DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding6 = this.binding;
        if (dialogfragmentDeviceFanPresetBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceFanPresetBinding6 = null;
        }
        TextView textView = dialogfragmentDeviceFanPresetBinding6.currentUpdateTemp;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        String str = this.tmpDegreeTxt;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
            str = null;
        }
        sb.append(str);
        String str2 = this.tmpUnitTxt;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
            str2 = null;
        }
        sb.append(str2);
        textView.setText(sb.toString());
        textView.setLayoutParams(layoutParams2);
        textView.setVisibility(0);
        textView.getHandler().removeCallbacksAndMessages((Object) null);
        textView.getHandler().postDelayed(new DeviceFanPresetDialogFragment$$ExternalSyntheticLambda9(textView), LocationComponentConstants.MAX_ANIMATION_DURATION_MS);
    }

    /* access modifiers changed from: private */
    public static final void updateCurrentTemp$lambda$26$lambda$25(TextView textView) {
        textView.setVisibility(4);
    }

    private final void resetPresets() {
        this.isReset = true;
        this.currentPresetArray = (double[]) (this.isEcoMode ? DEFAULT_PRESET_ECO : DEFAULT_PRESET_AUTO).clone();
        List<Integer> list = this.drawableList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("drawableList");
            list = null;
        }
        int i = 0;
        for (Object next : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ((Number) next).intValue();
            double[] dArr = this.currentPresetArray;
            if (dArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentPresetArray");
                dArr = null;
            }
            int tempSliderValue = getTempSliderValue(dArr[i]);
            setThumbValue(i, tempSliderValue);
            List<? extends TextView> list2 = this.tempSelectTvs;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tempSelectTvs");
                list2 = null;
            }
            TextView textView = (TextView) list2.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(tempSliderValue);
            String str = this.tmpDegreeTxt;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
                str = null;
            }
            sb.append(str);
            String str2 = this.tmpUnitTxt;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
                str2 = null;
            }
            sb.append(str2);
            textView.setText(sb.toString());
            if (i == 0) {
                DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding = this.binding;
                if (dialogfragmentDeviceFanPresetBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogfragmentDeviceFanPresetBinding = null;
                }
                TextView textView2 = dialogfragmentDeviceFanPresetBinding.timerSelect1;
                StringBuilder sb2 = new StringBuilder("<");
                sb2.append(tempSliderValue);
                String str3 = this.tmpDegreeTxt;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tmpDegreeTxt");
                    str3 = null;
                }
                sb2.append(str3);
                String str4 = this.tmpUnitTxt;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tmpUnitTxt");
                    str4 = null;
                }
                sb2.append(str4);
                textView2.setText(sb2.toString());
            }
            i = i2;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x009a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void validateTempArray(double[] r17) {
        /*
            r16 = this;
            r0 = r16
            double[] r1 = r0.currentPresetArray
            java.lang.String r3 = "currentPresetArray"
            if (r1 != 0) goto L_0x000c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r1 = 0
        L_0x000c:
            int r4 = r1.length
            r5 = 0
            r6 = r5
            r7 = r6
        L_0x0010:
            if (r6 >= r4) goto L_0x00a0
            r8 = r1[r6]
            int r8 = r7 + 1
            int r9 = r0.getThumbValue(r7)
            r10 = r17[r7]
            int r10 = kotlin.math.MathKt.roundToInt((double) r10)
            if (r9 == r10) goto L_0x0099
            r10 = 1
            if (r7 != 0) goto L_0x003b
            int r11 = r0.getThumbValue(r8)
            int r12 = r0.minTemperatureApart
            int r11 = r11 - r12
            if (r9 <= r11) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r10 = r5
        L_0x0030:
            if (r10 == 0) goto L_0x0038
            int r9 = r0.minTemperature
            int r9 = kotlin.ranges.RangesKt.coerceAtLeast((int) r11, (int) r9)
        L_0x0038:
            r15 = r3
            goto L_0x0093
        L_0x003b:
            double[] r11 = r0.currentPresetArray
            if (r11 != 0) goto L_0x0043
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r11 = 0
        L_0x0043:
            int r11 = r11.length
            int r11 = r11 - r10
            if (r7 != r11) goto L_0x005d
            int r11 = r7 + -1
            int r11 = r0.getThumbValue(r11)
            int r12 = r0.minTemperatureApart
            int r11 = r11 + r12
            if (r9 >= r11) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r10 = r5
        L_0x0054:
            if (r10 == 0) goto L_0x0038
            int r9 = r0.maxTemperature
            int r9 = kotlin.ranges.RangesKt.coerceAtMost((int) r11, (int) r9)
            goto L_0x0038
        L_0x005d:
            int r11 = r7 + -1
            int r11 = r0.getThumbValue(r11)
            int r12 = r0.minTemperatureApart
            int r11 = r11 + r12
            int r12 = r0.getThumbValue(r8)
            int r13 = r0.minTemperatureApart
            int r12 = r12 - r13
            if (r9 >= r11) goto L_0x0071
            r13 = r10
            goto L_0x0072
        L_0x0071:
            r13 = r5
        L_0x0072:
            if (r9 <= r12) goto L_0x0076
            r14 = r10
            goto L_0x0077
        L_0x0076:
            r14 = r5
        L_0x0077:
            if (r13 != 0) goto L_0x007d
            if (r14 == 0) goto L_0x007c
            goto L_0x007d
        L_0x007c:
            r10 = r5
        L_0x007d:
            if (r10 == 0) goto L_0x0038
            r15 = r3
            r2 = r17[r7]
            int r2 = r0.getTempSliderValue(r2)
            if (r13 == 0) goto L_0x008c
            if (r14 == 0) goto L_0x008c
            r9 = r2
            goto L_0x0093
        L_0x008c:
            if (r13 == 0) goto L_0x0090
            r9 = r11
            goto L_0x0093
        L_0x0090:
            if (r14 == 0) goto L_0x0093
            r9 = r12
        L_0x0093:
            if (r10 == 0) goto L_0x009a
            r0.setThumbValue(r7, r9)
            goto L_0x009a
        L_0x0099:
            r15 = r3
        L_0x009a:
            int r6 = r6 + 1
            r7 = r8
            r3 = r15
            goto L_0x0010
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.DeviceFanPresetDialogFragment.validateTempArray(double[]):void");
    }

    private final int getThumbValue(int i) {
        DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding = this.binding;
        if (dialogfragmentDeviceFanPresetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceFanPresetBinding = null;
        }
        return dialogfragmentDeviceFanPresetBinding.rangeSlider.getThumb(i).getValue();
    }

    private final void setThumbValue(int i, int i2) {
        DialogfragmentDeviceFanPresetBinding dialogfragmentDeviceFanPresetBinding = this.binding;
        if (dialogfragmentDeviceFanPresetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentDeviceFanPresetBinding = null;
        }
        dialogfragmentDeviceFanPresetBinding.rangeSlider.getThumb(i).setValue(i2);
    }

    private final int getTempSliderValue(double d) {
        return this.isTempC ? MathKt.roundToInt(d) : MathKt.roundToInt(DeviceData.Companion.convertCelsiusToFahrenheit(d));
    }

    private final double getTempValueFromSlider(int i) {
        return this.isTempC ? (double) i : DeviceData.Companion.convertFahrenheitToCelsius((double) i);
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -2);
        }
    }
}
