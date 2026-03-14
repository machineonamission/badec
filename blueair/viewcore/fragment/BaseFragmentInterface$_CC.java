package com.blueair.viewcore.fragment;

// $FF: synthetic class
public final class BaseFragmentInterface$_CC {
   // $FF: synthetic method
   public static void showProgress$default(BaseFragmentInterface var0, boolean var1, int var2, Object var3) {
      if (var3 == null) {
         if ((var2 & 1) != 0) {
            var1 = true;
         }

         var0.showProgress(var1);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showProgress");
      }
   }
}
