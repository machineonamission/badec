package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blueair.core.model.Brightness;
import com.blueair.core.model.BrightnessKt;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.DeviceB4;
import com.blueair.core.model.DeviceB4sp;
import com.blueair.core.model.DeviceBlue;
import com.blueair.core.model.DeviceBluePremium;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasStandBy;
import com.blueair.devicedetails.databinding.HolderDeviceBrightnessBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import timber.log.Timber;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0018H\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0018H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceBrightnessHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceBrightnessBinding;", "onBrightnessSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/Brightness;", "", "onBrightnessIntSetListener", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceBrightnessBinding;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceBrightnessBinding;", "brightnessSeekbar", "Lcom/blueair/viewcore/view/AccessibleSeekBar;", "brightnessPercentView", "Landroid/widget/TextView;", "titleView", "lastProgress", "onProgressSet", "device", "Lcom/blueair/core/model/HasBrightness;", "update", "Lcom/blueair/core/model/Device;", "isSlidingRight", "", "progress", "updateThumb", "setOnline", "setOffline", "initializeBrightnessState", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceBrightnessHolder.kt */
public final class DeviceBrightnessHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceBrightnessBinding binding;
    /* access modifiers changed from: private */
    public final TextView brightnessPercentView;
    private final AccessibleSeekBar brightnessSeekbar;
    private int lastProgress;
    private final Function1<Integer, Unit> onBrightnessIntSetListener;
    private final Function1<Brightness, Unit> onBrightnessSetListener;
    private final TextView titleView;

    /* access modifiers changed from: private */
    public final void updateThumb(int i) {
    }

    public final HolderDeviceBrightnessBinding getBinding() {
        return this.binding;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceBrightnessHolder(com.blueair.devicedetails.databinding.HolderDeviceBrightnessBinding r3, kotlin.jvm.functions.Function1<? super com.blueair.core.model.Brightness, kotlin.Unit> r4, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r5) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onBrightnessSetListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "onBrightnessIntSetListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r2.<init>(r0)
            r2.binding = r3
            r2.onBrightnessSetListener = r4
            r2.onBrightnessIntSetListener = r5
            com.blueair.viewcore.view.AccessibleSeekBar r4 = r3.brightnessSeekbar
            java.lang.String r5 = "brightnessSeekbar"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r2.brightnessSeekbar = r4
            android.widget.TextView r5 = r3.settingValue
            java.lang.String r0 = "settingValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            r2.brightnessPercentView = r5
            android.widget.TextView r3 = r3.settingTitle
            java.lang.String r5 = "settingTitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            r2.titleView = r3
            android.graphics.drawable.Drawable r3 = r4.getProgressDrawable()
            boolean r4 = r3 instanceof android.graphics.drawable.LayerDrawable
            if (r4 == 0) goto L_0x0049
            android.graphics.drawable.LayerDrawable r3 = (android.graphics.drawable.LayerDrawable) r3
            goto L_0x004a
        L_0x0049:
            r3 = 0
        L_0x004a:
            if (r3 == 0) goto L_0x006a
            r4 = 16908301(0x102000d, float:2.3877265E-38)
            android.graphics.drawable.Drawable r3 = r3.findDrawableByLayerId(r4)
            if (r3 == 0) goto L_0x006a
            android.graphics.drawable.Drawable r3 = r3.mutate()
            if (r3 == 0) goto L_0x006a
            android.view.View r4 = r2.itemView
            android.content.Context r4 = r4.getContext()
            int r5 = com.blueair.viewcore.R.color.colorPrimary
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r3.setTint(r4)
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceBrightnessHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceBrightnessBinding, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void");
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\t¨\u0006\u000e"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceBrightnessHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceBrightnessHolder;", "parentView", "Landroid/view/ViewGroup;", "onBrightnessSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/Brightness;", "", "onBrightnessIntSetListener", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceBrightnessHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceBrightnessHolder newInstance(ViewGroup viewGroup, Function1<? super Brightness, Unit> function1, Function1<? super Integer, Unit> function12) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onBrightnessSetListener");
            Intrinsics.checkNotNullParameter(function12, "onBrightnessIntSetListener");
            HolderDeviceBrightnessBinding inflate = HolderDeviceBrightnessBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceBrightnessHolder(inflate, function1, function12);
        }
    }

    /* access modifiers changed from: private */
    public final void onProgressSet(HasBrightness hasBrightness) {
        int progress = this.brightnessSeekbar.getProgress();
        Timber.Forest forest = Timber.Forest;
        forest.e("progress before snap: " + progress, new Object[0]);
        if (BrightnessKt.hasBrightnessInPercent(hasBrightness)) {
            updateThumb(progress);
            Timber.Forest.d("brightness seekbar:  progress = %d", Integer.valueOf(this.brightnessSeekbar.getProgress()));
            this.onBrightnessIntSetListener.invoke(Integer.valueOf(progress));
        } else {
            Brightness fromPercentage = Brightness.Companion.fromPercentage(progress, isSlidingRight(progress));
            updateThumb(fromPercentage.toPercentage());
            this.brightnessSeekbar.postDelayed(new DeviceBrightnessHolder$$ExternalSyntheticLambda0(this, fromPercentage), (long) ViewConfiguration.getTapTimeout());
            Timber.Forest.d("brightness seekbar:  progress = %d, brightness = %s, direction: %s", Integer.valueOf(progress), fromPercentage, Boolean.valueOf(isSlidingRight(progress)));
            this.onBrightnessSetListener.invoke(fromPercentage);
        }
        this.lastProgress = this.brightnessSeekbar.getProgress();
    }

    /* access modifiers changed from: private */
    public static final void onProgressSet$lambda$1(DeviceBrightnessHolder deviceBrightnessHolder, Brightness brightness) {
        deviceBrightnessHolder.brightnessSeekbar.setProgress(brightness.toPercentage());
        Timber.Forest forest = Timber.Forest;
        forest.e("progress after snap: " + deviceBrightnessHolder.brightnessSeekbar.getProgress(), new Object[0]);
    }

    public void update(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        if (device instanceof HasBrightness) {
            Timber.Forest forest = Timber.Forest;
            forest.d("current offset: " + this.brightnessSeekbar.getThumbOffset(), new Object[0]);
            initializeBrightnessState(device);
            if (device.getConnectivityStatus() != ConnectivityStatus.ONLINE) {
                setOffline(device);
            } else if ((!(device instanceof HasStandBy) || !((HasStandBy) device).isStandByOn()) && ((!(device instanceof HasG4NightMode) || !((HasG4NightMode) device).isG4NightModeOn()) && !DeviceKt.isDisinfectionOn(device))) {
                setOnline(device);
            } else {
                setOffline(device);
            }
            this.brightnessSeekbar.setOnSeekBarChangeListener(new DeviceBrightnessHolder$update$1(this, device));
        }
    }

    /* access modifiers changed from: private */
    public final boolean isSlidingRight(int i) {
        return this.lastProgress < i;
    }

    private final void setOnline(Device device) {
        this.brightnessPercentView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.colorPrimary));
        this.titleView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.marineblue));
        this.brightnessSeekbar.setAlpha(1.0f);
        this.brightnessSeekbar.setEnabled(true);
        initializeBrightnessState(device);
    }

    private final void setOffline(Device device) {
        this.brightnessPercentView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.smokegray));
        this.titleView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.smokegray));
        this.brightnessSeekbar.setAlpha(0.5f);
        this.brightnessSeekbar.setEnabled(false);
        initializeBrightnessState(device);
    }

    private final void initializeBrightnessState(Device device) {
        int i;
        if (device instanceof HasBrightness) {
            HasBrightness hasBrightness = (HasBrightness) device;
            if ((hasBrightness instanceof DeviceG4) || (hasBrightness instanceof DeviceB4) || (hasBrightness instanceof DeviceB4sp) || (hasBrightness instanceof DeviceBlue) || (hasBrightness instanceof DeviceBluePremium) || (hasBrightness instanceof DeviceAware)) {
                i = hasBrightness.getBrightness();
            } else {
                i = hasBrightness.getBrightnessEnum().toPercentage();
            }
            TextView textView = this.brightnessPercentView;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%d %s", Arrays.copyOf(new Object[]{Integer.valueOf(i), "%"}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
            updateThumb(i);
            this.brightnessSeekbar.setProgress(i);
            this.lastProgress = this.brightnessSeekbar.getProgress();
        }
    }
}
