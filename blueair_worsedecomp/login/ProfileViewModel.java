package com.blueair.login;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.android.LazyContextDIPropertyDelegateProvider;
import org.kodein.di.android.x.ClosestKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010D\u001a\u00020#R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8VX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001dX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00188F¢\u0006\u0006\u001a\u0004\b \u0010\u001bR\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001dX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00188F¢\u0006\u0006\u001a\u0004\b$\u0010\u001bR\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u001dX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u001f\u0010+\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00190\u00190\u001d¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b/\u0010(R\u001f\u00100\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00190\u00190\u001d¢\u0006\b\n\u0000\u001a\u0004\b1\u0010(R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b3\u0010(R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b5\u0010(R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b7\u0010(R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b9\u0010(R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b;\u0010(R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b=\u0010(R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d¢\u0006\b\n\u0000\u001a\u0004\b?\u0010(R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d¢\u0006\b\n\u0000\u001a\u0004\bA\u0010(R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/blueair/login/ProfileViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "Lorg/kodein/di/DIAware;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "gigyaService", "Lcom/blueair/auth/GigyaService;", "getGigyaService", "()Lcom/blueair/auth/GigyaService;", "gigyaService$delegate", "loading", "Landroidx/lifecycle/LiveData;", "", "getLoading", "()Landroidx/lifecycle/LiveData;", "_loading", "Landroidx/lifecycle/MutableLiveData;", "failure", "", "getFailure", "_failure", "success", "", "getSuccess", "_success", "email", "getEmail", "()Landroidx/lifecycle/MutableLiveData;", "firstName", "getFirstName", "firstNameValid", "kotlin.jvm.PlatformType", "getFirstNameValid", "lastName", "getLastName", "lastNameValid", "getLastNameValid", "phoneNumber", "getPhoneNumber", "address", "getAddress", "zipCode", "getZipCode", "area", "getArea", "city", "getCity", "country", "getCountry", "subscribe", "getSubscribe", "consentData", "getConsentData", "account", "Lcom/blueair/auth/GigyaAccountExtended;", "updateProfile", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ProfileViewModel.kt */
public final class ProfileViewModel extends AndroidViewModel implements CoroutineScope, DIAware {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    /* access modifiers changed from: private */
    public final MutableLiveData<String> _failure = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _loading = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<Unit> _success = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public GigyaAccountExtended account;
    private final MutableLiveData<String> address = new ProfileViewModel$address$1(this);
    private final MutableLiveData<String> area = new ProfileViewModel$area$1(this);
    private final MutableLiveData<String> city = new ProfileViewModel$city$1(this);
    private final MutableLiveData<Boolean> consentData = new ProfileViewModel$consentData$1(this);
    private final MutableLiveData<String> country = new ProfileViewModel$country$1(this);
    private final Lazy di$delegate;
    private final MutableLiveData<String> email = new ProfileViewModel$email$1(this);
    private final MutableLiveData<String> firstName = new ProfileViewModel$firstName$1(this);
    private final MutableLiveData<Boolean> firstNameValid = new MutableLiveData<>(true);
    private final Lazy gigyaService$delegate;
    private final MutableLiveData<String> lastName = new ProfileViewModel$lastName$1(this);
    private final MutableLiveData<Boolean> lastNameValid = new MutableLiveData<>(true);
    private final MutableLiveData<String> phoneNumber = new ProfileViewModel$phoneNumber$1(this);
    private final MutableLiveData<Boolean> subscribe = new ProfileViewModel$subscribe$1(this);
    private final MutableLiveData<String> zipCode = new ProfileViewModel$zipCode$1(this);

