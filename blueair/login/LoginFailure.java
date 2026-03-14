package com.blueair.login;

import com.blueair.auth.GigyaService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"},
   d2 = {"Lcom/blueair/login/LoginFailure;", "", "code", "", "textResId", "", "titleResId", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCode", "()Ljava/lang/String;", "getTextResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitleResId", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/blueair/login/LoginFailure;", "equals", "", "other", "hashCode", "toString", "Companion", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LoginFailure {
   private static final LoginFailure ACCOUNT_LOCKED;
   private static final LoginFailure CANCELED;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final LoginFailure EMAIL_ALREADY_EXIST;
   private static final LoginFailure GET_EMAIL_ERROR;
   private static final LoginFailure INTERNET_CONNECTION;
   private static final LoginFailure INVALID_EMAIL_OR_PASSWORD;
   private static final LoginFailure INVALID_PARAM_VALUE;
   private static final LoginFailure INVALID_PASSWORD;
   private static final LoginFailure LOGIN_IDENTIFIER_EXIST;
   private static final LoginFailure LOGIN_PENDING_PASSWORD_CHANGE;
   private static final LoginFailure MISSING_EMAIL_ERROR;
   private static final LoginFailure NO_USER_WITH_THAT_EMAIL;
   private static final LoginFailure RESET_NO_USER_WITH_THAT_EMAIL;
   private static final LoginFailure SERVER_ERROR;
   private final String code;
   private final Integer textResId;
   private final Integer titleResId;

   static {
      INVALID_EMAIL_OR_PASSWORD = new LoginFailure("403042", com.blueair.viewcore.R.string.login_error_msg_invalid_credentials, com.blueair.viewcore.R.string.login_error_title_invalid_credentials);
      INTERNET_CONNECTION = new LoginFailure("400106", com.blueair.viewcore.R.string.login_error_internet_connection, (Integer)null, 4, (DefaultConstructorMarker)null);
      NO_USER_WITH_THAT_EMAIL = new LoginFailure("403047", com.blueair.viewcore.R.string.invalid_credentials, (Integer)null, 4, (DefaultConstructorMarker)null);
      LOGIN_IDENTIFIER_EXIST = new LoginFailure("403043", com.blueair.viewcore.R.string.login_error_user_exist, (Integer)null, 4, (DefaultConstructorMarker)null);
      GET_EMAIL_ERROR = new LoginFailure("400025", com.blueair.viewcore.R.string.login_get_email_error, (Integer)null, 4, (DefaultConstructorMarker)null);
      MISSING_EMAIL_ERROR = new LoginFailure("400027", com.blueair.viewcore.R.string.login_get_email_error, (Integer)null, 4, (DefaultConstructorMarker)null);
      INVALID_PARAM_VALUE = new LoginFailure("400006", com.blueair.viewcore.R.string.login_get_email_error, (Integer)null, 4, (DefaultConstructorMarker)null);
      INVALID_PASSWORD = new LoginFailure("400009", com.blueair.viewcore.R.string.register_invalid_input, (Integer)null, 4, (DefaultConstructorMarker)null);
      EMAIL_ALREADY_EXIST = new LoginFailure("400009-1", com.blueair.viewcore.R.string.login_error_msg_account_already_exists, com.blueair.viewcore.R.string.login_error_title_account_already_exists);
      RESET_NO_USER_WITH_THAT_EMAIL = new LoginFailure("403047", com.blueair.viewcore.R.string.password_reset_error_not_found_email, (Integer)null, 4, (DefaultConstructorMarker)null);
      LOGIN_PENDING_PASSWORD_CHANGE = new LoginFailure("403100", com.blueair.viewcore.R.string.login_error_msg_update_password, com.blueair.viewcore.R.string.login_error_title_update_password);
      ACCOUNT_LOCKED = new LoginFailure("403120", com.blueair.viewcore.R.string.login_error_msg_account_paused, com.blueair.viewcore.R.string.login_error_title_account_paused);
      CANCELED = new LoginFailure((String)null, (Integer)null, (Integer)null, 4, (DefaultConstructorMarker)null);
      SERVER_ERROR = new LoginFailure((String)null, com.blueair.viewcore.R.string.login_error_msg_common, (Integer)null, 4, (DefaultConstructorMarker)null);
   }

   public LoginFailure(String var1, Integer var2, Integer var3) {
      this.code = var1;
      this.textResId = var2;
      this.titleResId = var3;
   }

   // $FF: synthetic method
   public LoginFailure(String var1, Integer var2, Integer var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 4) != 0) {
         var3 = null;
      }

      this(var1, var2, var3);
   }

   // $FF: synthetic method
   public static LoginFailure copy$default(LoginFailure var0, String var1, Integer var2, Integer var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.code;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.textResId;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.titleResId;
      }

      return var0.copy(var1, var2, var3);
   }

   public final String component1() {
      return this.code;
   }

   public final Integer component2() {
      return this.textResId;
   }

   public final Integer component3() {
      return this.titleResId;
   }

   public final LoginFailure copy(String var1, Integer var2, Integer var3) {
      return new LoginFailure(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof LoginFailure)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.code, var1.code)) {
            return false;
         } else if (!Intrinsics.areEqual(this.textResId, var1.textResId)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.titleResId, var1.titleResId);
         }
      }
   }

   public final String getCode() {
      return this.code;
   }

   public final Integer getTextResId() {
      return this.textResId;
   }

   public final Integer getTitleResId() {
      return this.titleResId;
   }

   public int hashCode() {
      String var4 = this.code;
      int var3 = 0;
      int var1;
      if (var4 == null) {
         var1 = 0;
      } else {
         var1 = var4.hashCode();
      }

      Integer var5 = this.textResId;
      int var2;
      if (var5 == null) {
         var2 = 0;
      } else {
         var2 = var5.hashCode();
      }

      var5 = this.titleResId;
      if (var5 != null) {
         var3 = var5.hashCode();
      }

      return (var1 * 31 + var2) * 31 + var3;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("LoginFailure(code=");
      var1.append(this.code);
      var1.append(", textResId=");
      var1.append(this.textResId);
      var1.append(", titleResId=");
      var1.append(this.titleResId);
      var1.append(')');
      return var1.toString();
   }

   @Metadata(
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007¨\u0006'"},
      d2 = {"Lcom/blueair/login/LoginFailure$Companion;", "", "<init>", "()V", "INVALID_EMAIL_OR_PASSWORD", "Lcom/blueair/login/LoginFailure;", "getINVALID_EMAIL_OR_PASSWORD", "()Lcom/blueair/login/LoginFailure;", "INTERNET_CONNECTION", "getINTERNET_CONNECTION", "NO_USER_WITH_THAT_EMAIL", "getNO_USER_WITH_THAT_EMAIL", "LOGIN_IDENTIFIER_EXIST", "getLOGIN_IDENTIFIER_EXIST", "GET_EMAIL_ERROR", "getGET_EMAIL_ERROR", "MISSING_EMAIL_ERROR", "getMISSING_EMAIL_ERROR", "INVALID_PARAM_VALUE", "getINVALID_PARAM_VALUE", "INVALID_PASSWORD", "getINVALID_PASSWORD", "EMAIL_ALREADY_EXIST", "getEMAIL_ALREADY_EXIST", "RESET_NO_USER_WITH_THAT_EMAIL", "getRESET_NO_USER_WITH_THAT_EMAIL", "LOGIN_PENDING_PASSWORD_CHANGE", "getLOGIN_PENDING_PASSWORD_CHANGE", "ACCOUNT_LOCKED", "getACCOUNT_LOCKED", "CANCELED", "getCANCELED", "SERVER_ERROR", "getSERVER_ERROR", "fromCode", "e", "", "isReset", "", "login_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      // $FF: synthetic method
      public static LoginFailure fromCode$default(Companion var0, Throwable var1, boolean var2, int var3, Object var4) {
         if ((var3 & 2) != 0) {
            var2 = false;
         }

         return var0.fromCode(var1, var2);
      }

      public final LoginFailure fromCode(Throwable var1, boolean var2) {
         boolean var3 = var1 instanceof GigyaService.GigyaException;
         Object var5 = null;
         String var6;
         if (var3) {
            var6 = String.valueOf(((GigyaService.GigyaException)var1).getError().getErrorCode());
         } else if (var1 != null) {
            var6 = var1.getMessage();
         } else {
            var6 = null;
         }

         if (var6 != null) {
            switch (var6) {
               case "400009-1":
                  return this.getEMAIL_ALREADY_EXIST();
               case "400006":
                  return this.getINVALID_PARAM_VALUE();
               case "400009":
                  return this.getINVALID_PASSWORD();
               case "400025":
                  return this.getGET_EMAIL_ERROR();
               case "400027":
                  return this.getMISSING_EMAIL_ERROR();
               case "400106":
                  return this.getINTERNET_CONNECTION();
               case "403042":
                  return this.getINVALID_EMAIL_OR_PASSWORD();
               case "403043":
                  return this.getLOGIN_IDENTIFIER_EXIST();
               case "403047":
                  if (var2) {
                     return this.getRESET_NO_USER_WITH_THAT_EMAIL();
                  }

                  return this.getNO_USER_WITH_THAT_EMAIL();
                  break;
               case "403100":
                  return this.getLOGIN_PENDING_PASSWORD_CHANGE();
               case "403120":
                  return this.getACCOUNT_LOCKED();
            }
         }

         String var4 = (String)var5;
         if (var6 != null) {
            Integer var7 = StringsKt.toIntOrNull(var6);
            var4 = (String)var5;
            if (var7 != null) {
               var4 = var7.toString();
            }
         }

         return new LoginFailure(var4, com.blueair.viewcore.R.string.login_error_msg_common, (Integer)null, 4, (DefaultConstructorMarker)null);
      }

      public final LoginFailure getACCOUNT_LOCKED() {
         return LoginFailure.ACCOUNT_LOCKED;
      }

      public final LoginFailure getCANCELED() {
         return LoginFailure.CANCELED;
      }

      public final LoginFailure getEMAIL_ALREADY_EXIST() {
         return LoginFailure.EMAIL_ALREADY_EXIST;
      }

      public final LoginFailure getGET_EMAIL_ERROR() {
         return LoginFailure.GET_EMAIL_ERROR;
      }

      public final LoginFailure getINTERNET_CONNECTION() {
         return LoginFailure.INTERNET_CONNECTION;
      }

      public final LoginFailure getINVALID_EMAIL_OR_PASSWORD() {
         return LoginFailure.INVALID_EMAIL_OR_PASSWORD;
      }

      public final LoginFailure getINVALID_PARAM_VALUE() {
         return LoginFailure.INVALID_PARAM_VALUE;
      }

      public final LoginFailure getINVALID_PASSWORD() {
         return LoginFailure.INVALID_PASSWORD;
      }

      public final LoginFailure getLOGIN_IDENTIFIER_EXIST() {
         return LoginFailure.LOGIN_IDENTIFIER_EXIST;
      }

      public final LoginFailure getLOGIN_PENDING_PASSWORD_CHANGE() {
         return LoginFailure.LOGIN_PENDING_PASSWORD_CHANGE;
      }

      public final LoginFailure getMISSING_EMAIL_ERROR() {
         return LoginFailure.MISSING_EMAIL_ERROR;
      }

      public final LoginFailure getNO_USER_WITH_THAT_EMAIL() {
         return LoginFailure.NO_USER_WITH_THAT_EMAIL;
      }

      public final LoginFailure getRESET_NO_USER_WITH_THAT_EMAIL() {
         return LoginFailure.RESET_NO_USER_WITH_THAT_EMAIL;
      }

      public final LoginFailure getSERVER_ERROR() {
         return LoginFailure.SERVER_ERROR;
      }
   }
}
