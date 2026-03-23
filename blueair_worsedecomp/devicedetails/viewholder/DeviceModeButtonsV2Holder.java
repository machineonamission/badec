package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.util.TypedValueCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceMiniRestful;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.adapter.DeviceModeButtonsV2Adapter;
import com.blueair.devicedetails.databinding.HolderDeviceModeButtonsV2Binding;
import com.blueair.viewcore.utils.ModeIcon;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB<\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J4\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001cR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceModeButtonsV2Holder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceModeButtonsV2Binding;", "binding", "device", "Lcom/blueair/core/model/Device;", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/viewcore/utils/ModeIcon;", "Lkotlin/ParameterName;", "name", "mode", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceModeButtonsV2Binding;Lcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function1;)V", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceModeButtonsV2Adapter;", "refreshLayout", "setRecyclerViewMarginH", "dp", "", "update", "forceOffline", "", "mainMode", "Lcom/blueair/core/model/MainMode;", "modeValue", "stayOffModeValues", "", "disableModeValues", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceModeButtonsV2Holder.kt */
public final class DeviceModeButtonsV2Holder extends DeviceControlHolder<HolderDeviceModeButtonsV2Binding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final DeviceModeButtonsV2Adapter adapter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceModeButtonsV2Holder(HolderDeviceModeButtonsV2Binding holderDeviceModeButtonsV2Binding, Device device, Function1<? super ModeIcon, Unit> function1) {
        super(holderDeviceModeButtonsV2Binding);
        Intrinsics.checkNotNullParameter(holderDeviceModeButtonsV2Binding, "binding");
        Intrinsics.checkNotNullParameter(function1, "onModeSelectedListener");
        DeviceModeButtonsV2Adapter deviceModeButtonsV2Adapter = new DeviceModeButtonsV2Adapter(function1);
        this.adapter = deviceModeButtonsV2Adapter;
        deviceModeButtonsV2Adapter.setDevice(device);
        refreshLayout();
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b¨\u0006\u0011"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceModeButtonsV2Holder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceModeButtonsV2Holder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/viewcore/utils/ModeIcon;", "Lkotlin/ParameterName;", "name", "mode", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceModeButtonsV2Holder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceModeButtonsV2Holder newInstance(ViewGroup viewGroup, Device device, Function1<? super ModeIcon, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onModeSelectedListener");
            HolderDeviceModeButtonsV2Binding inflate = HolderDeviceModeButtonsV2Binding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            inflate.getRoot().setItemAnimator((RecyclerView.ItemAnimator) null);
            return new DeviceModeButtonsV2Holder(inflate, device, function1);
        }
    }

    private final void refreshLayout() {
        RecyclerView recyclerView = ((HolderDeviceModeButtonsV2Binding) getBinding()).modeButtons;
        int coerceAtMost = RangesKt.coerceAtMost(this.adapter.getItemCount(), 4);
        if (coerceAtMost == 2) {
            setRecyclerViewMarginH(this.adapter.getDevice() instanceof DeviceMiniRestful ? 0.0f : 80.0f);
        } else if (coerceAtMost == 3) {
            setRecyclerViewMarginH(35.0f);
        }
        recyclerView.setLayoutManager(new GridLayoutManager(this.itemView.getContext(), coerceAtMost));
        recyclerView.setAdapter(this.adapter);
    }

    private final void setRecyclerViewMarginH(float f) {
        int dpToPx = (int) TypedValueCompat.dpToPx(f, ((HolderDeviceModeButtonsV2Binding) getBinding()).modeButtons.getContext().getResources().getDisplayMetrics());
        ViewGroup.LayoutParams layoutParams = ((HolderDeviceModeButtonsV2Binding) getBinding()).modeButtons.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.setMarginStart(dpToPx);
            marginLayoutParams.setMarginEnd(dpToPx);
            ((HolderDeviceModeButtonsV2Binding) getBinding()).modeButtons.setLayoutParams(marginLayoutParams);
        }
    }

    public void update(Device device, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
        int itemCount = this.adapter.getItemCount();
        this.adapter.setDevice(device);
        if (this.adapter.getItemCount() != itemCount) {
            refreshLayout();
        }
        this.adapter.setForceOffline(z);
    }

    public static /* synthetic */ void update$default(DeviceModeButtonsV2Holder deviceModeButtonsV2Holder, MainMode mainMode, ModeIcon modeIcon, Set set, Set set2, int i, Object obj) {
        if ((i & 8) != 0) {
            set2 = SetsKt.emptySet();
        }
        deviceModeButtonsV2Holder.update(mainMode, modeIcon, set, set2);
    }

    public final void update(MainMode mainMode, ModeIcon modeIcon, Set<? extends ModeIcon> set, Set<? extends ModeIcon> set2) {
        Intrinsics.checkNotNullParameter(mainMode, "mainMode");
        Intrinsics.checkNotNullParameter(modeIcon, "modeValue");
        Intrinsics.checkNotNullParameter(set, "stayOffModeValues");
        Intrinsics.checkNotNullParameter(set2, "disableModeValues");
        int itemCount = this.adapter.getItemCount();
        this.adapter.setMainMode(mainMode);
        if (this.adapter.getItemCount() != itemCount) {
            refreshLayout();
        }
        this.adapter.setModeValue(modeIcon);
        this.adapter.setDisableModeValues(set2);
        this.adapter.setStayOffModeValues(set);
    }
}
