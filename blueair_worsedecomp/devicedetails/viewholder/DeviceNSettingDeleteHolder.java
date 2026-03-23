package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.HolderDeviceHSettingsDeleteBinding;
import com.blueair.devicedetails.databinding.HolderDeviceNSettingsDeleteBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8FX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNSettingDeleteHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/viewbinding/ViewBinding;", "<init>", "(Landroidx/viewbinding/ViewBinding;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "deleteButton", "Landroid/widget/Button;", "getDeleteButton", "()Landroid/widget/Button;", "deleteButton$delegate", "Lkotlin/Lazy;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNSettingDeleteHolder.kt */
public final class DeviceNSettingDeleteHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ViewBinding binding;
    private final Lazy deleteButton$delegate = LazyKt.lazy(new DeviceNSettingDeleteHolder$$ExternalSyntheticLambda0(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceNSettingDeleteHolder(ViewBinding viewBinding) {
        super(viewBinding.getRoot());
        Intrinsics.checkNotNullParameter(viewBinding, "binding");
        this.binding = viewBinding;
    }

    public final ViewBinding getBinding() {
        return this.binding;
    }

    /* access modifiers changed from: private */
    public static final Button deleteButton_delegate$lambda$0(DeviceNSettingDeleteHolder deviceNSettingDeleteHolder) {
        return (Button) deviceNSettingDeleteHolder.binding.getRoot().findViewById(R.id.delete_btn);
    }

    public final Button getDeleteButton() {
        Object value = this.deleteButton$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Button) value;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNSettingDeleteHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNSettingDeleteHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNSettingDeleteHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNSettingDeleteHolder newInstance(ViewGroup viewGroup, Device device) {
            ViewDataBinding viewDataBinding;
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            if (device == null || !DeviceKt.isAfterG4(device) || (device instanceof DeviceNewClassic)) {
                HolderDeviceNSettingsDeleteBinding inflate = HolderDeviceNSettingsDeleteBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                viewDataBinding = inflate;
            } else {
                HolderDeviceHSettingsDeleteBinding inflate2 = HolderDeviceHSettingsDeleteBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
                viewDataBinding = inflate2;
            }
            return new DeviceNSettingDeleteHolder(viewDataBinding);
        }
    }
}
