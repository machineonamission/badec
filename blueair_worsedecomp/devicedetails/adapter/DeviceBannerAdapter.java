package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasBody;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasWaterLevel;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.WaterLevel;
import com.blueair.devicedetails.viewholder.DeviceBannerHolder;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001aH\u0016R*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0011@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceBannerHolder;", "<init>", "()V", "value", "", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner;", "banners", "setBanners", "(Ljava/util/List;)V", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "Lcom/blueair/core/model/Device;", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "refreshBanners", "", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "Banner", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceBannerAdapter.kt */
public final class DeviceBannerAdapter extends RecyclerView.Adapter<DeviceBannerHolder> {
    private List<? extends Banner> banners = CollectionsKt.emptyList();
    private Device device;
    public DeviceDetailsViewModel viewModel;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\n\u000b\f\rB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u0001\u0004\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner;", "", "titleRes", "", "messageRes", "<init>", "(II)V", "getTitleRes", "()I", "getMessageRes", "WarningBodyNotMounted", "WarningFilterExpired", "WarningWickExpired", "WarningWaterShortage", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner$WarningBodyNotMounted;", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner$WarningFilterExpired;", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner$WarningWaterShortage;", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner$WarningWickExpired;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceBannerAdapter.kt */
    public static abstract class Banner {
        private final int messageRes;
        private final int titleRes;

        public /* synthetic */ Banner(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2);
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner$WarningBodyNotMounted;", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeviceBannerAdapter.kt */
        public static final class WarningBodyNotMounted extends Banner {
            public static final WarningBodyNotMounted INSTANCE = new WarningBodyNotMounted();

            private WarningBodyNotMounted() {
                super(R.string.body_not_in_position, R.string.body_not_in_position_desc, (DefaultConstructorMarker) null);
            }
        }

        private Banner(int i, int i2) {
            this.titleRes = i;
            this.messageRes = i2;
        }

        public final int getMessageRes() {
            return this.messageRes;
        }

        public final int getTitleRes() {
            return this.titleRes;
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner$WarningFilterExpired;", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeviceBannerAdapter.kt */
        public static final class WarningFilterExpired extends Banner {
            public static final WarningFilterExpired INSTANCE = new WarningFilterExpired();

            private WarningFilterExpired() {
                super(R.string.warning_title_filter_expired, R.string.warning_msg_wick_expired, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner$WarningWickExpired;", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeviceBannerAdapter.kt */
        public static final class WarningWickExpired extends Banner {
            public static final WarningWickExpired INSTANCE = new WarningWickExpired();

            private WarningWickExpired() {
                super(R.string.warning_title_wick_expired, R.string.warning_msg_wick_expired, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner$WarningWaterShortage;", "Lcom/blueair/devicedetails/adapter/DeviceBannerAdapter$Banner;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeviceBannerAdapter.kt */
        public static final class WarningWaterShortage extends Banner {
            public static final WarningWaterShortage INSTANCE = new WarningWaterShortage();

            private WarningWaterShortage() {
                super(R.string.notification_template_title_water_shortage_new, R.string.notification_template_content_water_shortage_new, (DefaultConstructorMarker) null);
            }
        }
    }

    private final void setBanners(List<? extends Banner> list) {
        if (!Intrinsics.areEqual((Object) this.banners, (Object) list)) {
            this.banners = list;
            notifyDataSetChanged();
        }
    }

    public final DeviceDetailsViewModel getViewModel() {
        DeviceDetailsViewModel deviceDetailsViewModel = this.viewModel;
        if (deviceDetailsViewModel != null) {
            return deviceDetailsViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void setViewModel(DeviceDetailsViewModel deviceDetailsViewModel) {
        Intrinsics.checkNotNullParameter(deviceDetailsViewModel, "<set-?>");
        this.viewModel = deviceDetailsViewModel;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final void setDevice(Device device2) {
        if (!Intrinsics.areEqual((Object) this.device, (Object) device2)) {
            this.device = device2;
            if (device2 != null) {
                refreshBanners(device2);
            }
        }
    }

    private final void refreshBanners(Device device2) {
        Integer filterLife;
        List arrayList = new ArrayList();
        if ((device2 instanceof HasBody) && !((HasBody) device2).getBodyMounted() && !getViewModel().getBannerBodyNotMountedClosed()) {
            arrayList.add(Banner.WarningBodyNotMounted.INSTANCE);
        }
        HasWick hasWick = null;
        if ((device2 instanceof DeviceCombo2in1) || (device2 instanceof DevicePet20)) {
            HasFanSpeed hasFanSpeed = device2 instanceof HasFanSpeed ? (HasFanSpeed) device2 : null;
            if (((hasFanSpeed == null || (filterLife = hasFanSpeed.getFilterLife()) == null) ? 0 : filterLife.intValue()) >= 100 && !getViewModel().getBannerFilterExpiredClosed()) {
                arrayList.add(Banner.WarningFilterExpired.INSTANCE);
            }
        }
        if (device2 instanceof HasWick) {
            hasWick = (HasWick) device2;
        }
        if (hasWick != null) {
            if (hasWick.getWickUsage() >= 100 && !getViewModel().getBannerWickExpiredClosed()) {
                arrayList.add(Banner.WarningWickExpired.INSTANCE);
            }
            if ((device2 instanceof HasWaterLevel ? ((HasWaterLevel) device2).isInWaterLevel(WaterLevel.SHORTAGE) : hasWick.getWaterShortage()) && !getViewModel().getBannerWaterShortageClosed()) {
                arrayList.add(Banner.WarningWaterShortage.INSTANCE);
            }
        }
        setBanners(arrayList);
    }

    public int getItemCount() {
        return this.banners.size();
    }

    public DeviceBannerHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return DeviceBannerHolder.Companion.newInstance(viewGroup);
    }

    public void onBindViewHolder(DeviceBannerHolder deviceBannerHolder, int i) {
        Intrinsics.checkNotNullParameter(deviceBannerHolder, "holder");
        Banner banner = (Banner) this.banners.get(i);
        Device device2 = this.device;
        if (device2 != null) {
            deviceBannerHolder.bind(banner, device2);
        }
        deviceBannerHolder.getBinding().closeBtn.setOnClickListener(new DeviceBannerAdapter$$ExternalSyntheticLambda0(banner, this));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$4(Banner banner, DeviceBannerAdapter deviceBannerAdapter, View view) {
        if (banner instanceof Banner.WarningBodyNotMounted) {
            deviceBannerAdapter.getViewModel().setBannerBodyNotMountedClosed(true);
        } else if (banner instanceof Banner.WarningFilterExpired) {
            deviceBannerAdapter.getViewModel().setBannerFilterExpiredClosed(true);
        } else if (banner instanceof Banner.WarningWickExpired) {
            deviceBannerAdapter.getViewModel().setBannerWickExpiredClosed(true);
        } else if (banner instanceof Banner.WarningWaterShortage) {
            deviceBannerAdapter.getViewModel().setBannerWaterShortageClosed(true);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Device device2 = deviceBannerAdapter.device;
        if (device2 != null) {
            deviceBannerAdapter.refreshBanners(device2);
        }
    }
}
