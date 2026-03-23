package com.blueair.viewcore.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J.\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0003J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006 "}, d2 = {"Lcom/blueair/viewcore/viewmodel/PopupMessage;", "Landroid/os/Parcelable;", "titleResId", "", "subtitleResId", "messageResId", "<init>", "(ILjava/lang/Integer;I)V", "getTitleResId", "()I", "getSubtitleResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessageResId", "component1", "component2", "component3", "copy", "(ILjava/lang/Integer;I)Lcom/blueair/viewcore/viewmodel/PopupMessage;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseViewModel.kt */
public final class PopupMessage implements Parcelable {
    public static final Parcelable.Creator<PopupMessage> CREATOR = new Creator();
    private final int messageResId;
    private final Integer subtitleResId;
    private final int titleResId;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BaseViewModel.kt */
    public static final class Creator implements Parcelable.Creator<PopupMessage> {
        public final PopupMessage createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PopupMessage(parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt());
        }

        public final PopupMessage[] newArray(int i) {
            return new PopupMessage[i];
        }
    }

    public static /* synthetic */ PopupMessage copy$default(PopupMessage popupMessage, int i, Integer num, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = popupMessage.titleResId;
        }
        if ((i3 & 2) != 0) {
            num = popupMessage.subtitleResId;
        }
        if ((i3 & 4) != 0) {
            i2 = popupMessage.messageResId;
        }
        return popupMessage.copy(i, num, i2);
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

    public final PopupMessage copy(int i, Integer num, int i2) {
        return new PopupMessage(i, num, i2);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PopupMessage)) {
            return false;
        }
        PopupMessage popupMessage = (PopupMessage) obj;
        return this.titleResId == popupMessage.titleResId && Intrinsics.areEqual((Object) this.subtitleResId, (Object) popupMessage.subtitleResId) && this.messageResId == popupMessage.messageResId;
    }

    public int hashCode() {
        int i = this.titleResId * 31;
        Integer num = this.subtitleResId;
        return ((i + (num == null ? 0 : num.hashCode())) * 31) + this.messageResId;
    }

    public String toString() {
        return "PopupMessage(titleResId=" + this.titleResId + ", subtitleResId=" + this.subtitleResId + ", messageResId=" + this.messageResId + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeInt(this.titleResId);
        Integer num = this.subtitleResId;
        if (num == null) {
            i2 = 0;
        } else {
            parcel.writeInt(1);
            i2 = num.intValue();
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.messageResId);
    }

    public PopupMessage(int i, Integer num, int i2) {
        this.titleResId = i;
        this.subtitleResId = num;
        this.messageResId = i2;
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
}
