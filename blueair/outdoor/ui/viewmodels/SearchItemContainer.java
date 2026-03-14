package com.blueair.outdoor.ui.viewmodels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"},
   d2 = {"Lcom/blueair/outdoor/ui/viewmodels/SearchItemContainer;", "", "primaryText", "", "secondaryText", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPrimaryText", "()Ljava/lang/String;", "getSecondaryText", "getId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SearchItemContainer {
   private final String id;
   private final String primaryText;
   private final String secondaryText;

   public SearchItemContainer(String var1, String var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "primaryText");
      Intrinsics.checkNotNullParameter(var2, "secondaryText");
      Intrinsics.checkNotNullParameter(var3, "id");
      super();
      this.primaryText = var1;
      this.secondaryText = var2;
      this.id = var3;
   }

   // $FF: synthetic method
   public static SearchItemContainer copy$default(SearchItemContainer var0, String var1, String var2, String var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.primaryText;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.secondaryText;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.id;
      }

      return var0.copy(var1, var2, var3);
   }

   public final String component1() {
      return this.primaryText;
   }

   public final String component2() {
      return this.secondaryText;
   }

   public final String component3() {
      return this.id;
   }

   public final SearchItemContainer copy(String var1, String var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "primaryText");
      Intrinsics.checkNotNullParameter(var2, "secondaryText");
      Intrinsics.checkNotNullParameter(var3, "id");
      return new SearchItemContainer(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof SearchItemContainer)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.primaryText, var1.primaryText)) {
            return false;
         } else if (!Intrinsics.areEqual(this.secondaryText, var1.secondaryText)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.id, var1.id);
         }
      }
   }

   public final String getId() {
      return this.id;
   }

   public final String getPrimaryText() {
      return this.primaryText;
   }

   public final String getSecondaryText() {
      return this.secondaryText;
   }

   public int hashCode() {
      return (this.primaryText.hashCode() * 31 + this.secondaryText.hashCode()) * 31 + this.id.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("SearchItemContainer(primaryText=");
      var1.append(this.primaryText);
      var1.append(", secondaryText=");
      var1.append(this.secondaryText);
      var1.append(", id=");
      var1.append(this.id);
      var1.append(')');
      return var1.toString();
   }
}
