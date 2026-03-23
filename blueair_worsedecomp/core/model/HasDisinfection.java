package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasDisinfection;", "Lcom/blueair/core/model/Device;", "disinfection", "", "getDisinfection", "()Ljava/lang/Boolean;", "disinfectLeftTime", "", "getDisinfectLeftTime", "()Ljava/lang/Integer;", "disinfectLeftTimeUpdateTime", "", "getDisinfectLeftTimeUpdateTime", "()Ljava/lang/Long;", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasDisinfection extends Device {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DISINFECTION_TIME = 7200;

    /* renamed from: com.blueair.core.model.HasDisinfection$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        static {
            Companion companion = HasDisinfection.Companion;
        }
    }

    Integer getDisinfectLeftTime();

    Long getDisinfectLeftTimeUpdateTime();

    Boolean getDisinfection();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasDisinfection hasDisinfection) {
            return Device.CC.$default$getConnectivityStatus(hasDisinfection);
        }

        @Deprecated
        public static TimeZone getTimezone(HasDisinfection hasDisinfection, Context context) {
            return Device.CC.$default$getTimezone(hasDisinfection, context);
        }

        @Deprecated
        public static DeviceType getType(HasDisinfection hasDisinfection) {
            return Device.CC.$default$getType(hasDisinfection);
        }

        @Deprecated
        public static boolean isOnline(HasDisinfection hasDisinfection) {
            return Device.CC.$default$isOnline(hasDisinfection);
        }

        @Deprecated
        public static boolean isUsDevice(HasDisinfection hasDisinfection) {
            return Device.CC.$default$isUsDevice(hasDisinfection);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/HasDisinfection$Companion;", "", "<init>", "()V", "DISINFECTION_TIME", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DISINFECTION_TIME = 7200;

        private Companion() {
        }
    }
}
