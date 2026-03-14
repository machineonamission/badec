package com.blueair.outdoor.ui.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.HasLocation;
import com.blueair.outdoor.databinding.HolderAssignDeviceBinding;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00070\rJ\b\u0010\u001c\u001a\u00020\u001aH\u0002J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR6\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"},
   d2 = {"Lcom/blueair/outdoor/ui/adapters/DeviceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/outdoor/ui/adapters/DeviceViewHolder;", "<init>", "()V", "_selectionModified", "Landroidx/lifecycle/MutableLiveData;", "", "selectionModified", "Landroidx/lifecycle/LiveData;", "getSelectionModified", "()Landroidx/lifecycle/LiveData;", "value", "", "", "originalSelections", "getOriginalSelections", "()Ljava/util/Map;", "_selections", "", "selections", "getSelections", "devices", "", "Lcom/blueair/core/model/HasLocation;", "setData", "", "data", "checkSelectionModified", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceAdapter extends RecyclerView.Adapter {
   private final MutableLiveData _selectionModified;
   private final Map _selections;
   private List devices;
   private Map originalSelections;
   private final LiveData selectionModified;
   private final Map selections;

   // $FF: synthetic method
   public static void $r8$lambda$WhQN3XGfSfmVqcoPaXTKdIn2Mg4(DeviceAdapter var0, HasLocation var1, HolderAssignDeviceBinding var2, View var3) {
      onBindViewHolder$lambda$4$lambda$3(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$dkv_MxJViwtDO75ikB5g2Pk6omU/* $FF was: $r8$lambda$dkv-MxJViwtDO75ikB5g2Pk6omU*/(HolderAssignDeviceBinding var0, DeviceAdapter var1, HasLocation var2, View var3) {
      onBindViewHolder$lambda$4$lambda$2(var0, var1, var2, var3);
   }

   public DeviceAdapter() {
      MutableLiveData var1 = new MutableLiveData(false);
      this._selectionModified = var1;
      this.selectionModified = Transformations.distinctUntilChanged((LiveData)var1);
      this.originalSelections = MapsKt.emptyMap();
      Map var2 = (Map)(new LinkedHashMap());
      this._selections = var2;
      this.selections = var2;
      this.devices = CollectionsKt.emptyList();
   }

   private final void checkSelectionModified() {
      MutableLiveData var3 = this._selectionModified;
      Map var4 = this._selections;
      boolean var1 = var4.isEmpty();
      boolean var2 = false;
      if (var1) {
         var1 = var2;
      } else {
         Iterator var5 = var4.entrySet().iterator();

         while(true) {
            var1 = var2;
            if (!var5.hasNext()) {
               break;
            }

            Map.Entry var7 = (Map.Entry)var5.next();
            if (!Intrinsics.areEqual(var7.getValue(), this.originalSelections.get(var7.getKey()))) {
               var1 = true;
               break;
            }
         }
      }

      var3.setValue(var1);
   }

   private static final void onBindViewHolder$lambda$4$lambda$2(HolderAssignDeviceBinding var0, DeviceAdapter var1, HasLocation var2, View var3) {
      var0.checkBox.setChecked(var0.checkBox.isChecked() ^ true);
      var1._selections.put(var2.getUid(), var0.checkBox.isChecked());
      var1.checkSelectionModified();
   }

   private static final void onBindViewHolder$lambda$4$lambda$3(DeviceAdapter var0, HasLocation var1, HolderAssignDeviceBinding var2, View var3) {
      var0._selections.put(var1.getUid(), var2.checkBox.isChecked());
      var0.checkSelectionModified();
   }

   public int getItemCount() {
      return this.devices.size();
   }

   public final Map getOriginalSelections() {
      return this.originalSelections;
   }

   public final LiveData getSelectionModified() {
      return this.selectionModified;
   }

   public final Map getSelections() {
      return this.selections;
   }

   public void onBindViewHolder(DeviceViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      HasLocation var4 = (HasLocation)this.devices.get(var2);
      HolderAssignDeviceBinding var5 = var1.getBinding();
      var5.deviceName.setText((CharSequence)var4.getName());
      CheckBox var6 = var5.checkBox;
      Boolean var7 = (Boolean)this._selections.get(var4.getUid());
      boolean var3;
      if (var7 != null) {
         var3 = var7;
      } else {
         var3 = false;
      }

      var6.setChecked(var3);
      var5.getRoot().setOnClickListener(new DeviceAdapter$$ExternalSyntheticLambda0(var5, this, var4));
      var5.checkBox.setOnClickListener(new DeviceAdapter$$ExternalSyntheticLambda1(this, var4, var5));
   }

   public DeviceViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return DeviceViewHolder.Companion.newInstance(var1);
   }

   public final void setData(Map var1) {
      Intrinsics.checkNotNullParameter(var1, "data");
      Map var3 = (Map)(new LinkedHashMap(MapsKt.mapCapacity(var1.size())));

      for(Map.Entry var4 : (Iterable)var1.entrySet()) {
         var3.put(((HasLocation)var4.getKey()).getUid(), var4.getValue());
      }

      this.originalSelections = var3;
      this._selections.clear();
      this._selections.putAll(this.originalSelections);
      this.devices = CollectionsKt.toList((Iterable)var1.keySet());
      this._selectionModified.setValue(false);
      this.notifyDataSetChanged();
   }
}
