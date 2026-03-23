package com.blueair.graph.viewmodel;

import com.github.mikephil.charting.data.Entry;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/blueair/graph/viewmodel/GraphMergeable;", "", "graphHistoricalDataPoints", "", "Lcom/github/mikephil/charting/data/Entry;", "getGraphHistoricalDataPoints", "()Ljava/util/List;", "graphReducedHistoricalDataPoints", "getGraphReducedHistoricalDataPoints", "graphRealTimeDataPoints", "getGraphRealTimeDataPoints", "graphRelativeTimedDataPoints", "getGraphRelativeTimedDataPoints", "compareGraphDataPoints", "getCompareGraphDataPoints", "timeStampFilter", "", "", "getTimeStampFilter", "()Ljava/util/Set;", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GraphViewModel.kt */
public interface GraphMergeable {
    List<Entry> getCompareGraphDataPoints();

    List<Entry> getGraphHistoricalDataPoints();

    List<Entry> getGraphRealTimeDataPoints();

    List<Entry> getGraphReducedHistoricalDataPoints();

    List<Entry> getGraphRelativeTimedDataPoints();

    Set<Float> getTimeStampFilter();
}
