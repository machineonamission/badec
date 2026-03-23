package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.core.view.ViewGroupKt;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.HolderDeviceMainModeDehumBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B2\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0011¨\u0006\u0015"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceMainModeDehumHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceMainModeDehumBinding;", "binding", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/MainMode;", "Lkotlin/ParameterName;", "name", "mode", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceMainModeDehumBinding;Lkotlin/jvm/functions/Function1;)V", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "mainMode", "isEnabled", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceMainModeDehumHolder.kt */
public final class DeviceMainModeDehumHolder extends DeviceControlHolder<HolderDeviceMainModeDehumBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceMainModeDehumHolder(HolderDeviceMainModeDehumBinding holderDeviceMainModeDehumBinding, Function1<? super MainMode, Unit> function1) {
        super(holderDeviceMainModeDehumBinding);
        Intrinsics.checkNotNullParameter(holderDeviceMainModeDehumBinding, "binding");
        Intrinsics.checkNotNullParameter(function1, "onModeSelectedListener");
        holderDeviceMainModeDehumBinding.radioGroup.setOnCheckedChangeListener(new DeviceMainModeDehumHolder$$ExternalSyntheticLambda0(function1));
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceMainModeDehumHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceMainModeDehumHolder;", "parentView", "Landroid/view/ViewGroup;", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/MainMode;", "Lkotlin/ParameterName;", "name", "mode", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceMainModeDehumHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceMainModeDehumHolder newInstance(ViewGroup viewGroup, Function1<? super MainMode, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onModeSelectedListener");
            HolderDeviceMainModeDehumBinding inflate = HolderDeviceMainModeDehumBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceMainModeDehumHolder(inflate, function1);
        }
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(Function1 function1, RadioGroup radioGroup, int i) {
        MainMode mainMode;
        if (i == R.id.rb_purify) {
            mainMode = MainMode.AirPurify;
        } else {
            mainMode = i == R.id.rb_dehum ? MainMode.Dehumidification : null;
        }
        if (mainMode != null) {
            function1.invoke(mainMode);
        }
    }

    public void update(Device device, boolean z) {
        MainMode mainMode;
        Intrinsics.checkNotNullParameter(device, "device");
        HasMainMode hasMainMode = device instanceof HasMainMode ? (HasMainMode) device : null;
        if (hasMainMode != null && (mainMode = hasMainMode.mainMode()) != null) {
            update(mainMode, !DeviceKt.isStandByOn(device) && device.isOnline() && !z);
        }
    }

    public final void update(MainMode mainMode, boolean z) {
        Intrinsics.checkNotNullParameter(mainMode, "mainMode");
        com.blueair.viewcore.view.RadioGroup radioGroup = ((HolderDeviceMainModeDehumBinding) getBinding()).radioGroup;
        Intrinsics.checkNotNullExpressionValue(radioGroup, "radioGroup");
        for (View enabled : ViewGroupKt.getChildren(radioGroup)) {
            enabled.setEnabled(z);
        }
        ((HolderDeviceMainModeDehumBinding) getBinding()).radioGroup.checkSilence(mainMode == MainMode.AirPurify ? R.id.rb_purify : R.id.rb_dehum);
    }
}
