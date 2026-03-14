package com.blueair.core.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"},
   d2 = {"Lcom/blueair/core/model/OnboardingFlowEvent;", "Lcom/blueair/core/model/AmplitudeEvent;", "props", "", "", "", "<init>", "(Ljava/util/Map;)V", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class OnboardingFlowEvent extends AmplitudeEvent {
   public OnboardingFlowEvent() {
      this((Map)null, 1, (DefaultConstructorMarker)null);
   }

   public OnboardingFlowEvent(Map var1) {
      super("Onboarding flow event", var1);
   }

   // $FF: synthetic method
   public OnboardingFlowEvent(Map var1, int var2, DefaultConstructorMarker var3) {
      if ((var2 & 1) != 0) {
         var1 = null;
      }

      this(var1);
   }
}
