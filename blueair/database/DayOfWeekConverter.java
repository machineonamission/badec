package com.blueair.database;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import java.lang.reflect.Type;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"},
   d2 = {"Lcom/blueair/database/DayOfWeekConverter;", "", "<init>", "()V", "Companion", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DayOfWeekConverter {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @JvmStatic
   public static final Set jsonToSet(String var0) {
      return Companion.jsonToSet(var0);
   }

   @JvmStatic
   public static final String listToJson(Set var0) {
      return Companion.listToJson(var0);
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\r\u001a\u00020\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007R\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000e"},
      d2 = {"Lcom/blueair/database/DayOfWeekConverter$Companion;", "", "<init>", "()V", "jsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "", "getJsonAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "jsonToSet", "value", "", "listToJson", "database_otherRelease"},
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
         JsonAdapter var1 = (new Moshi.Builder()).add((JsonAdapter.Factory)(new KotlinJsonAdapterFactory())).add((JsonAdapter.Factory)(new KotlinJsonAdapterFactory())).build().adapter((Type)Types.newParameterizedType((Type)Set.class, new Type[]{Integer.class}));
         Intrinsics.checkNotNullExpressionValue(var1, "adapter(...)");
         return var1;
      }

      @JvmStatic
      public final Set jsonToSet(String var1) {
         CharSequence var2 = (CharSequence)var1;
         if (var2 != null && var2.length() != 0) {
            Set var3 = (Set)this.getJsonAdapter().fromJson(var1);
            if (var3 != null) {
               var3 = CollectionsKt.toSet((Iterable)var3);
               if (var3 != null) {
                  return var3;
               }
            }

            return SetsKt.emptySet();
         } else {
            return SetsKt.emptySet();
         }
      }

      @JvmStatic
      public final String listToJson(Set var1) {
         Set var2;
         if (var1 == null) {
            var2 = SetsKt.emptySet();
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
