package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\""},
   d2 = {"Lcom/blueair/api/restapi/UploadLogRsp;", "Lcom/blueair/api/restapi/PresignUploadRsp;", "url", "", "fields", "", "expiresIn", "", "maxBytes", "", "logUuid", "<init>", "(Ljava/lang/String;Ljava/util/Map;IJLjava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getFields", "()Ljava/util/Map;", "getExpiresIn", "()I", "getMaxBytes", "()J", "getLogUuid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class UploadLogRsp extends PresignUploadRsp {
   private final int expiresIn;
   private final Map fields;
   private final String logUuid;
   private final long maxBytes;
   private final String url;

   public UploadLogRsp(String var1, Map var2, int var3, long var4, String var6) {
      Intrinsics.checkNotNullParameter(var1, "url");
      Intrinsics.checkNotNullParameter(var2, "fields");
      Intrinsics.checkNotNullParameter(var6, "logUuid");
      super();
      this.url = var1;
      this.fields = var2;
      this.expiresIn = var3;
      this.maxBytes = var4;
      this.logUuid = var6;
   }

   // $FF: synthetic method
   public static UploadLogRsp copy$default(UploadLogRsp var0, String var1, Map var2, int var3, long var4, String var6, int var7, Object var8) {
      if ((var7 & 1) != 0) {
         var1 = var0.url;
      }

      if ((var7 & 2) != 0) {
         var2 = var0.fields;
      }

      if ((var7 & 4) != 0) {
         var3 = var0.expiresIn;
      }

      if ((var7 & 8) != 0) {
         var4 = var0.maxBytes;
      }

      if ((var7 & 16) != 0) {
         var6 = var0.logUuid;
      }

      return var0.copy(var1, var2, var3, var4, var6);
   }

   public final String component1() {
      return this.url;
   }

   public final Map component2() {
      return this.fields;
   }

   public final int component3() {
      return this.expiresIn;
   }

   public final long component4() {
      return this.maxBytes;
   }

   public final String component5() {
      return this.logUuid;
   }

   public final UploadLogRsp copy(String var1, Map var2, int var3, long var4, String var6) {
      Intrinsics.checkNotNullParameter(var1, "url");
      Intrinsics.checkNotNullParameter(var2, "fields");
      Intrinsics.checkNotNullParameter(var6, "logUuid");
      return new UploadLogRsp(var1, var2, var3, var4, var6);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof UploadLogRsp)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.url, var1.url)) {
            return false;
         } else if (!Intrinsics.areEqual(this.fields, var1.fields)) {
            return false;
         } else if (this.expiresIn != var1.expiresIn) {
            return false;
         } else if (this.maxBytes != var1.maxBytes) {
            return false;
         } else {
            return Intrinsics.areEqual(this.logUuid, var1.logUuid);
         }
      }
   }

   public int getExpiresIn() {
      return this.expiresIn;
   }

   public Map getFields() {
      return this.fields;
   }

   public final String getLogUuid() {
      return this.logUuid;
   }

   public long getMaxBytes() {
      return this.maxBytes;
   }

   public String getUrl() {
      return this.url;
   }

   public int hashCode() {
      return (((this.url.hashCode() * 31 + this.fields.hashCode()) * 31 + this.expiresIn) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.maxBytes)) * 31 + this.logUuid.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("UploadLogRsp(url=");
      var1.append(this.url);
      var1.append(", fields=");
      var1.append(this.fields);
      var1.append(", expiresIn=");
      var1.append(this.expiresIn);
      var1.append(", maxBytes=");
      var1.append(this.maxBytes);
      var1.append(", logUuid=");
      var1.append(this.logUuid);
      var1.append(')');
      return var1.toString();
   }
}
