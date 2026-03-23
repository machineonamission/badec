package com.blueair.viewcore.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B`\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J$\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tHÆ\u0003Ji\u0010!\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032#\b\u0002\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R,\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/blueair/viewcore/viewmodel/ConfirmationMessage;", "", "titleResId", "", "messageResId", "positiveResId", "negativeResId", "topImageResId", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "confirmed", "", "<init>", "(IIILjava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "getTitleResId", "()I", "getMessageResId", "getPositiveResId", "getNegativeResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTopImageResId", "getAction", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(IIILjava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Lcom/blueair/viewcore/viewmodel/ConfirmationMessage;", "equals", "other", "hashCode", "toString", "", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseViewModel.kt */
public final class ConfirmationMessage {
    private final Function1<Boolean, Unit> action;
    private final int messageResId;
    private final Integer negativeResId;
    private final int positiveResId;
    private final int titleResId;
    private final Integer topImageResId;

    public static /* synthetic */ ConfirmationMessage copy$default(ConfirmationMessage confirmationMessage, int i, int i2, int i3, Integer num, Integer num2, Function1<Boolean, Unit> function1, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = confirmationMessage.titleResId;
        }
        if ((i4 & 2) != 0) {
            i2 = confirmationMessage.messageResId;
        }
        if ((i4 & 4) != 0) {
            i3 = confirmationMessage.positiveResId;
        }
        if ((i4 & 8) != 0) {
            num = confirmationMessage.negativeResId;
        }
        if ((i4 & 16) != 0) {
            num2 = confirmationMessage.topImageResId;
        }
        if ((i4 & 32) != 0) {
            function1 = confirmationMessage.action;
        }
        Integer num3 = num2;
        Function1<Boolean, Unit> function12 = function1;
        Integer num4 = num;
        int i5 = i2;
        return confirmationMessage.copy(i, i5, i3, num4, num3, function12);
    }

    public final int component1() {
        return this.titleResId;
    }

    public final int component2() {
        return this.messageResId;
    }

    public final int component3() {
        return this.positiveResId;
    }

    public final Integer component4() {
        return this.negativeResId;
    }

    public final Integer component5() {
        return this.topImageResId;
    }

    public final Function1<Boolean, Unit> component6() {
        return this.action;
    }

    public final ConfirmationMessage copy(int i, int i2, int i3, Integer num, Integer num2, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        return new ConfirmationMessage(i, i2, i3, num, num2, function1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfirmationMessage)) {
            return false;
        }
        ConfirmationMessage confirmationMessage = (ConfirmationMessage) obj;
        return this.titleResId == confirmationMessage.titleResId && this.messageResId == confirmationMessage.messageResId && this.positiveResId == confirmationMessage.positiveResId && Intrinsics.areEqual((Object) this.negativeResId, (Object) confirmationMessage.negativeResId) && Intrinsics.areEqual((Object) this.topImageResId, (Object) confirmationMessage.topImageResId) && Intrinsics.areEqual((Object) this.action, (Object) confirmationMessage.action);
    }

    public int hashCode() {
        int i = ((((this.titleResId * 31) + this.messageResId) * 31) + this.positiveResId) * 31;
        Integer num = this.negativeResId;
        int i2 = 0;
        int hashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.topImageResId;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        return ((hashCode + i2) * 31) + this.action.hashCode();
    }

    public String toString() {
        return "ConfirmationMessage(titleResId=" + this.titleResId + ", messageResId=" + this.messageResId + ", positiveResId=" + this.positiveResId + ", negativeResId=" + this.negativeResId + ", topImageResId=" + this.topImageResId + ", action=" + this.action + ')';
    }

    public ConfirmationMessage(int i, int i2, int i3, Integer num, Integer num2, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.titleResId = i;
        this.messageResId = i2;
        this.positiveResId = i3;
        this.negativeResId = num;
        this.topImageResId = num2;
        this.action = function1;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public final int getMessageResId() {
        return this.messageResId;
    }

    public final int getPositiveResId() {
        return this.positiveResId;
    }

    public final Integer getNegativeResId() {
        return this.negativeResId;
    }

    public final Integer getTopImageResId() {
        return this.topImageResId;
    }

    public final Function1<Boolean, Unit> getAction() {
        return this.action;
    }
}
