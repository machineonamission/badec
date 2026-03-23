package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.api.utils.BlueCloudSensor;
import com.blueair.core.model.IndoorDatapoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\b0\b¢\u0006\u0004\b\u000b\u0010\fJ\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\u0017\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\b0\bHÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\b0\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006#"}, d2 = {"Lcom/blueair/api/restapi/BlueDataWrapper;", "", "did", "", "start", "", "end", "sensors", "", "datapoints", "", "<init>", "(Ljava/lang/String;JJLjava/util/List;Ljava/util/List;)V", "getDid", "()Ljava/lang/String;", "getStart", "()J", "getEnd", "getSensors", "()Ljava/util/List;", "getDatapoints", "convertToSimpleIndoorDataPoints", "Lcom/blueair/core/model/IndoorDatapoint;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueCloudRestApi.kt */
public final class BlueDataWrapper {
    private final List<List<Double>> datapoints;
    private final String did;
    private final long end;
    private final List<String> sensors;
    private final long start;

    public static /* synthetic */ BlueDataWrapper copy$default(BlueDataWrapper blueDataWrapper, String str, long j, long j2, List<String> list, List<List<Double>> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = blueDataWrapper.did;
        }
        if ((i & 2) != 0) {
            j = blueDataWrapper.start;
        }
        if ((i & 4) != 0) {
            j2 = blueDataWrapper.end;
        }
        if ((i & 8) != 0) {
            list = blueDataWrapper.sensors;
        }
        if ((i & 16) != 0) {
            list2 = blueDataWrapper.datapoints;
        }
        long j3 = j2;
        long j4 = j;
        return blueDataWrapper.copy(str, j4, j3, list, list2);
    }

    public final String component1() {
        return this.did;
    }

    public final long component2() {
        return this.start;
    }

    public final long component3() {
        return this.end;
    }

    public final List<String> component4() {
        return this.sensors;
    }

    public final List<List<Double>> component5() {
        return this.datapoints;
    }

    public final BlueDataWrapper copy(String str, long j, long j2, List<String> list, List<? extends List<Double>> list2) {
        Intrinsics.checkNotNullParameter(str, "did");
        Intrinsics.checkNotNullParameter(list, "sensors");
        List<? extends List<Double>> list3 = list2;
        Intrinsics.checkNotNullParameter(list3, "datapoints");
        return new BlueDataWrapper(str, j, j2, list, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlueDataWrapper)) {
            return false;
        }
        BlueDataWrapper blueDataWrapper = (BlueDataWrapper) obj;
        return Intrinsics.areEqual((Object) this.did, (Object) blueDataWrapper.did) && this.start == blueDataWrapper.start && this.end == blueDataWrapper.end && Intrinsics.areEqual((Object) this.sensors, (Object) blueDataWrapper.sensors) && Intrinsics.areEqual((Object) this.datapoints, (Object) blueDataWrapper.datapoints);
    }

    public int hashCode() {
        return (((((((this.did.hashCode() * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.start)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.end)) * 31) + this.sensors.hashCode()) * 31) + this.datapoints.hashCode();
    }

    public String toString() {
        return "BlueDataWrapper(did=" + this.did + ", start=" + this.start + ", end=" + this.end + ", sensors=" + this.sensors + ", datapoints=" + this.datapoints + ')';
    }

    public BlueDataWrapper(String str, long j, long j2, List<String> list, List<? extends List<Double>> list2) {
        Intrinsics.checkNotNullParameter(str, "did");
        Intrinsics.checkNotNullParameter(list, "sensors");
        Intrinsics.checkNotNullParameter(list2, "datapoints");
        this.did = str;
        this.start = j;
        this.end = j2;
        this.sensors = list;
        this.datapoints = list2;
    }

    public final String getDid() {
        return this.did;
    }

    public final long getStart() {
        return this.start;
    }

    public final long getEnd() {
        return this.end;
    }

    public final List<String> getSensors() {
        return this.sensors;
    }

    public final List<List<Double>> getDatapoints() {
        return this.datapoints;
    }

    public final List<IndoorDatapoint> convertToSimpleIndoorDataPoints() {
        BlueDataWrapper blueDataWrapper = this;
        List<IndoorDatapoint> arrayList = new ArrayList<>();
        Iterator it = blueDataWrapper.datapoints.iterator();
        while (it.hasNext()) {
            List list = (List) it.next();
            Double d = (Double) list.get(0);
            long doubleValue = d != null ? (long) d.doubleValue() : System.currentTimeMillis() / 1000;
            Float valueOf = Float.valueOf(0.0f);
            Float valueOf2 = Float.valueOf(0.0f);
            Float valueOf3 = Float.valueOf(0.0f);
            Float valueOf4 = Float.valueOf(0.0f);
            Float valueOf5 = Float.valueOf(0.0f);
            Float valueOf6 = Float.valueOf(0.0f);
            Float valueOf7 = Float.valueOf(0.0f);
            Float valueOf8 = Float.valueOf(0.0f);
            Float valueOf9 = Float.valueOf(0.0f);
            Iterator it2 = blueDataWrapper.sensors.iterator();
            Float f = valueOf9;
            Float f2 = valueOf7;
            Float f3 = valueOf8;
            int i = 0;
            Float f4 = valueOf5;
            Float f5 = valueOf6;
            Float f6 = valueOf3;
            Float f7 = valueOf4;
            Float f8 = valueOf;
            Float f9 = valueOf2;
            while (it2.hasNext()) {
                Object next = it2.next();
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str = (String) next;
                Timber.Forest forest = Timber.Forest;
                Iterator it3 = it;
                Iterator it4 = it2;
                forest.d("convertToSimpleIndoorDataPoints: index = " + i + ", sensor = " + str, new Object[0]);
                Float f10 = null;
                if (Intrinsics.areEqual((Object) str, (Object) BlueCloudSensor.PM1.INSTANCE.getName())) {
                    Double d2 = (Double) list.get(i2);
                    if (d2 != null) {
                        f10 = Float.valueOf((float) d2.doubleValue());
                    }
                    f8 = f10;
                } else if (Intrinsics.areEqual((Object) str, (Object) BlueCloudSensor.PM10.INSTANCE.getName())) {
                    Double d3 = (Double) list.get(i2);
                    if (d3 != null) {
                        f10 = Float.valueOf((float) d3.doubleValue());
                    }
                    f9 = f10;
                } else if (Intrinsics.areEqual((Object) str, (Object) BlueCloudSensor.PM25.INSTANCE.getName())) {
                    Double d4 = (Double) list.get(i2);
                    if (d4 != null) {
                        f10 = Float.valueOf((float) d4.doubleValue());
                    }
                    f6 = f10;
                } else if (Intrinsics.areEqual((Object) str, (Object) BlueCloudSensor.VOC.INSTANCE.getName())) {
                    Double d5 = (Double) list.get(i2);
                    if (d5 != null) {
                        f10 = Float.valueOf((float) d5.doubleValue());
                    }
                    f7 = f10;
                } else if (Intrinsics.areEqual((Object) str, (Object) BlueCloudSensor.HCHO.INSTANCE.getName())) {
                    Double d6 = (Double) list.get(i2);
                    if (d6 != null) {
                        f10 = Float.valueOf((float) d6.doubleValue());
                    }
                    f4 = f10;
                } else if (Intrinsics.areEqual((Object) str, (Object) BlueCloudSensor.Temperature.INSTANCE.getName())) {
                    Double d7 = (Double) list.get(i2);
                    if (d7 != null) {
                        f10 = Float.valueOf((float) d7.doubleValue());
                    }
                    f5 = f10;
                } else if (Intrinsics.areEqual((Object) str, (Object) BlueCloudSensor.Humidity.INSTANCE.getName())) {
                    Double d8 = (Double) list.get(i2);
                    if (d8 != null) {
                        f10 = Float.valueOf((float) d8.doubleValue());
                    }
                    f2 = f10;
                } else if (Intrinsics.areEqual((Object) str, (Object) BlueCloudSensor.Fan.INSTANCE.getName())) {
                    Double d9 = (Double) list.get(i2);
                    if (d9 != null) {
                        f10 = Float.valueOf((float) d9.doubleValue());
                    }
                    f3 = f10;
                } else if (Intrinsics.areEqual((Object) str, (Object) BlueCloudSensor.Weight.INSTANCE.getName())) {
                    Double d10 = (Double) list.get(i2);
                    if (d10 != null) {
                        f10 = Float.valueOf((float) d10.doubleValue());
                    }
                    f = f10;
                }
                i = i2;
                it = it3;
                it2 = it4;
            }
            Iterator it5 = it;
            IndoorDatapoint indoorDatapoint = new IndoorDatapoint(doubleValue, f8, f9, f6, f7, f4, f5, f2, f3, f);
            Timber.Forest forest2 = Timber.Forest;
            forest2.d("convertToSimpleIndoorDataPoints: idp = " + indoorDatapoint, new Object[0]);
            arrayList.add(indoorDatapoint);
            blueDataWrapper = this;
            it = it5;
        }
        return arrayList;
    }
}
