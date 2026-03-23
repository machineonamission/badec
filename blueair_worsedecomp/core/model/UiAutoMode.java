package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \t2\u00020\u0001:\u0004\u0006\u0007\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/blueair/core/model/UiAutoMode;", "", "state", "", "<init>", "(Ljava/lang/String;)V", "NotAvailable", "On", "Off", "Companion", "Lcom/blueair/core/model/UiAutoMode$NotAvailable;", "Lcom/blueair/core/model/UiAutoMode$Off;", "Lcom/blueair/core/model/UiAutoMode$On;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AutoMode.kt */
public abstract class UiAutoMode {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public /* synthetic */ UiAutoMode(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/UiAutoMode$NotAvailable;", "Lcom/blueair/core/model/UiAutoMode;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AutoMode.kt */
    public static final class NotAvailable extends UiAutoMode {
        public static final NotAvailable INSTANCE = new NotAvailable();

        private NotAvailable() {
            super("not_available", (DefaultConstructorMarker) null);
        }
    }

    private UiAutoMode(String str) {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/UiAutoMode$On;", "Lcom/blueair/core/model/UiAutoMode;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AutoMode.kt */
    public static final class On extends UiAutoMode {
        public static final On INSTANCE = new On();

        private On() {
            super(DebugKt.DEBUG_PROPERTY_VALUE_ON, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/UiAutoMode$Off;", "Lcom/blueair/core/model/UiAutoMode;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AutoMode.kt */
    public static final class Off extends UiAutoMode {
        public static final Off INSTANCE = new Off();

        private Off() {
            super(DebugKt.DEBUG_PROPERTY_VALUE_OFF, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/blueair/core/model/UiAutoMode$Companion;", "", "<init>", "()V", "from", "Lcom/blueair/core/model/UiAutoMode;", "device", "Lcom/blueair/core/model/Device;", "input", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AutoMode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UiAutoMode from(Device device, String str) {
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(str, "input");
            if (!(device instanceof DeviceClassic) && !DeviceKt.isG4orB4orNB(device) && !(device instanceof DeviceIcp) && (!(device instanceof HasLinkingCapability) || !((HasLinkingCapability) device).isLinked())) {
                return NotAvailable.INSTANCE;
            }
            if (Intrinsics.areEqual((Object) str, (Object) "auto")) {
                return On.INSTANCE;
            }
            return Off.INSTANCE;
        }
    }
}
