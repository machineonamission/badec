package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.databinding.HolderDeviceSensorCardBinding;
import com.blueair.viewcore.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJE\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u00072\b\b\u0001\u0010\u001b\u001a\u00020\u0007H\u0002J\u0012\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u0007H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSensorCardHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceSensorCardBinding;", "isCelsius", "", "normalTintColor", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceSensorCardBinding;ZI)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceSensorCardBinding;", "update", "", "device", "Lcom/blueair/core/model/HasSensorData;", "sensorType", "Lcom/blueair/core/model/SensorType;", "sensorValue", "", "updateTime", "", "isStandByOn", "isOffline", "isSelected", "(Lcom/blueair/core/model/HasSensorData;Lcom/blueair/core/model/SensorType;Ljava/lang/Float;JZZZ)V", "getColor", "colorRes", "getString", "", "stringRes", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSensorCardHolder.kt */
public final class DeviceSensorCardHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceSensorCardBinding binding;
    private final boolean isCelsius;
    private final int normalTintColor;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSensorCardHolder.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.core.model.SensorType[] r0 = com.blueair.core.model.SensorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM1     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM25     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM10     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.HUM     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.TMP     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.VOC     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceSensorCardHolder.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceSensorCardHolder(HolderDeviceSensorCardBinding holderDeviceSensorCardBinding, boolean z, int i) {
        super(holderDeviceSensorCardBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderDeviceSensorCardBinding, "binding");
        this.binding = holderDeviceSensorCardBinding;
        this.isCelsius = z;
        this.normalTintColor = i;
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        ConstraintLayout constraintLayout = holderDeviceSensorCardBinding.cardContainer;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "cardContainer");
        ViewUtils.setAccessibilityDelegate$default(viewUtils, constraintLayout, Reflection.getOrCreateKotlinClass(Button.class), (String) null, (Function2) null, 12, (Object) null);
    }

    public final HolderDeviceSensorCardBinding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSensorCardHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceSensorCardHolder;", "parentView", "Landroid/view/ViewGroup;", "isCelsius", "", "normalTintColor", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSensorCardHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceSensorCardHolder newInstance(ViewGroup viewGroup, boolean z, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderDeviceSensorCardBinding inflate = HolderDeviceSensorCardBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceSensorCardHolder(inflate, z, i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void update(com.blueair.core.model.HasSensorData r6, com.blueair.core.model.SensorType r7, java.lang.Float r8, long r9, boolean r11, boolean r12, boolean r13) {
        /*
            r5 = this;
            java.lang.String r0 = "device"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "sensorType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.blueair.devicedetails.databinding.HolderDeviceSensorCardBinding r0 = r5.binding
            androidx.constraintlayout.widget.ConstraintLayout r1 = r0.cardContainer
            int r2 = com.blueair.viewcore.R.drawable.rounded_rectangle_white90_r16
            r1.setBackgroundResource(r2)
            int r1 = r5.normalTintColor
            if (r1 == 0) goto L_0x0022
            androidx.constraintlayout.widget.ConstraintLayout r1 = r0.cardContainer
            int r2 = r5.normalTintColor
            android.content.res.ColorStateList r2 = android.content.res.ColorStateList.valueOf(r2)
            r1.setBackgroundTintList(r2)
        L_0x0022:
            android.widget.ImageView r1 = r0.sensorIcon
            int[] r2 = com.blueair.devicedetails.viewholder.DeviceSensorCardHolder.WhenMappings.$EnumSwitchMapping$0
            int r3 = r7.ordinal()
            r2 = r2[r3]
            switch(r2) {
                case 1: goto L_0x0041;
                case 2: goto L_0x003e;
                case 3: goto L_0x003b;
                case 4: goto L_0x0038;
                case 5: goto L_0x0035;
                case 6: goto L_0x0032;
                default: goto L_0x002f;
            }
        L_0x002f:
            int r2 = com.blueair.viewcore.R.drawable.ic_pm25
            goto L_0x0043
        L_0x0032:
            int r2 = com.blueair.viewcore.R.drawable.ic_tvoc
            goto L_0x0043
        L_0x0035:
            int r2 = com.blueair.viewcore.R.drawable.ic_tmp
            goto L_0x0043
        L_0x0038:
            int r2 = com.blueair.viewcore.R.drawable.ic_hum
            goto L_0x0043
        L_0x003b:
            int r2 = com.blueair.viewcore.R.drawable.ic_pm10
            goto L_0x0043
        L_0x003e:
            int r2 = com.blueair.viewcore.R.drawable.ic_pm25
            goto L_0x0043
        L_0x0041:
            int r2 = com.blueair.viewcore.R.drawable.ic_pm1
        L_0x0043:
            r1.setImageResource(r2)
            android.widget.TextView r1 = r0.sensorLabel
            com.blueair.graph.utils.GraphUiUtils r2 = com.blueair.graph.utils.GraphUiUtils.INSTANCE
            int r2 = r2.getSensorName(r7)
            r1.setText(r2)
            r1 = 0
            if (r12 == 0) goto L_0x006a
            com.blueair.graph.utils.GraphUiUtils r6 = com.blueair.graph.utils.GraphUiUtils.INSTANCE
            int r6 = r6.getSeverityDot6Null()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            int r8 = com.blueair.viewcore.R.string.offline_label
            java.lang.String r8 = r5.getString(r8)
            int r9 = com.blueair.viewcore.R.color.surface_dark_55
            int r10 = com.blueair.viewcore.R.color.surface_dark_55
            goto L_0x0127
        L_0x006a:
            if (r11 == 0) goto L_0x007e
            com.blueair.graph.utils.GraphUiUtils r6 = com.blueair.graph.utils.GraphUiUtils.INSTANCE
            int r6 = r6.getSeverityDot6Null()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            int r9 = com.blueair.viewcore.R.color.surface_dark_65
            int r10 = com.blueair.viewcore.R.color.colorPrimaryText
            java.lang.String r8 = "-"
            goto L_0x0127
        L_0x007e:
            if (r8 == 0) goto L_0x0113
            long r11 = java.lang.System.currentTimeMillis()
            long r11 = r11 - r9
            r9 = 20000(0x4e20, double:9.8813E-320)
            int r9 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x008d
            goto L_0x0113
        L_0x008d:
            int[] r9 = com.blueair.devicedetails.viewholder.DeviceSensorCardHolder.WhenMappings.$EnumSwitchMapping$0
            int r10 = r7.ordinal()
            r9 = r9[r10]
            r10 = 4
            if (r9 == r10) goto L_0x00f7
            r10 = 5
            if (r9 == r10) goto L_0x00c2
            com.blueair.core.util.IndoorAirRatingRanges$Companion r9 = com.blueair.core.util.IndoorAirRatingRanges.Companion
            com.blueair.core.util.IndoorAirRatingRanges r6 = r9.instance(r6)
            float r9 = r8.floatValue()
            int r6 = r6.getRangePosition(r9, r7)
            com.blueair.graph.utils.GraphUiUtils r9 = com.blueair.graph.utils.GraphUiUtils.INSTANCE
            java.util.List r9 = r9.getSeverityDots6()
            java.lang.Object r6 = kotlin.collections.CollectionsKt.getOrNull(r9, r6)
            java.lang.Integer r6 = (java.lang.Integer) r6
            float r8 = r8.floatValue()
            int r8 = kotlin.math.MathKt.roundToInt((float) r8)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            goto L_0x0123
        L_0x00c2:
            boolean r6 = r5.isCelsius
            if (r6 == 0) goto L_0x00cb
            float r6 = r8.floatValue()
            goto L_0x00d5
        L_0x00cb:
            com.blueair.core.model.DeviceData$Companion r6 = com.blueair.core.model.DeviceData.Companion
            float r8 = r8.floatValue()
            float r6 = r6.convertCelsiusToFahrenheit((float) r8)
        L_0x00d5:
            int r6 = kotlin.math.MathKt.roundToInt((float) r6)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r6)
            r6 = 176(0xb0, float:2.47E-43)
            r8.append(r6)
            boolean r6 = r5.isCelsius
            if (r6 == 0) goto L_0x00ed
            r6 = 67
            goto L_0x00ef
        L_0x00ed:
            r6 = 70
        L_0x00ef:
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            goto L_0x0110
        L_0x00f7:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            float r8 = r8.floatValue()
            int r8 = kotlin.math.MathKt.roundToInt((float) r8)
            r6.append(r8)
            r8 = 37
            r6.append(r8)
            java.lang.String r6 = r6.toString()
        L_0x0110:
            r8 = r6
            r6 = r1
            goto L_0x0123
        L_0x0113:
            com.blueair.graph.utils.GraphUiUtils r6 = com.blueair.graph.utils.GraphUiUtils.INSTANCE
            int r6 = r6.getSeverityDot6Null()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            int r8 = com.blueair.viewcore.R.string.label_reading
            java.lang.String r8 = r5.getString(r8)
        L_0x0123:
            int r9 = com.blueair.viewcore.R.color.surface_dark_65
            int r10 = com.blueair.viewcore.R.color.colorPrimaryText
        L_0x0127:
            r11 = 0
            java.lang.String r12 = "aqiIcon"
            if (r6 == 0) goto L_0x0157
            r2 = 2
            com.blueair.core.model.SensorType[] r2 = new com.blueair.core.model.SensorType[r2]
            com.blueair.core.model.SensorType r3 = com.blueair.core.model.SensorType.HUM
            r2[r11] = r3
            com.blueair.core.model.SensorType r3 = com.blueair.core.model.SensorType.TMP
            r4 = 1
            r2[r4] = r3
            java.util.Set r2 = kotlin.collections.SetsKt.setOf(r2)
            boolean r2 = r2.contains(r7)
            if (r2 == 0) goto L_0x0143
            goto L_0x0157
        L_0x0143:
            android.widget.ImageView r11 = r0.aqiIcon
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            android.view.View r11 = (android.view.View) r11
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r11, r4)
            android.widget.ImageView r11 = r0.aqiIcon
            int r6 = r6.intValue()
            r11.setImageResource(r6)
            goto L_0x0161
        L_0x0157:
            android.widget.ImageView r6 = r0.aqiIcon
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r12)
            android.view.View r6 = (android.view.View) r6
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r6, r11)
        L_0x0161:
            android.widget.TextView r6 = r0.aqiValue
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r6.setText(r8)
            android.widget.TextView r6 = r0.sensorLabel
            int r8 = r5.getColor(r9)
            r6.setTextColor(r8)
            android.widget.TextView r6 = r0.aqiValue
            int r8 = r5.getColor(r10)
            r6.setTextColor(r8)
            if (r13 == 0) goto L_0x01c2
            androidx.constraintlayout.widget.ConstraintLayout r6 = r0.cardContainer
            int r8 = com.blueair.viewcore.R.drawable.rounded_rectangle_primary_r16
            r6.setBackgroundResource(r8)
            androidx.constraintlayout.widget.ConstraintLayout r6 = r0.cardContainer
            r6.setBackgroundTintList(r1)
            android.widget.ImageView r6 = r0.sensorIcon
            int[] r8 = com.blueair.devicedetails.viewholder.DeviceSensorCardHolder.WhenMappings.$EnumSwitchMapping$0
            int r7 = r7.ordinal()
            r7 = r8[r7]
            switch(r7) {
                case 1: goto L_0x01a7;
                case 2: goto L_0x01a4;
                case 3: goto L_0x01a1;
                case 4: goto L_0x019e;
                case 5: goto L_0x019b;
                case 6: goto L_0x0198;
                default: goto L_0x0195;
            }
        L_0x0195:
            int r7 = com.blueair.viewcore.R.drawable.ic_pm25_selected
            goto L_0x01a9
        L_0x0198:
            int r7 = com.blueair.viewcore.R.drawable.ic_tvoc_selected
            goto L_0x01a9
        L_0x019b:
            int r7 = com.blueair.viewcore.R.drawable.ic_tmp_selected
            goto L_0x01a9
        L_0x019e:
            int r7 = com.blueair.viewcore.R.drawable.ic_hum_selected
            goto L_0x01a9
        L_0x01a1:
            int r7 = com.blueair.viewcore.R.drawable.ic_pm10_selected
            goto L_0x01a9
        L_0x01a4:
            int r7 = com.blueair.viewcore.R.drawable.ic_pm25_selected
            goto L_0x01a9
        L_0x01a7:
            int r7 = com.blueair.viewcore.R.drawable.ic_pm1_selected
        L_0x01a9:
            r6.setImageResource(r7)
            android.widget.TextView r6 = r0.sensorLabel
            int r7 = com.blueair.viewcore.R.color.white_65
            int r7 = r5.getColor(r7)
            r6.setTextColor(r7)
            android.widget.TextView r6 = r0.aqiValue
            int r7 = com.blueair.viewcore.R.color.white
            int r7 = r5.getColor(r7)
            r6.setTextColor(r7)
        L_0x01c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceSensorCardHolder.update(com.blueair.core.model.HasSensorData, com.blueair.core.model.SensorType, java.lang.Float, long, boolean, boolean, boolean):void");
    }

    private final int getColor(int i) {
        return this.binding.getRoot().getContext().getColor(i);
    }

    private final String getString(int i) {
        String string = this.binding.getRoot().getContext().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
