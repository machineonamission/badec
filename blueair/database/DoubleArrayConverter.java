package com.blueair.database;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
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
   d2 = {"Lcom/blueair/database/DoubleArrayConverter;", "", "<init>", "()V", "Companion", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DoubleArrayConverter {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @JvmStatic
   public static final String fromDoubleArray(double[] var0) {
      return Companion.fromDoubleArray(var0);
   }

   @JvmStatic
   public static final double[] fromString(String var0) {
      return Companion.fromString(var0);
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007R \u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000f"},
      d2 = {"Lcom/blueair/database/DoubleArrayConverter$Companion;", "", "<init>", "()V", "jsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "", "getJsonAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "fromString", "", "value", "", "fromDoubleArray", "database_otherRelease"},
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

      private final JsonAdapter getJsonAdapter() {
         JsonAdapter var1 = (new Moshi.Builder()).add((JsonAdapter.Factory)(new KotlinJsonAdapterFactory())).build().adapter((Type)Types.newParameterizedType((Type)List.class, new Type[]{Double.class}));
         Intrinsics.checkNotNullExpressionValue(var1, "adapter(...)");
         return var1;
      }

      @JvmStatic
      public final String fromDoubleArray(double[] var1) {
         label15: {
            if (var1 != null) {
               List var2 = ArraysKt.toList(var1);
               var3 = var2;
               if (var2 != null) {
                  break label15;
               }
            }

            var3 = CollectionsKt.emptyList();
         }

         if (var3.isEmpty()) {
            return "";
         } else {
            String var4 = this.getJsonAdapter().toJson(var3);
            Intrinsics.checkNotNull(var4);
            return var4;
         }
      }

      @JvmStatic
      public final double[] fromString(String var1) {
         CharSequence var2 = (CharSequence)var1;
         if (var2 != null && var2.length() != 0) {
            List var3 = (List)this.getJsonAdapter().fromJson(var1);
            if (var3 != null) {
               double[] var4 = CollectionsKt.toDoubleArray((Collection)var3);
               if (var4 != null) {
                  return var4;
               }
            }

            return new double[0];
         } else {
            return new double[0];
         }
      }
   }
}
