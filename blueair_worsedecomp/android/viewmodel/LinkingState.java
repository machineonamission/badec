package com.blueair.android.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/blueair/android/viewmodel/LinkingState;", "", "<init>", "()V", "Idle", "Loading", "UrlGot", "AuthCodeGot", "Success", "Failed", "Cancel", "Lcom/blueair/android/viewmodel/LinkingState$AuthCodeGot;", "Lcom/blueair/android/viewmodel/LinkingState$Cancel;", "Lcom/blueair/android/viewmodel/LinkingState$Failed;", "Lcom/blueair/android/viewmodel/LinkingState$Idle;", "Lcom/blueair/android/viewmodel/LinkingState$Loading;", "Lcom/blueair/android/viewmodel/LinkingState$Success;", "Lcom/blueair/android/viewmodel/LinkingState$UrlGot;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AccountLinkingViewModel.kt */
public abstract class LinkingState {
    public static final int $stable = 0;

    public /* synthetic */ LinkingState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/android/viewmodel/LinkingState$Idle;", "Lcom/blueair/android/viewmodel/LinkingState;", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AccountLinkingViewModel.kt */
    public static final class Idle extends LinkingState {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super((DefaultConstructorMarker) null);
        }
    }

    private LinkingState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/android/viewmodel/LinkingState$Loading;", "Lcom/blueair/android/viewmodel/LinkingState;", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AccountLinkingViewModel.kt */
    public static final class Loading extends LinkingState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/android/viewmodel/LinkingState$UrlGot;", "Lcom/blueair/android/viewmodel/LinkingState;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AccountLinkingViewModel.kt */
    public static final class UrlGot extends LinkingState {
        public static final int $stable = 0;
        private final String url;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UrlGot(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "url");
            this.url = str;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/android/viewmodel/LinkingState$AuthCodeGot;", "Lcom/blueair/android/viewmodel/LinkingState;", "code", "", "<init>", "(Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AccountLinkingViewModel.kt */
    public static final class AuthCodeGot extends LinkingState {
        public static final int $stable = 0;
        private final String code;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AuthCodeGot(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "code");
            this.code = str;
        }

        public final String getCode() {
            return this.code;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/android/viewmodel/LinkingState$Success;", "Lcom/blueair/android/viewmodel/LinkingState;", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AccountLinkingViewModel.kt */
    public static final class Success extends LinkingState {
        public static final int $stable = 0;
        public static final Success INSTANCE = new Success();

        private Success() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/android/viewmodel/LinkingState$Failed;", "Lcom/blueair/android/viewmodel/LinkingState;", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AccountLinkingViewModel.kt */
    public static final class Failed extends LinkingState {
        public static final int $stable = 0;
        public static final Failed INSTANCE = new Failed();

        private Failed() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/android/viewmodel/LinkingState$Cancel;", "Lcom/blueair/android/viewmodel/LinkingState;", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AccountLinkingViewModel.kt */
    public static final class Cancel extends LinkingState {
        public static final int $stable = 0;
        public static final Cancel INSTANCE = new Cancel();

        private Cancel() {
            super((DefaultConstructorMarker) null);
        }
    }
}
