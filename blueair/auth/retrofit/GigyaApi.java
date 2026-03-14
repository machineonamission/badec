package com.blueair.auth.retrofit;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\r\u000eJ\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'J,\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH'¨\u0006\u000fÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/auth/retrofit/GigyaApi;", "", "checkDataCenterForId", "Lretrofit2/Call;", "Lcom/blueair/auth/retrofit/GigyaApi$UserResponse;", "loginId", "", "apiKey", "getJWT", "Lcom/blueair/auth/retrofit/GigyaApi$GigyaJWTResponse;", "sessionSecret", "expiration", "", "UserResponse", "GigyaJWTResponse", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface GigyaApi {
   @GET("accounts.isAvailableLoginID")
   Call checkDataCenterForId(@Query("loginId") String var1, @Query("apiKey") String var2);

   @FormUrlEncoded
   @POST("accounts.getJWT")
   Call getJWT(@Field("secret") String var1, @Field("apiKey") String var2, @Field("expiration") int var3);

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"},
      d2 = {"Lcom/blueair/auth/retrofit/GigyaApi$GigyaJWTResponse;", "", "id_token", "", "statusCode", "errorCode", "errorMessage", "time", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId_token", "()Ljava/lang/String;", "getStatusCode", "getErrorCode", "getErrorMessage", "getTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class GigyaJWTResponse {
      private final String errorCode;
      private final String errorMessage;
      private final String id_token;
      private final String statusCode;
      private final String time;

      public GigyaJWTResponse(String var1, String var2, String var3, String var4, String var5) {
         Intrinsics.checkNotNullParameter(var1, "id_token");
         Intrinsics.checkNotNullParameter(var2, "statusCode");
         Intrinsics.checkNotNullParameter(var3, "errorCode");
         Intrinsics.checkNotNullParameter(var5, "time");
         super();
         this.id_token = var1;
         this.statusCode = var2;
         this.errorCode = var3;
         this.errorMessage = var4;
         this.time = var5;
      }

      // $FF: synthetic method
      public GigyaJWTResponse(String var1, String var2, String var3, String var4, String var5, int var6, DefaultConstructorMarker var7) {
         if ((var6 & 8) != 0) {
            var4 = null;
         }

         this(var1, var2, var3, var4, var5);
      }

      // $FF: synthetic method
      public static GigyaJWTResponse copy$default(GigyaJWTResponse var0, String var1, String var2, String var3, String var4, String var5, int var6, Object var7) {
         if ((var6 & 1) != 0) {
            var1 = var0.id_token;
         }

         if ((var6 & 2) != 0) {
            var2 = var0.statusCode;
         }

         if ((var6 & 4) != 0) {
            var3 = var0.errorCode;
         }

         if ((var6 & 8) != 0) {
            var4 = var0.errorMessage;
         }

         if ((var6 & 16) != 0) {
            var5 = var0.time;
         }

         return var0.copy(var1, var2, var3, var4, var5);
      }

      public final String component1() {
         return this.id_token;
      }

      public final String component2() {
         return this.statusCode;
      }

      public final String component3() {
         return this.errorCode;
      }

      public final String component4() {
         return this.errorMessage;
      }

      public final String component5() {
         return this.time;
      }

      public final GigyaJWTResponse copy(String var1, String var2, String var3, String var4, String var5) {
         Intrinsics.checkNotNullParameter(var1, "id_token");
         Intrinsics.checkNotNullParameter(var2, "statusCode");
         Intrinsics.checkNotNullParameter(var3, "errorCode");
         Intrinsics.checkNotNullParameter(var5, "time");
         return new GigyaJWTResponse(var1, var2, var3, var4, var5);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof GigyaJWTResponse)) {
            return false;
         } else {
            var1 = var1;
            if (!Intrinsics.areEqual(this.id_token, var1.id_token)) {
               return false;
            } else if (!Intrinsics.areEqual(this.statusCode, var1.statusCode)) {
               return false;
            } else if (!Intrinsics.areEqual(this.errorCode, var1.errorCode)) {
               return false;
            } else if (!Intrinsics.areEqual(this.errorMessage, var1.errorMessage)) {
               return false;
            } else {
               return Intrinsics.areEqual(this.time, var1.time);
            }
         }
      }

      public final String getErrorCode() {
         return this.errorCode;
      }

      public final String getErrorMessage() {
         return this.errorMessage;
      }

      public final String getId_token() {
         return this.id_token;
      }

      public final String getStatusCode() {
         return this.statusCode;
      }

      public final String getTime() {
         return this.time;
      }

      public int hashCode() {
         int var3 = this.id_token.hashCode();
         int var4 = this.statusCode.hashCode();
         int var2 = this.errorCode.hashCode();
         String var5 = this.errorMessage;
         int var1;
         if (var5 == null) {
            var1 = 0;
         } else {
            var1 = var5.hashCode();
         }

         return (((var3 * 31 + var4) * 31 + var2) * 31 + var1) * 31 + this.time.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("GigyaJWTResponse(id_token=");
         var1.append(this.id_token);
         var1.append(", statusCode=");
         var1.append(this.statusCode);
         var1.append(", errorCode=");
         var1.append(this.errorCode);
         var1.append(", errorMessage=");
         var1.append(this.errorMessage);
         var1.append(", time=");
         var1.append(this.time);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b$\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jz\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0002\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013¨\u0006,"},
      d2 = {"Lcom/blueair/auth/retrofit/GigyaApi$UserResponse;", "", "isAvailable", "", "fullEventName", "", "callId", "statusCode", "", "statusReason", "errorCode", "errorDetails", "errorMessage", "time", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFullEventName", "()Ljava/lang/String;", "getCallId", "getStatusCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatusReason", "getErrorCode", "getErrorDetails", "getErrorMessage", "getTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/blueair/auth/retrofit/GigyaApi$UserResponse;", "equals", "other", "hashCode", "toString", "auth_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class UserResponse {
      private final String callId;
      private final Integer errorCode;
      private final String errorDetails;
      private final String errorMessage;
      private final String fullEventName;
      private final Boolean isAvailable;
      private final Integer statusCode;
      private final String statusReason;
      private final String time;

      public UserResponse(Boolean var1, String var2, String var3, Integer var4, String var5, Integer var6, String var7, String var8, String var9) {
         this.isAvailable = var1;
         this.fullEventName = var2;
         this.callId = var3;
         this.statusCode = var4;
         this.statusReason = var5;
         this.errorCode = var6;
         this.errorDetails = var7;
         this.errorMessage = var8;
         this.time = var9;
      }

      // $FF: synthetic method
      public static UserResponse copy$default(UserResponse var0, Boolean var1, String var2, String var3, Integer var4, String var5, Integer var6, String var7, String var8, String var9, int var10, Object var11) {
         if ((var10 & 1) != 0) {
            var1 = var0.isAvailable;
         }

         if ((var10 & 2) != 0) {
            var2 = var0.fullEventName;
         }

         if ((var10 & 4) != 0) {
            var3 = var0.callId;
         }

         if ((var10 & 8) != 0) {
            var4 = var0.statusCode;
         }

         if ((var10 & 16) != 0) {
            var5 = var0.statusReason;
         }

         if ((var10 & 32) != 0) {
            var6 = var0.errorCode;
         }

         if ((var10 & 64) != 0) {
            var7 = var0.errorDetails;
         }

         if ((var10 & 128) != 0) {
            var8 = var0.errorMessage;
         }

         if ((var10 & 256) != 0) {
            var9 = var0.time;
         }

         return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

      public final Boolean component1() {
         return this.isAvailable;
      }

      public final String component2() {
         return this.fullEventName;
      }

      public final String component3() {
         return this.callId;
      }

      public final Integer component4() {
         return this.statusCode;
      }

      public final String component5() {
         return this.statusReason;
      }

      public final Integer component6() {
         return this.errorCode;
      }

      public final String component7() {
         return this.errorDetails;
      }

      public final String component8() {
         return this.errorMessage;
      }

      public final String component9() {
         return this.time;
      }

      public final UserResponse copy(Boolean var1, String var2, String var3, Integer var4, String var5, Integer var6, String var7, String var8, String var9) {
         return new UserResponse(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof UserResponse)) {
            return false;
         } else {
            var1 = var1;
            if (!Intrinsics.areEqual(this.isAvailable, var1.isAvailable)) {
               return false;
            } else if (!Intrinsics.areEqual(this.fullEventName, var1.fullEventName)) {
               return false;
            } else if (!Intrinsics.areEqual(this.callId, var1.callId)) {
               return false;
            } else if (!Intrinsics.areEqual(this.statusCode, var1.statusCode)) {
               return false;
            } else if (!Intrinsics.areEqual(this.statusReason, var1.statusReason)) {
               return false;
            } else if (!Intrinsics.areEqual(this.errorCode, var1.errorCode)) {
               return false;
            } else if (!Intrinsics.areEqual(this.errorDetails, var1.errorDetails)) {
               return false;
            } else if (!Intrinsics.areEqual(this.errorMessage, var1.errorMessage)) {
               return false;
            } else {
               return Intrinsics.areEqual(this.time, var1.time);
            }
         }
      }

      public final String getCallId() {
         return this.callId;
      }

      public final Integer getErrorCode() {
         return this.errorCode;
      }

      public final String getErrorDetails() {
         return this.errorDetails;
      }

      public final String getErrorMessage() {
         return this.errorMessage;
      }

      public final String getFullEventName() {
         return this.fullEventName;
      }

      public final Integer getStatusCode() {
         return this.statusCode;
      }

      public final String getStatusReason() {
         return this.statusReason;
      }

      public final String getTime() {
         return this.time;
      }

      public int hashCode() {
         Boolean var10 = this.isAvailable;
         int var9 = 0;
         int var1;
         if (var10 == null) {
            var1 = 0;
         } else {
            var1 = var10.hashCode();
         }

         String var11 = this.fullEventName;
         int var2;
         if (var11 == null) {
            var2 = 0;
         } else {
            var2 = var11.hashCode();
         }

         var11 = this.callId;
         int var3;
         if (var11 == null) {
            var3 = 0;
         } else {
            var3 = var11.hashCode();
         }

         Integer var13 = this.statusCode;
         int var4;
         if (var13 == null) {
            var4 = 0;
         } else {
            var4 = var13.hashCode();
         }

         String var14 = this.statusReason;
         int var5;
         if (var14 == null) {
            var5 = 0;
         } else {
            var5 = var14.hashCode();
         }

         Integer var15 = this.errorCode;
         int var6;
         if (var15 == null) {
            var6 = 0;
         } else {
            var6 = var15.hashCode();
         }

         String var16 = this.errorDetails;
         int var7;
         if (var16 == null) {
            var7 = 0;
         } else {
            var7 = var16.hashCode();
         }

         var16 = this.errorMessage;
         int var8;
         if (var16 == null) {
            var8 = 0;
         } else {
            var8 = var16.hashCode();
         }

         var16 = this.time;
         if (var16 != null) {
            var9 = var16.hashCode();
         }

         return (((((((var1 * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var7) * 31 + var8) * 31 + var9;
      }

      public final Boolean isAvailable() {
         return this.isAvailable;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("UserResponse(isAvailable=");
         var1.append(this.isAvailable);
         var1.append(", fullEventName=");
         var1.append(this.fullEventName);
         var1.append(", callId=");
         var1.append(this.callId);
         var1.append(", statusCode=");
         var1.append(this.statusCode);
         var1.append(", statusReason=");
         var1.append(this.statusReason);
         var1.append(", errorCode=");
         var1.append(this.errorCode);
         var1.append(", errorDetails=");
         var1.append(this.errorDetails);
         var1.append(", errorMessage=");
         var1.append(this.errorMessage);
         var1.append(", time=");
         var1.append(this.time);
         var1.append(')');
         return var1.toString();
      }
   }
}
