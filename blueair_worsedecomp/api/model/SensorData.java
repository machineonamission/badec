package com.blueair.api.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ<\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/blueair/api/model/SensorData;", "", "name", "", "value", "timeDelta", "", "baseTime", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/Long;)V", "getName", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "getTimeDelta", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBaseTime", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/Long;)Lcom/blueair/api/model/SensorData;", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SensorData.kt */
public final class SensorData {
    private final Long baseTime;
    private final String name;
    private final Long timeDelta;
    private final Object value;

    public static /* synthetic */ SensorData copy$default(SensorData sensorData, String str, Object obj, Long l, Long l2, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = sensorData.name;
        }
        if ((i & 2) != 0) {
            obj = sensorData.value;
        }
        if ((i & 4) != 0) {
            l = sensorData.timeDelta;
        }
        if ((i & 8) != 0) {
            l2 = sensorData.baseTime;
        }
        return sensorData.copy(str, obj, l, l2);
    }

    public final String component1() {
        return this.name;
    }

    public final Object component2() {
        return this.value;
    }

    public final Long component3() {
        return this.timeDelta;
    }

    public final Long component4() {
        return this.baseTime;
    }

    public final SensorData copy(@Json(name = "n") String str, @Json(name = "v") Object obj, @Json(name = "t") Long l, @Json(name = "bt") Long l2) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new SensorData(str, obj, l, l2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SensorData)) {
            return false;
        }
        SensorData sensorData = (SensorData) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) sensorData.name) && Intrinsics.areEqual(this.value, sensorData.value) && Intrinsics.areEqual((Object) this.timeDelta, (Object) sensorData.timeDelta) && Intrinsics.areEqual((Object) this.baseTime, (Object) sensorData.baseTime);
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        Object obj = this.value;
        int i = 0;
        int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        Long l = this.timeDelta;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.baseTime;
        if (l2 != null) {
            i = l2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "SensorData(name=" + this.name + ", value=" + this.value + ", timeDelta=" + this.timeDelta + ", baseTime=" + this.baseTime + ')';
    }

    public SensorData(@Json(name = "n") String str, @Json(name = "v") Object obj, @Json(name = "t") Long l, @Json(name = "bt") Long l2) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.value = obj;
        this.timeDelta = l;
        this.baseTime = l2;
    }

    public final String getName() {
        return this.name;
    }

    public final Object getValue() {
        return this.value;
    }

    public final Long getTimeDelta() {
        return this.timeDelta;
    }

    public final Long getBaseTime() {
        return this.baseTime;
    }
}
