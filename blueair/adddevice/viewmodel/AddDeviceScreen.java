package com.blueair.adddevice.viewmodel;

import androidx.fragment.app.Fragment;
import com.blueair.adddevice.fragment.AddDeviceSuccessFragment;
import com.blueair.adddevice.fragment.AddDeviceWifiFragment;
import com.blueair.adddevice.fragment.BluetoothScanResultFragment;
import com.blueair.adddevice.fragment.EnterDeviceNameFragment;
import com.blueair.adddevice.fragment.WifiPasswordFragment;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\f\u001a\u00020\u0004R\u0016\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"},
   d2 = {"Lcom/blueair/adddevice/viewmodel/AddDeviceScreen;", "", "clazz", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "<init>", "(Ljava/lang/String;ILjava/lang/Class;)V", "ChooseDevice", "WifiList", "WifiPassword", "Success", "EnterDeviceName", "fragment", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum AddDeviceScreen {
   private static final EnumEntries $ENTRIES;
   private static final AddDeviceScreen[] $VALUES;
   ChooseDevice(BluetoothScanResultFragment.class),
   EnterDeviceName(EnterDeviceNameFragment.class),
   Success(AddDeviceSuccessFragment.class),
   WifiList(AddDeviceWifiFragment.class),
   WifiPassword(WifiPasswordFragment.class);

   private final Class clazz;

   // $FF: synthetic method
   private static final AddDeviceScreen[] $values() {
      return new AddDeviceScreen[]{ChooseDevice, WifiList, WifiPassword, Success, EnterDeviceName};
   }

   static {
      AddDeviceScreen[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
   }

   private AddDeviceScreen(Class var3) {
      this.clazz = var3;
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final Fragment fragment() {
      Object var1 = this.clazz.newInstance();
      Intrinsics.checkNotNullExpressionValue(var1, "newInstance(...)");
      return (Fragment)var1;
   }
}
