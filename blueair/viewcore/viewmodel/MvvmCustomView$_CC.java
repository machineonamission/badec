package com.blueair.viewcore.viewmodel;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

// $FF: synthetic class
public final class MvvmCustomView$_CC {
   public static void $default$attachLifeCycle(MvvmCustomView var0, Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("Attaching lifecycle for ");
      var2.append(var1);
      var3.d(var2.toString(), new Object[0]);
      LifecycleOwner var4;
      if (var1 instanceof LifecycleOwner) {
         var4 = (LifecycleOwner)var1;
      } else {
         var4 = null;
      }

      if (var4 != null) {
         var0.onLifecycleOwnerAttached(var4);
      } else {
         throw new LifecycleOwnerNotFoundException((String)null, 1, (DefaultConstructorMarker)null);
      }
   }

   // $FF: synthetic method
   public static void access$attachLifeCycle$jd(MvvmCustomView var0, Context var1) {
      $default$attachLifeCycle(var0, var1);
   }
}
