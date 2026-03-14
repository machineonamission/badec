package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"},
   d2 = {"triggerToServerValue", "", "Lcom/blueair/core/model/Device;", "trigger", "Lcom/blueair/core/model/FilterTrigger;", "core_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class FilterTriggerKt {
   public static final String triggerToServerValue(Device var0, FilterTrigger var1) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "trigger");
      if (Intrinsics.areEqual(var1, FilterTrigger.Particles.INSTANCE)) {
         return DeviceKt.isG4orB4orNB(var0) ? "PM" : "pm";
      } else if (Intrinsics.areEqual(var1, FilterTrigger.ParticlesAndGases.INSTANCE)) {
         return DeviceKt.isG4orB4orNB(var0) ? "PMtVOC" : "pm_voc";
      } else if (Intrinsics.areEqual(var1, FilterTrigger.UnknownTrigger.INSTANCE)) {
         return "unknown";
      } else {
         throw new NoWhenBranchMatchedException();
      }
   }
}
