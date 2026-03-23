package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.viewholder.DeviceModeButtonV2Holder;
import com.blueair.viewcore.utils.ModeIcon;
import com.blueair.viewcore.utils.ModeIconKt;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B.\u0012%\b\u0002\u0010\u0003\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010/\u001a\u00020\tH\u0002J\b\u00100\u001a\u000201H\u0016J\u0018\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000201H\u0016J\u0018\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u000201H\u0016R+\u0010\u0003\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R0\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR0\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\"X\u000e¢\u0006\u0002\n\u0000R(\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\f\u001a\u0004\u0018\u00010#@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010*\u001a\u00020)2\u0006\u0010\f\u001a\u00020)@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00069"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceModeButtonsV2Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceModeButtonV2Holder;", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/viewcore/utils/ModeIcon;", "Lkotlin/ParameterName;", "name", "mode", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "value", "Lcom/blueair/core/model/MainMode;", "mainMode", "getMainMode", "()Lcom/blueair/core/model/MainMode;", "setMainMode", "(Lcom/blueair/core/model/MainMode;)V", "modeValue", "getModeValue", "()Lcom/blueair/viewcore/utils/ModeIcon;", "setModeValue", "(Lcom/blueair/viewcore/utils/ModeIcon;)V", "", "disableModeValues", "getDisableModeValues", "()Ljava/util/Set;", "setDisableModeValues", "(Ljava/util/Set;)V", "stayOffModeValues", "getStayOffModeValues", "setStayOffModeValues", "modes", "", "Lcom/blueair/core/model/Device;", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "", "forceOffline", "getForceOffline", "()Z", "setForceOffline", "(Z)V", "refreshItems", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceModeButtonsV2Adapter.kt */
public final class DeviceModeButtonsV2Adapter extends RecyclerView.Adapter<DeviceModeButtonV2Holder> {
    private Device device;
    private Set<? extends ModeIcon> disableModeValues;
    private boolean forceOffline;
    private MainMode mainMode;
    private ModeIcon modeValue;
    private List<? extends ModeIcon> modes;
    private final Function1<ModeIcon, Unit> onModeSelectedListener;
    private Set<? extends ModeIcon> stayOffModeValues;

    public DeviceModeButtonsV2Adapter() {
        this((Function1) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceModeButtonsV2Adapter(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1);
    }

    public DeviceModeButtonsV2Adapter(Function1<? super ModeIcon, Unit> function1) {
        this.onModeSelectedListener = function1;
        this.disableModeValues = SetsKt.emptySet();
        this.stayOffModeValues = SetsKt.emptySet();
        this.modes = CollectionsKt.emptyList();
    }

    public final MainMode getMainMode() {
        return this.mainMode;
    }

    public final void setMainMode(MainMode mainMode2) {
        if (this.mainMode != mainMode2) {
            this.mainMode = mainMode2;
            this.modes = ModeIconKt.getSupportedModes$default(this.device, true, false, mainMode2, 2, (Object) null);
            refreshItems();
        }
    }

    public final ModeIcon getModeValue() {
        return this.modeValue;
    }

    public final void setModeValue(ModeIcon modeIcon) {
        if (this.modeValue != modeIcon) {
            this.modeValue = modeIcon;
            refreshItems();
        }
    }

    public final Set<ModeIcon> getDisableModeValues() {
        return this.disableModeValues;
    }

    public final void setDisableModeValues(Set<? extends ModeIcon> set) {
        Intrinsics.checkNotNullParameter(set, "value");
        if (!Intrinsics.areEqual((Object) this.disableModeValues, (Object) set)) {
            this.disableModeValues = set;
            notifyDataSetChanged();
        }
    }

    public final Set<ModeIcon> getStayOffModeValues() {
        return this.stayOffModeValues;
    }

    public final void setStayOffModeValues(Set<? extends ModeIcon> set) {
        Intrinsics.checkNotNullParameter(set, "value");
        if (!Intrinsics.areEqual((Object) this.stayOffModeValues, (Object) set)) {
            this.stayOffModeValues = set;
            notifyDataSetChanged();
        }
    }

    public final Device getDevice() {
        return this.device;
    }

    public final void setDevice(Device device2) {
        if (!Intrinsics.areEqual((Object) this.device, (Object) device2)) {
            this.device = device2;
            this.modes = ModeIconKt.getSupportedModes$default(device2, true, false, this.mainMode, 2, (Object) null);
            refreshItems();
        }
    }

    public final boolean getForceOffline() {
        return this.forceOffline;
    }

    public final void setForceOffline(boolean z) {
        if (this.forceOffline != z) {
            this.forceOffline = z;
            refreshItems();
        }
    }

    private final void refreshItems() {
        notifyItemRangeChanged(0, getItemCount());
    }

    public int getItemCount() {
        return this.modes.size();
    }

    public DeviceModeButtonV2Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return DeviceModeButtonV2Holder.Companion.newInstance(viewGroup);
    }

    public void onBindViewHolder(DeviceModeButtonV2Holder deviceModeButtonV2Holder, int i) {
        Intrinsics.checkNotNullParameter(deviceModeButtonV2Holder, "holder");
        ModeIcon modeIcon = (ModeIcon) this.modes.get(i);
        ModeIcon modeIcon2 = this.modeValue;
        if (modeIcon2 != null) {
            deviceModeButtonV2Holder.updateMode(modeIcon, modeIcon2, this.stayOffModeValues, this.disableModeValues);
        } else {
            Device device2 = this.device;
            Intrinsics.checkNotNull(device2);
            deviceModeButtonV2Holder.updateMode(modeIcon, device2, this.forceOffline);
        }
        deviceModeButtonV2Holder.getBinding().modeRoot.setOnClickListener(new DeviceModeButtonsV2Adapter$$ExternalSyntheticLambda0(this, modeIcon));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(DeviceModeButtonsV2Adapter deviceModeButtonsV2Adapter, ModeIcon modeIcon, View view) {
        Function1<ModeIcon, Unit> function1 = deviceModeButtonsV2Adapter.onModeSelectedListener;
        if (function1 != null) {
            function1.invoke(modeIcon);
        }
    }
}
