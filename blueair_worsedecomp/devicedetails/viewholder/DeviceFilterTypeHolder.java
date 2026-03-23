package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterInfo;
import com.blueair.core.model.I18nConfig;
import com.blueair.devicedetails.databinding.HolderDeviceFilterTypeBinding;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterTypeHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceFilterTypeBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceFilterTypeBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceFilterTypeBinding;", "update", "", "device", "Lcom/blueair/core/model/Device;", "filterInfo", "Lcom/blueair/core/model/FilterInfo;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceFilterTypeHolder.kt */
public final class DeviceFilterTypeHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceFilterTypeBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceFilterTypeHolder(HolderDeviceFilterTypeBinding holderDeviceFilterTypeBinding) {
        super(holderDeviceFilterTypeBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderDeviceFilterTypeBinding, "binding");
        this.binding = holderDeviceFilterTypeBinding;
    }

    public final HolderDeviceFilterTypeBinding getBinding() {
        return this.binding;
    }

    public final void update(Device device, FilterInfo filterInfo) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(filterInfo, "filterInfo");
        TextView textView = this.binding.filterName;
        String value$default = I18nConfig.getValue$default(filterInfo.getName(), (Locale) null, 1, (Object) null);
        if (value$default == null) {
            value$default = "";
        }
        textView.setText(value$default);
        this.binding.filterImage.setImageResource(filterInfo.getImage());
        MaterialButton materialButton = this.binding.myFilterBtn;
        Intrinsics.checkNotNullExpressionValue(materialButton, "myFilterBtn");
        ViewExtensionsKt.show(materialButton, !DeviceKt.isG4orB4orNB(device));
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterTypeHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceFilterTypeHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterTypeHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceFilterTypeHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderDeviceFilterTypeBinding inflate = HolderDeviceFilterTypeBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceFilterTypeHolder(inflate);
        }
    }
}
