package com.blueair.bluetooth.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build.VERSION;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"},
   d2 = {"Lcom/blueair/bluetooth/utils/BluetoothUtils;", "", "<init>", "()V", "isBluetoothEnabled", "", "context", "Landroid/content/Context;", "hasBluetoothPermissions", "shouldShowBluetoothRequestPermissionDialog", "fragment", "Landroidx/fragment/app/Fragment;", "bluetooth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BluetoothUtils {
   public static final BluetoothUtils INSTANCE = new BluetoothUtils();

   private BluetoothUtils() {
   }

   public final boolean hasBluetoothPermissions(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      if (VERSION.SDK_INT >= 31) {
         return ContextCompat.checkSelfPermission(var1, "android.permission.BLUETOOTH_SCAN") == 0 && ContextCompat.checkSelfPermission(var1, "android.permission.BLUETOOTH_CONNECT") == 0 && ContextCompat.checkSelfPermission(var1, "android.permission.BLUETOOTH_ADVERTISE") == 0;
      } else {
         return true;
      }
   }

   public final boolean isBluetoothEnabled(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      BluetoothManager var2 = (BluetoothManager)ContextCompat.getSystemService(var1, BluetoothManager.class);
      if (var2 != null) {
         BluetoothAdapter var3 = var2.getAdapter();
         if (var3 != null && var3.isEnabled()) {
            return true;
         }
      }

      return false;
   }

   public final boolean shouldShowBluetoothRequestPermissionDialog(Fragment var1) {
      Intrinsics.checkNotNullParameter(var1, "fragment");
      return var1.shouldShowRequestPermissionRationale("android.permission.BLUETOOTH_SCAN") || var1.shouldShowRequestPermissionRationale("android.permission.BLUETOOTH_CONNECT") || var1.shouldShowRequestPermissionRationale("android.permission.BLUETOOTH_ADVERTISE");
   }
}
