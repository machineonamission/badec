package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.TimerState;
import com.blueair.devicedetails.databinding.HolderDeviceHTimerBinding;
import com.blueair.devicedetails.dialog.DeviceTimerPickerDialogFragment;
import com.blueair.viewcore.R;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.joda.time.DateTimeConstants;
import timber.log.Timber;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aBO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHTimerHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceHTimerBinding;", "device", "Lcom/blueair/core/model/Device;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onStateSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/TimerState;", "onDurationSetListener", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceHTimerBinding;Lcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceHTimerBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "liveDevice", "enableView", "enable", "", "timerState", "update", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceHTimerHolder.kt */
public final class DeviceHTimerHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceHTimerBinding binding;
    private final Device device;
    private Device liveDevice;
    private final Function1<Integer, Unit> onDurationSetListener;
    private final Function0<Unit> onOpenInfoListener;
    private final Function1<TimerState, Unit> onStateSetListener;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceHTimerHolder.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.blueair.core.model.TimerState[] r0 = com.blueair.core.model.TimerState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.TimerState r1 = com.blueair.core.model.TimerState.COMPLETED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.TimerState r1 = com.blueair.core.model.TimerState.START     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.TimerState r1 = com.blueair.core.model.TimerState.RESUME     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.TimerState r1 = com.blueair.core.model.TimerState.STOP     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceHTimerHolder.WhenMappings.<clinit>():void");
        }
    }

    public final HolderDeviceHTimerBinding getBinding() {
        return this.binding;
    }

    public final Device getDevice() {
        return this.device;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u000e¨\u0006\u0012"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHTimerHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceHTimerHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onStateSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/TimerState;", "onDurationSetListener", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceHTimerHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceHTimerHolder newInstance(ViewGroup viewGroup, Device device, Function0<Unit> function0, Function1<? super TimerState, Unit> function1, Function1<? super Integer, Unit> function12) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onOpenInfoListener");
            Intrinsics.checkNotNullParameter(function1, "onStateSetListener");
            Intrinsics.checkNotNullParameter(function12, "onDurationSetListener");
            HolderDeviceHTimerBinding inflate = HolderDeviceHTimerBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceHTimerHolder(inflate, device, function0, function1, function12);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceHTimerHolder(com.blueair.devicedetails.databinding.HolderDeviceHTimerBinding r3, com.blueair.core.model.Device r4, kotlin.jvm.functions.Function0<kotlin.Unit> r5, kotlin.jvm.functions.Function1<? super com.blueair.core.model.TimerState, kotlin.Unit> r6, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r7) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onOpenInfoListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "onStateSetListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "onDurationSetListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            android.widget.FrameLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r2.<init>(r0)
            r2.binding = r3
            r2.device = r4
            r2.onOpenInfoListener = r5
            r2.onStateSetListener = r6
            r2.onDurationSetListener = r7
            r2.liveDevice = r4
            android.widget.TextView r4 = r3.timerTitle
            com.blueair.devicedetails.viewholder.DeviceHTimerHolder$$ExternalSyntheticLambda0 r5 = new com.blueair.devicedetails.viewholder.DeviceHTimerHolder$$ExternalSyntheticLambda0
            r5.<init>(r2)
            r4.setOnClickListener(r5)
            android.widget.TextView r4 = r3.timerSelect
            com.blueair.devicedetails.viewholder.DeviceHTimerHolder$$ExternalSyntheticLambda1 r5 = new com.blueair.devicedetails.viewholder.DeviceHTimerHolder$$ExternalSyntheticLambda1
            r5.<init>(r2)
            r4.setOnClickListener(r5)
            androidx.appcompat.widget.AppCompatImageView r4 = r3.timerControlIcon
            com.blueair.devicedetails.viewholder.DeviceHTimerHolder$$ExternalSyntheticLambda2 r5 = new com.blueair.devicedetails.viewholder.DeviceHTimerHolder$$ExternalSyntheticLambda2
            r5.<init>(r2)
            r4.setOnClickListener(r5)
            android.widget.FrameLayout r3 = r3.contentProgress
            com.blueair.devicedetails.viewholder.DeviceHTimerHolder$$ExternalSyntheticLambda3 r4 = new com.blueair.devicedetails.viewholder.DeviceHTimerHolder$$ExternalSyntheticLambda3
            r4.<init>(r2)
            r3.setOnClickListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceHTimerHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceHTimerBinding, com.blueair.core.model.Device, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void");
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceHTimerHolder deviceHTimerHolder, View view) {
        deviceHTimerHolder.onOpenInfoListener.invoke();
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$6(DeviceHTimerHolder deviceHTimerHolder, View view) {
        Device device2 = deviceHTimerHolder.liveDevice;
        HasTimer hasTimer = device2 instanceof HasTimer ? (HasTimer) device2 : null;
        if (hasTimer != null) {
            Context context = view.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            Class<DeviceTimerPickerDialogFragment> cls = DeviceTimerPickerDialogFragment.class;
            Intrinsics.checkNotNullExpressionValue("DeviceTimerPickerDialogFragment", "getSimpleName(...)");
            if (!(supportFragmentManager.findFragmentByTag("DeviceTimerPickerDialogFragment") instanceof DeviceTimerPickerDialogFragment) && !supportFragmentManager.isStateSaved()) {
                String string = view.getContext().getString(R.string.timer);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String string2 = deviceHTimerHolder.binding.getRoot().getContext().getString(R.string.timer_duration);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                Device device3 = deviceHTimerHolder.device;
                List list = CollectionsKt.toList(new IntRange(1, ((device3 instanceof DevicePet20) || (device3 instanceof DeviceCombo2in1) || (device3 instanceof DeviceCombo3in1)) ? 24 : 12));
                Iterable<Number> iterable = list;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Number intValue : iterable) {
                    String format = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(intValue.intValue())}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    arrayList.add(format);
                }
                DeviceTimerPickerDialogFragment newInstance = DeviceTimerPickerDialogFragment.Companion.newInstance(string, (List) arrayList, RangesKt.coerceAtLeast(list.indexOf(Integer.valueOf(hasTimer.getTimerDuration() / DateTimeConstants.SECONDS_PER_HOUR)), 0), true);
                newInstance.setOnPickResult(new DeviceHTimerHolder$$ExternalSyntheticLambda4(deviceHTimerHolder, list));
                newInstance.show(supportFragmentManager, "DeviceTimerPickerDialogFragment");
            }
        }
    }

    static final Unit lambda$6$lambda$5$lambda$4$lambda$3$lambda$2(DeviceHTimerHolder deviceHTimerHolder, List list, int i) {
        deviceHTimerHolder.onDurationSetListener.invoke(Integer.valueOf(((Number) list.get(i)).intValue() * DateTimeConstants.SECONDS_PER_HOUR));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$8(DeviceHTimerHolder deviceHTimerHolder, View view) {
        Device device2 = deviceHTimerHolder.liveDevice;
        HasTimer hasTimer = device2 instanceof HasTimer ? (HasTimer) device2 : null;
        if (hasTimer != null) {
            if (WhenMappings.$EnumSwitchMapping$0[hasTimer.timerStatus().ordinal()] == 1) {
                deviceHTimerHolder.onStateSetListener.invoke(TimerState.START);
            } else {
                deviceHTimerHolder.onStateSetListener.invoke(TimerState.COMPLETED);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$10(DeviceHTimerHolder deviceHTimerHolder, View view) {
        Device device2 = deviceHTimerHolder.liveDevice;
        HasTimer hasTimer = device2 instanceof HasTimer ? (HasTimer) device2 : null;
        if (hasTimer != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[hasTimer.timerStatus().ordinal()];
            if (i == 2 || i == 3) {
                deviceHTimerHolder.onStateSetListener.invoke(TimerState.STOP);
            } else if (i == 4) {
                deviceHTimerHolder.onStateSetListener.invoke(TimerState.RESUME);
            }
        }
    }

    private final void enableView(boolean z, TimerState timerState) {
        int i;
        this.binding.timerSelect.setEnabled(z);
        this.binding.timerControlIcon.setEnabled(z);
        this.binding.contentProgress.setEnabled(z);
        this.binding.timerProgressBar.setEnabled(z);
        this.binding.timerProgressStatusIcon.setEnabled(z);
        Context context = this.itemView.getContext();
        int i2 = WhenMappings.$EnumSwitchMapping$0[timerState.ordinal()];
        if (i2 == 1) {
            i = R.color.greyblue;
        } else if (i2 != 4) {
            i = z ? R.color.colorPrimary : R.color.greyblue;
        } else {
            i = z ? R.color.colorPrimary : R.color.greyblue;
        }
        this.binding.timerProgressBar.setIndicatorColor(context.getColor(i));
        this.binding.timerProgressBar.setTrackColor(this.itemView.getContext().getColor(z ? R.color.timberwolf : R.color.anti_flash_blue));
        this.binding.timerSelect.setTextColor(this.itemView.getContext().getColor(z ? R.color.colorPrimaryText : R.color.greyblue));
    }

    public void update(Device device2) {
        int i;
        Intrinsics.checkNotNullParameter(device2, "device");
        if (device2 instanceof HasTimer) {
            this.liveDevice = device2;
            HasTimer hasTimer = (HasTimer) device2;
            TimerState timerStatus = hasTimer.timerStatus();
            boolean z = false;
            if (WhenMappings.$EnumSwitchMapping$0[timerStatus.ordinal()] == 1) {
                TextView textView = this.binding.timerSelect;
                Intrinsics.checkNotNullExpressionValue(textView, "timerSelect");
                ViewExtensionsKt.show$default(textView, false, 1, (Object) null);
                TextView textView2 = this.binding.timerSelect;
                String string = this.itemView.getContext().getString(R.string.timer_duration);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(hasTimer.getTimerDuration() / DateTimeConstants.SECONDS_PER_HOUR)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView2.setText(format);
                this.binding.timerControlIcon.setImageResource(R.drawable.selector_timer_start);
                LinearLayout linearLayout = this.binding.contentCountdown;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "contentCountdown");
                ViewExtensionsKt.hide(linearLayout);
            } else {
                TextView textView3 = this.binding.timerSelect;
                Intrinsics.checkNotNullExpressionValue(textView3, "timerSelect");
                ViewExtensionsKt.hide(textView3);
                this.binding.timerControlIcon.setImageResource(R.drawable.selector_timer_stop);
                LinearLayout linearLayout2 = this.binding.contentCountdown;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "contentCountdown");
                ViewExtensionsKt.show$default(linearLayout2, false, 1, (Object) null);
                if (timerStatus == TimerState.STOP) {
                    this.binding.countdownNumber.setTextColor(this.itemView.getContext().getColor(R.color.lightbluegrey));
                    this.binding.timerProgressBar.setIndicatorColor(this.itemView.getContext().getColor(R.color.colorPrimary));
                    this.binding.timerProgressStatusIcon.setImageResource(R.drawable.selector_timer_progress_start);
                } else {
                    this.binding.countdownNumber.setTextColor(this.itemView.getContext().getColor(R.color.colorPrimary));
                    this.binding.timerProgressBar.setIndicatorColor(this.itemView.getContext().getColor(R.color.colorPrimary));
                    this.binding.timerProgressStatusIcon.setImageResource(R.drawable.selector_timer_progress_pause);
                }
                int timerLeftTime = hasTimer.getTimerLeftTime();
                int coerceAtLeast = RangesKt.coerceAtLeast(hasTimer.getTimerDuration(), 1);
                int i2 = WhenMappings.$EnumSwitchMapping$0[timerStatus.ordinal()];
                if (i2 == 2 || i2 == 3) {
                    i = HasTimer.CC.getRealTimerLeftTime$default(hasTimer, 0, 1, (Object) null);
                } else if (i2 != 4) {
                    i = 0;
                } else {
                    i = RangesKt.coerceIn(timerLeftTime, 0, coerceAtLeast);
                }
                Timber.Forest.d(HasTimer.CC.getRealTimerLeftTime$default(hasTimer, 0, 1, (Object) null) + " _ " + hasTimer.getTimerLeftTimeUpdateTime(), new Object[0]);
                this.binding.timerProgressBar.setProgress((i * 100) / coerceAtLeast);
                int i3 = i / DateTimeConstants.SECONDS_PER_HOUR;
                int i4 = i - (i3 * DateTimeConstants.SECONDS_PER_HOUR);
                int i5 = i4 / 60;
                TextView textView4 = this.binding.countdownNumber;
                String format2 = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i4 - (i5 * 60))}, 3));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                textView4.setText(format2);
            }
            if ((device2 instanceof HasCombo3in1MainMode) && ((HasMainMode) device2).isInMainMode(MainMode.HEAT) && device2.isUsDevice()) {
                z = true;
            }
            enableView(!z, hasTimer.timerStatus());
        }
    }
}
