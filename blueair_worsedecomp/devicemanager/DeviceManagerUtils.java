package com.blueair.devicemanager;

import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceStreamAttribute;
import com.blueair.core.model.HasAblCloudFunctions;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.Failure;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\tJ$\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Lcom/blueair/devicemanager/DeviceManagerUtils;", "", "<init>", "()V", "safeApiResult", "Lio/flatcircle/coroutinehelper/ApiResult;", "T", "apiResult", "exception", "", "shouldIgnoreStompOfflineEvent", "", "attribute", "Lcom/blueair/core/model/DeviceStreamAttribute;", "value", "device", "Lcom/blueair/core/model/Device;", "devicemanager_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceManagerUtils.kt */
public final class DeviceManagerUtils {
    public static final DeviceManagerUtils INSTANCE = new DeviceManagerUtils();

    private DeviceManagerUtils() {
    }

    public static /* synthetic */ ApiResult safeApiResult$default(DeviceManagerUtils deviceManagerUtils, ApiResult apiResult, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = new IllegalStateException("There weren't any connections available");
        }
        return deviceManagerUtils.safeApiResult(apiResult, th);
    }

    public final <T> ApiResult<T> safeApiResult(ApiResult<T> apiResult, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "exception");
        return apiResult == null ? new Failure<>(th) : apiResult;
    }

    public final boolean shouldIgnoreStompOfflineEvent(DeviceStreamAttribute<?> deviceStreamAttribute, Object obj, Device device) {
        Intrinsics.checkNotNullParameter(deviceStreamAttribute, "attribute");
        Intrinsics.checkNotNullParameter(device, "device");
        return (device instanceof HasAblCloudFunctions) && (deviceStreamAttribute instanceof DeviceStreamAttribute.ConnectivityStatus) && Intrinsics.areEqual(obj, (Object) Integer.valueOf(ConnectivityStatus.OFFLINE.ordinal())) && device.getConnectivityStatusIndex() == ConnectivityStatus.UPDATING.ordinal();
    }
}
