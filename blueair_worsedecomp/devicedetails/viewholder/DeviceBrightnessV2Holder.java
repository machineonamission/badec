package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.databinding.HolderDeviceBrightnessV2Binding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B:\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0017J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceBrightnessV2Holder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceBrightnessV2Binding;", "binding", "isInSchedule", "", "onBrightnessSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "brightness", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceBrightnessV2Binding;ZLkotlin/jvm/functions/Function1;)V", "()Z", "minBrightness", "inTouch", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "calcProgress", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceBrightnessV2Holder.kt */
public final class DeviceBrightnessV2Holder extends DeviceControlHolder<HolderDeviceBrightnessV2Binding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public boolean inTouch;
    private final boolean isInSchedule;
    /* access modifiers changed from: private */
    public int minBrightness;
    /* access modifiers changed from: private */
    public final Function1<Integer, Unit> onBrightnessSetListener;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceBrightnessV2Holder.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.blueair.core.model.ApSubMode[] r0 = com.blueair.core.model.ApSubMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.ApSubMode r1 = com.blueair.core.model.ApSubMode.ECO     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.ApSubMode r1 = com.blueair.core.model.ApSubMode.NIGHT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceBrightnessV2Holder.WhenMappings.<clinit>():void");
        }
    }

    public final boolean isInSchedule() {
        return this.isInSchedule;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b¨\u0006\u0011"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceBrightnessV2Holder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceBrightnessV2Holder;", "parentView", "Landroid/view/ViewGroup;", "isInSchedule", "", "onBrightnessSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "brightness", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceBrightnessV2Holder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceBrightnessV2Holder newInstance(ViewGroup viewGroup, boolean z, Function1<? super Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onBrightnessSetListener");
            HolderDeviceBrightnessV2Binding inflate = HolderDeviceBrightnessV2Binding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceBrightnessV2Holder(inflate, z, function1);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceBrightnessV2Holder(HolderDeviceBrightnessV2Binding holderDeviceBrightnessV2Binding, boolean z, Function1<? super Integer, Unit> function1) {
        super(holderDeviceBrightnessV2Binding);
        Intrinsics.checkNotNullParameter(holderDeviceBrightnessV2Binding, "binding");
        Intrinsics.checkNotNullParameter(function1, "onBrightnessSetListener");
        this.isInSchedule = z;
        this.onBrightnessSetListener = function1;
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        View view = holderDeviceBrightnessV2Binding.clickView;
        Intrinsics.checkNotNullExpressionValue(view, "clickView");
        ViewUtils.setAccessibilityDelegate$default(viewUtils, view, (KClass) null, getString(R.string.button_role), (Function2) null, 10, (Object) null);
        holderDeviceBrightnessV2Binding.clickView.setOnClickListener(new DeviceBrightnessV2Holder$$ExternalSyntheticLambda1(holderDeviceBrightnessV2Binding));
        holderDeviceBrightnessV2Binding.expendSwitch.setOnCheckedChangeListener(new DeviceBrightnessV2Holder$$ExternalSyntheticLambda2(holderDeviceBrightnessV2Binding));
        holderDeviceBrightnessV2Binding.seekbar.setOnSeekBarChangeListener(new DeviceBrightnessV2Holder$1$3(holderDeviceBrightnessV2Binding, this));
        if (z) {
            holderDeviceBrightnessV2Binding.expendSwitch.setChecked(false);
        }
    }

    static final void lambda$2$lambda$0(HolderDeviceBrightnessV2Binding holderDeviceBrightnessV2Binding, View view) {
        holderDeviceBrightnessV2Binding.expendSwitch.setChecked(!holderDeviceBrightnessV2Binding.expendSwitch.isChecked());
    }

    static final void lambda$2$lambda$1(HolderDeviceBrightnessV2Binding holderDeviceBrightnessV2Binding, CompoundButton compoundButton, boolean z) {
        Group group = holderDeviceBrightnessV2Binding.expendedContent;
        Intrinsics.checkNotNullExpressionValue(group, "expendedContent");
        ViewExtensionsKt.show(group, !z);
    }

    public void update(Device device, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
        if (!this.inTouch) {
            if (device instanceof HasBrightness) {
                update(device, ((HasBrightness) device).getBrightness());
            }
            if (z || !device.isOnline() || DeviceKt.isStandByOn(device)) {
                HolderDeviceBrightnessV2Binding holderDeviceBrightnessV2Binding = (HolderDeviceBrightnessV2Binding) getBinding();
                holderDeviceBrightnessV2Binding.clickView.setEnabled(false);
                holderDeviceBrightnessV2Binding.expendSwitch.setEnabled(false);
                holderDeviceBrightnessV2Binding.expendSwitch.setChecked(true);
                SwitchCompat switchCompat = holderDeviceBrightnessV2Binding.expendSwitch;
                Intrinsics.checkNotNullExpressionValue(switchCompat, "expendSwitch");
                ViewExtensionsKt.show(switchCompat, true);
                holderDeviceBrightnessV2Binding.getRoot().setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.surface_dark_5)));
                holderDeviceBrightnessV2Binding.leadingIcon.setImageResource(R.drawable.ic_brightness_disabled);
                holderDeviceBrightnessV2Binding.title.setTextColor(getColor(R.color.surface_dark_55));
                holderDeviceBrightnessV2Binding.progressText.setText("");
            } else {
                HolderDeviceBrightnessV2Binding holderDeviceBrightnessV2Binding2 = (HolderDeviceBrightnessV2Binding) getBinding();
                holderDeviceBrightnessV2Binding2.clickView.setEnabled(true);
                holderDeviceBrightnessV2Binding2.expendSwitch.setEnabled(true);
                holderDeviceBrightnessV2Binding2.getRoot().setBackgroundTintList((ColorStateList) null);
                holderDeviceBrightnessV2Binding2.leadingIcon.setImageResource(R.drawable.ic_brightness);
                holderDeviceBrightnessV2Binding2.title.setTextColor(getColor(R.color.colorPrimaryText));
                if (device instanceof HasMainMode) {
                    HasMainMode hasMainMode = (HasMainMode) device;
                    if (hasMainMode.isInMainMode(MainMode.AirPurify)) {
                        int i = WhenMappings.$EnumSwitchMapping$0[hasMainMode.apSubMode().ordinal()];
                        if (i == 1) {
                            holderDeviceBrightnessV2Binding2.clickView.setEnabled(false);
                            SwitchCompat switchCompat2 = holderDeviceBrightnessV2Binding2.expendSwitch;
                            Intrinsics.checkNotNullExpressionValue(switchCompat2, "expendSwitch");
                            ViewExtensionsKt.show(switchCompat2, false);
                            holderDeviceBrightnessV2Binding2.expendSwitch.setChecked(true);
                            holderDeviceBrightnessV2Binding2.progressText.setText(R.string.eco);
                        } else if (i != 2) {
                            SwitchCompat switchCompat3 = holderDeviceBrightnessV2Binding2.expendSwitch;
                            Intrinsics.checkNotNullExpressionValue(switchCompat3, "expendSwitch");
                            ViewExtensionsKt.show(switchCompat3, true);
                        } else {
                            holderDeviceBrightnessV2Binding2.clickView.setEnabled(false);
                            SwitchCompat switchCompat4 = holderDeviceBrightnessV2Binding2.expendSwitch;
                            Intrinsics.checkNotNullExpressionValue(switchCompat4, "expendSwitch");
                            ViewExtensionsKt.show(switchCompat4, false);
                            holderDeviceBrightnessV2Binding2.expendSwitch.setChecked(true);
                            holderDeviceBrightnessV2Binding2.progressText.setText(R.string.night);
                        }
                    }
                }
            }
            View view = ((HolderDeviceBrightnessV2Binding) getBinding()).clickView;
            view.setContentDescription(((HolderDeviceBrightnessV2Binding) getBinding()).title.getText() + ", " + ((HolderDeviceBrightnessV2Binding) getBinding()).progressText.getText());
        }
    }

    public final void update(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        if (DeviceKt.useNewBrightnessRange(device)) {
            this.minBrightness = 10;
            if (Build.VERSION.SDK_INT >= 26) {
                ((HolderDeviceBrightnessV2Binding) getBinding()).seekbar.setMin(this.minBrightness);
            }
            TextView textView = ((HolderDeviceBrightnessV2Binding) getBinding()).tvProgress0;
            StringBuilder sb = new StringBuilder();
            sb.append(this.minBrightness);
            sb.append('%');
            textView.setText(sb.toString());
        }
        int coerceIn = RangesKt.coerceIn(i, this.minBrightness, 100);
        ((HolderDeviceBrightnessV2Binding) getBinding()).seekbar.setProgress(calcProgress(coerceIn));
        TextView textView2 = ((HolderDeviceBrightnessV2Binding) getBinding()).progressText;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(coerceIn);
        sb2.append('%');
        textView2.setText(sb2.toString());
        View view = ((HolderDeviceBrightnessV2Binding) getBinding()).clickView;
        view.setContentDescription(((HolderDeviceBrightnessV2Binding) getBinding()).title.getText() + ", " + ((HolderDeviceBrightnessV2Binding) getBinding()).progressText.getText());
    }

    public final int calcProgress(int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return i;
        }
        int i2 = this.minBrightness;
        return MathKt.roundToInt(((((float) (i - i2)) * 100.0f) / ((float) (100 - i2))) + 0.5f);
    }
}
