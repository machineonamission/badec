package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasHinsMode;
import com.blueair.core.model.HasStandBy;
import com.blueair.devicedetails.databinding.HolderDeviceNHinsBinding;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0004¢\u0006\u0002\n\u0000R)\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNHinsHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceNHinsBinding;", "onHinsInfoClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isG4NightMode", "", "onHinsSetListener", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNHinsBinding;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceNHinsBinding;", "update", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNHinsHolder.kt */
public final class DeviceNHinsHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceNHinsBinding binding;
    private boolean isG4NightMode;
    private final Function1<Boolean, Unit> onHinsInfoClickListener;
    private final Function1<Boolean, Unit> onHinsSetListener;

    public final HolderDeviceNHinsBinding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¨\u0006\u0010"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNHinsHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNHinsHolder;", "parentView", "Landroid/view/ViewGroup;", "onHinsInfoClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isG4NightMode", "", "onHinsSetListener", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNHinsHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNHinsHolder newInstance(ViewGroup viewGroup, Function1<? super Boolean, Unit> function1, Function1<? super Boolean, Unit> function12) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onHinsInfoClickListener");
            Intrinsics.checkNotNullParameter(function12, "onHinsSetListener");
            HolderDeviceNHinsBinding inflate = HolderDeviceNHinsBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceNHinsHolder(inflate, function1, function12);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceNHinsHolder(com.blueair.devicedetails.databinding.HolderDeviceNHinsBinding r3, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r4, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r5) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onHinsInfoClickListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "onHinsSetListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.widget.FrameLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r2.<init>(r0)
            r2.binding = r3
            r2.onHinsInfoClickListener = r4
            r2.onHinsSetListener = r5
            android.widget.TextView r4 = r3.title
            com.blueair.devicedetails.viewholder.DeviceNHinsHolder$$ExternalSyntheticLambda0 r5 = new com.blueair.devicedetails.viewholder.DeviceNHinsHolder$$ExternalSyntheticLambda0
            r5.<init>(r2)
            r4.setOnClickListener(r5)
            com.blueair.viewcore.view.SwitchCompat r3 = r3.switchBtn
            com.blueair.devicedetails.viewholder.DeviceNHinsHolder$$ExternalSyntheticLambda1 r4 = new com.blueair.devicedetails.viewholder.DeviceNHinsHolder$$ExternalSyntheticLambda1
            r4.<init>(r2)
            r3.setOnCheckedChangeListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceNHinsHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceNHinsBinding, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void");
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceNHinsHolder deviceNHinsHolder, View view) {
        deviceNHinsHolder.onHinsInfoClickListener.invoke(Boolean.valueOf(deviceNHinsHolder.isG4NightMode));
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(DeviceNHinsHolder deviceNHinsHolder, CompoundButton compoundButton, boolean z) {
        deviceNHinsHolder.onHinsSetListener.invoke(Boolean.valueOf(deviceNHinsHolder.isG4NightMode));
    }

    public void update(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        if (!(device instanceof HasStandBy) || !((HasStandBy) device).isStandByOn()) {
            this.binding.switchBtn.setEnabled(true);
            if ((device instanceof HasG4NightMode) && (device instanceof HasHinsMode)) {
                this.isG4NightMode = ((HasG4NightMode) device).isG4NightModeOn();
                HasHinsMode hasHinsMode = (HasHinsMode) device;
                this.binding.switchBtn.setCheckedSilence(this.isG4NightMode ? hasHinsMode.isHinsNightModeOn() : hasHinsMode.isHinsModeOn());
                this.binding.title.setText(this.isG4NightMode ? R.string.photon_pure_night : R.string.photon_pure);
            }
        } else {
            this.binding.title.setText(R.string.photon_pure);
            this.binding.switchBtn.setCheckedSilence(false);
            this.binding.switchBtn.setEnabled(false);
        }
        this.binding.switchBtn.setContentDescription(this.binding.title.getText());
    }
}
