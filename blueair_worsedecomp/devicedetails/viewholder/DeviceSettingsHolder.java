package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.databinding.HolderDeviceSettingsBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSettingsHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceSettingsBinding;", "binding", "onOpenActionListener", "Lkotlin/Function0;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceSettingsBinding;Lkotlin/jvm/functions/Function0;)V", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSettingsHolder.kt */
public final class DeviceSettingsHolder extends DeviceControlHolder<HolderDeviceSettingsBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Function0<Unit> onOpenActionListener;

    public void update(Device device, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSettingsHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceSettingsHolder;", "parentView", "Landroid/view/ViewGroup;", "onOpenActionListener", "Lkotlin/Function0;", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSettingsHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceSettingsHolder newInstance(ViewGroup viewGroup, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onOpenActionListener");
            HolderDeviceSettingsBinding inflate = HolderDeviceSettingsBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceSettingsHolder(inflate, function0);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceSettingsHolder(HolderDeviceSettingsBinding holderDeviceSettingsBinding, Function0<Unit> function0) {
        super(holderDeviceSettingsBinding);
        Intrinsics.checkNotNullParameter(holderDeviceSettingsBinding, "binding");
        Intrinsics.checkNotNullParameter(function0, "onOpenActionListener");
        this.onOpenActionListener = function0;
        holderDeviceSettingsBinding.contentContainer.setOnClickListener(new DeviceSettingsHolder$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceSettingsHolder deviceSettingsHolder, View view) {
        deviceSettingsHolder.onOpenActionListener.invoke();
    }
}
