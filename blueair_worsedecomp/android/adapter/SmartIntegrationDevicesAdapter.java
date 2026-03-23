package com.blueair.android.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.fragment.integration.IotDeviceConfig;
import com.blueair.viewcore.R;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0013H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R0\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/blueair/android/adapter/SmartIntegrationDevicesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/android/adapter/SmartIntegrationDeviceHolder;", "deviceClickPublisher", "Lio/reactivex/subjects/PublishSubject;", "", "useG4Protect", "", "<init>", "(Lio/reactivex/subjects/PublishSubject;Z)V", "value", "", "Lcom/blueair/android/fragment/integration/IotDeviceConfig;", "devices", "getDevices", "()Ljava/util/List;", "setDevices", "(Ljava/util/List;)V", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SmartIntegrationDevicesAdapter.kt */
public final class SmartIntegrationDevicesAdapter extends RecyclerView.Adapter<SmartIntegrationDeviceHolder> {
    public static final int $stable = 8;
    private final PublishSubject<String> deviceClickPublisher;
    private List<IotDeviceConfig> devices = CollectionsKt.emptyList();
    private final boolean useG4Protect;

    public SmartIntegrationDevicesAdapter(PublishSubject<String> publishSubject, boolean z) {
        Intrinsics.checkNotNullParameter(publishSubject, "deviceClickPublisher");
        this.deviceClickPublisher = publishSubject;
        this.useG4Protect = z;
    }

    public final List<IotDeviceConfig> getDevices() {
        return this.devices;
    }

    public final void setDevices(List<IotDeviceConfig> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.devices = list;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.devices.size();
    }

    public SmartIntegrationDeviceHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return SmartIntegrationDeviceHolder.Companion.newInstance(viewGroup);
    }

    public void onBindViewHolder(SmartIntegrationDeviceHolder smartIntegrationDeviceHolder, int i) {
        Intrinsics.checkNotNullParameter(smartIntegrationDeviceHolder, "holder");
        IotDeviceConfig iotDeviceConfig = this.devices.get(i);
        smartIntegrationDeviceHolder.update(iotDeviceConfig.getNameRes(), iotDeviceConfig.getImageRes(), this.useG4Protect && iotDeviceConfig.getNameRes() == R.string.blueair_g4);
        smartIntegrationDeviceHolder.getBinding().clickview.setOnClickListener(new SmartIntegrationDevicesAdapter$$ExternalSyntheticLambda0(this, iotDeviceConfig));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(SmartIntegrationDevicesAdapter smartIntegrationDevicesAdapter, IotDeviceConfig iotDeviceConfig, View view) {
        smartIntegrationDevicesAdapter.deviceClickPublisher.onNext(iotDeviceConfig.getLink());
    }
}
