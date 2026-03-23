package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ViewKt;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.viewholder.DeviceNModeButtonHolder;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.PopupInfoDialogFragment;
import com.blueair.viewcore.utils.ModeIcon;
import com.blueair.viewcore.utils.ModeIconKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B@\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010'\u001a\u00020(H\u0016J\u0018\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020(H\u0016J\u0018\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020(H\u0016J\"\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u001b2\b\u00104\u001a\u0004\u0018\u000105H\u0002J \u00106\u001a\u00020\u000b2\u0006\u00101\u001a\u0002022\u0006\u00107\u001a\u00020(2\u0006\u00108\u001a\u00020(H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u000fR.\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000fR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00069"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceNModeButtonsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceNModeButtonHolder;", "isInSchedule", "", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/viewcore/utils/ModeIcon;", "Lkotlin/ParameterName;", "name", "mode", "", "isMainMode", "<init>", "(ZLkotlin/jvm/functions/Function1;Z)V", "()Z", "getOnModeSelectedListener", "()Lkotlin/jvm/functions/Function1;", "modes", "", "purifierMode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "getPurifierMode", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "setPurifierMode", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;)V", "purifierMainMode", "Lcom/blueair/core/model/MainMode;", "getPurifierMainMode", "()Lcom/blueair/core/model/MainMode;", "setPurifierMainMode", "(Lcom/blueair/core/model/MainMode;)V", "value", "Lcom/blueair/core/model/Device;", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "handleClickInfo", "view", "Landroid/view/View;", "mainMode", "subMode", "Lcom/blueair/core/model/ApSubMode;", "showInfoDialog", "title", "content", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNModeButtonsAdapter.kt */
public final class DeviceNModeButtonsAdapter extends RecyclerView.Adapter<DeviceNModeButtonHolder> {
    private Device device;
    private final boolean isInSchedule;
    private final boolean isMainMode;
    private List<? extends ModeIcon> modes;
    private final Function1<ModeIcon, Unit> onModeSelectedListener;
    private MainMode purifierMainMode;
    private DeviceCreateEditScheduleViewModel.PurifierMode purifierMode;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceNModeButtonsAdapter(boolean z, Function1 function1, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : function1, (i & 4) != 0 ? false : z2);
    }

    public final boolean isInSchedule() {
        return this.isInSchedule;
    }

    public final Function1<ModeIcon, Unit> getOnModeSelectedListener() {
        return this.onModeSelectedListener;
    }

    public final boolean isMainMode() {
        return this.isMainMode;
    }

    public DeviceNModeButtonsAdapter(boolean z, Function1<? super ModeIcon, Unit> function1, boolean z2) {
        this.isInSchedule = z;
        this.onModeSelectedListener = function1;
        this.isMainMode = z2;
        this.modes = CollectionsKt.emptyList();
    }

    public final DeviceCreateEditScheduleViewModel.PurifierMode getPurifierMode() {
        return this.purifierMode;
    }

    public final void setPurifierMode(DeviceCreateEditScheduleViewModel.PurifierMode purifierMode2) {
        this.purifierMode = purifierMode2;
    }

    public final MainMode getPurifierMainMode() {
        return this.purifierMainMode;
    }

    public final void setPurifierMainMode(MainMode mainMode) {
        this.purifierMainMode = mainMode;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final void setDevice(Device device2) {
        if (!Intrinsics.areEqual((Object) this.device, (Object) device2) || this.purifierMode != null || this.purifierMainMode != null) {
            this.device = device2;
            this.modes = ModeIconKt.getSupportedModes$default(device2, this.isInSchedule, this.isMainMode, (MainMode) null, 4, (Object) null);
            notifyDataSetChanged();
        }
    }

    public int getItemCount() {
        return this.modes.size();
    }

    public DeviceNModeButtonHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return DeviceNModeButtonHolder.Companion.newInstance(viewGroup);
    }

    public void onBindViewHolder(DeviceNModeButtonHolder deviceNModeButtonHolder, int i) {
        Intrinsics.checkNotNullParameter(deviceNModeButtonHolder, "holder");
        ModeIcon modeIcon = (ModeIcon) this.modes.get(i);
        deviceNModeButtonHolder.getBinding().modeRoot.setOnClickListener(new DeviceNModeButtonsAdapter$$ExternalSyntheticLambda0(this, modeIcon));
        if (this.isMainMode) {
            deviceNModeButtonHolder.updateMainMode(modeIcon, this.device, this.purifierMainMode, this.purifierMode);
            deviceNModeButtonHolder.getBinding().infoView.setOnClickListener(new DeviceNModeButtonsAdapter$$ExternalSyntheticLambda1(modeIcon, this));
            return;
        }
        deviceNModeButtonHolder.updateMode(modeIcon, this.device, this.purifierMainMode, this.purifierMode);
        deviceNModeButtonHolder.getBinding().infoView.setOnClickListener(new DeviceNModeButtonsAdapter$$ExternalSyntheticLambda2(this, modeIcon));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(DeviceNModeButtonsAdapter deviceNModeButtonsAdapter, ModeIcon modeIcon, View view) {
        Function1<ModeIcon, Unit> function1 = deviceNModeButtonsAdapter.onModeSelectedListener;
        if (function1 != null) {
            function1.invoke(modeIcon);
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(ModeIcon modeIcon, DeviceNModeButtonsAdapter deviceNModeButtonsAdapter, View view) {
        MainMode mainMode = modeIcon.toMainMode();
        if (mainMode != null) {
            Intrinsics.checkNotNull(view);
            deviceNModeButtonsAdapter.handleClickInfo(view, mainMode, (ApSubMode) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$4(DeviceNModeButtonsAdapter deviceNModeButtonsAdapter, ModeIcon modeIcon, View view) {
        MainMode mainMode = deviceNModeButtonsAdapter.purifierMainMode;
        if (mainMode == null) {
            Device device2 = deviceNModeButtonsAdapter.device;
            HasCombo3in1MainMode hasCombo3in1MainMode = device2 instanceof HasCombo3in1MainMode ? (HasCombo3in1MainMode) device2 : null;
            mainMode = hasCombo3in1MainMode != null ? hasCombo3in1MainMode.mainMode() : null;
            if (mainMode == null) {
                return;
            }
        }
        ApSubMode apSubMode = modeIcon.toApSubMode();
        if (apSubMode != null) {
            Intrinsics.checkNotNull(view);
            deviceNModeButtonsAdapter.handleClickInfo(view, mainMode, apSubMode);
        }
    }

    private final void handleClickInfo(View view, MainMode mainMode, ApSubMode apSubMode) {
        if (apSubMode == null && mainMode == MainMode.HEAT) {
            showInfoDialog(view, R.string.main_mode_heat, R.string.mode_disable_hint_heat);
        }
    }

    private final void showInfoDialog(View view, int i, int i2) {
        FragmentManager childFragmentManager = ViewKt.findFragment(view).getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<PopupInfoDialogFragment> cls = PopupInfoDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("PopupInfoDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("PopupInfoDialogFragment") instanceof PopupInfoDialogFragment) && !childFragmentManager.isStateSaved()) {
            PopupInfoDialogFragment.Companion.newInstance(i, (Integer) null, i2).show(childFragmentManager, "PopupInfoDialogFragment");
        }
    }
}
