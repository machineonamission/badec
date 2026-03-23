package com.blueair.devicedetails.viewholder;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.databinding.HolderDeviceModeButtonV2Binding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.utils.ModeIcon;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ6\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00122\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceModeButtonV2Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceModeButtonV2Binding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceModeButtonV2Binding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceModeButtonV2Binding;", "updateMode", "", "mode", "Lcom/blueair/viewcore/utils/ModeIcon;", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "modeValue", "stayOffIcons", "", "disableModeIcons", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceModeButtonV2Holder.kt */
public final class DeviceModeButtonV2Holder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceModeButtonV2Binding binding;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceModeButtonV2Holder.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|27) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.viewcore.utils.ModeIcon[] r0 = com.blueair.viewcore.utils.ModeIcon.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.FAN_SPEED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.NIGHT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.AUTO     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.WATERDROP_AUTO     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.ECO     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.SKIN     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.STANDBY     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.CHILD_LOCK     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.DISINFECTION     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.SMART     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.DRYING     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.CONTINUOUS     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceModeButtonV2Holder.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceModeButtonV2Holder(HolderDeviceModeButtonV2Binding holderDeviceModeButtonV2Binding) {
        super(holderDeviceModeButtonV2Binding.getRoot());
        Intrinsics.checkNotNullParameter(holderDeviceModeButtonV2Binding, "binding");
        this.binding = holderDeviceModeButtonV2Binding;
    }

    public final HolderDeviceModeButtonV2Binding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceModeButtonV2Holder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceModeButtonV2Holder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceModeButtonV2Holder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceModeButtonV2Holder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderDeviceModeButtonV2Binding inflate = HolderDeviceModeButtonV2Binding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            ViewUtils viewUtils = ViewUtils.INSTANCE;
            FrameLayout root = inflate.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            ViewUtils.setAccessibilityDelegate$default(viewUtils, root, Reflection.getOrCreateKotlinClass(RadioButton.class), (String) null, new DeviceModeButtonV2Holder$Companion$$ExternalSyntheticLambda0(), 4, (Object) null);
            return new DeviceModeButtonV2Holder(inflate);
        }

        /* access modifiers changed from: private */
        public static final Unit newInstance$lambda$0(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Intrinsics.checkNotNullParameter(view, "v");
            Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
            accessibilityNodeInfoCompat.setSelected(Intrinsics.areEqual(view.getTag(), (Object) true));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        if (r4.getWaterShortage() != false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x026b, code lost:
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        if (((com.blueair.core.model.HasBody) r11).getBodyMounted() == false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0282, code lost:
        if (r11.isInDehSubMode(com.blueair.core.model.DehSubMode.CONTINUOUS) != false) goto L_0x02dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0299, code lost:
        if (r11.isInDehSubMode(com.blueair.core.model.DehSubMode.DRYING) != false) goto L_0x02dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x02a8, code lost:
        if (((com.blueair.core.model.HasPetMainMode) r11).isInMainMode(com.blueair.core.model.MainMode.SMART) != false) goto L_0x02dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x02b3, code lost:
        if (com.blueair.core.model.DeviceKt.isDisinfectionOn(r11) != false) goto L_0x02dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x02c0, code lost:
        if (((com.blueair.core.model.HasChildLock) r11).isChildLockOn() != false) goto L_0x02dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x02cd, code lost:
        if (((com.blueair.core.model.HasStandBy) r11).isStandByOn() != false) goto L_0x02dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x02da, code lost:
        if (r7 == false) goto L_0x026b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x02dc, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x02e1, code lost:
        if (r12 == false) goto L_0x02e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x02e3, code lost:
        r2 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x02d0  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x02d2  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x02e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateMode(com.blueair.viewcore.utils.ModeIcon r10, com.blueair.core.model.Device r11, boolean r12) {
        /*
            r9 = this;
            java.lang.String r0 = "mode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "device"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            com.blueair.devicedetails.databinding.HolderDeviceModeButtonV2Binding r0 = r9.binding
            android.widget.TextView r0 = r0.modeText
            int r1 = r10.getTextShort()
            r0.setText(r1)
            boolean r0 = r11 instanceof com.blueair.core.model.HasWaterLevel
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0028
            r0 = r11
            com.blueair.core.model.HasWaterLevel r0 = (com.blueair.core.model.HasWaterLevel) r0
            com.blueair.core.model.WaterLevel r3 = com.blueair.core.model.WaterLevel.SHORTAGE
            boolean r0 = r0.isInWaterLevel(r3)
            if (r0 == 0) goto L_0x0028
            r0 = r1
            goto L_0x0029
        L_0x0028:
            r0 = r2
        L_0x0029:
            boolean r3 = r11 instanceof com.blueair.core.model.DeviceHumidifier20
            if (r3 == 0) goto L_0x002f
            r4 = r0
            goto L_0x0059
        L_0x002f:
            boolean r4 = r11 instanceof com.blueair.core.model.DeviceHumidifier
            if (r4 == 0) goto L_0x0049
            r4 = r11
            com.blueair.core.model.DeviceHumidifier r4 = (com.blueair.core.model.DeviceHumidifier) r4
            java.lang.String r5 = r4.getHardware()
            java.lang.String r6 = "hum_n"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x0058
            boolean r4 = r4.getWaterShortage()
            if (r4 == 0) goto L_0x0058
            goto L_0x0056
        L_0x0049:
            boolean r4 = r11 instanceof com.blueair.core.model.HasBody
            if (r4 == 0) goto L_0x0058
            r4 = r11
            com.blueair.core.model.HasBody r4 = (com.blueair.core.model.HasBody) r4
            boolean r4 = r4.getBodyMounted()
            if (r4 != 0) goto L_0x0058
        L_0x0056:
            r4 = r1
            goto L_0x0059
        L_0x0058:
            r4 = r2
        L_0x0059:
            boolean r5 = com.blueair.core.model.DeviceKt.isStandByOn(r11)
            if (r5 != 0) goto L_0x006c
            boolean r5 = r11.isOnline()
            if (r5 == 0) goto L_0x006c
            if (r12 != 0) goto L_0x006c
            if (r4 == 0) goto L_0x006a
            goto L_0x006c
        L_0x006a:
            r12 = r2
            goto L_0x006d
        L_0x006c:
            r12 = r1
        L_0x006d:
            boolean r4 = r11 instanceof com.blueair.core.model.DeviceCombo2in120
            if (r4 == 0) goto L_0x00a3
            if (r0 != 0) goto L_0x007c
            r0 = r11
            com.blueair.core.model.DeviceCombo2in120 r0 = (com.blueair.core.model.DeviceCombo2in120) r0
            boolean r0 = r0.getWaterTankFailure()
            if (r0 == 0) goto L_0x00a3
        L_0x007c:
            r0 = r11
            com.blueair.core.model.DeviceCombo2in120 r0 = (com.blueair.core.model.DeviceCombo2in120) r0
            com.blueair.core.model.MainMode r4 = com.blueair.core.model.MainMode.Humidification
            boolean r0 = r0.isInMainMode(r4)
            if (r0 == 0) goto L_0x009c
            r0 = 3
            com.blueair.viewcore.utils.ModeIcon[] r0 = new com.blueair.viewcore.utils.ModeIcon[r0]
            com.blueair.viewcore.utils.ModeIcon r4 = com.blueair.viewcore.utils.ModeIcon.FAN_SPEED
            r0[r2] = r4
            com.blueair.viewcore.utils.ModeIcon r4 = com.blueair.viewcore.utils.ModeIcon.NIGHT
            r0[r1] = r4
            r4 = 2
            com.blueair.viewcore.utils.ModeIcon r5 = com.blueair.viewcore.utils.ModeIcon.SKIN
            r0[r4] = r5
            java.util.Set r0 = kotlin.collections.SetsKt.setOf(r0)
            goto L_0x00a7
        L_0x009c:
            com.blueair.viewcore.utils.ModeIcon r0 = com.blueair.viewcore.utils.ModeIcon.SKIN
            java.util.Set r0 = kotlin.collections.SetsKt.setOf(r0)
            goto L_0x00a7
        L_0x00a3:
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()
        L_0x00a7:
            r4 = 0
            if (r12 != 0) goto L_0x031b
            boolean r12 = r0.contains(r10)
            if (r12 == 0) goto L_0x00b2
            goto L_0x031b
        L_0x00b2:
            boolean r12 = r11 instanceof com.blueair.core.model.HasCombo3in1MainMode
            if (r12 == 0) goto L_0x00dc
            r12 = r11
            com.blueair.core.model.HasCombo3in1MainMode r12 = (com.blueair.core.model.HasCombo3in1MainMode) r12
            com.blueair.core.model.ApSubMode r12 = r12.currentSubMode()
            com.blueair.core.model.ApSubMode r0 = com.blueair.core.model.ApSubMode.FAN
            if (r12 != r0) goto L_0x00c3
            r0 = r1
            goto L_0x00c4
        L_0x00c3:
            r0 = r2
        L_0x00c4:
            com.blueair.core.model.ApSubMode r5 = com.blueair.core.model.ApSubMode.AUTO
            if (r12 != r5) goto L_0x00ca
            r5 = r1
            goto L_0x00cb
        L_0x00ca:
            r5 = r2
        L_0x00cb:
            com.blueair.core.model.ApSubMode r6 = com.blueair.core.model.ApSubMode.ECO
            if (r12 != r6) goto L_0x00d1
            r6 = r1
            goto L_0x00d2
        L_0x00d1:
            r6 = r2
        L_0x00d2:
            com.blueair.core.model.ApSubMode r7 = com.blueair.core.model.ApSubMode.NIGHT
            if (r12 != r7) goto L_0x00d9
            r12 = r1
            goto L_0x0212
        L_0x00d9:
            r12 = r2
            goto L_0x0212
        L_0x00dc:
            boolean r12 = r11 instanceof com.blueair.core.model.HasDehumidifierMainMode
            if (r12 == 0) goto L_0x0123
            r12 = r11
            com.blueair.core.model.HasDehumidifierMainMode r12 = (com.blueair.core.model.HasDehumidifierMainMode) r12
            com.blueair.core.model.MainMode r0 = com.blueair.core.model.MainMode.AirPurify
            boolean r0 = r12.isInMainMode(r0)
            if (r0 == 0) goto L_0x00f5
            com.blueair.core.model.ApSubMode r0 = com.blueair.core.model.ApSubMode.FAN
            boolean r0 = r12.isInApSubMode(r0)
            if (r0 == 0) goto L_0x00f5
            r0 = r1
            goto L_0x00f6
        L_0x00f5:
            r0 = r2
        L_0x00f6:
            com.blueair.core.model.MainMode r5 = com.blueair.core.model.MainMode.AirPurify
            boolean r5 = r12.isInMainMode(r5)
            if (r5 == 0) goto L_0x0108
            com.blueair.core.model.ApSubMode r5 = com.blueair.core.model.ApSubMode.NIGHT
            boolean r5 = r12.isInApSubMode(r5)
            if (r5 == 0) goto L_0x0108
            r5 = r1
            goto L_0x0109
        L_0x0108:
            r5 = r2
        L_0x0109:
            com.blueair.core.model.MainMode r6 = com.blueair.core.model.MainMode.Dehumidification
            boolean r6 = r12.isInMainMode(r6)
            if (r6 == 0) goto L_0x011b
            com.blueair.core.model.DehSubMode r6 = com.blueair.core.model.DehSubMode.AUTO
            boolean r12 = r12.isInDehSubMode(r6)
            if (r12 == 0) goto L_0x011b
            r12 = r1
            goto L_0x011c
        L_0x011b:
            r12 = r2
        L_0x011c:
            r6 = r12
            r7 = r2
            r12 = r5
            r5 = r0
            r0 = r7
            goto L_0x0253
        L_0x0123:
            boolean r12 = r11 instanceof com.blueair.core.model.HasHumMainMode
            if (r12 == 0) goto L_0x019d
            boolean r12 = r11 instanceof com.blueair.core.model.HasWick
            if (r12 == 0) goto L_0x0136
            r12 = r11
            com.blueair.core.model.HasWick r12 = (com.blueair.core.model.HasWick) r12
            boolean r12 = r12.getWickdryOn()
            if (r12 == 0) goto L_0x0136
            r12 = r1
            goto L_0x0137
        L_0x0136:
            r12 = r2
        L_0x0137:
            r0 = r11
            com.blueair.core.model.HasHumMainMode r0 = (com.blueair.core.model.HasHumMainMode) r0
            com.blueair.core.model.MainMode r5 = com.blueair.core.model.MainMode.Humidification
            boolean r5 = r0.isInMainMode(r5)
            if (r5 == 0) goto L_0x016f
            com.blueair.core.model.HumSubMode r5 = com.blueair.core.model.HumSubMode.FAN
            boolean r5 = r0.isInHumSubMode(r5)
            if (r5 == 0) goto L_0x014e
            if (r12 != 0) goto L_0x014e
            r5 = r1
            goto L_0x014f
        L_0x014e:
            r5 = r2
        L_0x014f:
            com.blueair.core.model.HumSubMode r6 = com.blueair.core.model.HumSubMode.NIGHT
            boolean r6 = r0.isInHumSubMode(r6)
            if (r6 == 0) goto L_0x015b
            if (r12 != 0) goto L_0x015b
            r6 = r1
            goto L_0x015c
        L_0x015b:
            r6 = r2
        L_0x015c:
            com.blueair.core.model.HumSubMode r7 = com.blueair.core.model.HumSubMode.SKIN
            boolean r0 = r0.isInHumSubMode(r7)
            if (r0 == 0) goto L_0x0168
            if (r12 != 0) goto L_0x0168
            r12 = r1
            goto L_0x0169
        L_0x0168:
            r12 = r2
        L_0x0169:
            r0 = r12
            r7 = r2
            r12 = r6
            r6 = r7
            goto L_0x0253
        L_0x016f:
            com.blueair.core.model.ApSubMode r5 = com.blueair.core.model.ApSubMode.FAN
            boolean r5 = r0.isInApSubMode(r5)
            if (r5 == 0) goto L_0x017b
            if (r12 != 0) goto L_0x017b
            r5 = r1
            goto L_0x017c
        L_0x017b:
            r5 = r2
        L_0x017c:
            com.blueair.core.model.ApSubMode r6 = com.blueair.core.model.ApSubMode.NIGHT
            boolean r6 = r0.isInApSubMode(r6)
            if (r6 == 0) goto L_0x0188
            if (r12 != 0) goto L_0x0188
            r6 = r1
            goto L_0x0189
        L_0x0188:
            r6 = r2
        L_0x0189:
            com.blueair.core.model.ApSubMode r7 = com.blueair.core.model.ApSubMode.AUTO
            boolean r0 = r0.isInApSubMode(r7)
            if (r0 == 0) goto L_0x0195
            if (r12 != 0) goto L_0x0195
            r12 = r1
            goto L_0x0196
        L_0x0195:
            r12 = r2
        L_0x0196:
            r0 = r6
            r6 = r12
            r12 = r0
            r0 = r2
            r7 = r0
            goto L_0x0253
        L_0x019d:
            boolean r12 = r11 instanceof com.blueair.core.model.HasMainMode
            if (r12 == 0) goto L_0x01f3
            r12 = r11
            com.blueair.core.model.HasMainMode r12 = (com.blueair.core.model.HasMainMode) r12
            com.blueair.core.model.MainMode r0 = com.blueair.core.model.MainMode.AirPurify
            boolean r0 = r12.isInMainMode(r0)
            if (r0 == 0) goto L_0x01b6
            com.blueair.core.model.ApSubMode r0 = com.blueair.core.model.ApSubMode.FAN
            boolean r0 = r12.isInApSubMode(r0)
            if (r0 == 0) goto L_0x01b6
            r0 = r1
            goto L_0x01b7
        L_0x01b6:
            r0 = r2
        L_0x01b7:
            com.blueair.core.model.MainMode r5 = com.blueair.core.model.MainMode.AirPurify
            boolean r5 = r12.isInMainMode(r5)
            if (r5 == 0) goto L_0x01c9
            com.blueair.core.model.ApSubMode r5 = com.blueair.core.model.ApSubMode.NIGHT
            boolean r5 = r12.isInApSubMode(r5)
            if (r5 == 0) goto L_0x01c9
            r5 = r1
            goto L_0x01ca
        L_0x01c9:
            r5 = r2
        L_0x01ca:
            com.blueair.core.model.MainMode r6 = com.blueair.core.model.MainMode.AirPurify
            boolean r6 = r12.isInMainMode(r6)
            if (r6 == 0) goto L_0x01dc
            com.blueair.core.model.ApSubMode r6 = com.blueair.core.model.ApSubMode.AUTO
            boolean r6 = r12.isInApSubMode(r6)
            if (r6 == 0) goto L_0x01dc
            r6 = r1
            goto L_0x01dd
        L_0x01dc:
            r6 = r2
        L_0x01dd:
            com.blueair.core.model.MainMode r7 = com.blueair.core.model.MainMode.AirPurify
            boolean r7 = r12.isInMainMode(r7)
            if (r7 == 0) goto L_0x01ef
            com.blueair.core.model.ApSubMode r7 = com.blueair.core.model.ApSubMode.ECO
            boolean r12 = r12.isInApSubMode(r7)
            if (r12 == 0) goto L_0x01ef
            r12 = r1
            goto L_0x01f0
        L_0x01ef:
            r12 = r2
        L_0x01f0:
            r7 = r12
            r12 = r5
            goto L_0x0214
        L_0x01f3:
            boolean r12 = r11 instanceof com.blueair.core.model.HasMode
            if (r12 == 0) goto L_0x0217
            r12 = r11
            com.blueair.core.model.HasMode r12 = (com.blueair.core.model.HasMode) r12
            com.blueair.core.model.Mode r0 = com.blueair.core.model.Mode.FAN
            boolean r0 = r12.isInMode(r0)
            com.blueair.core.model.Mode r5 = com.blueair.core.model.Mode.AUTO
            boolean r5 = r12.isInMode(r5)
            com.blueair.core.model.Mode r6 = com.blueair.core.model.Mode.ECO
            boolean r6 = r12.isInMode(r6)
            com.blueair.core.model.Mode r7 = com.blueair.core.model.Mode.NIGHT
            boolean r12 = r12.isInMode(r7)
        L_0x0212:
            r7 = r6
            r6 = r5
        L_0x0214:
            r5 = r0
            r0 = r2
            goto L_0x0253
        L_0x0217:
            boolean r12 = r11 instanceof com.blueair.core.model.HasFanSpeed
            if (r12 == 0) goto L_0x0228
            r12 = r11
            com.blueair.core.model.HasFanSpeed r12 = (com.blueair.core.model.HasFanSpeed) r12
            com.blueair.core.model.AutoMode r12 = r12.getAutoMode()
            com.blueair.core.model.AutoMode r0 = com.blueair.core.model.AutoMode.ON
            if (r12 != r0) goto L_0x0228
            r5 = r1
            goto L_0x0229
        L_0x0228:
            r5 = r2
        L_0x0229:
            boolean r12 = r11 instanceof com.blueair.core.model.HasEcoMode
            if (r12 == 0) goto L_0x0238
            r12 = r11
            com.blueair.core.model.HasEcoMode r12 = (com.blueair.core.model.HasEcoMode) r12
            boolean r12 = r12.isEcoModeOn()
            if (r12 == 0) goto L_0x0238
            r6 = r1
            goto L_0x0239
        L_0x0238:
            r6 = r2
        L_0x0239:
            boolean r12 = r11 instanceof com.blueair.core.model.HasG4NightMode
            if (r12 == 0) goto L_0x0248
            r12 = r11
            com.blueair.core.model.HasG4NightMode r12 = (com.blueair.core.model.HasG4NightMode) r12
            boolean r12 = r12.isG4NightModeOn()
            if (r12 == 0) goto L_0x0248
            r12 = r1
            goto L_0x0249
        L_0x0248:
            r12 = r2
        L_0x0249:
            if (r5 != 0) goto L_0x0251
            if (r12 != 0) goto L_0x0251
            if (r6 != 0) goto L_0x0251
            r0 = r1
            goto L_0x0212
        L_0x0251:
            r0 = r2
            goto L_0x0212
        L_0x0253:
            if (r3 == 0) goto L_0x0260
            r3 = r11
            com.blueair.core.model.DeviceHumidifier20 r3 = (com.blueair.core.model.DeviceHumidifier20) r3
            boolean r3 = r3.getWickdryOn()
            if (r3 == 0) goto L_0x0260
            goto L_0x02e4
        L_0x0260:
            int[] r3 = com.blueair.devicedetails.viewholder.DeviceModeButtonV2Holder.WhenMappings.$EnumSwitchMapping$0
            int r8 = r10.ordinal()
            r3 = r3[r8]
            switch(r3) {
                case 1: goto L_0x02e0;
                case 2: goto L_0x02e1;
                case 3: goto L_0x02d4;
                case 4: goto L_0x02d4;
                case 5: goto L_0x02d2;
                case 6: goto L_0x02d0;
                case 7: goto L_0x02c3;
                case 8: goto L_0x02b6;
                case 9: goto L_0x02ab;
                case 10: goto L_0x029c;
                case 11: goto L_0x0285;
                case 12: goto L_0x026e;
                default: goto L_0x026b;
            }
        L_0x026b:
            r12 = r2
            goto L_0x02e1
        L_0x026e:
            boolean r12 = r11 instanceof com.blueair.core.model.HasDehumidifierMainMode
            if (r12 == 0) goto L_0x026b
            com.blueair.core.model.HasDehumidifierMainMode r11 = (com.blueair.core.model.HasDehumidifierMainMode) r11
            com.blueair.core.model.MainMode r12 = com.blueair.core.model.MainMode.Dehumidification
            boolean r12 = r11.isInMainMode(r12)
            if (r12 == 0) goto L_0x026b
            com.blueair.core.model.DehSubMode r12 = com.blueair.core.model.DehSubMode.CONTINUOUS
            boolean r11 = r11.isInDehSubMode(r12)
            if (r11 == 0) goto L_0x026b
            goto L_0x02dc
        L_0x0285:
            boolean r12 = r11 instanceof com.blueair.core.model.HasDehumidifierMainMode
            if (r12 == 0) goto L_0x026b
            com.blueair.core.model.HasDehumidifierMainMode r11 = (com.blueair.core.model.HasDehumidifierMainMode) r11
            com.blueair.core.model.MainMode r12 = com.blueair.core.model.MainMode.Dehumidification
            boolean r12 = r11.isInMainMode(r12)
            if (r12 == 0) goto L_0x026b
            com.blueair.core.model.DehSubMode r12 = com.blueair.core.model.DehSubMode.DRYING
            boolean r11 = r11.isInDehSubMode(r12)
            if (r11 == 0) goto L_0x026b
            goto L_0x02c2
        L_0x029c:
            boolean r12 = r11 instanceof com.blueair.core.model.HasPetMainMode
            if (r12 == 0) goto L_0x026b
            com.blueair.core.model.HasPetMainMode r11 = (com.blueair.core.model.HasPetMainMode) r11
            com.blueair.core.model.MainMode r12 = com.blueair.core.model.MainMode.SMART
            boolean r11 = r11.isInMainMode(r12)
            if (r11 == 0) goto L_0x026b
            goto L_0x02c2
        L_0x02ab:
            boolean r12 = r11 instanceof com.blueair.core.model.HasDisinfection
            if (r12 == 0) goto L_0x026b
            boolean r11 = com.blueair.core.model.DeviceKt.isDisinfectionOn(r11)
            if (r11 == 0) goto L_0x026b
            goto L_0x02dc
        L_0x02b6:
            boolean r12 = r11 instanceof com.blueair.core.model.HasChildLock
            if (r12 == 0) goto L_0x026b
            com.blueair.core.model.HasChildLock r11 = (com.blueair.core.model.HasChildLock) r11
            boolean r11 = r11.isChildLockOn()
            if (r11 == 0) goto L_0x026b
        L_0x02c2:
            goto L_0x02dc
        L_0x02c3:
            boolean r12 = r11 instanceof com.blueair.core.model.HasStandBy
            if (r12 == 0) goto L_0x026b
            com.blueair.core.model.HasStandBy r11 = (com.blueair.core.model.HasStandBy) r11
            boolean r11 = r11.isStandByOn()
            if (r11 == 0) goto L_0x026b
            goto L_0x02dc
        L_0x02d0:
            r12 = r0
            goto L_0x02e1
        L_0x02d2:
            r12 = r7
            goto L_0x02e1
        L_0x02d4:
            boolean r11 = r11 instanceof com.blueair.core.model.DeviceNewClassic
            if (r11 == 0) goto L_0x02de
            if (r6 != 0) goto L_0x02dc
            if (r7 == 0) goto L_0x026b
        L_0x02dc:
            r12 = r1
            goto L_0x02e1
        L_0x02de:
            r12 = r6
            goto L_0x02e1
        L_0x02e0:
            r12 = r5
        L_0x02e1:
            if (r12 == 0) goto L_0x02e4
            r2 = r1
        L_0x02e4:
            com.blueair.devicedetails.databinding.HolderDeviceModeButtonV2Binding r11 = r9.binding
            android.widget.LinearLayout r12 = r11.modeRoot
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            r12.setTag(r0)
            android.widget.LinearLayout r12 = r11.modeRoot
            r12.setEnabled(r1)
            android.widget.TextView r12 = r11.modeText
            android.view.View r0 = r9.itemView
            android.content.res.Resources r0 = r0.getResources()
            if (r2 == 0) goto L_0x0301
            int r1 = com.blueair.viewcore.R.color.colorPrimaryText
            goto L_0x0303
        L_0x0301:
            int r1 = com.blueair.viewcore.R.color.surface_dark_65
        L_0x0303:
            int r0 = r0.getColor(r1, r4)
            r12.setTextColor(r0)
            if (r2 == 0) goto L_0x0311
            int r10 = r10.getOnIconV2()
            goto L_0x0315
        L_0x0311:
            int r10 = r10.getOffIconV2()
        L_0x0315:
            androidx.appcompat.widget.AppCompatImageView r11 = r11.modeIcon
            r11.setImageResource(r10)
            return
        L_0x031b:
            com.blueair.devicedetails.databinding.HolderDeviceModeButtonV2Binding r11 = r9.binding
            android.widget.LinearLayout r12 = r11.modeRoot
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            r12.setTag(r0)
            android.widget.LinearLayout r12 = r11.modeRoot
            r12.setEnabled(r2)
            androidx.appcompat.widget.AppCompatImageView r12 = r11.modeIcon
            int r10 = r10.getDisabledIconV2()
            r12.setImageResource(r10)
            android.widget.TextView r10 = r11.modeText
            android.view.View r11 = r9.itemView
            android.content.res.Resources r11 = r11.getResources()
            int r12 = com.blueair.viewcore.R.color.surface_dark_55
            int r11 = r11.getColor(r12, r4)
            r10.setTextColor(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceModeButtonV2Holder.updateMode(com.blueair.viewcore.utils.ModeIcon, com.blueair.core.model.Device, boolean):void");
    }

    public final void updateMode(ModeIcon modeIcon, ModeIcon modeIcon2, Set<? extends ModeIcon> set, Set<? extends ModeIcon> set2) {
        Intrinsics.checkNotNullParameter(modeIcon, "mode");
        Intrinsics.checkNotNullParameter(modeIcon2, "modeValue");
        Intrinsics.checkNotNullParameter(set, "stayOffIcons");
        Intrinsics.checkNotNullParameter(set2, "disableModeIcons");
        HolderDeviceModeButtonV2Binding holderDeviceModeButtonV2Binding = this.binding;
        holderDeviceModeButtonV2Binding.modeText.setText(modeIcon.getTextShort());
        boolean z = false;
        if (modeIcon2 == ModeIcon.STANDBY || set2.contains(modeIcon2)) {
            holderDeviceModeButtonV2Binding.modeRoot.setTag(false);
            holderDeviceModeButtonV2Binding.modeRoot.setEnabled(false);
            holderDeviceModeButtonV2Binding.modeIcon.setImageResource(modeIcon.getDisabledIconV2());
            holderDeviceModeButtonV2Binding.modeText.setTextColor(this.itemView.getResources().getColor(R.color.surface_dark_55, (Resources.Theme) null));
            return;
        }
        holderDeviceModeButtonV2Binding.modeRoot.setEnabled(true);
        if (modeIcon == modeIcon2 && !set.contains(modeIcon2)) {
            z = true;
        }
        holderDeviceModeButtonV2Binding.modeRoot.setTag(Boolean.valueOf(z));
        holderDeviceModeButtonV2Binding.modeText.setTextColor(this.itemView.getResources().getColor(z ? R.color.colorPrimaryText : R.color.surface_dark_65, (Resources.Theme) null));
        holderDeviceModeButtonV2Binding.modeIcon.setImageResource(z ? modeIcon.getOnIconV2() : modeIcon.getOffIconV2());
    }
}
