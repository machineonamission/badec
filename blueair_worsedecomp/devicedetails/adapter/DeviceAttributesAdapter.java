package com.blueair.devicedetails.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.Brightness;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.model.SmartSubMode;
import com.blueair.core.model.TimerState;
import com.blueair.devicedetails.util.AttributeAction;
import com.blueair.devicedetails.util.DeviceAttribute;
import com.blueair.devicedetails.viewholder.DeviceAttributeHolder;
import com.blueair.devicedetails.viewholder.DeviceAutoModeHolder;
import com.blueair.devicedetails.viewholder.DeviceBrightnessHolder;
import com.blueair.devicedetails.viewholder.DeviceC3FanSpeedHolder;
import com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder;
import com.blueair.devicedetails.viewholder.DeviceDetectCatHolder;
import com.blueair.devicedetails.viewholder.DeviceDisinfectionStatusHolder;
import com.blueair.devicedetails.viewholder.DeviceEtaHolder;
import com.blueair.devicedetails.viewholder.DeviceFanPresetHolder;
import com.blueair.devicedetails.viewholder.DeviceFilterOrWickStatusHolder;
import com.blueair.devicedetails.viewholder.DeviceFilterStatusHolder;
import com.blueair.devicedetails.viewholder.DeviceGermShieldNightModeHolder;
import com.blueair.devicedetails.viewholder.DeviceGermShieldStatusHolder;
import com.blueair.devicedetails.viewholder.DeviceHAuthRhHolder;
import com.blueair.devicedetails.viewholder.DeviceHDryModeHolder;
import com.blueair.devicedetails.viewholder.DeviceHTimerHolder;
import com.blueair.devicedetails.viewholder.DeviceMainModeButtonsHolder;
import com.blueair.devicedetails.viewholder.DeviceManualModeHolder;
import com.blueair.devicedetails.viewholder.DeviceModeButtonsHolder;
import com.blueair.devicedetails.viewholder.DeviceNBrightnessHolder;
import com.blueair.devicedetails.viewholder.DeviceNChildLockHolder;
import com.blueair.devicedetails.viewholder.DeviceNCleanAirEtaHolder;
import com.blueair.devicedetails.viewholder.DeviceNFanSpeedHolder;
import com.blueair.devicedetails.viewholder.DeviceNFilterStatusHolder;
import com.blueair.devicedetails.viewholder.DeviceNHinsHolder;
import com.blueair.devicedetails.viewholder.DeviceNModeButtonsHolder;
import com.blueair.devicedetails.viewholder.DeviceOTAHolder;
import com.blueair.devicedetails.viewholder.DeviceOfflineHolder;
import com.blueair.devicedetails.viewholder.DeviceOscillationHolder;
import com.blueair.devicedetails.viewholder.DeviceSeparatorHolder;
import com.blueair.devicedetails.viewholder.DeviceStandbyModeHolder;
import com.blueair.devicedetails.viewholder.DeviceSubAutoHolder;
import com.blueair.devicedetails.viewholder.DeviceTargetTemperatureHolder;
import com.blueair.devicedetails.viewholder.DeviceTimezoneHintHolder;
import com.blueair.devicedetails.viewholder.DeviceWeightHolder;
import com.blueair.viewcore.utils.ModeIcon;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001dH\u0016J\u0018\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(H\u0002J\u0006\u0010)\u001a\u00020\u000eJ\u0006\u0010*\u001a\u00020\u000eJ\u0006\u0010+\u001a\u00020\u000eJ\u0006\u0010,\u001a\u00020\u000eR\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0016@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006-"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceAttributesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "onActionPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/devicedetails/util/AttributeAction;", "<init>", "(Lio/reactivex/subjects/PublishSubject;)V", "attributes", "", "Lcom/blueair/devicedetails/util/DeviceAttribute;", "forceOffline", "", "setForceOffline", "", "value", "Lcom/blueair/core/model/IndoorDatapoint;", "latestDatapoint", "getLatestDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "setLatestDatapoint", "(Lcom/blueair/core/model/IndoorDatapoint;)V", "Lcom/blueair/core/model/Device;", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "getItemCount", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "handleModeAction", "mode", "Lcom/blueair/viewcore/utils/ModeIcon;", "notifyDisinfectLeftTimeChanged", "notifyTimerLeftTimeChanged", "notifyWickDryLeftTimeChanged", "notifySubAutoChanged", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAttributesAdapter.kt */
public final class DeviceAttributesAdapter extends RecyclerView.Adapter<DeviceAttributeHolder> {
    private List<? extends DeviceAttribute> attributes = CollectionsKt.emptyList();
    private Device device;
    private boolean forceOffline;
    private IndoorDatapoint latestDatapoint;
    private final PublishSubject<AttributeAction<?>> onActionPublisher;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAttributesAdapter.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(85:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|(2:79|80)|81|83|84|85|86|87|88|89|90|91|92|93|94|95|96|(2:97|98)|99|101) */
        /* JADX WARNING: Can't wrap try/catch for region: R(86:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|(2:79|80)|81|83|84|85|86|87|88|89|90|91|92|93|94|95|96|(2:97|98)|99|101) */
        /* JADX WARNING: Can't wrap try/catch for region: R(87:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|(2:79|80)|81|83|84|85|86|87|88|89|90|91|92|93|94|95|96|(2:97|98)|99|101) */
        /* JADX WARNING: Can't wrap try/catch for region: R(88:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|(2:79|80)|81|83|84|85|86|87|88|89|90|91|92|93|94|95|96|(2:97|98)|99|101) */
        /* JADX WARNING: Can't wrap try/catch for region: R(89:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|(2:79|80)|81|83|84|85|86|87|88|89|90|91|92|93|94|95|96|(2:97|98)|99|101) */
        /* JADX WARNING: Can't wrap try/catch for region: R(90:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|(2:79|80)|81|83|84|85|86|87|88|89|90|91|92|93|94|95|96|(2:97|98)|99|101) */
        /* JADX WARNING: Can't wrap try/catch for region: R(92:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|(2:79|80)|81|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|101) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00d2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00dc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00e6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00fa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0104 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x010e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0118 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0122 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0136 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x0140 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x015b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x0163 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x016b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x0173 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x017b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x0183 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:97:0x018b */
        static {
            /*
                com.blueair.devicedetails.util.DeviceAttribute[] r0 = com.blueair.devicedetails.util.DeviceAttribute.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.blueair.devicedetails.util.DeviceAttribute r2 = com.blueair.devicedetails.util.DeviceAttribute.GERMSHIELD_STATUS     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.blueair.devicedetails.util.DeviceAttribute r3 = com.blueair.devicedetails.util.DeviceAttribute.STANDBY_MODE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.blueair.devicedetails.util.DeviceAttribute r4 = com.blueair.devicedetails.util.DeviceAttribute.DISINFECTION_STATUS     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                com.blueair.devicedetails.util.DeviceAttribute r5 = com.blueair.devicedetails.util.DeviceAttribute.MANUAL_MODE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r5 = 5
                com.blueair.devicedetails.util.DeviceAttribute r6 = com.blueair.devicedetails.util.DeviceAttribute.AUTO_MODE     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                r6 = 6
                com.blueair.devicedetails.util.DeviceAttribute r7 = com.blueair.devicedetails.util.DeviceAttribute.FILTER_STATUS     // Catch:{ NoSuchFieldError -> 0x003d }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r0[r7] = r6     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                r7 = 7
                com.blueair.devicedetails.util.DeviceAttribute r8 = com.blueair.devicedetails.util.DeviceAttribute.MODE_BUTTONS     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r0[r8] = r7     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                r8 = 8
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.GERMSHIELD_NM     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r0[r9] = r8     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.BRIGHTNESS     // Catch:{ NoSuchFieldError -> 0x005a }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r10 = 9
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.CLEAN_AIR_ETA     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r10 = 10
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.OFFLINE     // Catch:{ NoSuchFieldError -> 0x006e }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r10 = 11
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.N_OFFLINE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r10 = 12
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.OTA     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r10 = 13
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.TIMEZONE     // Catch:{ NoSuchFieldError -> 0x008c }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r10 = 14
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.SEPARATOR     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r10 = 15
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.N_HINS     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r10 = 16
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.N_ON_OFF     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r10 = 17
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.N_MODE_BUTTONS     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r10 = 18
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.N_FAN_SPEED     // Catch:{ NoSuchFieldError -> 0x00be }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r10 = 19
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.N_BRIGHTNESS     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r10 = 20
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.SUB_AUTO     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r10 = 21
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.TARGET_TEMPERATURE     // Catch:{ NoSuchFieldError -> 0x00dc }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dc }
                r10 = 22
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x00dc }
            L_0x00dc:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.N_FILTER_STATUS     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r10 = 23
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.N_CHILD_LOCK     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r10 = 24
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.AUTO_RH     // Catch:{ NoSuchFieldError -> 0x00fa }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fa }
                r10 = 25
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x00fa }
            L_0x00fa:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.WICK_STATUS     // Catch:{ NoSuchFieldError -> 0x0104 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0104 }
                r10 = 26
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x0104 }
            L_0x0104:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.TIMER     // Catch:{ NoSuchFieldError -> 0x010e }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x010e }
                r10 = 27
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x010e }
            L_0x010e:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.DRY_MODE     // Catch:{ NoSuchFieldError -> 0x0118 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0118 }
                r10 = 28
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x0118 }
            L_0x0118:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.OSCILLATION     // Catch:{ NoSuchFieldError -> 0x0122 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0122 }
                r10 = 29
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x0122 }
            L_0x0122:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.FAN_PRESET     // Catch:{ NoSuchFieldError -> 0x012c }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r10 = 30
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.HUM_ON_OFF     // Catch:{ NoSuchFieldError -> 0x0136 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0136 }
                r10 = 31
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x0136 }
            L_0x0136:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.WEIGHT     // Catch:{ NoSuchFieldError -> 0x0140 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0140 }
                r10 = 32
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x0140 }
            L_0x0140:
                com.blueair.devicedetails.util.DeviceAttribute r9 = com.blueair.devicedetails.util.DeviceAttribute.DETECT_CAT     // Catch:{ NoSuchFieldError -> 0x014a }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x014a }
                r10 = 33
                r0[r9] = r10     // Catch:{ NoSuchFieldError -> 0x014a }
            L_0x014a:
                $EnumSwitchMapping$0 = r0
                com.blueair.viewcore.utils.ModeIcon[] r0 = com.blueair.viewcore.utils.ModeIcon.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.viewcore.utils.ModeIcon r9 = com.blueair.viewcore.utils.ModeIcon.STANDBY     // Catch:{ NoSuchFieldError -> 0x015b }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x015b }
                r0[r9] = r1     // Catch:{ NoSuchFieldError -> 0x015b }
            L_0x015b:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.FAN_SPEED     // Catch:{ NoSuchFieldError -> 0x0163 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0163 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0163 }
            L_0x0163:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.AUTO     // Catch:{ NoSuchFieldError -> 0x016b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x016b }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x016b }
            L_0x016b:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.WATERDROP_AUTO     // Catch:{ NoSuchFieldError -> 0x0173 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0173 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0173 }
            L_0x0173:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.NIGHT     // Catch:{ NoSuchFieldError -> 0x017b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x017b }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x017b }
            L_0x017b:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.CHILD_LOCK     // Catch:{ NoSuchFieldError -> 0x0183 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0183 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x0183 }
            L_0x0183:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.DISINFECTION     // Catch:{ NoSuchFieldError -> 0x018b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x018b }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x018b }
            L_0x018b:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.ECO     // Catch:{ NoSuchFieldError -> 0x0193 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0193 }
                r0[r1] = r8     // Catch:{ NoSuchFieldError -> 0x0193 }
            L_0x0193:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.adapter.DeviceAttributesAdapter.WhenMappings.<clinit>():void");
        }
    }

    public DeviceAttributesAdapter(PublishSubject<AttributeAction<?>> publishSubject) {
        Intrinsics.checkNotNullParameter(publishSubject, "onActionPublisher");
        this.onActionPublisher = publishSubject;
    }

    public final void setForceOffline(boolean z) {
        this.forceOffline = z;
        this.attributes = DeviceAttribute.Companion.getSupportedAttributes(this.device, z);
        notifyDataSetChanged();
    }

    public final IndoorDatapoint getLatestDatapoint() {
        return this.latestDatapoint;
    }

    public final void setLatestDatapoint(IndoorDatapoint indoorDatapoint) {
        int indexOf;
        IndoorDatapoint indoorDatapoint2 = this.latestDatapoint;
        if (!Intrinsics.areEqual((Object) indoorDatapoint, (Object) indoorDatapoint2)) {
            this.latestDatapoint = indoorDatapoint;
            Float f = null;
            if (!Intrinsics.areEqual(indoorDatapoint != null ? indoorDatapoint.getPm25() : null, indoorDatapoint2 != null ? indoorDatapoint2.getPm25() : null)) {
                int indexOf2 = this.attributes.indexOf(DeviceAttribute.N_FAN_SPEED);
                if (indexOf2 < 0) {
                    indexOf2 = this.attributes.indexOf(DeviceAttribute.CLEAN_AIR_ETA);
                }
                if (indexOf2 < 0) {
                    indexOf2 = this.attributes.indexOf(DeviceAttribute.N_CLEAN_AIR_ETA);
                }
                if (indexOf2 >= 0) {
                    notifyItemChanged(indexOf2);
                }
            }
            IndoorDatapoint indoorDatapoint3 = this.latestDatapoint;
            Float weight = indoorDatapoint3 != null ? indoorDatapoint3.getWeight() : null;
            if (indoorDatapoint2 != null) {
                f = indoorDatapoint2.getWeight();
            }
            if (!Intrinsics.areEqual(weight, f) && (indexOf = this.attributes.indexOf(DeviceAttribute.WEIGHT)) >= 0) {
                notifyItemChanged(indexOf);
            }
        }
    }

    public final Device getDevice() {
        return this.device;
    }

    public final void setDevice(Device device2) {
        if (!Intrinsics.areEqual((Object) this.device, (Object) device2)) {
            this.device = device2;
            this.attributes = DeviceAttribute.Companion.getSupportedAttributes(device2, this.forceOffline);
            notifyDataSetChanged();
        }
    }

    public int getItemCount() {
        if (this.device != null) {
            return this.attributes.size();
        }
        return 0;
    }

    public int getItemViewType(int i) {
        return ((DeviceAttribute) this.attributes.get(i)).ordinal();
    }

    public DeviceAttributeHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        DeviceAttribute deviceAttribute = DeviceAttribute.Companion.getATTRIBUTES()[i];
        switch (WhenMappings.$EnumSwitchMapping$0[deviceAttribute.ordinal()]) {
            case 1:
                return DeviceGermShieldStatusHolder.Companion.newInstance(viewGroup, new DeviceAttributesAdapter$$ExternalSyntheticLambda0(this));
            case 2:
                return DeviceStandbyModeHolder.Companion.newInstance(viewGroup);
            case 3:
                return DeviceDisinfectionStatusHolder.Companion.newInstance(viewGroup, new DeviceAttributesAdapter$$ExternalSyntheticLambda2(this));
            case 4:
                return DeviceManualModeHolder.Companion.newInstance(viewGroup, new DeviceAttributesAdapter$$ExternalSyntheticLambda14(this));
            case 5:
                return DeviceAutoModeHolder.Companion.newInstance(viewGroup);
            case 6:
                return DeviceFilterStatusHolder.Companion.newInstance(viewGroup, new DeviceAttributesAdapter$$ExternalSyntheticLambda25(this));
            case 7:
                return DeviceModeButtonsHolder.Companion.newInstance(viewGroup, new DeviceAttributesAdapter$$ExternalSyntheticLambda26(this));
            case 8:
                return DeviceGermShieldNightModeHolder.Companion.newInstance(viewGroup, new DeviceAttributesAdapter$$ExternalSyntheticLambda27(this));
            case 9:
                return DeviceBrightnessHolder.Companion.newInstance(viewGroup, new DeviceAttributesAdapter$$ExternalSyntheticLambda28(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda29(this));
            case 10:
                return DeviceEtaHolder.Companion.newInstance(viewGroup);
            case 11:
            case 12:
                return DeviceOfflineHolder.Companion.newInstance(viewGroup, this.device, new DeviceAttributesAdapter$$ExternalSyntheticLambda30(this));
            case 13:
                return DeviceOTAHolder.Companion.newInstance(viewGroup);
            case 14:
                return DeviceTimezoneHintHolder.Companion.newInstance(viewGroup, new DeviceAttributesAdapter$$ExternalSyntheticLambda31(this));
            case 15:
                return DeviceSeparatorHolder.Companion.newInstance(viewGroup);
            case 16:
                return DeviceNHinsHolder.Companion.newInstance(viewGroup, new DeviceAttributesAdapter$$ExternalSyntheticLambda11(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda22(this));
            case 17:
                return DeviceCOnOffButtonHolder.Companion.newInstance$default(DeviceCOnOffButtonHolder.Companion, viewGroup, this.device, DeviceCOnOffButtonHolder.Type.STANDBY, false, new DeviceAttributesAdapter$$ExternalSyntheticLambda32(this), 8, (Object) null);
            case 18:
                if (this.device instanceof HasCombo3in1MainMode) {
                    return DeviceMainModeButtonsHolder.Companion.newInstance(viewGroup, this.device, new DeviceAttributesAdapter$$ExternalSyntheticLambda33(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda34(this));
                }
                return DeviceNModeButtonsHolder.Companion.newInstance(viewGroup, this.device, false, new DeviceAttributesAdapter$$ExternalSyntheticLambda35(this));
            case 19:
                return DeviceNFanSpeedHolder.Companion.newInstance(viewGroup, this.device, false, new DeviceAttributesAdapter$$ExternalSyntheticLambda36(this));
            case 20:
                return DeviceNBrightnessHolder.Companion.newInstance(viewGroup, this.device, false, new DeviceAttributesAdapter$$ExternalSyntheticLambda37(this));
            case 21:
                return DeviceSubAutoHolder.Companion.newInstance(viewGroup, this.device, false, new DeviceAttributesAdapter$$ExternalSyntheticLambda38(this));
            case 22:
                return DeviceTargetTemperatureHolder.Companion.newInstance$default(DeviceTargetTemperatureHolder.Companion, viewGroup, this.device, false, new DeviceAttributesAdapter$$ExternalSyntheticLambda1(this), 4, (Object) null);
            case 23:
                if (this.device instanceof DeviceNewClassic) {
                    return DeviceNFilterStatusHolder.Companion.newInstance(viewGroup, new DeviceAttributesAdapter$$ExternalSyntheticLambda3(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda4(this));
                }
                return DeviceFilterOrWickStatusHolder.Companion.newInstance(viewGroup, DeviceFilterType.FILTER, new DeviceAttributesAdapter$$ExternalSyntheticLambda5(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda6(this));
            case 24:
                return DeviceNChildLockHolder.Companion.newInstance(viewGroup, this.device, new DeviceAttributesAdapter$$ExternalSyntheticLambda7(this));
            case 25:
                return DeviceHAuthRhHolder.Companion.newInstance(viewGroup, false, new DeviceAttributesAdapter$$ExternalSyntheticLambda8(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda9(this));
            case 26:
                return DeviceFilterOrWickStatusHolder.Companion.newInstance(viewGroup, DeviceFilterType.WICK, new DeviceAttributesAdapter$$ExternalSyntheticLambda10(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda12(this));
            case 27:
                return DeviceHTimerHolder.Companion.newInstance(viewGroup, this.device, new DeviceAttributesAdapter$$ExternalSyntheticLambda13(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda15(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda16(this));
            case 28:
                return DeviceHDryModeHolder.Companion.newInstance(viewGroup, this.device, new DeviceAttributesAdapter$$ExternalSyntheticLambda17(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda18(this));
            case 29:
                return DeviceOscillationHolder.Companion.newInstance(viewGroup, false, new DeviceAttributesAdapter$$ExternalSyntheticLambda19(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda20(this));
            case 30:
                return DeviceFanPresetHolder.Companion.newInstance(viewGroup, this.device, new DeviceAttributesAdapter$$ExternalSyntheticLambda21(this));
            case 31:
                return DeviceCOnOffButtonHolder.Companion.newInstance$default(DeviceCOnOffButtonHolder.Companion, viewGroup, this.device, DeviceCOnOffButtonHolder.Type.HUM, false, new DeviceAttributesAdapter$$ExternalSyntheticLambda23(this), 8, (Object) null);
            case 32:
                return DeviceWeightHolder.Companion.newInstance(viewGroup, this.device, new DeviceAttributesAdapter$$ExternalSyntheticLambda24(this));
            case 33:
                return DeviceDetectCatHolder.Companion.newInstance(viewGroup, this.device);
            default:
                DeviceNCleanAirEtaHolder newInstance = DeviceNCleanAirEtaHolder.Companion.newInstance(viewGroup);
                newInstance.getBinding().cleanAirEta.setText(deviceAttribute.name());
                newInstance.getBinding().cleanAirEta.setTag(deviceAttribute == DeviceAttribute.N_CLEAN_AIR_ETA ? null : "dev_holder");
                return newInstance;
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$0(DeviceAttributesAdapter deviceAttributesAdapter) {
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.OpenGermShieldInfoAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$1(DeviceAttributesAdapter deviceAttributesAdapter) {
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.OpenDisinfectionInfoAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$2(DeviceAttributesAdapter deviceAttributesAdapter, FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "it");
        deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.FanSpeedAction(fanSpeedEnum));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$3(DeviceAttributesAdapter deviceAttributesAdapter, boolean z) {
        deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.OpenFilterPageAction(z));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$4(DeviceAttributesAdapter deviceAttributesAdapter, ModeIcon modeIcon) {
        Intrinsics.checkNotNullParameter(modeIcon, "mode");
        deviceAttributesAdapter.handleModeAction(modeIcon);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$5(DeviceAttributesAdapter deviceAttributesAdapter) {
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.GsnmSwitchAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$6(DeviceAttributesAdapter deviceAttributesAdapter, Brightness brightness) {
        Intrinsics.checkNotNullParameter(brightness, "it");
        deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.BrightnessAction(brightness));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$7(DeviceAttributesAdapter deviceAttributesAdapter, int i) {
        deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.BrightnessPercentageAction(i));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$8(DeviceAttributesAdapter deviceAttributesAdapter) {
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.TroubleShootAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$9(DeviceAttributesAdapter deviceAttributesAdapter) {
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.TimeZoneAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$10(DeviceAttributesAdapter deviceAttributesAdapter, boolean z) {
        deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.OpenHinsInfoAction(z));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$11(DeviceAttributesAdapter deviceAttributesAdapter, boolean z) {
        deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.HinsLockAction(z));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$12(DeviceAttributesAdapter deviceAttributesAdapter, DeviceCOnOffButtonHolder.Type type, boolean z) {
        Intrinsics.checkNotNullParameter(type, "<unused var>");
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.StandbyModeAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$13(DeviceAttributesAdapter deviceAttributesAdapter, MainMode mainMode) {
        Intrinsics.checkNotNullParameter(mainMode, "mainMode");
        deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.MainModeAction(mainMode));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$14(DeviceAttributesAdapter deviceAttributesAdapter, ApSubMode apSubMode) {
        Intrinsics.checkNotNullParameter(apSubMode, "subMode");
        deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.ApSubModeAction(apSubMode));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$17(DeviceAttributesAdapter deviceAttributesAdapter, ModeIcon modeIcon) {
        Intrinsics.checkNotNullParameter(modeIcon, "mode");
        Device device2 = deviceAttributesAdapter.device;
        if (device2 instanceof DevicePet20) {
            if (modeIcon == ModeIcon.SMART) {
                deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.MainModeAction(MainMode.SMART));
            } else {
                ApSubMode apSubMode = modeIcon.toApSubMode();
                if (apSubMode != null) {
                    deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.ApSubModeAction(apSubMode));
                }
            }
        } else if (device2 instanceof HasMode) {
            Mode mode = modeIcon.toMode();
            if (mode != null) {
                deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.ModeAction(mode));
            }
        } else {
            deviceAttributesAdapter.handleModeAction(modeIcon);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$18(DeviceAttributesAdapter deviceAttributesAdapter, FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "it");
        deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.FanSpeedAction(fanSpeedEnum));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$19(DeviceAttributesAdapter deviceAttributesAdapter, int i) {
        deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.BrightnessPercentageAction(i));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$20(DeviceAttributesAdapter deviceAttributesAdapter, boolean z) {
        deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.SmartSubModeAction(z ? SmartSubMode.AUTO_ON : SmartSubMode.AUTO_OFF));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$21(DeviceAttributesAdapter deviceAttributesAdapter, double d) {
        deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.TargetTemperatureAction(d));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$22(DeviceAttributesAdapter deviceAttributesAdapter) {
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.OpenFilterInfoAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$23(DeviceAttributesAdapter deviceAttributesAdapter, boolean z) {
        deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.OpenFilterPageAction(z));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$24(DeviceAttributesAdapter deviceAttributesAdapter) {
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.OpenFilterInfoAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$25(DeviceAttributesAdapter deviceAttributesAdapter, boolean z) {
        deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.OpenFilterPageAction(z));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$26(DeviceAttributesAdapter deviceAttributesAdapter, boolean z) {
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.ChildLockAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$27(DeviceAttributesAdapter deviceAttributesAdapter) {
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.AutoRhInfoAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$28(DeviceAttributesAdapter deviceAttributesAdapter, int i) {
        deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.AutoRhAction(i));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$29(DeviceAttributesAdapter deviceAttributesAdapter) {
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.OpenWickInfoAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$30(DeviceAttributesAdapter deviceAttributesAdapter, boolean z) {
        deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.OpenWickPageAction(z));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$31(DeviceAttributesAdapter deviceAttributesAdapter) {
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.OpenTimerInfoAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$32(DeviceAttributesAdapter deviceAttributesAdapter, TimerState timerState) {
        Intrinsics.checkNotNullParameter(timerState, "it");
        deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.TimerStateAction(timerState));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$33(DeviceAttributesAdapter deviceAttributesAdapter, int i) {
        deviceAttributesAdapter.onActionPublisher.onNext(new AttributeAction.TimerDurationAction(i));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$34(DeviceAttributesAdapter deviceAttributesAdapter) {
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.OpenDryModeInfoAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$35(DeviceAttributesAdapter deviceAttributesAdapter) {
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.DryModeCancelAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$36(DeviceAttributesAdapter deviceAttributesAdapter, boolean z) {
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.OscillationEnableAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$37(DeviceAttributesAdapter deviceAttributesAdapter) {
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.OscillationSettingAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$38(DeviceAttributesAdapter deviceAttributesAdapter) {
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.OpenFanPresetPageAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$39(DeviceAttributesAdapter deviceAttributesAdapter, DeviceCOnOffButtonHolder.Type type, boolean z) {
        Intrinsics.checkNotNullParameter(type, "<unused var>");
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.HumModeAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$40(DeviceAttributesAdapter deviceAttributesAdapter) {
        deviceAttributesAdapter.onActionPublisher.onNext(AttributeAction.PeelingAction.INSTANCE);
        return Unit.INSTANCE;
    }

    public void onBindViewHolder(DeviceAttributeHolder deviceAttributeHolder, int i) {
        Device device2;
        Intrinsics.checkNotNullParameter(deviceAttributeHolder, "holder");
        Device device3 = this.device;
        if (device3 != null) {
            deviceAttributeHolder.update(device3);
        }
        if (deviceAttributeHolder instanceof DeviceNFilterStatusHolder) {
            if (this.forceOffline) {
                ((DeviceNFilterStatusHolder) deviceAttributeHolder).setOffline();
            }
        } else if (deviceAttributeHolder instanceof DeviceFilterOrWickStatusHolder) {
            if (this.forceOffline) {
                ((DeviceFilterOrWickStatusHolder) deviceAttributeHolder).setOffline();
            }
        } else if (deviceAttributeHolder instanceof DeviceEtaHolder) {
            Device device4 = this.device;
            if (device4 != null) {
                IndoorDatapoint indoorDatapoint = this.latestDatapoint;
                if (indoorDatapoint == null) {
                    indoorDatapoint = device4 instanceof HasSensorData ? ((HasSensorData) device4).getLatestSensorDatapoint() : null;
                }
                if (indoorDatapoint != null) {
                    ((DeviceEtaHolder) deviceAttributeHolder).update((HasFanSpeed) device4, indoorDatapoint);
                }
            }
        } else if (deviceAttributeHolder instanceof DeviceNCleanAirEtaHolder) {
            DeviceNCleanAirEtaHolder deviceNCleanAirEtaHolder = (DeviceNCleanAirEtaHolder) deviceAttributeHolder;
            if (!Intrinsics.areEqual(deviceNCleanAirEtaHolder.getBinding().cleanAirEta.getTag(), (Object) "dev_holder") && (device2 = this.device) != null) {
                deviceNCleanAirEtaHolder.update(device2, this.latestDatapoint);
            }
        } else if (deviceAttributeHolder instanceof DeviceC3FanSpeedHolder) {
            Device device5 = this.device;
            if (device5 != null) {
                ((DeviceC3FanSpeedHolder) deviceAttributeHolder).update(device5, this.latestDatapoint);
            }
        } else if (deviceAttributeHolder instanceof DeviceNFanSpeedHolder) {
            Device device6 = this.device;
            if (device6 != null) {
                ((DeviceNFanSpeedHolder) deviceAttributeHolder).update(device6, this.latestDatapoint);
            }
        } else if (deviceAttributeHolder instanceof DeviceWeightHolder) {
            Device device7 = this.device;
            if (device7 != null) {
                ((DeviceWeightHolder) deviceAttributeHolder).update(device7, this.latestDatapoint);
            }
        } else if ((deviceAttributeHolder instanceof DeviceBrightnessHolder) && i == 0) {
            ((DeviceBrightnessHolder) deviceAttributeHolder).getBinding().getRoot().setPadding(0, 0, 0, 0);
        }
    }

    private final void handleModeAction(ModeIcon modeIcon) {
        Device device2 = this.device;
        if (device2 != null) {
            switch (WhenMappings.$EnumSwitchMapping$1[modeIcon.ordinal()]) {
                case 1:
                    this.onActionPublisher.onNext(AttributeAction.StandbyModeAction.INSTANCE);
                    return;
                case 2:
                    this.onActionPublisher.onNext(AttributeAction.ManualModeAction.INSTANCE);
                    return;
                case 3:
                case 4:
                    if (!(device2 instanceof HasStandBy) || !(device2 instanceof HasFanSpeed)) {
                        Timber.Forest.d("auto mode clicked ", new Object[0]);
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
                    } else {
                        Timber.Forest forest = Timber.Forest;
                        StringBuilder sb = new StringBuilder("auto mode clicked & is standby on =  ");
                        HasStandBy hasStandBy = (HasStandBy) device2;
                        sb.append(hasStandBy.isStandByOn());
                        forest.d(sb.toString(), new Object[0]);
                        if (!hasStandBy.isStandByOn()) {
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
                    }
                case 5:
                    if (device2 instanceof HasStandBy) {
                        Timber.Forest forest2 = Timber.Forest;
                        StringBuilder sb2 = new StringBuilder("night mode clicked & is standby on =  ");
                        HasStandBy hasStandBy2 = (HasStandBy) device2;
                        sb2.append(hasStandBy2.isStandByOn());
                        forest2.d(sb2.toString(), new Object[0]);
                        if (!hasStandBy2.isStandByOn()) {
                            this.onActionPublisher.onNext(AttributeAction.NightModeAction.INSTANCE);
                            return;
                        }
                        return;
                    }
                    Timber.Forest.d("night mode clicked ", new Object[0]);
                    this.onActionPublisher.onNext(AttributeAction.NightModeAction.INSTANCE);
                    return;
                case 6:
                    this.onActionPublisher.onNext(AttributeAction.ChildLockAction.INSTANCE);
                    return;
                case 7:
                    this.onActionPublisher.onNext(AttributeAction.DisinfectionModeAction.INSTANCE);
                    return;
                case 8:
                    this.onActionPublisher.onNext(AttributeAction.EcoModeAction.INSTANCE);
                    return;
                default:
                    return;
            }
        }
    }

    public final void notifyDisinfectLeftTimeChanged() {
        int i = 0;
        Timber.Forest.d("disinftime adapter.notifyDisinfectLeftTimeChanged", new Object[0]);
        Iterator<? extends DeviceAttribute> it = this.attributes.iterator();
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (((DeviceAttribute) it.next()) == DeviceAttribute.DISINFECTION_STATUS) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            notifyItemChanged(i);
        }
    }

    public final void notifyTimerLeftTimeChanged() {
        Iterator<? extends DeviceAttribute> it = this.attributes.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (((DeviceAttribute) it.next()) == DeviceAttribute.TIMER) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            notifyItemChanged(i);
        }
    }

    public final void notifyWickDryLeftTimeChanged() {
        Iterator<? extends DeviceAttribute> it = this.attributes.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (((DeviceAttribute) it.next()) == DeviceAttribute.DRY_MODE) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            notifyItemChanged(i);
        }
    }

    public final void notifySubAutoChanged() {
        Iterator<? extends DeviceAttribute> it = this.attributes.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (((DeviceAttribute) it.next()) == DeviceAttribute.SUB_AUTO) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            notifyItemChanged(i);
        }
    }
}
