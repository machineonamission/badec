package com.blueair.outdoor.ui.adapters;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\f¢\u0006\u0004\b\u0004\u0010\rJ\b\u0010\u0012\u001a\u00020\fH\u0016R\u001a\u0010\u000e\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"},
   d2 = {"Lcom/blueair/outdoor/ui/adapters/LocationLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "", "(Landroid/content/Context;IZ)V", "isScrollingEnabled", "()Z", "setScrollingEnabled", "(Z)V", "canScrollHorizontally", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LocationLinearLayoutManager extends LinearLayoutManager {
   private boolean isScrollingEnabled;

   public LocationLinearLayoutManager(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1);
      this.isScrollingEnabled = true;
   }

   public LocationLinearLayoutManager(Context var1, int var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
      this.isScrollingEnabled = true;
   }

   public LocationLinearLayoutManager(Context var1, AttributeSet var2, int var3, int var4) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2, var3, var4);
      this.isScrollingEnabled = true;
   }

   public boolean canScrollHorizontally() {
      return this.isScrollingEnabled && super.canScrollHorizontally();
   }

   public final boolean isScrollingEnabled() {
      return this.isScrollingEnabled;
   }

   public final void setScrollingEnabled(boolean var1) {
      this.isScrollingEnabled = var1;
   }
}
