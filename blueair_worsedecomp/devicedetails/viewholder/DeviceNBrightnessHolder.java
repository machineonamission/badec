package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.ViewDataBinding;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.HasBrightness;
import com.blueair.devicedetails.databinding.HolderDeviceHBrightnessBinding;
import com.blueair.devicedetails.databinding.HolderDeviceNBrightnessBinding;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBD\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNBrightnessHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Landroidx/databinding/ViewDataBinding;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onBrightnessSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "brightness", "", "<init>", "(Landroidx/databinding/ViewDataBinding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "()Z", "seekbar", "Landroid/widget/SeekBar;", "progressText", "Landroid/widget/TextView;", "seekbarMin", "update", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNBrightnessHolder.kt */
public final class DeviceNBrightnessHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ViewDataBinding binding;
    private final Device device;
    private final boolean isInSchedule;
    /* access modifiers changed from: private */
    public final Function1<Integer, Unit> onBrightnessSetListener;
    /* access modifiers changed from: private */
    public final TextView progressText;
    private final SeekBar seekbar;
    private final int seekbarMin;

    public final ViewDataBinding getBinding() {
        return this.binding;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final boolean isInSchedule() {
        return this.isInSchedule;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¨\u0006\u0013"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNBrightnessHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNBrightnessHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onBrightnessSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "brightness", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNBrightnessHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNBrightnessHolder newInstance(ViewGroup viewGroup, Device device, boolean z, Function1<? super Integer, Unit> function1) {
            ViewDataBinding viewDataBinding;
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onBrightnessSetListener");
            if (device instanceof DeviceNewClassic) {
                HolderDeviceNBrightnessBinding inflate = HolderDeviceNBrightnessBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                if (z) {
                    inflate.contentContainer.setBackground(AppCompatResources.getDrawable(viewGroup.getContext(), R.drawable.rounded_square_light_grey));
                }
                Intrinsics.checkNotNullExpressionValue(inflate, "apply(...)");
                viewDataBinding = inflate;
            } else {
                HolderDeviceHBrightnessBinding inflate2 = HolderDeviceHBrightnessBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                if (z) {
                    inflate2.contentContainer.setBackground(AppCompatResources.getDrawable(viewGroup.getContext(), R.drawable.rounded_square_anti_flash_blue_r8));
                }
                Intrinsics.checkNotNullExpressionValue(inflate2, "apply(...)");
                viewDataBinding = inflate2;
            }
            return new DeviceNBrightnessHolder(viewDataBinding, device, z, function1);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceNBrightnessHolder(androidx.databinding.ViewDataBinding r3, com.blueair.core.model.Device r4, boolean r5, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r6) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onBrightnessSetListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            android.view.View r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.<init>(r0)
            r2.binding = r3
            r2.device = r4
            r2.isInSchedule = r5
            r2.onBrightnessSetListener = r6
            boolean r4 = r4 instanceof com.blueair.core.model.DeviceNewClassic
            r2.seekbarMin = r4
            boolean r5 = r3 instanceof com.blueair.devicedetails.databinding.HolderDeviceHBrightnessBinding
            java.lang.String r6 = "progressText"
            java.lang.String r0 = "seekbar"
            if (r5 == 0) goto L_0x0040
            r5 = r3
            com.blueair.devicedetails.databinding.HolderDeviceHBrightnessBinding r5 = (com.blueair.devicedetails.databinding.HolderDeviceHBrightnessBinding) r5
            com.blueair.viewcore.view.AccessibleSeekBar r5 = r5.seekbar
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            android.widget.SeekBar r5 = (android.widget.SeekBar) r5
            r2.seekbar = r5
            com.blueair.devicedetails.databinding.HolderDeviceHBrightnessBinding r3 = (com.blueair.devicedetails.databinding.HolderDeviceHBrightnessBinding) r3
            android.widget.TextView r3 = r3.progressText
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            r2.progressText = r3
            goto L_0x005d
        L_0x0040:
            java.lang.String r5 = "null cannot be cast to non-null type com.blueair.devicedetails.databinding.HolderDeviceNBrightnessBinding"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r5)
            r5 = r3
            com.blueair.devicedetails.databinding.HolderDeviceNBrightnessBinding r5 = (com.blueair.devicedetails.databinding.HolderDeviceNBrightnessBinding) r5
            r5 = r3
            com.blueair.devicedetails.databinding.HolderDeviceNBrightnessBinding r5 = (com.blueair.devicedetails.databinding.HolderDeviceNBrightnessBinding) r5
            com.blueair.viewcore.view.AccessibleSeekBar r5 = r5.seekbar
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            android.widget.SeekBar r5 = (android.widget.SeekBar) r5
            r2.seekbar = r5
            com.blueair.devicedetails.databinding.HolderDeviceNBrightnessBinding r3 = (com.blueair.devicedetails.databinding.HolderDeviceNBrightnessBinding) r3
            android.widget.TextView r3 = r3.progressText
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            r2.progressText = r3
        L_0x005d:
            int r3 = android.os.Build.VERSION.SDK_INT
            r5 = 26
            if (r3 < r5) goto L_0x006a
            android.widget.SeekBar r3 = r2.seekbar
            com.blueair.viewcore.view.AccessibleSeekBar r3 = (com.blueair.viewcore.view.AccessibleSeekBar) r3
            r3.setMin(r4)
        L_0x006a:
            android.widget.SeekBar r3 = r2.seekbar
            com.blueair.viewcore.view.AccessibleSeekBar r3 = (com.blueair.viewcore.view.AccessibleSeekBar) r3
            com.blueair.devicedetails.viewholder.DeviceNBrightnessHolder$1 r4 = new com.blueair.devicedetails.viewholder.DeviceNBrightnessHolder$1
            r4.<init>(r2)
            android.widget.SeekBar$OnSeekBarChangeListener r4 = (android.widget.SeekBar.OnSeekBarChangeListener) r4
            r3.setOnSeekBarChangeListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceNBrightnessHolder.<init>(androidx.databinding.ViewDataBinding, com.blueair.core.model.Device, boolean, kotlin.jvm.functions.Function1):void");
    }

    public void update(Device device2) {
        Intrinsics.checkNotNullParameter(device2, "device");
        if (device2 instanceof HasBrightness) {
            update(RangesKt.coerceIn(((HasBrightness) device2).getBrightness(), this.seekbarMin, 100));
        }
    }

    public final void update(int i) {
        int coerceIn = RangesKt.coerceIn(i, this.seekbarMin, 100);
        this.seekbar.setProgress(coerceIn);
        TextView textView = this.progressText;
        StringBuilder sb = new StringBuilder();
        sb.append(coerceIn);
        sb.append('%');
        textView.setText(sb.toString());
    }
}
