package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\t\u0012\b\b\u0003\u0010\n\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\r\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u000fHÆ\u0003Ju\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\r\u001a\u00020\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u00107\u001a\u00020%2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\tHÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b)\u0010\u0013R\u0013\u0010*\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b+\u0010\u0013¨\u0006;"},
   d2 = {"Lcom/blueair/core/model/DeviceEvent;", "", "id", "", "timeStamp", "", "origin", "message", "errorCode", "", "connectionEvent", "region", "relayingParty", "stateName", "info", "Lcom/blueair/core/model/Info;", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/Info;)V", "getId", "()Ljava/lang/String;", "getTimeStamp", "()J", "getOrigin", "getMessage", "getErrorCode", "()I", "getConnectionEvent", "getRegion", "getRelayingParty", "getStateName", "getInfo", "()Lcom/blueair/core/model/Info;", "onboardingState", "Lcom/blueair/core/model/OnboardingState;", "getOnboardingState", "()Lcom/blueair/core/model/OnboardingState;", "hasError", "", "getHasError", "()Z", "errorMessage", "getErrorMessage", "originDeviceId", "getOriginDeviceId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
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

   public DeviceEvent(String var1, @Json(name = "ts") long var2, @Json(name = "o") String var4, @Json(name = "m") String var5, @Json(name = "ec") int var6, @Json(name = "et") String var7, @Json(name = "r") String var8, @Json(name = "rp") String var9, @Json(name = "ot") String var10, @Json(name = "a") Info var11) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Intrinsics.checkNotNullParameter(var5, "message");
      Intrinsics.checkNotNullParameter(var7, "connectionEvent");
      Intrinsics.checkNotNullParameter(var10, "stateName");
      super();
      this.id = var1;
      this.timeStamp = var2;
      this.origin = var4;
      this.message = var5;
      this.errorCode = var6;
      this.connectionEvent = var7;
      this.region = var8;
      this.relayingParty = var9;
      this.stateName = var10;
      this.info = var11;
   }

   // $FF: synthetic method
   public DeviceEvent(String var1, long var2, String var4, String var5, int var6, String var7, String var8, String var9, String var10, Info var11, int var12, DefaultConstructorMarker var13) {
      if ((var12 & 8) != 0) {
         var5 = "";
      }

      if ((var12 & 16) != 0) {
         var6 = 0;
      }

      if ((var12 & 32) != 0) {
         var7 = "";
      }

      if ((var12 & 64) != 0) {
         var8 = "";
      }

      if ((var12 & 128) != 0) {
         var9 = null;
      }

      if ((var12 & 256) != 0) {
         var10 = "";
      }

      if ((var12 & 512) != 0) {
         var11 = null;
      }

      this(var1, var2, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   // $FF: synthetic method
   public static DeviceEvent copy$default(DeviceEvent var0, String var1, long var2, String var4, String var5, int var6, String var7, String var8, String var9, String var10, Info var11, int var12, Object var13) {
      if ((var12 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var12 & 2) != 0) {
         var2 = var0.timeStamp;
      }

      if ((var12 & 4) != 0) {
         var4 = var0.origin;
      }

      if ((var12 & 8) != 0) {
         var5 = var0.message;
      }

      if ((var12 & 16) != 0) {
         var6 = var0.errorCode;
      }

      if ((var12 & 32) != 0) {
         var7 = var0.connectionEvent;
      }

      if ((var12 & 64) != 0) {
         var8 = var0.region;
      }

      if ((var12 & 128) != 0) {
         var9 = var0.relayingParty;
      }

      if ((var12 & 256) != 0) {
         var10 = var0.stateName;
      }

      if ((var12 & 512) != 0) {
         var11 = var0.info;
      }

      return var0.copy(var1, var2, var4, var5, var6, var7, var8, var9, var10, var11);
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

   public final DeviceEvent copy(String var1, @Json(name = "ts") long var2, @Json(name = "o") String var4, @Json(name = "m") String var5, @Json(name = "ec") int var6, @Json(name = "et") String var7, @Json(name = "r") String var8, @Json(name = "rp") String var9, @Json(name = "ot") String var10, @Json(name = "a") Info var11) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Intrinsics.checkNotNullParameter(var5, "message");
      Intrinsics.checkNotNullParameter(var7, "connectionEvent");
      Intrinsics.checkNotNullParameter(var10, "stateName");
      return new DeviceEvent(var1, var2, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceEvent)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.id, var1.id)) {
            return false;
         } else if (this.timeStamp != var1.timeStamp) {
            return false;
         } else if (!Intrinsics.areEqual(this.origin, var1.origin)) {
            return false;
         } else if (!Intrinsics.areEqual(this.message, var1.message)) {
            return false;
         } else if (this.errorCode != var1.errorCode) {
            return false;
         } else if (!Intrinsics.areEqual(this.connectionEvent, var1.connectionEvent)) {
            return false;
         } else if (!Intrinsics.areEqual(this.region, var1.region)) {
            return false;
         } else if (!Intrinsics.areEqual(this.relayingParty, var1.relayingParty)) {
            return false;
         } else if (!Intrinsics.areEqual(this.stateName, var1.stateName)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.info, var1.info);
         }
      }
   }

   public final String getConnectionEvent() {
      return this.connectionEvent;
   }

   public final int getErrorCode() {
      return this.errorCode;
   }

   public final String getErrorMessage() {
      StringBuilder var1 = new StringBuilder("event = ");
      var1.append(this.connectionEvent);
      var1.append(", errorCode = ");
      var1.append(this.errorCode);
      return var1.toString();
   }

   public final boolean getHasError() {
      return this.errorCode < 0;
   }

   public final String getId() {
      return this.id;
   }

   public final Info getInfo() {
      return this.info;
   }

   public final String getMessage() {
      return this.message;
   }

   public final OnboardingState getOnboardingState() {
      return OnboardingState.Companion.fromName(this.connectionEvent);
   }

   public final String getOrigin() {
      return this.origin;
   }

   public final String getOriginDeviceId() {
      return this.origin;
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

   public final long getTimeStamp() {
      return this.timeStamp;
   }

   public int hashCode() {
      int var5 = this.id.hashCode();
      int var6 = AddDeviceState$$ExternalSyntheticBackport0.m(this.timeStamp);
      String var11 = this.origin;
      int var4 = 0;
      int var1;
      if (var11 == null) {
         var1 = 0;
      } else {
         var1 = var11.hashCode();
      }

      int var7 = this.message.hashCode();
      int var9 = this.errorCode;
      int var8 = this.connectionEvent.hashCode();
      var11 = this.region;
      int var2;
      if (var11 == null) {
         var2 = 0;
      } else {
         var2 = var11.hashCode();
      }

      var11 = this.relayingParty;
      int var3;
      if (var11 == null) {
         var3 = 0;
      } else {
         var3 = var11.hashCode();
      }

      int var10 = this.stateName.hashCode();
      Info var14 = this.info;
      if (var14 != null) {
         var4 = var14.hashCode();
      }

      return ((((((((var5 * 31 + var6) * 31 + var1) * 31 + var7) * 31 + var9) * 31 + var8) * 31 + var2) * 31 + var3) * 31 + var10) * 31 + var4;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceEvent(id=");
      var1.append(this.id);
      var1.append(", timeStamp=");
      var1.append(this.timeStamp);
      var1.append(", origin=");
      var1.append(this.origin);
      var1.append(", message=");
      var1.append(this.message);
      var1.append(", errorCode=");
      var1.append(this.errorCode);
      var1.append(", connectionEvent=");
      var1.append(this.connectionEvent);
      var1.append(", region=");
      var1.append(this.region);
      var1.append(", relayingParty=");
      var1.append(this.relayingParty);
      var1.append(", stateName=");
      var1.append(this.stateName);
      var1.append(", info=");
      var1.append(this.info);
      var1.append(')');
      return var1.toString();
   }
}
