package com.blueair.database;

import com.blueair.core.util.MoshiSerializer;
import com.squareup.moshi.Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"},
   d2 = {"Lcom/blueair/database/IntArrayConverter;", "", "<init>", "()V", "Companion", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class IntArrayConverter {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final MoshiSerializer serializer;

   static {
      ParameterizedType var0 = Types.newParameterizedType((Type)List.class, new Type[]{Integer.class});
      Intrinsics.checkNotNullExpressionValue(var0, "newParameterizedType(...)");
      serializer = new MoshiSerializer((Type)var0, new Object[0]);
   }

   @JvmStatic
   public static final String fromIntArray(int[] var0) {
      return Companion.fromIntArray(var0);
   }

   @JvmStatic
   public static final int[] fromString(String var0) {
      return Companion.fromString(var0);
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"},
      d2 = {"Lcom/blueair/database/IntArrayConverter$Companion;", "", "<init>", "()V", "serializer", "Lcom/blueair/core/util/MoshiSerializer;", "", "", "fromString", "", "value", "", "fromIntArray", "database_otherRelease"},
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
      public final String fromIntArray(int[] var1) {
         List var3;
         if (var1 != null) {
            List var2 = ArraysKt.toList(var1);
            var3 = var2;
            if (var2 != null) {
               return var3.isEmpty() ? "" : IntArrayConverter.serializer.toJson(var3);
            }
         }

         var3 = CollectionsKt.emptyList();
         return var3.isEmpty() ? "" : IntArrayConverter.serializer.toJson(var3);
      }

      @JvmStatic
      public final int[] fromString(String var1) {
         CharSequence var2 = (CharSequence)var1;
         if (var2 != null && var2.length() != 0) {
            List var3 = (List)IntArrayConverter.serializer.fromJson(var1);
            if (var3 != null) {
               int[] var4 = CollectionsKt.toIntArray((Collection)var3);
               if (var4 != null) {
                  return var4;
               }
            }

            return new int[0];
         } else {
            return new int[0];
         }
      }
   }
}
