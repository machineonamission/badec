package com.blueair.adddevice.adapter;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"},
   d2 = {"legacy", "", "Lcom/blueair/adddevice/adapter/DeviceModel;", "adddevice_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class SelectDeviceModelAdapterKt {
   public static final boolean legacy(DeviceModel var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      return CollectionsKt.listOf(new DeviceModel[]{DeviceModel.AWARE, DeviceModel.CLASSIC, DeviceModel.ICP, DeviceModel.SENSE}).contains(var0);
   }
}
