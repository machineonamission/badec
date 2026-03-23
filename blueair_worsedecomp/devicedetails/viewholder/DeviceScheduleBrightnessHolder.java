package com.blueair.devicedetails.viewholder;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Brightness;
import com.blueair.core.model.BrightnessKt;
import com.blueair.core.model.Device;
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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0011H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleBrightnessHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceBrightnessBinding;", "onBrightnessChanged", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceBrightnessBinding;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceBrightnessBinding;", "brightnessSeekbar", "Lcom/blueair/viewcore/view/AccessibleSeekBar;", "brightnessPercentView", "Landroid/widget/TextView;", "lastProgress", "", "bind", "device", "Lcom/blueair/core/model/Device;", "brightness", "onProgressSet", "isSlidingRight", "", "progress", "updateThumb", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceScheduleBrightnessHolder.kt */
public final class DeviceScheduleBrightnessHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceBrightnessBinding binding;
    /* access modifiers changed from: private */
    public final TextView brightnessPercentView;
    private final AccessibleSeekBar brightnessSeekbar;
    private int lastProgress;
    private final Function1<Object, Unit> onBrightnessChanged;

    public final HolderDeviceBrightnessBinding getBinding() {
        return this.binding;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceScheduleBrightnessHolder(HolderDeviceBrightnessBinding holderDeviceBrightnessBinding, Function1<Object, Unit> function1) {
        super(holderDeviceBrightnessBinding.getRoot());
        Drawable findDrawableByLayerId;
        Drawable mutate;
        Intrinsics.checkNotNullParameter(holderDeviceBrightnessBinding, "binding");
        Intrinsics.checkNotNullParameter(function1, "onBrightnessChanged");
        this.binding = holderDeviceBrightnessBinding;
        this.onBrightnessChanged = function1;
        AccessibleSeekBar accessibleSeekBar = holderDeviceBrightnessBinding.brightnessSeekbar;
        Intrinsics.checkNotNullExpressionValue(accessibleSeekBar, "brightnessSeekbar");
        this.brightnessSeekbar = accessibleSeekBar;
        TextView textView = holderDeviceBrightnessBinding.settingValue;
        Intrinsics.checkNotNullExpressionValue(textView, "settingValue");
        this.brightnessPercentView = textView;
        Drawable progressDrawable = accessibleSeekBar.getProgressDrawable();
        LayerDrawable layerDrawable = progressDrawable instanceof LayerDrawable ? (LayerDrawable) progressDrawable : null;
        if (layerDrawable != null && (findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908301)) != null && (mutate = findDrawableByLayerId.mutate()) != null) {
            mutate.setTint(ContextCompat.getColor(this.itemView.getContext(), R.color.colorPrimary));
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleBrightnessHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceScheduleBrightnessHolder;", "parentView", "Landroid/view/ViewGroup;", "onBrightnessChanged", "Lkotlin/Function1;", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceScheduleBrightnessHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceScheduleBrightnessHolder newInstance(ViewGroup viewGroup, Function1<Object, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onBrightnessChanged");
            HolderDeviceBrightnessBinding inflate = HolderDeviceBrightnessBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceScheduleBrightnessHolder(inflate, function1);
        }
    }

    public final void bind(Device device, Object obj) {
        Integer num;
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(obj, "brightness");
        Timber.Forest forest = Timber.Forest;
        forest.d("current offset: " + this.brightnessSeekbar.getThumbOffset(), new Object[0]);
        if (obj instanceof Brightness) {
            num = Integer.valueOf(((Brightness) obj).toPercentage());
        } else {
            num = (Integer) obj;
        }
        int intValue = num.intValue();
        TextView textView = this.brightnessPercentView;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%d %s", Arrays.copyOf(new Object[]{Integer.valueOf(intValue), "%"}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        updateThumb(intValue);
        this.brightnessSeekbar.setProgress(intValue);
        this.lastProgress = this.brightnessSeekbar.getProgress();
        this.brightnessSeekbar.setOnSeekBarChangeListener(new DeviceScheduleBrightnessHolder$bind$2(this, device));
    }

    /* access modifiers changed from: private */
    public final void onProgressSet(Device device) {
        int progress = this.brightnessSeekbar.getProgress();
        if (BrightnessKt.hasBrightnessInPercent(device)) {
            updateThumb(progress);
            Timber.Forest forest = Timber.Forest;
            forest.d("brightness seekbar:  progress = " + this.brightnessSeekbar.getProgress(), new Object[0]);
            this.onBrightnessChanged.invoke(Integer.valueOf(progress));
        } else {
            Brightness fromPercentage = Brightness.Companion.fromPercentage(progress, isSlidingRight(progress));
            updateThumb(fromPercentage.toPercentage());
            this.brightnessSeekbar.setProgress(fromPercentage.toPercentage());
            Timber.Forest forest2 = Timber.Forest;
            forest2.d("brightness seekbar:  progress = " + this.brightnessSeekbar.getProgress() + ", brightness = " + fromPercentage + ", direction: " + isSlidingRight(progress), new Object[0]);
            this.onBrightnessChanged.invoke(fromPercentage);
        }
        this.lastProgress = this.brightnessSeekbar.getProgress();
    }

    /* access modifiers changed from: private */
    public final boolean isSlidingRight(int i) {
        return this.lastProgress < i;
    }

    /* access modifiers changed from: private */
    public final void updateThumb(int i) {
        if (i == 0) {
            this.brightnessSeekbar.setThumb(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.thumb_brightness_at_0_percent));
        } else if (1 <= i && i < 3) {
            this.brightnessSeekbar.setThumb(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.thumb_brightness_at_two_percent));
        } else if (3 <= i && i < 6) {
            this.brightnessSeekbar.setThumb(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.atoms_layers_neumorphs_brightness_knob));
        } else if (i == 97) {
            this.brightnessSeekbar.setThumb(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.thumb_brightness_at_97_percent));
        } else if (i == 98) {
            this.brightnessSeekbar.setThumb(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.thumb_brightness_at_98_percent));
        } else if (i == 99) {
            this.brightnessSeekbar.setThumb(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.thumb_brightness_at_99_percent));
        } else if (i == 100) {
            this.brightnessSeekbar.setThumb(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.thumb_brightness_at_100_percent));
        } else {
            this.brightnessSeekbar.setThumb(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.thumb_brightness));
        }
    }
}
