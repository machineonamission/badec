package com.blueair.devicemanager;

import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceStreamAttribute;
import com.blueair.core.model.HasAblCloudFunctions;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.Failure;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\tJ$\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"},
   d2 = {"Lcom/blueair/devicemanager/DeviceManagerUtils;", "", "<init>", "()V", "safeApiResult", "Lio/flatcircle/coroutinehelper/ApiResult;", "T", "apiResult", "exception", "", "shouldIgnoreStompOfflineEvent", "", "attribute", "Lcom/blueair/core/model/DeviceStreamAttribute;", "value", "device", "Lcom/blueair/core/model/Device;", "devicemanager_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceManagerUtils {
   public static final DeviceManagerUtils INSTANCE = new DeviceManagerUtils();

   private DeviceManagerUtils() {
   }

   // $FF: synthetic method
   public static ApiResult safeApiResult$default(DeviceManagerUtils var0, ApiResult var1, Throwable var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = (Throwable)(new IllegalStateException("There weren't any connections available"));
      }

      return var0.safeApiResult(var1, var2);
   }

   public final ApiResult safeApiResult(ApiResult var1, Throwable var2) {
      Intrinsics.checkNotNullParameter(var2, "exception");
      ApiResult var3 = var1;
      if (var1 == null) {
         var3 = (ApiResult)(new Failure(var2));
      }

      return var3;
   }

   public final boolean shouldIgnoreStompOfflineEvent(DeviceStreamAttribute var1, Object var2, Device var3) {
      Intrinsics.checkNotNullParameter(var1, "attribute");
      Intrinsics.checkNotNullParameter(var3, "device");
      return var3 instanceof HasAblCloudFunctions && var1 instanceof DeviceStreamAttribute.ConnectivityStatus && Intrinsics.areEqual(var2, ConnectivityStatus.OFFLINE.ordinal()) && var3.getConnectivityStatusIndex() == ConnectivityStatus.UPDATING.ordinal();
   }
}
