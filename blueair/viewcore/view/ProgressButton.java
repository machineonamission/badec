package com.blueair.viewcore.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.core.content.res.ResourcesCompat;
import com.blueair.viewcore.R;
import com.blueair.viewcore.databinding.ProgressButtonBinding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u000bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"},
   d2 = {"Lcom/blueair/viewcore/view/ProgressButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autoLoad", "", "getAutoLoad", "()Z", "setAutoLoad", "(Z)V", "currentlyLoading", "getCurrentlyLoading", "progressBar", "Landroid/widget/ProgressBar;", "imageView", "Landroid/widget/ImageView;", "performClick", "hideProgress", "", "showProgress", "shouldShowProgress", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ProgressButton extends FrameLayout {
   private boolean autoLoad;
   private final ImageView imageView;
   private final ProgressBar progressBar;

   public ProgressButton(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, (AttributeSet)null, 0, 6, (DefaultConstructorMarker)null);
   }

   public ProgressButton(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, var2, 0, 4, (DefaultConstructorMarker)null);
   }

   public ProgressButton(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
      this.autoLoad = true;
      ProgressButtonBinding var4 = ProgressButtonBinding.inflate(LayoutInflater.from(var1), (ViewGroup)this);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      ProgressBar var5 = var4.progressBar;
      Intrinsics.checkNotNullExpressionValue(var5, "progressBar");
      this.progressBar = var5;
      ImageView var9 = var4.image;
      Intrinsics.checkNotNullExpressionValue(var9, "image");
      this.imageView = var9;
      if (var2 == null) {
         this.setBackground(ResourcesCompat.getDrawable(var1.getResources(), R.drawable.btn_next_background, (Resources.Theme)null));
         var9.setImageDrawable(ResourcesCompat.getDrawable(var1.getResources(), R.drawable.btn_next_foreground, (Resources.Theme)null));
      } else {
         TypedArray var6 = var1.obtainStyledAttributes(var2, R.styleable.ProgressButton, 0, 0);
         Intrinsics.checkNotNullExpressionValue(var6, "obtainStyledAttributes(...)");
         this.autoLoad = var6.getBoolean(R.styleable.ProgressButton_auto_progress, true);
         var3 = var6.getResourceId(R.styleable.ProgressButton_button_background, R.drawable.btn_next_background);
         this.setBackground(ResourcesCompat.getDrawable(var1.getResources(), var3, (Resources.Theme)null));
         var3 = var6.getResourceId(R.styleable.ProgressButton_button_foreground, R.drawable.btn_next_foreground);
         var9.setImageDrawable(ResourcesCompat.getDrawable(var1.getResources(), var3, (Resources.Theme)null));
         var6.recycle();
      }
   }

   // $FF: synthetic method
   public ProgressButton(Context var1, AttributeSet var2, int var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = 0;
      }

      this(var1, var2, var3);
   }

   // $FF: synthetic method
   public static void showProgress$default(ProgressButton var0, boolean var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = true;
      }

      var0.showProgress(var1);
   }

   public final boolean getAutoLoad() {
      return this.autoLoad;
   }

   public final boolean getCurrentlyLoading() {
      return this.progressBar.getVisibility() == 0;
   }

   public final void hideProgress() {
      this.showProgress(false);
   }

   public boolean performClick() {
      if (!this.getCurrentlyLoading()) {
         if (this.autoLoad) {
            showProgress$default(this, false, 1, (Object)null);
         }

         return super.performClick();
      } else {
         return false;
      }
   }

   public final void setAutoLoad(boolean var1) {
      this.autoLoad = var1;
   }

   public final void showProgress(boolean var1) {
      ViewExtensionsKt.show((View)this.imageView, var1 ^ true);
      ViewExtensionsKt.show((View)this.progressBar, var1);
   }
}
