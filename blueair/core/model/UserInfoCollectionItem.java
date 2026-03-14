package com.blueair.core.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JK\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\tHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016¨\u0006)"},
   d2 = {"Lcom/blueair/core/model/UserInfoCollectionItem;", "", "id", "", "name", "Lcom/blueair/core/model/I18nConfig;", "scenario", "usage", "omitted", "", "records", "", "Lcom/blueair/core/model/UserInfoCollectionRecord;", "<init>", "(Ljava/lang/String;Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;ILjava/util/List;)V", "getId", "()Ljava/lang/String;", "getName", "()Lcom/blueair/core/model/I18nConfig;", "getScenario", "getUsage", "getOmitted", "()I", "setOmitted", "(I)V", "getRecords", "()Ljava/util/List;", "recordsCount", "getRecordsCount", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class UserInfoCollectionItem {
   private final String id;
   private final I18nConfig name;
   private int omitted;
   private final List records;
   private final I18nConfig scenario;
   private final I18nConfig usage;

   public UserInfoCollectionItem(String var1, I18nConfig var2, I18nConfig var3, I18nConfig var4, int var5, List var6) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var3, "scenario");
      Intrinsics.checkNotNullParameter(var4, "usage");
      Intrinsics.checkNotNullParameter(var6, "records");
      super();
      this.id = var1;
      this.name = var2;
      this.scenario = var3;
      this.usage = var4;
      this.omitted = var5;
      this.records = var6;
   }

   // $FF: synthetic method
   public UserInfoCollectionItem(String var1, I18nConfig var2, I18nConfig var3, I18nConfig var4, int var5, List var6, int var7, DefaultConstructorMarker var8) {
      if ((var7 & 16) != 0) {
         var5 = 0;
      }

      if ((var7 & 32) != 0) {
         var6 = (List)(new ArrayList());
      }

      this(var1, var2, var3, var4, var5, var6);
   }

   // $FF: synthetic method
   public static UserInfoCollectionItem copy$default(UserInfoCollectionItem var0, String var1, I18nConfig var2, I18nConfig var3, I18nConfig var4, int var5, List var6, int var7, Object var8) {
      if ((var7 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var7 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var7 & 4) != 0) {
         var3 = var0.scenario;
      }

      if ((var7 & 8) != 0) {
         var4 = var0.usage;
      }

      if ((var7 & 16) != 0) {
         var5 = var0.omitted;
      }

      if ((var7 & 32) != 0) {
         var6 = var0.records;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6);
   }

   public final String component1() {
      return this.id;
   }

   public final I18nConfig component2() {
      return this.name;
   }

   public final I18nConfig component3() {
      return this.scenario;
   }

   public final I18nConfig component4() {
      return this.usage;
   }

   public final int component5() {
      return this.omitted;
   }

   public final List component6() {
      return this.records;
   }

   public final UserInfoCollectionItem copy(String var1, I18nConfig var2, I18nConfig var3, I18nConfig var4, int var5, List var6) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var3, "scenario");
      Intrinsics.checkNotNullParameter(var4, "usage");
      Intrinsics.checkNotNullParameter(var6, "records");
      return new UserInfoCollectionItem(var1, var2, var3, var4, var5, var6);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof UserInfoCollectionItem)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.id, var1.id)) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (!Intrinsics.areEqual(this.scenario, var1.scenario)) {
            return false;
         } else if (!Intrinsics.areEqual(this.usage, var1.usage)) {
            return false;
         } else if (this.omitted != var1.omitted) {
            return false;
         } else {
            return Intrinsics.areEqual(this.records, var1.records);
         }
      }
   }

   public final String getId() {
      return this.id;
   }

   public final I18nConfig getName() {
      return this.name;
   }

   public final int getOmitted() {
      return this.omitted;
   }

   public final List getRecords() {
      return this.records;
   }

   public final int getRecordsCount() {
      return this.omitted + this.records.size();
   }

   public final I18nConfig getScenario() {
      return this.scenario;
   }

   public final I18nConfig getUsage() {
      return this.usage;
   }

   public int hashCode() {
      return ((((this.id.hashCode() * 31 + this.name.hashCode()) * 31 + this.scenario.hashCode()) * 31 + this.usage.hashCode()) * 31 + this.omitted) * 31 + this.records.hashCode();
   }

   public final void setOmitted(int var1) {
      this.omitted = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("UserInfoCollectionItem(id=");
      var1.append(this.id);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", scenario=");
      var1.append(this.scenario);
      var1.append(", usage=");
      var1.append(this.usage);
      var1.append(", omitted=");
      var1.append(this.omitted);
      var1.append(", records=");
      var1.append(this.records);
      var1.append(')');
      return var1.toString();
   }
}
