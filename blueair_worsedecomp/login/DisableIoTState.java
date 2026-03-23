package com.blueair.login;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nj\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u0010"}, d2 = {"Lcom/blueair/login/DisableIoTState;", "Landroid/os/Parcelable;", "", "<init>", "(Ljava/lang/String;I)V", "Idle", "Disabling", "Disabled", "Failed", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DisableIoTConfirmViewModel.kt */
public enum DisableIoTState implements Parcelable {
    Idle,
    Disabling,
    Disabled,
    Failed;
    
    public static final Parcelable.Creator<DisableIoTState> CREATOR = null;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DisableIoTConfirmViewModel.kt */
    public static final class Creator implements Parcelable.Creator<DisableIoTState> {
        public final DisableIoTState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return DisableIoTState.valueOf(parcel.readString());
        }

        public final DisableIoTState[] newArray(int i) {
            return new DisableIoTState[i];
        }
    }

    public static EnumEntries<DisableIoTState> getEntries() {
        return $ENTRIES;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(name());
    }

    static {
        DisableIoTState[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        CREATOR = new Creator();
    }
}
