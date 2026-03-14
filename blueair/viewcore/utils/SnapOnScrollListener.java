package com.blueair.viewcore.utils;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.blueair.viewcore.extensions.SnapHelperExtensionsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"},
   d2 = {"Lcom/blueair/viewcore/utils/SnapOnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "snapHelper", "Landroidx/recyclerview/widget/SnapHelper;", "behavior", "Lcom/blueair/viewcore/utils/SnapOnScrollListener$Behavior;", "onSnapPositionChangeListener", "Lcom/blueair/viewcore/utils/SnapOnScrollListener$OnSnapPositionChangeListener;", "<init>", "(Landroidx/recyclerview/widget/SnapHelper;Lcom/blueair/viewcore/utils/SnapOnScrollListener$Behavior;Lcom/blueair/viewcore/utils/SnapOnScrollListener$OnSnapPositionChangeListener;)V", "getBehavior", "()Lcom/blueair/viewcore/utils/SnapOnScrollListener$Behavior;", "setBehavior", "(Lcom/blueair/viewcore/utils/SnapOnScrollListener$Behavior;)V", "getOnSnapPositionChangeListener", "()Lcom/blueair/viewcore/utils/SnapOnScrollListener$OnSnapPositionChangeListener;", "setOnSnapPositionChangeListener", "(Lcom/blueair/viewcore/utils/SnapOnScrollListener$OnSnapPositionChangeListener;)V", "snapPosition", "", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "onScrollStateChanged", "newState", "maybeNotifySnapPositionChange", "OnSnapPositionChangeListener", "Behavior", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SnapOnScrollListener extends RecyclerView.OnScrollListener {
   private Behavior behavior;
   private OnSnapPositionChangeListener onSnapPositionChangeListener;
   private final SnapHelper snapHelper;
   private int snapPosition;

   public SnapOnScrollListener(SnapHelper var1, Behavior var2, OnSnapPositionChangeListener var3) {
      Intrinsics.checkNotNullParameter(var1, "snapHelper");
      Intrinsics.checkNotNullParameter(var2, "behavior");
      super();
      this.snapHelper = var1;
      this.behavior = var2;
      this.onSnapPositionChangeListener = var3;
      this.snapPosition = -1;
   }

   // $FF: synthetic method
   public SnapOnScrollListener(SnapHelper var1, Behavior var2, OnSnapPositionChangeListener var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL;
      }

      if ((var4 & 4) != 0) {
         var3 = null;
      }

      this(var1, var2, var3);
   }

   private final void maybeNotifySnapPositionChange(RecyclerView var1) {
      int var2 = SnapHelperExtensionsKt.getSnapPosition(this.snapHelper, var1);
      if (this.snapPosition != var2) {
         OnSnapPositionChangeListener var3 = this.onSnapPositionChangeListener;
         if (var3 != null) {
            var3.onSnapPositionChange(var2);
         }

         this.snapPosition = var2;
      }

   }

   public final Behavior getBehavior() {
      return this.behavior;
   }

   public final OnSnapPositionChangeListener getOnSnapPositionChangeListener() {
      return this.onSnapPositionChangeListener;
   }

   public void onScrollStateChanged(RecyclerView var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "recyclerView");
      if (this.behavior == SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL_STATE_IDLE && var2 == 0) {
         this.maybeNotifySnapPositionChange(var1);
      }

   }

   public void onScrolled(RecyclerView var1, int var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "recyclerView");
      if (this.behavior == SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL) {
         this.maybeNotifySnapPositionChange(var1);
      }

   }

   public final void setBehavior(Behavior var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.behavior = var1;
   }

   public final void setOnSnapPositionChangeListener(OnSnapPositionChangeListener var1) {
      this.onSnapPositionChangeListener = var1;
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/viewcore/utils/SnapOnScrollListener$Behavior;", "", "<init>", "(Ljava/lang/String;I)V", "NOTIFY_ON_SCROLL", "NOTIFY_ON_SCROLL_STATE_IDLE", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static enum Behavior {
      private static final EnumEntries $ENTRIES;
      private static final Behavior[] $VALUES;
      NOTIFY_ON_SCROLL,
      NOTIFY_ON_SCROLL_STATE_IDLE;

      // $FF: synthetic method
      private static final Behavior[] $values() {
         return new Behavior[]{NOTIFY_ON_SCROLL, NOTIFY_ON_SCROLL_STATE_IDLE};
      }

      static {
         Behavior[] var0 = $values();
         $VALUES = var0;
         $ENTRIES = EnumEntriesKt.enumEntries(var0);
      }

      public static EnumEntries getEntries() {
         return $ENTRIES;
      }
   }

   @Metadata(
      d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"},
      d2 = {"Lcom/blueair/viewcore/utils/SnapOnScrollListener$OnSnapPositionChangeListener;", "", "onSnapPositionChange", "", "position", "", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public interface OnSnapPositionChangeListener {
      void onSnapPositionChange(int var1);
   }
}
