package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.SensorType;
import com.blueair.devicedetails.viewholder.DeviceSensorCardHolder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u00103\u001a\u0002042\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u00105\u001a\u0002042\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u00106\u001a\u0002042\u0006\u00107\u001a\u000208J\b\u00109\u001a\u00020\u001aH\u0002J\b\u0010:\u001a\u00020\u001dH\u0016J\u0018\u0010;\u001a\u00020\u00022\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u001dH\u0016J\u0018\u0010?\u001a\u0002042\u0006\u0010@\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u001dH\u0016R0\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R$\u0010&\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u001d@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010!R\u001a\u0010)\u001a\u00020*X.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006B"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceSensorCardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceSensorCardHolder;", "<init>", "()V", "value", "", "Lcom/blueair/core/model/SensorType;", "sensors", "getSensors", "()Ljava/util/List;", "setSensors", "(Ljava/util/List;)V", "originSensors", "sensorValues", "", "", "dontSortSensorSet", "", "getDontSortSensorSet", "()Ljava/util/Set;", "dontSortSensorSet$delegate", "Lkotlin/Lazy;", "sensorValueUpdateTime", "", "isStandByOn", "", "isOffline", "normalTintColor", "", "getNormalTintColor", "()I", "setNormalTintColor", "(I)V", "liveSelectedIndex", "Landroidx/lifecycle/MutableLiveData;", "getLiveSelectedIndex", "()Landroidx/lifecycle/MutableLiveData;", "selectedIndex", "getSelectedIndex", "setSelectedIndex", "device", "Lcom/blueair/core/model/HasSensorData;", "getDevice", "()Lcom/blueair/core/model/HasSensorData;", "setDevice", "(Lcom/blueair/core/model/HasSensorData;)V", "isCelsius", "()Z", "setCelsius", "(Z)V", "setStandBy", "", "setOffline", "updateSensorData", "data", "Lcom/blueair/core/model/DeviceData;", "shouldSortSensor", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSensorCardsAdapter.kt */
public final class DeviceSensorCardsAdapter extends RecyclerView.Adapter<DeviceSensorCardHolder> {
    public HasSensorData device;
    private final Lazy dontSortSensorSet$delegate = LazyKt.lazy(new DeviceSensorCardsAdapter$$ExternalSyntheticLambda1());
    private boolean isCelsius = true;
    private boolean isOffline;
    private boolean isStandByOn;
    private final MutableLiveData<Integer> liveSelectedIndex = new MutableLiveData<>(-1);
    private int normalTintColor;
    private List<? extends SensorType> originSensors = CollectionsKt.emptyList();
    private int selectedIndex = -1;
    private long sensorValueUpdateTime;
    private final Map<SensorType, Float> sensorValues = new LinkedHashMap();
    private List<? extends SensorType> sensors = CollectionsKt.emptyList();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSensorCardsAdapter.kt */
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
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM25     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM10     // Catch:{ NoSuchFieldError -> 0x0022 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.adapter.DeviceSensorCardsAdapter.WhenMappings.<clinit>():void");
        }
    }

    public final List<SensorType> getSensors() {
        return this.sensors;
    }

    public final void setSensors(List<? extends SensorType> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.sensors = list;
        if (this.originSensors.isEmpty()) {
            this.originSensors = list;
        }
    }

    private final Set<SensorType> getDontSortSensorSet() {
        return (Set) this.dontSortSensorSet$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Set dontSortSensorSet_delegate$lambda$0() {
        return SetsKt.setOf(SensorType.HUM, SensorType.TMP);
    }

    public final int getNormalTintColor() {
        return this.normalTintColor;
    }

    public final void setNormalTintColor(int i) {
        this.normalTintColor = i;
    }

    public final MutableLiveData<Integer> getLiveSelectedIndex() {
        return this.liveSelectedIndex;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final void setSelectedIndex(int i) {
        int i2 = this.selectedIndex;
        if (i2 != i) {
            if (i2 >= 0) {
                notifyItemChanged(i2);
            }
            this.selectedIndex = i;
            notifyItemChanged(i);
            this.liveSelectedIndex.setValue(Integer.valueOf(i));
        }
    }

    public final HasSensorData getDevice() {
        HasSensorData hasSensorData = this.device;
        if (hasSensorData != null) {
            return hasSensorData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("device");
        return null;
    }

    public final void setDevice(HasSensorData hasSensorData) {
        Intrinsics.checkNotNullParameter(hasSensorData, "<set-?>");
        this.device = hasSensorData;
    }

    public final boolean isCelsius() {
        return this.isCelsius;
    }

    public final void setCelsius(boolean z) {
        this.isCelsius = z;
    }

    public final void setStandBy(boolean z) {
        if (z != this.isStandByOn) {
            this.isStandByOn = z;
            notifyDataSetChanged();
        }
    }

    public final void setOffline(boolean z) {
        if (z != this.isOffline) {
            this.isOffline = z;
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: java.util.List<? extends com.blueair.core.model.SensorType>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v24, resolved type: java.util.List<? extends com.blueair.core.model.SensorType>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateSensorData(com.blueair.core.model.DeviceData r10) {
        /*
            r9 = this;
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.util.List r10 = r10.getRawDataPoints()
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
            boolean r0 = r10.hasNext()
            r1 = 0
            if (r0 != 0) goto L_0x0018
            r0 = r1
            goto L_0x0041
        L_0x0018:
            java.lang.Object r0 = r10.next()
            boolean r2 = r10.hasNext()
            if (r2 != 0) goto L_0x0023
            goto L_0x0041
        L_0x0023:
            r2 = r0
            com.blueair.core.model.IndoorDatapoint r2 = (com.blueair.core.model.IndoorDatapoint) r2
            long r2 = r2.getTimeInSeconds()
        L_0x002a:
            java.lang.Object r4 = r10.next()
            r5 = r4
            com.blueair.core.model.IndoorDatapoint r5 = (com.blueair.core.model.IndoorDatapoint) r5
            long r5 = r5.getTimeInSeconds()
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x003b
            r0 = r4
            r2 = r5
        L_0x003b:
            boolean r4 = r10.hasNext()
            if (r4 != 0) goto L_0x002a
        L_0x0041:
            com.blueair.core.model.IndoorDatapoint r0 = (com.blueair.core.model.IndoorDatapoint) r0
            if (r0 != 0) goto L_0x005f
            java.util.List<? extends com.blueair.core.model.SensorType> r10 = r9.originSensors
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x004d:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x0201
            java.lang.Object r0 = r10.next()
            com.blueair.core.model.SensorType r0 = (com.blueair.core.model.SensorType) r0
            java.util.Map<com.blueair.core.model.SensorType, java.lang.Float> r2 = r9.sensorValues
            r2.put(r0, r1)
            goto L_0x004d
        L_0x005f:
            java.util.List<? extends com.blueair.core.model.SensorType> r10 = r9.originSensors
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x0067:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x00b6
            java.lang.Object r2 = r10.next()
            com.blueair.core.model.SensorType r2 = (com.blueair.core.model.SensorType) r2
            java.util.Map<com.blueair.core.model.SensorType, java.lang.Float> r3 = r9.sensorValues
            int[] r4 = com.blueair.devicedetails.adapter.DeviceSensorCardsAdapter.WhenMappings.$EnumSwitchMapping$0
            int r5 = r2.ordinal()
            r4 = r4[r5]
            switch(r4) {
                case 1: goto L_0x00ae;
                case 2: goto L_0x00a9;
                case 3: goto L_0x00a4;
                case 4: goto L_0x009f;
                case 5: goto L_0x009a;
                case 6: goto L_0x0095;
                case 7: goto L_0x0090;
                case 8: goto L_0x008b;
                case 9: goto L_0x0086;
                default: goto L_0x0080;
            }
        L_0x0080:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L_0x0086:
            java.lang.Float r4 = r0.getWeight()
            goto L_0x00b2
        L_0x008b:
            java.lang.Float r4 = r0.getFan()
            goto L_0x00b2
        L_0x0090:
            java.lang.Float r4 = r0.getTmp()
            goto L_0x00b2
        L_0x0095:
            java.lang.Float r4 = r0.getHum()
            goto L_0x00b2
        L_0x009a:
            java.lang.Float r4 = r0.getHcho()
            goto L_0x00b2
        L_0x009f:
            java.lang.Float r4 = r0.getVoc()
            goto L_0x00b2
        L_0x00a4:
            java.lang.Float r4 = r0.getPm10()
            goto L_0x00b2
        L_0x00a9:
            java.lang.Float r4 = r0.getPm25()
            goto L_0x00b2
        L_0x00ae:
            java.lang.Float r4 = r0.getPm1()
        L_0x00b2:
            r3.put(r2, r4)
            goto L_0x0067
        L_0x00b6:
            long r2 = r9.sensorValueUpdateTime
            r4 = 0
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 != 0) goto L_0x01fb
            boolean r10 = r9.shouldSortSensor()
            if (r10 == 0) goto L_0x01fb
            com.blueair.core.util.IndoorAirRatingRanges$Companion r10 = com.blueair.core.util.IndoorAirRatingRanges.Companion
            com.blueair.core.model.HasSensorData r2 = r9.getDevice()
            com.blueair.core.util.IndoorAirRatingRanges r10 = r10.instance(r2)
            java.util.List<? extends com.blueair.core.model.SensorType> r2 = r9.originSensors
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x00e0:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x00ff
            java.lang.Object r5 = r2.next()
            r6 = r5
            com.blueair.core.model.SensorType r6 = (com.blueair.core.model.SensorType) r6
            java.util.Set r7 = r9.getDontSortSensorSet()
            boolean r6 = r7.contains(r6)
            if (r6 == 0) goto L_0x00fb
            r3.add(r5)
            goto L_0x00e0
        L_0x00fb:
            r4.add(r5)
            goto L_0x00e0
        L_0x00ff:
            kotlin.Pair r2 = new kotlin.Pair
            r2.<init>(r3, r4)
            java.lang.Object r3 = r2.component1()
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r2 = r2.component2()
            java.util.List r2 = (java.util.List) r2
            boolean r4 = r2.isEmpty()
            if (r4 == 0) goto L_0x011a
            java.util.List<? extends com.blueair.core.model.SensorType> r10 = r9.originSensors
            goto L_0x01f8
        L_0x011a:
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r5)
            r4.<init>(r6)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r2 = r2.iterator()
        L_0x012d:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x017a
            java.lang.Object r6 = r2.next()
            com.blueair.core.model.SensorType r6 = (com.blueair.core.model.SensorType) r6
            java.util.Map<com.blueair.core.model.SensorType, java.lang.Float> r7 = r9.sensorValues
            java.lang.Object r7 = r7.get(r6)
            java.lang.Float r7 = (java.lang.Float) r7
            if (r7 == 0) goto L_0x014d
            float r7 = r7.floatValue()
            double r7 = (double) r7
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            goto L_0x014e
        L_0x014d:
            r7 = r1
        L_0x014e:
            if (r7 == 0) goto L_0x016d
            java.lang.Number r7 = (java.lang.Number) r7
            double r7 = r7.doubleValue()
            com.blueair.core.util.IndoorAirRatingRanges$IndoorAirRating r7 = r10.rating((double) r7, (com.blueair.core.model.SensorType) r6)
            if (r7 == 0) goto L_0x0165
            int r7 = r7.getRating()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x0166
        L_0x0165:
            r7 = r1
        L_0x0166:
            if (r7 == 0) goto L_0x016d
            int r7 = r7.intValue()
            goto L_0x016e
        L_0x016d:
            r7 = -1
        L_0x016e:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            kotlin.Pair r6 = kotlin.TuplesKt.to(r6, r7)
            r4.add(r6)
            goto L_0x012d
        L_0x017a:
            java.util.List r4 = (java.util.List) r4
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            com.blueair.devicedetails.adapter.DeviceSensorCardsAdapter$updateSensorData$$inlined$sortedByDescending$1 r10 = new com.blueair.devicedetails.adapter.DeviceSensorCardsAdapter$updateSensorData$$inlined$sortedByDescending$1
            r10.<init>()
            java.util.Comparator r10 = (java.util.Comparator) r10
            java.util.List r10 = kotlin.collections.CollectionsKt.sortedWith(r4, r10)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r5)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r10 = r10.iterator()
        L_0x019a:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x01b0
            java.lang.Object r2 = r10.next()
            kotlin.Pair r2 = (kotlin.Pair) r2
            java.lang.Object r2 = r2.component1()
            com.blueair.core.model.SensorType r2 = (com.blueair.core.model.SensorType) r2
            r1.add(r2)
            goto L_0x019a
        L_0x01b0:
            r10 = r1
            java.util.List r10 = (java.util.List) r10
            boolean r1 = r3.isEmpty()
            if (r1 == 0) goto L_0x01ba
            goto L_0x01f8
        L_0x01ba:
            kotlin.collections.ArrayDeque r1 = new kotlin.collections.ArrayDeque
            java.util.Collection r10 = (java.util.Collection) r10
            r1.<init>(r10)
            java.util.List<? extends com.blueair.core.model.SensorType> r10 = r9.originSensors
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r5)
            r2.<init>(r3)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r10 = r10.iterator()
        L_0x01d4:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto L_0x01f5
            java.lang.Object r3 = r10.next()
            com.blueair.core.model.SensorType r3 = (com.blueair.core.model.SensorType) r3
            java.util.Set r4 = r9.getDontSortSensorSet()
            boolean r4 = r4.contains(r3)
            if (r4 == 0) goto L_0x01eb
            goto L_0x01f1
        L_0x01eb:
            java.lang.Object r3 = r1.removeFirst()
            com.blueair.core.model.SensorType r3 = (com.blueair.core.model.SensorType) r3
        L_0x01f1:
            r2.add(r3)
            goto L_0x01d4
        L_0x01f5:
            r10 = r2
            java.util.List r10 = (java.util.List) r10
        L_0x01f8:
            r9.setSensors(r10)
        L_0x01fb:
            long r0 = r0.getTimeInMillis()
            r9.sensorValueUpdateTime = r0
        L_0x0201:
            r10 = 0
            int r0 = r9.getItemCount()
            r9.notifyItemRangeChanged(r10, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.adapter.DeviceSensorCardsAdapter.updateSensorData(com.blueair.core.model.DeviceData):void");
    }

    private final boolean shouldSortSensor() {
        return !(getDevice() instanceof DeviceDehumidifier) && !(getDevice() instanceof DeviceHumidifier) && !(getDevice() instanceof DeviceHumidifier20);
    }

    public int getItemCount() {
        return this.sensors.size();
    }

    public DeviceSensorCardHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return DeviceSensorCardHolder.Companion.newInstance(viewGroup, this.isCelsius, this.normalTintColor);
    }

    public void onBindViewHolder(DeviceSensorCardHolder deviceSensorCardHolder, int i) {
        Intrinsics.checkNotNullParameter(deviceSensorCardHolder, "holder");
        SensorType sensorType = (SensorType) this.sensors.get(i);
        deviceSensorCardHolder.getBinding().getRoot().setOnClickListener(new DeviceSensorCardsAdapter$$ExternalSyntheticLambda0(this, deviceSensorCardHolder));
        deviceSensorCardHolder.update(getDevice(), sensorType, this.sensorValues.get(sensorType), this.sensorValueUpdateTime, this.isStandByOn, this.isOffline, this.selectedIndex == i);
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$10(DeviceSensorCardsAdapter deviceSensorCardsAdapter, DeviceSensorCardHolder deviceSensorCardHolder, View view) {
        deviceSensorCardsAdapter.setSelectedIndex(deviceSensorCardHolder.getBindingAdapterPosition());
    }
}
