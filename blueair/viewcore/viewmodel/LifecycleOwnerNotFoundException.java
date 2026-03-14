package com.blueair.viewcore.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
   d2 = {"Lcom/blueair/viewcore/viewmodel/LifecycleOwnerNotFoundException;", "", "message", "", "<init>", "(Ljava/lang/String;)V", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LifecycleOwnerNotFoundException extends Throwable {
   public LifecycleOwnerNotFoundException() {
      this((String)null, 1, (DefaultConstructorMarker)null);
   }

   public LifecycleOwnerNotFoundException(String var1) {
      super(var1);
   }

   // $FF: synthetic method
   public LifecycleOwnerNotFoundException(String var1, int var2, DefaultConstructorMarker var3) {
      if ((var2 & 1) != 0) {
         var1 = null;
      }

      this(var1);
   }
}
