package com.blueair.viewcore.utils;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J,\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010R\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0006\u0010\u0017\u001a\u00020\u000eJ\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"},
   d2 = {"Lcom/blueair/viewcore/utils/CustomStackLayoutManager;", "Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;", "cardStackView", "Lcom/yuyakaido/android/cardstackview/CardStackView;", "stackListener", "Lcom/yuyakaido/android/cardstackview/CardStackListener;", "autoMeause", "", "<init>", "(Lcom/yuyakaido/android/cardstackview/CardStackView;Lcom/yuyakaido/android/cardstackview/CardStackListener;Z)V", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "isAutoMeasureEnabled", "onMeasure", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "widthSpec", "", "heightSpec", "setSizeFromTopView", "setSizeFromChild", "topView", "Landroid/view/View;", "width", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class CustomStackLayoutManager extends CardStackLayoutManager {
   private final boolean autoMeause;
   private final CardStackView cardStackView;

   public CustomStackLayoutManager(CardStackView var1, CardStackListener var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "cardStackView");
      Intrinsics.checkNotNullParameter(var2, "stackListener");
      super(var1.getContext(), var2);
      this.cardStackView = var1;
      this.autoMeause = var3;
   }

   // $FF: synthetic method
   public CustomStackLayoutManager(CardStackView var1, CardStackListener var2, boolean var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 4) != 0) {
         var3 = true;
      }

      this(var1, var2, var3);
   }

   private final void setSizeFromChild(View var1, int var2) {
      if (this.autoMeause) {
         CardStackView var5 = this.cardStackView;
         int var3 = 0;
         RecyclerView.ViewHolder var6 = var5.findViewHolderForAdapterPosition(0);
         View var8 = var1;
         if (var6 != null) {
            var8 = var6.itemView;
            if (var8 == null) {
               var8 = var1;
            }
         }

         int var4 = this.getPaddingTop() + this.getPaddingBottom();
         if (this.getItemCount() > 0) {
            var8.measure(CardStackLayoutManager.getChildMeasureSpec(var2, this.getWidthMode(), this.getPaddingLeft() + this.getPaddingRight(), var8.getLayoutParams().width, true), CardStackLayoutManager.getChildMeasureSpec(this.getHeight(), this.getHeightMode(), var4, var8.getLayoutParams().height, true));
            var3 = var8.getMeasuredHeight() + var4;
         }

         ViewGroup.LayoutParams var7 = this.cardStackView.getLayoutParams();
         var7.height = var3;
         this.cardStackView.setLayoutParams(var7);
      }
   }

   public RecyclerView.LayoutParams generateDefaultLayoutParams() {
      return new RecyclerView.LayoutParams(-1, -2);
   }

   public boolean isAutoMeasureEnabled() {
      return this.autoMeause;
   }

   public void onMeasure(RecyclerView.Recycler var1, RecyclerView.State var2, int var3, int var4) {
      Intrinsics.checkNotNullParameter(var1, "recycler");
      Intrinsics.checkNotNullParameter(var2, "state");
      View var5 = this.getTopView();
      if (var5 != null && !this.autoMeause) {
         this.setSizeFromChild(var5, CardStackLayoutManager.chooseSize(var3, this.getPaddingLeft() + this.getPaddingRight(), ViewCompat.getMinimumWidth((View)this.cardStackView)));
      } else {
         super.onMeasure(var1, var2, var3, var4);
      }
   }

   public final void setSizeFromTopView() {
      View var1 = this.getTopView();
      if (var1 != null) {
         this.setSizeFromChild(var1, this.getWidth());
      }

   }
}
