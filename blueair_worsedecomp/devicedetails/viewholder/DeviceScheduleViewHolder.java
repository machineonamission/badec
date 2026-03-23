package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.devicedetails.databinding.HolderDeviceScheduleBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.extensions.DayOfWeekExtensionKt;
import com.blueair.viewcore.utils.ModeIcon;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceScheduleBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceScheduleBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceScheduleBinding;", "formatter12", "Ljava/text/SimpleDateFormat;", "formatter24", "bind", "", "hasCustomName", "", "is24Format", "item", "Lcom/blueair/core/model/DeviceScheduleMerged;", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceScheduleViewHolder.kt */
public final class DeviceScheduleViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceScheduleBinding binding;
    private final SimpleDateFormat formatter12 = new SimpleDateFormat("hh:mm a");
    private final SimpleDateFormat formatter24 = new SimpleDateFormat("HH:mm");

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleViewHolder$Companion;", "", "<init>", "()V", "instance", "Lcom/blueair/devicedetails/viewholder/DeviceScheduleViewHolder;", "parent", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceScheduleViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceScheduleViewHolder instance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            HolderDeviceScheduleBinding inflate = HolderDeviceScheduleBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceScheduleViewHolder(inflate);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceScheduleViewHolder(HolderDeviceScheduleBinding holderDeviceScheduleBinding) {
        super(holderDeviceScheduleBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderDeviceScheduleBinding, "binding");
        this.binding = holderDeviceScheduleBinding;
    }

    public final HolderDeviceScheduleBinding getBinding() {
        return this.binding;
    }

    public final void bind(boolean z, boolean z2, DeviceScheduleMerged deviceScheduleMerged, Device device) {
        String str;
        Pair pair;
        String str2;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(deviceScheduleMerged, "item");
        Intrinsics.checkNotNullParameter(device, "device");
        if (DayOfWeekExtensionKt.isWeekdaysOnly(DayOfWeek.Companion, deviceScheduleMerged.getDaysOfWeek())) {
            str = this.itemView.getContext().getString(R.string.weekdays);
        } else if (DayOfWeekExtensionKt.isWeekendOnly(DayOfWeek.Companion, deviceScheduleMerged.getDaysOfWeek())) {
            str = this.itemView.getContext().getString(R.string.weekend);
        } else if (DayOfWeekExtensionKt.isEveryDay(DayOfWeek.Companion, deviceScheduleMerged.getDaysOfWeek())) {
            str = this.itemView.getContext().getString(R.string.everyday);
        } else {
            str = CollectionsKt.joinToString$default(deviceScheduleMerged.getDaysOfWeek(), ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new DeviceScheduleViewHolder$$ExternalSyntheticLambda0(this), 30, (Object) null);
        }
        Intrinsics.checkNotNull(str);
        if (!z2) {
            pair = TuplesKt.to(this.formatter12.format(this.formatter24.parse(deviceScheduleMerged.getStartTime())), this.formatter12.format(this.formatter24.parse(deviceScheduleMerged.getEndTime())));
        } else {
            pair = TuplesKt.to(deviceScheduleMerged.getStartTime(), deviceScheduleMerged.getEndTime());
        }
        TextView textView = this.binding.timeRange;
        textView.setText(((String) pair.component1()) + " - " + ((String) pair.component2()));
        if (!z || StringsKt.isBlank(deviceScheduleMerged.getName())) {
            str2 = this.itemView.getContext().getString(R.string.schedule_default_name);
            Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
        } else {
            str2 = deviceScheduleMerged.getName();
        }
        Spanned fromHtml = HtmlCompat.fromHtml(str2 + " <b>" + str + "</b>", 0);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(...)");
        this.binding.nameAndRepeat.setText(fromHtml);
        TextView textView2 = this.binding.mode;
        Context context = this.itemView.getContext();
        if (deviceScheduleMerged.isNightMode()) {
            i = R.string.night;
        } else if (deviceScheduleMerged.isAutoMode()) {
            i = R.string.auto;
        } else if (deviceScheduleMerged.isStandbyMode()) {
            i = R.string.stand_by;
        } else if (deviceScheduleMerged.isDisinfectionMode()) {
            i = R.string.disinfection;
        } else {
            i = R.string.fan_speed;
        }
        textView2.setText(context.getString(i));
        Context context2 = this.itemView.getContext();
        if (deviceScheduleMerged.isNightMode()) {
            i2 = ModeIcon.NIGHT.getOnIcon();
        } else if (deviceScheduleMerged.isAutoMode()) {
            i2 = ModeIcon.AUTO.proofread(device).getOnIcon();
        } else if (deviceScheduleMerged.isStandbyMode()) {
            i2 = ModeIcon.STANDBY.getOffIcon();
        } else if (deviceScheduleMerged.isDisinfectionMode()) {
            i2 = ModeIcon.DISINFECTION.getOnIcon();
        } else {
            i2 = ModeIcon.FAN_SPEED.getOnIcon();
        }
        Drawable drawable = ContextCompat.getDrawable(context2, i2);
        int dimensionPixelSize = this.itemView.getResources().getDimensionPixelSize(R.dimen.schedule_mode_icon_size);
        if (drawable != null) {
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        }
        this.binding.mode.setCompoundDrawablesRelative((Drawable) null, (Drawable) null, drawable, (Drawable) null);
    }

    /* access modifiers changed from: private */
    public static final CharSequence bind$lambda$0(DeviceScheduleViewHolder deviceScheduleViewHolder, DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "it");
        Context context = deviceScheduleViewHolder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return DayOfWeekExtensionKt.displayValueShort(dayOfWeek, context);
    }
}
