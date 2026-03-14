package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
   d2 = {"Lcom/blueair/core/model/OnboardingStartedEvent;", "Lcom/blueair/core/model/OnboardingFlowEvent;", "deviceType", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class OnboardingStartedEvent extends OnboardingFlowEvent {
   public OnboardingStartedEvent(String var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceType");
      super(MapsKt.mapOf(new Pair[]{TuplesKt.to("Step", "Start"), TuplesKt.to("Device type", var1)}));
   }
}
