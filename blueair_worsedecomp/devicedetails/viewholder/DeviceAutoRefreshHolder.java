package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasAirRefresh;
import com.blueair.core.model.HasMainMode;
import com.blueair.devicedetails.databinding.HolderDeviceAutoRefreshBinding;
import com.blueair.viewcore.R;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAutoRefreshHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceAutoRefreshBinding;", "binding", "onOpenInfoListener", "Lkotlin/Function0;", "", "onCancelListener", "onCloseHintListener", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceAutoRefreshBinding;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "autoRefreshHintClosedBefore", "", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "closedBefore", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAutoRefreshHolder.kt */
public final class DeviceAutoRefreshHolder extends DeviceControlHolder<HolderDeviceAutoRefreshBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private boolean autoRefreshHintClosedBefore;
    private final Function0<Unit> onCancelListener;
    private final Function0<Unit> onCloseHintListener;
    private final Function0<Unit> onOpenInfoListener;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAutoRefreshHolder.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|23) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0043 */
        static {
            /*
                com.blueair.core.model.AirRefreshState[] r0 = com.blueair.core.model.AirRefreshState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.blueair.core.model.AirRefreshState r2 = com.blueair.core.model.AirRefreshState.START     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.blueair.core.model.AirRefreshState r3 = com.blueair.core.model.AirRefreshState.COMPLETED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.blueair.core.model.AirRefreshState r4 = com.blueair.core.model.AirRefreshState.CANCEL     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                com.blueair.core.model.ApSubMode[] r0 = com.blueair.core.model.ApSubMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.ApSubMode r4 = com.blueair.core.model.ApSubMode.AUTO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.blueair.core.model.ApSubMode r1 = com.blueair.core.model.ApSubMode.ECO     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.blueair.core.model.ApSubMode r1 = com.blueair.core.model.ApSubMode.FAN     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.blueair.core.model.ApSubMode r1 = com.blueair.core.model.ApSubMode.NIGHT     // Catch:{ NoSuchFieldError -> 0x004c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceAutoRefreshHolder.WhenMappings.<clinit>():void");
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\r"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAutoRefreshHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceAutoRefreshHolder;", "parentView", "Landroid/view/ViewGroup;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onCancelListener", "onClosePromptListener", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAutoRefreshHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceAutoRefreshHolder newInstance(ViewGroup viewGroup, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onOpenInfoListener");
            Intrinsics.checkNotNullParameter(function02, "onCancelListener");
            Intrinsics.checkNotNullParameter(function03, "onClosePromptListener");
            HolderDeviceAutoRefreshBinding inflate = HolderDeviceAutoRefreshBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceAutoRefreshHolder(inflate, function0, function02, function03);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceAutoRefreshHolder(HolderDeviceAutoRefreshBinding holderDeviceAutoRefreshBinding, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        super(holderDeviceAutoRefreshBinding);
        Intrinsics.checkNotNullParameter(holderDeviceAutoRefreshBinding, "binding");
        Intrinsics.checkNotNullParameter(function0, "onOpenInfoListener");
        Intrinsics.checkNotNullParameter(function02, "onCancelListener");
        Intrinsics.checkNotNullParameter(function03, "onCloseHintListener");
        this.onOpenInfoListener = function0;
        this.onCancelListener = function02;
        this.onCloseHintListener = function03;
        holderDeviceAutoRefreshBinding.infoIcon.setOnClickListener(new DeviceAutoRefreshHolder$$ExternalSyntheticLambda0(this));
        holderDeviceAutoRefreshBinding.btnCancel.setOnClickListener(new DeviceAutoRefreshHolder$$ExternalSyntheticLambda1(this));
        holderDeviceAutoRefreshBinding.btnCloseHint.setOnClickListener(new DeviceAutoRefreshHolder$$ExternalSyntheticLambda2(this));
    }

    static final void lambda$3$lambda$0(DeviceAutoRefreshHolder deviceAutoRefreshHolder, View view) {
        deviceAutoRefreshHolder.onOpenInfoListener.invoke();
    }

    static final void lambda$3$lambda$1(DeviceAutoRefreshHolder deviceAutoRefreshHolder, View view) {
        deviceAutoRefreshHolder.onCancelListener.invoke();
    }

    static final void lambda$3$lambda$2(DeviceAutoRefreshHolder deviceAutoRefreshHolder, View view) {
        deviceAutoRefreshHolder.onCloseHintListener.invoke();
    }

    public void update(Device device, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
        boolean z2 = z || !device.isOnline() || DeviceKt.isStandByOn(device);
        HolderDeviceAutoRefreshBinding holderDeviceAutoRefreshBinding = (HolderDeviceAutoRefreshBinding) getBinding();
        if ((device instanceof HasMainMode) && (device instanceof HasAirRefresh)) {
            if (z2) {
                holderDeviceAutoRefreshBinding.leadingIcon.setImageResource(R.drawable.ic_auto_refresh_leading_disabled);
                holderDeviceAutoRefreshBinding.title.setText(getString(R.string.auto_refresh));
                holderDeviceAutoRefreshBinding.title.setTextColor(getColor(R.color.surface_dark_55));
                Group group = holderDeviceAutoRefreshBinding.expendedContent;
                Intrinsics.checkNotNullExpressionValue(group, "expendedContent");
                ViewExtensionsKt.show(group, false);
                ConstraintLayout constraintLayout = holderDeviceAutoRefreshBinding.hintContainer;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "hintContainer");
                ViewExtensionsKt.show(constraintLayout, false);
                holderDeviceAutoRefreshBinding.autoRefreshContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r16_black5_stroke1_disabled_white_bg);
            } else {
                holderDeviceAutoRefreshBinding.leadingIcon.setImageResource(R.drawable.ic_auto_refresh_leading);
                holderDeviceAutoRefreshBinding.title.setTextColor(getColor(R.color.colorPrimaryText));
                holderDeviceAutoRefreshBinding.autoRefreshContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r16_black5_stroke1);
                HasAirRefresh hasAirRefresh = (HasAirRefresh) device;
                if (hasAirRefresh.getAirRefreshEnabled()) {
                    int i = WhenMappings.$EnumSwitchMapping$1[((HasMainMode) device).apSubMode().ordinal()];
                    if (i == 1 || i == 2) {
                        int i2 = WhenMappings.$EnumSwitchMapping$0[hasAirRefresh.airRefreshStatus().ordinal()];
                        if (i2 == 1) {
                            TextView textView = holderDeviceAutoRefreshBinding.title;
                            textView.setText(getString(R.string.auto_refresh) + " - " + getString(R.string.air_refreshing));
                            Group group2 = holderDeviceAutoRefreshBinding.expendedContent;
                            Intrinsics.checkNotNullExpressionValue(group2, "expendedContent");
                            ViewExtensionsKt.show(group2, true);
                            int airRefreshLeftSeconds$default = HasAirRefresh.CC.getAirRefreshLeftSeconds$default(hasAirRefresh, 0, 1, (Object) null);
                            int ceil = (int) Math.ceil(((double) airRefreshLeftSeconds$default) / 60.0d);
                            int ceil2 = (int) Math.ceil(((double) hasAirRefresh.getAirRefreshDuration()) / 60.0d);
                            holderDeviceAutoRefreshBinding.progressIndicator.setProgress(RangesKt.coerceIn((airRefreshLeftSeconds$default * 100) / RangesKt.coerceAtLeast(hasAirRefresh.getAirRefreshDuration(), 1), (ClosedRange<Integer>) new IntRange(0, 100)));
                            TextView textView2 = holderDeviceAutoRefreshBinding.leftTimeText;
                            String format = String.format(getString(ceil == 1 ? R.string.disinfection_left_time_1min : R.string.disinfection_left_time), Arrays.copyOf(new Object[]{Integer.valueOf(ceil)}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                            textView2.setText(format);
                            TextView textView3 = holderDeviceAutoRefreshBinding.durationText;
                            String format2 = String.format(getString(R.string.auto_refresh_duration), Arrays.copyOf(new Object[]{Integer.valueOf(ceil2)}, 1));
                            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                            textView3.setText(format2);
                        } else if (i2 == 2 || i2 == 3) {
                            TextView textView4 = holderDeviceAutoRefreshBinding.title;
                            textView4.setText(getString(R.string.auto_refresh) + " - " + getString(R.string.active));
                            Group group3 = holderDeviceAutoRefreshBinding.expendedContent;
                            Intrinsics.checkNotNullExpressionValue(group3, "expendedContent");
                            ViewExtensionsKt.show(group3, false);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        ConstraintLayout constraintLayout2 = holderDeviceAutoRefreshBinding.hintContainer;
                        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "hintContainer");
                        ViewExtensionsKt.show(constraintLayout2, false);
                    } else if (i == 3 || i == 4) {
                        TextView textView5 = holderDeviceAutoRefreshBinding.title;
                        textView5.setText(getString(R.string.auto_refresh) + " - " + getString(R.string.inactive));
                        Group group4 = holderDeviceAutoRefreshBinding.expendedContent;
                        Intrinsics.checkNotNullExpressionValue(group4, "expendedContent");
                        ViewExtensionsKt.show(group4, false);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    ConstraintLayout constraintLayout3 = holderDeviceAutoRefreshBinding.hintContainer;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout3, "hintContainer");
                    ViewExtensionsKt.show(constraintLayout3, !this.autoRefreshHintClosedBefore);
                } else {
                    holderDeviceAutoRefreshBinding.title.setText(R.string.auto_refresh);
                    ConstraintLayout constraintLayout4 = holderDeviceAutoRefreshBinding.hintContainer;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout4, "hintContainer");
                    ViewExtensionsKt.show(constraintLayout4, false);
                }
            }
        }
        holderDeviceAutoRefreshBinding.infoIcon.setContentDescription(holderDeviceAutoRefreshBinding.infoIcon.getContext().getString(R.string.more_info_about, new Object[]{getString(R.string.auto_refresh)}));
    }

    public final void update(Device device, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(device, "device");
        this.autoRefreshHintClosedBefore = z2;
        update(device, z);
    }
}
