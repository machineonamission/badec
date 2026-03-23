package com.blueair.graph.viewmodel;

import com.blueair.core.model.PollutantType;
import com.blueair.core.model.SensorType;
import com.blueair.core.model.SimpleDatapoint;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.core.util.OutdoorAirRatingRanges;
import com.blueair.core.util.OutdoorRanges;
import com.blueair.graph.utils.ChartTimeScale;
import com.blueair.graph.utils.MpChartUtils;
import com.blueair.graph.utils.MpOutdoorChartUtils;
import com.blueair.viewcore.viewmodel.StandardVMNonNullState;
import com.github.mikephil.charting.data.Entry;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 g2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001gB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u001a2\b\b\u0002\u00104\u001a\u00020\u0005J\u0006\u00105\u001a\u000202J\u000e\u00106\u001a\u0002022\u0006\u00107\u001a\u00020,J\u000e\u00108\u001a\u0002022\u0006\u00109\u001a\u00020\u0012J\u000e\u0010:\u001a\u0002022\u0006\u0010;\u001a\u00020\u0016J\u0014\u0010<\u001a\u0002022\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>J2\u0010@\u001a\u0002022\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020$2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0012H\u0007J\"\u0010G\u001a\u0002022\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0B2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0016H\u0007J2\u0010I\u001a\u0002022\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010J\u001a\u00020\u00022\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020?0LH\u0002J<\u0010M\u001a\u0002022\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020$2\b\b\u0002\u0010N\u001a\u00020\u00052\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0012H\u0007J,\u0010O\u001a\u0002022\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0B2\b\b\u0002\u0010N\u001a\u00020\u00052\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0016H\u0007J<\u0010P\u001a\u0002022\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010J\u001a\u00020\u00022\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020?0L2\b\b\u0002\u0010N\u001a\u00020\u0005H\u0007J&\u0010Q\u001a\u0002022\f\u0010R\u001a\b\u0012\u0004\u0012\u00020 0B2\u0006\u0010S\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u0002H\u0003J\u001a\u0010T\u001a\u0002022\u0006\u0010U\u001a\u00020\u00022\b\b\u0002\u0010V\u001a\u00020\u0005H\u0003J\u0012\u0010W\u001a\u0004\u0018\u00010 2\u0006\u0010X\u001a\u00020 H\u0002J\u0010\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010X\u001a\u00020 J\u001a\u0010[\u001a\u0004\u0018\u00010C2\u0006\u0010\\\u001a\u00020,2\u0006\u0010]\u001a\u00020?H\u0002J\u0012\u0010^\u001a\u0004\u0018\u00010C2\u0006\u0010X\u001a\u00020 H\u0002J\u001a\u0010_\u001a\u0004\u0018\u00010C2\u0006\u0010\\\u001a\u00020,2\u0006\u0010`\u001a\u00020aH\u0002J\n\u0010b\u001a\u0004\u0018\u00010\u0002H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128@X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168@X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000bR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\"\"\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0013\u0010/\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b0\u0010\"R\u0012\u0010c\u001a\u00020dX\u0005¢\u0006\u0006\u001a\u0004\be\u0010f¨\u0006h"}, d2 = {"Lcom/blueair/graph/viewmodel/GraphViewModel;", "Lcom/blueair/viewcore/viewmodel/StandardVMNonNullState;", "Lcom/blueair/graph/viewmodel/GraphState;", "Lkotlinx/coroutines/CoroutineScope;", "outdoor", "", "name", "", "<init>", "(ZLjava/lang/String;)V", "getOutdoor", "()Z", "getName", "()Ljava/lang/String;", "defaultState", "getDefaultState", "()Lcom/blueair/graph/viewmodel/GraphState;", "sensorType", "Lcom/blueair/core/model/SensorType;", "getSensorType$graph_otherRelease", "()Lcom/blueair/core/model/SensorType;", "pollutantType", "Lcom/blueair/core/model/PollutantType;", "getPollutantType$graph_otherRelease", "()Lcom/blueair/core/model/PollutantType;", "timeScale", "Lcom/blueair/graph/utils/ChartTimeScale;", "getTimeScale$graph_otherRelease", "()Lcom/blueair/graph/utils/ChartTimeScale;", "isCelsius", "isCelsius$graph_otherRelease", "tempLastSelectedEntry", "Lcom/github/mikephil/charting/data/Entry;", "getTempLastSelectedEntry", "()Lcom/github/mikephil/charting/data/Entry;", "deviceRatings", "Lcom/blueair/core/util/IndoorAirRatingRanges;", "getDeviceRatings", "()Lcom/blueair/core/util/IndoorAirRatingRanges;", "tempRelativelyTimedLastSelectedEntry", "getTempRelativelyTimedLastSelectedEntry", "setTempRelativelyTimedLastSelectedEntry", "(Lcom/github/mikephil/charting/data/Entry;)V", "startingTimeInMillis", "", "getStartingTimeInMillis", "()J", "latestGraphDataPoint", "getLatestGraphDataPoint", "updateScale", "", "nuTimeScale", "force", "refresh", "gotoTime", "timeInMillis", "setSensorType", "nuSensorType", "setPollutantType", "nuPollutantType", "setTimeStampFilter", "nuTimeStampFilter", "", "", "updateIndoorRealTime", "nuDatapoints", "", "Lcom/blueair/core/model/SimpleDatapoint;", "nuIsCelsius", "ratings", "overrideSensorType", "updateOutdoorRealTime", "overridePollutantType", "updateRealTime", "nuState", "entryYMapper", "Lkotlin/Function1;", "updateIndoorHistorical", "isCompare", "updateOutdoorHistorical", "updateHistorical", "updateGraphDataPoints", "nuDataPoints", "isRealTime", "updateState", "nuGraphState", "doMerge", "getCompareDataPointForEntry", "entry", "reverseRelativelyTimedEntryToDataPoint", "Lcom/blueair/graph/viewmodel/ReversedResult;", "reverseIndoorEntryToDataPoint", "x", "y", "reverseOutdoorEntryToDataPoint", "reverseEntryToDataPoint", "unscaledValue", "", "onSaveState", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GraphViewModel.kt */
public final class GraphViewModel extends StandardVMNonNullState<GraphState> implements CoroutineScope {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ChartTimeScale DEFAULT_TIME_SCALE = ChartTimeScale.WEEK;
    /* access modifiers changed from: private */
    public static final long MONTH_IN_MILIS = TimeUnit.DAYS.toMillis(30);
    private final /* synthetic */ DefaultCoroutineScope $$delegate_0 = new DefaultCoroutineScope();
    private final GraphState defaultState;
    private final String name;
    private final boolean outdoor;
    private Entry tempRelativelyTimedLastSelectedEntry;

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public GraphViewModel(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.outdoor = z;
        this.name = str;
        this.defaultState = z ? GraphState.Companion.outdoorDefault() : GraphState.Companion.indoorDefault();
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getOutdoor() {
        return this.outdoor;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/blueair/graph/viewmodel/GraphViewModel$Companion;", "", "<init>", "()V", "DEFAULT_TIME_SCALE", "Lcom/blueair/graph/utils/ChartTimeScale;", "getDEFAULT_TIME_SCALE", "()Lcom/blueair/graph/utils/ChartTimeScale;", "MONTH_IN_MILIS", "", "getMONTH_IN_MILIS", "()J", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GraphViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ChartTimeScale getDEFAULT_TIME_SCALE() {
            return GraphViewModel.DEFAULT_TIME_SCALE;
        }

        public final long getMONTH_IN_MILIS() {
            return GraphViewModel.MONTH_IN_MILIS;
        }
    }

    /* access modifiers changed from: protected */
    public GraphState getDefaultState() {
        return this.defaultState;
    }

    public final SensorType getSensorType$graph_otherRelease() {
        return ((GraphState) getState()).getSensorType();
    }

    public final PollutantType getPollutantType$graph_otherRelease() {
        if (this.outdoor) {
            return ((GraphState) getState()).getPollutantType();
        }
        PollutantType fromSensorType = PollutantType.Companion.fromSensorType(((GraphState) getState()).getSensorType());
        return fromSensorType == null ? PollutantType.PM25.INSTANCE : fromSensorType;
    }

    public final ChartTimeScale getTimeScale$graph_otherRelease() {
        return ((GraphState) getState()).getTimeScale();
    }

    public final boolean isCelsius$graph_otherRelease() {
        return ((GraphState) getState()).isCelsius();
    }

    private final Entry getTempLastSelectedEntry() {
        Entry entry = this.tempRelativelyTimedLastSelectedEntry;
        if (entry != null) {
            return new Entry(entry.getX() + ((float) getStartingTimeInMillis()), entry.getY());
        }
        return null;
    }

    public final IndoorAirRatingRanges getDeviceRatings() {
        return ((GraphState) getState()).getDeviceRatings();
    }

    public final Entry getTempRelativelyTimedLastSelectedEntry() {
        return this.tempRelativelyTimedLastSelectedEntry;
    }

    public final void setTempRelativelyTimedLastSelectedEntry(Entry entry) {
        this.tempRelativelyTimedLastSelectedEntry = entry;
    }

    public final long getStartingTimeInMillis() {
        return ((GraphState) getState()).getStartingTimeInMillis();
    }

    public final Entry getLatestGraphDataPoint() {
        List<Entry> graphRelativeTimedDataPoints = ((GraphState) getState()).getGraphRelativeTimedDataPoints();
        if (graphRelativeTimedDataPoints != null) {
            return (Entry) CollectionsKt.lastOrNull(graphRelativeTimedDataPoints);
        }
        return null;
    }

    public static /* synthetic */ void updateScale$default(GraphViewModel graphViewModel, ChartTimeScale chartTimeScale, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        graphViewModel.updateScale(chartTimeScale, z);
    }

    public final void updateScale(ChartTimeScale chartTimeScale, boolean z) {
        Intrinsics.checkNotNullParameter(chartTimeScale, "nuTimeScale");
        if (chartTimeScale != ((GraphState) getState()).getTimeScale() || z) {
            Timber.Forest forest = Timber.Forest;
            forest.v("updateScale: name = " + this.name, new Object[0]);
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new GraphViewModel$updateScale$1(this, chartTimeScale, (Continuation<? super GraphViewModel$updateScale$1>) null), 2, (Object) null);
        }
    }

    public final void refresh() {
        updateScale(((GraphState) getState()).getTimeScale(), true);
    }

    public final void gotoTime(long j) {
        Entry entry;
        Object obj;
        GraphState copy$default = GraphState.copy$default((GraphState) getState(), (List) null, (List) null, (List) null, (List) null, (List) null, (Set) null, (Entry) null, 0, 0, (ChartTimeScale) null, 0, 0, (List) null, false, 0, (IndoorAirRatingRanges) null, 65535, (Object) null);
        long startingTimeInMillis = j - copy$default.getStartingTimeInMillis();
        List<Entry> graphRelativeTimedDataPoints = copy$default.getGraphRelativeTimedDataPoints();
        if (graphRelativeTimedDataPoints != null) {
            Iterator it = graphRelativeTimedDataPoints.iterator();
            if (!it.hasNext()) {
                obj = null;
            } else {
                obj = it.next();
                if (it.hasNext()) {
                    float f = (float) startingTimeInMillis;
                    float abs = Math.abs(f - ((Entry) obj).getX());
                    do {
                        Object next = it.next();
                        float abs2 = Math.abs(f - ((Entry) next).getX());
                        if (Float.compare(abs, abs2) > 0) {
                            obj = next;
                            abs = abs2;
                        }
                    } while (it.hasNext());
                }
            }
            entry = (Entry) obj;
        } else {
            entry = null;
        }
        Entry entry2 = entry != null ? new Entry(entry.getX() + ((float) copy$default.getStartingTimeInMillis()), entry.getY()) : null;
        Timber.Forest.v("gotoTime: relativelyTimedClosestEntry = " + entry + ", closestEntry = " + entry2 + ", tempLastSelectedEntry = " + getTempLastSelectedEntry() + ", name = " + this.name, new Object[0]);
        if (entry != null) {
            float x = entry.getX();
            Entry entry3 = this.tempRelativelyTimedLastSelectedEntry;
            if (!Intrinsics.areEqual(x, entry3 != null ? Float.valueOf(entry3.getX()) : null)) {
                this.tempRelativelyTimedLastSelectedEntry = entry;
                updateState$default(this, copy$default, false, 2, (Object) null);
            }
        }
    }

    public final void setSensorType(SensorType sensorType) {
        SensorType sensorType2 = sensorType;
        Intrinsics.checkNotNullParameter(sensorType2, "nuSensorType");
        Timber.Forest forest = Timber.Forest;
        forest.v("setSensorType = " + sensorType2 + ", name = " + this.name, new Object[0]);
        this.tempRelativelyTimedLastSelectedEntry = null;
        synchronized (getStateLock()) {
            updateState(GraphState.copy$default((GraphState) getState(), (List) null, (List) null, (List) null, (List) null, (List) null, (Set) null, (Entry) null, System.currentTimeMillis() - MONTH_IN_MILIS, System.currentTimeMillis(), (ChartTimeScale) null, sensorType2.ordinal(), 0, (List) null, false, 0, (IndoorAirRatingRanges) null, 64000, (Object) null), false);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setPollutantType(PollutantType pollutantType) {
        PollutantType pollutantType2 = pollutantType;
        Intrinsics.checkNotNullParameter(pollutantType2, "nuPollutantType");
        Timber.Forest forest = Timber.Forest;
        forest.v("setPollutantType = " + pollutantType2 + ", name = " + this.name, new Object[0]);
        this.tempRelativelyTimedLastSelectedEntry = null;
        synchronized (getStateLock()) {
            updateState(GraphState.copy$default((GraphState) getState(), (List) null, (List) null, (List) null, (List) null, (List) null, (Set) null, (Entry) null, System.currentTimeMillis() - MONTH_IN_MILIS, System.currentTimeMillis(), (ChartTimeScale) null, pollutantType2.getCode(), 0, (List) null, false, 0, (IndoorAirRatingRanges) null, 64000, (Object) null), false);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setTimeStampFilter(Set<Float> set) {
        Set<Float> set2 = set;
        Intrinsics.checkNotNullParameter(set2, "nuTimeStampFilter");
        if (!Intrinsics.areEqual((Object) set2, (Object) ((GraphState) getState()).getTimeStampFilter())) {
            List<Entry> graphHistoricalDataPoints = ((GraphState) getState()).getGraphHistoricalDataPoints();
            List<Entry> graphRealTimeDataPoints = ((GraphState) getState()).getGraphRealTimeDataPoints();
            GraphState copy$default = GraphState.copy$default((GraphState) getState(), (List) null, (List) null, (List) null, (List) null, (List) null, set2, (Entry) null, 0, 0, (ChartTimeScale) null, 0, 0, (List) null, false, 0, (IndoorAirRatingRanges) null, 65503, (Object) null);
            if (graphHistoricalDataPoints == null && graphRealTimeDataPoints == null) {
                updateState$default(this, copy$default, false, 2, (Object) null);
                return;
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new GraphViewModel$setTimeStampFilter$1(graphHistoricalDataPoints, this, copy$default, graphRealTimeDataPoints, (Continuation<? super GraphViewModel$setTimeStampFilter$1>) null), 2, (Object) null);
        }
    }

    public static /* synthetic */ void updateIndoorRealTime$default(GraphViewModel graphViewModel, List list, boolean z, IndoorAirRatingRanges indoorAirRatingRanges, SensorType sensorType, int i, Object obj) {
        if ((i & 8) != 0) {
            sensorType = null;
        }
        graphViewModel.updateIndoorRealTime(list, z, indoorAirRatingRanges, sensorType);
    }

    public final void updateIndoorRealTime(List<SimpleDatapoint> list, boolean z, IndoorAirRatingRanges indoorAirRatingRanges, SensorType sensorType) {
        List<SimpleDatapoint> list2 = list;
        IndoorAirRatingRanges indoorAirRatingRanges2 = indoorAirRatingRanges;
        Intrinsics.checkNotNullParameter(list2, "nuDatapoints");
        Intrinsics.checkNotNullParameter(indoorAirRatingRanges2, "ratings");
        Timber.Forest forest = Timber.Forest;
        forest.v("updateIndoorRealTime, size = " + list2.size() + ", name = " + this.name, new Object[0]);
        GraphState graphState = (GraphState) getState();
        SensorType sensorType2 = sensorType == null ? ((GraphState) getState()).getSensorType() : sensorType;
        double[] airRatingsFor = indoorAirRatingRanges2.airRatingsFor(sensorType2);
        updateRealTime(list, GraphState.copy$default(graphState, (List) null, (List) null, (List) null, (List) null, (List) null, (Set) null, (Entry) null, 0, 0, (ChartTimeScale) null, 0, indoorAirRatingRanges2.numberOfRangesFor(sensorType2), ArraysKt.toList(airRatingsFor), z, 0, indoorAirRatingRanges, 18431, (Object) null), new GraphViewModel$$ExternalSyntheticLambda3(sensorType2, airRatingsFor, z));
    }

    /* access modifiers changed from: private */
    public static final float updateIndoorRealTime$lambda$5(SensorType sensorType, double[] dArr, boolean z, float f) {
        return (float) MpChartUtils.INSTANCE.getScaledValueForChart(f, sensorType, dArr, z);
    }

    public static /* synthetic */ void updateOutdoorRealTime$default(GraphViewModel graphViewModel, List list, PollutantType pollutantType, int i, Object obj) {
        if ((i & 2) != 0) {
            pollutantType = null;
        }
        graphViewModel.updateOutdoorRealTime(list, pollutantType);
    }

    public final void updateOutdoorRealTime(List<SimpleDatapoint> list, PollutantType pollutantType) {
        List<SimpleDatapoint> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "nuDatapoints");
        Timber.Forest forest = Timber.Forest;
        forest.v("updateOutdoorRealTime, size = " + list2.size() + ", name = " + this.name, new Object[0]);
        OutdoorRanges airRatingsFor = OutdoorAirRatingRanges.INSTANCE.airRatingsFor(pollutantType == null ? getPollutantType$graph_otherRelease() : pollutantType);
        double[] high = airRatingsFor.getHigh();
        updateRealTime(list2, GraphState.copy$default((GraphState) getState(), (List) null, (List) null, (List) null, (List) null, (List) null, (Set) null, (Entry) null, 0, 0, (ChartTimeScale) null, 0, high.length, ArraysKt.toList(high), false, 0, (IndoorAirRatingRanges) null, 59391, (Object) null), new GraphViewModel$$ExternalSyntheticLambda2(airRatingsFor));
    }

    /* access modifiers changed from: private */
    public static final float updateOutdoorRealTime$lambda$6(OutdoorRanges outdoorRanges, float f) {
        return (float) MpChartUtils.INSTANCE.getScaledValueForChart(f, outdoorRanges.getHigh());
    }

    private final void updateRealTime(List<SimpleDatapoint> list, GraphState graphState, Function1<? super Float, Float> function1) {
        if (!list.isEmpty()) {
            Timber.Forest forest = Timber.Forest;
            forest.v("updateRealTime, size = " + list.size() + ", name = " + this.name, new Object[0]);
            Iterable<SimpleDatapoint> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (SimpleDatapoint simpleDatapoint : iterable) {
                arrayList.add(new GraphEntry(simpleDatapoint.getTimeInMillis(), function1.invoke(Float.valueOf(simpleDatapoint.getValue())).floatValue()));
            }
            updateGraphDataPoints((List) arrayList, true, graphState);
        }
    }

    public static /* synthetic */ void updateIndoorHistorical$default(GraphViewModel graphViewModel, List list, boolean z, IndoorAirRatingRanges indoorAirRatingRanges, boolean z2, SensorType sensorType, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = false;
        }
        boolean z3 = z2;
        if ((i & 16) != 0) {
            sensorType = null;
        }
        graphViewModel.updateIndoorHistorical(list, z, indoorAirRatingRanges, z3, sensorType);
    }

    public final void updateIndoorHistorical(List<SimpleDatapoint> list, boolean z, IndoorAirRatingRanges indoorAirRatingRanges, boolean z2, SensorType sensorType) {
        GraphState graphState;
        double[] dArr;
        SensorType sensorType2;
        List<SimpleDatapoint> list2 = list;
        IndoorAirRatingRanges indoorAirRatingRanges2 = indoorAirRatingRanges;
        boolean z3 = z2;
        Intrinsics.checkNotNullParameter(list2, "nuDatapoints");
        Intrinsics.checkNotNullParameter(indoorAirRatingRanges2, "ratings");
        GraphState graphState2 = (GraphState) getState();
        SensorType sensorType3 = sensorType == null ? graphState2.getSensorType() : sensorType;
        Timber.Forest forest = Timber.Forest;
        forest.v("updateIndoorHistorical, isCompare = " + z3 + ", size = " + list2.size() + ", name = " + this.name, new Object[0]);
        double[] airRatingsFor = indoorAirRatingRanges2.airRatingsFor(sensorType3);
        int numberOfRangesFor = indoorAirRatingRanges2.numberOfRangesFor(sensorType3);
        if (z3) {
            graphState = GraphState.copy$default(graphState2, (List) null, (List) null, (List) null, (List) null, (List) null, (Set) null, (Entry) null, 0, 0, (ChartTimeScale) null, 0, 0, (List) null, false, 0, (IndoorAirRatingRanges) null, 65535, (Object) null);
            dArr = airRatingsFor;
            sensorType2 = sensorType3;
        } else {
            sensorType2 = sensorType3;
            dArr = airRatingsFor;
            graphState = GraphState.copy$default(graphState2, (List) null, (List) null, (List) null, (List) null, (List) null, (Set) null, (Entry) null, 0, 0, (ChartTimeScale) null, 0, numberOfRangesFor, ArraysKt.toList(airRatingsFor), z, 0, indoorAirRatingRanges, 18431, (Object) null);
        }
        updateHistorical(list, graphState, new GraphViewModel$$ExternalSyntheticLambda1(sensorType2, dArr, z), z2);
    }

    /* access modifiers changed from: private */
    public static final float updateIndoorHistorical$lambda$8(SensorType sensorType, double[] dArr, boolean z, float f) {
        return (float) MpChartUtils.INSTANCE.getScaledValueForChart(f, sensorType, dArr, z);
    }

    public static /* synthetic */ void updateOutdoorHistorical$default(GraphViewModel graphViewModel, List list, boolean z, PollutantType pollutantType, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            pollutantType = null;
        }
        graphViewModel.updateOutdoorHistorical(list, z, pollutantType);
    }

    public final void updateOutdoorHistorical(List<SimpleDatapoint> list, boolean z, PollutantType pollutantType) {
        double[] dArr;
        GraphState graphState;
        List<SimpleDatapoint> list2 = list;
        boolean z2 = z;
        Intrinsics.checkNotNullParameter(list2, "nuDatapoints");
        Timber.Forest forest = Timber.Forest;
        forest.v("updateOutdoorHistorical, isCompare = " + z2 + ", size = " + list2.size() + ", name = " + this.name, new Object[0]);
        SensorType sensorType = PollutantType.Companion.toSensorType(pollutantType == null ? getPollutantType$graph_otherRelease() : pollutantType);
        if (!z2 || sensorType == null) {
            dArr = OutdoorAirRatingRanges.INSTANCE.airRatingsFor(pollutantType == null ? getPollutantType$graph_otherRelease() : pollutantType).getHigh();
        } else {
            dArr = ((GraphState) getState()).getDeviceRatings().airRatingsFor(sensorType);
        }
        int length = dArr.length;
        if (z2) {
            graphState = GraphState.copy$default((GraphState) getState(), (List) null, (List) null, (List) null, (List) null, (List) null, (Set) null, (Entry) null, 0, 0, (ChartTimeScale) null, 0, 0, (List) null, false, 0, (IndoorAirRatingRanges) null, 65535, (Object) null);
        } else {
            graphState = GraphState.copy$default((GraphState) getState(), (List) null, (List) null, (List) null, (List) null, (List) null, (Set) null, (Entry) null, 0, 0, (ChartTimeScale) null, 0, length, ArraysKt.toList(dArr), false, 0, (IndoorAirRatingRanges) null, 59391, (Object) null);
        }
        updateHistorical(list2, graphState, new GraphViewModel$$ExternalSyntheticLambda0(dArr), z2);
    }

    /* access modifiers changed from: private */
    public static final float updateOutdoorHistorical$lambda$9(double[] dArr, float f) {
        return (float) MpChartUtils.INSTANCE.getScaledValueForChart(f, dArr);
    }

    public static /* synthetic */ void updateHistorical$default(GraphViewModel graphViewModel, List list, GraphState graphState, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        graphViewModel.updateHistorical(list, graphState, function1, z);
    }

    public final void updateHistorical(List<SimpleDatapoint> list, GraphState graphState, Function1<? super Float, Float> function1, boolean z) {
        List<SimpleDatapoint> list2 = list;
        GraphState graphState2 = graphState;
        Function1<? super Float, Float> function12 = function1;
        boolean z2 = z;
        Intrinsics.checkNotNullParameter(list2, "nuDatapoints");
        Intrinsics.checkNotNullParameter(graphState2, "nuState");
        Intrinsics.checkNotNullParameter(function12, "entryYMapper");
        if (!list2.isEmpty()) {
            Timber.Forest forest = Timber.Forest;
            forest.v("updateHistorical, isCompare = " + z2 + ", size = " + list2.size() + ", name = " + this.name, new Object[0]);
            Iterable<SimpleDatapoint> iterable = list2;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (SimpleDatapoint simpleDatapoint : iterable) {
                arrayList.add(new Entry((float) simpleDatapoint.getTimeInMillis(), function12.invoke(Float.valueOf(simpleDatapoint.getValue())).floatValue()));
            }
            List<Entry> list3 = (List) arrayList;
            List<Entry> reduceWithDouglasPeucker = MpChartUtils.INSTANCE.reduceWithDouglasPeucker((List<? extends Entry>) list3, getTimeScale$graph_otherRelease());
            Timber.Forest forest2 = Timber.Forest;
            forest2.v("updateHistorical: reducedDataPoints.size = " + reduceWithDouglasPeucker.size() + ", " + this.name, new Object[0]);
            if (!z2) {
                if (graphState2.getTimeStampFilter() != null) {
                    reduceWithDouglasPeucker = list3;
                }
                List<Entry> list4 = reduceWithDouglasPeucker;
                List<Entry> list5 = list4;
                updateGraphDataPoints(list5, false, GraphState.copy$default(graphState, list3, (List) null, (List) null, (List) null, (List) null, (Set) null, (Entry) null, 0, 0, (ChartTimeScale) null, 0, 0, (List) null, false, 0, (IndoorAirRatingRanges) null, 65534, (Object) null));
            } else if (!Intrinsics.areEqual((Object) reduceWithDouglasPeucker, (Object) graphState2.getCompareGraphDataPoints())) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain(), (CoroutineStart) null, new GraphViewModel$updateHistorical$1(this, graphState2, reduceWithDouglasPeucker, (Continuation<? super GraphViewModel$updateHistorical$1>) null), 2, (Object) null);
            } else {
                Timber.Forest forest3 = Timber.Forest;
                forest3.v("updateHistorical: IGNORE COMPARE SINCE SAME, name = " + this.name, new Object[0]);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: java.util.List} */
    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x00e4: MOVE  (r5v22 java.util.Collection) = (r11v0 java.util.List)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    public final void updateGraphDataPoints(java.util.List<? extends com.github.mikephil.charting.data.Entry> r21, boolean r22, com.blueair.graph.viewmodel.GraphState r23) {
        /*
            r20 = this;
            r1 = r20
            r0 = r22
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "updateGraphDataPoints, isRealTime = "
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r4 = ", size = "
            r3.append(r4)
            int r4 = r21.size()
            r3.append(r4)
            java.lang.String r4 = ", hasTimeStampFilter = "
            r3.append(r4)
            java.util.Set r4 = r23.getTimeStampFilter()
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x002b
            r4 = r5
            goto L_0x002c
        L_0x002b:
            r4 = r6
        L_0x002c:
            r3.append(r4)
            java.lang.String r4 = ", nuState.containsCompare() = "
            r3.append(r4)
            java.util.List r4 = r23.getCompareGraphDataPoints()
            java.util.Collection r4 = (java.util.Collection) r4
            if (r4 == 0) goto L_0x0045
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r4 = r6
            goto L_0x0046
        L_0x0045:
            r4 = r5
        L_0x0046:
            r4 = r4 ^ r5
            r3.append(r4)
            java.lang.String r4 = ", "
            r3.append(r4)
            java.lang.String r5 = r1.name
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r5 = new java.lang.Object[r6]
            r2.v(r3, r5)
            long r8 = java.lang.System.currentTimeMillis()
            long r2 = MONTH_IN_MILIS
            long r2 = r8 - r2
            java.util.List r5 = r23.getGraphHistoricalDataPoints()
            if (r5 == 0) goto L_0x0078
            java.lang.Object r5 = kotlin.collections.CollectionsKt.lastOrNull(r5)
            com.github.mikephil.charting.data.Entry r5 = (com.github.mikephil.charting.data.Entry) r5
            if (r5 == 0) goto L_0x0078
            float r5 = r5.getX()
            goto L_0x0079
        L_0x0078:
            r5 = 0
        L_0x0079:
            if (r0 == 0) goto L_0x008b
            java.util.Set r7 = r23.getTimeStampFilter()
            if (r7 == 0) goto L_0x0086
            java.util.List r7 = r23.getGraphHistoricalDataPoints()
            goto L_0x008d
        L_0x0086:
            java.util.List r7 = r23.getGraphReducedHistoricalDataPoints()
            goto L_0x008d
        L_0x008b:
            r7 = r21
        L_0x008d:
            if (r0 == 0) goto L_0x0092
            r0 = r21
            goto L_0x0096
        L_0x0092:
            java.util.List r0 = r23.getGraphRealTimeDataPoints()
        L_0x0096:
            r10 = 0
            if (r0 == 0) goto L_0x00d2
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Collection r11 = (java.util.Collection) r11
            java.util.Iterator r0 = r0.iterator()
        L_0x00a6:
            boolean r12 = r0.hasNext()
            if (r12 == 0) goto L_0x00cf
            java.lang.Object r12 = r0.next()
            r13 = r12
            com.github.mikephil.charting.data.Entry r13 = (com.github.mikephil.charting.data.Entry) r13
            boolean r14 = r13 instanceof com.blueair.graph.viewmodel.GraphEntry
            if (r14 == 0) goto L_0x00c3
            com.blueair.graph.viewmodel.GraphEntry r13 = (com.blueair.graph.viewmodel.GraphEntry) r13
            long r13 = r13.getXx()
            float r13 = (float) r13
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 <= 0) goto L_0x00a6
            goto L_0x00cb
        L_0x00c3:
            float r13 = r13.getX()
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 <= 0) goto L_0x00a6
        L_0x00cb:
            r11.add(r12)
            goto L_0x00a6
        L_0x00cf:
            java.util.List r11 = (java.util.List) r11
            goto L_0x00d3
        L_0x00d2:
            r11 = r10
        L_0x00d3:
            com.blueair.graph.viewmodel.GraphViewModel$$ExternalSyntheticLambda4 r0 = new com.blueair.graph.viewmodel.GraphViewModel$$ExternalSyntheticLambda4
            r0.<init>(r2)
            r5 = r7
            java.util.Collection r5 = (java.util.Collection) r5
            if (r5 == 0) goto L_0x00e3
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x00f0
        L_0x00e3:
            r5 = r11
            java.util.Collection r5 = (java.util.Collection) r5
            if (r5 == 0) goto L_0x0183
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x00f0
            goto L_0x0183
        L_0x00f0:
            if (r7 != 0) goto L_0x00f7
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x00f8
        L_0x00f7:
            r5 = r7
        L_0x00f8:
            java.util.Collection r5 = (java.util.Collection) r5
            if (r11 == 0) goto L_0x0100
            r12 = r11
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            goto L_0x0106
        L_0x0100:
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()
            java.lang.Iterable r12 = (java.lang.Iterable) r12
        L_0x0106:
            java.util.List r5 = kotlin.collections.CollectionsKt.plus(r5, r12)
            java.util.Set r12 = r23.getTimeStampFilter()
            if (r12 == 0) goto L_0x015a
            timber.log.Timber$Forest r12 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "updateGraphDataPoints: filter timeStamps, "
            r13.<init>(r14)
            java.lang.String r14 = r1.name
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.Object[] r14 = new java.lang.Object[r6]
            r12.v(r13, r14)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.Iterator r5 = r5.iterator()
        L_0x0134:
            boolean r13 = r5.hasNext()
            if (r13 == 0) goto L_0x0157
            java.lang.Object r13 = r5.next()
            r14 = r13
            com.github.mikephil.charting.data.Entry r14 = (com.github.mikephil.charting.data.Entry) r14
            java.util.Set r15 = r23.getTimeStampFilter()
            float r14 = r14.getX()
            java.lang.Float r14 = java.lang.Float.valueOf(r14)
            boolean r14 = r15.contains(r14)
            if (r14 == 0) goto L_0x0134
            r12.add(r13)
            goto L_0x0134
        L_0x0157:
            r5 = r12
            java.util.List r5 = (java.util.List) r5
        L_0x015a:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.Iterator r5 = r5.iterator()
        L_0x0167:
            boolean r13 = r5.hasNext()
            if (r13 == 0) goto L_0x017f
            java.lang.Object r13 = r5.next()
            com.github.mikephil.charting.data.Entry r13 = (com.github.mikephil.charting.data.Entry) r13
            java.lang.Object r13 = r0.invoke(r13)
            com.github.mikephil.charting.data.Entry r13 = (com.github.mikephil.charting.data.Entry) r13
            if (r13 == 0) goto L_0x0167
            r12.add(r13)
            goto L_0x0167
        L_0x017f:
            java.util.List r12 = (java.util.List) r12
            r5 = r12
            goto L_0x0184
        L_0x0183:
            r5 = r10
        L_0x0184:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "updateGraphDataPoints: combinedRelativeTimedDataPoints.size = "
            r12.<init>(r13)
            if (r5 == 0) goto L_0x0197
            int r10 = r5.size()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
        L_0x0197:
            r12.append(r10)
            r12.append(r4)
            java.lang.String r4 = r1.name
            r12.append(r4)
            java.lang.String r4 = r12.toString()
            java.lang.Object[] r10 = new java.lang.Object[r6]
            r0.v(r4, r10)
            java.util.List r0 = r23.getGraphRelativeTimedDataPoints()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x01d9
            r12 = r1
            kotlinx.coroutines.CoroutineScope r12 = (kotlinx.coroutines.CoroutineScope) r12
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()
            r13 = r0
            kotlin.coroutines.CoroutineContext r13 = (kotlin.coroutines.CoroutineContext) r13
            com.blueair.graph.viewmodel.GraphViewModel$updateGraphDataPoints$1 r0 = new com.blueair.graph.viewmodel.GraphViewModel$updateGraphDataPoints$1
            r10 = 0
            r18 = r2
            r3 = r7
            r6 = r18
            r2 = r23
            r4 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10)
            r15 = r0
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r16 = 2
            r17 = 0
            r14 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r12, r13, r14, r15, r16, r17)
            return
        L_0x01d9:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "updateGraphDataPoints: IGNORE since same data, name = "
            r2.<init>(r3)
            java.lang.String r3 = r1.name
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r0.d(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.viewmodel.GraphViewModel.updateGraphDataPoints(java.util.List, boolean, com.blueair.graph.viewmodel.GraphState):void");
    }

    /* access modifiers changed from: private */
    public static final Entry updateGraphDataPoints$lambda$12(long j, Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "e");
        if (entry instanceof GraphEntry) {
            GraphEntry graphEntry = (GraphEntry) entry;
            if (graphEntry.getXx() >= j) {
                return new Entry((float) (graphEntry.getXx() - j), graphEntry.getYy());
            }
            return null;
        }
        float f = (float) j;
        if (entry.getX() >= f) {
            return new Entry(entry.getX() - f, entry.getY());
        }
        return null;
    }

    static /* synthetic */ void updateState$default(GraphViewModel graphViewModel, GraphState graphState, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        graphViewModel.updateState(graphState, z);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateState(com.blueair.graph.viewmodel.GraphState r32, boolean r33) {
        /*
            r31 = this;
            r1 = r31
            java.lang.String r0 = "updateState, \nfinalState.graphRelativeTimedDataPoints.isNull() = "
            java.lang.String r2 = "updateState, \nnuState.graphRelativeTimedDataPoints.isNull() = "
            java.lang.Object r3 = r1.getStateLock()
            monitor-enter(r3)
            android.os.Parcelable r4 = r1.getState()     // Catch:{ all -> 0x0113 }
            com.blueair.graph.viewmodel.GraphState r4 = (com.blueair.graph.viewmodel.GraphState) r4     // Catch:{ all -> 0x0113 }
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest     // Catch:{ all -> 0x0113 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            r6.<init>(r2)     // Catch:{ all -> 0x0113 }
            java.util.List r2 = r32.getGraphRelativeTimedDataPoints()     // Catch:{ all -> 0x0113 }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x0113 }
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L_0x002b
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0113 }
            if (r2 == 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r2 = r8
            goto L_0x002c
        L_0x002b:
            r2 = r7
        L_0x002c:
            r6.append(r2)     // Catch:{ all -> 0x0113 }
            java.lang.String r2 = ", nuState.compareGraphDataPoints.isNull() = "
            r6.append(r2)     // Catch:{ all -> 0x0113 }
            java.util.List r2 = r32.getCompareGraphDataPoints()     // Catch:{ all -> 0x0113 }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x0113 }
            if (r2 == 0) goto L_0x0045
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0113 }
            if (r2 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r2 = r8
            goto L_0x0046
        L_0x0045:
            r2 = r7
        L_0x0046:
            r6.append(r2)     // Catch:{ all -> 0x0113 }
            java.lang.String r2 = ", \noldState.graphRelativeTimedDataPoints.isNull() = "
            r6.append(r2)     // Catch:{ all -> 0x0113 }
            java.util.List r2 = r4.getGraphRelativeTimedDataPoints()     // Catch:{ all -> 0x0113 }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x0113 }
            if (r2 == 0) goto L_0x005f
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0113 }
            if (r2 == 0) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            r2 = r8
            goto L_0x0060
        L_0x005f:
            r2 = r7
        L_0x0060:
            r6.append(r2)     // Catch:{ all -> 0x0113 }
            java.lang.String r2 = ", oldState.compareGraphDataPoints.isNull() = "
            r6.append(r2)     // Catch:{ all -> 0x0113 }
            java.util.List r2 = r4.getCompareGraphDataPoints()     // Catch:{ all -> 0x0113 }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x0113 }
            if (r2 == 0) goto L_0x0079
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0113 }
            if (r2 == 0) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            r2 = r8
            goto L_0x007a
        L_0x0079:
            r2 = r7
        L_0x007a:
            r6.append(r2)     // Catch:{ all -> 0x0113 }
            java.lang.String r2 = ", \nname = "
            r6.append(r2)     // Catch:{ all -> 0x0113 }
            java.lang.String r2 = r1.name     // Catch:{ all -> 0x0113 }
            r6.append(r2)     // Catch:{ all -> 0x0113 }
            java.lang.String r2 = r6.toString()     // Catch:{ all -> 0x0113 }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x0113 }
            r5.v(r2, r6)     // Catch:{ all -> 0x0113 }
            if (r33 == 0) goto L_0x009b
            com.blueair.graph.viewmodel.GraphMergeable r4 = (com.blueair.graph.viewmodel.GraphMergeable) r4     // Catch:{ all -> 0x0113 }
            r2 = r32
            com.blueair.graph.viewmodel.GraphState r2 = r2.merge(r4)     // Catch:{ all -> 0x0113 }
            goto L_0x009d
        L_0x009b:
            r2 = r32
        L_0x009d:
            r9 = r2
            com.github.mikephil.charting.data.Entry r16 = r1.getTempLastSelectedEntry()     // Catch:{ all -> 0x0113 }
            r29 = 65471(0xffbf, float:9.1744E-41)
            r30 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r28 = 0
            com.blueair.graph.viewmodel.GraphState r2 = com.blueair.graph.viewmodel.GraphState.copy$default(r9, r10, r11, r12, r13, r14, r15, r16, r17, r19, r21, r22, r23, r24, r25, r26, r28, r29, r30)     // Catch:{ all -> 0x0113 }
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest     // Catch:{ all -> 0x0113 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            r5.<init>(r0)     // Catch:{ all -> 0x0113 }
            java.util.List r0 = r2.getGraphRelativeTimedDataPoints()     // Catch:{ all -> 0x0113 }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ all -> 0x0113 }
            if (r0 == 0) goto L_0x00db
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0113 }
            if (r0 == 0) goto L_0x00d9
            goto L_0x00db
        L_0x00d9:
            r0 = r8
            goto L_0x00dc
        L_0x00db:
            r0 = r7
        L_0x00dc:
            r5.append(r0)     // Catch:{ all -> 0x0113 }
            java.lang.String r0 = ", finalState.compareGraphDataPoints.isNull() = "
            r5.append(r0)     // Catch:{ all -> 0x0113 }
            java.util.List r0 = r2.getCompareGraphDataPoints()     // Catch:{ all -> 0x0113 }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ all -> 0x0113 }
            if (r0 == 0) goto L_0x00f4
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0113 }
            if (r0 == 0) goto L_0x00f3
            goto L_0x00f4
        L_0x00f3:
            r7 = r8
        L_0x00f4:
            r5.append(r7)     // Catch:{ all -> 0x0113 }
            java.lang.String r0 = ", \nname = "
            r5.append(r0)     // Catch:{ all -> 0x0113 }
            java.lang.String r0 = r1.name     // Catch:{ all -> 0x0113 }
            r5.append(r0)     // Catch:{ all -> 0x0113 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0113 }
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ all -> 0x0113 }
            r4.v(r0, r5)     // Catch:{ all -> 0x0113 }
            android.os.Parcelable r2 = (android.os.Parcelable) r2     // Catch:{ all -> 0x0113 }
            r1.setState(r2)     // Catch:{ all -> 0x0113 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0113 }
            monitor-exit(r3)
            return
        L_0x0113:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.viewmodel.GraphViewModel.updateState(com.blueair.graph.viewmodel.GraphState, boolean):void");
    }

    private final Entry getCompareDataPointForEntry(Entry entry) {
        Object obj;
        List<Entry> compareGraphDataPoints = ((GraphState) getState()).getCompareGraphDataPoints();
        if (compareGraphDataPoints != null) {
            Iterator it = compareGraphDataPoints.iterator();
            if (!it.hasNext()) {
                obj = null;
            } else {
                obj = it.next();
                if (it.hasNext()) {
                    float abs = Math.abs(((Entry) obj).getX() - entry.getX());
                    do {
                        Object next = it.next();
                        float abs2 = Math.abs(((Entry) next).getX() - entry.getX());
                        if (Float.compare(abs, abs2) > 0) {
                            obj = next;
                            abs = abs2;
                        }
                    } while (it.hasNext());
                }
            }
            Entry entry2 = (Entry) obj;
            if (entry2 == null || Math.abs(entry2.getX() - entry.getX()) >= ((float) 3600000)) {
                return null;
            }
            return entry2;
        }
        return null;
    }

    public final ReversedResult reverseRelativelyTimedEntryToDataPoint(Entry entry) {
        SimpleDatapoint simpleDatapoint;
        Entry compareDataPointForEntry;
        Intrinsics.checkNotNullParameter(entry, "entry");
        Entry entry2 = new Entry(entry.getX() + ((float) getStartingTimeInMillis()), entry.getY());
        if (this.outdoor) {
            simpleDatapoint = reverseOutdoorEntryToDataPoint(entry2);
        } else {
            simpleDatapoint = reverseIndoorEntryToDataPoint(((long) entry.getX()) + getStartingTimeInMillis(), entry.getY());
        }
        SimpleDatapoint simpleDatapoint2 = null;
        if (simpleDatapoint == null) {
            return null;
        }
        if (!(this.outdoor || PollutantType.Companion.fromSensorType(getSensorType$graph_otherRelease()) == null || (compareDataPointForEntry = getCompareDataPointForEntry(entry2)) == null)) {
            simpleDatapoint2 = reverseIndoorEntryToDataPoint((long) compareDataPointForEntry.getX(), compareDataPointForEntry.getY());
        }
        return new ReversedResult(simpleDatapoint, simpleDatapoint2);
    }

    private final SimpleDatapoint reverseIndoorEntryToDataPoint(long j, float f) {
        return reverseEntryToDataPoint(j, MpChartUtils.INSTANCE.getRealValueFromScaledChartValue(f, getSensorType$graph_otherRelease(), isCelsius$graph_otherRelease(), getDeviceRatings().airRatingsFor(getSensorType$graph_otherRelease())));
    }

    private final SimpleDatapoint reverseOutdoorEntryToDataPoint(Entry entry) {
        return reverseEntryToDataPoint((long) entry.getX(), MpOutdoorChartUtils.INSTANCE.getRealValueFromScaledChartValueOutdoor((double) entry.getY(), OutdoorAirRatingRanges.INSTANCE.airRatingsFor(getPollutantType$graph_otherRelease()).getHigh()));
    }

    private final SimpleDatapoint reverseEntryToDataPoint(long j, double d) {
        SimpleDatapoint simpleDatapoint = new SimpleDatapoint(j / ((long) 1000), (float) d);
        Timber.Forest forest = Timber.Forest;
        forest.v("reverseEntryToDataPoint: entry = " + j + " ; dp = " + simpleDatapoint, new Object[0]);
        return simpleDatapoint;
    }

    public GraphState onSaveState() {
        ChartTimeScale timeScale = ((GraphState) getState()).getTimeScale();
        int typeCode = ((GraphState) getState()).getTypeCode();
        return new GraphState((List) null, (List) null, (List) null, (List) null, (List) null, (Set) null, ((GraphState) getState()).getLastSelectedEntry(), ((GraphState) getState()).getStartingTimeInMillis(), ((GraphState) getState()).getLatestTimeInMillis(), timeScale, typeCode, ((GraphState) getState()).getNumberOfRanges(), ((GraphState) getState()).getMaxThresholds(), ((GraphState) getState()).isCelsius(), 0, (IndoorAirRatingRanges) null, 49215, (DefaultConstructorMarker) null);
    }
}
