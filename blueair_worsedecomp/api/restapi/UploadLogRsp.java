package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.facebook.GraphRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\""}, d2 = {"Lcom/blueair/api/restapi/UploadLogRsp;", "Lcom/blueair/api/restapi/PresignUploadRsp;", "url", "", "fields", "", "expiresIn", "", "maxBytes", "", "logUuid", "<init>", "(Ljava/lang/String;Ljava/util/Map;IJLjava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getFields", "()Ljava/util/Map;", "getExpiresIn", "()I", "getMaxBytes", "()J", "getLogUuid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class UploadLogRsp extends PresignUploadRsp {
    private final int expiresIn;
    private final Map<String, String> fields;
    private final String logUuid;
    private final long maxBytes;
    private final String url;

    public static /* synthetic */ UploadLogRsp copy$default(UploadLogRsp uploadLogRsp, String str, Map<String, String> map, int i, long j, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = uploadLogRsp.url;
        }
        if ((i2 & 2) != 0) {
            map = uploadLogRsp.fields;
        }
        if ((i2 & 4) != 0) {
            i = uploadLogRsp.expiresIn;
        }
        if ((i2 & 8) != 0) {
            j = uploadLogRsp.maxBytes;
        }
        if ((i2 & 16) != 0) {
            str2 = uploadLogRsp.logUuid;
        }
        String str3 = str2;
        long j2 = j;
        return uploadLogRsp.copy(str, map, i, j2, str3);
    }

    public final String component1() {
        return this.url;
    }

    public final Map<String, String> component2() {
        return this.fields;
    }

    public final int component3() {
        return this.expiresIn;
    }

    public final long component4() {
        return this.maxBytes;
    }

    public final String component5() {
        return this.logUuid;
    }

    public final UploadLogRsp copy(String str, Map<String, String> map, int i, long j, String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(map, GraphRequest.FIELDS_PARAM);
        Intrinsics.checkNotNullParameter(str2, "logUuid");
        return new UploadLogRsp(str, map, i, j, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadLogRsp)) {
            return false;
        }
        UploadLogRsp uploadLogRsp = (UploadLogRsp) obj;
        return Intrinsics.areEqual((Object) this.url, (Object) uploadLogRsp.url) && Intrinsics.areEqual((Object) this.fields, (Object) uploadLogRsp.fields) && this.expiresIn == uploadLogRsp.expiresIn && this.maxBytes == uploadLogRsp.maxBytes && Intrinsics.areEqual((Object) this.logUuid, (Object) uploadLogRsp.logUuid);
    }

    public int hashCode() {
        return (((((((this.url.hashCode() * 31) + this.fields.hashCode()) * 31) + this.expiresIn) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.maxBytes)) * 31) + this.logUuid.hashCode();
    }

    public String toString() {
        return "UploadLogRsp(url=" + this.url + ", fields=" + this.fields + ", expiresIn=" + this.expiresIn + ", maxBytes=" + this.maxBytes + ", logUuid=" + this.logUuid + ')';
    }

    public String getUrl() {
        return this.url;
    }

    public Map<String, String> getFields() {
        return this.fields;
    }

    public int getExpiresIn() {
        return this.expiresIn;
    }

    public long getMaxBytes() {
        return this.maxBytes;
    }

    public final String getLogUuid() {
        return this.logUuid;
    }

    public UploadLogRsp(String str, Map<String, String> map, int i, long j, String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(map, GraphRequest.FIELDS_PARAM);
        Intrinsics.checkNotNullParameter(str2, "logUuid");
        this.url = str;
        this.fields = map;
        this.expiresIn = i;
        this.maxBytes = j;
        this.logUuid = str2;
    }
}
