package com.blueair.viewcore.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0001HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0006\u0010\f\u001a\u00020\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u001a"},
   d2 = {"Lcom/blueair/viewcore/viewmodel/MvvmCustomViewStateWrapper;", "Landroid/os/Parcelable;", "superState", "state", "<init>", "(Landroid/os/Parcelable;Landroid/os/Parcelable;)V", "getSuperState", "()Landroid/os/Parcelable;", "getState", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class MvvmCustomViewStateWrapper implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final Parcelable state;
   private final Parcelable superState;

   public MvvmCustomViewStateWrapper(Parcelable var1, Parcelable var2) {
      this.superState = var1;
      this.state = var2;
   }

   // $FF: synthetic method
   public static MvvmCustomViewStateWrapper copy$default(MvvmCustomViewStateWrapper var0, Parcelable var1, Parcelable var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.superState;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.state;
      }

      return var0.copy(var1, var2);
   }

   public final Parcelable component1() {
      return this.superState;
   }

   public final Parcelable component2() {
      return this.state;
   }

   public final MvvmCustomViewStateWrapper copy(Parcelable var1, Parcelable var2) {
      return new MvvmCustomViewStateWrapper(var1, var2);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof MvvmCustomViewStateWrapper)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.superState, var1.superState)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.state, var1.state);
         }
      }
   }

   public final Parcelable getState() {
      return this.state;
   }

   public final Parcelable getSuperState() {
      return this.superState;
   }

   public int hashCode() {
      Parcelable var3 = this.superState;
      int var2 = 0;
      int var1;
      if (var3 == null) {
         var1 = 0;
      } else {
         var1 = var3.hashCode();
      }

      var3 = this.state;
      if (var3 != null) {
         var2 = var3.hashCode();
      }

      return var1 * 31 + var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("MvvmCustomViewStateWrapper(superState=");
      var1.append(this.superState);
      var1.append(", state=");
      var1.append(this.state);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeParcelable(this.superState, var2);
      var1.writeParcelable(this.state, var2);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final MvvmCustomViewStateWrapper createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         return new MvvmCustomViewStateWrapper(var1.readParcelable(MvvmCustomViewStateWrapper.class.getClassLoader()), var1.readParcelable(MvvmCustomViewStateWrapper.class.getClassLoader()));
      }

      public final MvvmCustomViewStateWrapper[] newArray(int var1) {
         return new MvvmCustomViewStateWrapper[var1];
      }
   }
}
