package com.blueair.core.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"},
   d2 = {"Lcom/blueair/core/model/AmplitudeEvent;", "", "eventName", "", "props", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getEventName", "()Ljava/lang/String;", "getProps", "()Ljava/util/Map;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public class AmplitudeEvent {
   private final String eventName;
   private final Map props;

   public AmplitudeEvent(String var1, Map var2) {
      Intrinsics.checkNotNullParameter(var1, "eventName");
      super();
      this.eventName = var1;
      this.props = var2;
   }

   // $FF: synthetic method
   public AmplitudeEvent(String var1, Map var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      this(var1, var2);
   }

   public final String getEventName() {
      return this.eventName;
   }

   public final Map getProps() {
      return this.props;
   }
}
