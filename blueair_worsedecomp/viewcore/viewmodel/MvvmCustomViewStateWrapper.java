package com.blueair.viewcore.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0001HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0006\u0010\f\u001a\u00020\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/blueair/viewcore/viewmodel/MvvmCustomViewStateWrapper;", "Landroid/os/Parcelable;", "superState", "state", "<init>", "(Landroid/os/Parcelable;Landroid/os/Parcelable;)V", "getSuperState", "()Landroid/os/Parcelable;", "getState", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MvvmCustomView.kt */
public final class MvvmCustomViewStateWrapper implements Parcelable {
    public static final Parcelable.Creator<MvvmCustomViewStateWrapper> CREATOR = new Creator();
    private final Parcelable state;
    private final Parcelable superState;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: MvvmCustomView.kt */
    public static final class Creator implements Parcelable.Creator<MvvmCustomViewStateWrapper> {
        public final MvvmCustomViewStateWrapper createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MvvmCustomViewStateWrapper(parcel.readParcelable(MvvmCustomViewStateWrapper.class.getClassLoader()), parcel.readParcelable(MvvmCustomViewStateWrapper.class.getClassLoader()));
        }

        public final MvvmCustomViewStateWrapper[] newArray(int i) {
            return new MvvmCustomViewStateWrapper[i];
        }
    }

    public static /* synthetic */ MvvmCustomViewStateWrapper copy$default(MvvmCustomViewStateWrapper mvvmCustomViewStateWrapper, Parcelable parcelable, Parcelable parcelable2, int i, Object obj) {
        if ((i & 1) != 0) {
            parcelable = mvvmCustomViewStateWrapper.superState;
        }
        if ((i & 2) != 0) {
            parcelable2 = mvvmCustomViewStateWrapper.state;
        }
        return mvvmCustomViewStateWrapper.copy(parcelable, parcelable2);
    }

    public final Parcelable component1() {
        return this.superState;
    }

    public final Parcelable component2() {
        return this.state;
    }

    public final MvvmCustomViewStateWrapper copy(Parcelable parcelable, Parcelable parcelable2) {
        return new MvvmCustomViewStateWrapper(parcelable, parcelable2);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MvvmCustomViewStateWrapper)) {
            return false;
        }
        MvvmCustomViewStateWrapper mvvmCustomViewStateWrapper = (MvvmCustomViewStateWrapper) obj;
        return Intrinsics.areEqual((Object) this.superState, (Object) mvvmCustomViewStateWrapper.superState) && Intrinsics.areEqual((Object) this.state, (Object) mvvmCustomViewStateWrapper.state);
    }

    public int hashCode() {
        Parcelable parcelable = this.superState;
        int i = 0;
        int hashCode = (parcelable == null ? 0 : parcelable.hashCode()) * 31;
        Parcelable parcelable2 = this.state;
        if (parcelable2 != null) {
            i = parcelable2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "MvvmCustomViewStateWrapper(superState=" + this.superState + ", state=" + this.state + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.superState, i);
        parcel.writeParcelable(this.state, i);
    }

    public MvvmCustomViewStateWrapper(Parcelable parcelable, Parcelable parcelable2) {
        this.superState = parcelable;
        this.state = parcelable2;
    }

    public final Parcelable getSuperState() {
        return this.superState;
    }

    public final Parcelable getState() {
        return this.state;
    }
}
