package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.viewholder.DeviceTimezoneHolder;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010#\u001a\u00020\u0006H\u0016J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0006H\u0016J\u0018\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0006H\u0016R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R0\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\f0\u0012@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017RL\u0010\u0018\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006+"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceTimezoneAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceTimezoneHolder;", "<init>", "()V", "value", "", "selectedIndex", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "Ljava/util/TimeZone;", "selectedTimezone", "getSelectedTimezone", "()Ljava/util/TimeZone;", "setSelectedTimezone", "(Ljava/util/TimeZone;)V", "", "timezoneList", "getTimezoneList", "()Ljava/util/List;", "setTimezoneList", "(Ljava/util/List;)V", "selectedTimezoneListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "timezone", "", "getSelectedTimezoneListener", "()Lkotlin/jvm/functions/Function2;", "setSelectedTimezoneListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceTimezoneAdapter.kt */
public final class DeviceTimezoneAdapter extends RecyclerView.Adapter<DeviceTimezoneHolder> {
    private int selectedIndex = -1;
    private TimeZone selectedTimezone;
    private Function2<? super Integer, ? super TimeZone, Unit> selectedTimezoneListener;
    private List<? extends TimeZone> timezoneList;

    public DeviceTimezoneAdapter() {
        TimeZone timeZone = TimeZone.getDefault();
        Intrinsics.checkNotNullExpressionValue(timeZone, "getDefault(...)");
        this.selectedTimezone = timeZone;
        this.timezoneList = CollectionsKt.emptyList();
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    private final void setSelectedIndex(int i) {
        int i2 = this.selectedIndex;
        if (i2 != i) {
            notifyItemChanged(i2);
            notifyItemChanged(i);
            this.selectedIndex = i;
        }
    }

    public final TimeZone getSelectedTimezone() {
        return this.selectedTimezone;
    }

    public final void setSelectedTimezone(TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(timeZone, "value");
        if (!Intrinsics.areEqual((Object) this.selectedTimezone, (Object) timeZone)) {
            this.selectedTimezone = timeZone;
            setSelectedIndex(this.timezoneList.indexOf(timeZone));
            Function2<? super Integer, ? super TimeZone, Unit> function2 = this.selectedTimezoneListener;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(this.selectedIndex), timeZone);
            }
        }
    }

    public final List<TimeZone> getTimezoneList() {
        return this.timezoneList;
    }

    public final void setTimezoneList(List<? extends TimeZone> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        if (!Intrinsics.areEqual((Object) this.timezoneList, (Object) list)) {
            this.timezoneList = list;
            setSelectedIndex(list.indexOf(this.selectedTimezone));
            notifyDataSetChanged();
        }
    }

    public final Function2<Integer, TimeZone, Unit> getSelectedTimezoneListener() {
        return this.selectedTimezoneListener;
    }

    public final void setSelectedTimezoneListener(Function2<? super Integer, ? super TimeZone, Unit> function2) {
        this.selectedTimezoneListener = function2;
    }

    public int getItemCount() {
        return this.timezoneList.size();
    }

    public DeviceTimezoneHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return DeviceTimezoneHolder.Companion.newInstance(viewGroup);
    }

    public void onBindViewHolder(DeviceTimezoneHolder deviceTimezoneHolder, int i) {
        Intrinsics.checkNotNullParameter(deviceTimezoneHolder, "holder");
        TimeZone timeZone = (TimeZone) this.timezoneList.get(i);
        deviceTimezoneHolder.bind(timeZone, i == this.selectedIndex);
        deviceTimezoneHolder.itemView.setOnClickListener(new DeviceTimezoneAdapter$$ExternalSyntheticLambda0(this, timeZone));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(DeviceTimezoneAdapter deviceTimezoneAdapter, TimeZone timeZone, View view) {
        deviceTimezoneAdapter.setSelectedTimezone(timeZone);
    }
}
