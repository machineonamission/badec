package com.blueair.outdoor.ui.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B}\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u0010\u0012&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e0\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020/H\u0016J\b\u00106\u001a\u00020/H\u0016J\u0018\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020/H\u0016J\u000e\u0010:\u001a\u00020!2\u0006\u00109\u001a\u00020/J\u0018\u0010;\u001a\u00020\u000e2\u0006\u00109\u001a\u00020/2\u0006\u00108\u001a\u00020\u0002H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u001b\u001a\u0004\u0018\u00010!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R0\u0010'\u001a\b\u0012\u0004\u0012\u00020!0\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020!0\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b-\u0010\u001eR\u0014\u0010.\u001a\u00020/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u0006<"},
   d2 = {"Lcom/blueair/outdoor/ui/adapters/LocationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "mapType", "", "shouldShowAssignProduct", "", "isSaveEnabled", "onSaveClicked", "Lkotlin/Function2;", "Lcom/blueair/core/model/TrackedLocation;", "Lcom/blueair/core/model/AqiData;", "", "onDeleteClicked", "Lkotlin/Function1;", "onAssignClicked", "Lkotlin/Function3;", "", "Lcom/blueair/core/model/Device;", "<init>", "(Landroid/content/Context;Ljava/lang/String;ZZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "getContext", "()Landroid/content/Context;", "getMapType", "()Ljava/lang/String;", "value", "showAssignProduct", "getShowAssignProduct", "()Z", "setShowAssignProduct", "(Z)V", "Lcom/blueair/outdoor/ui/adapters/LocationItem;", "mergedCurrentLocation", "getMergedCurrentLocation", "()Lcom/blueair/outdoor/ui/adapters/LocationItem;", "setMergedCurrentLocation", "(Lcom/blueair/outdoor/ui/adapters/LocationItem;)V", "mergedData", "getMergedData", "()Ljava/util/List;", "setMergedData", "(Ljava/util/List;)V", "showCurrentLocation", "getShowCurrentLocation", "offset", "", "getOffset", "()I", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "getItem", "adjustWidth", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LocationAdapter extends RecyclerView.Adapter {
   private final Context context;
   private final boolean isSaveEnabled;
   private final String mapType;
   private LocationItem mergedCurrentLocation;
   private List mergedData;
   private final Function3 onAssignClicked;
   private final Function1 onDeleteClicked;
   private final Function2 onSaveClicked;
   private boolean showAssignProduct;

   public LocationAdapter(Context var1, String var2, boolean var3, boolean var4, Function2 var5, Function1 var6, Function3 var7) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "mapType");
      Intrinsics.checkNotNullParameter(var5, "onSaveClicked");
      Intrinsics.checkNotNullParameter(var6, "onDeleteClicked");
      Intrinsics.checkNotNullParameter(var7, "onAssignClicked");
      super();
      this.context = var1;
      this.mapType = var2;
      this.isSaveEnabled = var4;
      this.onSaveClicked = var5;
      this.onDeleteClicked = var6;
      this.onAssignClicked = var7;
      this.showAssignProduct = var3;
      this.mergedData = CollectionsKt.emptyList();
   }

   private final void adjustWidth(int var1, RecyclerView.ViewHolder var2) {
      Resources var8 = this.context.getResources();
      Intrinsics.checkNotNullExpressionValue(var8, "getResources(...)");
      int var3 = (int)TypedValue.applyDimension(1, 20.0F, var8.getDisplayMetrics());
      int var5 = (int)TypedValue.applyDimension(1, 8.0F, var8.getDisplayMetrics());
      int var7 = (int)TypedValue.applyDimension(1, 32.0F, var8.getDisplayMetrics());
      int var6 = var8.getDisplayMetrics().widthPixels;
      if (var1 == 0) {
         byte var4 = 0;
         var1 = var3;
         var3 = var4;
      } else if ((this.getShowCurrentLocation() || var1 != ((Collection)this.mergedData).size() - 1) && (!this.getShowCurrentLocation() || var1 != ((Collection)this.mergedData).size())) {
         var3 = 0;
         var1 = 0;
      } else {
         var1 = 0;
      }

      ConstraintLayout.LayoutParams var10 = new ConstraintLayout.LayoutParams(var6 - var5 * 2 - var7, -1);
      var10.setMargins(var1 + var5, 0, var5 + var3, 0);
      var2.itemView.setLayoutParams((ViewGroup.LayoutParams)var10);
   }

   private final int getOffset() {
      return this.getShowCurrentLocation();
   }

   public final Context getContext() {
      return this.context;
   }

   public final LocationItem getItem(int var1) {
      LocationItem var2 = this.mergedCurrentLocation;
      return var1 == 0 && var2 != null ? var2 : (LocationItem)this.mergedData.get(var1 - this.getOffset());
   }

   public int getItemCount() {
      return ((Collection)this.mergedData).size() + this.getOffset();
   }

   public final String getMapType() {
      return this.mapType;
   }

   public final LocationItem getMergedCurrentLocation() {
      return this.mergedCurrentLocation;
   }

   public final List getMergedData() {
      return this.mergedData;
   }

   public final boolean getShowAssignProduct() {
      return this.showAssignProduct;
   }

   public final boolean getShowCurrentLocation() {
      return this.mergedCurrentLocation != null;
   }

   public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      this.adjustWidth(var2, var1);
      if (var1 instanceof LocationViewHolder) {
         LocationItem var3 = this.getItem(var2);
         if (var2 == 0 && this.getShowCurrentLocation()) {
            ((LocationViewHolder)var1).bind(var3, this.mapType, LocationView.TYPE.CURRENT_LOCATION, this.showAssignProduct, this.isSaveEnabled, this.onSaveClicked, this.onDeleteClicked, this.onAssignClicked);
            return;
         }

         ((LocationViewHolder)var1).bind(var3, this.mapType, LocationView.TYPE.SAVED_LOCATION, this.showAssignProduct, this.isSaveEnabled, this.onSaveClicked, this.onDeleteClicked, this.onAssignClicked);
      }

   }

   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return LocationViewHolder.Companion.newInstance(var1);
   }

   public final void setMergedCurrentLocation(LocationItem var1) {
      this.mergedCurrentLocation = var1;
      this.notifyDataSetChanged();
   }

   public final void setMergedData(List var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.mergedData = var1;
      this.notifyDataSetChanged();
   }

   public final void setShowAssignProduct(boolean var1) {
      if (this.showAssignProduct != var1) {
         this.showAssignProduct = var1;
         this.notifyDataSetChanged();
      }
   }
}
