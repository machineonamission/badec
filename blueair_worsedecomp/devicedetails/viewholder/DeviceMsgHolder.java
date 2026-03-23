package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.TypedValueCompat;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.databinding.HolderDeviceMsgBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceMsgHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceMsgBinding;", "binding", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceMsgBinding;)V", "update", "", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceMsgHolder.kt */
public final class DeviceMsgHolder extends DeviceControlHolder<HolderDeviceMsgBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public void update(Device device, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceMsgHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceMsgHolder;", "parentView", "Landroid/view/ViewGroup;", "titleRes", "", "msgRes", "expectMarginTopInDp", "", "expectIconRes", "onClosedListener", "Lkotlin/Function0;", "", "(Landroid/view/ViewGroup;IILjava/lang/Float;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)Lcom/blueair/devicedetails/viewholder/DeviceMsgHolder;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceMsgHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DeviceMsgHolder newInstance$default(Companion companion, ViewGroup viewGroup, int i, int i2, Float f, Integer num, Function0 function0, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                f = null;
            }
            if ((i3 & 16) != 0) {
                num = null;
            }
            return companion.newInstance(viewGroup, i, i2, f, num, function0);
        }

        public final DeviceMsgHolder newInstance(ViewGroup viewGroup, int i, int i2, Float f, Integer num, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onClosedListener");
            HolderDeviceMsgBinding inflate = HolderDeviceMsgBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            inflate.title.setText(i);
            inflate.message.setText(i2);
            inflate.closeBtn.setOnClickListener(new DeviceMsgHolder$Companion$$ExternalSyntheticLambda0(function0));
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
            if (num != null) {
                inflate.leadingIcon.setImageResource(num.intValue());
            }
            return new DeviceMsgHolder(inflate);
        }

        /* access modifiers changed from: private */
        public static final void newInstance$lambda$1$lambda$0(Function0 function0, View view) {
            function0.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceMsgHolder(HolderDeviceMsgBinding holderDeviceMsgBinding) {
        super(holderDeviceMsgBinding);
        Intrinsics.checkNotNullParameter(holderDeviceMsgBinding, "binding");
    }
}
