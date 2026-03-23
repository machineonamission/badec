package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/blueair/api/restapi/InitialBody;", "", "eventsubscription", "Lcom/blueair/api/restapi/EventSubscription;", "deviceconfigquery", "", "Lcom/blueair/api/restapi/DeviceConfigQuery;", "includestates", "", "deviceInfo", "Lcom/blueair/api/restapi/DeviceInfo;", "<init>", "(Lcom/blueair/api/restapi/EventSubscription;Ljava/util/List;ZLcom/blueair/api/restapi/DeviceInfo;)V", "getEventsubscription", "()Lcom/blueair/api/restapi/EventSubscription;", "getDeviceconfigquery", "()Ljava/util/List;", "getIncludestates", "()Z", "getDeviceInfo", "()Lcom/blueair/api/restapi/DeviceInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class InitialBody {
    private final DeviceInfo deviceInfo;
    private final List<DeviceConfigQuery> deviceconfigquery;
    private final EventSubscription eventsubscription;
    private final boolean includestates;

    public static /* synthetic */ InitialBody copy$default(InitialBody initialBody, EventSubscription eventSubscription, List<DeviceConfigQuery> list, boolean z, DeviceInfo deviceInfo2, int i, Object obj) {
        if ((i & 1) != 0) {
            eventSubscription = initialBody.eventsubscription;
        }
        if ((i & 2) != 0) {
            list = initialBody.deviceconfigquery;
        }
        if ((i & 4) != 0) {
            z = initialBody.includestates;
        }
        if ((i & 8) != 0) {
            deviceInfo2 = initialBody.deviceInfo;
        }
        return initialBody.copy(eventSubscription, list, z, deviceInfo2);
    }

    public final EventSubscription component1() {
        return this.eventsubscription;
    }

    public final List<DeviceConfigQuery> component2() {
        return this.deviceconfigquery;
    }

    public final boolean component3() {
        return this.includestates;
    }

    public final DeviceInfo component4() {
        return this.deviceInfo;
    }

    public final InitialBody copy(EventSubscription eventSubscription, List<DeviceConfigQuery> list, boolean z, DeviceInfo deviceInfo2) {
        Intrinsics.checkNotNullParameter(eventSubscription, "eventsubscription");
        Intrinsics.checkNotNullParameter(list, "deviceconfigquery");
        return new InitialBody(eventSubscription, list, z, deviceInfo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InitialBody)) {
            return false;
        }
        InitialBody initialBody = (InitialBody) obj;
        return Intrinsics.areEqual((Object) this.eventsubscription, (Object) initialBody.eventsubscription) && Intrinsics.areEqual((Object) this.deviceconfigquery, (Object) initialBody.deviceconfigquery) && this.includestates == initialBody.includestates && Intrinsics.areEqual((Object) this.deviceInfo, (Object) initialBody.deviceInfo);
    }

    public int hashCode() {
        int hashCode = ((((this.eventsubscription.hashCode() * 31) + this.deviceconfigquery.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.includestates)) * 31;
        DeviceInfo deviceInfo2 = this.deviceInfo;
        return hashCode + (deviceInfo2 == null ? 0 : deviceInfo2.hashCode());
    }

    public String toString() {
        return "InitialBody(eventsubscription=" + this.eventsubscription + ", deviceconfigquery=" + this.deviceconfigquery + ", includestates=" + this.includestates + ", deviceInfo=" + this.deviceInfo + ')';
    }

    public InitialBody(EventSubscription eventSubscription, List<DeviceConfigQuery> list, boolean z, DeviceInfo deviceInfo2) {
        Intrinsics.checkNotNullParameter(eventSubscription, "eventsubscription");
        Intrinsics.checkNotNullParameter(list, "deviceconfigquery");
        this.eventsubscription = eventSubscription;
        this.deviceconfigquery = list;
        this.includestates = z;
        this.deviceInfo = deviceInfo2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InitialBody(EventSubscription eventSubscription, List list, boolean z, DeviceInfo deviceInfo2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventSubscription, list, (i & 4) != 0 ? true : z, (i & 8) != 0 ? null : deviceInfo2);
    }

    public final EventSubscription getEventsubscription() {
        return this.eventsubscription;
    }

    public final List<DeviceConfigQuery> getDeviceconfigquery() {
        return this.deviceconfigquery;
    }

    public final boolean getIncludestates() {
        return this.includestates;
    }

    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }
}
