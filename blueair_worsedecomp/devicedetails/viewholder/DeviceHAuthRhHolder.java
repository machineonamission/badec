package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasAutoRh;
import com.blueair.devicedetails.databinding.HolderDeviceHAutorhBinding;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBH\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R,\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHAuthRhHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceHAutorhBinding;", "isInSchedule", "", "onOpenInfoListener", "Lkotlin/Function0;", "", "onHumidityTargetSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "autoRh", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceHAutorhBinding;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceHAutorhBinding;", "()Z", "getOnOpenInfoListener", "()Lkotlin/jvm/functions/Function0;", "getOnHumidityTargetSetListener", "()Lkotlin/jvm/functions/Function1;", "update", "device", "Lcom/blueair/core/model/Device;", "autorh", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceHAuthRhHolder.kt */
public final class DeviceHAuthRhHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceHAutorhBinding binding;
    private final boolean isInSchedule;
    private final Function1<Integer, Unit> onHumidityTargetSetListener;
    private final Function0<Unit> onOpenInfoListener;

    public final HolderDeviceHAutorhBinding getBinding() {
        return this.binding;
    }

    public final boolean isInSchedule() {
        return this.isInSchedule;
    }

    public final Function0<Unit> getOnOpenInfoListener() {
        return this.onOpenInfoListener;
    }

    public final Function1<Integer, Unit> getOnHumidityTargetSetListener() {
        return this.onHumidityTargetSetListener;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JG\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\f0\u000e¨\u0006\u0013"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHAuthRhHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceHAuthRhHolder;", "parentView", "Landroid/view/ViewGroup;", "isInSchedule", "", "onOpenInfoListener", "Lkotlin/Function0;", "", "onHumidityTargetSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "autoRh", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceHAuthRhHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceHAuthRhHolder newInstance(ViewGroup viewGroup, boolean z, Function0<Unit> function0, Function1<? super Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onOpenInfoListener");
            Intrinsics.checkNotNullParameter(function1, "onHumidityTargetSetListener");
            HolderDeviceHAutorhBinding inflate = HolderDeviceHAutorhBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            if (z) {
                inflate.contentContainer.setBackground(AppCompatResources.getDrawable(viewGroup.getContext(), R.drawable.rounded_square_anti_flash_blue_r8));
            }
            Intrinsics.checkNotNullExpressionValue(inflate, "apply(...)");
            return new DeviceHAuthRhHolder(inflate, z, function0, function1);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceHAuthRhHolder(com.blueair.devicedetails.databinding.HolderDeviceHAutorhBinding r3, boolean r4, kotlin.jvm.functions.Function0<kotlin.Unit> r5, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r6) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onOpenInfoListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "onHumidityTargetSetListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            android.widget.FrameLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r2.<init>(r0)
            r2.binding = r3
            r2.isInSchedule = r4
            r2.onOpenInfoListener = r5
            r2.onHumidityTargetSetListener = r6
            if (r4 == 0) goto L_0x002e
            android.widget.TextView r4 = r3.title
            r5 = 0
            r4.setCompoundDrawablesWithIntrinsicBounds(r5, r5, r5, r5)
            goto L_0x0038
        L_0x002e:
            android.widget.TextView r4 = r3.title
            com.blueair.devicedetails.viewholder.DeviceHAuthRhHolder$$ExternalSyntheticLambda0 r5 = new com.blueair.devicedetails.viewholder.DeviceHAuthRhHolder$$ExternalSyntheticLambda0
            r5.<init>(r2)
            r4.setOnClickListener(r5)
        L_0x0038:
            com.blueair.viewcore.view.AccessibleSeekBar r3 = r3.seekbar
            com.blueair.devicedetails.viewholder.DeviceHAuthRhHolder$2 r4 = new com.blueair.devicedetails.viewholder.DeviceHAuthRhHolder$2
            r4.<init>(r2)
            android.widget.SeekBar$OnSeekBarChangeListener r4 = (android.widget.SeekBar.OnSeekBarChangeListener) r4
            r3.setOnSeekBarChangeListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceHAuthRhHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceHAutorhBinding, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1):void");
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceHAuthRhHolder deviceHAuthRhHolder, View view) {
        deviceHAuthRhHolder.onOpenInfoListener.invoke();
    }

    public void update(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        if (device instanceof HasAutoRh) {
            update(RangesKt.coerceIn(((HasAutoRh) device).getAutoRh(), 30, 80));
        }
    }

    public final void update(int i) {
        int coerceIn = RangesKt.coerceIn(i, 30, 80);
        this.binding.seekbar.setProgress(coerceIn);
        TextView textView = this.binding.progressText;
        StringBuilder sb = new StringBuilder();
        sb.append(coerceIn);
        sb.append('%');
        textView.setText(sb.toString());
    }
}
