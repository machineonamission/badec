package com.blueair.viewcore;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ:\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"},
   d2 = {"Lcom/blueair/viewcore/Header;", "", "title", "", "message", "iconDrawableResource", "", "stepOrdinal", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getTitle", "()Ljava/lang/String;", "getMessage", "getIconDrawableResource", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStepOrdinal", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/blueair/viewcore/Header;", "equals", "", "other", "hashCode", "toString", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class Header {
   private final Integer iconDrawableResource;
   private final String message;
   private final Integer stepOrdinal;
   private final String title;

   public Header(String var1, String var2, Integer var3, Integer var4) {
      Intrinsics.checkNotNullParameter(var1, "title");
      Intrinsics.checkNotNullParameter(var2, "message");
      super();
      this.title = var1;
      this.message = var2;
      this.iconDrawableResource = var3;
      this.stepOrdinal = var4;
   }

   // $FF: synthetic method
   public static Header copy$default(Header var0, String var1, String var2, Integer var3, Integer var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.title;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.message;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.iconDrawableResource;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.stepOrdinal;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   public final String component1() {
      return this.title;
   }

   public final String component2() {
      return this.message;
   }

   public final Integer component3() {
      return this.iconDrawableResource;
   }

   public final Integer component4() {
      return this.stepOrdinal;
   }

   public final Header copy(String var1, String var2, Integer var3, Integer var4) {
      Intrinsics.checkNotNullParameter(var1, "title");
      Intrinsics.checkNotNullParameter(var2, "message");
      return new Header(var1, var2, var3, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof Header)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.title, var1.title)) {
            return false;
         } else if (!Intrinsics.areEqual(this.message, var1.message)) {
            return false;
         } else if (!Intrinsics.areEqual(this.iconDrawableResource, var1.iconDrawableResource)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.stepOrdinal, var1.stepOrdinal);
         }
      }
   }

   public final Integer getIconDrawableResource() {
      return this.iconDrawableResource;
   }

   public final String getMessage() {
      return this.message;
   }

   public final Integer getStepOrdinal() {
      return this.stepOrdinal;
   }

   public final String getTitle() {
      return this.title;
   }

   public int hashCode() {
      int var4 = this.title.hashCode();
      int var3 = this.message.hashCode();
      Integer var5 = this.iconDrawableResource;
      int var2 = 0;
      int var1;
      if (var5 == null) {
         var1 = 0;
      } else {
         var1 = var5.hashCode();
      }

      var5 = this.stepOrdinal;
      if (var5 != null) {
         var2 = var5.hashCode();
      }

      return ((var4 * 31 + var3) * 31 + var1) * 31 + var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("Header(title=");
      var1.append(this.title);
      var1.append(", message=");
      var1.append(this.message);
      var1.append(", iconDrawableResource=");
      var1.append(this.iconDrawableResource);
      var1.append(", stepOrdinal=");
      var1.append(this.stepOrdinal);
      var1.append(')');
      return var1.toString();
   }
}
