package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceIcp;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasCleanAirEta;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.devicedetails.databinding.HolderDeviceFanspeedV2Binding;
import com.blueair.devicedetails.util.DeviceControlUtils;
import com.blueair.devicedetails.util.EtaUtils;
import com.blueair.devicedetails.util.FanSpeedUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/BD\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0007H\u0016J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003J\b\u0010%\u001a\u00020\u000eH\u0002J\u0010\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u001eH\u0002J\u0018\u0010(\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020)2\u0006\u0010'\u001a\u00020\u001eH\u0002J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u001eH\u0002J\u001f\u0010\"\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\n2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFanSpeedV2Holder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceFanspeedV2Binding;", "binding", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onFanSpeedSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "Lkotlin/ParameterName;", "name", "speed", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceFanspeedV2Binding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "()Z", "tvList", "", "Landroid/widget/TextView;", "separatorList", "Landroid/view/View;", "previousIsFanMode", "supportStepless", "maxGearPosition", "", "minGearPosition", "inTouch", "lastProgress", "update", "forceOffline", "hydrateEta", "handleGearProgress", "calcFanSpeedByProgress", "progress", "getProgressAfterSnap", "Lcom/blueair/core/model/HasFanSpeed;", "isSlidingRight", "fanSpeedEnum", "preferSpeedLevel", "(Lcom/blueair/core/model/FanSpeedEnum;Ljava/lang/Integer;)V", "applyContentDesp", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceFanSpeedV2Holder.kt */
public final class DeviceFanSpeedV2Holder extends DeviceControlHolder<HolderDeviceFanspeedV2Binding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Device device;
    /* access modifiers changed from: private */
    public boolean inTouch;
    private final boolean isInSchedule;
    private int lastProgress;
    private int maxGearPosition = 4;
    private int minGearPosition;
    /* access modifiers changed from: private */
    public final Function1<FanSpeedEnum, Unit> onFanSpeedSelectedListener;
    private boolean previousIsFanMode;
    private final List<View> separatorList;
    private boolean supportStepless;
    private final List<TextView> tvList;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFanSpeedV2Holder.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.blueair.core.model.ApSubMode[] r0 = com.blueair.core.model.ApSubMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.ApSubMode r1 = com.blueair.core.model.ApSubMode.AUTO     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.ApSubMode r1 = com.blueair.core.model.ApSubMode.ECO     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.ApSubMode r1 = com.blueair.core.model.ApSubMode.NIGHT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.ApSubMode r1 = com.blueair.core.model.ApSubMode.FAN     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceFanSpeedV2Holder.WhenMappings.<clinit>():void");
        }
    }

    public final Device getDevice() {
        return this.device;
    }

    public final void setDevice(Device device2) {
        this.device = device2;
    }

    public final boolean isInSchedule() {
        return this.isInSchedule;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¨\u0006\u0013"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFanSpeedV2Holder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceFanSpeedV2Holder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onFanSpeedSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "Lkotlin/ParameterName;", "name", "speed", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFanSpeedV2Holder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceFanSpeedV2Holder newInstance(ViewGroup viewGroup, Device device, boolean z, Function1<? super FanSpeedEnum, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onFanSpeedSelectedListener");
            HolderDeviceFanspeedV2Binding inflate = HolderDeviceFanspeedV2Binding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceFanSpeedV2Holder(inflate, device, z, function1);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceFanSpeedV2Holder(HolderDeviceFanspeedV2Binding holderDeviceFanspeedV2Binding, Device device2, boolean z, Function1<? super FanSpeedEnum, Unit> function1) {
        super(holderDeviceFanspeedV2Binding);
        Intrinsics.checkNotNullParameter(holderDeviceFanspeedV2Binding, "binding");
        Intrinsics.checkNotNullParameter(function1, "onFanSpeedSelectedListener");
        this.device = device2;
        this.isInSchedule = z;
        this.onFanSpeedSelectedListener = function1;
        TextView textView = holderDeviceFanspeedV2Binding.tvProgress0;
        Intrinsics.checkNotNullExpressionValue(textView, "tvProgress0");
        TextView textView2 = holderDeviceFanspeedV2Binding.tvProgress1;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvProgress1");
        TextView textView3 = holderDeviceFanspeedV2Binding.tvProgress2;
        Intrinsics.checkNotNullExpressionValue(textView3, "tvProgress2");
        TextView textView4 = holderDeviceFanspeedV2Binding.tvProgress3;
        Intrinsics.checkNotNullExpressionValue(textView4, "tvProgress3");
        TextView textView5 = holderDeviceFanspeedV2Binding.tvProgress4;
        Intrinsics.checkNotNullExpressionValue(textView5, "tvProgress4");
        this.tvList = CollectionsKt.listOf(textView, textView2, textView3, textView4, textView5);
        View view = holderDeviceFanspeedV2Binding.separator0;
        Intrinsics.checkNotNullExpressionValue(view, "separator0");
        View view2 = holderDeviceFanspeedV2Binding.separator1;
        Intrinsics.checkNotNullExpressionValue(view2, "separator1");
        View view3 = holderDeviceFanspeedV2Binding.separator2;
        Intrinsics.checkNotNullExpressionValue(view3, "separator2");
        View view4 = holderDeviceFanspeedV2Binding.separator3;
        Intrinsics.checkNotNullExpressionValue(view4, "separator3");
        View view5 = holderDeviceFanspeedV2Binding.separator4;
        Intrinsics.checkNotNullExpressionValue(view5, "separator4");
        this.separatorList = CollectionsKt.listOf(view, view2, view3, view4, view5);
        handleGearProgress();
        holderDeviceFanspeedV2Binding.clickView.setOnClickListener(new DeviceFanSpeedV2Holder$$ExternalSyntheticLambda0(holderDeviceFanspeedV2Binding));
        holderDeviceFanspeedV2Binding.expendSwitch.setOnCheckedChangeListener(new DeviceFanSpeedV2Holder$$ExternalSyntheticLambda1(holderDeviceFanspeedV2Binding, this));
        holderDeviceFanspeedV2Binding.seekbar.setOnSeekBarChangeListener(new DeviceFanSpeedV2Holder$1$3(this));
        if (z) {
            holderDeviceFanspeedV2Binding.expendSwitch.setChecked(false);
        }
        Device device3 = this.device;
        if (!(device3 instanceof HasFanSpeed) || device3 == null || DeviceKt.isAfterG4(device3)) {
            this.supportStepless = false;
            holderDeviceFanspeedV2Binding.seekbar.setMax(this.maxGearPosition - this.minGearPosition);
            return;
        }
        this.supportStepless = true;
        Device device4 = this.device;
        if (!(device4 instanceof DeviceIcp)) {
            HasFanSpeed hasFanSpeed = device4 instanceof HasFanSpeed ? (HasFanSpeed) device4 : null;
            if (hasFanSpeed == null || !hasFanSpeed.getHasGear4()) {
                holderDeviceFanspeedV2Binding.seekbar.setMax(99);
                return;
            }
        }
        holderDeviceFanspeedV2Binding.seekbar.setMax(100);
    }

    static final void lambda$3$lambda$0(HolderDeviceFanspeedV2Binding holderDeviceFanspeedV2Binding, View view) {
        holderDeviceFanspeedV2Binding.expendSwitch.setChecked(!holderDeviceFanspeedV2Binding.expendSwitch.isChecked());
    }

    static final void lambda$3$lambda$2(HolderDeviceFanspeedV2Binding holderDeviceFanspeedV2Binding, DeviceFanSpeedV2Holder deviceFanSpeedV2Holder, CompoundButton compoundButton, boolean z) {
        Group group = holderDeviceFanspeedV2Binding.expendedContent;
        Intrinsics.checkNotNullExpressionValue(group, "expendedContent");
        ViewExtensionsKt.show(group, !z);
        if (deviceFanSpeedV2Holder.isInSchedule) {
            return;
        }
        if (z) {
            LinearLayout linearLayout = holderDeviceFanspeedV2Binding.etaContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "etaContainer");
            ViewExtensionsKt.hide(linearLayout);
            return;
        }
        Device device2 = deviceFanSpeedV2Holder.device;
        if (device2 != null) {
            deviceFanSpeedV2Holder.update(device2, false);
        }
    }

    public void update(Device device2, boolean z) {
        Intrinsics.checkNotNullParameter(device2, "device");
        if (!this.inTouch) {
            this.device = device2;
            if (device2 instanceof HasFanSpeed) {
                update(((HasFanSpeed) device2).getFanSpeedEnum(), Integer.valueOf(FanSpeedUtils.INSTANCE.getFanSpeedLevel(device2)));
                if (DeviceControlUtils.INSTANCE.isFanMode(device2)) {
                    if (!this.previousIsFanMode) {
                        ((HolderDeviceFanspeedV2Binding) getBinding()).expendSwitch.setChecked(false);
                    }
                    this.previousIsFanMode = true;
                } else {
                    this.previousIsFanMode = false;
                }
            }
            if (z || !device2.isOnline() || DeviceKt.isStandByOn(device2)) {
                HolderDeviceFanspeedV2Binding holderDeviceFanspeedV2Binding = (HolderDeviceFanspeedV2Binding) getBinding();
                holderDeviceFanspeedV2Binding.clickView.setEnabled(false);
                holderDeviceFanspeedV2Binding.expendSwitch.setEnabled(false);
                holderDeviceFanspeedV2Binding.expendSwitch.setChecked(true);
                SwitchCompat switchCompat = holderDeviceFanspeedV2Binding.expendSwitch;
                Intrinsics.checkNotNullExpressionValue(switchCompat, "expendSwitch");
                ViewExtensionsKt.show(switchCompat, true);
                holderDeviceFanspeedV2Binding.getRoot().setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.surface_dark_5)));
                holderDeviceFanspeedV2Binding.leadingIcon.setImageResource(R.drawable.ic_fanspeed_disabled);
                holderDeviceFanspeedV2Binding.title.setTextColor(getColor(R.color.surface_dark_55));
                holderDeviceFanspeedV2Binding.progressText.setText("");
            } else {
                HolderDeviceFanspeedV2Binding holderDeviceFanspeedV2Binding2 = (HolderDeviceFanspeedV2Binding) getBinding();
                holderDeviceFanspeedV2Binding2.clickView.setEnabled(true);
                holderDeviceFanspeedV2Binding2.expendSwitch.setEnabled(true);
                holderDeviceFanspeedV2Binding2.getRoot().setBackgroundTintList((ColorStateList) null);
                holderDeviceFanspeedV2Binding2.leadingIcon.setImageResource(R.drawable.ic_fanspeed);
                holderDeviceFanspeedV2Binding2.title.setTextColor(getColor(R.color.colorPrimaryText));
                if (!(device2 instanceof HasMainMode) || (device2 instanceof HasHumMainMode)) {
                    hydrateEta(device2);
                } else {
                    int i = WhenMappings.$EnumSwitchMapping$0[((HasMainMode) device2).apSubMode().ordinal()];
                    if (i == 1) {
                        holderDeviceFanspeedV2Binding2.clickView.setEnabled(false);
                        SwitchCompat switchCompat2 = holderDeviceFanspeedV2Binding2.expendSwitch;
                        Intrinsics.checkNotNullExpressionValue(switchCompat2, "expendSwitch");
                        ViewExtensionsKt.show(switchCompat2, false);
                        holderDeviceFanspeedV2Binding2.expendSwitch.setChecked(true);
                        holderDeviceFanspeedV2Binding2.progressText.setText(R.string.auto);
                    } else if (i == 2) {
                        holderDeviceFanspeedV2Binding2.clickView.setEnabled(false);
                        SwitchCompat switchCompat3 = holderDeviceFanspeedV2Binding2.expendSwitch;
                        Intrinsics.checkNotNullExpressionValue(switchCompat3, "expendSwitch");
                        ViewExtensionsKt.show(switchCompat3, false);
                        holderDeviceFanspeedV2Binding2.expendSwitch.setChecked(true);
                        holderDeviceFanspeedV2Binding2.progressText.setText(R.string.eco);
                    } else if (i == 3) {
                        holderDeviceFanspeedV2Binding2.clickView.setEnabled(false);
                        SwitchCompat switchCompat4 = holderDeviceFanspeedV2Binding2.expendSwitch;
                        Intrinsics.checkNotNullExpressionValue(switchCompat4, "expendSwitch");
                        ViewExtensionsKt.show(switchCompat4, false);
                        holderDeviceFanspeedV2Binding2.expendSwitch.setChecked(true);
                        holderDeviceFanspeedV2Binding2.progressText.setText(R.string.night);
                    } else if (i == 4) {
                        hydrateEta(device2);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            applyContentDesp();
        }
    }

    private final void hydrateEta(Device device2) {
        Integer num;
        Float pm25;
        HolderDeviceFanspeedV2Binding holderDeviceFanspeedV2Binding = (HolderDeviceFanspeedV2Binding) getBinding();
        SwitchCompat switchCompat = holderDeviceFanspeedV2Binding.expendSwitch;
        Intrinsics.checkNotNullExpressionValue(switchCompat, "expendSwitch");
        ViewExtensionsKt.show(switchCompat, true);
        if (!(device2 instanceof HasFanSpeed) || !(device2 instanceof HasSensorData)) {
            LinearLayout linearLayout = holderDeviceFanspeedV2Binding.etaContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "etaContainer");
            ViewExtensionsKt.show(linearLayout, false);
            return;
        }
        if (device2 instanceof HasCleanAirEta) {
            num = Integer.valueOf(((HasCleanAirEta) device2).getCleanAirEta() / 60);
        } else {
            IndoorDatapoint latestSensorDatapoint = ((HasSensorData) device2).getLatestSensorDatapoint();
            num = (latestSensorDatapoint == null || (pm25 = latestSensorDatapoint.getPm25()) == null) ? null : Integer.valueOf(EtaUtils.INSTANCE.eta(DeviceKt.fanSpeedValue(device2), (int) pm25.floatValue()));
        }
        if (num == null) {
            LinearLayout linearLayout2 = holderDeviceFanspeedV2Binding.etaContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "etaContainer");
            ViewExtensionsKt.show(linearLayout2, false);
            return;
        }
        String str = "";
        if (num.intValue() == 0) {
            LinearLayout linearLayout3 = holderDeviceFanspeedV2Binding.etaContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "etaContainer");
            ViewExtensionsKt.show(linearLayout3, !holderDeviceFanspeedV2Binding.expendSwitch.isChecked());
            holderDeviceFanspeedV2Binding.etaIcon.setImageResource(R.drawable.ic_eta_done);
            holderDeviceFanspeedV2Binding.etaText.setText(R.string.cleaning_complete);
            holderDeviceFanspeedV2Binding.etaValue.setText(str);
            return;
        }
        LinearLayout linearLayout4 = holderDeviceFanspeedV2Binding.etaContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout4, "etaContainer");
        ViewExtensionsKt.show(linearLayout4, !holderDeviceFanspeedV2Binding.expendSwitch.isChecked());
        holderDeviceFanspeedV2Binding.etaIcon.setImageResource(R.drawable.ic_eta);
        holderDeviceFanspeedV2Binding.etaText.setText(R.string.clear_air_in);
        TextView textView = holderDeviceFanspeedV2Binding.etaValue;
        StringBuilder sb = new StringBuilder();
        if (num.intValue() > 60) {
            str = "> ";
        }
        sb.append(str);
        sb.append(Math.min(num.intValue(), 60));
        sb.append(TokenParser.SP);
        sb.append(getString((num != null && num.intValue() == 1) ? R.string.eta_minute : R.string.eta_minutes));
        textView.setText(sb.toString());
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [com.blueair.core.model.Device] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleGearProgress() {
        /*
            r4 = this;
            com.blueair.core.model.Device r0 = r4.device
            boolean r1 = r0 instanceof com.blueair.core.model.HasFanSpeed
            r2 = 0
            if (r1 == 0) goto L_0x000a
            com.blueair.core.model.HasFanSpeed r0 = (com.blueair.core.model.HasFanSpeed) r0
            goto L_0x000b
        L_0x000a:
            r0 = r2
        L_0x000b:
            r1 = 1
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.getHasGear4()
            if (r0 != r1) goto L_0x0016
            r0 = 4
            goto L_0x0017
        L_0x0016:
            r0 = 3
        L_0x0017:
            r4.maxGearPosition = r0
            com.blueair.core.model.Device r0 = r4.device
            boolean r3 = r0 instanceof com.blueair.core.model.HasFanSpeed
            if (r3 == 0) goto L_0x0022
            r2 = r0
            com.blueair.core.model.HasFanSpeed r2 = (com.blueair.core.model.HasFanSpeed) r2
        L_0x0022:
            r0 = 0
            if (r2 == 0) goto L_0x002d
            boolean r2 = r2.getHasGear0()
            if (r2 != r1) goto L_0x002d
            r2 = r1
            goto L_0x002e
        L_0x002d:
            r2 = r0
        L_0x002e:
            r1 = r1 ^ r2
            r4.minGearPosition = r1
            java.util.List<android.widget.TextView> r1 = r4.tvList
            java.util.Collection r1 = (java.util.Collection) r1
            int r1 = r1.size()
        L_0x0039:
            if (r0 >= r1) goto L_0x0061
            int r2 = r4.minGearPosition
            if (r0 < r2) goto L_0x0043
            int r2 = r4.maxGearPosition
            if (r0 <= r2) goto L_0x005e
        L_0x0043:
            java.util.List<android.widget.TextView> r2 = r4.tvList
            java.lang.Object r2 = r2.get(r0)
            java.lang.String r3 = "get(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
            java.util.List<android.view.View> r2 = r4.separatorList
            java.lang.Object r2 = r2.get(r0)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
        L_0x005e:
            int r0 = r0 + 1
            goto L_0x0039
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceFanSpeedV2Holder.handleGearProgress():void");
    }

    /* access modifiers changed from: private */
    public final FanSpeedEnum calcFanSpeedByProgress(int i) {
        if (!this.supportStepless) {
            return FanSpeedEnum.Companion.fromStep(i + this.minGearPosition, this.device);
        }
        Device device2 = this.device;
        HasFanSpeed hasFanSpeed = device2 instanceof HasFanSpeed ? (HasFanSpeed) device2 : null;
        if (hasFanSpeed != null && hasFanSpeed.getHasGear4()) {
            return FanSpeedEnum.Companion.fanSpeedEnumFromProgressBluePremium(FanSpeedUtils.INSTANCE.getBluePremiumFromSeekBarProgress(i));
        }
        Device device3 = this.device;
        if (device3 != null && DeviceKt.isG4orB4orNB(device3)) {
            return FanSpeedEnum.Companion.fanSpeedEnumFromProgressG4(FanSpeedUtils.INSTANCE.getG4FanSpeedFromSeekBarProgress(i));
        }
        if (this.device instanceof DeviceIcp) {
            return FanSpeedEnum.Companion.fanSpeedEnumFromProgressIcp(FanSpeedUtils.INSTANCE.getIcpSpeedFromSeekBarProgress(i));
        }
        return FanSpeedEnum.Companion.fanSpeedEnumFromProgressLegacy(FanSpeedUtils.INSTANCE.getLegacySpeedFromSeekBarProgress(i));
    }

    /* access modifiers changed from: private */
    public final int getProgressAfterSnap(HasFanSpeed hasFanSpeed, int i) {
        if (hasFanSpeed.getHasGear4()) {
            return isSlidingRight(i) ? 25 : 0;
        }
        if (DeviceKt.isG4orB4orNB(hasFanSpeed)) {
            if (isSlidingRight(i)) {
                return 33;
            }
            return 0;
        } else if (hasFanSpeed instanceof DeviceIcp) {
            if (76 <= i && i < 101) {
                return 100;
            }
            if (26 > i || i >= 76) {
                return 0;
            }
            return 50;
        } else if (1 > i || i >= 33) {
            if (34 > i || i >= 66) {
                if (67 > i || i >= 99) {
                    return 0;
                }
                if (isSlidingRight(i)) {
                    return 99;
                }
                return 66;
            } else if (isSlidingRight(i)) {
                return 66;
            } else {
                return 33;
            }
        } else if (isSlidingRight(i)) {
            return 33;
        } else {
            return 0;
        }
    }

    private final boolean isSlidingRight(int i) {
        return this.lastProgress < i;
    }

    public static /* synthetic */ void update$default(DeviceFanSpeedV2Holder deviceFanSpeedV2Holder, FanSpeedEnum fanSpeedEnum, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        deviceFanSpeedV2Holder.update(fanSpeedEnum, num);
    }

    public final void update(FanSpeedEnum fanSpeedEnum, Integer num) {
        int i;
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "fanSpeedEnum");
        if (fanSpeedEnum != FanSpeedEnum.SNAP_STEP) {
            int coerceIn = RangesKt.coerceIn(num != null ? num.intValue() : FanSpeedUtils.INSTANCE.getFanSpeedLevel(this.device, fanSpeedEnum), this.minGearPosition, this.maxGearPosition);
            if (this.device instanceof HasFanSpeed) {
                AccessibleSeekBar accessibleSeekBar = ((HolderDeviceFanspeedV2Binding) getBinding()).seekbar;
                if (this.supportStepless) {
                    Device device2 = this.device;
                    Intrinsics.checkNotNull(device2, "null cannot be cast to non-null type com.blueair.core.model.HasFanSpeed");
                    if (((HasFanSpeed) device2).getHasGear4()) {
                        i = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedBluePremium(fanSpeedEnum);
                    } else {
                        Device device3 = this.device;
                        Intrinsics.checkNotNull(device3);
                        if (DeviceKt.isG4orB4orNB(device3)) {
                            i = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedG4(fanSpeedEnum);
                        } else if (this.device instanceof DeviceIcp) {
                            i = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedIcp(fanSpeedEnum);
                        } else {
                            i = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedLegacy(fanSpeedEnum);
                        }
                    }
                } else {
                    i = coerceIn - this.minGearPosition;
                }
                accessibleSeekBar.setProgress(i);
            }
            this.lastProgress = ((HolderDeviceFanspeedV2Binding) getBinding()).seekbar.getProgress();
            ((HolderDeviceFanspeedV2Binding) getBinding()).progressText.setText(String.valueOf(coerceIn));
            int color = getColor(R.color.colorPrimary);
            int color2 = getColor(R.color.surface_dark_55);
            int color3 = getColor(R.color.surface_dark_45);
            int i2 = this.minGearPosition;
            int i3 = this.maxGearPosition;
            if (i2 <= i3) {
                while (true) {
                    if (i2 <= coerceIn) {
                        this.tvList.get(i2).setTextColor(color);
                        this.separatorList.get(i2).setBackground(new ColorDrawable(color));
                    } else {
                        this.tvList.get(i2).setTextColor(color2);
                        this.separatorList.get(i2).setBackground(new ColorDrawable(color3));
                    }
                    if (i2 == i3) {
                        break;
                    }
                    i2++;
                }
            }
            if (this.isInSchedule) {
                applyContentDesp();
            }
        }
    }

    public final void applyContentDesp() {
        HolderDeviceFanspeedV2Binding holderDeviceFanspeedV2Binding = (HolderDeviceFanspeedV2Binding) getBinding();
        View view = holderDeviceFanspeedV2Binding.clickView;
        view.setContentDescription(holderDeviceFanspeedV2Binding.title.getText() + ", " + holderDeviceFanspeedV2Binding.progressText.getText());
    }
}
