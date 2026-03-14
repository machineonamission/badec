package com.blueair.android.activity;

import android.graphics.Paint.Align;
import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@SmartTable
@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"},
   d2 = {"Lcom/blueair/android/activity/InfoItemRecord;", "", "name", "", "scenario", "usage", "count", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getScenario", "getUsage", "getCount", "getContent", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class InfoItemRecord {
   public static final int $stable = 0;
   @SmartColumn(
      align = Align.LEFT,
      id = 5,
      name = "    收集内容",
      titleAlign = Align.LEFT,
      width = 100
   )
   private final String content;
   @SmartColumn(
      align = Align.LEFT,
      id = 4,
      name = "    收集情况",
      titleAlign = Align.LEFT,
      width = 150
   )
   private final String count;
   @SmartColumn(
      align = Align.LEFT,
      id = 1,
      name = "    信息名称",
      titleAlign = Align.LEFT,
      width = 150
   )
   private final String name;
   @SmartColumn(
      align = Align.LEFT,
      id = 2,
      name = "    使用场景",
      titleAlign = Align.LEFT,
      width = 200
   )
   private final String scenario;
   @SmartColumn(
      align = Align.LEFT,
      id = 3,
      name = "    使用目的",
      titleAlign = Align.LEFT,
      width = 300
   )
   private final String usage;

   public InfoItemRecord(String var1, String var2, String var3, String var4, String var5) {
      Intrinsics.checkNotNullParameter(var1, "name");
      Intrinsics.checkNotNullParameter(var2, "scenario");
      Intrinsics.checkNotNullParameter(var3, "usage");
      Intrinsics.checkNotNullParameter(var4, "count");
      Intrinsics.checkNotNullParameter(var5, "content");
      super();
      this.name = var1;
      this.scenario = var2;
      this.usage = var3;
      this.count = var4;
      this.content = var5;
   }

   // $FF: synthetic method
   public static InfoItemRecord copy$default(InfoItemRecord var0, String var1, String var2, String var3, String var4, String var5, int var6, Object var7) {
      if ((var6 & 1) != 0) {
         var1 = var0.name;
      }

      if ((var6 & 2) != 0) {
         var2 = var0.scenario;
      }

      if ((var6 & 4) != 0) {
         var3 = var0.usage;
      }

      if ((var6 & 8) != 0) {
         var4 = var0.count;
      }

      if ((var6 & 16) != 0) {
         var5 = var0.content;
      }

      return var0.copy(var1, var2, var3, var4, var5);
   }

   public final String component1() {
      return this.name;
   }

   public final String component2() {
      return this.scenario;
   }

   public final String component3() {
      return this.usage;
   }

   public final String component4() {
      return this.count;
   }

   public final String component5() {
      return this.content;
   }

   public final InfoItemRecord copy(String var1, String var2, String var3, String var4, String var5) {
      Intrinsics.checkNotNullParameter(var1, "name");
      Intrinsics.checkNotNullParameter(var2, "scenario");
      Intrinsics.checkNotNullParameter(var3, "usage");
      Intrinsics.checkNotNullParameter(var4, "count");
      Intrinsics.checkNotNullParameter(var5, "content");
      return new InfoItemRecord(var1, var2, var3, var4, var5);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof InfoItemRecord)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (!Intrinsics.areEqual(this.scenario, var1.scenario)) {
            return false;
         } else if (!Intrinsics.areEqual(this.usage, var1.usage)) {
            return false;
         } else if (!Intrinsics.areEqual(this.count, var1.count)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.content, var1.content);
         }
      }
   }

   public final String getContent() {
      return this.content;
   }

   public final String getCount() {
      return this.count;
   }

   public final String getName() {
      return this.name;
   }

   public final String getScenario() {
      return this.scenario;
   }

   public final String getUsage() {
      return this.usage;
   }

   public int hashCode() {
      return (((this.name.hashCode() * 31 + this.scenario.hashCode()) * 31 + this.usage.hashCode()) * 31 + this.count.hashCode()) * 31 + this.content.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("InfoItemRecord(name=");
      var1.append(this.name);
      var1.append(", scenario=");
      var1.append(this.scenario);
      var1.append(", usage=");
      var1.append(this.usage);
      var1.append(", count=");
      var1.append(this.count);
      var1.append(", content=");
      var1.append(this.content);
      var1.append(')');
      return var1.toString();
   }
}
