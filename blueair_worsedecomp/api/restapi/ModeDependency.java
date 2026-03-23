package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/blueair/api/restapi/ModeDependency;", "", "am", "Lcom/blueair/api/restapi/AutoModeTrigger;", "nm", "Lcom/blueair/api/restapi/G4NightModeTrigger;", "<init>", "(Lcom/blueair/api/restapi/AutoModeTrigger;Lcom/blueair/api/restapi/G4NightModeTrigger;)V", "getAm", "()Lcom/blueair/api/restapi/AutoModeTrigger;", "getNm", "()Lcom/blueair/api/restapi/G4NightModeTrigger;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueCloudRestApi.kt */
public final class ModeDependency {
    private final AutoModeTrigger am;
    private final G4NightModeTrigger nm;

    public static /* synthetic */ ModeDependency copy$default(ModeDependency modeDependency, AutoModeTrigger autoModeTrigger, G4NightModeTrigger g4NightModeTrigger, int i, Object obj) {
        if ((i & 1) != 0) {
            autoModeTrigger = modeDependency.am;
        }
        if ((i & 2) != 0) {
            g4NightModeTrigger = modeDependency.nm;
        }
        return modeDependency.copy(autoModeTrigger, g4NightModeTrigger);
    }

    public final AutoModeTrigger component1() {
        return this.am;
    }

    public final G4NightModeTrigger component2() {
        return this.nm;
    }

    public final ModeDependency copy(AutoModeTrigger autoModeTrigger, G4NightModeTrigger g4NightModeTrigger) {
        Intrinsics.checkNotNullParameter(autoModeTrigger, "am");
        Intrinsics.checkNotNullParameter(g4NightModeTrigger, "nm");
        return new ModeDependency(autoModeTrigger, g4NightModeTrigger);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ModeDependency)) {
            return false;
        }
        ModeDependency modeDependency = (ModeDependency) obj;
        return Intrinsics.areEqual((Object) this.am, (Object) modeDependency.am) && Intrinsics.areEqual((Object) this.nm, (Object) modeDependency.nm);
    }

    public int hashCode() {
        return (this.am.hashCode() * 31) + this.nm.hashCode();
    }

    public String toString() {
        return "ModeDependency(am=" + this.am + ", nm=" + this.nm + ')';
    }

    public ModeDependency(AutoModeTrigger autoModeTrigger, G4NightModeTrigger g4NightModeTrigger) {
        Intrinsics.checkNotNullParameter(autoModeTrigger, "am");
        Intrinsics.checkNotNullParameter(g4NightModeTrigger, "nm");
        this.am = autoModeTrigger;
        this.nm = g4NightModeTrigger;
    }

    public final AutoModeTrigger getAm() {
        return this.am;
    }

    public final G4NightModeTrigger getNm() {
        return this.nm;
    }
}
