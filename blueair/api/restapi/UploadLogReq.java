package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"},
   d2 = {"Lcom/blueair/api/restapi/UploadLogReq;", "Lcom/blueair/api/restapi/PresignUploadReq;", "gigyaUid", "", "cloudRegion", "type", "length", "purpose", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGigyaUid", "()Ljava/lang/String;", "getCloudRegion", "getType", "getLength", "getPurpose", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class UploadLogReq extends PresignUploadReq {
   private final String cloudRegion;
   private final String gigyaUid;
   private final String length;
   private final String purpose;
   private final String type;

   public UploadLogReq(String var1, String var2, String var3, String var4, String var5) {
      Intrinsics.checkNotNullParameter(var1, "gigyaUid");
      Intrinsics.checkNotNullParameter(var2, "cloudRegion");
      Intrinsics.checkNotNullParameter(var3, "type");
      Intrinsics.checkNotNullParameter(var4, "length");
      Intrinsics.checkNotNullParameter(var5, "purpose");
      super();
      this.gigyaUid = var1;
      this.cloudRegion = var2;
      this.type = var3;
      this.length = var4;
      this.purpose = var5;
   }

   // $FF: synthetic method
   public UploadLogReq(String var1, String var2, String var3, String var4, String var5, int var6, DefaultConstructorMarker var7) {
      if ((var6 & 16) != 0) {
         var5 = "log";
      }

      this(var1, var2, var3, var4, var5);
   }

   // $FF: synthetic method
   public static UploadLogReq copy$default(UploadLogReq var0, String var1, String var2, String var3, String var4, String var5, int var6, Object var7) {
      if ((var6 & 1) != 0) {
         var1 = var0.gigyaUid;
      }

      if ((var6 & 2) != 0) {
         var2 = var0.cloudRegion;
      }

      if ((var6 & 4) != 0) {
         var3 = var0.type;
      }

      if ((var6 & 8) != 0) {
         var4 = var0.length;
      }

      if ((var6 & 16) != 0) {
         var5 = var0.purpose;
      }

      return var0.copy(var1, var2, var3, var4, var5);
   }

   public final String component1() {
      return this.gigyaUid;
   }

   public final String component2() {
      return this.cloudRegion;
   }

   public final String component3() {
      return this.type;
   }

   public final String component4() {
      return this.length;
   }

   public final String component5() {
      return this.purpose;
   }

   public final UploadLogReq copy(String var1, String var2, String var3, String var4, String var5) {
      Intrinsics.checkNotNullParameter(var1, "gigyaUid");
      Intrinsics.checkNotNullParameter(var2, "cloudRegion");
      Intrinsics.checkNotNullParameter(var3, "type");
      Intrinsics.checkNotNullParameter(var4, "length");
      Intrinsics.checkNotNullParameter(var5, "purpose");
      return new UploadLogReq(var1, var2, var3, var4, var5);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof UploadLogReq)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.gigyaUid, var1.gigyaUid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.cloudRegion, var1.cloudRegion)) {
            return false;
         } else if (!Intrinsics.areEqual(this.type, var1.type)) {
            return false;
         } else if (!Intrinsics.areEqual(this.length, var1.length)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.purpose, var1.purpose);
         }
      }
   }

   public final String getCloudRegion() {
      return this.cloudRegion;
   }

   public final String getGigyaUid() {
      return this.gigyaUid;
   }

   public final String getLength() {
      return this.length;
   }

   public String getPurpose() {
      return this.purpose;
   }

   public final String getType() {
      return this.type;
   }

   public int hashCode() {
      return (((this.gigyaUid.hashCode() * 31 + this.cloudRegion.hashCode()) * 31 + this.type.hashCode()) * 31 + this.length.hashCode()) * 31 + this.purpose.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("UploadLogReq(gigyaUid=");
      var1.append(this.gigyaUid);
      var1.append(", cloudRegion=");
      var1.append(this.cloudRegion);
      var1.append(", type=");
      var1.append(this.type);
      var1.append(", length=");
      var1.append(this.length);
      var1.append(", purpose=");
      var1.append(this.purpose);
      var1.append(')');
      return var1.toString();
   }
}
