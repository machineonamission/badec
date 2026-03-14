package com.blueair.viewcore.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J.\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0003J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006 "},
   d2 = {"Lcom/blueair/viewcore/viewmodel/PopupMessage;", "Landroid/os/Parcelable;", "titleResId", "", "subtitleResId", "messageResId", "<init>", "(ILjava/lang/Integer;I)V", "getTitleResId", "()I", "getSubtitleResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessageResId", "component1", "component2", "component3", "copy", "(ILjava/lang/Integer;I)Lcom/blueair/viewcore/viewmodel/PopupMessage;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class PopupMessage implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final int messageResId;
   private final Integer subtitleResId;
   private final int titleResId;

   public PopupMessage(int var1, Integer var2, int var3) {
      this.titleResId = var1;
      this.subtitleResId = var2;
      this.messageResId = var3;
   }

   // $FF: synthetic method
   public static PopupMessage copy$default(PopupMessage var0, int var1, Integer var2, int var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.titleResId;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.subtitleResId;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.messageResId;
      }

      return var0.copy(var1, var2, var3);
   }

   public final int component1() {
      return this.titleResId;
   }

   public final Integer component2() {
      return this.subtitleResId;
   }

   public final int component3() {
      return this.messageResId;
   }

   public final PopupMessage copy(int var1, Integer var2, int var3) {
      return new PopupMessage(var1, var2, var3);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof PopupMessage)) {
         return false;
      } else {
         var1 = var1;
         if (this.titleResId != var1.titleResId) {
            return false;
         } else if (!Intrinsics.areEqual(this.subtitleResId, var1.subtitleResId)) {
            return false;
         } else {
            return this.messageResId == var1.messageResId;
         }
      }
   }

   public final int getMessageResId() {
      return this.messageResId;
   }

   public final Integer getSubtitleResId() {
      return this.subtitleResId;
   }

   public final int getTitleResId() {
      return this.titleResId;
   }

   public int hashCode() {
      int var2 = this.titleResId;
      Integer var3 = this.subtitleResId;
      int var1;
      if (var3 == null) {
         var1 = 0;
      } else {
         var1 = var3.hashCode();
      }

      return (var2 * 31 + var1) * 31 + this.messageResId;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("PopupMessage(titleResId=");
      var1.append(this.titleResId);
      var1.append(", subtitleResId=");
      var1.append(this.subtitleResId);
      var1.append(", messageResId=");
      var1.append(this.messageResId);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeInt(this.titleResId);
      Integer var3 = this.subtitleResId;
      if (var3 == null) {
         var2 = 0;
      } else {
         var1.writeInt(1);
         var2 = var3;
      }

      var1.writeInt(var2);
      var1.writeInt(this.messageResId);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final PopupMessage createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         int var2 = var1.readInt();
         Integer var3;
         if (var1.readInt() == 0) {
            var3 = null;
         } else {
            var3 = var1.readInt();
         }

         return new PopupMessage(var2, var3, var1.readInt());
      }

      public final PopupMessage[] newArray(int var1) {
         return new PopupMessage[var1];
      }
   }
}
