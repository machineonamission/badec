package com.blueair.adddevice.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.adddevice.viewholder.CommonDeviceNameHolder;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rH\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\rH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR(\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001c"},
   d2 = {"Lcom/blueair/adddevice/adapter/CommonDeviceNameAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/adddevice/viewholder/CommonDeviceNameHolder;", "selectNamePublisher", "Lio/reactivex/subjects/PublishSubject;", "", "commonNames", "", "<init>", "(Lio/reactivex/subjects/PublishSubject;Ljava/util/List;)V", "getCommonNames", "()Ljava/util/List;", "getItemCount", "", "value", "selectedName", "getSelectedName", "()Ljava/lang/String;", "setSelectedName", "(Ljava/lang/String;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class CommonDeviceNameAdapter extends RecyclerView.Adapter {
   private final List commonNames;
   private final PublishSubject selectNamePublisher;
   private String selectedName;

   // $FF: synthetic method
   public static void $r8$lambda$OuaXZ6Ue576zJ5eKxojZqWUPTTA(CommonDeviceNameAdapter var0, String var1, CommonDeviceNameHolder var2, View var3) {
      onBindViewHolder$lambda$0(var0, var1, var2, var3);
   }

   public CommonDeviceNameAdapter(PublishSubject var1, List var2) {
      Intrinsics.checkNotNullParameter(var1, "selectNamePublisher");
      Intrinsics.checkNotNullParameter(var2, "commonNames");
      super();
      this.selectNamePublisher = var1;
      this.commonNames = var2;
   }

   private static final void onBindViewHolder$lambda$0(CommonDeviceNameAdapter var0, String var1, CommonDeviceNameHolder var2, View var3) {
      var0.selectNamePublisher.onNext(var1);
      var2.selectionUpdate(true);
   }

   public final List getCommonNames() {
      return this.commonNames;
   }

   public int getItemCount() {
      return this.commonNames.size();
   }

   public final String getSelectedName() {
      return this.selectedName;
   }

   public void onBindViewHolder(CommonDeviceNameHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      String var3 = (String)this.commonNames.get(var2);
      var1.update(var3, Intrinsics.areEqual(var3, this.selectedName));
      var1.getRadioButton().setOnClickListener(new CommonDeviceNameAdapter$$ExternalSyntheticLambda0(this, var3, var1));
   }

   public CommonDeviceNameHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return CommonDeviceNameHolder.Companion.newInstance(var1);
   }

   public final void setSelectedName(String var1) {
      if (!Intrinsics.areEqual(this.selectedName, var1)) {
         this.selectedName = var1;
         this.notifyDataSetChanged();
      }

   }
}
