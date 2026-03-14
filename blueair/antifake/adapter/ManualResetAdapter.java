package com.blueair.antifake.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.antifake.databinding.HolderManualResetBinding;
import com.blueair.viewcore.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"},
   d2 = {"Lcom/blueair/antifake/adapter/ManualResetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/antifake/adapter/ManualResetHolder;", "<init>", "()V", "items", "", "Lkotlin/Pair;", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ManualResetAdapter extends RecyclerView.Adapter {
   private final List items;

   public ManualResetAdapter() {
      this.items = CollectionsKt.listOf(new Pair(R.string.manual_reset_filter_instruction, R.raw.anime_manual_reset_filter));
   }

   public int getItemCount() {
      return this.items.size();
   }

   public void onBindViewHolder(ManualResetHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      Pair var3 = (Pair)this.items.get(var2);
      var1.getBinding().contentMessage.setText(((Number)var3.getFirst()).intValue());
      var1.getBinding().animationView.setAnimation(((Number)var3.getSecond()).intValue());
      var1.getBinding().animationView.playAnimation();
   }

   public ManualResetHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      HolderManualResetBinding var3 = HolderManualResetBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      return new ManualResetHolder(var3);
   }
}
