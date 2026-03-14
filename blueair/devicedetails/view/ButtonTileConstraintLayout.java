package com.blueair.devicedetails.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014¨\u0006\n"},
   d2 = {"Lcom/blueair/devicedetails/view/ButtonTileConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onFinishInflate", "", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ButtonTileConstraintLayout extends ConstraintLayout {
   public ButtonTileConstraintLayout(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, (AttributeSet)null, 2, (DefaultConstructorMarker)null);
   }

   public ButtonTileConstraintLayout(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2);
   }

   // $FF: synthetic method
   public ButtonTileConstraintLayout(Context var1, AttributeSet var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      this(var1, var2);
   }

   protected void onFinishInflate() {
      super.onFinishInflate();
      String var1 = this.getResources().getString(R.string.button_role);
      Intrinsics.checkNotNullExpressionValue(var1, "getString(...)");
      ViewUtils.setAccessibilityDelegate$default(ViewUtils.INSTANCE, (View)this, (KClass)null, var1, (Function2)null, 10, (Object)null);
   }
}
