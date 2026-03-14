package com.blueair.core.model;

import com.blueair.core.BuildEnvironment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¨\u0006\u0007"},
   d2 = {"logNotFoundError", "", "path", "", "key", "result", "", "core_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class SkuConfigurationKt {
   // $FF: synthetic method
   public static final void access$logNotFoundError(String var0, String var1, Object var2) {
      logNotFoundError(var0, var1, var2);
   }

   private static final void logNotFoundError(String var0, String var1, Object var2) {
      if (var2 == null || var2 instanceof Integer && Intrinsics.areEqual(var2, 0)) {
         CharSequence var4 = (CharSequence)var1;
         if (var4 == null || var4.length() == 0) {
            return;
         }

         StringBuilder var5 = new StringBuilder("SkuConfiguration parse error: reference not found | ");
         var5.append(var0);
         var5.append(": ");
         var5.append(var1);
         var0 = var5.toString();
         Timber.Forest.e(var0, new Object[0]);
         if (!BuildEnvironment.INSTANCE.isRelease()) {
            throw new Exception(var0);
         }
      }

   }
}
