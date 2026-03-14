package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\nÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasDehumidifierMainMode;", "Lcom/blueair/core/model/HasMainMode;", "dehSubMode", "", "getDehSubMode", "()I", "Lcom/blueair/core/model/DehSubMode;", "isInDehSubMode", "", "subMode", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasDehumidifierMainMode extends HasMainMode {
   DehSubMode dehSubMode();

   int getDehSubMode();

   boolean isInDehSubMode(DehSubMode var1);

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ApSubMode apSubMode(HasDehumidifierMainMode var0) {
         return HasDehumidifierMainMode$_CC.access$apSubMode$jd(var0);
      }

      @Deprecated
      public static DehSubMode dehSubMode(HasDehumidifierMainMode var0) {
         return HasDehumidifierMainMode$_CC.access$dehSubMode$jd(var0);
      }

      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasDehumidifierMainMode var0) {
         return HasDehumidifierMainMode$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasDehumidifierMainMode var0, Context var1) {
         return HasDehumidifierMainMode$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasDehumidifierMainMode var0) {
         return HasDehumidifierMainMode$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasDehumidifierMainMode var0) {
         return HasDehumidifierMainMode$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isInApSubMode(HasDehumidifierMainMode var0, ApSubMode var1) {
         Intrinsics.checkNotNullParameter(var1, "subMode");
         return HasDehumidifierMainMode$_CC.access$isInApSubMode$jd(var0, var1);
      }

      @Deprecated
      public static boolean isInDehSubMode(HasDehumidifierMainMode var0, DehSubMode var1) {
         Intrinsics.checkNotNullParameter(var1, "subMode");
         return HasDehumidifierMainMode$_CC.access$isInDehSubMode$jd(var0, var1);
      }

      @Deprecated
      public static boolean isInMainMode(HasDehumidifierMainMode var0, MainMode var1) {
         Intrinsics.checkNotNullParameter(var1, "mainMode");
         return HasDehumidifierMainMode$_CC.access$isInMainMode$jd(var0, var1);
      }

      @Deprecated
      public static boolean isOnline(HasDehumidifierMainMode var0) {
         return HasDehumidifierMainMode$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasDehumidifierMainMode var0) {
         return HasDehumidifierMainMode$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static MainMode mainMode(HasDehumidifierMainMode var0) {
         return HasDehumidifierMainMode$_CC.access$mainMode$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasDehumidifierMainMode var0) {
         return HasDehumidifierMainMode$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
