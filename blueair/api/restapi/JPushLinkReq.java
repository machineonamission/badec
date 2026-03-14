package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"},
   d2 = {"Lcom/blueair/api/restapi/JPushLinkReq;", "", "jgid", "", "language", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getJgid", "()Ljava/lang/String;", "getLanguage", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class JPushLinkReq {
   private final String jgid;
   private final String language;

   public JPushLinkReq(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "jgid");
      Intrinsics.checkNotNullParameter(var2, "language");
      super();
      this.jgid = var1;
      this.language = var2;
   }

   // $FF: synthetic method
   public static JPushLinkReq copy$default(JPushLinkReq var0, String var1, String var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.jgid;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.language;
      }

      return var0.copy(var1, var2);
   }

   public final String component1() {
      return this.jgid;
   }

   public final String component2() {
      return this.language;
   }

   public final JPushLinkReq copy(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "jgid");
      Intrinsics.checkNotNullParameter(var2, "language");
      return new JPushLinkReq(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof JPushLinkReq)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.jgid, var1.jgid)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.language, var1.language);
         }
      }
   }

   public final String getJgid() {
      return this.jgid;
   }

   public final String getLanguage() {
      return this.language;
   }

   public int hashCode() {
      return this.jgid.hashCode() * 31 + this.language.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("JPushLinkReq(jgid=");
      var1.append(this.jgid);
      var1.append(", language=");
      var1.append(this.language);
      var1.append(')');
      return var1.toString();
   }
}
