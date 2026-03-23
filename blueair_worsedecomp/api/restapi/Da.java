package com.blueair.api.restapi;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/blueair/api/restapi/Da;", "", "nightMode", "Lcom/blueair/api/restapi/ConfigurationAutoMode;", "autoMode", "<init>", "(Lcom/blueair/api/restapi/ConfigurationAutoMode;Lcom/blueair/api/restapi/ConfigurationAutoMode;)V", "getNightMode", "()Lcom/blueair/api/restapi/ConfigurationAutoMode;", "getAutoMode", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class Da {
    private final ConfigurationAutoMode autoMode;
    private final ConfigurationAutoMode nightMode;

    public static /* synthetic */ Da copy$default(Da da, ConfigurationAutoMode configurationAutoMode, ConfigurationAutoMode configurationAutoMode2, int i, Object obj) {
        if ((i & 1) != 0) {
            configurationAutoMode = da.nightMode;
        }
        if ((i & 2) != 0) {
            configurationAutoMode2 = da.autoMode;
        }
        return da.copy(configurationAutoMode, configurationAutoMode2);
    }

    public final ConfigurationAutoMode component1() {
        return this.nightMode;
    }

    public final ConfigurationAutoMode component2() {
        return this.autoMode;
    }

    public final Da copy(@Json(name = "nm") ConfigurationAutoMode configurationAutoMode, @Json(name = "am") ConfigurationAutoMode configurationAutoMode2) {
        return new Da(configurationAutoMode, configurationAutoMode2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Da)) {
            return false;
        }
        Da da = (Da) obj;
        return Intrinsics.areEqual((Object) this.nightMode, (Object) da.nightMode) && Intrinsics.areEqual((Object) this.autoMode, (Object) da.autoMode);
    }

    public int hashCode() {
        ConfigurationAutoMode configurationAutoMode = this.nightMode;
        int i = 0;
        int hashCode = (configurationAutoMode == null ? 0 : configurationAutoMode.hashCode()) * 31;
        ConfigurationAutoMode configurationAutoMode2 = this.autoMode;
        if (configurationAutoMode2 != null) {
            i = configurationAutoMode2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Da(nightMode=" + this.nightMode + ", autoMode=" + this.autoMode + ')';
    }

    public Da(@Json(name = "nm") ConfigurationAutoMode configurationAutoMode, @Json(name = "am") ConfigurationAutoMode configurationAutoMode2) {
        this.nightMode = configurationAutoMode;
        this.autoMode = configurationAutoMode2;
    }

    public final ConfigurationAutoMode getNightMode() {
        return this.nightMode;
    }

    public final ConfigurationAutoMode getAutoMode() {
        return this.autoMode;
    }
}
