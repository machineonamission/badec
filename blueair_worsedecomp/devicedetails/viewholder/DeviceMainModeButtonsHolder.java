package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.adapter.DeviceNModeButtonsAdapter;
import com.blueair.devicedetails.databinding.HolderDeviceMainModeButtonsBinding;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.utils.ModeIcon;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u0004¢\u0006\u0002\n\u0000R)\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceMainModeButtonsHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceMainModeButtonsBinding;", "device", "Lcom/blueair/core/model/Device;", "onMainModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/MainMode;", "Lkotlin/ParameterName;", "name", "mode", "", "onSubModeSelectedListener", "Lcom/blueair/core/model/ApSubMode;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceMainModeButtonsBinding;Lcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceMainModeButtonsBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "mainModeAdapter", "Lcom/blueair/devicedetails/adapter/DeviceNModeButtonsAdapter;", "subModeAdapter", "update", "mainMode", "subMode", "isStandbyOn", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceMainModeButtonsHolder.kt */
public final class DeviceMainModeButtonsHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceMainModeButtonsBinding binding;
    private final Device device;
    private final DeviceNModeButtonsAdapter mainModeAdapter;
    private final Function1<MainMode, Unit> onMainModeSelectedListener;
    private final Function1<ApSubMode, Unit> onSubModeSelectedListener;
    private final DeviceNModeButtonsAdapter subModeAdapter;

    public final HolderDeviceMainModeButtonsBinding getBinding() {
        return this.binding;
    }

    public final Device getDevice() {
        return this.device;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J^\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b¨\u0006\u0013"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceMainModeButtonsHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceMainModeButtonsHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "onMainModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/MainMode;", "Lkotlin/ParameterName;", "name", "mode", "", "onSubModeSelectedListener", "Lcom/blueair/core/model/ApSubMode;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceMainModeButtonsHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceMainModeButtonsHolder newInstance(ViewGroup viewGroup, Device device, Function1<? super MainMode, Unit> function1, Function1<? super ApSubMode, Unit> function12) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onMainModeSelectedListener");
            Intrinsics.checkNotNullParameter(function12, "onSubModeSelectedListener");
            HolderDeviceMainModeButtonsBinding inflate = HolderDeviceMainModeButtonsBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceMainModeButtonsHolder(inflate, device, function1, function12);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceMainModeButtonsHolder(com.blueair.devicedetails.databinding.HolderDeviceMainModeButtonsBinding r8, com.blueair.core.model.Device r9, kotlin.jvm.functions.Function1<? super com.blueair.core.model.MainMode, kotlin.Unit> r10, kotlin.jvm.functions.Function1<? super com.blueair.core.model.ApSubMode, kotlin.Unit> r11) {
        /*
            r7 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "onMainModeSelectedListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "onSubModeSelectedListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            android.widget.LinearLayout r0 = r8.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r7.<init>(r0)
            r7.binding = r8
            r7.device = r9
            r7.onMainModeSelectedListener = r10
            r7.onSubModeSelectedListener = r11
            com.blueair.devicedetails.adapter.DeviceNModeButtonsAdapter r9 = new com.blueair.devicedetails.adapter.DeviceNModeButtonsAdapter
            com.blueair.devicedetails.viewholder.DeviceMainModeButtonsHolder$$ExternalSyntheticLambda0 r10 = new com.blueair.devicedetails.viewholder.DeviceMainModeButtonsHolder$$ExternalSyntheticLambda0
            r10.<init>(r7)
            r11 = 1
            r0 = 0
            r9.<init>(r0, r10, r11)
            r7.mainModeAdapter = r9
            com.blueair.devicedetails.adapter.DeviceNModeButtonsAdapter r1 = new com.blueair.devicedetails.adapter.DeviceNModeButtonsAdapter
            com.blueair.devicedetails.viewholder.DeviceMainModeButtonsHolder$$ExternalSyntheticLambda1 r3 = new com.blueair.devicedetails.viewholder.DeviceMainModeButtonsHolder$$ExternalSyntheticLambda1
            r3.<init>(r7)
            r5 = 4
            r6 = 0
            r2 = 0
            r4 = 0
            r1.<init>(r2, r3, r4, r5, r6)
            r7.subModeAdapter = r1
            androidx.recyclerview.widget.RecyclerView r10 = r8.mainModeButtons
            androidx.recyclerview.widget.GridLayoutManager r11 = new androidx.recyclerview.widget.GridLayoutManager
            android.view.View r0 = r7.itemView
            android.content.Context r0 = r0.getContext()
            r2 = 4
            r11.<init>(r0, r2)
            com.blueair.devicedetails.viewholder.DeviceMainModeButtonsHolder$1$1 r0 = new com.blueair.devicedetails.viewholder.DeviceMainModeButtonsHolder$1$1
            r0.<init>()
            androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup r0 = (androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup) r0
            r11.setSpanSizeLookup(r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r11 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r11
            r10.setLayoutManager(r11)
            androidx.recyclerview.widget.RecyclerView r10 = r8.mainModeButtons
            androidx.recyclerview.widget.RecyclerView$Adapter r9 = (androidx.recyclerview.widget.RecyclerView.Adapter) r9
            r10.setAdapter(r9)
            androidx.recyclerview.widget.RecyclerView r9 = r8.subModeButtons
            androidx.recyclerview.widget.GridLayoutManager r10 = new androidx.recyclerview.widget.GridLayoutManager
            android.view.View r11 = r7.itemView
            android.content.Context r11 = r11.getContext()
            r10.<init>(r11, r2)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r10 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r10
            r9.setLayoutManager(r10)
            androidx.recyclerview.widget.RecyclerView r8 = r8.subModeButtons
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = (androidx.recyclerview.widget.RecyclerView.Adapter) r1
            r8.setAdapter(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceMainModeButtonsHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceMainModeButtonsBinding, com.blueair.core.model.Device, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void");
    }

    /* access modifiers changed from: private */
    public static final Unit mainModeAdapter$lambda$0(DeviceMainModeButtonsHolder deviceMainModeButtonsHolder, ModeIcon modeIcon) {
        Intrinsics.checkNotNullParameter(modeIcon, "it");
        MainMode mainMode = modeIcon.toMainMode();
        if (mainMode != null) {
            deviceMainModeButtonsHolder.onMainModeSelectedListener.invoke(mainMode);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit subModeAdapter$lambda$1(DeviceMainModeButtonsHolder deviceMainModeButtonsHolder, ModeIcon modeIcon) {
        Intrinsics.checkNotNullParameter(modeIcon, "it");
        ApSubMode apSubMode = modeIcon.toApSubMode();
        if (apSubMode != null) {
            deviceMainModeButtonsHolder.onSubModeSelectedListener.invoke(apSubMode);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        if (r2.isStandByOn() == false) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(com.blueair.core.model.Device r5) {
        /*
            r4 = this;
            java.lang.String r0 = "device"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.blueair.devicedetails.adapter.DeviceNModeButtonsAdapter r0 = r4.mainModeAdapter
            r0.setDevice(r5)
            com.blueair.devicedetails.adapter.DeviceNModeButtonsAdapter r0 = r4.subModeAdapter
            r0.setDevice(r5)
            com.blueair.devicedetails.databinding.HolderDeviceMainModeButtonsBinding r0 = r4.binding
            android.widget.TextView r0 = r0.heatHint
            java.lang.String r1 = "heatHint"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            boolean r1 = r5 instanceof com.blueair.core.model.HasCombo3in1MainMode
            r2 = 0
            if (r1 == 0) goto L_0x0023
            r1 = r5
            com.blueair.core.model.HasCombo3in1MainMode r1 = (com.blueair.core.model.HasCombo3in1MainMode) r1
            goto L_0x0024
        L_0x0023:
            r1 = r2
        L_0x0024:
            if (r1 == 0) goto L_0x003f
            com.blueair.core.model.MainMode r3 = com.blueair.core.model.MainMode.HEAT
            boolean r1 = r1.isInMainMode(r3)
            r3 = 1
            if (r1 != r3) goto L_0x003f
            boolean r1 = r5 instanceof com.blueair.core.model.HasStandBy
            if (r1 == 0) goto L_0x0036
            r2 = r5
            com.blueair.core.model.HasStandBy r2 = (com.blueair.core.model.HasStandBy) r2
        L_0x0036:
            if (r2 == 0) goto L_0x003f
            boolean r5 = r2.isStandByOn()
            if (r5 != 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r3 = 0
        L_0x0040:
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceMainModeButtonsHolder.update(com.blueair.core.model.Device):void");
    }

    public final void update(Device device2, MainMode mainMode, ApSubMode apSubMode, boolean z) {
        Intrinsics.checkNotNullParameter(device2, "device");
        Intrinsics.checkNotNullParameter(mainMode, "mainMode");
        Intrinsics.checkNotNullParameter(apSubMode, "subMode");
        this.mainModeAdapter.setPurifierMainMode(mainMode);
        this.subModeAdapter.setPurifierMainMode(mainMode);
        DeviceCreateEditScheduleViewModel.PurifierMode fromSubMode = z ? DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY : DeviceCreateEditScheduleViewModel.PurifierMode.Companion.fromSubMode(apSubMode);
        this.mainModeAdapter.setPurifierMode(fromSubMode);
        this.subModeAdapter.setPurifierMode(fromSubMode);
        this.subModeAdapter.setDevice(device2);
        this.mainModeAdapter.setDevice(device2);
        TextView textView = this.binding.heatHint;
        Intrinsics.checkNotNullExpressionValue(textView, "heatHint");
        ViewExtensionsKt.hide(textView);
    }
}
