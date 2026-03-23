package io.flatcircle.connectivityhelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lio/flatcircle/connectivityhelper/ConnectionStateMonitor;", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: ConnectionMonitor.kt */
final class ConnectionMonitor$connectionMonitors$2 extends Lambda implements Function0<List<? extends ConnectionStateMonitor>> {
    final /* synthetic */ ConnectionMonitor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionMonitor$connectionMonitors$2(ConnectionMonitor connectionMonitor) {
        super(0);
        this.this$0 = connectionMonitor;
    }

    public final List<ConnectionStateMonitor> invoke() {
        Iterable<ConnectionType> watchedConnections = this.this$0.getWatchedConnections();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(watchedConnections, 10));
        for (ConnectionType connectionStateMonitor : watchedConnections) {
            arrayList.add(new ConnectionStateMonitor(connectionStateMonitor));
        }
        return (List) arrayList;
    }
}
