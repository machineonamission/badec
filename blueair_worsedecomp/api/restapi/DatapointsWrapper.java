package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.IndoorDatapoint;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0014\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\b¢\u0006\u0004\b\f\u0010\rJ\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\bJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\bHÆ\u0003J_\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001f\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006&"}, d2 = {"Lcom/blueair/api/restapi/DatapointsWrapper;", "", "uuid", "", "start", "", "end", "sensors", "", "units", "datapoints", "", "<init>", "(Ljava/lang/String;JJLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getUuid", "()Ljava/lang/String;", "getStart", "()J", "getEnd", "getSensors", "()Ljava/util/List;", "getUnits", "getDatapoints", "convertToIndoorDataPoints", "Lcom/blueair/core/model/IndoorDatapoint;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAblRestApi.kt */
public final class DatapointsWrapper {
    private final List<List<Double>> datapoints;
    private final long end;
    private final List<String> sensors;
    private final long start;
    private final List<String> units;
    private final String uuid;

    public static /* synthetic */ DatapointsWrapper copy$default(DatapointsWrapper datapointsWrapper, String str, long j, long j2, List<String> list, List<String> list2, List<List<Double>> list3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = datapointsWrapper.uuid;
        }
        if ((i & 2) != 0) {
            j = datapointsWrapper.start;
        }
        if ((i & 4) != 0) {
            j2 = datapointsWrapper.end;
        }
        if ((i & 8) != 0) {
            list = datapointsWrapper.sensors;
        }
        if ((i & 16) != 0) {
            list2 = datapointsWrapper.units;
        }
        if ((i & 32) != 0) {
            list3 = datapointsWrapper.datapoints;
        }
        List<List<Double>> list4 = list3;
        List<String> list5 = list;
        long j3 = j2;
        long j4 = j;
        return datapointsWrapper.copy(str, j4, j3, list5, list2, list4);
    }

    public final String component1() {
        return this.uuid;
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

    public final List<String> component5() {
        return this.units;
    }

    public final List<List<Double>> component6() {
        return this.datapoints;
    }

    public final DatapointsWrapper copy(String str, long j, long j2, List<String> list, List<String> list2, List<? extends List<Double>> list3) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        List<String> list4 = list;
        Intrinsics.checkNotNullParameter(list4, "sensors");
        List<String> list5 = list2;
        Intrinsics.checkNotNullParameter(list5, "units");
        List<? extends List<Double>> list6 = list3;
        Intrinsics.checkNotNullParameter(list6, "datapoints");
        return new DatapointsWrapper(str, j, j2, list4, list5, list6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DatapointsWrapper)) {
            return false;
        }
        DatapointsWrapper datapointsWrapper = (DatapointsWrapper) obj;
        return Intrinsics.areEqual((Object) this.uuid, (Object) datapointsWrapper.uuid) && this.start == datapointsWrapper.start && this.end == datapointsWrapper.end && Intrinsics.areEqual((Object) this.sensors, (Object) datapointsWrapper.sensors) && Intrinsics.areEqual((Object) this.units, (Object) datapointsWrapper.units) && Intrinsics.areEqual((Object) this.datapoints, (Object) datapointsWrapper.datapoints);
    }

    public int hashCode() {
        return (((((((((this.uuid.hashCode() * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.start)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.end)) * 31) + this.sensors.hashCode()) * 31) + this.units.hashCode()) * 31) + this.datapoints.hashCode();
    }

    public String toString() {
        return "DatapointsWrapper(uuid=" + this.uuid + ", start=" + this.start + ", end=" + this.end + ", sensors=" + this.sensors + ", units=" + this.units + ", datapoints=" + this.datapoints + ')';
    }

    public DatapointsWrapper(String str, long j, long j2, List<String> list, List<String> list2, List<? extends List<Double>> list3) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        Intrinsics.checkNotNullParameter(list, "sensors");
        Intrinsics.checkNotNullParameter(list2, "units");
        Intrinsics.checkNotNullParameter(list3, "datapoints");
        this.uuid = str;
        this.start = j;
        this.end = j2;
        this.sensors = list;
        this.units = list2;
        this.datapoints = list3;
    }

    public final String getUuid() {
        return this.uuid;
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

    public final List<String> getUnits() {
        return this.units;
    }

    public final List<List<Double>> getDatapoints() {
        return this.datapoints;
    }

    public final List<IndoorDatapoint> convertToIndoorDataPoints() {
        String str;
        Double d;
        List<IndoorDatapoint> arrayList = new ArrayList<>();
        for (List list : this.datapoints) {
            long j = this.start;
            int i = 0;
            long j2 = j;
            Float f = null;
            Float f2 = null;
            Float f3 = null;
            Float f4 = null;
            Float f5 = null;
            Float f6 = null;
            for (Object next : this.sensors) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str2 = (String) next;
                switch (str2.hashCode()) {
                    case 3581:
                        if (!str2.equals("pm")) {
                            break;
                        } else {
                            Double d2 = (Double) list.get(i);
                            if (d2 == null) {
                                f3 = null;
                                break;
                            } else {
                                f3 = Float.valueOf((float) d2.doubleValue());
                                break;
                            }
                        }
                    case 98630:
                        str = "co2";
                        break;
                    case 103680:
                        if (!str2.equals("hum")) {
                            break;
                        } else {
                            Double d3 = (Double) list.get(i);
                            if (d3 == null) {
                                f6 = null;
                                break;
                            } else {
                                f6 = Float.valueOf((float) d3.doubleValue());
                                break;
                            }
                        }
                    case 111060:
                        if (!str2.equals("pm1")) {
                            break;
                        } else {
                            Double d4 = (Double) list.get(i);
                            if (d4 == null) {
                                f = null;
                                break;
                            } else {
                                f = Float.valueOf((float) d4.doubleValue());
                                break;
                            }
                        }
                    case 114967:
                        if (!str2.equals("tmp")) {
                            break;
                        } else {
                            Double d5 = (Double) list.get(i);
                            if (d5 == null) {
                                f5 = null;
                                break;
                            } else {
                                f5 = Float.valueOf((float) d5.doubleValue());
                                break;
                            }
                        }
                    case 116938:
                        if (!str2.equals("voc")) {
                            break;
                        } else {
                            Double d6 = (Double) list.get(i);
                            if (d6 == null) {
                                f4 = null;
                                break;
                            } else {
                                f4 = Float.valueOf((float) d6.doubleValue());
                                break;
                            }
                        }
                    case 3442908:
                        if (!str2.equals("pm10")) {
                            break;
                        } else {
                            Double d7 = (Double) list.get(i);
                            if (d7 == null) {
                                f2 = null;
                                break;
                            } else {
                                f2 = Float.valueOf((float) d7.doubleValue());
                                break;
                            }
                        }
                    case 3560141:
                        if (str2.equals("time") && (d = (Double) list.get(i)) != null) {
                            j2 = MathKt.roundToLong(d.doubleValue());
                            break;
                        }
                    case 1813824405:
                        str = "allpollu";
                        break;
                }
                str2.equals(str);
                i = i2;
            }
            arrayList.add(new IndoorDatapoint(j2, f, f2, f3, f4, (Float) null, f5, f6, (Float) null, (Float) null));
        }
        return arrayList;
    }
}
