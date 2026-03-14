package com.blueair.viewcore.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.blueair.viewcore.view.ProgressBlockerView;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.flatcircle.viewhelper.ViewHelperUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

// $FF: synthetic class
public final class ProgressFragment$_CC {
   public static void $default$clearProgressFragment(ProgressFragment var0) {
      var0.setProgressBlockerView((ProgressBlockerView)null);
   }

   public static void $default$hideProgress(ProgressFragment var0, Context var1) {
      showProgress$default(var0, var1, false, (Integer)null, 4, (Object)null);
   }

   public static void $default$showProgress(ProgressFragment var0, Context var1, boolean var2, Integer var3) throws NullPointerException {
      ConstraintLayout var10 = var0.getRootView();
      if (var1 != null && var10 == null) {
         throw new NullPointerException("Your rootview can't be null, my guy");
      } else {
         if (var2 && var1 != null && var10 != null) {
            label28: {
               if (var0.getProgressBlockerView() != null) {
                  ProgressBlockerView var4 = var0.getProgressBlockerView();
                  Intrinsics.checkNotNull(var4);
                  if (var10.findViewById(var4.getId()) != null) {
                     break label28;
                  }
               }

               var0.setProgressBlockerView(new ProgressBlockerView(var1, (AttributeSet)null, 0, 6, (DefaultConstructorMarker)null));
               ProgressBlockerView var5 = var0.getProgressBlockerView();
               Intrinsics.checkNotNull(var5);
               var5.setId(View.generateViewId());
               var5 = var0.getProgressBlockerView();
               Intrinsics.checkNotNull(var5);
               var5.setShouldBlock(false);
               ConstraintSet var7 = new ConstraintSet();
               var10.addView((View)var0.getProgressBlockerView());
               var7.clone(var10);
               ProgressBlockerView var11 = var0.getProgressBlockerView();
               Intrinsics.checkNotNull(var11);
               var7.connect(var11.getId(), 3, var10.getId(), 3, 0);
               var11 = var0.getProgressBlockerView();
               Intrinsics.checkNotNull(var11);
               var7.connect(var11.getId(), 4, var10.getId(), 4, 0);
               var11 = var0.getProgressBlockerView();
               Intrinsics.checkNotNull(var11);
               var7.connect(var11.getId(), 6, var10.getId(), 6, 0);
               var11 = var0.getProgressBlockerView();
               Intrinsics.checkNotNull(var11);
               var7.connect(var11.getId(), 7, var10.getId(), 7, 0);
               var7.applyTo(var10);
               ProgressBlockerView var8 = var0.getProgressBlockerView();
               Intrinsics.checkNotNull(var8);
               var8.setLayoutParams((ViewGroup.LayoutParams)(new ConstraintLayout.LayoutParams(-1, -1)));
            }
         }

         ProgressBlockerView var9 = var0.getProgressBlockerView();
         if (var9 != null) {
            ViewExtensionsKt.show((View)var9, var2);
         }

         if (var2) {
            ViewHelperUtil.INSTANCE.hideSoftKeyboard((View)var0.getProgressBlockerView());
         }

      }
   }

   // $FF: synthetic method
   public static void access$clearProgressFragment$jd(ProgressFragment var0) {
      $default$clearProgressFragment(var0);
   }

   // $FF: synthetic method
   public static void access$hideProgress$jd(ProgressFragment var0, Context var1) {
      $default$hideProgress(var0, var1);
   }

   // $FF: synthetic method
   public static void access$showProgress$jd(ProgressFragment var0, Context var1, boolean var2, Integer var3) {
      $default$showProgress(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void showProgress$default(ProgressFragment var0, Context var1, boolean var2, Integer var3, int var4, Object var5) throws NullPointerException {
      if (var5 == null) {
         if ((var4 & 2) != 0) {
            var2 = true;
         }

         if ((var4 & 4) != 0) {
            var3 = null;
         }

         var0.showProgress(var1, var2, var3);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showProgress");
      }
   }
}
