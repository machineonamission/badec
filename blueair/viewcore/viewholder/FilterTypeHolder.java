package com.blueair.viewcore.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.FilterInfo;
import com.blueair.viewcore.R;
import com.blueair.viewcore.databinding.HolderFilterTypeBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JP\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"},
   d2 = {"Lcom/blueair/viewcore/viewholder/FilterTypeHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/viewcore/databinding/HolderFilterTypeBinding;", "<init>", "(Lcom/blueair/viewcore/databinding/HolderFilterTypeBinding;)V", "getBinding", "()Lcom/blueair/viewcore/databinding/HolderFilterTypeBinding;", "update", "", "filter", "Lcom/blueair/core/model/FilterInfo;", "selected", "", "position", "", "onFilterInfoClickListener", "Lkotlin/Function1;", "onFilterSelectedListener", "Lkotlin/Function2;", "Companion", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FilterTypeHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderFilterTypeBinding binding;

   // $FF: synthetic method
   public static void $r8$lambda$RjBe9tdgHpIo54BsdkA1MrLI_H0(Function1 var0, FilterInfo var1, View var2) {
      update$lambda$4$lambda$3$lambda$2(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Y99dyuXv805Su3YIScun_9hpeYI/* $FF was: $r8$lambda$Y99dyuXv805Su3YIScun-9hpeYI*/(Function2 var0, int var1, FilterInfo var2, View var3) {
      update$lambda$4$lambda$1$lambda$0(var0, var1, var2, var3);
   }

   public FilterTypeHolder(HolderFilterTypeBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super(var1.getRoot());
      this.binding = var1;
   }

   private static final void update$lambda$4$lambda$1$lambda$0(Function2 var0, int var1, FilterInfo var2, View var3) {
      var0.invoke(var1, var2);
   }

   private static final void update$lambda$4$lambda$3$lambda$2(Function1 var0, FilterInfo var1, View var2) {
      var0.invoke(var1);
   }

   public final HolderFilterTypeBinding getBinding() {
      return this.binding;
   }

   public final void update(FilterInfo var1, boolean var2, int var3, Function1 var4, Function2 var5) {
      Intrinsics.checkNotNullParameter(var1, "filter");
      HolderFilterTypeBinding var6 = this.binding;
      var6.icon.setImageResource(var1.getImage());
      var6.name.setText((CharSequence)var1.getName().getValue());
      var6.flIcon.setSelected(var2);
      if (var5 != null) {
         var6.flIcon.setOnClickListener(new FilterTypeHolder$$ExternalSyntheticLambda0(var5, var3, var1));
      }

      if (var4 != null) {
         var6.ivInfo.setOnClickListener(new FilterTypeHolder$$ExternalSyntheticLambda1(var4, var1));
      }

      var6.ivInfo.setContentDescription((CharSequence)var6.getRoot().getContext().getString(R.string.more_info_about, new Object[]{var6.name.getText()}));
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/viewcore/viewholder/FilterTypeHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/viewcore/viewholder/FilterTypeHolder;", "parentView", "Landroid/view/ViewGroup;", "viewcore_otherRelease"},
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

      public final FilterTypeHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderFilterTypeBinding var2 = HolderFilterTypeBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new FilterTypeHolder(var2);
      }
   }
}
