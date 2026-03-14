package com.blueair.viewcore.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0002¨\u0006\r"},
   d2 = {"Lcom/blueair/viewcore/view/SeekProgressBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setUpProgressbar", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SeekProgressBar extends AppCompatSeekBar {
   public SeekProgressBar(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, (AttributeSet)null, 2, (DefaultConstructorMarker)null);
   }

   public SeekProgressBar(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2);
      this.setEnabled(false);
   }

   // $FF: synthetic method
   public SeekProgressBar(Context var1, AttributeSet var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      this(var1, var2);
   }

   private final void setUpProgressbar() {
      int var1 = this.getProgress();
      if (var1 != 0 && var1 != 1 && var1 != 2 && var1 != 3) {
         switch (var1) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
               break;
            default:
               this.setThumb(ContextCompat.getDrawable(this.getContext(), R.drawable.atoms_layers_neumorphs_pp_card_eta_tip_of_fill_left));
               return;
         }
      }

      this.setThumb((Drawable)null);
   }

   protected void onDraw(Canvas var1) {
      Intrinsics.checkNotNullParameter(var1, "canvas");
      this.setUpProgressbar();
      super.onDraw(var1);
   }
}
