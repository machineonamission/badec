package com.blueair.bluetooth.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/blueair/bluetooth/utils/BluetoothUtils;", "", "<init>", "()V", "isBluetoothEnabled", "", "context", "Landroid/content/Context;", "hasBluetoothPermissions", "shouldShowBluetoothRequestPermissionDialog", "fragment", "Landroidx/fragment/app/Fragment;", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BluetoothUtils.kt */
public final class BluetoothUtils {
    public static final BluetoothUtils INSTANCE = new BluetoothUtils();

    private BluetoothUtils() {
    }

    public final boolean isBluetoothEnabled(Context context) {
        BluetoothAdapter adapter;
        Intrinsics.checkNotNullParameter(context, "context");
        BluetoothManager bluetoothManager = (BluetoothManager) ContextCompat.getSystemService(context, BluetoothManager.class);
        if (bluetoothManager == null || (adapter = bluetoothManager.getAdapter()) == null || !adapter.isEnabled()) {
            return false;
        }
        return true;
    }

    public final boolean hasBluetoothPermissions(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT < 31) {
            return true;
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_SCAN") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_CONNECT") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_ADVERTISE") == 0) {
            return true;
        }
        return false;
    }

    public final boolean shouldShowBluetoothRequestPermissionDialog(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return fragment.shouldShowRequestPermissionRationale("android.permission.BLUETOOTH_SCAN") || fragment.shouldShowRequestPermissionRationale("android.permission.BLUETOOTH_CONNECT") || fragment.shouldShowRequestPermissionRationale("android.permission.BLUETOOTH_ADVERTISE");
    }
}
