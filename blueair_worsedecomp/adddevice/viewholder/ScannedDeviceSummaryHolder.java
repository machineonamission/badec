package com.blueair.adddevice.viewholder;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.core.util.TypedValueCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.adddevice.databinding.HolderScannedDeviceBinding;
import com.blueair.adddevice.model.BluetoothConnectingState;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.DeviceImage;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.dd.ShadowLayout;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/blueair/adddevice/viewholder/ScannedDeviceSummaryHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/adddevice/databinding/HolderScannedDeviceBinding;", "<init>", "(Lcom/blueair/adddevice/databinding/HolderScannedDeviceBinding;)V", "getBinding", "()Lcom/blueair/adddevice/databinding/HolderScannedDeviceBinding;", "clickView", "Landroid/view/View;", "getClickView", "()Landroid/view/View;", "padding", "", "getPadding", "()I", "padding$delegate", "Lkotlin/Lazy;", "update", "", "device", "Lcom/blueair/core/model/BluetoothDevice;", "connectingState", "Lcom/blueair/adddevice/model/BluetoothConnectingState;", "hydrateOnlineStatus", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ScannedDeviceSummaryHolder.kt */
public final class ScannedDeviceSummaryHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderScannedDeviceBinding binding;
    private final View clickView;
    private final Lazy padding$delegate = LazyKt.lazy(new ScannedDeviceSummaryHolder$$ExternalSyntheticLambda0(this));

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/viewholder/ScannedDeviceSummaryHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/viewholder/ScannedDeviceSummaryHolder;", "parentView", "Landroid/view/ViewGroup;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ScannedDeviceSummaryHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ScannedDeviceSummaryHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderScannedDeviceBinding inflate = HolderScannedDeviceBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new ScannedDeviceSummaryHolder(inflate);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScannedDeviceSummaryHolder(HolderScannedDeviceBinding holderScannedDeviceBinding) {
        super(holderScannedDeviceBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderScannedDeviceBinding, "binding");
        this.binding = holderScannedDeviceBinding;
        ShadowLayout shadowLayout = holderScannedDeviceBinding.slRoot;
        Intrinsics.checkNotNullExpressionValue(shadowLayout, "slRoot");
        this.clickView = shadowLayout;
    }

    public final HolderScannedDeviceBinding getBinding() {
        return this.binding;
    }

    public final View getClickView() {
        return this.clickView;
    }

    private final int getPadding() {
        return ((Number) this.padding$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public static final int padding_delegate$lambda$0(ScannedDeviceSummaryHolder scannedDeviceSummaryHolder) {
        return (int) TypedValueCompat.dpToPx(4.0f, scannedDeviceSummaryHolder.binding.getRoot().getResources().getDisplayMetrics());
    }

    public final void update(BluetoothDevice bluetoothDevice, BluetoothConnectingState bluetoothConnectingState) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, "device");
        Intrinsics.checkNotNullParameter(bluetoothConnectingState, "connectingState");
        this.binding.name.setText(bluetoothDevice.isUnknownSku() ? this.itemView.getContext().getString(R.string.unknown_device) : bluetoothDevice.getFamilyName());
        this.binding.model.setText(bluetoothDevice.isUnknownSku() ? this.itemView.getContext().getString(R.string.unknown_device) : bluetoothDevice.getModelName());
        this.binding.macNumber.setText(bluetoothDevice.getWifiMac());
        if (bluetoothDevice.isUnknownSku()) {
            AppCompatImageView appCompatImageView = this.binding.deviceImg;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "deviceImg");
            ViewExtensionsKt.hide(appCompatImageView);
            TextView textView = this.binding.connectedLabel;
            Intrinsics.checkNotNullExpressionValue(textView, "connectedLabel");
            ViewExtensionsKt.hide(textView);
        } else {
            AppCompatImageView appCompatImageView2 = this.binding.deviceImg;
            DeviceImage deviceImage = DeviceConfigProvider.INSTANCE.getDeviceImage(bluetoothDevice);
            appCompatImageView2.setImageResource(deviceImage != null ? deviceImage.getDevice() : 0);
            AppCompatImageView appCompatImageView3 = this.binding.deviceImg;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "deviceImg");
            ViewExtensionsKt.show$default(appCompatImageView3, false, 1, (Object) null);
            TextView textView2 = this.binding.connectedLabel;
            Intrinsics.checkNotNullExpressionValue(textView2, "connectedLabel");
            ViewExtensionsKt.show(textView2, !Intrinsics.areEqual((Object) bluetoothDevice.isOnline(), (Object) true));
        }
        hydrateOnlineStatus(bluetoothDevice);
    }

    private final void hydrateOnlineStatus(BluetoothDevice bluetoothDevice) {
        if (Intrinsics.areEqual((Object) bluetoothDevice.isOnline(), (Object) true)) {
            this.binding.clRoot.setBackgroundResource(R.drawable.rounded_rectangle_grey_r20_dark10_stroke1);
        } else {
            this.binding.clRoot.setBackgroundResource(R.drawable.rounded_rectangle_white_r20_dark10_stroke1);
        }
        Group group = this.binding.groupMac;
        Intrinsics.checkNotNullExpressionValue(group, "groupMac");
        ViewExtensionsKt.show(group, !Intrinsics.areEqual((Object) bluetoothDevice.isOnline(), (Object) false));
        if (bluetoothDevice.isOnline() == null) {
            TextView textView = this.binding.model;
            Intrinsics.checkNotNullExpressionValue(textView, "model");
            ViewExtensionsKt.show(textView, !bluetoothDevice.isUnknownSku());
            TextView textView2 = this.binding.tvOnlineStatus;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvOnlineStatus");
            ViewExtensionsKt.hide(textView2);
            return;
        }
        TextView textView3 = this.binding.model;
        Intrinsics.checkNotNullExpressionValue(textView3, "model");
        ViewExtensionsKt.hide(textView3);
        TextView textView4 = this.binding.tvOnlineStatus;
        if (Intrinsics.areEqual((Object) bluetoothDevice.isOnline(), (Object) true)) {
            textView4.setText(R.string.connected);
            Intrinsics.checkNotNull(textView4);
            textView4.setPadding(0, 0, 0, 0);
            textView4.setBackground((Drawable) null);
            textView4.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_connected_contained, 0);
        } else {
            textView4.setText(R.string.offline_label);
            textView4.setPadding(getPadding() * 2, getPadding(), getPadding() * 2, getPadding());
            textView4.setBackgroundResource(R.drawable.rounded_rectangle_dark_5_r8);
            textView4.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
        }
        Intrinsics.checkNotNull(textView4);
        ViewExtensionsKt.show$default(textView4, false, 1, (Object) null);
    }
}
