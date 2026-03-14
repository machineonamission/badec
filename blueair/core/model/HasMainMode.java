package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\bH\u0016J\b\u0010\u0006\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000bH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u000eÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasMainMode;", "Lcom/blueair/core/model/HasSKU;", "mainMode", "", "getMainMode", "()I", "apSubMode", "getApSubMode", "Lcom/blueair/core/model/MainMode;", "isInMainMode", "", "Lcom/blueair/core/model/ApSubMode;", "isInApSubMode", "subMode", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasMainMode extends HasSKU {
   ApSubMode apSubMode();

   int getApSubMode();

   int getMainMode();

   boolean isInApSubMode(ApSubMode var1);

   boolean isInMainMode(MainMode var1);

   MainMode mainMode();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ApSubMode apSubMode(HasMainMode var0) {
         return HasMainMode$_CC.access$apSubMode$jd(var0);
      }

      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasMainMode var0) {
         return HasMainMode$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasMainMode var0, Context var1) {
         return HasMainMode$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasMainMode var0) {
         return HasMainMode$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasMainMode var0) {
         return HasMainMode$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isInApSubMode(HasMainMode var0, ApSubMode var1) {
         Intrinsics.checkNotNullParameter(var1, "subMode");
         return HasMainMode$_CC.access$isInApSubMode$jd(var0, var1);
      }

      @Deprecated
      public static boolean isInMainMode(HasMainMode var0, MainMode var1) {
         Intrinsics.checkNotNullParameter(var1, "mainMode");
         return HasMainMode$_CC.access$isInMainMode$jd(var0, var1);
      }

      @Deprecated
      public static boolean isOnline(HasMainMode var0) {
         return HasMainMode$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasMainMode var0) {
         return HasMainMode$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static MainMode mainMode(HasMainMode var0) {
         return HasMainMode$_CC.access$mainMode$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasMainMode var0) {
         return HasMainMode$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
