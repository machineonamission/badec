package com.blueair.devicedetails.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.FilterTrigger;
import com.blueair.core.model.HasWick;
import com.blueair.core.util.TimezoneUtils;
import com.blueair.devicedetails.util.DeviceNSettings;
import com.blueair.devicedetails.viewholder.DeviceNSettingDeleteHolder;
import com.blueair.devicedetails.viewholder.DeviceNSettingHolder;
import com.blueair.devicedetails.viewholder.DeviceNSettingTriggerHolder;
import com.blueair.viewcore.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001cH\u0016J\u0018\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001cH\u0016Ra\u0010\u0005\u001aI\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015X\u000e¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceNSettingsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "onSettingActionListener", "Lkotlin/Function3;", "Lcom/blueair/devicedetails/util/DeviceNSettings;", "Lkotlin/ParameterName;", "name", "type", "Lcom/blueair/core/model/Device;", "device", "", "data", "", "getOnSettingActionListener", "()Lkotlin/jvm/functions/Function3;", "setOnSettingActionListener", "(Lkotlin/jvm/functions/Function3;)V", "settings", "", "value", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "getItemCount", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNSettingsAdapter.kt */
public final class DeviceNSettingsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Device device;
    private Function3<? super DeviceNSettings, ? super Device, Object, Unit> onSettingActionListener;
    private List<? extends DeviceNSettings> settings = CollectionsKt.emptyList();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNSettingsAdapter.kt */
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
                com.blueair.devicedetails.util.DeviceNSettings[] r0 = com.blueair.devicedetails.util.DeviceNSettings.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.CUSTOM_NAME     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.TIME_ZONE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.PRODUCT_INFO     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.TEMPERATURE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.DRY_MODE     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.SYSTEM_INFO     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.TRIGGER_AUTO     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.TRIGGER_NIGHT     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.blueair.devicedetails.util.DeviceNSettings r1 = com.blueair.devicedetails.util.DeviceNSettings.DELETE     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.adapter.DeviceNSettingsAdapter.WhenMappings.<clinit>():void");
        }
    }

    public final Function3<DeviceNSettings, Device, Object, Unit> getOnSettingActionListener() {
        return this.onSettingActionListener;
    }

    public final void setOnSettingActionListener(Function3<? super DeviceNSettings, ? super Device, Object, Unit> function3) {
        this.onSettingActionListener = function3;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final void setDevice(Device device2) {
        if (!Intrinsics.areEqual((Object) this.device, (Object) device2)) {
            this.device = device2;
            this.settings = DeviceNSettings.Companion.getSupportedSettings(this.device);
            notifyDataSetChanged();
        }
    }

    public int getItemCount() {
        return this.settings.size();
    }

    public int getItemViewType(int i) {
        return ((DeviceNSettings) this.settings.get(i)).ordinal();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        switch (WhenMappings.$EnumSwitchMapping$0[((DeviceNSettings) DeviceNSettings.getEntries().get(i)).ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return DeviceNSettingHolder.Companion.newInstance(viewGroup);
            case 7:
            case 8:
                return DeviceNSettingTriggerHolder.Companion.newInstance(viewGroup);
            case 9:
                return DeviceNSettingDeleteHolder.Companion.newInstance(viewGroup, this.device);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Device device2 = this.device;
        if (device2 != null) {
            DeviceNSettings deviceNSettings = (DeviceNSettings) this.settings.get(i);
            if (viewHolder instanceof DeviceNSettingHolder) {
                HasWick hasWick = null;
                switch (WhenMappings.$EnumSwitchMapping$0[deviceNSettings.ordinal()]) {
                    case 1:
                        ((DeviceNSettingHolder) viewHolder).update(R.string.custom_name, device2.getName());
                        break;
                    case 2:
                        int i2 = R.string.timezone;
                        TimezoneUtils timezoneUtils = TimezoneUtils.INSTANCE;
                        Context context = viewHolder.itemView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        ((DeviceNSettingHolder) viewHolder).update(i2, timezoneUtils.getDisplayName(context, Device.CC.getTimezone$default(device2, (Context) null, 1, (Object) null)));
                        break;
                    case 3:
                        ((DeviceNSettingHolder) viewHolder).update(R.string.product_info, "");
                        break;
                    case 4:
                        int i3 = DeviceKt.isCelsiusUnit(device2) ? R.string.temperature_celsius : R.string.temperature_fahrenheit;
                        int i4 = R.string.temp_expanded;
                        String string = viewHolder.itemView.getContext().getString(i3);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        ((DeviceNSettingHolder) viewHolder).update(i4, string);
                        break;
                    case 5:
                        if (device2 instanceof HasWick) {
                            hasWick = (HasWick) device2;
                        }
                        int i5 = hasWick != null ? hasWick.getWickdryEnabled() : false ? R.string.on : R.string.off;
                        int i6 = R.string.dry_mode;
                        String string2 = viewHolder.itemView.getContext().getString(i5);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        ((DeviceNSettingHolder) viewHolder).update(i6, string2);
                        break;
                    case 6:
                        ((DeviceNSettingHolder) viewHolder).update(R.string.error_report, "");
                        break;
                }
                ((DeviceNSettingHolder) viewHolder).getBinding().getRoot().setOnClickListener(new DeviceNSettingsAdapter$$ExternalSyntheticLambda0(this, deviceNSettings, device2));
            } else if (viewHolder instanceof DeviceNSettingTriggerHolder) {
                DeviceNewClassic deviceNewClassic = (DeviceNewClassic) device2;
                int i7 = WhenMappings.$EnumSwitchMapping$0[deviceNSettings.ordinal()];
                if (i7 == 7) {
                    DeviceNSettingTriggerHolder deviceNSettingTriggerHolder = (DeviceNSettingTriggerHolder) viewHolder;
                    deviceNSettingTriggerHolder.update(R.string.triggers_for_auto_mode_n, deviceNewClassic.getTrigger(), deviceNewClassic.isStandByOn());
                    deviceNSettingTriggerHolder.setOnTriggerSelectedListener(new DeviceNSettingsAdapter$$ExternalSyntheticLambda1(device2, this, deviceNSettings));
                } else if (i7 == 8) {
                    DeviceNSettingTriggerHolder deviceNSettingTriggerHolder2 = (DeviceNSettingTriggerHolder) viewHolder;
                    deviceNSettingTriggerHolder2.update(R.string.triggers_for_night_mode_n, deviceNewClassic.getG4NightModeTrigger(), deviceNewClassic.isStandByOn());
                    deviceNSettingTriggerHolder2.setOnTriggerSelectedListener(new DeviceNSettingsAdapter$$ExternalSyntheticLambda2(device2, this, deviceNSettings));
                }
            } else if (viewHolder instanceof DeviceNSettingDeleteHolder) {
                ((DeviceNSettingDeleteHolder) viewHolder).getDeleteButton().setOnClickListener(new DeviceNSettingsAdapter$$ExternalSyntheticLambda3(this, deviceNSettings, device2));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(DeviceNSettingsAdapter deviceNSettingsAdapter, DeviceNSettings deviceNSettings, Device device2, View view) {
        Function3<? super DeviceNSettings, ? super Device, Object, Unit> function3 = deviceNSettingsAdapter.onSettingActionListener;
        if (function3 != null) {
            function3.invoke(deviceNSettings, device2, Unit.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$1(Device device2, DeviceNSettingsAdapter deviceNSettingsAdapter, DeviceNSettings deviceNSettings, FilterTrigger filterTrigger) {
        Function3<? super DeviceNSettings, ? super Device, Object, Unit> function3;
        Intrinsics.checkNotNullParameter(filterTrigger, "newTrigger");
        if (!Intrinsics.areEqual((Object) filterTrigger, (Object) ((DeviceNewClassic) device2).getTrigger()) && (function3 = deviceNSettingsAdapter.onSettingActionListener) != null) {
            function3.invoke(deviceNSettings, device2, filterTrigger);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$2(Device device2, DeviceNSettingsAdapter deviceNSettingsAdapter, DeviceNSettings deviceNSettings, FilterTrigger filterTrigger) {
        Function3<? super DeviceNSettings, ? super Device, Object, Unit> function3;
        Intrinsics.checkNotNullParameter(filterTrigger, "newTrigger");
        if (!Intrinsics.areEqual((Object) filterTrigger, (Object) ((DeviceNewClassic) device2).getG4NightModeTrigger()) && (function3 = deviceNSettingsAdapter.onSettingActionListener) != null) {
            function3.invoke(deviceNSettings, device2, filterTrigger);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3(DeviceNSettingsAdapter deviceNSettingsAdapter, DeviceNSettings deviceNSettings, Device device2, View view) {
        Function3<? super DeviceNSettings, ? super Device, Object, Unit> function3 = deviceNSettingsAdapter.onSettingActionListener;
        if (function3 != null) {
            function3.invoke(deviceNSettings, device2, Unit.INSTANCE);
        }
    }
}
