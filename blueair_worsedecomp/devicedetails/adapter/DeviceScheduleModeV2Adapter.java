package com.blueair.devicedetails.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.BlueDeviceScheduleEndType;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceMiniRestful;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.viewholder.DeviceBrightnessV2Holder;
import com.blueair.devicedetails.viewholder.DeviceFanSpeedV2Holder;
import com.blueair.devicedetails.viewholder.DeviceHumidificationHolder;
import com.blueair.devicedetails.viewholder.DeviceMainModeDehumHolder;
import com.blueair.devicedetails.viewholder.DeviceModeButtonsV2Holder;
import com.blueair.devicedetails.viewholder.DeviceScheduleCustomTypeV2Holder;
import com.blueair.devicedetails.viewholder.DeviceTargetHumidityHolder;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.utils.ModeIcon;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003VWXBo\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0016\u0010\u0016\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0012\u0004\u0012\u00020\u00190\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010J\u001a\u00020\u0019H\u0002J\u0018\u0010K\u001a\u00020\u00022\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0014H\u0016J\b\u0010O\u001a\u00020\u0014H\u0016J\u0010\u0010P\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\u0014H\u0016J\u0018\u0010R\u001a\u00020\u00192\u0006\u0010S\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\u0014H\u0016J\b\u0010T\u001a\u00020\bH\u0002J\b\u0010U\u001a\u00020\bH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R!\u0010\u0016\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0012\u0004\u0012\u00020\u00190\u0017¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R$\u0010\t\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010\u000b\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R&\u0010\r\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000e8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\b\u0012\u0004\u0012\u000206058BX\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0012@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0014@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R$\u0010\u0015\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010(\"\u0004\b@\u0010*R\u000e\u0010A\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R*\u0010D\u001a\b\u0012\u0004\u0012\u00020C0B2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020C0B@CX\u000e¢\u0006\b\n\u0000\"\u0004\bE\u0010FR$\u0010G\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010(\"\u0004\bI\u0010*¨\u0006Y"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "device", "Lcom/blueair/core/model/Device;", "group", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$ControlGroup;", "isStartMode", "", "customType", "", "mainMode", "Lcom/blueair/core/model/MainMode;", "mode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "fanSpeed", "Lcom/blueair/core/model/FanSpeedEnum;", "brightness", "", "autoRh", "", "humMode", "onActionListener", "Lkotlin/Function1;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "", "<init>", "(Lcom/blueair/core/model/Device;Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$ControlGroup;ZLjava/lang/String;Lcom/blueair/core/model/MainMode;Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;Lcom/blueair/core/model/FanSpeedEnum;Ljava/lang/Object;IZLkotlin/jvm/functions/Function1;)V", "getDevice", "()Lcom/blueair/core/model/Device;", "getGroup", "()Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$ControlGroup;", "getOnActionListener", "()Lkotlin/jvm/functions/Function1;", "value", "getCustomType", "()Ljava/lang/String;", "setCustomType", "(Ljava/lang/String;)V", "isStandByOn", "()Z", "setStandByOn", "(Z)V", "getMainMode", "()Lcom/blueair/core/model/MainMode;", "setMainMode", "(Lcom/blueair/core/model/MainMode;)V", "expectedValue", "getMode", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "setMode", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;)V", "stayOffModes", "", "Lcom/blueair/viewcore/utils/ModeIcon;", "getStayOffModes", "()Ljava/util/Set;", "getFanSpeed", "()Lcom/blueair/core/model/FanSpeedEnum;", "getBrightness", "()Ljava/lang/Object;", "getAutoRh", "()I", "getHumMode", "setHumMode", "firstRefresh", "", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$ModeControl;", "modeControls", "setModeControls", "(Ljava/util/List;)V", "endTypeHintClosedBefore", "getEndTypeHintClosedBefore", "setEndTypeHintClosedBefore", "refreshControls", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "isHumOn", "hasHumidification", "ControlGroup", "ModeControl", "Action", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceScheduleModeV2Adapter.kt */
public final class DeviceScheduleModeV2Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int autoRh;
    private Object brightness;
    private String customType;
    private final Device device;
    private boolean endTypeHintClosedBefore;
    private FanSpeedEnum fanSpeed;
    private boolean firstRefresh;
    private final ControlGroup group;
    private boolean humMode;
    private boolean isStandByOn;
    private final boolean isStartMode;
    private MainMode mainMode;
    private DeviceCreateEditScheduleViewModel.PurifierMode mode;
    private List<? extends ModeControl> modeControls;
    private final Function1<Action<?>, Unit> onActionListener;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceScheduleModeV2Adapter.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|(2:15|16)|17|19|20|21|(2:23|24)|25|(2:27|28)|29|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|53) */
        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|(2:1|2)|3|5|6|7|9|10|(2:11|12)|13|15|16|17|19|20|21|(2:23|24)|25|(2:27|28)|29|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|53) */
        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|(2:1|2)|3|5|6|7|9|10|11|12|13|15|16|17|19|20|21|(2:23|24)|25|27|28|29|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|53) */
        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|1|2|3|5|6|7|9|10|11|12|13|15|16|17|19|20|21|(2:23|24)|25|27|28|29|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|53) */
        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|1|2|3|5|6|7|9|10|11|12|13|15|16|17|19|20|21|23|24|25|27|28|29|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|53) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0080 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0088 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0098 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00a8 */
        static {
            /*
                com.blueair.core.model.MainMode[] r0 = com.blueair.core.model.MainMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.blueair.core.model.MainMode r2 = com.blueair.core.model.MainMode.AirPurify     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.blueair.core.model.MainMode r3 = com.blueair.core.model.MainMode.SMART     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode[] r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r3 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r3 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.AUTO     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                r3 = 3
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r4 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.DRYING     // Catch:{ NoSuchFieldError -> 0x003b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                r4 = 4
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r5 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.SKIN     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                r5 = 5
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r6 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.SMART     // Catch:{ NoSuchFieldError -> 0x004d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                r6 = 6
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r7 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.CONTINUOUS     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r0[r7] = r6     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                $EnumSwitchMapping$1 = r0
                com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$ControlGroup[] r0 = com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.ControlGroup.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$ControlGroup r7 = com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.ControlGroup.MODES     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r0[r7] = r1     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$ControlGroup r7 = com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.ControlGroup.CONTROLS     // Catch:{ NoSuchFieldError -> 0x006f }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r0[r7] = r2     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                $EnumSwitchMapping$2 = r0
                com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$ModeControl[] r0 = com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.ModeControl.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$ModeControl r7 = com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.ModeControl.CUSTOM_TYPE     // Catch:{ NoSuchFieldError -> 0x0080 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0080 }
                r0[r7] = r1     // Catch:{ NoSuchFieldError -> 0x0080 }
            L_0x0080:
                com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$ModeControl r1 = com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.ModeControl.MAIN_MODES_DEHUM     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0088 }
            L_0x0088:
                com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$ModeControl r1 = com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.ModeControl.MODE_BUTTONS     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$ModeControl r1 = com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.ModeControl.FAN_SPEED     // Catch:{ NoSuchFieldError -> 0x0098 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0098 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0098 }
            L_0x0098:
                com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$ModeControl r1 = com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.ModeControl.TARGET_HUM     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$ModeControl r1 = com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.ModeControl.BRIGHTNESS     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$ModeControl r1 = com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.ModeControl.HUMIDIFICATION     // Catch:{ NoSuchFieldError -> 0x00b1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b1 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b1 }
            L_0x00b1:
                $EnumSwitchMapping$3 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.WhenMappings.<clinit>():void");
        }
    }

    public final Device getDevice() {
        return this.device;
    }

    public final ControlGroup getGroup() {
        return this.group;
    }

    public final Function1<Action<?>, Unit> getOnActionListener() {
        return this.onActionListener;
    }

    public DeviceScheduleModeV2Adapter(Device device2, ControlGroup controlGroup, boolean z, String str, MainMode mainMode2, DeviceCreateEditScheduleViewModel.PurifierMode purifierMode, FanSpeedEnum fanSpeedEnum, Object obj, int i, boolean z2, Function1<? super Action<?>, Unit> function1) {
        Intrinsics.checkNotNullParameter(device2, "device");
        Intrinsics.checkNotNullParameter(controlGroup, "group");
        Intrinsics.checkNotNullParameter(str, "customType");
        Intrinsics.checkNotNullParameter(mainMode2, "mainMode");
        Intrinsics.checkNotNullParameter(purifierMode, "mode");
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "fanSpeed");
        Intrinsics.checkNotNullParameter(obj, "brightness");
        Intrinsics.checkNotNullParameter(function1, "onActionListener");
        this.device = device2;
        this.group = controlGroup;
        this.isStartMode = z;
        this.onActionListener = function1;
        this.customType = str;
        this.isStandByOn = purifierMode == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY;
        this.mainMode = mainMode2;
        DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter = this;
        if (purifierMode == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[mainMode2.ordinal()];
            if (i2 != 1) {
                purifierMode = i2 != 2 ? DeviceCreateEditScheduleViewModel.PurifierMode.AUTO : DeviceCreateEditScheduleViewModel.PurifierMode.SMART;
            } else {
                Device device3 = this.device;
                purifierMode = ((device3 instanceof DeviceDehumidifier) || (device3 instanceof DeviceMiniRestful) || (device3 instanceof DevicePet20)) ? DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL : DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
            }
        }
        this.mode = purifierMode;
        this.fanSpeed = fanSpeedEnum;
        this.brightness = obj;
        this.autoRh = i;
        this.humMode = z2;
        this.firstRefresh = true;
        this.modeControls = CollectionsKt.emptyList();
        refreshControls();
    }

    public final String getCustomType() {
        return this.customType;
    }

    public final void setCustomType(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        if (!Intrinsics.areEqual((Object) this.customType, (Object) str)) {
            this.customType = str;
            refreshControls();
            this.onActionListener.invoke(new Action.CUSTOM_TYPE_CHANGED(str));
        }
    }

    public final boolean isStandByOn() {
        return this.isStandByOn;
    }

    public final void setStandByOn(boolean z) {
        if (this.isStandByOn != z) {
            this.isStandByOn = z;
            refreshControls();
            Timber.Forest forest = Timber.Forest;
            forest.d("StandByOn: " + this.isStandByOn + ", mode: " + getMode(), new Object[0]);
            this.onActionListener.invoke(new Action.SUB_MODE_CHANGED(getMode()));
        }
    }

    public final MainMode getMainMode() {
        return this.mainMode;
    }

    public final void setMainMode(MainMode mainMode2) {
        DeviceCreateEditScheduleViewModel.PurifierMode purifierMode;
        int indexOf;
        Intrinsics.checkNotNullParameter(mainMode2, "value");
        if (this.mainMode != mainMode2) {
            this.mainMode = mainMode2;
            if (WhenMappings.$EnumSwitchMapping$0[mainMode2.ordinal()] == 1) {
                Device device2 = this.device;
                purifierMode = ((device2 instanceof DeviceDehumidifier) || (device2 instanceof DeviceCombo2in120)) ? DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL : DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
            } else {
                purifierMode = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
            }
            setMode(purifierMode);
            if ((this.device instanceof HasHumMainMode) && (indexOf = this.modeControls.indexOf(ModeControl.TARGET_HUM)) >= 0) {
                notifyItemChanged(indexOf);
            }
            this.onActionListener.invoke(new Action.MAIN_MODE_CHANGED(mainMode2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setMode(com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode r5) {
        /*
            r4 = this;
            java.lang.String r0 = "expectedValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY
            r1 = 0
            r2 = 1
            if (r5 != r0) goto L_0x000d
            r0 = r2
            goto L_0x000e
        L_0x000d:
            r0 = r1
        L_0x000e:
            r4.setStandByOn(r0)
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = r4.mode
            if (r0 == r5) goto L_0x0016
            r1 = r2
        L_0x0016:
            com.blueair.core.model.Device r0 = r4.device
            boolean r0 = r0 instanceof com.blueair.core.model.HasHumMainMode
            if (r0 == 0) goto L_0x0032
            boolean r0 = r4.isStandByOn
            if (r0 != 0) goto L_0x0032
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.AUTO
            if (r5 != r0) goto L_0x0025
            goto L_0x0033
        L_0x0025:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = r4.mode
            if (r0 != r5) goto L_0x0032
            com.blueair.core.model.MainMode r0 = r4.mainMode
            com.blueair.core.model.MainMode r3 = com.blueair.core.model.MainMode.Humidification
            if (r0 != r3) goto L_0x0032
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r5 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.AUTO
            goto L_0x0033
        L_0x0032:
            r2 = r1
        L_0x0033:
            if (r2 == 0) goto L_0x004d
            boolean r0 = r4.isStandByOn
            if (r0 == 0) goto L_0x003a
            goto L_0x004d
        L_0x003a:
            r4.mode = r5
            r4.refreshControls()
            kotlin.jvm.functions.Function1<com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$Action<?>, kotlin.Unit> r5 = r4.onActionListener
            com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$Action$SUB_MODE_CHANGED r0 = new com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter$Action$SUB_MODE_CHANGED
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r1 = r4.getMode()
            r0.<init>(r1)
            r5.invoke(r0)
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.setMode(com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode):void");
    }

    public final DeviceCreateEditScheduleViewModel.PurifierMode getMode() {
        return this.isStandByOn ? DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY : this.mode;
    }

    private final Set<ModeIcon> getStayOffModes() {
        return (!(this.device instanceof HasHumMainMode) || !isHumOn()) ? SetsKt.emptySet() : SetsKt.setOf(ModeIcon.AUTO);
    }

    public final FanSpeedEnum getFanSpeed() {
        return this.fanSpeed;
    }

    public final Object getBrightness() {
        return this.brightness;
    }

    public final int getAutoRh() {
        return this.autoRh;
    }

    public final boolean getHumMode() {
        return this.humMode;
    }

    public final void setHumMode(boolean z) {
        if (this.humMode != z) {
            this.humMode = z;
        }
    }

    private final void setModeControls(List<? extends ModeControl> list) {
        int size = this.modeControls.size();
        this.modeControls = list;
        notifyDataSetChanged();
        if (list.size() != size || this.firstRefresh) {
            this.onActionListener.invoke(new Action.ITEM_COUNT_CHANGED(list.size()));
        }
    }

    public final boolean getEndTypeHintClosedBefore() {
        return this.endTypeHintClosedBefore;
    }

    public final void setEndTypeHintClosedBefore(boolean z) {
        if (this.endTypeHintClosedBefore != z) {
            this.endTypeHintClosedBefore = z;
            int indexOf = this.modeControls.indexOf(ModeControl.CUSTOM_TYPE);
            if (indexOf >= 0) {
                notifyItemChanged(indexOf);
            }
        }
    }

    private final void refreshControls() {
        List arrayList = new ArrayList();
        int i = WhenMappings.$EnumSwitchMapping$2[this.group.ordinal()];
        if (i == 1) {
            if (!this.isStartMode) {
                arrayList.add(ModeControl.CUSTOM_TYPE);
                if (Intrinsics.areEqual((Object) this.customType, (Object) BlueDeviceScheduleEndType.PREVIOUS)) {
                    setModeControls(arrayList);
                    return;
                }
            }
            if (hasHumidification()) {
                arrayList.add(ModeControl.HUMIDIFICATION);
            }
            if (this.device instanceof DeviceDehumidifier) {
                arrayList.add(ModeControl.MAIN_MODES_DEHUM);
            }
            Device device2 = this.device;
            if (!(device2 instanceof DeviceMiniRestful) || ((DeviceMiniRestful) device2).hasNightMode()) {
                arrayList.add(ModeControl.MODE_BUTTONS);
            }
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else if (this.isStartMode || !Intrinsics.areEqual((Object) this.customType, (Object) BlueDeviceScheduleEndType.PREVIOUS)) {
            Device device3 = this.device;
            if ((device3 instanceof DeviceDehumidifier) || (device3 instanceof HasWick)) {
                arrayList.add(ModeControl.TARGET_HUM);
            }
            switch (WhenMappings.$EnumSwitchMapping$1[getMode().ordinal()]) {
                case 1:
                    arrayList.add(0, ModeControl.FAN_SPEED);
                    arrayList.add(ModeControl.BRIGHTNESS);
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    arrayList.add(ModeControl.BRIGHTNESS);
                    break;
            }
        } else {
            setModeControls(CollectionsKt.emptyList());
            return;
        }
        setModeControls(arrayList);
        if (this.firstRefresh) {
            this.firstRefresh = false;
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        switch (WhenMappings.$EnumSwitchMapping$3[((ModeControl) ModeControl.getEntries().get(i)).ordinal()]) {
            case 1:
                return DeviceScheduleCustomTypeV2Holder.Companion.newInstance(viewGroup, new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda0(this), new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda1(this));
            case 2:
                return DeviceMainModeDehumHolder.Companion.newInstance(viewGroup, new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda2(this));
            case 3:
                return DeviceModeButtonsV2Holder.Companion.newInstance(viewGroup, this.device, new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda3(this));
            case 4:
                return DeviceFanSpeedV2Holder.Companion.newInstance(viewGroup, this.device, true, new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda4(this));
            case 5:
                return DeviceTargetHumidityHolder.Companion.newInstance(viewGroup, this.device, true, new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda5(this), new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda6(), new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda7(this));
            case 6:
                return DeviceBrightnessV2Holder.Companion.newInstance(viewGroup, true, new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda8(this));
            case 7:
                return DeviceHumidificationHolder.Companion.newInstance$default(DeviceHumidificationHolder.Companion, viewGroup, true, new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda9(this), (Function0) null, 8, (Object) null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$1(DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter) {
        deviceScheduleModeV2Adapter.onActionListener.invoke(Action.END_TYPE_HINT_CLOSED.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$2(DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        deviceScheduleModeV2Adapter.setCustomType(str);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$3(DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter, MainMode mainMode2) {
        Intrinsics.checkNotNullParameter(mainMode2, "it");
        deviceScheduleModeV2Adapter.setMainMode(mainMode2);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$5(DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter, ModeIcon modeIcon) {
        Intrinsics.checkNotNullParameter(modeIcon, "selectedMode");
        DeviceCreateEditScheduleViewModel.PurifierMode fromModeIcon = DeviceCreateEditScheduleViewModel.PurifierMode.Companion.fromModeIcon(modeIcon);
        if (fromModeIcon != null) {
            if (deviceScheduleModeV2Adapter.device instanceof HasHumMainMode) {
                int i = WhenMappings.$EnumSwitchMapping$1[fromModeIcon.ordinal()];
                if (i == 2) {
                    deviceScheduleModeV2Adapter.setMainMode(MainMode.AirPurify);
                } else if (i == 4) {
                    deviceScheduleModeV2Adapter.setMainMode(MainMode.Humidification);
                }
            }
            deviceScheduleModeV2Adapter.setMode(fromModeIcon);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$6(DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter, FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "it");
        deviceScheduleModeV2Adapter.fanSpeed = fanSpeedEnum;
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$7(DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter) {
        deviceScheduleModeV2Adapter.onActionListener.invoke(Action.OPEN_TARGET_HUMIDITY_INFO.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$8(boolean z) {
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$9(DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter, int i) {
        deviceScheduleModeV2Adapter.autoRh = i;
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$10(DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter, int i) {
        deviceScheduleModeV2Adapter.brightness = Integer.valueOf(i);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$11(DeviceScheduleModeV2Adapter deviceScheduleModeV2Adapter) {
        MainMode mainMode2;
        boolean isHumOn = deviceScheduleModeV2Adapter.isHumOn();
        boolean z = !isHumOn;
        if (deviceScheduleModeV2Adapter.device instanceof HasHumMainMode) {
            if (isHumOn) {
                mainMode2 = MainMode.AirPurify;
            } else {
                mainMode2 = MainMode.Humidification;
            }
            deviceScheduleModeV2Adapter.setMainMode(mainMode2);
        } else {
            deviceScheduleModeV2Adapter.setHumMode(z);
            deviceScheduleModeV2Adapter.onActionListener.invoke(new Action.HUM_MODE_CHANGED(deviceScheduleModeV2Adapter.humMode));
        }
        return Unit.INSTANCE;
    }

    public int getItemCount() {
        return this.modeControls.size();
    }

    public int getItemViewType(int i) {
        return ((ModeControl) this.modeControls.get(i)).ordinal();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r9, int r10) {
        /*
            r8 = this;
            java.lang.String r10 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r10)
            boolean r10 = r9 instanceof com.blueair.devicedetails.viewholder.DeviceScheduleCustomTypeV2Holder
            if (r10 == 0) goto L_0x0013
            com.blueair.devicedetails.viewholder.DeviceScheduleCustomTypeV2Holder r9 = (com.blueair.devicedetails.viewholder.DeviceScheduleCustomTypeV2Holder) r9
            java.lang.String r10 = r8.customType
            boolean r0 = r8.endTypeHintClosedBefore
            r9.update(r10, r0)
            return
        L_0x0013:
            boolean r10 = r9 instanceof com.blueair.devicedetails.viewholder.DeviceMainModeDehumHolder
            r0 = 1
            if (r10 == 0) goto L_0x0023
            com.blueair.devicedetails.viewholder.DeviceMainModeDehumHolder r9 = (com.blueair.devicedetails.viewholder.DeviceMainModeDehumHolder) r9
            com.blueair.core.model.MainMode r10 = r8.mainMode
            boolean r1 = r8.isStandByOn
            r0 = r0 ^ r1
            r9.update((com.blueair.core.model.MainMode) r10, (boolean) r0)
            return
        L_0x0023:
            boolean r10 = r9 instanceof com.blueair.devicedetails.viewholder.DeviceModeButtonsV2Holder
            if (r10 == 0) goto L_0x0042
            r1 = r9
            com.blueair.devicedetails.viewholder.DeviceModeButtonsV2Holder r1 = (com.blueair.devicedetails.viewholder.DeviceModeButtonsV2Holder) r1
            com.blueair.core.model.MainMode r2 = r8.mainMode
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r9 = r8.getMode()
            com.blueair.core.model.Device r10 = r8.device
            com.blueair.viewcore.utils.ModeIcon r3 = r9.toModeIcon(r10)
            java.util.Set r4 = r8.getStayOffModes()
            r6 = 8
            r7 = 0
            r5 = 0
            com.blueair.devicedetails.viewholder.DeviceModeButtonsV2Holder.update$default(r1, r2, r3, r4, r5, r6, r7)
            return
        L_0x0042:
            boolean r10 = r9 instanceof com.blueair.devicedetails.viewholder.DeviceFanSpeedV2Holder
            r1 = 0
            if (r10 == 0) goto L_0x0050
            com.blueair.devicedetails.viewholder.DeviceFanSpeedV2Holder r9 = (com.blueair.devicedetails.viewholder.DeviceFanSpeedV2Holder) r9
            com.blueair.core.model.FanSpeedEnum r10 = r8.fanSpeed
            r0 = 2
            com.blueair.devicedetails.viewholder.DeviceFanSpeedV2Holder.update$default(r9, r10, r1, r0, r1)
            return
        L_0x0050:
            boolean r10 = r9 instanceof com.blueair.devicedetails.viewholder.DeviceBrightnessV2Holder
            if (r10 == 0) goto L_0x0085
            java.lang.Object r10 = r8.brightness
            boolean r0 = r10 instanceof com.blueair.core.model.Brightness
            if (r0 == 0) goto L_0x005d
            com.blueair.core.model.Brightness r10 = (com.blueair.core.model.Brightness) r10
            goto L_0x005e
        L_0x005d:
            r10 = r1
        L_0x005e:
            if (r10 == 0) goto L_0x006c
            r0 = r9
            com.blueair.devicedetails.viewholder.DeviceBrightnessV2Holder r0 = (com.blueair.devicedetails.viewholder.DeviceBrightnessV2Holder) r0
            com.blueair.core.model.Device r2 = r8.device
            int r10 = r10.toPercentage()
            r0.update((com.blueair.core.model.Device) r2, (int) r10)
        L_0x006c:
            java.lang.Object r10 = r8.brightness
            boolean r0 = r10 instanceof java.lang.Integer
            if (r0 == 0) goto L_0x0075
            r1 = r10
            java.lang.Integer r1 = (java.lang.Integer) r1
        L_0x0075:
            if (r1 == 0) goto L_0x00bb
            java.lang.Number r1 = (java.lang.Number) r1
            int r10 = r1.intValue()
            com.blueair.devicedetails.viewholder.DeviceBrightnessV2Holder r9 = (com.blueair.devicedetails.viewholder.DeviceBrightnessV2Holder) r9
            com.blueair.core.model.Device r0 = r8.device
            r9.update((com.blueair.core.model.Device) r0, (int) r10)
            return
        L_0x0085:
            boolean r10 = r9 instanceof com.blueair.devicedetails.viewholder.DeviceTargetHumidityHolder
            r1 = 0
            if (r10 == 0) goto L_0x00a4
            com.blueair.devicedetails.viewholder.DeviceTargetHumidityHolder r9 = (com.blueair.devicedetails.viewholder.DeviceTargetHumidityHolder) r9
            int r10 = r8.autoRh
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r2 = r8.getMode()
            boolean r3 = r8.isHumOn()
            if (r3 != 0) goto L_0x00a0
            boolean r3 = r8.hasHumidification()
            if (r3 != 0) goto L_0x009f
            goto L_0x00a0
        L_0x009f:
            r0 = r1
        L_0x00a0:
            r9.update(r10, r2, r0)
            return
        L_0x00a4:
            boolean r10 = r9 instanceof com.blueair.devicedetails.viewholder.DeviceHumidificationHolder
            if (r10 == 0) goto L_0x00bb
            com.blueair.devicedetails.viewholder.DeviceHumidificationHolder r9 = (com.blueair.devicedetails.viewholder.DeviceHumidificationHolder) r9
            boolean r10 = r8.isHumOn()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r2 = r8.getMode()
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r3 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY
            if (r2 != r3) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            r0 = r1
        L_0x00b8:
            r9.update((boolean) r10, (boolean) r0)
        L_0x00bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.adapter.DeviceScheduleModeV2Adapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    private final boolean isHumOn() {
        Device device2 = this.device;
        if (device2 instanceof HasHumMainMode) {
            return this.mainMode == MainMode.Humidification;
        }
        if (device2 instanceof HasHumMode) {
            return this.humMode;
        }
        return false;
    }

    private final boolean hasHumidification() {
        Device device2 = this.device;
        return (device2 instanceof HasHumMode) || (device2 instanceof HasHumMainMode);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$ControlGroup;", "", "<init>", "(Ljava/lang/String;I)V", "MODES", "CONTROLS", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceScheduleModeV2Adapter.kt */
    public enum ControlGroup {
        MODES,
        CONTROLS;

        public static EnumEntries<ControlGroup> getEntries() {
            return $ENTRIES;
        }

        static {
            ControlGroup[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$ModeControl;", "", "group", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$ControlGroup;", "<init>", "(Ljava/lang/String;ILcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$ControlGroup;)V", "getGroup", "()Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$ControlGroup;", "CUSTOM_TYPE", "MAIN_MODES_DEHUM", "HUMIDIFICATION", "MODE_BUTTONS", "FAN_SPEED", "TARGET_HUM", "BRIGHTNESS", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceScheduleModeV2Adapter.kt */
    public enum ModeControl {
        CUSTOM_TYPE(ControlGroup.MODES),
        MAIN_MODES_DEHUM(ControlGroup.MODES),
        HUMIDIFICATION(ControlGroup.MODES),
        MODE_BUTTONS(ControlGroup.MODES),
        FAN_SPEED(ControlGroup.CONTROLS),
        TARGET_HUM(ControlGroup.CONTROLS),
        BRIGHTNESS(ControlGroup.CONTROLS);
        
        private final ControlGroup group;

        public static EnumEntries<ModeControl> getEntries() {
            return $ENTRIES;
        }

        private ModeControl(ControlGroup controlGroup) {
            this.group = controlGroup;
        }

        public final ControlGroup getGroup() {
            return this.group;
        }

        static {
            ModeControl[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0007\t\n\u000b\f\r\u000e\u000fB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u0001\u0007\u0010\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "T", "", "data", "<init>", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "MAIN_MODE_CHANGED", "SUB_MODE_CHANGED", "OPEN_TARGET_HUMIDITY_INFO", "END_TYPE_HINT_CLOSED", "CUSTOM_TYPE_CHANGED", "ITEM_COUNT_CHANGED", "HUM_MODE_CHANGED", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$CUSTOM_TYPE_CHANGED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$END_TYPE_HINT_CLOSED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$HUM_MODE_CHANGED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$ITEM_COUNT_CHANGED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$MAIN_MODE_CHANGED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$OPEN_TARGET_HUMIDITY_INFO;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$SUB_MODE_CHANGED;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceScheduleModeV2Adapter.kt */
    public static abstract class Action<T> {
        private final T data;

        public /* synthetic */ Action(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj);
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$MAIN_MODE_CHANGED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "Lcom/blueair/core/model/MainMode;", "mainMode", "<init>", "(Lcom/blueair/core/model/MainMode;)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeviceScheduleModeV2Adapter.kt */
        public static final class MAIN_MODE_CHANGED extends Action<MainMode> {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MAIN_MODE_CHANGED(MainMode mainMode) {
                super(mainMode, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(mainMode, "mainMode");
            }
        }

        private Action(T t) {
            this.data = t;
        }

        public final T getData() {
            return this.data;
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$SUB_MODE_CHANGED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "subMode", "<init>", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeviceScheduleModeV2Adapter.kt */
        public static final class SUB_MODE_CHANGED extends Action<DeviceCreateEditScheduleViewModel.PurifierMode> {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SUB_MODE_CHANGED(DeviceCreateEditScheduleViewModel.PurifierMode purifierMode) {
                super(purifierMode, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(purifierMode, "subMode");
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$OPEN_TARGET_HUMIDITY_INFO;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeviceScheduleModeV2Adapter.kt */
        public static final class OPEN_TARGET_HUMIDITY_INFO extends Action<Unit> {
            public static final OPEN_TARGET_HUMIDITY_INFO INSTANCE = new OPEN_TARGET_HUMIDITY_INFO();

            private OPEN_TARGET_HUMIDITY_INFO() {
                super(Unit.INSTANCE, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$END_TYPE_HINT_CLOSED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeviceScheduleModeV2Adapter.kt */
        public static final class END_TYPE_HINT_CLOSED extends Action<Unit> {
            public static final END_TYPE_HINT_CLOSED INSTANCE = new END_TYPE_HINT_CLOSED();

            private END_TYPE_HINT_CLOSED() {
                super(Unit.INSTANCE, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$CUSTOM_TYPE_CHANGED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "", "type", "<init>", "(Ljava/lang/String;)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeviceScheduleModeV2Adapter.kt */
        public static final class CUSTOM_TYPE_CHANGED extends Action<String> {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CUSTOM_TYPE_CHANGED(String str) {
                super(str, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "type");
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$ITEM_COUNT_CHANGED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "", "count", "<init>", "(I)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeviceScheduleModeV2Adapter.kt */
        public static final class ITEM_COUNT_CHANGED extends Action<Integer> {
            public ITEM_COUNT_CHANGED(int i) {
                super(Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$HUM_MODE_CHANGED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "", "humMode", "<init>", "(Z)V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeviceScheduleModeV2Adapter.kt */
        public static final class HUM_MODE_CHANGED extends Action<Boolean> {
            public HUM_MODE_CHANGED(boolean z) {
                super(Boolean.valueOf(z), (DefaultConstructorMarker) null);
            }
        }
    }
}
