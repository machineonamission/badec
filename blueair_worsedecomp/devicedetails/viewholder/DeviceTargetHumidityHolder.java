package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.databinding.HolderDeviceTargetHumidityBinding;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%Bf\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\f\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0007H\u0016J\u001e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0018R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\fX\u0004¢\u0006\u0002\n\u0000R)\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006&"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTargetHumidityHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceTargetHumidityBinding;", "binding", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onOpenInfoListener", "Lkotlin/Function0;", "", "onShowHintListener", "Lkotlin/Function1;", "onTargetSetListener", "", "Lkotlin/ParameterName;", "name", "autoRh", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceTargetHumidityBinding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "()Z", "inTouch", "minHum", "getMinHum", "()I", "update", "autorh", "disabled", "active", "forceOffline", "mode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "canActive", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceTargetHumidityHolder.kt */
public final class DeviceTargetHumidityHolder extends DeviceControlHolder<HolderDeviceTargetHumidityBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Device device;
    /* access modifiers changed from: private */
    public boolean inTouch;
    private final boolean isInSchedule;
    private final Function0<Unit> onOpenInfoListener;
    private final Function1<Boolean, Unit> onShowHintListener;
    /* access modifiers changed from: private */
    public final Function1<Integer, Unit> onTargetSetListener;

    private final int getMinHum() {
        return 30;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final void setDevice(Device device2) {
        this.device = device2;
    }

    public final boolean isInSchedule() {
        return this.isInSchedule;
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Je\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\u00102!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000e0\u0010¨\u0006\u0016"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTargetHumidityHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceTargetHumidityHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onOpenInfoListener", "Lkotlin/Function0;", "", "onShowHintListener", "Lkotlin/Function1;", "onTargetSetListener", "", "Lkotlin/ParameterName;", "name", "autoRh", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceTargetHumidityHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceTargetHumidityHolder newInstance(ViewGroup viewGroup, Device device, boolean z, Function0<Unit> function0, Function1<? super Boolean, Unit> function1, Function1<? super Integer, Unit> function12) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onOpenInfoListener");
            Intrinsics.checkNotNullParameter(function1, "onShowHintListener");
            Intrinsics.checkNotNullParameter(function12, "onTargetSetListener");
            HolderDeviceTargetHumidityBinding inflate = HolderDeviceTargetHumidityBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceTargetHumidityHolder(inflate, device, z, function0, function1, function12);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceTargetHumidityHolder(HolderDeviceTargetHumidityBinding holderDeviceTargetHumidityBinding, Device device2, boolean z, Function0<Unit> function0, Function1<? super Boolean, Unit> function1, Function1<? super Integer, Unit> function12) {
        super(holderDeviceTargetHumidityBinding);
        Intrinsics.checkNotNullParameter(holderDeviceTargetHumidityBinding, "binding");
        Intrinsics.checkNotNullParameter(function0, "onOpenInfoListener");
        Intrinsics.checkNotNullParameter(function1, "onShowHintListener");
        Intrinsics.checkNotNullParameter(function12, "onTargetSetListener");
        this.device = device2;
        this.isInSchedule = z;
        this.onOpenInfoListener = function0;
        this.onShowHintListener = function1;
        this.onTargetSetListener = function12;
        holderDeviceTargetHumidityBinding.ivInfo.setOnClickListener(new DeviceTargetHumidityHolder$$ExternalSyntheticLambda0(this));
        holderDeviceTargetHumidityBinding.clickView.setOnClickListener(new DeviceTargetHumidityHolder$$ExternalSyntheticLambda1(holderDeviceTargetHumidityBinding));
        holderDeviceTargetHumidityBinding.expendSwitch.setChecked(false);
        holderDeviceTargetHumidityBinding.expendSwitch.setOnCheckedChangeListener(new DeviceTargetHumidityHolder$$ExternalSyntheticLambda2(holderDeviceTargetHumidityBinding));
        TextView textView = holderDeviceTargetHumidityBinding.tvProgress0;
        StringBuilder sb = new StringBuilder();
        sb.append(getMinHum());
        sb.append('%');
        textView.setText(sb.toString());
        if (Build.VERSION.SDK_INT >= 26) {
            holderDeviceTargetHumidityBinding.seekbar.setMin(getMinHum());
        }
        holderDeviceTargetHumidityBinding.seekbar.setOnSeekBarChangeListener(new DeviceTargetHumidityHolder$1$4(holderDeviceTargetHumidityBinding, this));
    }

    static final void lambda$3$lambda$0(DeviceTargetHumidityHolder deviceTargetHumidityHolder, View view) {
        deviceTargetHumidityHolder.onOpenInfoListener.invoke();
    }

    static final void lambda$3$lambda$1(HolderDeviceTargetHumidityBinding holderDeviceTargetHumidityBinding, View view) {
        holderDeviceTargetHumidityBinding.expendSwitch.setChecked(!holderDeviceTargetHumidityBinding.expendSwitch.isChecked());
    }

    static final void lambda$3$lambda$2(HolderDeviceTargetHumidityBinding holderDeviceTargetHumidityBinding, CompoundButton compoundButton, boolean z) {
        Group group = holderDeviceTargetHumidityBinding.expendedContent;
        Intrinsics.checkNotNullExpressionValue(group, "expendedContent");
        ViewExtensionsKt.show(group, !z);
    }

    private final void update(int i) {
        int coerceIn = RangesKt.coerceIn(i, getMinHum(), 80);
        ((HolderDeviceTargetHumidityBinding) getBinding()).seekbar.setProgress(coerceIn);
        TextView textView = ((HolderDeviceTargetHumidityBinding) getBinding()).progressText;
        StringBuilder sb = new StringBuilder();
        sb.append(coerceIn);
        sb.append('%');
        textView.setText(sb.toString());
    }

    private final void update(boolean z, boolean z2) {
        HolderDeviceTargetHumidityBinding holderDeviceTargetHumidityBinding = (HolderDeviceTargetHumidityBinding) getBinding();
        if (z) {
            holderDeviceTargetHumidityBinding.clickView.setEnabled(false);
            holderDeviceTargetHumidityBinding.expendSwitch.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.fill_grey)));
            SwitchCompat switchCompat = holderDeviceTargetHumidityBinding.expendSwitch;
            Intrinsics.checkNotNullExpressionValue(switchCompat, "expendSwitch");
            ViewExtensionsKt.show(switchCompat, true);
            holderDeviceTargetHumidityBinding.expendSwitch.setChecked(true);
            Group group = holderDeviceTargetHumidityBinding.expendedContent;
            Intrinsics.checkNotNullExpressionValue(group, "expendedContent");
            ViewExtensionsKt.show(group, false);
            holderDeviceTargetHumidityBinding.getRoot().setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.surface_dark_5)));
            holderDeviceTargetHumidityBinding.leadingIcon.setImageResource(R.drawable.ic_hum_disabled);
            holderDeviceTargetHumidityBinding.title.setTextColor(getColor(R.color.surface_dark_55));
            holderDeviceTargetHumidityBinding.progressText.setText("");
            this.onShowHintListener.invoke(false);
            return;
        }
        holderDeviceTargetHumidityBinding.getRoot().setBackgroundTintList((ColorStateList) null);
        holderDeviceTargetHumidityBinding.expendSwitch.setBackgroundTintList((ColorStateList) null);
        holderDeviceTargetHumidityBinding.leadingIcon.setImageResource(R.drawable.ic_hum);
        holderDeviceTargetHumidityBinding.title.setTextColor(getColor(R.color.colorPrimaryText));
        if (z2) {
            holderDeviceTargetHumidityBinding.clickView.setEnabled(true);
            SwitchCompat switchCompat2 = holderDeviceTargetHumidityBinding.expendSwitch;
            Intrinsics.checkNotNullExpressionValue(switchCompat2, "expendSwitch");
            ViewExtensionsKt.show(switchCompat2, true);
            Group group2 = holderDeviceTargetHumidityBinding.expendedContent;
            Intrinsics.checkNotNullExpressionValue(group2, "expendedContent");
            ViewExtensionsKt.show(group2, !holderDeviceTargetHumidityBinding.expendSwitch.isChecked());
            this.onShowHintListener.invoke(false);
            return;
        }
        holderDeviceTargetHumidityBinding.clickView.setEnabled(false);
        SwitchCompat switchCompat3 = holderDeviceTargetHumidityBinding.expendSwitch;
        Intrinsics.checkNotNullExpressionValue(switchCompat3, "expendSwitch");
        ViewExtensionsKt.show(switchCompat3, false);
        Group group3 = holderDeviceTargetHumidityBinding.expendedContent;
        Intrinsics.checkNotNullExpressionValue(group3, "expendedContent");
        ViewExtensionsKt.show(group3, false);
        holderDeviceTargetHumidityBinding.progressText.setText("");
        this.onShowHintListener.invoke(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        if (r5.isInDehSubMode(com.blueair.core.model.DehSubMode.AUTO) != false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0062, code lost:
        if (com.blueair.devicedetails.util.DeviceControlUtils.INSTANCE.checkAutoMode(r5) != false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0078, code lost:
        if (com.blueair.devicedetails.util.DeviceControlUtils.INSTANCE.checkAutoMode(r5) != false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0095, code lost:
        if (r5.isInHumSubMode(com.blueair.core.model.HumSubMode.AUTO) != false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b6, code lost:
        if (r5.getWaterShortage() != false) goto L_0x00bf;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(com.blueair.core.model.Device r5, boolean r6) {
        /*
            r4 = this;
            java.lang.String r0 = "device"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r4.device = r5
            boolean r0 = r4.inTouch
            if (r0 == 0) goto L_0x000c
            return
        L_0x000c:
            boolean r0 = r5 instanceof com.blueair.core.model.HasAutoRh
            if (r0 == 0) goto L_0x001a
            r0 = r5
            com.blueair.core.model.HasAutoRh r0 = (com.blueair.core.model.HasAutoRh) r0
            int r0 = r0.getAutoRh()
            r4.update(r0)
        L_0x001a:
            r0 = 0
            r1 = 1
            if (r6 != 0) goto L_0x002d
            boolean r6 = r5.isOnline()
            if (r6 == 0) goto L_0x002d
            boolean r6 = com.blueair.core.model.DeviceKt.isStandByOn(r5)
            if (r6 == 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r6 = r0
            goto L_0x002e
        L_0x002d:
            r6 = r1
        L_0x002e:
            boolean r2 = r5 instanceof com.blueair.core.model.HasDehumidifierMainMode
            if (r2 == 0) goto L_0x0047
            com.blueair.core.model.HasDehumidifierMainMode r5 = (com.blueair.core.model.HasDehumidifierMainMode) r5
            com.blueair.core.model.MainMode r2 = com.blueair.core.model.MainMode.Dehumidification
            boolean r2 = r5.isInMainMode(r2)
            if (r2 == 0) goto L_0x00bf
            com.blueair.core.model.DehSubMode r2 = com.blueair.core.model.DehSubMode.AUTO
            boolean r5 = r5.isInDehSubMode(r2)
            if (r5 == 0) goto L_0x00bf
        L_0x0044:
            r0 = r1
            goto L_0x00bf
        L_0x0047:
            boolean r2 = r5 instanceof com.blueair.core.model.DeviceHumidifier20
            if (r2 == 0) goto L_0x0065
            r2 = r5
            com.blueair.core.model.DeviceHumidifier20 r2 = (com.blueair.core.model.DeviceHumidifier20) r2
            boolean r3 = r2.getWickdryOn()
            if (r3 != 0) goto L_0x00bf
            com.blueair.core.model.WaterLevel r3 = com.blueair.core.model.WaterLevel.SHORTAGE
            boolean r2 = r2.isInWaterLevel(r3)
            if (r2 != 0) goto L_0x00bf
            com.blueair.devicedetails.util.DeviceControlUtils r2 = com.blueair.devicedetails.util.DeviceControlUtils.INSTANCE
            boolean r5 = r2.checkAutoMode(r5)
            if (r5 == 0) goto L_0x00bf
            goto L_0x0044
        L_0x0065:
            boolean r2 = r5 instanceof com.blueair.core.model.HasHumMode
            if (r2 == 0) goto L_0x007b
            r2 = r5
            com.blueair.core.model.HasHumMode r2 = (com.blueair.core.model.HasHumMode) r2
            boolean r2 = r2.getHumMode()
            if (r2 == 0) goto L_0x00bf
            com.blueair.devicedetails.util.DeviceControlUtils r2 = com.blueair.devicedetails.util.DeviceControlUtils.INSTANCE
            boolean r5 = r2.checkAutoMode(r5)
            if (r5 == 0) goto L_0x00bf
            goto L_0x0044
        L_0x007b:
            boolean r2 = r5 instanceof com.blueair.core.model.DeviceCombo2in120
            if (r2 == 0) goto L_0x0098
            boolean r2 = com.blueair.core.model.DeviceKt.isHumidifyModeOn(r5)
            if (r2 == 0) goto L_0x00bf
            com.blueair.core.model.DeviceCombo2in120 r5 = (com.blueair.core.model.DeviceCombo2in120) r5
            com.blueair.core.model.WaterLevel r2 = com.blueair.core.model.WaterLevel.SHORTAGE
            boolean r2 = r5.isInWaterLevel(r2)
            if (r2 != 0) goto L_0x00bf
            com.blueair.core.model.HumSubMode r2 = com.blueair.core.model.HumSubMode.AUTO
            boolean r5 = r5.isInHumSubMode(r2)
            if (r5 == 0) goto L_0x00bf
            goto L_0x0044
        L_0x0098:
            boolean r2 = r5 instanceof com.blueair.core.model.DeviceHumidifier
            if (r2 == 0) goto L_0x00b9
            com.blueair.devicedetails.util.DeviceControlUtils r2 = com.blueair.devicedetails.util.DeviceControlUtils.INSTANCE
            boolean r2 = r2.checkAutoMode(r5)
            if (r2 == 0) goto L_0x00bf
            com.blueair.core.model.DeviceHumidifier r5 = (com.blueair.core.model.DeviceHumidifier) r5
            java.lang.String r2 = r5.getHardware()
            java.lang.String r3 = "hum_n"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0044
            boolean r5 = r5.getWaterShortage()
            if (r5 != 0) goto L_0x00bf
            goto L_0x0044
        L_0x00b9:
            com.blueair.devicedetails.util.DeviceControlUtils r0 = com.blueair.devicedetails.util.DeviceControlUtils.INSTANCE
            boolean r0 = r0.checkAutoMode(r5)
        L_0x00bf:
            r4.update((boolean) r6, (boolean) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceTargetHumidityHolder.update(com.blueair.core.model.Device, boolean):void");
    }

    public final void update(int i, DeviceCreateEditScheduleViewModel.PurifierMode purifierMode, boolean z) {
        Intrinsics.checkNotNullParameter(purifierMode, "mode");
        update(i);
        boolean z2 = true;
        boolean z3 = purifierMode == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY;
        if (purifierMode != DeviceCreateEditScheduleViewModel.PurifierMode.AUTO || !z) {
            z2 = false;
        }
        update(z3, z2);
    }
}
