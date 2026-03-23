package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/blueair/api/restapi/AntiFakeLogReq;", "", "antifakecode", "", "devicesku", "res", "deviceid", "mac", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAntifakecode", "()Ljava/lang/String;", "getDevicesku", "getRes", "getDeviceid", "getMac", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class AntiFakeLogReq {
    private final String antifakecode;
    private final String deviceid;
    private final String devicesku;
    private final String mac;
    private final String res;

    public static /* synthetic */ AntiFakeLogReq copy$default(AntiFakeLogReq antiFakeLogReq, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = antiFakeLogReq.antifakecode;
        }
        if ((i & 2) != 0) {
            str2 = antiFakeLogReq.devicesku;
        }
        if ((i & 4) != 0) {
            str3 = antiFakeLogReq.res;
        }
        if ((i & 8) != 0) {
            str4 = antiFakeLogReq.deviceid;
        }
        if ((i & 16) != 0) {
            str5 = antiFakeLogReq.mac;
        }
        String str6 = str4;
        String str7 = str5;
        return antiFakeLogReq.copy(str, str2, str3, str6, str7);
    }

    public final String component1() {
        return this.antifakecode;
    }

    public final String component2() {
        return this.devicesku;
    }

    public final String component3() {
        return this.res;
    }

    public final String component4() {
        return this.deviceid;
    }

    public final String component5() {
        return this.mac;
    }

    public final AntiFakeLogReq copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "antifakecode");
        Intrinsics.checkNotNullParameter(str2, "devicesku");
        Intrinsics.checkNotNullParameter(str3, "res");
        return new AntiFakeLogReq(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AntiFakeLogReq)) {
            return false;
        }
        AntiFakeLogReq antiFakeLogReq = (AntiFakeLogReq) obj;
        return Intrinsics.areEqual((Object) this.antifakecode, (Object) antiFakeLogReq.antifakecode) && Intrinsics.areEqual((Object) this.devicesku, (Object) antiFakeLogReq.devicesku) && Intrinsics.areEqual((Object) this.res, (Object) antiFakeLogReq.res) && Intrinsics.areEqual((Object) this.deviceid, (Object) antiFakeLogReq.deviceid) && Intrinsics.areEqual((Object) this.mac, (Object) antiFakeLogReq.mac);
    }

    public int hashCode() {
        int hashCode = ((((this.antifakecode.hashCode() * 31) + this.devicesku.hashCode()) * 31) + this.res.hashCode()) * 31;
        String str = this.deviceid;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.mac;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "AntiFakeLogReq(antifakecode=" + this.antifakecode + ", devicesku=" + this.devicesku + ", res=" + this.res + ", deviceid=" + this.deviceid + ", mac=" + this.mac + ')';
    }

    public AntiFakeLogReq(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "antifakecode");
        Intrinsics.checkNotNullParameter(str2, "devicesku");
        Intrinsics.checkNotNullParameter(str3, "res");
        this.antifakecode = str;
        this.devicesku = str2;
        this.res = str3;
        this.deviceid = str4;
        this.mac = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AntiFakeLogReq(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r1 = this;
            r8 = r7 & 8
            r0 = 0
            if (r8 == 0) goto L_0x0006
            r5 = r0
        L_0x0006:
            r7 = r7 & 16
            if (r7 == 0) goto L_0x000c
            r7 = r0
            goto L_0x000d
        L_0x000c:
            r7 = r6
        L_0x000d:
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.restapi.AntiFakeLogReq.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getAntifakecode() {
        return this.antifakecode;
    }

    public final String getDevicesku() {
        return this.devicesku;
    }

    public final String getRes() {
        return this.res;
    }

    public final String getDeviceid() {
        return this.deviceid;
    }

    public final String getMac() {
        return this.mac;
    }
}
