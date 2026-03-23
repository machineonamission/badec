package com.blueair.viewcore.dialog;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b)\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u00102J\u0006\u00103\u001a\u00020\u0005J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\u0005HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\"\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b#\u0010\u001aR\u0011\u0010$\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b%\u0010\u001a¨\u0006?"}, d2 = {"Lcom/blueair/viewcore/dialog/StepGuides;", "Landroid/os/Parcelable;", "requestKey", "", "headTitle", "", "headMessage", "headBtn", "stepTitle", "stepBtn", "stepMessages", "", "completeTitle", "completeMessage", "completeBtn", "minLines", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IILjava/util/List;IIII)V", "getRequestKey", "()Ljava/lang/String;", "getHeadTitle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeadMessage", "getHeadBtn", "getStepTitle", "()I", "getStepBtn", "getStepMessages", "()Ljava/util/List;", "getCompleteTitle", "getCompleteMessage", "getCompleteBtn", "getMinLines", "stepSize", "getStepSize", "pageSize", "getPageSize", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IILjava/util/List;IIII)Lcom/blueair/viewcore/dialog/StepGuides;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: StepGuideDialogFragment.kt */
public final class StepGuides implements Parcelable {
    public static final Parcelable.Creator<StepGuides> CREATOR = new Creator();
    private final int completeBtn;
    private final int completeMessage;
    private final int completeTitle;
    private final Integer headBtn;
    private final Integer headMessage;
    private final Integer headTitle;
    private final int minLines;
    private final String requestKey;
    private final int stepBtn;
    private final List<Integer> stepMessages;
    private final int stepTitle;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: StepGuideDialogFragment.kt */
    public static final class Creator implements Parcelable.Creator<StepGuides> {
        public final StepGuides createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            Integer num = null;
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() != 0) {
                num = Integer.valueOf(parcel.readInt());
            }
            Integer num2 = num;
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i != readInt3; i++) {
                arrayList.add(Integer.valueOf(parcel.readInt()));
            }
            return new StepGuides(readString, valueOf, valueOf2, num2, readInt, readInt2, arrayList, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        public final StepGuides[] newArray(int i) {
            return new StepGuides[i];
        }
    }

    public static /* synthetic */ StepGuides copy$default(StepGuides stepGuides, String str, Integer num, Integer num2, Integer num3, int i, int i2, List<Integer> list, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = stepGuides.requestKey;
        }
        if ((i7 & 2) != 0) {
            num = stepGuides.headTitle;
        }
        if ((i7 & 4) != 0) {
            num2 = stepGuides.headMessage;
        }
        if ((i7 & 8) != 0) {
            num3 = stepGuides.headBtn;
        }
        if ((i7 & 16) != 0) {
            i = stepGuides.stepTitle;
        }
        if ((i7 & 32) != 0) {
            i2 = stepGuides.stepBtn;
        }
        if ((i7 & 64) != 0) {
            list = stepGuides.stepMessages;
        }
        if ((i7 & 128) != 0) {
            i3 = stepGuides.completeTitle;
        }
        if ((i7 & 256) != 0) {
            i4 = stepGuides.completeMessage;
        }
        if ((i7 & 512) != 0) {
            i5 = stepGuides.completeBtn;
        }
        if ((i7 & 1024) != 0) {
            i6 = stepGuides.minLines;
        }
        int i8 = i5;
        int i9 = i6;
        int i10 = i3;
        int i11 = i4;
        int i12 = i2;
        List<Integer> list2 = list;
        Integer num4 = num3;
        int i13 = i;
        return stepGuides.copy(str, num, num2, num4, i13, i12, list2, i10, i11, i8, i9);
    }

    public final String component1() {
        return this.requestKey;
    }

    public final int component10() {
        return this.completeBtn;
    }

    public final int component11() {
        return this.minLines;
    }

    public final Integer component2() {
        return this.headTitle;
    }

    public final Integer component3() {
        return this.headMessage;
    }

    public final Integer component4() {
        return this.headBtn;
    }

    public final int component5() {
        return this.stepTitle;
    }

    public final int component6() {
        return this.stepBtn;
    }

    public final List<Integer> component7() {
        return this.stepMessages;
    }

    public final int component8() {
        return this.completeTitle;
    }

    public final int component9() {
        return this.completeMessage;
    }

    public final StepGuides copy(String str, Integer num, Integer num2, Integer num3, int i, int i2, List<Integer> list, int i3, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(str, "requestKey");
        List<Integer> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "stepMessages");
        return new StepGuides(str, num, num2, num3, i, i2, list2, i3, i4, i5, i6);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StepGuides)) {
            return false;
        }
        StepGuides stepGuides = (StepGuides) obj;
        return Intrinsics.areEqual((Object) this.requestKey, (Object) stepGuides.requestKey) && Intrinsics.areEqual((Object) this.headTitle, (Object) stepGuides.headTitle) && Intrinsics.areEqual((Object) this.headMessage, (Object) stepGuides.headMessage) && Intrinsics.areEqual((Object) this.headBtn, (Object) stepGuides.headBtn) && this.stepTitle == stepGuides.stepTitle && this.stepBtn == stepGuides.stepBtn && Intrinsics.areEqual((Object) this.stepMessages, (Object) stepGuides.stepMessages) && this.completeTitle == stepGuides.completeTitle && this.completeMessage == stepGuides.completeMessage && this.completeBtn == stepGuides.completeBtn && this.minLines == stepGuides.minLines;
    }

    public int hashCode() {
        int hashCode = this.requestKey.hashCode() * 31;
        Integer num = this.headTitle;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.headMessage;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.headBtn;
        if (num3 != null) {
            i = num3.hashCode();
        }
        return ((((((((((((((hashCode3 + i) * 31) + this.stepTitle) * 31) + this.stepBtn) * 31) + this.stepMessages.hashCode()) * 31) + this.completeTitle) * 31) + this.completeMessage) * 31) + this.completeBtn) * 31) + this.minLines;
    }

    public String toString() {
        return "StepGuides(requestKey=" + this.requestKey + ", headTitle=" + this.headTitle + ", headMessage=" + this.headMessage + ", headBtn=" + this.headBtn + ", stepTitle=" + this.stepTitle + ", stepBtn=" + this.stepBtn + ", stepMessages=" + this.stepMessages + ", completeTitle=" + this.completeTitle + ", completeMessage=" + this.completeMessage + ", completeBtn=" + this.completeBtn + ", minLines=" + this.minLines + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.requestKey);
        Integer num = this.headTitle;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.headMessage;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Integer num3 = this.headBtn;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        parcel.writeInt(this.stepTitle);
        parcel.writeInt(this.stepBtn);
        List<Integer> list = this.stepMessages;
        parcel.writeInt(list.size());
        for (Integer intValue : list) {
            parcel.writeInt(intValue.intValue());
        }
        parcel.writeInt(this.completeTitle);
        parcel.writeInt(this.completeMessage);
        parcel.writeInt(this.completeBtn);
        parcel.writeInt(this.minLines);
    }

    public StepGuides(String str, Integer num, Integer num2, Integer num3, int i, int i2, List<Integer> list, int i3, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(str, "requestKey");
        Intrinsics.checkNotNullParameter(list, "stepMessages");
        this.requestKey = str;
        this.headTitle = num;
        this.headMessage = num2;
        this.headBtn = num3;
        this.stepTitle = i;
        this.stepBtn = i2;
        this.stepMessages = list;
        this.completeTitle = i3;
        this.completeMessage = i4;
        this.completeBtn = i5;
        this.minLines = i6;
    }

    public final String getRequestKey() {
        return this.requestKey;
    }

    public final Integer getHeadTitle() {
        return this.headTitle;
    }

    public final Integer getHeadMessage() {
        return this.headMessage;
    }

    public final Integer getHeadBtn() {
        return this.headBtn;
    }

    public final int getStepTitle() {
        return this.stepTitle;
    }

    public final int getStepBtn() {
        return this.stepBtn;
    }

    public final List<Integer> getStepMessages() {
        return this.stepMessages;
    }

    public final int getCompleteTitle() {
        return this.completeTitle;
    }

    public final int getCompleteMessage() {
        return this.completeMessage;
    }

    public final int getCompleteBtn() {
        return this.completeBtn;
    }

    public final int getMinLines() {
        return this.minLines;
    }

    public final int getStepSize() {
        return this.stepMessages.size();
    }

    public final int getPageSize() {
        return getStepSize() + (this.headTitle == null ? 1 : 2);
    }
}
