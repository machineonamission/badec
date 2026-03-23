package com.blueair.core.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0003JS\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006$"}, d2 = {"Lcom/blueair/core/model/MbLocationFeatures;", "", "place_type", "", "", "text", "place_name", "properties", "Lcom/blueair/core/model/MbLocationProperties;", "address", "center", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/MbLocationProperties;Ljava/lang/String;Ljava/util/List;)V", "getPlace_type", "()Ljava/util/List;", "getText", "()Ljava/lang/String;", "getPlace_name", "getProperties", "()Lcom/blueair/core/model/MbLocationProperties;", "getAddress", "getCenter", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MbLocationFeatures.kt */
public final class MbLocationFeatures {
    private final String address;
    private final List<Double> center;
    private final String place_name;
    private final List<String> place_type;
    private final MbLocationProperties properties;
    private final String text;

    public static /* synthetic */ MbLocationFeatures copy$default(MbLocationFeatures mbLocationFeatures, List<String> list, String str, String str2, MbLocationProperties mbLocationProperties, String str3, List<Double> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mbLocationFeatures.place_type;
        }
        if ((i & 2) != 0) {
            str = mbLocationFeatures.text;
        }
        if ((i & 4) != 0) {
            str2 = mbLocationFeatures.place_name;
        }
        if ((i & 8) != 0) {
            mbLocationProperties = mbLocationFeatures.properties;
        }
        if ((i & 16) != 0) {
            str3 = mbLocationFeatures.address;
        }
        if ((i & 32) != 0) {
            list2 = mbLocationFeatures.center;
        }
        String str4 = str3;
        List<Double> list3 = list2;
        MbLocationProperties mbLocationProperties2 = mbLocationProperties;
        String str5 = str;
        return mbLocationFeatures.copy(list, str5, str2, mbLocationProperties2, str4, list3);
    }

    public final List<String> component1() {
        return this.place_type;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.place_name;
    }

    public final MbLocationProperties component4() {
        return this.properties;
    }

    public final String component5() {
        return this.address;
    }

    public final List<Double> component6() {
        return this.center;
    }

    public final MbLocationFeatures copy(List<String> list, String str, String str2, MbLocationProperties mbLocationProperties, String str3, List<Double> list2) {
        Intrinsics.checkNotNullParameter(list, "place_type");
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "place_name");
        Intrinsics.checkNotNullParameter(mbLocationProperties, "properties");
        Intrinsics.checkNotNullParameter(list2, "center");
        return new MbLocationFeatures(list, str, str2, mbLocationProperties, str3, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MbLocationFeatures)) {
            return false;
        }
        MbLocationFeatures mbLocationFeatures = (MbLocationFeatures) obj;
        return Intrinsics.areEqual((Object) this.place_type, (Object) mbLocationFeatures.place_type) && Intrinsics.areEqual((Object) this.text, (Object) mbLocationFeatures.text) && Intrinsics.areEqual((Object) this.place_name, (Object) mbLocationFeatures.place_name) && Intrinsics.areEqual((Object) this.properties, (Object) mbLocationFeatures.properties) && Intrinsics.areEqual((Object) this.address, (Object) mbLocationFeatures.address) && Intrinsics.areEqual((Object) this.center, (Object) mbLocationFeatures.center);
    }

    public int hashCode() {
        int hashCode = ((((((this.place_type.hashCode() * 31) + this.text.hashCode()) * 31) + this.place_name.hashCode()) * 31) + this.properties.hashCode()) * 31;
        String str = this.address;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.center.hashCode();
    }

    public String toString() {
        return "MbLocationFeatures(place_type=" + this.place_type + ", text=" + this.text + ", place_name=" + this.place_name + ", properties=" + this.properties + ", address=" + this.address + ", center=" + this.center + ')';
    }

    public MbLocationFeatures(List<String> list, String str, String str2, MbLocationProperties mbLocationProperties, String str3, List<Double> list2) {
        Intrinsics.checkNotNullParameter(list, "place_type");
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "place_name");
        Intrinsics.checkNotNullParameter(mbLocationProperties, "properties");
        Intrinsics.checkNotNullParameter(list2, "center");
        this.place_type = list;
        this.text = str;
        this.place_name = str2;
        this.properties = mbLocationProperties;
        this.address = str3;
        this.center = list2;
    }

    public final List<String> getPlace_type() {
        return this.place_type;
    }

    public final String getText() {
        return this.text;
    }

    public final String getPlace_name() {
        return this.place_name;
    }

    public final MbLocationProperties getProperties() {
        return this.properties;
    }

    public final String getAddress() {
        return this.address;
    }

    public final List<Double> getCenter() {
        return this.center;
    }
}
