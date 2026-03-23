package com.blueair.core.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/blueair/core/model/Info;", "", "progress", "", "eventCode", "imageId", "", "stage", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getProgress", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEventCode", "getImageId", "()Ljava/lang/String;", "getStage", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/blueair/core/model/Info;", "equals", "", "other", "hashCode", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceUuid.kt */
public final class Info {
    private final Integer eventCode;
    private final String imageId;
    private final Integer progress;
    private final String stage;

    public static /* synthetic */ Info copy$default(Info info, Integer num, Integer num2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = info.progress;
        }
        if ((i & 2) != 0) {
            num2 = info.eventCode;
        }
        if ((i & 4) != 0) {
            str = info.imageId;
        }
        if ((i & 8) != 0) {
            str2 = info.stage;
        }
        return info.copy(num, num2, str, str2);
    }

    public final Integer component1() {
        return this.progress;
    }

    public final Integer component2() {
        return this.eventCode;
    }

    public final String component3() {
        return this.imageId;
    }

    public final String component4() {
        return this.stage;
    }

    public final Info copy(@Json(name = "c") Integer num, @Json(name = "ec") Integer num2, String str, String str2) {
        return new Info(num, num2, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Info)) {
            return false;
        }
        Info info = (Info) obj;
        return Intrinsics.areEqual((Object) this.progress, (Object) info.progress) && Intrinsics.areEqual((Object) this.eventCode, (Object) info.eventCode) && Intrinsics.areEqual((Object) this.imageId, (Object) info.imageId) && Intrinsics.areEqual((Object) this.stage, (Object) info.stage);
    }

    public int hashCode() {
        Integer num = this.progress;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.eventCode;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.imageId;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.stage;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "Info(progress=" + this.progress + ", eventCode=" + this.eventCode + ", imageId=" + this.imageId + ", stage=" + this.stage + ')';
    }

    public Info(@Json(name = "c") Integer num, @Json(name = "ec") Integer num2, String str, String str2) {
        this.progress = num;
        this.eventCode = num2;
        this.imageId = str;
        this.stage = str2;
    }

    public final Integer getProgress() {
        return this.progress;
    }

    public final Integer getEventCode() {
        return this.eventCode;
    }

    public final String getImageId() {
        return this.imageId;
    }

    public final String getStage() {
        return this.stage;
    }
}
