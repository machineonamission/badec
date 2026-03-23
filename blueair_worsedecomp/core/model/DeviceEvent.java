package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\t\u0012\b\b\u0003\u0010\n\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\r\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u000fHÆ\u0003Ju\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\r\u001a\u00020\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u00107\u001a\u00020%2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\tHÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b)\u0010\u0013R\u0013\u0010*\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b+\u0010\u0013¨\u0006;"}, d2 = {"Lcom/blueair/core/model/DeviceEvent;", "", "id", "", "timeStamp", "", "origin", "message", "errorCode", "", "connectionEvent", "region", "relayingParty", "stateName", "info", "Lcom/blueair/core/model/Info;", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/Info;)V", "getId", "()Ljava/lang/String;", "getTimeStamp", "()J", "getOrigin", "getMessage", "getErrorCode", "()I", "getConnectionEvent", "getRegion", "getRelayingParty", "getStateName", "getInfo", "()Lcom/blueair/core/model/Info;", "onboardingState", "Lcom/blueair/core/model/OnboardingState;", "getOnboardingState", "()Lcom/blueair/core/model/OnboardingState;", "hasError", "", "getHasError", "()Z", "errorMessage", "getErrorMessage", "originDeviceId", "getOriginDeviceId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEvent.kt */
public final class DeviceEvent {
    private final String connectionEvent;
    private final int errorCode;
    private final String id;
    private final Info info;
    private final String message;
    private final String origin;
    private final String region;
    private final String relayingParty;
    private final String stateName;
    private final long timeStamp;

