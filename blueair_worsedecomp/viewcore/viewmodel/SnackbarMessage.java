package com.blueair.viewcore.viewmodel;

import com.blueair.viewcore.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/blueair/viewcore/viewmodel/SnackbarMessage;", "", "messageResId", "", "type", "Lcom/blueair/viewcore/ViewUtils$MessageType;", "<init>", "(ILcom/blueair/viewcore/ViewUtils$MessageType;)V", "getMessageResId", "()I", "getType", "()Lcom/blueair/viewcore/ViewUtils$MessageType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseViewModel.kt */
public final class SnackbarMessage {
    private final int messageResId;
    private final ViewUtils.MessageType type;

    public static /* synthetic */ SnackbarMessage copy$default(SnackbarMessage snackbarMessage, int i, ViewUtils.MessageType messageType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = snackbarMessage.messageResId;
        }
        if ((i2 & 2) != 0) {
            messageType = snackbarMessage.type;
        }
        return snackbarMessage.copy(i, messageType);
    }

    public final int component1() {
        return this.messageResId;
    }

    public final ViewUtils.MessageType component2() {
        return this.type;
    }

    public final SnackbarMessage copy(int i, ViewUtils.MessageType messageType) {
        Intrinsics.checkNotNullParameter(messageType, "type");
        return new SnackbarMessage(i, messageType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SnackbarMessage)) {
            return false;
        }
        SnackbarMessage snackbarMessage = (SnackbarMessage) obj;
        return this.messageResId == snackbarMessage.messageResId && Intrinsics.areEqual((Object) this.type, (Object) snackbarMessage.type);
    }

    public int hashCode() {
        return (this.messageResId * 31) + this.type.hashCode();
    }

    public String toString() {
        return "SnackbarMessage(messageResId=" + this.messageResId + ", type=" + this.type + ')';
    }

    public SnackbarMessage(int i, ViewUtils.MessageType messageType) {
        Intrinsics.checkNotNullParameter(messageType, "type");
        this.messageResId = i;
        this.type = messageType;
    }

    public final int getMessageResId() {
        return this.messageResId;
    }

    public final ViewUtils.MessageType getType() {
        return this.type;
    }
}
