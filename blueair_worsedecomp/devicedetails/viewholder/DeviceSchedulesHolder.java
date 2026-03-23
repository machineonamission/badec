package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.devicedetails.databinding.HolderDeviceSchedulesBinding;
import com.blueair.viewcore.R;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSchedulesHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceSchedulesBinding;", "binding", "onChildLockClickedListener", "Lkotlin/Function0;", "", "onOpenSchedulesListener", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceSchedulesBinding;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "schedules", "", "Lcom/blueair/core/model/DeviceScheduleMerged;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSchedulesHolder.kt */
public final class DeviceSchedulesHolder extends DeviceControlHolder<HolderDeviceSchedulesBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Function0<Unit> onChildLockClickedListener;
    private final Function0<Unit> onOpenSchedulesListener;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSchedulesHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceSchedulesHolder;", "parentView", "Landroid/view/ViewGroup;", "onChildLockClickedListener", "Lkotlin/Function0;", "", "onOpenSchedulesListener", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSchedulesHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceSchedulesHolder newInstance(ViewGroup viewGroup, Function0<Unit> function0, Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onChildLockClickedListener");
            Intrinsics.checkNotNullParameter(function02, "onOpenSchedulesListener");
            HolderDeviceSchedulesBinding inflate = HolderDeviceSchedulesBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceSchedulesHolder(inflate, function0, function02);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceSchedulesHolder(HolderDeviceSchedulesBinding holderDeviceSchedulesBinding, Function0<Unit> function0, Function0<Unit> function02) {
        super(holderDeviceSchedulesBinding);
        Intrinsics.checkNotNullParameter(holderDeviceSchedulesBinding, "binding");
        Intrinsics.checkNotNullParameter(function0, "onChildLockClickedListener");
        Intrinsics.checkNotNullParameter(function02, "onOpenSchedulesListener");
        this.onChildLockClickedListener = function0;
        this.onOpenSchedulesListener = function02;
        holderDeviceSchedulesBinding.childLockContainer.setOnClickListener(new DeviceSchedulesHolder$$ExternalSyntheticLambda0(this));
        holderDeviceSchedulesBinding.schedulesContainer.setOnClickListener(new DeviceSchedulesHolder$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceSchedulesHolder deviceSchedulesHolder, View view) {
        deviceSchedulesHolder.onChildLockClickedListener.invoke();
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(DeviceSchedulesHolder deviceSchedulesHolder, View view) {
        deviceSchedulesHolder.onOpenSchedulesListener.invoke();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(com.blueair.core.model.Device r4, boolean r5) {
        /*
            r3 = this;
            java.lang.String r0 = "device"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r4 instanceof com.blueair.core.model.HasChildLock
            r1 = 0
            if (r0 == 0) goto L_0x000e
            r0 = r4
            com.blueair.core.model.HasChildLock r0 = (com.blueair.core.model.HasChildLock) r0
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            if (r0 == 0) goto L_0x008a
            androidx.viewbinding.ViewBinding r0 = r3.getBinding()
            com.blueair.devicedetails.databinding.HolderDeviceSchedulesBinding r0 = (com.blueair.devicedetails.databinding.HolderDeviceSchedulesBinding) r0
            if (r5 != 0) goto L_0x0037
            boolean r5 = r4.isOnline()
            if (r5 == 0) goto L_0x0037
            boolean r5 = com.blueair.core.model.DeviceKt.isStandByOn(r4)
            if (r5 != 0) goto L_0x0037
            boolean r5 = r4 instanceof com.blueair.core.model.HasBody
            if (r5 == 0) goto L_0x002c
            r1 = r4
            com.blueair.core.model.HasBody r1 = (com.blueair.core.model.HasBody) r1
        L_0x002c:
            if (r1 == 0) goto L_0x0035
            boolean r5 = r1.getBodyMounted()
            if (r5 != 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r5 = 0
            goto L_0x0038
        L_0x0037:
            r5 = 1
        L_0x0038:
            androidx.constraintlayout.widget.ConstraintLayout r1 = r0.childLockContainer
            r2 = r5 ^ 1
            r1.setEnabled(r2)
            androidx.constraintlayout.widget.ConstraintLayout r1 = r0.childLockContainer
            if (r5 == 0) goto L_0x0046
            int r2 = com.blueair.viewcore.R.drawable.rounded_rectangle_white_r1000_black5_stroke1_disabled_white_bg
            goto L_0x0048
        L_0x0046:
            int r2 = com.blueair.viewcore.R.drawable.rounded_rectangle_white_r1000_black5_stroke1
        L_0x0048:
            r1.setBackgroundResource(r2)
            android.widget.TextView r1 = r0.childLockText
            if (r5 == 0) goto L_0x0052
            int r2 = com.blueair.viewcore.R.color.surface_dark_55
            goto L_0x0054
        L_0x0052:
            int r2 = com.blueair.viewcore.R.color.colorPrimaryText
        L_0x0054:
            int r2 = r3.getColor(r2)
            r1.setTextColor(r2)
            com.blueair.core.model.HasChildLock r4 = (com.blueair.core.model.HasChildLock) r4
            boolean r4 = r4.isChildLockOn()
            if (r4 == 0) goto L_0x0077
            android.widget.ImageView r4 = r0.childLockIcon
            if (r5 == 0) goto L_0x006a
            int r5 = com.blueair.viewcore.R.drawable.ic_child_lock_on_disabled
            goto L_0x006c
        L_0x006a:
            int r5 = com.blueair.viewcore.R.drawable.ic_child_lock_on
        L_0x006c:
            r4.setImageResource(r5)
            android.widget.TextView r4 = r0.childLockValue
            int r5 = com.blueair.viewcore.R.string.on
            r4.setText(r5)
            return
        L_0x0077:
            android.widget.ImageView r4 = r0.childLockIcon
            if (r5 == 0) goto L_0x007e
            int r5 = com.blueair.viewcore.R.drawable.ic_child_lock_off_disabled
            goto L_0x0080
        L_0x007e:
            int r5 = com.blueair.viewcore.R.drawable.ic_child_lock_off
        L_0x0080:
            r4.setImageResource(r5)
            android.widget.TextView r4 = r0.childLockValue
            int r5 = com.blueair.viewcore.R.string.off
            r4.setText(r5)
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceSchedulesHolder.update(com.blueair.core.model.Device, boolean):void");
    }

    public final void update(Device device, boolean z, List<DeviceScheduleMerged> list) {
        int i;
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(list, "schedules");
        update(device, z);
        Iterable<DeviceScheduleMerged> iterable = list;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            i = 0;
            for (DeviceScheduleMerged paused : iterable) {
                if (!paused.getPaused() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        } else {
            i = 0;
        }
        TextView textView = ((HolderDeviceSchedulesBinding) getBinding()).schedulesValue;
        String format = String.format(getString(R.string.schedule_active), Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        ((HolderDeviceSchedulesBinding) getBinding()).schedulesIcon.setImageResource(i > 0 ? R.drawable.ic_schedules_active : R.drawable.ic_schedules_off);
    }
}
