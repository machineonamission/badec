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

@Metadata(
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0016J\u0018\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\"H\u0016J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\"H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0013R0\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006-"},
   d2 = {"Lcom/blueair/adddevice/adapter/ScannedDevicesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "deviceSelectPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/core/model/BluetoothDevice;", "legacySelectPublisher", "", "locationService", "Lcom/blueair/auth/LocationService;", "<init>", "(Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lcom/blueair/auth/LocationService;)V", "hasEmptyState", "getHasEmptyState", "()Z", "value", "hideSingleDevice", "getHideSingleDevice", "setHideSingleDevice", "(Z)V", "nuDevices", "", "devices", "getDevices", "()Ljava/util/List;", "setDevices", "(Ljava/util/List;)V", "connectingInfo", "Lcom/blueair/adddevice/model/BluetoothConnectingInfo;", "getConnectingInfo", "()Lcom/blueair/adddevice/model/BluetoothConnectingInfo;", "setConnectingInfo", "(Lcom/blueair/adddevice/model/BluetoothConnectingInfo;)V", "getItemCount", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ScannedDevicesAdapter extends RecyclerView.Adapter {
   private static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   @Deprecated
   public static final int TYPE_EMPTY_STATE = 0;
   @Deprecated
   public static final int TYPE_FIND_YOUR_DEVICE = 1;
   @Deprecated
   public static final int TYPE_LEGACY_DEVICE = 2;
   private BluetoothConnectingInfo connectingInfo;
   private final PublishSubject deviceSelectPublisher;
   private List devices;
   private boolean hideSingleDevice;
   private final PublishSubject legacySelectPublisher;
   private final LocationService locationService;

   // $FF: synthetic method
   public static void $r8$lambda$KXlawafuBHr9EkZt_yGac7PkqoA(ScannedDevicesAdapter var0, View var1) {
      onBindViewHolder$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Q4p_fRphDPOEp9tf9dNLB8f_7AI/* $FF was: $r8$lambda$Q4p_fRphDPOEp9tf9dNLB8f-7AI*/(ScannedDevicesAdapter var0, BluetoothDevice var1, View var2) {
      onBindViewHolder$lambda$0(var0, var1, var2);
   }

   public ScannedDevicesAdapter(PublishSubject var1, PublishSubject var2, LocationService var3) {
      Intrinsics.checkNotNullParameter(var1, "deviceSelectPublisher");
      Intrinsics.checkNotNullParameter(var2, "legacySelectPublisher");
      Intrinsics.checkNotNullParameter(var3, "locationService");
      super();
      this.deviceSelectPublisher = var1;
      this.legacySelectPublisher = var2;
      this.locationService = var3;
      this.devices = CollectionsKt.emptyList();
   }

   private static final void onBindViewHolder$lambda$0(ScannedDevicesAdapter var0, BluetoothDevice var1, View var2) {
      var0.deviceSelectPublisher.onNext(var1);
   }

   private static final void onBindViewHolder$lambda$1(ScannedDevicesAdapter var0, View var1) {
      var0.legacySelectPublisher.onNext(true);
   }

   public final BluetoothConnectingInfo getConnectingInfo() {
      return this.connectingInfo;
   }

   public final List getDevices() {
      return this.devices;
   }

   public final boolean getHasEmptyState() {
      return this.devices.isEmpty() || this.hideSingleDevice && this.devices.size() == 1;
   }

   public final boolean getHideSingleDevice() {
      return this.hideSingleDevice;
   }

   public int getItemCount() {
      return this.getHasEmptyState() ? 1 : this.devices.size() + 1;
   }

   public int getItemViewType(int var1) {
      if (this.getHasEmptyState()) {
         return 0;
      } else {
         return var1 < this.devices.size() ? 1 : 2;
      }
   }

   public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      if (!(var1 instanceof ScannedDeviceSummaryHolder)) {
         if (var1 instanceof LegacyDeviceEntryHolder) {
            ((LegacyDeviceEntryHolder)var1).getClickView().setOnClickListener(new ScannedDevicesAdapter$$ExternalSyntheticLambda1(this));
         }

      } else {
         BluetoothDevice var3 = (BluetoothDevice)this.devices.get(var2);
         BluetoothConnectingInfo var4 = this.connectingInfo;
         Timber.Forest var6 = Timber.Forest;
         StringBuilder var5 = new StringBuilder("onBindViewHolder: device = ");
         var5.append(var3);
         var5.append(", connInfo = ");
         var5.append(var4);
         var6.d(var5.toString(), new Object[0]);
         ScannedDeviceSummaryHolder var8 = (ScannedDeviceSummaryHolder)var1;
         BluetoothConnectingState var7;
         if (var4 != null && Intrinsics.areEqual(var4.getDeviceMac(), var3.getMac())) {
            var7 = var4.getConnectionState();
         } else {
            var7 = BluetoothConnectingState.NotConnected.INSTANCE;
         }

         var8.update(var3, var7);
         var8.getClickView().setOnClickListener(new ScannedDevicesAdapter$$ExternalSyntheticLambda0(this, var3));
      }
   }

   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      if (var2 != 0) {
         if (var2 != 1) {
            if (var2 == 2) {
               return LegacyDeviceEntryHolder.Companion.newInstance(var1, this.locationService);
            } else {
               throw new RuntimeException("View Type does not exist.");
            }
         } else {
            return ScannedDeviceSummaryHolder.Companion.newInstance(var1);
         }
      } else {
         return ScannedDeviceEmptyStateHolder.Companion.newInstance(var1);
      }
   }

   public final void setConnectingInfo(BluetoothConnectingInfo var1) {
      this.connectingInfo = var1;
   }

   public final void setDevices(List var1) {
      Intrinsics.checkNotNullParameter(var1, "nuDevices");
      if (!Intrinsics.areEqual(this.devices, var1)) {
         this.devices = CollectionsKt.sorted((Iterable)var1);
         this.notifyDataSetChanged();
      }

   }

   public final void setHideSingleDevice(boolean var1) {
      if (this.hideSingleDevice != var1) {
         this.hideSingleDevice = var1;
         this.notifyDataSetChanged();
      }

   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/adapter/ScannedDevicesAdapter$Companion;", "", "<init>", "()V", "TYPE_EMPTY_STATE", "", "TYPE_FIND_YOUR_DEVICE", "TYPE_LEGACY_DEVICE", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   private static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
