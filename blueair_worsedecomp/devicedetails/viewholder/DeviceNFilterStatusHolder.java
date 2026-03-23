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
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasSKU;
import com.blueair.devicedetails.databinding.HolderDeviceNFilterStatusBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R)\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNFilterStatusHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceNFilterStatusBinding;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onOpenFilterPageListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "onlyBuy", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNFilterStatusBinding;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceNFilterStatusBinding;", "update", "device", "Lcom/blueair/core/model/Device;", "setOffline", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNFilterStatusHolder.kt */
public final class DeviceNFilterStatusHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceNFilterStatusBinding binding;
    private final Function1<Boolean, Unit> onOpenFilterPageListener;
    private final Function0<Unit> onOpenInfoListener;

    public final HolderDeviceNFilterStatusBinding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n0\f¨\u0006\u0011"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNFilterStatusHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNFilterStatusHolder;", "parentView", "Landroid/view/ViewGroup;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onOpenFilterPageListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "onlyBuy", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNFilterStatusHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceNFilterStatusHolder newInstance(ViewGroup viewGroup, Function0<Unit> function0, Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onOpenInfoListener");
            Intrinsics.checkNotNullParameter(function1, "onOpenFilterPageListener");
            HolderDeviceNFilterStatusBinding inflate = HolderDeviceNFilterStatusBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceNFilterStatusHolder(inflate, function0, function1);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceNFilterStatusHolder(com.blueair.devicedetails.databinding.HolderDeviceNFilterStatusBinding r3, kotlin.jvm.functions.Function0<kotlin.Unit> r4, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r5) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onOpenInfoListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "onOpenFilterPageListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.view.View r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.<init>(r0)
            r2.binding = r3
            r2.onOpenInfoListener = r4
            r2.onOpenFilterPageListener = r5
            android.widget.TextView r4 = r3.title
            com.blueair.devicedetails.viewholder.DeviceNFilterStatusHolder$$ExternalSyntheticLambda0 r5 = new com.blueair.devicedetails.viewholder.DeviceNFilterStatusHolder$$ExternalSyntheticLambda0
            r5.<init>(r2)
            r4.setOnClickListener(r5)
            com.google.android.material.button.MaterialButton r4 = r3.howToReplace
            com.blueair.devicedetails.viewholder.DeviceNFilterStatusHolder$$ExternalSyntheticLambda1 r5 = new com.blueair.devicedetails.viewholder.DeviceNFilterStatusHolder$$ExternalSyntheticLambda1
            r5.<init>(r2)
            r4.setOnClickListener(r5)
            com.google.android.material.button.MaterialButton r3 = r3.buyNew
            com.blueair.devicedetails.viewholder.DeviceNFilterStatusHolder$$ExternalSyntheticLambda2 r4 = new com.blueair.devicedetails.viewholder.DeviceNFilterStatusHolder$$ExternalSyntheticLambda2
            r4.<init>(r2)
            r3.setOnClickListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceNFilterStatusHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceNFilterStatusBinding, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1):void");
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceNFilterStatusHolder deviceNFilterStatusHolder, View view) {
        deviceNFilterStatusHolder.onOpenInfoListener.invoke();
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(DeviceNFilterStatusHolder deviceNFilterStatusHolder, View view) {
        deviceNFilterStatusHolder.onOpenFilterPageListener.invoke(false);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$2(DeviceNFilterStatusHolder deviceNFilterStatusHolder, View view) {
        deviceNFilterStatusHolder.onOpenFilterPageListener.invoke(true);
    }

    public void update(Device device) {
        int i;
        String str;
        Intrinsics.checkNotNullParameter(device, "device");
        if ((device instanceof HasSKU) && (device instanceof HasFanSpeed)) {
            FilterConfig filterConfig = DeviceConfigProvider.INSTANCE.getFilterConfig(device, DeviceFilterType.FILTER);
            MaterialButton materialButton = this.binding.howToReplace;
            Intrinsics.checkNotNullExpressionValue(materialButton, "howToReplace");
            View view = materialButton;
            CharSequence awsLinkValue = DeviceConfigProvider.INSTANCE.getAwsLinkValue(filterConfig != null ? filterConfig.getVideo() : null);
            boolean z = false;
            ViewExtensionsKt.show(view, !(awsLinkValue == null || awsLinkValue.length() == 0));
            MaterialButton materialButton2 = this.binding.buyNew;
            Intrinsics.checkNotNullExpressionValue(materialButton2, "buyNew");
            ViewExtensionsKt.show(materialButton2, DeviceConfigProvider.INSTANCE.hasBuyFilterLink(filterConfig));
            if (device.getConnectivityStatus() == ConnectivityStatus.ONLINE) {
                FilterLifeTime filterLifeTime = DeviceKt.getFilterLifeTime(device);
                int filterLife = filterLifeTime.getFilterLife();
                HolderDeviceNFilterStatusBinding holderDeviceNFilterStatusBinding = this.binding;
                holderDeviceNFilterStatusBinding.progressBar.setProgress(filterLife);
                if (filterLifeTime.getFilterLife() <= 0) {
                    z = true;
                }
                LinearProgressIndicator linearProgressIndicator = holderDeviceNFilterStatusBinding.progressBar;
                if (filterLife > 10) {
                    i = R.color.colorPrimary;
                } else {
                    i = R.color.fill_warning;
                }
                linearProgressIndicator.setIndicatorColor(update$getColor(this, i));
                TextView textView = holderDeviceNFilterStatusBinding.progressText;
                if (z) {
                    str = this.itemView.getContext().getString(R.string.filter_has_expired);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(filterLife);
                    sb.append('%');
                    str = sb.toString();
                }
                textView.setText(str);
                TextView textView2 = holderDeviceNFilterStatusBinding.expiredText;
                Intrinsics.checkNotNullExpressionValue(textView2, "expiredText");
                ViewExtensionsKt.show(textView2, z);
                TextView textView3 = holderDeviceNFilterStatusBinding.hintText;
                Intrinsics.checkNotNullExpressionValue(textView3, "hintText");
                ViewExtensionsKt.hide(textView3);
                return;
            }
            setOffline();
        }
    }

    private static final int update$getColor(DeviceNFilterStatusHolder deviceNFilterStatusHolder, int i) {
        return deviceNFilterStatusHolder.itemView.getContext().getColor(i);
    }

    public final void setOffline() {
        HolderDeviceNFilterStatusBinding holderDeviceNFilterStatusBinding = this.binding;
        holderDeviceNFilterStatusBinding.progressText.setText("");
        holderDeviceNFilterStatusBinding.progressBar.setProgress(0);
        TextView textView = holderDeviceNFilterStatusBinding.hintText;
        Intrinsics.checkNotNullExpressionValue(textView, "hintText");
        ViewExtensionsKt.show$default(textView, false, 1, (Object) null);
        holderDeviceNFilterStatusBinding.hintText.setText(R.string.offline_label);
        TextView textView2 = holderDeviceNFilterStatusBinding.expiredText;
        Intrinsics.checkNotNullExpressionValue(textView2, "expiredText");
        ViewExtensionsKt.hide(textView2);
    }
}
