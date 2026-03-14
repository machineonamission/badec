package com.blueair.api.utils;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001:\u0001\u000fB\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"},
   d2 = {"Lcom/blueair/api/utils/SkipBadElementsListAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "", "", "elementAdapter", "<init>", "(Lcom/squareup/moshi/JsonAdapter;)V", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "Factory", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SkipBadElementsListAdapter extends JsonAdapter {
   private final JsonAdapter elementAdapter;

   public SkipBadElementsListAdapter(JsonAdapter var1) {
      Intrinsics.checkNotNullParameter(var1, "elementAdapter");
      super();
      this.elementAdapter = var1;
   }

   public List fromJson(JsonReader var1) {
      Intrinsics.checkNotNullParameter(var1, "reader");
      List var2 = (List)(new ArrayList());
      var1.beginArray();

      for(; var1.hasNext(); var1.skipValue()) {
         try {
            ((Collection)var2).add(this.elementAdapter.fromJson(var1.peekJson()));
         } catch (JsonDataException var4) {
            Timber.Forest.e((Throwable)var4, "JsonArray element parsing exception, will skip this element", new Object[0]);
         }
      }

      var1.endArray();
      return var2;
   }

   public void toJson(JsonWriter var1, List var2) {
      Intrinsics.checkNotNullParameter(var1, "writer");
      if (var2 == null) {
         throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
      } else {
         var1.beginArray();

         for(Object var3 : (Iterable)var2) {
            this.elementAdapter.toJson(var1, var3);
         }

         var1.endArray();
      }
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"},
      d2 = {"Lcom/blueair/api/utils/SkipBadElementsListAdapter$Factory;", "Lcom/squareup/moshi/JsonAdapter$Factory;", "<init>", "()V", "create", "Lcom/squareup/moshi/JsonAdapter;", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "moshi", "Lcom/squareup/moshi/Moshi;", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Factory implements JsonAdapter.Factory {
      public static final Factory INSTANCE = new Factory();

      private Factory() {
      }

      public JsonAdapter create(Type var1, Set var2, Moshi var3) {
         Intrinsics.checkNotNullParameter(var1, "type");
         Intrinsics.checkNotNullParameter(var2, "annotations");
         Intrinsics.checkNotNullParameter(var3, "moshi");
         if (Intrinsics.areEqual(Types.getRawType(var1), List.class) && !Intrinsics.areEqual(var1, List.class)) {
            JsonAdapter var4 = var3.adapter(Types.collectionElementType(var1, List.class));
            Intrinsics.checkNotNull(var4);
            return (new SkipBadElementsListAdapter(var4)).nullSafe();
         } else {
            return null;
         }
      }
   }
}
