package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003JU\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0006\u0010\"\u001a\u00020\u0007J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006/"}, d2 = {"Lcom/blueair/core/model/FilterInfo;", "Landroid/os/Parcelable;", "type", "Lcom/blueair/core/model/DeviceFilterType;", "name", "Lcom/blueair/core/model/I18nConfig;", "image", "", "summary", "manual", "linkSubscribe", "Lcom/blueair/core/model/IpConfig;", "linkPurchase", "<init>", "(Lcom/blueair/core/model/DeviceFilterType;Lcom/blueair/core/model/I18nConfig;IILcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/IpConfig;Lcom/blueair/core/model/IpConfig;)V", "getType", "()Lcom/blueair/core/model/DeviceFilterType;", "getName", "()Lcom/blueair/core/model/I18nConfig;", "getImage", "()I", "getSummary", "getManual", "getLinkSubscribe", "()Lcom/blueair/core/model/IpConfig;", "getLinkPurchase", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SkuConfiguration.kt */
public final class FilterInfo implements Parcelable {
    public static final Parcelable.Creator<FilterInfo> CREATOR = new Creator();
    private final int image;
    private final IpConfig linkPurchase;
    private final IpConfig linkSubscribe;
    private final I18nConfig manual;
    private final I18nConfig name;
    private final int summary;
    private final DeviceFilterType type;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SkuConfiguration.kt */
    public static final class Creator implements Parcelable.Creator<FilterInfo> {
        public final FilterInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            DeviceFilterType valueOf = DeviceFilterType.valueOf(parcel.readString());
            I18nConfig createFromParcel = I18nConfig.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            IpConfig ipConfig = null;
            I18nConfig createFromParcel2 = parcel.readInt() == 0 ? null : I18nConfig.CREATOR.createFromParcel(parcel);
            IpConfig createFromParcel3 = parcel.readInt() == 0 ? null : IpConfig.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                ipConfig = IpConfig.CREATOR.createFromParcel(parcel);
            }
            return new FilterInfo(valueOf, createFromParcel, readInt, readInt2, createFromParcel2, createFromParcel3, ipConfig);
        }

        public final FilterInfo[] newArray(int i) {
            return new FilterInfo[i];
        }
    }

    public static /* synthetic */ FilterInfo copy$default(FilterInfo filterInfo, DeviceFilterType deviceFilterType, I18nConfig i18nConfig, int i, int i2, I18nConfig i18nConfig2, IpConfig ipConfig, IpConfig ipConfig2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            deviceFilterType = filterInfo.type;
        }
        if ((i3 & 2) != 0) {
            i18nConfig = filterInfo.name;
        }
        if ((i3 & 4) != 0) {
            i = filterInfo.image;
        }
        if ((i3 & 8) != 0) {
            i2 = filterInfo.summary;
        }
        if ((i3 & 16) != 0) {
            i18nConfig2 = filterInfo.manual;
        }
        if ((i3 & 32) != 0) {
            ipConfig = filterInfo.linkSubscribe;
        }
        if ((i3 & 64) != 0) {
            ipConfig2 = filterInfo.linkPurchase;
        }
        IpConfig ipConfig3 = ipConfig;
        IpConfig ipConfig4 = ipConfig2;
        int i4 = i2;
        I18nConfig i18nConfig3 = i18nConfig2;
        return filterInfo.copy(deviceFilterType, i18nConfig, i, i4, i18nConfig3, ipConfig3, ipConfig4);
    }

    public final DeviceFilterType component1() {
        return this.type;
    }

    public final I18nConfig component2() {
        return this.name;
    }

    public final int component3() {
        return this.image;
    }

    public final int component4() {
        return this.summary;
    }

    public final I18nConfig component5() {
        return this.manual;
    }

    public final IpConfig component6() {
        return this.linkSubscribe;
    }

    public final IpConfig component7() {
        return this.linkPurchase;
    }

    public final FilterInfo copy(DeviceFilterType deviceFilterType, I18nConfig i18nConfig, int i, int i2, I18nConfig i18nConfig2, IpConfig ipConfig, IpConfig ipConfig2) {
        Intrinsics.checkNotNullParameter(deviceFilterType, "type");
        Intrinsics.checkNotNullParameter(i18nConfig, "name");
        return new FilterInfo(deviceFilterType, i18nConfig, i, i2, i18nConfig2, ipConfig, ipConfig2);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterInfo)) {
            return false;
        }
        FilterInfo filterInfo = (FilterInfo) obj;
        return this.type == filterInfo.type && Intrinsics.areEqual((Object) this.name, (Object) filterInfo.name) && this.image == filterInfo.image && this.summary == filterInfo.summary && Intrinsics.areEqual((Object) this.manual, (Object) filterInfo.manual) && Intrinsics.areEqual((Object) this.linkSubscribe, (Object) filterInfo.linkSubscribe) && Intrinsics.areEqual((Object) this.linkPurchase, (Object) filterInfo.linkPurchase);
    }

    public int hashCode() {
        int hashCode = ((((((this.type.hashCode() * 31) + this.name.hashCode()) * 31) + this.image) * 31) + this.summary) * 31;
        I18nConfig i18nConfig = this.manual;
        int i = 0;
        int hashCode2 = (hashCode + (i18nConfig == null ? 0 : i18nConfig.hashCode())) * 31;
        IpConfig ipConfig = this.linkSubscribe;
        int hashCode3 = (hashCode2 + (ipConfig == null ? 0 : ipConfig.hashCode())) * 31;
        IpConfig ipConfig2 = this.linkPurchase;
        if (ipConfig2 != null) {
            i = ipConfig2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "FilterInfo(type=" + this.type + ", name=" + this.name + ", image=" + this.image + ", summary=" + this.summary + ", manual=" + this.manual + ", linkSubscribe=" + this.linkSubscribe + ", linkPurchase=" + this.linkPurchase + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.type.name());
        this.name.writeToParcel(parcel, i);
        parcel.writeInt(this.image);
        parcel.writeInt(this.summary);
        I18nConfig i18nConfig = this.manual;
        if (i18nConfig == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            i18nConfig.writeToParcel(parcel, i);
        }
        IpConfig ipConfig = this.linkSubscribe;
        if (ipConfig == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            ipConfig.writeToParcel(parcel, i);
        }
        IpConfig ipConfig2 = this.linkPurchase;
        if (ipConfig2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        ipConfig2.writeToParcel(parcel, i);
    }

    public FilterInfo(DeviceFilterType deviceFilterType, I18nConfig i18nConfig, int i, int i2, I18nConfig i18nConfig2, IpConfig ipConfig, IpConfig ipConfig2) {
        Intrinsics.checkNotNullParameter(deviceFilterType, "type");
        Intrinsics.checkNotNullParameter(i18nConfig, "name");
        this.type = deviceFilterType;
        this.name = i18nConfig;
        this.image = i;
        this.summary = i2;
        this.manual = i18nConfig2;
        this.linkSubscribe = ipConfig;
        this.linkPurchase = ipConfig2;
    }

    public final DeviceFilterType getType() {
        return this.type;
    }

    public final I18nConfig getName() {
        return this.name;
    }

    public final int getImage() {
        return this.image;
    }

    public final int getSummary() {
        return this.summary;
    }

    public final I18nConfig getManual() {
        return this.manual;
    }

    public final IpConfig getLinkSubscribe() {
        return this.linkSubscribe;
    }

    public final IpConfig getLinkPurchase() {
        return this.linkPurchase;
    }
}
