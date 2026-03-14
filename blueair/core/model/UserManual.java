package com.blueair.core.model;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0019"},
   d2 = {"Lcom/blueair/core/model/UserManual;", "", "link", "", "<init>", "(Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "startIndex", "", "getStartIndex", "()I", "filterIndex", "getFilterIndex", "wickIndex", "getWickIndex", "refresherIndex", "getRefresherIndex", "component1", "copy", "equals", "", "other", "hashCode", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class UserManual {
   private final int filterIndex;
   private final String link;
   private final int refresherIndex;
   private final int startIndex;
   private final int wickIndex;

   public UserManual(String var1) {
      int var2;
      byte var3;
      label36: {
         Intrinsics.checkNotNullParameter(var1, "link");
         super();
         this.link = var1;
         var5 = Uri.parse(var1);
         Intrinsics.checkNotNullExpressionValue(var5, "parse(this)");
         String var4 = var5.getQueryParameter("start_index");
         var3 = 1;
         if (var4 != null) {
            Integer var11 = StringsKt.toIntOrNull(var4);
            if (var11 != null) {
               var2 = var11;
               break label36;
            }
         }

         var2 = 1;
      }

      label31: {
         this.startIndex = var2;
         String var12 = var5.getQueryParameter("filter_index");
         if (var12 != null) {
            Integer var13 = StringsKt.toIntOrNull(var12);
            if (var13 != null) {
               var2 = var13;
               break label31;
            }
         }

         var2 = 1;
      }

      label26: {
         this.filterIndex = var2;
         String var14 = var5.getQueryParameter("wick_index");
         if (var14 != null) {
            Integer var15 = StringsKt.toIntOrNull(var14);
            if (var15 != null) {
               var2 = var15;
               break label26;
            }
         }

         var2 = 1;
      }

      this.wickIndex = var2;
      var1 = var5.getQueryParameter("refresher_index");
      var2 = var3;
      if (var1 != null) {
         Integer var7 = StringsKt.toIntOrNull(var1);
         var2 = var3;
         if (var7 != null) {
            var2 = var7;
         }
      }

      this.refresherIndex = var2;
   }

   // $FF: synthetic method
   public static UserManual copy$default(UserManual var0, String var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.link;
      }

      return var0.copy(var1);
   }

   public final String component1() {
      return this.link;
   }

   public final UserManual copy(String var1) {
      Intrinsics.checkNotNullParameter(var1, "link");
      return new UserManual(var1);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof UserManual)) {
         return false;
      } else {
         var1 = var1;
         return Intrinsics.areEqual(this.link, var1.link);
      }
   }

   public final int getFilterIndex() {
      return this.filterIndex;
   }

   public final String getLink() {
      return this.link;
   }

   public final int getRefresherIndex() {
      return this.refresherIndex;
   }

   public final int getStartIndex() {
      return this.startIndex;
   }

   public final int getWickIndex() {
      return this.wickIndex;
   }

   public int hashCode() {
      return this.link.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("UserManual(link=");
      var1.append(this.link);
      var1.append(')');
      return var1.toString();
   }
}
