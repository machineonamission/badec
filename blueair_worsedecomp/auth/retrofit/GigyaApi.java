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

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\r\u000eJ\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'J,\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH'¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/blueair/auth/retrofit/GigyaApi;", "", "checkDataCenterForId", "Lretrofit2/Call;", "Lcom/blueair/auth/retrofit/GigyaApi$UserResponse;", "loginId", "", "apiKey", "getJWT", "Lcom/blueair/auth/retrofit/GigyaApi$GigyaJWTResponse;", "sessionSecret", "expiration", "", "UserResponse", "GigyaJWTResponse", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GigyaApi.kt */
public interface GigyaApi {
    @GET("accounts.isAvailableLoginID")
    Call<UserResponse> checkDataCenterForId(@Query("loginId") String str, @Query("apiKey") String str2);

    @FormUrlEncoded
    @POST("accounts.getJWT")
    Call<GigyaJWTResponse> getJWT(@Field("secret") String str, @Field("apiKey") String str2, @Field("expiration") int i);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b$\b\b\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jz\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0002\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013¨\u0006,"}, d2 = {"Lcom/blueair/auth/retrofit/GigyaApi$UserResponse;", "", "isAvailable", "", "fullEventName", "", "callId", "statusCode", "", "statusReason", "errorCode", "errorDetails", "errorMessage", "time", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFullEventName", "()Ljava/lang/String;", "getCallId", "getStatusCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatusReason", "getErrorCode", "getErrorDetails", "getErrorMessage", "getTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/blueair/auth/retrofit/GigyaApi$UserResponse;", "equals", "other", "hashCode", "toString", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GigyaApi.kt */
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

        public static /* synthetic */ UserResponse copy$default(UserResponse userResponse, Boolean bool, String str, String str2, Integer num, String str3, Integer num2, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = userResponse.isAvailable;
            }
            if ((i & 2) != 0) {
                str = userResponse.fullEventName;
            }
            if ((i & 4) != 0) {
                str2 = userResponse.callId;
            }
            if ((i & 8) != 0) {
                num = userResponse.statusCode;
            }
            if ((i & 16) != 0) {
                str3 = userResponse.statusReason;
            }
            if ((i & 32) != 0) {
                num2 = userResponse.errorCode;
            }
            if ((i & 64) != 0) {
                str4 = userResponse.errorDetails;
            }
            if ((i & 128) != 0) {
                str5 = userResponse.errorMessage;
            }
            if ((i & 256) != 0) {
                str6 = userResponse.time;
            }
            String str7 = str5;
            String str8 = str6;
            Integer num3 = num2;
            String str9 = str4;
            Integer num4 = num;
            String str10 = str3;
            return userResponse.copy(bool, str, str2, num4, str10, num3, str9, str7, str8);
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

