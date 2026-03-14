package com.blueair.login;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nj\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u0010"},
   d2 = {"Lcom/blueair/login/DisableIoTState;", "Landroid/os/Parcelable;", "", "<init>", "(Ljava/lang/String;I)V", "Idle", "Disabling", "Disabled", "Failed", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum DisableIoTState implements Parcelable {
   private static final EnumEntries $ENTRIES;
   private static final DisableIoTState[] $VALUES;
   public static final Parcelable.Creator CREATOR;
   Disabled,
   Disabling,
   Failed,
   Idle;

   // $FF: synthetic method
   private static final DisableIoTState[] $values() {
      return new DisableIoTState[]{Idle, Disabling, Disabled, Failed};
   }

   static {
      DisableIoTState[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
      CREATOR = new Creator();
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final int describeContents() {
      return 0;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeString(this.name());
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final DisableIoTState createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         return DisableIoTState.valueOf(var1.readString());
      }

      public final DisableIoTState[] newArray(int var1) {
         return new DisableIoTState[var1];
      }
   }
}
