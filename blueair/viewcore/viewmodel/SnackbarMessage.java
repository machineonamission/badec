package com.blueair.viewcore.viewmodel;

import com.blueair.viewcore.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"},
   d2 = {"Lcom/blueair/viewcore/viewmodel/SnackbarMessage;", "", "messageResId", "", "type", "Lcom/blueair/viewcore/ViewUtils$MessageType;", "<init>", "(ILcom/blueair/viewcore/ViewUtils$MessageType;)V", "getMessageResId", "()I", "getType", "()Lcom/blueair/viewcore/ViewUtils$MessageType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SnackbarMessage {
   private final int messageResId;
   private final ViewUtils.MessageType type;

   public SnackbarMessage(int var1, ViewUtils.MessageType var2) {
      Intrinsics.checkNotNullParameter(var2, "type");
      super();
      this.messageResId = var1;
      this.type = var2;
   }

   // $FF: synthetic method
   public static SnackbarMessage copy$default(SnackbarMessage var0, int var1, ViewUtils.MessageType var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.messageResId;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.type;
      }

      return var0.copy(var1, var2);
   }

   public final int component1() {
      return this.messageResId;
   }

   public final ViewUtils.MessageType component2() {
      return this.type;
   }

   public final SnackbarMessage copy(int var1, ViewUtils.MessageType var2) {
      Intrinsics.checkNotNullParameter(var2, "type");
      return new SnackbarMessage(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof SnackbarMessage)) {
         return false;
      } else {
         var1 = var1;
         if (this.messageResId != var1.messageResId) {
            return false;
         } else {
            return Intrinsics.areEqual(this.type, var1.type);
         }
      }
   }

   public final int getMessageResId() {
      return this.messageResId;
   }

   public final ViewUtils.MessageType getType() {
      return this.type;
   }

   public int hashCode() {
      return this.messageResId * 31 + this.type.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("SnackbarMessage(messageResId=");
      var1.append(this.messageResId);
      var1.append(", type=");
      var1.append(this.type);
      var1.append(')');
      return var1.toString();
   }
}
