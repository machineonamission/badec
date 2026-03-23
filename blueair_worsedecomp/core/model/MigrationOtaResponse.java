package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.client.config.CookieSpecs;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/blueair/core/model/MigrationOtaResponse;", "", "compatibility", "", "model", "isUpgrading", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getCompatibility", "()Ljava/lang/String;", "getModel", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MigrationOtaResponse.kt */
public final class MigrationOtaResponse {
    private final String compatibility;
    private final boolean isUpgrading;
    private final String model;

    public static /* synthetic */ MigrationOtaResponse copy$default(MigrationOtaResponse migrationOtaResponse, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = migrationOtaResponse.compatibility;
        }
        if ((i & 2) != 0) {
            str2 = migrationOtaResponse.model;
        }
        if ((i & 4) != 0) {
            z = migrationOtaResponse.isUpgrading;
        }
        return migrationOtaResponse.copy(str, str2, z);
    }

    public final String component1() {
        return this.compatibility;
    }

    public final String component2() {
        return this.model;
    }

    public final boolean component3() {
        return this.isUpgrading;
    }

    public final MigrationOtaResponse copy(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, CookieSpecs.BROWSER_COMPATIBILITY);
        Intrinsics.checkNotNullParameter(str2, "model");
        return new MigrationOtaResponse(str, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MigrationOtaResponse)) {
            return false;
        }
        MigrationOtaResponse migrationOtaResponse = (MigrationOtaResponse) obj;
        return Intrinsics.areEqual((Object) this.compatibility, (Object) migrationOtaResponse.compatibility) && Intrinsics.areEqual((Object) this.model, (Object) migrationOtaResponse.model) && this.isUpgrading == migrationOtaResponse.isUpgrading;
    }

    public int hashCode() {
        return (((this.compatibility.hashCode() * 31) + this.model.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isUpgrading);
    }

    public String toString() {
        return "MigrationOtaResponse(compatibility=" + this.compatibility + ", model=" + this.model + ", isUpgrading=" + this.isUpgrading + ')';
    }

    public MigrationOtaResponse(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, CookieSpecs.BROWSER_COMPATIBILITY);
        Intrinsics.checkNotNullParameter(str2, "model");
        this.compatibility = str;
        this.model = str2;
        this.isUpgrading = z;
    }

    public final String getCompatibility() {
        return this.compatibility;
    }

    public final String getModel() {
        return this.model;
    }

    public final boolean isUpgrading() {
        return this.isUpgrading;
    }
}
