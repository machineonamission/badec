package com.blueair.viewcore;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

// $FF: synthetic class
public final class ViewCoreAppbar$_CC {
   public static void $default$setHeader(ViewCoreAppbar var0, Header var1) {
      Intrinsics.checkNotNullParameter(var1, "header");
      var0.getHeaderTitle().setText((CharSequence)var1.getTitle());
      var0.getHeaderMsg().setText((CharSequence)var1.getMessage());
      View var4 = (View)var0.getHeaderMsg();
      boolean var2;
      if (((CharSequence)var1.getMessage()).length() > 0) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      if (var2) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      var4.setVisibility(var2);
      if (var1.getIconDrawableResource() != null) {
         ActionBar var11 = var0.getActionBar();
         if (var11 != null) {
            var11.setHomeAsUpIndicator(var1.getIconDrawableResource());
         }

         var11 = var0.getActionBar();
         if (var11 != null) {
            var11.setDisplayHomeAsUpEnabled(true);
         }
      } else {
         ActionBar var13 = var0.getActionBar();
         if (var13 != null) {
            var13.setHomeAsUpIndicator(R.drawable.ic_arrow_back_trans);
         }

         var13 = var0.getActionBar();
         if (var13 != null) {
            var13.setDisplayHomeAsUpEnabled(false);
         }
      }

      if (var1.getStepOrdinal() != null) {
         ((View)var0.getProgressIndicator()).setVisibility(0);
         var0.getProgressIndicator().setProgress(var1.getStepOrdinal());
         Iterator var6 = ((Iterable)var0.getOnboardingSteps()).iterator();

         for(int var9 = 0; var6.hasNext(); ++var9) {
            Object var15 = var6.next();
            if (var9 < 0) {
               CollectionsKt.throwIndexOverflow();
            }

            TextView var16 = (TextView)var15;
            ((View)var16).setVisibility(0);
            boolean var3;
            if (var9 <= var1.getStepOrdinal()) {
               var3 = true;
            } else {
               var3 = false;
            }

            var16.setEnabled(var3);
            Integer var5 = var1.getStepOrdinal();
            if (var5 != null && var9 == var5) {
               var3 = true;
            } else {
               var3 = false;
            }

            var16.setSelected(var3);
         }
      } else {
         ((View)var0.getProgressIndicator()).setVisibility(8);
         Iterator var7 = ((Iterable)var0.getOnboardingSteps()).iterator();

         while(var7.hasNext()) {
            ((View)((TextView)var7.next())).setVisibility(8);
         }
      }

   }

   // $FF: synthetic method
   public static void access$setHeader$jd(ViewCoreAppbar var0, Header var1) {
      $default$setHeader(var0, var1);
   }
}
