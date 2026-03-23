package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasOscillation;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.databinding.HolderDeviceOscillationBinding;
import com.blueair.viewcore.R;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceOscillationHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceOscillationBinding;", "isInSchedule", "", "onOscillationSwitchListener", "Lkotlin/Function1;", "", "onOpenOscillationListener", "Lkotlin/Function0;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceOscillationBinding;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceOscillationBinding;", "()Z", "update", "device", "Lcom/blueair/core/model/Device;", "disableSettings", "disabled", "allowDirectionSetting", "isOscillationEnabled", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceOscillationHolder.kt */
public final class DeviceOscillationHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceOscillationBinding binding;
    private final boolean isInSchedule;
    private final Function0<Unit> onOpenOscillationListener;
    private final Function1<Boolean, Unit> onOscillationSwitchListener;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceOscillationHolder.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.core.model.OscillationDirection[] r0 = com.blueair.core.model.OscillationDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.OscillationDirection r1 = com.blueair.core.model.OscillationDirection.STRAIGHT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.OscillationDirection r1 = com.blueair.core.model.OscillationDirection.LEFT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.OscillationDirection r1 = com.blueair.core.model.OscillationDirection.RIGHT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceOscillationHolder.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceOscillationHolder(HolderDeviceOscillationBinding holderDeviceOscillationBinding, boolean z, Function1 function1, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(holderDeviceOscillationBinding, (i & 2) != 0 ? false : z, function1, function0);
    }

    public final HolderDeviceOscillationBinding getBinding() {
        return this.binding;
    }

    public final boolean isInSchedule() {
        return this.isInSchedule;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceOscillationHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceOscillationHolder;", "parentView", "Landroid/view/ViewGroup;", "isInSchedule", "", "onOscillationSwitchListener", "Lkotlin/Function1;", "", "onOpenOscillationListener", "Lkotlin/Function0;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceOscillationHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DeviceOscillationHolder newInstance$default(Companion companion, ViewGroup viewGroup, boolean z, Function1 function1, Function0 function0, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.newInstance(viewGroup, z, function1, function0);
        }

        public final DeviceOscillationHolder newInstance(ViewGroup viewGroup, boolean z, Function1<? super Boolean, Unit> function1, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onOscillationSwitchListener");
            Intrinsics.checkNotNullParameter(function0, "onOpenOscillationListener");
            HolderDeviceOscillationBinding inflate = HolderDeviceOscillationBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            inflate.fanView.setInAttribute(true);
            Intrinsics.checkNotNullExpressionValue(inflate, "apply(...)");
            return new DeviceOscillationHolder(inflate, z, function1, function0);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceOscillationHolder(com.blueair.devicedetails.databinding.HolderDeviceOscillationBinding r3, boolean r4, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r5, kotlin.jvm.functions.Function0<kotlin.Unit> r6) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onOscillationSwitchListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "onOpenOscillationListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            android.widget.FrameLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r2.<init>(r0)
            r2.binding = r3
            r2.isInSchedule = r4
            r2.onOscillationSwitchListener = r5
            r2.onOpenOscillationListener = r6
            com.blueair.viewcore.view.SwitchCompat r5 = r3.switchBtn
            com.blueair.devicedetails.viewholder.DeviceOscillationHolder$$ExternalSyntheticLambda0 r6 = new com.blueair.devicedetails.viewholder.DeviceOscillationHolder$$ExternalSyntheticLambda0
            r6.<init>(r2)
            r5.setOnCheckedChangeListener(r6)
            androidx.constraintlayout.widget.ConstraintLayout r5 = r3.contentOscillationSettings
            com.blueair.devicedetails.viewholder.DeviceOscillationHolder$$ExternalSyntheticLambda1 r6 = new com.blueair.devicedetails.viewholder.DeviceOscillationHolder$$ExternalSyntheticLambda1
            r6.<init>(r2)
            r5.setOnClickListener(r6)
            android.view.View r5 = r3.spacer1
            java.lang.String r6 = "spacer1"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r6 = r4 ^ 1
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r5, r6)
            android.view.View r5 = r3.spacer2
            java.lang.String r6 = "spacer2"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r6 = r4 ^ 1
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r5, r6)
            androidx.constraintlayout.widget.ConstraintLayout r5 = r3.contentOscillationFanView
            java.lang.String r6 = "contentOscillationFanView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            android.view.View r5 = (android.view.View) r5
            r6 = r4 ^ 1
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r5, r6)
            androidx.constraintlayout.widget.ConstraintLayout r5 = r3.contentOscillationSettings
            java.lang.String r6 = "contentOscillationSettings"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            android.view.View r5 = (android.view.View) r5
            r6 = r4 ^ 1
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r5, r6)
            if (r4 == 0) goto L_0x00a4
            android.widget.LinearLayout r4 = r3.contentContainer
            android.view.View r5 = r2.itemView
            android.content.Context r5 = r5.getContext()
            int r6 = com.blueair.viewcore.R.drawable.rounded_square_anti_flash_blue_r8
            android.graphics.drawable.Drawable r5 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r5, r6)
            r4.setBackground(r5)
            android.view.View r4 = r2.itemView
            android.content.Context r4 = r4.getContext()
            android.content.res.Resources r4 = r4.getResources()
            int r5 = com.blueair.viewcore.R.dimen.device_details_humidifier_margin_horizontal
            int r4 = r4.getDimensionPixelSize(r5)
            androidx.constraintlayout.widget.ConstraintLayout r3 = r3.contentTitle
            java.lang.String r5 = "contentTitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            android.view.View r3 = (android.view.View) r3
            int r5 = r3.getPaddingTop()
            int r6 = r3.getPaddingBottom()
            r3.setPadding(r4, r5, r4, r6)
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceOscillationHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceOscillationBinding, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0):void");
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceOscillationHolder deviceOscillationHolder, CompoundButton compoundButton, boolean z) {
        deviceOscillationHolder.onOscillationSwitchListener.invoke(Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(DeviceOscillationHolder deviceOscillationHolder, View view) {
        deviceOscillationHolder.onOpenOscillationListener.invoke();
    }

    public void update(Device device) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(device, "device");
        if (device instanceof HasOscillation) {
            HolderDeviceOscillationBinding holderDeviceOscillationBinding = this.binding;
            HasOscillation hasOscillation = (HasOscillation) device;
            holderDeviceOscillationBinding.switchBtn.setCheckedSilence(hasOscillation.isOscillationEnabled());
            holderDeviceOscillationBinding.fanView.animateFanAngles(hasOscillation.getOscillationAngle(), hasOscillation.oscillationDirection());
            int i3 = WhenMappings.$EnumSwitchMapping$0[hasOscillation.oscillationDirection().ordinal()];
            boolean z = true;
            if (i3 == 1) {
                i2 = R.drawable.ic_arrow_straight_off;
                i = R.string.oscillation_direction_straight;
            } else if (i3 == 2) {
                i2 = R.drawable.ic_arrow_left_off;
                i = R.string.oscillation_direction_left;
            } else if (i3 == 3) {
                i2 = R.drawable.ic_arrow_right_off;
                i = R.string.oscillation_direction_right;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            holderDeviceOscillationBinding.angleDirection.setImageResource(i2);
            holderDeviceOscillationBinding.direction.setText(i);
            TextView textView = holderDeviceOscillationBinding.angle;
            StringBuilder sb = new StringBuilder();
            sb.append(hasOscillation.getOscillationAngle());
            sb.append(Typography.degree);
            textView.setText(sb.toString());
            holderDeviceOscillationBinding.speed.setText(String.valueOf(hasOscillation.oscillationFanSpeed().getDisplayValue()));
            if (device instanceof HasCombo3in1MainMode) {
                if (!((HasMainMode) device).isInMainMode(MainMode.HEAT) || !device.isUsDevice()) {
                    HasCombo3in1MainMode hasCombo3in1MainMode = (HasCombo3in1MainMode) device;
                    if ((!hasCombo3in1MainMode.isInSubMode(ApSubMode.FAN) || hasCombo3in1MainMode.currentFanSpeed() != 0) && !hasCombo3in1MainMode.isInSubMode(ApSubMode.ECO)) {
                        z = false;
                    }
                }
                disableSettings(z, ((HasCombo3in1MainMode) device).isInSubMode(ApSubMode.ECO));
            }
        }
    }

    private final void disableSettings(boolean z, boolean z2) {
        this.binding.switchBtn.setEnabled(!z);
        ConstraintLayout constraintLayout = this.binding.contentOscillationSettings;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "contentOscillationSettings");
        ViewExtensionsKt.show(constraintLayout, !z || z2);
        int color = this.itemView.getContext().getColor(z ? R.color.light_gray : R.color.colorPrimaryText);
        this.binding.directionTitle.setTextColor(color);
        this.binding.direction.setTextColor(color);
        this.binding.oscillationAngleTitle.setTextColor(color);
        this.binding.angle.setTextColor(color);
        this.binding.speedTitle.setTextColor(color);
        this.binding.speed.setTextColor(color);
        if (z && z2) {
            int color2 = this.itemView.getContext().getColor(R.color.colorPrimaryText);
            this.binding.directionTitle.setTextColor(color2);
            this.binding.direction.setTextColor(color2);
        }
    }

    public final void update(Device device, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
        if (device instanceof HasOscillation) {
            this.binding.switchBtn.setCheckedSilence(z);
        }
    }
}
