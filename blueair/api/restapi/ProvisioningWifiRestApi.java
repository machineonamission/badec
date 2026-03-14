package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.api.model.ProvisionRequestBody;
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

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b`\u0018\u0000 \u00122\u00020\u0001:\u0007\u0012\u0013\u0014\u0015\u0016\u0017\u0018J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\nH'J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\u000b\u001a\u00020\u000fH'J\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0011\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\bH'¨\u0006\u0019À\u0006\u0003"},
   d2 = {"Lcom/blueair/api/restapi/ProvisioningWifiRestApi;", "", "getUuid", "Lkotlinx/coroutines/Deferred;", "Lcom/blueair/api/restapi/ProvisioningWifiRestApi$UuidWrapper;", "getSsids", "Lcom/blueair/api/restapi/ProvisioningWifiRestApi$SsidWrapper;", "uuid", "", "provisionDevice", "Lcom/blueair/api/model/ProvisionRequestBody;", "request", "getOnboardingEventQueue", "Lcom/blueair/api/restapi/ProvisioningWifiRestApi$DeviceEventWrapper;", "switchOffSoftAp", "Lcom/blueair/api/restapi/ProvisioningWifiRestApi$SwitchOffSoftApBody;", "resetDevice", "ipv4", "Companion", "UuidWrapper", "SsidWrapper", "DeviceEventWrapper", "SwitchOffSoftApBody", "ResetDeviceBody", "InstructionBody", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface ProvisioningWifiRestApi {
   String BASE_DOMAIN = "192.168.4.1";
   String BASE_URL = "https://192.168.4.1/";
   Companion Companion = ProvisioningWifiRestApi.Companion.$$INSTANCE;
   String EVENT_QUEUE = "d/{uuid}/events/queue";
   String GET_SSIDS = "d/{uuid}/management/ssid";
   String GET_STATS = "d/getstats";
   String GET_UUID = "d/uuid";
   String PROVISION = "d/{uuid}/provision/ssid";
   String RESET_DEVICE = "https://{ipv4}/d/{uuid}/management/reset";
   String SWITCH_OFF_SOFT_AP = "d/{uuid}/management/softap";

   @GET("d/{uuid}/events/queue")
   Deferred getOnboardingEventQueue(@Path("uuid") String var1);

   @GET("d/{uuid}/management/ssid")
   Deferred getSsids(@Path("uuid") String var1);

   @GET("d/uuid")
   Deferred getUuid();

   @POST("d/{uuid}/provision/ssid")
   Deferred provisionDevice(@Path("uuid") String var1, @Body ProvisionRequestBody var2);

   @GET("https://{ipv4}/d/{uuid}/management/reset")
   Deferred resetDevice(@Path("ipv4") String var1, @Path("uuid") String var2);

   @POST("d/{uuid}/management/softap")
   Deferred switchOffSoftAp(@Path("uuid") String var1, @Body SwitchOffSoftApBody var2);

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"},
      d2 = {"Lcom/blueair/api/restapi/ProvisioningWifiRestApi$Companion;", "", "<init>", "()V", "BASE_DOMAIN", "", "BASE_URL", "GET_UUID", "GET_SSIDS", "PROVISION", "EVENT_QUEUE", "GET_STATS", "SWITCH_OFF_SOFT_AP", "RESET_DEVICE", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      static final Companion $$INSTANCE = new Companion();
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

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      // $FF: synthetic method
      public static Deferred switchOffSoftAp$default(ProvisioningWifiRestApi var0, String var1, SwitchOffSoftApBody var2, int var3, Object var4) {
         return ProvisioningWifiRestApi$_CC.switchOffSoftAp$default(var0, var1, var2, var3, var4);
      }
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"},
      d2 = {"Lcom/blueair/api/restapi/ProvisioningWifiRestApi$DeviceEventWrapper;", "", "events", "", "Lcom/blueair/core/model/DeviceEvent;", "<init>", "(Ljava/util/List;)V", "getEvents", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DeviceEventWrapper {
      private final List events;

      public DeviceEventWrapper(List var1) {
         Intrinsics.checkNotNullParameter(var1, "events");
         super();
         this.events = var1;
      }

      // $FF: synthetic method
      public static DeviceEventWrapper copy$default(DeviceEventWrapper var0, List var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.events;
         }

         return var0.copy(var1);
      }

      public final List component1() {
         return this.events;
      }

      public final DeviceEventWrapper copy(List var1) {
         Intrinsics.checkNotNullParameter(var1, "events");
         return new DeviceEventWrapper(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof DeviceEventWrapper)) {
            return false;
         } else {
            var1 = var1;
            return Intrinsics.areEqual(this.events, var1.events);
         }
      }

      public final List getEvents() {
         return this.events;
      }

      public int hashCode() {
         return this.events.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("DeviceEventWrapper(events=");
         var1.append(this.events);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"},
      d2 = {"Lcom/blueair/api/restapi/ProvisioningWifiRestApi$InstructionBody;", "", "target", "", "instruction", "store", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTarget", "()Ljava/lang/String;", "getInstruction", "getStore", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class InstructionBody {
      private final String instruction;
      private final String store;
      private final String target;

      public InstructionBody() {
         this((String)null, (String)null, (String)null, 7, (DefaultConstructorMarker)null);
      }

      public InstructionBody(String var1, String var2, String var3) {
         Intrinsics.checkNotNullParameter(var1, "target");
         Intrinsics.checkNotNullParameter(var2, "instruction");
         Intrinsics.checkNotNullParameter(var3, "store");
         super();
         this.target = var1;
         this.instruction = var2;
         this.store = var3;
      }

      // $FF: synthetic method
      public InstructionBody(String var1, String var2, String var3, int var4, DefaultConstructorMarker var5) {
         if ((var4 & 1) != 0) {
            var1 = "Target-Descision";
         }

         if ((var4 & 2) != 0) {
            var2 = "Rollback-Config";
         }

         if ((var4 & 4) != 0) {
            var3 = "Initial";
         }

         this(var1, var2, var3);
      }

      // $FF: synthetic method
      public static InstructionBody copy$default(InstructionBody var0, String var1, String var2, String var3, int var4, Object var5) {
         if ((var4 & 1) != 0) {
            var1 = var0.target;
         }

         if ((var4 & 2) != 0) {
            var2 = var0.instruction;
         }

         if ((var4 & 4) != 0) {
            var3 = var0.store;
         }

         return var0.copy(var1, var2, var3);
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

      public final InstructionBody copy(String var1, String var2, String var3) {
         Intrinsics.checkNotNullParameter(var1, "target");
         Intrinsics.checkNotNullParameter(var2, "instruction");
         Intrinsics.checkNotNullParameter(var3, "store");
         return new InstructionBody(var1, var2, var3);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof InstructionBody)) {
            return false;
         } else {
            var1 = var1;
            if (!Intrinsics.areEqual(this.target, var1.target)) {
               return false;
            } else if (!Intrinsics.areEqual(this.instruction, var1.instruction)) {
               return false;
            } else {
               return Intrinsics.areEqual(this.store, var1.store);
            }
         }
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

      public int hashCode() {
         return (this.target.hashCode() * 31 + this.instruction.hashCode()) * 31 + this.store.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("InstructionBody(target=");
         var1.append(this.target);
         var1.append(", instruction=");
         var1.append(this.instruction);
         var1.append(", store=");
         var1.append(this.store);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"},
      d2 = {"Lcom/blueair/api/restapi/ProvisioningWifiRestApi$ResetDeviceBody;", "", "instructions", "", "Lcom/blueair/api/restapi/ProvisioningWifiRestApi$InstructionBody;", "<init>", "(Ljava/util/List;)V", "getInstructions", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ResetDeviceBody {
      private final List instructions;

      public ResetDeviceBody() {
         this((List)null, 1, (DefaultConstructorMarker)null);
      }

      public ResetDeviceBody(List var1) {
         Intrinsics.checkNotNullParameter(var1, "instructions");
         super();
         this.instructions = var1;
      }

      // $FF: synthetic method
      public ResetDeviceBody(List var1, int var2, DefaultConstructorMarker var3) {
         if ((var2 & 1) != 0) {
            var1 = CollectionsKt.listOf(new InstructionBody((String)null, (String)null, (String)null, 7, (DefaultConstructorMarker)null));
         }

         this(var1);
      }

      // $FF: synthetic method
      public static ResetDeviceBody copy$default(ResetDeviceBody var0, List var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.instructions;
         }

         return var0.copy(var1);
      }

      public final List component1() {
         return this.instructions;
      }

      public final ResetDeviceBody copy(List var1) {
         Intrinsics.checkNotNullParameter(var1, "instructions");
         return new ResetDeviceBody(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof ResetDeviceBody)) {
            return false;
         } else {
            var1 = var1;
            return Intrinsics.areEqual(this.instructions, var1.instructions);
         }
      }

      public final List getInstructions() {
         return this.instructions;
      }

      public int hashCode() {
         return this.instructions.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("ResetDeviceBody(instructions=");
         var1.append(this.instructions);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"},
      d2 = {"Lcom/blueair/api/restapi/ProvisioningWifiRestApi$SsidWrapper;", "", "network", "", "Lcom/blueair/core/model/Ssid;", "<init>", "(Ljava/util/List;)V", "getNetwork", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SsidWrapper {
      private final List network;

      public SsidWrapper(List var1) {
         Intrinsics.checkNotNullParameter(var1, "network");
         super();
         this.network = var1;
      }

      // $FF: synthetic method
      public static SsidWrapper copy$default(SsidWrapper var0, List var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.network;
         }

         return var0.copy(var1);
      }

      public final List component1() {
         return this.network;
      }

      public final SsidWrapper copy(List var1) {
         Intrinsics.checkNotNullParameter(var1, "network");
         return new SsidWrapper(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof SsidWrapper)) {
            return false;
         } else {
            var1 = var1;
            return Intrinsics.areEqual(this.network, var1.network);
         }
      }

      public final List getNetwork() {
         return this.network;
      }

      public int hashCode() {
         return this.network.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("SsidWrapper(network=");
         var1.append(this.network);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"},
      d2 = {"Lcom/blueair/api/restapi/ProvisioningWifiRestApi$SwitchOffSoftApBody;", "", "enabled", "", "<init>", "(Z)V", "getEnabled", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SwitchOffSoftApBody {
      private final boolean enabled;

      public SwitchOffSoftApBody() {
         this(false, 1, (DefaultConstructorMarker)null);
      }

      public SwitchOffSoftApBody(boolean var1) {
         this.enabled = var1;
      }

      // $FF: synthetic method
      public SwitchOffSoftApBody(boolean var1, int var2, DefaultConstructorMarker var3) {
         if ((var2 & 1) != 0) {
            var1 = false;
         }

         this(var1);
      }

      // $FF: synthetic method
      public static SwitchOffSoftApBody copy$default(SwitchOffSoftApBody var0, boolean var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.enabled;
         }

         return var0.copy(var1);
      }

      public final boolean component1() {
         return this.enabled;
      }

      public final SwitchOffSoftApBody copy(boolean var1) {
         return new SwitchOffSoftApBody(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof SwitchOffSoftApBody)) {
            return false;
         } else {
            var1 = var1;
            return this.enabled == var1.enabled;
         }
      }

      public final boolean getEnabled() {
         return this.enabled;
      }

      public int hashCode() {
         return AddDeviceState$$ExternalSyntheticBackport0.m(this.enabled);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("SwitchOffSoftApBody(enabled=");
         var1.append(this.enabled);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"},
      d2 = {"Lcom/blueair/api/restapi/ProvisioningWifiRestApi$UuidWrapper;", "", "uuid", "", "Lcom/blueair/core/model/DeviceUuid;", "<init>", "(Ljava/util/List;)V", "getUuid", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class UuidWrapper {
      private final List uuid;

      public UuidWrapper(List var1) {
         Intrinsics.checkNotNullParameter(var1, "uuid");
         super();
         this.uuid = var1;
      }

      // $FF: synthetic method
      public static UuidWrapper copy$default(UuidWrapper var0, List var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.uuid;
         }

         return var0.copy(var1);
      }

      public final List component1() {
         return this.uuid;
      }

      public final UuidWrapper copy(List var1) {
         Intrinsics.checkNotNullParameter(var1, "uuid");
         return new UuidWrapper(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof UuidWrapper)) {
            return false;
         } else {
            var1 = var1;
            return Intrinsics.areEqual(this.uuid, var1.uuid);
         }
      }

      public final List getUuid() {
         return this.uuid;
      }

      public int hashCode() {
         return this.uuid.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("UuidWrapper(uuid=");
         var1.append(this.uuid);
         var1.append(')');
         return var1.toString();
      }
   }
}
