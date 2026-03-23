package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.BlueDeviceScheduleEndType;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.HolderDeviceScheduleCustomTypeV2Binding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R,\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleCustomTypeV2Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceScheduleCustomTypeV2Binding;", "onCloseHintListener", "Lkotlin/Function0;", "", "onTypeSelectedListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "type", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceScheduleCustomTypeV2Binding;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceScheduleCustomTypeV2Binding;", "getOnCloseHintListener", "()Lkotlin/jvm/functions/Function0;", "getOnTypeSelectedListener", "()Lkotlin/jvm/functions/Function1;", "update", "hintClosedBefore", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceScheduleCustomTypeV2Holder.kt */
public final class DeviceScheduleCustomTypeV2Holder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceScheduleCustomTypeV2Binding binding;
    private final Function0<Unit> onCloseHintListener;
    private final Function1<String, Unit> onTypeSelectedListener;

    public final HolderDeviceScheduleCustomTypeV2Binding getBinding() {
        return this.binding;
    }

    public final Function0<Unit> getOnCloseHintListener() {
        return this.onCloseHintListener;
    }

    public final Function1<String, Unit> getOnTypeSelectedListener() {
        return this.onTypeSelectedListener;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n0\f¨\u0006\u0011"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleCustomTypeV2Holder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceScheduleCustomTypeV2Holder;", "parentView", "Landroid/view/ViewGroup;", "onCloseHintListener", "Lkotlin/Function0;", "", "onTypeSelectedListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "type", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceScheduleCustomTypeV2Holder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceScheduleCustomTypeV2Holder newInstance(ViewGroup viewGroup, Function0<Unit> function0, Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onCloseHintListener");
            Intrinsics.checkNotNullParameter(function1, "onTypeSelectedListener");
            HolderDeviceScheduleCustomTypeV2Binding inflate = HolderDeviceScheduleCustomTypeV2Binding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceScheduleCustomTypeV2Holder(inflate, function0, function1);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceScheduleCustomTypeV2Holder(HolderDeviceScheduleCustomTypeV2Binding holderDeviceScheduleCustomTypeV2Binding, Function0<Unit> function0, Function1<? super String, Unit> function1) {
        super(holderDeviceScheduleCustomTypeV2Binding.getRoot());
        Intrinsics.checkNotNullParameter(holderDeviceScheduleCustomTypeV2Binding, "binding");
        Intrinsics.checkNotNullParameter(function0, "onCloseHintListener");
        Intrinsics.checkNotNullParameter(function1, "onTypeSelectedListener");
        this.binding = holderDeviceScheduleCustomTypeV2Binding;
        this.onCloseHintListener = function0;
        this.onTypeSelectedListener = function1;
        holderDeviceScheduleCustomTypeV2Binding.radioGroupCustomScheduleSettings.setOnCheckedChangeListener(new DeviceScheduleCustomTypeV2Holder$$ExternalSyntheticLambda0(this));
        holderDeviceScheduleCustomTypeV2Binding.btnClose.setOnClickListener(new DeviceScheduleCustomTypeV2Holder$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceScheduleCustomTypeV2Holder deviceScheduleCustomTypeV2Holder, RadioGroup radioGroup, int i) {
        int i2 = R.id.radio_button_previous;
        String str = BlueDeviceScheduleEndType.PREVIOUS;
        if (i != i2 && i == R.id.radio_button_custom) {
            str = "custom";
        }
        deviceScheduleCustomTypeV2Holder.onTypeSelectedListener.invoke(str);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(DeviceScheduleCustomTypeV2Holder deviceScheduleCustomTypeV2Holder, View view) {
        deviceScheduleCustomTypeV2Holder.onCloseHintListener.invoke();
    }

    public final void update(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "type");
        int i = Intrinsics.areEqual((Object) str, (Object) "custom") ? R.id.radio_button_custom : R.id.radio_button_previous;
        int i2 = Intrinsics.areEqual((Object) str, (Object) BlueDeviceScheduleEndType.PREVIOUS) ? com.blueair.viewcore.R.string.schedule_last_used_description : com.blueair.viewcore.R.string.schedule_custom_description_v2;
        this.binding.radioGroupCustomScheduleSettings.check(i);
        this.binding.textviewCustomScheduleDescription.setText(i2);
        LinearLayout linearLayout = this.binding.descriptionContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "descriptionContainer");
        ViewExtensionsKt.show(linearLayout, !z);
    }
}
