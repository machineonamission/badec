package com.blueair.android.adapter;

import android.content.res.Resources;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\fJ\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001f"},
   d2 = {"Lcom/blueair/android/adapter/InfoListItem;", "", "id", "", "textRes", "", "text", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "titleRes", "(Ljava/lang/String;I)V", "title", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTextRes", "()I", "getText", "obtainText", "resources", "Landroid/content/res/Resources;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class InfoListItem {
   public static final int $stable = 0;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final InfoListItem POLICY_TERMS;
   private static final InfoListItem SHARED_THIRD_PARTIES;
   private static final InfoListItem USER_INFO_COLLECTIONS;
   private final String id;
   private final String text;
   private final int textRes;

   static {
      POLICY_TERMS = new InfoListItem("POLICY_TERMS", R.string.privacy_and_terms);
      USER_INFO_COLLECTIONS = new InfoListItem("USER_INFO_COLLECTIONS", R.string.collected_personal_infomation);
      SHARED_THIRD_PARTIES = new InfoListItem("SHARED_THIRD_PARTIES", R.string.infomation_shared_with_third_parties);
   }

   public InfoListItem(String var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "id");
      this(var1, var2, "");
   }

   public InfoListItem(String var1, int var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Intrinsics.checkNotNullParameter(var3, "text");
      super();
      this.id = var1;
      this.textRes = var2;
      this.text = var3;
   }

   public InfoListItem(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Intrinsics.checkNotNullParameter(var2, "title");
      this(var1, 0, var2);
   }

   // $FF: synthetic method
   public static InfoListItem copy$default(InfoListItem var0, String var1, int var2, String var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.textRes;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.text;
      }

      return var0.copy(var1, var2, var3);
   }

   public final String component1() {
      return this.id;
   }

   public final int component2() {
      return this.textRes;
   }

   public final String component3() {
      return this.text;
   }

   public final InfoListItem copy(String var1, int var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Intrinsics.checkNotNullParameter(var3, "text");
      return new InfoListItem(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof InfoListItem)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.id, var1.id)) {
            return false;
         } else if (this.textRes != var1.textRes) {
            return false;
         } else {
            return Intrinsics.areEqual(this.text, var1.text);
         }
      }
   }

   public final String getId() {
      return this.id;
   }

   public final String getText() {
      return this.text;
   }

   public final int getTextRes() {
      return this.textRes;
   }

   public int hashCode() {
      return (this.id.hashCode() * 31 + this.textRes) * 31 + this.text.hashCode();
   }

   public final String obtainText(Resources var1) {
      Intrinsics.checkNotNullParameter(var1, "resources");
      int var2 = this.textRes;
      if (var2 != 0) {
         String var3 = var1.getString(var2);
         Intrinsics.checkNotNullExpressionValue(var3, "getString(...)");
         return var3;
      } else {
         return this.text;
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("InfoListItem(id=");
      var1.append(this.id);
      var1.append(", textRes=");
      var1.append(this.textRes);
      var1.append(", text=");
      var1.append(this.text);
      var1.append(')');
      return var1.toString();
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"},
      d2 = {"Lcom/blueair/android/adapter/InfoListItem$Companion;", "", "<init>", "()V", "POLICY_TERMS", "Lcom/blueair/android/adapter/InfoListItem;", "getPOLICY_TERMS", "()Lcom/blueair/android/adapter/InfoListItem;", "USER_INFO_COLLECTIONS", "getUSER_INFO_COLLECTIONS", "SHARED_THIRD_PARTIES", "getSHARED_THIRD_PARTIES", "app_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final InfoListItem getPOLICY_TERMS() {
         return InfoListItem.POLICY_TERMS;
      }

      public final InfoListItem getSHARED_THIRD_PARTIES() {
         return InfoListItem.SHARED_THIRD_PARTIES;
      }

      public final InfoListItem getUSER_INFO_COLLECTIONS() {
         return InfoListItem.USER_INFO_COLLECTIONS;
      }
   }
}
