package com.blueair.devicedetails.adapter;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.DehSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceMiniRestful;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.HasDehumidifierMainMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.HumSubMode;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.model.MoodLampEnum;
import com.blueair.core.model.TimerState;
import com.blueair.core.model.WickDryingGear;
import com.blueair.devicedetails.databinding.HolderDeviceTestBinding;
import com.blueair.devicedetails.util.AttributeAction;
import com.blueair.devicedetails.util.DeviceControl;
import com.blueair.devicedetails.util.DeviceControlGroup;
import com.blueair.devicedetails.viewholder.DeviceAlarmsHolder;
import com.blueair.devicedetails.viewholder.DeviceAutoDryHolder;
import com.blueair.devicedetails.viewholder.DeviceAutoRefreshHolder;
import com.blueair.devicedetails.viewholder.DeviceBrightnessV2Holder;
import com.blueair.devicedetails.viewholder.DeviceControlHolder;
import com.blueair.devicedetails.viewholder.DeviceFanSpeedV2Holder;
import com.blueair.devicedetails.viewholder.DeviceFilterV2Holder;
import com.blueair.devicedetails.viewholder.DeviceGermShieldStatusV2Holder;
import com.blueair.devicedetails.viewholder.DeviceHintHolder;
import com.blueair.devicedetails.viewholder.DeviceHumidificationHolder;
import com.blueair.devicedetails.viewholder.DeviceMainModeDehumHolder;
import com.blueair.devicedetails.viewholder.DeviceModeButtonsV2Holder;
import com.blueair.devicedetails.viewholder.DeviceMoodLampHolder;
import com.blueair.devicedetails.viewholder.DeviceMsgHolder;
import com.blueair.devicedetails.viewholder.DeviceNightLampHolder;
import com.blueair.devicedetails.viewholder.DeviceOfflineV2Holder;
import com.blueair.devicedetails.viewholder.DeviceSchedulesHolder;
import com.blueair.devicedetails.viewholder.DeviceSettingsHolder;
import com.blueair.devicedetails.viewholder.DeviceTargetHumidityHolder;
import com.blueair.devicedetails.viewholder.DeviceTestHolder;
import com.blueair.devicedetails.viewholder.DeviceTimerHolder;
import com.blueair.devicedetails.viewholder.DeviceWickDryingHolder;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.utils.ModeIcon;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010*\u001a\u00020$H\u0002J\u000e\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u000eJ\u000e\u0010-\u001a\u00020$2\u0006\u0010!\u001a\u00020\u001cJ\u000e\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u001cJ\u000e\u00100\u001a\u00020$2\u0006\u0010/\u001a\u00020\u001cJ\u0006\u00101\u001a\u00020$J\u0006\u00102\u001a\u00020$J\u0014\u00103\u001a\u00020$2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\rJ\u001c\u00104\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020;H\u0002J\u001c\u0010<\u001a\u00020$2\n\u0010=\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010>\u001a\u000208H\u0016J\u0010\u0010?\u001a\u0002082\u0006\u0010>\u001a\u000208H\u0016J\b\u0010@\u001a\u000208H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00180\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u001c@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceControlsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "group", "Lcom/blueair/devicedetails/util/DeviceControlGroup;", "onActionPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/devicedetails/util/AttributeAction;", "<init>", "(Lcom/blueair/devicedetails/util/DeviceControlGroup;Lio/reactivex/subjects/PublishSubject;)V", "getGroup", "()Lcom/blueair/devicedetails/util/DeviceControlGroup;", "controls", "", "Lcom/blueair/devicedetails/util/DeviceControl;", "closedControls", "", "value", "Lcom/blueair/core/model/Device;", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "Lcom/blueair/core/model/DeviceScheduleMerged;", "schedules", "getSchedules", "()Ljava/util/List;", "", "autoRefreshHintClosedBefore", "getAutoRefreshHintClosedBefore", "()Z", "humHintClosedBefore", "forceOffline", "onItemCountChangedListener", "Lkotlin/Function0;", "", "getOnItemCountChangedListener", "()Lkotlin/jvm/functions/Function0;", "setOnItemCountChangedListener", "(Lkotlin/jvm/functions/Function0;)V", "firstRefresh", "refreshControls", "notifyItemChanged", "control", "setForceOffline", "setAutoRefreshHintClosedBefore", "closedBefore", "setHumHintClosedBefore", "markSkinHintClosedBefore", "markSmartHintClosedBefore", "notifySchedulesUpdate", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "handleModeAction", "mode", "Lcom/blueair/viewcore/utils/ModeIcon;", "onBindViewHolder", "holder", "position", "getItemViewType", "getItemCount", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceControlsAdapter.kt */
public final class DeviceControlsAdapter extends RecyclerView.Adapter<DeviceControlHolder<?>> {
    private boolean autoRefreshHintClosedBefore;
    private final Set<DeviceControl> closedControls = new LinkedHashSet();
    private List<? extends DeviceControl> controls = CollectionsKt.emptyList();
    private Device device;
    private boolean firstRefresh = true;
    private boolean forceOffline;
    private final DeviceControlGroup group;
    private boolean humHintClosedBefore;
    private final PublishSubject<AttributeAction<?>> onActionPublisher;
    private Function0<Unit> onItemCountChangedListener;
    private List<DeviceScheduleMerged> schedules = CollectionsKt.emptyList();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceControlsAdapter.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(70:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|(2:65|66)|67|69|70|71|72|73|74|75|76|77|78|(2:79|80)|81|83) */
        /* JADX WARNING: Can't wrap try/catch for region: R(71:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|(2:65|66)|67|69|70|71|72|73|74|75|76|77|78|(2:79|80)|81|83) */
        /* JADX WARNING: Can't wrap try/catch for region: R(72:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|(2:65|66)|67|69|70|71|72|73|74|75|76|77|78|(2:79|80)|81|83) */
        /* JADX WARNING: Can't wrap try/catch for region: R(73:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|(2:65|66)|67|69|70|71|72|73|74|75|76|77|78|(2:79|80)|81|83) */
        /* JADX WARNING: Can't wrap try/catch for region: R(74:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|(2:65|66)|67|69|70|71|72|73|74|75|76|77|78|(2:79|80)|81|83) */
        /* JADX WARNING: Can't wrap try/catch for region: R(75:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|69|70|71|72|73|74|75|76|77|78|(2:79|80)|81|83) */
        /* JADX WARNING: Can't wrap try/catch for region: R(77:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|69|70|71|72|73|74|75|76|77|78|79|80|81|83) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00d2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00dc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00e6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00fa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0104 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x010e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0129 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0131 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0139 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0141 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x0149 */
        static {
            /*
                com.blueair.devicedetails.util.DeviceControl[] r0 = com.blueair.devicedetails.util.DeviceControl.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.blueair.devicedetails.util.DeviceControl r2 = com.blueair.devicedetails.util.DeviceControl.OFFLINE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.blueair.devicedetails.util.DeviceControl r3 = com.blueair.devicedetails.util.DeviceControl.MAIN_MODES_DEHUM     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.blueair.devicedetails.util.DeviceControl r4 = com.blueair.devicedetails.util.DeviceControl.MODE_BUTTONS     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                com.blueair.devicedetails.util.DeviceControl r5 = com.blueair.devicedetails.util.DeviceControl.MSG_FILTER_DOOR_OPEN     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r5 = 5
                com.blueair.devicedetails.util.DeviceControl r6 = com.blueair.devicedetails.util.DeviceControl.MSG_FRONT_PANEL_OPEN     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                r6 = 6
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.MSG_TOP_PART_DISPLACED     // Catch:{ NoSuchFieldError -> 0x003d }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r0[r7] = r6     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.MSG_WATER_TANK_FULL     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r8 = 7
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.MSG_WATER_TANK_FAILURE     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r8 = 8
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.MSG_WATER_TANK_SHORTAGE     // Catch:{ NoSuchFieldError -> 0x005a }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r8 = 9
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.FAN_SPEED     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r8 = 10
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.AUTO_REFRESH     // Catch:{ NoSuchFieldError -> 0x006e }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r8 = 11
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.TARGET_HUM     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r8 = 12
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.SCHEDULE     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r8 = 13
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.BRIGHTNESS     // Catch:{ NoSuchFieldError -> 0x008c }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r8 = 14
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.FILTER     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r8 = 15
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.WICK     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r8 = 16
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.REFRESHER     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r8 = 17
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.SETTINGS     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r8 = 18
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.TIMER     // Catch:{ NoSuchFieldError -> 0x00be }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r8 = 19
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.MOOD_LAMP     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r8 = 20
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.NIGHT_LAMP     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r8 = 21
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.ALARMS     // Catch:{ NoSuchFieldError -> 0x00dc }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dc }
                r8 = 22
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00dc }
            L_0x00dc:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.WICK_DRYING     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r8 = 23
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.AUTO_DRY     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r8 = 24
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.MODE_HUMIDIFICATION     // Catch:{ NoSuchFieldError -> 0x00fa }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fa }
                r8 = 25
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00fa }
            L_0x00fa:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.SKIN_HINT     // Catch:{ NoSuchFieldError -> 0x0104 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0104 }
                r8 = 26
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0104 }
            L_0x0104:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.SMART_HINT     // Catch:{ NoSuchFieldError -> 0x010e }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x010e }
                r8 = 27
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x010e }
            L_0x010e:
                com.blueair.devicedetails.util.DeviceControl r7 = com.blueair.devicedetails.util.DeviceControl.GERM_SHIELD     // Catch:{ NoSuchFieldError -> 0x0118 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0118 }
                r8 = 28
                r0[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0118 }
            L_0x0118:
                $EnumSwitchMapping$0 = r0
                com.blueair.viewcore.utils.ModeIcon[] r0 = com.blueair.viewcore.utils.ModeIcon.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.viewcore.utils.ModeIcon r7 = com.blueair.viewcore.utils.ModeIcon.FAN_SPEED     // Catch:{ NoSuchFieldError -> 0x0129 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0129 }
                r0[r7] = r1     // Catch:{ NoSuchFieldError -> 0x0129 }
            L_0x0129:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.AUTO     // Catch:{ NoSuchFieldError -> 0x0131 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0131 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0131 }
            L_0x0131:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.WATERDROP_AUTO     // Catch:{ NoSuchFieldError -> 0x0139 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0139 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0139 }
            L_0x0139:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.NIGHT     // Catch:{ NoSuchFieldError -> 0x0141 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0141 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0141 }
            L_0x0141:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.DISINFECTION     // Catch:{ NoSuchFieldError -> 0x0149 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0149 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x0149 }
            L_0x0149:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.ECO     // Catch:{ NoSuchFieldError -> 0x0151 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0151 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x0151 }
            L_0x0151:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.adapter.DeviceControlsAdapter.WhenMappings.<clinit>():void");
        }
    }

    public DeviceControlsAdapter(DeviceControlGroup deviceControlGroup, PublishSubject<AttributeAction<?>> publishSubject) {
        Intrinsics.checkNotNullParameter(deviceControlGroup, "group");
        Intrinsics.checkNotNullParameter(publishSubject, "onActionPublisher");
        this.group = deviceControlGroup;
        this.onActionPublisher = publishSubject;
    }

    public final DeviceControlGroup getGroup() {
        return this.group;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final void setDevice(Device device2) {
        if (!Intrinsics.areEqual((Object) this.device, (Object) device2)) {
            this.device = device2;
            refreshControls();
            this.firstRefresh = false;
        }
    }

    public final List<DeviceScheduleMerged> getSchedules() {
        return this.schedules;
    }

    public final boolean getAutoRefreshHintClosedBefore() {
        return this.autoRefreshHintClosedBefore;
    }

    public final Function0<Unit> getOnItemCountChangedListener() {
        return this.onItemCountChangedListener;
    }

    public final void setOnItemCountChangedListener(Function0<Unit> function0) {
        this.onItemCountChangedListener = function0;
    }

    private final void refreshControls() {
        Function0<Unit> function0;
        int size = this.controls.size();
        Collection arrayList = new ArrayList();
        for (Object next : DeviceControl.Companion.getSupportedControls(this.device, this.group, this.forceOffline)) {
            if (!this.closedControls.contains((DeviceControl) next)) {
                arrayList.add(next);
            }
        }
        List<? extends DeviceControl> list = (List) arrayList;
        this.controls = list;
        notifyItemRangeChanged(0, list.size());
        if ((this.controls.size() != size || this.firstRefresh) && (function0 = this.onItemCountChangedListener) != null) {
            function0.invoke();
        }
    }

    public final void notifyItemChanged(DeviceControl deviceControl) {
        Intrinsics.checkNotNullParameter(deviceControl, "control");
        int indexOf = this.controls.indexOf(deviceControl);
        if (indexOf >= 0) {
            notifyItemChanged(indexOf);
        }
    }

    public final void setForceOffline(boolean z) {
        this.forceOffline = z;
        refreshControls();
    }

    public final void setAutoRefreshHintClosedBefore(boolean z) {
        this.autoRefreshHintClosedBefore = z;
        notifyItemChanged(DeviceControl.AUTO_REFRESH);
    }

    public final void setHumHintClosedBefore(boolean z) {
        this.humHintClosedBefore = z;
        notifyItemChanged(DeviceControl.MODE_HUMIDIFICATION);
    }

    public final void markSkinHintClosedBefore() {
        this.closedControls.add(DeviceControl.SKIN_HINT);
        refreshControls();
    }

    public final void markSmartHintClosedBefore() {
        this.closedControls.add(DeviceControl.SMART_HINT);
        refreshControls();
    }

    public final void notifySchedulesUpdate(List<DeviceScheduleMerged> list) {
        Intrinsics.checkNotNullParameter(list, "schedules");
        this.schedules = list;
        notifyItemChanged(DeviceControl.SCHEDULE);
    }

    public DeviceControlHolder<?> onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        DeviceControl deviceControl = (DeviceControl) DeviceControl.getEntries().get(i);
        FilterConfig filterConfig = null;
        switch (WhenMappings.$EnumSwitchMapping$0[deviceControl.ordinal()]) {
            case 1:
                return DeviceOfflineV2Holder.Companion.newInstance(viewGroup, new DeviceControlsAdapter$$ExternalSyntheticLambda0(this), new DeviceControlsAdapter$$ExternalSyntheticLambda2(this));
            case 2:
                return DeviceMainModeDehumHolder.Companion.newInstance(viewGroup, new DeviceControlsAdapter$$ExternalSyntheticLambda14(this));
            case 3:
                return DeviceModeButtonsV2Holder.Companion.newInstance(viewGroup, this.device, new DeviceControlsAdapter$$ExternalSyntheticLambda26(this));
            case 4:
                return DeviceMsgHolder.Companion.newInstance$default(DeviceMsgHolder.Companion, viewGroup, R.string.filter_door_open, R.string.filter_door_open_content, (Float) null, (Integer) null, new DeviceControlsAdapter$$ExternalSyntheticLambda28(this), 24, (Object) null);
            case 5:
                return DeviceMsgHolder.Companion.newInstance$default(DeviceMsgHolder.Companion, viewGroup, R.string.front_panel_open, R.string.front_panel_open_content, (Float) null, (Integer) null, new DeviceControlsAdapter$$ExternalSyntheticLambda29(this), 24, (Object) null);
            case 6:
                return DeviceMsgHolder.Companion.newInstance$default(DeviceMsgHolder.Companion, viewGroup, R.string.body_not_in_position, R.string.body_not_in_position_desc, (Float) null, (Integer) null, new DeviceControlsAdapter$$ExternalSyntheticLambda30(this), 24, (Object) null);
            case 7:
                return DeviceMsgHolder.Companion.newInstance$default(DeviceMsgHolder.Companion, viewGroup, R.string.msg_title_water_tank_full, R.string.msg_content_water_tank_full, (Float) null, (Integer) null, new DeviceControlsAdapter$$ExternalSyntheticLambda31(this), 24, (Object) null);
            case 8:
                return DeviceMsgHolder.Companion.newInstance$default(DeviceMsgHolder.Companion, viewGroup, R.string.msg_title_water_tank_failure, R.string.msg_content_water_tank_failure, (Float) null, (Integer) null, new DeviceControlsAdapter$$ExternalSyntheticLambda32(this), 24, (Object) null);
            case 9:
                return DeviceMsgHolder.Companion.newInstance(viewGroup, R.string.msg_title_water_tank_shortage, R.string.msg_content_water_tank_shortage, Float.valueOf(32.0f), Integer.valueOf(R.drawable.ic_water_shortage), new DeviceControlsAdapter$$ExternalSyntheticLambda34(this));
            case 10:
                return DeviceFanSpeedV2Holder.Companion.newInstance(viewGroup, this.device, false, new DeviceControlsAdapter$$ExternalSyntheticLambda11(this));
            case 11:
                return DeviceAutoRefreshHolder.Companion.newInstance(viewGroup, new DeviceControlsAdapter$$ExternalSyntheticLambda22(this), new DeviceControlsAdapter$$ExternalSyntheticLambda33(this), new DeviceControlsAdapter$$ExternalSyntheticLambda35(this));
            case 12:
                return DeviceTargetHumidityHolder.Companion.newInstance(viewGroup, this.device, false, new DeviceControlsAdapter$$ExternalSyntheticLambda36(this), new DeviceControlsAdapter$$ExternalSyntheticLambda37(this), new DeviceControlsAdapter$$ExternalSyntheticLambda38(this));
            case 13:
                return DeviceSchedulesHolder.Companion.newInstance(viewGroup, new DeviceControlsAdapter$$ExternalSyntheticLambda39(this), new DeviceControlsAdapter$$ExternalSyntheticLambda40(this));
            case 14:
                return DeviceBrightnessV2Holder.Companion.newInstance(viewGroup, false, new DeviceControlsAdapter$$ExternalSyntheticLambda1(this));
            case 15:
                DeviceFilterV2Holder.Companion companion = DeviceFilterV2Holder.Companion;
                Device device2 = this.device;
                DeviceFilterType deviceFilterType = DeviceFilterType.FILTER;
                DeviceConfigProvider deviceConfigProvider = DeviceConfigProvider.INSTANCE;
                Device device3 = this.device;
                if (device3 != null) {
                    filterConfig = DeviceConfigProvider.INSTANCE.getFilterConfig(device3, DeviceFilterType.FILTER);
                }
                return companion.newInstance(viewGroup, device2, deviceFilterType, deviceConfigProvider.hasBuyFilterLink(filterConfig), new DeviceControlsAdapter$$ExternalSyntheticLambda3(this), new DeviceControlsAdapter$$ExternalSyntheticLambda4(this));
            case 16:
                DeviceFilterV2Holder.Companion companion2 = DeviceFilterV2Holder.Companion;
                Device device4 = this.device;
                DeviceFilterType deviceFilterType2 = DeviceFilterType.WICK;
                DeviceConfigProvider deviceConfigProvider2 = DeviceConfigProvider.INSTANCE;
                Device device5 = this.device;
                if (device5 != null) {
                    filterConfig = DeviceConfigProvider.INSTANCE.getFilterConfig(device5, DeviceFilterType.WICK);
                }
                return companion2.newInstance(viewGroup, device4, deviceFilterType2, deviceConfigProvider2.hasBuyFilterLink(filterConfig), new DeviceControlsAdapter$$ExternalSyntheticLambda5(this), new DeviceControlsAdapter$$ExternalSyntheticLambda6(this));
            case 17:
                DeviceFilterV2Holder.Companion companion3 = DeviceFilterV2Holder.Companion;
                Device device6 = this.device;
                DeviceFilterType deviceFilterType3 = DeviceFilterType.REFRESHER;
                DeviceConfigProvider deviceConfigProvider3 = DeviceConfigProvider.INSTANCE;
                Device device7 = this.device;
                if (device7 != null) {
                    filterConfig = DeviceConfigProvider.INSTANCE.getFilterConfig(device7, DeviceFilterType.REFRESHER);
                }
                return companion3.newInstance(viewGroup, device6, deviceFilterType3, deviceConfigProvider3.hasBuyFilterLink(filterConfig), new DeviceControlsAdapter$$ExternalSyntheticLambda7(this), new DeviceControlsAdapter$$ExternalSyntheticLambda8(this));
            case 18:
                return DeviceSettingsHolder.Companion.newInstance(viewGroup, new DeviceControlsAdapter$$ExternalSyntheticLambda9(this));
            case 19:
                return DeviceTimerHolder.Companion.newInstance(viewGroup, new DeviceControlsAdapter$$ExternalSyntheticLambda10(this), new DeviceControlsAdapter$$ExternalSyntheticLambda12(this));
            case 20:
                return DeviceMoodLampHolder.Companion.newInstance(viewGroup, this.device, false, new DeviceControlsAdapter$$ExternalSyntheticLambda13(this));
            case 21:
                return DeviceNightLampHolder.Companion.newInstance(viewGroup, this.device, false, new DeviceControlsAdapter$$ExternalSyntheticLambda15(this));
            case 22:
                return DeviceAlarmsHolder.Companion.newInstance(viewGroup, new DeviceControlsAdapter$$ExternalSyntheticLambda16(this));
            case 23:
                return DeviceWickDryingHolder.Companion.newInstance(viewGroup, false, new DeviceControlsAdapter$$ExternalSyntheticLambda17(this), new DeviceControlsAdapter$$ExternalSyntheticLambda18(this));
            case 24:
                return DeviceAutoDryHolder.Companion.newInstance(viewGroup, new DeviceControlsAdapter$$ExternalSyntheticLambda19(this), new DeviceControlsAdapter$$ExternalSyntheticLambda20(this));
            case 25:
                return DeviceHumidificationHolder.Companion.newInstance$default(DeviceHumidificationHolder.Companion, viewGroup, false, new DeviceControlsAdapter$$ExternalSyntheticLambda21(this), new DeviceControlsAdapter$$ExternalSyntheticLambda23(this), 2, (Object) null);
            case 26:
                return DeviceHintHolder.Companion.newInstance(viewGroup, R.string.skin_mode_hint, Float.valueOf(8.0f), new DeviceControlsAdapter$$ExternalSyntheticLambda24(this));
            case 27:
                return DeviceHintHolder.Companion.newInstance(viewGroup, R.string.smart_mode_hint, Float.valueOf(16.0f), new DeviceControlsAdapter$$ExternalSyntheticLambda25(this));
            case 28:
                return DeviceGermShieldStatusV2Holder.Companion.newInstance(viewGroup, new DeviceControlsAdapter$$ExternalSyntheticLambda27());
            default:
                DeviceTestHolder newInstance = DeviceTestHolder.Companion.newInstance(viewGroup);
                TextView textView = ((HolderDeviceTestBinding) newInstance.getBinding()).title;
                textView.setText(deviceControl.name() + " - " + deviceControl.getGroup());
                return newInstance;
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$1(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.closedControls.add(DeviceControl.OFFLINE);
        deviceControlsAdapter.refreshControls();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$2(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.TroubleShootAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$3(DeviceControlsAdapter deviceControlsAdapter, MainMode mainMode) {
        Intrinsics.checkNotNullParameter(mainMode, "mainMode");
        deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.MainModeAction(mainMode));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$11(DeviceControlsAdapter deviceControlsAdapter, ModeIcon modeIcon) {
        Intrinsics.checkNotNullParameter(modeIcon, "mode");
        Device device2 = deviceControlsAdapter.device;
        if (device2 instanceof HasDehumidifierMainMode) {
            DehSubMode dehSubMode = modeIcon.toDehSubMode();
            if (dehSubMode != null) {
                deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.DehSubModeAction(dehSubMode));
                Enum enumR = dehSubMode;
            } else {
                ApSubMode apSubMode = modeIcon.toApSubMode();
                if (apSubMode != null) {
                    deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.ApSubModeAction(apSubMode));
                    Enum enumR2 = apSubMode;
                }
            }
        } else if ((device2 instanceof DeviceBlue40) || (device2 instanceof DeviceMiniRestful)) {
            ApSubMode apSubMode2 = modeIcon.toApSubMode();
            if (apSubMode2 != null) {
                deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.ApSubModeAction(apSubMode2));
            }
        } else if (device2 instanceof HasMode) {
            Mode mode = modeIcon.toMode();
            if (mode != null) {
                deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.ModeAction(mode));
            }
        } else if (device2 instanceof HasHumMainMode) {
            Intrinsics.checkNotNull(device2, "null cannot be cast to non-null type com.blueair.core.model.HasHumMainMode");
            if (((HasHumMainMode) device2).isInMainMode(MainMode.Humidification)) {
                HumSubMode humSubMode = modeIcon.toHumSubMode();
                if (humSubMode != null) {
                    deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.HumSubModeAction(humSubMode));
                }
            } else if (modeIcon == ModeIcon.SKIN) {
                deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.HumSubModeAction(HumSubMode.SKIN));
            } else {
                ApSubMode apSubMode3 = modeIcon.toApSubMode();
                if (apSubMode3 != null) {
                    deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.ApSubModeAction(apSubMode3));
                }
            }
        } else if (!(device2 instanceof DevicePet20)) {
            deviceControlsAdapter.handleModeAction(modeIcon);
        } else if (modeIcon == ModeIcon.SMART) {
            deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.MainModeAction(MainMode.SMART));
        } else {
            ApSubMode apSubMode4 = modeIcon.toApSubMode();
            if (apSubMode4 != null) {
                deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.ApSubModeAction(apSubMode4));
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$12(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.closedControls.add(DeviceControl.MSG_FILTER_DOOR_OPEN);
        deviceControlsAdapter.refreshControls();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$13(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.closedControls.add(DeviceControl.MSG_FRONT_PANEL_OPEN);
        deviceControlsAdapter.refreshControls();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$14(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.closedControls.add(DeviceControl.MSG_TOP_PART_DISPLACED);
        deviceControlsAdapter.refreshControls();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$15(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.closedControls.add(DeviceControl.MSG_WATER_TANK_FULL);
        deviceControlsAdapter.refreshControls();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$16(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.closedControls.add(DeviceControl.MSG_WATER_TANK_FAILURE);
        deviceControlsAdapter.refreshControls();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$17(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.closedControls.add(DeviceControl.MSG_WATER_TANK_SHORTAGE);
        deviceControlsAdapter.refreshControls();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$18(DeviceControlsAdapter deviceControlsAdapter, FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "fanSpeed");
        deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.FanSpeedAction(fanSpeedEnum));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$19(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.AutoRefreshInfoAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$20(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.AutoRefreshCancelAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$21(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.AutoRefreshHintClosedAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$22(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.AutoRhInfoAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$23(DeviceControlsAdapter deviceControlsAdapter, boolean z) {
        deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.AutoRhShowHintAction(z));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$24(DeviceControlsAdapter deviceControlsAdapter, int i) {
        deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.AutoRhAction(i));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$25(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.ChildLockAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$26(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.OpenDeviceSchedulesAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$27(DeviceControlsAdapter deviceControlsAdapter, int i) {
        deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.BrightnessPercentageAction(i));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$30(DeviceControlsAdapter deviceControlsAdapter, boolean z) {
        deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.OpenFilterPageAction(z));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$29(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.OpenFilterInfoAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$32(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.OpenWickInfoAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$33(DeviceControlsAdapter deviceControlsAdapter, boolean z) {
        deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.OpenWickPageAction(z));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$35(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.OpenCubeInfoAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$36(DeviceControlsAdapter deviceControlsAdapter, boolean z) {
        deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.OpenCubePageAction(z));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$37(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.OpenDeviceSettingsAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$38(DeviceControlsAdapter deviceControlsAdapter, TimerState timerState) {
        Intrinsics.checkNotNullParameter(timerState, "it");
        deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.TimerStateAction(timerState));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$39(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.SelectTimerDurationAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$40(DeviceControlsAdapter deviceControlsAdapter, MoodLampEnum moodLampEnum) {
        Intrinsics.checkNotNullParameter(moodLampEnum, "it");
        deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.MoodLampAction(moodLampEnum));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$41(DeviceControlsAdapter deviceControlsAdapter, int i) {
        deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.NightLampAction(i));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$42(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.OpenDeviceAlarmsAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$43(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.WickDryingInfoAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$44(DeviceControlsAdapter deviceControlsAdapter, WickDryingGear wickDryingGear) {
        Intrinsics.checkNotNullParameter(wickDryingGear, "it");
        deviceControlsAdapter.onActionPublisher.onNext(new AttributeAction.WickDryingAction(wickDryingGear));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$45(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.OpenDryModeInfoAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$46(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.DryModeCancelAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$47(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.HumModeAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$48(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.CloseHumHintAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$49(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.CloseSkinHintAction.INSTANCE);
        deviceControlsAdapter.markSkinHintClosedBefore();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$50(DeviceControlsAdapter deviceControlsAdapter) {
        deviceControlsAdapter.onActionPublisher.onNext(AttributeAction.CloseSmartHintAction.INSTANCE);
        deviceControlsAdapter.markSmartHintClosedBefore();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$51() {
        return Unit.INSTANCE;
    }

    private final void handleModeAction(ModeIcon modeIcon) {
        Device device2 = this.device;
        if (device2 != null) {
            switch (WhenMappings.$EnumSwitchMapping$1[modeIcon.ordinal()]) {
                case 1:
                    this.onActionPublisher.onNext(AttributeAction.ManualModeAction.INSTANCE);
                    return;
                case 2:
                case 3:
                    if (!(device2 instanceof HasStandBy) || !(device2 instanceof HasFanSpeed)) {
                        HasFanSpeed hasFanSpeed = (HasFanSpeed) device2;
                        if (hasFanSpeed.getAutoMode() == AutoMode.ON) {
                            this.onActionPublisher.onNext(new AttributeAction.AutoModeAction(false));
                            return;
                        } else if (hasFanSpeed.getAutoMode() == AutoMode.OFF) {
                            this.onActionPublisher.onNext(new AttributeAction.AutoModeAction(true));
                            return;
                        } else {
                            return;
                        }
                    } else if (!((HasStandBy) device2).isStandByOn()) {
                        HasFanSpeed hasFanSpeed2 = (HasFanSpeed) device2;
                        if (hasFanSpeed2.getAutoMode() == AutoMode.ON) {
                            this.onActionPublisher.onNext(new AttributeAction.AutoModeAction(DeviceKt.isDisinfectionOn(device2)));
                            return;
                        } else if (hasFanSpeed2.getAutoMode() == AutoMode.OFF) {
                            this.onActionPublisher.onNext(new AttributeAction.AutoModeAction(true));
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case 4:
                    if (!(device2 instanceof HasStandBy)) {
                        this.onActionPublisher.onNext(AttributeAction.NightModeAction.INSTANCE);
                        return;
                    } else if (!((HasStandBy) device2).isStandByOn()) {
                        this.onActionPublisher.onNext(AttributeAction.NightModeAction.INSTANCE);
                        return;
                    } else {
                        return;
                    }
                case 5:
                    this.onActionPublisher.onNext(AttributeAction.DisinfectionModeAction.INSTANCE);
                    return;
                case 6:
                    this.onActionPublisher.onNext(AttributeAction.EcoModeAction.INSTANCE);
                    return;
                default:
                    return;
            }
        }
    }

    public void onBindViewHolder(DeviceControlHolder<?> deviceControlHolder, int i) {
        Intrinsics.checkNotNullParameter(deviceControlHolder, "holder");
        Device device2 = this.device;
        if (device2 == null) {
            return;
        }
        if (deviceControlHolder instanceof DeviceSchedulesHolder) {
            ((DeviceSchedulesHolder) deviceControlHolder).update(device2, this.forceOffline, this.schedules);
        } else if (deviceControlHolder instanceof DeviceAutoRefreshHolder) {
            ((DeviceAutoRefreshHolder) deviceControlHolder).update(device2, this.forceOffline, this.autoRefreshHintClosedBefore);
        } else if (deviceControlHolder instanceof DeviceHumidificationHolder) {
            ((DeviceHumidificationHolder) deviceControlHolder).update(device2, this.forceOffline, this.humHintClosedBefore);
        } else {
            deviceControlHolder.update(device2, this.forceOffline);
        }
    }

    public int getItemViewType(int i) {
        return ((DeviceControl) this.controls.get(i)).ordinal();
    }

    public int getItemCount() {
        return this.controls.size();
    }
}
