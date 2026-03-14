package com.blueair.devicedetails.util;

import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceG4;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001¨\u0006\u0006"},
   d2 = {"supportFilterWidget", "", "Lcom/blueair/core/model/Device;", "widget", "Lcom/blueair/devicedetails/util/DeviceFilterPageWidget;", "filterPurchase", "devicedetails_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceFilterPageWidgetKt {
   public static final boolean supportFilterWidget(Device var0, DeviceFilterPageWidget var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "widget");
      if (var0 instanceof DeviceG4) {
         if (Intrinsics.areEqual(var1, DeviceFilterPageWidget.FilterTutorialVideo.INSTANCE)) {
            if (!((DeviceG4)var0).isPlus()) {
               return true;
            }

            return false;
         }

         if (Intrinsics.areEqual(var1, DeviceFilterPageWidget.FilterType.INSTANCE) || Intrinsics.areEqual(var1, DeviceFilterPageWidget.FilterStatus.INSTANCE) || Intrinsics.areEqual(var1, DeviceFilterPageWidget.FilterImportanceVideo.INSTANCE)) {
            return true;
         }

         if (Intrinsics.areEqual(var1, DeviceFilterPageWidget.FilterReset.INSTANCE)) {
            return false;
         }

         if (!Intrinsics.areEqual(var1, DeviceFilterPageWidget.FilterPurchase.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
         }
      } else {
         if (Intrinsics.areEqual(var1, DeviceFilterPageWidget.FilterType.INSTANCE) || Intrinsics.areEqual(var1, DeviceFilterPageWidget.FilterStatus.INSTANCE) || Intrinsics.areEqual(var1, DeviceFilterPageWidget.FilterImportanceVideo.INSTANCE)) {
            return true;
         }

         if (!Intrinsics.areEqual(var1, DeviceFilterPageWidget.FilterPurchase.INSTANCE)) {
            return false;
         }
      }

      return var2;
   }
}
