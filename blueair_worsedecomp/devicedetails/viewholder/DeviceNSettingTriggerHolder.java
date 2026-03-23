package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.FilterTrigger;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.HolderDeviceNSettingsTriggerBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R7\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNSettingTriggerHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceNSettingsTriggerBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNSettingsTriggerBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceNSettingsTriggerBinding;", "onTriggerSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FilterTrigger;", "Lkotlin/ParameterName;", "name", "trigger", "", "getOnTriggerSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnTriggerSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "update", "title", "", "value", "disabled", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNSettingTriggerHolder.kt */
public final class DeviceNSettingTriggerHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceNSettingsTriggerBinding binding;
    private Function1<? super FilterTrigger, Unit> onTriggerSelectedListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceNSettingTriggerHolder(HolderDeviceNSettingsTriggerBinding holderDeviceNSettingsTriggerBinding) {
        super(holderDeviceNSettingsTriggerBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderDeviceNSettingsTriggerBinding, "binding");
        this.binding = holderDeviceNSettingsTriggerBinding;
        RadioGroup radioGroup = holderDeviceNSettingsTriggerBinding.radioGroupTrigger;
        Intrinsics.checkNotNullExpressionValue(radioGroup, "radioGroupTrigger");
        for (View onClickListener : ViewGroupKt.getChildren(radioGroup)) {
            onClickListener.setOnClickListener(new DeviceNSettingTriggerHolder$$ExternalSyntheticLambda0(this));
        }
    }

    public final HolderDeviceNSettingsTriggerBinding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNSettingTriggerHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNSettingTriggerHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNSettingTriggerHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNSettingTriggerHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderDeviceNSettingsTriggerBinding inflate = HolderDeviceNSettingsTriggerBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceNSettingTriggerHolder(inflate);
        }
    }

    public final Function1<FilterTrigger, Unit> getOnTriggerSelectedListener() {
        return this.onTriggerSelectedListener;
    }

    public final void setOnTriggerSelectedListener(Function1<? super FilterTrigger, Unit> function1) {
        this.onTriggerSelectedListener = function1;
    }

    static final void lambda$2$lambda$1(DeviceNSettingTriggerHolder deviceNSettingTriggerHolder, View view) {
        FilterTrigger filterTrigger;
        Function1<? super FilterTrigger, Unit> function1;
        int id = view.getId();
        if (id == R.id.radio_button_pm) {
            filterTrigger = FilterTrigger.Particles.INSTANCE;
        } else {
            filterTrigger = id == R.id.radio_button_pm_tvoc ? FilterTrigger.ParticlesAndGases.INSTANCE : null;
        }
        if (filterTrigger != null && (function1 = deviceNSettingTriggerHolder.onTriggerSelectedListener) != null) {
            function1.invoke(filterTrigger);
        }
    }

    public final void update(int i, FilterTrigger filterTrigger, boolean z) {
        int i2;
        Intrinsics.checkNotNullParameter(filterTrigger, "value");
        this.binding.title.setText(i);
        if (filterTrigger instanceof FilterTrigger.Particles) {
            i2 = R.id.radio_button_pm;
        } else if (filterTrigger instanceof FilterTrigger.ParticlesAndGases) {
            i2 = R.id.radio_button_pm_tvoc;
        } else {
            i2 = R.id.radio_button_pm;
        }
        this.binding.radioGroupTrigger.check(i2);
        this.binding.title.setTextColor(ContextCompat.getColor(this.itemView.getContext(), z ? com.blueair.viewcore.R.color.marineblue_20 : com.blueair.viewcore.R.color.colorPrimaryText));
        RadioGroup radioGroup = this.binding.radioGroupTrigger;
        Intrinsics.checkNotNullExpressionValue(radioGroup, "radioGroupTrigger");
        for (View enabled : ViewGroupKt.getChildren(radioGroup)) {
            enabled.setEnabled(!z);
        }
    }
}
