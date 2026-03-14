package com.blueair.api.restapi;

import com.blueair.core.model.BlueCloudHomeLocationReceive;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0003¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u001e\u001a\u00020\u0003¢\u0006\u0002\u0010\"J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ja\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u001dHÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012¨\u0006/"},
   d2 = {"Lcom/blueair/api/restapi/DeviceInfo;", "", "id", "", "configuration", "Lcom/blueair/api/restapi/Configuration;", "sensordata", "", "Lcom/blueair/api/model/SensorData;", "states", "Lcom/blueair/api/restapi/State;", "welcomehome", "Lcom/blueair/core/model/BlueCloudHomeLocationReceive;", "location_id", "timezone", "<init>", "(Ljava/lang/String;Lcom/blueair/api/restapi/Configuration;Ljava/util/List;Ljava/util/List;Lcom/blueair/core/model/BlueCloudHomeLocationReceive;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getConfiguration", "()Lcom/blueair/api/restapi/Configuration;", "getSensordata", "()Ljava/util/List;", "getStates", "getWelcomehome", "()Lcom/blueair/core/model/BlueCloudHomeLocationReceive;", "getLocation_id", "getTimezone", "obtainStateIntValue", "", "fieldName", "(Ljava/lang/String;)Ljava/lang/Integer;", "obtainStateBoolValue", "", "(Ljava/lang/String;)Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceInfo {
   private final Configuration configuration;
   private final String id;
   private final String location_id;
   private final List sensordata;
   private final List states;
   private final String timezone;
   private final BlueCloudHomeLocationReceive welcomehome;

   public DeviceInfo(String var1, Configuration var2, List var3, List var4, BlueCloudHomeLocationReceive var5, String var6, String var7) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Intrinsics.checkNotNullParameter(var2, "configuration");
      Intrinsics.checkNotNullParameter(var3, "sensordata");
      Intrinsics.checkNotNullParameter(var4, "states");
      super();
      this.id = var1;
      this.configuration = var2;
      this.sensordata = var3;
      this.states = var4;
      this.welcomehome = var5;
      this.location_id = var6;
      this.timezone = var7;
   }

   // $FF: synthetic method
   public static DeviceInfo copy$default(DeviceInfo var0, String var1, Configuration var2, List var3, List var4, BlueCloudHomeLocationReceive var5, String var6, String var7, int var8, Object var9) {
      if ((var8 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var8 & 2) != 0) {
         var2 = var0.configuration;
      }

      if ((var8 & 4) != 0) {
         var3 = var0.sensordata;
      }

      if ((var8 & 8) != 0) {
         var4 = var0.states;
      }

      if ((var8 & 16) != 0) {
         var5 = var0.welcomehome;
      }

      if ((var8 & 32) != 0) {
         var6 = var0.location_id;
      }

      if ((var8 & 64) != 0) {
         var7 = var0.timezone;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7);
   }

   public final String component1() {
      return this.id;
   }

   public final Configuration component2() {
      return this.configuration;
   }

   public final List component3() {
      return this.sensordata;
   }

   public final List component4() {
      return this.states;
   }

   public final BlueCloudHomeLocationReceive component5() {
      return this.welcomehome;
   }

   public final String component6() {
      return this.location_id;
   }

   public final String component7() {
      return this.timezone;
   }

   public final DeviceInfo copy(String var1, Configuration var2, List var3, List var4, BlueCloudHomeLocationReceive var5, String var6, String var7) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Intrinsics.checkNotNullParameter(var2, "configuration");
      Intrinsics.checkNotNullParameter(var3, "sensordata");
      Intrinsics.checkNotNullParameter(var4, "states");
      return new DeviceInfo(var1, var2, var3, var4, var5, var6, var7);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceInfo)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.id, var1.id)) {
            return false;
         } else if (!Intrinsics.areEqual(this.configuration, var1.configuration)) {
            return false;
         } else if (!Intrinsics.areEqual(this.sensordata, var1.sensordata)) {
            return false;
         } else if (!Intrinsics.areEqual(this.states, var1.states)) {
            return false;
         } else if (!Intrinsics.areEqual(this.welcomehome, var1.welcomehome)) {
            return false;
         } else if (!Intrinsics.areEqual(this.location_id, var1.location_id)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.timezone, var1.timezone);
         }
      }
   }

   public final Configuration getConfiguration() {
      return this.configuration;
   }

   public final String getId() {
      return this.id;
   }

   public final String getLocation_id() {
      return this.location_id;
   }

   public final List getSensordata() {
      return this.sensordata;
   }

   public final List getStates() {
      return this.states;
   }

   public final String getTimezone() {
      return this.timezone;
   }

   public final BlueCloudHomeLocationReceive getWelcomehome() {
      return this.welcomehome;
   }

   public int hashCode() {
      int var4 = this.id.hashCode();
      int var5 = this.configuration.hashCode();
      int var7 = this.sensordata.hashCode();
      int var6 = this.states.hashCode();
      BlueCloudHomeLocationReceive var8 = this.welcomehome;
      int var3 = 0;
      int var1;
      if (var8 == null) {
         var1 = 0;
      } else {
         var1 = var8.hashCode();
      }

      String var9 = this.location_id;
      int var2;
      if (var9 == null) {
         var2 = 0;
      } else {
         var2 = var9.hashCode();
      }

      var9 = this.timezone;
      if (var9 != null) {
         var3 = var9.hashCode();
      }

      return (((((var4 * 31 + var5) * 31 + var7) * 31 + var6) * 31 + var1) * 31 + var2) * 31 + var3;
   }

   public final Boolean obtainStateBoolValue(String var1) {
      Intrinsics.checkNotNullParameter(var1, "fieldName");
      Iterator var3 = ((Iterable)this.states).iterator();

      while(true) {
         if (var3.hasNext()) {
            Object var2 = var3.next();
            if (!Intrinsics.areEqual(((State)var2).getN(), var1)) {
               continue;
            }

            var4 = var2;
            break;
         }

         var4 = null;
         break;
      }

      State var5 = (State)var4;
      return var5 != null ? var5.getVb() : null;
   }

   public final Integer obtainStateIntValue(String var1) {
      Intrinsics.checkNotNullParameter(var1, "fieldName");
      Iterator var3 = ((Iterable)this.states).iterator();

      while(true) {
         if (var3.hasNext()) {
            Object var2 = var3.next();
            if (!Intrinsics.areEqual(((State)var2).getN(), var1)) {
               continue;
            }

            var4 = var2;
            break;
         }

         var4 = null;
         break;
      }

      State var5 = (State)var4;
      return var5 != null ? var5.getV() : null;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceInfo(id=");
      var1.append(this.id);
      var1.append(", configuration=");
      var1.append(this.configuration);
      var1.append(", sensordata=");
      var1.append(this.sensordata);
      var1.append(", states=");
      var1.append(this.states);
      var1.append(", welcomehome=");
      var1.append(this.welcomehome);
      var1.append(", location_id=");
      var1.append(this.location_id);
      var1.append(", timezone=");
      var1.append(this.timezone);
      var1.append(')');
      return var1.toString();
   }
}
