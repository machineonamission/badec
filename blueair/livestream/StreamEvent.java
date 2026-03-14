package com.blueair.livestream;

import com.blueair.api.model.SensorDataKt;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.ConnectedState;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceEvent;
import com.blueair.core.model.DeviceState;
import com.blueair.core.model.DeviceStreamAttribute;
import com.blueair.core.model.DualOscillationConfig;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.util.MoshiSerializer;
import io.flatcircle.ble.BleEvent;
import io.flatcircle.mqtt.MqttEvent;
import io.flatcircle.stomp.StompEvent;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001c*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001cB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ4\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"},
   d2 = {"Lcom/blueair/livestream/StreamEvent;", "T", "", "eventType", "Lcom/blueair/livestream/StreamEventType;", "deviceId", "", "content", "<init>", "(Lcom/blueair/livestream/StreamEventType;Ljava/lang/String;Ljava/lang/Object;)V", "getEventType", "()Lcom/blueair/livestream/StreamEventType;", "getDeviceId", "()Ljava/lang/String;", "getContent", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component3", "copy", "(Lcom/blueair/livestream/StreamEventType;Ljava/lang/String;Ljava/lang/Object;)Lcom/blueair/livestream/StreamEvent;", "equals", "", "other", "hashCode", "", "toString", "Companion", "livestream_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class StreamEvent {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final Lazy alarmSerializer$delegate = LazyKt.lazy(new StreamEvent$$ExternalSyntheticLambda0());
   private static Map updateProgress = (Map)(new LinkedHashMap());
   private final Object content;
   private final String deviceId;
   private final StreamEventType eventType;

   // $FF: synthetic method
   public static MoshiSerializer $r8$lambda$WbIPmYnif4V7JjfT9HopyIjxdog() {
      return alarmSerializer_delegate$lambda$0();
   }

   public StreamEvent(StreamEventType var1, String var2, Object var3) {
      Intrinsics.checkNotNullParameter(var1, "eventType");
      Intrinsics.checkNotNullParameter(var2, "deviceId");
      super();
      this.eventType = var1;
      this.deviceId = var2;
      this.content = var3;
   }

   // $FF: synthetic method
   public StreamEvent(StreamEventType var1, String var2, Object var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 4) != 0) {
         var3 = null;
      }

      this(var1, var2, var3);
   }

   private static final MoshiSerializer alarmSerializer_delegate$lambda$0() {
      return new MoshiSerializer((Type)DeviceAlarm.class, new Object[0]);
   }

   // $FF: synthetic method
   public static StreamEvent copy$default(StreamEvent var0, StreamEventType var1, String var2, Object var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.eventType;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.deviceId;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.content;
      }

      return var0.copy(var1, var2, var3);
   }

   public final StreamEventType component1() {
      return this.eventType;
   }

   public final String component2() {
      return this.deviceId;
   }

   public final Object component3() {
      return this.content;
   }

   public final StreamEvent copy(StreamEventType var1, String var2, Object var3) {
      Intrinsics.checkNotNullParameter(var1, "eventType");
      Intrinsics.checkNotNullParameter(var2, "deviceId");
      return new StreamEvent(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof StreamEvent)) {
         return false;
      } else {
         var1 = var1;
         if (this.eventType != var1.eventType) {
            return false;
         } else if (!Intrinsics.areEqual(this.deviceId, var1.deviceId)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.content, var1.content);
         }
      }
   }

   public final Object getContent() {
      return this.content;
   }

   public final String getDeviceId() {
      return this.deviceId;
   }

   public final StreamEventType getEventType() {
      return this.eventType;
   }

   public int hashCode() {
      int var2 = this.eventType.hashCode();
      int var3 = this.deviceId.hashCode();
      Object var4 = this.content;
      int var1;
      if (var4 == null) {
         var1 = 0;
      } else {
         var1 = var4.hashCode();
      }

      return (var2 * 31 + var3) * 31 + var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("StreamEvent(eventType=");
      var1.append(this.eventType);
      var1.append(", deviceId=");
      var1.append(this.deviceId);
      var1.append(", content=");
      var1.append(this.content);
      var1.append(')');
      return var1.toString();
   }

   @Metadata(
      d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013J \u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0011\"\u0004\b\u0001\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0017J \u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0011\"\u0004\b\u0001\u0010\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001aR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"},
      d2 = {"Lcom/blueair/livestream/StreamEvent$Companion;", "", "<init>", "()V", "updateProgress", "", "", "", "alarmSerializer", "Lcom/blueair/core/util/MoshiSerializer;", "Lcom/blueair/core/model/DeviceAlarm;", "getAlarmSerializer", "()Lcom/blueair/core/util/MoshiSerializer;", "alarmSerializer$delegate", "Lkotlin/Lazy;", "fromMqtt", "", "Lcom/blueair/livestream/StreamEvent;", "mqttEvent", "Lio/flatcircle/mqtt/MqttEvent;", "fromStomp", "T", "stompEvent", "Lio/flatcircle/stomp/StompEvent;", "fromBle", "bleEvent", "Lio/flatcircle/ble/BleEvent;", "livestream_otherRelease"},
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

      private static final void fromMqtt$addDeviceStreamAttributeEvent(List var0, MqttEvent var1, DeviceStreamAttribute var2) {
         var0.add(new StreamEvent(StreamEventType.DEVICE_ATTRIBUTE, ((MqttEvent.MqttStateEvent)var1).getDeviceId(), var2));
      }

      private static final DeviceAlarm fromMqtt$toAlarm(Object var0) {
         DeviceAlarm var1 = null;
         Object var2 = null;
         if (var0 != null) {
            label108: {
               Throwable var10000;
               label113: {
                  label105: {
                     try {
                        Result.Companion var12 = Result.Companion;
                        if (var0 instanceof Map) {
                           var0 = (DeviceAlarm)StreamEvent.Companion.getAlarmSerializer().fromMap((Map)var0);
                           break label105;
                        }
                     } catch (Throwable var8) {
                        var10000 = var8;
                        boolean var10001 = false;
                        break label113;
                     }

                     var0 = null;
                  }

                  label97:
                  try {
                     var0 = Result.constructor-impl(var0);
                     break label108;
                  } catch (Throwable var7) {
                     var10000 = var7;
                     boolean var14 = false;
                     break label97;
                  }
               }

               Throwable var13 = var10000;
               Result.Companion var10 = Result.Companion;
               var0 = Result.constructor-impl(ResultKt.createFailure(var13));
            }

            if (Result.isFailure-impl(var0)) {
               var0 = var2;
            }

            var1 = (DeviceAlarm)var0;
         }

         return var1;
      }

      private final MoshiSerializer getAlarmSerializer() {
         return (MoshiSerializer)StreamEvent.alarmSerializer$delegate.getValue();
      }

      public final StreamEvent fromBle(BleEvent var1) {
         Intrinsics.checkNotNullParameter(var1, "bleEvent");
         Object var3 = var1.getContent();
         boolean var2 = var3 instanceof ConnectivityStatus;
         Object var4 = null;
         Pair var9;
         if (var2) {
            StreamEventType var5 = StreamEventType.DEVICE_ATTRIBUTE;
            Object var8 = var1.getContent();
            Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type com.blueair.core.model.ConnectivityStatus");
            var9 = TuplesKt.to(var5, new DeviceStreamAttribute.ConnectivityStatus(((ConnectivityStatus)var8).ordinal()));
         } else if (var3 instanceof IndoorDatapoint) {
            StreamEventType var12 = StreamEventType.DEVICE_ATTRIBUTE;
            Object var10 = var1.getContent();
            Intrinsics.checkNotNull(var10, "null cannot be cast to non-null type com.blueair.core.model.IndoorDatapoint");
            var9 = TuplesKt.to(var12, new DeviceStreamAttribute.LatestSensorDataPoint((IndoorDatapoint)var10));
         } else if (var3 instanceof DeviceStreamAttribute) {
            StreamEventType var13 = StreamEventType.DEVICE_ATTRIBUTE;
            Object var11 = var1.getContent();
            Intrinsics.checkNotNull(var11, "null cannot be cast to non-null type com.blueair.core.model.DeviceStreamAttribute<*>");
            var9 = TuplesKt.to(var13, (DeviceStreamAttribute)var11);
         } else {
            var9 = TuplesKt.to(StreamEventType.UNKNOWN, new DeviceStreamAttribute.Unknown(false, 1, (DefaultConstructorMarker)null));
         }

         StreamEventType var14 = (StreamEventType)var9.getFirst();
         String var6 = var1.getUuid();
         Object var7 = var9.getSecond();
         if (var7 == null) {
            var7 = var4;
         }

         return new StreamEvent(var14, var6, var7);
      }

      public final List fromMqtt(MqttEvent var1) {
         Intrinsics.checkNotNullParameter(var1, "mqttEvent");
         boolean var15 = var1 instanceof MqttEvent.MqttDeviceEvent;
         int var12 = 0;
         if (var15) {
            DeviceEvent var295 = ((MqttEvent.MqttDeviceEvent)var1).getDeviceEvent();
            List var218 = (List)(new ArrayList());
            CharSequence var43 = (CharSequence)var295.getConnectionEvent();
            CharSequence var26 = (CharSequence)"ImageProvision";
            Object var46 = null;
            var15 = StringsKt.contains$default(var43, var26, false, 2, (Object)null);
            String var44 = "";
            if (var15) {
               Timber.Forest.v("fromMqtt: DEVICE_OTA StreamEvent", new Object[0]);
               StreamEventType var296 = StreamEventType.DEVICE_OTA;
               String var62 = var295.getOrigin();
               String var27 = var62;
               if (var62 == null) {
                  var27 = "";
               }

               int var37;
               label515: {
                  var62 = var295.getOrigin();
                  if (var62 != null) {
                     Map var23 = StreamEvent.updateProgress;
                     Integer var22 = (Integer)StreamEvent.updateProgress.get(var62);
                     if (var22 != null) {
                        var37 = var22;
                     } else {
                        var37 = 0;
                     }

                     var23.put(var62, var37 + 3);
                     Integer var64 = (Integer)StreamEvent.updateProgress.get(var62);
                     if (var64 != null) {
                        var37 = var64;
                        break label515;
                     }
                  }

                  var37 = 0;
               }

               var218.add(new StreamEvent(var296, var27, Math.min(99, var37)));
            }

            ConnectedState var65 = ConnectedState.Companion.fromName(var295.getConnectionEvent());
            ConnectivityStatus var28;
            if (Intrinsics.areEqual(var65, ConnectedState.Connected.INSTANCE)) {
               var28 = ConnectivityStatus.ONLINE;
            } else {
               var28 = (ConnectivityStatus)var46;
               if (Intrinsics.areEqual(var65, ConnectedState.NotConnected.INSTANCE)) {
                  var28 = ConnectivityStatus.OFFLINE;
               }
            }

            if (var28 != null) {
               String var47 = var295.getOriginDeviceId();
               if (var47 != null) {
                  StreamEvent.updateProgress.put(var47, 0);
                  Unit var48 = Unit.INSTANCE;
                  var48 = Unit.INSTANCE;
               }

               Timber.Forest var50 = Timber.Forest;
               StringBuilder var66 = new StringBuilder("fromMqtt: ConnectivityStatus event with connectivityStatus ");
               var66.append(var28);
               var50.v(var66.toString(), new Object[0]);
               StreamEventType var67 = StreamEventType.DEVICE_ATTRIBUTE;
               String var51 = var295.getOriginDeviceId();
               if (var51 != null) {
                  var44 = var51;
               }

               var218.add(new StreamEvent(var67, var44, new DeviceStreamAttribute.ConnectivityStatus(var28.ordinal())));
            }

            return var218;
         } else if (var1 instanceof MqttEvent.MqttSensorEvent) {
            MqttEvent.MqttSensorEvent var25 = (MqttEvent.MqttSensorEvent)var1;
            IndoorDatapoint var42 = SensorDataKt.toIndoorDatapoint(var25.getSensorEvents());
            return var42 == null ? CollectionsKt.emptyList() : CollectionsKt.listOf(new StreamEvent(StreamEventType.DEVICE_ATTRIBUTE, var25.getDeviceId(), new DeviceStreamAttribute.LatestSensorDataPoint(var42)));
         } else if (var1 instanceof MqttEvent.MqttConnectivityEvent) {
            MqttEvent.MqttConnectivityEvent var41 = (MqttEvent.MqttConnectivityEvent)var1;
            ConnectivityStatus var24;
            if (var41.isOnline()) {
               var24 = ConnectivityStatus.ONLINE;
            } else {
               var24 = ConnectivityStatus.OFFLINE;
            }

            int var35 = var24.ordinal();
            return CollectionsKt.listOf(new StreamEvent(StreamEventType.DEVICE_ATTRIBUTE, var41.getDeviceId(), new DeviceStreamAttribute.ConnectivityStatus(var35)));
         } else if (var1 instanceof MqttEvent.MqttStateEvent) {
            List var16 = (List)(new ArrayList());
            MqttEvent.MqttStateEvent var19 = (MqttEvent.MqttStateEvent)var1;
            DeviceState var17 = var19.getSensorStateBundle().getCurrent().getState().getReported();
            DeviceState var18 = var19.getSensorStateBundle().getPrevious().getState().getReported();
            Timber.Forest var21 = Timber.Forest;
            StringBuilder var20 = new StringBuilder("fromMqtt: curReported =  ");
            var20.append(var17);
            var20.append("  & prevReported = ");
            var20.append(var18);
            var21.d(var20.toString(), new Object[0]);
            if (!Intrinsics.areEqual(var17.getAutomode(), var18.getAutomode())) {
               Boolean var219 = var17.getAutomode();
               if (var219 != null) {
                  var15 = var219;
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.AutoMode(AutoMode.Companion.fromBoolean(var15).toText()));
                  Unit var220 = Unit.INSTANCE;
                  var220 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getChildlock(), var18.getChildlock())) {
               Boolean var222 = var17.getChildlock();
               if (var222 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.ChildLock(var222));
                  Unit var223 = Unit.INSTANCE;
                  var223 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getFanspeed(), var18.getFanspeed())) {
               Integer var225 = var17.getFanspeed();
               if (var225 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.FanSpeedManualOrAuto(((Number)var225).intValue()));
                  Unit var226 = Unit.INSTANCE;
                  var226 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getBrightness(), var18.getBrightness())) {
               Integer var228 = var17.getBrightness();
               if (var228 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.Brightness(((Number)var228).intValue()));
                  Unit var229 = Unit.INSTANCE;
                  var229 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getGermshield(), var18.getGermshield())) {
               Boolean var231 = var17.getGermshield();
               if (var231 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.GermShield(var231));
                  Unit var232 = Unit.INSTANCE;
                  var232 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getGsnm(), var18.getGsnm())) {
               Boolean var234 = var17.getGsnm();
               if (var234 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.GermShieldNight(var234));
                  Unit var235 = Unit.INSTANCE;
                  var235 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getNightmode(), var18.getNightmode())) {
               Boolean var237 = var17.getNightmode();
               if (var237 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.G4NightMode(var237));
                  Unit var238 = Unit.INSTANCE;
                  var238 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getStandby(), var18.getStandby())) {
               Boolean var240 = var17.getStandby();
               if (var240 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.StandByMode(var240));
                  Unit var241 = Unit.INSTANCE;
                  var241 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getEco(), var18.getEco())) {
               Boolean var243 = var17.getEco();
               if (var243 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.EcoMode(var243));
                  Unit var244 = Unit.INSTANCE;
                  var244 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getHins(), var18.getHins())) {
               Boolean var246 = var17.getHins();
               if (var246 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.HinsMode(var246));
                  Unit var247 = Unit.INSTANCE;
                  var247 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getNmhins(), var18.getNmhins())) {
               Boolean var249 = var17.getNmhins();
               if (var249 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.HinsNightMode(var249));
                  Unit var250 = Unit.INSTANCE;
                  var250 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getSafetyswitch(), var18.getSafetyswitch())) {
               Boolean var252 = var17.getSafetyswitch();
               if (var252 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.SafetySwitch(var252));
                  Unit var253 = Unit.INSTANCE;
                  var253 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getFilterusage(), var18.getFilterusage())) {
               Integer var255 = var17.getFilterusage();
               if (var255 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.FilterUsage(((Number)var255).intValue()));
                  Unit var256 = Unit.INSTANCE;
                  var256 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getDisinfection(), var18.getDisinfection())) {
               Boolean var258 = var17.getDisinfection();
               if (var258 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.Disinfection(var258));
                  Unit var259 = Unit.INSTANCE;
                  var259 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getDisinftime(), var18.getDisinftime())) {
               Integer var261 = var17.getDisinftime();
               if (var261 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.DisinfectLeftTime(new Pair(((Number)var261).intValue(), var19.getSensorStateBundle().getTimestamp())));
                  Unit var262 = Unit.INSTANCE;
                  var262 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getWickdrye(), var18.getWickdrye())) {
               Boolean var264 = var17.getWickdrye();
               if (var264 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.WickdryEnabled(var264));
                  Unit var265 = Unit.INSTANCE;
                  var265 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getWickdrys(), var18.getWickdrys())) {
               Boolean var267 = var17.getWickdrys();
               if (var267 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.WickdryOn(var267));
                  Unit var268 = Unit.INSTANCE;
                  var268 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getWickdryl(), var18.getWickdryl()) || !Intrinsics.areEqual(var17.getWickdryts(), var18.getWickdryts())) {
               Integer var270 = var17.getWickdryl();
               if (var270 != null) {
                  int var2 = ((Number)var270).intValue();
                  var270 = var17.getWickdryts();
                  long var13;
                  if (var270 != null) {
                     var13 = (long)var270;
                  } else {
                     var13 = var19.getSensorStateBundle().getTimestamp();
                  }

                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.WickdryLeftTime(new Pair(var2, var13)));
                  Unit var272 = Unit.INSTANCE;
                  var272 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getWickusage(), var18.getWickusage())) {
               Integer var274 = var17.getWickusage();
               if (var274 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.WickUsage(((Number)var274).intValue()));
                  Unit var275 = Unit.INSTANCE;
                  var275 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getWshortage(), var18.getWshortage())) {
               Boolean var277 = var17.getWshortage();
               if (var277 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.WaterShortage(var277));
                  Unit var278 = Unit.INSTANCE;
                  var278 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getAutorh(), var18.getAutorh())) {
               Integer var280 = var17.getAutorh();
               if (var280 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.AutoRh(((Number)var280).intValue()));
                  Unit var281 = Unit.INSTANCE;
                  var281 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getTimstate(), var18.getTimstate())) {
               Integer var283 = var17.getTimstate();
               if (var283 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.TimerStatus(((Number)var283).intValue()));
                  Unit var284 = Unit.INSTANCE;
                  var284 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getTimdur(), var18.getTimdur())) {
               Integer var286 = var17.getTimdur();
               if (var286 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.TimerDuration(((Number)var286).intValue()));
                  Unit var287 = Unit.INSTANCE;
                  var287 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getTiml(), var18.getTiml()) || !Intrinsics.areEqual(var17.getTimts(), var18.getTimts())) {
               Integer var289 = var17.getTiml();
               if (var289 != null) {
                  int var29 = ((Number)var289).intValue();
                  var289 = var17.getTimts();
                  long var38;
                  if (var289 != null) {
                     var38 = (long)var289;
                  } else {
                     var38 = var19.getSensorStateBundle().getTimestamp();
                  }

                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.TimerLeftTime(new Pair(var29, var38)));
                  Unit var68 = Unit.INSTANCE;
                  var68 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getTu(), var18.getTu())) {
               Integer var70 = var17.getTu();
               if (var70 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.TemperatureUnit(((Number)var70).intValue()));
                  Unit var71 = Unit.INSTANCE;
                  var71 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getOscstate(), var18.getOscstate())) {
               Integer var73 = var17.getOscstate();
               if (var73 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.OscillationState(((Number)var73).intValue()));
                  Unit var74 = Unit.INSTANCE;
                  var74 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getOsc(), var18.getOsc())) {
               Integer var76 = var17.getOsc();
               if (var76 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.OscillationAngle(((Number)var76).intValue()));
                  Unit var77 = Unit.INSTANCE;
                  var77 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getOscdir(), var18.getOscdir())) {
               Integer var79 = var17.getOscdir();
               if (var79 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.OscillationDirection(((Number)var79).intValue()));
                  Unit var80 = Unit.INSTANCE;
                  var80 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getOscfs(), var18.getOscfs())) {
               Integer var82 = var17.getOscfs();
               if (var82 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.OscillationFanSpeed(((Number)var82).intValue()));
                  Unit var83 = Unit.INSTANCE;
                  var83 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getMainmode(), var18.getMainmode())) {
               Integer var85 = var17.getMainmode();
               if (var85 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.MainMode(((Number)var85).intValue()));
                  Unit var86 = Unit.INSTANCE;
                  var86 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getApsubmode(), var18.getApsubmode())) {
               Integer var88 = var17.getApsubmode();
               if (var88 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.ApSubMode(((Number)var88).intValue()));
                  Unit var89 = Unit.INSTANCE;
                  var89 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getFsp0(), var18.getFsp0())) {
               Integer var91 = var17.getFsp0();
               if (var91 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.ApFanSpeed(((Number)var91).intValue()));
                  Unit var92 = Unit.INSTANCE;
                  var92 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getHeatsubmode(), var18.getHeatsubmode())) {
               Integer var94 = var17.getHeatsubmode();
               if (var94 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.HeatSubMode(((Number)var94).intValue()));
                  Unit var95 = Unit.INSTANCE;
                  var95 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getHeatfs(), var18.getHeatfs())) {
               Integer var97 = var17.getHeatfs();
               if (var97 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.HeatFanSpeed(((Number)var97).intValue()));
                  Unit var98 = Unit.INSTANCE;
                  var98 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getHeattemp(), var18.getHeattemp())) {
               Integer var100 = var17.getHeattemp();
               if (var100 != null) {
                  int var30 = ((Number)var100).intValue();
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.HeatAutoTmp(DeviceData.Companion.fromServerValue(var30)));
                  Unit var101 = Unit.INSTANCE;
                  var101 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getEcoheattemp(), var18.getEcoheattemp())) {
               Integer var103 = var17.getEcoheattemp();
               if (var103 != null) {
                  int var31 = ((Number)var103).intValue();
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.HeatEcoTmp(DeviceData.Companion.fromServerValue(var31)));
                  Unit var104 = Unit.INSTANCE;
                  var104 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getCoolsubmode(), var18.getCoolsubmode())) {
               Integer var106 = var17.getCoolsubmode();
               if (var106 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.CoolSubMode(((Number)var106).intValue()));
                  Unit var107 = Unit.INSTANCE;
                  var107 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getCoolfs(), var18.getCoolfs())) {
               Integer var109 = var17.getCoolfs();
               if (var109 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.CoolFanSpeed(((Number)var109).intValue()));
                  Unit var110 = Unit.INSTANCE;
                  var110 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getCoolautotag(), var18.getCoolautotag())) {
               Integer var112 = var17.getCoolautotag();
               if (var112 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.CoolAutoTag(((Number)var112).intValue()));
                  Unit var113 = Unit.INSTANCE;
                  var113 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getCoolautofs1(), var18.getCoolautofs1()) || !Intrinsics.areEqual(var17.getCoolautofs2(), var18.getCoolautofs2()) || !Intrinsics.areEqual(var17.getCoolautofs3(), var18.getCoolautofs3())) {
               Iterable var291 = (Iterable)CollectionsKt.listOfNotNull(new Integer[]{var17.getCoolautofs1(), var17.getCoolautofs2(), var17.getCoolautofs3()});
               Collection var115 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var291, 10)));
               Iterator var292 = var291.iterator();

               while(var292.hasNext()) {
                  int var32 = ((Number)var292.next()).intValue();
                  var115.add(DeviceData.Companion.fromServerValue(var32));
               }

               fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.CoolAutoPresets(CollectionsKt.toDoubleArray((Collection)((List)var115))));
               Unit var116 = Unit.INSTANCE;
            }

            if (!Intrinsics.areEqual(var17.getCoolecotag(), var18.getCoolecotag())) {
               Integer var117 = var17.getCoolecotag();
               if (var117 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.CoolEcoTag(((Number)var117).intValue()));
                  Unit var118 = Unit.INSTANCE;
                  var118 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getCoolecofs1(), var18.getCoolecofs1()) || !Intrinsics.areEqual(var17.getCoolecofs2(), var18.getCoolecofs2())) {
               Iterable var293 = (Iterable)CollectionsKt.listOfNotNull(new Integer[]{var17.getCoolecofs1(), var17.getCoolecofs2()});
               Collection var120 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var293, 10)));
               Iterator var294 = var293.iterator();

               while(var294.hasNext()) {
                  int var33 = ((Number)var294.next()).intValue();
                  var120.add(DeviceData.Companion.fromServerValue(var33));
               }

               fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.CoolEcoPresets(CollectionsKt.toDoubleArray((Collection)((List)var120))));
               Unit var121 = Unit.INSTANCE;
            }

            if (!Intrinsics.areEqual(var17.getMode(), var18.getMode())) {
               Integer var122 = var17.getMode();
               if (var122 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.Mode(((Number)var122).intValue()));
                  Unit var123 = Unit.INSTANCE;
                  var123 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getHummode(), var18.getHummode())) {
               Boolean var125 = var17.getHummode();
               if (var125 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.HumMode(var125));
                  Unit var126 = Unit.INSTANCE;
                  var126 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getWlevel(), var18.getWlevel())) {
               Integer var128 = var17.getWlevel();
               if (var128 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.WaterLevel(((Number)var128).intValue()));
                  Unit var129 = Unit.INSTANCE;
                  var129 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getDehsubmode(), var18.getDehsubmode())) {
               Integer var131 = var17.getDehsubmode();
               if (var131 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.DehSubMode(((Number)var131).intValue()));
                  Unit var132 = Unit.INSTANCE;
                  var132 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getWatertankfailure(), var18.getWatertankfailure())) {
               Boolean var134 = var17.getWatertankfailure();
               if (var134 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.WaterTankFailure(var134));
                  Unit var135 = Unit.INSTANCE;
                  var135 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getWtankfail(), var18.getWtankfail())) {
               Boolean var137 = var17.getWtankfail();
               if (var137 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.WaterTankFailure(var137));
                  Unit var138 = Unit.INSTANCE;
                  var138 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getSmartsubmode(), var18.getSmartsubmode())) {
               Integer var140 = var17.getSmartsubmode();
               if (var140 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.SmartSubMode(((Number)var140).intValue()));
                  Unit var141 = Unit.INSTANCE;
                  var141 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getDetectcat(), var18.getDetectcat())) {
               Boolean var143 = var17.getDetectcat();
               if (var143 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.DetectCat(var143));
                  Unit var144 = Unit.INSTANCE;
                  var144 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getBodymounted(), var18.getBodymounted())) {
               Boolean var146 = var17.getBodymounted();
               if (var146 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.BodyMounted(var146));
                  Unit var147 = Unit.INSTANCE;
                  var147 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getAireta(), var18.getAireta())) {
               Integer var149 = var17.getAireta();
               if (var149 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.CleanAirEta(((Number)var149).intValue()));
                  Unit var150 = Unit.INSTANCE;
                  var150 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getDisplaymode(), var18.getDisplaymode())) {
               Integer var152 = var17.getDisplaymode();
               if (var152 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.PanelDisplayMode(((Number)var152).intValue()));
                  Unit var153 = Unit.INSTANCE;
                  var153 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getHover(), var18.getHover())) {
               Boolean var155 = var17.getHover();
               if (var155 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.HoverEnabled(var155));
                  Unit var156 = Unit.INSTANCE;
                  var156 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getAirrefresh(), var18.getAirrefresh())) {
               Boolean var158 = var17.getAirrefresh();
               if (var158 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.AirRefreshEnabled(var158));
                  Unit var159 = Unit.INSTANCE;
                  var159 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getArstate(), var18.getArstate())) {
               Integer var161 = var17.getArstate();
               if (var161 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.AirRefreshStatus(((Number)var161).intValue()));
                  Unit var162 = Unit.INSTANCE;
                  var162 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getArdur(), var18.getArdur())) {
               Integer var164 = var17.getArdur();
               if (var164 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.AirRefreshDuration(((Number)var164).intValue()));
                  Unit var165 = Unit.INSTANCE;
                  var165 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getArts(), var18.getArts())) {
               Integer var167 = var17.getArts();
               if (var167 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.AirRefreshTimeStamp(((Number)var167).intValue()));
                  Unit var168 = Unit.INSTANCE;
                  var168 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getStartts(), var18.getStartts())) {
               Integer var170 = var17.getStartts();
               if (var170 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.AirRefreshStartTimeStamp(((Number)var170).intValue()));
                  Unit var171 = Unit.INSTANCE;
                  var171 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getEndts(), var18.getEndts())) {
               Integer var173 = var17.getEndts();
               if (var173 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.AirRefreshEndTimeStamp(((Number)var173).intValue()));
                  Unit var174 = Unit.INSTANCE;
                  var174 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getRoomtype(), var18.getRoomtype())) {
               Integer var176 = var17.getRoomtype();
               if (var176 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.RoomType(((Number)var176).intValue()));
                  Unit var177 = Unit.INSTANCE;
                  var177 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getNlbrightness(), var18.getNlbrightness())) {
               Integer var179 = var17.getNlbrightness();
               if (var179 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.NightLampBrightness(((Number)var179).intValue()));
                  Unit var180 = Unit.INSTANCE;
                  var180 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getWickdrydur(), var18.getWickdrydur())) {
               Integer var182 = var17.getWickdrydur();
               if (var182 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.WickdryDuration(((Number)var182).intValue()));
                  Unit var183 = Unit.INSTANCE;
                  var183 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getWickdrydone(), var18.getWickdrydone())) {
               Boolean var185 = var17.getWickdrydone();
               if (var185 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.WickdryDone(var185));
                  Unit var186 = Unit.INSTANCE;
                  var186 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getYwrme(), var18.getYwrme())) {
               fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.YwrmEnabled(var17.getYwrme()));
            }

            if (!Intrinsics.areEqual(var17.getYwrmusage(), var18.getYwrmusage())) {
               Integer var188 = var17.getYwrmusage();
               if (var188 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.YwrmUsage(((Number)var188).intValue()));
                  Unit var189 = Unit.INSTANCE;
                  var189 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getNlstepless(), var18.getNlstepless())) {
               Integer var191 = var17.getNlstepless();
               if (var191 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.NightLampSteplessBrightness(((Number)var191).intValue()));
                  Unit var192 = Unit.INSTANCE;
                  var192 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getAlarm1(), var18.getAlarm1()) || !Intrinsics.areEqual(var17.getAlarm2(), var18.getAlarm2()) || !Intrinsics.areEqual(var17.getAlarm3(), var18.getAlarm3()) || !Intrinsics.areEqual(var17.getAlarm4(), var18.getAlarm4()) || !Intrinsics.areEqual(var17.getAlarm5(), var18.getAlarm5()) || !Intrinsics.areEqual(var17.getAlarm6(), var18.getAlarm6())) {
               fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.Alarms(CollectionsKt.listOf(new DeviceAlarm[]{fromMqtt$toAlarm(var17.getAlarm1()), fromMqtt$toAlarm(var17.getAlarm2()), fromMqtt$toAlarm(var17.getAlarm3()), fromMqtt$toAlarm(var17.getAlarm4()), fromMqtt$toAlarm(var17.getAlarm5()), fromMqtt$toAlarm(var17.getAlarm6())})));
            }

            if (!Intrinsics.areEqual(var17.getHumsubmode(), var18.getHumsubmode())) {
               Integer var194 = var17.getHumsubmode();
               if (var194 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.HumSubMode(((Number)var194).intValue()));
                  Unit var195 = Unit.INSTANCE;
                  var195 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getHourformat(), var18.getHourformat())) {
               Boolean var197 = var17.getHourformat();
               if (var197 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.Use24Hour(var197));
                  Unit var198 = Unit.INSTANCE;
                  var198 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getWaterinfill(), var18.getWaterinfill())) {
               Boolean var200 = var17.getWaterinfill();
               if (var200 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.WaterInfill(var200));
                  Unit var201 = Unit.INSTANCE;
                  var201 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getSensormode(), var18.getSensormode())) {
               Integer var203 = var17.getSensormode();
               if (var203 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.SensorMode(((Number)var203).intValue()));
                  Unit var204 = Unit.INSTANCE;
                  var204 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getCoolfslevel(), var18.getCoolfslevel())) {
               Integer var206 = var17.getCoolfslevel();
               if (var206 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.CoolFanSpeedLevel(((Number)var206).intValue()));
                  Unit var207 = Unit.INSTANCE;
                  var207 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getCoolauto(), var18.getCoolauto())) {
               Integer var209 = var17.getCoolauto();
               if (var209 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.CoolAutoLevel(((Number)var209).intValue()));
                  Unit var210 = Unit.INSTANCE;
                  var210 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getNightstartts(), var18.getNightstartts())) {
               Long var212 = var17.getNightstartts();
               if (var212 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.NightModeStartTime(((Number)var212).longValue()));
                  Unit var213 = Unit.INSTANCE;
                  var213 = Unit.INSTANCE;
               }
            }

            if (!Intrinsics.areEqual(var17.getRpm(), var18.getRpm())) {
               Integer var215 = var17.getRpm();
               if (var215 != null) {
                  fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.Rpm(((Number)var215).intValue()));
                  Unit var216 = Unit.INSTANCE;
                  var216 = Unit.INSTANCE;
               }
            }

            if (Intrinsics.areEqual(var17.getOscmode(), var18.getOscmode()) && Intrinsics.areEqual(var17.getOscstateh(), var18.getOscstateh()) && Intrinsics.areEqual(var17.getOscfixh(), var18.getOscfixh()) && Intrinsics.areEqual(var17.getOscminh(), var18.getOscminh()) && Intrinsics.areEqual(var17.getOscmaxh(), var18.getOscmaxh()) && Intrinsics.areEqual(var17.getOscstatev(), var18.getOscstatev()) && Intrinsics.areEqual(var17.getOscfixv(), var18.getOscfixv()) && Intrinsics.areEqual(var17.getOscminv(), var18.getOscminv()) && Intrinsics.areEqual(var17.getOscmaxv(), var18.getOscmaxv()) && Intrinsics.areEqual(var17.getCalibrationh(), var18.getCalibrationh()) && Intrinsics.areEqual(var17.getCalibrationv(), var18.getCalibrationv())) {
               return var16;
            } else {
               Integer var52 = var17.getOscmode();
               int var34;
               if (var52 != null) {
                  var34 = var52;
               } else {
                  var34 = 0;
               }

               var52 = var17.getOscstateh();
               int var3;
               if (var52 != null) {
                  var3 = var52;
               } else {
                  var3 = 0;
               }

               var52 = var17.getOscfixh();
               int var4;
               if (var52 != null) {
                  var4 = var52;
               } else {
                  var4 = 0;
               }

               var52 = var17.getOscminh();
               int var5;
               if (var52 != null) {
                  var5 = var52;
               } else {
                  var5 = 0;
               }

               var52 = var17.getOscmaxh();
               int var6;
               if (var52 != null) {
                  var6 = var52;
               } else {
                  var6 = 0;
               }

               var52 = var17.getOscstatev();
               int var7;
               if (var52 != null) {
                  var7 = var52;
               } else {
                  var7 = 0;
               }

               var52 = var17.getOscfixv();
               int var8;
               if (var52 != null) {
                  var8 = var52;
               } else {
                  var8 = 0;
               }

               var52 = var17.getOscminv();
               int var9;
               if (var52 != null) {
                  var9 = var52;
               } else {
                  var9 = 0;
               }

               var52 = var17.getOscmaxv();
               int var10;
               if (var52 != null) {
                  var10 = var52;
               } else {
                  var10 = 0;
               }

               var52 = var17.getCalibrationh();
               int var11;
               if (var52 != null) {
                  var11 = var52;
               } else {
                  var11 = 0;
               }

               Integer var45 = var17.getCalibrationv();
               if (var45 != null) {
                  var12 = var45;
               }

               fromMqtt$addDeviceStreamAttributeEvent(var16, var1, new DeviceStreamAttribute.DualOscillationConfig(new DualOscillationConfig(var34, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12)));
               return var16;
            }
         } else if (var1 instanceof MqttEvent.LogoutEvent) {
            return CollectionsKt.emptyList();
         } else {
            throw new NoWhenBranchMatchedException();
         }
      }

      public final StreamEvent fromStomp(StompEvent var1) {
         Intrinsics.checkNotNullParameter(var1, "stompEvent");
         Object var3 = var1.getContent();
         boolean var2 = var3 instanceof ConnectivityStatus;
         Object var4 = null;
         Pair var9;
         if (var2) {
            StreamEventType var5 = StreamEventType.DEVICE_ATTRIBUTE;
            Object var8 = var1.getContent();
            Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type com.blueair.core.model.ConnectivityStatus");
            var9 = TuplesKt.to(var5, new DeviceStreamAttribute.ConnectivityStatus(((ConnectivityStatus)var8).ordinal()));
         } else if (var3 instanceof IndoorDatapoint) {
            StreamEventType var12 = StreamEventType.DEVICE_ATTRIBUTE;
            Object var10 = var1.getContent();
            Intrinsics.checkNotNull(var10, "null cannot be cast to non-null type com.blueair.core.model.IndoorDatapoint");
            var9 = TuplesKt.to(var12, new DeviceStreamAttribute.LatestSensorDataPoint((IndoorDatapoint)var10));
         } else if (var3 instanceof DeviceStreamAttribute) {
            StreamEventType var11 = StreamEventType.DEVICE_ATTRIBUTE;
            Object var13 = var1.getContent();
            Intrinsics.checkNotNull(var13, "null cannot be cast to non-null type com.blueair.core.model.DeviceStreamAttribute<*>");
            var9 = TuplesKt.to(var11, (DeviceStreamAttribute)var13);
         } else {
            var9 = TuplesKt.to(StreamEventType.UNKNOWN, new DeviceStreamAttribute.Unknown(false, 1, (DefaultConstructorMarker)null));
         }

         StreamEventType var14 = (StreamEventType)var9.getFirst();
         String var6 = var1.getUuid();
         Object var7 = var9.getSecond();
         if (var7 == null) {
            var7 = var4;
         }

         return new StreamEvent(var14, var6, var7);
      }
   }
}
