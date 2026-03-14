package com.blueair.database;

import com.blueair.core.model.IndoorDatapoint;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"},
   d2 = {"Lcom/blueair/database/IndoorDatapointConverter;", "", "<init>", "()V", "Companion", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class IndoorDatapointConverter {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   @JvmStatic
   public static final String fromArrayList(ArrayList var0) {
      return Companion.fromArrayList(var0);
   }

   @JvmStatic
   public static final ArrayList fromString(String var0) {
      return Companion.fromString(var0);
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J$\u0010\u000e\u001a\u00020\r2\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0007R'\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"},
      d2 = {"Lcom/blueair/database/IndoorDatapointConverter$Companion;", "", "<init>", "()V", "jsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Ljava/util/ArrayList;", "Lcom/blueair/core/model/IndoorDatapoint;", "Lkotlin/collections/ArrayList;", "getJsonAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "fromString", "value", "", "fromArrayList", "database_otherRelease"},
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
      public final String fromArrayList(ArrayList var1) {
         Collection var2 = (Collection)var1;
         if (var2 != null && !var2.isEmpty()) {
            String var3 = this.getJsonAdapter().toJson(var1);
            Intrinsics.checkNotNullExpressionValue(var3, "toJson(...)");
            return var3;
         } else {
            return "";
         }
      }

      @JvmStatic
      public final ArrayList fromString(String var1) {
         CharSequence var2 = (CharSequence)var1;
         if (var2 != null && var2.length() != 0) {
            ArrayList var4 = (ArrayList)this.getJsonAdapter().fromJson(var1);
            ArrayList var3 = var4;
            if (var4 == null) {
               var3 = new ArrayList();
            }

            return var3;
         } else {
            return new ArrayList();
         }
      }

      public final JsonAdapter getJsonAdapter() {
         JsonAdapter var1 = (new Moshi.Builder()).add((JsonAdapter.Factory)(new KotlinJsonAdapterFactory())).build().adapter((Type)Types.newParameterizedType((Type)List.class, new Type[]{IndoorDatapoint.class}));
         Intrinsics.checkNotNullExpressionValue(var1, "adapter(...)");
         return var1;
      }
   }
}
