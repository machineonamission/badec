package com.blueair.core.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"},
   d2 = {"Lcom/blueair/core/model/UserInfoCollections;", "", "version", "", "series", "extras", "Lcom/blueair/core/model/UserInfoExtras;", "collections", "", "Lcom/blueair/core/model/UserInfoCollectionGroup;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/UserInfoExtras;Ljava/util/List;)V", "getVersion", "()Ljava/lang/String;", "getSeries", "getExtras", "()Lcom/blueair/core/model/UserInfoExtras;", "getCollections", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class UserInfoCollections {
   private final List collections;
   private final UserInfoExtras extras;
   private final String series;
   private final String version;

   public UserInfoCollections(String var1, String var2, UserInfoExtras var3, @Json(name = "user_info_collection") List var4) {
      Intrinsics.checkNotNullParameter(var1, "version");
      Intrinsics.checkNotNullParameter(var2, "series");
      Intrinsics.checkNotNullParameter(var4, "collections");
      super();
      this.version = var1;
      this.series = var2;
      this.extras = var3;
      this.collections = var4;
   }

   // $FF: synthetic method
   public static UserInfoCollections copy$default(UserInfoCollections var0, String var1, String var2, UserInfoExtras var3, List var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.version;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.series;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.extras;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.collections;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   public final String component1() {
      return this.version;
   }

   public final String component2() {
      return this.series;
   }

   public final UserInfoExtras component3() {
      return this.extras;
   }

   public final List component4() {
      return this.collections;
   }

   public final UserInfoCollections copy(String var1, String var2, UserInfoExtras var3, @Json(name = "user_info_collection") List var4) {
      Intrinsics.checkNotNullParameter(var1, "version");
      Intrinsics.checkNotNullParameter(var2, "series");
      Intrinsics.checkNotNullParameter(var4, "collections");
      return new UserInfoCollections(var1, var2, var3, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof UserInfoCollections)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.version, var1.version)) {
            return false;
         } else if (!Intrinsics.areEqual(this.series, var1.series)) {
            return false;
         } else if (!Intrinsics.areEqual(this.extras, var1.extras)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.collections, var1.collections);
         }
      }
   }

   public final List getCollections() {
      return this.collections;
   }

   public final UserInfoExtras getExtras() {
      return this.extras;
   }

   public final String getSeries() {
      return this.series;
   }

   public final String getVersion() {
      return this.version;
   }

   public int hashCode() {
      int var2 = this.version.hashCode();
      int var3 = this.series.hashCode();
      UserInfoExtras var4 = this.extras;
      int var1;
      if (var4 == null) {
         var1 = 0;
      } else {
         var1 = var4.hashCode();
      }

      return ((var2 * 31 + var3) * 31 + var1) * 31 + this.collections.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("UserInfoCollections(version=");
      var1.append(this.version);
      var1.append(", series=");
      var1.append(this.series);
      var1.append(", extras=");
      var1.append(this.extras);
      var1.append(", collections=");
      var1.append(this.collections);
      var1.append(')');
      return var1.toString();
   }
}
