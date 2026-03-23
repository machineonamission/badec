package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.devicedetails.viewholder.LinkedDeviceHolder;
import com.blueair.viewcore.R;
import com.blueair.viewcore.viewholder.EmptyStateHolder;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0016J\u0018\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020#H\u0016J\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00022\u0006\u0010%\u001a\u00020#H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R0\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010!¨\u0006."}, d2 = {"Lcom/blueair/devicedetails/adapter/LinkedDevicesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "deviceSelectedPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/devicedetails/adapter/LinkedDeviceSelectionAction;", "<init>", "(Lio/reactivex/subjects/PublishSubject;)V", "parentDevice", "Lcom/blueair/core/model/HasLinkingCapability;", "getParentDevice", "()Lcom/blueair/core/model/HasLinkingCapability;", "setParentDevice", "(Lcom/blueair/core/model/HasLinkingCapability;)V", "linkedDevice", "Lcom/blueair/core/model/DeviceAware;", "getLinkedDevice", "()Lcom/blueair/core/model/DeviceAware;", "value", "", "awares", "getAwares", "()Ljava/util/List;", "setAwares", "(Ljava/util/List;)V", "hasEmptyState", "", "getHasEmptyState", "()Z", "nuAware", "selectedAware", "getSelectedAware", "setSelectedAware", "(Lcom/blueair/core/model/DeviceAware;)V", "getItemCount", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LinkedDevicesAdapter.kt */
public final class LinkedDevicesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_AWARE = 1;
    public static final int TYPE_EMPTY_STATE = 0;
    private List<DeviceAware> awares = CollectionsKt.emptyList();
    private final PublishSubject<LinkedDeviceSelectionAction> deviceSelectedPublisher;
    private HasLinkingCapability parentDevice;
    private DeviceAware selectedAware;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/blueair/devicedetails/adapter/LinkedDevicesAdapter$Companion;", "", "<init>", "()V", "TYPE_EMPTY_STATE", "", "TYPE_AWARE", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: LinkedDevicesAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public LinkedDevicesAdapter(PublishSubject<LinkedDeviceSelectionAction> publishSubject) {
        Intrinsics.checkNotNullParameter(publishSubject, "deviceSelectedPublisher");
        this.deviceSelectedPublisher = publishSubject;
    }

    public final HasLinkingCapability getParentDevice() {
        return this.parentDevice;
    }

    public final void setParentDevice(HasLinkingCapability hasLinkingCapability) {
        this.parentDevice = hasLinkingCapability;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.blueair.core.model.DeviceAware} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.blueair.core.model.DeviceAware getLinkedDevice() {
        /*
            r5 = this;
            java.util.List<com.blueair.core.model.DeviceAware> r0 = r5.awares
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x0029
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.core.model.DeviceAware r3 = (com.blueair.core.model.DeviceAware) r3
            java.lang.String r3 = r3.getUid()
            com.blueair.core.model.HasLinkingCapability r4 = r5.parentDevice
            if (r4 == 0) goto L_0x0022
            java.lang.String r2 = r4.getLinkedToUid()
        L_0x0022:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0008
            r2 = r1
        L_0x0029:
            com.blueair.core.model.DeviceAware r2 = (com.blueair.core.model.DeviceAware) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.adapter.LinkedDevicesAdapter.getLinkedDevice():com.blueair.core.model.DeviceAware");
    }

    public final List<DeviceAware> getAwares() {
        return this.awares;
    }

    public final void setAwares(List<DeviceAware> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.awares = CollectionsKt.sortedWith(list, new LinkedDevicesAdapter$special$$inlined$sortedBy$1());
        notifyDataSetChanged();
    }

    private final boolean getHasEmptyState() {
        return this.awares.isEmpty();
    }

    public final DeviceAware getSelectedAware() {
        return this.selectedAware;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5 != null ? r5.getLinkedToUid() : null) == false) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setSelectedAware(com.blueair.core.model.DeviceAware r8) {
        /*
            r7 = this;
            com.blueair.core.model.DeviceAware r0 = r7.selectedAware
            r7.selectedAware = r8
            r1 = -1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L_0x0021
            if (r8 == 0) goto L_0x0010
            java.lang.String r4 = r8.getUid()
            goto L_0x0011
        L_0x0010:
            r4 = r3
        L_0x0011:
            com.blueair.core.model.HasLinkingCapability r5 = r7.parentDevice
            if (r5 == 0) goto L_0x001a
            java.lang.String r5 = r5.getLinkedToUid()
            goto L_0x001b
        L_0x001a:
            r5 = r3
        L_0x001b:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x0027
        L_0x0021:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r0)
            if (r4 == 0) goto L_0x005f
        L_0x0027:
            com.blueair.core.model.HasLinkingCapability r0 = r7.parentDevice
            if (r0 == 0) goto L_0x002e
            r0.setLinkedToUid(r3)
        L_0x002e:
            r7.selectedAware = r3
            java.util.List<com.blueair.core.model.DeviceAware> r0 = r7.awares
            java.util.Iterator r0 = r0.iterator()
        L_0x0036:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0059
            java.lang.Object r4 = r0.next()
            com.blueair.core.model.DeviceAware r4 = (com.blueair.core.model.DeviceAware) r4
            java.lang.String r4 = r4.getUid()
            if (r8 == 0) goto L_0x004d
            java.lang.String r5 = r8.getUid()
            goto L_0x004e
        L_0x004d:
            r5 = r3
        L_0x004e:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x0056
            r1 = r2
            goto L_0x0059
        L_0x0056:
            int r2 = r2 + 1
            goto L_0x0036
        L_0x0059:
            if (r1 < 0) goto L_0x0108
            r7.notifyItemChanged(r1)
            return
        L_0x005f:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r0)
            if (r4 != 0) goto L_0x0108
            if (r0 == 0) goto L_0x0093
            java.util.List<com.blueair.core.model.DeviceAware> r3 = r7.awares
            java.util.Iterator r3 = r3.iterator()
            r4 = r2
        L_0x006e:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x008c
            java.lang.Object r5 = r3.next()
            com.blueair.core.model.DeviceAware r5 = (com.blueair.core.model.DeviceAware) r5
            java.lang.String r5 = r5.getUid()
            java.lang.String r6 = r0.getUid()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x0089
            goto L_0x008d
        L_0x0089:
            int r4 = r4 + 1
            goto L_0x006e
        L_0x008c:
            r4 = r1
        L_0x008d:
            if (r4 < 0) goto L_0x00dc
            r7.notifyItemChanged(r4)
            goto L_0x00dc
        L_0x0093:
            if (r8 == 0) goto L_0x009a
            java.lang.String r0 = r8.getUid()
            goto L_0x009b
        L_0x009a:
            r0 = r3
        L_0x009b:
            com.blueair.core.model.HasLinkingCapability r4 = r7.parentDevice
            if (r4 == 0) goto L_0x00a4
            java.lang.String r4 = r4.getLinkedToUid()
            goto L_0x00a5
        L_0x00a4:
            r4 = r3
        L_0x00a5:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r0 != 0) goto L_0x00dc
            java.util.List<com.blueair.core.model.DeviceAware> r0 = r7.awares
            java.util.Iterator r0 = r0.iterator()
            r4 = r2
        L_0x00b2:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x00d6
            java.lang.Object r5 = r0.next()
            com.blueair.core.model.DeviceAware r5 = (com.blueair.core.model.DeviceAware) r5
            java.lang.String r5 = r5.getUid()
            com.blueair.core.model.HasLinkingCapability r6 = r7.parentDevice
            if (r6 == 0) goto L_0x00cb
            java.lang.String r6 = r6.getLinkedToUid()
            goto L_0x00cc
        L_0x00cb:
            r6 = r3
        L_0x00cc:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x00d3
            goto L_0x00d7
        L_0x00d3:
            int r4 = r4 + 1
            goto L_0x00b2
        L_0x00d6:
            r4 = r1
        L_0x00d7:
            if (r4 < 0) goto L_0x00dc
            r7.notifyItemChanged(r4)
        L_0x00dc:
            if (r8 == 0) goto L_0x0108
            java.util.List<com.blueair.core.model.DeviceAware> r0 = r7.awares
            java.util.Iterator r0 = r0.iterator()
        L_0x00e4:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0103
            java.lang.Object r3 = r0.next()
            com.blueair.core.model.DeviceAware r3 = (com.blueair.core.model.DeviceAware) r3
            java.lang.String r3 = r3.getUid()
            java.lang.String r4 = r8.getUid()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0100
            r1 = r2
            goto L_0x0103
        L_0x0100:
            int r2 = r2 + 1
            goto L_0x00e4
        L_0x0103:
            if (r1 < 0) goto L_0x0108
            r7.notifyItemChanged(r1)
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.adapter.LinkedDevicesAdapter.setSelectedAware(com.blueair.core.model.DeviceAware):void");
    }

    public int getItemCount() {
        if (getHasEmptyState()) {
            return 1;
        }
        return this.awares.size();
    }

    public int getItemViewType(int i) {
        return getHasEmptyState() ^ true ? 1 : 0;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 0) {
            return EmptyStateHolder.Companion.newInstance(viewGroup);
        }
        if (i == 1) {
            return LinkedDeviceHolder.Companion.newInstance(viewGroup);
        }
        throw new RuntimeException("View Type does not exist.");
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Timber.Forest forest = Timber.Forest;
        forest.v("Binding adapter at position " + i, new Object[0]);
        if (viewHolder instanceof LinkedDeviceHolder) {
            DeviceAware deviceAware = this.awares.get(i);
            LinkedDeviceHolder linkedDeviceHolder = (LinkedDeviceHolder) viewHolder;
            String name = deviceAware.getName();
            DeviceAware deviceAware2 = this.selectedAware;
            String str = null;
            if (deviceAware2 == null ? (deviceAware2 = getLinkedDevice()) != null : deviceAware2 != null) {
                str = deviceAware2.getUid();
            }
            linkedDeviceHolder.update(name, Intrinsics.areEqual((Object) str, (Object) deviceAware.getUid()));
            linkedDeviceHolder.getClickView().setOnClickListener(new LinkedDevicesAdapter$$ExternalSyntheticLambda0(this, deviceAware));
        }
        if (viewHolder instanceof EmptyStateHolder) {
            String string = viewHolder.itemView.getContext().getString(R.string.no_aware);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ((EmptyStateHolder) viewHolder).update(string);
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$7(LinkedDevicesAdapter linkedDevicesAdapter, DeviceAware deviceAware, View view) {
        HasLinkingCapability hasLinkingCapability = linkedDevicesAdapter.parentDevice;
        if (hasLinkingCapability != null) {
            linkedDevicesAdapter.deviceSelectedPublisher.onNext(new LinkedDeviceSelectionAction(hasLinkingCapability, deviceAware));
        }
    }
}
