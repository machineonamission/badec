package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.SensorType;
import com.blueair.devicedetails.databinding.HolderDeviceEtaBinding;
import com.blueair.devicedetails.util.EtaUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.IndoorAirStatusLabel;
import com.blueair.viewcore.view.SeekProgressBar;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceEtaHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceEtaBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceEtaBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceEtaBinding;", "update", "", "device", "Lcom/blueair/core/model/HasFanSpeed;", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEtaHolder.kt */
public final class DeviceEtaHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceEtaBinding binding;

    public void update(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceEtaHolder(com.blueair.devicedetails.databinding.HolderDeviceEtaBinding r3) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r2.<init>(r0)
            r2.binding = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceEtaHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceEtaBinding):void");
    }

    public final HolderDeviceEtaBinding getBinding() {
        return this.binding;
    }

    public final void update(HasFanSpeed hasFanSpeed, IndoorDatapoint indoorDatapoint) {
        IndoorAirStatusLabel fromDeviceAndSensorAndDatapoint;
        Integer indoorAirStatusProgressDrawable;
        Intrinsics.checkNotNullParameter(hasFanSpeed, "device");
        Intrinsics.checkNotNullParameter(indoorDatapoint, "dataPoint");
        if (indoorDatapoint.getPm25() == null) {
            TextView textView = this.binding.clearAirMinView;
            Intrinsics.checkNotNullExpressionValue(textView, "clearAirMinView");
            ViewExtensionsKt.show(textView, false);
            TextView textView2 = this.binding.clearAirMsgView;
            Intrinsics.checkNotNullExpressionValue(textView2, "clearAirMsgView");
            ViewExtensionsKt.show(textView2, false);
            SeekProgressBar seekProgressBar = this.binding.progress;
            Intrinsics.checkNotNullExpressionValue(seekProgressBar, "progress");
            ViewExtensionsKt.show(seekProgressBar, false);
        }
        EtaUtils etaUtils = EtaUtils.INSTANCE;
        Device device = hasFanSpeed;
        int fanSpeedValue = DeviceKt.fanSpeedValue(device);
        Float pm25 = indoorDatapoint.getPm25();
        int eta = etaUtils.eta(fanSpeedValue, pm25 != null ? (int) pm25.floatValue() : Integer.MAX_VALUE);
        boolean z = eta > 60;
        int calcEtaPercent = EtaUtils.INSTANCE.calcEtaPercent(eta);
        Timber.Forest forest = Timber.Forest;
        forest.d("update: eta = " + eta + ", perc = " + calcEtaPercent + ", dataPoint = " + indoorDatapoint + ", fanspeed = " + DeviceKt.fanSpeedValue(device), new Object[0]);
        String str = "";
        if (eta == 0) {
            this.binding.clearAirMinView.setText(this.itemView.getResources().getString(R.string.eta_success));
            this.binding.clearAirMsgView.setText(str);
        } else {
            TextView textView3 = this.binding.clearAirMinView;
            StringBuilder sb = new StringBuilder();
            if (z) {
                str = "> ";
            }
            sb.append(str);
            sb.append(Math.min(eta, 60));
            sb.append(TokenParser.SP);
            sb.append(this.itemView.getResources().getString(R.string.eta_minutes));
            textView3.setText(sb.toString());
            this.binding.clearAirMsgView.setText(this.itemView.getResources().getString(R.string.clear_air_in));
        }
        this.binding.progress.setProgress(calcEtaPercent);
        if ((hasFanSpeed instanceof HasSensorData) && (fromDeviceAndSensorAndDatapoint = IndoorAirStatusLabel.Companion.fromDeviceAndSensorAndDatapoint(indoorDatapoint, (HasSensorData) hasFanSpeed, SensorType.PM25, true)) != null && (indoorAirStatusProgressDrawable = fromDeviceAndSensorAndDatapoint.getIndoorAirStatusProgressDrawable()) != null) {
            this.binding.progress.setProgressDrawable(ContextCompat.getDrawable(this.itemView.getContext(), indoorAirStatusProgressDrawable.intValue()));
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceEtaHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceEtaHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceEtaHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceEtaHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderDeviceEtaBinding inflate = HolderDeviceEtaBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceEtaHolder(inflate);
        }
    }
}
