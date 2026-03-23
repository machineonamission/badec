package com.blueair.viewcore.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.FilterInfo;
import com.blueair.core.model.I18nConfig;
import com.blueair.push.NotificationService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.databinding.HolderDeviceFilterBinding;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/blueair/viewcore/viewholder/DeviceFilterHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/viewcore/databinding/HolderDeviceFilterBinding;", "<init>", "(Lcom/blueair/viewcore/databinding/HolderDeviceFilterBinding;)V", "getBinding", "()Lcom/blueair/viewcore/databinding/HolderDeviceFilterBinding;", "update", "", "filter", "Lcom/blueair/core/model/FilterInfo;", "onFilterSelectedListener", "Lkotlin/Function1;", "Companion", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceFilterHolder.kt */
public final class DeviceFilterHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceFilterBinding binding;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterHolder.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceFilterType.values().length];
            try {
                iArr[DeviceFilterType.WICK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final HolderDeviceFilterBinding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/viewcore/viewholder/DeviceFilterHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/viewcore/viewholder/DeviceFilterHolder;", "parentView", "Landroid/view/ViewGroup;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceFilterHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderDeviceFilterBinding inflate = HolderDeviceFilterBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceFilterHolder(inflate);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceFilterHolder(HolderDeviceFilterBinding holderDeviceFilterBinding) {
        super(holderDeviceFilterBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderDeviceFilterBinding, "binding");
        this.binding = holderDeviceFilterBinding;
    }

    public final void update(FilterInfo filterInfo, Function1<? super FilterInfo, Unit> function1) {
        int i;
        Intrinsics.checkNotNullParameter(filterInfo, NotificationService.ACTION_TYPE_FILTER);
        HolderDeviceFilterBinding holderDeviceFilterBinding = this.binding;
        holderDeviceFilterBinding.icon.setImageResource(filterInfo.getImage());
        TextView textView = holderDeviceFilterBinding.name;
        boolean z = true;
        String value$default = I18nConfig.getValue$default(filterInfo.getName(), (Locale) null, 1, (Object) null);
        if (value$default == null) {
            value$default = "";
        }
        textView.setText(value$default);
        MaterialButton materialButton = holderDeviceFilterBinding.btnSelect;
        if (WhenMappings.$EnumSwitchMapping$0[filterInfo.getType().ordinal()] == 1) {
            i = R.string.select_wick;
        } else {
            i = R.string.select_filter;
        }
        materialButton.setText(i);
        MaterialButton materialButton2 = holderDeviceFilterBinding.btnSelect;
        Intrinsics.checkNotNullExpressionValue(materialButton2, "btnSelect");
        View view = materialButton2;
        if (function1 == null) {
            z = false;
        }
        ViewExtensionsKt.show(view, z);
        holderDeviceFilterBinding.btnSelect.setOnClickListener(new DeviceFilterHolder$$ExternalSyntheticLambda0(function1, filterInfo));
    }

    /* access modifiers changed from: private */
    public static final void update$lambda$1$lambda$0(Function1 function1, FilterInfo filterInfo, View view) {
        if (function1 != null) {
            function1.invoke(filterInfo);
        }
    }
}
