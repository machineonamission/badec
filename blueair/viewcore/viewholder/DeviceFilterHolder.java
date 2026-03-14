package com.blueair.viewcore.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.FilterInfo;
import com.blueair.viewcore.R;
import com.blueair.viewcore.databinding.HolderDeviceFilterBinding;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"},
   d2 = {"Lcom/blueair/viewcore/viewholder/DeviceFilterHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/viewcore/databinding/HolderDeviceFilterBinding;", "<init>", "(Lcom/blueair/viewcore/databinding/HolderDeviceFilterBinding;)V", "getBinding", "()Lcom/blueair/viewcore/databinding/HolderDeviceFilterBinding;", "update", "", "filter", "Lcom/blueair/core/model/FilterInfo;", "onFilterSelectedListener", "Lkotlin/Function1;", "Companion", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceFilterHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceFilterBinding binding;

   // $FF: synthetic method
   public static void $r8$lambda$zqp5Z27u_wkhF3DvLwdgJeTi7Yk(Function1 var0, FilterInfo var1, View var2) {
      update$lambda$1$lambda$0(var0, var1, var2);
   }

   public DeviceFilterHolder(HolderDeviceFilterBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super(var1.getRoot());
      this.binding = var1;
   }

   private static final void update$lambda$1$lambda$0(Function1 var0, FilterInfo var1, View var2) {
      if (var0 != null) {
         var0.invoke(var1);
      }

   }

   public final HolderDeviceFilterBinding getBinding() {
      return this.binding;
   }

   public final void update(FilterInfo var1, Function1 var2) {
      Intrinsics.checkNotNullParameter(var1, "filter");
      HolderDeviceFilterBinding var6 = this.binding;
      var6.icon.setImageResource(var1.getImage());
      TextView var7 = var6.name;
      String var5 = var1.getName().getValue();
      if (var5 == null) {
         var5 = "";
      }

      var7.setText((CharSequence)var5);
      MaterialButton var12 = var6.btnSelect;
      DeviceFilterType var9 = var1.getType();
      int var3 = DeviceFilterHolder.WhenMappings.$EnumSwitchMapping$0[var9.ordinal()];
      boolean var4 = true;
      if (var3 == 1) {
         var3 = R.string.select_wick;
      } else {
         var3 = R.string.select_filter;
      }

      var12.setText(var3);
      MaterialButton var10 = var6.btnSelect;
      Intrinsics.checkNotNullExpressionValue(var10, "btnSelect");
      View var11 = (View)var10;
      if (var2 == null) {
         var4 = false;
      }

      ViewExtensionsKt.show(var11, var4);
      var6.btnSelect.setOnClickListener(new DeviceFilterHolder$$ExternalSyntheticLambda0(var2, var1));
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/viewcore/viewholder/DeviceFilterHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/viewcore/viewholder/DeviceFilterHolder;", "parentView", "Landroid/view/ViewGroup;", "viewcore_otherRelease"},
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

      public final DeviceFilterHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceFilterBinding var2 = HolderDeviceFilterBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceFilterHolder(var2);
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[DeviceFilterType.values().length];

         try {
            var0[DeviceFilterType.WICK.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
