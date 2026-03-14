package com.blueair.outdoor.ui.adapters;

import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.databinding.HolderSearchSavedLocationBinding;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J;\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\r0\u0013H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"},
   d2 = {"Lcom/blueair/outdoor/ui/adapters/SavedLocationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/outdoor/databinding/HolderSearchSavedLocationBinding;", "<init>", "(Lcom/blueair/outdoor/databinding/HolderSearchSavedLocationBinding;)V", "getBinding", "()Lcom/blueair/outdoor/databinding/HolderSearchSavedLocationBinding;", "primary", "Landroid/widget/TextView;", "getPrimary", "()Landroid/widget/TextView;", "bind", "", "location", "Lcom/blueair/core/model/TrackedLocation;", "isCurrentLocation", "", "onSavedLocationClicked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Companion", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
final class SavedLocationViewHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderSearchSavedLocationBinding binding;
   private final TextView primary;

   // $FF: synthetic method
   public static void $r8$lambda$G0IGNfq_cu7YHVn0clOHq4oPCwo(Function1 var0, TrackedLocation var1, View var2) {
      bind$lambda$1(var0, var1, var2);
   }

   public SavedLocationViewHolder(HolderSearchSavedLocationBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super((View)var1.getRoot());
      this.binding = var1;
      TextView var2 = var1.primaryText;
      Intrinsics.checkNotNullExpressionValue(var2, "primaryText");
      this.primary = var2;
   }

   private static final void bind$lambda$1(Function1 var0, TrackedLocation var1, View var2) {
      var0.invoke(var1);
   }

   public final void bind(TrackedLocation var1, boolean var2, Function1 var3) {
      Intrinsics.checkNotNullParameter(var1, "location");
      Intrinsics.checkNotNullParameter(var3, "onSavedLocationClicked");
      TextView var8 = this.primary;
      StringBuilder var7 = new StringBuilder();
      var7.append(var1.getLocationName());
      var7.append(" - ");
      String var6 = var1.getCityName();
      String var5 = var6;
      if (var6 == null) {
         var6 = var1.getCountryName();
         var5 = var6;
         if (var6 == null) {
            var5 = "";
         }
      }

      int var4;
      label26: {
         var7.append(var5);
         var8.setText((CharSequence)var7.toString());
         var4 = (int)TypedValue.applyDimension(1, 24.0F, this.itemView.getResources().getDisplayMetrics());
         if (var2) {
            Drawable var9 = ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.ic_gps);
            if (var9 != null) {
               var10 = var9.mutate();
               if (var10 != null) {
                  var10.setTint(ContextCompat.getColor(this.itemView.getContext(), R.color.marineblue));
                  break label26;
               }
            }
         } else {
            Drawable var11 = ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.ic_location_marker_selected);
            if (var11 != null) {
               var10 = var11.mutate();
               break label26;
            }
         }

         var10 = null;
      }

      if (var10 != null) {
         var10.setBounds(0, 0, var4, var4);
      }

      this.primary.setCompoundDrawables(var10, (Drawable)null, (Drawable)null, (Drawable)null);
      this.itemView.setOnClickListener(new SavedLocationViewHolder$$ExternalSyntheticLambda0(var3, var1));
   }

   public final HolderSearchSavedLocationBinding getBinding() {
      return this.binding;
   }

   public final TextView getPrimary() {
      return this.primary;
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/outdoor/ui/adapters/SavedLocationViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/outdoor/ui/adapters/SavedLocationViewHolder;", "parent", "Landroid/view/ViewGroup;", "outdoor_otherRelease"},
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

      public final SavedLocationViewHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parent");
         HolderSearchSavedLocationBinding var2 = HolderSearchSavedLocationBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new SavedLocationViewHolder(var2);
      }
   }
}
