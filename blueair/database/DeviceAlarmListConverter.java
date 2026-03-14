package com.blueair.database;

import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.util.MoshiSerializer;
import com.squareup.moshi.Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"},
   d2 = {"Lcom/blueair/database/DeviceAlarmListConverter;", "", "<init>", "()V", "Companion", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceAlarmListConverter {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final MoshiSerializer serializer;

   static {
      ParameterizedType var0 = Types.newParameterizedType((Type)List.class, new Type[]{DeviceAlarm.class});
      Intrinsics.checkNotNullExpressionValue(var0, "newParameterizedType(...)");
      serializer = new MoshiSerializer((Type)var0, new Object[0]);
   }

   @JvmStatic
   public static final String fromDeviceAlarmList(List var0) {
      return Companion.fromDeviceAlarmList(var0);
   }

   @JvmStatic
   public static final List fromString(String var0) {
      return Companion.fromString(var0);
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0007R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"},
      d2 = {"Lcom/blueair/database/DeviceAlarmListConverter$Companion;", "", "<init>", "()V", "serializer", "Lcom/blueair/core/util/MoshiSerializer;", "", "Lcom/blueair/core/model/DeviceAlarm;", "fromString", "value", "", "fromDeviceAlarmList", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      @JvmStatic
      public final String fromDeviceAlarmList(List var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         return DeviceAlarmListConverter.serializer.toJson(var1);
      }

      @JvmStatic
      public final List fromString(String var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         List var4;
         if (((CharSequence)StringsKt.trim(var1, new char[]{'[', ']'})).length() == 0) {
            var4 = null;
         } else {
            var4 = (List)DeviceAlarmListConverter.serializer.fromJson(var1);
         }

         List var3 = var4;
         if (var4 == null) {
            ArrayList var5 = new ArrayList(6);

            for(int var2 = 0; var2 < 6; ++var2) {
               var5.add((Object)null);
            }

            var3 = (List)var5;
         }

         return var3;
      }
   }
}
