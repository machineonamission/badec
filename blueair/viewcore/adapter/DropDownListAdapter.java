package com.blueair.viewcore.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.viewcore.viewholder.DropDownItemHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\nH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001d"},
   d2 = {"Lcom/blueair/viewcore/adapter/DropDownListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/viewcore/viewholder/DropDownItemHolder;", "headFirstItem", "", "items", "", "", "onItemSelectedListener", "Lkotlin/Function2;", "", "", "<init>", "(ZLjava/util/List;Lkotlin/jvm/functions/Function2;)V", "getHeadFirstItem", "()Z", "value", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DropDownListAdapter extends RecyclerView.Adapter {
   private final boolean headFirstItem;
   private List items;
   private final Function2 onItemSelectedListener;

   // $FF: synthetic method
   public static void $r8$lambda$nk1C2m7sp2otJfRquCrb9uQlzUc(DropDownListAdapter var0, DropDownItemHolder var1, int var2, View var3) {
      onBindViewHolder$lambda$1$lambda$0(var0, var1, var2, var3);
   }

   public DropDownListAdapter(boolean var1, List var2, Function2 var3) {
      Intrinsics.checkNotNullParameter(var2, "items");
      Intrinsics.checkNotNullParameter(var3, "onItemSelectedListener");
      super();
      this.headFirstItem = var1;
      this.onItemSelectedListener = var3;
      this.items = var2;
   }

   private static final void onBindViewHolder$lambda$1$lambda$0(DropDownListAdapter var0, DropDownItemHolder var1, int var2, View var3) {
      var0.onItemSelectedListener.invoke(var1.getBindingAdapterPosition(), var0.items.get(var2));
   }

   public final boolean getHeadFirstItem() {
      return this.headFirstItem;
   }

   public int getItemCount() {
      return this.items.size();
   }

   public final List getItems() {
      return this.items;
   }

   public void onBindViewHolder(DropDownItemHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      TextView var4 = var1.getBinding().text;
      var4.setText((CharSequence)this.items.get(var2));
      if (this.headFirstItem) {
         float var3;
         if (var2 == 0) {
            var3 = 16.0F;
         } else {
            var3 = 14.0F;
         }

         var4.setTextSize(2, var3);
      }

      var4.setOnClickListener(new DropDownListAdapter$$ExternalSyntheticLambda0(this, var1, var2));
   }

   public DropDownItemHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return DropDownItemHolder.Companion.newInstance(var1);
   }

   public final void setItems(List var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      if (!Intrinsics.areEqual(this.items, var1)) {
         this.items = var1;
         this.notifyDataSetChanged();
      }
   }
}
