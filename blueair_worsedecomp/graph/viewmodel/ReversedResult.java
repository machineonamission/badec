package com.blueair.graph.viewmodel;

import com.blueair.core.model.SimpleDatapoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/blueair/graph/viewmodel/ReversedResult;", "", "dataPoint", "Lcom/blueair/core/model/SimpleDatapoint;", "compareDataPoint", "<init>", "(Lcom/blueair/core/model/SimpleDatapoint;Lcom/blueair/core/model/SimpleDatapoint;)V", "getDataPoint", "()Lcom/blueair/core/model/SimpleDatapoint;", "getCompareDataPoint", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GraphViewModel.kt */
public final class ReversedResult {
    private final SimpleDatapoint compareDataPoint;
    private final SimpleDatapoint dataPoint;

    public static /* synthetic */ ReversedResult copy$default(ReversedResult reversedResult, SimpleDatapoint simpleDatapoint, SimpleDatapoint simpleDatapoint2, int i, Object obj) {
        if ((i & 1) != 0) {
            simpleDatapoint = reversedResult.dataPoint;
        }
        if ((i & 2) != 0) {
            simpleDatapoint2 = reversedResult.compareDataPoint;
        }
        return reversedResult.copy(simpleDatapoint, simpleDatapoint2);
    }

    public final SimpleDatapoint component1() {
        return this.dataPoint;
    }

    public final SimpleDatapoint component2() {
        return this.compareDataPoint;
    }

    public final ReversedResult copy(SimpleDatapoint simpleDatapoint, SimpleDatapoint simpleDatapoint2) {
        Intrinsics.checkNotNullParameter(simpleDatapoint, "dataPoint");
        return new ReversedResult(simpleDatapoint, simpleDatapoint2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReversedResult)) {
            return false;
        }
        ReversedResult reversedResult = (ReversedResult) obj;
        return Intrinsics.areEqual((Object) this.dataPoint, (Object) reversedResult.dataPoint) && Intrinsics.areEqual((Object) this.compareDataPoint, (Object) reversedResult.compareDataPoint);
    }

    public int hashCode() {
        int hashCode = this.dataPoint.hashCode() * 31;
        SimpleDatapoint simpleDatapoint = this.compareDataPoint;
        return hashCode + (simpleDatapoint == null ? 0 : simpleDatapoint.hashCode());
    }

    public String toString() {
        return "ReversedResult(dataPoint=" + this.dataPoint + ", compareDataPoint=" + this.compareDataPoint + ')';
    }

    public ReversedResult(SimpleDatapoint simpleDatapoint, SimpleDatapoint simpleDatapoint2) {
        Intrinsics.checkNotNullParameter(simpleDatapoint, "dataPoint");
        this.dataPoint = simpleDatapoint;
        this.compareDataPoint = simpleDatapoint2;
    }

    public final SimpleDatapoint getCompareDataPoint() {
        return this.compareDataPoint;
    }

    public final SimpleDatapoint getDataPoint() {
        return this.dataPoint;
    }
}
