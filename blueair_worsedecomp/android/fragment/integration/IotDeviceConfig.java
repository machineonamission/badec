package com.blueair.android.fragment.integration;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/blueair/android/fragment/integration/IotDeviceConfig;", "", "link", "", "nameRes", "", "imageRes", "<init>", "(Ljava/lang/String;II)V", "getLink", "()Ljava/lang/String;", "getNameRes", "()I", "getImageRes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: IotDeviceConfig.kt */
public final class IotDeviceConfig {
    public static final int $stable = 0;
    private final int imageRes;
    private final String link;
    private final int nameRes;

    public static /* synthetic */ IotDeviceConfig copy$default(IotDeviceConfig iotDeviceConfig, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = iotDeviceConfig.link;
        }
        if ((i3 & 2) != 0) {
            i = iotDeviceConfig.nameRes;
        }
        if ((i3 & 4) != 0) {
            i2 = iotDeviceConfig.imageRes;
        }
        return iotDeviceConfig.copy(str, i, i2);
    }

    public final String component1() {
        return this.link;
    }

    public final int component2() {
        return this.nameRes;
    }

    public final int component3() {
        return this.imageRes;
    }

    public final IotDeviceConfig copy(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "link");
        return new IotDeviceConfig(str, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IotDeviceConfig)) {
            return false;
        }
        IotDeviceConfig iotDeviceConfig = (IotDeviceConfig) obj;
        return Intrinsics.areEqual((Object) this.link, (Object) iotDeviceConfig.link) && this.nameRes == iotDeviceConfig.nameRes && this.imageRes == iotDeviceConfig.imageRes;
    }

    public int hashCode() {
        return (((this.link.hashCode() * 31) + this.nameRes) * 31) + this.imageRes;
    }

    public String toString() {
        return "IotDeviceConfig(link=" + this.link + ", nameRes=" + this.nameRes + ", imageRes=" + this.imageRes + ')';
    }

    public IotDeviceConfig(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "link");
        this.link = str;
        this.nameRes = i;
        this.imageRes = i2;
    }

    public final String getLink() {
        return this.link;
    }

    public final int getNameRes() {
        return this.nameRes;
    }

    public final int getImageRes() {
        return this.imageRes;
    }
}
