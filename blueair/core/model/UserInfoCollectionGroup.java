package com.blueair.core.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"},
   d2 = {"Lcom/blueair/core/model/UserInfoCollectionGroup;", "", "id", "", "name", "Lcom/blueair/core/model/I18nConfig;", "items", "", "Lcom/blueair/core/model/UserInfoCollectionItem;", "<init>", "(Ljava/lang/String;Lcom/blueair/core/model/I18nConfig;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getName", "()Lcom/blueair/core/model/I18nConfig;", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class UserInfoCollectionGroup {
   private final String id;
   private final List items;
   private final I18nConfig name;

   public UserInfoCollectionGroup(String var1, I18nConfig var2, List var3) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var3, "items");
      super();
      this.id = var1;
      this.name = var2;
      this.items = var3;
   }

   // $FF: synthetic method
   public UserInfoCollectionGroup(String var1, I18nConfig var2, List var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 4) != 0) {
         var3 = CollectionsKt.emptyList();
      }

      this(var1, var2, var3);
   }

   // $FF: synthetic method
   public static UserInfoCollectionGroup copy$default(UserInfoCollectionGroup var0, String var1, I18nConfig var2, List var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.items;
      }

      return var0.copy(var1, var2, var3);
   }

   public final String component1() {
      return this.id;
   }

   public final I18nConfig component2() {
      return this.name;
   }

   public final List component3() {
      return this.items;
   }

   public final UserInfoCollectionGroup copy(String var1, I18nConfig var2, List var3) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var3, "items");
      return new UserInfoCollectionGroup(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof UserInfoCollectionGroup)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.id, var1.id)) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.items, var1.items);
         }
      }
   }

   public final String getId() {
      return this.id;
   }

   public final List getItems() {
      return this.items;
   }

   public final I18nConfig getName() {
      return this.name;
   }

   public int hashCode() {
      return (this.id.hashCode() * 31 + this.name.hashCode()) * 31 + this.items.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("UserInfoCollectionGroup(id=");
      var1.append(this.id);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", items=");
      var1.append(this.items);
      var1.append(')');
      return var1.toString();
   }
}
