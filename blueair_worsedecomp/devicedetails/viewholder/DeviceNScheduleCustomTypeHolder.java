package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.core.model.BlueDeviceScheduleEndType;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.HolderDeviceHScheduleCustomTypeBinding;
import com.blueair.devicedetails.databinding.HolderDeviceNScheduleCustomTypeBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR7\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNScheduleCustomTypeHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/viewbinding/ViewBinding;", "device", "Lcom/blueair/core/model/Device;", "<init>", "(Landroidx/viewbinding/ViewBinding;Lcom/blueair/core/model/Device;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "onTypeSelectedListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "type", "", "getOnTypeSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnTypeSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "radioGroupCustomScheduleSettings", "Landroid/widget/RadioGroup;", "textviewCustomScheduleDescription", "Landroid/widget/TextView;", "update", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNScheduleCustomTypeHolder.kt */
public final class DeviceNScheduleCustomTypeHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ViewBinding binding;
    private final Device device;
    private Function1<? super String, Unit> onTypeSelectedListener;
    private final RadioGroup radioGroupCustomScheduleSettings;
    private final TextView textviewCustomScheduleDescription;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNScheduleCustomTypeHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNScheduleCustomTypeHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNScheduleCustomTypeHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNScheduleCustomTypeHolder newInstance(ViewGroup viewGroup, Device device) {
            ViewBinding viewBinding;
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            if (device == null || !DeviceKt.isAfterG4(device) || (device instanceof DeviceNewClassic)) {
                HolderDeviceNScheduleCustomTypeBinding inflate = HolderDeviceNScheduleCustomTypeBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                viewBinding = inflate;
            } else {
                HolderDeviceHScheduleCustomTypeBinding inflate2 = HolderDeviceHScheduleCustomTypeBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
                viewBinding = inflate2;
            }
            return new DeviceNScheduleCustomTypeHolder(viewBinding, device);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceNScheduleCustomTypeHolder(ViewBinding viewBinding, Device device2) {
        super(viewBinding.getRoot());
        Intrinsics.checkNotNullParameter(viewBinding, "binding");
        this.binding = viewBinding;
        this.device = device2;
        if (viewBinding instanceof HolderDeviceHScheduleCustomTypeBinding) {
            RadioGroup radioGroup = ((HolderDeviceHScheduleCustomTypeBinding) viewBinding).radioGroupCustomScheduleSettings;
            Intrinsics.checkNotNullExpressionValue(radioGroup, "radioGroupCustomScheduleSettings");
            this.radioGroupCustomScheduleSettings = radioGroup;
            TextView textView = ((HolderDeviceHScheduleCustomTypeBinding) viewBinding).textviewCustomScheduleDescription;
            Intrinsics.checkNotNullExpressionValue(textView, "textviewCustomScheduleDescription");
            this.textviewCustomScheduleDescription = textView;
        } else {
            Intrinsics.checkNotNull(viewBinding, "null cannot be cast to non-null type com.blueair.devicedetails.databinding.HolderDeviceNScheduleCustomTypeBinding");
            HolderDeviceNScheduleCustomTypeBinding holderDeviceNScheduleCustomTypeBinding = (HolderDeviceNScheduleCustomTypeBinding) viewBinding;
            RadioGroup radioGroup2 = ((HolderDeviceNScheduleCustomTypeBinding) viewBinding).radioGroupCustomScheduleSettings;
            Intrinsics.checkNotNullExpressionValue(radioGroup2, "radioGroupCustomScheduleSettings");
            this.radioGroupCustomScheduleSettings = radioGroup2;
            TextView textView2 = ((HolderDeviceNScheduleCustomTypeBinding) viewBinding).textviewCustomScheduleDescription;
            Intrinsics.checkNotNullExpressionValue(textView2, "textviewCustomScheduleDescription");
            this.textviewCustomScheduleDescription = textView2;
        }
        this.radioGroupCustomScheduleSettings.setOnCheckedChangeListener(new DeviceNScheduleCustomTypeHolder$$ExternalSyntheticLambda0(this));
    }

    public final ViewBinding getBinding() {
        return this.binding;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final Function1<String, Unit> getOnTypeSelectedListener() {
        return this.onTypeSelectedListener;
    }

    public final void setOnTypeSelectedListener(Function1<? super String, Unit> function1) {
        this.onTypeSelectedListener = function1;
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceNScheduleCustomTypeHolder deviceNScheduleCustomTypeHolder, RadioGroup radioGroup, int i) {
        int i2 = R.id.radio_button_previous;
        String str = BlueDeviceScheduleEndType.PREVIOUS;
        if (i != i2 && i == R.id.radio_button_custom) {
            str = "custom";
        }
        Function1<? super String, Unit> function1 = deviceNScheduleCustomTypeHolder.onTypeSelectedListener;
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    public final void update(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        int i = Intrinsics.areEqual((Object) str, (Object) "custom") ? R.id.radio_button_custom : R.id.radio_button_previous;
        int i2 = Intrinsics.areEqual((Object) str, (Object) BlueDeviceScheduleEndType.PREVIOUS) ? com.blueair.viewcore.R.string.schedule_previous_description : com.blueair.viewcore.R.string.schedule_custom_description;
        this.radioGroupCustomScheduleSettings.check(i);
        this.textviewCustomScheduleDescription.setText(i2);
    }
}
