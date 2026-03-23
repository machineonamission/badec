package com.blueair.devicedetails.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.devicedetails.viewholder.DeviceScheduleBrightnessHolder;
import com.blueair.devicedetails.viewholder.DeviceScheduleManualModeViewHolder;
import com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder;
import com.blueair.devicedetails.viewholder.DeviceScheduleTitleHeaderViewHolder;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u001f\u001a\u00020\rH\u0002J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0016J\u0018\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0015H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0017\u0010\u0018R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u0019@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006*"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleInstructionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "isCustom", "", "mode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "fanSpeed", "Lcom/blueair/core/model/FanSpeedEnum;", "brightness", "", "onPurifierModeChanged", "Lkotlin/Function1;", "", "onFanSpeedChanged", "onBrightnessChanged", "<init>", "(ZLcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;Lcom/blueair/core/model/FanSpeedEnum;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "()Z", "value", "", "", "options", "setOptions", "(Ljava/util/List;)V", "Lcom/blueair/core/model/Device;", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "reconfigureViews", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceScheduleInstructionAdapter.kt */
public final class DeviceScheduleInstructionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int BRIGHTNESS_VIEW = 3;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int FAN_SPEED_VIEW = 2;
    public static final int MODE_BUTTONS_HEADER = 0;
    public static final int MODE_BUTTONS_VIEW = 1;
    private Object brightness;
    private Device device;
    private FanSpeedEnum fanSpeed;
    private final boolean isCustom;
    private DeviceCreateEditScheduleViewModel.PurifierMode mode;
    private final Function1<Object, Unit> onBrightnessChanged;
    private final Function1<FanSpeedEnum, Unit> onFanSpeedChanged;
    private final Function1<DeviceCreateEditScheduleViewModel.PurifierMode, Unit> onPurifierModeChanged;
    private List<Integer> options = CollectionsKt.emptyList();

    public final boolean isCustom() {
        return this.isCustom;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleInstructionAdapter$Companion;", "", "<init>", "()V", "MODE_BUTTONS_HEADER", "", "MODE_BUTTONS_VIEW", "FAN_SPEED_VIEW", "BRIGHTNESS_VIEW", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceScheduleInstructionAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DeviceScheduleInstructionAdapter(boolean z, DeviceCreateEditScheduleViewModel.PurifierMode purifierMode, FanSpeedEnum fanSpeedEnum, Object obj, Function1<? super DeviceCreateEditScheduleViewModel.PurifierMode, Unit> function1, Function1<? super FanSpeedEnum, Unit> function12, Function1<Object, Unit> function13) {
        Intrinsics.checkNotNullParameter(purifierMode, "mode");
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "fanSpeed");
        Intrinsics.checkNotNullParameter(obj, "brightness");
        Intrinsics.checkNotNullParameter(function1, "onPurifierModeChanged");
        Intrinsics.checkNotNullParameter(function12, "onFanSpeedChanged");
        Intrinsics.checkNotNullParameter(function13, "onBrightnessChanged");
        this.isCustom = z;
        this.mode = purifierMode;
        this.fanSpeed = fanSpeedEnum;
        this.brightness = obj;
        this.onPurifierModeChanged = function1;
        this.onFanSpeedChanged = function12;
        this.onBrightnessChanged = function13;
    }

    private final void setOptions(List<Integer> list) {
        this.options = list;
        notifyDataSetChanged();
    }

    public final Device getDevice() {
        return this.device;
    }

    public final void setDevice(Device device2) {
        if (!Intrinsics.areEqual((Object) this.device, (Object) device2)) {
            this.device = device2;
            reconfigureViews();
        }
    }

    private final void reconfigureViews() {
        List arrayList = new ArrayList();
        if (this.device instanceof HasFanSpeed) {
            if (!this.isCustom) {
                arrayList.add(0);
            }
            arrayList.add(1);
        }
        if ((this.device instanceof HasFanSpeed) && this.mode == DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL) {
            arrayList.add(2);
        }
        if (!(!(this.device instanceof HasBrightness) || this.mode == DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT || this.mode == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY || this.mode == DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION || this.mode == DeviceCreateEditScheduleViewModel.PurifierMode.ECO)) {
            arrayList.add(3);
        }
        setOptions(arrayList);
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$0(DeviceScheduleInstructionAdapter deviceScheduleInstructionAdapter, DeviceCreateEditScheduleViewModel.PurifierMode purifierMode) {
        Intrinsics.checkNotNullParameter(purifierMode, "it");
        deviceScheduleInstructionAdapter.mode = purifierMode;
        deviceScheduleInstructionAdapter.reconfigureViews();
        deviceScheduleInstructionAdapter.onPurifierModeChanged.invoke(purifierMode);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$1(DeviceScheduleInstructionAdapter deviceScheduleInstructionAdapter, FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "it");
        deviceScheduleInstructionAdapter.fanSpeed = fanSpeedEnum;
        deviceScheduleInstructionAdapter.onFanSpeedChanged.invoke(fanSpeedEnum);
        return Unit.INSTANCE;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Device device2;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 0) {
            return DeviceScheduleTitleHeaderViewHolder.Companion.newInstance(viewGroup, R.string.purifier_mode);
        }
        if (i == 1) {
            DeviceScheduleModeButtonsHolder.Companion companion = DeviceScheduleModeButtonsHolder.Companion;
            boolean z = false;
            if (!this.isCustom && (device2 = this.device) != null) {
                z = DeviceKt.supportDisinfection(device2);
            }
            return companion.newInstance(viewGroup, z, new DeviceScheduleInstructionAdapter$$ExternalSyntheticLambda0(this));
        } else if (i == 2) {
            return DeviceScheduleManualModeViewHolder.Companion.newInstance(viewGroup, new DeviceScheduleInstructionAdapter$$ExternalSyntheticLambda1(this));
        } else {
            if (i == 3) {
                return DeviceScheduleBrightnessHolder.Companion.newInstance(viewGroup, new DeviceScheduleInstructionAdapter$$ExternalSyntheticLambda2(this));
            }
            throw new Exception("View not supported");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$2(DeviceScheduleInstructionAdapter deviceScheduleInstructionAdapter, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "nuBrightness");
        deviceScheduleInstructionAdapter.brightness = obj;
        deviceScheduleInstructionAdapter.onBrightnessChanged.invoke(obj);
        return Unit.INSTANCE;
    }

    public int getItemCount() {
        return this.options.size();
    }

    public int getItemViewType(int i) {
        return this.options.get(i).intValue();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Device device2;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof DeviceScheduleTitleHeaderViewHolder) {
            ((DeviceScheduleTitleHeaderViewHolder) viewHolder).bind();
        } else if (viewHolder instanceof DeviceScheduleModeButtonsHolder) {
            Device device3 = this.device;
            if (device3 != null) {
                ((DeviceScheduleModeButtonsHolder) viewHolder).bind(device3, this.mode);
            }
        } else if (viewHolder instanceof DeviceScheduleManualModeViewHolder) {
            Device device4 = this.device;
            if (device4 != null && (device4 instanceof HasFanSpeed)) {
                ((DeviceScheduleManualModeViewHolder) viewHolder).bind((HasFanSpeed) device4, this.fanSpeed);
            }
        } else if ((viewHolder instanceof DeviceScheduleBrightnessHolder) && (device2 = this.device) != null) {
            ((DeviceScheduleBrightnessHolder) viewHolder).bind(device2, this.brightness);
        }
    }
}
