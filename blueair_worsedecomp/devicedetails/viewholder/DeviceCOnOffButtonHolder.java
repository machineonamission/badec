package com.blueair.devicedetails.viewholder;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ViewKt;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.HasWaterLevel;
import com.blueair.core.model.WaterLevel;
import com.blueair.devicedetails.databinding.HolderDeviceCOnOffButtonBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.view.SwitchCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bBE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0015R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceCOnOffButtonHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceCOnOffButtonBinding;", "device", "Lcom/blueair/core/model/Device;", "type", "Lcom/blueair/devicedetails/viewholder/DeviceCOnOffButtonHolder$Type;", "isInSchedule", "", "onSetListener", "Lkotlin/Function2;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceCOnOffButtonBinding;Lcom/blueair/core/model/Device;Lcom/blueair/devicedetails/viewholder/DeviceCOnOffButtonHolder$Type;ZLkotlin/jvm/functions/Function2;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceCOnOffButtonBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "getType", "()Lcom/blueair/devicedetails/viewholder/DeviceCOnOffButtonHolder$Type;", "()Z", "titlePrefix", "", "update", "isOn", "Type", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceCOnOffButtonHolder.kt */
public final class DeviceCOnOffButtonHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceCOnOffButtonBinding binding;
    private final Device device;
    private final boolean isInSchedule;
    private final Function2<Type, Boolean, Unit> onSetListener;
    private final String titlePrefix;
    private final Type type;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceCOnOffButtonHolder.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder$Type[] r0 = com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder$Type r1 = com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder.Type.STANDBY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder$Type r1 = com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder.Type.HUM     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceCOnOffButtonHolder(HolderDeviceCOnOffButtonBinding holderDeviceCOnOffButtonBinding, Device device2, Type type2, boolean z, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(holderDeviceCOnOffButtonBinding, device2, type2, (i & 8) != 0 ? false : z, function2);
    }

    public final HolderDeviceCOnOffButtonBinding getBinding() {
        return this.binding;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final Type getType() {
        return this.type;
    }

    public final boolean isInSchedule() {
        return this.isInSchedule;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceCOnOffButtonHolder(com.blueair.devicedetails.databinding.HolderDeviceCOnOffButtonBinding r3, com.blueair.core.model.Device r4, com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder.Type r5, boolean r6, kotlin.jvm.functions.Function2<? super com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder.Type, ? super java.lang.Boolean, kotlin.Unit> r7) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "onSetListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            android.widget.FrameLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r2.<init>(r0)
            r2.binding = r3
            r2.device = r4
            r2.type = r5
            r2.isInSchedule = r6
            r2.onSetListener = r7
            com.blueair.viewcore.view.SwitchCompat r4 = r3.switchBtn
            com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder$$ExternalSyntheticLambda0 r7 = new com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder$$ExternalSyntheticLambda0
            r7.<init>(r2)
            r4.setOnCheckedChangeListener(r7)
            android.view.View r4 = r2.itemView
            android.content.Context r4 = r4.getContext()
            com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder$Type r7 = com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder.Type.STANDBY
            if (r5 != r7) goto L_0x003e
            int r7 = com.blueair.viewcore.R.string.device_status
            goto L_0x0040
        L_0x003e:
            int r7 = com.blueair.viewcore.R.string.humidification
        L_0x0040:
            java.lang.String r4 = r4.getString(r7)
            java.lang.String r7 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            r2.titlePrefix = r4
            android.widget.TextView r4 = r3.title
            com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder$Type r7 = com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder.Type.STANDBY
            if (r5 != r7) goto L_0x0054
            int r5 = com.blueair.viewcore.R.drawable.ic_standby_switch
            goto L_0x0056
        L_0x0054:
            int r5 = com.blueair.viewcore.R.drawable.ic_humidification_switch
        L_0x0056:
            r7 = 0
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds((android.widget.TextView) r4, (int) r5, (int) r7, (int) r7, (int) r7)
            if (r6 == 0) goto L_0x006d
            androidx.constraintlayout.widget.ConstraintLayout r3 = r3.contentContainer
            android.view.View r4 = r2.itemView
            android.content.Context r4 = r4.getContext()
            int r5 = com.blueair.viewcore.R.drawable.rounded_square_anti_flash_blue_r8
            android.graphics.drawable.Drawable r4 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r4, r5)
            r3.setBackground(r4)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceCOnOffButtonBinding, com.blueair.core.model.Device, com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder$Type, boolean, kotlin.jvm.functions.Function2):void");
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceCOnOffButtonHolder$Type;", "", "<init>", "(Ljava/lang/String;I)V", "STANDBY", "HUM", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceCOnOffButtonHolder.kt */
    public enum Type {
        STANDBY,
        HUM;

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        static {
            Type[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\u000f¨\u0006\u0011"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceCOnOffButtonHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceCOnOffButtonHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "type", "Lcom/blueair/devicedetails/viewholder/DeviceCOnOffButtonHolder$Type;", "isInSchedule", "", "onSetListener", "Lkotlin/Function2;", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceCOnOffButtonHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DeviceCOnOffButtonHolder newInstance$default(Companion companion, ViewGroup viewGroup, Device device, Type type, boolean z, Function2 function2, int i, Object obj) {
            if ((i & 8) != 0) {
                z = false;
            }
            return companion.newInstance(viewGroup, device, type, z, function2);
        }

        public final DeviceCOnOffButtonHolder newInstance(ViewGroup viewGroup, Device device, Type type, boolean z, Function2<? super Type, ? super Boolean, Unit> function2) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(function2, "onSetListener");
            HolderDeviceCOnOffButtonBinding inflate = HolderDeviceCOnOffButtonBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceCOnOffButtonHolder(inflate, device, type, z, function2);
        }
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceCOnOffButtonHolder deviceCOnOffButtonHolder, CompoundButton compoundButton, boolean z) {
        deviceCOnOffButtonHolder.onSetListener.invoke(deviceCOnOffButtonHolder.type, Boolean.valueOf(!z));
    }

    public void update(Device device2) {
        Intrinsics.checkNotNullParameter(device2, "device");
        int i = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        boolean z = true;
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            } else if (device2 instanceof HasHumMode) {
                HasHumMode hasHumMode = (HasHumMode) device2;
                update(hasHumMode.getHumMode());
                SwitchCompat switchCompat = this.binding.switchBtn;
                if (!(device2 instanceof HasStandBy) || ((HasStandBy) device2).isStandByOn()) {
                    z = false;
                }
                switchCompat.setEnabled(z);
                if (!(device2 instanceof HasWaterLevel) || !((HasWaterLevel) device2).isInWaterLevel(WaterLevel.SHORTAGE) || hasHumMode.getHumMode()) {
                    TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(this.binding.title, R.drawable.ic_humidification_switch, 0, 0, 0);
                    this.binding.title.setOnClickListener((View.OnClickListener) null);
                    return;
                }
                this.binding.switchBtn.setEnabled(false);
                TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(this.binding.title, R.drawable.ic_humidification_switch, 0, R.drawable.ic_info_h_16, 0);
                this.binding.title.post(new DeviceCOnOffButtonHolder$$ExternalSyntheticLambda1(this));
                this.binding.title.setOnClickListener(new DeviceCOnOffButtonHolder$$ExternalSyntheticLambda2(this));
            }
        } else if (device2 instanceof HasStandBy) {
            update(!((HasStandBy) device2).isStandByOn());
        }
    }

    /* access modifiers changed from: private */
    public static final void update$lambda$1(DeviceCOnOffButtonHolder deviceCOnOffButtonHolder) {
        Drawable drawable = deviceCOnOffButtonHolder.binding.title.getCompoundDrawables()[2];
        if (drawable != null) {
            drawable.setTint(deviceCOnOffButtonHolder.itemView.getContext().getColor(R.color.peach));
        }
    }

    /* access modifiers changed from: private */
    public static final void update$lambda$3(DeviceCOnOffButtonHolder deviceCOnOffButtonHolder, View view) {
        View view2 = deviceCOnOffButtonHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "itemView");
        FragmentManager childFragmentManager = ViewKt.findFragment(view2).getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.warning_title_water_shortage, (Integer) null, R.string.warning_msg_water_shortage, Integer.valueOf(R.string.snackbar_ok), (Integer) null, false, false, false, true, (String[]) null, (String) null, (Function1) null, 3808, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
        }
    }

    public final void update(boolean z) {
        this.binding.switchBtn.setCheckedSilence(z);
        String string = this.itemView.getContext().getString(z ? R.string.on_camel_case : R.string.off_camel_case);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        TextView textView = this.binding.title;
        textView.setText(this.titlePrefix + string);
        this.binding.switchBtn.setContentDescription(this.titlePrefix);
    }
}
