package com.blueair.auth.retrofit;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000 \u001a2\u00020\u0001:\u0005\u001a\u001b\u001c\u001d\u001eJ\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0001\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\tJ(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0012\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u0013J$\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00032\b\b\u0001\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\tJ(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0018\u001a\u00020\u0016H§@¢\u0006\u0002\u0010\u0019¨\u0006\u001fÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/auth/retrofit/AblUserApi;", "", "getSpecificRegionSync", "Lretrofit2/Response;", "Lcom/blueair/auth/retrofit/AblUserApi$BlueairGranularRegion;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHomehost", "", "username", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doTokenExchange", "Lcom/blueair/auth/retrofit/AblUserApi$GigyaJwtTokenExchange;", "jwtExchange", "(Lcom/blueair/auth/retrofit/AblUserApi$GigyaJwtTokenExchange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUser", "Lcom/blueair/auth/retrofit/AblUserApi$AblUser;", "setLanguage", "", "language", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttributes", "", "Lcom/blueair/auth/retrofit/AblUserApi$UserAttribute;", "setExternalUidAttr", "userAttribute", "(Ljava/lang/String;Lcom/blueair/auth/retrofit/AblUserApi$UserAttribute;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "BlueairGranularRegion", "GigyaJwtTokenExchange", "AblUser", "UserAttribute", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface AblUserApi {
   Companion Companion = AblUserApi.Companion.$$INSTANCE;
   String USERNAME = "username";

   @POST("v2/token/exchange")
   Object doTokenExchange(@Body GigyaJwtTokenExchange var1, Continuation var2);

   @GET("v2/user/{username}/attributes/")
   Object getAttributes(@Path("username") String var1, Continuation var2);

   @GET("v2/user/{username}/homehost/")
   @Headers({"AuthDelegation: IdentityLab"})
   Object getHomehost(@Path("username") String var1, Continuation var2);

   @GET("v2/geocode/ip")
   Object getSpecificRegionSync(Continuation var1);

   @GET("v2/user/{username}/get/")
   Object getUser(@Path("username") String var1, Continuation var2);

   @GET("v2/user/{username}/attributes/ext_uid")
   Object setExternalUidAttr(@Path("username") String var1, @Body UserAttribute var2, Continuation var3);

   @POST("v2/user/{username}/language/{language}/")
   Object setLanguage(@Path("username") String var1, @Path("language") String var2, Continuation var3);

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b0\b\u0087\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u009a\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0003HÖ\u0001J\t\u00106\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b$\u0010\u001e¨\u00067"},
      d2 = {"Lcom/blueair/auth/retrofit/AblUserApi$AblUser;", "", "id", "", "username", "", "confirmed", "", "firstName", "lastName", "acceptLanguage", "create", "createdBy", "password", "permission", "phoneNumber", "update", "<init>", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()I", "getUsername", "()Ljava/lang/String;", "getConfirmed", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFirstName", "getLastName", "getAcceptLanguage", "getCreate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCreatedBy", "getPassword", "getPermission", "getPhoneNumber", "getUpdate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/blueair/auth/retrofit/AblUserApi$AblUser;", "equals", "other", "hashCode", "toString", "auth_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
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
         this(0, (String)null, (Boolean)null, (String)null, (String)null, (String)null, (Integer)null, (String)null, (String)null, (String)null, (String)null, (Integer)null, 4095, (DefaultConstructorMarker)null);
      }

      public AblUser(int var1, String var2, Boolean var3, String var4, String var5, String var6, Integer var7, String var8, String var9, String var10, String var11, Integer var12) {
         Intrinsics.checkNotNullParameter(var2, "username");
         super();
         this.id = var1;
         this.username = var2;
         this.confirmed = var3;
         this.firstName = var4;
         this.lastName = var5;
         this.acceptLanguage = var6;
         this.create = var7;
         this.createdBy = var8;
         this.password = var9;
         this.permission = var10;
         this.phoneNumber = var11;
         this.update = var12;
      }

      // $FF: synthetic method
      public AblUser(int var1, String var2, Boolean var3, String var4, String var5, String var6, Integer var7, String var8, String var9, String var10, String var11, Integer var12, int var13, DefaultConstructorMarker var14) {
         if ((var13 & 1) != 0) {
            var1 = 0;
         }

         if ((var13 & 2) != 0) {
            var2 = "";
         }

         if ((var13 & 4) != 0) {
            var3 = null;
         }

         if ((var13 & 8) != 0) {
            var4 = null;
         }

         if ((var13 & 16) != 0) {
            var5 = null;
         }

         if ((var13 & 32) != 0) {
            var6 = null;
         }

         if ((var13 & 64) != 0) {
            var7 = null;
         }

         if ((var13 & 128) != 0) {
            var8 = null;
         }

         if ((var13 & 256) != 0) {
            var9 = null;
         }

         if ((var13 & 512) != 0) {
            var10 = null;
         }

         if ((var13 & 1024) != 0) {
            var11 = null;
         }

         if ((var13 & 2048) != 0) {
            var12 = null;
         }

         this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
      }

      // $FF: synthetic method
      public static AblUser copy$default(AblUser var0, int var1, String var2, Boolean var3, String var4, String var5, String var6, Integer var7, String var8, String var9, String var10, String var11, Integer var12, int var13, Object var14) {
         if ((var13 & 1) != 0) {
            var1 = var0.id;
         }

         if ((var13 & 2) != 0) {
            var2 = var0.username;
         }

         if ((var13 & 4) != 0) {
            var3 = var0.confirmed;
         }

         if ((var13 & 8) != 0) {
            var4 = var0.firstName;
         }

         if ((var13 & 16) != 0) {
            var5 = var0.lastName;
         }

         if ((var13 & 32) != 0) {
            var6 = var0.acceptLanguage;
         }

         if ((var13 & 64) != 0) {
            var7 = var0.create;
         }

         if ((var13 & 128) != 0) {
            var8 = var0.createdBy;
         }

         if ((var13 & 256) != 0) {
            var9 = var0.password;
         }

         if ((var13 & 512) != 0) {
            var10 = var0.permission;
         }

         if ((var13 & 1024) != 0) {
            var11 = var0.phoneNumber;
         }

         if ((var13 & 2048) != 0) {
            var12 = var0.update;
         }

         return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
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

      public final AblUser copy(int var1, String var2, Boolean var3, String var4, String var5, String var6, Integer var7, String var8, String var9, String var10, String var11, Integer var12) {
         Intrinsics.checkNotNullParameter(var2, "username");
         return new AblUser(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof AblUser)) {
            return false;
         } else {
            var1 = var1;
            if (this.id != var1.id) {
               return false;
            } else if (!Intrinsics.areEqual(this.username, var1.username)) {
               return false;
            } else if (!Intrinsics.areEqual(this.confirmed, var1.confirmed)) {
               return false;
            } else if (!Intrinsics.areEqual(this.firstName, var1.firstName)) {
               return false;
            } else if (!Intrinsics.areEqual(this.lastName, var1.lastName)) {
               return false;
            } else if (!Intrinsics.areEqual(this.acceptLanguage, var1.acceptLanguage)) {
               return false;
            } else if (!Intrinsics.areEqual(this.create, var1.create)) {
               return false;
            } else if (!Intrinsics.areEqual(this.createdBy, var1.createdBy)) {
               return false;
            } else if (!Intrinsics.areEqual(this.password, var1.password)) {
               return false;
            } else if (!Intrinsics.areEqual(this.permission, var1.permission)) {
               return false;
            } else if (!Intrinsics.areEqual(this.phoneNumber, var1.phoneNumber)) {
               return false;
            } else {
               return Intrinsics.areEqual(this.update, var1.update);
            }
         }
      }

      public final String getAcceptLanguage() {
         return this.acceptLanguage;
      }

      public final Boolean getConfirmed() {
         return this.confirmed;
      }

      public final Integer getCreate() {
         return this.create;
      }

      public final String getCreatedBy() {
         return this.createdBy;
      }

      public final String getFirstName() {
         return this.firstName;
      }

      public final int getId() {
         return this.id;
      }

      public final String getLastName() {
         return this.lastName;
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

      public final String getUsername() {
         return this.username;
      }

      public int hashCode() {
         int var12 = this.id;
         int var11 = this.username.hashCode();
         Boolean var13 = this.confirmed;
         int var10 = 0;
         int var1;
         if (var13 == null) {
            var1 = 0;
         } else {
            var1 = var13.hashCode();
         }

         String var14 = this.firstName;
         int var2;
         if (var14 == null) {
            var2 = 0;
         } else {
            var2 = var14.hashCode();
         }

         var14 = this.lastName;
         int var3;
         if (var14 == null) {
            var3 = 0;
         } else {
            var3 = var14.hashCode();
         }

         var14 = this.acceptLanguage;
         int var4;
         if (var14 == null) {
            var4 = 0;
         } else {
            var4 = var14.hashCode();
         }

         Integer var17 = this.create;
         int var5;
         if (var17 == null) {
            var5 = 0;
         } else {
            var5 = var17.hashCode();
         }

         String var18 = this.createdBy;
         int var6;
         if (var18 == null) {
            var6 = 0;
         } else {
            var6 = var18.hashCode();
         }

         var18 = this.password;
         int var7;
         if (var18 == null) {
            var7 = 0;
         } else {
            var7 = var18.hashCode();
         }

         var18 = this.permission;
         int var8;
         if (var18 == null) {
            var8 = 0;
         } else {
            var8 = var18.hashCode();
         }

         var18 = this.phoneNumber;
         int var9;
         if (var18 == null) {
            var9 = 0;
         } else {
            var9 = var18.hashCode();
         }

         Integer var22 = this.update;
         if (var22 != null) {
            var10 = var22.hashCode();
         }

         return ((((((((((var12 * 31 + var11) * 31 + var1) * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var7) * 31 + var8) * 31 + var9) * 31 + var10;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("AblUser(id=");
         var1.append(this.id);
         var1.append(", username=");
         var1.append(this.username);
         var1.append(", confirmed=");
         var1.append(this.confirmed);
         var1.append(", firstName=");
         var1.append(this.firstName);
         var1.append(", lastName=");
         var1.append(this.lastName);
         var1.append(", acceptLanguage=");
         var1.append(this.acceptLanguage);
         var1.append(", create=");
         var1.append(this.create);
         var1.append(", createdBy=");
         var1.append(this.createdBy);
         var1.append(", password=");
         var1.append(this.password);
         var1.append(", permission=");
         var1.append(this.permission);
         var1.append(", phoneNumber=");
         var1.append(this.phoneNumber);
         var1.append(", update=");
         var1.append(this.update);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"},
      d2 = {"Lcom/blueair/auth/retrofit/AblUserApi$BlueairGranularRegion;", "", "countryCode", "", "<init>", "(Ljava/lang/String;)V", "getCountryCode", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BlueairGranularRegion {
      private final String countryCode;

      public BlueairGranularRegion(String var1) {
         Intrinsics.checkNotNullParameter(var1, "countryCode");
         super();
         this.countryCode = var1;
      }

      // $FF: synthetic method
      public static BlueairGranularRegion copy$default(BlueairGranularRegion var0, String var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.countryCode;
         }

         return var0.copy(var1);
      }

      public final String component1() {
         return this.countryCode;
      }

      public final BlueairGranularRegion copy(String var1) {
         Intrinsics.checkNotNullParameter(var1, "countryCode");
         return new BlueairGranularRegion(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof BlueairGranularRegion)) {
            return false;
         } else {
            var1 = var1;
            return Intrinsics.areEqual(this.countryCode, var1.countryCode);
         }
      }

      public final String getCountryCode() {
         return this.countryCode;
      }

      public int hashCode() {
         return this.countryCode.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("BlueairGranularRegion(countryCode=");
         var1.append(this.countryCode);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"},
      d2 = {"Lcom/blueair/auth/retrofit/AblUserApi$Companion;", "", "<init>", "()V", "USERNAME", "", "auth_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      static final Companion $$INSTANCE = new Companion();
      public static final String USERNAME = "username";

      private Companion() {
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"},
      d2 = {"Lcom/blueair/auth/retrofit/AblUserApi$GigyaJwtTokenExchange;", "", "token", "", "provider", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getProvider", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class GigyaJwtTokenExchange {
      private final String provider;
      private final String token;

      public GigyaJwtTokenExchange(String var1, String var2) {
         Intrinsics.checkNotNullParameter(var1, "token");
         super();
         this.token = var1;
         this.provider = var2;
      }

      // $FF: synthetic method
      public static GigyaJwtTokenExchange copy$default(GigyaJwtTokenExchange var0, String var1, String var2, int var3, Object var4) {
         if ((var3 & 1) != 0) {
            var1 = var0.token;
         }

         if ((var3 & 2) != 0) {
            var2 = var0.provider;
         }

         return var0.copy(var1, var2);
      }

      public final String component1() {
         return this.token;
      }

      public final String component2() {
         return this.provider;
      }

      public final GigyaJwtTokenExchange copy(String var1, String var2) {
         Intrinsics.checkNotNullParameter(var1, "token");
         return new GigyaJwtTokenExchange(var1, var2);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof GigyaJwtTokenExchange)) {
            return false;
         } else {
            var1 = var1;
            if (!Intrinsics.areEqual(this.token, var1.token)) {
               return false;
            } else {
               return Intrinsics.areEqual(this.provider, var1.provider);
            }
         }
      }

      public final String getProvider() {
         return this.provider;
      }

      public final String getToken() {
         return this.token;
      }

      public int hashCode() {
         int var2 = this.token.hashCode();
         String var3 = this.provider;
         int var1;
         if (var3 == null) {
            var1 = 0;
         } else {
            var1 = var3.hashCode();
         }

         return var2 * 31 + var1;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("GigyaJwtTokenExchange(token=");
         var1.append(this.token);
         var1.append(", provider=");
         var1.append(this.provider);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "},
      d2 = {"Lcom/blueair/auth/retrofit/AblUserApi$UserAttribute;", "", "currentValue", "", "defaultValue", "name", "scope", "userId", "", "uuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getCurrentValue", "()Ljava/lang/String;", "getDefaultValue", "getName", "getScope", "getUserId", "()I", "getUuid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "auth_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class UserAttribute {
      private final String currentValue;
      private final String defaultValue;
      private final String name;
      private final String scope;
      private final int userId;
      private final String uuid;

      public UserAttribute(String var1, String var2, String var3, String var4, int var5, String var6) {
         Intrinsics.checkNotNullParameter(var1, "currentValue");
         Intrinsics.checkNotNullParameter(var2, "defaultValue");
         Intrinsics.checkNotNullParameter(var3, "name");
         Intrinsics.checkNotNullParameter(var4, "scope");
         Intrinsics.checkNotNullParameter(var6, "uuid");
         super();
         this.currentValue = var1;
         this.defaultValue = var2;
         this.name = var3;
         this.scope = var4;
         this.userId = var5;
         this.uuid = var6;
      }

      // $FF: synthetic method
      public UserAttribute(String var1, String var2, String var3, String var4, int var5, String var6, int var7, DefaultConstructorMarker var8) {
         if ((var7 & 2) != 0) {
            var2 = "";
         }

         this(var1, var2, var3, var4, var5, var6);
      }

      // $FF: synthetic method
      public static UserAttribute copy$default(UserAttribute var0, String var1, String var2, String var3, String var4, int var5, String var6, int var7, Object var8) {
         if ((var7 & 1) != 0) {
            var1 = var0.currentValue;
         }

         if ((var7 & 2) != 0) {
            var2 = var0.defaultValue;
         }

         if ((var7 & 4) != 0) {
            var3 = var0.name;
         }

         if ((var7 & 8) != 0) {
            var4 = var0.scope;
         }

         if ((var7 & 16) != 0) {
            var5 = var0.userId;
         }

         if ((var7 & 32) != 0) {
            var6 = var0.uuid;
         }

         return var0.copy(var1, var2, var3, var4, var5, var6);
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

      public final UserAttribute copy(String var1, String var2, String var3, String var4, int var5, String var6) {
         Intrinsics.checkNotNullParameter(var1, "currentValue");
         Intrinsics.checkNotNullParameter(var2, "defaultValue");
         Intrinsics.checkNotNullParameter(var3, "name");
         Intrinsics.checkNotNullParameter(var4, "scope");
         Intrinsics.checkNotNullParameter(var6, "uuid");
         return new UserAttribute(var1, var2, var3, var4, var5, var6);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof UserAttribute)) {
            return false;
         } else {
            var1 = var1;
            if (!Intrinsics.areEqual(this.currentValue, var1.currentValue)) {
               return false;
            } else if (!Intrinsics.areEqual(this.defaultValue, var1.defaultValue)) {
               return false;
            } else if (!Intrinsics.areEqual(this.name, var1.name)) {
               return false;
            } else if (!Intrinsics.areEqual(this.scope, var1.scope)) {
               return false;
            } else if (this.userId != var1.userId) {
               return false;
            } else {
               return Intrinsics.areEqual(this.uuid, var1.uuid);
            }
         }
      }

      public final String getCurrentValue() {
         return this.currentValue;
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

      public int hashCode() {
         return ((((this.currentValue.hashCode() * 31 + this.defaultValue.hashCode()) * 31 + this.name.hashCode()) * 31 + this.scope.hashCode()) * 31 + this.userId) * 31 + this.uuid.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("UserAttribute(currentValue=");
         var1.append(this.currentValue);
         var1.append(", defaultValue=");
         var1.append(this.defaultValue);
         var1.append(", name=");
         var1.append(this.name);
         var1.append(", scope=");
         var1.append(this.scope);
         var1.append(", userId=");
         var1.append(this.userId);
         var1.append(", uuid=");
         var1.append(this.uuid);
         var1.append(')');
         return var1.toString();
      }
   }
}
