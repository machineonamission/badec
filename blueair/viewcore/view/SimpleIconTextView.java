package com.blueair.viewcore.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0007J\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007J\u0010\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u000fJ\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"},
   d2 = {"Lcom/blueair/viewcore/view/SimpleIconTextView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageView", "Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "setIcon", "", "drawable", "Landroid/graphics/drawable/Drawable;", "setIconResource", "resId", "setIconSize", "width", "height", "setText", "text", "", "hideText", "setTextSize", "size", "", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SimpleIconTextView extends LinearLayout {
   private final ImageView imageView;
   private final TextView textView;

   public SimpleIconTextView(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, (AttributeSet)null, 0, 6, (DefaultConstructorMarker)null);
   }

   public SimpleIconTextView(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, var2, 0, 4, (DefaultConstructorMarker)null);
   }

   public SimpleIconTextView(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
      this.setOrientation(0);
      this.setGravity(16);
      ImageView var8 = new ImageView(var1);
      this.imageView = var8;
      View var9 = LayoutInflater.from(var1).inflate(R.layout.simple_text_with_family_weight500, (ViewGroup)null);
      Intrinsics.checkNotNull(var9, "null cannot be cast to non-null type android.widget.TextView");
      TextView var17 = (TextView)var9;
      this.textView = var17;
      TypedArray var12 = var1.obtainStyledAttributes(var2, R.styleable.SimpleIconTextView, var3, 0);
      Intrinsics.checkNotNullExpressionValue(var12, "obtainStyledAttributes(...)");
      Drawable var11 = var12.getDrawable(R.styleable.SimpleIconTextView_iconDrawable);
      int var6 = var12.getDimensionPixelSize(R.styleable.SimpleIconTextView_iconSize, -1);
      var3 = var12.getDimensionPixelSize(R.styleable.SimpleIconTextView_iconWidth, -2);
      int var7 = var12.getDimensionPixelSize(R.styleable.SimpleIconTextView_iconHeight, -2);
      String var10 = var12.getString(R.styleable.SimpleIconTextView_android_text);
      float var4 = var12.getDimension(R.styleable.SimpleIconTextView_android_textSize, 0.0F);
      ColorStateList var15 = var12.getColorStateList(R.styleable.SimpleIconTextView_android_textColor);
      int var5 = var12.getDimensionPixelSize(R.styleable.SimpleIconTextView_spacing, 0);
      var12.recycle();
      var8.setImageDrawable(var11);
      if (var6 != -1) {
         this.setIconSize(var6, var6);
      } else {
         this.setIconSize(var3, var7);
      }

      if (var5 != 0) {
         ViewGroup.MarginLayoutParams var14;
         if (var17.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams var13 = var17.getLayoutParams();
            Intrinsics.checkNotNull(var13, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            var14 = (ViewGroup.MarginLayoutParams)var13;
         } else {
            var14 = (ViewGroup.MarginLayoutParams)(new LinearLayout.LayoutParams(-2, -2));
         }

         var14.setMarginStart(var5);
         var17.setLayoutParams((ViewGroup.LayoutParams)var14);
      }

      this.setText(var10);
      if (var4 != 0.0F) {
         var17.setTextSize(0, var4);
      }

      if (var15 != null) {
         var17.setTextColor(var15);
      }

      this.addView((View)var8);
      this.addView((View)var17);
   }

   // $FF: synthetic method
   public SimpleIconTextView(Context var1, AttributeSet var2, int var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = 0;
      }

      this(var1, var2, var3);
   }

   public final void hideText() {
      this.textView.setVisibility(8);
   }

   public final void setIcon(Drawable var1) {
      this.imageView.setImageDrawable(var1);
   }

   public final void setIconResource(int var1) {
      this.imageView.setImageResource(var1);
   }

   public final void setIconSize(int var1, int var2) {
      ViewGroup.LayoutParams var4 = this.imageView.getLayoutParams();
      ViewGroup.LayoutParams var3 = var4;
      if (var4 == null) {
         var3 = (ViewGroup.LayoutParams)(new LinearLayout.LayoutParams(var1, var2));
      }

      var3.width = var1;
      var3.height = var2;
      this.imageView.setLayoutParams(var3);
   }

   public final void setText(String var1) {
      TextView var4 = this.textView;
      CharSequence var5 = (CharSequence)var1;
      var4.setText(var5);
      View var7 = (View)this.textView;
      byte var3 = 0;
      boolean var2;
      if (var5 != null && var5.length() != 0) {
         var2 = 0;
      } else {
         var2 = 1;
      }

      if (!var2) {
         var2 = var3;
      } else {
         var2 = 8;
      }

      var7.setVisibility(var2);
   }

   public final void setTextSize(float var1) {
      this.textView.setTextSize(var1);
   }
}
