package com.blueair.outdoor.ui.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J0\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J0\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"},
   d2 = {"Lcom/blueair/outdoor/ui/adapters/LocationPageIndicatorItemDecorator;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "currentLocationActiveBitmap", "Landroid/graphics/Bitmap;", "currentLocationInactiveBitmap", "savedLocationActiveBitmap", "savedLocationInactiveBitmap", "onDraw", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "drawInactive", "indicatorStartX", "", "startY", "itemCount", "hasCurrentLocation", "", "drawActive", "activeElement", "Companion", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LocationPageIndicatorItemDecorator extends RecyclerView.ItemDecoration {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final float DP;
   private static final int mIndicatorHeightPadding;
   private static final int mIndicatorItemLength;
   private static final int mIndicatorItemPadding;
   private Bitmap currentLocationActiveBitmap;
   private Bitmap currentLocationInactiveBitmap;
   private Bitmap savedLocationActiveBitmap;
   private Bitmap savedLocationInactiveBitmap;

   static {
      float var0 = Resources.getSystem().getDisplayMetrics().density;
      DP = var0;
      mIndicatorHeightPadding = (int)((float)4 * var0);
      float var1 = (float)8;
      mIndicatorItemLength = (int)(var0 * var1);
      mIndicatorItemPadding = (int)(var0 * var1);
   }

   public LocationPageIndicatorItemDecorator(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super();
      int var2 = ContextCompat.getColor(var1, R.color.marineblue);
      int var3 = ContextCompat.getColor(var1, R.color.gray);
      Drawable var5 = ContextCompat.getDrawable(var1, R.drawable.ic_gps);
      if (var5 != null) {
         Drawable var6 = var5.mutate();
         Intrinsics.checkNotNullExpressionValue(var6, "mutate(...)");
         var6.setTint(var2);
         Companion var4 = Companion;
         this.currentLocationActiveBitmap = var4.convertToBitmap(var6);
         var5 = var5.mutate();
         Intrinsics.checkNotNullExpressionValue(var5, "mutate(...)");
         var5.setTint(var3);
         this.currentLocationInactiveBitmap = var4.convertToBitmap(var5);
      }

      var5 = ContextCompat.getDrawable(var1, R.drawable.bg_circle);
      if (var5 != null) {
         Drawable var8 = var5.mutate();
         Intrinsics.checkNotNullExpressionValue(var8, "mutate(...)");
         var8.setTint(var2);
         Companion var7 = Companion;
         this.savedLocationActiveBitmap = var7.convertToBitmap(var8);
         var8 = var5.mutate();
         Intrinsics.checkNotNullExpressionValue(var8, "mutate(...)");
         var8.setTint(var3);
         this.savedLocationInactiveBitmap = var7.convertToBitmap(var8);
      }

   }

   private final void drawActive(Canvas var1, int var2, int var3, int var4, boolean var5) {
      int var6 = mIndicatorItemLength;
      var2 += (mIndicatorItemPadding + var6) * var4;
      Rect var7 = new Rect(var2, var3, var2 + var6, var6 + var3);
      if (var4 == 0 && var5) {
         Bitmap var10 = this.currentLocationActiveBitmap;
         if (var10 != null) {
            var1.drawBitmap(var10, (Rect)null, var7, (Paint)null);
            return;
         }
      } else {
         Bitmap var8 = this.savedLocationActiveBitmap;
         if (var8 != null) {
            var1.drawBitmap(var8, (Rect)null, var7, (Paint)null);
         }
      }

   }

   private final void drawInactive(Canvas var1, int var2, int var3, int var4, boolean var5) {
      int var7 = mIndicatorItemLength;

      for(int var6 = 0; var6 < var4; ++var6) {
         Rect var8 = new Rect(var2, var3, var2 + var7, var3 + var7);
         if (var6 == 0 && var5) {
            Bitmap var10 = this.currentLocationInactiveBitmap;
            if (var10 != null) {
               var1.drawBitmap(var10, (Rect)null, var8, (Paint)null);
            }
         } else {
            Bitmap var9 = this.savedLocationInactiveBitmap;
            if (var9 != null) {
               var1.drawBitmap(var9, (Rect)null, var8, (Paint)null);
            }
         }

         var2 += mIndicatorItemPadding + var7;
      }

   }

   public void onDraw(Canvas var1, RecyclerView var2, RecyclerView.State var3) {
      Intrinsics.checkNotNullParameter(var1, "c");
      Intrinsics.checkNotNullParameter(var2, "parent");
      Intrinsics.checkNotNullParameter(var3, "state");
      super.onDraw(var1, var2, var3);
      LocationAdapter var10 = var2.getAdapter();
      Intrinsics.checkNotNull(var10, "null cannot be cast to non-null type com.blueair.outdoor.ui.adapters.LocationAdapter");
      var10 = var10;
      RecyclerView.LayoutManager var9 = var2.getLayoutManager();
      Intrinsics.checkNotNull(var9, "null cannot be cast to non-null type com.blueair.outdoor.ui.adapters.LocationLinearLayoutManager");
      LocationLinearLayoutManager var15 = (LocationLinearLayoutManager)var9;
      int var7 = var10.getItemCount();
      if (var7 != 0) {
         int var6 = mIndicatorItemLength;
         float var5 = (float)(var6 * var7);
         float var4 = (float)(Math.max(0, var7 - 1) * mIndicatorItemPadding);
         var4 = ((float)var2.getWidth() - (var5 + var4)) / 2.0F;
         int var8 = var2.getHeight() - var6 - mIndicatorHeightPadding;
         var6 = (int)var4;
         this.drawInactive(var1, var6, var8, var7, var10.getShowCurrentLocation());
         var7 = var15.findFirstCompletelyVisibleItemPosition();
         if (var7 != -1) {
            this.drawActive(var1, var6, var8, var7, var10.getShowCurrentLocation());
            return;
         }
      }

   }

   @Metadata(
      d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"},
      d2 = {"Lcom/blueair/outdoor/ui/adapters/LocationPageIndicatorItemDecorator$Companion;", "", "<init>", "()V", "DP", "", "mIndicatorHeightPadding", "", "mIndicatorItemLength", "mIndicatorItemPadding", "convertToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "outdoor_otherRelease"},
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

      private final Bitmap convertToBitmap(Drawable var1) {
         if (var1 instanceof BitmapDrawable) {
            Bitmap var4 = ((BitmapDrawable)var1).getBitmap();
            Intrinsics.checkNotNullExpressionValue(var4, "getBitmap(...)");
            return var4;
         } else {
            Bitmap var3 = Bitmap.createBitmap(LocationPageIndicatorItemDecorator.mIndicatorItemLength, LocationPageIndicatorItemDecorator.mIndicatorItemLength, Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(var3, "createBitmap(...)");
            Canvas var2 = new Canvas(var3);
            var1.setBounds(0, 0, var2.getWidth(), var2.getHeight());
            var1.draw(var2);
            return var3;
         }
      }
   }
}
