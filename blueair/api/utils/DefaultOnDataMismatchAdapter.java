package com.blueair.api.utils;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Set;

public final class DefaultOnDataMismatchAdapter extends JsonAdapter {
   private final Object defaultValue;
   private final JsonAdapter delegate;

   private DefaultOnDataMismatchAdapter(JsonAdapter var1, Object var2) {
      this.delegate = var1;
      this.defaultValue = var2;
   }

   public static JsonAdapter.Factory newFactory(Class var0, Object var1) {
      return new JsonAdapter.Factory(var0, var1) {
         final Object val$defaultValue;
         final Class val$type;

         {
            this.val$type = var1;
            this.val$defaultValue = var2;
         }

         public JsonAdapter create(Type var1, Set var2, Moshi var3) {
            Class var4 = this.val$type;
            return var4 != var1 ? null : new DefaultOnDataMismatchAdapter(var3.nextAdapter(this, var4, var2), this.val$defaultValue);
         }
      };
   }

   public Object fromJson(JsonReader var1) throws IOException {
      JsonReader var3 = var1.peekJson();

      Object var2;
      try {
         var2 = this.delegate.fromJson(var3);
      } catch (JsonDataException var6) {
         var2 = this.defaultValue;
      } finally {
         var3.close();
      }

      var1.skipValue();
      return var2;
   }

   public void toJson(JsonWriter var1, Object var2) throws IOException {
      this.delegate.toJson(var1, var2);
   }
}
