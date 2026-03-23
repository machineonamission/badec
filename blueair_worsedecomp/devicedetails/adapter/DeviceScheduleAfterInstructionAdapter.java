package com.blueair.devicedetails.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.devicedetails.viewholder.DeviceScheduleBrightnessHolder;
import com.blueair.devicedetails.viewholder.DeviceScheduleManualModeViewHolder;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001f\u001a\u00020\tH\u0002J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0016J\u0018\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0017\u0010\u0018R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\r\u001a\u0004\u0018\u00010\u0019@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006*"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleAfterInstructionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fanSpeed", "Lcom/blueair/core/model/FanSpeedEnum;", "brightness", "", "onFanSpeedChanged", "Lkotlin/Function1;", "", "onBrightnessChanged", "<init>", "(Lcom/blueair/core/model/FanSpeedEnum;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "value", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "mode", "getMode", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "setMode", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;)V", "", "", "options", "setOptions", "(Ljava/util/List;)V", "Lcom/blueair/core/model/Device;", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "reconfigureViews", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceScheduleAfterInstructionAdapter.kt */
public final class DeviceScheduleAfterInstructionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int BRIGHTNESS_VIEW = 2;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int FAN_SPEED_VIEW = 1;
    private Object brightness;
    private Device device;
    private FanSpeedEnum fanSpeed;
    private DeviceCreateEditScheduleViewModel.PurifierMode mode = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
    private final Function1<Object, Unit> onBrightnessChanged;
    private final Function1<FanSpeedEnum, Unit> onFanSpeedChanged;
    private List<Integer> options = CollectionsKt.emptyList();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleAfterInstructionAdapter$Companion;", "", "<init>", "()V", "FAN_SPEED_VIEW", "", "BRIGHTNESS_VIEW", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceScheduleAfterInstructionAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DeviceScheduleAfterInstructionAdapter(FanSpeedEnum fanSpeedEnum, Object obj, Function1<? super FanSpeedEnum, Unit> function1, Function1<Object, Unit> function12) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "fanSpeed");
        Intrinsics.checkNotNullParameter(obj, "brightness");
        Intrinsics.checkNotNullParameter(function1, "onFanSpeedChanged");
        Intrinsics.checkNotNullParameter(function12, "onBrightnessChanged");
        this.fanSpeed = fanSpeedEnum;
        this.brightness = obj;
        this.onFanSpeedChanged = function1;
        this.onBrightnessChanged = function12;
    }

    public final DeviceCreateEditScheduleViewModel.PurifierMode getMode() {
        return this.mode;
    }

    public final void setMode(DeviceCreateEditScheduleViewModel.PurifierMode purifierMode) {
        Intrinsics.checkNotNullParameter(purifierMode, "value");
        this.mode = purifierMode;
        reconfigureViews();
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
            arrayList.add(1);
        }
        if (this.device instanceof HasBrightness) {
            arrayList.add(2);
        }
        setOptions(arrayList);
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$0(DeviceScheduleAfterInstructionAdapter deviceScheduleAfterInstructionAdapter, FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "it");
        deviceScheduleAfterInstructionAdapter.fanSpeed = fanSpeedEnum;
        deviceScheduleAfterInstructionAdapter.onFanSpeedChanged.invoke(fanSpeedEnum);
        return Unit.INSTANCE;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 1) {
            return DeviceScheduleManualModeViewHolder.Companion.newInstance(viewGroup, new DeviceScheduleAfterInstructionAdapter$$ExternalSyntheticLambda0(this));
        }
        if (i == 2) {
            return DeviceScheduleBrightnessHolder.Companion.newInstance(viewGroup, new DeviceScheduleAfterInstructionAdapter$$ExternalSyntheticLambda1(this));
        }
        throw new Exception("View not supported");
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$1(DeviceScheduleAfterInstructionAdapter deviceScheduleAfterInstructionAdapter, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "nuBrightness");
        deviceScheduleAfterInstructionAdapter.brightness = obj;
        deviceScheduleAfterInstructionAdapter.onBrightnessChanged.invoke(obj);
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
        if (viewHolder instanceof DeviceScheduleManualModeViewHolder) {
            Device device3 = this.device;
            if (device3 != null && (device3 instanceof HasFanSpeed)) {
                ((DeviceScheduleManualModeViewHolder) viewHolder).bind((HasFanSpeed) device3, this.fanSpeed);
            }
        } else if ((viewHolder instanceof DeviceScheduleBrightnessHolder) && (device2 = this.device) != null) {
            ((DeviceScheduleBrightnessHolder) viewHolder).bind(device2, this.brightness);
        }
    }
}
