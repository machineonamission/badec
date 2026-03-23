package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.TypedValueCompat;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.databinding.HolderDeviceHintBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHintHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceHintBinding;", "binding", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceHintBinding;)V", "update", "", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceHintHolder.kt */
public final class DeviceHintHolder extends DeviceControlHolder<HolderDeviceHintBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public void update(Device device, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHintHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceHintHolder;", "parentView", "Landroid/view/ViewGroup;", "msgRes", "", "expectMarginTopInDp", "", "onClosedListener", "Lkotlin/Function0;", "", "(Landroid/view/ViewGroup;ILjava/lang/Float;Lkotlin/jvm/functions/Function0;)Lcom/blueair/devicedetails/viewholder/DeviceHintHolder;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceHintHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DeviceHintHolder newInstance$default(Companion companion, ViewGroup viewGroup, int i, Float f, Function0 function0, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                f = null;
            }
            return companion.newInstance(viewGroup, i, f, function0);
        }

        public final DeviceHintHolder newInstance(ViewGroup viewGroup, int i, Float f, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onClosedListener");
            HolderDeviceHintBinding inflate = HolderDeviceHintBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            inflate.hintText.setText(i);
            inflate.btnCloseHint.setOnClickListener(new DeviceHintHolder$Companion$$ExternalSyntheticLambda0(function0));
            Intrinsics.checkNotNullExpressionValue(inflate, "apply(...)");
            if (f != null) {
                float floatValue = f.floatValue();
                ViewGroup.LayoutParams layoutParams = inflate.getRoot().getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                if (marginLayoutParams != null) {
                    marginLayoutParams.topMargin = (int) TypedValueCompat.dpToPx(floatValue, viewGroup.getResources().getDisplayMetrics());
                    inflate.getRoot().setLayoutParams(marginLayoutParams);
                }
            }
            return new DeviceHintHolder(inflate);
        }

        /* access modifiers changed from: private */
        public static final void newInstance$lambda$1$lambda$0(Function0 function0, View view) {
            function0.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceHintHolder(HolderDeviceHintBinding holderDeviceHintBinding) {
        super(holderDeviceHintBinding);
        Intrinsics.checkNotNullParameter(holderDeviceHintBinding, "binding");
    }
}
