package com.blueair.devicedetails.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasAutoRh;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.HasOscillation;
import com.blueair.core.model.HasPetMainMode;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.SmartSubMode;
import com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder;
import com.blueair.devicedetails.viewholder.DeviceHAuthRhHolder;
import com.blueair.devicedetails.viewholder.DeviceMainModeButtonsHolder;
import com.blueair.devicedetails.viewholder.DeviceNBrightnessHolder;
import com.blueair.devicedetails.viewholder.DeviceNFanSpeedHolder;
import com.blueair.devicedetails.viewholder.DeviceNModeButtonsHolder;
import com.blueair.devicedetails.viewholder.DeviceNOnOffButtonHolder;
import com.blueair.devicedetails.viewholder.DeviceNScheduleCustomTypeHolder;
import com.blueair.devicedetails.viewholder.DeviceOscillationHolder;
import com.blueair.devicedetails.viewholder.DeviceSubAutoHolder;
import com.blueair.devicedetails.viewholder.DeviceTargetTemperatureHolder;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.utils.ModeIcon;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b+\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001TBw\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010I\u001a\u00020JH\u0002J\u0018\u0010K\u001a\u00020\u00022\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0010H\u0016J\b\u0010O\u001a\u00020\u0010H\u0016J\u0010\u0010P\u001a\u00020\u00102\u0006\u0010Q\u001a\u00020\u0010H\u0016J\u0018\u0010R\u001a\u00020J2\u0006\u0010S\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010 R$\u0010\u0007\u001a\u00020\b2\u0006\u0010!\u001a\u00020\b@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\n2\u0006\u0010!\u001a\u00020\n@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010\u0011\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010\u0013\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0014@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\f@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010<R\u001e\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b>\u0010 R$\u0010\u001b\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010 \"\u0004\b@\u0010AR\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR*\u0010F\u001a\b\u0012\u0004\u0012\u00020E0D2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020E0D@BX\u000e¢\u0006\b\n\u0000\"\u0004\bG\u0010H¨\u0006U"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceNScheduleModeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "device", "Lcom/blueair/core/model/Device;", "isStartMode", "", "customType", "", "mode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "fanSpeed", "Lcom/blueair/core/model/FanSpeedEnum;", "brightness", "", "autoRh", "", "mainMode", "Lcom/blueair/core/model/MainMode;", "apSubMode", "Lcom/blueair/core/model/ApSubMode;", "smartSubMode", "Lcom/blueair/core/model/SmartSubMode;", "heatAutoTemp", "", "heatEcoTmp", "oscillationEnabled", "humMode", "<init>", "(Lcom/blueair/core/model/Device;ZLjava/lang/String;Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;Lcom/blueair/core/model/FanSpeedEnum;Ljava/lang/Object;ILcom/blueair/core/model/MainMode;Lcom/blueair/core/model/ApSubMode;Lcom/blueair/core/model/SmartSubMode;DDZZ)V", "getDevice", "()Lcom/blueair/core/model/Device;", "()Z", "value", "getCustomType", "()Ljava/lang/String;", "setCustomType", "(Ljava/lang/String;)V", "lastMode", "getMode", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "setMode", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;)V", "getMainMode", "()Lcom/blueair/core/model/MainMode;", "setMainMode", "(Lcom/blueair/core/model/MainMode;)V", "getApSubMode", "()Lcom/blueair/core/model/ApSubMode;", "setApSubMode", "(Lcom/blueair/core/model/ApSubMode;)V", "getFanSpeed", "()Lcom/blueair/core/model/FanSpeedEnum;", "setFanSpeed", "(Lcom/blueair/core/model/FanSpeedEnum;)V", "getBrightness", "()Ljava/lang/Object;", "getAutoRh", "()I", "getHeatAutoTemp", "()D", "getHeatEcoTmp", "getOscillationEnabled", "getHumMode", "setHumMode", "(Z)V", "getSmartSubMode", "()Lcom/blueair/core/model/SmartSubMode;", "", "Lcom/blueair/devicedetails/adapter/DeviceNScheduleModeAdapter$ModeControl;", "modeControls", "setModeControls", "(Ljava/util/List;)V", "refreshControls", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "ModeControl", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNScheduleModeAdapter.kt */
public final class DeviceNScheduleModeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ApSubMode apSubMode;
    private int autoRh;
    private Object brightness;
    private String customType;
    private final Device device;
    private FanSpeedEnum fanSpeed;
    private double heatAutoTemp;
    private double heatEcoTmp;
    private boolean humMode;
    private final boolean isStartMode;
    private DeviceCreateEditScheduleViewModel.PurifierMode lastMode;
    private MainMode mainMode;
    private DeviceCreateEditScheduleViewModel.PurifierMode mode;
    private List<? extends ModeControl> modeControls = CollectionsKt.emptyList();
    private boolean oscillationEnabled;
    private SmartSubMode smartSubMode;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNScheduleModeAdapter.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|(2:47|48)|49|51) */
        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|(2:47|48)|49|51) */
        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|51) */
        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|51) */
        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|51) */
        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|51) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0075 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x008f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0098 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00a2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00ac */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b6 */
        static {
            /*
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode[] r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r2 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.SMART     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r3 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r4 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.AUTO     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r5 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.ECO     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                com.blueair.core.model.ApSubMode[] r0 = com.blueair.core.model.ApSubMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.ApSubMode r5 = com.blueair.core.model.ApSubMode.FAN     // Catch:{ NoSuchFieldError -> 0x003c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                com.blueair.core.model.ApSubMode r5 = com.blueair.core.model.ApSubMode.AUTO     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                com.blueair.core.model.ApSubMode r5 = com.blueair.core.model.ApSubMode.ECO     // Catch:{ NoSuchFieldError -> 0x004c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                com.blueair.core.model.ApSubMode r5 = com.blueair.core.model.ApSubMode.NIGHT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                $EnumSwitchMapping$1 = r0
                com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter$ModeControl[] r0 = com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter.ModeControl.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter$ModeControl r5 = com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter.ModeControl.CUSTOM_TYPE     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter$ModeControl r1 = com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter.ModeControl.MAIN_MODE_BUTTONS     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter$ModeControl r1 = com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter.ModeControl.MODE_BUTTONS     // Catch:{ NoSuchFieldError -> 0x0075 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0075 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0075 }
            L_0x0075:
                com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter$ModeControl r1 = com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter.ModeControl.FAN_SPEED     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter$ModeControl r1 = com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter.ModeControl.BRIGHTNESS     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter$ModeControl r1 = com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter.ModeControl.AUTO_RH     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter$ModeControl r1 = com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter.ModeControl.ON_OFF     // Catch:{ NoSuchFieldError -> 0x0098 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0098 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0098 }
            L_0x0098:
                com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter$ModeControl r1 = com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter.ModeControl.HUM_MODE     // Catch:{ NoSuchFieldError -> 0x00a2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a2 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a2 }
            L_0x00a2:
                com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter$ModeControl r1 = com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter.ModeControl.TARGET_TEMPERATURE     // Catch:{ NoSuchFieldError -> 0x00ac }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ac }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ac }
            L_0x00ac:
                com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter$ModeControl r1 = com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter.ModeControl.OSCILLATION     // Catch:{ NoSuchFieldError -> 0x00b6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b6 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b6 }
            L_0x00b6:
                com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter$ModeControl r1 = com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter.ModeControl.SUB_AUTO     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                $EnumSwitchMapping$2 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter.WhenMappings.<clinit>():void");
        }
    }

    public final Device getDevice() {
        return this.device;
    }

    public final boolean isStartMode() {
        return this.isStartMode;
    }

    public DeviceNScheduleModeAdapter(Device device2, boolean z, String str, DeviceCreateEditScheduleViewModel.PurifierMode purifierMode, FanSpeedEnum fanSpeedEnum, Object obj, int i, MainMode mainMode2, ApSubMode apSubMode2, SmartSubMode smartSubMode2, double d, double d2, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(device2, "device");
        Intrinsics.checkNotNullParameter(str, "customType");
        Intrinsics.checkNotNullParameter(purifierMode, "mode");
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "fanSpeed");
        Intrinsics.checkNotNullParameter(obj, "brightness");
        Intrinsics.checkNotNullParameter(mainMode2, "mainMode");
        Intrinsics.checkNotNullParameter(apSubMode2, "apSubMode");
        Intrinsics.checkNotNullParameter(smartSubMode2, "smartSubMode");
        this.device = device2;
        this.isStartMode = z;
        this.customType = str;
        this.lastMode = purifierMode;
        this.mode = purifierMode;
        this.mainMode = mainMode2;
        this.apSubMode = apSubMode2;
        this.fanSpeed = fanSpeedEnum;
        this.brightness = obj;
        this.autoRh = i;
        this.heatAutoTemp = d;
        this.heatEcoTmp = d2;
        this.oscillationEnabled = z2;
        this.humMode = z3;
        this.smartSubMode = smartSubMode2;
        refreshControls();
    }

    public final String getCustomType() {
        return this.customType;
    }

    private final void setCustomType(String str) {
        if (!Intrinsics.areEqual((Object) this.customType, (Object) str)) {
            this.customType = str;
            refreshControls();
        }
    }

    public final DeviceCreateEditScheduleViewModel.PurifierMode getMode() {
        return this.mode;
    }

    private final void setMode(DeviceCreateEditScheduleViewModel.PurifierMode purifierMode) {
        DeviceCreateEditScheduleViewModel.PurifierMode purifierMode2 = this.mode;
        if (purifierMode2 != purifierMode) {
            this.lastMode = purifierMode2;
            this.mode = purifierMode;
            refreshControls();
        }
    }

    public final MainMode getMainMode() {
        return this.mainMode;
    }

    private final void setMainMode(MainMode mainMode2) {
        if (this.mainMode != mainMode2) {
            this.mainMode = mainMode2;
            setApSubMode(ApSubMode.FAN);
            setFanSpeed(FanSpeedEnum.ELEVEN);
            refreshControls();
        }
    }

    public final ApSubMode getApSubMode() {
        return this.apSubMode;
    }

    private final void setApSubMode(ApSubMode apSubMode2) {
        if (this.apSubMode != apSubMode2) {
            this.apSubMode = apSubMode2;
            refreshControls();
        }
    }

    public final FanSpeedEnum getFanSpeed() {
        return this.fanSpeed;
    }

    private final void setFanSpeed(FanSpeedEnum fanSpeedEnum) {
        if (this.fanSpeed != fanSpeedEnum) {
            this.fanSpeed = fanSpeedEnum;
            if (this.device instanceof HasCombo3in1MainMode) {
                refreshControls();
            }
        }
    }

    public final Object getBrightness() {
        return this.brightness;
    }

    public final int getAutoRh() {
        return this.autoRh;
    }

    public final double getHeatAutoTemp() {
        return this.heatAutoTemp;
    }

    public final double getHeatEcoTmp() {
        return this.heatEcoTmp;
    }

    public final boolean getOscillationEnabled() {
        return this.oscillationEnabled;
    }

    public final boolean getHumMode() {
        return this.humMode;
    }

    private final void setHumMode(boolean z) {
        if (this.humMode != z) {
            this.humMode = z;
            refreshControls();
        }
    }

    public final SmartSubMode getSmartSubMode() {
        return this.smartSubMode;
    }

    private final void setModeControls(List<? extends ModeControl> list) {
        this.modeControls = list;
        notifyDataSetChanged();
    }

    private final void refreshControls() {
        List arrayList = new ArrayList();
        if (!this.isStartMode) {
            arrayList.add(ModeControl.CUSTOM_TYPE);
            if (!Intrinsics.areEqual((Object) this.customType, (Object) "custom")) {
                setModeControls(arrayList);
                return;
            }
        }
        Device device2 = this.device;
        if (device2 instanceof HasPetMainMode) {
            arrayList.add(ModeControl.ON_OFF);
            if (this.mode != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
                arrayList.add(ModeControl.MODE_BUTTONS);
                int i = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
                if (i == 1) {
                    arrayList.add(ModeControl.BRIGHTNESS);
                } else if (i == 2) {
                    arrayList.add(ModeControl.FAN_SPEED);
                    arrayList.add(ModeControl.BRIGHTNESS);
                }
            }
        } else if (device2 instanceof HasCombo3in1MainMode) {
            arrayList.add(ModeControl.ON_OFF);
            arrayList.add(ModeControl.MAIN_MODE_BUTTONS);
            if (this.mode != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY && (!this.device.isUsDevice() || this.mainMode != MainMode.HEAT)) {
                int i2 = WhenMappings.$EnumSwitchMapping$1[this.apSubMode.ordinal()];
                if (i2 == 1) {
                    arrayList.add(ModeControl.FAN_SPEED);
                    if ((this.device instanceof HasOscillation) && this.fanSpeed.compareTo(FanSpeedEnum.OFF) > 0) {
                        arrayList.add(ModeControl.OSCILLATION);
                    }
                    arrayList.add(ModeControl.BRIGHTNESS);
                } else if (i2 == 2) {
                    if (this.device instanceof HasAutoRh) {
                        arrayList.add(ModeControl.AUTO_RH);
                    }
                    if (this.mainMode == MainMode.HEAT) {
                        arrayList.add(ModeControl.TARGET_TEMPERATURE);
                    }
                    if (this.device instanceof HasOscillation) {
                        arrayList.add(ModeControl.OSCILLATION);
                    }
                    arrayList.add(ModeControl.BRIGHTNESS);
                } else if (i2 != 3) {
                    if (i2 == 4 && (this.device instanceof HasOscillation)) {
                        arrayList.add(ModeControl.OSCILLATION);
                    }
                } else if (this.mainMode == MainMode.HEAT) {
                    arrayList.add(ModeControl.TARGET_TEMPERATURE);
                }
            }
        } else if (device2 instanceof HasMode) {
            arrayList.add(ModeControl.ON_OFF);
            if ((this.device instanceof HasHumMode) && this.mode != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
                arrayList.add(ModeControl.HUM_MODE);
            }
            arrayList.add(ModeControl.MODE_BUTTONS);
            int i3 = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
            if (i3 == 2) {
                arrayList.add(ModeControl.FAN_SPEED);
                arrayList.add(ModeControl.BRIGHTNESS);
            } else if (i3 == 3) {
                Device device3 = this.device;
                if ((device3 instanceof HasAutoRh) && (!(device3 instanceof HasHumMode) || this.humMode)) {
                    arrayList.add(ModeControl.AUTO_RH);
                }
                arrayList.add(ModeControl.BRIGHTNESS);
            }
        } else {
            arrayList.add(ModeControl.MODE_BUTTONS);
            int i4 = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
            if (i4 == 2) {
                arrayList.add(ModeControl.FAN_SPEED);
                arrayList.add(ModeControl.BRIGHTNESS);
            } else if (i4 == 3) {
                Device device4 = this.device;
                if ((device4 instanceof HasAutoRh) && (!(device4 instanceof HasHumMode) || this.humMode)) {
                    arrayList.add(ModeControl.AUTO_RH);
                }
                arrayList.add(ModeControl.BRIGHTNESS);
            } else if (i4 == 4 && !(this.device instanceof DeviceNewClassic)) {
                arrayList.add(ModeControl.BRIGHTNESS);
            }
            arrayList.add(ModeControl.ON_OFF);
        }
        setModeControls(arrayList);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        switch (WhenMappings.$EnumSwitchMapping$2[((ModeControl) ModeControl.getEntries().get(i)).ordinal()]) {
            case 1:
                return DeviceNScheduleCustomTypeHolder.Companion.newInstance(viewGroup, this.device);
            case 2:
                return DeviceMainModeButtonsHolder.Companion.newInstance(viewGroup, this.device, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda0(this), new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda10(this));
            case 3:
                return DeviceNModeButtonsHolder.Companion.newInstance(viewGroup, this.device, true, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda11(this));
            case 4:
                return DeviceNFanSpeedHolder.Companion.newInstance(viewGroup, this.device, true, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda12(this));
            case 5:
                return DeviceNBrightnessHolder.Companion.newInstance(viewGroup, this.device, true, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda13(this));
            case 6:
                return DeviceHAuthRhHolder.Companion.newInstance(viewGroup, true, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda14(), new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda1(this));
            case 7:
                ViewGroup viewGroup2 = viewGroup;
                Device device2 = this.device;
                return ((device2 instanceof DeviceNewClassic) || (device2 instanceof DeviceHumidifier)) ? DeviceNOnOffButtonHolder.Companion.newInstance(viewGroup2, this.device, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda2(this)) : DeviceCOnOffButtonHolder.Companion.newInstance(viewGroup2, this.device, DeviceCOnOffButtonHolder.Type.STANDBY, true, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda3(this));
            case 8:
                return DeviceCOnOffButtonHolder.Companion.newInstance(viewGroup, this.device, DeviceCOnOffButtonHolder.Type.HUM, true, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda4(this));
            case 9:
                return DeviceTargetTemperatureHolder.Companion.newInstance(viewGroup, this.device, true, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda6(this));
            case 10:
                return DeviceOscillationHolder.Companion.newInstance(viewGroup, true, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda7(this), new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda8());
            case 11:
                return DeviceSubAutoHolder.Companion.newInstance(viewGroup, this.device, true, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda9(this));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$0(DeviceNScheduleModeAdapter deviceNScheduleModeAdapter, MainMode mainMode2) {
        Intrinsics.checkNotNullParameter(mainMode2, "it");
        deviceNScheduleModeAdapter.setMainMode(mainMode2);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$1(DeviceNScheduleModeAdapter deviceNScheduleModeAdapter, ApSubMode apSubMode2) {
        Intrinsics.checkNotNullParameter(apSubMode2, "it");
        deviceNScheduleModeAdapter.setApSubMode(apSubMode2);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$3(DeviceNScheduleModeAdapter deviceNScheduleModeAdapter, ModeIcon modeIcon) {
        Intrinsics.checkNotNullParameter(modeIcon, "selectedMode");
        DeviceCreateEditScheduleViewModel.PurifierMode fromModeIcon = DeviceCreateEditScheduleViewModel.PurifierMode.Companion.fromModeIcon(modeIcon);
        if (fromModeIcon != null) {
            deviceNScheduleModeAdapter.setMode(fromModeIcon);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$4(DeviceNScheduleModeAdapter deviceNScheduleModeAdapter, FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "it");
        deviceNScheduleModeAdapter.setFanSpeed(fanSpeedEnum);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$5(DeviceNScheduleModeAdapter deviceNScheduleModeAdapter, int i) {
        deviceNScheduleModeAdapter.brightness = Integer.valueOf(i);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$6() {
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$7(DeviceNScheduleModeAdapter deviceNScheduleModeAdapter, int i) {
        deviceNScheduleModeAdapter.autoRh = i;
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$8(DeviceNScheduleModeAdapter deviceNScheduleModeAdapter) {
        DeviceCreateEditScheduleViewModel.PurifierMode purifierMode;
        if (deviceNScheduleModeAdapter.mode == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
            purifierMode = deviceNScheduleModeAdapter.lastMode == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY ? DeviceCreateEditScheduleViewModel.PurifierMode.AUTO : deviceNScheduleModeAdapter.lastMode;
        } else {
            purifierMode = DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY;
        }
        deviceNScheduleModeAdapter.setMode(purifierMode);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$9(DeviceNScheduleModeAdapter deviceNScheduleModeAdapter, DeviceCOnOffButtonHolder.Type type, boolean z) {
        DeviceCreateEditScheduleViewModel.PurifierMode purifierMode;
        Intrinsics.checkNotNullParameter(type, "<unused var>");
        if (deviceNScheduleModeAdapter.mode != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
            purifierMode = DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY;
        } else if (deviceNScheduleModeAdapter.lastMode == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
            purifierMode = deviceNScheduleModeAdapter.device instanceof DevicePet20 ? DeviceCreateEditScheduleViewModel.PurifierMode.SMART : DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
        } else {
            purifierMode = deviceNScheduleModeAdapter.lastMode;
        }
        deviceNScheduleModeAdapter.setMode(purifierMode);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$10(DeviceNScheduleModeAdapter deviceNScheduleModeAdapter, DeviceCOnOffButtonHolder.Type type, boolean z) {
        Intrinsics.checkNotNullParameter(type, "<unused var>");
        deviceNScheduleModeAdapter.setHumMode(!deviceNScheduleModeAdapter.humMode);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$11(DeviceNScheduleModeAdapter deviceNScheduleModeAdapter, double d) {
        if (deviceNScheduleModeAdapter.device instanceof HasCombo3in1MainMode) {
            int i = WhenMappings.$EnumSwitchMapping$1[deviceNScheduleModeAdapter.apSubMode.ordinal()];
            if (i == 2) {
                deviceNScheduleModeAdapter.heatAutoTemp = d;
            } else if (i == 3) {
                deviceNScheduleModeAdapter.heatEcoTmp = d;
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$12(DeviceNScheduleModeAdapter deviceNScheduleModeAdapter, boolean z) {
        deviceNScheduleModeAdapter.oscillationEnabled = z;
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$13() {
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$14(DeviceNScheduleModeAdapter deviceNScheduleModeAdapter, boolean z) {
        deviceNScheduleModeAdapter.smartSubMode = z ? SmartSubMode.AUTO_ON : SmartSubMode.AUTO_OFF;
        return Unit.INSTANCE;
    }

    public int getItemCount() {
        return this.modeControls.size();
    }

    public int getItemViewType(int i) {
        return ((ModeControl) this.modeControls.get(i)).ordinal();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v30, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r7, int r8) {
        /*
            r6 = this;
            java.lang.String r8 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            boolean r8 = r7 instanceof com.blueair.devicedetails.viewholder.DeviceNScheduleCustomTypeHolder
            if (r8 == 0) goto L_0x0019
            com.blueair.devicedetails.viewholder.DeviceNScheduleCustomTypeHolder r7 = (com.blueair.devicedetails.viewholder.DeviceNScheduleCustomTypeHolder) r7
            java.lang.String r8 = r6.customType
            r7.update(r8)
            com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter$$ExternalSyntheticLambda5 r8 = new com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter$$ExternalSyntheticLambda5
            r8.<init>(r6)
            r7.setOnTypeSelectedListener(r8)
            return
        L_0x0019:
            boolean r8 = r7 instanceof com.blueair.devicedetails.viewholder.DeviceNModeButtonsHolder
            if (r8 == 0) goto L_0x0027
            com.blueair.devicedetails.viewholder.DeviceNModeButtonsHolder r7 = (com.blueair.devicedetails.viewholder.DeviceNModeButtonsHolder) r7
            com.blueair.core.model.Device r8 = r6.device
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = r6.mode
            r7.update(r8, r0)
            return
        L_0x0027:
            boolean r8 = r7 instanceof com.blueair.devicedetails.viewholder.DeviceNFanSpeedHolder
            if (r8 == 0) goto L_0x0033
            com.blueair.devicedetails.viewholder.DeviceNFanSpeedHolder r7 = (com.blueair.devicedetails.viewholder.DeviceNFanSpeedHolder) r7
            com.blueair.core.model.FanSpeedEnum r8 = r6.fanSpeed
            r7.update((com.blueair.core.model.FanSpeedEnum) r8)
            return
        L_0x0033:
            boolean r8 = r7 instanceof com.blueair.devicedetails.viewholder.DeviceNBrightnessHolder
            if (r8 == 0) goto L_0x0065
            java.lang.Object r8 = r6.brightness
            boolean r0 = r8 instanceof com.blueair.core.model.Brightness
            r1 = 0
            if (r0 == 0) goto L_0x0041
            com.blueair.core.model.Brightness r8 = (com.blueair.core.model.Brightness) r8
            goto L_0x0042
        L_0x0041:
            r8 = r1
        L_0x0042:
            if (r8 == 0) goto L_0x004e
            r0 = r7
            com.blueair.devicedetails.viewholder.DeviceNBrightnessHolder r0 = (com.blueair.devicedetails.viewholder.DeviceNBrightnessHolder) r0
            int r8 = r8.toPercentage()
            r0.update((int) r8)
        L_0x004e:
            java.lang.Object r8 = r6.brightness
            boolean r0 = r8 instanceof java.lang.Integer
            if (r0 == 0) goto L_0x0057
            r1 = r8
            java.lang.Integer r1 = (java.lang.Integer) r1
        L_0x0057:
            if (r1 == 0) goto L_0x0110
            java.lang.Number r1 = (java.lang.Number) r1
            int r8 = r1.intValue()
            com.blueair.devicedetails.viewholder.DeviceNBrightnessHolder r7 = (com.blueair.devicedetails.viewholder.DeviceNBrightnessHolder) r7
            r7.update((int) r8)
            return
        L_0x0065:
            boolean r8 = r7 instanceof com.blueair.devicedetails.viewholder.DeviceHAuthRhHolder
            if (r8 == 0) goto L_0x007d
            int r8 = r6.autoRh
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            if (r8 == 0) goto L_0x0110
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            com.blueair.devicedetails.viewholder.DeviceHAuthRhHolder r7 = (com.blueair.devicedetails.viewholder.DeviceHAuthRhHolder) r7
            r7.update((int) r8)
            return
        L_0x007d:
            boolean r8 = r7 instanceof com.blueair.devicedetails.viewholder.DeviceNOnOffButtonHolder
            r0 = 1
            r1 = 0
            if (r8 == 0) goto L_0x0091
            com.blueair.devicedetails.viewholder.DeviceNOnOffButtonHolder r7 = (com.blueair.devicedetails.viewholder.DeviceNOnOffButtonHolder) r7
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r8 = r6.mode
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r2 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY
            if (r8 != r2) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            r0 = r1
        L_0x008d:
            r7.update((boolean) r0)
            return
        L_0x0091:
            boolean r8 = r7 instanceof com.blueair.devicedetails.viewholder.DeviceMainModeButtonsHolder
            if (r8 == 0) goto L_0x00a9
            com.blueair.devicedetails.viewholder.DeviceMainModeButtonsHolder r7 = (com.blueair.devicedetails.viewholder.DeviceMainModeButtonsHolder) r7
            com.blueair.core.model.Device r8 = r6.device
            com.blueair.core.model.MainMode r2 = r6.mainMode
            com.blueair.core.model.ApSubMode r3 = r6.apSubMode
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r4 = r6.mode
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r5 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY
            if (r4 != r5) goto L_0x00a4
            goto L_0x00a5
        L_0x00a4:
            r0 = r1
        L_0x00a5:
            r7.update(r8, r2, r3, r0)
            return
        L_0x00a9:
            boolean r8 = r7 instanceof com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder
            if (r8 == 0) goto L_0x00c6
            com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder r7 = (com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder) r7
            com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder$Type r8 = r7.getType()
            com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder$Type r2 = com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder.Type.HUM
            if (r8 != r2) goto L_0x00ba
            boolean r0 = r6.humMode
            goto L_0x00c2
        L_0x00ba:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r8 = r6.mode
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r2 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY
            if (r8 == r2) goto L_0x00c1
            goto L_0x00c2
        L_0x00c1:
            r0 = r1
        L_0x00c2:
            r7.update((boolean) r0)
            return
        L_0x00c6:
            boolean r8 = r7 instanceof com.blueair.devicedetails.viewholder.DeviceC3FanSpeedHolder
            if (r8 == 0) goto L_0x00d2
            com.blueair.devicedetails.viewholder.DeviceC3FanSpeedHolder r7 = (com.blueair.devicedetails.viewholder.DeviceC3FanSpeedHolder) r7
            com.blueair.core.model.FanSpeedEnum r8 = r6.fanSpeed
            r7.update((com.blueair.core.model.FanSpeedEnum) r8)
            return
        L_0x00d2:
            boolean r8 = r7 instanceof com.blueair.devicedetails.viewholder.DeviceOscillationHolder
            if (r8 == 0) goto L_0x00e0
            com.blueair.devicedetails.viewholder.DeviceOscillationHolder r7 = (com.blueair.devicedetails.viewholder.DeviceOscillationHolder) r7
            com.blueair.core.model.Device r8 = r6.device
            boolean r0 = r6.oscillationEnabled
            r7.update(r8, r0)
            return
        L_0x00e0:
            boolean r8 = r7 instanceof com.blueair.devicedetails.viewholder.DeviceTargetTemperatureHolder
            if (r8 == 0) goto L_0x0105
            com.blueair.core.model.ApSubMode r8 = r6.apSubMode
            int[] r0 = com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter.WhenMappings.$EnumSwitchMapping$1
            int r8 = r8.ordinal()
            r8 = r0[r8]
            r0 = 2
            if (r8 == r0) goto L_0x00fd
            r0 = 3
            if (r8 == r0) goto L_0x00f5
            goto L_0x0110
        L_0x00f5:
            com.blueair.devicedetails.viewholder.DeviceTargetTemperatureHolder r7 = (com.blueair.devicedetails.viewholder.DeviceTargetTemperatureHolder) r7
            double r0 = r6.heatEcoTmp
            r7.update((double) r0)
            return
        L_0x00fd:
            com.blueair.devicedetails.viewholder.DeviceTargetTemperatureHolder r7 = (com.blueair.devicedetails.viewholder.DeviceTargetTemperatureHolder) r7
            double r0 = r6.heatAutoTemp
            r7.update((double) r0)
            return
        L_0x0105:
            boolean r8 = r7 instanceof com.blueair.devicedetails.viewholder.DeviceSubAutoHolder
            if (r8 == 0) goto L_0x0110
            com.blueair.devicedetails.viewholder.DeviceSubAutoHolder r7 = (com.blueair.devicedetails.viewholder.DeviceSubAutoHolder) r7
            com.blueair.core.model.SmartSubMode r8 = r6.smartSubMode
            r7.update((com.blueair.core.model.SmartSubMode) r8)
        L_0x0110:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    /* access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$15(DeviceNScheduleModeAdapter deviceNScheduleModeAdapter, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        deviceNScheduleModeAdapter.setCustomType(str);
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceNScheduleModeAdapter$ModeControl;", "", "<init>", "(Ljava/lang/String;I)V", "CUSTOM_TYPE", "MAIN_MODE_BUTTONS", "MODE_BUTTONS", "FAN_SPEED", "BRIGHTNESS", "AUTO_RH", "ON_OFF", "HUM_MODE", "TARGET_TEMPERATURE", "OSCILLATION", "SUB_AUTO", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNScheduleModeAdapter.kt */
    public enum ModeControl {
        CUSTOM_TYPE,
        MAIN_MODE_BUTTONS,
        MODE_BUTTONS,
        FAN_SPEED,
        BRIGHTNESS,
        AUTO_RH,
        ON_OFF,
        HUM_MODE,
        TARGET_TEMPERATURE,
        OSCILLATION,
        SUB_AUTO;

        public static EnumEntries<ModeControl> getEntries() {
            return $ENTRIES;
        }

        static {
            ModeControl[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }
}
