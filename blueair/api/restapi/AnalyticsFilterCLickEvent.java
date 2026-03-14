package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.AnalyticEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0081\b\u0018\u0000 :2\u00020\u0001:\u0001:By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u0097\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\rHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016¨\u0006;"},
   d2 = {"Lcom/blueair/api/restapi/AnalyticsFilterCLickEvent;", "", "event_name", "", "click_time", "", "device_model", "device_uuid", "device_sku", "device_mcu_firmware", "device_timezone", "device_filter_type", "device_filter_left_life", "", "filter_name", "user_id", "user_region", "phone_os", "phone_device", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEvent_name", "()Ljava/lang/String;", "getClick_time", "()J", "getDevice_model", "getDevice_uuid", "getDevice_sku", "getDevice_mcu_firmware", "getDevice_timezone", "getDevice_filter_type", "getDevice_filter_left_life", "()I", "getFilter_name", "getUser_id", "getUser_region", "getPhone_os", "getPhone_device", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AnalyticsFilterCLickEvent {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final long click_time;
   private final int device_filter_left_life;
   private final String device_filter_type;
   private final String device_mcu_firmware;
   private final String device_model;
   private final String device_sku;
   private final String device_timezone;
   private final String device_uuid;
   private final String event_name;
   private final String filter_name;
   private final String phone_device;
   private final String phone_os;
   private final String user_id;
   private final String user_region;

   public AnalyticsFilterCLickEvent(String var1, long var2, String var4, String var5, String var6, String var7, String var8, String var9, int var10, String var11, String var12, String var13, String var14, String var15) {
      Intrinsics.checkNotNullParameter(var1, "event_name");
      Intrinsics.checkNotNullParameter(var4, "device_model");
      Intrinsics.checkNotNullParameter(var5, "device_uuid");
      Intrinsics.checkNotNullParameter(var6, "device_sku");
      Intrinsics.checkNotNullParameter(var7, "device_mcu_firmware");
      Intrinsics.checkNotNullParameter(var8, "device_timezone");
      Intrinsics.checkNotNullParameter(var9, "device_filter_type");
      Intrinsics.checkNotNullParameter(var12, "user_id");
      Intrinsics.checkNotNullParameter(var13, "user_region");
      Intrinsics.checkNotNullParameter(var14, "phone_os");
      Intrinsics.checkNotNullParameter(var15, "phone_device");
      super();
      this.event_name = var1;
      this.click_time = var2;
      this.device_model = var4;
      this.device_uuid = var5;
      this.device_sku = var6;
      this.device_mcu_firmware = var7;
      this.device_timezone = var8;
      this.device_filter_type = var9;
      this.device_filter_left_life = var10;
      this.filter_name = var11;
      this.user_id = var12;
      this.user_region = var13;
      this.phone_os = var14;
      this.phone_device = var15;
   }

   // $FF: synthetic method
   public static AnalyticsFilterCLickEvent copy$default(AnalyticsFilterCLickEvent var0, String var1, long var2, String var4, String var5, String var6, String var7, String var8, String var9, int var10, String var11, String var12, String var13, String var14, String var15, int var16, Object var17) {
      if ((var16 & 1) != 0) {
         var1 = var0.event_name;
      }

      if ((var16 & 2) != 0) {
         var2 = var0.click_time;
      }

      if ((var16 & 4) != 0) {
         var4 = var0.device_model;
      }

      if ((var16 & 8) != 0) {
         var5 = var0.device_uuid;
      }

      if ((var16 & 16) != 0) {
         var6 = var0.device_sku;
      }

      if ((var16 & 32) != 0) {
         var7 = var0.device_mcu_firmware;
      }

      if ((var16 & 64) != 0) {
         var8 = var0.device_timezone;
      }

      if ((var16 & 128) != 0) {
         var9 = var0.device_filter_type;
      }

      if ((var16 & 256) != 0) {
         var10 = var0.device_filter_left_life;
      }

      if ((var16 & 512) != 0) {
         var11 = var0.filter_name;
      }

      if ((var16 & 1024) != 0) {
         var12 = var0.user_id;
      }

      if ((var16 & 2048) != 0) {
         var13 = var0.user_region;
      }

      if ((var16 & 4096) != 0) {
         var14 = var0.phone_os;
      }

      if ((var16 & 8192) != 0) {
         var15 = var0.phone_device;
      }

      return var0.copy(var1, var2, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
   }

   public final String component1() {
      return this.event_name;
   }

   public final String component10() {
      return this.filter_name;
   }

   public final String component11() {
      return this.user_id;
   }

   public final String component12() {
      return this.user_region;
   }

   public final String component13() {
      return this.phone_os;
   }

   public final String component14() {
      return this.phone_device;
   }

   public final long component2() {
      return this.click_time;
   }

   public final String component3() {
      return this.device_model;
   }

   public final String component4() {
      return this.device_uuid;
   }

   public final String component5() {
      return this.device_sku;
   }

   public final String component6() {
      return this.device_mcu_firmware;
   }

   public final String component7() {
      return this.device_timezone;
   }

   public final String component8() {
      return this.device_filter_type;
   }

   public final int component9() {
      return this.device_filter_left_life;
   }

   public final AnalyticsFilterCLickEvent copy(String var1, long var2, String var4, String var5, String var6, String var7, String var8, String var9, int var10, String var11, String var12, String var13, String var14, String var15) {
      Intrinsics.checkNotNullParameter(var1, "event_name");
      Intrinsics.checkNotNullParameter(var4, "device_model");
      Intrinsics.checkNotNullParameter(var5, "device_uuid");
      Intrinsics.checkNotNullParameter(var6, "device_sku");
      Intrinsics.checkNotNullParameter(var7, "device_mcu_firmware");
      Intrinsics.checkNotNullParameter(var8, "device_timezone");
      Intrinsics.checkNotNullParameter(var9, "device_filter_type");
      Intrinsics.checkNotNullParameter(var12, "user_id");
      Intrinsics.checkNotNullParameter(var13, "user_region");
      Intrinsics.checkNotNullParameter(var14, "phone_os");
      Intrinsics.checkNotNullParameter(var15, "phone_device");
      return new AnalyticsFilterCLickEvent(var1, var2, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof AnalyticsFilterCLickEvent)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.event_name, var1.event_name)) {
            return false;
         } else if (this.click_time != var1.click_time) {
            return false;
         } else if (!Intrinsics.areEqual(this.device_model, var1.device_model)) {
            return false;
         } else if (!Intrinsics.areEqual(this.device_uuid, var1.device_uuid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.device_sku, var1.device_sku)) {
            return false;
         } else if (!Intrinsics.areEqual(this.device_mcu_firmware, var1.device_mcu_firmware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.device_timezone, var1.device_timezone)) {
            return false;
         } else if (!Intrinsics.areEqual(this.device_filter_type, var1.device_filter_type)) {
            return false;
         } else if (this.device_filter_left_life != var1.device_filter_left_life) {
            return false;
         } else if (!Intrinsics.areEqual(this.filter_name, var1.filter_name)) {
            return false;
         } else if (!Intrinsics.areEqual(this.user_id, var1.user_id)) {
            return false;
         } else if (!Intrinsics.areEqual(this.user_region, var1.user_region)) {
            return false;
         } else if (!Intrinsics.areEqual(this.phone_os, var1.phone_os)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.phone_device, var1.phone_device);
         }
      }
   }

   public final long getClick_time() {
      return this.click_time;
   }

   public final int getDevice_filter_left_life() {
      return this.device_filter_left_life;
   }

   public final String getDevice_filter_type() {
      return this.device_filter_type;
   }

   public final String getDevice_mcu_firmware() {
      return this.device_mcu_firmware;
   }

   public final String getDevice_model() {
      return this.device_model;
   }

   public final String getDevice_sku() {
      return this.device_sku;
   }

   public final String getDevice_timezone() {
      return this.device_timezone;
   }

   public final String getDevice_uuid() {
      return this.device_uuid;
   }

   public final String getEvent_name() {
      return this.event_name;
   }

   public final String getFilter_name() {
      return this.filter_name;
   }

   public final String getPhone_device() {
      return this.phone_device;
   }

   public final String getPhone_os() {
      return this.phone_os;
   }

   public final String getUser_id() {
      return this.user_id;
   }

   public final String getUser_region() {
      return this.user_region;
   }

   public int hashCode() {
      int var2 = this.event_name.hashCode();
      int var6 = AddDeviceState$$ExternalSyntheticBackport0.m(this.click_time);
      int var9 = this.device_model.hashCode();
      int var3 = this.device_uuid.hashCode();
      int var5 = this.device_sku.hashCode();
      int var8 = this.device_mcu_firmware.hashCode();
      int var10 = this.device_timezone.hashCode();
      int var4 = this.device_filter_type.hashCode();
      int var7 = this.device_filter_left_life;
      String var11 = this.filter_name;
      int var1;
      if (var11 == null) {
         var1 = 0;
      } else {
         var1 = var11.hashCode();
      }

      return ((((((((((((var2 * 31 + var6) * 31 + var9) * 31 + var3) * 31 + var5) * 31 + var8) * 31 + var10) * 31 + var4) * 31 + var7) * 31 + var1) * 31 + this.user_id.hashCode()) * 31 + this.user_region.hashCode()) * 31 + this.phone_os.hashCode()) * 31 + this.phone_device.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("AnalyticsFilterCLickEvent(event_name=");
      var1.append(this.event_name);
      var1.append(", click_time=");
      var1.append(this.click_time);
      var1.append(", device_model=");
      var1.append(this.device_model);
      var1.append(", device_uuid=");
      var1.append(this.device_uuid);
      var1.append(", device_sku=");
      var1.append(this.device_sku);
      var1.append(", device_mcu_firmware=");
      var1.append(this.device_mcu_firmware);
      var1.append(", device_timezone=");
      var1.append(this.device_timezone);
      var1.append(", device_filter_type=");
      var1.append(this.device_filter_type);
      var1.append(", device_filter_left_life=");
      var1.append(this.device_filter_left_life);
      var1.append(", filter_name=");
      var1.append(this.filter_name);
      var1.append(", user_id=");
      var1.append(this.user_id);
      var1.append(", user_region=");
      var1.append(this.user_region);
      var1.append(", phone_os=");
      var1.append(this.phone_os);
      var1.append(", phone_device=");
      var1.append(this.phone_device);
      var1.append(')');
      return var1.toString();
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/api/restapi/AnalyticsFilterCLickEvent$Companion;", "", "<init>", "()V", "fromAnalyticEvent", "Lcom/blueair/api/restapi/AnalyticsFilterCLickEvent;", "event", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      private static final String fromAnalyticEvent$payloadStr(AnalyticEvent.FilterClickEvent var0, String var1) {
         Object var2 = var0.getPayload().get(var1);
         String var3;
         if (var2 instanceof String) {
            var3 = (String)var2;
         } else {
            var3 = null;
         }

         var1 = var3;
         if (var3 == null) {
            var1 = "";
         }

         return var1;
      }

      public final AnalyticsFilterCLickEvent fromAnalyticEvent(AnalyticEvent.FilterClickEvent var1) {
         Intrinsics.checkNotNullParameter(var1, "event");
         String var8 = var1.getEventName();
         Object var6 = var1.getPayload().get("click_time");
         boolean var3 = var6 instanceof Long;
         Object var7 = null;
         Long var15;
         if (var3) {
            var15 = (Long)var6;
         } else {
            var15 = null;
         }

         long var4;
         if (var15 != null) {
            var4 = var15;
         } else {
            var4 = System.currentTimeMillis();
         }

         String var14 = fromAnalyticEvent$payloadStr(var1, "device_model");
         String var12 = fromAnalyticEvent$payloadStr(var1, "device_uuid");
         String var11 = fromAnalyticEvent$payloadStr(var1, "device_sku");
         String var13 = fromAnalyticEvent$payloadStr(var1, "device_mcu_firmware");
         String var10 = fromAnalyticEvent$payloadStr(var1, "device_timezone");
         String var9 = fromAnalyticEvent$payloadStr(var1, "device_filter_type");
         Object var16 = var1.getPayload().get("device_filter_left_life");
         Integer var17;
         if (var16 instanceof Integer) {
            var17 = (Integer)var16;
         } else {
            var17 = null;
         }

         int var2;
         if (var17 != null) {
            var2 = var17;
         } else {
            var2 = 0;
         }

         CharSequence var18 = (CharSequence)fromAnalyticEvent$payloadStr(var1, "filter_name");
         if (var18.length() == 0) {
            var18 = (CharSequence)var7;
         }

         return new AnalyticsFilterCLickEvent(var8, var4, var14, var12, var11, var13, var10, var9, var2, (String)var18, fromAnalyticEvent$payloadStr(var1, "user_id"), fromAnalyticEvent$payloadStr(var1, "user_region"), fromAnalyticEvent$payloadStr(var1, "phone_os"), fromAnalyticEvent$payloadStr(var1, "phone_device"));
      }
   }
}
