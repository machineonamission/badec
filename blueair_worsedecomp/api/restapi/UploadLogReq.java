package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/blueair/api/restapi/UploadLogReq;", "Lcom/blueair/api/restapi/PresignUploadReq;", "gigyaUid", "", "cloudRegion", "type", "length", "purpose", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGigyaUid", "()Ljava/lang/String;", "getCloudRegion", "getType", "getLength", "getPurpose", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class UploadLogReq extends PresignUploadReq {
    private final String cloudRegion;
    private final String gigyaUid;
    private final String length;
    private final String purpose;
    private final String type;

    public static /* synthetic */ UploadLogReq copy$default(UploadLogReq uploadLogReq, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uploadLogReq.gigyaUid;
        }
        if ((i & 2) != 0) {
            str2 = uploadLogReq.cloudRegion;
        }
        if ((i & 4) != 0) {
            str3 = uploadLogReq.type;
        }
        if ((i & 8) != 0) {
            str4 = uploadLogReq.length;
        }
        if ((i & 16) != 0) {
            str5 = uploadLogReq.purpose;
        }
        String str6 = str4;
        String str7 = str5;
        return uploadLogReq.copy(str, str2, str3, str6, str7);
    }

    public final String component1() {
        return this.gigyaUid;
    }

    public final String component2() {
        return this.cloudRegion;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.length;
    }

    public final String component5() {
        return this.purpose;
    }

    public final UploadLogReq copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "gigyaUid");
        Intrinsics.checkNotNullParameter(str2, "cloudRegion");
        Intrinsics.checkNotNullParameter(str3, "type");
        Intrinsics.checkNotNullParameter(str4, "length");
        Intrinsics.checkNotNullParameter(str5, "purpose");
        return new UploadLogReq(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadLogReq)) {
            return false;
        }
        UploadLogReq uploadLogReq = (UploadLogReq) obj;
        return Intrinsics.areEqual((Object) this.gigyaUid, (Object) uploadLogReq.gigyaUid) && Intrinsics.areEqual((Object) this.cloudRegion, (Object) uploadLogReq.cloudRegion) && Intrinsics.areEqual((Object) this.type, (Object) uploadLogReq.type) && Intrinsics.areEqual((Object) this.length, (Object) uploadLogReq.length) && Intrinsics.areEqual((Object) this.purpose, (Object) uploadLogReq.purpose);
    }

    public int hashCode() {
        return (((((((this.gigyaUid.hashCode() * 31) + this.cloudRegion.hashCode()) * 31) + this.type.hashCode()) * 31) + this.length.hashCode()) * 31) + this.purpose.hashCode();
    }

    public String toString() {
        return "UploadLogReq(gigyaUid=" + this.gigyaUid + ", cloudRegion=" + this.cloudRegion + ", type=" + this.type + ", length=" + this.length + ", purpose=" + this.purpose + ')';
    }

    public final String getGigyaUid() {
        return this.gigyaUid;
    }

    public final String getCloudRegion() {
        return this.cloudRegion;
    }

    public final String getType() {
        return this.type;
    }

    public final String getLength() {
        return this.length;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UploadLogReq(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? "log" : str5);
    }

    public String getPurpose() {
        return this.purpose;
    }

    public UploadLogReq(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "gigyaUid");
        Intrinsics.checkNotNullParameter(str2, "cloudRegion");
        Intrinsics.checkNotNullParameter(str3, "type");
        Intrinsics.checkNotNullParameter(str4, "length");
        Intrinsics.checkNotNullParameter(str5, "purpose");
        this.gigyaUid = str;
        this.cloudRegion = str2;
        this.type = str3;
        this.length = str4;
        this.purpose = str5;
    }
}
