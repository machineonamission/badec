package com.blueair.adddevice.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.auth.LocationService;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"},
   d2 = {"Lcom/blueair/adddevice/adapter/SelectDeviceModelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/adddevice/adapter/DeviceModelViewholder;", "locationService", "Lcom/blueair/auth/LocationService;", "deviceSelectedPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/adddevice/adapter/DeviceModel;", "<init>", "(Lcom/blueair/auth/LocationService;Lio/reactivex/subjects/PublishSubject;)V", "defaultModelList", "", "getDefaultModelList", "()Ljava/util/List;", "value", "", "deviceList", "getDeviceList", "setDeviceList", "(Ljava/util/List;)V", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SelectDeviceModelAdapter extends RecyclerView.Adapter {
   private final List defaultModelList;
   private List deviceList;
   private final PublishSubject deviceSelectedPublisher;
   private final LocationService locationService;

   // $FF: synthetic method
   public static void $r8$lambda$EKUNRKFOmexg3yPS4ScvZSuyX00(SelectDeviceModelAdapter var0, DeviceModel var1, View var2) {
      onBindViewHolder$lambda$1(var0, var1, var2);
   }

   public SelectDeviceModelAdapter(LocationService var1, PublishSubject var2) {
      Intrinsics.checkNotNullParameter(var1, "locationService");
      Intrinsics.checkNotNullParameter(var2, "deviceSelectedPublisher");
      super();
      this.locationService = var1;
      this.deviceSelectedPublisher = var2;
      List var3 = CollectionsKt.mutableListOf(new DeviceModel[]{DeviceModel.CLASSIC, DeviceModel.SENSE});
      if (var1.isInAwareRegion()) {
         var3.add(DeviceModel.AWARE);
      }

      if (var1.isInIcpRegion()) {
         var3.add(DeviceModel.ICP);
      }

      this.defaultModelList = var3;
      this.deviceList = var3;
   }

   private static final void onBindViewHolder$lambda$1(SelectDeviceModelAdapter var0, DeviceModel var1, View var2) {
      var0.deviceSelectedPublisher.onNext(var1);
   }

   public final List getDefaultModelList() {
      return this.defaultModelList;
   }

   public final List getDeviceList() {
      return this.deviceList;
   }

   public int getItemCount() {
      return this.deviceList.size();
   }

   public void onBindViewHolder(DeviceModelViewholder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      DeviceModel var3 = (DeviceModel)this.deviceList.get(var2);
      var1.update(var3);
      var1.getClickView().setOnClickListener(new SelectDeviceModelAdapter$$ExternalSyntheticLambda0(this, var3));
   }

   public DeviceModelViewholder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return DeviceModelViewholder.Companion.newInstance(var1);
   }

   public final void setDeviceList(List var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      if (!Intrinsics.areEqual(var1, this.deviceList)) {
         this.deviceList = var1;
         this.notifyDataSetChanged();
      }
   }
}
