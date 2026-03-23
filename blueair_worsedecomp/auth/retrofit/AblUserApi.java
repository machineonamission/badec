package com.blueair.auth.retrofit;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000 \u001a2\u00020\u0001:\u0005\u001a\u001b\u001c\u001d\u001eJ\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0001\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\tJ(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0012\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u0013J$\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00032\b\b\u0001\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\tJ(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0018\u001a\u00020\u0016H§@¢\u0006\u0002\u0010\u0019¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Lcom/blueair/auth/retrofit/AblUserApi;", "", "getSpecificRegionSync", "Lretrofit2/Response;", "Lcom/blueair/auth/retrofit/AblUserApi$BlueairGranularRegion;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHomehost", "", "username", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doTokenExchange", "Lcom/blueair/auth/retrofit/AblUserApi$GigyaJwtTokenExchange;", "jwtExchange", "(Lcom/blueair/auth/retrofit/AblUserApi$GigyaJwtTokenExchange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUser", "Lcom/blueair/auth/retrofit/AblUserApi$AblUser;", "setLanguage", "", "language", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttributes", "", "Lcom/blueair/auth/retrofit/AblUserApi$UserAttribute;", "setExternalUidAttr", "userAttribute", "(Ljava/lang/String;Lcom/blueair/auth/retrofit/AblUserApi$UserAttribute;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "BlueairGranularRegion", "GigyaJwtTokenExchange", "AblUser", "UserAttribute", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AblUserApi.kt */
public interface AblUserApi {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String USERNAME = "username";

    @POST("v2/token/exchange")
    Object doTokenExchange(@Body GigyaJwtTokenExchange gigyaJwtTokenExchange, Continuation<? super Response<GigyaJwtTokenExchange>> continuation);

    @GET("v2/user/{username}/attributes/")
    Object getAttributes(@Path("username") String str, Continuation<? super Response<List<UserAttribute>>> continuation);

    @GET("v2/user/{username}/homehost/")
    @Headers({"AuthDelegation: IdentityLab"})
    Object getHomehost(@Path("username") String str, Continuation<? super Response<String>> continuation);

    @GET("v2/geocode/ip")
    Object getSpecificRegionSync(Continuation<? super Response<BlueairGranularRegion>> continuation);

    @GET("v2/user/{username}/get/")
    Object getUser(@Path("username") String str, Continuation<? super Response<AblUser>> continuation);

    @GET("v2/user/{username}/attributes/ext_uid")
    Object setExternalUidAttr(@Path("username") String str, @Body UserAttribute userAttribute, Continuation<? super Response<String>> continuation);

    @POST("v2/user/{username}/language/{language}/")
    Object setLanguage(@Path("username") String str, @Path("language") String str2, Continuation<? super Response<Unit>> continuation);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/blueair/auth/retrofit/AblUserApi$Companion;", "", "<init>", "()V", "USERNAME", "", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AblUserApi.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String USERNAME = "username";

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/blueair/auth/retrofit/AblUserApi$BlueairGranularRegion;", "", "countryCode", "", "<init>", "(Ljava/lang/String;)V", "getCountryCode", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AblUserApi.kt */
    public static final class BlueairGranularRegion {
        private final String countryCode;

        public static /* synthetic */ BlueairGranularRegion copy$default(BlueairGranularRegion blueairGranularRegion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = blueairGranularRegion.countryCode;
            }
            return blueairGranularRegion.copy(str);
        }

        public final String component1() {
            return this.countryCode;
        }

        public final BlueairGranularRegion copy(String str) {
            Intrinsics.checkNotNullParameter(str, RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE);
            return new BlueairGranularRegion(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BlueairGranularRegion) && Intrinsics.areEqual((Object) this.countryCode, (Object) ((BlueairGranularRegion) obj).countryCode);
        }

        public int hashCode() {
            return this.countryCode.hashCode();
        }

        public String toString() {
            return "BlueairGranularRegion(countryCode=" + this.countryCode + ')';
        }

        public BlueairGranularRegion(String str) {
            Intrinsics.checkNotNullParameter(str, RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE);
            this.countryCode = str;
        }

        public final String getCountryCode() {
            return this.countryCode;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/blueair/auth/retrofit/AblUserApi$GigyaJwtTokenExchange;", "", "token", "", "provider", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getProvider", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AblUserApi.kt */
    public static final class GigyaJwtTokenExchange {
        private final String provider;
        private final String token;

        public static /* synthetic */ GigyaJwtTokenExchange copy$default(GigyaJwtTokenExchange gigyaJwtTokenExchange, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gigyaJwtTokenExchange.token;
            }
            if ((i & 2) != 0) {
                str2 = gigyaJwtTokenExchange.provider;
            }
            return gigyaJwtTokenExchange.copy(str, str2);
        }

        public final String component1() {
            return this.token;
        }

        public final String component2() {
            return this.provider;
        }

        public final GigyaJwtTokenExchange copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "token");
            return new GigyaJwtTokenExchange(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GigyaJwtTokenExchange)) {
                return false;
            }
            GigyaJwtTokenExchange gigyaJwtTokenExchange = (GigyaJwtTokenExchange) obj;
            return Intrinsics.areEqual((Object) this.token, (Object) gigyaJwtTokenExchange.token) && Intrinsics.areEqual((Object) this.provider, (Object) gigyaJwtTokenExchange.provider);
        }

        public int hashCode() {
            int hashCode = this.token.hashCode() * 31;
            String str = this.provider;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "GigyaJwtTokenExchange(token=" + this.token + ", provider=" + this.provider + ')';
        }

        public GigyaJwtTokenExchange(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "token");
            this.token = str;
            this.provider = str2;
        }

        public final String getProvider() {
            return this.provider;
        }

        public final String getToken() {
            return this.token;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b0\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0003HÖ\u0001J\t\u00106\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b$\u0010\u001e¨\u00067"}, d2 = {"Lcom/blueair/auth/retrofit/AblUserApi$AblUser;", "", "id", "", "username", "", "confirmed", "", "firstName", "lastName", "acceptLanguage", "create", "createdBy", "password", "permission", "phoneNumber", "update", "<init>", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()I", "getUsername", "()Ljava/lang/String;", "getConfirmed", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFirstName", "getLastName", "getAcceptLanguage", "getCreate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCreatedBy", "getPassword", "getPermission", "getPhoneNumber", "getUpdate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/blueair/auth/retrofit/AblUserApi$AblUser;", "equals", "other", "hashCode", "toString", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AblUserApi.kt */
    public static final class AblUser {
        private final String acceptLanguage;
        private final Boolean confirmed;
        private final Integer create;
        private final String createdBy;
        private final String firstName;
        private final int id;
        private final String lastName;
        private final String password;
        private final String permission;
        private final String phoneNumber;
        private final Integer update;
        private final String username;

        public AblUser() {
            this(0, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, 4095, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ AblUser copy$default(AblUser ablUser, int i, String str, Boolean bool, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, Integer num2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = ablUser.id;
            }
            if ((i2 & 2) != 0) {
                str = ablUser.username;
            }
            if ((i2 & 4) != 0) {
                bool = ablUser.confirmed;
            }
            if ((i2 & 8) != 0) {
                str2 = ablUser.firstName;
            }
            if ((i2 & 16) != 0) {
                str3 = ablUser.lastName;
            }
            if ((i2 & 32) != 0) {
                str4 = ablUser.acceptLanguage;
            }
            if ((i2 & 64) != 0) {
                num = ablUser.create;
            }
            if ((i2 & 128) != 0) {
                str5 = ablUser.createdBy;
            }
            if ((i2 & 256) != 0) {
                str6 = ablUser.password;
            }
            if ((i2 & 512) != 0) {
                str7 = ablUser.permission;
            }
            if ((i2 & 1024) != 0) {
                str8 = ablUser.phoneNumber;
            }
            if ((i2 & 2048) != 0) {
                num2 = ablUser.update;
            }
            String str9 = str8;
            Integer num3 = num2;
            String str10 = str6;
            String str11 = str7;
            Integer num4 = num;
            String str12 = str5;
            String str13 = str3;
            String str14 = str4;
            String str15 = str2;
            String str16 = str;
            return ablUser.copy(i, str16, bool, str15, str13, str14, num4, str12, str10, str11, str9, num3);
        }

        public final int component1() {
            return this.id;
        }

        public final String component10() {
            return this.permission;
        }

        public final String component11() {
            return this.phoneNumber;
        }

        public final Integer component12() {
            return this.update;
        }

        public final String component2() {
            return this.username;
        }

        public final Boolean component3() {
            return this.confirmed;
        }

        public final String component4() {
            return this.firstName;
        }

        public final String component5() {
            return this.lastName;
        }

        public final String component6() {
            return this.acceptLanguage;
        }

        public final Integer component7() {
            return this.create;
        }

        public final String component8() {
            return this.createdBy;
        }

        public final String component9() {
            return this.password;
        }

        public final AblUser copy(int i, String str, Boolean bool, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, Integer num2) {
            String str9 = str;
            Intrinsics.checkNotNullParameter(str9, "username");
            return new AblUser(i, str9, bool, str2, str3, str4, num, str5, str6, str7, str8, num2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AblUser)) {
                return false;
            }
            AblUser ablUser = (AblUser) obj;
            return this.id == ablUser.id && Intrinsics.areEqual((Object) this.username, (Object) ablUser.username) && Intrinsics.areEqual((Object) this.confirmed, (Object) ablUser.confirmed) && Intrinsics.areEqual((Object) this.firstName, (Object) ablUser.firstName) && Intrinsics.areEqual((Object) this.lastName, (Object) ablUser.lastName) && Intrinsics.areEqual((Object) this.acceptLanguage, (Object) ablUser.acceptLanguage) && Intrinsics.areEqual((Object) this.create, (Object) ablUser.create) && Intrinsics.areEqual((Object) this.createdBy, (Object) ablUser.createdBy) && Intrinsics.areEqual((Object) this.password, (Object) ablUser.password) && Intrinsics.areEqual((Object) this.permission, (Object) ablUser.permission) && Intrinsics.areEqual((Object) this.phoneNumber, (Object) ablUser.phoneNumber) && Intrinsics.areEqual((Object) this.update, (Object) ablUser.update);
        }

        public int hashCode() {
            int hashCode = ((this.id * 31) + this.username.hashCode()) * 31;
            Boolean bool = this.confirmed;
            int i = 0;
            int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            String str = this.firstName;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.lastName;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.acceptLanguage;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num = this.create;
            int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
            String str4 = this.createdBy;
            int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.password;
            int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.permission;
            int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.phoneNumber;
            int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
            Integer num2 = this.update;
            if (num2 != null) {
                i = num2.hashCode();
            }
            return hashCode10 + i;
        }

        public String toString() {
            return "AblUser(id=" + this.id + ", username=" + this.username + ", confirmed=" + this.confirmed + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", acceptLanguage=" + this.acceptLanguage + ", create=" + this.create + ", createdBy=" + this.createdBy + ", password=" + this.password + ", permission=" + this.permission + ", phoneNumber=" + this.phoneNumber + ", update=" + this.update + ')';
        }

        public AblUser(int i, String str, Boolean bool, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, Integer num2) {
            Intrinsics.checkNotNullParameter(str, "username");
            this.id = i;
            this.username = str;
            this.confirmed = bool;
            this.firstName = str2;
            this.lastName = str3;
            this.acceptLanguage = str4;
            this.create = num;
            this.createdBy = str5;
            this.password = str6;
            this.permission = str7;
            this.phoneNumber = str8;
            this.update = num2;
        }

        public final int getId() {
            return this.id;
        }

        public /* synthetic */ AblUser(int i, String str, Boolean bool, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, Integer num2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            Integer num3;
            String str9;
            String str10;
            String str11;
            String str12;
            Integer num4;
            String str13;
            String str14;
            String str15;
            Boolean bool2;
            String str16;
            int i3;
            AblUser ablUser;
            i = (i2 & 1) != 0 ? 0 : i;
            str = (i2 & 2) != 0 ? "" : str;
            bool = (i2 & 4) != 0 ? null : bool;
            str2 = (i2 & 8) != 0 ? null : str2;
            str3 = (i2 & 16) != 0 ? null : str3;
            str4 = (i2 & 32) != 0 ? null : str4;
            num = (i2 & 64) != 0 ? null : num;
            str5 = (i2 & 128) != 0 ? null : str5;
            str6 = (i2 & 256) != 0 ? null : str6;
            str7 = (i2 & 512) != 0 ? null : str7;
            str8 = (i2 & 1024) != 0 ? null : str8;
            if ((i2 & 2048) != 0) {
                num3 = null;
                str10 = str7;
                str9 = str8;
                str12 = str5;
                str11 = str6;
                str13 = str4;
                num4 = num;
                str15 = str2;
                str14 = str3;
                str16 = str;
                bool2 = bool;
                ablUser = this;
                i3 = i;
            } else {
                num3 = num2;
                str9 = str8;
                str11 = str6;
                str10 = str7;
                num4 = num;
                str12 = str5;
                str14 = str3;
                str13 = str4;
                bool2 = bool;
                str15 = str2;
                i3 = i;
                str16 = str;
                ablUser = this;
            }
            new AblUser(i3, str16, bool2, str15, str14, str13, num4, str12, str11, str10, str9, num3);
        }

        public final String getUsername() {
            return this.username;
        }

        public final Boolean getConfirmed() {
            return this.confirmed;
        }

        public final String getFirstName() {
            return this.firstName;
        }

        public final String getLastName() {
            return this.lastName;
        }

        public final String getAcceptLanguage() {
            return this.acceptLanguage;
        }

        public final Integer getCreate() {
            return this.create;
        }

        public final String getCreatedBy() {
            return this.createdBy;
        }

        public final String getPassword() {
            return this.password;
        }

        public final String getPermission() {
            return this.permission;
        }

        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        public final Integer getUpdate() {
            return this.update;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcom/blueair/auth/retrofit/AblUserApi$UserAttribute;", "", "currentValue", "", "defaultValue", "name", "scope", "userId", "", "uuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getCurrentValue", "()Ljava/lang/String;", "getDefaultValue", "getName", "getScope", "getUserId", "()I", "getUuid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AblUserApi.kt */
    public static final class UserAttribute {
        private final String currentValue;
        private final String defaultValue;
        private final String name;
        private final String scope;
        private final int userId;
        private final String uuid;

        public static /* synthetic */ UserAttribute copy$default(UserAttribute userAttribute, String str, String str2, String str3, String str4, int i, String str5, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = userAttribute.currentValue;
            }
            if ((i2 & 2) != 0) {
                str2 = userAttribute.defaultValue;
            }
            if ((i2 & 4) != 0) {
                str3 = userAttribute.name;
            }
            if ((i2 & 8) != 0) {
                str4 = userAttribute.scope;
            }
            if ((i2 & 16) != 0) {
                i = userAttribute.userId;
            }
            if ((i2 & 32) != 0) {
                str5 = userAttribute.uuid;
            }
            int i3 = i;
            String str6 = str5;
            String str7 = str4;
            String str8 = str2;
            return userAttribute.copy(str, str8, str3, str7, i3, str6);
        }

        public final String component1() {
            return this.currentValue;
        }

        public final String component2() {
            return this.defaultValue;
        }

        public final String component3() {
            return this.name;
        }

        public final String component4() {
            return this.scope;
        }

        public final int component5() {
            return this.userId;
        }

        public final String component6() {
            return this.uuid;
        }

        public final UserAttribute copy(String str, String str2, String str3, String str4, int i, String str5) {
            Intrinsics.checkNotNullParameter(str, "currentValue");
            Intrinsics.checkNotNullParameter(str2, "defaultValue");
            Intrinsics.checkNotNullParameter(str3, "name");
            Intrinsics.checkNotNullParameter(str4, "scope");
            Intrinsics.checkNotNullParameter(str5, "uuid");
            return new UserAttribute(str, str2, str3, str4, i, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserAttribute)) {
                return false;
            }
            UserAttribute userAttribute = (UserAttribute) obj;
            return Intrinsics.areEqual((Object) this.currentValue, (Object) userAttribute.currentValue) && Intrinsics.areEqual((Object) this.defaultValue, (Object) userAttribute.defaultValue) && Intrinsics.areEqual((Object) this.name, (Object) userAttribute.name) && Intrinsics.areEqual((Object) this.scope, (Object) userAttribute.scope) && this.userId == userAttribute.userId && Intrinsics.areEqual((Object) this.uuid, (Object) userAttribute.uuid);
        }

        public int hashCode() {
            return (((((((((this.currentValue.hashCode() * 31) + this.defaultValue.hashCode()) * 31) + this.name.hashCode()) * 31) + this.scope.hashCode()) * 31) + this.userId) * 31) + this.uuid.hashCode();
        }

        public String toString() {
            return "UserAttribute(currentValue=" + this.currentValue + ", defaultValue=" + this.defaultValue + ", name=" + this.name + ", scope=" + this.scope + ", userId=" + this.userId + ", uuid=" + this.uuid + ')';
        }

        public UserAttribute(String str, String str2, String str3, String str4, int i, String str5) {
            Intrinsics.checkNotNullParameter(str, "currentValue");
            Intrinsics.checkNotNullParameter(str2, "defaultValue");
            Intrinsics.checkNotNullParameter(str3, "name");
            Intrinsics.checkNotNullParameter(str4, "scope");
            Intrinsics.checkNotNullParameter(str5, "uuid");
            this.currentValue = str;
            this.defaultValue = str2;
            this.name = str3;
            this.scope = str4;
            this.userId = i;
            this.uuid = str5;
        }

        public final String getCurrentValue() {
            return this.currentValue;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UserAttribute(String str, String str2, String str3, String str4, int i, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? "" : str2, str3, str4, i, str5);
        }

        public final String getDefaultValue() {
            return this.defaultValue;
        }

        public final String getName() {
            return this.name;
        }

        public final String getScope() {
            return this.scope;
        }

        public final int getUserId() {
            return this.userId;
        }

        public final String getUuid() {
            return this.uuid;
        }
    }
}
