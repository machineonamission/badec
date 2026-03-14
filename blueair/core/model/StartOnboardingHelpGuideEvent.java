package com.blueair.core.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
   d2 = {"Lcom/blueair/core/model/StartOnboardingHelpGuideEvent;", "Lcom/blueair/core/model/AmplitudeEvent;", "<init>", "()V", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class StartOnboardingHelpGuideEvent extends AmplitudeEvent {
   public static final StartOnboardingHelpGuideEvent INSTANCE = new StartOnboardingHelpGuideEvent();

   private StartOnboardingHelpGuideEvent() {
      super("Onboarding help guide start event", (Map)null, 2, (DefaultConstructorMarker)null);
   }
}