    public static /* synthetic */ DeviceEvent copy$default(DeviceEvent deviceEvent, String str, long j, String str2, String str3, int i, String str4, String str5, String str6, String str7, Info info2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = deviceEvent.id;
        }
        if ((i2 & 2) != 0) {
            j = deviceEvent.timeStamp;
        }
        if ((i2 & 4) != 0) {
            str2 = deviceEvent.origin;
        }
        if ((i2 & 8) != 0) {
            str3 = deviceEvent.message;
        }
        if ((i2 & 16) != 0) {
            i = deviceEvent.errorCode;
        }
        if ((i2 & 32) != 0) {
            str4 = deviceEvent.connectionEvent;
        }
        if ((i2 & 64) != 0) {
            str5 = deviceEvent.region;
        }
        if ((i2 & 128) != 0) {
            str6 = deviceEvent.relayingParty;
        }
        if ((i2 & 256) != 0) {
            str7 = deviceEvent.stateName;
        }
        if ((i2 & 512) != 0) {
            info2 = deviceEvent.info;
        }
        String str8 = str7;
        Info info3 = info2;
        String str9 = str5;
        String str10 = str6;
        long j2 = j;
        return deviceEvent.copy(str, j2, str2, str3, i, str4, str9, str10, str8, info3);
    }

    public final String component1() {
        return this.id;
    }

    public final Info component10() {
        return this.info;
    }

    public final long component2() {
        return this.timeStamp;
    }

    public final String component3() {
        return this.origin;
    }

    public final String component4() {
        return this.message;
    }

    public final int component5() {
        return this.errorCode;
    }

    public final String component6() {
        return this.connectionEvent;
    }

    public final String component7() {
        return this.region;
    }

    public final String component8() {
        return this.relayingParty;
    }

    public final String component9() {
        return this.stateName;
    }

    public final DeviceEvent copy(String str, @Json(name = "ts") long j, @Json(name = "o") String str2, @Json(name = "m") String str3, @Json(name = "ec") int i, @Json(name = "et") String str4, @Json(name = "r") String str5, @Json(name = "rp") String str6, @Json(name = "ot") String str7, @Json(name = "a") Info info2) {
        Intrinsics.checkNotNullParameter(str, "id");
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str8, "message");
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, "connectionEvent");
        String str10 = str7;
        Intrinsics.checkNotNullParameter(str10, "stateName");
        return new DeviceEvent(str, j, str2, str8, i, str9, str5, str6, str10, info2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceEvent)) {
            return false;
        }
        DeviceEvent deviceEvent = (DeviceEvent) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) deviceEvent.id) && this.timeStamp == deviceEvent.timeStamp && Intrinsics.areEqual((Object) this.origin, (Object) deviceEvent.origin) && Intrinsics.areEqual((Object) this.message, (Object) deviceEvent.message) && this.errorCode == deviceEvent.errorCode && Intrinsics.areEqual((Object) this.connectionEvent, (Object) deviceEvent.connectionEvent) && Intrinsics.areEqual((Object) this.region, (Object) deviceEvent.region) && Intrinsics.areEqual((Object) this.relayingParty, (Object) deviceEvent.relayingParty) && Intrinsics.areEqual((Object) this.stateName, (Object) deviceEvent.stateName) && Intrinsics.areEqual((Object) this.info, (Object) deviceEvent.info);
    }

    public int hashCode() {
        int hashCode = ((this.id.hashCode() * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.timeStamp)) * 31;
        String str = this.origin;
        int i = 0;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.message.hashCode()) * 31) + this.errorCode) * 31) + this.connectionEvent.hashCode()) * 31;
        String str2 = this.region;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.relayingParty;
        int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.stateName.hashCode()) * 31;
        Info info2 = this.info;
        if (info2 != null) {
            i = info2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "DeviceEvent(id=" + this.id + ", timeStamp=" + this.timeStamp + ", origin=" + this.origin + ", message=" + this.message + ", errorCode=" + this.errorCode + ", connectionEvent=" + this.connectionEvent + ", region=" + this.region + ", relayingParty=" + this.relayingParty + ", stateName=" + this.stateName + ", info=" + this.info + ')';
    }

    public DeviceEvent(String str, @Json(name = "ts") long j, @Json(name = "o") String str2, @Json(name = "m") String str3, @Json(name = "ec") int i, @Json(name = "et") String str4, @Json(name = "r") String str5, @Json(name = "rp") String str6, @Json(name = "ot") String str7, @Json(name = "a") Info info2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str3, "message");
        Intrinsics.checkNotNullParameter(str4, "connectionEvent");
        Intrinsics.checkNotNullParameter(str7, "stateName");
        this.id = str;
        this.timeStamp = j;
        this.origin = str2;
        this.message = str3;
        this.errorCode = i;
        this.connectionEvent = str4;
        this.region = str5;
        this.relayingParty = str6;
        this.stateName = str7;
        this.info = info2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceEvent(java.lang.String r3, long r4, java.lang.String r6, java.lang.String r7, int r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, com.blueair.core.model.Info r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r2 = this;
            r15 = r14 & 8
            java.lang.String r0 = ""
            if (r15 == 0) goto L_0x0007
            r7 = r0
        L_0x0007:
            r15 = r14 & 16
            if (r15 == 0) goto L_0x000c
            r8 = 0
        L_0x000c:
            r15 = r14 & 32
            if (r15 == 0) goto L_0x0011
            r9 = r0
        L_0x0011:
            r15 = r14 & 64
            if (r15 == 0) goto L_0x0016
            r10 = r0
        L_0x0016:
            r15 = r14 & 128(0x80, float:1.794E-43)
            r1 = 0
            if (r15 == 0) goto L_0x001c
            r11 = r1
        L_0x001c:
            r15 = r14 & 256(0x100, float:3.59E-43)
            if (r15 == 0) goto L_0x0021
            r12 = r0
        L_0x0021:
            r14 = r14 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x0027
            r14 = r1
            goto L_0x0028
        L_0x0027:
            r14 = r13
        L_0x0028:
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r5 = r4
            r4 = r3
            r3 = r2
            r3.<init>(r4, r5, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceEvent.<init>(java.lang.String, long, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.blueair.core.model.Info, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getId() {
        return this.id;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final String getOrigin() {
        return this.origin;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getConnectionEvent() {
        return this.connectionEvent;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getRelayingParty() {
        return this.relayingParty;
    }

    public final String getStateName() {
        return this.stateName;
    }

    public final Info getInfo() {
        return this.info;
    }

    public final OnboardingState getOnboardingState() {
        return OnboardingState.Companion.fromName(this.connectionEvent);
    }

    public final boolean getHasError() {
        return this.errorCode < 0;
    }

    public final String getErrorMessage() {
        return "event = " + this.connectionEvent + ", errorCode = " + this.errorCode;
    }

    public final String getOriginDeviceId() {
        return this.origin;
    }
}
