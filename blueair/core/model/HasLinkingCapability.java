package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006\u000bÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasLinkingCapability;", "Lcom/blueair/core/model/HasFanSpeed;", "linkedToUid", "", "getLinkedToUid", "()Ljava/lang/String;", "setLinkedToUid", "(Ljava/lang/String;)V", "isLinked", "", "()Z", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasLinkingCapability extends HasFanSpeed {
   String getLinkedToUid();

   boolean isLinked();

   void setLinkedToUid(String var1);

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static AutoMode getAutoMode(HasLinkingCapability var0) {
         return HasLinkingCapability$_CC.access$getAutoMode$jd(var0);
      }

      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasLinkingCapability var0) {
         return HasLinkingCapability$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static FanSpeedEnum getFanSpeedEnum(HasLinkingCapability var0) {
         return HasLinkingCapability$_CC.access$getFanSpeedEnum$jd(var0);
      }

      @Deprecated
      public static Filter getFilter(HasLinkingCapability var0) {
         return HasLinkingCapability$_CC.access$getFilter$jd(var0);
      }

      @Deprecated
      public static boolean getHasGear0(HasLinkingCapability var0) {
         return HasLinkingCapability$_CC.access$getHasGear0$jd(var0);
      }

      @Deprecated
      public static boolean getHasGear4(HasLinkingCapability var0) {
         return HasLinkingCapability$_CC.access$getHasGear4$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasLinkingCapability var0, Context var1) {
         return HasLinkingCapability$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static FilterTrigger getTrigger(HasLinkingCapability var0) {
         return HasLinkingCapability$_CC.access$getTrigger$jd(var0);
      }

      @Deprecated
      public static DeviceType getType(HasLinkingCapability var0) {
         return HasLinkingCapability$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static UiAutoMode getUiAutoMode(HasLinkingCapability var0) {
         return HasLinkingCapability$_CC.access$getUiAutoMode$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasLinkingCapability var0) {
         return HasLinkingCapability$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isLinked(HasLinkingCapability var0) {
         return HasLinkingCapability$_CC.access$isLinked$jd(var0);
      }

      @Deprecated
      public static boolean isOnline(HasLinkingCapability var0) {
         return HasLinkingCapability$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasLinkingCapability var0) {
         return HasLinkingCapability$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasLinkingCapability var0) {
         return HasLinkingCapability$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
