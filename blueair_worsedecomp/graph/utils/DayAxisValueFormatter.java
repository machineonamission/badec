package com.blueair.graph.utils;

import com.foobot.liblabclient.core.WsDefinition;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.ValueFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/blueair/graph/utils/DayAxisValueFormatter;", "Lcom/github/mikephil/charting/formatter/ValueFormatter;", "is24HrFormat", "", "startingDate", "", "scale", "Lcom/blueair/graph/utils/ChartTimeScale;", "<init>", "(ZJLcom/blueair/graph/utils/ChartTimeScale;)V", "()Z", "getStartingDate", "()J", "getScale", "()Lcom/blueair/graph/utils/ChartTimeScale;", "getAxisLabel", "", "value", "", "axis", "Lcom/github/mikephil/charting/components/AxisBase;", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ValueFormatter.kt */
public final class DayAxisValueFormatter extends ValueFormatter {
    private final boolean is24HrFormat;
    private final ChartTimeScale scale;
    private final long startingDate;

    public DayAxisValueFormatter(boolean z, long j, ChartTimeScale chartTimeScale) {
        Intrinsics.checkNotNullParameter(chartTimeScale, WsDefinition.SCALE);
        this.is24HrFormat = z;
        this.startingDate = j;
        this.scale = chartTimeScale;
    }

    public final ChartTimeScale getScale() {
        return this.scale;
    }

    public final long getStartingDate() {
        return this.startingDate;
    }

    public final boolean is24HrFormat() {
        return this.is24HrFormat;
    }

    public String getAxisLabel(float f, AxisBase axisBase) {
        SimpleDateFormat simpleDateFormat;
        Date date = new Date(((long) f) + this.startingDate);
        if (this.scale == ChartTimeScale.DAY) {
            simpleDateFormat = this.is24HrFormat ? new SimpleDateFormat("dd MMM HH:mm") : new SimpleDateFormat("dd MMM h:mm a");
        } else {
            simpleDateFormat = new SimpleDateFormat("dd MMM");
        }
        String format = simpleDateFormat.format(date);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
