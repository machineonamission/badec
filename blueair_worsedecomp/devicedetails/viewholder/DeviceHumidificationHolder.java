package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasWaterLevel;
import com.blueair.core.model.WaterLevel;
import com.blueair.devicedetails.databinding.HolderDeviceHumidificationBinding;
import com.blueair.viewcore.R;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHumidificationHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceHumidificationBinding;", "binding", "inSchedule", "", "onModeChangeListener", "Lkotlin/Function0;", "", "onCloseHintListener", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceHumidificationBinding;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "hintClosedBefore", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "closedBefore", "humMode", "inactive", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceHumidificationHolder.kt */
public final class DeviceHumidificationHolder extends DeviceControlHolder<HolderDeviceHumidificationBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private boolean hintClosedBefore;
    private final boolean inSchedule;
    private final Function0<Unit> onCloseHintListener;
    private final Function0<Unit> onModeChangeListener;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¨\u0006\u000e"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHumidificationHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceHumidificationHolder;", "parentView", "Landroid/view/ViewGroup;", "inSchedule", "", "onModeChangeListener", "Lkotlin/Function0;", "", "onClosePromptListener", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceHumidificationHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DeviceHumidificationHolder newInstance$default(Companion companion, ViewGroup viewGroup, boolean z, Function0 function0, Function0 function02, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                function02 = null;
            }
            return companion.newInstance(viewGroup, z, function0, function02);
        }

        public final DeviceHumidificationHolder newInstance(ViewGroup viewGroup, boolean z, Function0<Unit> function0, Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onModeChangeListener");
            HolderDeviceHumidificationBinding inflate = HolderDeviceHumidificationBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceHumidificationHolder(inflate, z, function0, function02);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceHumidificationHolder(HolderDeviceHumidificationBinding holderDeviceHumidificationBinding, boolean z, Function0<Unit> function0, Function0<Unit> function02) {
        super(holderDeviceHumidificationBinding);
        Intrinsics.checkNotNullParameter(holderDeviceHumidificationBinding, "binding");
        Intrinsics.checkNotNullParameter(function0, "onModeChangeListener");
        this.inSchedule = z;
        this.onModeChangeListener = function0;
        this.onCloseHintListener = function02;
        holderDeviceHumidificationBinding.hintContainer.btnCloseHint.setOnClickListener(new DeviceHumidificationHolder$$ExternalSyntheticLambda0(this));
        holderDeviceHumidificationBinding.switchMode.setOnCheckedChangeListener(new DeviceHumidificationHolder$$ExternalSyntheticLambda1(this));
    }

    static final void lambda$2$lambda$0(DeviceHumidificationHolder deviceHumidificationHolder, View view) {
        Function0<Unit> function0 = deviceHumidificationHolder.onCloseHintListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    static final void lambda$2$lambda$1(DeviceHumidificationHolder deviceHumidificationHolder, CompoundButton compoundButton, boolean z) {
        deviceHumidificationHolder.onModeChangeListener.invoke();
    }

    public void update(Device device, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
        boolean z2 = true;
        boolean z3 = !DeviceKt.isHumidifyModeOn(device) && ((device instanceof HasWaterLevel) && ((HasWaterLevel) device).isInWaterLevel(WaterLevel.SHORTAGE));
        if (!z && device.isOnline() && !DeviceKt.isStandByOn(device) && !z3) {
            z2 = false;
        }
        update(DeviceKt.isHumidifyModeOn(device), z2);
    }

    public final void update(Device device, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(device, "device");
        this.hintClosedBefore = z2;
        update(device, z);
    }

    public final void update(boolean z, boolean z2) {
        HolderDeviceHumidificationBinding holderDeviceHumidificationBinding = (HolderDeviceHumidificationBinding) getBinding();
        boolean z3 = false;
        if (z2) {
            holderDeviceHumidificationBinding.title.setTextColor(getColor(R.color.surface_dark_55));
            ConstraintLayout root = holderDeviceHumidificationBinding.hintContainer.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            ViewExtensionsKt.show(root, false);
            holderDeviceHumidificationBinding.switchMode.setEnabled(false);
            holderDeviceHumidificationBinding.leadingIcon.setImageTintList(ColorStateList.valueOf(getColor(R.color.surface_dark_45)));
            holderDeviceHumidificationBinding.clContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r16_black5_stroke1_disabled_white_bg);
        } else {
            holderDeviceHumidificationBinding.title.setTextColor(getColor(R.color.colorPrimaryText));
            holderDeviceHumidificationBinding.clContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r16_black5_stroke1);
            holderDeviceHumidificationBinding.leadingIcon.setImageTintList((ColorStateList) null);
            holderDeviceHumidificationBinding.hintContainer.hintText.setText(this.itemView.getContext().getString(R.string.humidification_mode_hint));
            ConstraintLayout root2 = holderDeviceHumidificationBinding.hintContainer.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
            View view = root2;
            if (!this.hintClosedBefore && !this.inSchedule && z) {
                z3 = true;
            }
            ViewExtensionsKt.show(view, z3);
            holderDeviceHumidificationBinding.switchMode.setEnabled(true);
        }
        holderDeviceHumidificationBinding.switchMode.setCheckedSilence(z);
    }
}
