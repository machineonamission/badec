package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bS\b\u0087\b\u0018\u00002\u00020\u0001B©\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b$\u0010%J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010N\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010O\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010P\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010Q\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jê\u0002\u0010e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010fJ\u0013\u0010g\u001a\u00020\r2\b\u0010h\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010i\u001a\u00020\u0006HÖ\u0001J\t\u0010j\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010'R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010+\u001a\u0004\b1\u0010*R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00103\u001a\u0004\b\f\u00102R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00103\u001a\u0004\b\u000e\u00102R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00103\u001a\u0004\b\u000f\u00102R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010'R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00100\u001a\u0004\b5\u0010/R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010'R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00100\u001a\u0004\b7\u0010/R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010'R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010'R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00100\u001a\u0004\b:\u0010/R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010'R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00100\u001a\u0004\b>\u0010/R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010'R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010'R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010'R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010'R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00100\u001a\u0004\bC\u0010/R\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010'R\u0013\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010'R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010'R\u0013\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010'¨\u0006k"},
   d2 = {"Lcom/blueair/core/model/ProfileResponse;", "", "UID", "", "UIDSignature", "apiVersion", "", "callId", "created", "createdTimestamp", "", "errorCode", "isActive", "", "isRegistered", "isVerified", "lastLogin", "lastLoginTimestamp", "lastUpdated", "lastUpdatedTimestamp", "loginProvider", "oldestDataUpdated", "oldestDataUpdatedTimestamp", "profile", "Lcom/blueair/core/model/Profile;", "registered", "registeredTimestamp", "signatureTimestamp", "socialProviders", "time", "verified", "verifiedTimestamp", "status", "errorMessage", "statusMessage", "operation", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/blueair/core/model/Profile;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUID", "()Ljava/lang/String;", "getUIDSignature", "getApiVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCallId", "getCreated", "getCreatedTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getErrorCode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLastLogin", "getLastLoginTimestamp", "getLastUpdated", "getLastUpdatedTimestamp", "getLoginProvider", "getOldestDataUpdated", "getOldestDataUpdatedTimestamp", "getProfile", "()Lcom/blueair/core/model/Profile;", "getRegistered", "getRegisteredTimestamp", "getSignatureTimestamp", "getSocialProviders", "getTime", "getVerified", "getVerifiedTimestamp", "getStatus", "getErrorMessage", "getStatusMessage", "getOperation", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/blueair/core/model/Profile;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/blueair/core/model/ProfileResponse;", "equals", "other", "hashCode", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
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

   public ProfileResponse(String var1, String var2, Integer var3, String var4, String var5, Long var6, Integer var7, Boolean var8, Boolean var9, Boolean var10, String var11, Long var12, String var13, Long var14, String var15, String var16, Long var17, Profile var18, String var19, Long var20, String var21, String var22, String var23, String var24, Long var25, String var26, String var27, String var28, String var29) {
      this.UID = var1;
      this.UIDSignature = var2;
      this.apiVersion = var3;
      this.callId = var4;
      this.created = var5;
      this.createdTimestamp = var6;
      this.errorCode = var7;
      this.isActive = var8;
      this.isRegistered = var9;
      this.isVerified = var10;
      this.lastLogin = var11;
      this.lastLoginTimestamp = var12;
      this.lastUpdated = var13;
      this.lastUpdatedTimestamp = var14;
      this.loginProvider = var15;
      this.oldestDataUpdated = var16;
      this.oldestDataUpdatedTimestamp = var17;
      this.profile = var18;
      this.registered = var19;
      this.registeredTimestamp = var20;
      this.signatureTimestamp = var21;
      this.socialProviders = var22;
      this.time = var23;
      this.verified = var24;
      this.verifiedTimestamp = var25;
      this.status = var26;
      this.errorMessage = var27;
      this.statusMessage = var28;
      this.operation = var29;
   }

   // $FF: synthetic method
   public static ProfileResponse copy$default(ProfileResponse var0, String var1, String var2, Integer var3, String var4, String var5, Long var6, Integer var7, Boolean var8, Boolean var9, Boolean var10, String var11, Long var12, String var13, Long var14, String var15, String var16, Long var17, Profile var18, String var19, Long var20, String var21, String var22, String var23, String var24, Long var25, String var26, String var27, String var28, String var29, int var30, Object var31) {
      if ((var30 & 1) != 0) {
         var1 = var0.UID;
      }

      if ((var30 & 2) != 0) {
         var2 = var0.UIDSignature;
      }

      if ((var30 & 4) != 0) {
         var3 = var0.apiVersion;
      }

      if ((var30 & 8) != 0) {
         var4 = var0.callId;
      }

      if ((var30 & 16) != 0) {
         var5 = var0.created;
      }

      if ((var30 & 32) != 0) {
         var6 = var0.createdTimestamp;
      }

      if ((var30 & 64) != 0) {
         var7 = var0.errorCode;
      }

      if ((var30 & 128) != 0) {
         var8 = var0.isActive;
      }

      if ((var30 & 256) != 0) {
         var9 = var0.isRegistered;
      }

      if ((var30 & 512) != 0) {
         var10 = var0.isVerified;
      }

      if ((var30 & 1024) != 0) {
         var11 = var0.lastLogin;
      }

      if ((var30 & 2048) != 0) {
         var12 = var0.lastLoginTimestamp;
      }

      if ((var30 & 4096) != 0) {
         var13 = var0.lastUpdated;
      }

      if ((var30 & 8192) != 0) {
         var14 = var0.lastUpdatedTimestamp;
      }

      if ((var30 & 16384) != 0) {
         var15 = var0.loginProvider;
      }

      if ((var30 & '耀') != 0) {
         var16 = var0.oldestDataUpdated;
      }

      if ((var30 & 65536) != 0) {
         var17 = var0.oldestDataUpdatedTimestamp;
      }

      if ((var30 & 131072) != 0) {
         var18 = var0.profile;
      }

      if ((var30 & 262144) != 0) {
         var19 = var0.registered;
      }

      if ((var30 & 524288) != 0) {
         var20 = var0.registeredTimestamp;
      }

      if ((var30 & 1048576) != 0) {
         var21 = var0.signatureTimestamp;
      }

      if ((var30 & 2097152) != 0) {
         var22 = var0.socialProviders;
      }

      if ((var30 & 4194304) != 0) {
         var23 = var0.time;
      }

      if ((var30 & 8388608) != 0) {
         var24 = var0.verified;
      }

      if ((var30 & 16777216) != 0) {
         var25 = var0.verifiedTimestamp;
      }

      if ((var30 & 33554432) != 0) {
         var26 = var0.status;
      }

      if ((var30 & 67108864) != 0) {
         var27 = var0.errorMessage;
      }

      if ((var30 & 134217728) != 0) {
         var28 = var0.statusMessage;
      }

      if ((var30 & 268435456) != 0) {
         var29 = var0.operation;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29);
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

   public final ProfileResponse copy(String var1, String var2, Integer var3, String var4, String var5, Long var6, Integer var7, Boolean var8, Boolean var9, Boolean var10, String var11, Long var12, String var13, Long var14, String var15, String var16, Long var17, Profile var18, String var19, Long var20, String var21, String var22, String var23, String var24, Long var25, String var26, String var27, String var28, String var29) {
      return new ProfileResponse(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof ProfileResponse)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.UID, var1.UID)) {
            return false;
         } else if (!Intrinsics.areEqual(this.UIDSignature, var1.UIDSignature)) {
            return false;
         } else if (!Intrinsics.areEqual(this.apiVersion, var1.apiVersion)) {
            return false;
         } else if (!Intrinsics.areEqual(this.callId, var1.callId)) {
            return false;
         } else if (!Intrinsics.areEqual(this.created, var1.created)) {
            return false;
         } else if (!Intrinsics.areEqual(this.createdTimestamp, var1.createdTimestamp)) {
            return false;
         } else if (!Intrinsics.areEqual(this.errorCode, var1.errorCode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.isActive, var1.isActive)) {
            return false;
         } else if (!Intrinsics.areEqual(this.isRegistered, var1.isRegistered)) {
            return false;
         } else if (!Intrinsics.areEqual(this.isVerified, var1.isVerified)) {
            return false;
         } else if (!Intrinsics.areEqual(this.lastLogin, var1.lastLogin)) {
            return false;
         } else if (!Intrinsics.areEqual(this.lastLoginTimestamp, var1.lastLoginTimestamp)) {
            return false;
         } else if (!Intrinsics.areEqual(this.lastUpdated, var1.lastUpdated)) {
            return false;
         } else if (!Intrinsics.areEqual(this.lastUpdatedTimestamp, var1.lastUpdatedTimestamp)) {
            return false;
         } else if (!Intrinsics.areEqual(this.loginProvider, var1.loginProvider)) {
            return false;
         } else if (!Intrinsics.areEqual(this.oldestDataUpdated, var1.oldestDataUpdated)) {
            return false;
         } else if (!Intrinsics.areEqual(this.oldestDataUpdatedTimestamp, var1.oldestDataUpdatedTimestamp)) {
            return false;
         } else if (!Intrinsics.areEqual(this.profile, var1.profile)) {
            return false;
         } else if (!Intrinsics.areEqual(this.registered, var1.registered)) {
            return false;
         } else if (!Intrinsics.areEqual(this.registeredTimestamp, var1.registeredTimestamp)) {
            return false;
         } else if (!Intrinsics.areEqual(this.signatureTimestamp, var1.signatureTimestamp)) {
            return false;
         } else if (!Intrinsics.areEqual(this.socialProviders, var1.socialProviders)) {
            return false;
         } else if (!Intrinsics.areEqual(this.time, var1.time)) {
            return false;
         } else if (!Intrinsics.areEqual(this.verified, var1.verified)) {
            return false;
         } else if (!Intrinsics.areEqual(this.verifiedTimestamp, var1.verifiedTimestamp)) {
            return false;
         } else if (!Intrinsics.areEqual(this.status, var1.status)) {
            return false;
         } else if (!Intrinsics.areEqual(this.errorMessage, var1.errorMessage)) {
            return false;
         } else if (!Intrinsics.areEqual(this.statusMessage, var1.statusMessage)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.operation, var1.operation);
         }
      }
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

   public final String getErrorMessage() {
      return this.errorMessage;
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

   public final String getOperation() {
      return this.operation;
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

   public final String getStatus() {
      return this.status;
   }

   public final String getStatusMessage() {
      return this.statusMessage;
   }

   public final String getTime() {
      return this.time;
   }

   public final String getUID() {
      return this.UID;
   }

   public final String getUIDSignature() {
      return this.UIDSignature;
   }

   public final String getVerified() {
      return this.verified;
   }

   public final Long getVerifiedTimestamp() {
      return this.verifiedTimestamp;
   }

   public int hashCode() {
      String var30 = this.UID;
      int var29 = 0;
      int var1;
      if (var30 == null) {
         var1 = 0;
      } else {
         var1 = var30.hashCode();
      }

      var30 = this.UIDSignature;
      int var2;
      if (var30 == null) {
         var2 = 0;
      } else {
         var2 = var30.hashCode();
      }

      Integer var32 = this.apiVersion;
      int var3;
      if (var32 == null) {
         var3 = 0;
      } else {
         var3 = var32.hashCode();
      }

      String var33 = this.callId;
      int var4;
      if (var33 == null) {
         var4 = 0;
      } else {
         var4 = var33.hashCode();
      }

      var33 = this.created;
      int var5;
      if (var33 == null) {
         var5 = 0;
      } else {
         var5 = var33.hashCode();
      }

      Long var35 = this.createdTimestamp;
      int var6;
      if (var35 == null) {
         var6 = 0;
      } else {
         var6 = var35.hashCode();
      }

      Integer var36 = this.errorCode;
      int var7;
      if (var36 == null) {
         var7 = 0;
      } else {
         var7 = var36.hashCode();
      }

      Boolean var37 = this.isActive;
      int var8;
      if (var37 == null) {
         var8 = 0;
      } else {
         var8 = var37.hashCode();
      }

      var37 = this.isRegistered;
      int var9;
      if (var37 == null) {
         var9 = 0;
      } else {
         var9 = var37.hashCode();
      }

      var37 = this.isVerified;
      int var10;
      if (var37 == null) {
         var10 = 0;
      } else {
         var10 = var37.hashCode();
      }

      String var40 = this.lastLogin;
      int var11;
      if (var40 == null) {
         var11 = 0;
      } else {
         var11 = var40.hashCode();
      }

      Long var41 = this.lastLoginTimestamp;
      int var12;
      if (var41 == null) {
         var12 = 0;
      } else {
         var12 = var41.hashCode();
      }

      String var42 = this.lastUpdated;
      int var13;
      if (var42 == null) {
         var13 = 0;
      } else {
         var13 = var42.hashCode();
      }

      Long var43 = this.lastUpdatedTimestamp;
      int var14;
      if (var43 == null) {
         var14 = 0;
      } else {
         var14 = var43.hashCode();
      }

      String var44 = this.loginProvider;
      int var15;
      if (var44 == null) {
         var15 = 0;
      } else {
         var15 = var44.hashCode();
      }

      var44 = this.oldestDataUpdated;
      int var16;
      if (var44 == null) {
         var16 = 0;
      } else {
         var16 = var44.hashCode();
      }

      Long var46 = this.oldestDataUpdatedTimestamp;
      int var17;
      if (var46 == null) {
         var17 = 0;
      } else {
         var17 = var46.hashCode();
      }

      Profile var47 = this.profile;
      int var18;
      if (var47 == null) {
         var18 = 0;
      } else {
         var18 = var47.hashCode();
      }

      String var48 = this.registered;
      int var19;
      if (var48 == null) {
         var19 = 0;
      } else {
         var19 = var48.hashCode();
      }

      Long var49 = this.registeredTimestamp;
      int var20;
      if (var49 == null) {
         var20 = 0;
      } else {
         var20 = var49.hashCode();
      }

      String var50 = this.signatureTimestamp;
      int var21;
      if (var50 == null) {
         var21 = 0;
      } else {
         var21 = var50.hashCode();
      }

      var50 = this.socialProviders;
      int var22;
      if (var50 == null) {
         var22 = 0;
      } else {
         var22 = var50.hashCode();
      }

      var50 = this.time;
      int var23;
      if (var50 == null) {
         var23 = 0;
      } else {
         var23 = var50.hashCode();
      }

      var50 = this.verified;
      int var24;
      if (var50 == null) {
         var24 = 0;
      } else {
         var24 = var50.hashCode();
      }

      Long var54 = this.verifiedTimestamp;
      int var25;
      if (var54 == null) {
         var25 = 0;
      } else {
         var25 = var54.hashCode();
      }

      String var55 = this.status;
      int var26;
      if (var55 == null) {
         var26 = 0;
      } else {
         var26 = var55.hashCode();
      }

      var55 = this.errorMessage;
      int var27;
      if (var55 == null) {
         var27 = 0;
      } else {
         var27 = var55.hashCode();
      }

      var55 = this.statusMessage;
      int var28;
      if (var55 == null) {
         var28 = 0;
      } else {
         var28 = var55.hashCode();
      }

      var55 = this.operation;
      if (var55 != null) {
         var29 = var55.hashCode();
      }

      return (((((((((((((((((((((((((((var1 * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var7) * 31 + var8) * 31 + var9) * 31 + var10) * 31 + var11) * 31 + var12) * 31 + var13) * 31 + var14) * 31 + var15) * 31 + var16) * 31 + var17) * 31 + var18) * 31 + var19) * 31 + var20) * 31 + var21) * 31 + var22) * 31 + var23) * 31 + var24) * 31 + var25) * 31 + var26) * 31 + var27) * 31 + var28) * 31 + var29;
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

   public String toString() {
      StringBuilder var1 = new StringBuilder("ProfileResponse(UID=");
      var1.append(this.UID);
      var1.append(", UIDSignature=");
      var1.append(this.UIDSignature);
      var1.append(", apiVersion=");
      var1.append(this.apiVersion);
      var1.append(", callId=");
      var1.append(this.callId);
      var1.append(", created=");
      var1.append(this.created);
      var1.append(", createdTimestamp=");
      var1.append(this.createdTimestamp);
      var1.append(", errorCode=");
      var1.append(this.errorCode);
      var1.append(", isActive=");
      var1.append(this.isActive);
      var1.append(", isRegistered=");
      var1.append(this.isRegistered);
      var1.append(", isVerified=");
      var1.append(this.isVerified);
      var1.append(", lastLogin=");
      var1.append(this.lastLogin);
      var1.append(", lastLoginTimestamp=");
      var1.append(this.lastLoginTimestamp);
      var1.append(", lastUpdated=");
      var1.append(this.lastUpdated);
      var1.append(", lastUpdatedTimestamp=");
      var1.append(this.lastUpdatedTimestamp);
      var1.append(", loginProvider=");
      var1.append(this.loginProvider);
      var1.append(", oldestDataUpdated=");
      var1.append(this.oldestDataUpdated);
      var1.append(", oldestDataUpdatedTimestamp=");
      var1.append(this.oldestDataUpdatedTimestamp);
      var1.append(", profile=");
      var1.append(this.profile);
      var1.append(", registered=");
      var1.append(this.registered);
      var1.append(", registeredTimestamp=");
      var1.append(this.registeredTimestamp);
      var1.append(", signatureTimestamp=");
      var1.append(this.signatureTimestamp);
      var1.append(", socialProviders=");
      var1.append(this.socialProviders);
      var1.append(", time=");
      var1.append(this.time);
      var1.append(", verified=");
      var1.append(this.verified);
      var1.append(", verifiedTimestamp=");
      var1.append(this.verifiedTimestamp);
      var1.append(", status=");
      var1.append(this.status);
      var1.append(", errorMessage=");
      var1.append(this.errorMessage);
      var1.append(", statusMessage=");
      var1.append(this.statusMessage);
      var1.append(", operation=");
      var1.append(this.operation);
      var1.append(')');
      return var1.toString();
   }
}
