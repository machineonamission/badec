package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.databinding.HolderDeviceC3FanSpeedBinding;
import com.blueair.devicedetails.util.EtaUtils;
import com.blueair.devicedetails.util.FanSpeedUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0001*BD\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0007H\u0002J\u0018\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bH\u0002J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010&\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010(J\u000e\u0010&\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nJ\b\u0010)\u001a\u00020\u000eH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceC3FanSpeedHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceC3FanSpeedBinding;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onFanSpeedSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "Lkotlin/ParameterName;", "name", "fanSpeedEnum", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceC3FanSpeedBinding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceC3FanSpeedBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "()Z", "tvs", "Ljava/util/ArrayList;", "Landroid/widget/TextView;", "Lkotlin/collections/ArrayList;", "seekBarEnabledMarginTop", "", "Ljava/lang/Integer;", "seekBarEnabledPadding", "Landroid/graphics/Rect;", "postFanSpeed", "setSeekbarEnabled", "enabled", "updateProgressLabels", "context", "Landroid/content/Context;", "progress", "update", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "updateUpDownButtonState", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceC3FanSpeedHolder.kt */
public final class DeviceC3FanSpeedHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceC3FanSpeedBinding binding;
    private final Device device;
    private final boolean isInSchedule;
    private final Function1<FanSpeedEnum, Unit> onFanSpeedSetListener;
    private Integer seekBarEnabledMarginTop;
    private Rect seekBarEnabledPadding;
    private ArrayList<TextView> tvs;

    public final HolderDeviceC3FanSpeedBinding getBinding() {
        return this.binding;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final boolean isInSchedule() {
        return this.isInSchedule;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¨\u0006\u0013"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceC3FanSpeedHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceC3FanSpeedHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onFanSpeedSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "Lkotlin/ParameterName;", "name", "fanSpeedEnum", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceC3FanSpeedHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DeviceC3FanSpeedHolder newInstance$default(Companion companion, ViewGroup viewGroup, Device device, boolean z, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.newInstance(viewGroup, device, z, function1);
        }

        public final DeviceC3FanSpeedHolder newInstance(ViewGroup viewGroup, Device device, boolean z, Function1<? super FanSpeedEnum, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onFanSpeedSetListener");
            HolderDeviceC3FanSpeedBinding inflate = HolderDeviceC3FanSpeedBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            DeviceC3FanSpeedHolder deviceC3FanSpeedHolder = new DeviceC3FanSpeedHolder(inflate, device, z, function1);
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            deviceC3FanSpeedHolder.updateProgressLabels(context, inflate.seekbar.getProgress());
            return deviceC3FanSpeedHolder;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceC3FanSpeedHolder(com.blueair.devicedetails.databinding.HolderDeviceC3FanSpeedBinding r6, com.blueair.core.model.Device r7, boolean r8, kotlin.jvm.functions.Function1<? super com.blueair.core.model.FanSpeedEnum, kotlin.Unit> r9) {
        /*
            r5 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "onFanSpeedSetListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            android.widget.FrameLayout r0 = r6.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r5.<init>(r0)
            r5.binding = r6
            r5.device = r7
            r5.isInSchedule = r8
            r5.onFanSpeedSetListener = r9
            android.widget.TextView r7 = r6.fanSpeedLevel0
            java.lang.String r9 = "fanSpeedLevel0"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
            android.widget.TextView r9 = r6.fanSpeedLevel1
            java.lang.String r0 = "fanSpeedLevel1"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            android.widget.TextView r0 = r6.fanSpeedLevel2
            java.lang.String r1 = "fanSpeedLevel2"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.widget.TextView r1 = r6.fanSpeedLevel3
            java.lang.String r2 = "fanSpeedLevel3"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.widget.TextView r2 = r6.fanSpeedLevel4
            java.lang.String r3 = "fanSpeedLevel4"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r3 = 5
            android.widget.TextView[] r3 = new android.widget.TextView[r3]
            r4 = 0
            r3[r4] = r7
            r7 = 1
            r3[r7] = r9
            r7 = 2
            r3[r7] = r0
            r7 = 3
            r3[r7] = r1
            r7 = 4
            r3[r7] = r2
            java.util.ArrayList r7 = kotlin.collections.CollectionsKt.arrayListOf(r3)
            r5.tvs = r7
            com.blueair.viewcore.view.AccessibleSeekBar r7 = r6.seekbar
            com.blueair.devicedetails.viewholder.DeviceC3FanSpeedHolder$1 r9 = new com.blueair.devicedetails.viewholder.DeviceC3FanSpeedHolder$1
            r9.<init>(r5)
            android.widget.SeekBar$OnSeekBarChangeListener r9 = (android.widget.SeekBar.OnSeekBarChangeListener) r9
            r7.setOnSeekBarChangeListener(r9)
            androidx.appcompat.widget.AppCompatImageView r7 = r6.upIcon
            com.blueair.devicedetails.viewholder.DeviceC3FanSpeedHolder$$ExternalSyntheticLambda0 r9 = new com.blueair.devicedetails.viewholder.DeviceC3FanSpeedHolder$$ExternalSyntheticLambda0
            r9.<init>(r5)
            r7.setOnClickListener(r9)
            androidx.appcompat.widget.AppCompatImageView r7 = r6.downIcon
            com.blueair.devicedetails.viewholder.DeviceC3FanSpeedHolder$$ExternalSyntheticLambda1 r9 = new com.blueair.devicedetails.viewholder.DeviceC3FanSpeedHolder$$ExternalSyntheticLambda1
            r9.<init>(r5)
            r7.setOnClickListener(r9)
            if (r8 == 0) goto L_0x00b6
            androidx.constraintlayout.widget.ConstraintLayout r7 = r6.contentContainer
            android.view.View r8 = r5.itemView
            android.content.Context r8 = r8.getContext()
            int r9 = com.blueair.viewcore.R.drawable.rounded_square_anti_flash_blue_r8
            android.graphics.drawable.Drawable r8 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r8, r9)
            r7.setBackground(r8)
            android.view.View r7 = r5.itemView
            android.content.Context r7 = r7.getContext()
            android.content.res.Resources r7 = r7.getResources()
            int r8 = com.blueair.viewcore.R.dimen.device_details_humidifier_margin_horizontal
            int r7 = r7.getDimensionPixelSize(r8)
            androidx.constraintlayout.widget.ConstraintLayout r8 = r6.contentContainer
            java.lang.String r9 = "contentContainer"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            android.view.View r8 = (android.view.View) r8
            r8.setPadding(r7, r7, r7, r7)
            android.widget.TextView r6 = r6.cleanAirEta
            java.lang.String r7 = "cleanAirEta"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            android.view.View r6 = (android.view.View) r6
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r6)
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceC3FanSpeedHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceC3FanSpeedBinding, com.blueair.core.model.Device, boolean, kotlin.jvm.functions.Function1):void");
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$2(DeviceC3FanSpeedHolder deviceC3FanSpeedHolder, View view) {
        AccessibleSeekBar accessibleSeekBar = deviceC3FanSpeedHolder.binding.seekbar;
        int progress = accessibleSeekBar.getProgress();
        Iterator<Integer> it = FanSpeedUtils.INSTANCE.getBLUE_PREMIUM_FAN_PROGRESS_SNAP().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().intValue() > progress) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            accessibleSeekBar.setProgress(FanSpeedUtils.INSTANCE.getBLUE_PREMIUM_FAN_PROGRESS_SNAP().get(i).intValue());
        }
        deviceC3FanSpeedHolder.postFanSpeed();
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$5(DeviceC3FanSpeedHolder deviceC3FanSpeedHolder, View view) {
        int i;
        AccessibleSeekBar accessibleSeekBar = deviceC3FanSpeedHolder.binding.seekbar;
        int progress = accessibleSeekBar.getProgress();
        List<Integer> blue_premium_fan_progress_snap = FanSpeedUtils.INSTANCE.getBLUE_PREMIUM_FAN_PROGRESS_SNAP();
        ListIterator<Integer> listIterator = blue_premium_fan_progress_snap.listIterator(blue_premium_fan_progress_snap.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (listIterator.previous().intValue() < progress) {
                    i = listIterator.nextIndex();
                    break;
                }
            } else {
                i = -1;
                break;
            }
        }
        if (i >= 0) {
            accessibleSeekBar.setProgress(FanSpeedUtils.INSTANCE.getBLUE_PREMIUM_FAN_PROGRESS_SNAP().get(i).intValue());
        }
        deviceC3FanSpeedHolder.postFanSpeed();
    }

    /* access modifiers changed from: private */
    public final void postFanSpeed() {
        updateUpDownButtonState();
        FanSpeedEnum fanSpeedEnumFromProgressBluePremium = FanSpeedEnum.Companion.fanSpeedEnumFromProgressBluePremium(FanSpeedUtils.INSTANCE.getBluePremiumFromSeekBarProgress(this.binding.seekbar.getProgress()));
        update(fanSpeedEnumFromProgressBluePremium);
        this.onFanSpeedSetListener.invoke(fanSpeedEnumFromProgressBluePremium);
    }

    private final void setSeekbarEnabled(boolean z) {
        int i;
        AppCompatImageView appCompatImageView = this.binding.downIcon;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "downIcon");
        ViewExtensionsKt.show(appCompatImageView, z);
        AppCompatImageView appCompatImageView2 = this.binding.upIcon;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "upIcon");
        ViewExtensionsKt.show(appCompatImageView2, z);
        AccessibleSeekBar accessibleSeekBar = this.binding.seekbar;
        accessibleSeekBar.setEnabled(z);
        accessibleSeekBar.setThumb(z ? AppCompatResources.getDrawable(accessibleSeekBar.getContext(), R.drawable.thumb_shadowed) : null);
        accessibleSeekBar.setProgressDrawable(AppCompatResources.getDrawable(accessibleSeekBar.getContext(), z ? R.drawable.progressbar_slim : R.drawable.progressbar_slim_gray));
        ViewGroup.LayoutParams layoutParams = accessibleSeekBar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        if (this.seekBarEnabledMarginTop == null) {
            this.seekBarEnabledMarginTop = Integer.valueOf(layoutParams2.topMargin);
            this.seekBarEnabledPadding = new Rect(accessibleSeekBar.getPaddingLeft(), accessibleSeekBar.getPaddingTop(), accessibleSeekBar.getPaddingRight(), accessibleSeekBar.getPaddingBottom());
        }
        if (z) {
            Integer num = this.seekBarEnabledMarginTop;
            i = num != null ? num.intValue() : -15;
        } else {
            i = 30;
        }
        layoutParams2.topMargin = i;
        if (z) {
            Rect rect = this.seekBarEnabledPadding;
            if (rect != null) {
                accessibleSeekBar.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                return;
            }
            return;
        }
        Intrinsics.checkNotNull(accessibleSeekBar);
        accessibleSeekBar.setPadding(0, 0, 0, 0);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateProgressLabels(android.content.Context r5, int r6) {
        /*
            r4 = this;
            r0 = 25
            r1 = 0
            if (r6 < 0) goto L_0x0009
            if (r6 >= r0) goto L_0x0009
        L_0x0007:
            r6 = r1
            goto L_0x0024
        L_0x0009:
            r2 = 50
            if (r0 > r6) goto L_0x0011
            if (r6 >= r2) goto L_0x0011
            r6 = 1
            goto L_0x0024
        L_0x0011:
            r0 = 75
            if (r2 > r6) goto L_0x0019
            if (r6 >= r0) goto L_0x0019
            r6 = 2
            goto L_0x0024
        L_0x0019:
            r2 = 100
            if (r0 > r6) goto L_0x0021
            if (r6 >= r2) goto L_0x0021
            r6 = 3
            goto L_0x0024
        L_0x0021:
            if (r6 != r2) goto L_0x0007
            r6 = 4
        L_0x0024:
            java.util.ArrayList<android.widget.TextView> r0 = r4.tvs
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x002c:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004f
            java.lang.Object r2 = r0.next()
            int r3 = r1 + 1
            if (r1 >= 0) goto L_0x003d
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x003d:
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r1 > r6) goto L_0x0044
            int r1 = com.blueair.viewcore.R.color.colorPrimaryText
            goto L_0x0046
        L_0x0044:
            int r1 = com.blueair.viewcore.R.color.light_gray
        L_0x0046:
            int r1 = r5.getColor(r1)
            r2.setTextColor(r1)
            r1 = r3
            goto L_0x002c
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceC3FanSpeedHolder.updateProgressLabels(android.content.Context, int):void");
    }

    public void update(Device device2) {
        Intrinsics.checkNotNullParameter(device2, "device");
        if (device2 instanceof HasCombo3in1MainMode) {
            HasCombo3in1MainMode hasCombo3in1MainMode = (HasCombo3in1MainMode) device2;
            update(hasCombo3in1MainMode.currentFanSpeedEnum());
            setSeekbarEnabled(!hasCombo3in1MainMode.isInMainMode(MainMode.HEAT) || !device2.isUsDevice());
        } else if (device2 instanceof HasFanSpeed) {
            update(((HasFanSpeed) device2).getFanSpeedEnum());
        }
    }

    public final void update(Device device2, IndoorDatapoint indoorDatapoint) {
        IndoorDatapoint indoorDatapoint2;
        Intrinsics.checkNotNullParameter(device2, "device");
        if (device2 instanceof HasFanSpeed) {
            Float f = null;
            if (indoorDatapoint == null) {
                HasSensorData hasSensorData = device2 instanceof HasSensorData ? (HasSensorData) device2 : null;
                indoorDatapoint2 = hasSensorData != null ? hasSensorData.getLatestSensorDatapoint() : null;
            } else {
                indoorDatapoint2 = indoorDatapoint;
            }
            if ((indoorDatapoint2 != null ? indoorDatapoint2.getPm25() : null) == null || this.isInSchedule || ((device2 instanceof HasWick) && ((HasWick) device2).getWickdryOn())) {
                TextView textView = this.binding.cleanAirEta;
                Intrinsics.checkNotNullExpressionValue(textView, "cleanAirEta");
                ViewExtensionsKt.show(textView, false);
                return;
            }
            TextView textView2 = this.binding.cleanAirEta;
            EtaUtils etaUtils = EtaUtils.INSTANCE;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            int fanSpeedValue = DeviceKt.fanSpeedValue(device2);
            if (indoorDatapoint != null) {
                f = indoorDatapoint.getPm25();
            }
            textView2.setText(etaUtils.etaString(context, fanSpeedValue, f));
        }
    }

    public final void update(FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "fanSpeedEnum");
        this.binding.seekbar.setProgress(FanSpeedUtils.INSTANCE.getProgressFromFanSpeedBluePremium(fanSpeedEnum));
        updateUpDownButtonState();
    }

    private final void updateUpDownButtonState() {
        int progress = this.binding.seekbar.getProgress();
        boolean z = true;
        this.binding.upIcon.setEnabled(progress < 100);
        AppCompatImageView appCompatImageView = this.binding.downIcon;
        if (progress <= 0) {
            z = false;
        }
        appCompatImageView.setEnabled(z);
    }
}
