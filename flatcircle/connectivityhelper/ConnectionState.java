package io.flatcircle.connectivityhelper;

import android.net.ConnectivityManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\f\r\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u0001\u0003\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/flatcircle/connectivityhelper/ConnectionState;", "", "lastCheckInMillis", "", "(J)V", "getLastCheckInMillis", "()J", "setLastCheckInMillis", "millisSinceLastCheck", "newState", "connectivityManager", "Landroid/net/ConnectivityManager;", "Offline", "Online", "ProbablyOnline", "Lio/flatcircle/connectivityhelper/ConnectionState$Offline;", "Lio/flatcircle/connectivityhelper/ConnectionState$ProbablyOnline;", "Lio/flatcircle/connectivityhelper/ConnectionState$Online;", "connectivityhelper_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: ConnectionMonitor.kt */
public abstract class ConnectionState {
    private long lastCheckInMillis;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/flatcircle/connectivityhelper/ConnectionState$Offline;", "Lio/flatcircle/connectivityhelper/ConnectionState;", "()V", "connectivityhelper_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: ConnectionMonitor.kt */
    public static final class Offline extends ConnectionState {
        public static final Offline INSTANCE = new Offline();

        private Offline() {
            super(System.currentTimeMillis(), (DefaultConstructorMarker) null);
        }
    }

    private ConnectionState(long j) {
        this.lastCheckInMillis = j;
    }

    public /* synthetic */ ConnectionState(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    public final long getLastCheckInMillis() {
        return this.lastCheckInMillis;
    }

    public final void setLastCheckInMillis(long j) {
        this.lastCheckInMillis = j;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/flatcircle/connectivityhelper/ConnectionState$ProbablyOnline;", "Lio/flatcircle/connectivityhelper/ConnectionState;", "()V", "connectivityhelper_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: ConnectionMonitor.kt */
    public static final class ProbablyOnline extends ConnectionState {
        public static final ProbablyOnline INSTANCE = new ProbablyOnline();

        private ProbablyOnline() {
            super(System.currentTimeMillis(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/flatcircle/connectivityhelper/ConnectionState$Online;", "Lio/flatcircle/connectivityhelper/ConnectionState;", "()V", "connectivityhelper_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: ConnectionMonitor.kt */
    public static final class Online extends ConnectionState {
        public static final Online INSTANCE = new Online();

        private Online() {
            super(System.currentTimeMillis(), (DefaultConstructorMarker) null);
        }
    }

    public final ConnectionState newState(ConnectivityManager connectivityManager) {
        Intrinsics.checkParameterIsNotNull(connectivityManager, "connectivityManager");
        Pair pair = new Pair(this, Boolean.valueOf(NetUtil.INSTANCE.isProbablyOnline(connectivityManager)));
        if (Intrinsics.areEqual((Object) pair, (Object) new Pair(Offline.INSTANCE, false)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(ProbablyOnline.INSTANCE, false)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(Online.INSTANCE, false))) {
            return Offline.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) pair, (Object) new Pair(Offline.INSTANCE, true)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(ProbablyOnline.INSTANCE, true))) {
            return ProbablyOnline.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) pair, (Object) new Pair(Online.INSTANCE, true))) {
            return Online.INSTANCE;
        }
        return Offline.INSTANCE;
    }

    public final long millisSinceLastCheck() {
        return System.currentTimeMillis() - this.lastCheckInMillis;
    }
}
