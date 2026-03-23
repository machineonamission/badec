package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasStandBy;
import com.blueair.devicedetails.adapter.DeviceNModeButtonsAdapter;
import com.blueair.devicedetails.databinding.HolderDeviceHModeButtonsBinding;
import com.blueair.devicedetails.databinding.HolderDeviceNModeButtonBinding;
import com.blueair.devicedetails.databinding.HolderDeviceNModeButtonsBinding;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.ModeIcon;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"BD\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010 \u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNModeButtonsHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Landroidx/viewbinding/ViewBinding;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/viewcore/utils/ModeIcon;", "Lkotlin/ParameterName;", "name", "mode", "", "<init>", "(Landroidx/viewbinding/ViewBinding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "()Z", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceNModeButtonsAdapter;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "standbyHintText", "Landroid/widget/TextView;", "standbyModeRoot", "Lcom/blueair/devicedetails/databinding/HolderDeviceNModeButtonBinding;", "separator", "Landroid/view/View;", "update", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNModeButtonsHolder.kt */
public final class DeviceNModeButtonsHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final DeviceNModeButtonsAdapter adapter;
    private final ViewBinding binding;
    private final Device device;
    private final boolean isInSchedule;
    private final Function1<ModeIcon, Unit> onModeSelectedListener;
    private final RecyclerView recyclerView;
    private final View separator;
    private final TextView standbyHintText;
    private final HolderDeviceNModeButtonBinding standbyModeRoot;

    public final ViewBinding getBinding() {
        return this.binding;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final boolean isInSchedule() {
        return this.isInSchedule;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¨\u0006\u0013"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNModeButtonsHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNModeButtonsHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/viewcore/utils/ModeIcon;", "Lkotlin/ParameterName;", "name", "mode", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNModeButtonsHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNModeButtonsHolder newInstance(ViewGroup viewGroup, Device device, boolean z, Function1<? super ModeIcon, Unit> function1) {
            ViewBinding viewBinding;
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onModeSelectedListener");
            if ((device instanceof DeviceCombo2in1) || (device instanceof DevicePet20) || (((device instanceof DeviceHumidifier) && !z) || ((device instanceof DeviceNewClassic) && !z))) {
                HolderDeviceHModeButtonsBinding inflate = HolderDeviceHModeButtonsBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                viewBinding = inflate;
            } else {
                HolderDeviceNModeButtonsBinding inflate2 = HolderDeviceNModeButtonsBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
                viewBinding = inflate2;
            }
            return new DeviceNModeButtonsHolder(viewBinding, device, z, function1);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceNModeButtonsHolder(androidx.viewbinding.ViewBinding r11, com.blueair.core.model.Device r12, boolean r13, kotlin.jvm.functions.Function1<? super com.blueair.viewcore.utils.ModeIcon, kotlin.Unit> r14) {
        /*
            r10 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "onModeSelectedListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            android.view.View r0 = r11.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r10.<init>(r0)
            r10.binding = r11
            r10.device = r12
            r10.isInSchedule = r13
            r10.onModeSelectedListener = r14
            com.blueair.devicedetails.adapter.DeviceNModeButtonsAdapter r2 = new com.blueair.devicedetails.adapter.DeviceNModeButtonsAdapter
            r6 = 4
            r7 = 0
            r5 = 0
            r3 = r13
            r4 = r14
            r2.<init>(r3, r4, r5, r6, r7)
            r10.adapter = r2
            boolean r13 = r11 instanceof com.blueair.devicedetails.databinding.HolderDeviceHModeButtonsBinding
            java.lang.String r14 = "modeButtons"
            if (r13 == 0) goto L_0x009b
            r13 = r11
            com.blueair.devicedetails.databinding.HolderDeviceHModeButtonsBinding r13 = (com.blueair.devicedetails.databinding.HolderDeviceHModeButtonsBinding) r13
            androidx.recyclerview.widget.RecyclerView r13 = r13.modeButtons
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            r10.recyclerView = r13
            r13 = r11
            com.blueair.devicedetails.databinding.HolderDeviceHModeButtonsBinding r13 = (com.blueair.devicedetails.databinding.HolderDeviceHModeButtonsBinding) r13
            android.widget.TextView r13 = r13.standbyHint
            r10.standbyHintText = r13
            r14 = r11
            com.blueair.devicedetails.databinding.HolderDeviceHModeButtonsBinding r14 = (com.blueair.devicedetails.databinding.HolderDeviceHModeButtonsBinding) r14
            com.blueair.devicedetails.databinding.HolderDeviceNModeButtonBinding r14 = r14.standbyModeRoot
            r10.standbyModeRoot = r14
            com.blueair.devicedetails.databinding.HolderDeviceHModeButtonsBinding r11 = (com.blueair.devicedetails.databinding.HolderDeviceHModeButtonsBinding) r11
            android.view.View r11 = r11.separator
            r10.separator = r11
            if (r3 == 0) goto L_0x0063
            android.view.View r13 = (android.view.View) r13
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r13)
            android.view.View r13 = r14.getRoot()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r1)
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r13)
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r11)
            goto L_0x00b3
        L_0x0063:
            boolean r0 = r12 instanceof com.blueair.core.model.DeviceNewClassic
            android.view.View r3 = r14.getRoot()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r3, r0)
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r11, r0)
            if (r0 == 0) goto L_0x0083
            int r11 = com.blueair.viewcore.R.string.air_purifier_off_msg
            r13.setText(r11)
            android.widget.LinearLayout r11 = r14.modeRoot
            com.blueair.devicedetails.viewholder.DeviceNModeButtonsHolder$$ExternalSyntheticLambda0 r13 = new com.blueair.devicedetails.viewholder.DeviceNModeButtonsHolder$$ExternalSyntheticLambda0
            r13.<init>(r10)
            r11.setOnClickListener(r13)
        L_0x0083:
            com.blueair.viewcore.ViewUtils r3 = com.blueair.viewcore.ViewUtils.INSTANCE
            android.view.View r4 = r14.getRoot()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            java.lang.Class<android.widget.RadioButton> r11 = android.widget.RadioButton.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r11)
            r8 = 12
            r9 = 0
            r6 = 0
            r7 = 0
            com.blueair.viewcore.ViewUtils.setAccessibilityDelegate$default(r3, r4, r5, r6, r7, r8, r9)
            goto L_0x00b3
        L_0x009b:
            java.lang.String r13 = "null cannot be cast to non-null type com.blueair.devicedetails.databinding.HolderDeviceNModeButtonsBinding"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11, r13)
            r13 = r11
            com.blueair.devicedetails.databinding.HolderDeviceNModeButtonsBinding r13 = (com.blueair.devicedetails.databinding.HolderDeviceNModeButtonsBinding) r13
            com.blueair.devicedetails.databinding.HolderDeviceNModeButtonsBinding r11 = (com.blueair.devicedetails.databinding.HolderDeviceNModeButtonsBinding) r11
            androidx.recyclerview.widget.RecyclerView r11 = r11.modeButtons
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r14)
            r10.recyclerView = r11
            r11 = 0
            r10.standbyHintText = r11
            r10.standbyModeRoot = r11
            r10.separator = r11
        L_0x00b3:
            r2.setDevice(r12)
            androidx.recyclerview.widget.RecyclerView r11 = r10.recyclerView
            androidx.recyclerview.widget.GridLayoutManager r12 = new androidx.recyclerview.widget.GridLayoutManager
            android.view.View r13 = r10.itemView
            android.content.Context r13 = r13.getContext()
            int r14 = r2.getItemCount()
            r0 = 4
            if (r14 >= r0) goto L_0x00cb
            int r0 = r2.getItemCount()
        L_0x00cb:
            r12.<init>(r13, r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r12 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r12
            r11.setLayoutManager(r12)
            androidx.recyclerview.widget.RecyclerView r11 = r10.recyclerView
            androidx.recyclerview.widget.RecyclerView$Adapter r2 = (androidx.recyclerview.widget.RecyclerView.Adapter) r2
            r11.setAdapter(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceNModeButtonsHolder.<init>(androidx.viewbinding.ViewBinding, com.blueair.core.model.Device, boolean, kotlin.jvm.functions.Function1):void");
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceNModeButtonsHolder deviceNModeButtonsHolder, View view) {
        deviceNModeButtonsHolder.onModeSelectedListener.invoke(ModeIcon.STANDBY);
    }

    public void update(Device device2) {
        View root;
        Intrinsics.checkNotNullParameter(device2, "device");
        this.adapter.setDevice(device2);
        TextView textView = this.standbyHintText;
        if (textView != null) {
            ViewExtensionsKt.show(textView, ((device2 instanceof DeviceHumidifier) || (device2 instanceof DeviceNewClassic)) && ((HasStandBy) device2).isStandByOn());
        }
        HolderDeviceNModeButtonBinding holderDeviceNModeButtonBinding = this.standbyModeRoot;
        if (holderDeviceNModeButtonBinding != null && (root = holderDeviceNModeButtonBinding.getRoot()) != null && root.getVisibility() == 0 && (device2 instanceof HasStandBy)) {
            HolderDeviceNModeButtonBinding holderDeviceNModeButtonBinding2 = this.standbyModeRoot;
            HasStandBy hasStandBy = (HasStandBy) device2;
            if (hasStandBy.isStandByOn()) {
                holderDeviceNModeButtonBinding2.modeIcon.setImageResource(ModeIcon.STANDBY.getOnIcon());
                holderDeviceNModeButtonBinding2.modeText.setText(R.string.turn_on);
            } else {
                holderDeviceNModeButtonBinding2.modeIcon.setImageResource(ModeIcon.STANDBY.getOffIcon());
                holderDeviceNModeButtonBinding2.modeText.setText(R.string.on);
            }
            this.standbyModeRoot.getRoot().setSelected(!hasStandBy.isStandByOn());
        }
    }

    public final void update(Device device2, DeviceCreateEditScheduleViewModel.PurifierMode purifierMode) {
        Intrinsics.checkNotNullParameter(device2, "device");
        Intrinsics.checkNotNullParameter(purifierMode, "mode");
        this.adapter.setPurifierMode(purifierMode);
        this.adapter.setDevice(device2);
    }
}
