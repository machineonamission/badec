package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.FilterLifeTime;
import com.blueair.core.model.HasSKU;
import com.blueair.core.model.HasWick;
import com.blueair.devicedetails.databinding.HolderDeviceFilterOrWickStatusBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019BH\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R)\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterOrWickStatusHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceFilterOrWickStatusBinding;", "type", "Lcom/blueair/core/model/DeviceFilterType;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onOpenPageListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "onlyBuy", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceFilterOrWickStatusBinding;Lcom/blueair/core/model/DeviceFilterType;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceFilterOrWickStatusBinding;", "getType", "()Lcom/blueair/core/model/DeviceFilterType;", "update", "device", "Lcom/blueair/core/model/Device;", "setOffline", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceFilterOrWickStatusHolder.kt */
public final class DeviceFilterOrWickStatusHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceFilterOrWickStatusBinding binding;
    private final Function0<Unit> onOpenInfoListener;
    private final Function1<Boolean, Unit> onOpenPageListener;
    private final DeviceFilterType type;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterOrWickStatusHolder.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceFilterType.values().length];
            try {
                iArr[DeviceFilterType.FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final HolderDeviceFilterOrWickStatusBinding getBinding() {
        return this.binding;
    }

    public final DeviceFilterType getType() {
        return this.type;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JG\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\f0\u000e¨\u0006\u0013"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterOrWickStatusHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceFilterOrWickStatusHolder;", "parentView", "Landroid/view/ViewGroup;", "type", "Lcom/blueair/core/model/DeviceFilterType;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onOpenPageListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "onlyBuy", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterOrWickStatusHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceFilterOrWickStatusHolder newInstance(ViewGroup viewGroup, DeviceFilterType deviceFilterType, Function0<Unit> function0, Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(deviceFilterType, "type");
            Intrinsics.checkNotNullParameter(function0, "onOpenInfoListener");
            Intrinsics.checkNotNullParameter(function1, "onOpenPageListener");
            HolderDeviceFilterOrWickStatusBinding inflate = HolderDeviceFilterOrWickStatusBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceFilterOrWickStatusHolder(inflate, deviceFilterType, function0, function1);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceFilterOrWickStatusHolder(com.blueair.devicedetails.databinding.HolderDeviceFilterOrWickStatusBinding r3, com.blueair.core.model.DeviceFilterType r4, kotlin.jvm.functions.Function0<kotlin.Unit> r5, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r6) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "onOpenInfoListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "onOpenPageListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            android.widget.FrameLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r2.<init>(r0)
            r2.binding = r3
            r2.type = r4
            r2.onOpenInfoListener = r5
            r2.onOpenPageListener = r6
            android.widget.FrameLayout r5 = r3.getRoot()
            int[] r6 = com.blueair.devicedetails.viewholder.DeviceFilterOrWickStatusHolder.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r6[r4]
            r6 = 1
            if (r4 != r6) goto L_0x003c
            int r4 = com.blueair.devicedetails.R.id.holder_device_n_filter_status
            goto L_0x003e
        L_0x003c:
            int r4 = com.blueair.devicedetails.R.id.holder_device_h_wick_status
        L_0x003e:
            r5.setId(r4)
            android.widget.TextView r4 = r3.title
            com.blueair.devicedetails.viewholder.DeviceFilterOrWickStatusHolder$$ExternalSyntheticLambda0 r5 = new com.blueair.devicedetails.viewholder.DeviceFilterOrWickStatusHolder$$ExternalSyntheticLambda0
            r5.<init>(r2)
            r4.setOnClickListener(r5)
            com.google.android.material.button.MaterialButton r4 = r3.howToReplace
            com.blueair.devicedetails.viewholder.DeviceFilterOrWickStatusHolder$$ExternalSyntheticLambda1 r5 = new com.blueair.devicedetails.viewholder.DeviceFilterOrWickStatusHolder$$ExternalSyntheticLambda1
            r5.<init>(r2)
            r4.setOnClickListener(r5)
            com.google.android.material.button.MaterialButton r3 = r3.buyNew
            com.blueair.devicedetails.viewholder.DeviceFilterOrWickStatusHolder$$ExternalSyntheticLambda2 r4 = new com.blueair.devicedetails.viewholder.DeviceFilterOrWickStatusHolder$$ExternalSyntheticLambda2
            r4.<init>(r2)
            r3.setOnClickListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceFilterOrWickStatusHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceFilterOrWickStatusBinding, com.blueair.core.model.DeviceFilterType, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1):void");
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceFilterOrWickStatusHolder deviceFilterOrWickStatusHolder, View view) {
        deviceFilterOrWickStatusHolder.onOpenInfoListener.invoke();
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(DeviceFilterOrWickStatusHolder deviceFilterOrWickStatusHolder, View view) {
        deviceFilterOrWickStatusHolder.onOpenPageListener.invoke(false);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$2(DeviceFilterOrWickStatusHolder deviceFilterOrWickStatusHolder, View view) {
        deviceFilterOrWickStatusHolder.onOpenPageListener.invoke(true);
    }

    public void update(Device device) {
        FilterConfig filterConfig;
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(device, "device");
        if ((device instanceof HasSKU) && (filterConfig = DeviceConfigProvider.INSTANCE.getFilterConfig(device, this.type)) != null) {
            boolean z = true;
            if (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()] == 1) {
                i3 = R.string.filter_time_left;
                FilterLifeTime filterLifeTime = DeviceKt.getFilterLifeTime(device);
                i = filterLifeTime.getFilterLife();
                i2 = DeviceConfigProvider.INSTANCE.getFilterStatusColor(filterLifeTime);
                this.binding.iconLeft.setImageResource(R.drawable.ic_filter_status);
                this.binding.title.setText(R.string.filter_status);
                this.binding.howToReplace.setText(R.string.how_to_replace_filter);
                this.binding.buyNew.setText(R.string.buy_new_filter);
            } else if (device instanceof HasWick) {
                i3 = R.string.wick_lifetime_left_is;
                i = ((HasWick) device).getWickLifeLeft();
                i2 = DeviceConfigProvider.INSTANCE.getWickStatusColor(i);
                this.binding.iconLeft.setImageResource(R.drawable.ic_humidity_wick);
                this.binding.title.setText(R.string.wick_status);
                this.binding.howToReplace.setText(R.string.how_to_replace_wick);
                this.binding.buyNew.setText(R.string.buy_new_wick);
            } else {
                return;
            }
            MaterialButton materialButton = this.binding.howToReplace;
            Intrinsics.checkNotNullExpressionValue(materialButton, "howToReplace");
            View view = materialButton;
            CharSequence awsLinkValue = DeviceConfigProvider.INSTANCE.getAwsLinkValue(filterConfig.getVideo());
            ViewExtensionsKt.show(view, !(awsLinkValue == null || awsLinkValue.length() == 0));
            MaterialButton materialButton2 = this.binding.buyNew;
            Intrinsics.checkNotNullExpressionValue(materialButton2, "buyNew");
            ViewExtensionsKt.show(materialButton2, DeviceConfigProvider.INSTANCE.hasBuyFilterLink(filterConfig));
            if (device.getConnectivityStatus() == ConnectivityStatus.ONLINE) {
                if (i > 0) {
                    z = false;
                }
                HolderDeviceFilterOrWickStatusBinding holderDeviceFilterOrWickStatusBinding = this.binding;
                holderDeviceFilterOrWickStatusBinding.lifetime.setText(i3);
                TextView textView = holderDeviceFilterOrWickStatusBinding.lifetimeValue;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append('%');
                textView.setText(sb.toString());
                holderDeviceFilterOrWickStatusBinding.lifetimeValue.setTextColor(i2);
                holderDeviceFilterOrWickStatusBinding.progressBar.setProgress(i);
                holderDeviceFilterOrWickStatusBinding.progressBar.setIndicatorColor(update$getColor(this, i > 10 ? R.color.colorPrimary : R.color.fill_warning));
                TextView textView2 = holderDeviceFilterOrWickStatusBinding.expiredText;
                Intrinsics.checkNotNullExpressionValue(textView2, "expiredText");
                ViewExtensionsKt.show(textView2, z);
                return;
            }
            setOffline();
        }
    }

    private static final int update$getColor(DeviceFilterOrWickStatusHolder deviceFilterOrWickStatusHolder, int i) {
        return deviceFilterOrWickStatusHolder.itemView.getContext().getColor(i);
    }

    public final void setOffline() {
        HolderDeviceFilterOrWickStatusBinding holderDeviceFilterOrWickStatusBinding = this.binding;
        holderDeviceFilterOrWickStatusBinding.lifetime.setText(R.string.offline_label);
        holderDeviceFilterOrWickStatusBinding.lifetimeValue.setText("");
        holderDeviceFilterOrWickStatusBinding.progressBar.setProgress(0);
        TextView textView = holderDeviceFilterOrWickStatusBinding.expiredText;
        Intrinsics.checkNotNullExpressionValue(textView, "expiredText");
        ViewExtensionsKt.hide(textView);
    }
}
