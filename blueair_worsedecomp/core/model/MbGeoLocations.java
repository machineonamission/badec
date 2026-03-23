package com.blueair.core.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/blueair/core/model/MbGeoLocations;", "", "type", "", "query", "", "features", "Lcom/blueair/core/model/MbLocationFeatures;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "getQuery", "()Ljava/util/List;", "getFeatures", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MbGeoLocations.kt */
public final class MbGeoLocations {
    private final List<MbLocationFeatures> features;
    private final List<String> query;
    private final String type;

    public static /* synthetic */ MbGeoLocations copy$default(MbGeoLocations mbGeoLocations, String str, List<String> list, List<MbLocationFeatures> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mbGeoLocations.type;
        }
        if ((i & 2) != 0) {
            list = mbGeoLocations.query;
        }
        if ((i & 4) != 0) {
            list2 = mbGeoLocations.features;
        }
        return mbGeoLocations.copy(str, list, list2);
    }

    public final String component1() {
        return this.type;
    }

    public final List<String> component2() {
        return this.query;
    }

    public final List<MbLocationFeatures> component3() {
        return this.features;
    }

    public final MbGeoLocations copy(String str, List<String> list, List<MbLocationFeatures> list2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(list, "query");
        Intrinsics.checkNotNullParameter(list2, "features");
        return new MbGeoLocations(str, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MbGeoLocations)) {
            return false;
        }
        MbGeoLocations mbGeoLocations = (MbGeoLocations) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) mbGeoLocations.type) && Intrinsics.areEqual((Object) this.query, (Object) mbGeoLocations.query) && Intrinsics.areEqual((Object) this.features, (Object) mbGeoLocations.features);
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.query.hashCode()) * 31) + this.features.hashCode();
    }

    public String toString() {
        return "MbGeoLocations(type=" + this.type + ", query=" + this.query + ", features=" + this.features + ')';
    }

    public MbGeoLocations(String str, List<String> list, List<MbLocationFeatures> list2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(list, "query");
        Intrinsics.checkNotNullParameter(list2, "features");
        this.type = str;
        this.query = list;
        this.features = list2;
    }

    public final String getType() {
        return this.type;
    }

    public final List<String> getQuery() {
        return this.query;
    }

    public final List<MbLocationFeatures> getFeatures() {
        return this.features;
    }
}
