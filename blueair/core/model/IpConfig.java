package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.ToJson;
import com.squareup.moshi.Types;
import com.squareup.moshi.JsonReader.Token;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001 B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006!"},
   d2 = {"Lcom/blueair/core/model/IpConfig;", "Landroid/os/Parcelable;", "map", "", "", "<init>", "(Ljava/util/Map;)V", "default", "(Ljava/lang/String;)V", "getMap", "()Ljava/util/Map;", "getDefault$annotations", "()V", "getDefault", "()Ljava/lang/String;", "getValue", "ip", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Adapter", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class IpConfig implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final String default;
   private final Map map;

   public IpConfig(String var1) {
      Intrinsics.checkNotNullParameter(var1, "default");
      this(MapsKt.mapOf(TuplesKt.to("default", var1)));
   }

   public IpConfig(Map var1) {
      Intrinsics.checkNotNullParameter(var1, "map");
      super();
      this.map = var1;
      this.default = (String)var1.get("default");
   }

   // $FF: synthetic method
   public static IpConfig copy$default(IpConfig var0, Map var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.map;
      }

      return var0.copy(var1);
   }

   // $FF: synthetic method
   public static void getDefault$annotations() {
   }

   public final Map component1() {
      return this.map;
   }

   public final IpConfig copy(Map var1) {
      Intrinsics.checkNotNullParameter(var1, "map");
      return new IpConfig(var1);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof IpConfig)) {
         return false;
      } else {
         var1 = var1;
         return Intrinsics.areEqual(this.map, var1.map);
      }
   }

   public final String getDefault() {
      return this.default;
   }

   public final Map getMap() {
      return this.map;
   }

   public final String getValue(String var1) {
      Map var2 = this.map;
      if (var1 != null) {
         var1 = var1.toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var1, "toLowerCase(...)");
      } else {
         var1 = null;
      }

      String var5 = (String)var2.get(var1);
      var1 = var5;
      if (var5 == null) {
         var1 = this.default;
      }

      return var1;
   }

   public int hashCode() {
      return this.map.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("IpConfig(map=");
      var1.append(this.map);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      Map var3 = this.map;
      var1.writeInt(var3.size());

      for(Map.Entry var5 : var3.entrySet()) {
         var1.writeString((String)var5.getKey());
         var1.writeString((String)var5.getValue());
      }

   }

   @Metadata(
      d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0017J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0017Rb\u0010\u0005\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007 \b*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0006 \b**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007 \b*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0006\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/IpConfig$Adapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/blueair/core/model/IpConfig;", "<init>", "()V", "adapter", "", "", "kotlin.jvm.PlatformType", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Adapter extends JsonAdapter {
      public static final Adapter INSTANCE = new Adapter();
      private static final JsonAdapter adapter = (new Moshi.Builder()).add((JsonAdapter.Factory)(new KotlinJsonAdapterFactory())).build().adapter((Type)Types.newParameterizedType((Type)Map.class, new Type[]{String.class, String.class}));

      private Adapter() {
      }

      @FromJson
      public IpConfig fromJson(JsonReader var1) {
         Intrinsics.checkNotNullParameter(var1, "reader");
         JsonReader.Token var3 = var1.peek();
         int var2;
         if (var3 == null) {
            var2 = -1;
         } else {
            var2 = IpConfig.Adapter.WhenMappings.$EnumSwitchMapping$0[var3.ordinal()];
         }

         if (var2 != 1) {
            if (var2 != 2) {
               return null;
            } else {
               String var5 = var1.nextString();
               Intrinsics.checkNotNullExpressionValue(var5, "nextString(...)");
               return new IpConfig(var5);
            }
         } else {
            Map var6 = (Map)adapter.fromJson(var1);
            Map var4 = var6;
            if (var6 == null) {
               var4 = MapsKt.emptyMap();
            }

            return new IpConfig(var4);
         }
      }

      @ToJson
      public void toJson(JsonWriter var1, IpConfig var2) {
         Intrinsics.checkNotNullParameter(var1, "writer");
         JsonAdapter var3 = adapter;
         Map var4;
         if (var2 != null) {
            var4 = var2.getMap();
         } else {
            var4 = null;
         }

         var3.toJson(var1, var4);
      }

      // $FF: synthetic class
      @Metadata(
         k = 3,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class WhenMappings {
         public static final int[] $EnumSwitchMapping$0;

         static {
            int[] var0 = new int[Token.values().length];

            try {
               var0[Token.BEGIN_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError var3) {
            }

            try {
               var0[Token.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError var2) {
            }

            $EnumSwitchMapping$0 = var0;
         }
      }
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final IpConfig createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         int var3 = var1.readInt();
         LinkedHashMap var4 = new LinkedHashMap(var3);

         for(int var2 = 0; var2 != var3; ++var2) {
            var4.put(var1.readString(), var1.readString());
         }

         return new IpConfig((Map)var4);
      }

      public final IpConfig[] newArray(int var1) {
         return new IpConfig[var1];
      }
   }
}
