package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasDisinfection;
import com.blueair.devicedetails.databinding.HolderDeviceDisinfectionStatusBinding;
import com.blueair.devicedetails.util.DisinfectionUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceDisinfectionStatusHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceDisinfectionStatusBinding;", "onDisinfectionInfoClickListener", "Lkotlin/Function0;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceDisinfectionStatusBinding;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceDisinfectionStatusBinding;", "update", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceDisinfectionStatusHolder.kt */
public final class DeviceDisinfectionStatusHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceDisinfectionStatusBinding binding;
    private final Function0<Unit> onDisinfectionInfoClickListener;

    public final HolderDeviceDisinfectionStatusBinding getBinding() {
        return this.binding;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceDisinfectionStatusHolder(com.blueair.devicedetails.databinding.HolderDeviceDisinfectionStatusBinding r3, kotlin.jvm.functions.Function0<kotlin.Unit> r4) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onDisinfectionInfoClickListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r2.<init>(r0)
            r2.binding = r3
            r2.onDisinfectionInfoClickListener = r4
            android.widget.TextView r3 = r3.attributeTitle
            com.blueair.devicedetails.viewholder.DeviceDisinfectionStatusHolder$$ExternalSyntheticLambda0 r4 = new com.blueair.devicedetails.viewholder.DeviceDisinfectionStatusHolder$$ExternalSyntheticLambda0
            r4.<init>(r2)
            r3.setOnClickListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceDisinfectionStatusHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceDisinfectionStatusBinding, kotlin.jvm.functions.Function0):void");
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceDisinfectionStatusHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceDisinfectionStatusHolder;", "parentView", "Landroid/view/ViewGroup;", "onDisinfectionInfoClickListener", "Lkotlin/Function0;", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceDisinfectionStatusHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceDisinfectionStatusHolder newInstance(ViewGroup viewGroup, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onDisinfectionInfoClickListener");
            HolderDeviceDisinfectionStatusBinding inflate = HolderDeviceDisinfectionStatusBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceDisinfectionStatusHolder(inflate, function0);
        }
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceDisinfectionStatusHolder deviceDisinfectionStatusHolder, View view) {
        deviceDisinfectionStatusHolder.onDisinfectionInfoClickListener.invoke();
    }

    public void update(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        if (device instanceof HasDisinfection) {
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Pair<Integer, Spanned> countdownStatus = DisinfectionUtils.INSTANCE.getCountdownStatus((HasDisinfection) device, context);
            int intValue = countdownStatus.component1().intValue();
            this.binding.disinfectionLeftTimeView.setText(countdownStatus.component2());
            this.binding.progress.setProgress(100 - ((intValue * 100) / 7200));
        }
    }
}
