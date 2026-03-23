package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.TypedValueCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.DeviceImage;
import com.blueair.core.model.HasAlarm;
import com.blueair.devicedetails.adapter.AlarmCardAdapter;
import com.blueair.devicedetails.databinding.HolderDevicesAlarmBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.utils.SimpleSpacingDecoration;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/blueair/devicedetails/viewholder/DevicesAlarmViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDevicesAlarmBinding;", "onAlarmChecked", "Lkotlin/Function3;", "Lcom/blueair/core/model/HasAlarm;", "Lcom/blueair/core/model/DeviceAlarm;", "", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDevicesAlarmBinding;Lkotlin/jvm/functions/Function3;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDevicesAlarmBinding;", "alarmDevice", "adapter", "Lcom/blueair/devicedetails/adapter/AlarmCardAdapter;", "troubleshootingBtn", "Landroid/widget/Button;", "getTroubleshootingBtn", "()Landroid/widget/Button;", "closeBtn", "getCloseBtn", "iconMore", "Landroid/view/View;", "getIconMore", "()Landroid/view/View;", "bind", "hasAlarm", "forceOffline", "hideOfflineTip", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DevicesAlarmViewHolder.kt */
public final class DevicesAlarmViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final AlarmCardAdapter adapter;
    private HasAlarm alarmDevice;
    private final HolderDevicesAlarmBinding binding;
    private final Function3<HasAlarm, DeviceAlarm, Boolean, Unit> onAlarmChecked;

    public final HolderDevicesAlarmBinding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\t¨\u0006\u000e"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DevicesAlarmViewHolder$Companion;", "", "<init>", "()V", "instance", "Lcom/blueair/devicedetails/viewholder/DevicesAlarmViewHolder;", "parent", "Landroid/view/ViewGroup;", "onAlarmChecked", "Lkotlin/Function3;", "Lcom/blueair/core/model/HasAlarm;", "Lcom/blueair/core/model/DeviceAlarm;", "", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DevicesAlarmViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DevicesAlarmViewHolder instance(ViewGroup viewGroup, Function3<? super HasAlarm, ? super DeviceAlarm, ? super Boolean, Unit> function3) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            Intrinsics.checkNotNullParameter(function3, "onAlarmChecked");
            HolderDevicesAlarmBinding inflate = HolderDevicesAlarmBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DevicesAlarmViewHolder(inflate, function3);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DevicesAlarmViewHolder(HolderDevicesAlarmBinding holderDevicesAlarmBinding, Function3<? super HasAlarm, ? super DeviceAlarm, ? super Boolean, Unit> function3) {
        super(holderDevicesAlarmBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderDevicesAlarmBinding, "binding");
        Intrinsics.checkNotNullParameter(function3, "onAlarmChecked");
        this.binding = holderDevicesAlarmBinding;
        this.onAlarmChecked = function3;
        AlarmCardAdapter alarmCardAdapter = new AlarmCardAdapter(this.itemView.getContext().getColor(R.color.surface_dark_65), new DevicesAlarmViewHolder$$ExternalSyntheticLambda0(this), (Function1) null, 4, (DefaultConstructorMarker) null);
        this.adapter = alarmCardAdapter;
        RecyclerView recyclerView = holderDevicesAlarmBinding.rvAlarms;
        recyclerView.setAdapter(alarmCardAdapter);
        recyclerView.addItemDecoration(new SimpleSpacingDecoration(0, (int) TypedValueCompat.dpToPx(8.0f, recyclerView.getResources().getDisplayMetrics()), false, 4, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    public static final Unit adapter$lambda$1(DevicesAlarmViewHolder devicesAlarmViewHolder, DeviceAlarm deviceAlarm, boolean z) {
        Intrinsics.checkNotNullParameter(deviceAlarm, "deviceAlarm");
        HasAlarm hasAlarm = devicesAlarmViewHolder.alarmDevice;
        if (hasAlarm != null) {
            devicesAlarmViewHolder.onAlarmChecked.invoke(hasAlarm, deviceAlarm, Boolean.valueOf(z));
        }
        return Unit.INSTANCE;
    }

    public final Button getTroubleshootingBtn() {
        Button button = this.binding.layoutOffline.troubleshootBtn;
        Intrinsics.checkNotNullExpressionValue(button, "troubleshootBtn");
        return button;
    }

    public final Button getCloseBtn() {
        Button button = this.binding.layoutOffline.closeBtn;
        Intrinsics.checkNotNullExpressionValue(button, "closeBtn");
        return button;
    }

    public final View getIconMore() {
        ImageView imageView = this.binding.ivMore;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivMore");
        return imageView;
    }

    public final void bind(HasAlarm hasAlarm, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(hasAlarm, "hasAlarm");
        this.alarmDevice = hasAlarm;
        boolean z3 = true;
        int i = 0;
        boolean z4 = z || !hasAlarm.isOnline();
        this.adapter.setData(CollectionsKt.filterNotNull(hasAlarm.getAlarms()), z4);
        HolderDevicesAlarmBinding holderDevicesAlarmBinding = this.binding;
        holderDevicesAlarmBinding.ivMore.setImageTintList(z4 ? ColorStateList.valueOf(this.itemView.getContext().getColor(R.color.surface_dark_45)) : null);
        ConstraintLayout root = holderDevicesAlarmBinding.layoutOffline.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        ViewExtensionsKt.show(root, z4 && !z2);
        RecyclerView recyclerView = holderDevicesAlarmBinding.rvAlarms;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rvAlarms");
        View view = recyclerView;
        if (this.adapter.getItemCount() <= 0) {
            z3 = false;
        }
        ViewExtensionsKt.show(view, z3);
        ImageView imageView = holderDevicesAlarmBinding.ivDevice;
        DeviceImage deviceImage = DeviceConfigProvider.INSTANCE.getDeviceImage((Device) hasAlarm);
        if (deviceImage != null) {
            i = deviceImage.getDevice();
        }
        imageView.setImageResource(i);
        holderDevicesAlarmBinding.tvDeviceName.setText(hasAlarm.getName());
    }
}
