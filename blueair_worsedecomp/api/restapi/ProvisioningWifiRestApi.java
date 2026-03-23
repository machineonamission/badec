package com.blueair.api.restapi;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.api.model.ProvisionRequestBody;
import com.blueair.core.model.DeviceEvent;
import com.blueair.core.model.DeviceUuid;
import com.blueair.core.model.Ssid;
import com.google.android.libraries.places.api.model.PlaceTypes;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b`\u0018\u0000 \u00122\u00020\u0001:\u0007\u0012\u0013\u0014\u0015\u0016\u0017\u0018J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\nH'J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\u000b\u001a\u00020\u000fH'J\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0011\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\bH'¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lcom/blueair/api/restapi/ProvisioningWifiRestApi;", "", "getUuid", "Lkotlinx/coroutines/Deferred;", "Lcom/blueair/api/restapi/ProvisioningWifiRestApi$UuidWrapper;", "getSsids", "Lcom/blueair/api/restapi/ProvisioningWifiRestApi$SsidWrapper;", "uuid", "", "provisionDevice", "Lcom/blueair/api/model/ProvisionRequestBody;", "request", "getOnboardingEventQueue", "Lcom/blueair/api/restapi/ProvisioningWifiRestApi$DeviceEventWrapper;", "switchOffSoftAp", "Lcom/blueair/api/restapi/ProvisioningWifiRestApi$SwitchOffSoftApBody;", "resetDevice", "ipv4", "Companion", "UuidWrapper", "SsidWrapper", "DeviceEventWrapper", "SwitchOffSoftApBody", "ResetDeviceBody", "InstructionBody", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ProvisioningWifiRestApi.kt */
public interface ProvisioningWifiRestApi {
    public static final String BASE_DOMAIN = "192.168.4.1";
    public static final String BASE_URL = "https://192.168.4.1/";
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String EVENT_QUEUE = "d/{uuid}/events/queue";
    public static final String GET_SSIDS = "d/{uuid}/management/ssid";
    public static final String GET_STATS = "d/getstats";
    public static final String GET_UUID = "d/uuid";
    public static final String PROVISION = "d/{uuid}/provision/ssid";
    public static final String RESET_DEVICE = "https://{ipv4}/d/{uuid}/management/reset";
    public static final String SWITCH_OFF_SOFT_AP = "d/{uuid}/management/softap";

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ProvisioningWifiRestApi.kt */
    public static final class DefaultImpls {
    }

    @GET("d/{uuid}/events/queue")
    Deferred<DeviceEventWrapper> getOnboardingEventQueue(@Path("uuid") String str);

    @GET("d/{uuid}/management/ssid")
    Deferred<SsidWrapper> getSsids(@Path("uuid") String str);

    @GET("d/uuid")
    Deferred<UuidWrapper> getUuid();

    @POST("d/{uuid}/provision/ssid")
    Deferred<ProvisionRequestBody> provisionDevice(@Path("uuid") String str, @Body ProvisionRequestBody provisionRequestBody);

    @GET("https://{ipv4}/d/{uuid}/management/reset")
    Deferred<String> resetDevice(@Path("ipv4") String str, @Path("uuid") String str2);

    @POST("d/{uuid}/management/softap")
    Deferred<SwitchOffSoftApBody> switchOffSoftAp(@Path("uuid") String str, @Body SwitchOffSoftApBody switchOffSoftApBody);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/blueair/api/restapi/ProvisioningWifiRestApi$Companion;", "", "<init>", "()V", "BASE_DOMAIN", "", "BASE_URL", "GET_UUID", "GET_SSIDS", "PROVISION", "EVENT_QUEUE", "GET_STATS", "SWITCH_OFF_SOFT_AP", "RESET_DEVICE", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ProvisioningWifiRestApi.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String BASE_DOMAIN = "192.168.4.1";
        public static final String BASE_URL = "https://192.168.4.1/";
        public static final String EVENT_QUEUE = "d/{uuid}/events/queue";
        public static final String GET_SSIDS = "d/{uuid}/management/ssid";
        public static final String GET_STATS = "d/getstats";
        public static final String GET_UUID = "d/uuid";
        public static final String PROVISION = "d/{uuid}/provision/ssid";
        public static final String RESET_DEVICE = "https://{ipv4}/d/{uuid}/management/reset";
        public static final String SWITCH_OFF_SOFT_AP = "d/{uuid}/management/softap";

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/blueair/api/restapi/ProvisioningWifiRestApi$UuidWrapper;", "", "uuid", "", "Lcom/blueair/core/model/DeviceUuid;", "<init>", "(Ljava/util/List;)V", "getUuid", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ProvisioningWifiRestApi.kt */
    public static final class UuidWrapper {
        private final List<DeviceUuid> uuid;

        public static /* synthetic */ UuidWrapper copy$default(UuidWrapper uuidWrapper, List<DeviceUuid> list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = uuidWrapper.uuid;
            }
            return uuidWrapper.copy(list);
        }

        public final List<DeviceUuid> component1() {
            return this.uuid;
        }

        public final UuidWrapper copy(List<DeviceUuid> list) {
            Intrinsics.checkNotNullParameter(list, "uuid");
            return new UuidWrapper(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UuidWrapper) && Intrinsics.areEqual((Object) this.uuid, (Object) ((UuidWrapper) obj).uuid);
        }

        public int hashCode() {
            return this.uuid.hashCode();
        }

        public String toString() {
            return "UuidWrapper(uuid=" + this.uuid + ')';
        }

        public UuidWrapper(List<DeviceUuid> list) {
            Intrinsics.checkNotNullParameter(list, "uuid");
            this.uuid = list;
        }

        public final List<DeviceUuid> getUuid() {
            return this.uuid;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/blueair/api/restapi/ProvisioningWifiRestApi$SsidWrapper;", "", "network", "", "Lcom/blueair/core/model/Ssid;", "<init>", "(Ljava/util/List;)V", "getNetwork", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ProvisioningWifiRestApi.kt */
    public static final class SsidWrapper {
        private final List<Ssid> network;

        public static /* synthetic */ SsidWrapper copy$default(SsidWrapper ssidWrapper, List<Ssid> list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = ssidWrapper.network;
            }
            return ssidWrapper.copy(list);
        }

        public final List<Ssid> component1() {
            return this.network;
        }

        public final SsidWrapper copy(List<Ssid> list) {
            Intrinsics.checkNotNullParameter(list, "network");
            return new SsidWrapper(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SsidWrapper) && Intrinsics.areEqual((Object) this.network, (Object) ((SsidWrapper) obj).network);
        }

        public int hashCode() {
            return this.network.hashCode();
        }

        public String toString() {
            return "SsidWrapper(network=" + this.network + ')';
        }

        public SsidWrapper(List<Ssid> list) {
            Intrinsics.checkNotNullParameter(list, "network");
            this.network = list;
        }

        public final List<Ssid> getNetwork() {
            return this.network;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/blueair/api/restapi/ProvisioningWifiRestApi$DeviceEventWrapper;", "", "events", "", "Lcom/blueair/core/model/DeviceEvent;", "<init>", "(Ljava/util/List;)V", "getEvents", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ProvisioningWifiRestApi.kt */
    public static final class DeviceEventWrapper {
        private final List<DeviceEvent> events;

        public static /* synthetic */ DeviceEventWrapper copy$default(DeviceEventWrapper deviceEventWrapper, List<DeviceEvent> list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = deviceEventWrapper.events;
            }
            return deviceEventWrapper.copy(list);
        }

        public final List<DeviceEvent> component1() {
            return this.events;
        }

        public final DeviceEventWrapper copy(List<DeviceEvent> list) {
            Intrinsics.checkNotNullParameter(list, "events");
            return new DeviceEventWrapper(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeviceEventWrapper) && Intrinsics.areEqual((Object) this.events, (Object) ((DeviceEventWrapper) obj).events);
        }

        public int hashCode() {
            return this.events.hashCode();
        }

        public String toString() {
            return "DeviceEventWrapper(events=" + this.events + ')';
        }

        public DeviceEventWrapper(List<DeviceEvent> list) {
            Intrinsics.checkNotNullParameter(list, "events");
            this.events = list;
        }

        public final List<DeviceEvent> getEvents() {
            return this.events;
        }
    }

    /* renamed from: com.blueair.api.restapi.ProvisioningWifiRestApi$-CC  reason: invalid class name */
    /* compiled from: ProvisioningWifiRestApi.kt */
    public final /* synthetic */ class CC {
        static {
            Companion companion = ProvisioningWifiRestApi.Companion;
        }

        public static /* synthetic */ Deferred switchOffSoftAp$default(ProvisioningWifiRestApi provisioningWifiRestApi, String str, SwitchOffSoftApBody switchOffSoftApBody, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    switchOffSoftApBody = new SwitchOffSoftApBody(false, 1, (DefaultConstructorMarker) null);
                }
                return provisioningWifiRestApi.switchOffSoftAp(str, switchOffSoftApBody);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchOffSoftAp");
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/blueair/api/restapi/ProvisioningWifiRestApi$SwitchOffSoftApBody;", "", "enabled", "", "<init>", "(Z)V", "getEnabled", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ProvisioningWifiRestApi.kt */
    public static final class SwitchOffSoftApBody {
        private final boolean enabled;

        public SwitchOffSoftApBody() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ SwitchOffSoftApBody copy$default(SwitchOffSoftApBody switchOffSoftApBody, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = switchOffSoftApBody.enabled;
            }
            return switchOffSoftApBody.copy(z);
        }

        public final boolean component1() {
            return this.enabled;
        }

        public final SwitchOffSoftApBody copy(boolean z) {
            return new SwitchOffSoftApBody(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SwitchOffSoftApBody) && this.enabled == ((SwitchOffSoftApBody) obj).enabled;
        }

        public int hashCode() {
            return AddDeviceState$$ExternalSyntheticBackport0.m(this.enabled);
        }

        public String toString() {
            return "SwitchOffSoftApBody(enabled=" + this.enabled + ')';
        }

        public SwitchOffSoftApBody(boolean z) {
            this.enabled = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SwitchOffSoftApBody(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        public final boolean getEnabled() {
            return this.enabled;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/blueair/api/restapi/ProvisioningWifiRestApi$ResetDeviceBody;", "", "instructions", "", "Lcom/blueair/api/restapi/ProvisioningWifiRestApi$InstructionBody;", "<init>", "(Ljava/util/List;)V", "getInstructions", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ProvisioningWifiRestApi.kt */
    public static final class ResetDeviceBody {
        private final List<InstructionBody> instructions;

        public ResetDeviceBody() {
            this((List) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ResetDeviceBody copy$default(ResetDeviceBody resetDeviceBody, List<InstructionBody> list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = resetDeviceBody.instructions;
            }
            return resetDeviceBody.copy(list);
        }

        public final List<InstructionBody> component1() {
            return this.instructions;
        }

        public final ResetDeviceBody copy(List<InstructionBody> list) {
            Intrinsics.checkNotNullParameter(list, "instructions");
            return new ResetDeviceBody(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ResetDeviceBody) && Intrinsics.areEqual((Object) this.instructions, (Object) ((ResetDeviceBody) obj).instructions);
        }

        public int hashCode() {
            return this.instructions.hashCode();
        }

        public String toString() {
            return "ResetDeviceBody(instructions=" + this.instructions + ')';
        }

        public ResetDeviceBody(List<InstructionBody> list) {
            Intrinsics.checkNotNullParameter(list, "instructions");
            this.instructions = list;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ResetDeviceBody(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.listOf(new InstructionBody((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null)) : list);
        }

        public final List<InstructionBody> getInstructions() {
            return this.instructions;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/blueair/api/restapi/ProvisioningWifiRestApi$InstructionBody;", "", "target", "", "instruction", "store", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTarget", "()Ljava/lang/String;", "getInstruction", "getStore", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ProvisioningWifiRestApi.kt */
    public static final class InstructionBody {
        private final String instruction;
        private final String store;
        private final String target;

        public InstructionBody() {
            this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ InstructionBody copy$default(InstructionBody instructionBody, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = instructionBody.target;
            }
            if ((i & 2) != 0) {
                str2 = instructionBody.instruction;
            }
            if ((i & 4) != 0) {
                str3 = instructionBody.store;
            }
            return instructionBody.copy(str, str2, str3);
        }

        public final String component1() {
            return this.target;
        }

        public final String component2() {
            return this.instruction;
        }

        public final String component3() {
            return this.store;
        }

        public final InstructionBody copy(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, TypedValues.AttributesType.S_TARGET);
            Intrinsics.checkNotNullParameter(str2, "instruction");
            Intrinsics.checkNotNullParameter(str3, PlaceTypes.STORE);
            return new InstructionBody(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InstructionBody)) {
                return false;
            }
            InstructionBody instructionBody = (InstructionBody) obj;
            return Intrinsics.areEqual((Object) this.target, (Object) instructionBody.target) && Intrinsics.areEqual((Object) this.instruction, (Object) instructionBody.instruction) && Intrinsics.areEqual((Object) this.store, (Object) instructionBody.store);
        }

        public int hashCode() {
            return (((this.target.hashCode() * 31) + this.instruction.hashCode()) * 31) + this.store.hashCode();
        }

        public String toString() {
            return "InstructionBody(target=" + this.target + ", instruction=" + this.instruction + ", store=" + this.store + ')';
        }

        public InstructionBody(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, TypedValues.AttributesType.S_TARGET);
            Intrinsics.checkNotNullParameter(str2, "instruction");
            Intrinsics.checkNotNullParameter(str3, PlaceTypes.STORE);
            this.target = str;
            this.instruction = str2;
            this.store = str3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ InstructionBody(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "Target-Descision" : str, (i & 2) != 0 ? "Rollback-Config" : str2, (i & 4) != 0 ? "Initial" : str3);
        }

        public final String getInstruction() {
            return this.instruction;
        }

        public final String getStore() {
            return this.store;
        }

        public final String getTarget() {
            return this.target;
        }
    }
}
