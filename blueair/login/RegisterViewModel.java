package com.blueair.login;

import android.app.Application;
import android.content.Context;
import android.util.Patterns;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.auth.AuthService;
import com.blueair.auth.GigyaServer;
import com.blueair.auth.GigyaService;
import com.blueair.core.BuildEnvironment;
import com.gigya.android.sdk.account.models.GigyaAccount;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b-\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 G2\u00020\u0001:\u0001GB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010A\u001a\u00020BJ\u000e\u0010C\u001a\u00020BH\u0082@¢\u0006\u0002\u0010DJ\u0006\u0010E\u001a\u00020BJ\b\u0010F\u001a\u00020\u0014H\u0002R\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\n8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00140\u00140\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\n8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\rR\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00140\u00140\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\rR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140\n8F¢\u0006\u0006\u001a\u0004\b$\u0010\rR\u001c\u0010%\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00140\u00140\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0012R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8F¢\u0006\u0006\u001a\u0004\b)\u0010\rR\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0012R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140\n8F¢\u0006\u0006\u001a\u0004\b.\u0010\rR\u001c\u0010/\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00140\u00140\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0012R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u00140\n8F¢\u0006\u0006\u001a\u0004\b3\u0010\rR\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0012R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0012R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0012R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00140\n8F¢\u0006\u0006\u001a\u0004\b<\u0010\rR\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00140\n8F¢\u0006\u0006\u001a\u0004\b?\u0010\rR\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"},
   d2 = {"Lcom/blueair/login/RegisterViewModel;", "Lcom/blueair/login/BaseLoginViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dataCenter", "Landroidx/lifecycle/LiveData;", "", "getDataCenter", "()Landroidx/lifecycle/LiveData;", "_dataCenter", "Landroidx/lifecycle/MutableLiveData;", "firstName", "getFirstName", "()Landroidx/lifecycle/MutableLiveData;", "firstNameValid", "", "getFirstNameValid", "_firstNameValid", "lastName", "getLastName", "lastNameValid", "getLastNameValid", "_lastNameValid", "email", "getEmail", "emailError", "getEmailError", "_emailError", "phone", "getPhone", "phoneValid", "getPhoneValid", "_phoneValid", "password", "getPassword", "passwordError", "getPasswordError", "_passwordError", "confirmPassword", "getConfirmPassword", "confirmPasswordValid", "getConfirmPasswordValid", "_confirmPasswordValid", "confirmYear", "getConfirmYear", "yearConfirmed", "getYearConfirmed", "_yearConfirmed", "confirmSubscribe", "getConfirmSubscribe", "confirmConsentDate", "getConfirmConsentDate", "confirmPrivacy", "getConfirmPrivacy", "privacyConfirmed", "getPrivacyConfirmed", "_privacyConfirmed", "formError", "getFormError", "_formError", "loadDataCenter", "", "updateGigyaDataCenter", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "validateForm", "Companion", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class RegisterViewModel extends BaseLoginViewModel {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final Regex PASSWORD_REGEX_CN;
   private static final Regex PASSWORD_REGEX_EU;
   private static final Regex PASSWORD_REGEX_US = new Regex("(?=.*?[A-Z])(?=.*?[a-z])(?=.*\\d)(?=.*?[#?!@$%^&*-])(?!.*\\s).{10,}");
   private final MutableLiveData _confirmPasswordValid;
   private final MutableLiveData _dataCenter;
   private final MutableLiveData _emailError;
   private final MutableLiveData _firstNameValid;
   private final MutableLiveData _formError;
   private final MutableLiveData _lastNameValid;
   private final MutableLiveData _passwordError;
   private final MutableLiveData _phoneValid;
   private final MutableLiveData _privacyConfirmed;
   private final MutableLiveData _yearConfirmed;
   private final MutableLiveData confirmConsentDate;
   private final MutableLiveData confirmPassword;
   private final MutableLiveData confirmPrivacy;
   private final MutableLiveData confirmSubscribe;
   private final MutableLiveData confirmYear;
   private final Context context;
   private final MutableLiveData email;
   private final MutableLiveData firstName;
   private final MutableLiveData lastName;
   private final MutableLiveData password;
   private final MutableLiveData phone;

   static {
      Regex var0 = new Regex("(?!.*\\s).{8,}");
      PASSWORD_REGEX_EU = var0;
      PASSWORD_REGEX_CN = var0;
   }

   public RegisterViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "app");
      super(var1);
      this.context = var1.getApplicationContext();
      this._dataCenter = new MutableLiveData();
      this.firstName = new MutableLiveData();
      Boolean var2 = true;
      this._firstNameValid = new MutableLiveData(var2);
      this.lastName = new MutableLiveData();
      this._lastNameValid = new MutableLiveData(var2);
      this.email = new MutableLiveData();
      this._emailError = new MutableLiveData((Object)null);
      this.phone = new MutableLiveData();
      this._phoneValid = new MutableLiveData(var2);
      this.password = new MutableLiveData();
      this._passwordError = new MutableLiveData((Object)null);
      this.confirmPassword = new MutableLiveData();
      this._confirmPasswordValid = new MutableLiveData(var2);
      this.confirmYear = new MutableLiveData();
      this._yearConfirmed = new MutableLiveData();
      this.confirmSubscribe = new MutableLiveData();
      this.confirmConsentDate = new MutableLiveData();
      this.confirmPrivacy = new MutableLiveData();
      this._privacyConfirmed = new MutableLiveData();
      this._formError = new MutableLiveData(false);
   }

   private final Object updateGigyaDataCenter(Continuation var1) {
      label23: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var5 = var3;
               break label23;
            }
         }

         var5 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final RegisterViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.updateGigyaDataCenter((Continuation)this);
            }
         };
      }

      AuthService var8 = (AuthService)((<undefinedtype>)var5).result;
      Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var5).label;
      Object var6;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         ResultKt.throwOnFailure(var8);
         var6 = var8;
      } else {
         ResultKt.throwOnFailure(var8);
         var8 = this.getAuthService();
         ((<undefinedtype>)var5).label = 1;
         var8 = (AuthService)var8.updateGigyaDataCenter((Continuation)var5);
         var6 = var8;
         if (var8 == var4) {
            return var4;
         }
      }

      GigyaServer var7 = (GigyaServer)var6;
      this._dataCenter.postValue(var7.getCountryCode());
      return Unit.INSTANCE;
   }

   private final boolean validateForm() {
      String var7;
      Boolean var8;
      boolean var14;
      label152: {
         var14 = BuildEnvironment.INSTANCE.isChina();
         var7 = null;
         var8 = true;
         if (!var14) {
            MutableLiveData var9 = this._firstNameValid;
            String var6 = (String)this.firstName.getValue();
            Boolean var17;
            if (var6 != null) {
               var17 = StringsKt.isBlank((CharSequence)var6) ^ true;
            } else {
               var17 = null;
            }

            var9.setValue(var17);
            var9 = this._lastNameValid;
            String var18 = (String)this.lastName.getValue();
            Boolean var19;
            if (var18 != null) {
               var19 = StringsKt.isBlank((CharSequence)var18) ^ true;
            } else {
               var19 = null;
            }

            var9.setValue(var19);
            Iterable var20 = (Iterable)CollectionsKt.listOf(new Boolean[]{(Boolean)this.getFirstNameValid().getValue(), (Boolean)this.getLastNameValid().getValue()});
            if (!(var20 instanceof Collection) || !((Collection)var20).isEmpty()) {
               Iterator var21 = var20.iterator();

               while(var21.hasNext()) {
                  if (!Intrinsics.areEqual((Boolean)var21.next(), var8)) {
                     var14 = false;
                     break label152;
                  }
               }
            }
         }

         var14 = true;
      }

      MutableLiveData var35 = this._emailError;
      CharSequence var22 = (CharSequence)this.email.getValue();
      String var23;
      if (var22 != null && var22.length() != 0) {
         if (!Patterns.EMAIL_ADDRESS.matcher((CharSequence)String.valueOf(this.email.getValue())).matches()) {
            var23 = this.context.getString(com.blueair.viewcore.R.string.invalid_email);
         } else {
            var23 = null;
         }
      } else {
         var23 = this.context.getString(com.blueair.viewcore.R.string.enter_email);
      }

      label132: {
         var35.setValue(var23);
         var23 = (String)this.getDataCenter().getValue();
         if (var23 != null) {
            int var1 = var23.hashCode();
            if (var1 != 3179) {
               if (var1 == 3248 && var23.equals("eu")) {
                  var25 = PASSWORD_REGEX_EU;
                  break label132;
               }
            } else if (var23.equals("cn")) {
               var25 = PASSWORD_REGEX_CN;
               break label132;
            }
         }

         var25 = PASSWORD_REGEX_US;
      }

      String var11 = (String)this.password.getValue();
      MutableLiveData var10 = this._passwordError;
      CharSequence var36 = (CharSequence)var11;
      if (var36 != null && var36.length() != 0) {
         if (!var25.matches((CharSequence)String.valueOf(this.password.getValue()))) {
            var7 = this.context.getString(com.blueair.viewcore.R.string.invalid_password);
         }
      } else {
         var7 = this.context.getString(com.blueair.viewcore.R.string.enter_password);
      }

      var10.setValue(var7);
      if (!Intrinsics.areEqual(var25, PASSWORD_REGEX_US) && this.getPasswordError().getValue() == null && var11 != null) {
         Iterable var26 = (Iterable)CollectionsKt.listOf(new String[]{"[a-z]", "[A-Z]", "[0-9]", "[#?!@$%^&*-]"});
         int var2;
         if (var26 instanceof Collection && ((Collection)var26).isEmpty()) {
            var2 = 0;
         } else {
            Iterator var27 = var26.iterator();
            int var12 = 0;

            while(true) {
               var2 = var12;
               if (!var27.hasNext()) {
                  break;
               }

               if ((new Regex((String)var27.next())).containsMatchIn(var36)) {
                  var2 = var12 + 1;
                  var12 = var2;
                  if (var2 < 0) {
                     CollectionsKt.throwCountOverflow();
                     var12 = var2;
                  }
               }
            }
         }

         if (var2 < 3) {
            this._passwordError.setValue(this.context.getString(com.blueair.viewcore.R.string.invalid_password));
         }
      }

      boolean var4;
      label106: {
         this._confirmPasswordValid.setValue(Intrinsics.areEqual(this.confirmPassword.getValue(), this.password.getValue()));
         var32 = this._yearConfirmed;
         if (this.confirmYear.getValue() != null) {
            Object var28 = this.confirmYear.getValue();
            Intrinsics.checkNotNull(var28);
            if ((Boolean)var28) {
               var4 = true;
               break label106;
            }
         }

         var4 = false;
      }

      label101: {
         var32.setValue(var4);
         var29 = this._privacyConfirmed;
         if (this.confirmPrivacy.getValue() != null) {
            Object var33 = this.confirmPrivacy.getValue();
            Intrinsics.checkNotNull(var33);
            if ((Boolean)var33) {
               var4 = true;
               break label101;
            }
         }

         var4 = false;
      }

      var29.setValue(var4);
      if (this.getEmailError().getValue() == null) {
         var4 = true;
      } else {
         var4 = false;
      }

      boolean var5;
      if (this.getPasswordError().getValue() == null) {
         var5 = true;
      } else {
         var5 = false;
      }

      Iterable var30 = (Iterable)CollectionsKt.listOf(new Boolean[]{var4, var5, (Boolean)this.getConfirmPasswordValid().getValue(), (Boolean)this.confirmYear.getValue(), (Boolean)this.confirmPrivacy.getValue(), var14});
      if (var30 instanceof Collection && ((Collection)var30).isEmpty()) {
         return true;
      } else {
         Iterator var31 = var30.iterator();

         while(var31.hasNext()) {
            if (!Intrinsics.areEqual((Boolean)var31.next(), var8)) {
               return false;
            }
         }

         return true;
      }
   }

   public final MutableLiveData getConfirmConsentDate() {
      return this.confirmConsentDate;
   }

   public final MutableLiveData getConfirmPassword() {
      return this.confirmPassword;
   }

   public final LiveData getConfirmPasswordValid() {
      return (LiveData)this._confirmPasswordValid;
   }

   public final MutableLiveData getConfirmPrivacy() {
      return this.confirmPrivacy;
   }

   public final MutableLiveData getConfirmSubscribe() {
      return this.confirmSubscribe;
   }

   public final MutableLiveData getConfirmYear() {
      return this.confirmYear;
   }

   public final LiveData getDataCenter() {
      return (LiveData)this._dataCenter;
   }

   public final MutableLiveData getEmail() {
      return this.email;
   }

   public final LiveData getEmailError() {
      return (LiveData)this._emailError;
   }

   public final MutableLiveData getFirstName() {
      return this.firstName;
   }

   public final LiveData getFirstNameValid() {
      return (LiveData)this._firstNameValid;
   }

   public final LiveData getFormError() {
      return (LiveData)this._formError;
   }

   public final MutableLiveData getLastName() {
      return this.lastName;
   }

   public final LiveData getLastNameValid() {
      return (LiveData)this._lastNameValid;
   }

   public final MutableLiveData getPassword() {
      return this.password;
   }

   public final LiveData getPasswordError() {
      return (LiveData)this._passwordError;
   }

   public final MutableLiveData getPhone() {
      return this.phone;
   }

   public final LiveData getPhoneValid() {
      return (LiveData)this._phoneValid;
   }

   public final LiveData getPrivacyConfirmed() {
      return (LiveData)this._privacyConfirmed;
   }

   public final LiveData getYearConfirmed() {
      return (LiveData)this._yearConfirmed;
   }

   public final void loadDataCenter() {
      this.loadingLaunch(new Function1(this, (Continuation)null) {
         int label;
         final RegisterViewModel this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Continuation var1) {
            return (Continuation)(new <anonymous constructor>(this.this$0, var1));
         }

         public final Object invoke(Continuation var1) {
            return ((<undefinedtype>)this.create(var1)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               RegisterViewModel var5 = this.this$0;
               Continuation var4 = (Continuation)this;
               this.label = 1;
               if (var5.updateGigyaDataCenter(var4) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      });
   }

   public final void register() {
      if (!this.validateForm()) {
         this._formError.setValue(true);
      } else {
         this._formError.setValue(false);
         this.authenticateUser(new Function1(this, (Continuation)null) {
            boolean Z$0;
            int label;
            final RegisterViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Continuation create(Continuation var1) {
               return (Continuation)(new <anonymous constructor>(this.this$0, var1));
            }

            public final Object invoke(Continuation var1) {
               return ((<undefinedtype>)this.create(var1)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               boolean var3;
               Throwable var10000;
               label5667: {
                  label5672: {
                     Object var8;
                     label5665: {
                        var8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int var2 = this.label;
                        if (var2 != 0) {
                           if (var2 != 1) {
                              if (var2 != 2) {
                                 if (var2 != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                 }

                                 boolean var4 = this.Z$0;
                                 var3 = var4;

                                 try {
                                    ResultKt.throwOnFailure(var1);
                                 } catch (Throwable var661) {
                                    var10000 = var661;
                                    boolean var10001 = false;
                                    break label5667;
                                 }

                                 var3 = var4;
                                 break label5672;
                              }

                              ResultKt.throwOnFailure(var1);
                              break label5665;
                           }

                           ResultKt.throwOnFailure(var1);
                        } else {
                           ResultKt.throwOnFailure(var1);
                           CharSequence var663 = (CharSequence)this.this$0._dataCenter.getValue();
                           if (var663 == null || var663.length() == 0) {
                              RegisterViewModel var664 = this.this$0;
                              Continuation var7 = (Continuation)this;
                              this.label = 1;
                              if (var664.updateGigyaDataCenter(var7) == var8) {
                                 return var8;
                              }
                           }
                        }

                        var1 = this.this$0.getAuthService();
                        Object var672 = this.this$0.getEmail().getValue();
                        Intrinsics.checkNotNull(var672);
                        String var673 = (String)var672;
                        Continuation var9 = (Continuation)this;
                        this.label = 2;
                        Object var674 = var1.doGigyaDataCentersHaveEmailAddress(var673, var9);
                        var1 = (AuthService)var674;
                        if (var674 == var8) {
                           return var8;
                        }
                     }

                     boolean var670 = (Boolean)var1;
                     var3 = var670;

                     GigyaService var679;
                     try {
                        var679 = this.this$0.getGigyaService();
                     } catch (Throwable var660) {
                        var10000 = var660;
                        boolean var684 = false;
                        break label5667;
                     }

                     var3 = var670;

                     boolean var5;
                     try {
                        var5 = BuildEnvironment.INSTANCE.isChina();
                     } catch (Throwable var659) {
                        var10000 = var659;
                        boolean var685 = false;
                        break label5667;
                     }

                     String var675 = "-";
                     String var666;
                     if (var5) {
                        var666 = "-";
                     } else {
                        var3 = var670;

                        try {
                           var667 = this.this$0.getFirstName().getValue();
                        } catch (Throwable var658) {
                           var10000 = var658;
                           boolean var686 = false;
                           break label5667;
                        }

                        var3 = var670;

                        try {
                           Intrinsics.checkNotNull(var667);
                        } catch (Throwable var657) {
                           var10000 = var657;
                           boolean var687 = false;
                           break label5667;
                        }

                        var3 = var670;

                        try {
                           var666 = (String)var667;
                        } catch (Throwable var656) {
                           var10000 = var656;
                           boolean var688 = false;
                           break label5667;
                        }
                     }

                     var3 = var670;

                     label5675: {
                        try {
                           if (BuildEnvironment.INSTANCE.isChina()) {
                              break label5675;
                           }
                        } catch (Throwable var662) {
                           var10000 = var662;
                           boolean var689 = false;
                           break label5667;
                        }

                        var3 = var670;

                        try {
                           var676 = this.this$0.getLastName().getValue();
                        } catch (Throwable var655) {
                           var10000 = var655;
                           boolean var690 = false;
                           break label5667;
                        }

                        var3 = var670;

                        try {
                           Intrinsics.checkNotNull(var676);
                        } catch (Throwable var654) {
                           var10000 = var654;
                           boolean var691 = false;
                           break label5667;
                        }

                        var3 = var670;

                        try {
                           var675 = (String)var676;
                        } catch (Throwable var653) {
                           var10000 = var653;
                           boolean var692 = false;
                           break label5667;
                        }
                     }

                     var3 = var670;

                     Object var10;
                     try {
                        var10 = this.this$0.getEmail().getValue();
                     } catch (Throwable var652) {
                        var10000 = var652;
                        boolean var693 = false;
                        break label5667;
                     }

                     var3 = var670;

                     try {
                        Intrinsics.checkNotNull(var10);
                     } catch (Throwable var651) {
                        var10000 = var651;
                        boolean var694 = false;
                        break label5667;
                     }

                     var3 = var670;

                     try {
                        var680 = (String)var10;
                     } catch (Throwable var650) {
                        var10000 = var650;
                        boolean var695 = false;
                        break label5667;
                     }

                     var3 = var670;

                     Object var11;
                     try {
                        var11 = this.this$0.getPassword().getValue();
                     } catch (Throwable var649) {
                        var10000 = var649;
                        boolean var696 = false;
                        break label5667;
                     }

                     var3 = var670;

                     try {
                        Intrinsics.checkNotNull(var11);
                     } catch (Throwable var648) {
                        var10000 = var648;
                        boolean var697 = false;
                        break label5667;
                     }

                     var3 = var670;

                     try {
                        var681 = (String)var11;
                     } catch (Throwable var647) {
                        var10000 = var647;
                        boolean var698 = false;
                        break label5667;
                     }

                     var3 = var670;

                     Boolean var12;
                     try {
                        var12 = (Boolean)this.this$0.getConfirmSubscribe().getValue();
                     } catch (Throwable var646) {
                        var10000 = var646;
                        boolean var699 = false;
                        break label5667;
                     }

                     boolean var6 = false;
                     if (var12 != null) {
                        var3 = var670;

                        try {
                           var5 = var12;
                        } catch (Throwable var645) {
                           var10000 = var645;
                           boolean var700 = false;
                           break label5667;
                        }
                     } else {
                        var5 = false;
                     }

                     var3 = var670;

                     try {
                        var12 = (Boolean)this.this$0.getConfirmConsentDate().getValue();
                     } catch (Throwable var644) {
                        var10000 = var644;
                        boolean var701 = false;
                        break label5667;
                     }

                     if (var12 != null) {
                        var3 = var670;

                        try {
                           var6 = var12;
                        } catch (Throwable var643) {
                           var10000 = var643;
                           boolean var702 = false;
                           break label5667;
                        }
                     }

                     var3 = var670;

                     try {
                        var683 = (Continuation)this;
                     } catch (Throwable var642) {
                        var10000 = var642;
                        boolean var703 = false;
                        break label5667;
                     }

                     var3 = var670;

                     try {
                        this.Z$0 = var670;
                     } catch (Throwable var641) {
                        var10000 = var641;
                        boolean var704 = false;
                        break label5667;
                     }

                     var3 = var670;

                     try {
                        this.label = 3;
                     } catch (Throwable var640) {
                        var10000 = var640;
                        boolean var705 = false;
                        break label5667;
                     }

                     var3 = var670;

                     try {
                        var677 = var679.emailRegister(var666, var675, var680, var681, "", var5, var6, var683);
                     } catch (Throwable var639) {
                        var10000 = var639;
                        boolean var706 = false;
                        break label5667;
                     }

                     var3 = var670;
                     var1 = (AuthService)var677;
                     if (var677 == var8) {
                        return var8;
                     }
                  }

                  label5568:
                  try {
                     GigyaAccount var669 = (GigyaAccount)var1;
                     return var669;
                  } catch (Throwable var638) {
                     var10000 = var638;
                     boolean var707 = false;
                     break label5568;
                  }
               }

               Throwable var678 = var10000;
               String var668;
               if (var678 instanceof GigyaService.GigyaException) {
                  var668 = String.valueOf(((GigyaService.GigyaException)var678).getError().getErrorCode());
               } else {
                  var668 = var678.getMessage();
               }

               if (Intrinsics.areEqual(var668, "400009") && var3) {
                  throw new Exception("400009-1");
               } else {
                  throw var678;
               }
            }
         });
      }
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"},
      d2 = {"Lcom/blueair/login/RegisterViewModel$Companion;", "", "<init>", "()V", "PASSWORD_REGEX_US", "Lkotlin/text/Regex;", "getPASSWORD_REGEX_US$login_otherRelease$annotations", "getPASSWORD_REGEX_US$login_otherRelease", "()Lkotlin/text/Regex;", "PASSWORD_REGEX_EU", "getPASSWORD_REGEX_EU$login_otherRelease$annotations", "getPASSWORD_REGEX_EU$login_otherRelease", "PASSWORD_REGEX_CN", "getPASSWORD_REGEX_CN$login_otherRelease$annotations", "getPASSWORD_REGEX_CN$login_otherRelease", "login_otherRelease"},
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
      public static void getPASSWORD_REGEX_CN$login_otherRelease$annotations() {
      }

      // $FF: synthetic method
      public static void getPASSWORD_REGEX_EU$login_otherRelease$annotations() {
      }

      // $FF: synthetic method
      public static void getPASSWORD_REGEX_US$login_otherRelease$annotations() {
      }

      public final Regex getPASSWORD_REGEX_CN$login_otherRelease() {
         return RegisterViewModel.PASSWORD_REGEX_CN;
      }

      public final Regex getPASSWORD_REGEX_EU$login_otherRelease() {
         return RegisterViewModel.PASSWORD_REGEX_EU;
      }

      public final Regex getPASSWORD_REGEX_US$login_otherRelease() {
         return RegisterViewModel.PASSWORD_REGEX_US;
      }
   }
}
