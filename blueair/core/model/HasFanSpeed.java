package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0012\u0010\u0013\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\f\u0012\u0004\b%\u0010 \u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\f\u0012\u0004\b*\u0010 \u001a\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020)8VX\u0096\u0004¢\u0006\f\u0012\u0004\b.\u0010 \u001a\u0004\b/\u0010,¨\u00060À\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/Device;", "fanSpeed", "", "getFanSpeed", "()I", "filterLife", "getFilterLife", "()Ljava/lang/Integer;", "autoModeText", "", "getAutoModeText", "()Ljava/lang/String;", "autoMode", "Lcom/blueair/core/model/AutoMode;", "getAutoMode", "()Lcom/blueair/core/model/AutoMode;", "filterType", "getFilterType", "filterTrigger", "getFilterTrigger", "uiAutoMode", "Lcom/blueair/core/model/UiAutoMode;", "getUiAutoMode", "()Lcom/blueair/core/model/UiAutoMode;", "fanSpeedEnum", "Lcom/blueair/core/model/FanSpeedEnum;", "getFanSpeedEnum", "()Lcom/blueair/core/model/FanSpeedEnum;", "filter", "Lcom/blueair/core/model/Filter;", "getFilter$annotations", "()V", "getFilter", "()Lcom/blueair/core/model/Filter;", "trigger", "Lcom/blueair/core/model/FilterTrigger;", "getTrigger$annotations", "getTrigger", "()Lcom/blueair/core/model/FilterTrigger;", "hasGear0", "", "getHasGear0$annotations", "getHasGear0", "()Z", "hasGear4", "getHasGear4$annotations", "getHasGear4", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasFanSpeed extends Device {
   AutoMode getAutoMode();

   String getAutoModeText();

   int getFanSpeed();

   FanSpeedEnum getFanSpeedEnum();

   Filter getFilter();

   Integer getFilterLife();

   String getFilterTrigger();

   String getFilterType();

   boolean getHasGear0();

   boolean getHasGear4();

   FilterTrigger getTrigger();

   UiAutoMode getUiAutoMode();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static AutoMode getAutoMode(HasFanSpeed var0) {
         return HasFanSpeed$_CC.access$getAutoMode$jd(var0);
      }

      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasFanSpeed var0) {
         return HasFanSpeed$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static FanSpeedEnum getFanSpeedEnum(HasFanSpeed var0) {
         return HasFanSpeed$_CC.access$getFanSpeedEnum$jd(var0);
      }

      @Deprecated
      public static Filter getFilter(HasFanSpeed var0) {
         return HasFanSpeed$_CC.access$getFilter$jd(var0);
      }

      // $FF: synthetic method
      public static void getFilter$annotations() {
      }

      @Deprecated
      public static boolean getHasGear0(HasFanSpeed var0) {
         return HasFanSpeed$_CC.access$getHasGear0$jd(var0);
      }

      // $FF: synthetic method
      public static void getHasGear0$annotations() {
      }

      @Deprecated
      public static boolean getHasGear4(HasFanSpeed var0) {
         return HasFanSpeed$_CC.access$getHasGear4$jd(var0);
      }

      // $FF: synthetic method
      public static void getHasGear4$annotations() {
      }

      @Deprecated
      public static TimeZone getTimezone(HasFanSpeed var0, Context var1) {
         return HasFanSpeed$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static FilterTrigger getTrigger(HasFanSpeed var0) {
         return HasFanSpeed$_CC.access$getTrigger$jd(var0);
      }

      // $FF: synthetic method
      public static void getTrigger$annotations() {
      }

      @Deprecated
      public static DeviceType getType(HasFanSpeed var0) {
         return HasFanSpeed$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static UiAutoMode getUiAutoMode(HasFanSpeed var0) {
         return HasFanSpeed$_CC.access$getUiAutoMode$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasFanSpeed var0) {
         return HasFanSpeed$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isOnline(HasFanSpeed var0) {
         return HasFanSpeed$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasFanSpeed var0) {
         return HasFanSpeed$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasFanSpeed var0) {
         return HasFanSpeed$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
