package com.blueair.core.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"},
   d2 = {"Lcom/blueair/core/model/ChinaPrivacy;", "", "version", "", "text", "Lcom/blueair/core/model/I18nConfig;", "linkTerms", "linkPrivacy", "<init>", "(ILcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;)V", "getVersion", "()I", "getText", "()Lcom/blueair/core/model/I18nConfig;", "getLinkTerms", "getLinkPrivacy", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ChinaPrivacy {
   private final I18nConfig linkPrivacy;
   private final I18nConfig linkTerms;
   private final I18nConfig text;
   private final int version;

   public ChinaPrivacy(int var1, I18nConfig var2, @Json(name = "link_terms") I18nConfig var3, @Json(name = "link_privacy") I18nConfig var4) {
      Intrinsics.checkNotNullParameter(var2, "text");
      Intrinsics.checkNotNullParameter(var3, "linkTerms");
      Intrinsics.checkNotNullParameter(var4, "linkPrivacy");
      super();
      this.version = var1;
      this.text = var2;
      this.linkTerms = var3;
      this.linkPrivacy = var4;
   }

   // $FF: synthetic method
   public static ChinaPrivacy copy$default(ChinaPrivacy var0, int var1, I18nConfig var2, I18nConfig var3, I18nConfig var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.version;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.text;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.linkTerms;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.linkPrivacy;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   public final int component1() {
      return this.version;
   }

   public final I18nConfig component2() {
      return this.text;
   }

   public final I18nConfig component3() {
      return this.linkTerms;
   }

   public final I18nConfig component4() {
      return this.linkPrivacy;
   }

   public final ChinaPrivacy copy(int var1, I18nConfig var2, @Json(name = "link_terms") I18nConfig var3, @Json(name = "link_privacy") I18nConfig var4) {
      Intrinsics.checkNotNullParameter(var2, "text");
      Intrinsics.checkNotNullParameter(var3, "linkTerms");
      Intrinsics.checkNotNullParameter(var4, "linkPrivacy");
      return new ChinaPrivacy(var1, var2, var3, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof ChinaPrivacy)) {
         return false;
      } else {
         var1 = var1;
         if (this.version != var1.version) {
            return false;
         } else if (!Intrinsics.areEqual(this.text, var1.text)) {
            return false;
         } else if (!Intrinsics.areEqual(this.linkTerms, var1.linkTerms)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.linkPrivacy, var1.linkPrivacy);
         }
      }
   }

   public final I18nConfig getLinkPrivacy() {
      return this.linkPrivacy;
   }

   public final I18nConfig getLinkTerms() {
      return this.linkTerms;
   }

   public final I18nConfig getText() {
      return this.text;
   }

   public final int getVersion() {
      return this.version;
   }

   public int hashCode() {
      return ((this.version * 31 + this.text.hashCode()) * 31 + this.linkTerms.hashCode()) * 31 + this.linkPrivacy.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("ChinaPrivacy(version=");
      var1.append(this.version);
      var1.append(", text=");
      var1.append(this.text);
      var1.append(", linkTerms=");
      var1.append(this.linkTerms);
      var1.append(", linkPrivacy=");
      var1.append(this.linkPrivacy);
      var1.append(')');
      return var1.toString();
   }
}
