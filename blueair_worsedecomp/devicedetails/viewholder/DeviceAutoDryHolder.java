package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasWick;
import com.blueair.devicedetails.databinding.HolderDeviceAutoDryBinding;
import com.blueair.viewcore.R;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0010H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAutoDryHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceAutoDryBinding;", "binding", "onOpenInfoListener", "Lkotlin/Function0;", "", "onCancelListener", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceAutoDryBinding;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "updateProgress", "Lcom/blueair/core/model/HasWick;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAutoDryHolder.kt */
public final class DeviceAutoDryHolder extends DeviceControlHolder<HolderDeviceAutoDryBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Function0<Unit> onCancelListener;
    private final Function0<Unit> onOpenInfoListener;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAutoDryHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceAutoDryHolder;", "parentView", "Landroid/view/ViewGroup;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onCancelListener", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAutoDryHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceAutoDryHolder newInstance(ViewGroup viewGroup, Function0<Unit> function0, Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onOpenInfoListener");
            Intrinsics.checkNotNullParameter(function02, "onCancelListener");
            HolderDeviceAutoDryBinding inflate = HolderDeviceAutoDryBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceAutoDryHolder(inflate, function0, function02);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceAutoDryHolder(HolderDeviceAutoDryBinding holderDeviceAutoDryBinding, Function0<Unit> function0, Function0<Unit> function02) {
        super(holderDeviceAutoDryBinding);
        Intrinsics.checkNotNullParameter(holderDeviceAutoDryBinding, "binding");
        Intrinsics.checkNotNullParameter(function0, "onOpenInfoListener");
        Intrinsics.checkNotNullParameter(function02, "onCancelListener");
        this.onOpenInfoListener = function0;
        this.onCancelListener = function02;
        holderDeviceAutoDryBinding.infoIcon.setOnClickListener(new DeviceAutoDryHolder$$ExternalSyntheticLambda0(this));
        holderDeviceAutoDryBinding.btnCancel.setOnClickListener(new DeviceAutoDryHolder$$ExternalSyntheticLambda1(this));
    }

    static final void lambda$2$lambda$0(DeviceAutoDryHolder deviceAutoDryHolder, View view) {
        deviceAutoDryHolder.onOpenInfoListener.invoke();
    }

    static final void lambda$2$lambda$1(DeviceAutoDryHolder deviceAutoDryHolder, View view) {
        deviceAutoDryHolder.onCancelListener.invoke();
    }

    public void update(Device device, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
        boolean z2 = z || !device.isOnline();
        HolderDeviceAutoDryBinding holderDeviceAutoDryBinding = (HolderDeviceAutoDryBinding) getBinding();
        if (!(device instanceof HasWick)) {
            return;
        }
        if (z2) {
            holderDeviceAutoDryBinding.leadingIcon.setImageTintList(ColorStateList.valueOf(getColor(R.color.surface_dark_45)));
            holderDeviceAutoDryBinding.title.setTextColor(getColor(R.color.surface_dark_55));
            Group group = holderDeviceAutoDryBinding.expendedContent;
            Intrinsics.checkNotNullExpressionValue(group, "expendedContent");
            ViewExtensionsKt.show(group, false);
            holderDeviceAutoDryBinding.clContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r16_black5_stroke1_disabled_white_bg);
            return;
        }
        holderDeviceAutoDryBinding.leadingIcon.setImageTintList((ColorStateList) null);
        holderDeviceAutoDryBinding.title.setTextColor(getColor(R.color.colorPrimaryText));
        holderDeviceAutoDryBinding.clContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r16_black5_stroke1);
        HasWick hasWick = (HasWick) device;
        if (!hasWick.getWickdryEnabled()) {
            Group group2 = holderDeviceAutoDryBinding.expendedContent;
            Intrinsics.checkNotNullExpressionValue(group2, "expendedContent");
            ViewExtensionsKt.show(group2, false);
        } else if (hasWick.getWickdryOn()) {
            updateProgress(hasWick);
            Group group3 = holderDeviceAutoDryBinding.expendedContent;
            Intrinsics.checkNotNullExpressionValue(group3, "expendedContent");
            ViewExtensionsKt.show(group3, true);
        } else {
            Group group4 = holderDeviceAutoDryBinding.expendedContent;
            Intrinsics.checkNotNullExpressionValue(group4, "expendedContent");
            ViewExtensionsKt.show(group4, false);
        }
    }

    private final void updateProgress(HasWick hasWick) {
        int wickDryLeftSeconds = hasWick.getWickDryLeftSeconds();
        ((HolderDeviceAutoDryBinding) getBinding()).progressIndicator.setProgress(RangesKt.coerceIn((wickDryLeftSeconds * 100) / 7200, 0, 100));
        int ceil = (int) Math.ceil(((double) wickDryLeftSeconds) / 60.0d);
        TextView textView = ((HolderDeviceAutoDryBinding) getBinding()).tvLeft;
        textView.setText(textView.getContext().getString(ceil > 1 ? R.string.disinfection_left_time : R.string.disinfection_left_time_1min, new Object[]{String.valueOf(ceil)}));
    }
}
