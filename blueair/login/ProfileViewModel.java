package com.blueair.login;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blueair.auth.BrandXxBh8488Eml;
import com.blueair.auth.Email;
import com.blueair.auth.GigyaAccountAddress;
import com.blueair.auth.GigyaAccountData;
import com.blueair.auth.GigyaAccountExtended;
import com.blueair.auth.GigyaService;
import com.blueair.auth.OptInOptOut;
import com.blueair.auth.SubscriptionsDto;
import com.blueair.auth.Unilever;
import com.blueair.core.BuildEnvironment;
import com.gigya.android.sdk.account.models.Phone;
import com.gigya.android.sdk.account.models.Profile;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.LazyDelegate;
import org.kodein.di.DIAware.DefaultImpls;
import org.kodein.di.android.LazyContextDIPropertyDelegateProvider;
import org.kodein.di.android.x.ClosestKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010D\u001a\u00020#R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00188F¢\u0006\u0006\u001a\u0004\b \u0010\u001bR\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00188F¢\u0006\u0006\u001a\u0004\b$\u0010\u001bR\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u001f\u0010+\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00190\u00190\u001d¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b/\u0010(R\u001f\u00100\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00190\u00190\u001d¢\u0006\b\n\u0000\u001a\u0004\b1\u0010(R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b3\u0010(R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b5\u0010(R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b7\u0010(R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b9\u0010(R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b;\u0010(R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b=\u0010(R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d¢\u0006\b\n\u0000\u001a\u0004\b?\u0010(R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d¢\u0006\b\n\u0000\u001a\u0004\bA\u0010(R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"},
   d2 = {"Lcom/blueair/login/ProfileViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "Lorg/kodein/di/DIAware;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "gigyaService", "Lcom/blueair/auth/GigyaService;", "getGigyaService", "()Lcom/blueair/auth/GigyaService;", "gigyaService$delegate", "loading", "Landroidx/lifecycle/LiveData;", "", "getLoading", "()Landroidx/lifecycle/LiveData;", "_loading", "Landroidx/lifecycle/MutableLiveData;", "failure", "", "getFailure", "_failure", "success", "", "getSuccess", "_success", "email", "getEmail", "()Landroidx/lifecycle/MutableLiveData;", "firstName", "getFirstName", "firstNameValid", "kotlin.jvm.PlatformType", "getFirstNameValid", "lastName", "getLastName", "lastNameValid", "getLastNameValid", "phoneNumber", "getPhoneNumber", "address", "getAddress", "zipCode", "getZipCode", "area", "getArea", "city", "getCity", "country", "getCountry", "subscribe", "getSubscribe", "consentData", "getConsentData", "account", "Lcom/blueair/auth/GigyaAccountExtended;", "updateProfile", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ProfileViewModel extends AndroidViewModel implements CoroutineScope, DIAware {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(ProfileViewModel.class, "di", "getDi()Lorg/kodein/di/DI;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(ProfileViewModel.class, "gigyaService", "getGigyaService()Lcom/blueair/auth/GigyaService;", 0)))};
   private final MutableLiveData _failure;
   private final MutableLiveData _loading;
   private final MutableLiveData _success;
   private GigyaAccountExtended account;
   private final MutableLiveData address;
   private final MutableLiveData area;
   private final MutableLiveData city;
   private final MutableLiveData consentData;
   private final MutableLiveData country;
   private final Lazy di$delegate;
   private final MutableLiveData email;
   private final MutableLiveData firstName;
   private final MutableLiveData firstNameValid;
   private final Lazy gigyaService$delegate;
   private final MutableLiveData lastName;
   private final MutableLiveData lastNameValid;
   private final MutableLiveData phoneNumber;
   private final MutableLiveData subscribe;
   private final MutableLiveData zipCode;

   public ProfileViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "app");
      super(var1);
      LazyContextDIPropertyDelegateProvider var2 = ClosestKt.closestDI(this);
      KProperty[] var4 = $$delegatedProperties;
      this.di$delegate = var2.provideDelegate(this, var4[0]);
      DIAware var5 = this;
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var7 = DIAwareKt.Instance(var5, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, GigyaService.class)), (Object)null);
      Boolean var6 = true;
      this.gigyaService$delegate = var7.provideDelegate(this, var4[1]);
      this._loading = new MutableLiveData();
      this._failure = new MutableLiveData();
      this._success = new MutableLiveData();
      this.email = new MutableLiveData(this) {
         final ProfileViewModel this$0;

         {
            this.this$0 = var1;
         }

         public void setValue(String var1) {
            super.setValue(var1);
            GigyaAccountExtended var2 = this.this$0.account;
            if (var2 != null) {
               Profile var3 = var2.getProfile();
               if (var3 != null) {
                  var3.setEmail(var1);
               }
            }

         }
      };
      this.firstName = new MutableLiveData(this) {
         final ProfileViewModel this$0;

         {
            this.this$0 = var1;
         }

         public void setValue(String var1) {
            super.setValue(var1);
            GigyaAccountExtended var2 = this.this$0.account;
            if (var2 != null) {
               Profile var3 = var2.getProfile();
               if (var3 != null) {
                  var3.setFirstName(var1);
               }
            }

         }
      };
      this.firstNameValid = new MutableLiveData(var6);
      this.lastName = new MutableLiveData(this) {
         final ProfileViewModel this$0;

         {
            this.this$0 = var1;
         }

         public void setValue(String var1) {
            super.setValue(var1);
            GigyaAccountExtended var2 = this.this$0.account;
            if (var2 != null) {
               Profile var3 = var2.getProfile();
               if (var3 != null) {
                  var3.setLastName(var1);
               }
            }

         }
      };
      this.lastNameValid = new MutableLiveData(var6);
      this.phoneNumber = new MutableLiveData(this) {
         final ProfileViewModel this$0;

         {
            this.this$0 = var1;
         }

         public void setValue(String var1) {
            super.setValue(var1);
            Phone var2 = new Phone();
            var2.setNumber(var1);
            GigyaAccountExtended var3 = this.this$0.account;
            if (var3 != null) {
               Profile var4 = var3.getProfile();
               if (var4 != null) {
                  var4.setPhones(CollectionsKt.listOf(var2));
               }
            }

         }
      };
      this.address = new MutableLiveData(this) {
         final ProfileViewModel this$0;

         {
            this.this$0 = var1;
         }

         public void setValue(String var1) {
            super.setValue(var1);
            GigyaAccountExtended var2 = this.this$0.account;
            if (var2 != null) {
               GigyaAccountData var3 = var2.getData();
               if (var3 != null) {
                  GigyaAccountAddress var4 = var3.getAddress();
                  if (var4 != null) {
                     var4.setAddressLine1(var1);
                  }
               }
            }

         }
      };
      this.zipCode = new MutableLiveData(this) {
         final ProfileViewModel this$0;

         {
            this.this$0 = var1;
         }

         public void setValue(String var1) {
            super.setValue(var1);
            GigyaAccountExtended var2 = this.this$0.account;
            if (var2 != null) {
               GigyaAccountData var3 = var2.getData();
               if (var3 != null) {
                  GigyaAccountAddress var4 = var3.getAddress();
                  if (var4 != null) {
                     var4.setPostCode(var1);
                  }
               }
            }

         }
      };
      this.area = new MutableLiveData(this) {
         final ProfileViewModel this$0;

         {
            this.this$0 = var1;
         }

         public void setValue(String var1) {
            super.setValue(var1);
            GigyaAccountExtended var2 = this.this$0.account;
            if (var2 != null) {
               GigyaAccountData var3 = var2.getData();
               if (var3 != null) {
                  GigyaAccountAddress var4 = var3.getAddress();
                  if (var4 != null) {
                     var4.setStateCode(var1);
                  }
               }
            }

         }
      };
      this.city = new MutableLiveData(this) {
         final ProfileViewModel this$0;

         {
            this.this$0 = var1;
         }

         public void setValue(String var1) {
            super.setValue(var1);
            GigyaAccountExtended var2 = this.this$0.account;
            if (var2 != null) {
               GigyaAccountData var3 = var2.getData();
               if (var3 != null) {
                  GigyaAccountAddress var4 = var3.getAddress();
                  if (var4 != null) {
                     var4.setCity(var1);
                  }
               }
            }

         }
      };
      this.country = new MutableLiveData(this) {
         final ProfileViewModel this$0;

         {
            this.this$0 = var1;
         }

         public void setValue(String var1) {
            super.setValue(var1);
            GigyaAccountExtended var2 = this.this$0.account;
            if (var2 != null) {
               GigyaAccountData var3 = var2.getData();
               if (var3 != null) {
                  GigyaAccountAddress var4 = var3.getAddress();
                  if (var4 != null) {
                     var4.setCountry(var1);
                  }
               }
            }

         }
      };
      this.subscribe = new MutableLiveData(this) {
         final ProfileViewModel this$0;

         {
            this.this$0 = var1;
         }

         public void setValue(Boolean var1) {
            super.setValue(var1);
            GigyaAccountExtended var3 = this.this$0.account;
            if (var3 != null) {
               SubscriptionsDto var4 = var3.getSubscriptions();
               if (var4 != null) {
                  OptInOptOut var5 = var4.getOptInOptOut();
                  if (var5 != null) {
                     Unilever var6 = var5.getUnilever();
                     if (var6 != null) {
                        Email var7 = var6.getEmail();
                        if (var7 != null) {
                           boolean var2;
                           if (var1 != null) {
                              var2 = var1;
                           } else {
                              var2 = false;
                           }

                           var7.setSubscribed(var2);
                        }
                     }
                  }
               }
            }

         }
      };
      this.consentData = new MutableLiveData(this) {
         final ProfileViewModel this$0;

         {
            this.this$0 = var1;
         }

         public void setValue(Boolean var1) {
            super.setValue(var1);
            GigyaAccountExtended var3 = this.this$0.account;
            if (var3 != null) {
               SubscriptionsDto var4 = var3.getSubscriptions();
               if (var4 != null) {
                  OptInOptOut var5 = var4.getOptInOptOut();
                  if (var5 != null) {
                     BrandXxBh8488Eml var6 = var5.getBRAND_XX_BH8488_EML();
                     if (var6 != null) {
                        Email var7 = var6.getEmail();
                        if (var7 != null) {
                           boolean var2;
                           if (var1 != null) {
                              var2 = var1;
                           } else {
                              var2 = false;
                           }

                           var7.setSubscribed(var2);
                        }
                     }
                  }
               }
            }

         }
      };
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int I$0;
         private Object L$0;
         Object L$1;
         int label;
         final ProfileViewModel this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.this$0, var2);
            var3.L$0 = var1;
            return (Continuation)var3;
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            label588: {
               Throwable var10000;
               label587: {
                  CoroutineScope var3 = (CoroutineScope)this.L$0;
                  Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = (CoroutineScope)this.L$1;

                     try {
                        ResultKt.throwOnFailure(var1);
                     } catch (Throwable var18) {
                        var10000 = var18;
                        boolean var10001 = false;
                        break label587;
                     }
                  } else {
                     ResultKt.throwOnFailure(var1);
                     this.this$0._loading.setValue(Boxing.boxBoolean(true));
                     ProfileViewModel var5 = this.this$0;

                     try {
                        Result.Companion var19 = Result.Companion;
                        GigyaService var20 = var5.getGigyaService();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(var3);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(var3);
                        this.I$0 = 0;
                        this.label = 1;
                        var38 = var20.getProfile(this);
                     } catch (Throwable var17) {
                        var10000 = var17;
                        boolean var69 = false;
                        break label587;
                     }

                     var1 = var38;
                     if (var38 == var4) {
                        return var4;
                     }
                  }

                  label578:
                  try {
                     var1 = Result.constructor-impl((GigyaAccountExtended)var1);
                     break label588;
                  } catch (Throwable var16) {
                     var10000 = var16;
                     boolean var70 = false;
                     break label578;
                  }
               }

               Throwable var39 = var10000;
               Result.Companion var21 = Result.Companion;
               var1 = Result.constructor-impl(ResultKt.createFailure(var39));
            }

            this.this$0._loading.setValue(Boxing.boxBoolean(false));
            if (Result.isFailure-impl(var1)) {
               MutableLiveData var52 = this.this$0._failure;
               Throwable var36 = Result.exceptionOrNull-impl(var1);
               Intrinsics.checkNotNull(var36);
               var52.setValue(var36.getMessage());
               return Unit.INSTANCE;
            } else {
               ProfileViewModel var40 = this.this$0;
               ResultKt.throwOnFailure(var1);
               var40.account = (GigyaAccountExtended)var1;
               GigyaAccountExtended var23 = this.this$0.account;
               if (var23 != null) {
                  if (var23.getProfile() == null) {
                     var23.setProfile(new Profile());
                  }

                  if (var23.getData().getAddress() == null) {
                     var23.setData(GigyaAccountData.copy$default(var23.getData(), new GigyaAccountAddress((String)null, (String)null, (String)null, (String)null, (String)null, 31, (DefaultConstructorMarker)null), (String)null, (String)null, (Integer)null, 14, (Object)null));
                  }
               }

               var23 = this.this$0.account;
               Object var66 = null;
               Profile var41;
               if (var23 != null) {
                  var41 = var23.getProfile();
               } else {
                  var41 = null;
               }

               label567: {
                  var23 = this.this$0.account;
                  if (var23 != null) {
                     GigyaAccountData var26 = var23.getData();
                     if (var26 != null) {
                        var27 = var26.getAddress();
                        break label567;
                     }
                  }

                  var27 = null;
               }

               MutableLiveData var6 = this.this$0.getEmail();
               String var53;
               if (var41 != null) {
                  var53 = var41.getEmail();
               } else {
                  var53 = null;
               }

               var6.setValue(var53);
               var6 = this.this$0.getFirstName();
               if (var41 != null) {
                  var53 = var41.getFirstName();
               } else {
                  var53 = null;
               }

               var6.setValue(var53);
               var6 = this.this$0.getLastName();
               if (var41 != null) {
                  var53 = var41.getLastName();
               } else {
                  var53 = null;
               }

               label561: {
                  var6.setValue(var53);
                  var56 = this.this$0.getPhoneNumber();
                  if (var41 != null) {
                     List var42 = var41.getPhones();
                     if (var42 != null) {
                        Phone var43 = (Phone)CollectionsKt.firstOrNull(var42);
                        if (var43 != null) {
                           var44 = var43.getNumber();
                           break label561;
                        }
                     }
                  }

                  var44 = null;
               }

               var56.setValue(var44);
               MutableLiveData var57 = this.this$0.getAddress();
               String var45;
               if (var27 != null) {
                  var45 = var27.getAddressLine1();
               } else {
                  var45 = null;
               }

               var57.setValue(var45);
               var57 = this.this$0.getZipCode();
               if (var27 != null) {
                  var45 = var27.getPostCode();
               } else {
                  var45 = null;
               }

               var57.setValue(var45);
               var57 = this.this$0.getArea();
               if (var27 != null) {
                  var45 = var27.getStateCode();
               } else {
                  var45 = null;
               }

               var57.setValue(var45);
               var57 = this.this$0.getCity();
               if (var27 != null) {
                  var45 = var27.getCity();
               } else {
                  var45 = null;
               }

               var57.setValue(var45);
               MutableLiveData var49 = this.this$0.getCountry();
               String var28;
               if (var27 != null) {
                  var28 = var27.getCountry();
               } else {
                  var28 = null;
               }

               label554: {
                  var49.setValue(var28);
                  var49 = this.this$0.getSubscribe();
                  GigyaAccountExtended var29 = this.this$0.account;
                  if (var29 != null) {
                     SubscriptionsDto var30 = var29.getSubscriptions();
                     if (var30 != null) {
                        OptInOptOut var31 = var30.getOptInOptOut();
                        if (var31 != null) {
                           Unilever var32 = var31.getUnilever();
                           if (var32 != null) {
                              Email var33 = var32.getEmail();
                              if (var33 != null) {
                                 var34 = Boxing.boxBoolean(var33.isSubscribed());
                                 break label554;
                              }
                           }
                        }
                     }
                  }

                  var34 = null;
               }

               var49.setValue(var34);
               var49 = this.this$0.getConsentData();
               GigyaAccountExtended var61 = this.this$0.account;
               Boolean var35 = (Boolean)var66;
               if (var61 != null) {
                  SubscriptionsDto var62 = var61.getSubscriptions();
                  var35 = (Boolean)var66;
                  if (var62 != null) {
                     OptInOptOut var63 = var62.getOptInOptOut();
                     var35 = (Boolean)var66;
                     if (var63 != null) {
                        BrandXxBh8488Eml var64 = var63.getBRAND_XX_BH8488_EML();
                        var35 = (Boolean)var66;
                        if (var64 != null) {
                           Email var65 = var64.getEmail();
                           var35 = (Boolean)var66;
                           if (var65 != null) {
                              var35 = Boxing.boxBoolean(var65.isSubscribed());
                           }
                        }
                     }
                  }
               }

               var49.setValue(var35);
               return Unit.INSTANCE;
            }
         }
      }, 3, (Object)null);
   }

   private final GigyaService getGigyaService() {
      return (GigyaService)this.gigyaService$delegate.getValue();
   }

   public final MutableLiveData getAddress() {
      return this.address;
   }

   public final MutableLiveData getArea() {
      return this.area;
   }

   public final MutableLiveData getCity() {
      return this.city;
   }

   public final MutableLiveData getConsentData() {
      return this.consentData;
   }

   public CoroutineContext getCoroutineContext() {
      return ViewModelKt.getViewModelScope((ViewModel)this).getCoroutineContext();
   }

   public final MutableLiveData getCountry() {
      return this.country;
   }

   public DI getDi() {
      return (DI)this.di$delegate.getValue();
   }

   public DIContext getDiContext() {
      return DefaultImpls.getDiContext(this);
   }

   public DITrigger getDiTrigger() {
      return DefaultImpls.getDiTrigger(this);
   }

   public final MutableLiveData getEmail() {
      return this.email;
   }

   public final LiveData getFailure() {
      return (LiveData)this._failure;
   }

   public final MutableLiveData getFirstName() {
      return this.firstName;
   }

   public final MutableLiveData getFirstNameValid() {
      return this.firstNameValid;
   }

   public final MutableLiveData getLastName() {
      return this.lastName;
   }

   public final MutableLiveData getLastNameValid() {
      return this.lastNameValid;
   }

   public final LiveData getLoading() {
      return (LiveData)this._loading;
   }

   public final MutableLiveData getPhoneNumber() {
      return this.phoneNumber;
   }

   public final MutableLiveData getSubscribe() {
      return this.subscribe;
   }

   public final LiveData getSuccess() {
      return (LiveData)this._success;
   }

   public final MutableLiveData getZipCode() {
      return this.zipCode;
   }

   public final void updateProfile() {
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int I$0;
         int I$1;
         private Object L$0;
         Object L$1;
         Object L$2;
         Object L$3;
         int label;
         final ProfileViewModel this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.this$0, var2);
            var3.L$0 = var1;
            return (Continuation)var3;
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            label486: {
               Throwable var10000;
               label496: {
                  CoroutineScope var6 = (CoroutineScope)this.L$0;
                  Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  GigyaAccountExtended var35;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     GigyaAccountExtended var40 = (GigyaAccountExtended)this.L$3;
                     var40 = (GigyaAccountExtended)this.L$2;
                     CoroutineScope var46 = (CoroutineScope)this.L$1;

                     try {
                        ResultKt.throwOnFailure(var1);
                     } catch (Throwable var26) {
                        var10000 = var26;
                        boolean var48 = false;
                        break label496;
                     }

                     var35 = var40;
                  } else {
                     ResultKt.throwOnFailure(var1);
                     if (BuildEnvironment.INSTANCE.isChina()) {
                        CharSequence var28 = (CharSequence)this.this$0.getFirstName().getValue();
                        if (var28 == null || StringsKt.isBlank(var28)) {
                           this.this$0.getFirstName().setValue("-");
                        }

                        var28 = (CharSequence)this.this$0.getLastName().getValue();
                        if (var28 == null || StringsKt.isBlank(var28)) {
                           this.this$0.getLastName().setValue("-");
                        }
                     }

                     MutableLiveData var4 = this.this$0.getFirstNameValid();
                     String var30 = (String)this.this$0.getFirstName().getValue();
                     Object var3 = null;
                     Boolean var31;
                     if (var30 != null) {
                        var31 = Boxing.boxBoolean(StringsKt.isBlank((CharSequence)var30) ^ true);
                     } else {
                        var31 = null;
                     }

                     var4.setValue(var31);
                     var4 = this.this$0.getLastNameValid();
                     String var32 = (String)this.this$0.getLastName().getValue();
                     Boolean var33;
                     if (var32 != null) {
                        var33 = Boxing.boxBoolean(StringsKt.isBlank((CharSequence)var32) ^ true);
                     } else {
                        var33 = null;
                     }

                     var4.setValue(var33);
                     if (!Intrinsics.areEqual(this.this$0.getFirstNameValid().getValue(), Boxing.boxBoolean(true)) || !Intrinsics.areEqual(this.this$0.getLastNameValid().getValue(), Boxing.boxBoolean(true))) {
                        return Unit.INSTANCE;
                     }

                     this.this$0._loading.setValue(Boxing.boxBoolean(true));
                     ProfileViewModel var7 = this.this$0;

                     try {
                        Result.Companion var34 = Result.Companion;
                        var45 = var7.account;
                     } catch (Throwable var25) {
                        var10000 = var25;
                        boolean var10001 = false;
                        break label496;
                     }

                     var35 = (GigyaAccountExtended)var3;
                     if (var45 != null) {
                        try {
                           GigyaService var36 = var7.getGigyaService();
                           this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                           this.L$1 = SpillingKt.nullOutSpilledVariable(var6);
                           this.L$2 = var45;
                           this.L$3 = SpillingKt.nullOutSpilledVariable(var45);
                           this.I$0 = 0;
                           this.I$1 = 0;
                           this.label = 1;
                           if (var36.updateProfile(var45, true, this) == var5) {
                              return var5;
                           }
                        } catch (Throwable var27) {
                           var10000 = var27;
                           boolean var47 = false;
                           break label496;
                        }

                        var35 = var45;
                     }
                  }

                  label458:
                  try {
                     var1 = Result.constructor-impl(var35);
                     break label486;
                  } catch (Throwable var24) {
                     var10000 = var24;
                     boolean var49 = false;
                     break label458;
                  }
               }

               Throwable var42 = var10000;
               Result.Companion var37 = Result.Companion;
               var1 = Result.constructor-impl(ResultKt.createFailure(var42));
            }

            this.this$0._loading.setValue(Boxing.boxBoolean(false));
            if (Result.isFailure-impl(var1)) {
               MutableLiveData var43 = this.this$0._failure;
               Throwable var39 = Result.exceptionOrNull-impl(var1);
               Intrinsics.checkNotNull(var39);
               var43.setValue(var39.getMessage());
            } else {
               this.this$0._success.setValue(Unit.INSTANCE);
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }
}
