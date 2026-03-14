package com.blueair.outdoor.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0084\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00162&\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00070\u0018¨\u0006\u001c"},
   d2 = {"Lcom/blueair/outdoor/ui/adapters/LocationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Lcom/blueair/outdoor/ui/adapters/LocationView;", "<init>", "(Lcom/blueair/outdoor/ui/adapters/LocationView;)V", "bind", "", "locationData", "Lcom/blueair/outdoor/ui/adapters/LocationItem;", "mapType", "", "type", "Lcom/blueair/outdoor/ui/adapters/LocationView$TYPE;", "showAssignProduct", "", "isSaveEnabled", "onSaveClicked", "Lkotlin/Function2;", "Lcom/blueair/core/model/TrackedLocation;", "Lcom/blueair/core/model/AqiData;", "onDeleteClicked", "Lkotlin/Function1;", "onAssignClicked", "Lkotlin/Function3;", "", "Lcom/blueair/core/model/Device;", "Companion", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LocationViewHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   public LocationViewHolder(LocationView var1) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super((View)var1);
   }

   public final void bind(LocationItem var1, String var2, LocationView.TYPE var3, boolean var4, boolean var5, Function2 var6, Function1 var7, Function3 var8) {
      Intrinsics.checkNotNullParameter(var1, "locationData");
      Intrinsics.checkNotNullParameter(var2, "mapType");
      Intrinsics.checkNotNullParameter(var3, "type");
      Intrinsics.checkNotNullParameter(var6, "onSaveClicked");
      Intrinsics.checkNotNullParameter(var7, "onDeleteClicked");
      Intrinsics.checkNotNullParameter(var8, "onAssignClicked");
      View var9 = this.itemView;
      Intrinsics.checkNotNull(var9, "null cannot be cast to non-null type com.blueair.outdoor.ui.adapters.LocationView");
      ((LocationView)var9).bind(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\n"},
      d2 = {"Lcom/blueair/outdoor/ui/adapters/LocationViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/outdoor/ui/adapters/LocationViewHolder;", "parent", "Landroid/view/ViewGroup;", "createView", "Lcom/blueair/outdoor/ui/adapters/LocationView;", "outdoor_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      private final LocationView createView(ViewGroup var1) {
         Context var3 = var1.getContext();
         Intrinsics.checkNotNullExpressionValue(var3, "getContext(...)");
         LocationView var4 = new LocationView(var3);
         FrameLayout var2 = var4.getBinding().progressBar;
         Intrinsics.checkNotNullExpressionValue(var2, "progressBar");
         ViewExtensionsKt.hide((View)var2);
         ConstraintLayout var5 = var4.getBinding().saveContainer;
         Intrinsics.checkNotNullExpressionValue(var5, "saveContainer");
         ViewExtensionsKt.hide((View)var5);
         return var4;
      }

      public final LocationViewHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parent");
         return new LocationViewHolder(this.createView(var1));
      }
   }
}
