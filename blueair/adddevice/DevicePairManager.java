package com.blueair.adddevice;

import android.content.Context;
import com.hiflying.smartlink.OnSmartLinkListener;
import com.hiflying.smartlink.SmartLinkedModule;
import com.hiflying.smartlink.v7.MulticastSmartLinker;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"},
   d2 = {"Lcom/blueair/adddevice/DevicePairManager;", "", "<init>", "()V", "LOG_TAG", "", "kotlin.jvm.PlatformType", "BROKEN_LIB_MAC_TEST", "DEFAULT_SMARTLINKER_UUID", "kDeviceServerIP", "kDeviceServerPort", "", "kReadTimeout", "smartLinkerAttempt", "mDeviceInformation", "Lcom/blueair/adddevice/DeviceInformationLegacy;", "performAutomaticPairing", "", "context", "Landroid/content/Context;", "networkSSID", "networkPassPhrase", "autoPairingListener", "Lcom/blueair/adddevice/DevicePairManager$AutoPairingListener;", "performManualPairing", "onLinked", "smartLinkedModule", "Lcom/hiflying/smartlink/SmartLinkedModule;", "AutoPairingListener", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DevicePairManager {
   private static final String BROKEN_LIB_MAC_TEST = ";";
   public static final String DEFAULT_SMARTLINKER_UUID = "LPB100";
   public static final DevicePairManager INSTANCE = new DevicePairManager();
   private static final String LOG_TAG = "DevicePairManager";
   private static final String kDeviceServerIP = "10.10.100.254";
   private static final int kDeviceServerPort = 1337;
   private static final int kReadTimeout = 30000;
   private static DeviceInformationLegacy mDeviceInformation;
   private static int smartLinkerAttempt;

   // $FF: synthetic method
   public static Unit $r8$lambda$t4WcnaoBDSY3plZODIur5vwqEXg(MulticastSmartLinker var0) {
      return performAutomaticPairing$lambda$0(var0);
   }

   private DevicePairManager() {
   }

   private final void onLinked(SmartLinkedModule var1, AutoPairingListener var2) {
      smartLinkerAttempt = 0;
      String var6 = var1.getIp();
      String var3 = var1.getMac();
      String var5 = var1.getId();
      String var4 = "Unknown-ID";
      String var7 = var5;
      if (var5 == null) {
         var7 = "Unknown-ID";
      }

      Intrinsics.checkNotNull(var3);
      CharSequence var15 = (CharSequence)var3;
      if (StringsKt.contains$default(var15, (CharSequence)";", false, 2, (Object)null)) {
         label29: {
            Timber.Forest.w("Compensate for broken SmartLink library.", new Object[0]);
            Intrinsics.checkNotNull(var3);
            List var8 = (new Regex(";")).split(var15, 0);
            if (!var8.isEmpty()) {
               ListIterator var16 = var8.listIterator(var8.size());

               while(var16.hasPrevious()) {
                  if (((CharSequence)((String)var16.previous())).length() != 0) {
                     var9 = CollectionsKt.take((Iterable)var8, var16.nextIndex() + 1);
                     break label29;
                  }
               }
            }

            var9 = CollectionsKt.emptyList();
         }

         String[] var17 = (String[])((Collection)var9).toArray(new String[0]);
         var7 = var3;
         var3 = var4;
         if (var17.length == 2) {
            var7 = var17[0];
            var3 = var17[1];
         }

         var4 = var3;
         var3 = var7;
         var7 = var4;
      }

      var4 = TimeZone.getDefault().getID();
      Timber.Forest.d("SmartLinker linked set up device info", new Object[0]);
      Intrinsics.checkNotNull(var4);
      DeviceInformationLegacy var11 = new DeviceInformationLegacy(var6, var3, var7, "Unknown", "Unknown", "Unknown", var4);
      Timber.Forest.i(var11.toString(), new Object[0]);
      var2.onCompleted(var11);
   }

   private static final Unit performAutomaticPairing$lambda$0(MulticastSmartLinker var0) {
      var0.setOnSmartLinkListener((OnSmartLinkListener)null);
      var0.stop();
      return Unit.INSTANCE;
   }

   public final void performAutomaticPairing(Context var1, String var2, String var3, AutoPairingListener var4) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "networkSSID");
      Intrinsics.checkNotNullParameter(var3, "networkPassPhrase");
      Intrinsics.checkNotNullParameter(var4, "autoPairingListener");
      Timber.Forest.d("performAutomaticPairing()", new Object[0]);
      MulticastSmartLinker var6 = MulticastSmartLinker.getInstance();
      var6.setMixType(1);
      var6.setTimeoutPeriod(30000);
      DevicePairManager$$ExternalSyntheticLambda0 var5 = new DevicePairManager$$ExternalSyntheticLambda0(var6);
      var6.setOnSmartLinkListener(new OnSmartLinkListener(var5, var4) {
         final AutoPairingListener $autoPairingListener;
         final Function0 $stopSmartLink;

         {
            this.$stopSmartLink = var1;
            this.$autoPairingListener = var2;
         }

         public void onCompleted() {
            Timber.Forest.d("SmartLinker completed", new Object[0]);
         }

         public void onLinked(SmartLinkedModule var1) {
            Intrinsics.checkNotNullParameter(var1, "smartLinkedModule");
            Timber.Forest var3 = Timber.Forest;
            StringBuilder var4 = new StringBuilder("SmartLinker linked to: ");
            var4.append(var1.getIp());
            var4.append(", ");
            var4.append(var1);
            var4.append(", current thread = ");
            var4.append(Thread.currentThread());
            var3.d(var4.toString(), new Object[0]);
            int var2 = DevicePairManager.smartLinkerAttempt;
            DevicePairManager var5 = DevicePairManager.INSTANCE;
            DevicePairManager.smartLinkerAttempt = var2 + 1;
            Timber.Forest var7 = Timber.Forest;
            StringBuilder var6 = new StringBuilder("SmartLinker attempts = ");
            var6.append(DevicePairManager.smartLinkerAttempt);
            var7.d(var6.toString(), new Object[0]);
            if (!Intrinsics.areEqual(var1.getId(), "LPB100")) {
               this.$stopSmartLink.invoke();
               DevicePairManager.INSTANCE.onLinked(var1, this.$autoPairingListener);
            } else {
               if (DevicePairManager.smartLinkerAttempt == 2) {
                  this.$stopSmartLink.invoke();
                  DevicePairManager.INSTANCE.onLinked(var1, this.$autoPairingListener);
               }

            }
         }

         public void onTimeOut() {
            Timber.Forest.d("SmartLinker timeout occurred", new Object[0]);
            this.$stopSmartLink.invoke();
            this.$autoPairingListener.onCompleted((DeviceInformationLegacy)null);
         }
      });

      try {
         var6.start(var1, var3, var2);
      } catch (Throwable var8) {
         Timber.Forest.e(var8);
         var5.invoke();
         var4.onCompleted((DeviceInformationLegacy)null);
         return;
      }
   }

   public final DeviceInformationLegacy performManualPairing(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "networkSSID");
      Intrinsics.checkNotNullParameter(var2, "networkPassPhrase");
      Timber.Forest.d("performManualPairing()", new Object[0]);
      mDeviceInformation = null;
      NetworkTCPTextClient var3 = new NetworkTCPTextClient(kDeviceServerIP, kDeviceServerPort, kReadTimeout);
      if (var3.connect()) {
         StringBuilder var4 = new StringBuilder("w;");
         var4.append(var1);
         var4.append(';');
         var4.append(var2);
         var1 = var4.toString();
         Timber.Forest var11 = Timber.Forest;
         var4 = new StringBuilder("Sending the command to the device: \"");
         var4.append(var1);
         var4.append("\".");
         var11.d(var4.toString(), new Object[0]);
         String var12;
         if (!var3.writeMessage(var1)) {
            Timber.Forest.d("Sending of the command failed.", new Object[0]);
         } else {
            do {
               var12 = var3.readMessage();
               if (var12 != null) {
                  CharSequence var5 = (CharSequence)var12;
                  if (StringsKt.contains$default(var5, (CharSequence)";", false, 2, (Object)null)) {
                     label38: {
                        Timber.Forest var7 = Timber.Forest;
                        var4 = new StringBuilder("Received a response from the device: ");
                        var4.append(var12);
                        var7.d(var4.toString(), new Object[0]);
                        List var8 = (new Regex(";")).split(var5, 0);
                        if (!var8.isEmpty()) {
                           ListIterator var15 = var8.listIterator(var8.size());

                           while(var15.hasPrevious()) {
                              if (((CharSequence)((String)var15.previous())).length() != 0) {
                                 var9 = CollectionsKt.take((Iterable)var8, var15.nextIndex() + 1);
                                 break label38;
                              }
                           }
                        }

                        var9 = CollectionsKt.emptyList();
                     }

                     String[] var17 = (String[])((Collection)var9).toArray(new String[0]);
                     if (var17.length == 2) {
                        Timber.Forest.d("Creating device information (this does not mean the configuration was successful).", new Object[0]);
                        var1 = TimeZone.getDefault().getID();
                        String var16 = var17[0];
                        var17 = var17[1];
                        Intrinsics.checkNotNull(var1);
                        mDeviceInformation = new DeviceInformationLegacy((String)null, var16, var17, "Unknown", "Unknown", "Unknown", var1);
                     }
                  }
               }
            } while(var12 != null);
         }

         var3.disconnect();
      }

      return mDeviceInformation;
   }

   @Metadata(
      d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006À\u0006\u0003"},
      d2 = {"Lcom/blueair/adddevice/DevicePairManager$AutoPairingListener;", "", "onCompleted", "", "deviceInformation", "Lcom/blueair/adddevice/DeviceInformationLegacy;", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public interface AutoPairingListener {
      void onCompleted(DeviceInformationLegacy var1);
   }
}
