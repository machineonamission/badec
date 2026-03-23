package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\b\u001a\u00020\u000eH\u0016J\b\u0010\n\u001a\u00020\u000fH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasOscillation;", "Lcom/blueair/core/model/Device;", "oscillationState", "", "getOscillationState", "()I", "oscillationAngle", "getOscillationAngle", "oscillationDirection", "getOscillationDirection", "oscillationFanSpeed", "getOscillationFanSpeed", "isOscillationEnabled", "", "Lcom/blueair/core/model/OscillationDirection;", "Lcom/blueair/core/model/OscillationFanSpeed;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasOscillation extends Device {
    int getOscillationAngle();

    int getOscillationDirection();

    int getOscillationFanSpeed();

    int getOscillationState();

    boolean isOscillationEnabled();

    OscillationDirection oscillationDirection();

    OscillationFanSpeed oscillationFanSpeed();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasOscillation hasOscillation) {
            return Device.CC.$default$getConnectivityStatus(hasOscillation);
        }

        @Deprecated
        public static TimeZone getTimezone(HasOscillation hasOscillation, Context context) {
            return Device.CC.$default$getTimezone(hasOscillation, context);
        }

        @Deprecated
        public static DeviceType getType(HasOscillation hasOscillation) {
            return Device.CC.$default$getType(hasOscillation);
        }

        @Deprecated
        public static boolean isOnline(HasOscillation hasOscillation) {
            return Device.CC.$default$isOnline(hasOscillation);
        }

        @Deprecated
        public static boolean isUsDevice(HasOscillation hasOscillation) {
            return Device.CC.$default$isUsDevice(hasOscillation);
        }

        @Deprecated
        public static boolean isOscillationEnabled(HasOscillation hasOscillation) {
            return CC.$default$isOscillationEnabled(hasOscillation);
        }

        @Deprecated
        public static OscillationDirection oscillationDirection(HasOscillation hasOscillation) {
            return CC.$default$oscillationDirection(hasOscillation);
        }

        @Deprecated
        public static OscillationFanSpeed oscillationFanSpeed(HasOscillation hasOscillation) {
            return CC.$default$oscillationFanSpeed(hasOscillation);
        }
    }

    /* renamed from: com.blueair.core.model.HasOscillation$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static boolean $default$isOscillationEnabled(HasOscillation _this) {
            return _this.getOscillationState() == 1;
        }

        public static OscillationDirection $default$oscillationDirection(HasOscillation _this) {
            Object obj;
            Iterator it = OscillationDirection.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((OscillationDirection) obj).getValue() == _this.getOscillationDirection()) {
                    break;
                }
            }
            OscillationDirection oscillationDirection = (OscillationDirection) obj;
            return oscillationDirection == null ? OscillationDirection.STRAIGHT : oscillationDirection;
        }

        public static OscillationFanSpeed $default$oscillationFanSpeed(HasOscillation _this) {
            Object obj;
            Iterator it = OscillationFanSpeed.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((OscillationFanSpeed) obj).getValue() == _this.getOscillationFanSpeed()) {
                    break;
                }
            }
            OscillationFanSpeed oscillationFanSpeed = (OscillationFanSpeed) obj;
            return oscillationFanSpeed == null ? OscillationFanSpeed.SPEED_1 : oscillationFanSpeed;
        }
    }
}
