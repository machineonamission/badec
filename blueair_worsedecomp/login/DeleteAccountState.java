package com.blueair.login;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/blueair/login/DeleteAccountState;", "Landroid/os/Parcelable;", "<init>", "()V", "Idle", "Deleting", "Deleted", "Failed", "Lcom/blueair/login/DeleteAccountState$Deleted;", "Lcom/blueair/login/DeleteAccountState$Deleting;", "Lcom/blueair/login/DeleteAccountState$Failed;", "Lcom/blueair/login/DeleteAccountState$Idle;", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeleteAccountConfirmViewModel.kt */
public abstract class DeleteAccountState implements Parcelable {
    public /* synthetic */ DeleteAccountState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DeleteAccountState() {
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/blueair/login/DeleteAccountState$Idle;", "Lcom/blueair/login/DeleteAccountState;", "country", "", "<init>", "(Ljava/lang/String;)V", "getCountry", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeleteAccountConfirmViewModel.kt */
    public static final class Idle extends DeleteAccountState {
        public static final Parcelable.Creator<Idle> CREATOR = new Creator();
        private final String country;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeleteAccountConfirmViewModel.kt */
        public static final class Creator implements Parcelable.Creator<Idle> {
            public final Idle createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Idle(parcel.readString());
            }

            public final Idle[] newArray(int i) {
                return new Idle[i];
            }
        }

        public static /* synthetic */ Idle copy$default(Idle idle, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = idle.country;
            }
            return idle.copy(str);
        }

        public final String component1() {
            return this.country;
        }

        public final Idle copy(String str) {
            Intrinsics.checkNotNullParameter(str, "country");
            return new Idle(str);
        }

        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Idle) && Intrinsics.areEqual((Object) this.country, (Object) ((Idle) obj).country);
        }

        public int hashCode() {
            return this.country.hashCode();
        }

        public String toString() {
            return "Idle(country=" + this.country + ')';
        }

        public final void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.country);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Idle(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "country");
            this.country = str;
        }

        public final String getCountry() {
            return this.country;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/blueair/login/DeleteAccountState$Deleting;", "Lcom/blueair/login/DeleteAccountState;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeleteAccountConfirmViewModel.kt */
    public static final class Deleting extends DeleteAccountState {
        public static final Parcelable.Creator<Deleting> CREATOR = new Creator();
        public static final Deleting INSTANCE = new Deleting();

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeleteAccountConfirmViewModel.kt */
        public static final class Creator implements Parcelable.Creator<Deleting> {
            public final Deleting createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Deleting.INSTANCE;
            }

            public final Deleting[] newArray(int i) {
                return new Deleting[i];
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeInt(1);
        }

        private Deleting() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/blueair/login/DeleteAccountState$Deleted;", "Lcom/blueair/login/DeleteAccountState;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeleteAccountConfirmViewModel.kt */
    public static final class Deleted extends DeleteAccountState {
        public static final Parcelable.Creator<Deleted> CREATOR = new Creator();
        public static final Deleted INSTANCE = new Deleted();

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeleteAccountConfirmViewModel.kt */
        public static final class Creator implements Parcelable.Creator<Deleted> {
            public final Deleted createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Deleted.INSTANCE;
            }

            public final Deleted[] newArray(int i) {
                return new Deleted[i];
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeInt(1);
        }

        private Deleted() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/blueair/login/DeleteAccountState$Failed;", "Lcom/blueair/login/DeleteAccountState;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeleteAccountConfirmViewModel.kt */
    public static final class Failed extends DeleteAccountState {
        public static final Parcelable.Creator<Failed> CREATOR = new Creator();
        public static final Failed INSTANCE = new Failed();

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeleteAccountConfirmViewModel.kt */
        public static final class Creator implements Parcelable.Creator<Failed> {
            public final Failed createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Failed.INSTANCE;
            }

            public final Failed[] newArray(int i) {
                return new Failed[i];
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeInt(1);
        }

        private Failed() {
            super((DefaultConstructorMarker) null);
        }
    }
}
