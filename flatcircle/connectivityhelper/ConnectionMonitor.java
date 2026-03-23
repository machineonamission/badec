package io.flatcircle.connectivityhelper;

import android.content.Context;
import android.net.ConnectivityManager;
import io.flatcircle.connectivityhelper.ConnectionState;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0002-.B/\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'H\u0016J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\tJ\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020)H\u0016R!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0010¨\u0006/"}, d2 = {"Lio/flatcircle/connectivityhelper/ConnectionMonitor;", "Lio/flatcircle/connectivityhelper/ConnectivityEventObserver;", "Lio/flatcircle/connectivityhelper/PingResultHandler;", "context", "Landroid/content/Context;", "stateChangeListener", "Lio/flatcircle/connectivityhelper/StateChangeListener;", "watchedConnections", "", "Lio/flatcircle/connectivityhelper/ConnectionType;", "endpoint", "", "(Landroid/content/Context;Lio/flatcircle/connectivityhelper/StateChangeListener;Ljava/util/List;Ljava/lang/String;)V", "connectionMonitors", "Lio/flatcircle/connectivityhelper/ConnectionStateMonitor;", "getConnectionMonitors", "()Ljava/util/List;", "connectionMonitors$delegate", "Lkotlin/Lazy;", "nuState", "Lio/flatcircle/connectivityhelper/ConnectionState;", "connectionState", "getConnectionState", "()Lio/flatcircle/connectivityhelper/ConnectionState;", "setConnectionState", "(Lio/flatcircle/connectivityhelper/ConnectionState;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "pingLooper", "Lio/flatcircle/connectivityhelper/PingLooper;", "getStateChangeListener", "()Lio/flatcircle/connectivityhelper/StateChangeListener;", "setStateChangeListener", "(Lio/flatcircle/connectivityhelper/StateChangeListener;)V", "getWatchedConnections", "clear", "", "handleConnectivityEvent", "connectivityEvent", "Lio/flatcircle/connectivityhelper/ConnectivityEvent;", "isConnectedTo", "", "connectionType", "result", "didReachEndpoint", "Builder", "Companion", "connectivityhelper_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: ConnectionMonitor.kt */
public final class ConnectionMonitor implements ConnectivityEventObserver, PingResultHandler {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ConnectionMonitor.class), "connectionMonitors", "getConnectionMonitors()Ljava/util/List;"))};
    public static final String BAIDU_IP = "180.76.5";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String GOOGLE_IP = "8.8.8.8";
    public static final long TIME_BETWEEN_PINGS = 30000;
    private final Lazy connectionMonitors$delegate;
    private ConnectionState connectionState;
    private final ConnectivityManager connectivityManager;
    private final PingLooper pingLooper;
    private StateChangeListener stateChangeListener;
    private final List<ConnectionType> watchedConnections;

    private final List<ConnectionStateMonitor> getConnectionMonitors() {
        Lazy lazy = this.connectionMonitors$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (List) lazy.getValue();
    }

    public /* synthetic */ ConnectionMonitor(Context context, StateChangeListener stateChangeListener2, List list, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, stateChangeListener2, list, str);
    }

    private ConnectionMonitor(Context context, StateChangeListener stateChangeListener2, List<? extends ConnectionType> list, String str) {
        this.stateChangeListener = stateChangeListener2;
        this.watchedConnections = list;
        this.connectionMonitors$delegate = LazyKt.lazy(new ConnectionMonitor$connectionMonitors$2(this));
        this.pingLooper = new PingLooper(getConnectionMonitors(), this, str);
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            this.connectivityManager = (ConnectivityManager) systemService;
            this.connectionState = ConnectionState.Offline.INSTANCE;
            for (ConnectionStateMonitor enable : getConnectionMonitors()) {
                enable.enable(this.connectivityManager, this);
            }
            this.pingLooper.doPings();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public final StateChangeListener getStateChangeListener() {
        return this.stateChangeListener;
    }

    public final void setStateChangeListener(StateChangeListener stateChangeListener2) {
        this.stateChangeListener = stateChangeListener2;
    }

    public final List<ConnectionType> getWatchedConnections() {
        return this.watchedConnections;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lio/flatcircle/connectivityhelper/ConnectionMonitor$Companion;", "", "()V", "BAIDU_IP", "", "GOOGLE_IP", "TIME_BETWEEN_PINGS", "", "connectivityhelper_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: ConnectionMonitor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void result(boolean z) {
        if (z) {
            setConnectionState(ConnectionState.Online.INSTANCE);
        } else if (NetUtil.INSTANCE.isProbablyOnline(this.connectivityManager)) {
            setConnectionState(ConnectionState.ProbablyOnline.INSTANCE);
        } else {
            setConnectionState(ConnectionState.Offline.INSTANCE);
        }
    }

    public final boolean isConnectedTo(ConnectionType connectionType) throws IllegalArgumentException {
        Boolean bool;
        Object obj;
        Intrinsics.checkParameterIsNotNull(connectionType, "connectionType");
        Iterator it = this.watchedConnections.iterator();
        while (true) {
            bool = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ConnectionType) obj).getNetworkCapablity() == connectionType.getNetworkCapablity()) {
                break;
            }
        }
        ConnectionType connectionType2 = (ConnectionType) obj;
        if (connectionType2 != null) {
            bool = Boolean.valueOf(connectionType2.isConnectedTo());
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        throw new IllegalArgumentException("The ConnectionMonitor was not instantiated with the passed " + connectionType + " connectiontype");
    }

    public final ConnectionState getConnectionState() {
        return this.connectionState;
    }

    private final void setConnectionState(ConnectionState connectionState2) {
        if ((connectionState2 instanceof ConnectionState.ProbablyOnline) && (this.connectionState.millisSinceLastCheck() > 30000 || (this.connectionState instanceof ConnectionState.Offline))) {
            this.pingLooper.doPings();
        } else if (connectionState2 instanceof ConnectionState.Offline) {
            this.pingLooper.cancel();
        }
        this.connectionState = connectionState2;
        StateChangeListener stateChangeListener2 = this.stateChangeListener;
        if (stateChangeListener2 != null) {
            stateChangeListener2.netStateChange(connectionState2);
        }
    }

    public void handleConnectivityEvent(ConnectivityEvent connectivityEvent) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(connectivityEvent, "connectivityEvent");
        setConnectionState(this.connectionState.newState(this.connectivityManager));
        Iterator it = this.watchedConnections.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ConnectionType) obj).getNetworkCapablity() == connectivityEvent.getConnectionType().getNetworkCapablity()) {
                break;
            }
        }
        ConnectionType connectionType = (ConnectionType) obj;
        if (connectionType != null) {
            connectionType.setConnectedTo(connectivityEvent.isConnectedTo());
        }
    }

    public final void clear() {
        StateChangeListener stateChangeListener2 = null;
        this.stateChangeListener = null;
        this.pingLooper.cancel();
        for (ConnectionStateMonitor disable : getConnectionMonitors()) {
            disable.disable(this.connectivityManager);
        }
        this.connectivityManager.isActiveNetworkMetered();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\nJ\u001f\u0010\u000b\u001a\u00020\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0013\"\u00020\r¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/flatcircle/connectivityhelper/ConnectionMonitor$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "endpoint", "", "stateChangeListener", "Lio/flatcircle/connectivityhelper/StateChangeListener;", "timeBetweenPings", "", "watchedConnections", "", "Lio/flatcircle/connectivityhelper/ConnectionType;", "build", "Lio/flatcircle/connectivityhelper/ConnectionMonitor;", "address", "milliseconds", "connections", "", "([Lio/flatcircle/connectivityhelper/ConnectionType;)Lio/flatcircle/connectivityhelper/ConnectionMonitor$Builder;", "connectivityhelper_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: ConnectionMonitor.kt */
    public static final class Builder {
        private final Context context;
        private String endpoint = ConnectionMonitor.GOOGLE_IP;
        private StateChangeListener stateChangeListener;
        private long timeBetweenPings = 30000;
        private List<? extends ConnectionType> watchedConnections = CollectionsKt.emptyList();

        public Builder(Context context2) {
            Intrinsics.checkParameterIsNotNull(context2, "context");
            this.context = context2;
        }

        public final Builder watchedConnections(ConnectionType... connectionTypeArr) {
            Intrinsics.checkParameterIsNotNull(connectionTypeArr, "connections");
            this.watchedConnections = ArraysKt.toList((T[]) connectionTypeArr);
            return this;
        }

        public final Builder stateChangeListener(StateChangeListener stateChangeListener2) {
            Intrinsics.checkParameterIsNotNull(stateChangeListener2, "stateChangeListener");
            this.stateChangeListener = stateChangeListener2;
            return this;
        }

        public final Builder timeBetweenPings(long j) {
            this.timeBetweenPings = j;
            return this;
        }

        public final Builder endpoint(String str) {
            Intrinsics.checkParameterIsNotNull(str, "address");
            this.endpoint = str;
            return this;
        }

        public final ConnectionMonitor build() {
            return new ConnectionMonitor(this.context, this.stateChangeListener, this.watchedConnections, this.endpoint, (DefaultConstructorMarker) null);
        }
    }
}
