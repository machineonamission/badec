package com.blueair.core.model;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bS\b\b\u0018\u00002\u00020\u0001B©\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b$\u0010%J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010N\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010O\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010P\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010Q\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jê\u0002\u0010e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010fJ\u0013\u0010g\u001a\u00020\r2\b\u0010h\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010i\u001a\u00020\u0006HÖ\u0001J\t\u0010j\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010'R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010+\u001a\u0004\b1\u0010*R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00103\u001a\u0004\b\f\u00102R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00103\u001a\u0004\b\u000e\u00102R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00103\u001a\u0004\b\u000f\u00102R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010'R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00100\u001a\u0004\b5\u0010/R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010'R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00100\u001a\u0004\b7\u0010/R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010'R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010'R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00100\u001a\u0004\b:\u0010/R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010'R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00100\u001a\u0004\b>\u0010/R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010'R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010'R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010'R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010'R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00100\u001a\u0004\bC\u0010/R\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010'R\u0013\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010'R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010'R\u0013\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010'¨\u0006k"}, d2 = {"Lcom/blueair/core/model/ProfileResponse;", "", "UID", "", "UIDSignature", "apiVersion", "", "callId", "created", "createdTimestamp", "", "errorCode", "isActive", "", "isRegistered", "isVerified", "lastLogin", "lastLoginTimestamp", "lastUpdated", "lastUpdatedTimestamp", "loginProvider", "oldestDataUpdated", "oldestDataUpdatedTimestamp", "profile", "Lcom/blueair/core/model/Profile;", "registered", "registeredTimestamp", "signatureTimestamp", "socialProviders", "time", "verified", "verifiedTimestamp", "status", "errorMessage", "statusMessage", "operation", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/blueair/core/model/Profile;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUID", "()Ljava/lang/String;", "getUIDSignature", "getApiVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCallId", "getCreated", "getCreatedTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getErrorCode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLastLogin", "getLastLoginTimestamp", "getLastUpdated", "getLastUpdatedTimestamp", "getLoginProvider", "getOldestDataUpdated", "getOldestDataUpdatedTimestamp", "getProfile", "()Lcom/blueair/core/model/Profile;", "getRegistered", "getRegisteredTimestamp", "getSignatureTimestamp", "getSocialProviders", "getTime", "getVerified", "getVerifiedTimestamp", "getStatus", "getErrorMessage", "getStatusMessage", "getOperation", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/blueair/core/model/Profile;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/blueair/core/model/ProfileResponse;", "equals", "other", "hashCode", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ProfileResponse.kt */
public final class ProfileResponse {
    private final String UID;
    private final String UIDSignature;
    private final Integer apiVersion;
    private final String callId;
    private final String created;
    private final Long createdTimestamp;
    private final Integer errorCode;
    private final String errorMessage;
    private final Boolean isActive;
    private final Boolean isRegistered;
    private final Boolean isVerified;
    private final String lastLogin;
    private final Long lastLoginTimestamp;
    private final String lastUpdated;
    private final Long lastUpdatedTimestamp;
    private final String loginProvider;
    private final String oldestDataUpdated;
    private final Long oldestDataUpdatedTimestamp;
    private final String operation;
    private final Profile profile;
    private final String registered;
    private final Long registeredTimestamp;
    private final String signatureTimestamp;
    private final String socialProviders;
    private final String status;
    private final String statusMessage;
    private final String time;
    private final String verified;
    private final Long verifiedTimestamp;

