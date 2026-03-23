package com.blueair.core.model;

import com.blueair.core.model.OnboardingState;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \f2\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0001\b\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/blueair/core/model/OnboardingError;", "", "<init>", "()V", "JwtError", "PasswordError", "RouterError", "SignalError", "DeviceOrServerError", "HoldingError", "UnknownError", "InternetError", "Companion", "Lcom/blueair/core/model/OnboardingError$DeviceOrServerError;", "Lcom/blueair/core/model/OnboardingError$HoldingError;", "Lcom/blueair/core/model/OnboardingError$InternetError;", "Lcom/blueair/core/model/OnboardingError$JwtError;", "Lcom/blueair/core/model/OnboardingError$PasswordError;", "Lcom/blueair/core/model/OnboardingError$RouterError;", "Lcom/blueair/core/model/OnboardingError$SignalError;", "Lcom/blueair/core/model/OnboardingError$UnknownError;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEvent.kt */
public abstract class OnboardingError {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public /* synthetic */ OnboardingError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private OnboardingError() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/OnboardingError$JwtError;", "Lcom/blueair/core/model/OnboardingError;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceEvent.kt */
    public static final class JwtError extends OnboardingError {
        public static final JwtError INSTANCE = new JwtError();

        private JwtError() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/OnboardingError$PasswordError;", "Lcom/blueair/core/model/OnboardingError;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceEvent.kt */
    public static final class PasswordError extends OnboardingError {
        public static final PasswordError INSTANCE = new PasswordError();

        private PasswordError() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/OnboardingError$RouterError;", "Lcom/blueair/core/model/OnboardingError;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceEvent.kt */
    public static final class RouterError extends OnboardingError {
        public static final RouterError INSTANCE = new RouterError();

        private RouterError() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/OnboardingError$SignalError;", "Lcom/blueair/core/model/OnboardingError;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceEvent.kt */
    public static final class SignalError extends OnboardingError {
        public static final SignalError INSTANCE = new SignalError();

        private SignalError() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/OnboardingError$DeviceOrServerError;", "Lcom/blueair/core/model/OnboardingError;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceEvent.kt */
    public static final class DeviceOrServerError extends OnboardingError {
        public static final DeviceOrServerError INSTANCE = new DeviceOrServerError();

        private DeviceOrServerError() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/OnboardingError$HoldingError;", "Lcom/blueair/core/model/OnboardingError;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceEvent.kt */
    public static final class HoldingError extends OnboardingError {
        public static final HoldingError INSTANCE = new HoldingError();

        private HoldingError() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/OnboardingError$UnknownError;", "Lcom/blueair/core/model/OnboardingError;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceEvent.kt */
    public static final class UnknownError extends OnboardingError {
        public static final UnknownError INSTANCE = new UnknownError();

        private UnknownError() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/OnboardingError$InternetError;", "Lcom/blueair/core/model/OnboardingError;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceEvent.kt */
    public static final class InternetError extends OnboardingError {
        public static final InternetError INSTANCE = new InternetError();

        private InternetError() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/blueair/core/model/OnboardingError$Companion;", "", "<init>", "()V", "getOnboardingError", "Lcom/blueair/core/model/OnboardingError;", "event", "Lcom/blueair/core/model/DeviceEvent;", "onboardingState", "Lcom/blueair/core/model/OnboardingState;", "errorCode", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OnboardingError getOnboardingError(DeviceEvent deviceEvent) {
            Intrinsics.checkNotNullParameter(deviceEvent, "event");
            return getOnboardingError(deviceEvent.getOnboardingState(), deviceEvent.getErrorCode());
        }

        public final OnboardingError getOnboardingError(OnboardingState onboardingState, int i) {
            Intrinsics.checkNotNullParameter(onboardingState, "onboardingState");
            if (i < 0) {
                Pair pair = new Pair(onboardingState, Integer.valueOf(i));
                if (Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.LinkConnect.INSTANCE, -4))) {
                    return JwtError.INSTANCE;
                }
                if (Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.LinkConnect.INSTANCE, -1)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.LinkConnect.INSTANCE, -2)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.LinkReconnect.INSTANCE, -1)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.LinkReconnect.INSTANCE, -2)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.BrokerConnected.INSTANCE, -1)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.RegisterDevice.INSTANCE, -1)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.SettingPassword.INSTANCE, -1))) {
                    return SignalError.INSTANCE;
                }
                if (Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.ObtainingIPAddress.INSTANCE, -1)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.ObtainingIPAddress.INSTANCE, -2)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.ObtainingIPAddress.INSTANCE, -3))) {
                    return RouterError.INSTANCE;
                }
                if (Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.Authenticating.INSTANCE, -1)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.Authenticating.INSTANCE, -2)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.BrokerConnecting.INSTANCE, -1)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.BrokerConnecting.INSTANCE, -2)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.BrokerConnecting.INSTANCE, -3)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.BrokerConnecting.INSTANCE, -4)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.BrokerConnected.INSTANCE, -2)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.BrokerConnected.INSTANCE, -3)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.BrokerConnected.INSTANCE, -4)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.BrokerConnected.INSTANCE, -5)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.BrokerConnected.INSTANCE, -6)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.BrokerConnected.INSTANCE, -7)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.RegisterDevice.INSTANCE, -2)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.RegisterDevice.INSTANCE, -3)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.RegisterDevice.INSTANCE, -4)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.RegisterDevice.INSTANCE, -5)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.SettingPassword.INSTANCE, -2)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.SettingPassword.INSTANCE, -3)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.SettingPassword.INSTANCE, -4))) {
                    return DeviceOrServerError.INSTANCE;
                }
                if (Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.BrokerConnecting.INSTANCE, -5))) {
                    return HoldingError.INSTANCE;
                }
                if (Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.Authenticating.INSTANCE, -99)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.BrokerConnecting.INSTANCE, -99)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.BrokerConnected.INSTANCE, -99))) {
                    return InternetError.INSTANCE;
                }
                if (Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.LinkConnect.INSTANCE, -3)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.LinkReconnect.INSTANCE, -3)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.Authenticating.INSTANCE, -3)) || Intrinsics.areEqual((Object) pair, (Object) new Pair(OnboardingState.BrokerConnected.INSTANCE, -8))) {
                    return PasswordError.INSTANCE;
                }
                return UnknownError.INSTANCE;
            }
            throw new IllegalArgumentException("errorCode has to be negative. Not an error?");
        }
    }
}
