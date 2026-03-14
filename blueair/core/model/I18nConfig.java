package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.core.util.LocaleUtils;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.ToJson;
import com.squareup.moshi.JsonReader.Token;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u00016B\u0089\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008d\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010)\u001a\u00020*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020*HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020*R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u00067"},
   d2 = {"Lcom/blueair/core/model/I18nConfig;", "Landroid/os/Parcelable;", "default", "", "en", "fr", "ja", "ko", "es", "sv", "de", "pl", "zhHans", "zhHant", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDefault", "()Ljava/lang/String;", "getEn", "getFr", "getJa", "getKo", "getEs", "getSv", "getDe", "getPl", "getZhHans", "getZhHant", "getValue", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Adapter", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class I18nConfig implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final String de;
   private final String default;
   private final String en;
   private final String es;
   private final String fr;
   private final String ja;
   private final String ko;
   private final String pl;
   private final String sv;
   private final String zhHans;
   private final String zhHant;

   public I18nConfig(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, @Json(name = "zh-Hans") String var10, @Json(name = "zh-Hant") String var11) {
      this.default = var1;
      this.en = var2;
      this.fr = var3;
      this.ja = var4;
      this.ko = var5;
      this.es = var6;
      this.sv = var7;
      this.de = var8;
      this.pl = var9;
      this.zhHans = var10;
      this.zhHant = var11;
   }

   // $FF: synthetic method
   public I18nConfig(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, int var12, DefaultConstructorMarker var13) {
      if ((var12 & 2) != 0) {
         var2 = null;
      }

      if ((var12 & 4) != 0) {
         var3 = null;
      }

      if ((var12 & 8) != 0) {
         var4 = null;
      }

      if ((var12 & 16) != 0) {
         var5 = null;
      }

      if ((var12 & 32) != 0) {
         var6 = null;
      }

      if ((var12 & 64) != 0) {
         var7 = null;
      }

      if ((var12 & 128) != 0) {
         var8 = null;
      }

      if ((var12 & 256) != 0) {
         var9 = null;
      }

      if ((var12 & 512) != 0) {
         var10 = null;
      }

      if ((var12 & 1024) != 0) {
         var11 = null;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   // $FF: synthetic method
   public static I18nConfig copy$default(I18nConfig var0, String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, int var12, Object var13) {
      if ((var12 & 1) != 0) {
         var1 = var0.default;
      }

      if ((var12 & 2) != 0) {
         var2 = var0.en;
      }

      if ((var12 & 4) != 0) {
         var3 = var0.fr;
      }

      if ((var12 & 8) != 0) {
         var4 = var0.ja;
      }

      if ((var12 & 16) != 0) {
         var5 = var0.ko;
      }

      if ((var12 & 32) != 0) {
         var6 = var0.es;
      }

      if ((var12 & 64) != 0) {
         var7 = var0.sv;
      }

      if ((var12 & 128) != 0) {
         var8 = var0.de;
      }

      if ((var12 & 256) != 0) {
         var9 = var0.pl;
      }

      if ((var12 & 512) != 0) {
         var10 = var0.zhHans;
      }

      if ((var12 & 1024) != 0) {
         var11 = var0.zhHant;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   public final String component1() {
      return this.default;
   }

   public final String component10() {
      return this.zhHans;
   }

   public final String component11() {
      return this.zhHant;
   }

   public final String component2() {
      return this.en;
   }

   public final String component3() {
      return this.fr;
   }

   public final String component4() {
      return this.ja;
   }

   public final String component5() {
      return this.ko;
   }

   public final String component6() {
      return this.es;
   }

   public final String component7() {
      return this.sv;
   }

   public final String component8() {
      return this.de;
   }

   public final String component9() {
      return this.pl;
   }

   public final I18nConfig copy(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, @Json(name = "zh-Hans") String var10, @Json(name = "zh-Hant") String var11) {
      return new I18nConfig(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof I18nConfig)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.default, var1.default)) {
            return false;
         } else if (!Intrinsics.areEqual(this.en, var1.en)) {
            return false;
         } else if (!Intrinsics.areEqual(this.fr, var1.fr)) {
            return false;
         } else if (!Intrinsics.areEqual(this.ja, var1.ja)) {
            return false;
         } else if (!Intrinsics.areEqual(this.ko, var1.ko)) {
            return false;
         } else if (!Intrinsics.areEqual(this.es, var1.es)) {
            return false;
         } else if (!Intrinsics.areEqual(this.sv, var1.sv)) {
            return false;
         } else if (!Intrinsics.areEqual(this.de, var1.de)) {
            return false;
         } else if (!Intrinsics.areEqual(this.pl, var1.pl)) {
            return false;
         } else if (!Intrinsics.areEqual(this.zhHans, var1.zhHans)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.zhHant, var1.zhHant);
         }
      }
   }

   public final String getDe() {
      return this.de;
   }

   public final String getDefault() {
      return this.default;
   }

   public final String getEn() {
      return this.en;
   }

   public final String getEs() {
      return this.es;
   }

   public final String getFr() {
      return this.fr;
   }

   public final String getJa() {
      return this.ja;
   }

   public final String getKo() {
      return this.ko;
   }

   public final String getPl() {
      return this.pl;
   }

   public final String getSv() {
      return this.sv;
   }

   public final String getValue() {
      String var4;
      label78: {
         label77: {
            var4 = LocaleUtils.INSTANCE.getLanguageCode();
            int var1 = var4.hashCode();
            if (var1 != 3201) {
               if (var1 != 3241) {
                  if (var1 != 3246) {
                     if (var1 != 3276) {
                        if (var1 != 3383) {
                           if (var1 != 3428) {
                              if (var1 != 3580) {
                                 if (var1 != 3683) {
                                    if (var1 != 3886) {
                                       switch (var1) {
                                          case -372468771:
                                             if (var4.equals("zh-Hans")) {
                                                break label77;
                                             }
                                             break;
                                          case -372468770:
                                             if (var4.equals("zh-Hant")) {
                                                var4 = this.zhHant;
                                                break label78;
                                             }
                                       }
                                    } else if (var4.equals("zh")) {
                                       break label77;
                                    }
                                 } else if (var4.equals("sv")) {
                                    var4 = this.sv;
                                    break label78;
                                 }
                              } else if (var4.equals("pl")) {
                                 var4 = this.pl;
                                 break label78;
                              }
                           } else if (var4.equals("ko")) {
                              var4 = this.ko;
                              break label78;
                           }
                        } else if (var4.equals("ja")) {
                           var4 = this.ja;
                           break label78;
                        }
                     } else if (var4.equals("fr")) {
                        var4 = this.fr;
                        break label78;
                     }
                  } else if (var4.equals("es")) {
                     var4 = this.es;
                     break label78;
                  }
               } else if (var4.equals("en")) {
                  var4 = this.en;
                  break label78;
               }
            } else if (var4.equals("de")) {
               var4 = this.de;
               break label78;
            }

            var4 = this.default;
            break label78;
         }

         var4 = this.zhHans;
      }

      String var3 = var4;
      if (var4 == null) {
         var3 = this.default;
      }

      return var3;
   }

   public final String getZhHans() {
      return this.zhHans;
   }

   public final String getZhHant() {
      return this.zhHant;
   }

   public int hashCode() {
      String var12 = this.default;
      int var11 = 0;
      int var1;
      if (var12 == null) {
         var1 = 0;
      } else {
         var1 = var12.hashCode();
      }

      var12 = this.en;
      int var2;
      if (var12 == null) {
         var2 = 0;
      } else {
         var2 = var12.hashCode();
      }

      var12 = this.fr;
      int var3;
      if (var12 == null) {
         var3 = 0;
      } else {
         var3 = var12.hashCode();
      }

      var12 = this.ja;
      int var4;
      if (var12 == null) {
         var4 = 0;
      } else {
         var4 = var12.hashCode();
      }

      var12 = this.ko;
      int var5;
      if (var12 == null) {
         var5 = 0;
      } else {
         var5 = var12.hashCode();
      }

      var12 = this.es;
      int var6;
      if (var12 == null) {
         var6 = 0;
      } else {
         var6 = var12.hashCode();
      }

      var12 = this.sv;
      int var7;
      if (var12 == null) {
         var7 = 0;
      } else {
         var7 = var12.hashCode();
      }

      var12 = this.de;
      int var8;
      if (var12 == null) {
         var8 = 0;
      } else {
         var8 = var12.hashCode();
      }

      var12 = this.pl;
      int var9;
      if (var12 == null) {
         var9 = 0;
      } else {
         var9 = var12.hashCode();
      }

      var12 = this.zhHans;
      int var10;
      if (var12 == null) {
         var10 = 0;
      } else {
         var10 = var12.hashCode();
      }

      var12 = this.zhHant;
      if (var12 != null) {
         var11 = var12.hashCode();
      }

      return (((((((((var1 * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var7) * 31 + var8) * 31 + var9) * 31 + var10) * 31 + var11;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("I18nConfig(default=");
      var1.append(this.default);
      var1.append(", en=");
      var1.append(this.en);
      var1.append(", fr=");
      var1.append(this.fr);
      var1.append(", ja=");
      var1.append(this.ja);
      var1.append(", ko=");
      var1.append(this.ko);
      var1.append(", es=");
      var1.append(this.es);
      var1.append(", sv=");
      var1.append(this.sv);
      var1.append(", de=");
      var1.append(this.de);
      var1.append(", pl=");
      var1.append(this.pl);
      var1.append(", zhHans=");
      var1.append(this.zhHans);
      var1.append(", zhHant=");
      var1.append(this.zhHant);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeString(this.default);
      var1.writeString(this.en);
      var1.writeString(this.fr);
      var1.writeString(this.ja);
      var1.writeString(this.ko);
      var1.writeString(this.es);
      var1.writeString(this.sv);
      var1.writeString(this.de);
      var1.writeString(this.pl);
      var1.writeString(this.zhHans);
      var1.writeString(this.zhHant);
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\tH\u0017J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0017R2\u0010\u0005\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00020\u0002 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"},
      d2 = {"Lcom/blueair/core/model/I18nConfig$Adapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/blueair/core/model/I18nConfig;", "<init>", "()V", "adapter", "kotlin.jvm.PlatformType", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Adapter extends JsonAdapter {
      public static final Adapter INSTANCE = new Adapter();
      private static final JsonAdapter adapter = (new Moshi.Builder()).add((JsonAdapter.Factory)(new KotlinJsonAdapterFactory())).build().adapter(I18nConfig.class);

      private Adapter() {
      }

      @FromJson
      public I18nConfig fromJson(JsonReader var1) {
         Intrinsics.checkNotNullParameter(var1, "reader");
         JsonReader.Token var3 = var1.peek();
         int var2;
         if (var3 == null) {
            var2 = -1;
         } else {
            var2 = I18nConfig.Adapter.WhenMappings.$EnumSwitchMapping$0[var3.ordinal()];
         }

         if (var2 != 1) {
            return var2 != 2 ? null : new I18nConfig(var1.nextString(), (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, 2046, (DefaultConstructorMarker)null);
         } else {
            return (I18nConfig)adapter.fromJson(var1);
         }
      }

      @ToJson
      public void toJson(JsonWriter var1, I18nConfig var2) {
         Intrinsics.checkNotNullParameter(var1, "writer");
         adapter.toJson(var1, var2);
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
      public final I18nConfig createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         return new I18nConfig(var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString());
      }

      public final I18nConfig[] newArray(int var1) {
         return new I18nConfig[var1];
      }
   }
}
