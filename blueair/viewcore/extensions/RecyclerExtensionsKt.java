package com.blueair.viewcore.extensions;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.blueair.viewcore.utils.SnapOnScrollListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"},
   d2 = {"attachSnapHelperWithListener", "", "Landroidx/recyclerview/widget/RecyclerView;", "snapHelper", "Landroidx/recyclerview/widget/SnapHelper;", "behavior", "Lcom/blueair/viewcore/utils/SnapOnScrollListener$Behavior;", "onSnapPositionChangeListener", "Lcom/blueair/viewcore/utils/SnapOnScrollListener$OnSnapPositionChangeListener;", "viewcore_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class RecyclerExtensionsKt {
   public static final void attachSnapHelperWithListener(RecyclerView var0, SnapHelper var1, SnapOnScrollListener.Behavior var2, SnapOnScrollListener.OnSnapPositionChangeListener var3) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "snapHelper");
      Intrinsics.checkNotNullParameter(var2, "behavior");
      Intrinsics.checkNotNullParameter(var3, "onSnapPositionChangeListener");
      var1.attachToRecyclerView(var0);
      var0.addOnScrollListener(new SnapOnScrollListener(var1, var2, var3));
   }

   // $FF: synthetic method
   public static void attachSnapHelperWithListener$default(RecyclerView var0, SnapHelper var1, SnapOnScrollListener.Behavior var2, SnapOnScrollListener.OnSnapPositionChangeListener var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL;
      }

      attachSnapHelperWithListener(var0, var1, var2, var3);
   }
}
