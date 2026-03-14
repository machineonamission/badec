package com.blueair.android.util;

import android.content.Context;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u001a\u0010\f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0018"},
   d2 = {"Lcom/blueair/android/util/SimpleScrollingPagerIndicator;", "Lru/tinkoff/scrollingpagerindicator/ScrollingPagerIndicator;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentPostion", "getCurrentPostion", "()I", "setCurrentPostion", "(I)V", "setCurrentPosition", "", "position", "onPageScrolled", "page", "offset", "", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SimpleScrollingPagerIndicator extends ScrollingPagerIndicator {
   public static final int $stable = 8;
   private int currentPostion;

   public SimpleScrollingPagerIndicator(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1);
   }

   public SimpleScrollingPagerIndicator(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2);
   }

   public SimpleScrollingPagerIndicator(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2, var3);
   }

   public final int getCurrentPostion() {
      return this.currentPostion;
   }

   public void onPageScrolled(int var1, float var2) {
      super.onPageScrolled(var1, var2);
      if ((double)var2 > (double)0.5F && var1 < this.getVisibleDotCount() - 1) {
         this.currentPostion = var1 + 1;
      } else {
         this.currentPostion = var1;
      }
   }

   public void setCurrentPosition(int var1) {
      super.setCurrentPosition(var1);
      this.currentPostion = var1;
   }

   public final void setCurrentPostion(int var1) {
      this.currentPostion = var1;
   }
}
