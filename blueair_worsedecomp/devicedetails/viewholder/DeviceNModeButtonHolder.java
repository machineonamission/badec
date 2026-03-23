package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.databinding.HolderDeviceNModeButtonBinding;
import com.blueair.viewcore.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J,\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNModeButtonHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceNModeButtonBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNModeButtonBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceNModeButtonBinding;", "updateMode", "", "mode", "Lcom/blueair/viewcore/utils/ModeIcon;", "device", "Lcom/blueair/core/model/Device;", "purifierMainMode", "Lcom/blueair/core/model/MainMode;", "purifierMode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "updateMainMode", "mainMode", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNModeButtonHolder.kt */
public final class DeviceNModeButtonHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceNModeButtonBinding binding;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNModeButtonHolder.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|(2:25|26)|27|29) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|29) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0069 */
        static {
            /*
                com.blueair.core.model.MainMode[] r0 = com.blueair.core.model.MainMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.blueair.core.model.MainMode r2 = com.blueair.core.model.MainMode.HEAT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.blueair.core.model.MainMode r3 = com.blueair.core.model.MainMode.COOL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                com.blueair.viewcore.utils.ModeIcon[] r0 = com.blueair.viewcore.utils.ModeIcon.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.viewcore.utils.ModeIcon r3 = com.blueair.viewcore.utils.ModeIcon.FAN_SPEED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.NIGHT     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.AUTO     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.WATERDROP_AUTO     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.ECO     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.STANDBY     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.DISINFECTION     // Catch:{ NoSuchFieldError -> 0x005f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.SMART     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.CHILD_LOCK     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceNModeButtonHolder.WhenMappings.<clinit>():void");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNModeButtonHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNModeButtonHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNModeButtonHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNModeButtonHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderDeviceNModeButtonBinding inflate = HolderDeviceNModeButtonBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceNModeButtonHolder(inflate);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceNModeButtonHolder(HolderDeviceNModeButtonBinding holderDeviceNModeButtonBinding) {
        super(holderDeviceNModeButtonBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderDeviceNModeButtonBinding, "binding");
        this.binding = holderDeviceNModeButtonBinding;
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        LinearLayout linearLayout = holderDeviceNModeButtonBinding.modeRoot;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "modeRoot");
        ViewUtils.setAccessibilityDelegate$default(viewUtils, linearLayout, Reflection.getOrCreateKotlinClass(RadioButton.class), (String) null, (Function2) null, 12, (Object) null);
    }

    public final HolderDeviceNModeButtonBinding getBinding() {
        return this.binding;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x01ba, code lost:
        if (((com.blueair.core.model.HasChildLock) r12).isChildLockOn() != false) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x01c7, code lost:
        if (((com.blueair.core.model.HasPetMainMode) r12).isInMainMode(com.blueair.core.model.MainMode.SMART) != false) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x01d2, code lost:
        if (com.blueair.core.model.DeviceKt.isDisinfectionOn(r12) != false) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x01df, code lost:
        if (((com.blueair.core.model.HasStandBy) r12).isStandByOn() != false) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x01ea, code lost:
        if (r7 == false) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0060, code lost:
        if (r6.isStandByOn() == true) goto L_0x0258;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a0, code lost:
        if (r13.getWaterShortage() != false) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00c5, code lost:
        if (r14 == com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.SMART) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00cb, code lost:
        if (r14 == com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00d1, code lost:
        if (r14 == com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00d7, code lost:
        if (r14 == com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.ECO) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00e5, code lost:
        if (r14 != com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.ECO) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00eb, code lost:
        if (r14 == com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00f1, code lost:
        if (r14 == com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL) goto L_0x01f2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x028d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateMode(com.blueair.viewcore.utils.ModeIcon r11, com.blueair.core.model.Device r12, com.blueair.core.model.MainMode r13, com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode r14) {
        /*
            r10 = this;
            java.lang.String r0 = "mode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            com.blueair.devicedetails.databinding.HolderDeviceNModeButtonBinding r0 = r10.binding
            android.widget.TextView r0 = r0.modeText
            int r1 = r11.getText()
            r0.setText(r1)
            boolean r0 = r12 instanceof com.blueair.core.model.HasCombo3in1MainMode
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0049
            r3 = r10
            com.blueair.devicedetails.viewholder.DeviceNModeButtonHolder r3 = (com.blueair.devicedetails.viewholder.DeviceNModeButtonHolder) r3
            if (r13 != 0) goto L_0x0023
            r3 = r12
            com.blueair.core.model.HasCombo3in1MainMode r3 = (com.blueair.core.model.HasCombo3in1MainMode) r3
            com.blueair.core.model.MainMode r3 = r3.mainMode()
            goto L_0x0024
        L_0x0023:
            r3 = r13
        L_0x0024:
            int[] r4 = com.blueair.devicedetails.viewholder.DeviceNModeButtonHolder.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r4[r3]
            if (r3 == r1) goto L_0x003f
            r4 = 2
            if (r3 == r4) goto L_0x0032
            goto L_0x0049
        L_0x0032:
            com.blueair.viewcore.utils.ModeIcon r3 = com.blueair.viewcore.utils.ModeIcon.AUTO
            if (r11 == r3) goto L_0x0047
            com.blueair.viewcore.utils.ModeIcon r3 = com.blueair.viewcore.utils.ModeIcon.WATERDROP_AUTO
            if (r11 == r3) goto L_0x0047
            com.blueair.viewcore.utils.ModeIcon r3 = com.blueair.viewcore.utils.ModeIcon.ECO
            if (r11 != r3) goto L_0x0049
            goto L_0x0047
        L_0x003f:
            com.blueair.viewcore.utils.ModeIcon r3 = com.blueair.viewcore.utils.ModeIcon.NIGHT
            if (r11 == r3) goto L_0x0047
            com.blueair.viewcore.utils.ModeIcon r3 = com.blueair.viewcore.utils.ModeIcon.ECO
            if (r11 != r3) goto L_0x0049
        L_0x0047:
            r3 = r1
            goto L_0x004a
        L_0x0049:
            r3 = r2
        L_0x004a:
            r4 = 0
            java.lang.String r5 = "modeText"
            if (r12 == 0) goto L_0x0258
            if (r14 != 0) goto L_0x0064
            boolean r6 = r12 instanceof com.blueair.core.model.HasStandBy
            if (r6 == 0) goto L_0x0059
            r6 = r12
            com.blueair.core.model.HasStandBy r6 = (com.blueair.core.model.HasStandBy) r6
            goto L_0x005a
        L_0x0059:
            r6 = r4
        L_0x005a:
            if (r6 == 0) goto L_0x0064
            boolean r6 = r6.isStandByOn()
            if (r6 != r1) goto L_0x0064
            goto L_0x0258
        L_0x0064:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r6 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY
            if (r14 != r6) goto L_0x006a
            goto L_0x0258
        L_0x006a:
            if (r3 != 0) goto L_0x00b2
            boolean r3 = r12.isUsDevice()
            if (r3 == 0) goto L_0x0085
            if (r0 == 0) goto L_0x0085
            if (r13 != 0) goto L_0x0081
            r3 = r12
            com.blueair.core.model.HasCombo3in1MainMode r3 = (com.blueair.core.model.HasCombo3in1MainMode) r3
            com.blueair.core.model.MainMode r6 = com.blueair.core.model.MainMode.HEAT
            boolean r3 = r3.isInMainMode(r6)
            if (r3 != 0) goto L_0x00b2
        L_0x0081:
            com.blueair.core.model.MainMode r3 = com.blueair.core.model.MainMode.HEAT
            if (r13 == r3) goto L_0x00b2
        L_0x0085:
            com.blueair.viewcore.utils.ModeIcon r13 = com.blueair.viewcore.utils.ModeIcon.STANDBY
            if (r11 == r13) goto L_0x00a2
            boolean r13 = r12 instanceof com.blueair.core.model.DeviceHumidifier
            if (r13 == 0) goto L_0x00a2
            r13 = r12
            com.blueair.core.model.DeviceHumidifier r13 = (com.blueair.core.model.DeviceHumidifier) r13
            java.lang.String r3 = r13.getHardware()
            java.lang.String r6 = "hum_n"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)
            if (r3 == 0) goto L_0x00a2
            boolean r13 = r13.getWaterShortage()
            if (r13 != 0) goto L_0x00b2
        L_0x00a2:
            boolean r13 = r12 instanceof com.blueair.core.model.HasBody
            if (r13 == 0) goto L_0x00b0
            r13 = r12
            com.blueair.core.model.HasBody r13 = (com.blueair.core.model.HasBody) r13
            boolean r13 = r13.getBodyMounted()
            if (r13 != 0) goto L_0x00b0
            goto L_0x00b2
        L_0x00b0:
            r13 = r2
            goto L_0x00b3
        L_0x00b2:
            r13 = r1
        L_0x00b3:
            if (r14 == 0) goto L_0x00f5
            int[] r0 = com.blueair.devicedetails.viewholder.DeviceNModeButtonHolder.WhenMappings.$EnumSwitchMapping$1
            int r3 = r11.ordinal()
            r0 = r0[r3]
            switch(r0) {
                case 1: goto L_0x00ef;
                case 2: goto L_0x00e9;
                case 3: goto L_0x00db;
                case 4: goto L_0x00db;
                case 5: goto L_0x00d5;
                case 6: goto L_0x00cf;
                case 7: goto L_0x00c9;
                case 8: goto L_0x00c3;
                default: goto L_0x00c0;
            }
        L_0x00c0:
            r1 = r2
            goto L_0x01f2
        L_0x00c3:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r12 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.SMART
            if (r14 != r12) goto L_0x00c0
            goto L_0x01f2
        L_0x00c9:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r12 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION
            if (r14 != r12) goto L_0x00c0
            goto L_0x01f2
        L_0x00cf:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r12 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY
            if (r14 != r12) goto L_0x00c0
            goto L_0x01f2
        L_0x00d5:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r12 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.ECO
            if (r14 != r12) goto L_0x00c0
            goto L_0x01f2
        L_0x00db:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r0 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.AUTO
            if (r14 == r0) goto L_0x01f2
            boolean r12 = r12 instanceof com.blueair.core.model.DeviceNewClassic
            if (r12 == 0) goto L_0x00c0
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r12 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.ECO
            if (r14 != r12) goto L_0x00c0
            goto L_0x01f2
        L_0x00e9:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r12 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT
            if (r14 != r12) goto L_0x00c0
            goto L_0x01f2
        L_0x00ef:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r12 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL
            if (r14 != r12) goto L_0x00c0
            goto L_0x01f2
        L_0x00f5:
            boolean r14 = r12 instanceof com.blueair.core.model.HasPetMainMode
            if (r14 == 0) goto L_0x0126
            r0 = r12
            com.blueair.core.model.HasPetMainMode r0 = (com.blueair.core.model.HasPetMainMode) r0
            com.blueair.core.model.MainMode r3 = com.blueair.core.model.MainMode.AirPurify
            boolean r3 = r0.isInMainMode(r3)
            if (r3 == 0) goto L_0x010e
            com.blueair.core.model.ApSubMode r3 = com.blueair.core.model.ApSubMode.FAN
            boolean r3 = r0.isInApSubMode(r3)
            if (r3 == 0) goto L_0x010e
            r3 = r1
            goto L_0x010f
        L_0x010e:
            r3 = r2
        L_0x010f:
            com.blueair.core.model.MainMode r6 = com.blueair.core.model.MainMode.AirPurify
            boolean r6 = r0.isInMainMode(r6)
            if (r6 == 0) goto L_0x0121
            com.blueair.core.model.ApSubMode r6 = com.blueair.core.model.ApSubMode.NIGHT
            boolean r0 = r0.isInApSubMode(r6)
            if (r0 == 0) goto L_0x0121
            r0 = r1
            goto L_0x0122
        L_0x0121:
            r0 = r2
        L_0x0122:
            r6 = r2
            r7 = r6
            goto L_0x01a3
        L_0x0126:
            if (r0 == 0) goto L_0x014d
            r0 = r12
            com.blueair.core.model.HasCombo3in1MainMode r0 = (com.blueair.core.model.HasCombo3in1MainMode) r0
            com.blueair.core.model.ApSubMode r0 = r0.currentSubMode()
            com.blueair.core.model.ApSubMode r3 = com.blueair.core.model.ApSubMode.FAN
            if (r0 != r3) goto L_0x0135
            r3 = r1
            goto L_0x0136
        L_0x0135:
            r3 = r2
        L_0x0136:
            com.blueair.core.model.ApSubMode r6 = com.blueair.core.model.ApSubMode.AUTO
            if (r0 != r6) goto L_0x013c
            r6 = r1
            goto L_0x013d
        L_0x013c:
            r6 = r2
        L_0x013d:
            com.blueair.core.model.ApSubMode r7 = com.blueair.core.model.ApSubMode.ECO
            if (r0 != r7) goto L_0x0143
            r7 = r1
            goto L_0x0144
        L_0x0143:
            r7 = r2
        L_0x0144:
            com.blueair.core.model.ApSubMode r8 = com.blueair.core.model.ApSubMode.NIGHT
            if (r0 != r8) goto L_0x014b
            r0 = r1
            goto L_0x01a3
        L_0x014b:
            r0 = r2
            goto L_0x01a3
        L_0x014d:
            boolean r0 = r12 instanceof com.blueair.core.model.HasMode
            if (r0 == 0) goto L_0x0168
            r0 = r12
            com.blueair.core.model.HasMode r0 = (com.blueair.core.model.HasMode) r0
            com.blueair.core.model.Mode r3 = com.blueair.core.model.Mode.FAN
            boolean r3 = r0.isInMode(r3)
            com.blueair.core.model.Mode r6 = com.blueair.core.model.Mode.AUTO
            boolean r6 = r0.isInMode(r6)
            com.blueair.core.model.Mode r7 = com.blueair.core.model.Mode.NIGHT
            boolean r0 = r0.isInMode(r7)
            r7 = r2
            goto L_0x01a3
        L_0x0168:
            boolean r0 = r12 instanceof com.blueair.core.model.HasFanSpeed
            if (r0 == 0) goto L_0x0179
            r0 = r12
            com.blueair.core.model.HasFanSpeed r0 = (com.blueair.core.model.HasFanSpeed) r0
            com.blueair.core.model.AutoMode r0 = r0.getAutoMode()
            com.blueair.core.model.AutoMode r3 = com.blueair.core.model.AutoMode.ON
            if (r0 != r3) goto L_0x0179
            r6 = r1
            goto L_0x017a
        L_0x0179:
            r6 = r2
        L_0x017a:
            boolean r0 = r12 instanceof com.blueair.core.model.HasEcoMode
            if (r0 == 0) goto L_0x0189
            r0 = r12
            com.blueair.core.model.HasEcoMode r0 = (com.blueair.core.model.HasEcoMode) r0
            boolean r0 = r0.isEcoModeOn()
            if (r0 == 0) goto L_0x0189
            r7 = r1
            goto L_0x018a
        L_0x0189:
            r7 = r2
        L_0x018a:
            boolean r0 = r12 instanceof com.blueair.core.model.HasG4NightMode
            if (r0 == 0) goto L_0x0199
            r0 = r12
            com.blueair.core.model.HasG4NightMode r0 = (com.blueair.core.model.HasG4NightMode) r0
            boolean r0 = r0.isG4NightModeOn()
            if (r0 == 0) goto L_0x0199
            r0 = r1
            goto L_0x019a
        L_0x0199:
            r0 = r2
        L_0x019a:
            if (r6 != 0) goto L_0x01a2
            if (r0 != 0) goto L_0x01a2
            if (r7 != 0) goto L_0x01a2
            r3 = r1
            goto L_0x01a3
        L_0x01a2:
            r3 = r2
        L_0x01a3:
            int[] r8 = com.blueair.devicedetails.viewholder.DeviceNModeButtonHolder.WhenMappings.$EnumSwitchMapping$1
            int r9 = r11.ordinal()
            r8 = r8[r9]
            switch(r8) {
                case 1: goto L_0x01f1;
                case 2: goto L_0x01ef;
                case 3: goto L_0x01e4;
                case 4: goto L_0x01e4;
                case 5: goto L_0x01e2;
                case 6: goto L_0x01d5;
                case 7: goto L_0x01ca;
                case 8: goto L_0x01bd;
                case 9: goto L_0x01b0;
                default: goto L_0x01ae;
            }
        L_0x01ae:
            goto L_0x00c0
        L_0x01b0:
            boolean r14 = r12 instanceof com.blueair.core.model.HasChildLock
            if (r14 == 0) goto L_0x00c0
            com.blueair.core.model.HasChildLock r12 = (com.blueair.core.model.HasChildLock) r12
            boolean r12 = r12.isChildLockOn()
            if (r12 == 0) goto L_0x00c0
            goto L_0x01f2
        L_0x01bd:
            if (r14 == 0) goto L_0x00c0
            com.blueair.core.model.HasPetMainMode r12 = (com.blueair.core.model.HasPetMainMode) r12
            com.blueair.core.model.MainMode r14 = com.blueair.core.model.MainMode.SMART
            boolean r12 = r12.isInMainMode(r14)
            if (r12 == 0) goto L_0x00c0
            goto L_0x01f2
        L_0x01ca:
            boolean r14 = r12 instanceof com.blueair.core.model.HasDisinfection
            if (r14 == 0) goto L_0x00c0
            boolean r12 = com.blueair.core.model.DeviceKt.isDisinfectionOn(r12)
            if (r12 == 0) goto L_0x00c0
            goto L_0x01f2
        L_0x01d5:
            boolean r14 = r12 instanceof com.blueair.core.model.HasStandBy
            if (r14 == 0) goto L_0x00c0
            com.blueair.core.model.HasStandBy r12 = (com.blueair.core.model.HasStandBy) r12
            boolean r12 = r12.isStandByOn()
            if (r12 == 0) goto L_0x00c0
            goto L_0x01f2
        L_0x01e2:
            r1 = r7
            goto L_0x01f2
        L_0x01e4:
            boolean r12 = r12 instanceof com.blueair.core.model.DeviceNewClassic
            if (r12 == 0) goto L_0x01ed
            if (r6 != 0) goto L_0x01f2
            if (r7 == 0) goto L_0x00c0
            goto L_0x01f2
        L_0x01ed:
            r1 = r6
            goto L_0x01f2
        L_0x01ef:
            r1 = r0
            goto L_0x01f2
        L_0x01f1:
            r1 = r3
        L_0x01f2:
            com.blueair.devicedetails.databinding.HolderDeviceNModeButtonBinding r12 = r10.binding
            android.widget.LinearLayout r14 = r12.modeRoot
            r0 = r13 ^ 1
            r14.setEnabled(r0)
            com.blueair.viewcore.utils.ModeIcon r14 = com.blueair.viewcore.utils.ModeIcon.STANDBY
            if (r11 != r14) goto L_0x0206
            android.widget.TextView r14 = r12.modeText
            int r0 = com.blueair.viewcore.R.string.turn_on
            r14.setText(r0)
        L_0x0206:
            android.widget.TextView r14 = r12.modeText
            android.view.View r0 = r10.itemView
            android.content.res.Resources r0 = r0.getResources()
            if (r13 == 0) goto L_0x0213
            int r2 = com.blueair.viewcore.R.color.light_gray
            goto L_0x0215
        L_0x0213:
            int r2 = com.blueair.viewcore.R.color.colorPrimaryText
        L_0x0215:
            int r0 = r0.getColor(r2, r4)
            r14.setTextColor(r0)
            if (r1 == 0) goto L_0x022a
            if (r13 == 0) goto L_0x0225
            int r13 = r11.getOnIconDisabled()
            goto L_0x0235
        L_0x0225:
            int r13 = r11.getOnIcon()
            goto L_0x0235
        L_0x022a:
            if (r13 == 0) goto L_0x0231
            int r13 = r11.getOffIconDisabled()
            goto L_0x0235
        L_0x0231:
            int r13 = r11.getOffIcon()
        L_0x0235:
            androidx.appcompat.widget.AppCompatImageView r14 = r12.modeIcon
            r14.setImageResource(r13)
            if (r1 != 0) goto L_0x024a
            com.blueair.viewcore.utils.ModeIcon r13 = com.blueair.viewcore.utils.ModeIcon.STANDBY
            if (r11 != r13) goto L_0x0241
            goto L_0x024a
        L_0x0241:
            android.widget.TextView r11 = r12.modeText
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r5)
            com.blueair.viewcore.ViewExtensionsKt.unbold(r11)
            goto L_0x0252
        L_0x024a:
            android.widget.TextView r11 = r12.modeText
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r5)
            com.blueair.viewcore.ViewExtensionsKt.bold(r11)
        L_0x0252:
            android.widget.LinearLayout r11 = r12.modeRoot
            r11.setSelected(r1)
            return
        L_0x0258:
            com.blueair.devicedetails.databinding.HolderDeviceNModeButtonBinding r12 = r10.binding
            com.blueair.viewcore.utils.ModeIcon r13 = com.blueair.viewcore.utils.ModeIcon.STANDBY
            if (r11 != r13) goto L_0x028d
            android.widget.LinearLayout r13 = r12.modeRoot
            r13.setEnabled(r1)
            androidx.appcompat.widget.AppCompatImageView r13 = r12.modeIcon
            int r11 = r11.getOnIcon()
            r13.setImageResource(r11)
            android.widget.TextView r11 = r12.modeText
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r5)
            com.blueair.viewcore.ViewExtensionsKt.unbold(r11)
            android.widget.TextView r11 = r12.modeText
            int r13 = com.blueair.viewcore.R.string.turn_on
            r11.setText(r13)
            android.widget.TextView r11 = r12.modeText
            android.view.View r12 = r10.itemView
            android.content.res.Resources r12 = r12.getResources()
            int r13 = com.blueair.viewcore.R.color.colorPrimaryText
            int r12 = r12.getColor(r13, r4)
            r11.setTextColor(r12)
            return
        L_0x028d:
            android.widget.LinearLayout r13 = r12.modeRoot
            r13.setSelected(r2)
            android.widget.LinearLayout r13 = r12.modeRoot
            r13.setEnabled(r2)
            androidx.appcompat.widget.AppCompatImageView r13 = r12.modeIcon
            int r11 = r11.getOffIconDisabled()
            r13.setImageResource(r11)
            android.widget.TextView r11 = r12.modeText
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r5)
            com.blueair.viewcore.ViewExtensionsKt.unbold(r11)
            android.widget.TextView r11 = r12.modeText
            android.view.View r12 = r10.itemView
            android.content.res.Resources r12 = r12.getResources()
            int r13 = com.blueair.viewcore.R.color.smokegray
            int r12 = r12.getColor(r13, r4)
            r11.setTextColor(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceNModeButtonHolder.updateMode(com.blueair.viewcore.utils.ModeIcon, com.blueair.core.model.Device, com.blueair.core.model.MainMode, com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
        if (r5.isStandByOn() == true) goto L_0x00b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateMainMode(com.blueair.viewcore.utils.ModeIcon r7, com.blueair.core.model.Device r8, com.blueair.core.model.MainMode r9, com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode r10) {
        /*
            r6 = this;
            java.lang.String r0 = "mainMode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.blueair.devicedetails.databinding.HolderDeviceNModeButtonBinding r0 = r6.binding
            android.widget.TextView r0 = r0.modeText
            int r1 = r7.getText()
            r0.setText(r1)
            r0 = 0
            r1 = 1
            if (r8 == 0) goto L_0x0020
            boolean r2 = r8.isUsDevice()
            if (r2 != r1) goto L_0x0020
            com.blueair.viewcore.utils.ModeIcon r2 = com.blueair.viewcore.utils.ModeIcon.HEAT
            if (r7 != r2) goto L_0x0020
            r2 = r1
            goto L_0x0021
        L_0x0020:
            r2 = r0
        L_0x0021:
            com.blueair.devicedetails.databinding.HolderDeviceNModeButtonBinding r3 = r6.binding
            androidx.appcompat.widget.AppCompatImageView r3 = r3.infoView
            java.lang.String r4 = "infoView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            android.view.View r3 = (android.view.View) r3
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r3, r2)
            java.lang.String r3 = "modeText"
            r4 = 0
            if (r8 == 0) goto L_0x00b4
            if (r9 != 0) goto L_0x0049
            boolean r5 = r8 instanceof com.blueair.core.model.HasStandBy
            if (r5 == 0) goto L_0x003e
            r5 = r8
            com.blueair.core.model.HasStandBy r5 = (com.blueair.core.model.HasStandBy) r5
            goto L_0x003f
        L_0x003e:
            r5 = r4
        L_0x003f:
            if (r5 == 0) goto L_0x0049
            boolean r5 = r5.isStandByOn()
            if (r5 != r1) goto L_0x0049
            goto L_0x00b4
        L_0x0049:
            com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode r5 = com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY
            if (r10 != r5) goto L_0x004f
            goto L_0x00b4
        L_0x004f:
            com.blueair.core.model.MainMode r10 = r7.toMainMode()
            if (r9 != 0) goto L_0x0065
            boolean r9 = r8 instanceof com.blueair.core.model.HasCombo3in1MainMode
            if (r9 == 0) goto L_0x005c
            com.blueair.core.model.HasCombo3in1MainMode r8 = (com.blueair.core.model.HasCombo3in1MainMode) r8
            goto L_0x005d
        L_0x005c:
            r8 = r4
        L_0x005d:
            if (r8 == 0) goto L_0x0064
            com.blueair.core.model.MainMode r9 = r8.mainMode()
            goto L_0x0065
        L_0x0064:
            r9 = r4
        L_0x0065:
            if (r10 != r9) goto L_0x0068
            r0 = r1
        L_0x0068:
            com.blueair.devicedetails.databinding.HolderDeviceNModeButtonBinding r8 = r6.binding
            android.widget.LinearLayout r9 = r8.modeRoot
            r10 = r2 ^ 1
            r9.setEnabled(r10)
            android.widget.TextView r9 = r8.modeText
            android.view.View r10 = r6.itemView
            android.content.res.Resources r10 = r10.getResources()
            if (r2 == 0) goto L_0x007e
            int r1 = com.blueair.viewcore.R.color.light_gray
            goto L_0x0080
        L_0x007e:
            int r1 = com.blueair.viewcore.R.color.colorPrimaryText
        L_0x0080:
            int r10 = r10.getColor(r1, r4)
            r9.setTextColor(r10)
            if (r0 == 0) goto L_0x0095
            if (r2 == 0) goto L_0x0090
            int r7 = r7.getOnIconDisabled()
            goto L_0x00a0
        L_0x0090:
            int r7 = r7.getOnIcon()
            goto L_0x00a0
        L_0x0095:
            if (r2 == 0) goto L_0x009c
            int r7 = r7.getOffIconDisabled()
            goto L_0x00a0
        L_0x009c:
            int r7 = r7.getOffIcon()
        L_0x00a0:
            androidx.appcompat.widget.AppCompatImageView r9 = r8.modeIcon
            r9.setImageResource(r7)
            android.widget.TextView r7 = r8.modeText
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r3)
            if (r0 == 0) goto L_0x00b0
            com.blueair.viewcore.ViewExtensionsKt.bold(r7)
            return
        L_0x00b0:
            com.blueair.viewcore.ViewExtensionsKt.unbold(r7)
            return
        L_0x00b4:
            com.blueair.devicedetails.databinding.HolderDeviceNModeButtonBinding r8 = r6.binding
            android.widget.LinearLayout r9 = r8.modeRoot
            r9.setEnabled(r0)
            androidx.appcompat.widget.AppCompatImageView r9 = r8.modeIcon
            int r7 = r7.getOffIconDisabled()
            r9.setImageResource(r7)
            android.widget.TextView r7 = r8.modeText
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r3)
            com.blueair.viewcore.ViewExtensionsKt.unbold(r7)
            android.widget.TextView r7 = r8.modeText
            android.view.View r8 = r6.itemView
            android.content.res.Resources r8 = r8.getResources()
            int r9 = com.blueair.viewcore.R.color.smokegray
            int r8 = r8.getColor(r9, r4)
            r7.setTextColor(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceNModeButtonHolder.updateMainMode(com.blueair.viewcore.utils.ModeIcon, com.blueair.core.model.Device, com.blueair.core.model.MainMode, com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel$PurifierMode):void");
    }
}
