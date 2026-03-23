package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasHumMode;
import com.blueair.devicedetails.databinding.HolderScheduleCardBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.extensions.DayOfWeekExtensionKt;
import com.blueair.viewcore.utils.ModeIcon;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.text.SimpleDateFormat;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/blueair/devicedetails/viewholder/ScheduleCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderScheduleCardBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderScheduleCardBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderScheduleCardBinding;", "formatter12", "Ljava/text/SimpleDateFormat;", "formatter24", "bind", "", "hasCustomName", "", "is24Format", "item", "Lcom/blueair/core/model/DeviceScheduleMerged;", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ScheduleCardViewHolder.kt */
public final class ScheduleCardViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderScheduleCardBinding binding;
    private final SimpleDateFormat formatter12 = new SimpleDateFormat("hh:mm a");
    private final SimpleDateFormat formatter24 = new SimpleDateFormat("HH:mm");

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/ScheduleCardViewHolder$Companion;", "", "<init>", "()V", "instance", "Lcom/blueair/devicedetails/viewholder/ScheduleCardViewHolder;", "parent", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ScheduleCardViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ScheduleCardViewHolder instance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            HolderScheduleCardBinding inflate = HolderScheduleCardBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new ScheduleCardViewHolder(inflate);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScheduleCardViewHolder(HolderScheduleCardBinding holderScheduleCardBinding) {
        super(holderScheduleCardBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderScheduleCardBinding, "binding");
        this.binding = holderScheduleCardBinding;
    }

    public final HolderScheduleCardBinding getBinding() {
        return this.binding;
    }

    public final void bind(boolean z, boolean z2, DeviceScheduleMerged deviceScheduleMerged, Device device) {
        Pair pair;
        String str;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(deviceScheduleMerged, "item");
        Intrinsics.checkNotNullParameter(device, "device");
        Set set = CollectionsKt.toSet(CollectionsKt.sortedWith(deviceScheduleMerged.getDaysOfWeek(), new ScheduleCardViewHolder$bind$$inlined$sortedBy$1()));
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        String dayOfWeekExtensionKt = DayOfWeekExtensionKt.toString(set, context);
        if (!z2) {
            pair = TuplesKt.to(this.formatter12.format(this.formatter24.parse(deviceScheduleMerged.getStartTime())), this.formatter12.format(this.formatter24.parse(deviceScheduleMerged.getEndTime())));
        } else {
            pair = TuplesKt.to(deviceScheduleMerged.getStartTime(), deviceScheduleMerged.getEndTime());
        }
        TextView textView = this.binding.timeRange;
        textView.setText(((String) pair.component1()) + " - " + ((String) pair.component2()));
        if (!z || StringsKt.isBlank(deviceScheduleMerged.getName())) {
            str = this.itemView.getContext().getString(R.string.schedule_default_name);
            Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
        } else {
            str = deviceScheduleMerged.getName();
        }
        this.binding.tvName.setText(str);
        this.binding.tvRepeat.setText(dayOfWeekExtensionKt);
        if (deviceScheduleMerged.isStandbyMode() || (!(device instanceof HasCombo3in1MainMode) && !(device instanceof DeviceDehumidifier) && !(device instanceof HasHumMainMode) && !(device instanceof HasHumMode))) {
            ImageView imageView = this.binding.ivMainMode;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivMainMode");
            ViewExtensionsKt.hide(imageView);
        } else {
            ImageView imageView2 = this.binding.ivMainMode;
            Context context2 = this.itemView.getContext();
            if (deviceScheduleMerged.isCoolMainMode()) {
                i2 = ModeIcon.COOL.getFlatIcon();
            } else if (deviceScheduleMerged.isHeatMainMode()) {
                i2 = ModeIcon.HEAT.getFlatIcon();
            } else if (deviceScheduleMerged.isDehMainMode()) {
                i2 = R.drawable.mode_icon_dehum_flat;
            } else if (deviceScheduleMerged.isHumMainMode() || deviceScheduleMerged.isHumMode()) {
                i2 = ModeIcon.HUM.getFlatIcon();
            } else {
                i2 = ModeIcon.AIR_PURIFY.getFlatIcon();
            }
            imageView2.setImageDrawable(ContextCompat.getDrawable(context2, i2));
            ImageView imageView3 = this.binding.ivMainMode;
            Intrinsics.checkNotNullExpressionValue(imageView3, "ivMainMode");
            ViewExtensionsKt.show$default(imageView3, false, 1, (Object) null);
        }
        String str2 = "";
        if (deviceScheduleMerged.isNightMode()) {
            i = ModeIcon.NIGHT.getFlatIcon();
        } else if (deviceScheduleMerged.isAutoMode()) {
            i = ModeIcon.AUTO.proofread(device).getFlatIcon();
        } else if (deviceScheduleMerged.isStandbyMode()) {
            i = ModeIcon.STANDBY.getFlatIcon();
        } else if (deviceScheduleMerged.isDisinfectionMode()) {
            i = ModeIcon.DISINFECTION.getFlatIcon();
        } else if (deviceScheduleMerged.isEcoMode()) {
            i = ModeIcon.ECO.getFlatIcon();
        } else if (deviceScheduleMerged.isSmartMainMode()) {
            i = ModeIcon.SMART.getFlatIcon();
        } else if (deviceScheduleMerged.isDryingMode()) {
            i = ModeIcon.DRYING.getFlatIcon();
        } else if (deviceScheduleMerged.isContinuousMode()) {
            i = ModeIcon.CONTINUOUS.getFlatIcon();
        } else if (deviceScheduleMerged.isSkinMode()) {
            i = ModeIcon.SKIN.getFlatIcon();
        } else {
            str2 = String.valueOf(deviceScheduleMerged.fetchFanSpeed(device));
            i = ModeIcon.FAN_SPEED.getFlatIcon();
        }
        CharSequence charSequence = str2;
        if (charSequence.length() == 0) {
            AppCompatTextView appCompatTextView = this.binding.tvMode;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "tvMode");
            ViewExtensionsKt.hide(appCompatTextView);
        } else {
            this.binding.tvMode.setText(charSequence);
            AppCompatTextView appCompatTextView2 = this.binding.tvMode;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "tvMode");
            ViewExtensionsKt.show$default(appCompatTextView2, false, 1, (Object) null);
        }
        if (!deviceScheduleMerged.isHumMainMode() || !deviceScheduleMerged.isAutoMode()) {
            this.binding.ivMode.setImageResource(i);
            LinearLayout linearLayout = this.binding.llMode;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "llMode");
            ViewExtensionsKt.show$default(linearLayout, false, 1, (Object) null);
        } else {
            LinearLayout linearLayout2 = this.binding.llMode;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "llMode");
            ViewExtensionsKt.hide(linearLayout2);
        }
        this.binding.switchSchedule.setCheckedSilence(!deviceScheduleMerged.getPaused());
    }
}
