package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.databinding.HolderDeviceOfflineV2Binding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceOfflineV2Holder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceOfflineV2Binding;", "binding", "onClosedListener", "Lkotlin/Function0;", "", "onTroubleShootClickListener", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceOfflineV2Binding;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceOfflineV2Holder.kt */
public final class DeviceOfflineV2Holder extends DeviceControlHolder<HolderDeviceOfflineV2Binding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Function0<Unit> onClosedListener;
    private final Function0<Unit> onTroubleShootClickListener;

    public void update(Device device, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceOfflineV2Holder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceOfflineV2Holder;", "parentView", "Landroid/view/ViewGroup;", "onClosedListener", "Lkotlin/Function0;", "", "onTroubleShootClickListener", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceOfflineV2Holder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceOfflineV2Holder newInstance(ViewGroup viewGroup, Function0<Unit> function0, Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onClosedListener");
            Intrinsics.checkNotNullParameter(function02, "onTroubleShootClickListener");
            HolderDeviceOfflineV2Binding inflate = HolderDeviceOfflineV2Binding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceOfflineV2Holder(inflate, function0, function02);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceOfflineV2Holder(HolderDeviceOfflineV2Binding holderDeviceOfflineV2Binding, Function0<Unit> function0, Function0<Unit> function02) {
        super(holderDeviceOfflineV2Binding);
        Intrinsics.checkNotNullParameter(holderDeviceOfflineV2Binding, "binding");
        Intrinsics.checkNotNullParameter(function0, "onClosedListener");
        Intrinsics.checkNotNullParameter(function02, "onTroubleShootClickListener");
        this.onClosedListener = function0;
        this.onTroubleShootClickListener = function02;
        holderDeviceOfflineV2Binding.closeBtn.setOnClickListener(new DeviceOfflineV2Holder$$ExternalSyntheticLambda0(this));
        holderDeviceOfflineV2Binding.troubleshootBtn.setOnClickListener(new DeviceOfflineV2Holder$$ExternalSyntheticLambda1(this));
    }

    static final void lambda$2$lambda$0(DeviceOfflineV2Holder deviceOfflineV2Holder, View view) {
        deviceOfflineV2Holder.onClosedListener.invoke();
    }

    static final void lambda$2$lambda$1(DeviceOfflineV2Holder deviceOfflineV2Holder, View view) {
        deviceOfflineV2Holder.onTroubleShootClickListener.invoke();
    }
}
