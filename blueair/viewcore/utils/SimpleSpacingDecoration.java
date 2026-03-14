package com.blueair.viewcore.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001'B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003J(\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J(\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0003H\u0002J0\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002J\u0010\u0010&\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("},
   d2 = {"Lcom/blueair/viewcore/utils/SimpleSpacingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "horizontalSpacing", "", "verticalSpacing", "includeEdge", "", "<init>", "(IIZ)V", "excludeCallback", "Lcom/blueair/viewcore/utils/SimpleSpacingDecoration$ExcludeCallback;", "topEdgeSpacing", "bottomEdgeSpacing", "edgeHorizontalSpacing", "setEdgeSpacing", "", "hSpacing", "vSpacing", "topSpacing", "bottomSpacing", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getLinearItemOffset", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "itemPosition", "contentPos", "getGridItemOffsets", "column", "spanCount", "itemCountWithoutHeader", "setExcludeCallback", "ExcludeCallback", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SimpleSpacingDecoration extends RecyclerView.ItemDecoration {
   private int bottomEdgeSpacing;
   private int edgeHorizontalSpacing;
   private ExcludeCallback excludeCallback;
   private final int horizontalSpacing;
   private boolean includeEdge;
   private int topEdgeSpacing;
   private final int verticalSpacing;

   public SimpleSpacingDecoration(int var1, int var2) {
      this(var1, var2, false, 4, (DefaultConstructorMarker)null);
   }

   public SimpleSpacingDecoration(int var1, int var2, boolean var3) {
      this.horizontalSpacing = var1;
      this.verticalSpacing = var2;
      this.includeEdge = var3;
      if (var3) {
         this.setEdgeSpacing(var1, var2);
      }

   }

   // $FF: synthetic method
   public SimpleSpacingDecoration(int var1, int var2, boolean var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 4) != 0) {
         var3 = false;
      }

      this(var1, var2, var3);
   }

   private final void getGridItemOffsets(Rect var1, int var2, int var3, int var4, int var5) {
      if (this.includeEdge) {
         var1.left = this.horizontalSpacing * (var4 - var3) / var4;
         var1.right = this.horizontalSpacing * (var3 + 1) / var4;
         if (var3 == 0) {
            var1.left = this.edgeHorizontalSpacing;
         }

         if (var3 == var4 - 1) {
            var1.right = this.edgeHorizontalSpacing;
         }

         if (var2 < var4) {
            var1.top = this.topEdgeSpacing;
         }

         int var6 = var5 / var4 * var4;
         var3 = var6;
         if (var5 % var4 == 0) {
            var3 = var6 - var4;
         }

         if (var2 >= var3) {
            var2 = this.bottomEdgeSpacing;
         } else {
            var2 = this.verticalSpacing;
         }

         var1.bottom = var2;
      } else {
         var1.left = this.horizontalSpacing * var3 / var4;
         var1.right = this.horizontalSpacing * (var4 - 1 - var3) / var4;
         if (var2 >= var4) {
            var1.top = this.verticalSpacing;
         }

      }
   }

   private final void getLinearItemOffset(Rect var1, LinearLayoutManager var2, int var3, int var4) {
      int var5 = var2.getOrientation();
      boolean var6 = false;
      if (var5 == 1) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      if (this.includeEdge) {
         if (var4 == 0) {
            if (var5) {
               var1.top = this.topEdgeSpacing;
            } else {
               var1.left = this.edgeHorizontalSpacing;
            }
         }

         var4 = var6;
         if (var3 == var2.getItemCount() - 1) {
            var4 = 1;
         }

         if (var5) {
            if (var4) {
               var3 = this.bottomEdgeSpacing;
            } else {
               var3 = this.verticalSpacing;
            }

            var1.bottom = var3;
         } else {
            if (var4) {
               var3 = this.edgeHorizontalSpacing;
            } else {
               var3 = this.horizontalSpacing;
            }

            var1.right = var3;
         }
      } else {
         if (var4 > 0) {
            if (var5) {
               var1.top = this.verticalSpacing;
               return;
            }

            var1.left = this.horizontalSpacing;
         }

      }
   }

   public void getItemOffsets(Rect var1, View var2, RecyclerView var3, RecyclerView.State var4) {
      Intrinsics.checkNotNullParameter(var1, "outRect");
      Intrinsics.checkNotNullParameter(var2, "view");
      Intrinsics.checkNotNullParameter(var3, "parent");
      Intrinsics.checkNotNullParameter(var4, "state");
      super.getItemOffsets(var1, var2, var3, var4);
      int var7 = var3.getChildAdapterPosition(var2);
      ExcludeCallback var13 = this.excludeCallback;
      if (var13 != null) {
         Intrinsics.checkNotNull(var13);
         if (var13.shouldExclude(var7)) {
            return;
         }
      }

      var13 = this.excludeCallback;
      int var5;
      if (var13 != null) {
         Intrinsics.checkNotNull(var13);
         var5 = var13.getHeaderCount();
      } else {
         var5 = 0;
      }

      int var6 = var7 - var5;
      if (var6 >= 0) {
         RecyclerView.LayoutManager var11 = var3.getLayoutManager();
         if (var11 != null) {
            if (var11 instanceof GridLayoutManager) {
               GridLayoutManager var10 = (GridLayoutManager)var11;
               var7 = var10.getSpanCount();
               this.getGridItemOffsets(var1, var6, var6 % var7, var7, var10.getItemCount() - var5);
               return;
            }

            if (var11 instanceof StaggeredGridLayoutManager) {
               ViewGroup.LayoutParams var8 = var2.getLayoutParams();
               Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
               StaggeredGridLayoutManager.LayoutParams var9 = (StaggeredGridLayoutManager.LayoutParams)var8;
               StaggeredGridLayoutManager var12 = (StaggeredGridLayoutManager)var11;
               var7 = var12.getSpanCount();
               this.getGridItemOffsets(var1, var6, var9.getSpanIndex(), var7, var12.getItemCount() - var5);
               return;
            }

            if (var11 instanceof LinearLayoutManager) {
               this.getLinearItemOffset(var1, (LinearLayoutManager)var11, var7, var6);
            }
         }
      }

   }

   public final void setEdgeSpacing(int var1, int var2) {
      this.setEdgeSpacing(var1, var2, var2);
   }

   public final void setEdgeSpacing(int var1, int var2, int var3) {
      if (var1 != 0 || var2 != 0 || var3 != 0) {
         this.includeEdge = true;
         this.edgeHorizontalSpacing = var1;
         this.topEdgeSpacing = var2;
         this.bottomEdgeSpacing = var3;
      }
   }

   public final void setExcludeCallback(ExcludeCallback var1) {
      this.excludeCallback = var1;
   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\tÀ\u0006\u0003"},
      d2 = {"Lcom/blueair/viewcore/utils/SimpleSpacingDecoration$ExcludeCallback;", "", "headerCount", "", "getHeaderCount", "()I", "shouldExclude", "", "position", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public interface ExcludeCallback {
      int getHeaderCount();

      boolean shouldExclude(int var1);
   }
}
