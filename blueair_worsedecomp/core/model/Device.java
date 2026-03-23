package com.blueair.core.model;

import android.content.Context;
import android.os.Parcelable;
import com.blueair.core.util.TimezoneUtils;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u00106\u001a\u0002072\n\b\u0002\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020/H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0012\u0010\u0016\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0012\u0010\u0018\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0012\u0010\u001a\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u0012\u0010\u001c\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0005R\u0012\u0010\u001e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0005R\u0012\u0010 \u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0005R\u0012\u0010\"\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0005R\u0012\u0010$\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0005R\u0012\u0010&\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\rR\u001a\u0010(\u001a\u00020)8VX\u0004¢\u0006\f\u0012\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u00100R\u001a\u00101\u001a\u0002028VX\u0004¢\u0006\f\u0012\u0004\b3\u0010+\u001a\u0004\b4\u00105¨\u0006;À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/Device;", "Landroid/os/Parcelable;", "uid", "", "getUid", "()Ljava/lang/String;", "name", "getName", "modelName", "getModelName", "typeIndex", "", "getTypeIndex", "()I", "connectivityStatusIndex", "getConnectivityStatusIndex", "lastConnectivityInMillis", "", "getLastConnectivityInMillis", "()J", "mac", "getMac", "mcuFirmware", "getMcuFirmware", "wifiFirmware", "getWifiFirmware", "hardware", "getHardware", "timeZone", "getTimeZone", "serial", "getSerial", "purchaseDate", "getPurchaseDate", "dealerName", "getDealerName", "dealerCountry", "getDealerCountry", "updateProgress", "getUpdateProgress", "connectivityStatus", "Lcom/blueair/core/model/ConnectivityStatus;", "getConnectivityStatus$annotations", "()V", "getConnectivityStatus", "()Lcom/blueair/core/model/ConnectivityStatus;", "isOnline", "", "()Z", "type", "Lcom/blueair/core/model/DeviceType;", "getType$annotations", "getType", "()Lcom/blueair/core/model/DeviceType;", "getTimezone", "Ljava/util/TimeZone;", "context", "Landroid/content/Context;", "isUsDevice", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface Device extends Parcelable {
    ConnectivityStatus getConnectivityStatus();

    int getConnectivityStatusIndex();

    String getDealerCountry();

    String getDealerName();

    String getHardware();

    long getLastConnectivityInMillis();

    String getMac();

    String getMcuFirmware();

    String getModelName();

    String getName();

    String getPurchaseDate();

    String getSerial();

    String getTimeZone();

    TimeZone getTimezone(Context context);

    DeviceType getType();

    int getTypeIndex();

    String getUid();

    int getUpdateProgress();

    String getWifiFirmware();

    boolean isOnline();

    boolean isUsDevice();

    /* renamed from: com.blueair.core.model.Device$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static ConnectivityStatus $default$getConnectivityStatus(Device _this) {
            return ConnectivityStatus.values()[_this.getConnectivityStatusIndex()];
        }

        public static boolean $default$isOnline(Device _this) {
            return _this.getConnectivityStatusIndex() == ConnectivityStatus.ONLINE.ordinal();
        }

        public static DeviceType $default$getType(Device _this) {
            return DeviceType.Companion.fromIndex(_this.getTypeIndex());
        }

        public static /* synthetic */ TimeZone getTimezone$default(Device device, Context context, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    context = null;
                }
                return device.getTimezone(context);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTimezone");
        }

        public static TimeZone $default$getTimezone(Device _this, Context context) {
            TimeZone timeZone = TimeZone.getTimeZone(_this.getTimeZone());
            if (Intrinsics.areEqual((Object) timeZone.getID(), (Object) "GMT")) {
                timeZone = TimeZone.getDefault();
            }
            if (context != null) {
                TimezoneUtils timezoneUtils = TimezoneUtils.INSTANCE;
                Intrinsics.checkNotNull(timeZone);
                TimeZone ensureValidTimezone = timezoneUtils.ensureValidTimezone(context, timeZone);
                if (ensureValidTimezone != null) {
                    return ensureValidTimezone;
                }
            }
            Intrinsics.checkNotNull(timeZone);
            return timeZone;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
            r0 = r0.getMarket();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean $default$isUsDevice(com.blueair.core.model.Device r3) {
            /*
                com.blueair.core.util.SkuConfigurationManager r0 = com.blueair.core.util.SkuConfigurationManager.INSTANCE
                com.blueair.core.model.SkuConfiguration r0 = r0.getConfig()
                java.lang.String r1 = com.blueair.core.model.DeviceKt.getSkuCompat(r3)
                com.blueair.core.model.DeviceConfig r0 = r0.getDeviceConfig(r1)
                r1 = 0
                if (r0 == 0) goto L_0x0021
                java.util.Set r0 = r0.getMarket()
                if (r0 == 0) goto L_0x0021
                java.lang.String r2 = "us"
                boolean r0 = r0.contains(r2)
                r2 = 1
                if (r0 != r2) goto L_0x0021
                return r2
            L_0x0021:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.Device.CC.$default$isUsDevice(com.blueair.core.model.Device):boolean");
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void getConnectivityStatus$annotations() {
        }

        public static /* synthetic */ void getType$annotations() {
        }

        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(Device device) {
            return CC.$default$getConnectivityStatus(device);
        }

        @Deprecated
        public static boolean isOnline(Device device) {
            return CC.$default$isOnline(device);
        }

        @Deprecated
        public static DeviceType getType(Device device) {
            return CC.$default$getType(device);
        }

        @Deprecated
        public static TimeZone getTimezone(Device device, Context context) {
            return CC.$default$getTimezone(device, context);
        }

        @Deprecated
        public static boolean isUsDevice(Device device) {
            return CC.$default$isUsDevice(device);
        }
    }
}
