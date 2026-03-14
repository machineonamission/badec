package com.blueair.bluetooth.service;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.ParcelUuid;
import com.blueair.bluetooth.model.BleScannedDevice;
import com.polidea.rxandroidble2.RxBleClient;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import com.polidea.rxandroidble2.scan.IsConnectable;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanResult;
import com.polidea.rxandroidble2.scan.ScanSettings;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0016J\r\u0010\u0019\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001c\u001a\u00020\u001dR\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u001e\u001a\u00020\u001fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"},
   d2 = {"Lcom/blueair/bluetooth/service/BleScanningService;", "Lkotlinx/coroutines/CoroutineScope;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "scanObservable", "Lio/reactivex/Observable;", "Lcom/polidea/rxandroidble2/scan/ScanResult;", "scanDisposable", "Lio/reactivex/disposables/Disposable;", "devices", "", "Lcom/blueair/bluetooth/model/BleScannedDevice;", "_resultStream", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "resultFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getResultFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "startScanning", "", "reset", "resetResult", "stopScanning", "()Lkotlin/Unit;", "getScannedDevice", "mac", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "bluetooth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BleScanningService implements CoroutineScope {
   private static final String BLE_SERVICE_UUID_DEFAULT = "4772911e-d07c-4617-8241-f4d10948d6ae";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String G4_UUID = "4772911e-d07c-4617-8241-f4d10948d6ae";
   private static final int UNDOCUMENTED_SCAN_THROTTLE_ERROR_CODE = 2147483646;
   private final DefaultCoroutineScope $$delegate_0;
   private final MutableStateFlow _resultStream;
   private final List devices;
   private final StateFlow resultFlow;
   private Disposable scanDisposable;
   private Observable scanObservable;

   // $FF: synthetic method
   public static void $r8$lambda$3vrO2HaYRXIbbxdPEPlxLWd0Cl0(Function1 var0, Object var1) {
      startScanning$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$WbBF4p1Vjxfgc9y0kS4bDaNhDzE(BleScanningService var0, Throwable var1) {
      return startScanning$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$h10WFui_1YAri0fbNx1fKBDv5t0(Function1 var0, Object var1) {
      return _init_$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$kbO2u7hBa_JZVvFG_tdeeEs4BSc/* $FF was: $r8$lambda$kbO2u7hBa-JZVvFG-tdeeEs4BSc*/(Function1 var0, Object var1) {
      startScanning$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$nwCKo1E9RHieYntj3BzTwqCpRCg(BleScanningService var0, ScanResult var1) {
      return startScanning$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$vxPfgurGeiEU82gLbaGmeNodU3Y(Throwable var0) {
      return _init_$lambda$0(var0);
   }

   public BleScanningService(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "appContext");
      super();
      this.$$delegate_0 = new DefaultCoroutineScope();
      this.devices = (List)(new ArrayList());
      MutableStateFlow var2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
      this._resultStream = var2;
      this.resultFlow = (StateFlow)var2;
      if (var1.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
         label16: {
            ScanSettings var8 = (new ScanSettings.Builder()).setScanMode(2).setCallbackType(1).build();
            ScanFilter var3 = (new ScanFilter.Builder()).setServiceUuid(new ParcelUuid(UUID.fromString("4772911e-d07c-4617-8241-f4d10948d6ae"))).build();
            RxBleClient var4 = RxBleClient.create(var1);
            if (var4 != null) {
               Observable var5 = var4.scanBleDevices(var8, new ScanFilter[]{var3});
               if (var5 != null) {
                  var5 = var5.subscribeOn(Schedulers.io());
                  if (var5 != null) {
                     var7 = var5.retry(new BleScanningService$$ExternalSyntheticLambda1(new BleScanningService$$ExternalSyntheticLambda0()));
                     break label16;
                  }
               }
            }

            var7 = null;
         }

         this.scanObservable = var7;
      }

   }

   private static final boolean _init_$lambda$0(Throwable var0) {
      Intrinsics.checkNotNullParameter(var0, "t");
      Timber.Forest.d(var0, "rx ble retry", new Object[0]);
      return var0 instanceof BleScanException && ((BleScanException)var0).getReason() != 2147483646;
   }

   private static final boolean _init_$lambda$1(Function1 var0, Object var1) {
      Intrinsics.checkNotNullParameter(var1, "p0");
      return (Boolean)var0.invoke(var1);
   }

   private static final Unit startScanning$lambda$3(BleScanningService var0, ScanResult var1) {
      BluetoothDevice var5 = var1.getBleDevice().getBluetoothDevice();
      Intrinsics.checkNotNullExpressionValue(var5, "getBluetoothDevice(...)");
      IsConnectable var6 = var1.isConnectable();
      IsConnectable var7 = IsConnectable.CONNECTABLE;
      boolean var3 = true;
      boolean var4;
      if (var6 == var7) {
         var4 = true;
      } else {
         var4 = false;
      }

      BleScannedDevice var10 = new BleScannedDevice(var5, "4772911e-d07c-4617-8241-f4d10948d6ae", var4);
      Timber.Forest var11 = Timber.Forest;
      StringBuilder var12 = new StringBuilder("rx ble device found ");
      var12.append(var1.getBleDevice().getName());
      var12.append('-');
      var12.append(var10.getConnectable());
      var11.d(var12.toString(), new Object[0]);
      Iterator var8 = var0.devices.iterator();
      int var2 = 0;

      while(true) {
         if (!var8.hasNext()) {
            var2 = -1;
            break;
         }

         if (Intrinsics.areEqual(((BleScannedDevice)var8.next()).getDevice().getAddress(), var10.getDevice().getAddress())) {
            break;
         }

         ++var2;
      }

      if (var2 >= 0) {
         if (((BleScannedDevice)var0.devices.get(var2)).getConnectable() != var10.getConnectable()) {
            var0.devices.set(var2, var10);
            var2 = var3;
         } else {
            var2 = 0;
         }
      } else {
         var0.devices.add(var10);
         var2 = var3;
      }

      if (!((Collection)var0.devices).isEmpty() && var2) {
         var0._resultStream.tryEmit(CollectionsKt.toList((Iterable)var0.devices));
      }

      return Unit.INSTANCE;
   }

   private static final void startScanning$lambda$4(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final Unit startScanning$lambda$5(BleScanningService var0, Throwable var1) {
      Timber.Forest.e(var1, "rx ble scan error", new Object[0]);
      var0._resultStream.tryEmit(CollectionsKt.emptyList());
      return Unit.INSTANCE;
   }

   private static final void startScanning$lambda$6(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   public CoroutineContext getCoroutineContext() {
      return this.$$delegate_0.getCoroutineContext();
   }

   public final StateFlow getResultFlow() {
      return this.resultFlow;
   }

   public final BleScannedDevice getScannedDevice(String var1) {
      Intrinsics.checkNotNullParameter(var1, "mac");
      Iterator var3 = ((Iterable)this.devices).iterator();

      while(true) {
         if (var3.hasNext()) {
            Object var2 = var3.next();
            if (!Intrinsics.areEqual(((BleScannedDevice)var2).getDevice().getAddress(), var1)) {
               continue;
            }

            var4 = var2;
            break;
         }

         var4 = null;
         break;
      }

      return (BleScannedDevice)var4;
   }

   public final void reset() {
      this.stopScanning();
      this.resetResult();
   }

   public final void resetResult() {
      this.devices.clear();
      this._resultStream.tryEmit(CollectionsKt.emptyList());
   }

   public final void startScanning() {
      Observable var1 = this.scanObservable;
      Disposable var2;
      if (var1 != null) {
         var2 = var1.subscribe(new BleScanningService$$ExternalSyntheticLambda3(new BleScanningService$$ExternalSyntheticLambda2(this)), new BleScanningService$$ExternalSyntheticLambda5(new BleScanningService$$ExternalSyntheticLambda4(this)));
      } else {
         var2 = null;
      }

      this.scanDisposable = var2;
   }

   public final Unit stopScanning() {
      Disposable var1 = this.scanDisposable;
      if (var1 != null) {
         var1.dispose();
         return Unit.INSTANCE;
      } else {
         return null;
      }
   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"},
      d2 = {"Lcom/blueair/bluetooth/service/BleScanningService$Companion;", "", "<init>", "()V", "G4_UUID", "", "BLE_SERVICE_UUID_DEFAULT", "UNDOCUMENTED_SCAN_THROTTLE_ERROR_CODE", "", "bluetooth_otherRelease"},
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
   }
}
