package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceIcp;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.viewcore.R;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceOfflineHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Landroidx/viewbinding/ViewBinding;", "device", "Lcom/blueair/core/model/Device;", "onTroubleShootClickListener", "Lkotlin/Function0;", "", "<init>", "(Landroidx/viewbinding/ViewBinding;Lcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "getOnTroubleShootClickListener", "()Lkotlin/jvm/functions/Function0;", "separator", "Landroid/view/View;", "offlineImageview", "Landroid/widget/ImageView;", "subtitle", "Landroid/widget/TextView;", "troubleshootBtn", "Landroid/widget/Button;", "update", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceOfflineHolder.kt */
public final class DeviceOfflineHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ViewBinding binding;
    private final Device device;
    private final ImageView offlineImageview;
    private final Function0<Unit> onTroubleShootClickListener;
    private final View separator;
    private final TextView subtitle;
    private final Button troubleshootBtn;

    public final ViewBinding getBinding() {
        return this.binding;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final Function0<Unit> getOnTroubleShootClickListener() {
        return this.onTroubleShootClickListener;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceOfflineHolder(androidx.viewbinding.ViewBinding r4, com.blueair.core.model.Device r5, kotlin.jvm.functions.Function0<kotlin.Unit> r6) {
        /*
            r3 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "onTroubleShootClickListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            android.view.View r0 = r4.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r3.<init>(r0)
            r3.binding = r4
            r3.device = r5
            r3.onTroubleShootClickListener = r6
            boolean r6 = r4 instanceof com.blueair.devicedetails.databinding.HolderDeviceHOfflineBinding
            java.lang.String r0 = "troubleshootBtn"
            java.lang.String r1 = "subtitle"
            java.lang.String r2 = "offlineImageview"
            if (r6 == 0) goto L_0x005c
            r6 = 0
            r3.separator = r6
            r6 = r4
            com.blueair.devicedetails.databinding.HolderDeviceHOfflineBinding r6 = (com.blueair.devicedetails.databinding.HolderDeviceHOfflineBinding) r6
            androidx.appcompat.widget.AppCompatImageView r6 = r6.offlineImageview
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r3.offlineImageview = r6
            r6 = r4
            com.blueair.devicedetails.databinding.HolderDeviceHOfflineBinding r6 = (com.blueair.devicedetails.databinding.HolderDeviceHOfflineBinding) r6
            android.widget.TextView r6 = r6.subtitle
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            r3.subtitle = r6
            r6 = r4
            com.blueair.devicedetails.databinding.HolderDeviceHOfflineBinding r6 = (com.blueair.devicedetails.databinding.HolderDeviceHOfflineBinding) r6
            com.google.android.material.button.MaterialButton r6 = r6.troubleshootBtn
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            android.widget.Button r6 = (android.widget.Button) r6
            r3.troubleshootBtn = r6
            boolean r6 = r5 instanceof com.blueair.core.model.DeviceHumidifier
            if (r6 == 0) goto L_0x0052
            int r6 = com.blueair.viewcore.R.string.offline_title_humidifier
            goto L_0x0054
        L_0x0052:
            int r6 = com.blueair.viewcore.R.string.offline_title
        L_0x0054:
            com.blueair.devicedetails.databinding.HolderDeviceHOfflineBinding r4 = (com.blueair.devicedetails.databinding.HolderDeviceHOfflineBinding) r4
            android.widget.TextView r4 = r4.title
            r4.setText(r6)
            goto L_0x008c
        L_0x005c:
            java.lang.String r6 = "null cannot be cast to non-null type com.blueair.devicedetails.databinding.HolderDeviceOfflineBinding"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r6)
            r6 = r4
            com.blueair.devicedetails.databinding.HolderDeviceOfflineBinding r6 = (com.blueair.devicedetails.databinding.HolderDeviceOfflineBinding) r6
            r6 = r4
            com.blueair.devicedetails.databinding.HolderDeviceOfflineBinding r6 = (com.blueair.devicedetails.databinding.HolderDeviceOfflineBinding) r6
            android.view.View r6 = r6.separator
            r3.separator = r6
            r6 = r4
            com.blueair.devicedetails.databinding.HolderDeviceOfflineBinding r6 = (com.blueair.devicedetails.databinding.HolderDeviceOfflineBinding) r6
            androidx.appcompat.widget.AppCompatImageView r6 = r6.offlineImageview
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r3.offlineImageview = r6
            r6 = r4
            com.blueair.devicedetails.databinding.HolderDeviceOfflineBinding r6 = (com.blueair.devicedetails.databinding.HolderDeviceOfflineBinding) r6
            android.widget.TextView r6 = r6.subtitle
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            r3.subtitle = r6
            com.blueair.devicedetails.databinding.HolderDeviceOfflineBinding r4 = (com.blueair.devicedetails.databinding.HolderDeviceOfflineBinding) r4
            com.google.android.material.button.MaterialButton r4 = r4.troubleshootBtn
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.widget.Button r4 = (android.widget.Button) r4
            r3.troubleshootBtn = r4
        L_0x008c:
            boolean r4 = r5 instanceof com.blueair.core.model.DeviceIcp
            if (r4 == 0) goto L_0x0098
            android.widget.Button r4 = r3.troubleshootBtn
            android.view.View r4 = (android.view.View) r4
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r4)
            return
        L_0x0098:
            android.widget.Button r4 = r3.troubleshootBtn
            com.blueair.devicedetails.viewholder.DeviceOfflineHolder$$ExternalSyntheticLambda0 r5 = new com.blueair.devicedetails.viewholder.DeviceOfflineHolder$$ExternalSyntheticLambda0
            r5.<init>(r3)
            r4.setOnClickListener(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceOfflineHolder.<init>(androidx.viewbinding.ViewBinding, com.blueair.core.model.Device, kotlin.jvm.functions.Function0):void");
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceOfflineHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceOfflineHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "onTroubleShootClickListener", "Lkotlin/Function0;", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceOfflineHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceOfflineHolder newInstance(ViewGroup viewGroup, Device device, Function0<Unit> function0) {
            Function3 function3;
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function0, "onTroubleShootClickListener");
            if (device == null || !DeviceKt.isAfterG4(device)) {
                function3 = DeviceOfflineHolder$Companion$newInstance$inflate$2.INSTANCE;
            } else {
                function3 = DeviceOfflineHolder$Companion$newInstance$inflate$1.INSTANCE;
            }
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            return new DeviceOfflineHolder((ViewBinding) function3.invoke(from, viewGroup, false), device, function0);
        }
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceOfflineHolder deviceOfflineHolder, View view) {
        deviceOfflineHolder.onTroubleShootClickListener.invoke();
    }

    public void update(Device device2) {
        Intrinsics.checkNotNullParameter(device2, "device");
        if (device2 instanceof DeviceNewClassic) {
            View view = this.separator;
            if (view != null) {
                ViewExtensionsKt.hide(view);
            }
            this.binding.getRoot().setBackgroundTintList(ColorStateList.valueOf(0));
        } else if (device2 instanceof DeviceIcp) {
            this.offlineImageview.setImageDrawable(ResourcesCompat.getDrawable(this.itemView.getResources(), R.drawable.ic_bluetooth_disabled, (Resources.Theme) null));
            this.subtitle.setText(this.itemView.getResources().getText(R.string.offline_subtitle_ble));
        }
    }
}
