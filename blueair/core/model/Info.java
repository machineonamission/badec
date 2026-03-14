package com.blueair.core.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"},
   d2 = {"Lcom/blueair/core/model/Info;", "", "progress", "", "eventCode", "imageId", "", "stage", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getProgress", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEventCode", "getImageId", "()Ljava/lang/String;", "getStage", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/blueair/core/model/Info;", "equals", "", "other", "hashCode", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class Info {
   private final Integer eventCode;
   private final String imageId;
   private final Integer progress;
   private final String stage;

   public Info(@Json(name = "c") Integer var1, @Json(name = "ec") Integer var2, String var3, String var4) {
      this.progress = var1;
      this.eventCode = var2;
      this.imageId = var3;
      this.stage = var4;
   }

   // $FF: synthetic method
   public static Info copy$default(Info var0, Integer var1, Integer var2, String var3, String var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.progress;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.eventCode;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.imageId;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.stage;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   public final Integer component1() {
      return this.progress;
   }

   public final Integer component2() {
      return this.eventCode;
   }

   public final String component3() {
      return this.imageId;
   }

   public final String component4() {
      return this.stage;
   }

   public final Info copy(@Json(name = "c") Integer var1, @Json(name = "ec") Integer var2, String var3, String var4) {
      return new Info(var1, var2, var3, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof Info)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.progress, var1.progress)) {
            return false;
         } else if (!Intrinsics.areEqual(this.eventCode, var1.eventCode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.imageId, var1.imageId)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.stage, var1.stage);
         }
      }
   }

   public final Integer getEventCode() {
      return this.eventCode;
   }

   public final String getImageId() {
      return this.imageId;
   }

   public final Integer getProgress() {
      return this.progress;
   }

   public final String getStage() {
      return this.stage;
   }

   public int hashCode() {
      Integer var5 = this.progress;
      int var4 = 0;
      int var1;
      if (var5 == null) {
         var1 = 0;
      } else {
         var1 = var5.hashCode();
      }

      var5 = this.eventCode;
      int var2;
      if (var5 == null) {
         var2 = 0;
      } else {
         var2 = var5.hashCode();
      }

      String var7 = this.imageId;
      int var3;
      if (var7 == null) {
         var3 = 0;
      } else {
         var3 = var7.hashCode();
      }

      var7 = this.stage;
      if (var7 != null) {
         var4 = var7.hashCode();
      }

      return ((var1 * 31 + var2) * 31 + var3) * 31 + var4;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("Info(progress=");
      var1.append(this.progress);
      var1.append(", eventCode=");
      var1.append(this.eventCode);
      var1.append(", imageId=");
      var1.append(this.imageId);
      var1.append(", stage=");
      var1.append(this.stage);
      var1.append(')');
      return var1.toString();
   }
}
