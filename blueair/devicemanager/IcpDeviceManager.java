package com.blueair.devicemanager;

import com.airboxlab.icp.sdk.BlueAirManager;
import com.airboxlab.icp.sdk.DeviceConnectionState;
import com.airboxlab.icp.sdk.DeviceSpec;
import com.airboxlab.icp.sdk.IcpDeviceInformation;
import com.airboxlab.icp.sdk.ScanListener;
import com.polidea.rxandroidble2.RxBleClient;
import com.polidea.rxandroidble2.RxBleClient.State;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleSource;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002#$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rJ(\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0011H\u0002J\u001a\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u000b\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00168F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0019R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00168F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0019¨\u0006%"},
   d2 = {"Lcom/blueair/devicemanager/IcpDeviceManager;", "", "blueairManager", "Lcom/airboxlab/icp/sdk/BlueAirManager;", "<init>", "(Lcom/airboxlab/icp/sdk/BlueAirManager;)V", "currentConnectionStates", "Ljava/util/HashMap;", "", "Lcom/blueair/devicemanager/IcpDeviceManager$IcpDeviceConnectionState;", "Lkotlin/collections/HashMap;", "macAddressToUuid", "pair", "Lio/reactivex/Single;", "Lcom/blueair/devicemanager/IcpDevice;", "scan", "", "Lcom/airboxlab/icp/sdk/IcpDevice;", "timeoutSeconds", "", "maxDevices", "deviceInfoObservable", "Lio/reactivex/Observable;", "Lcom/blueair/devicemanager/IcpDeviceInfo;", "getDeviceInfoObservable", "()Lio/reactivex/Observable;", "asIcpDevice", "d", "uuid", "bleClientStateObservable", "Lcom/blueair/devicemanager/IcpDeviceManager$BluetoothClientState;", "getBleClientStateObservable", "connectionStateObservable", "Lcom/blueair/devicemanager/IcpDeviceConnection;", "getConnectionStateObservable", "IcpDeviceConnectionState", "BluetoothClientState", "devicemanager_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class IcpDeviceManager {
   private final BlueAirManager blueairManager;
   private HashMap currentConnectionStates;
   private HashMap macAddressToUuid;

   // $FF: synthetic method
   public static Unit $r8$lambda$0Ba_8gCyO8islEYsnQsnhLJddp4/* $FF was: $r8$lambda$0Ba-8gCyO8islEYsnQsnhLJddp4*/(com.airboxlab.icp.sdk.IcpDevice var0, Throwable var1) {
      return pair$lambda$1$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static SingleSource $r8$lambda$4OKa4C7Mx2Vyu_pvAQ8zFvwoC7I(IcpDeviceManager var0, com.airboxlab.icp.sdk.IcpDevice[] var1) {
      return pair$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static IcpDeviceInfo $r8$lambda$5dAAWqo40wYaYL5DWE0dPsfhZmw(Function1 var0, Object var1) {
      return _get_deviceInfoObservable_$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static IcpDeviceInfo $r8$lambda$7GL5WB6H3nk53vFVGE_eys3BbjM(IcpDeviceManager var0, Pair var1) {
      return _get_deviceInfoObservable_$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$NKrLQzAhSG7d0F3V5riGgy8OaxM(IcpDeviceManager var0, long var1, long var3, SingleEmitter var5) {
      scan$lambda$3(var0, var1, var3, var5);
   }

   // $FF: synthetic method
   public static BluetoothClientState $r8$lambda$aSGcxHipL1JUuw49l3BQ0yeNqGs(Function1 var0, Object var1) {
      return _get_bleClientStateObservable_$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static IcpDeviceConnection $r8$lambda$h5PB30TC_WMhQD_wcfiCRJKb98k/* $FF was: $r8$lambda$h5PB30TC-WMhQD_wcfiCRJKb98k*/(Function1 var0, Object var1) {
      return _get_connectionStateObservable_$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static SingleSource $r8$lambda$ol4ORKwZvMnKMHiKl7Ww_OCmxTs(Function1 var0, Object var1) {
      return pair$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static BluetoothClientState $r8$lambda$s_eknXQQED2szDsLvv11hJq3ps0/* $FF was: $r8$lambda$s-eknXQQED2szDsLvv11hJq3ps0*/(RxBleClient.State var0) {
      return _get_bleClientStateObservable_$lambda$6(var0);
   }

   // $FF: synthetic method
   public static IcpDeviceConnection $r8$lambda$xgkZagw1x2sceiYw5_MTA7KBczo(IcpDeviceManager var0, Pair var1) {
      return _get_connectionStateObservable_$lambda$8(var0, var1);
   }

   public IcpDeviceManager(BlueAirManager var1) {
      Intrinsics.checkNotNullParameter(var1, "blueairManager");
      super();
      this.blueairManager = var1;
      this.currentConnectionStates = new HashMap();
      this.macAddressToUuid = new HashMap();
   }

   private static final BluetoothClientState _get_bleClientStateObservable_$lambda$6(RxBleClient.State var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      int var1 = IcpDeviceManager.WhenMappings.$EnumSwitchMapping$0[var0.ordinal()];
      if (var1 != 1) {
         if (var1 != 2) {
            if (var1 != 3) {
               if (var1 != 4) {
                  if (var1 == 5) {
                     return IcpDeviceManager.BluetoothClientState.READY;
                  } else {
                     throw new NoWhenBranchMatchedException();
                  }
               } else {
                  return IcpDeviceManager.BluetoothClientState.LOCATION_SERVICES_NOT_ENABLED;
               }
            } else {
               return IcpDeviceManager.BluetoothClientState.LOCATION_PERMISSION_NOT_GRANTED;
            }
         } else {
            return IcpDeviceManager.BluetoothClientState.BLUETOOTH_NOT_AVAILABLE;
         }
      } else {
         return IcpDeviceManager.BluetoothClientState.BLUETOOTH_NOT_ENABLED;
      }
   }

   private static final BluetoothClientState _get_bleClientStateObservable_$lambda$7(Function1 var0, Object var1) {
      Intrinsics.checkNotNullParameter(var1, "p0");
      return (BluetoothClientState)var0.invoke(var1);
   }

   private static final IcpDeviceConnection _get_connectionStateObservable_$lambda$8(IcpDeviceManager var0, Pair var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      DeviceConnectionState var3 = (DeviceConnectionState)var1.getSecond();
      int var2 = IcpDeviceManager.WhenMappings.$EnumSwitchMapping$1[var3.ordinal()];
      IcpDeviceConnectionState var8;
      if (var2 != 1) {
         if (var2 != 2) {
            if (var2 != 3) {
               if (var2 != 4) {
                  if (var2 != 5) {
                     throw new NoWhenBranchMatchedException();
                  }

                  var8 = IcpDeviceManager.IcpDeviceConnectionState.UNKNOWN;
               } else {
                  var8 = IcpDeviceManager.IcpDeviceConnectionState.DISCONNECTED;
               }
            } else {
               var8 = IcpDeviceManager.IcpDeviceConnectionState.DISCONNECTING;
            }
         } else {
            var8 = IcpDeviceManager.IcpDeviceConnectionState.CONNECTED;
         }
      } else {
         var8 = IcpDeviceManager.IcpDeviceConnectionState.CONNECTING;
      }

      Timber.Forest var4 = Timber.Forest;
      StringBuilder var5 = new StringBuilder("Connection state changed ");
      var5.append(var1.getSecond());
      var5.append(" for ");
      var5.append(((com.airboxlab.icp.sdk.IcpDevice)var1.getFirst()).getUuid());
      var5.append(", ");
      var5.append(((com.airboxlab.icp.sdk.IcpDevice)var1.getFirst()).getMacAddress());
      var4.i(var5.toString(), new Object[0]);
      String var10;
      if (((com.airboxlab.icp.sdk.IcpDevice)var1.getFirst()).getCache().getDeviceInformation() != null) {
         IcpDeviceInformation var9 = ((com.airboxlab.icp.sdk.IcpDevice)var1.getFirst()).getCache().getDeviceInformation();
         if (var9 != null) {
            var10 = var9.getSerialNumber();
         } else {
            var10 = null;
         }
      } else if (((com.airboxlab.icp.sdk.IcpDevice)var1.getFirst()).getUuid() != null) {
         var10 = (String)var0.macAddressToUuid.get(((com.airboxlab.icp.sdk.IcpDevice)var1.getFirst()).getUuid());
      } else {
         var10 = (String)var0.macAddressToUuid.get(((com.airboxlab.icp.sdk.IcpDevice)var1.getFirst()).getMacAddress());
      }

      if (var10 != null) {
         ((Map)var0.currentConnectionStates).put(var10, var8);
      }

      IcpDevice var11 = var0.asIcpDevice((com.airboxlab.icp.sdk.IcpDevice)var1.getFirst(), var10);
      Timber.Forest var7 = Timber.Forest;
      StringBuilder var6 = new StringBuilder("Update connection state for ");
      var6.append(var8);
      var6.append(", ");
      var6.append(var11.getUuid());
      var6.append(", ");
      var6.append(var11.getMacAddress());
      var7.d(var6.toString(), new Object[0]);
      return new IcpDeviceConnection(var8, var11);
   }

   private static final IcpDeviceConnection _get_connectionStateObservable_$lambda$9(Function1 var0, Object var1) {
      Intrinsics.checkNotNullParameter(var1, "p0");
      return (IcpDeviceConnection)var0.invoke(var1);
   }

   private static final IcpDeviceInfo _get_deviceInfoObservable_$lambda$4(IcpDeviceManager var0, Pair var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      return new IcpDeviceInfo(var0.asIcpDevice((com.airboxlab.icp.sdk.IcpDevice)var1.getFirst()), ((IcpDeviceInformation)var1.getSecond()).getFirmwareChildMain(), ((IcpDeviceInformation)var1.getSecond()).getFirmwareChildPlug(), ((IcpDeviceInformation)var1.getSecond()).getFirmwareRevision(), ((IcpDeviceInformation)var1.getSecond()).getHardwareRevision(), ((IcpDeviceInformation)var1.getSecond()).getMacAddress(), ((IcpDeviceInformation)var1.getSecond()).getManufacturerName(), ((IcpDeviceInformation)var1.getSecond()).getSerialNumber());
   }

   private static final IcpDeviceInfo _get_deviceInfoObservable_$lambda$5(Function1 var0, Object var1) {
      Intrinsics.checkNotNullParameter(var1, "p0");
      return (IcpDeviceInfo)var0.invoke(var1);
   }

   private final IcpDevice asIcpDevice(com.airboxlab.icp.sdk.IcpDevice var1) {
      return new IcpDevice(var1.getMacAddress(), var1.getName(), var1.getUuid());
   }

   private final IcpDevice asIcpDevice(com.airboxlab.icp.sdk.IcpDevice var1, String var2) {
      return new IcpDevice(var1.getMacAddress(), var1.getName(), var2);
   }

   private static final SingleSource pair$lambda$1(IcpDeviceManager var0, com.airboxlab.icp.sdk.IcpDevice[] var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      boolean var2;
      if (((Object[])var1).length == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      Single var4;
      if (!var2) {
         var1 = ((Object[])var1)[0];
         IcpDevice var3 = new IcpDevice(var1.getMacAddress(), var1.getName(), var1.getUuid());
         BlueAirManager.connect$default(var0.blueairManager, var1, false, new IcpDeviceManager$$ExternalSyntheticLambda3(), 2, (Object)null);
         var4 = Single.just(var3);
         Intrinsics.checkNotNull(var4);
      } else {
         Timber.Forest.d("No device found.", new Object[0]);
         var4 = Single.just((Object)null);
         Intrinsics.checkNotNull(var4);
      }

      return (SingleSource)var4;
   }

   private static final Unit pair$lambda$1$lambda$0(com.airboxlab.icp.sdk.IcpDevice var0, Throwable var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("ICPOnConnecting ");
      var2.append(var0);
      var2.append(", ");
      var2.append(var1);
      var3.i(var2.toString(), new Object[0]);
      return Unit.INSTANCE;
   }

   private static final SingleSource pair$lambda$2(Function1 var0, Object var1) {
      Intrinsics.checkNotNullParameter(var1, "p0");
      return (SingleSource)var0.invoke(var1);
   }

   private final Single scan(long var1, long var3) {
      Single var5 = Single.create(new IcpDeviceManager$$ExternalSyntheticLambda0(this, var1, var3));
      Intrinsics.checkNotNullExpressionValue(var5, "create(...)");
      return var5;
   }

   // $FF: synthetic method
   static Single scan$default(IcpDeviceManager var0, long var1, long var3, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = 30L;
      }

      if ((var5 & 2) != 0) {
         var3 = Long.MAX_VALUE;
      }

      return var0.scan(var1, var3);
   }

   private static final void scan$lambda$3(IcpDeviceManager var0, long var1, long var3, SingleEmitter var5) {
      Intrinsics.checkNotNullParameter(var5, "it");
      var0.blueairManager.scan((DeviceSpec)(new DeviceSpec.IcpDeviceSpec()), var1, var3, new ScanListener(var5) {
         final SingleEmitter $it;

         {
            this.$it = var1;
         }

         public void onError(Throwable var1) {
            Intrinsics.checkNotNullParameter(var1, "throwable");
            this.$it.onError(var1);
         }

         public void onScanEnded(com.airboxlab.icp.sdk.IcpDevice[] var1) {
            Intrinsics.checkNotNullParameter(var1, "devices");
            Timber.Forest var2 = Timber.Forest;
            StringBuilder var3 = new StringBuilder("scan completed, found devices: ");
            var3.append(var1.length);
            var2.i(var3.toString(), new Object[0]);
            this.$it.onSuccess(var1);
         }
      });
   }

   public final Observable getBleClientStateObservable() {
      Observable var1 = this.blueairManager.managerStateObservable().map(new IcpDeviceManager$$ExternalSyntheticLambda2(new IcpDeviceManager$$ExternalSyntheticLambda1()));
      Intrinsics.checkNotNullExpressionValue(var1, "map(...)");
      return var1;
   }

   public final Observable getConnectionStateObservable() {
      Observable var1 = this.blueairManager.connectionStateObservable().map(new IcpDeviceManager$$ExternalSyntheticLambda7(new IcpDeviceManager$$ExternalSyntheticLambda6(this)));
      Intrinsics.checkNotNullExpressionValue(var1, "map(...)");
      return var1;
   }

   public final Observable getDeviceInfoObservable() {
      Observable var1 = this.blueairManager.deviceInfoObservable().map(new IcpDeviceManager$$ExternalSyntheticLambda9(new IcpDeviceManager$$ExternalSyntheticLambda8(this)));
      Intrinsics.checkNotNullExpressionValue(var1, "map(...)");
      return var1;
   }

   public final Single pair() {
      Single var1 = this.scan(30L, 1L).flatMap(new IcpDeviceManager$$ExternalSyntheticLambda5(new IcpDeviceManager$$ExternalSyntheticLambda4(this)));
      Intrinsics.checkNotNullExpressionValue(var1, "flatMap(...)");
      return var1;
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"},
      d2 = {"Lcom/blueair/devicemanager/IcpDeviceManager$BluetoothClientState;", "", "<init>", "(Ljava/lang/String;I)V", "BLUETOOTH_NOT_AVAILABLE", "LOCATION_PERMISSION_NOT_GRANTED", "BLUETOOTH_NOT_ENABLED", "LOCATION_SERVICES_NOT_ENABLED", "READY", "devicemanager_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static enum BluetoothClientState {
      private static final EnumEntries $ENTRIES;
      private static final BluetoothClientState[] $VALUES;
      BLUETOOTH_NOT_AVAILABLE,
      BLUETOOTH_NOT_ENABLED,
      LOCATION_PERMISSION_NOT_GRANTED,
      LOCATION_SERVICES_NOT_ENABLED,
      READY;

      // $FF: synthetic method
      private static final BluetoothClientState[] $values() {
         return new BluetoothClientState[]{BLUETOOTH_NOT_AVAILABLE, LOCATION_PERMISSION_NOT_GRANTED, BLUETOOTH_NOT_ENABLED, LOCATION_SERVICES_NOT_ENABLED, READY};
      }

      static {
         BluetoothClientState[] var0 = $values();
         $VALUES = var0;
         $ENTRIES = EnumEntriesKt.enumEntries(var0);
      }

      public static EnumEntries getEntries() {
         return $ENTRIES;
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"},
      d2 = {"Lcom/blueair/devicemanager/IcpDeviceManager$IcpDeviceConnectionState;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTING", "CONNECTED", "DISCONNECTING", "DISCONNECTED", "UNKNOWN", "devicemanager_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static enum IcpDeviceConnectionState {
      private static final EnumEntries $ENTRIES;
      private static final IcpDeviceConnectionState[] $VALUES;
      CONNECTED,
      CONNECTING,
      DISCONNECTED,
      DISCONNECTING,
      UNKNOWN;

      // $FF: synthetic method
      private static final IcpDeviceConnectionState[] $values() {
         return new IcpDeviceConnectionState[]{CONNECTING, CONNECTED, DISCONNECTING, DISCONNECTED, UNKNOWN};
      }

      static {
         IcpDeviceConnectionState[] var0 = $values();
         $VALUES = var0;
         $ENTRIES = EnumEntriesKt.enumEntries(var0);
      }

      public static EnumEntries getEntries() {
         return $ENTRIES;
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;
      public static final int[] $EnumSwitchMapping$1;

      static {
         int[] var0 = new int[State.values().length];

         try {
            var0[State.BLUETOOTH_NOT_ENABLED.ordinal()] = 1;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[State.BLUETOOTH_NOT_AVAILABLE.ordinal()] = 2;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[State.LOCATION_PERMISSION_NOT_GRANTED.ordinal()] = 3;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[State.LOCATION_SERVICES_NOT_ENABLED.ordinal()] = 4;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[State.READY.ordinal()] = 5;
         } catch (NoSuchFieldError var7) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[DeviceConnectionState.values().length];

         try {
            var0[DeviceConnectionState.CONNECTING.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[DeviceConnectionState.CONNECTED.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[DeviceConnectionState.DISCONNECTING.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[DeviceConnectionState.DISCONNECTED.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DeviceConnectionState.UNKNOWN.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$1 = var0;
      }
   }
}
