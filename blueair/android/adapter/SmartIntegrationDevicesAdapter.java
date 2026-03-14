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

@Metadata(
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0013H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"},
   d2 = {"Lcom/blueair/android/adapter/SmartIntegrationDevicesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/android/adapter/SmartIntegrationDeviceHolder;", "deviceClickPublisher", "Lio/reactivex/subjects/PublishSubject;", "", "useG4Protect", "", "<init>", "(Lio/reactivex/subjects/PublishSubject;Z)V", "value", "", "Lcom/blueair/android/fragment/integration/IotDeviceConfig;", "devices", "getDevices", "()Ljava/util/List;", "setDevices", "(Ljava/util/List;)V", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SmartIntegrationDevicesAdapter extends RecyclerView.Adapter {
   public static final int $stable = 8;
   private final PublishSubject deviceClickPublisher;
   private List devices;
   private final boolean useG4Protect;

   // $FF: synthetic method
   public static void $r8$lambda$Awh8sMs66ncmaDQYOj2SFh_F2zo(SmartIntegrationDevicesAdapter var0, IotDeviceConfig var1, View var2) {
      onBindViewHolder$lambda$0(var0, var1, var2);
   }

   public SmartIntegrationDevicesAdapter(PublishSubject var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "deviceClickPublisher");
      super();
      this.deviceClickPublisher = var1;
      this.useG4Protect = var2;
      this.devices = CollectionsKt.emptyList();
   }

   private static final void onBindViewHolder$lambda$0(SmartIntegrationDevicesAdapter var0, IotDeviceConfig var1, View var2) {
      var0.deviceClickPublisher.onNext(var1.getLink());
   }

   public final List getDevices() {
      return this.devices;
   }

   public int getItemCount() {
      return this.devices.size();
   }

   public void onBindViewHolder(SmartIntegrationDeviceHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      IotDeviceConfig var5 = (IotDeviceConfig)this.devices.get(var2);
      var2 = var5.getNameRes();
      int var3 = var5.getImageRes();
      boolean var4;
      if (this.useG4Protect && var5.getNameRes() == R.string.blueair_g4) {
         var4 = true;
      } else {
         var4 = false;
      }

      var1.update(var2, var3, var4);
      var1.getBinding().clickview.setOnClickListener(new SmartIntegrationDevicesAdapter$$ExternalSyntheticLambda0(this, var5));
   }

   public SmartIntegrationDeviceHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return SmartIntegrationDeviceHolder.Companion.newInstance(var1);
   }

   public final void setDevices(List var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.devices = var1;
      this.notifyDataSetChanged();
   }
}
