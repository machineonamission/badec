package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.databinding.ViewDataBinding;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasBody;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.HolderDeviceHAttributeFanSpeedBinding;
import com.blueair.devicedetails.databinding.HolderDeviceHFanSpeedBinding;
import com.blueair.devicedetails.databinding.HolderDeviceNFanSpeedBinding;
import com.blueair.devicedetails.util.EtaUtils;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#BD\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\nJ\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNFanSpeedHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Landroidx/databinding/ViewDataBinding;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onFanSpeedSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "Lkotlin/ParameterName;", "name", "speed", "", "<init>", "(Landroidx/databinding/ViewDataBinding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "()Z", "speed0", "Landroid/widget/RadioButton;", "speed4", "radioGroup", "Landroid/widget/RadioGroup;", "cleanAirEta", "Landroid/widget/TextView;", "setHolderEnabled", "enabled", "update", "speedEnum", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNFanSpeedHolder.kt */
public final class DeviceNFanSpeedHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ViewDataBinding binding;
    private final TextView cleanAirEta;
    private final Device device;
    private final boolean isInSchedule;
    private final Function1<FanSpeedEnum, Unit> onFanSpeedSelectedListener;
    private final RadioGroup radioGroup;
    private final RadioButton speed0;
    private final RadioButton speed4;

    public final ViewDataBinding getBinding() {
        return this.binding;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final boolean isInSchedule() {
        return this.isInSchedule;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¨\u0006\u0013"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNFanSpeedHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNFanSpeedHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onFanSpeedSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "Lkotlin/ParameterName;", "name", "speed", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNFanSpeedHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNFanSpeedHolder newInstance(ViewGroup viewGroup, Device device, boolean z, Function1<? super FanSpeedEnum, Unit> function1) {
            ViewDataBinding viewDataBinding;
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onFanSpeedSelectedListener");
            if (!z) {
                HolderDeviceHAttributeFanSpeedBinding inflate = HolderDeviceHAttributeFanSpeedBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNull(inflate);
                viewDataBinding = inflate;
            } else if (device instanceof DeviceNewClassic) {
                HolderDeviceNFanSpeedBinding inflate2 = HolderDeviceNFanSpeedBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNull(inflate2);
                viewDataBinding = inflate2;
            } else {
                HolderDeviceHFanSpeedBinding inflate3 = HolderDeviceHFanSpeedBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNull(inflate3);
                viewDataBinding = inflate3;
            }
            return new DeviceNFanSpeedHolder(viewDataBinding, device, z, function1);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceNFanSpeedHolder(androidx.databinding.ViewDataBinding r4, com.blueair.core.model.Device r5, boolean r6, kotlin.jvm.functions.Function1<? super com.blueair.core.model.FanSpeedEnum, kotlin.Unit> r7) {
        /*
            r3 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "onFanSpeedSelectedListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            android.view.View r0 = r4.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r3.<init>(r0)
            r3.binding = r4
            r3.device = r5
            r3.isInSchedule = r6
            r3.onFanSpeedSelectedListener = r7
            boolean r6 = r4 instanceof com.blueair.devicedetails.databinding.HolderDeviceHFanSpeedBinding
            r7 = 0
            java.lang.String r0 = "radioGroup"
            java.lang.String r1 = "speed4"
            java.lang.String r2 = "speed0"
            if (r6 == 0) goto L_0x0049
            r6 = r4
            com.blueair.devicedetails.databinding.HolderDeviceHFanSpeedBinding r6 = (com.blueair.devicedetails.databinding.HolderDeviceHFanSpeedBinding) r6
            android.widget.RadioButton r6 = r6.speed0
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            r3.speed0 = r6
            r6 = r4
            com.blueair.devicedetails.databinding.HolderDeviceHFanSpeedBinding r6 = (com.blueair.devicedetails.databinding.HolderDeviceHFanSpeedBinding) r6
            android.widget.RadioButton r6 = r6.speed4
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            r3.speed4 = r6
            com.blueair.devicedetails.databinding.HolderDeviceHFanSpeedBinding r4 = (com.blueair.devicedetails.databinding.HolderDeviceHFanSpeedBinding) r4
            android.widget.RadioGroup r4 = r4.radioGroup
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r3.radioGroup = r4
            r3.cleanAirEta = r7
            goto L_0x0099
        L_0x0049:
            boolean r6 = r4 instanceof com.blueair.devicedetails.databinding.HolderDeviceNFanSpeedBinding
            if (r6 == 0) goto L_0x006d
            r6 = r4
            com.blueair.devicedetails.databinding.HolderDeviceNFanSpeedBinding r6 = (com.blueair.devicedetails.databinding.HolderDeviceNFanSpeedBinding) r6
            android.widget.RadioButton r6 = r6.speed0
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            r3.speed0 = r6
            r6 = r4
            com.blueair.devicedetails.databinding.HolderDeviceNFanSpeedBinding r6 = (com.blueair.devicedetails.databinding.HolderDeviceNFanSpeedBinding) r6
            android.widget.RadioButton r6 = r6.speed4
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            r3.speed4 = r6
            com.blueair.devicedetails.databinding.HolderDeviceNFanSpeedBinding r4 = (com.blueair.devicedetails.databinding.HolderDeviceNFanSpeedBinding) r4
            android.widget.RadioGroup r4 = r4.radioGroup
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r3.radioGroup = r4
            r3.cleanAirEta = r7
            goto L_0x0099
        L_0x006d:
            java.lang.String r6 = "null cannot be cast to non-null type com.blueair.devicedetails.databinding.HolderDeviceHAttributeFanSpeedBinding"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r6)
            r6 = r4
            com.blueair.devicedetails.databinding.HolderDeviceHAttributeFanSpeedBinding r6 = (com.blueair.devicedetails.databinding.HolderDeviceHAttributeFanSpeedBinding) r6
            r6 = r4
            com.blueair.devicedetails.databinding.HolderDeviceHAttributeFanSpeedBinding r6 = (com.blueair.devicedetails.databinding.HolderDeviceHAttributeFanSpeedBinding) r6
            android.widget.RadioButton r6 = r6.speed0
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            r3.speed0 = r6
            r6 = r4
            com.blueair.devicedetails.databinding.HolderDeviceHAttributeFanSpeedBinding r6 = (com.blueair.devicedetails.databinding.HolderDeviceHAttributeFanSpeedBinding) r6
            android.widget.RadioButton r6 = r6.speed4
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            r3.speed4 = r6
            r6 = r4
            com.blueair.devicedetails.databinding.HolderDeviceHAttributeFanSpeedBinding r6 = (com.blueair.devicedetails.databinding.HolderDeviceHAttributeFanSpeedBinding) r6
            android.widget.RadioGroup r6 = r6.radioGroup
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            r3.radioGroup = r6
            com.blueair.devicedetails.databinding.HolderDeviceHAttributeFanSpeedBinding r4 = (com.blueair.devicedetails.databinding.HolderDeviceHAttributeFanSpeedBinding) r4
            android.widget.TextView r4 = r4.cleanAirEta
            r3.cleanAirEta = r4
        L_0x0099:
            boolean r4 = r5 instanceof com.blueair.core.model.HasFanSpeed
            if (r4 == 0) goto L_0x00a0
            r7 = r5
            com.blueair.core.model.HasFanSpeed r7 = (com.blueair.core.model.HasFanSpeed) r7
        L_0x00a0:
            if (r7 == 0) goto L_0x00aa
            boolean r4 = r7.getHasGear4()
            r6 = 1
            if (r4 != r6) goto L_0x00aa
            goto L_0x00b1
        L_0x00aa:
            android.widget.RadioButton r4 = r3.speed4
            android.view.View r4 = (android.view.View) r4
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r4)
        L_0x00b1:
            boolean r4 = r5 instanceof com.blueair.core.model.DevicePet20
            if (r4 == 0) goto L_0x00bc
            android.widget.RadioButton r4 = r3.speed0
            android.view.View r4 = (android.view.View) r4
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r4)
        L_0x00bc:
            android.widget.RadioGroup r4 = r3.radioGroup
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            kotlin.sequences.Sequence r4 = androidx.core.view.ViewGroupKt.getChildren(r4)
            java.util.Iterator r4 = r4.iterator()
        L_0x00c8:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00dd
            java.lang.Object r5 = r4.next()
            android.view.View r5 = (android.view.View) r5
            com.blueair.devicedetails.viewholder.DeviceNFanSpeedHolder$$ExternalSyntheticLambda0 r6 = new com.blueair.devicedetails.viewholder.DeviceNFanSpeedHolder$$ExternalSyntheticLambda0
            r6.<init>(r5, r3)
            r5.setOnClickListener(r6)
            goto L_0x00c8
        L_0x00dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceNFanSpeedHolder.<init>(androidx.databinding.ViewDataBinding, com.blueair.core.model.Device, boolean, kotlin.jvm.functions.Function1):void");
    }

    static final void lambda$1$lambda$0(View view, DeviceNFanSpeedHolder deviceNFanSpeedHolder, View view2) {
        int id = view.getId();
        int i = 0;
        if (id != R.id.speed_0) {
            if (id == R.id.speed_1) {
                i = 1;
            } else if (id == R.id.speed_2) {
                i = 2;
            } else if (id == R.id.speed_3) {
                i = 3;
            } else if (id == R.id.speed_4) {
                i = 4;
            }
        }
        deviceNFanSpeedHolder.onFanSpeedSelectedListener.invoke(FanSpeedEnum.Companion.fromStep(i, deviceNFanSpeedHolder.device));
    }

    private final void setHolderEnabled(boolean z) {
        for (View enabled : ViewGroupKt.getChildren(this.radioGroup)) {
            enabled.setEnabled(z);
        }
    }

    public void update(Device device2) {
        Intrinsics.checkNotNullParameter(device2, "device");
        if (device2 instanceof HasFanSpeed) {
            boolean z = device2 instanceof HasCombo3in1MainMode;
            update(z ? ((HasCombo3in1MainMode) device2).currentFanSpeedEnum() : ((HasFanSpeed) device2).getFanSpeedEnum());
            if (device2 instanceof HasBody) {
                setHolderEnabled(((HasBody) device2).getBodyMounted());
                return;
            }
            boolean z2 = true;
            if (z) {
                if (((HasMainMode) device2).isInMainMode(MainMode.HEAT) && device2.isUsDevice()) {
                    z2 = false;
                }
                setHolderEnabled(z2);
            } else if (device2 instanceof DeviceHumidifier) {
                DeviceHumidifier deviceHumidifier = (DeviceHumidifier) device2;
                if (Intrinsics.areEqual((Object) deviceHumidifier.getHardware(), (Object) "hum_n")) {
                    setHolderEnabled(!deviceHumidifier.getWaterShortage());
                }
            }
        }
    }

    public final void update(FanSpeedEnum fanSpeedEnum) {
        int i;
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "speedEnum");
        int step = fanSpeedEnum.toStep(this.device);
        if (step == 0) {
            i = R.id.speed_0;
        } else if (step == 1) {
            i = R.id.speed_1;
        } else if (step == 2) {
            i = R.id.speed_2;
        } else if (step != 3) {
            i = R.id.speed_4;
        } else {
            i = R.id.speed_3;
        }
        this.radioGroup.check(i);
    }

    public final void update(Device device2, IndoorDatapoint indoorDatapoint) {
        IndoorDatapoint indoorDatapoint2;
        Intrinsics.checkNotNullParameter(device2, "device");
        if (device2 instanceof HasFanSpeed) {
            Float f = null;
            if (indoorDatapoint == null) {
                HasSensorData hasSensorData = device2 instanceof HasSensorData ? (HasSensorData) device2 : null;
                indoorDatapoint2 = hasSensorData != null ? hasSensorData.getLatestSensorDatapoint() : null;
            } else {
                indoorDatapoint2 = indoorDatapoint;
            }
            if ((indoorDatapoint2 != null ? indoorDatapoint2.getPm25() : null) == null || this.isInSchedule || ((device2 instanceof HasWick) && ((HasWick) device2).getWickdryOn())) {
                TextView textView = this.cleanAirEta;
                if (textView != null) {
                    ViewExtensionsKt.hide(textView);
                    return;
                }
                return;
            }
            TextView textView2 = this.cleanAirEta;
            if (textView2 != null) {
                ViewExtensionsKt.show$default(textView2, false, 1, (Object) null);
            }
            TextView textView3 = this.cleanAirEta;
            if (textView3 != null) {
                EtaUtils etaUtils = EtaUtils.INSTANCE;
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                int fanSpeedValue = DeviceKt.fanSpeedValue(device2);
                if (indoorDatapoint != null) {
                    f = indoorDatapoint.getPm25();
                }
                textView3.setText(etaUtils.etaString(context, fanSpeedValue, f));
            }
        }
    }
}