        public final UserResponse copy(Boolean bool, String str, String str2, Integer num, String str3, Integer num2, String str4, String str5, String str6) {
            return new UserResponse(bool, str, str2, num, str3, num2, str4, str5, str6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserResponse)) {
                return false;
            }
            UserResponse userResponse = (UserResponse) obj;
            return Intrinsics.areEqual((Object) this.isAvailable, (Object) userResponse.isAvailable) && Intrinsics.areEqual((Object) this.fullEventName, (Object) userResponse.fullEventName) && Intrinsics.areEqual((Object) this.callId, (Object) userResponse.callId) && Intrinsics.areEqual((Object) this.statusCode, (Object) userResponse.statusCode) && Intrinsics.areEqual((Object) this.statusReason, (Object) userResponse.statusReason) && Intrinsics.areEqual((Object) this.errorCode, (Object) userResponse.errorCode) && Intrinsics.areEqual((Object) this.errorDetails, (Object) userResponse.errorDetails) && Intrinsics.areEqual((Object) this.errorMessage, (Object) userResponse.errorMessage) && Intrinsics.areEqual((Object) this.time, (Object) userResponse.time);
        }

        public int hashCode() {
            Boolean bool = this.isAvailable;
            int i = 0;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            String str = this.fullEventName;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.callId;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num = this.statusCode;
            int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            String str3 = this.statusReason;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num2 = this.errorCode;
            int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str4 = this.errorDetails;
            int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.errorMessage;
            int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.time;
            if (str6 != null) {
                i = str6.hashCode();
            }
            return hashCode8 + i;
        }

        public String toString() {
            return "UserResponse(isAvailable=" + this.isAvailable + ", fullEventName=" + this.fullEventName + ", callId=" + this.callId + ", statusCode=" + this.statusCode + ", statusReason=" + this.statusReason + ", errorCode=" + this.errorCode + ", errorDetails=" + this.errorDetails + ", errorMessage=" + this.errorMessage + ", time=" + this.time + ')';
        }

        public UserResponse(Boolean bool, String str, String str2, Integer num, String str3, Integer num2, String str4, String str5, String str6) {
            this.isAvailable = bool;
            this.fullEventName = str;
            this.callId = str2;
            this.statusCode = num;
            this.statusReason = str3;
            this.errorCode = num2;
            this.errorDetails = str4;
            this.errorMessage = str5;
            this.time = str6;
        }

        public final Boolean isAvailable() {
            return this.isAvailable;
        }

        public final String getFullEventName() {
            return this.fullEventName;
        }

        public final String getCallId() {
            return this.callId;
        }

        public final Integer getStatusCode() {
            return this.statusCode;
        }

        public final String getStatusReason() {
            return this.statusReason;
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

        public final String getTime() {
            return this.time;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/blueair/auth/retrofit/GigyaApi$GigyaJWTResponse;", "", "id_token", "", "statusCode", "errorCode", "errorMessage", "time", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId_token", "()Ljava/lang/String;", "getStatusCode", "getErrorCode", "getErrorMessage", "getTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GigyaApi.kt */
    public static final class GigyaJWTResponse {
        private final String errorCode;
        private final String errorMessage;
        private final String id_token;
        private final String statusCode;
        private final String time;

        public static /* synthetic */ GigyaJWTResponse copy$default(GigyaJWTResponse gigyaJWTResponse, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gigyaJWTResponse.id_token;
            }
            if ((i & 2) != 0) {
                str2 = gigyaJWTResponse.statusCode;
            }
            if ((i & 4) != 0) {
                str3 = gigyaJWTResponse.errorCode;
            }
            if ((i & 8) != 0) {
                str4 = gigyaJWTResponse.errorMessage;
            }
            if ((i & 16) != 0) {
                str5 = gigyaJWTResponse.time;
            }
            String str6 = str4;
            String str7 = str5;
            return gigyaJWTResponse.copy(str, str2, str3, str6, str7);
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

        public final GigyaJWTResponse copy(String str, String str2, String str3, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, "id_token");
            Intrinsics.checkNotNullParameter(str2, "statusCode");
            Intrinsics.checkNotNullParameter(str3, "errorCode");
            Intrinsics.checkNotNullParameter(str5, "time");
            return new GigyaJWTResponse(str, str2, str3, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GigyaJWTResponse)) {
                return false;
            }
            GigyaJWTResponse gigyaJWTResponse = (GigyaJWTResponse) obj;
            return Intrinsics.areEqual((Object) this.id_token, (Object) gigyaJWTResponse.id_token) && Intrinsics.areEqual((Object) this.statusCode, (Object) gigyaJWTResponse.statusCode) && Intrinsics.areEqual((Object) this.errorCode, (Object) gigyaJWTResponse.errorCode) && Intrinsics.areEqual((Object) this.errorMessage, (Object) gigyaJWTResponse.errorMessage) && Intrinsics.areEqual((Object) this.time, (Object) gigyaJWTResponse.time);
        }

        public int hashCode() {
            int hashCode = ((((this.id_token.hashCode() * 31) + this.statusCode.hashCode()) * 31) + this.errorCode.hashCode()) * 31;
            String str = this.errorMessage;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.time.hashCode();
        }

        public String toString() {
            return "GigyaJWTResponse(id_token=" + this.id_token + ", statusCode=" + this.statusCode + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", time=" + this.time + ')';
        }

        public GigyaJWTResponse(String str, String str2, String str3, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, "id_token");
            Intrinsics.checkNotNullParameter(str2, "statusCode");
            Intrinsics.checkNotNullParameter(str3, "errorCode");
            Intrinsics.checkNotNullParameter(str5, "time");
            this.id_token = str;
            this.statusCode = str2;
            this.errorCode = str3;
            this.errorMessage = str4;
            this.time = str5;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ GigyaJWTResponse(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i & 8) != 0 ? null : str4, str5);
        }

        public final String getId_token() {
            return this.id_token;
        }

        public final String getStatusCode() {
            return this.statusCode;
        }

        public final String getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final String getTime() {
            return this.time;
        }
    }
}