    static {
        Class<ProfileViewModel> cls = ProfileViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "di", "getDi()Lorg/kodein/di/DI;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "gigyaService", "getGigyaService()Lcom/blueair/auth/GigyaService;", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProfileViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "app");
        LazyContextDIPropertyDelegateProvider closestDI = ClosestKt.closestDI((AndroidViewModel) this);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.di$delegate = closestDI.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new ProfileViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.gigyaService$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, GigyaService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    public DIContext<?> getDiContext() {
        return DIAware.DefaultImpls.getDiContext(this);
    }

    public DITrigger getDiTrigger() {
        return DIAware.DefaultImpls.getDiTrigger(this);
    }

    public CoroutineContext getCoroutineContext() {
        return ViewModelKt.getViewModelScope(this).getCoroutineContext();
    }

    public DI getDi() {
        return (DI) this.di$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final GigyaService getGigyaService() {
        return (GigyaService) this.gigyaService$delegate.getValue();
    }

    public final LiveData<Boolean> getLoading() {
        return this._loading;
    }

    public final LiveData<String> getFailure() {
        return this._failure;
    }

    public final LiveData<Unit> getSuccess() {
        return this._success;
    }

    public final MutableLiveData<String> getEmail() {
        return this.email;
    }

    public final MutableLiveData<String> getFirstName() {
        return this.firstName;
    }

    public final MutableLiveData<Boolean> getFirstNameValid() {
        return this.firstNameValid;
    }

    public final MutableLiveData<String> getLastName() {
        return this.lastName;
    }

    public final MutableLiveData<Boolean> getLastNameValid() {
        return this.lastNameValid;
    }

    public final MutableLiveData<String> getPhoneNumber() {
        return this.phoneNumber;
    }

    public final MutableLiveData<String> getAddress() {
        return this.address;
    }

    public final MutableLiveData<String> getZipCode() {
        return this.zipCode;
    }

    public final MutableLiveData<String> getArea() {
        return this.area;
    }

    public final MutableLiveData<String> getCity() {
        return this.city;
    }

    public final MutableLiveData<String> getCountry() {
        return this.country;
    }

    public final MutableLiveData<Boolean> getSubscribe() {
        return this.subscribe;
    }

    public final MutableLiveData<Boolean> getConsentData() {
        return this.consentData;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.login.ProfileViewModel$1", f = "ProfileViewModel.kt", i = {0, 0, 0}, l = {117}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-ProfileViewModel$1$result$1"}, s = {"L$0", "L$1", "I$0"})
    /* renamed from: com.blueair.login.ProfileViewModel$1  reason: invalid class name */
    /* compiled from: ProfileViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ProfileViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            SubscriptionsDto subscriptions;
            OptInOptOut optInOptOut;
            BrandXxBh8488Eml brand_xx_bh8488_eml;
            Email email;
            SubscriptionsDto subscriptions2;
            OptInOptOut optInOptOut2;
            Unilever unilever;
            Email email2;
            List<Phone> phones;
            Phone phone;
            GigyaAccountData data;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0._loading.setValue(Boxing.boxBoolean(true));
                ProfileViewModel profileViewModel = this.this$0;
                Result.Companion companion = Result.Companion;
                GigyaService access$getGigyaService = profileViewModel.getGigyaService();
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.I$0 = 0;
                this.label = 1;
                obj = access$getGigyaService.getProfile(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$1;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.m9366constructorimpl(ResultKt.createFailure(th2));
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj2 = Result.m9366constructorimpl((GigyaAccountExtended) obj);
            this.this$0._loading.setValue(Boxing.boxBoolean(false));
            if (Result.m9372isFailureimpl(obj2)) {
                MutableLiveData access$get_failure$p = this.this$0._failure;
                Throwable r11 = Result.m9369exceptionOrNullimpl(obj2);
                Intrinsics.checkNotNull(r11);
                access$get_failure$p.setValue(r11.getMessage());
                return Unit.INSTANCE;
            }
            ProfileViewModel profileViewModel2 = this.this$0;
            ResultKt.throwOnFailure(obj2);
            profileViewModel2.account = (GigyaAccountExtended) obj2;
            GigyaAccountExtended access$getAccount$p = this.this$0.account;
            if (access$getAccount$p != null) {
                if (access$getAccount$p.getProfile() == null) {
                    access$getAccount$p.setProfile(new Profile());
                }
                if (access$getAccount$p.getData().getAddress() == null) {
                    access$getAccount$p.setData(GigyaAccountData.copy$default(access$getAccount$p.getData(), new GigyaAccountAddress((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null), (String) null, (String) null, (Integer) null, 14, (Object) null));
                }
            }
            GigyaAccountExtended access$getAccount$p2 = this.this$0.account;
            Boolean bool = null;
            Profile profile = access$getAccount$p2 != null ? access$getAccount$p2.getProfile() : null;
            GigyaAccountExtended access$getAccount$p3 = this.this$0.account;
            GigyaAccountAddress address = (access$getAccount$p3 == null || (data = access$getAccount$p3.getData()) == null) ? null : data.getAddress();
            this.this$0.getEmail().setValue(profile != null ? profile.getEmail() : null);
            this.this$0.getFirstName().setValue(profile != null ? profile.getFirstName() : null);
            this.this$0.getLastName().setValue(profile != null ? profile.getLastName() : null);
            this.this$0.getPhoneNumber().setValue((profile == null || (phones = profile.getPhones()) == null || (phone = (Phone) CollectionsKt.firstOrNull(phones)) == null) ? null : phone.getNumber());
            this.this$0.getAddress().setValue(address != null ? address.getAddressLine1() : null);
            this.this$0.getZipCode().setValue(address != null ? address.getPostCode() : null);
            this.this$0.getArea().setValue(address != null ? address.getStateCode() : null);
            this.this$0.getCity().setValue(address != null ? address.getCity() : null);
            this.this$0.getCountry().setValue(address != null ? address.getCountry() : null);
            MutableLiveData<Boolean> subscribe = this.this$0.getSubscribe();
            GigyaAccountExtended access$getAccount$p4 = this.this$0.account;
            subscribe.setValue((access$getAccount$p4 == null || (subscriptions2 = access$getAccount$p4.getSubscriptions()) == null || (optInOptOut2 = subscriptions2.getOptInOptOut()) == null || (unilever = optInOptOut2.getUnilever()) == null || (email2 = unilever.getEmail()) == null) ? null : Boxing.boxBoolean(email2.isSubscribed()));
            MutableLiveData<Boolean> consentData = this.this$0.getConsentData();
            GigyaAccountExtended access$getAccount$p5 = this.this$0.account;
            if (!(access$getAccount$p5 == null || (subscriptions = access$getAccount$p5.getSubscriptions()) == null || (optInOptOut = subscriptions.getOptInOptOut()) == null || (brand_xx_bh8488_eml = optInOptOut.getBRAND_XX_BH8488_EML()) == null || (email = brand_xx_bh8488_eml.getEmail()) == null)) {
                bool = Boxing.boxBoolean(email.isSubscribed());
            }
            consentData.setValue(bool);
            return Unit.INSTANCE;
        }
    }

    public final void updateProfile() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new ProfileViewModel$updateProfile$1(this, (Continuation<? super ProfileViewModel$updateProfile$1>) null), 3, (Object) null);
    }
}
