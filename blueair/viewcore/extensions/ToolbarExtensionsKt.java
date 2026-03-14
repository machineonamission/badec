package com.blueair.viewcore.extensions;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"},
   d2 = {"changeToolbarFont", "", "Landroidx/appcompat/widget/Toolbar;", "context", "Landroid/content/Context;", "fontRes", "", "viewcore_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class ToolbarExtensionsKt {
   public static final void changeToolbarFont(Toolbar var0, Context var1, int var2) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "context");
      int var4 = var0.getChildCount();

      for(int var3 = 0; var3 < var4; ++var3) {
         View var5 = var0.getChildAt(var3);
         if (var5 instanceof TextView) {
            TextView var6 = (TextView)var5;
            if (Intrinsics.areEqual(var6.getText(), var0.getTitle())) {
               var6.setTypeface(ResourcesCompat.getFont(var1, var2));
               return;
            }
         }
      }

   }
}
