package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"},
   d2 = {"Lcom/blueair/core/model/OnboardingFailureEvent;", "Lcom/blueair/core/model/OnboardingFlowEvent;", "deviceType", "", "auto", "", "failureDescription", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class OnboardingFailureEvent extends OnboardingFlowEvent {
   public OnboardingFailureEvent(String var1, boolean var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "deviceType");
      Intrinsics.checkNotNullParameter(var3, "failureDescription");
      Pair var6 = TuplesKt.to("Step", "Complete");
      Pair var5 = TuplesKt.to("Status", "Failure");
      String var4;
      if (var2) {
         var4 = "Auto";
      } else {
         var4 = "Manual";
      }

      super(MapsKt.mapOf(new Pair[]{var6, var5, TuplesKt.to("Onboarding type", var4), TuplesKt.to("Device type", var1), TuplesKt.to("Failure description", var3)}));
   }
}
