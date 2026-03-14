package com.blueair.antifake.viewmodel;

import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"},
   d2 = {"Lcom/blueair/antifake/viewmodel/BluetoothResetResult;", "", "<init>", "()V", "SUCCESS", "", "FAIL", "CONNECT_FAIL", "READ_USAGE_FAIL", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BluetoothResetResult {
   public static final String CONNECT_FAIL = "Bluetooth connection failed";
   public static final String FAIL = "Fail";
   public static final BluetoothResetResult INSTANCE = new BluetoothResetResult();
   public static final String READ_USAGE_FAIL = "Get consumable usage is fail";
   public static final String SUCCESS = "Success";

   private BluetoothResetResult() {
   }
}
