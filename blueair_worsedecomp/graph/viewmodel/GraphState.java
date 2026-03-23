package com.blueair.graph.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.PollutantType;
import com.blueair.core.model.SensorType;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.graph.utils.ChartTimeScale;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0001iBß\u0001\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020\u0002J\u0011\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0011\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0011\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0011\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0011\u0010Q\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u000fHÆ\u0003J\t\u0010T\u001a\u00020\u000fHÆ\u0003J\t\u0010U\u001a\u00020\u0012HÆ\u0003J\t\u0010V\u001a\u00020\u0014HÆ\u0003J\t\u0010W\u001a\u00020\u0014HÆ\u0003J\u000f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004HÆ\u0003J\t\u0010Y\u001a\u00020\u0019HÆ\u0003J\t\u0010Z\u001a\u00020\u000fHÆ\u0003J\t\u0010[\u001a\u00020\u001cHÆ\u0003Já\u0001\u0010\\\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u001cHÆ\u0001J\u0006\u0010]\u001a\u00020\u0014J\u0013\u0010^\u001a\u00020\u00192\b\u0010_\u001a\u0004\u0018\u00010`HÖ\u0003J\t\u0010a\u001a\u00020\u0014HÖ\u0001J\t\u0010b\u001a\u00020cHÖ\u0001J\u0016\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\u0014R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u001c\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0015\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u00102R\u0011\u0010\u001a\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b3\u0010*R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R!\u00106\u001a\u00020\u00198FX\u0002¢\u0006\u0012\n\u0004\b:\u0010;\u0012\u0004\b7\u00108\u001a\u0004\b9\u00102R\u0017\u0010<\u001a\u00020=8F¢\u0006\f\u0012\u0004\b>\u00108\u001a\u0004\b?\u0010@R\u0017\u0010A\u001a\u00020B8F¢\u0006\f\u0012\u0004\bC\u00108\u001a\u0004\bD\u0010ER#\u0010F\u001a\u0004\u0018\u00010\u00058FX\u0002¢\u0006\u0012\n\u0004\bI\u0010;\u0012\u0004\bG\u00108\u001a\u0004\bH\u0010(¨\u0006j"}, d2 = {"Lcom/blueair/graph/viewmodel/GraphState;", "Landroid/os/Parcelable;", "Lcom/blueair/graph/viewmodel/GraphMergeable;", "graphHistoricalDataPoints", "", "Lcom/github/mikephil/charting/data/Entry;", "graphReducedHistoricalDataPoints", "graphRealTimeDataPoints", "graphRelativeTimedDataPoints", "compareGraphDataPoints", "timeStampFilter", "", "", "lastSelectedEntry", "startingTimeInMillis", "", "latestTimeInMillis", "timeScale", "Lcom/blueair/graph/utils/ChartTimeScale;", "typeCode", "", "numberOfRanges", "maxThresholds", "", "isCelsius", "", "timeStamp", "deviceRatings", "Lcom/blueair/core/util/IndoorAirRatingRanges;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Set;Lcom/github/mikephil/charting/data/Entry;JJLcom/blueair/graph/utils/ChartTimeScale;IILjava/util/List;ZJLcom/blueair/core/util/IndoorAirRatingRanges;)V", "getGraphHistoricalDataPoints", "()Ljava/util/List;", "getGraphReducedHistoricalDataPoints", "getGraphRealTimeDataPoints", "getGraphRelativeTimedDataPoints", "getCompareGraphDataPoints", "getTimeStampFilter", "()Ljava/util/Set;", "getLastSelectedEntry", "()Lcom/github/mikephil/charting/data/Entry;", "getStartingTimeInMillis", "()J", "getLatestTimeInMillis", "getTimeScale", "()Lcom/blueair/graph/utils/ChartTimeScale;", "getTypeCode", "()I", "getNumberOfRanges", "getMaxThresholds", "()Z", "getTimeStamp", "getDeviceRatings", "()Lcom/blueair/core/util/IndoorAirRatingRanges;", "shouldShowGraph", "getShouldShowGraph$annotations", "()V", "getShouldShowGraph", "shouldShowGraph$delegate", "Lkotlin/Lazy;", "pollutantType", "Lcom/blueair/core/model/PollutantType;", "getPollutantType$annotations", "getPollutantType", "()Lcom/blueair/core/model/PollutantType;", "sensorType", "Lcom/blueair/core/model/SensorType;", "getSensorType$annotations", "getSensorType", "()Lcom/blueair/core/model/SensorType;", "relativelyTimedLastSelectedEntry", "getRelativelyTimedLastSelectedEntry$annotations", "getRelativelyTimedLastSelectedEntry", "relativelyTimedLastSelectedEntry$delegate", "merge", "right", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GraphViewModel.kt */
public final class GraphState implements Parcelable, GraphMergeable {
    public static final Parcelable.Creator<GraphState> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<Entry> compareGraphDataPoints;
    private final IndoorAirRatingRanges deviceRatings;
    private final List<Entry> graphHistoricalDataPoints;
    private final List<Entry> graphRealTimeDataPoints;
    private final List<Entry> graphReducedHistoricalDataPoints;
    private final List<Entry> graphRelativeTimedDataPoints;
    private final boolean isCelsius;
    private final Entry lastSelectedEntry;
    private final long latestTimeInMillis;
    private final List<Double> maxThresholds;
    private final int numberOfRanges;
    private final Lazy relativelyTimedLastSelectedEntry$delegate;
    private final Lazy shouldShowGraph$delegate;
    private final long startingTimeInMillis;
    private final ChartTimeScale timeScale;
    private final long timeStamp;
    private final Set<Float> timeStampFilter;
    private final int typeCode;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GraphViewModel.kt */
    public static final class Creator implements Parcelable.Creator<GraphState> {
        public final GraphState createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            ArrayList arrayList4;
            ArrayList arrayList5;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            LinkedHashSet linkedHashSet = null;
            boolean z = false;
            if (parcel2.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel2.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(parcel2.readParcelable(GraphState.class.getClassLoader()));
                }
            }
            List list = arrayList;
            if (parcel2.readInt() == 0) {
                arrayList2 = null;
            } else {
                int readInt2 = parcel2.readInt();
                arrayList2 = new ArrayList(readInt2);
                for (int i2 = 0; i2 != readInt2; i2++) {
                    arrayList2.add(parcel2.readParcelable(GraphState.class.getClassLoader()));
                }
            }
            List list2 = arrayList2;
            if (parcel2.readInt() == 0) {
                arrayList3 = null;
            } else {
                int readInt3 = parcel2.readInt();
                arrayList3 = new ArrayList(readInt3);
                for (int i3 = 0; i3 != readInt3; i3++) {
                    arrayList3.add(parcel2.readParcelable(GraphState.class.getClassLoader()));
                }
            }
            List list3 = arrayList3;
            if (parcel2.readInt() == 0) {
                arrayList4 = null;
            } else {
                int readInt4 = parcel2.readInt();
                arrayList4 = new ArrayList(readInt4);
                for (int i4 = 0; i4 != readInt4; i4++) {
                    arrayList4.add(parcel2.readParcelable(GraphState.class.getClassLoader()));
                }
            }
            List list4 = arrayList4;
            if (parcel2.readInt() == 0) {
                arrayList5 = null;
            } else {
                int readInt5 = parcel2.readInt();
                arrayList5 = new ArrayList(readInt5);
                for (int i5 = 0; i5 != readInt5; i5++) {
                    arrayList5.add(parcel2.readParcelable(GraphState.class.getClassLoader()));
                }
            }
            List list5 = arrayList5;
            if (parcel2.readInt() != 0) {
                int readInt6 = parcel2.readInt();
                linkedHashSet = new LinkedHashSet(readInt6);
                for (int i6 = 0; i6 != readInt6; i6++) {
                    linkedHashSet.add(Float.valueOf(parcel2.readFloat()));
                }
            }
            Set set = linkedHashSet;
            Entry entry = (Entry) parcel2.readParcelable(GraphState.class.getClassLoader());
            long readLong = parcel2.readLong();
            long readLong2 = parcel2.readLong();
            ChartTimeScale valueOf = ChartTimeScale.valueOf(parcel2.readString());
            int readInt7 = parcel2.readInt();
            int readInt8 = parcel2.readInt();
            int readInt9 = parcel2.readInt();
            ArrayList arrayList6 = new ArrayList(readInt9);
            for (int i7 = 0; i7 != readInt9; i7++) {
                arrayList6.add(Double.valueOf(parcel2.readDouble()));
            }
            List list6 = arrayList6;
            if (parcel2.readInt() != 0) {
                z = true;
            }
            return new GraphState(list, list2, list3, list4, list5, set, entry, readLong, readLong2, valueOf, readInt7, readInt8, list6, z, parcel2.readLong(), (IndoorAirRatingRanges) parcel2.readParcelable(GraphState.class.getClassLoader()));
        }

        public final GraphState[] newArray(int i) {
            return new GraphState[i];
        }
    }

    public GraphState() {
        this((List) null, (List) null, (List) null, (List) null, (List) null, (Set) null, (Entry) null, 0, 0, (ChartTimeScale) null, 0, 0, (List) null, false, 0, (IndoorAirRatingRanges) null, 65535, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GraphState copy$default(GraphState graphState, List list, List list2, List list3, List list4, List list5, Set set, Entry entry, long j, long j2, ChartTimeScale chartTimeScale, int i, int i2, List list6, boolean z, long j3, IndoorAirRatingRanges indoorAirRatingRanges, int i3, Object obj) {
        IndoorAirRatingRanges indoorAirRatingRanges2;
        long j4;
        GraphState graphState2 = graphState;
        int i4 = i3;
        List list7 = (i4 & 1) != 0 ? graphState2.graphHistoricalDataPoints : list;
        List list8 = (i4 & 2) != 0 ? graphState2.graphReducedHistoricalDataPoints : list2;
        List list9 = (i4 & 4) != 0 ? graphState2.graphRealTimeDataPoints : list3;
        List list10 = (i4 & 8) != 0 ? graphState2.graphRelativeTimedDataPoints : list4;
        List list11 = (i4 & 16) != 0 ? graphState2.compareGraphDataPoints : list5;
        Set set2 = (i4 & 32) != 0 ? graphState2.timeStampFilter : set;
        Entry entry2 = (i4 & 64) != 0 ? graphState2.lastSelectedEntry : entry;
        long j5 = (i4 & 128) != 0 ? graphState2.startingTimeInMillis : j;
        long j6 = (i4 & 256) != 0 ? graphState2.latestTimeInMillis : j2;
        ChartTimeScale chartTimeScale2 = (i4 & 512) != 0 ? graphState2.timeScale : chartTimeScale;
        int i5 = (i4 & 1024) != 0 ? graphState2.typeCode : i;
        int i6 = (i4 & 2048) != 0 ? graphState2.numberOfRanges : i2;
        List list12 = list7;
        List list13 = (i4 & 4096) != 0 ? graphState2.maxThresholds : list6;
        boolean z2 = (i4 & 8192) != 0 ? graphState2.isCelsius : z;
        long j7 = (i4 & 16384) != 0 ? graphState2.timeStamp : j3;
        if ((i3 & 32768) != 0) {
            j4 = j7;
            indoorAirRatingRanges2 = graphState2.deviceRatings;
        } else {
            indoorAirRatingRanges2 = indoorAirRatingRanges;
            j4 = j7;
        }
        return graphState2.copy(list12, list8, list9, list10, list11, set2, entry2, j5, j6, chartTimeScale2, i5, i6, list13, z2, j4, indoorAirRatingRanges2);
    }

    public static /* synthetic */ void getPollutantType$annotations() {
    }

    public static /* synthetic */ void getRelativelyTimedLastSelectedEntry$annotations() {
    }

    public static /* synthetic */ void getSensorType$annotations() {
    }

    public static /* synthetic */ void getShouldShowGraph$annotations() {
    }

    public final List<Entry> component1() {
        return this.graphHistoricalDataPoints;
    }

    public final ChartTimeScale component10() {
        return this.timeScale;
    }

    public final int component11() {
        return this.typeCode;
    }

    public final int component12() {
        return this.numberOfRanges;
    }

    public final List<Double> component13() {
        return this.maxThresholds;
    }

    public final boolean component14() {
        return this.isCelsius;
    }

    public final long component15() {
        return this.timeStamp;
    }

    public final IndoorAirRatingRanges component16() {
        return this.deviceRatings;
    }

    public final List<Entry> component2() {
        return this.graphReducedHistoricalDataPoints;
    }

    public final List<Entry> component3() {
        return this.graphRealTimeDataPoints;
    }

    public final List<Entry> component4() {
        return this.graphRelativeTimedDataPoints;
    }

    public final List<Entry> component5() {
        return this.compareGraphDataPoints;
    }

    public final Set<Float> component6() {
        return this.timeStampFilter;
    }

    public final Entry component7() {
        return this.lastSelectedEntry;
    }

    public final long component8() {
        return this.startingTimeInMillis;
    }

    public final long component9() {
        return this.latestTimeInMillis;
    }

    public final GraphState copy(List<? extends Entry> list, List<? extends Entry> list2, List<? extends Entry> list3, List<? extends Entry> list4, List<? extends Entry> list5, Set<Float> set, Entry entry, long j, long j2, ChartTimeScale chartTimeScale, int i, int i2, List<Double> list6, boolean z, long j3, IndoorAirRatingRanges indoorAirRatingRanges) {
        ChartTimeScale chartTimeScale2 = chartTimeScale;
        Intrinsics.checkNotNullParameter(chartTimeScale2, "timeScale");
        Intrinsics.checkNotNullParameter(list6, "maxThresholds");
        IndoorAirRatingRanges indoorAirRatingRanges2 = indoorAirRatingRanges;
        Intrinsics.checkNotNullParameter(indoorAirRatingRanges2, "deviceRatings");
        IndoorAirRatingRanges indoorAirRatingRanges3 = indoorAirRatingRanges2;
        return new GraphState(list, list2, list3, list4, list5, set, entry, j, j2, chartTimeScale2, i, i2, list6, z, j3, indoorAirRatingRanges3);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GraphState)) {
            return false;
        }
        GraphState graphState = (GraphState) obj;
        return Intrinsics.areEqual((Object) this.graphHistoricalDataPoints, (Object) graphState.graphHistoricalDataPoints) && Intrinsics.areEqual((Object) this.graphReducedHistoricalDataPoints, (Object) graphState.graphReducedHistoricalDataPoints) && Intrinsics.areEqual((Object) this.graphRealTimeDataPoints, (Object) graphState.graphRealTimeDataPoints) && Intrinsics.areEqual((Object) this.graphRelativeTimedDataPoints, (Object) graphState.graphRelativeTimedDataPoints) && Intrinsics.areEqual((Object) this.compareGraphDataPoints, (Object) graphState.compareGraphDataPoints) && Intrinsics.areEqual((Object) this.timeStampFilter, (Object) graphState.timeStampFilter) && Intrinsics.areEqual((Object) this.lastSelectedEntry, (Object) graphState.lastSelectedEntry) && this.startingTimeInMillis == graphState.startingTimeInMillis && this.latestTimeInMillis == graphState.latestTimeInMillis && this.timeScale == graphState.timeScale && this.typeCode == graphState.typeCode && this.numberOfRanges == graphState.numberOfRanges && Intrinsics.areEqual((Object) this.maxThresholds, (Object) graphState.maxThresholds) && this.isCelsius == graphState.isCelsius && this.timeStamp == graphState.timeStamp && Intrinsics.areEqual((Object) this.deviceRatings, (Object) graphState.deviceRatings);
    }

    public int hashCode() {
        List<Entry> list = this.graphHistoricalDataPoints;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<Entry> list2 = this.graphReducedHistoricalDataPoints;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<Entry> list3 = this.graphRealTimeDataPoints;
        int hashCode3 = (hashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<Entry> list4 = this.graphRelativeTimedDataPoints;
        int hashCode4 = (hashCode3 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<Entry> list5 = this.compareGraphDataPoints;
        int hashCode5 = (hashCode4 + (list5 == null ? 0 : list5.hashCode())) * 31;
        Set<Float> set = this.timeStampFilter;
        int hashCode6 = (hashCode5 + (set == null ? 0 : set.hashCode())) * 31;
        Entry entry = this.lastSelectedEntry;
        if (entry != null) {
            i = entry.hashCode();
        }
        return ((((((((((((((((((hashCode6 + i) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.startingTimeInMillis)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.latestTimeInMillis)) * 31) + this.timeScale.hashCode()) * 31) + this.typeCode) * 31) + this.numberOfRanges) * 31) + this.maxThresholds.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isCelsius)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.timeStamp)) * 31) + this.deviceRatings.hashCode();
    }

    public String toString() {
        return "GraphState(graphHistoricalDataPoints=" + this.graphHistoricalDataPoints + ", graphReducedHistoricalDataPoints=" + this.graphReducedHistoricalDataPoints + ", graphRealTimeDataPoints=" + this.graphRealTimeDataPoints + ", graphRelativeTimedDataPoints=" + this.graphRelativeTimedDataPoints + ", compareGraphDataPoints=" + this.compareGraphDataPoints + ", timeStampFilter=" + this.timeStampFilter + ", lastSelectedEntry=" + this.lastSelectedEntry + ", startingTimeInMillis=" + this.startingTimeInMillis + ", latestTimeInMillis=" + this.latestTimeInMillis + ", timeScale=" + this.timeScale + ", typeCode=" + this.typeCode + ", numberOfRanges=" + this.numberOfRanges + ", maxThresholds=" + this.maxThresholds + ", isCelsius=" + this.isCelsius + ", timeStamp=" + this.timeStamp + ", deviceRatings=" + this.deviceRatings + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        List<Entry> list = this.graphHistoricalDataPoints;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (Entry writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i);
            }
        }
        List<Entry> list2 = this.graphReducedHistoricalDataPoints;
        if (list2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list2.size());
            for (Entry writeParcelable2 : list2) {
                parcel.writeParcelable(writeParcelable2, i);
            }
        }
        List<Entry> list3 = this.graphRealTimeDataPoints;
        if (list3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list3.size());
            for (Entry writeParcelable3 : list3) {
                parcel.writeParcelable(writeParcelable3, i);
            }
        }
        List<Entry> list4 = this.graphRelativeTimedDataPoints;
        if (list4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list4.size());
            for (Entry writeParcelable4 : list4) {
                parcel.writeParcelable(writeParcelable4, i);
            }
        }
        List<Entry> list5 = this.compareGraphDataPoints;
        if (list5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list5.size());
            for (Entry writeParcelable5 : list5) {
                parcel.writeParcelable(writeParcelable5, i);
            }
        }
        Set<Float> set = this.timeStampFilter;
        if (set == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(set.size());
            for (Float floatValue : set) {
                parcel.writeFloat(floatValue.floatValue());
            }
        }
        parcel.writeParcelable(this.lastSelectedEntry, i);
        parcel.writeLong(this.startingTimeInMillis);
        parcel.writeLong(this.latestTimeInMillis);
        parcel.writeString(this.timeScale.name());
        parcel.writeInt(this.typeCode);
        parcel.writeInt(this.numberOfRanges);
        List<Double> list6 = this.maxThresholds;
        parcel.writeInt(list6.size());
        for (Double doubleValue : list6) {
            parcel.writeDouble(doubleValue.doubleValue());
        }
        parcel.writeInt(this.isCelsius ? 1 : 0);
        parcel.writeLong(this.timeStamp);
        parcel.writeParcelable(this.deviceRatings, i);
    }

    public GraphState(List<? extends Entry> list, List<? extends Entry> list2, List<? extends Entry> list3, List<? extends Entry> list4, List<? extends Entry> list5, Set<Float> set, Entry entry, long j, long j2, ChartTimeScale chartTimeScale, int i, int i2, List<Double> list6, boolean z, long j3, IndoorAirRatingRanges indoorAirRatingRanges) {
        ChartTimeScale chartTimeScale2 = chartTimeScale;
        List<Double> list7 = list6;
        IndoorAirRatingRanges indoorAirRatingRanges2 = indoorAirRatingRanges;
        Intrinsics.checkNotNullParameter(chartTimeScale2, "timeScale");
        Intrinsics.checkNotNullParameter(list7, "maxThresholds");
        Intrinsics.checkNotNullParameter(indoorAirRatingRanges2, "deviceRatings");
        this.graphHistoricalDataPoints = list;
        this.graphReducedHistoricalDataPoints = list2;
        this.graphRealTimeDataPoints = list3;
        this.graphRelativeTimedDataPoints = list4;
        this.compareGraphDataPoints = list5;
        this.timeStampFilter = set;
        this.lastSelectedEntry = entry;
        this.startingTimeInMillis = j;
        this.latestTimeInMillis = j2;
        this.timeScale = chartTimeScale2;
        this.typeCode = i;
        this.numberOfRanges = i2;
        this.maxThresholds = list7;
        this.isCelsius = z;
        this.timeStamp = j3;
        this.deviceRatings = indoorAirRatingRanges2;
        this.shouldShowGraph$delegate = LazyKt.lazy(new GraphState$$ExternalSyntheticLambda0(this));
        this.relativelyTimedLastSelectedEntry$delegate = LazyKt.lazy(new GraphState$$ExternalSyntheticLambda1(this));
    }

    public List<Entry> getGraphHistoricalDataPoints() {
        return this.graphHistoricalDataPoints;
    }

    public List<Entry> getGraphReducedHistoricalDataPoints() {
        return this.graphReducedHistoricalDataPoints;
    }

    public List<Entry> getGraphRealTimeDataPoints() {
        return this.graphRealTimeDataPoints;
    }

    public List<Entry> getGraphRelativeTimedDataPoints() {
        return this.graphRelativeTimedDataPoints;
    }

    public List<Entry> getCompareGraphDataPoints() {
        return this.compareGraphDataPoints;
    }

    public Set<Float> getTimeStampFilter() {
        return this.timeStampFilter;
    }

    public final Entry getLastSelectedEntry() {
        return this.lastSelectedEntry;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GraphState(java.util.List r68, java.util.List r69, java.util.List r70, java.util.List r71, java.util.List r72, java.util.Set r73, com.github.mikephil.charting.data.Entry r74, long r75, long r77, com.blueair.graph.utils.ChartTimeScale r79, int r80, int r81, java.util.List r82, boolean r83, long r84, com.blueair.core.util.IndoorAirRatingRanges r86, int r87, kotlin.jvm.internal.DefaultConstructorMarker r88) {
        /*
            r67 = this;
            r0 = r87
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r68
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r69
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r70
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r71
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r72
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r73
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r2 = r74
        L_0x003a:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x004a
            long r8 = java.lang.System.currentTimeMillis()
            com.blueair.graph.viewmodel.GraphViewModel$Companion r10 = com.blueair.graph.viewmodel.GraphViewModel.Companion
            long r10 = r10.getMONTH_IN_MILIS()
            long r8 = r8 - r10
            goto L_0x004c
        L_0x004a:
            r8 = r75
        L_0x004c:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0055
            long r10 = java.lang.System.currentTimeMillis()
            goto L_0x0057
        L_0x0055:
            r10 = r77
        L_0x0057:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0062
            com.blueair.graph.viewmodel.GraphViewModel$Companion r12 = com.blueair.graph.viewmodel.GraphViewModel.Companion
            com.blueair.graph.utils.ChartTimeScale r12 = r12.getDEFAULT_TIME_SCALE()
            goto L_0x0064
        L_0x0062:
            r12 = r79
        L_0x0064:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x006f
            com.blueair.core.model.PollutantType$AQI r13 = com.blueair.core.model.PollutantType.AQI.INSTANCE
            int r13 = r13.getCode()
            goto L_0x0071
        L_0x006f:
            r13 = r80
        L_0x0071:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0077
            r14 = 0
            goto L_0x0079
        L_0x0077:
            r14 = r81
        L_0x0079:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0082
            java.util.List r15 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0084
        L_0x0082:
            r15 = r82
        L_0x0084:
            r68 = r1
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x008c
            r1 = 1
            goto L_0x008e
        L_0x008c:
            r1 = r83
        L_0x008e:
            r69 = r1
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0097
            r16 = 0
            goto L_0x0099
        L_0x0097:
            r16 = r84
        L_0x0099:
            r1 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x010f
            com.blueair.core.util.IndoorAirRatingRanges$Companion r0 = com.blueair.core.util.IndoorAirRatingRanges.Companion
            com.blueair.core.model.DeviceG4 r18 = new com.blueair.core.model.DeviceG4
            r65 = 4095(0xfff, float:5.738E-42)
            r66 = 0
            java.lang.String r19 = ""
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r58 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r62 = 0
            r63 = 0
            r64 = -2
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66)
            r1 = r18
            com.blueair.core.model.HasSensorData r1 = (com.blueair.core.model.HasSensorData) r1
            com.blueair.core.util.IndoorAirRatingRanges r0 = r0.instance(r1)
            r87 = r0
            goto L_0x0111
        L_0x010f:
            r87 = r86
        L_0x0111:
            r84 = r69
            r75 = r2
            r70 = r3
            r71 = r4
            r72 = r5
            r73 = r6
            r74 = r7
            r76 = r8
            r78 = r10
            r80 = r12
            r81 = r13
            r82 = r14
            r83 = r15
            r85 = r16
            r69 = r68
            r68 = r67
            r68.<init>(r69, r70, r71, r72, r73, r74, r75, r76, r78, r80, r81, r82, r83, r84, r85, r87)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.viewmodel.GraphState.<init>(java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.Set, com.github.mikephil.charting.data.Entry, long, long, com.blueair.graph.utils.ChartTimeScale, int, int, java.util.List, boolean, long, com.blueair.core.util.IndoorAirRatingRanges, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final long getStartingTimeInMillis() {
        return this.startingTimeInMillis;
    }

    public final long getLatestTimeInMillis() {
        return this.latestTimeInMillis;
    }

    public final ChartTimeScale getTimeScale() {
        return this.timeScale;
    }

    public final int getTypeCode() {
        return this.typeCode;
    }

    public final int getNumberOfRanges() {
        return this.numberOfRanges;
    }

    public final List<Double> getMaxThresholds() {
        return this.maxThresholds;
    }

    public final boolean isCelsius() {
        return this.isCelsius;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final IndoorAirRatingRanges getDeviceRatings() {
        return this.deviceRatings;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/blueair/graph/viewmodel/GraphState$Companion;", "", "<init>", "()V", "indoorDefault", "Lcom/blueair/graph/viewmodel/GraphState;", "outdoorDefault", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GraphViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GraphState indoorDefault() {
            GraphState graphState = new GraphState((List) null, (List) null, (List) null, (List) null, (List) null, (Set) null, (Entry) null, 0, 0, (ChartTimeScale) null, 0, 0, (List) null, false, 0, (IndoorAirRatingRanges) null, 65535, (DefaultConstructorMarker) null);
            return GraphState.copy$default(graphState, (List) null, (List) null, (List) null, (List) null, (List) null, (Set) null, (Entry) null, 0, 0, ChartTimeScale.DAY, SensorType.PM25.ordinal(), 0, (List) null, false, 0, (IndoorAirRatingRanges) null, 63999, (Object) null);
        }

        public final GraphState outdoorDefault() {
            return new GraphState((List) null, (List) null, (List) null, (List) null, (List) null, (Set) null, (Entry) null, 0, 0, (ChartTimeScale) null, 0, 0, (List) null, false, 0, (IndoorAirRatingRanges) null, 65535, (DefaultConstructorMarker) null);
        }
    }

    public final boolean getShouldShowGraph() {
        return ((Boolean) this.shouldShowGraph$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean shouldShowGraph_delegate$lambda$0(GraphState graphState) {
        Collection graphRelativeTimedDataPoints2 = graphState.getGraphRelativeTimedDataPoints();
        return !(graphRelativeTimedDataPoints2 == null || graphRelativeTimedDataPoints2.isEmpty());
    }

    public final PollutantType getPollutantType() {
        return PollutantType.Companion.fromCode(this.typeCode);
    }

    public final SensorType getSensorType() {
        SensorType sensorType = (SensorType) ArraysKt.getOrNull((T[]) SensorType.values(), this.typeCode);
        return sensorType == null ? SensorType.PM25 : sensorType;
    }

    public final Entry getRelativelyTimedLastSelectedEntry() {
        return (Entry) this.relativelyTimedLastSelectedEntry$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Entry relativelyTimedLastSelectedEntry_delegate$lambda$2(GraphState graphState) {
        Entry entry = graphState.lastSelectedEntry;
        if (entry != null) {
            return new Entry(entry.getX() - ((float) graphState.startingTimeInMillis), entry.getY());
        }
        return null;
    }

    public final GraphState merge(GraphMergeable graphMergeable) {
        GraphMergeable graphMergeable2 = graphMergeable;
        Intrinsics.checkNotNullParameter(graphMergeable2, "right");
        List<Entry> graphHistoricalDataPoints2 = getGraphHistoricalDataPoints();
        if (graphHistoricalDataPoints2 == null) {
            graphHistoricalDataPoints2 = graphMergeable2.getGraphHistoricalDataPoints();
        }
        List<Entry> list = graphHistoricalDataPoints2;
        List<Entry> graphReducedHistoricalDataPoints2 = getGraphReducedHistoricalDataPoints();
        if (graphReducedHistoricalDataPoints2 == null) {
            graphReducedHistoricalDataPoints2 = graphMergeable2.getGraphReducedHistoricalDataPoints();
        }
        List<Entry> list2 = graphReducedHistoricalDataPoints2;
        List<Entry> graphRealTimeDataPoints2 = getGraphRealTimeDataPoints();
        if (graphRealTimeDataPoints2 == null) {
            graphRealTimeDataPoints2 = graphMergeable2.getGraphRealTimeDataPoints();
        }
        List<Entry> list3 = graphRealTimeDataPoints2;
        List<Entry> graphRelativeTimedDataPoints2 = getGraphRelativeTimedDataPoints();
        if (graphRelativeTimedDataPoints2 == null) {
            graphRelativeTimedDataPoints2 = graphMergeable2.getGraphRelativeTimedDataPoints();
        }
        List<Entry> list4 = graphRelativeTimedDataPoints2;
        List<Entry> compareGraphDataPoints2 = getCompareGraphDataPoints();
        if (compareGraphDataPoints2 == null) {
            compareGraphDataPoints2 = graphMergeable2.getCompareGraphDataPoints();
        }
        List<Entry> list5 = compareGraphDataPoints2;
        Set<Float> timeStampFilter2 = getTimeStampFilter();
        if (timeStampFilter2 == null) {
            timeStampFilter2 = graphMergeable2.getTimeStampFilter();
        }
        return copy$default(this, list, list2, list3, list4, list5, timeStampFilter2, (Entry) null, 0, 0, (ChartTimeScale) null, 0, 0, (List) null, false, 0, (IndoorAirRatingRanges) null, 65472, (Object) null);
    }
}
