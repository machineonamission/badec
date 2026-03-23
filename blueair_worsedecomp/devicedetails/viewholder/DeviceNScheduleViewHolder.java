package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.devicedetails.databinding.HolderDeviceNScheduleBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.extensions.DayOfWeekExtensionKt;
import com.blueair.viewcore.utils.ModeIcon;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.text.SimpleDateFormat;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNScheduleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceNScheduleBinding;", "device", "Lcom/blueair/core/model/Device;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNScheduleBinding;Lcom/blueair/core/model/Device;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceNScheduleBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "formatter12", "Ljava/text/SimpleDateFormat;", "formatter24", "bind", "", "hasCustomName", "", "is24Format", "item", "Lcom/blueair/core/model/DeviceScheduleMerged;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNScheduleViewHolder.kt */
public final class DeviceNScheduleViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceNScheduleBinding binding;
    private final Device device;
    private final SimpleDateFormat formatter12 = new SimpleDateFormat("hh:mm a");
    private final SimpleDateFormat formatter24 = new SimpleDateFormat("HH:mm");

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNScheduleViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNScheduleViewHolder;", "parent", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNScheduleViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNScheduleViewHolder newInstance(ViewGroup viewGroup, Device device) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            Intrinsics.checkNotNullParameter(device, "device");
            HolderDeviceNScheduleBinding inflate = HolderDeviceNScheduleBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceNScheduleViewHolder(inflate, device);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceNScheduleViewHolder(HolderDeviceNScheduleBinding holderDeviceNScheduleBinding, Device device2) {
        super(holderDeviceNScheduleBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderDeviceNScheduleBinding, "binding");
        Intrinsics.checkNotNullParameter(device2, "device");
        this.binding = holderDeviceNScheduleBinding;
        this.device = device2;
    }

    public final HolderDeviceNScheduleBinding getBinding() {
        return this.binding;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final void bind(boolean z, boolean z2, DeviceScheduleMerged deviceScheduleMerged) {
        Pair pair;
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(deviceScheduleMerged, "item");
        Set<DayOfWeek> daysOfWeek = deviceScheduleMerged.getDaysOfWeek();
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        String dayOfWeekExtensionKt = DayOfWeekExtensionKt.toString(daysOfWeek, context);
        if (z2) {
            pair = TuplesKt.to(deviceScheduleMerged.getStartTime(), deviceScheduleMerged.getEndTime());
        } else {
            pair = TuplesKt.to(this.formatter12.format(this.formatter24.parse(deviceScheduleMerged.getStartTime())), this.formatter12.format(this.formatter24.parse(deviceScheduleMerged.getEndTime())));
        }
        this.binding.timeRange.setText(((String) pair.component1()) + " - " + ((String) pair.component2()));
        if (!z || StringsKt.isBlank(deviceScheduleMerged.getName())) {
            str = this.itemView.getContext().getString(R.string.schedule_default_name);
            Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
        } else {
            str = deviceScheduleMerged.getName();
        }
        int i5 = 0;
        Spanned fromHtml = HtmlCompat.fromHtml(str + " <b>" + dayOfWeekExtensionKt + "</b>", 0);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(...)");
        this.binding.nameAndRepeat.setText(fromHtml);
        boolean z3 = true;
        if (!(this.device instanceof HasCombo3in1MainMode) || deviceScheduleMerged.isStandbyMode()) {
            AppCompatImageView appCompatImageView = this.binding.iconMainMode;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "iconMainMode");
            ViewExtensionsKt.hide(appCompatImageView);
            TextView textView = this.binding.mainMode;
            Intrinsics.checkNotNullExpressionValue(textView, "mainMode");
            ViewExtensionsKt.hide(textView);
        } else {
            AppCompatImageView appCompatImageView2 = this.binding.iconMainMode;
            Context context2 = this.itemView.getContext();
            if (deviceScheduleMerged.isCoolMainMode()) {
                i3 = ModeIcon.COOL.getOnIcon();
            } else if (deviceScheduleMerged.isHeatMainMode()) {
                i3 = ModeIcon.HEAT.getOnIcon();
            } else {
                i3 = ModeIcon.AIR_PURIFY.getOnIcon();
            }
            appCompatImageView2.setImageDrawable(ContextCompat.getDrawable(context2, i3));
            TextView textView2 = this.binding.mainMode;
            Intrinsics.checkNotNullExpressionValue(textView2, "mainMode");
            ViewExtensionsKt.show$default(textView2, false, 1, (Object) null);
            TextView textView3 = this.binding.mainMode;
            if (deviceScheduleMerged.isCoolMainMode()) {
                i4 = R.string.main_mode_cool_short;
            } else if (deviceScheduleMerged.isHeatMainMode()) {
                i4 = R.string.main_mode_heat_short;
            } else {
                i4 = R.string.main_mode_ap_short;
            }
            textView3.setText(i4);
            AppCompatImageView appCompatImageView3 = this.binding.iconMainMode;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "iconMainMode");
            ViewExtensionsKt.show$default(appCompatImageView3, false, 1, (Object) null);
            TextView textView4 = this.binding.mainMode;
            Intrinsics.checkNotNullExpressionValue(textView4, "mainMode");
            ViewExtensionsKt.show$default(textView4, false, 1, (Object) null);
        }
        Context context3 = this.itemView.getContext();
        if (deviceScheduleMerged.isNightMode()) {
            i = ModeIcon.NIGHT.getOnIcon();
        } else if (deviceScheduleMerged.isAutoMode()) {
            i = ModeIcon.AUTO.proofread(this.device).getOnIcon();
        } else if (deviceScheduleMerged.isStandbyMode()) {
            i = ModeIcon.STANDBY.getOffIcon();
        } else if (deviceScheduleMerged.isDisinfectionMode()) {
            i = ModeIcon.DISINFECTION.getOnIcon();
        } else if (deviceScheduleMerged.isEcoMode()) {
            i = ModeIcon.ECO.getOnIcon();
        } else if (deviceScheduleMerged.isSmartMainMode()) {
            i = ModeIcon.SMART.getOnIcon();
        } else {
            i = ModeIcon.FAN_SPEED.getOnIcon();
        }
        this.binding.iconMode.setImageDrawable(ContextCompat.getDrawable(context3, i));
        TextView textView5 = this.binding.mode;
        if (deviceScheduleMerged.isNightMode()) {
            i2 = R.string.night;
        } else if (deviceScheduleMerged.isAutoMode()) {
            i2 = R.string.auto;
        } else if (deviceScheduleMerged.isStandbyMode()) {
            i2 = R.string.stand_by;
        } else if (deviceScheduleMerged.isDisinfectionMode()) {
            i2 = R.string.disinfection;
        } else if (deviceScheduleMerged.isEcoMode()) {
            i2 = R.string.eco;
        } else if (deviceScheduleMerged.isSmartMainMode()) {
            i2 = R.string.main_mode_smart;
        } else {
            i2 = R.string.fan_speed;
        }
        textView5.setText(i2);
        TextView textView6 = this.binding.scheduleSwitch;
        Intrinsics.checkNotNullExpressionValue(textView6, "scheduleSwitch");
        View view = textView6;
        if (!DeviceKt.isAfterG4(this.device) || (this.device instanceof DeviceNewClassic)) {
            z3 = false;
        }
        if (!z3) {
            i5 = 8;
        }
        view.setVisibility(i5);
        this.binding.scheduleSwitch.setText(this.itemView.getContext().getString(deviceScheduleMerged.getPaused() ? R.string.off_camel_case : R.string.on_camel_case));
    }
}
