package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.HasAlarm;
import com.blueair.devicedetails.viewholder.DevicesAlarmViewHolder;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BU\u0012\u001e\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\n\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0016J\u0018\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020&H\u0016R)\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\nX\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\fX\u0004¢\u0006\u0002\n\u0000R0\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cX\u0004¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/blueair/devicedetails/adapter/DevicesAlarmAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DevicesAlarmViewHolder;", "onAlarmChecked", "Lkotlin/Function3;", "Lcom/blueair/core/model/HasAlarm;", "Lcom/blueair/core/model/DeviceAlarm;", "", "", "onTroubleShootClickListener", "Lkotlin/Function1;", "onMoreClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "<init>", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getOnAlarmChecked", "()Lkotlin/jvm/functions/Function3;", "value", "", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "hideOfflineUidSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "forceOffline", "getForceOffline", "()Z", "setForceOffline", "(Z)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DevicesAlarmAdapter.kt */
public final class DevicesAlarmAdapter extends RecyclerView.Adapter<DevicesAlarmViewHolder> {
    private boolean forceOffline;
    private final HashSet<String> hideOfflineUidSet = new HashSet<>();
    private List<? extends HasAlarm> items = CollectionsKt.emptyList();
    private final Function3<HasAlarm, DeviceAlarm, Boolean, Unit> onAlarmChecked;
    private final Function2<HasAlarm, View, Unit> onMoreClickListener;
    private final Function1<HasAlarm, Unit> onTroubleShootClickListener;

    public final Function3<HasAlarm, DeviceAlarm, Boolean, Unit> getOnAlarmChecked() {
        return this.onAlarmChecked;
    }

    public DevicesAlarmAdapter(Function3<? super HasAlarm, ? super DeviceAlarm, ? super Boolean, Unit> function3, Function1<? super HasAlarm, Unit> function1, Function2<? super HasAlarm, ? super View, Unit> function2) {
        Intrinsics.checkNotNullParameter(function3, "onAlarmChecked");
        Intrinsics.checkNotNullParameter(function1, "onTroubleShootClickListener");
        Intrinsics.checkNotNullParameter(function2, "onMoreClickListener");
        this.onAlarmChecked = function3;
        this.onTroubleShootClickListener = function1;
        this.onMoreClickListener = function2;
    }

    public final List<HasAlarm> getItems() {
        return this.items;
    }

    public final void setItems(List<? extends HasAlarm> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.items = list;
        notifyDataSetChanged();
    }

    public final boolean getForceOffline() {
        return this.forceOffline;
    }

    public final void setForceOffline(boolean z) {
        if (z != this.forceOffline) {
            this.forceOffline = z;
            notifyDataSetChanged();
        }
    }

    public DevicesAlarmViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return DevicesAlarmViewHolder.Companion.instance(viewGroup, this.onAlarmChecked);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(DevicesAlarmViewHolder devicesAlarmViewHolder, int i) {
        Intrinsics.checkNotNullParameter(devicesAlarmViewHolder, "holder");
        HasAlarm hasAlarm = (HasAlarm) this.items.get(i);
        devicesAlarmViewHolder.bind(hasAlarm, this.forceOffline, this.hideOfflineUidSet.contains(hasAlarm.getUid()));
        devicesAlarmViewHolder.getIconMore().setOnClickListener(new DevicesAlarmAdapter$$ExternalSyntheticLambda0(this, hasAlarm));
        devicesAlarmViewHolder.getCloseBtn().setOnClickListener(new DevicesAlarmAdapter$$ExternalSyntheticLambda1(this, hasAlarm, i));
        devicesAlarmViewHolder.getTroubleshootingBtn().setOnClickListener(new DevicesAlarmAdapter$$ExternalSyntheticLambda2(this, hasAlarm));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(DevicesAlarmAdapter devicesAlarmAdapter, HasAlarm hasAlarm, View view) {
        Function2<HasAlarm, View, Unit> function2 = devicesAlarmAdapter.onMoreClickListener;
        Intrinsics.checkNotNull(view);
        function2.invoke(hasAlarm, view);
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(DevicesAlarmAdapter devicesAlarmAdapter, HasAlarm hasAlarm, int i, View view) {
        devicesAlarmAdapter.hideOfflineUidSet.add(hasAlarm.getUid());
        devicesAlarmAdapter.notifyItemChanged(i);
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(DevicesAlarmAdapter devicesAlarmAdapter, HasAlarm hasAlarm, View view) {
        devicesAlarmAdapter.onTroubleShootClickListener.invoke(hasAlarm);
    }
}
