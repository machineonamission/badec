package com.blueair.api;

import com.blueair.core.model.DeviceEvent;
import com.blueair.core.model.Info;
import com.blueair.core.model.OnboardingError;
import com.blueair.core.model.OnboardingState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\f"},
   d2 = {"Lcom/blueair/api/MockingUtils;", "", "<init>", "()V", "onboardingEvents", "", "Lcom/blueair/core/model/DeviceEvent;", "iteration", "", "onboardingError", "Lcom/blueair/core/model/OnboardingError;", "onboardingEvent", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class MockingUtils {
   public static final MockingUtils INSTANCE = new MockingUtils();

   private MockingUtils() {
   }

   // $FF: synthetic method
   public static DeviceEvent onboardingEvent$default(MockingUtils var0, int var1, OnboardingError var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      return var0.onboardingEvent(var1, var2);
   }

   // $FF: synthetic method
   public static List onboardingEvents$default(MockingUtils var0, int var1, OnboardingError var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      return var0.onboardingEvents(var1, var2);
   }

   public final DeviceEvent onboardingEvent(int var1, OnboardingError var2) {
      DeviceEvent var3 = new DeviceEvent("id", System.currentTimeMillis(), "origin", "message", 0, "", "DeviceBound", "", "", (Info)null, 512, (DefaultConstructorMarker)null);
      if (var1 >= Reflection.getOrCreateKotlinClass(OnboardingState.class).getSealedSubclasses().size()) {
         return var3;
      } else {
         Iterable var5 = (Iterable)Reflection.getOrCreateKotlinClass(OnboardingState.class).getSealedSubclasses();
         Collection var4 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var5, 10)));
         Iterator var6 = var5.iterator();

         while(var6.hasNext()) {
            Object var10 = ((KClass)var6.next()).getObjectInstance();
            Intrinsics.checkNotNull(var10, "null cannot be cast to non-null type com.blueair.core.model.OnboardingState");
            var4.add((OnboardingState)var10);
         }

         OnboardingState var8 = (OnboardingState)((List)var4).get(var1);
         if (var1 >= 2 && var2 != null) {
            Pair var7;
            if (Intrinsics.areEqual(var2, OnboardingError.JwtError.INSTANCE)) {
               var7 = new Pair(OnboardingState.LinkConnect.INSTANCE, -4);
            } else if (Intrinsics.areEqual(var2, OnboardingError.PasswordError.INSTANCE)) {
               var7 = new Pair(OnboardingState.LinkConnect.INSTANCE, -3);
            } else if (Intrinsics.areEqual(var2, OnboardingError.RouterError.INSTANCE)) {
               var7 = new Pair(OnboardingState.ObtainingIPAddress.INSTANCE, -1);
            } else if (Intrinsics.areEqual(var2, OnboardingError.SignalError.INSTANCE)) {
               var7 = new Pair(OnboardingState.LinkReconnect.INSTANCE, -1);
            } else if (Intrinsics.areEqual(var2, OnboardingError.DeviceOrServerError.INSTANCE)) {
               var7 = new Pair(OnboardingState.BrokerConnecting.INSTANCE, -1);
            } else if (Intrinsics.areEqual(var2, OnboardingError.HoldingError.INSTANCE)) {
               var7 = new Pair(OnboardingState.BrokerConnecting.INSTANCE, -5);
            } else if (Intrinsics.areEqual(var2, OnboardingError.UnknownError.INSTANCE)) {
               var7 = new Pair(OnboardingState.LinkReconnect.INSTANCE, -10);
            } else {
               if (!Intrinsics.areEqual(var2, OnboardingError.InternetError.INSTANCE)) {
                  throw new NoWhenBranchMatchedException();
               }

               var7 = new Pair(OnboardingState.BrokerConnecting.INSTANCE, -99);
            }

            var8 = (OnboardingState)var7.component1();
            return DeviceEvent.copy$default(var3, (String)null, 0L, (String)null, (String)null, ((Number)var7.component2()).intValue(), (String)null, (String)null, (String)null, var8.getName(), (Info)null, 751, (Object)null);
         } else {
            return DeviceEvent.copy$default(var3, (String)null, 0L, (String)null, (String)null, 0, (String)null, (String)null, (String)null, var8.getName(), (Info)null, 767, (Object)null);
         }
      }
   }

   public final List onboardingEvents(int var1, OnboardingError var2) {
      List var4 = (List)(new ArrayList());
      if (var1 >= 0) {
         int var3 = 0;

         while(true) {
            var4.add(this.onboardingEvent(var3, var2));
            if (var3 == var1) {
               break;
            }

            ++var3;
         }
      }

      return var4;
   }
}
