package com.blueair.adddevice.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blueair.adddevice.DeviceUtilsLegacy;
import com.blueair.adddevice.model.AddDeviceState;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.bluetooth.utils.BluetoothUtils;
import com.blueair.core.util.LocationPermissionTracker;
import com.blueair.core.util.LocationUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.DialogUtils;
import io.flatcircle.connectivityhelper.NetUtil;
import io.reactivex.Single;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002%&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0012J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ*\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050$0#R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006'"},
   d2 = {"Lcom/blueair/adddevice/utils/AddDeviceUtils;", "", "<init>", "()V", "LOG_TAG", "", "getLOG_TAG", "()Ljava/lang/String;", "LOG_TAG$delegate", "Lkotlin/Lazy;", "screenDoesNotAllowBack", "", "screen", "Lcom/blueair/adddevice/utils/AddDeviceUtils$AddDeviceScreen;", "screenAllowsBack", "screenHasNoToolbar", "shouldChangeScreen", "oldState", "Lcom/blueair/adddevice/model/AddDeviceState;", "nuState", "getScreen", "state", "validateNet", "Lio/reactivex/Single;", "Lcom/blueair/adddevice/utils/AddDeviceUtils$NetValidation;", "context", "Landroid/content/Context;", "deviceModelType", "", "showEnableLocationBluetooth", "fragment", "Landroidx/fragment/app/Fragment;", "locationPermissionTracker", "Lcom/blueair/core/util/LocationPermissionTracker;", "resultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "AddDeviceScreen", "NetValidation", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceUtils {
   public static final AddDeviceUtils INSTANCE = new AddDeviceUtils();
   private static final Lazy LOG_TAG$delegate = LazyKt.lazy(new AddDeviceUtils$$ExternalSyntheticLambda2());

   // $FF: synthetic method
   public static Unit $r8$lambda$9iYcjbtk0lyB7bhGs2zrXpnCE0c(Ref.ObjectRef var0, boolean var1) {
      return showEnableLocationBluetooth$lambda$9$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$SzsVPnxwmennL0KT1KCtX_Ijn0g(Context var0) {
      return showEnableLocationBluetooth$lambda$3(var0);
   }

   // $FF: synthetic method
   public static NetValidation $r8$lambda$_ya3OBEgEHFgwW0Msm8rUOMqTWo(Context var0, int var1) {
      return validateNet$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$f6Fj6q_r4VyOFZMQI6yKpGqpvtg(LocationPermissionTracker var0, Fragment var1) {
      return showEnableLocationBluetooth$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static String $r8$lambda$fUhy7FSqz3cyqaqSTwNcT2K_emw/* $FF was: $r8$lambda$fUhy7FSqz3cyqaqSTwNcT2K-emw*/() {
      return LOG_TAG_delegate$lambda$0();
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$jryFtYCGwoZ3UmwI2Gi_V6mnICw/* $FF was: $r8$lambda$jryFtYCGwoZ3UmwI2Gi-V6mnICw*/(ActivityResultLauncher var0) {
      return showEnableLocationBluetooth$lambda$2(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$kL2plDhkq9NuQKFuOH6ok7Hx__E(Context var0) {
      return showEnableLocationBluetooth$lambda$7(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$uaKmM0KQ1b7aOO5e_k7vixWkIAM/* $FF was: $r8$lambda$uaKmM0KQ1b7aOO5e-k7vixWkIAM*/() {
      return showEnableLocationBluetooth$lambda$5$lambda$4();
   }

   private AddDeviceUtils() {
   }

   private static final String LOG_TAG_delegate$lambda$0() {
      return "AddDeviceUtils";
   }

   private final String getLOG_TAG() {
      Object var1 = LOG_TAG$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (String)var1;
   }

   private static final Unit showEnableLocationBluetooth$lambda$2(ActivityResultLauncher var0) {
      DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_bluetooth, R.string.permission_request_message_bluetooth);
      var0.launch(new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE"});
      return Unit.INSTANCE;
   }

   private static final Unit showEnableLocationBluetooth$lambda$3(Context var0) {
      Object var1 = var0.getSystemService("bluetooth");
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
      BluetoothAdapter var2 = ((BluetoothManager)var1).getAdapter();
      if (VERSION.SDK_INT >= 33) {
         var0.startActivity(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));
      } else {
         var2.enable();
      }

      return Unit.INSTANCE;
   }

   private static final Unit showEnableLocationBluetooth$lambda$5(LocationPermissionTracker var0, Fragment var1) {
      var0.requestLocationPermission(var1, new AddDeviceUtils$$ExternalSyntheticLambda0());
      return Unit.INSTANCE;
   }

   private static final Unit showEnableLocationBluetooth$lambda$5$lambda$4() {
      DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_location_bluetooth, R.string.permission_request_message_location_bluetooth);
      return Unit.INSTANCE;
   }

   private static final Unit showEnableLocationBluetooth$lambda$7(Context var0) {
      Intent var1 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
      var1.setFlags(268435456);
      var0.startActivity(var1);
      return Unit.INSTANCE;
   }

   private static final Unit showEnableLocationBluetooth$lambda$9$lambda$8(Ref.ObjectRef var0, boolean var1) {
      if (var1) {
         Function0 var2 = (Function0)var0.element;
         if (var2 != null) {
            var2.invoke();
         }
      }

      return Unit.INSTANCE;
   }

   private static final NetValidation validateNet$lambda$1(Context var0, int var1) {
      String var4 = NetUtil.INSTANCE.getActiveWifiSSID(var0);
      String var3 = DeviceUtilsLegacy.INSTANCE.getManualModeWiFiSSID(var1);
      boolean var2 = NetUtil.INSTANCE.isProbablyOnline(var0);
      Timber.Forest var5 = Timber.Forest;
      StringBuilder var6 = new StringBuilder("validateNet: isNetworkConnected = ");
      var6.append(var2);
      var6.append(", connectedWifiSSID = ");
      var6.append(var4);
      var6.append(", notAllowedWiFISSID = ");
      var6.append(var3);
      var6.append(", deviceModelType = ");
      var6.append(var1);
      var5.d(var6.toString(), new Object[0]);
      return new NetValidation(var4, var3, var2);
   }

   public final AddDeviceScreen getScreen(AddDeviceState var1) {
      Intrinsics.checkNotNullParameter(var1, "state");
      if (var1.getTroubleshoot()) {
         return AddDeviceUtils.AddDeviceScreen.TROUBLESHOOT;
      } else if (var1.getDeviceType() == 40) {
         if (!var1.getAutoFailed()) {
            if (var1.isSuccess() && var1.getSuccessScreen()) {
               return AddDeviceUtils.AddDeviceScreen.SUCCESS;
            }

            if (var1.getIcpStepsCompleted() == 0) {
               return AddDeviceUtils.AddDeviceScreen.ICP_SETUP_DEVICE;
            }

            if (var1.getIcpStepsCompleted() == 1) {
               return AddDeviceUtils.AddDeviceScreen.ICP_PAIR_DEVICE;
            }

            if (var1.getIcpStepsCompleted() == 2 && !var1.isReadyForNaming()) {
               return AddDeviceUtils.AddDeviceScreen.ICP_SAVE_DEVICE;
            }

            if (var1.getIcpStepsCompleted() == 2 && var1.isReadyForNaming()) {
               return AddDeviceUtils.AddDeviceScreen.ICP_NAME_DEVICE;
            }
         }

         return AddDeviceUtils.AddDeviceScreen.ICP_ADD_DEVICE;
      } else if (var1.getDeviceType() == 0) {
         Timber.Forest.d("getScreen() -> AddDeviceScreen.SELECT_DEVICE", new Object[0]);
         return AddDeviceUtils.AddDeviceScreen.SELECT_DEVICE;
      } else if (!var1.getInitialTextSeen()) {
         Timber.Forest.d("getScreen() -> AddDeviceScreen.SETUP_TEXT", new Object[0]);
         return AddDeviceUtils.AddDeviceScreen.SETUP_TEXT;
      } else if (var1.getResetDevice()) {
         Timber.Forest.d("getScreen() -> AddDeviceScreen.RESET_DEVICE", new Object[0]);
         return AddDeviceUtils.AddDeviceScreen.RESET_DEVICE;
      } else if (var1.getDeviceType() != 0 && var1.getDeviceType() != 3 && var1.getAutoMode() && var1.getAutoStepsCompleted() == 0) {
         Timber.Forest.d("getScreen() -> AddDeviceScreen.AUTO_STEP_1", new Object[0]);
         return AddDeviceUtils.AddDeviceScreen.AUTO_STEP_1;
      } else if (!var1.getAutoMode() || (var1.getAutoStepsCompleted() != 1 || var1.getDeviceType() == 3) && (var1.getAutoStepsCompleted() != 0 || var1.getDeviceType() != 3)) {
         if (var1.getDeviceInfo() != null || var1.getAutoFailed() || var1.getNetworkInfoSet() || var1.getAutoStepsCompleted() != 2 && (var1.getAutoStepsCompleted() != 1 || var1.getDeviceType() != 3)) {
            if (var1.getNetworkInfoSet() && (var1.getDeviceInfo() == null || !var1.getOtaCheckCompleted() && !var1.getAutoFailed()) && var1.getCurrentConfigMode() == 0 && !var1.getAutoFailed()) {
               Timber.Forest.d("getScreen() -> AddDeviceScreen.AUTO_PROGRESS", new Object[0]);
               return AddDeviceUtils.AddDeviceScreen.AUTO_PROGRESS;
            } else if (var1.getDeviceInfo() == null && var1.getCurrentConfigMode() == 1 && var1.getManualStepsCompleted() == 0) {
               Timber.Forest.d("getScreen() -> AddDeviceScreen.MANUAL_STEP_1", new Object[0]);
               return AddDeviceUtils.AddDeviceScreen.MANUAL_STEP_1;
            } else if (var1.getManualStepsCompleted() == 1 && !var1.getManualFailed()) {
               Timber.Forest.d("getScreen() -> AddDeviceScreen.MANUAL_STEP_2", new Object[0]);
               return AddDeviceUtils.AddDeviceScreen.MANUAL_STEP_2;
            } else if (var1.getManualStepsCompleted() == 2 && var1.getDeviceInfo() == null && !var1.getNetworkInfoSet()) {
               Timber.Forest.d("getScreen() -> AddDeviceScreen.CONFIG_NETWORK", new Object[0]);
               return AddDeviceUtils.AddDeviceScreen.CONFIG_NETWORK;
            } else if (var1.getNetworkInfoSet() && var1.getCurrentConfigMode() == 1 && (var1.getDeviceInfo() == null && !var1.getManualValidated() || var1.getDeviceInfo() != null && var1.getManualValidated()) && !var1.isReadyForNaming() && !var1.getManualFailed()) {
               Timber.Forest.d("getScreen() -> AddDeviceScreen.MANUAL_PROGRESS", new Object[0]);
               return AddDeviceUtils.AddDeviceScreen.MANUAL_PROGRESS;
            } else if (var1.getNetworkInfoSet() && var1.getCurrentConfigMode() == 1 && var1.getDeviceInfo() != null && !var1.getManualValidated() && !var1.getManualFailed()) {
               Timber.Forest.d("getScreen() -> AddDeviceScreen.MANUAL_VALIDATE", new Object[0]);
               return AddDeviceUtils.AddDeviceScreen.MANUAL_VALIDATE;
            } else if (var1.getCurrentConfigMode() == 0 && var1.getDeviceInfo() != null && var1.isReadyForNaming() && var1.getDeviceName() == null) {
               Timber.Forest.d("getScreen() -> AddDeviceScreen.NAME_DEVICE", new Object[0]);
               return AddDeviceUtils.AddDeviceScreen.NAME_DEVICE;
            } else if (var1.getCurrentConfigMode() == 1 && var1.getDeviceInfo() != null && var1.getManualValidated() && var1.isReadyForNaming() && var1.getDeviceName() == null) {
               Timber.Forest.d("getScreen() -> AddDeviceScreen.NAME_DEVICE", new Object[0]);
               return AddDeviceUtils.AddDeviceScreen.NAME_DEVICE;
            } else if (var1.getCurrentConfigMode() == 0 && var1.getAutoFailed() && var1.getAutoFailStepsCompleted() < 1) {
               Timber.Forest.d("getScreen() -> AddDeviceScreen.AUTO_FAIL_STEP_1", new Object[0]);
               return AddDeviceUtils.AddDeviceScreen.AUTO_FAIL_STEP_1;
            } else if (var1.getCurrentConfigMode() == 0 && var1.getAutoFailed() && var1.getAutoFailStepsCompleted() > 0) {
               Timber.Forest.d("getScreen() -> AddDeviceScreen.AUTO_FAIL_STEP_2", new Object[0]);
               return AddDeviceUtils.AddDeviceScreen.AUTO_FAIL_STEP_2;
            } else if (var1.getCurrentConfigMode() == 1 && var1.getManualFailed()) {
               Timber.Forest.d("getScreen() -> AddDeviceScreen.MANUAL_FAIL", new Object[0]);
               return AddDeviceUtils.AddDeviceScreen.MANUAL_FAIL;
            } else if (var1.isReadyForMigrationOta()) {
               Timber.Forest.d("getScreen() -> AddDeviceScreen.MIGRATION_OTA", new Object[0]);
               return AddDeviceUtils.AddDeviceScreen.MIGRATION_OTA;
            } else if (var1.isSuccess() && var1.getSuccessScreen()) {
               Timber.Forest.d("getScreen() -> AddDeviceScreen.SUCCESS", new Object[0]);
               return AddDeviceUtils.AddDeviceScreen.SUCCESS;
            } else {
               Timber.Forest.d("getScreen() -> AddDeviceScreen.NONE", new Object[0]);
               return AddDeviceUtils.AddDeviceScreen.NONE;
            }
         } else if (var1.getDeviceType() == 40) {
            Timber.Forest.d("getScreen() -> AddDeviceScreen.AUTO_PROGRESS", new Object[0]);
            return AddDeviceUtils.AddDeviceScreen.AUTO_PROGRESS;
         } else {
            Timber.Forest.d("getScreen() -> AddDeviceScreen.CONFIG_NETWORK", new Object[0]);
            return AddDeviceUtils.AddDeviceScreen.CONFIG_NETWORK;
         }
      } else {
         Timber.Forest.d("getScreen() -> AddDeviceScreen.AUTO_STEP_2", new Object[0]);
         return AddDeviceUtils.AddDeviceScreen.AUTO_STEP_2;
      }
   }

   public final boolean screenAllowsBack(AddDeviceScreen var1) {
      return this.screenDoesNotAllowBack(var1) ^ true;
   }

   public final boolean screenDoesNotAllowBack(AddDeviceScreen var1) {
      return var1 == null || var1 == AddDeviceUtils.AddDeviceScreen.NAME_DEVICE || var1 == AddDeviceUtils.AddDeviceScreen.SETUP_TEXT || var1 == AddDeviceUtils.AddDeviceScreen.MANUAL_PROGRESS || var1 == AddDeviceUtils.AddDeviceScreen.MANUAL_VALIDATE || var1 == AddDeviceUtils.AddDeviceScreen.MANUAL_FAIL || var1 == AddDeviceUtils.AddDeviceScreen.AUTO_PROGRESS || var1 == AddDeviceUtils.AddDeviceScreen.AUTO_FAIL_STEP_1 || var1 == AddDeviceUtils.AddDeviceScreen.SUCCESS || var1 == AddDeviceUtils.AddDeviceScreen.SELECT_DEVICE || var1 == AddDeviceUtils.AddDeviceScreen.MIGRATION_OTA;
   }

   public final boolean screenHasNoToolbar(AddDeviceScreen var1) {
      return var1 == null || var1 == AddDeviceUtils.AddDeviceScreen.SUCCESS;
   }

   public final boolean shouldChangeScreen(AddDeviceState var1, AddDeviceState var2) {
      Intrinsics.checkNotNullParameter(var1, "oldState");
      Intrinsics.checkNotNullParameter(var2, "nuState");
      return var2.getDeviceType() == 0 || var1.getDeviceType() == 0 && var1.getDeviceType() != var2.getDeviceType() || !var1.getInitialTextSeen() && var2.getInitialTextSeen() || var2.getAutoStepsCompleted() > var1.getAutoStepsCompleted() || var2.getManualStepsCompleted() > var1.getManualStepsCompleted() || !var1.getNetworkInfoSet() && var2.getNetworkInfoSet() || !var1.getAutoFailed() && var2.getAutoFailed() || var1.getAutoFailStepsCompleted() != var2.getAutoFailStepsCompleted() || var1.getAutoMode() && !var2.getAutoMode() || !var1.getManualFailed() && var2.getManualFailed() || !var1.getManualValidated() && var2.getManualValidated() || !var1.isReadyForNaming() && var2.isReadyForNaming() || !var1.getResetDevice() && var2.getResetDevice() || !var1.getSuccessScreen() && var2.getSuccessScreen() || var2.getIcpStepsCompleted() != var1.getIcpStepsCompleted() || var2.getMigrationOtaCheckCompleted() != var1.getMigrationOtaCheckCompleted() || var2.getTroubleshoot() != var1.getTroubleshoot();
   }

   public final boolean showEnableLocationBluetooth(Fragment var1, LocationPermissionTracker var2, ActivityResultLauncher var3) {
      Ref.ObjectRef var8;
      Integer var14;
      label46: {
         Intrinsics.checkNotNullParameter(var1, "fragment");
         Intrinsics.checkNotNullParameter(var2, "locationPermissionTracker");
         Intrinsics.checkNotNullParameter(var3, "resultLauncher");
         Context var7 = var1.requireContext();
         Intrinsics.checkNotNullExpressionValue(var7, "requireContext(...)");
         var8 = new Ref.ObjectRef();
         Integer var10;
         if (!BluetoothUtils.INSTANCE.hasBluetoothPermissions(var7)) {
            Integer var16 = R.string.permission_request;
            var10 = R.string.hint_allow_nearby_devices;
            var14 = R.string.add_device_success_btn_okay;
            var8.element = new AddDeviceUtils$$ExternalSyntheticLambda3(var3);
            var12 = var16;
         } else if (!BluetoothUtils.INSTANCE.isBluetoothEnabled(var7)) {
            var12 = R.string.enable_bluetooth;
            var10 = R.string.hint_turn_on_bluetooth;
            var14 = R.string.enable;
            var8.element = new AddDeviceUtils$$ExternalSyntheticLambda4(var7);
         } else if (VERSION.SDK_INT < 31 && !LocationUtils.INSTANCE.isLocationPermissionGranted(var7)) {
            int var4 = R.string.permission_request;
            Integer var15 = R.string.hint_allow_nearby_devices;
            var14 = R.string.add_device_success_btn_okay;
            var8.element = new AddDeviceUtils$$ExternalSyntheticLambda5(var2, var1);
            var12 = var4;
            var10 = var15;
         } else {
            if (VERSION.SDK_INT >= 31 || LocationUtils.INSTANCE.isLocationEnabled(var7)) {
               var12 = null;
               var14 = null;
               var11 = null;
               break label46;
            }

            var12 = R.string.enable_locations;
            var10 = R.string.hint_allow_nearby_devices;
            var14 = R.string.action_settings;
            var8.element = new AddDeviceUtils$$ExternalSyntheticLambda6(var7);
         }

         Integer var17 = var14;
         var14 = var10;
         var11 = var17;
      }

      if (var12 != null) {
         FragmentManager var18 = var1.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var18, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var18.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var18.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion var9 = ConfirmationDialogLeftAligned.Companion;
            int var13 = ((Number)var12).intValue();
            Intrinsics.checkNotNull(var14);
            int var5 = ((Number)var14).intValue();
            Intrinsics.checkNotNull(var11);
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(var9, var13, (Integer)null, var5, var11, R.string.btn_cancel, false, false, false, true, (String[])null, (String)null, (Integer)null, new AddDeviceUtils$$ExternalSyntheticLambda7(var8), 3680, (Object)null)).show(var18, "ConfirmationDialogLeftAligned");
         }

         return true;
      } else {
         return false;
      }
   }

   public final Single validateNet(Context var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Single var3 = Single.fromCallable(new AddDeviceUtils$$ExternalSyntheticLambda1(var1, var2));
      Intrinsics.checkNotNullExpressionValue(var3, "fromCallable(...)");
      return var3;
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"},
      d2 = {"Lcom/blueair/adddevice/utils/AddDeviceUtils$AddDeviceScreen;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "SELECT_DEVICE", "SETUP_TEXT", "AUTO_STEP_1", "AUTO_STEP_2", "CONFIG_NETWORK", "AUTO_PROGRESS", "MANUAL_STEP_1", "MANUAL_STEP_2", "MANUAL_PROGRESS", "MANUAL_VALIDATE", "NAME_DEVICE", "AUTO_FAIL_STEP_1", "AUTO_FAIL_STEP_2", "MANUAL_FAIL", "RESET_DEVICE", "SUCCESS", "ICP_ADD_DEVICE", "ICP_SETUP_DEVICE", "ICP_PAIR_DEVICE", "ICP_SAVE_DEVICE", "ICP_NAME_DEVICE", "MIGRATION_OTA", "TROUBLESHOOT", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static enum AddDeviceScreen {
      private static final EnumEntries $ENTRIES;
      private static final AddDeviceScreen[] $VALUES;
      AUTO_FAIL_STEP_1,
      AUTO_FAIL_STEP_2,
      AUTO_PROGRESS,
      AUTO_STEP_1,
      AUTO_STEP_2,
      CONFIG_NETWORK,
      ICP_ADD_DEVICE,
      ICP_NAME_DEVICE,
      ICP_PAIR_DEVICE,
      ICP_SAVE_DEVICE,
      ICP_SETUP_DEVICE,
      MANUAL_FAIL,
      MANUAL_PROGRESS,
      MANUAL_STEP_1,
      MANUAL_STEP_2,
      MANUAL_VALIDATE,
      MIGRATION_OTA,
      NAME_DEVICE,
      NONE,
      RESET_DEVICE,
      SELECT_DEVICE,
      SETUP_TEXT,
      SUCCESS,
      TROUBLESHOOT;

      // $FF: synthetic method
      private static final AddDeviceScreen[] $values() {
         return new AddDeviceScreen[]{NONE, SELECT_DEVICE, SETUP_TEXT, AUTO_STEP_1, AUTO_STEP_2, CONFIG_NETWORK, AUTO_PROGRESS, MANUAL_STEP_1, MANUAL_STEP_2, MANUAL_PROGRESS, MANUAL_VALIDATE, NAME_DEVICE, AUTO_FAIL_STEP_1, AUTO_FAIL_STEP_2, MANUAL_FAIL, RESET_DEVICE, SUCCESS, ICP_ADD_DEVICE, ICP_SETUP_DEVICE, ICP_PAIR_DEVICE, ICP_SAVE_DEVICE, ICP_NAME_DEVICE, MIGRATION_OTA, TROUBLESHOOT};
      }

      static {
         AddDeviceScreen[] var0 = $values();
         $VALUES = var0;
         $ENTRIES = EnumEntriesKt.enumEntries(var0);
      }

      public static EnumEntries getEntries() {
         return $ENTRIES;
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0018"},
      d2 = {"Lcom/blueair/adddevice/utils/AddDeviceUtils$NetValidation;", "", "connectedWifiSSID", "", "notAllowedWiFISSID", "isOnline", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getConnectedWifiSSID", "()Ljava/lang/String;", "getNotAllowedWiFISSID", "()Z", "valid", "getValid", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class NetValidation {
      private final String connectedWifiSSID;
      private final boolean isOnline;
      private final String notAllowedWiFISSID;

      public NetValidation(String var1, String var2, boolean var3) {
         Intrinsics.checkNotNullParameter(var2, "notAllowedWiFISSID");
         super();
         this.connectedWifiSSID = var1;
         this.notAllowedWiFISSID = var2;
         this.isOnline = var3;
      }

      // $FF: synthetic method
      public static NetValidation copy$default(NetValidation var0, String var1, String var2, boolean var3, int var4, Object var5) {
         if ((var4 & 1) != 0) {
            var1 = var0.connectedWifiSSID;
         }

         if ((var4 & 2) != 0) {
            var2 = var0.notAllowedWiFISSID;
         }

         if ((var4 & 4) != 0) {
            var3 = var0.isOnline;
         }

         return var0.copy(var1, var2, var3);
      }

      public final String component1() {
         return this.connectedWifiSSID;
      }

      public final String component2() {
         return this.notAllowedWiFISSID;
      }

      public final boolean component3() {
         return this.isOnline;
      }

      public final NetValidation copy(String var1, String var2, boolean var3) {
         Intrinsics.checkNotNullParameter(var2, "notAllowedWiFISSID");
         return new NetValidation(var1, var2, var3);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof NetValidation)) {
            return false;
         } else {
            var1 = var1;
            if (!Intrinsics.areEqual(this.connectedWifiSSID, var1.connectedWifiSSID)) {
               return false;
            } else if (!Intrinsics.areEqual(this.notAllowedWiFISSID, var1.notAllowedWiFISSID)) {
               return false;
            } else {
               return this.isOnline == var1.isOnline;
            }
         }
      }

      public final String getConnectedWifiSSID() {
         return this.connectedWifiSSID;
      }

      public final String getNotAllowedWiFISSID() {
         return this.notAllowedWiFISSID;
      }

      public final boolean getValid() {
         return this.isOnline;
      }

      public int hashCode() {
         String var2 = this.connectedWifiSSID;
         int var1;
         if (var2 == null) {
            var1 = 0;
         } else {
            var1 = var2.hashCode();
         }

         return (var1 * 31 + this.notAllowedWiFISSID.hashCode()) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.isOnline);
      }

      public final boolean isOnline() {
         return this.isOnline;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("NetValidation(connectedWifiSSID=");
         var1.append(this.connectedWifiSSID);
         var1.append(", notAllowedWiFISSID=");
         var1.append(this.notAllowedWiFISSID);
         var1.append(", isOnline=");
         var1.append(this.isOnline);
         var1.append(')');
         return var1.toString();
      }
   }
}
