package com.blueair.login;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b-\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 G2\u00020\u0001:\u0001GB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010A\u001a\u00020BJ\u000e\u0010C\u001a\u00020BH@¢\u0006\u0002\u0010DJ\u0006\u0010E\u001a\u00020BJ\b\u0010F\u001a\u00020\u0014H\u0002R\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\u0002X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\n8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00140\u00140\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\n8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\rR\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00140\u00140\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\rR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140\n8F¢\u0006\u0006\u001a\u0004\b$\u0010\rR\u001c\u0010%\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00140\u00140\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0012R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8F¢\u0006\u0006\u001a\u0004\b)\u0010\rR\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0012R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140\n8F¢\u0006\u0006\u001a\u0004\b.\u0010\rR\u001c\u0010/\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00140\u00140\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0012R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u00140\n8F¢\u0006\u0006\u001a\u0004\b3\u0010\rR\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0012R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0012R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0012R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00140\n8F¢\u0006\u0006\u001a\u0004\b<\u0010\rR\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00140\n8F¢\u0006\u0006\u001a\u0004\b?\u0010\rR\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/blueair/login/RegisterViewModel;", "Lcom/blueair/login/BaseLoginViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dataCenter", "Landroidx/lifecycle/LiveData;", "", "getDataCenter", "()Landroidx/lifecycle/LiveData;", "_dataCenter", "Landroidx/lifecycle/MutableLiveData;", "firstName", "getFirstName", "()Landroidx/lifecycle/MutableLiveData;", "firstNameValid", "", "getFirstNameValid", "_firstNameValid", "lastName", "getLastName", "lastNameValid", "getLastNameValid", "_lastNameValid", "email", "getEmail", "emailError", "getEmailError", "_emailError", "phone", "getPhone", "phoneValid", "getPhoneValid", "_phoneValid", "password", "getPassword", "passwordError", "getPasswordError", "_passwordError", "confirmPassword", "getConfirmPassword", "confirmPasswordValid", "getConfirmPasswordValid", "_confirmPasswordValid", "confirmYear", "getConfirmYear", "yearConfirmed", "getYearConfirmed", "_yearConfirmed", "confirmSubscribe", "getConfirmSubscribe", "confirmConsentDate", "getConfirmConsentDate", "confirmPrivacy", "getConfirmPrivacy", "privacyConfirmed", "getPrivacyConfirmed", "_privacyConfirmed", "formError", "getFormError", "_formError", "loadDataCenter", "", "updateGigyaDataCenter", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "validateForm", "Companion", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: RegisterViewModel.kt */
public final class RegisterViewModel extends BaseLoginViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Regex PASSWORD_REGEX_CN;
    /* access modifiers changed from: private */
    public static final Regex PASSWORD_REGEX_EU;
    /* access modifiers changed from: private */
    public static final Regex PASSWORD_REGEX_US = new Regex("(?=.*?[A-Z])(?=.*?[a-z])(?=.*\\d)(?=.*?[#?!@$%^&*-])(?!.*\\s).{10,}");
    private final MutableLiveData<Boolean> _confirmPasswordValid = new MutableLiveData<>(true);
    /* access modifiers changed from: private */
    public final MutableLiveData<String> _dataCenter = new MutableLiveData<>();
    private final MutableLiveData<String> _emailError = new MutableLiveData<>(null);
    private final MutableLiveData<Boolean> _firstNameValid = new MutableLiveData<>(true);
    private final MutableLiveData<Boolean> _formError = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> _lastNameValid = new MutableLiveData<>(true);
    private final MutableLiveData<String> _passwordError = new MutableLiveData<>(null);
    private final MutableLiveData<Boolean> _phoneValid = new MutableLiveData<>(true);
    private final MutableLiveData<Boolean> _privacyConfirmed = new MutableLiveData<>();
    private final MutableLiveData<Boolean> _yearConfirmed = new MutableLiveData<>();
    private final MutableLiveData<Boolean> confirmConsentDate = new MutableLiveData<>();
    private final MutableLiveData<String> confirmPassword = new MutableLiveData<>();
    private final MutableLiveData<Boolean> confirmPrivacy = new MutableLiveData<>();
    private final MutableLiveData<Boolean> confirmSubscribe = new MutableLiveData<>();
    private final MutableLiveData<Boolean> confirmYear = new MutableLiveData<>();
    private final Context context;
    private final MutableLiveData<String> email = new MutableLiveData<>();
    private final MutableLiveData<String> firstName = new MutableLiveData<>();
    private final MutableLiveData<String> lastName = new MutableLiveData<>();
    private final MutableLiveData<String> password = new MutableLiveData<>();
    private final MutableLiveData<String> phone = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RegisterViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "app");
        this.context = application.getApplicationContext();
    }

    public final LiveData<String> getDataCenter() {
        return this._dataCenter;
    }

    public final MutableLiveData<String> getFirstName() {
        return this.firstName;
    }

    public final LiveData<Boolean> getFirstNameValid() {
        return this._firstNameValid;
    }

    public final MutableLiveData<String> getLastName() {
        return this.lastName;
    }

    public final LiveData<Boolean> getLastNameValid() {
        return this._lastNameValid;
    }

    public final MutableLiveData<String> getEmail() {
        return this.email;
    }

    public final LiveData<String> getEmailError() {
        return this._emailError;
    }

    public final MutableLiveData<String> getPhone() {
        return this.phone;
    }

    public final LiveData<Boolean> getPhoneValid() {
        return this._phoneValid;
    }

    public final MutableLiveData<String> getPassword() {
        return this.password;
    }

    public final LiveData<String> getPasswordError() {
        return this._passwordError;
    }

    public final MutableLiveData<String> getConfirmPassword() {
        return this.confirmPassword;
    }

    public final LiveData<Boolean> getConfirmPasswordValid() {
        return this._confirmPasswordValid;
    }

    public final MutableLiveData<Boolean> getConfirmYear() {
        return this.confirmYear;
    }

    public final LiveData<Boolean> getYearConfirmed() {
        return this._yearConfirmed;
    }

    public final MutableLiveData<Boolean> getConfirmSubscribe() {
        return this.confirmSubscribe;
    }

    public final MutableLiveData<Boolean> getConfirmConsentDate() {
        return this.confirmConsentDate;
    }

    public final MutableLiveData<Boolean> getConfirmPrivacy() {
        return this.confirmPrivacy;
    }

    public final LiveData<Boolean> getPrivacyConfirmed() {
        return this._privacyConfirmed;
    }

    public final LiveData<Boolean> getFormError() {
        return this._formError;
    }

    public final void loadDataCenter() {
        loadingLaunch(new RegisterViewModel$loadDataCenter$1(this, (Continuation<? super RegisterViewModel$loadDataCenter$1>) null));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateGigyaDataCenter(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.blueair.login.RegisterViewModel$updateGigyaDataCenter$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.blueair.login.RegisterViewModel$updateGigyaDataCenter$1 r0 = (com.blueair.login.RegisterViewModel$updateGigyaDataCenter$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.blueair.login.RegisterViewModel$updateGigyaDataCenter$1 r0 = new com.blueair.login.RegisterViewModel$updateGigyaDataCenter$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0042
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            com.blueair.auth.AuthService r5 = r4.getAuthService()
            r0.label = r3
            java.lang.Object r5 = r5.updateGigyaDataCenter(r0)
            if (r5 != r1) goto L_0x0042
            return r1
        L_0x0042:
            com.blueair.auth.GigyaServer r5 = (com.blueair.auth.GigyaServer) r5
            androidx.lifecycle.MutableLiveData<java.lang.String> r0 = r4._dataCenter
            java.lang.String r5 = r5.getCountryCode()
            r0.postValue(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.login.RegisterViewModel.updateGigyaDataCenter(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void register() {
        if (!validateForm()) {
            this._formError.setValue(true);
            return;
        }
        this._formError.setValue(false);
        authenticateUser(new RegisterViewModel$register$1(this, (Continuation<? super RegisterViewModel$register$1>) null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0266 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0267  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean validateForm() {
        /*
            r11 = this;
            com.blueair.core.BuildEnvironment r0 = com.blueair.core.BuildEnvironment.INSTANCE
            boolean r0 = r0.isChina()
            r1 = 2
            r2 = 0
            r3 = 0
            r4 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)
            if (r0 == 0) goto L_0x0013
        L_0x0010:
            r0 = r4
            goto L_0x008c
        L_0x0013:
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r0 = r11._firstNameValid
            androidx.lifecycle.MutableLiveData<java.lang.String> r6 = r11.firstName
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x002b
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)
            r6 = r6 ^ r4
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            goto L_0x002c
        L_0x002b:
            r6 = r2
        L_0x002c:
            r0.setValue(r6)
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r0 = r11._lastNameValid
            androidx.lifecycle.MutableLiveData<java.lang.String> r6 = r11.lastName
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x0047
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)
            r6 = r6 ^ r4
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            goto L_0x0048
        L_0x0047:
            r6 = r2
        L_0x0048:
            r0.setValue(r6)
            java.lang.Boolean[] r0 = new java.lang.Boolean[r1]
            androidx.lifecycle.LiveData r6 = r11.getFirstNameValid()
            java.lang.Object r6 = r6.getValue()
            r0[r3] = r6
            androidx.lifecycle.LiveData r6 = r11.getLastNameValid()
            java.lang.Object r6 = r6.getValue()
            r0[r4] = r6
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r6 = r0 instanceof java.util.Collection
            if (r6 == 0) goto L_0x0075
            r6 = r0
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x0075
            goto L_0x0010
        L_0x0075:
            java.util.Iterator r0 = r0.iterator()
        L_0x0079:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x0010
            java.lang.Object r6 = r0.next()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r5)
            if (r6 != 0) goto L_0x0079
            r0 = r3
        L_0x008c:
            androidx.lifecycle.MutableLiveData<java.lang.String> r6 = r11._emailError
            androidx.lifecycle.MutableLiveData<java.lang.String> r7 = r11.email
            java.lang.Object r7 = r7.getValue()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x00c2
            int r7 = r7.length()
            if (r7 != 0) goto L_0x009f
            goto L_0x00c2
        L_0x009f:
            java.util.regex.Pattern r7 = android.util.Patterns.EMAIL_ADDRESS
            androidx.lifecycle.MutableLiveData<java.lang.String> r8 = r11.email
            java.lang.Object r8 = r8.getValue()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            java.util.regex.Matcher r7 = r7.matcher(r8)
            boolean r7 = r7.matches()
            if (r7 != 0) goto L_0x00c0
            android.content.Context r7 = r11.context
            int r8 = com.blueair.viewcore.R.string.invalid_email
            java.lang.String r7 = r7.getString(r8)
            goto L_0x00ca
        L_0x00c0:
            r7 = r2
            goto L_0x00ca
        L_0x00c2:
            android.content.Context r7 = r11.context
            int r8 = com.blueair.viewcore.R.string.enter_email
            java.lang.String r7 = r7.getString(r8)
        L_0x00ca:
            r6.setValue(r7)
            androidx.lifecycle.LiveData r6 = r11.getDataCenter()
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x00fe
            int r7 = r6.hashCode()
            r8 = 3179(0xc6b, float:4.455E-42)
            if (r7 == r8) goto L_0x00f2
            r8 = 3248(0xcb0, float:4.551E-42)
            if (r7 == r8) goto L_0x00e6
            goto L_0x00fe
        L_0x00e6:
            java.lang.String r7 = "eu"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x00ef
            goto L_0x00fe
        L_0x00ef:
            kotlin.text.Regex r6 = PASSWORD_REGEX_EU
            goto L_0x0100
        L_0x00f2:
            java.lang.String r7 = "cn"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x00fb
            goto L_0x00fe
        L_0x00fb:
            kotlin.text.Regex r6 = PASSWORD_REGEX_CN
            goto L_0x0100
        L_0x00fe:
            kotlin.text.Regex r6 = PASSWORD_REGEX_US
        L_0x0100:
            androidx.lifecycle.MutableLiveData<java.lang.String> r7 = r11.password
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            androidx.lifecycle.MutableLiveData<java.lang.String> r8 = r11._passwordError
            r9 = r7
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x0131
            int r10 = r9.length()
            if (r10 != 0) goto L_0x0116
            goto L_0x0131
        L_0x0116:
            androidx.lifecycle.MutableLiveData<java.lang.String> r10 = r11.password
            java.lang.Object r10 = r10.getValue()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = r6.matches(r10)
            if (r10 != 0) goto L_0x0139
            android.content.Context r2 = r11.context
            int r10 = com.blueair.viewcore.R.string.invalid_password
            java.lang.String r2 = r2.getString(r10)
            goto L_0x0139
        L_0x0131:
            android.content.Context r2 = r11.context
            int r10 = com.blueair.viewcore.R.string.enter_password
            java.lang.String r2 = r2.getString(r10)
        L_0x0139:
            r8.setValue(r2)
            kotlin.text.Regex r2 = PASSWORD_REGEX_US
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r2)
            r6 = 3
            if (r2 != 0) goto L_0x01a5
            androidx.lifecycle.LiveData r2 = r11.getPasswordError()
            java.lang.Object r2 = r2.getValue()
            if (r2 != 0) goto L_0x01a5
            if (r7 == 0) goto L_0x01a5
            java.lang.String r2 = "[0-9]"
            java.lang.String r7 = "[#?!@$%^&*-]"
            java.lang.String r8 = "[a-z]"
            java.lang.String r10 = "[A-Z]"
            java.lang.String[] r2 = new java.lang.String[]{r8, r10, r2, r7}
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            boolean r7 = r2 instanceof java.util.Collection
            if (r7 == 0) goto L_0x0172
            r7 = r2
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x0172
            r7 = r3
            goto L_0x0196
        L_0x0172:
            java.util.Iterator r2 = r2.iterator()
            r7 = r3
        L_0x0177:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x0196
            java.lang.Object r8 = r2.next()
            java.lang.String r8 = (java.lang.String) r8
            kotlin.text.Regex r10 = new kotlin.text.Regex
            r10.<init>((java.lang.String) r8)
            boolean r8 = r10.containsMatchIn(r9)
            if (r8 == 0) goto L_0x0177
            int r7 = r7 + 1
            if (r7 >= 0) goto L_0x0177
            kotlin.collections.CollectionsKt.throwCountOverflow()
            goto L_0x0177
        L_0x0196:
            if (r7 >= r6) goto L_0x01a5
            androidx.lifecycle.MutableLiveData<java.lang.String> r2 = r11._passwordError
            android.content.Context r7 = r11.context
            int r8 = com.blueair.viewcore.R.string.invalid_password
            java.lang.String r7 = r7.getString(r8)
            r2.setValue(r7)
        L_0x01a5:
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r2 = r11._confirmPasswordValid
            androidx.lifecycle.MutableLiveData<java.lang.String> r7 = r11.confirmPassword
            java.lang.Object r7 = r7.getValue()
            androidx.lifecycle.MutableLiveData<java.lang.String> r8 = r11.password
            java.lang.Object r8 = r8.getValue()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r2.setValue(r7)
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r2 = r11._yearConfirmed
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r7 = r11.confirmYear
            java.lang.Object r7 = r7.getValue()
            if (r7 == 0) goto L_0x01db
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r7 = r11.confirmYear
            java.lang.Object r7 = r7.getValue()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x01db
            r7 = r4
            goto L_0x01dc
        L_0x01db:
            r7 = r3
        L_0x01dc:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r2.setValue(r7)
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r2 = r11._privacyConfirmed
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r7 = r11.confirmPrivacy
            java.lang.Object r7 = r7.getValue()
            if (r7 == 0) goto L_0x0200
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r7 = r11.confirmPrivacy
            java.lang.Object r7 = r7.getValue()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0200
            r7 = r4
            goto L_0x0201
        L_0x0200:
            r7 = r3
        L_0x0201:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r2.setValue(r7)
            r2 = 6
            java.lang.Boolean[] r2 = new java.lang.Boolean[r2]
            androidx.lifecycle.LiveData r7 = r11.getEmailError()
            java.lang.Object r7 = r7.getValue()
            if (r7 != 0) goto L_0x0217
            r7 = r4
            goto L_0x0218
        L_0x0217:
            r7 = r3
        L_0x0218:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r2[r3] = r7
            androidx.lifecycle.LiveData r7 = r11.getPasswordError()
            java.lang.Object r7 = r7.getValue()
            if (r7 != 0) goto L_0x022a
            r7 = r4
            goto L_0x022b
        L_0x022a:
            r7 = r3
        L_0x022b:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r2[r4] = r7
            androidx.lifecycle.LiveData r7 = r11.getConfirmPasswordValid()
            java.lang.Object r7 = r7.getValue()
            r2[r1] = r7
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r1 = r11.confirmYear
            java.lang.Object r1 = r1.getValue()
            r2[r6] = r1
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r1 = r11.confirmPrivacy
            java.lang.Object r1 = r1.getValue()
            r6 = 4
            r2[r6] = r1
            r1 = 5
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r2[r1] = r0
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r2)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L_0x0267
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0267
            return r4
        L_0x0267:
            java.util.Iterator r0 = r0.iterator()
        L_0x026b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x027e
            java.lang.Object r1 = r0.next()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
            if (r1 != 0) goto L_0x026b
            return r3
        L_0x027e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.login.RegisterViewModel.validateForm():boolean");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u00058\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/blueair/login/RegisterViewModel$Companion;", "", "<init>", "()V", "PASSWORD_REGEX_US", "Lkotlin/text/Regex;", "getPASSWORD_REGEX_US$login_otherRelease$annotations", "getPASSWORD_REGEX_US$login_otherRelease", "()Lkotlin/text/Regex;", "PASSWORD_REGEX_EU", "getPASSWORD_REGEX_EU$login_otherRelease$annotations", "getPASSWORD_REGEX_EU$login_otherRelease", "PASSWORD_REGEX_CN", "getPASSWORD_REGEX_CN$login_otherRelease$annotations", "getPASSWORD_REGEX_CN$login_otherRelease", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: RegisterViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getPASSWORD_REGEX_CN$login_otherRelease$annotations() {
        }

        public static /* synthetic */ void getPASSWORD_REGEX_EU$login_otherRelease$annotations() {
        }

        public static /* synthetic */ void getPASSWORD_REGEX_US$login_otherRelease$annotations() {
        }

        private Companion() {
        }

        public final Regex getPASSWORD_REGEX_US$login_otherRelease() {
            return RegisterViewModel.PASSWORD_REGEX_US;
        }

        public final Regex getPASSWORD_REGEX_EU$login_otherRelease() {
            return RegisterViewModel.PASSWORD_REGEX_EU;
        }

        public final Regex getPASSWORD_REGEX_CN$login_otherRelease() {
            return RegisterViewModel.PASSWORD_REGEX_CN;
        }
    }

    static {
        Regex regex = new Regex("(?!.*\\s).{8,}");
        PASSWORD_REGEX_EU = regex;
        PASSWORD_REGEX_CN = regex;
    }
}
