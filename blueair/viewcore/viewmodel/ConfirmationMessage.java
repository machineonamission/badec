package com.blueair.viewcore.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B`\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J$\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tHÆ\u0003Ji\u0010!\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032#\b\u0002\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R,\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006("},
   d2 = {"Lcom/blueair/viewcore/viewmodel/ConfirmationMessage;", "", "titleResId", "", "messageResId", "positiveResId", "negativeResId", "topImageResId", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "confirmed", "", "<init>", "(IIILjava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "getTitleResId", "()I", "getMessageResId", "getPositiveResId", "getNegativeResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTopImageResId", "getAction", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(IIILjava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Lcom/blueair/viewcore/viewmodel/ConfirmationMessage;", "equals", "other", "hashCode", "toString", "", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ConfirmationMessage {
   private final Function1 action;
   private final int messageResId;
   private final Integer negativeResId;
   private final int positiveResId;
   private final int titleResId;
   private final Integer topImageResId;

   public ConfirmationMessage(int var1, int var2, int var3, Integer var4, Integer var5, Function1 var6) {
      Intrinsics.checkNotNullParameter(var6, "action");
      super();
      this.titleResId = var1;
      this.messageResId = var2;
      this.positiveResId = var3;
      this.negativeResId = var4;
      this.topImageResId = var5;
      this.action = var6;
   }

   // $FF: synthetic method
   public static ConfirmationMessage copy$default(ConfirmationMessage var0, int var1, int var2, int var3, Integer var4, Integer var5, Function1 var6, int var7, Object var8) {
      if ((var7 & 1) != 0) {
         var1 = var0.titleResId;
      }

      if ((var7 & 2) != 0) {
         var2 = var0.messageResId;
      }

      if ((var7 & 4) != 0) {
         var3 = var0.positiveResId;
      }

      if ((var7 & 8) != 0) {
         var4 = var0.negativeResId;
      }

      if ((var7 & 16) != 0) {
         var5 = var0.topImageResId;
      }

      if ((var7 & 32) != 0) {
         var6 = var0.action;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6);
   }

   public final int component1() {
      return this.titleResId;
   }

   public final int component2() {
      return this.messageResId;
   }

   public final int component3() {
      return this.positiveResId;
   }

   public final Integer component4() {
      return this.negativeResId;
   }

   public final Integer component5() {
      return this.topImageResId;
   }

   public final Function1 component6() {
      return this.action;
   }

   public final ConfirmationMessage copy(int var1, int var2, int var3, Integer var4, Integer var5, Function1 var6) {
      Intrinsics.checkNotNullParameter(var6, "action");
      return new ConfirmationMessage(var1, var2, var3, var4, var5, var6);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof ConfirmationMessage)) {
         return false;
      } else {
         var1 = var1;
         if (this.titleResId != var1.titleResId) {
            return false;
         } else if (this.messageResId != var1.messageResId) {
            return false;
         } else if (this.positiveResId != var1.positiveResId) {
            return false;
         } else if (!Intrinsics.areEqual(this.negativeResId, var1.negativeResId)) {
            return false;
         } else if (!Intrinsics.areEqual(this.topImageResId, var1.topImageResId)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.action, var1.action);
         }
      }
   }

   public final Function1 getAction() {
      return this.action;
   }

   public final int getMessageResId() {
      return this.messageResId;
   }

   public final Integer getNegativeResId() {
      return this.negativeResId;
   }

   public final int getPositiveResId() {
      return this.positiveResId;
   }

   public final int getTitleResId() {
      return this.titleResId;
   }

   public final Integer getTopImageResId() {
      return this.topImageResId;
   }

   public int hashCode() {
      int var4 = this.titleResId;
      int var3 = this.messageResId;
      int var5 = this.positiveResId;
      Integer var6 = this.negativeResId;
      int var2 = 0;
      int var1;
      if (var6 == null) {
         var1 = 0;
      } else {
         var1 = var6.hashCode();
      }

      var6 = this.topImageResId;
      if (var6 != null) {
         var2 = var6.hashCode();
      }

      return ((((var4 * 31 + var3) * 31 + var5) * 31 + var1) * 31 + var2) * 31 + this.action.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("ConfirmationMessage(titleResId=");
      var1.append(this.titleResId);
      var1.append(", messageResId=");
      var1.append(this.messageResId);
      var1.append(", positiveResId=");
      var1.append(this.positiveResId);
      var1.append(", negativeResId=");
      var1.append(this.negativeResId);
      var1.append(", topImageResId=");
      var1.append(this.topImageResId);
      var1.append(", action=");
      var1.append(this.action);
      var1.append(')');
      return var1.toString();
   }
}
