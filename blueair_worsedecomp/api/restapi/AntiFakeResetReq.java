package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011JF\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/blueair/api/restapi/AntiFakeResetReq;", "", "antifakecode", "", "devicesku", "deviceid", "mac", "usage", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAntifakecode", "()Ljava/lang/String;", "getDevicesku", "getDeviceid", "getMac", "getUsage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/blueair/api/restapi/AntiFakeResetReq;", "equals", "", "other", "hashCode", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class AntiFakeResetReq {
    private final String antifakecode;
    private final String deviceid;
    private final String devicesku;
    private final String mac;
    private final Integer usage;

    public static /* synthetic */ AntiFakeResetReq copy$default(AntiFakeResetReq antiFakeResetReq, String str, String str2, String str3, String str4, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = antiFakeResetReq.antifakecode;
        }
        if ((i & 2) != 0) {
            str2 = antiFakeResetReq.devicesku;
        }
        if ((i & 4) != 0) {
            str3 = antiFakeResetReq.deviceid;
        }
        if ((i & 8) != 0) {
            str4 = antiFakeResetReq.mac;
        }
        if ((i & 16) != 0) {
            num = antiFakeResetReq.usage;
        }
        String str5 = str4;
        Integer num2 = num;
        return antiFakeResetReq.copy(str, str2, str3, str5, num2);
    }

    public final String component1() {
        return this.antifakecode;
    }

    public final String component2() {
        return this.devicesku;
    }

    public final String component3() {
        return this.deviceid;
    }

    public final String component4() {
        return this.mac;
    }

    public final Integer component5() {
        return this.usage;
    }

    public final AntiFakeResetReq copy(String str, String str2, String str3, String str4, Integer num) {
        Intrinsics.checkNotNullParameter(str, "antifakecode");
        Intrinsics.checkNotNullParameter(str2, "devicesku");
        return new AntiFakeResetReq(str, str2, str3, str4, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AntiFakeResetReq)) {
            return false;
        }
        AntiFakeResetReq antiFakeResetReq = (AntiFakeResetReq) obj;
        return Intrinsics.areEqual((Object) this.antifakecode, (Object) antiFakeResetReq.antifakecode) && Intrinsics.areEqual((Object) this.devicesku, (Object) antiFakeResetReq.devicesku) && Intrinsics.areEqual((Object) this.deviceid, (Object) antiFakeResetReq.deviceid) && Intrinsics.areEqual((Object) this.mac, (Object) antiFakeResetReq.mac) && Intrinsics.areEqual((Object) this.usage, (Object) antiFakeResetReq.usage);
    }

    public int hashCode() {
        int hashCode = ((this.antifakecode.hashCode() * 31) + this.devicesku.hashCode()) * 31;
        String str = this.deviceid;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.mac;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.usage;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "AntiFakeResetReq(antifakecode=" + this.antifakecode + ", devicesku=" + this.devicesku + ", deviceid=" + this.deviceid + ", mac=" + this.mac + ", usage=" + this.usage + ')';
    }

    public AntiFakeResetReq(String str, String str2, String str3, String str4, Integer num) {
        Intrinsics.checkNotNullParameter(str, "antifakecode");
        Intrinsics.checkNotNullParameter(str2, "devicesku");
        this.antifakecode = str;
        this.devicesku = str2;
        this.deviceid = str3;
        this.mac = str4;
        this.usage = num;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AntiFakeResetReq(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.Integer r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r1 = this;
            r8 = r7 & 4
            r0 = 0
            if (r8 == 0) goto L_0x0006
            r4 = r0
        L_0x0006:
            r8 = r7 & 8
            if (r8 == 0) goto L_0x000b
            r5 = r0
        L_0x000b:
            r7 = r7 & 16
            if (r7 == 0) goto L_0x0011
            r7 = r0
            goto L_0x0012
        L_0x0011:
            r7 = r6
        L_0x0012:
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.restapi.AntiFakeResetReq.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getAntifakecode() {
        return this.antifakecode;
    }

    public final String getDevicesku() {
        return this.devicesku;
    }

    public final String getDeviceid() {
        return this.deviceid;
    }

    public final String getMac() {
        return this.mac;
    }

    public final Integer getUsage() {
        return this.usage;
    }
}
