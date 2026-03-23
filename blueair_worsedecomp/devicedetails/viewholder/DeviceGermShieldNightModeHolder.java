package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.blueair.devicedetails.databinding.HolderDeviceGermShieldNightModeBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceGermShieldNightModeHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceGermShieldNightModeBinding;", "onGsnmSetListener", "Lkotlin/Function0;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceGermShieldNightModeBinding;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceGermShieldNightModeBinding;", "update", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceGermShieldNightModeHolder.kt */
public final class DeviceGermShieldNightModeHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceGermShieldNightModeBinding binding;
    private final Function0<Unit> onGsnmSetListener;

    public final HolderDeviceGermShieldNightModeBinding getBinding() {
        return this.binding;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceGermShieldNightModeHolder(com.blueair.devicedetails.databinding.HolderDeviceGermShieldNightModeBinding r3, kotlin.jvm.functions.Function0<kotlin.Unit> r4) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onGsnmSetListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r2.<init>(r0)
            r2.binding = r3
            r2.onGsnmSetListener = r4
            com.blueair.viewcore.view.SwitchCompat r3 = r3.gsnmSwitch
            com.blueair.devicedetails.viewholder.DeviceGermShieldNightModeHolder$$ExternalSyntheticLambda0 r4 = new com.blueair.devicedetails.viewholder.DeviceGermShieldNightModeHolder$$ExternalSyntheticLambda0
            r4.<init>(r2)
            r3.setOnCheckedChangeListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceGermShieldNightModeHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceGermShieldNightModeBinding, kotlin.jvm.functions.Function0):void");
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceGermShieldNightModeHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceGermShieldNightModeHolder;", "parentView", "Landroid/view/ViewGroup;", "onGsnmSetListener", "Lkotlin/Function0;", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceGermShieldNightModeHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceGermShieldNightModeHolder newInstance(ViewGroup viewGroup, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onGsnmSetListener");
            HolderDeviceGermShieldNightModeBinding inflate = HolderDeviceGermShieldNightModeBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceGermShieldNightModeHolder(inflate, function0);
        }
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceGermShieldNightModeHolder deviceGermShieldNightModeHolder, CompoundButton compoundButton, boolean z) {
        deviceGermShieldNightModeHolder.onGsnmSetListener.invoke();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 != null ? r3.booleanValue() : true) != false) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(com.blueair.core.model.Device r3) {
        /*
            r2 = this;
            java.lang.String r0 = "device"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.blueair.devicedetails.databinding.HolderDeviceGermShieldNightModeBinding r0 = r2.binding
            com.blueair.viewcore.view.SwitchCompat r0 = r0.gsnmSwitch
            boolean r1 = r3 instanceof com.blueair.core.model.HasGermShieldMode
            if (r1 == 0) goto L_0x001f
            com.blueair.core.model.HasGermShieldMode r3 = (com.blueair.core.model.HasGermShieldMode) r3
            java.lang.Boolean r3 = r3.isGermShieldNightModeOn()
            r1 = 1
            if (r3 == 0) goto L_0x001b
            boolean r3 = r3.booleanValue()
            goto L_0x001c
        L_0x001b:
            r3 = r1
        L_0x001c:
            if (r3 == 0) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r1 = 0
        L_0x0020:
            r0.setCheckedSilence(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceGermShieldNightModeHolder.update(com.blueair.core.model.Device):void");
    }
}
