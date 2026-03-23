package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasMoodLamp;
import com.blueair.core.model.MoodLampEnum;
import com.blueair.devicedetails.databinding.HolderDeviceMoodLampBinding;
import com.blueair.devicedetails.util.NightLampUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"BD\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0007H\u0016J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceMoodLampHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceMoodLampBinding;", "binding", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onLampGearSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/MoodLampEnum;", "Lkotlin/ParameterName;", "name", "gear", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceMoodLampBinding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "()Z", "tvList", "", "Landroid/widget/TextView;", "separatorList", "Landroid/view/View;", "maxGearPosition", "", "inTouch", "lastProgress", "update", "forceOffline", "moodLampEnum", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceMoodLampHolder.kt */
public final class DeviceMoodLampHolder extends DeviceControlHolder<HolderDeviceMoodLampBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Device device;
    /* access modifiers changed from: private */
    public boolean inTouch;
    private final boolean isInSchedule;
    private int lastProgress;
    private final int maxGearPosition = 3;
    /* access modifiers changed from: private */
    public final Function1<MoodLampEnum, Unit> onLampGearSelectedListener;
    private final List<View> separatorList;
    private final List<TextView> tvList;

    public final Device getDevice() {
        return this.device;
    }

    public final void setDevice(Device device2) {
        this.device = device2;
    }

    public final boolean isInSchedule() {
        return this.isInSchedule;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¨\u0006\u0013"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceMoodLampHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceMoodLampHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onGearSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/MoodLampEnum;", "Lkotlin/ParameterName;", "name", "gear", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceMoodLampHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceMoodLampHolder newInstance(ViewGroup viewGroup, Device device, boolean z, Function1<? super MoodLampEnum, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onGearSelectedListener");
            HolderDeviceMoodLampBinding inflate = HolderDeviceMoodLampBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceMoodLampHolder(inflate, device, z, function1);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceMoodLampHolder(HolderDeviceMoodLampBinding holderDeviceMoodLampBinding, Device device2, boolean z, Function1<? super MoodLampEnum, Unit> function1) {
        super(holderDeviceMoodLampBinding);
        Intrinsics.checkNotNullParameter(holderDeviceMoodLampBinding, "binding");
        Intrinsics.checkNotNullParameter(function1, "onLampGearSelectedListener");
        this.device = device2;
        this.isInSchedule = z;
        this.onLampGearSelectedListener = function1;
        TextView textView = holderDeviceMoodLampBinding.tvProgress0;
        Intrinsics.checkNotNullExpressionValue(textView, "tvProgress0");
        TextView textView2 = holderDeviceMoodLampBinding.tvProgress1;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvProgress1");
        TextView textView3 = holderDeviceMoodLampBinding.tvProgress2;
        Intrinsics.checkNotNullExpressionValue(textView3, "tvProgress2");
        TextView textView4 = holderDeviceMoodLampBinding.tvProgress3;
        Intrinsics.checkNotNullExpressionValue(textView4, "tvProgress3");
        this.tvList = CollectionsKt.listOf(textView, textView2, textView3, textView4);
        View view = holderDeviceMoodLampBinding.separator0;
        Intrinsics.checkNotNullExpressionValue(view, "separator0");
        View view2 = holderDeviceMoodLampBinding.separator1;
        Intrinsics.checkNotNullExpressionValue(view2, "separator1");
        View view3 = holderDeviceMoodLampBinding.separator2;
        Intrinsics.checkNotNullExpressionValue(view3, "separator2");
        View view4 = holderDeviceMoodLampBinding.separator3;
        Intrinsics.checkNotNullExpressionValue(view4, "separator3");
        this.separatorList = CollectionsKt.listOf(view, view2, view3, view4);
        holderDeviceMoodLampBinding.clickView.setOnClickListener(new DeviceMoodLampHolder$$ExternalSyntheticLambda0(holderDeviceMoodLampBinding));
        holderDeviceMoodLampBinding.expendSwitch.setOnCheckedChangeListener(new DeviceMoodLampHolder$$ExternalSyntheticLambda1(holderDeviceMoodLampBinding, this));
        holderDeviceMoodLampBinding.seekbar.setOnSeekBarChangeListener(new DeviceMoodLampHolder$1$3(this));
        holderDeviceMoodLampBinding.expendSwitch.setChecked(false);
    }

    static final void lambda$3$lambda$0(HolderDeviceMoodLampBinding holderDeviceMoodLampBinding, View view) {
        holderDeviceMoodLampBinding.expendSwitch.setChecked(!holderDeviceMoodLampBinding.expendSwitch.isChecked());
    }

    static final void lambda$3$lambda$2(HolderDeviceMoodLampBinding holderDeviceMoodLampBinding, DeviceMoodLampHolder deviceMoodLampHolder, CompoundButton compoundButton, boolean z) {
        Device device2;
        Group group = holderDeviceMoodLampBinding.expendedContent;
        Intrinsics.checkNotNullExpressionValue(group, "expendedContent");
        ViewExtensionsKt.show(group, !z);
        if (!deviceMoodLampHolder.isInSchedule && !z && (device2 = deviceMoodLampHolder.device) != null) {
            deviceMoodLampHolder.update(device2, false);
        }
    }

    public void update(Device device2, boolean z) {
        Intrinsics.checkNotNullParameter(device2, "device");
        if (!this.inTouch) {
            this.device = device2;
            if (device2 instanceof HasMoodLamp) {
                update(MoodLampEnum.Companion.fromServerValue((HasMoodLamp) device2));
            }
            if (z || !device2.isOnline()) {
                HolderDeviceMoodLampBinding holderDeviceMoodLampBinding = (HolderDeviceMoodLampBinding) getBinding();
                holderDeviceMoodLampBinding.clickView.setEnabled(false);
                holderDeviceMoodLampBinding.expendSwitch.setEnabled(false);
                holderDeviceMoodLampBinding.expendSwitch.setChecked(true);
                Group group = holderDeviceMoodLampBinding.expendedContent;
                Intrinsics.checkNotNullExpressionValue(group, "expendedContent");
                ViewExtensionsKt.show(group, false);
                holderDeviceMoodLampBinding.expendSwitch.setChecked(true);
                SwitchCompat switchCompat = holderDeviceMoodLampBinding.expendSwitch;
                Intrinsics.checkNotNullExpressionValue(switchCompat, "expendSwitch");
                ViewExtensionsKt.show(switchCompat, true);
                holderDeviceMoodLampBinding.contentContainer.setEnabled(false);
                holderDeviceMoodLampBinding.expendSwitch.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.fill_grey)));
                holderDeviceMoodLampBinding.leadingIcon.setImageTintList(ColorStateList.valueOf(getColor(R.color.surface_dark_45)));
                holderDeviceMoodLampBinding.title.setTextColor(getColor(R.color.surface_dark_55));
                holderDeviceMoodLampBinding.progressText.setText("");
                return;
            }
            HolderDeviceMoodLampBinding holderDeviceMoodLampBinding2 = (HolderDeviceMoodLampBinding) getBinding();
            holderDeviceMoodLampBinding2.clickView.setEnabled(true);
            holderDeviceMoodLampBinding2.expendSwitch.setEnabled(true);
            holderDeviceMoodLampBinding2.contentContainer.setEnabled(true);
            holderDeviceMoodLampBinding2.leadingIcon.setImageTintList((ColorStateList) null);
            holderDeviceMoodLampBinding2.title.setTextColor(getColor(R.color.colorPrimaryText));
            holderDeviceMoodLampBinding2.expendSwitch.setBackgroundTintList((ColorStateList) null);
            SwitchCompat switchCompat2 = holderDeviceMoodLampBinding2.expendSwitch;
            Intrinsics.checkNotNullExpressionValue(switchCompat2, "expendSwitch");
            ViewExtensionsKt.show(switchCompat2, true);
        }
    }

    public final void update(MoodLampEnum moodLampEnum) {
        Intrinsics.checkNotNullParameter(moodLampEnum, "moodLampEnum");
        ((HolderDeviceMoodLampBinding) getBinding()).seekbar.setProgress(moodLampEnum.toStep());
        this.lastProgress = ((HolderDeviceMoodLampBinding) getBinding()).seekbar.getProgress();
        ((HolderDeviceMoodLampBinding) getBinding()).progressText.setText(NightLampUtils.INSTANCE.getTitleRes(moodLampEnum));
        int color = getColor(R.color.colorPrimary);
        int color2 = getColor(R.color.surface_dark_55);
        int color3 = getColor(R.color.surface_dark_45);
        int i = this.maxGearPosition;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                if (i2 <= this.lastProgress) {
                    this.tvList.get(i2).setTextColor(color);
                    this.separatorList.get(i2).setBackground(new ColorDrawable(color));
                } else {
                    this.tvList.get(i2).setTextColor(color2);
                    this.separatorList.get(i2).setBackground(new ColorDrawable(color3));
                }
                if (i2 != i) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }
}
