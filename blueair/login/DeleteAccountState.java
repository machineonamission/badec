package com.blueair.login;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"},
   d2 = {"Lcom/blueair/login/DeleteAccountState;", "Landroid/os/Parcelable;", "<init>", "()V", "Idle", "Deleting", "Deleted", "Failed", "Lcom/blueair/login/DeleteAccountState$Deleted;", "Lcom/blueair/login/DeleteAccountState$Deleting;", "Lcom/blueair/login/DeleteAccountState$Failed;", "Lcom/blueair/login/DeleteAccountState$Idle;", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class DeleteAccountState implements Parcelable {
   private DeleteAccountState() {
   }

   // $FF: synthetic method
   public DeleteAccountState(DefaultConstructorMarker var1) {
      this();
   }

   @Metadata(
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"},
      d2 = {"Lcom/blueair/login/DeleteAccountState$Deleted;", "Lcom/blueair/login/DeleteAccountState;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "login_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Deleted extends DeleteAccountState {
      public static final Parcelable.Creator CREATOR = new Creator();
      public static final Deleted INSTANCE = new Deleted();

      private Deleted() {
         super((DefaultConstructorMarker)null);
      }

      public final int describeContents() {
         return 0;
      }

      public final void writeToParcel(Parcel var1, int var2) {
         Intrinsics.checkNotNullParameter(var1, "dest");
         var1.writeInt(1);
      }

      @Metadata(
         k = 3,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class Creator implements Parcelable.Creator {
         public final Deleted createFromParcel(Parcel var1) {
            Intrinsics.checkNotNullParameter(var1, "parcel");
            var1.readInt();
            return DeleteAccountState.Deleted.INSTANCE;
         }

         public final Deleted[] newArray(int var1) {
            return new Deleted[var1];
         }
      }
   }

   @Metadata(
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"},
      d2 = {"Lcom/blueair/login/DeleteAccountState$Deleting;", "Lcom/blueair/login/DeleteAccountState;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "login_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Deleting extends DeleteAccountState {
      public static final Parcelable.Creator CREATOR = new Creator();
      public static final Deleting INSTANCE = new Deleting();

      private Deleting() {
         super((DefaultConstructorMarker)null);
      }

      public final int describeContents() {
         return 0;
      }

      public final void writeToParcel(Parcel var1, int var2) {
         Intrinsics.checkNotNullParameter(var1, "dest");
         var1.writeInt(1);
      }

      @Metadata(
         k = 3,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class Creator implements Parcelable.Creator {
         public final Deleting createFromParcel(Parcel var1) {
            Intrinsics.checkNotNullParameter(var1, "parcel");
            var1.readInt();
            return DeleteAccountState.Deleting.INSTANCE;
         }

         public final Deleting[] newArray(int var1) {
            return new Deleting[var1];
         }
      }
   }

   @Metadata(
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"},
      d2 = {"Lcom/blueair/login/DeleteAccountState$Failed;", "Lcom/blueair/login/DeleteAccountState;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "login_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Failed extends DeleteAccountState {
      public static final Parcelable.Creator CREATOR = new Creator();
      public static final Failed INSTANCE = new Failed();

      private Failed() {
         super((DefaultConstructorMarker)null);
      }

      public final int describeContents() {
         return 0;
      }

      public final void writeToParcel(Parcel var1, int var2) {
         Intrinsics.checkNotNullParameter(var1, "dest");
         var1.writeInt(1);
      }

      @Metadata(
         k = 3,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class Creator implements Parcelable.Creator {
         public final Failed createFromParcel(Parcel var1) {
            Intrinsics.checkNotNullParameter(var1, "parcel");
            var1.readInt();
            return DeleteAccountState.Failed.INSTANCE;
         }

         public final Failed[] newArray(int var1) {
            return new Failed[var1];
         }
      }
   }

   @Metadata(
      d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"},
      d2 = {"Lcom/blueair/login/DeleteAccountState$Idle;", "Lcom/blueair/login/DeleteAccountState;", "country", "", "<init>", "(Ljava/lang/String;)V", "getCountry", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "login_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Idle extends DeleteAccountState {
      public static final Parcelable.Creator CREATOR = new Creator();
      private final String country;

      public Idle(String var1) {
         Intrinsics.checkNotNullParameter(var1, "country");
         super((DefaultConstructorMarker)null);
         this.country = var1;
      }

      // $FF: synthetic method
      public static Idle copy$default(Idle var0, String var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.country;
         }

         return var0.copy(var1);
      }

      public final String component1() {
         return this.country;
      }

      public final Idle copy(String var1) {
         Intrinsics.checkNotNullParameter(var1, "country");
         return new Idle(var1);
      }

      public final int describeContents() {
         return 0;
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof Idle)) {
            return false;
         } else {
            var1 = var1;
            return Intrinsics.areEqual(this.country, var1.country);
         }
      }

      public final String getCountry() {
         return this.country;
      }

      public int hashCode() {
         return this.country.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("Idle(country=");
         var1.append(this.country);
         var1.append(')');
         return var1.toString();
      }

      public final void writeToParcel(Parcel var1, int var2) {
         Intrinsics.checkNotNullParameter(var1, "dest");
         var1.writeString(this.country);
      }

      @Metadata(
         k = 3,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class Creator implements Parcelable.Creator {
         public final Idle createFromParcel(Parcel var1) {
            Intrinsics.checkNotNullParameter(var1, "parcel");
            return new Idle(var1.readString());
         }

         public final Idle[] newArray(int var1) {
            return new Idle[var1];
         }
      }
   }
}
