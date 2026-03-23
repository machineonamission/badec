package com.blueair.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import timber.log.Timber;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/blueair/core/util/BasicTwoWayBindingThrottle;", "", "allowUpdateTimeout", "", "<init>", "(J)V", "getAllowUpdateTimeout", "()J", "lastUpdateSent", "notifyUpdateSent", "", "allowReceiveUpdate", "", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BasicTwoWayBindingThrottle.kt */
public final class BasicTwoWayBindingThrottle {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long DEFAULT_ALLOW_UPDATE_TIMEOUT = 3000;
    private final long allowUpdateTimeout;
    private long lastUpdateSent;

    public BasicTwoWayBindingThrottle() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/util/BasicTwoWayBindingThrottle$Companion;", "", "<init>", "()V", "DEFAULT_ALLOW_UPDATE_TIMEOUT", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BasicTwoWayBindingThrottle.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public BasicTwoWayBindingThrottle(long j) {
        this.allowUpdateTimeout = j;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BasicTwoWayBindingThrottle(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 3000 : j);
    }

    public final long getAllowUpdateTimeout() {
        return this.allowUpdateTimeout;
    }

    public final synchronized void notifyUpdateSent() {
        this.lastUpdateSent = System.currentTimeMillis();
    }

    public final synchronized boolean allowReceiveUpdate() {
        boolean z;
        z = Math.abs(System.currentTimeMillis() - this.lastUpdateSent) > this.allowUpdateTimeout;
        if (!z) {
            Timber.Forest.v("allowReceiveUpdate: block update", new Object[0]);
        }
        return z;
    }
}
