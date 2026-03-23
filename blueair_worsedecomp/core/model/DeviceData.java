package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.database.entity.DeviceDataEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 )2\u00020\u0001:\u0001)B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\bJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J-\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006*"}, d2 = {"Lcom/blueair/core/model/DeviceData;", "", "deviceId", "", "rawDataPoints", "", "Lcom/blueair/core/model/IndoorDatapoint;", "isCelsius", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Z)V", "getDeviceId", "()Ljava/lang/String;", "getRawDataPoints", "()Ljava/util/List;", "()Z", "datapoints", "getDatapoints$annotations", "()V", "getDatapoints", "datapoints$delegate", "Lkotlin/Lazy;", "toSimpleDataPoints", "Lcom/blueair/core/model/SimpleDatapoint;", "sensorType", "Lcom/blueair/core/model/SensorType;", "ignoreTemperatureUnit", "latestDatapoint", "getLatestDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "oldestDatapoint", "getOldestDatapoint", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceData.kt */
public final class DeviceData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long REAL_TIME_MAX_DELAY = 20000;
    private final Lazy datapoints$delegate = LazyKt.lazy(new DeviceData$$ExternalSyntheticLambda0(this));
    private final String deviceId;
    private final boolean isCelsius;
    private final List<IndoorDatapoint> rawDataPoints;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceData.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(2:17|18)|19|21) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|21) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.core.model.SensorType[] r0 = com.blueair.core.model.SensorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM1     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM10     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM25     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.VOC     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.HCHO     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.HUM     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.TMP     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.FAN     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.WEIGHT     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceData.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ DeviceData copy$default(DeviceData deviceData, String str, List<IndoorDatapoint> list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceData.deviceId;
        }
        if ((i & 2) != 0) {
            list = deviceData.rawDataPoints;
        }
        if ((i & 4) != 0) {
            z = deviceData.isCelsius;
        }
        return deviceData.copy(str, list, z);
    }

    public static /* synthetic */ void getDatapoints$annotations() {
    }

    public final String component1() {
        return this.deviceId;
    }

    public final List<IndoorDatapoint> component2() {
        return this.rawDataPoints;
    }

    public final boolean component3() {
        return this.isCelsius;
    }

    public final DeviceData copy(String str, List<IndoorDatapoint> list, boolean z) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        Intrinsics.checkNotNullParameter(list, "rawDataPoints");
        return new DeviceData(str, list, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceData)) {
            return false;
        }
        DeviceData deviceData = (DeviceData) obj;
        return Intrinsics.areEqual((Object) this.deviceId, (Object) deviceData.deviceId) && Intrinsics.areEqual((Object) this.rawDataPoints, (Object) deviceData.rawDataPoints) && this.isCelsius == deviceData.isCelsius;
    }

    public int hashCode() {
        return (((this.deviceId.hashCode() * 31) + this.rawDataPoints.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isCelsius);
    }

    public String toString() {
        return "DeviceData(deviceId=" + this.deviceId + ", rawDataPoints=" + this.rawDataPoints + ", isCelsius=" + this.isCelsius + ')';
    }

    public DeviceData(String str, List<IndoorDatapoint> list, boolean z) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        Intrinsics.checkNotNullParameter(list, "rawDataPoints");
        this.deviceId = str;
        this.rawDataPoints = list;
        this.isCelsius = z;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final List<IndoorDatapoint> getRawDataPoints() {
        return this.rawDataPoints;
    }

    public final boolean isCelsius() {
        return this.isCelsius;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0006\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/blueair/core/model/DeviceData$Companion;", "", "<init>", "()V", "REAL_TIME_MAX_DELAY", "", "convertCelsiusToFahrenheit", "", "celsius", "", "", "convertFahrenheitToCelsius", "fahrenheit", "toServerValue", "fromServerValue", "value", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final double convertCelsiusToFahrenheit(double d) {
            return ((d * 9.0d) / 5.0d) + 32.0d;
        }

        public final double convertFahrenheitToCelsius(double d) {
            return ((d - 32.0d) * 5.0d) / 9.0d;
        }

        public final double fromServerValue(int i) {
            return ((double) i) / 10.0d;
        }

        private Companion() {
        }

        public final int convertCelsiusToFahrenheit(int i) {
            return MathKt.roundToInt(convertCelsiusToFahrenheit((float) i));
        }

        public final float convertCelsiusToFahrenheit(float f) {
            return (float) convertCelsiusToFahrenheit((double) f);
        }

        public final int convertFahrenheitToCelsius(int i) {
            return MathKt.roundToInt(convertFahrenheitToCelsius((float) i));
        }

        public final float convertFahrenheitToCelsius(float f) {
            return (float) convertFahrenheitToCelsius((double) f);
        }

        public final int toServerValue(double d) {
            return MathKt.roundToInt(d * ((double) 10));
        }
    }

    public final List<IndoorDatapoint> getDatapoints() {
        return (List) this.datapoints$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final List datapoints_delegate$lambda$1(DeviceData deviceData) {
        DeviceData deviceData2 = deviceData;
        if (deviceData2.isCelsius) {
            return deviceData2.rawDataPoints;
        }
        Iterable<IndoorDatapoint> iterable = deviceData2.rawDataPoints;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (IndoorDatapoint indoorDatapoint : iterable) {
            if (indoorDatapoint.getTmp() != null) {
                indoorDatapoint = IndoorDatapoint.copy$default(indoorDatapoint, 0, (Float) null, (Float) null, (Float) null, (Float) null, (Float) null, Float.valueOf(Companion.convertCelsiusToFahrenheit(indoorDatapoint.getTmp().floatValue())), (Float) null, (Float) null, (Float) null, 959, (Object) null);
            }
            arrayList.add(indoorDatapoint);
        }
        return (List) arrayList;
    }

    public static /* synthetic */ List toSimpleDataPoints$default(DeviceData deviceData, SensorType sensorType, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return deviceData.toSimpleDataPoints(sensorType, z);
    }

    public final List<SimpleDatapoint> toSimpleDataPoints(SensorType sensorType, boolean z) {
        List list;
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        switch (WhenMappings.$EnumSwitchMapping$0[sensorType.ordinal()]) {
            case 1:
                Iterable<IndoorDatapoint> iterable = this.rawDataPoints;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (IndoorDatapoint indoorDatapoint : iterable) {
                    arrayList.add(indoorDatapoint.getPm1() == null ? null : new SimpleDatapoint(indoorDatapoint.getTimeInSeconds(), indoorDatapoint.getPm1().floatValue()));
                }
                list = (List) arrayList;
                break;
            case 2:
                Iterable<IndoorDatapoint> iterable2 = this.rawDataPoints;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                for (IndoorDatapoint indoorDatapoint2 : iterable2) {
                    arrayList2.add(indoorDatapoint2.getPm10() == null ? null : new SimpleDatapoint(indoorDatapoint2.getTimeInSeconds(), indoorDatapoint2.getPm10().floatValue()));
                }
                list = (List) arrayList2;
                break;
            case 3:
                Iterable<IndoorDatapoint> iterable3 = this.rawDataPoints;
                Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable3, 10));
                for (IndoorDatapoint indoorDatapoint3 : iterable3) {
                    arrayList3.add(indoorDatapoint3.getPm25() == null ? null : new SimpleDatapoint(indoorDatapoint3.getTimeInSeconds(), indoorDatapoint3.getPm25().floatValue()));
                }
                list = (List) arrayList3;
                break;
            case 4:
                Iterable<IndoorDatapoint> iterable4 = this.rawDataPoints;
                Collection arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable4, 10));
                for (IndoorDatapoint indoorDatapoint4 : iterable4) {
                    arrayList4.add(indoorDatapoint4.getVoc() == null ? null : new SimpleDatapoint(indoorDatapoint4.getTimeInSeconds(), indoorDatapoint4.getVoc().floatValue()));
                }
                list = (List) arrayList4;
                break;
            case 5:
                Iterable<IndoorDatapoint> iterable5 = this.rawDataPoints;
                Collection arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable5, 10));
                for (IndoorDatapoint indoorDatapoint5 : iterable5) {
                    arrayList5.add(indoorDatapoint5.getHcho() == null ? null : new SimpleDatapoint(indoorDatapoint5.getTimeInSeconds(), indoorDatapoint5.getHcho().floatValue()));
                }
                list = (List) arrayList5;
                break;
            case 6:
                Iterable<IndoorDatapoint> iterable6 = this.rawDataPoints;
                Collection arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable6, 10));
                for (IndoorDatapoint indoorDatapoint6 : iterable6) {
                    arrayList6.add(indoorDatapoint6.getHum() == null ? null : new SimpleDatapoint(indoorDatapoint6.getTimeInSeconds(), indoorDatapoint6.getHum().floatValue()));
                }
                list = (List) arrayList6;
                break;
            case 7:
                Iterable<IndoorDatapoint> iterable7 = this.rawDataPoints;
                Collection arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable7, 10));
                for (IndoorDatapoint indoorDatapoint7 : iterable7) {
                    arrayList7.add(indoorDatapoint7.getTmp() == null ? null : new SimpleDatapoint(indoorDatapoint7.getTimeInSeconds(), indoorDatapoint7.getTmp().floatValue()));
                }
                list = (List) arrayList7;
                break;
            case 8:
                Iterable<IndoorDatapoint> iterable8 = this.rawDataPoints;
                Collection arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable8, 10));
                for (IndoorDatapoint indoorDatapoint8 : iterable8) {
                    arrayList8.add(indoorDatapoint8.getFan() == null ? null : new SimpleDatapoint(indoorDatapoint8.getTimeInSeconds(), indoorDatapoint8.getFan().floatValue()));
                }
                list = (List) arrayList8;
                break;
            case 9:
                Iterable<IndoorDatapoint> iterable9 = this.rawDataPoints;
                Collection arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable9, 10));
                for (IndoorDatapoint indoorDatapoint9 : iterable9) {
                    arrayList9.add(indoorDatapoint9.getWeight() == null ? null : new SimpleDatapoint(indoorDatapoint9.getTimeInSeconds(), indoorDatapoint9.getWeight().floatValue()));
                }
                list = (List) arrayList9;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        List<SimpleDatapoint> filterNotNull = CollectionsKt.filterNotNull(list);
        if (sensorType != SensorType.TMP || this.isCelsius || z) {
            return filterNotNull;
        }
        Iterable<SimpleDatapoint> iterable10 = filterNotNull;
        Collection arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable10, 10));
        for (SimpleDatapoint simpleDatapoint : iterable10) {
            arrayList10.add(SimpleDatapoint.copy$default(simpleDatapoint, 0, Companion.convertCelsiusToFahrenheit(simpleDatapoint.getValue()), 1, (Object) null));
        }
        return (List) arrayList10;
    }

    public final IndoorDatapoint getLatestDatapoint() {
        return (IndoorDatapoint) CollectionsKt.firstOrNull(CollectionsKt.sortedWith(getDatapoints(), new DeviceData$special$$inlined$sortedByDescending$1()));
    }

    public final IndoorDatapoint getOldestDatapoint() {
        return (IndoorDatapoint) CollectionsKt.firstOrNull(CollectionsKt.sortedWith(getDatapoints(), new DeviceData$special$$inlined$sortedBy$1()));
    }
}
