package com.blueair.api.restapi;

import com.gigya.android.sdk.GigyaDefinitions;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/blueair/api/restapi/SetTimezoneReq;", "", "deviceids", "", "", "timezone", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getDeviceids", "()Ljava/util/List;", "getTimezone", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class SetTimezoneReq {
    private final List<String> deviceids;
    private final String timezone;

    public static /* synthetic */ SetTimezoneReq copy$default(SetTimezoneReq setTimezoneReq, List<String> list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = setTimezoneReq.deviceids;
        }
        if ((i & 2) != 0) {
            str = setTimezoneReq.timezone;
        }
        return setTimezoneReq.copy(list, str);
    }

    public final List<String> component1() {
        return this.deviceids;
    }

    public final String component2() {
        return this.timezone;
    }

    public final SetTimezoneReq copy(List<String> list, String str) {
        Intrinsics.checkNotNullParameter(list, "deviceids");
        Intrinsics.checkNotNullParameter(str, GigyaDefinitions.AccountProfileExtraFields.TIMEZONE);
        return new SetTimezoneReq(list, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetTimezoneReq)) {
            return false;
        }
        SetTimezoneReq setTimezoneReq = (SetTimezoneReq) obj;
        return Intrinsics.areEqual((Object) this.deviceids, (Object) setTimezoneReq.deviceids) && Intrinsics.areEqual((Object) this.timezone, (Object) setTimezoneReq.timezone);
    }

    public int hashCode() {
        return (this.deviceids.hashCode() * 31) + this.timezone.hashCode();
    }

    public String toString() {
        return "SetTimezoneReq(deviceids=" + this.deviceids + ", timezone=" + this.timezone + ')';
    }

    public SetTimezoneReq(List<String> list, String str) {
        Intrinsics.checkNotNullParameter(list, "deviceids");
        Intrinsics.checkNotNullParameter(str, GigyaDefinitions.AccountProfileExtraFields.TIMEZONE);
        this.deviceids = list;
        this.timezone = str;
    }

    public final List<String> getDeviceids() {
        return this.deviceids;
    }

    public final String getTimezone() {
        return this.timezone;
    }
}
