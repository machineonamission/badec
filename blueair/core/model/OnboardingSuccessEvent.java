package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"},
   d2 = {"Lcom/blueair/core/model/OnboardingSuccessEvent;", "Lcom/blueair/core/model/OnboardingFlowEvent;", "deviceType", "", "deviceId", "auto", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class OnboardingSuccessEvent extends OnboardingFlowEvent {
   public OnboardingSuccessEvent(String var1, String var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "deviceType");
      Intrinsics.checkNotNullParameter(var2, "deviceId");
      Pair var5 = TuplesKt.to("Step", "Complete");
      Pair var6 = TuplesKt.to("Status", "Success");
      String var4;
      if (var3) {
         var4 = "Auto";
      } else {
         var4 = "Manual";
      }

      super(MapsKt.mapOf(new Pair[]{var5, var6, TuplesKt.to("Onboarding type", var4), TuplesKt.to("Device type", var1), TuplesKt.to("Device ID", var2)}));
   }
}
