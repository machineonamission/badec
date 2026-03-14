package com.blueair.viewcore.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.TypedValueCompat;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0003J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0007J\u0016\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007J\u0010\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006!"},
   d2 = {"Lcom/blueair/viewcore/view/CirculatorFanContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "angleTextView", "Landroid/widget/TextView;", "fanView", "Lcom/blueair/viewcore/view/CirculatorFanView;", "placeHolderView", "Landroid/widget/ImageView;", "value", "", "horizontalMode", "getHorizontalMode", "()Z", "setHorizontalMode", "(Z)V", "updateLayout", "", "setFixAngle", "angle", "setSwingAngle", "start", "end", "setOnAngleChangeListener", "listener", "Lcom/blueair/viewcore/view/CirculatorFanView$OnAngleChangeListener;", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class CirculatorFanContainer extends FrameLayout {
   private final TextView angleTextView;
   private final CirculatorFanView fanView;
   private boolean horizontalMode;
   private final ImageView placeHolderView;

   public CirculatorFanContainer(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, (AttributeSet)null, 0, 6, (DefaultConstructorMarker)null);
   }

   public CirculatorFanContainer(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, var2, 0, 4, (DefaultConstructorMarker)null);
   }

   public CirculatorFanContainer(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
      TextView var4 = new TextView(var1);
      this.angleTextView = var4;
      CirculatorFanView var5 = new CirculatorFanView(var1, (AttributeSet)null, 0, 6, (DefaultConstructorMarker)null);
      this.fanView = var5;
      ImageView var8 = new ImageView(var1);
      this.placeHolderView = var8;
      this.horizontalMode = true;
      var5.bindAngleTextView(var4);
      FrameLayout.LayoutParams var6 = new FrameLayout.LayoutParams(-1, -1);
      var6.topMargin = (int)TypedValueCompat.dpToPx(60.0F, var1.getResources().getDisplayMetrics());
      this.addView(var5, (ViewGroup.LayoutParams)var6);
      var4.setTextColor(var1.getColor(R.color.colorPrimary));
      Typeface var7 = TypefaceCompat.create(var1, ResourcesCompat.getFont(var1, R.font.gilroy), 500, false);
      Intrinsics.checkNotNullExpressionValue(var7, "create(...)");
      var4.setTypeface(var7);
      var4.setTextSize(20.0F);
      this.addView((View)var4);
      this.addView((View)var8);
      this.updateLayout();
   }

   // $FF: synthetic method
   public CirculatorFanContainer(Context var1, AttributeSet var2, int var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = 0;
      }

      this(var1, var2, var3);
   }

   private final void updateLayout() {
      if (this.horizontalMode) {
         int var1 = (int)TypedValueCompat.dpToPx(80.0F, this.getContext().getResources().getDisplayMetrics());
         FrameLayout.LayoutParams var2 = new FrameLayout.LayoutParams(var1, var1);
         var2.gravity = 49;
         this.placeHolderView.setImageResource(R.drawable.img_fan_placeholder_horizontal);
         this.placeHolderView.setLayoutParams((ViewGroup.LayoutParams)var2);
         FrameLayout.LayoutParams var3 = new FrameLayout.LayoutParams(-2, -2);
         var2.bottomMargin = 0;
         var3.gravity = 81;
         this.angleTextView.setLayoutParams((ViewGroup.LayoutParams)var3);
         this.fanView.setRotation(0.0F);
         this.fanView.setMaxEndAngle(150.0F);
         this.fanView.setTranslationY(0.0F);
         this.setTranslationY(TypedValueCompat.dpToPx(20.0F, this.getContext().getResources().getDisplayMetrics()));
      } else {
         FrameLayout.LayoutParams var4 = new FrameLayout.LayoutParams((int)TypedValueCompat.dpToPx(96.0F, this.getContext().getResources().getDisplayMetrics()), (int)TypedValueCompat.dpToPx(109.0F, this.getContext().getResources().getDisplayMetrics()));
         var4.rightMargin = (int)TypedValueCompat.dpToPx(80.0F, this.getContext().getResources().getDisplayMetrics());
         var4.bottomMargin = (int)TypedValueCompat.dpToPx(10.0F, this.getContext().getResources().getDisplayMetrics());
         var4.gravity = 85;
         this.placeHolderView.setImageResource(R.drawable.img_fan_placeholder_vertical);
         this.placeHolderView.setLayoutParams((ViewGroup.LayoutParams)var4);
         var4 = new FrameLayout.LayoutParams(-2, -2);
         var4.gravity = 51;
         var4.topMargin = (int)TypedValueCompat.dpToPx(58.0F, this.getContext().getResources().getDisplayMetrics());
         var4.leftMargin = (int)TypedValueCompat.dpToPx(70.0F, this.getContext().getResources().getDisplayMetrics());
         this.angleTextView.setLayoutParams((ViewGroup.LayoutParams)var4);
         this.fanView.setRotation(150.0F);
         this.fanView.setMaxEndAngle(120.0F);
         this.fanView.setTranslationY(TypedValueCompat.dpToPx(-50.0F, this.getContext().getResources().getDisplayMetrics()));
         this.setTranslationY(0.0F);
      }

      this.fanView.invalidate();
   }

   public final boolean getHorizontalMode() {
      return this.horizontalMode;
   }

   public final void setFixAngle(int var1) {
      CirculatorFanView var3 = this.fanView;
      int var2 = var1;
      if (this.horizontalMode) {
         var2 = 120 - var1;
      }

      var3.setFixAngle(var2);
   }

   public final void setHorizontalMode(boolean var1) {
      if (this.horizontalMode != var1) {
         this.horizontalMode = var1;
         this.updateLayout();
      }

   }

   public final void setOnAngleChangeListener(CirculatorFanView.OnAngleChangeListener var1) {
      this.fanView.setOnAngleChangeListener(new CirculatorFanView.OnAngleChangeListener(this, var1) {
         final CirculatorFanView.OnAngleChangeListener $listener;
         final CirculatorFanContainer this$0;

         {
            this.this$0 = var1;
            this.$listener = var2;
         }

         public void onFixAngleChange(int var1) {
            int var2 = var1;
            if (this.this$0.getHorizontalMode()) {
               var2 = 120 - var1;
            }

            CirculatorFanView.OnAngleChangeListener var3 = this.$listener;
            if (var3 != null) {
               var3.onFixAngleChange(var2);
            }

         }

         public void onSwing(int var1, int var2) {
            if (this.this$0.getHorizontalMode()) {
               CirculatorFanView.OnAngleChangeListener var3 = this.$listener;
               if (var3 != null) {
                  var3.onSwing(120 - var2, 120 - var1);
                  return;
               }
            } else {
               CirculatorFanView.OnAngleChangeListener var4 = this.$listener;
               if (var4 != null) {
                  var4.onSwing(var1, var2);
               }
            }

         }
      });
   }

   public final void setSwingAngle(int var1, int var2) {
      if (this.horizontalMode) {
         this.fanView.setSwingAngle(120 - var2, 120 - var1);
      } else {
         this.fanView.setSwingAngle(var1, var2);
      }
   }
}
