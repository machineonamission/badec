package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.TimerState;
import com.blueair.devicedetails.databinding.HolderDeviceTimerBinding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joda.time.DateTimeConstants;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0003R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTimerHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceTimerBinding;", "binding", "onStateSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/TimerState;", "", "onClickDurationListener", "Lkotlin/Function0;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceTimerBinding;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "liveDevice", "Lcom/blueair/core/model/HasTimer;", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "hydrateTime", "leftSeconds", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceTimerHolder.kt */
public final class DeviceTimerHolder extends DeviceControlHolder<HolderDeviceTimerBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private HasTimer liveDevice;
    private final Function0<Unit> onClickDurationListener;
    private final Function1<TimerState, Unit> onStateSetListener;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceTimerHolder.kt */
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
                com.blueair.core.model.TimerState r1 = com.blueair.core.model.TimerState.START     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.TimerState r1 = com.blueair.core.model.TimerState.RESUME     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.TimerState r1 = com.blueair.core.model.TimerState.STOP     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.TimerState r1 = com.blueair.core.model.TimerState.COMPLETED     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceTimerHolder.WhenMappings.<clinit>():void");
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¨\u0006\u000e"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTimerHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceTimerHolder;", "parentView", "Landroid/view/ViewGroup;", "onStateSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/TimerState;", "", "onClickDurationListener", "Lkotlin/Function0;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceTimerHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceTimerHolder newInstance(ViewGroup viewGroup, Function1<? super TimerState, Unit> function1, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onStateSetListener");
            Intrinsics.checkNotNullParameter(function0, "onClickDurationListener");
            HolderDeviceTimerBinding inflate = HolderDeviceTimerBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceTimerHolder(inflate, function1, function0);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceTimerHolder(HolderDeviceTimerBinding holderDeviceTimerBinding, Function1<? super TimerState, Unit> function1, Function0<Unit> function0) {
        super(holderDeviceTimerBinding);
        Intrinsics.checkNotNullParameter(holderDeviceTimerBinding, "binding");
        Intrinsics.checkNotNullParameter(function1, "onStateSetListener");
        Intrinsics.checkNotNullParameter(function0, "onClickDurationListener");
        this.onStateSetListener = function1;
        this.onClickDurationListener = function0;
        holderDeviceTimerBinding.cbSwitch.setOnClickListener(new DeviceTimerHolder$$ExternalSyntheticLambda0(this));
        holderDeviceTimerBinding.tvTimer.setOnClickListener(new DeviceTimerHolder$$ExternalSyntheticLambda1(this));
        holderDeviceTimerBinding.ivClose.setOnClickListener(new DeviceTimerHolder$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(DeviceTimerHolder deviceTimerHolder, View view) {
        HasTimer hasTimer = deviceTimerHolder.liveDevice;
        if (hasTimer != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[hasTimer.timerStatus().ordinal()];
            if (i == 1 || i == 2) {
                deviceTimerHolder.onStateSetListener.invoke(TimerState.STOP);
            } else if (i != 3) {
                deviceTimerHolder.onStateSetListener.invoke(TimerState.START);
            } else {
                deviceTimerHolder.onStateSetListener.invoke(TimerState.RESUME);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$2(DeviceTimerHolder deviceTimerHolder, View view) {
        deviceTimerHolder.onClickDurationListener.invoke();
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$3(DeviceTimerHolder deviceTimerHolder, View view) {
        deviceTimerHolder.onStateSetListener.invoke(TimerState.COMPLETED);
    }

    public void update(Device device, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
        if (device instanceof HasTimer) {
            HasTimer hasTimer = (HasTimer) device;
            this.liveDevice = hasTimer;
            TimerState timerStatus = hasTimer.timerStatus();
            if (WhenMappings.$EnumSwitchMapping$0[timerStatus.ordinal()] == 4) {
                AppCompatImageView appCompatImageView = ((HolderDeviceTimerBinding) getBinding()).ivClose;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "ivClose");
                ViewExtensionsKt.hide(appCompatImageView);
                ((HolderDeviceTimerBinding) getBinding()).lavProgress.cancelAnimation();
                LottieAnimationView lottieAnimationView = ((HolderDeviceTimerBinding) getBinding()).lavProgress;
                Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lavProgress");
                ViewExtensionsKt.hide(lottieAnimationView);
                ((HolderDeviceTimerBinding) getBinding()).cbSwitch.setChecked(false);
                hydrateTime(hasTimer.getTimerDuration());
                ((HolderDeviceTimerBinding) getBinding()).tvTimer.setEnabled(true);
                return;
            }
            AppCompatImageView appCompatImageView2 = ((HolderDeviceTimerBinding) getBinding()).ivClose;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "ivClose");
            ViewExtensionsKt.show$default(appCompatImageView2, false, 1, (Object) null);
            ((HolderDeviceTimerBinding) getBinding()).cbSwitch.setChecked(timerStatus != TimerState.STOP);
            ((HolderDeviceTimerBinding) getBinding()).tvTimer.setEnabled(false);
            hydrateTime(hasTimer.getLeftSeconds());
            if (timerStatus == TimerState.STOP) {
                ((HolderDeviceTimerBinding) getBinding()).lavProgress.cancelAnimation();
                LottieAnimationView lottieAnimationView2 = ((HolderDeviceTimerBinding) getBinding()).lavProgress;
                Intrinsics.checkNotNullExpressionValue(lottieAnimationView2, "lavProgress");
                ViewExtensionsKt.hide(lottieAnimationView2);
                return;
            }
            if (!((HolderDeviceTimerBinding) getBinding()).lavProgress.isAnimating()) {
                ((HolderDeviceTimerBinding) getBinding()).lavProgress.playAnimation();
            }
            LottieAnimationView lottieAnimationView3 = ((HolderDeviceTimerBinding) getBinding()).lavProgress;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView3, "lavProgress");
            ViewExtensionsKt.show$default(lottieAnimationView3, false, 1, (Object) null);
        }
    }

    private final void hydrateTime(int i) {
        int i2 = i / DateTimeConstants.SECONDS_PER_HOUR;
        int ceil = (int) Math.ceil(((double) (i - (i2 * DateTimeConstants.SECONDS_PER_HOUR))) / 60.0d);
        if (ceil > 59) {
            i2++;
            ceil = 0;
        }
        AppCompatTextView appCompatTextView = ((HolderDeviceTimerBinding) getBinding()).tvTimer;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(ceil)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        appCompatTextView.setText(format);
    }
}