    public static /* synthetic */ ProfileResponse copy$default(ProfileResponse profileResponse, String str, String str2, Integer num, String str3, String str4, Long l, Integer num2, Boolean bool, Boolean bool2, Boolean bool3, String str5, Long l2, String str6, Long l3, String str7, String str8, Long l4, Profile profile2, String str9, Long l5, String str10, String str11, String str12, String str13, Long l6, String str14, String str15, String str16, String str17, int i, Object obj) {
        String str18;
        String str19;
        ProfileResponse profileResponse2 = profileResponse;
        int i2 = i;
        String str20 = (i2 & 1) != 0 ? profileResponse2.UID : str;
        String str21 = (i2 & 2) != 0 ? profileResponse2.UIDSignature : str2;
        Integer num3 = (i2 & 4) != 0 ? profileResponse2.apiVersion : num;
        String str22 = (i2 & 8) != 0 ? profileResponse2.callId : str3;
        String str23 = (i2 & 16) != 0 ? profileResponse2.created : str4;
        Long l7 = (i2 & 32) != 0 ? profileResponse2.createdTimestamp : l;
        Integer num4 = (i2 & 64) != 0 ? profileResponse2.errorCode : num2;
        Boolean bool4 = (i2 & 128) != 0 ? profileResponse2.isActive : bool;
        Boolean bool5 = (i2 & 256) != 0 ? profileResponse2.isRegistered : bool2;
        Boolean bool6 = (i2 & 512) != 0 ? profileResponse2.isVerified : bool3;
        String str24 = (i2 & 1024) != 0 ? profileResponse2.lastLogin : str5;
        Long l8 = (i2 & 2048) != 0 ? profileResponse2.lastLoginTimestamp : l2;
        String str25 = (i2 & 4096) != 0 ? profileResponse2.lastUpdated : str6;
        Long l9 = (i2 & 8192) != 0 ? profileResponse2.lastUpdatedTimestamp : l3;
        String str26 = str20;
        String str27 = (i2 & 16384) != 0 ? profileResponse2.loginProvider : str7;
        String str28 = (i2 & 32768) != 0 ? profileResponse2.oldestDataUpdated : str8;
        Long l10 = (i & 65536) != 0 ? profileResponse2.oldestDataUpdatedTimestamp : l4;
        Profile profile3 = (i & 131072) != 0 ? profileResponse2.profile : profile2;
        String str29 = (i & 262144) != 0 ? profileResponse2.registered : str9;
        Long l11 = (i & 524288) != 0 ? profileResponse2.registeredTimestamp : l5;
        String str30 = (i & 1048576) != 0 ? profileResponse2.signatureTimestamp : str10;
        String str31 = (i & 2097152) != 0 ? profileResponse2.socialProviders : str11;
        String str32 = (i & 4194304) != 0 ? profileResponse2.time : str12;
        String str33 = (i & 8388608) != 0 ? profileResponse2.verified : str13;
        Long l12 = (i & 16777216) != 0 ? profileResponse2.verifiedTimestamp : l6;
        String str34 = (i & 33554432) != 0 ? profileResponse2.status : str14;
        String str35 = (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? profileResponse2.errorMessage : str15;
        String str36 = (i & 134217728) != 0 ? profileResponse2.statusMessage : str16;
        if ((i & 268435456) != 0) {
            str19 = str36;
            str18 = profileResponse2.operation;
        } else {
            str18 = str17;
            str19 = str36;
        }
        return profileResponse2.copy(str26, str21, num3, str22, str23, l7, num4, bool4, bool5, bool6, str24, l8, str25, l9, str27, str28, l10, profile3, str29, l11, str30, str31, str32, str33, l12, str34, str35, str19, str18);
    }

    public final String component1() {
        return this.UID;
    }

    public final Boolean component10() {
        return this.isVerified;
    }

    public final String component11() {
        return this.lastLogin;
    }

    public final Long component12() {
        return this.lastLoginTimestamp;
    }

    public final String component13() {
        return this.lastUpdated;
    }

    public final Long component14() {
        return this.lastUpdatedTimestamp;
    }

    public final String component15() {
        return this.loginProvider;
    }

    public final String component16() {
        return this.oldestDataUpdated;
    }

    public final Long component17() {
        return this.oldestDataUpdatedTimestamp;
    }

    public final Profile component18() {
        return this.profile;
    }

    public final String component19() {
        return this.registered;
    }

    public final String component2() {
        return this.UIDSignature;
    }

    public final Long component20() {
        return this.registeredTimestamp;
    }

    public final String component21() {
        return this.signatureTimestamp;
    }

    public final String component22() {
        return this.socialProviders;
    }

    public final String component23() {
        return this.time;
    }

    public final String component24() {
        return this.verified;
    }

    public final Long component25() {
        return this.verifiedTimestamp;
    }

    public final String component26() {
        return this.status;
    }

    public final String component27() {
        return this.errorMessage;
    }

    public final String component28() {
        return this.statusMessage;
    }

    public final String component29() {
        return this.operation;
    }

    public final Integer component3() {
        return this.apiVersion;
    }

    public final String component4() {
        return this.callId;
    }

    public final String component5() {
        return this.created;
    }

    public final Long component6() {
        return this.createdTimestamp;
    }

    public final Integer component7() {
        return this.errorCode;
    }

    public final Boolean component8() {
        return this.isActive;
    }

    public final Boolean component9() {
        return this.isRegistered;
    }

    public final ProfileResponse copy(String str, String str2, Integer num, String str3, String str4, Long l, Integer num2, Boolean bool, Boolean bool2, Boolean bool3, String str5, Long l2, String str6, Long l3, String str7, String str8, Long l4, Profile profile2, String str9, Long l5, String str10, String str11, String str12, String str13, Long l6, String str14, String str15, String str16, String str17) {
        return new ProfileResponse(str, str2, num, str3, str4, l, num2, bool, bool2, bool3, str5, l2, str6, l3, str7, str8, l4, profile2, str9, l5, str10, str11, str12, str13, l6, str14, str15, str16, str17);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileResponse)) {
            return false;
        }
        ProfileResponse profileResponse = (ProfileResponse) obj;
        return Intrinsics.areEqual((Object) this.UID, (Object) profileResponse.UID) && Intrinsics.areEqual((Object) this.UIDSignature, (Object) profileResponse.UIDSignature) && Intrinsics.areEqual((Object) this.apiVersion, (Object) profileResponse.apiVersion) && Intrinsics.areEqual((Object) this.callId, (Object) profileResponse.callId) && Intrinsics.areEqual((Object) this.created, (Object) profileResponse.created) && Intrinsics.areEqual((Object) this.createdTimestamp, (Object) profileResponse.createdTimestamp) && Intrinsics.areEqual((Object) this.errorCode, (Object) profileResponse.errorCode) && Intrinsics.areEqual((Object) this.isActive, (Object) profileResponse.isActive) && Intrinsics.areEqual((Object) this.isRegistered, (Object) profileResponse.isRegistered) && Intrinsics.areEqual((Object) this.isVerified, (Object) profileResponse.isVerified) && Intrinsics.areEqual((Object) this.lastLogin, (Object) profileResponse.lastLogin) && Intrinsics.areEqual((Object) this.lastLoginTimestamp, (Object) profileResponse.lastLoginTimestamp) && Intrinsics.areEqual((Object) this.lastUpdated, (Object) profileResponse.lastUpdated) && Intrinsics.areEqual((Object) this.lastUpdatedTimestamp, (Object) profileResponse.lastUpdatedTimestamp) && Intrinsics.areEqual((Object) this.loginProvider, (Object) profileResponse.loginProvider) && Intrinsics.areEqual((Object) this.oldestDataUpdated, (Object) profileResponse.oldestDataUpdated) && Intrinsics.areEqual((Object) this.oldestDataUpdatedTimestamp, (Object) profileResponse.oldestDataUpdatedTimestamp) && Intrinsics.areEqual((Object) this.profile, (Object) profileResponse.profile) && Intrinsics.areEqual((Object) this.registered, (Object) profileResponse.registered) && Intrinsics.areEqual((Object) this.registeredTimestamp, (Object) profileResponse.registeredTimestamp) && Intrinsics.areEqual((Object) this.signatureTimestamp, (Object) profileResponse.signatureTimestamp) && Intrinsics.areEqual((Object) this.socialProviders, (Object) profileResponse.socialProviders) && Intrinsics.areEqual((Object) this.time, (Object) profileResponse.time) && Intrinsics.areEqual((Object) this.verified, (Object) profileResponse.verified) && Intrinsics.areEqual((Object) this.verifiedTimestamp, (Object) profileResponse.verifiedTimestamp) && Intrinsics.areEqual((Object) this.status, (Object) profileResponse.status) && Intrinsics.areEqual((Object) this.errorMessage, (Object) profileResponse.errorMessage) && Intrinsics.areEqual((Object) this.statusMessage, (Object) profileResponse.statusMessage) && Intrinsics.areEqual((Object) this.operation, (Object) profileResponse.operation);
    }

    public int hashCode() {
        String str = this.UID;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.UIDSignature;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.apiVersion;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.callId;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.created;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l = this.createdTimestamp;
        int hashCode6 = (hashCode5 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num2 = this.errorCode;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.isActive;
        int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isRegistered;
        int hashCode9 = (hashCode8 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isVerified;
        int hashCode10 = (hashCode9 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str5 = this.lastLogin;
        int hashCode11 = (hashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Long l2 = this.lastLoginTimestamp;
        int hashCode12 = (hashCode11 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str6 = this.lastUpdated;
        int hashCode13 = (hashCode12 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Long l3 = this.lastUpdatedTimestamp;
        int hashCode14 = (hashCode13 + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str7 = this.loginProvider;
        int hashCode15 = (hashCode14 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.oldestDataUpdated;
        int hashCode16 = (hashCode15 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Long l4 = this.oldestDataUpdatedTimestamp;
        int hashCode17 = (hashCode16 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Profile profile2 = this.profile;
        int hashCode18 = (hashCode17 + (profile2 == null ? 0 : profile2.hashCode())) * 31;
        String str9 = this.registered;
        int hashCode19 = (hashCode18 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Long l5 = this.registeredTimestamp;
        int hashCode20 = (hashCode19 + (l5 == null ? 0 : l5.hashCode())) * 31;
        String str10 = this.signatureTimestamp;
        int hashCode21 = (hashCode20 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.socialProviders;
        int hashCode22 = (hashCode21 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.time;
        int hashCode23 = (hashCode22 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.verified;
        int hashCode24 = (hashCode23 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Long l6 = this.verifiedTimestamp;
        int hashCode25 = (hashCode24 + (l6 == null ? 0 : l6.hashCode())) * 31;
        String str14 = this.status;
        int hashCode26 = (hashCode25 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.errorMessage;
        int hashCode27 = (hashCode26 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.statusMessage;
        int hashCode28 = (hashCode27 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.operation;
        if (str17 != null) {
            i = str17.hashCode();
        }
        return hashCode28 + i;
    }

    public String toString() {
        return "ProfileResponse(UID=" + this.UID + ", UIDSignature=" + this.UIDSignature + ", apiVersion=" + this.apiVersion + ", callId=" + this.callId + ", created=" + this.created + ", createdTimestamp=" + this.createdTimestamp + ", errorCode=" + this.errorCode + ", isActive=" + this.isActive + ", isRegistered=" + this.isRegistered + ", isVerified=" + this.isVerified + ", lastLogin=" + this.lastLogin + ", lastLoginTimestamp=" + this.lastLoginTimestamp + ", lastUpdated=" + this.lastUpdated + ", lastUpdatedTimestamp=" + this.lastUpdatedTimestamp + ", loginProvider=" + this.loginProvider + ", oldestDataUpdated=" + this.oldestDataUpdated + ", oldestDataUpdatedTimestamp=" + this.oldestDataUpdatedTimestamp + ", profile=" + this.profile + ", registered=" + this.registered + ", registeredTimestamp=" + this.registeredTimestamp + ", signatureTimestamp=" + this.signatureTimestamp + ", socialProviders=" + this.socialProviders + ", time=" + this.time + ", verified=" + this.verified + ", verifiedTimestamp=" + this.verifiedTimestamp + ", status=" + this.status + ", errorMessage=" + this.errorMessage + ", statusMessage=" + this.statusMessage + ", operation=" + this.operation + ')';
    }

    public ProfileResponse(String str, String str2, Integer num, String str3, String str4, Long l, Integer num2, Boolean bool, Boolean bool2, Boolean bool3, String str5, Long l2, String str6, Long l3, String str7, String str8, Long l4, Profile profile2, String str9, Long l5, String str10, String str11, String str12, String str13, Long l6, String str14, String str15, String str16, String str17) {
        this.UID = str;
        this.UIDSignature = str2;
        this.apiVersion = num;
        this.callId = str3;
        this.created = str4;
        this.createdTimestamp = l;
        this.errorCode = num2;
        this.isActive = bool;
        this.isRegistered = bool2;
        this.isVerified = bool3;
        this.lastLogin = str5;
        this.lastLoginTimestamp = l2;
        this.lastUpdated = str6;
        this.lastUpdatedTimestamp = l3;
        this.loginProvider = str7;
        this.oldestDataUpdated = str8;
        this.oldestDataUpdatedTimestamp = l4;
        this.profile = profile2;
        this.registered = str9;
        this.registeredTimestamp = l5;
        this.signatureTimestamp = str10;
        this.socialProviders = str11;
        this.time = str12;
        this.verified = str13;
        this.verifiedTimestamp = l6;
        this.status = str14;
        this.errorMessage = str15;
        this.statusMessage = str16;
        this.operation = str17;
    }

    public final String getUID() {
        return this.UID;
    }

    public final String getUIDSignature() {
        return this.UIDSignature;
    }

    public final Integer getApiVersion() {
        return this.apiVersion;
    }

    public final String getCallId() {
        return this.callId;
    }

    public final String getCreated() {
        return this.created;
    }

    public final Long getCreatedTimestamp() {
        return this.createdTimestamp;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final Boolean isActive() {
        return this.isActive;
    }

    public final Boolean isRegistered() {
        return this.isRegistered;
    }

    public final Boolean isVerified() {
        return this.isVerified;
    }

    public final String getLastLogin() {
        return this.lastLogin;
    }

    public final Long getLastLoginTimestamp() {
        return this.lastLoginTimestamp;
    }

    public final String getLastUpdated() {
        return this.lastUpdated;
    }

    public final Long getLastUpdatedTimestamp() {
        return this.lastUpdatedTimestamp;
    }

    public final String getLoginProvider() {
        return this.loginProvider;
    }

    public final String getOldestDataUpdated() {
        return this.oldestDataUpdated;
    }

    public final Long getOldestDataUpdatedTimestamp() {
        return this.oldestDataUpdatedTimestamp;
    }

    public final Profile getProfile() {
        return this.profile;
    }

    public final String getRegistered() {
        return this.registered;
    }

    public final Long getRegisteredTimestamp() {
        return this.registeredTimestamp;
    }

    public final String getSignatureTimestamp() {
        return this.signatureTimestamp;
    }

    public final String getSocialProviders() {
        return this.socialProviders;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getVerified() {
        return this.verified;
    }

    public final Long getVerifiedTimestamp() {
        return this.verifiedTimestamp;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final String getOperation() {
        return this.operation;
    }
}
