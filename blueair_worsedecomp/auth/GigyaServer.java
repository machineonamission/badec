package com.blueair.auth;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00102\u00020\u0001:\u0005\f\r\u000e\u000f\u0010B!\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u0001\u0004\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/blueair/auth/GigyaServer;", "", "url", "", "apiKey", "countryCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getApiKey", "getCountryCode", "USA", "EUROPE", "CHINA", "AUSTRALIA", "Companion", "Lcom/blueair/auth/GigyaServer$AUSTRALIA;", "Lcom/blueair/auth/GigyaServer$CHINA;", "Lcom/blueair/auth/GigyaServer$EUROPE;", "Lcom/blueair/auth/GigyaServer$USA;", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GigyaServer.kt */
public abstract class GigyaServer {
    /* access modifiers changed from: private */
    public static final List<GigyaServer> ALL_SERVERS = CollectionsKt.listOf(USA.INSTANCE, EUROPE.INSTANCE, CHINA.INSTANCE, AUSTRALIA.INSTANCE);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String apiKey;
    private final String countryCode;
    private final String url;

    public /* synthetic */ GigyaServer(String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3);
    }

    private GigyaServer(String str, String str2, String str3) {
        this.url = str;
        this.apiKey = str2;
        this.countryCode = str3;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getUrl() {
        return this.url;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/auth/GigyaServer$USA;", "Lcom/blueair/auth/GigyaServer;", "<init>", "()V", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GigyaServer.kt */
    public static final class USA extends GigyaServer {
        public static final USA INSTANCE = new USA();

        private USA() {
            super("https://accounts.us1.gigya.com", "3_-xUbbrIY8QCbHDWQs1tLXE-CZBQ50SGElcOY5hF1euE11wCoIlNbjMGAFQ6UwhMY", "us", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/auth/GigyaServer$EUROPE;", "Lcom/blueair/auth/GigyaServer;", "<init>", "()V", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GigyaServer.kt */
    public static final class EUROPE extends GigyaServer {
        public static final EUROPE INSTANCE = new EUROPE();

        private EUROPE() {
            super("https://accounts.eu1.gigya.com", "3_qRseYzrUJl1VyxvSJANalu_kNgQ83swB1B9uzgms58--5w1ClVNmrFdsDnWVQQCl", GigyaService.EUROPE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/auth/GigyaServer$CHINA;", "Lcom/blueair/auth/GigyaServer;", "<init>", "()V", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GigyaServer.kt */
    public static final class CHINA extends GigyaServer {
        public static final CHINA INSTANCE = new CHINA();

        private CHINA() {
            super("https://accounts.cn1.sapcdm.cn", "3_h3UEfJnA-zDpFPR9L4412HO7Mz2VVeN4wprbWYafPN1gX0kSnLcZ9VSfFi7bEIIU", "cn", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/auth/GigyaServer$AUSTRALIA;", "Lcom/blueair/auth/GigyaServer;", "<init>", "()V", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GigyaServer.kt */
    public static final class AUSTRALIA extends GigyaServer {
        public static final AUSTRALIA INSTANCE = new AUSTRALIA();

        private AUSTRALIA() {
            super("https://accounts.au1.gigya.com", "3_Z2N0mIFC6j2fx1z2sq76R3pwkCMaMX2y9btPb0_PgI_3wfjSJoofFnBbxbtuQksN", GigyaService.AUSTRALIA, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/blueair/auth/GigyaServer$Companion;", "", "<init>", "()V", "ALL_SERVERS", "", "Lcom/blueair/auth/GigyaServer;", "getALL_SERVERS", "()Ljava/util/List;", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GigyaServer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<GigyaServer> getALL_SERVERS() {
            return GigyaServer.ALL_SERVERS;
        }
    }
}
