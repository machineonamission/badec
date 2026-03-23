package com.blueair.adddevice.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.adddevice.model.BluetoothConnectingInfo;
import com.blueair.adddevice.model.BluetoothConnectingState;
import com.blueair.adddevice.viewholder.LegacyDeviceEntryHolder;
import com.blueair.adddevice.viewholder.ScannedDeviceEmptyStateHolder;
import com.blueair.adddevice.viewholder.ScannedDeviceSummaryHolder;
import com.blueair.auth.LocationService;
import com.blueair.core.model.BluetoothDevice;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0016J\u0018\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\"H\u0016J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\"H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0013R0\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006-"}, d2 = {"Lcom/blueair/adddevice/adapter/ScannedDevicesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "deviceSelectPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/core/model/BluetoothDevice;", "legacySelectPublisher", "", "locationService", "Lcom/blueair/auth/LocationService;", "<init>", "(Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lcom/blueair/auth/LocationService;)V", "hasEmptyState", "getHasEmptyState", "()Z", "value", "hideSingleDevice", "getHideSingleDevice", "setHideSingleDevice", "(Z)V", "nuDevices", "", "devices", "getDevices", "()Ljava/util/List;", "setDevices", "(Ljava/util/List;)V", "connectingInfo", "Lcom/blueair/adddevice/model/BluetoothConnectingInfo;", "getConnectingInfo", "()Lcom/blueair/adddevice/model/BluetoothConnectingInfo;", "setConnectingInfo", "(Lcom/blueair/adddevice/model/BluetoothConnectingInfo;)V", "getItemCount", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ScannedDevicesAdapter.kt */
public final class ScannedDevicesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final int TYPE_EMPTY_STATE = 0;
    @Deprecated
    public static final int TYPE_FIND_YOUR_DEVICE = 1;
    @Deprecated
    public static final int TYPE_LEGACY_DEVICE = 2;
    private BluetoothConnectingInfo connectingInfo;
    private final PublishSubject<BluetoothDevice> deviceSelectPublisher;
    private List<BluetoothDevice> devices = CollectionsKt.emptyList();
    private boolean hideSingleDevice;
    private final PublishSubject<Boolean> legacySelectPublisher;
    private final LocationService locationService;

    public ScannedDevicesAdapter(PublishSubject<BluetoothDevice> publishSubject, PublishSubject<Boolean> publishSubject2, LocationService locationService2) {
        Intrinsics.checkNotNullParameter(publishSubject, "deviceSelectPublisher");
        Intrinsics.checkNotNullParameter(publishSubject2, "legacySelectPublisher");
        Intrinsics.checkNotNullParameter(locationService2, "locationService");
        this.deviceSelectPublisher = publishSubject;
        this.legacySelectPublisher = publishSubject2;
        this.locationService = locationService2;
    }

    public final boolean getHasEmptyState() {
        return this.devices.isEmpty() || (this.hideSingleDevice && this.devices.size() == 1);
    }

    public final boolean getHideSingleDevice() {
        return this.hideSingleDevice;
    }

    public final void setHideSingleDevice(boolean z) {
        if (this.hideSingleDevice != z) {
            this.hideSingleDevice = z;
            notifyDataSetChanged();
        }
    }

    public final List<BluetoothDevice> getDevices() {
        return this.devices;
    }

    public final void setDevices(List<BluetoothDevice> list) {
        Intrinsics.checkNotNullParameter(list, "nuDevices");
        if (!Intrinsics.areEqual((Object) this.devices, (Object) list)) {
            this.devices = CollectionsKt.sorted(list);
            notifyDataSetChanged();
        }
    }

    public final BluetoothConnectingInfo getConnectingInfo() {
        return this.connectingInfo;
    }

    public final void setConnectingInfo(BluetoothConnectingInfo bluetoothConnectingInfo) {
        this.connectingInfo = bluetoothConnectingInfo;
    }

    public int getItemCount() {
        if (getHasEmptyState()) {
            return 1;
        }
        return this.devices.size() + 1;
    }

    public int getItemViewType(int i) {
        if (getHasEmptyState()) {
            return 0;
        }
        return i < this.devices.size() ? 1 : 2;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 0) {
            return ScannedDeviceEmptyStateHolder.Companion.newInstance(viewGroup);
        }
        if (i == 1) {
            return ScannedDeviceSummaryHolder.Companion.newInstance(viewGroup);
        }
        if (i == 2) {
            return LegacyDeviceEntryHolder.Companion.newInstance(viewGroup, this.locationService);
        }
        throw new RuntimeException("View Type does not exist.");
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof ScannedDeviceSummaryHolder) {
            BluetoothDevice bluetoothDevice = this.devices.get(i);
            BluetoothConnectingInfo bluetoothConnectingInfo = this.connectingInfo;
            Timber.Forest forest = Timber.Forest;
            forest.d("onBindViewHolder: device = " + bluetoothDevice + ", connInfo = " + bluetoothConnectingInfo, new Object[0]);
            ScannedDeviceSummaryHolder scannedDeviceSummaryHolder = (ScannedDeviceSummaryHolder) viewHolder;
            scannedDeviceSummaryHolder.update(bluetoothDevice, (bluetoothConnectingInfo == null || !Intrinsics.areEqual((Object) bluetoothConnectingInfo.getDeviceMac(), (Object) bluetoothDevice.getMac())) ? BluetoothConnectingState.NotConnected.INSTANCE : bluetoothConnectingInfo.getConnectionState());
            scannedDeviceSummaryHolder.getClickView().setOnClickListener(new ScannedDevicesAdapter$$ExternalSyntheticLambda0(this, bluetoothDevice));
        } else if (viewHolder instanceof LegacyDeviceEntryHolder) {
            ((LegacyDeviceEntryHolder) viewHolder).getClickView().setOnClickListener(new ScannedDevicesAdapter$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(ScannedDevicesAdapter scannedDevicesAdapter, BluetoothDevice bluetoothDevice, View view) {
        scannedDevicesAdapter.deviceSelectPublisher.onNext(bluetoothDevice);
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(ScannedDevicesAdapter scannedDevicesAdapter, View view) {
        scannedDevicesAdapter.legacySelectPublisher.onNext(true);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/adapter/ScannedDevicesAdapter$Companion;", "", "<init>", "()V", "TYPE_EMPTY_STATE", "", "TYPE_FIND_YOUR_DEVICE", "TYPE_LEGACY_DEVICE", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ScannedDevicesAdapter.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
