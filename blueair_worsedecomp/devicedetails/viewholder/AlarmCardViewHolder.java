package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AlarmSound;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.devicedetails.databinding.HolderAlarmCardBinding;
import com.blueair.viewcore.extensions.DayOfWeekExtensionKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joda.time.DateTimeConstants;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001b\u0010\u001c¨\u0006%"}, d2 = {"Lcom/blueair/devicedetails/viewholder/AlarmCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderAlarmCardBinding;", "onAlarmChecked", "Lkotlin/Function2;", "Lcom/blueair/core/model/DeviceAlarm;", "", "", "onAlarmTapped", "Lkotlin/Function1;", "nameColor", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderAlarmCardBinding;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderAlarmCardBinding;", "Ljava/lang/Integer;", "timeFormatter", "Ljava/text/SimpleDateFormat;", "getTimeFormatter", "()Ljava/text/SimpleDateFormat;", "timeFormatter$delegate", "Lkotlin/Lazy;", "calendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "getCalendar", "()Ljava/util/Calendar;", "calendar$delegate", "bind", "item", "offline", "getDisplayTime", "", "secondsInDay", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AlarmCardViewHolder.kt */
public final class AlarmCardViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderAlarmCardBinding binding;
    private final Lazy calendar$delegate;
    private final Integer nameColor;
    private final Function2<DeviceAlarm, Boolean, Unit> onAlarmChecked;
    private final Function1<DeviceAlarm, Unit> onAlarmTapped;
    private final Lazy timeFormatter$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AlarmCardViewHolder(HolderAlarmCardBinding holderAlarmCardBinding, Function2 function2, Function1 function1, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(holderAlarmCardBinding, function2, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : num);
    }

    public final HolderAlarmCardBinding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JQ\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/blueair/devicedetails/viewholder/AlarmCardViewHolder$Companion;", "", "<init>", "()V", "instance", "Lcom/blueair/devicedetails/viewholder/AlarmCardViewHolder;", "parent", "Landroid/view/ViewGroup;", "onAlarmChecked", "Lkotlin/Function2;", "Lcom/blueair/core/model/DeviceAlarm;", "", "", "onAlarmTapped", "Lkotlin/Function1;", "nameColor", "", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;)Lcom/blueair/devicedetails/viewholder/AlarmCardViewHolder;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AlarmCardViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ AlarmCardViewHolder instance$default(Companion companion, ViewGroup viewGroup, Function2 function2, Function1 function1, Integer num, int i, Object obj) {
            if ((i & 4) != 0) {
                function1 = null;
            }
            if ((i & 8) != 0) {
                num = null;
            }
            return companion.instance(viewGroup, function2, function1, num);
        }

        public final AlarmCardViewHolder instance(ViewGroup viewGroup, Function2<? super DeviceAlarm, ? super Boolean, Unit> function2, Function1<? super DeviceAlarm, Unit> function1, Integer num) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            Intrinsics.checkNotNullParameter(function2, "onAlarmChecked");
            HolderAlarmCardBinding inflate = HolderAlarmCardBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new AlarmCardViewHolder(inflate, function2, function1, num);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlarmCardViewHolder(HolderAlarmCardBinding holderAlarmCardBinding, Function2<? super DeviceAlarm, ? super Boolean, Unit> function2, Function1<? super DeviceAlarm, Unit> function1, Integer num) {
        super(holderAlarmCardBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderAlarmCardBinding, "binding");
        Intrinsics.checkNotNullParameter(function2, "onAlarmChecked");
        this.binding = holderAlarmCardBinding;
        this.onAlarmChecked = function2;
        this.onAlarmTapped = function1;
        this.nameColor = num;
        this.timeFormatter$delegate = LazyKt.lazy(new AlarmCardViewHolder$$ExternalSyntheticLambda0(this));
        this.calendar$delegate = LazyKt.lazy(new AlarmCardViewHolder$$ExternalSyntheticLambda1());
        if (num != null) {
            holderAlarmCardBinding.tvName.setTextColor(num.intValue());
        }
    }

    private final SimpleDateFormat getTimeFormatter() {
        return (SimpleDateFormat) this.timeFormatter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final SimpleDateFormat timeFormatter_delegate$lambda$0(AlarmCardViewHolder alarmCardViewHolder) {
        return new SimpleDateFormat(DateFormat.is24HourFormat(alarmCardViewHolder.itemView.getContext()) ? "HH:mm" : "hh:mm a");
    }

    private final Calendar getCalendar() {
        return (Calendar) this.calendar$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Calendar calendar_delegate$lambda$1() {
        return Calendar.getInstance();
    }

    public final void bind(DeviceAlarm deviceAlarm, boolean z) {
        Intrinsics.checkNotNullParameter(deviceAlarm, "item");
        HolderAlarmCardBinding holderAlarmCardBinding = this.binding;
        holderAlarmCardBinding.tvTime.setText(getDisplayTime(deviceAlarm.getSecondsInDay()));
        holderAlarmCardBinding.tvName.setText(deviceAlarm.getName());
        boolean z2 = true;
        holderAlarmCardBinding.switchAlarm.setEnabled(!z);
        holderAlarmCardBinding.switchAlarm.setCheckedSilence(deviceAlarm.getEnabled());
        if (!deviceAlarm.getDaysOfWeek().isEmpty()) {
            TextView textView = holderAlarmCardBinding.tvRepeat;
            Set set = CollectionsKt.toSet(CollectionsKt.sortedWith(deviceAlarm.getDaysOfWeek(), new AlarmCardViewHolder$bind$lambda$6$$inlined$sortedBy$1()));
            Context context = holderAlarmCardBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setText(DayOfWeekExtensionKt.toString(set, context));
            TextView textView2 = holderAlarmCardBinding.tvRepeat;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvRepeat");
            ViewExtensionsKt.show$default(textView2, false, 1, (Object) null);
        } else {
            TextView textView3 = holderAlarmCardBinding.tvRepeat;
            Intrinsics.checkNotNullExpressionValue(textView3, "tvRepeat");
            ViewExtensionsKt.hide(textView3);
        }
        ImageView imageView = holderAlarmCardBinding.ivLight;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivLight");
        ViewExtensionsKt.show(imageView, deviceAlarm.getLightEnabled());
        ImageView imageView2 = holderAlarmCardBinding.ivSound;
        Intrinsics.checkNotNullExpressionValue(imageView2, "ivSound");
        View view = imageView2;
        if (deviceAlarm.getSound() == AlarmSound.Mute.getValue()) {
            z2 = false;
        }
        ViewExtensionsKt.show(view, z2);
        holderAlarmCardBinding.getRoot().setOnClickListener(new AlarmCardViewHolder$$ExternalSyntheticLambda2(this, deviceAlarm));
        holderAlarmCardBinding.switchAlarm.setOnCheckedChangeListener(new AlarmCardViewHolder$$ExternalSyntheticLambda3(this, deviceAlarm));
    }

    /* access modifiers changed from: private */
    public static final void bind$lambda$6$lambda$4(AlarmCardViewHolder alarmCardViewHolder, DeviceAlarm deviceAlarm, View view) {
        Function1<DeviceAlarm, Unit> function1 = alarmCardViewHolder.onAlarmTapped;
        if (function1 != null) {
            function1.invoke(deviceAlarm);
        }
    }

    /* access modifiers changed from: private */
    public static final void bind$lambda$6$lambda$5(AlarmCardViewHolder alarmCardViewHolder, DeviceAlarm deviceAlarm, CompoundButton compoundButton, boolean z) {
        alarmCardViewHolder.onAlarmChecked.invoke(deviceAlarm, Boolean.valueOf(z));
    }

    private final String getDisplayTime(int i) {
        int i2 = i / DateTimeConstants.SECONDS_PER_HOUR;
        getCalendar().set(11, i2);
        getCalendar().set(12, (i - (i2 * DateTimeConstants.SECONDS_PER_HOUR)) / 60);
        String format = getTimeFormatter().format(getCalendar().getTime());
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
