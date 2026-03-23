package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000b2\u00020\u0001:\u0004\b\t\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/blueair/core/model/ConnectedState;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "NotConnected", "Connected", "CMSynchronization", "Companion", "Lcom/blueair/core/model/ConnectedState$CMSynchronization;", "Lcom/blueair/core/model/ConnectedState$Connected;", "Lcom/blueair/core/model/ConnectedState$NotConnected;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEvent.kt */
public abstract class ConnectedState {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String name;

    public /* synthetic */ ConnectedState(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private ConnectedState(String str) {
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/ConnectedState$NotConnected;", "Lcom/blueair/core/model/ConnectedState;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceEvent.kt */
    public static final class NotConnected extends ConnectedState {
        public static final NotConnected INSTANCE = new NotConnected();

        private NotConnected() {
            super("NotConnected", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/ConnectedState$Connected;", "Lcom/blueair/core/model/ConnectedState;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceEvent.kt */
    public static final class Connected extends ConnectedState {
        public static final Connected INSTANCE = new Connected();

        private Connected() {
            super("Connected", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/ConnectedState$CMSynchronization;", "Lcom/blueair/core/model/ConnectedState;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceEvent.kt */
    public static final class CMSynchronization extends ConnectedState {
        public static final CMSynchronization INSTANCE = new CMSynchronization();

        private CMSynchronization() {
            super("CM-Synchronization", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/core/model/ConnectedState$Companion;", "", "<init>", "()V", "fromName", "Lcom/blueair/core/model/ConnectedState;", "input", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConnectedState fromName(String str) {
            Intrinsics.checkNotNullParameter(str, "input");
            if (Intrinsics.areEqual((Object) str, (Object) NotConnected.INSTANCE.getName())) {
                return NotConnected.INSTANCE;
            }
            if (Intrinsics.areEqual((Object) str, (Object) Connected.INSTANCE.getName())) {
                return Connected.INSTANCE;
            }
            return CMSynchronization.INSTANCE;
        }
    }
}
