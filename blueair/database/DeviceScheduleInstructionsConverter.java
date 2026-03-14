package com.blueair.database;

import com.blueair.database.entity.DeviceScheduleInstructionEntity;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"},
   d2 = {"Lcom/blueair/database/DeviceScheduleInstructionsConverter;", "", "<init>", "()V", "Companion", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleInstructionsConverter {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @JvmStatic
   public static final List jsonToList(String var0) {
      return Companion.jsonToList(var0);
   }

   @JvmStatic
   public static final String listToJson(List var0) {
      return Companion.listToJson(var0);
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\r\u001a\u00020\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007R\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000e"},
      d2 = {"Lcom/blueair/database/DeviceScheduleInstructionsConverter$Companion;", "", "<init>", "()V", "jsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "Lcom/blueair/database/entity/DeviceScheduleInstructionEntity;", "getJsonAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "jsonToList", "value", "", "listToJson", "database_otherRelease"},
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

      public final JsonAdapter getJsonAdapter() {
         JsonAdapter var1 = (new Moshi.Builder()).add((JsonAdapter.Factory)(new KotlinJsonAdapterFactory())).add((JsonAdapter.Factory)(new KotlinJsonAdapterFactory())).build().adapter((Type)Types.newParameterizedType((Type)List.class, new Type[]{DeviceScheduleInstructionEntity.class}));
         Intrinsics.checkNotNullExpressionValue(var1, "adapter(...)");
         return var1;
      }

      @JvmStatic
      public final List jsonToList(String var1) {
         CharSequence var2 = (CharSequence)var1;
         if (var2 != null && var2.length() != 0) {
            List var3 = (List)this.getJsonAdapter().fromJson(var1);
            if (var3 != null) {
               var3 = CollectionsKt.toList((Iterable)var3);
               if (var3 != null) {
                  return var3;
               }
            }

            return CollectionsKt.emptyList();
         } else {
            return CollectionsKt.emptyList();
         }
      }

      @JvmStatic
      public final String listToJson(List var1) {
         List var2;
         if (var1 == null) {
            var2 = CollectionsKt.emptyList();
         } else {
            var2 = var1;
         }

         if (var2.isEmpty()) {
            return "";
         } else {
            String var3 = this.getJsonAdapter().toJson(var1);
            Intrinsics.checkNotNull(var3);
            return var3;
         }
      }
   }
}
