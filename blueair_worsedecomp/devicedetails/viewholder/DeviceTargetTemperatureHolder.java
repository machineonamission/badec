package com.blueair.devicedetails.viewholder;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.databinding.HolderDeviceTargetTemperatureBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001%BF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010$\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTargetTemperatureHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceTargetTemperatureBinding;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onTemperatureSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "temperature", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceTargetTemperatureBinding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceTargetTemperatureBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "()Z", "value", "isEcoMode", "setEcoMode", "(Z)V", "temperatureDegree", "", "temperatureUnit", "startTemp", "", "endTemp", "isTempC", "enableView", "enable", "refreshTempUnit", "update", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceTargetTemperatureHolder.kt */
public final class DeviceTargetTemperatureHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceTargetTemperatureBinding binding;
    private final Device device;
    private int endTemp;
    private boolean isEcoMode;
    private final boolean isInSchedule;
    /* access modifiers changed from: private */
    public boolean isTempC;
    /* access modifiers changed from: private */
    public final Function1<Double, Unit> onTemperatureSetListener;
    private int startTemp;
    /* access modifiers changed from: private */
    public final CharSequence temperatureDegree;
    /* access modifiers changed from: private */
    public CharSequence temperatureUnit;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceTargetTemperatureHolder.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.blueair.core.model.ApSubMode[] r0 = com.blueair.core.model.ApSubMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.ApSubMode r1 = com.blueair.core.model.ApSubMode.ECO     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.ApSubMode r1 = com.blueair.core.model.ApSubMode.AUTO     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceTargetTemperatureHolder.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceTargetTemperatureHolder(HolderDeviceTargetTemperatureBinding holderDeviceTargetTemperatureBinding, Device device2, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(holderDeviceTargetTemperatureBinding, device2, (i & 4) != 0 ? false : z, function1);
    }

    public final HolderDeviceTargetTemperatureBinding getBinding() {
        return this.binding;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final boolean isInSchedule() {
        return this.isInSchedule;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¨\u0006\u0013"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTargetTemperatureHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceTargetTemperatureHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onTemperatureSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "temperature", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceTargetTemperatureHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DeviceTargetTemperatureHolder newInstance$default(Companion companion, ViewGroup viewGroup, Device device, boolean z, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.newInstance(viewGroup, device, z, function1);
        }

        public final DeviceTargetTemperatureHolder newInstance(ViewGroup viewGroup, Device device, boolean z, Function1<? super Double, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onTemperatureSetListener");
            HolderDeviceTargetTemperatureBinding inflate = HolderDeviceTargetTemperatureBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceTargetTemperatureHolder(inflate, device, z, function1);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceTargetTemperatureHolder(com.blueair.devicedetails.databinding.HolderDeviceTargetTemperatureBinding r5, com.blueair.core.model.Device r6, boolean r7, kotlin.jvm.functions.Function1<? super java.lang.Double, kotlin.Unit> r8) {
        /*
            r4 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "onTemperatureSetListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            android.widget.FrameLayout r0 = r5.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r4.<init>(r0)
            r4.binding = r5
            r4.device = r6
            r4.isInSchedule = r7
            r4.onTemperatureSetListener = r8
            boolean r8 = r6 instanceof com.blueair.core.model.HasCombo3in1MainMode
            r0 = 1
            if (r8 == 0) goto L_0x0032
            r8 = r6
            com.blueair.core.model.HasCombo3in1MainMode r8 = (com.blueair.core.model.HasCombo3in1MainMode) r8
            com.blueair.core.model.ApSubMode r1 = com.blueair.core.model.ApSubMode.ECO
            boolean r8 = r8.isInSubMode(r1)
            if (r8 == 0) goto L_0x0032
            r8 = r0
            goto L_0x0033
        L_0x0032:
            r8 = 0
        L_0x0033:
            r4.isEcoMode = r8
            android.view.View r8 = r4.itemView
            android.content.Context r8 = r8.getContext()
            int r1 = com.blueair.viewcore.R.string.temperature_degree
            java.lang.CharSequence r8 = r8.getText(r1)
            java.lang.String r1 = "getText(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            r4.temperatureDegree = r8
            android.view.View r2 = r4.itemView
            android.content.Context r2 = r2.getContext()
            int r3 = com.blueair.viewcore.R.string.temperature_unit_c
            java.lang.CharSequence r2 = r2.getText(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            r4.temperatureUnit = r2
            r1 = 15
            r4.startTemp = r1
            r1 = 24
            r4.endTemp = r1
            r4.isTempC = r0
            if (r6 == 0) goto L_0x0068
            r4.refreshTempUnit(r6)
        L_0x0068:
            com.blueair.viewcore.view.AccessibleSeekBar r6 = r5.seekbar
            com.blueair.devicedetails.viewholder.DeviceTargetTemperatureHolder$2$1 r0 = new com.blueair.devicedetails.viewholder.DeviceTargetTemperatureHolder$2$1
            r0.<init>(r4)
            android.widget.SeekBar$OnSeekBarChangeListener r0 = (android.widget.SeekBar.OnSeekBarChangeListener) r0
            r6.setOnSeekBarChangeListener(r0)
            int r0 = r4.endTemp
            r6.setMax(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 < r1) goto L_0x0084
            int r0 = r4.startTemp
            r6.setMin(r0)
        L_0x0084:
            boolean r0 = r4.isEcoMode
            if (r0 == 0) goto L_0x008b
            int r0 = com.blueair.viewcore.R.drawable.progressbar_slim_gradient_78
            goto L_0x008d
        L_0x008b:
            int r0 = com.blueair.viewcore.R.drawable.progressbar_slim_gradient_32
        L_0x008d:
            android.content.Context r1 = r6.getContext()
            android.graphics.drawable.Drawable r0 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r0)
            r6.setProgressDrawable(r0)
            android.widget.TextView r6 = r5.startTemp
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = r4.startTemp
            r0.append(r1)
            r0.append(r8)
            java.lang.CharSequence r1 = r4.temperatureUnit
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.setText(r0)
            android.widget.TextView r6 = r5.endTemp
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = r4.endTemp
            r0.append(r1)
            r0.append(r8)
            java.lang.CharSequence r8 = r4.temperatureUnit
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r6.setText(r8)
            if (r7 == 0) goto L_0x00e5
            androidx.constraintlayout.widget.ConstraintLayout r5 = r5.contentContainer
            android.view.View r6 = r4.itemView
            android.content.Context r6 = r6.getContext()
            int r7 = com.blueair.viewcore.R.drawable.rounded_square_anti_flash_blue_r8
            android.graphics.drawable.Drawable r6 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r6, r7)
            r5.setBackground(r6)
        L_0x00e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceTargetTemperatureHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceTargetTemperatureBinding, com.blueair.core.model.Device, boolean, kotlin.jvm.functions.Function1):void");
    }

    private final void setEcoMode(boolean z) {
        this.isEcoMode = z;
        this.endTemp = z ? 24 : 37;
    }

    private final void enableView(boolean z) {
        AccessibleSeekBar accessibleSeekBar = this.binding.seekbar;
        Intrinsics.checkNotNullExpressionValue(accessibleSeekBar, "seekbar");
        ViewExtensionsKt.show(accessibleSeekBar, z);
        TextView textView = this.binding.startTemp;
        Intrinsics.checkNotNullExpressionValue(textView, "startTemp");
        ViewExtensionsKt.show(textView, z);
        TextView textView2 = this.binding.endTemp;
        Intrinsics.checkNotNullExpressionValue(textView2, "endTemp");
        ViewExtensionsKt.show(textView2, z);
    }

    private final void refreshTempUnit(Device device2) {
        int i = this.isEcoMode ? 24 : 37;
        boolean isCelsiusUnit = DeviceKt.isCelsiusUnit(device2);
        this.isTempC = isCelsiusUnit;
        if (isCelsiusUnit) {
            this.startTemp = 15;
            this.endTemp = i;
            CharSequence text = this.itemView.getContext().getText(R.string.temperature_unit_c);
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            this.temperatureUnit = text;
        } else {
            this.startTemp = DeviceData.Companion.convertCelsiusToFahrenheit(15);
            this.endTemp = DeviceData.Companion.convertCelsiusToFahrenheit(i);
            CharSequence text2 = this.itemView.getContext().getText(R.string.temperature_unit_f);
            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
            this.temperatureUnit = text2;
        }
        AccessibleSeekBar accessibleSeekBar = this.binding.seekbar;
        accessibleSeekBar.setMax(this.endTemp);
        if (Build.VERSION.SDK_INT >= 26) {
            accessibleSeekBar.setMin(this.startTemp);
        }
        TextView textView = this.binding.startTemp;
        StringBuilder sb = new StringBuilder();
        sb.append(this.startTemp);
        sb.append(this.temperatureDegree);
        sb.append(this.temperatureUnit);
        textView.setText(sb.toString());
        TextView textView2 = this.binding.endTemp;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.endTemp);
        sb2.append(this.temperatureDegree);
        sb2.append(this.temperatureUnit);
        textView2.setText(sb2.toString());
    }

    public void update(Device device2) {
        Intrinsics.checkNotNullParameter(device2, "device");
        if (device2 instanceof HasCombo3in1MainMode) {
            refreshTempUnit(device2);
            boolean isCelsiusUnit = DeviceKt.isCelsiusUnit(device2);
            HasCombo3in1MainMode hasCombo3in1MainMode = (HasCombo3in1MainMode) device2;
            int i = WhenMappings.$EnumSwitchMapping$0[hasCombo3in1MainMode.currentSubMode().ordinal()];
            if (i == 1) {
                update(isCelsiusUnit ? hasCombo3in1MainMode.getHeatEcoTmp() : DeviceData.Companion.convertCelsiusToFahrenheit(hasCombo3in1MainMode.getHeatEcoTmp()));
            } else if (i == 2) {
                update(isCelsiusUnit ? hasCombo3in1MainMode.getHeatAutoTmp() : DeviceData.Companion.convertCelsiusToFahrenheit(hasCombo3in1MainMode.getHeatAutoTmp()));
            }
            enableView(!(device2.isUsDevice() && hasCombo3in1MainMode.isInMainMode(MainMode.HEAT)));
        }
    }

    public final void update(double d) {
        int coerceIn = RangesKt.coerceIn(MathKt.roundToInt(d), this.startTemp, this.endTemp);
        this.binding.seekbar.setProgress(coerceIn);
        TextView textView = this.binding.progressText;
        StringBuilder sb = new StringBuilder();
        sb.append(coerceIn);
        sb.append(this.temperatureDegree);
        sb.append(this.temperatureUnit);
        textView.setText(sb.toString());
    }
}
