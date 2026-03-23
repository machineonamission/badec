package com.blueair.android.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.ActionBar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelLazy;
import com.blueair.android.R;
import com.blueair.android.databinding.ActivityDevSettingsBinding;
import com.blueair.android.dialog.EditGigyaTokenDialogFragment;
import com.blueair.android.viewmodel.DevSettingsViewModel;
import com.blueair.auth.AuthService;
import com.blueair.auth.BlueCloudDomain;
import com.blueair.core.AblEnvironment;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.util.SkuConfigurationManager;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.blueair.sdk.FirebaseSdk;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.viewmodel.BaseViewModelAction;
import com.blueair.viewcore.viewmodel.BaseViewModelEvent;
import com.blueair.viewcore.viewmodel.SnackbarMessage;
import com.google.android.material.snackbar.Snackbar;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import com.jakewharton.rxbinding2.view.RxView;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0014J\b\u0010\u001e\u001a\u00020\u0011H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001f²\u0006\n\u0010 \u001a\u00020!X\u0002"}, d2 = {"Lcom/blueair/android/activity/DevSettingsActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "dataBinding", "Lcom/blueair/android/databinding/ActivityDevSettingsBinding;", "viewModel", "Lcom/blueair/android/viewmodel/DevSettingsViewModel;", "getViewModel", "()Lcom/blueair/android/viewmodel/DevSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "changeForceRegionAction", "region", "isChecked", "", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "bindViewModel", "updateUrls", "onResume", "showRestartHint", "app_otherRelease", "authService", "Lcom/blueair/auth/AuthService;"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DevSettingsActivity.kt */
public final class DevSettingsActivity extends BaseActivity {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(DevSettingsActivity.class, "authService", "<v#0>", 0))};
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public ActivityDevSettingsBinding dataBinding;
    private final String screenName = AnalyticEvent.ScreenViewEvent.SIDE_MENU_DEV_SETTINGS;
    private final Lazy viewModel$delegate;

    public DevSettingsActivity() {
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DevSettingsViewModel.class), new DevSettingsActivity$special$$inlined$viewModels$default$2(componentActivity), new DevSettingsActivity$special$$inlined$viewModels$default$1(componentActivity), new DevSettingsActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    /* access modifiers changed from: private */
    public final DevSettingsViewModel getViewModel() {
        return (DevSettingsViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bindViewModel();
        ActivityDevSettingsBinding activityDevSettingsBinding = this.dataBinding;
        ActivityDevSettingsBinding activityDevSettingsBinding2 = null;
        if (activityDevSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding = null;
        }
        setSupportActionBar(activityDevSettingsBinding.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        updateUrls();
        ActivityDevSettingsBinding activityDevSettingsBinding3 = this.dataBinding;
        if (activityDevSettingsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding3 = null;
        }
        activityDevSettingsBinding3.buttonSaveUrl.postDelayed(new DevSettingsActivity$$ExternalSyntheticLambda40(this), 1000);
        ActivityDevSettingsBinding activityDevSettingsBinding4 = this.dataBinding;
        if (activityDevSettingsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding4 = null;
        }
        activityDevSettingsBinding4.showNotification.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda6(this));
        ActivityDevSettingsBinding activityDevSettingsBinding5 = this.dataBinding;
        if (activityDevSettingsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding5 = null;
        }
        activityDevSettingsBinding5.resetUserInfoSyncTime.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda18(this));
        ActivityDevSettingsBinding activityDevSettingsBinding6 = this.dataBinding;
        if (activityDevSettingsBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding6 = null;
        }
        activityDevSettingsBinding6.forceCrash.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda30());
        ActivityDevSettingsBinding activityDevSettingsBinding7 = this.dataBinding;
        if (activityDevSettingsBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding7 = null;
        }
        activityDevSettingsBinding7.forceUpdate.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda34(this));
        ActivityDevSettingsBinding activityDevSettingsBinding8 = this.dataBinding;
        if (activityDevSettingsBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding8 = null;
        }
        TextView textView = activityDevSettingsBinding8.appBuildInfo;
        StringBuilder sb = new StringBuilder();
        sb.append(BuildEnvironment.INSTANCE.getDisplayVersion());
        sb.append(" | release | other | ce39166 | ");
        SkuConfigurationManager skuConfigurationManager = SkuConfigurationManager.INSTANCE;
        sb.append("(" + skuConfigurationManager.getSeries() + ", " + skuConfigurationManager.getVersion() + ')');
        sb.append(" | ");
        UserInfoCollectionsManager userInfoCollectionsManager = UserInfoCollectionsManager.INSTANCE;
        sb.append("(" + userInfoCollectionsManager.getSeries() + ", " + userInfoCollectionsManager.getVersion() + ')');
        textView.setText(sb.toString());
        ActivityDevSettingsBinding activityDevSettingsBinding9 = this.dataBinding;
        if (activityDevSettingsBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding9 = null;
        }
        activityDevSettingsBinding9.gigyaUserRegion.setText("Gigya dataCenter: " + getViewModel().getGigyaDataCenter() + " | Gigya appRegion: " + getViewModel().getGigyaCloudDomainRegion() + " | Device region: " + getViewModel().getDeviceRegion() + " | IP region: " + getViewModel().getIpRegion());
        ActivityDevSettingsBinding activityDevSettingsBinding10 = this.dataBinding;
        if (activityDevSettingsBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding10 = null;
        }
        activityDevSettingsBinding10.legacyHomehost.setText(getViewModel().getHomehost());
        ActivityDevSettingsBinding activityDevSettingsBinding11 = this.dataBinding;
        if (activityDevSettingsBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding11 = null;
        }
        activityDevSettingsBinding11.resetHomehost.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda35(this));
        ActivityDevSettingsBinding activityDevSettingsBinding12 = this.dataBinding;
        if (activityDevSettingsBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding12 = null;
        }
        activityDevSettingsBinding12.setUrlUs.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda36(this));
        ActivityDevSettingsBinding activityDevSettingsBinding13 = this.dataBinding;
        if (activityDevSettingsBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding13 = null;
        }
        activityDevSettingsBinding13.setUrlEu.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda37(this));
        ActivityDevSettingsBinding activityDevSettingsBinding14 = this.dataBinding;
        if (activityDevSettingsBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding14 = null;
        }
        activityDevSettingsBinding14.setUrlCn.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda38(this));
        ActivityDevSettingsBinding activityDevSettingsBinding15 = this.dataBinding;
        if (activityDevSettingsBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding15 = null;
        }
        activityDevSettingsBinding15.forceRelease.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda39(this));
        ActivityDevSettingsBinding activityDevSettingsBinding16 = this.dataBinding;
        if (activityDevSettingsBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding16 = null;
        }
        activityDevSettingsBinding16.forceQa.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda41(this));
        ActivityDevSettingsBinding activityDevSettingsBinding17 = this.dataBinding;
        if (activityDevSettingsBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding17 = null;
        }
        activityDevSettingsBinding17.forceReset.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda42(this));
        ActivityDevSettingsBinding activityDevSettingsBinding18 = this.dataBinding;
        if (activityDevSettingsBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding18 = null;
        }
        activityDevSettingsBinding18.checkChina.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda43(this));
        ActivityDevSettingsBinding activityDevSettingsBinding19 = this.dataBinding;
        if (activityDevSettingsBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding19 = null;
        }
        activityDevSettingsBinding19.checkUSA.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda44(this));
        ActivityDevSettingsBinding activityDevSettingsBinding20 = this.dataBinding;
        if (activityDevSettingsBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding20 = null;
        }
        activityDevSettingsBinding20.checkKorea.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda45(this));
        ActivityDevSettingsBinding activityDevSettingsBinding21 = this.dataBinding;
        if (activityDevSettingsBinding21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding21 = null;
        }
        activityDevSettingsBinding21.checkForceAware.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda1(this));
        ActivityDevSettingsBinding activityDevSettingsBinding22 = this.dataBinding;
        if (activityDevSettingsBinding22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding22 = null;
        }
        activityDevSettingsBinding22.checkForceIcp.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda2(this));
        ActivityDevSettingsBinding activityDevSettingsBinding23 = this.dataBinding;
        if (activityDevSettingsBinding23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding23 = null;
        }
        activityDevSettingsBinding23.checkForceG4.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda3(this));
        ActivityDevSettingsBinding activityDevSettingsBinding24 = this.dataBinding;
        if (activityDevSettingsBinding24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding24 = null;
        }
        activityDevSettingsBinding24.checkForceB4.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda4(this));
        ActivityDevSettingsBinding activityDevSettingsBinding25 = this.dataBinding;
        if (activityDevSettingsBinding25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding25 = null;
        }
        activityDevSettingsBinding25.checkForceAlexa.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda5(this));
        ActivityDevSettingsBinding activityDevSettingsBinding26 = this.dataBinding;
        if (activityDevSettingsBinding26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding26 = null;
        }
        activityDevSettingsBinding26.checkForceTmall.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda7(this));
        ActivityDevSettingsBinding activityDevSettingsBinding27 = this.dataBinding;
        if (activityDevSettingsBinding27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding27 = null;
        }
        activityDevSettingsBinding27.checkForceGAssistant.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda8(this));
        ActivityDevSettingsBinding activityDevSettingsBinding28 = this.dataBinding;
        if (activityDevSettingsBinding28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding28 = null;
        }
        activityDevSettingsBinding28.sendLogs.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda9(this));
        ActivityDevSettingsBinding activityDevSettingsBinding29 = this.dataBinding;
        if (activityDevSettingsBinding29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding29 = null;
        }
        activityDevSettingsBinding29.setGigyaToken.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda10(this));
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new DevSettingsActivity$onCreate$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DevSettingsActivity$onCreate$27(DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, AuthService.class), (Object) null).provideDelegate((Object) null, $$delegatedProperties[0]), this, (Continuation<? super DevSettingsActivity$onCreate$27>) null), 2, (Object) null);
        FirebaseSdk.INSTANCE.getMessagingToken(new DevSettingsActivity$$ExternalSyntheticLambda12(this));
        FirebaseSdk.INSTANCE.getInstallationsId(new DevSettingsActivity$$ExternalSyntheticLambda13(this));
        ActivityDevSettingsBinding activityDevSettingsBinding30 = this.dataBinding;
        if (activityDevSettingsBinding30 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding30 = null;
        }
        activityDevSettingsBinding30.checkAmplitudeDebug.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda14(this));
        ActivityDevSettingsBinding activityDevSettingsBinding31 = this.dataBinding;
        if (activityDevSettingsBinding31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding31 = null;
        }
        activityDevSettingsBinding31.checkFacebookLogin.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda15(this));
        ActivityDevSettingsBinding activityDevSettingsBinding32 = this.dataBinding;
        if (activityDevSettingsBinding32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding32 = null;
        }
        activityDevSettingsBinding32.checkGoogleLogin.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda16(this));
        ActivityDevSettingsBinding activityDevSettingsBinding33 = this.dataBinding;
        if (activityDevSettingsBinding33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding33 = null;
        }
        activityDevSettingsBinding33.checkWeChatQQApple.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda17(this));
        ActivityDevSettingsBinding activityDevSettingsBinding34 = this.dataBinding;
        if (activityDevSettingsBinding34 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding34 = null;
        }
        activityDevSettingsBinding34.checkForceWelcomeHome.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda19(this));
        ActivityDevSettingsBinding activityDevSettingsBinding35 = this.dataBinding;
        if (activityDevSettingsBinding35 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding35 = null;
        }
        activityDevSettingsBinding35.forceRateUs.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda20(this));
        ActivityDevSettingsBinding activityDevSettingsBinding36 = this.dataBinding;
        if (activityDevSettingsBinding36 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding36 = null;
        }
        activityDevSettingsBinding36.forceWelcomeHomeIntro.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda21(this));
        ActivityDevSettingsBinding activityDevSettingsBinding37 = this.dataBinding;
        if (activityDevSettingsBinding37 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding37 = null;
        }
        activityDevSettingsBinding37.checkLokalisePreRelease.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda23(this));
        ActivityDevSettingsBinding activityDevSettingsBinding38 = this.dataBinding;
        if (activityDevSettingsBinding38 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding38 = null;
        }
        activityDevSettingsBinding38.checkGoogleDev.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda24(this));
        ActivityDevSettingsBinding activityDevSettingsBinding39 = this.dataBinding;
        if (activityDevSettingsBinding39 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding39 = null;
        }
        activityDevSettingsBinding39.checkAlexaDev.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda25(this));
        ActivityDevSettingsBinding activityDevSettingsBinding40 = this.dataBinding;
        if (activityDevSettingsBinding40 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding40 = null;
        }
        activityDevSettingsBinding40.checkUAT.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda26(this));
        ActivityDevSettingsBinding activityDevSettingsBinding41 = this.dataBinding;
        if (activityDevSettingsBinding41 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding41 = null;
        }
        activityDevSettingsBinding41.checkKlaviyoDev.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda27(this));
        ActivityDevSettingsBinding activityDevSettingsBinding42 = this.dataBinding;
        if (activityDevSettingsBinding42 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding42 = null;
        }
        activityDevSettingsBinding42.checkShowDetectCat.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda28(this));
        ActivityDevSettingsBinding activityDevSettingsBinding43 = this.dataBinding;
        if (activityDevSettingsBinding43 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding43 = null;
        }
        activityDevSettingsBinding43.welcomeHomeTestBtn.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda29(this));
        ActivityDevSettingsBinding activityDevSettingsBinding44 = this.dataBinding;
        if (activityDevSettingsBinding44 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding44 = null;
        }
        activityDevSettingsBinding44.etIntermittent.setText(String.valueOf(getViewModel().getAqiNotificationIntermittentInSecond()));
        ActivityDevSettingsBinding activityDevSettingsBinding45 = this.dataBinding;
        if (activityDevSettingsBinding45 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding45 = null;
        }
        activityDevSettingsBinding45.etContinuous.setText(String.valueOf(getViewModel().getAqiNotificationContinuousInSecond()));
        ActivityDevSettingsBinding activityDevSettingsBinding46 = this.dataBinding;
        if (activityDevSettingsBinding46 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding46 = null;
        }
        activityDevSettingsBinding46.revokeDismission.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda31(this));
        ActivityDevSettingsBinding activityDevSettingsBinding47 = this.dataBinding;
        if (activityDevSettingsBinding47 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            activityDevSettingsBinding2 = activityDevSettingsBinding47;
        }
        activityDevSettingsBinding2.btnSaveAqiThresold.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda32(this));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(DevSettingsActivity devSettingsActivity) {
        ActivityDevSettingsBinding activityDevSettingsBinding = devSettingsActivity.dataBinding;
        if (activityDevSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding = null;
        }
        activityDevSettingsBinding.buttonSaveUrl.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(DevSettingsActivity devSettingsActivity, View view) {
        devSettingsActivity.getViewModel().showNotification();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2(DevSettingsActivity devSettingsActivity, View view) {
        devSettingsActivity.getViewModel().resetUserInfoSyncTime();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$3(View view) {
        throw new RuntimeException("Force Crash on " + new Date());
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$4(DevSettingsActivity devSettingsActivity, View view) {
        devSettingsActivity.getViewModel().forceUpdateRemoteConfig();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$7(DevSettingsActivity devSettingsActivity, View view) {
        devSettingsActivity.getViewModel().setHomehost(AblEnvironment.INSTANCE.getBaseUrl());
        devSettingsActivity.showRestartHint();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$8(DevSettingsActivity devSettingsActivity, View view) {
        DevSettingsViewModel.forceBackend$default(devSettingsActivity.getViewModel(), BlueCloudDomain.PROVISION_USA, false, 2, (Object) null);
        devSettingsActivity.updateUrls();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$9(DevSettingsActivity devSettingsActivity, View view) {
        DevSettingsViewModel.forceBackend$default(devSettingsActivity.getViewModel(), BlueCloudDomain.PROVISION_EUROPE, false, 2, (Object) null);
        devSettingsActivity.updateUrls();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$10(DevSettingsActivity devSettingsActivity, View view) {
        DevSettingsViewModel.forceBackend$default(devSettingsActivity.getViewModel(), "cn-north-1", false, 2, (Object) null);
        devSettingsActivity.updateUrls();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$11(DevSettingsActivity devSettingsActivity, View view) {
        DevSettingsViewModel.forceBackend$default(devSettingsActivity.getViewModel(), (String) null, true, 1, (Object) null);
        devSettingsActivity.updateUrls();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$12(DevSettingsActivity devSettingsActivity, View view) {
        DevSettingsViewModel.forceBackend$default(devSettingsActivity.getViewModel(), (String) null, false, 1, (Object) null);
        devSettingsActivity.updateUrls();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$13(DevSettingsActivity devSettingsActivity, View view) {
        devSettingsActivity.getViewModel().setBackend(BlueCloudDomain.Companion.getINVALID());
        devSettingsActivity.updateUrls();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$14(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.changeForceRegionAction("cn", z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$15(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.changeForceRegionAction("us", z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$16(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.changeForceRegionAction("kr", z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$17(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.getViewModel().setForceAwareAvailable(z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$18(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.getViewModel().setForceIcpAvailable(z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$19(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.getViewModel().setForceG4available(z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$20(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.getViewModel().setForceB4available(z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$21(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.getViewModel().setForceAlexaAvailable(z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$22(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.getViewModel().setForceTmallAvailable(z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$23(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.getViewModel().setForceGAssistantAvailable(z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$24(DevSettingsActivity devSettingsActivity, View view) {
        UploadLogActivity.Companion.launch(devSettingsActivity);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$26(DevSettingsActivity devSettingsActivity, View view) {
        FragmentManager supportFragmentManager = devSettingsActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<EditGigyaTokenDialogFragment> cls = EditGigyaTokenDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("EditGigyaTokenDialogFragment", "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag("EditGigyaTokenDialogFragment") instanceof EditGigyaTokenDialogFragment) && !supportFragmentManager.isStateSaved()) {
            EditGigyaTokenDialogFragment.Companion.newInstance(devSettingsActivity.getViewModel().getGigyaToken()).show(supportFragmentManager, "EditGigyaTokenDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final AuthService onCreate$lambda$27(Lazy<AuthService> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$28(DevSettingsActivity devSettingsActivity, Result result) {
        CharSequence charSequence;
        ActivityDevSettingsBinding activityDevSettingsBinding = devSettingsActivity.dataBinding;
        Object obj = null;
        if (activityDevSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding = null;
        }
        TextView textView = activityDevSettingsBinding.textViewFCM;
        if (Result.m9373isSuccessimpl(result.m9375unboximpl())) {
            Object r3 = result.m9375unboximpl();
            if (!Result.m9372isFailureimpl(r3)) {
                obj = r3;
            }
            charSequence = (CharSequence) obj;
        } else {
            charSequence = AnalyticEvent.OnboardingLogEvent.RESULT_FAILED;
        }
        textView.setText(charSequence);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$29(DevSettingsActivity devSettingsActivity, Result result) {
        CharSequence charSequence;
        ActivityDevSettingsBinding activityDevSettingsBinding = devSettingsActivity.dataBinding;
        Object obj = null;
        if (activityDevSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding = null;
        }
        TextView textView = activityDevSettingsBinding.textViewIAM;
        if (Result.m9373isSuccessimpl(result.m9375unboximpl())) {
            Object r3 = result.m9375unboximpl();
            if (!Result.m9372isFailureimpl(r3)) {
                obj = r3;
            }
            charSequence = (CharSequence) obj;
        } else {
            charSequence = AnalyticEvent.OnboardingLogEvent.RESULT_FAILED;
        }
        textView.setText(charSequence);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$30(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.getViewModel().setAmplitudeDebug(z);
        devSettingsActivity.getViewModel().reInitAmplitude(z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$31(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.getViewModel().setFacebookLoginEnabled(z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$32(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.getViewModel().setGoogleLoginEnabled(z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$33(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.getViewModel().setWechatQQAppleLoginEnabled(z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$34(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.getViewModel().setForceWelcomeHome(z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$35(DevSettingsActivity devSettingsActivity, View view) {
        devSettingsActivity.getViewModel().toggleShouldShowRateUsDev();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$36(DevSettingsActivity devSettingsActivity, View view) {
        devSettingsActivity.getViewModel().toggleShouldShowWHExploreDev();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$37(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.getViewModel().setLokalisePreRelease(z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$38(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.getViewModel().setGoogleLive(!z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$39(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.getViewModel().setAlexaLive(!z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$40(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        if (devSettingsActivity.getViewModel().getInUatMode() != z) {
            devSettingsActivity.showRestartHint();
        }
        devSettingsActivity.getViewModel().setUatMode(z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$41(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        if (devSettingsActivity.getViewModel().getUseDevKlaviyo() != z) {
            devSettingsActivity.showRestartHint();
        }
        devSettingsActivity.getViewModel().setUseDevKlaviyo(z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$42(DevSettingsActivity devSettingsActivity, CompoundButton compoundButton, boolean z) {
        devSettingsActivity.getViewModel().setShowDetectCat(z);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$44(DevSettingsActivity devSettingsActivity, View view) {
        Device welcomeHomeTestDevice = devSettingsActivity.getViewModel().getWelcomeHomeTestDevice();
        if (welcomeHomeTestDevice != null) {
            DevSettingsViewModel viewModel = devSettingsActivity.getViewModel();
            ActivityDevSettingsBinding activityDevSettingsBinding = devSettingsActivity.dataBinding;
            ActivityDevSettingsBinding activityDevSettingsBinding2 = null;
            if (activityDevSettingsBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                activityDevSettingsBinding = null;
            }
            boolean isChecked = activityDevSettingsBinding.welcomeHomeIsMinRadius.isChecked();
            ActivityDevSettingsBinding activityDevSettingsBinding3 = devSettingsActivity.dataBinding;
            if (activityDevSettingsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            } else {
                activityDevSettingsBinding2 = activityDevSettingsBinding3;
            }
            viewModel.testWelcomeHome(welcomeHomeTestDevice, isChecked, activityDevSettingsBinding2.welcomeHomeIsEnter.isChecked());
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$45(DevSettingsActivity devSettingsActivity, View view) {
        devSettingsActivity.getViewModel().revokeAqiDismission();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$46(DevSettingsActivity devSettingsActivity, View view) {
        DevSettingsViewModel viewModel = devSettingsActivity.getViewModel();
        ActivityDevSettingsBinding activityDevSettingsBinding = devSettingsActivity.dataBinding;
        ActivityDevSettingsBinding activityDevSettingsBinding2 = null;
        if (activityDevSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding = null;
        }
        Editable text = activityDevSettingsBinding.etIntermittent.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        CharSequence charSequence = text;
        ActivityDevSettingsBinding activityDevSettingsBinding3 = devSettingsActivity.dataBinding;
        if (activityDevSettingsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            activityDevSettingsBinding2 = activityDevSettingsBinding3;
        }
        Editable text2 = activityDevSettingsBinding2.etContinuous.getText();
        Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
        viewModel.saveAqiThresold(charSequence, text2);
    }

    private final void changeForceRegionAction(String str, boolean z) {
        if (z) {
            getViewModel().setForceRegion(true, str);
            int hashCode = str.hashCode();
            ActivityDevSettingsBinding activityDevSettingsBinding = null;
            if (hashCode != 3179) {
                if (hashCode != 3431) {
                    if (hashCode == 3742 && str.equals("us")) {
                        ActivityDevSettingsBinding activityDevSettingsBinding2 = this.dataBinding;
                        if (activityDevSettingsBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                            activityDevSettingsBinding2 = null;
                        }
                        activityDevSettingsBinding2.checkChina.setChecked(false);
                        ActivityDevSettingsBinding activityDevSettingsBinding3 = this.dataBinding;
                        if (activityDevSettingsBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                        } else {
                            activityDevSettingsBinding = activityDevSettingsBinding3;
                        }
                        activityDevSettingsBinding.checkKorea.setChecked(false);
                    }
                } else if (str.equals("kr")) {
                    ActivityDevSettingsBinding activityDevSettingsBinding4 = this.dataBinding;
                    if (activityDevSettingsBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                        activityDevSettingsBinding4 = null;
                    }
                    activityDevSettingsBinding4.checkUSA.setChecked(false);
                    ActivityDevSettingsBinding activityDevSettingsBinding5 = this.dataBinding;
                    if (activityDevSettingsBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                    } else {
                        activityDevSettingsBinding = activityDevSettingsBinding5;
                    }
                    activityDevSettingsBinding.checkChina.setChecked(false);
                }
            } else if (str.equals("cn")) {
                ActivityDevSettingsBinding activityDevSettingsBinding6 = this.dataBinding;
                if (activityDevSettingsBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                    activityDevSettingsBinding6 = null;
                }
                activityDevSettingsBinding6.checkUSA.setChecked(false);
                ActivityDevSettingsBinding activityDevSettingsBinding7 = this.dataBinding;
                if (activityDevSettingsBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                } else {
                    activityDevSettingsBinding = activityDevSettingsBinding7;
                }
                activityDevSettingsBinding.checkKorea.setChecked(false);
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) getViewModel().getForceRegion())) {
            getViewModel().setForceRegion(false, str);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    private final void bindViewModel() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_dev_settings);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(...)");
        ActivityDevSettingsBinding activityDevSettingsBinding = (ActivityDevSettingsBinding) contentView;
        this.dataBinding = activityDevSettingsBinding;
        if (activityDevSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding = null;
        }
        LifecycleOwner lifecycleOwner = this;
        activityDevSettingsBinding.setLifecycleOwner(lifecycleOwner);
        LiveDataExtensionsKt.observeNonNull(getViewModel().getRemoteConfigUpdated(), lifecycleOwner, new DevSettingsActivity$$ExternalSyntheticLambda0(this));
        LiveData<List<Device>> liveDevices = getViewModel().getLiveDevices();
        liveDevices.observe(lifecycleOwner, new DevSettingsActivity$sam$androidx_lifecycle_Observer$0(new DevSettingsActivity$$ExternalSyntheticLambda11(liveDevices, this)));
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$48(DevSettingsActivity devSettingsActivity, Boolean bool) {
        String str;
        if (bool.booleanValue()) {
            str = "Remote config successfully updated";
        } else {
            str = "Failed to update remote config";
        }
        Toast.makeText(devSettingsActivity, str, 0).show();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$51$lambda$50(LiveData liveData, DevSettingsActivity devSettingsActivity, List list) {
        liveData.removeObservers(devSettingsActivity);
        ActivityDevSettingsBinding activityDevSettingsBinding = devSettingsActivity.dataBinding;
        if (activityDevSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding = null;
        }
        Spinner spinner = activityDevSettingsBinding.welcomeHomeDeviceSpinner;
        Intrinsics.checkNotNullExpressionValue(spinner, "welcomeHomeDeviceSpinner");
        Context context = devSettingsActivity;
        Intrinsics.checkNotNull(list);
        Iterable<Device> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Device name : iterable) {
            arrayList.add(name.getName());
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, (List) arrayList);
        arrayAdapter.setDropDownViewResource(17367049);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new DevSettingsActivity$bindViewModel$3$1$1(devSettingsActivity, list));
        return Unit.INSTANCE;
    }

    private final void updateUrls() {
        ActivityDevSettingsBinding activityDevSettingsBinding = this.dataBinding;
        ActivityDevSettingsBinding activityDevSettingsBinding2 = null;
        if (activityDevSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding = null;
        }
        activityDevSettingsBinding.labelTextBaseUrl.setText("Default API:\n" + getViewModel().getDefaultUrl());
        ActivityDevSettingsBinding activityDevSettingsBinding3 = this.dataBinding;
        if (activityDevSettingsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding3 = null;
        }
        activityDevSettingsBinding3.editTextBaseUrl.setText(getViewModel().getBaseUrl());
        ActivityDevSettingsBinding activityDevSettingsBinding4 = this.dataBinding;
        if (activityDevSettingsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding4 = null;
        }
        activityDevSettingsBinding4.labelBrokerBaseURL.setText("Default Broker:\n" + getViewModel().getDefaultBroker());
        ActivityDevSettingsBinding activityDevSettingsBinding5 = this.dataBinding;
        if (activityDevSettingsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            activityDevSettingsBinding2 = activityDevSettingsBinding5;
        }
        activityDevSettingsBinding2.editBrokerBaseURL.setText(getViewModel().getBrokerBaseURL());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ActivityDevSettingsBinding activityDevSettingsBinding = this.dataBinding;
        ActivityDevSettingsBinding activityDevSettingsBinding2 = null;
        if (activityDevSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding = null;
        }
        activityDevSettingsBinding.checkChina.setChecked(getViewModel().isForceChina());
        ActivityDevSettingsBinding activityDevSettingsBinding3 = this.dataBinding;
        if (activityDevSettingsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding3 = null;
        }
        activityDevSettingsBinding3.checkUSA.setChecked(getViewModel().isForceUSA());
        ActivityDevSettingsBinding activityDevSettingsBinding4 = this.dataBinding;
        if (activityDevSettingsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding4 = null;
        }
        activityDevSettingsBinding4.checkKorea.setChecked(getViewModel().isForceKorea());
        ActivityDevSettingsBinding activityDevSettingsBinding5 = this.dataBinding;
        if (activityDevSettingsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding5 = null;
        }
        activityDevSettingsBinding5.checkForceAware.setChecked(getViewModel().getForceAwareAvailable());
        ActivityDevSettingsBinding activityDevSettingsBinding6 = this.dataBinding;
        if (activityDevSettingsBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding6 = null;
        }
        activityDevSettingsBinding6.checkForceIcp.setChecked(getViewModel().getForceIcpAvailable());
        ActivityDevSettingsBinding activityDevSettingsBinding7 = this.dataBinding;
        if (activityDevSettingsBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding7 = null;
        }
        activityDevSettingsBinding7.checkForceG4.setChecked(getViewModel().getForceG4available());
        ActivityDevSettingsBinding activityDevSettingsBinding8 = this.dataBinding;
        if (activityDevSettingsBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding8 = null;
        }
        activityDevSettingsBinding8.checkForceB4.setChecked(getViewModel().getForceB4available());
        ActivityDevSettingsBinding activityDevSettingsBinding9 = this.dataBinding;
        if (activityDevSettingsBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding9 = null;
        }
        activityDevSettingsBinding9.checkForceAlexa.setChecked(getViewModel().getForceAlexaAvailable());
        ActivityDevSettingsBinding activityDevSettingsBinding10 = this.dataBinding;
        if (activityDevSettingsBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding10 = null;
        }
        activityDevSettingsBinding10.checkForceTmall.setChecked(getViewModel().getForceTmallAvailable());
        ActivityDevSettingsBinding activityDevSettingsBinding11 = this.dataBinding;
        if (activityDevSettingsBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding11 = null;
        }
        activityDevSettingsBinding11.checkForceGAssistant.setChecked(getViewModel().getForceGAssistantAvailable());
        ActivityDevSettingsBinding activityDevSettingsBinding12 = this.dataBinding;
        if (activityDevSettingsBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding12 = null;
        }
        activityDevSettingsBinding12.checkAmplitudeDebug.setChecked(getViewModel().getAmplitudeDebug());
        ActivityDevSettingsBinding activityDevSettingsBinding13 = this.dataBinding;
        if (activityDevSettingsBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding13 = null;
        }
        activityDevSettingsBinding13.checkFacebookLogin.setChecked(getViewModel().getFacebookLoginEnabled());
        ActivityDevSettingsBinding activityDevSettingsBinding14 = this.dataBinding;
        if (activityDevSettingsBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding14 = null;
        }
        activityDevSettingsBinding14.checkGoogleLogin.setChecked(getViewModel().getGoogleLoginEnabled());
        ActivityDevSettingsBinding activityDevSettingsBinding15 = this.dataBinding;
        if (activityDevSettingsBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding15 = null;
        }
        activityDevSettingsBinding15.checkWeChatQQApple.setChecked(getViewModel().getWechatQQAppleLoginEnabled());
        ActivityDevSettingsBinding activityDevSettingsBinding16 = this.dataBinding;
        if (activityDevSettingsBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding16 = null;
        }
        activityDevSettingsBinding16.checkForceWelcomeHome.setChecked(getViewModel().getForceWelcomeHome());
        ActivityDevSettingsBinding activityDevSettingsBinding17 = this.dataBinding;
        if (activityDevSettingsBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding17 = null;
        }
        activityDevSettingsBinding17.checkLokalisePreRelease.setChecked(getViewModel().getLokalisePreRelease());
        ActivityDevSettingsBinding activityDevSettingsBinding18 = this.dataBinding;
        if (activityDevSettingsBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding18 = null;
        }
        activityDevSettingsBinding18.checkGoogleDev.setChecked(!getViewModel().getGoogleLive());
        ActivityDevSettingsBinding activityDevSettingsBinding19 = this.dataBinding;
        if (activityDevSettingsBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding19 = null;
        }
        activityDevSettingsBinding19.checkAlexaDev.setChecked(!getViewModel().getAlexaLive());
        ActivityDevSettingsBinding activityDevSettingsBinding20 = this.dataBinding;
        if (activityDevSettingsBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding20 = null;
        }
        activityDevSettingsBinding20.checkUAT.setChecked(getViewModel().getInUatMode());
        ActivityDevSettingsBinding activityDevSettingsBinding21 = this.dataBinding;
        if (activityDevSettingsBinding21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding21 = null;
        }
        activityDevSettingsBinding21.checkKlaviyoDev.setChecked(getViewModel().getUseDevKlaviyo());
        ActivityDevSettingsBinding activityDevSettingsBinding22 = this.dataBinding;
        if (activityDevSettingsBinding22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding22 = null;
        }
        activityDevSettingsBinding22.checkShowDetectCat.setChecked(getViewModel().getShowDetectCat());
        CompositeDisposable rxSubs = getRxSubs();
        ActivityDevSettingsBinding activityDevSettingsBinding23 = this.dataBinding;
        if (activityDevSettingsBinding23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            activityDevSettingsBinding2 = activityDevSettingsBinding23;
        }
        Observable<Object> clicks = RxView.clicks(activityDevSettingsBinding2.buttonSaveUrl);
        Intrinsics.checkNotNullExpressionValue(clicks, "clicks(...)");
        rxSubs.add(RxExtensionsKt.subscribeAndLogE(clicks, new DevSettingsActivity$$ExternalSyntheticLambda22(this)));
        getRxSubs().add(RxExtensionsKt.subscribeAndLogE(getViewModel().getBaseActionPublisher(), new DevSettingsActivity$$ExternalSyntheticLambda33(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$52(DevSettingsActivity devSettingsActivity, Object obj) {
        DevSettingsViewModel viewModel = devSettingsActivity.getViewModel();
        ActivityDevSettingsBinding activityDevSettingsBinding = devSettingsActivity.dataBinding;
        ActivityDevSettingsBinding activityDevSettingsBinding2 = null;
        if (activityDevSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding = null;
        }
        String obj2 = StringsKt.trim((CharSequence) activityDevSettingsBinding.editTextBaseUrl.getText().toString()).toString();
        ActivityDevSettingsBinding activityDevSettingsBinding3 = devSettingsActivity.dataBinding;
        if (activityDevSettingsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            activityDevSettingsBinding2 = activityDevSettingsBinding3;
        }
        viewModel.changeBaseUrl(obj2, StringsKt.trim((CharSequence) activityDevSettingsBinding2.editBrokerBaseURL.getText().toString()).toString());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$53(DevSettingsActivity devSettingsActivity, BaseViewModelEvent baseViewModelEvent) {
        if (Intrinsics.areEqual((Object) baseViewModelEvent.getAction(), (Object) BaseViewModelAction.ShowSnackbar.INSTANCE)) {
            Object variable = baseViewModelEvent.getVariable();
            Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.blueair.viewcore.viewmodel.SnackbarMessage");
            SnackbarMessage snackbarMessage = (SnackbarMessage) variable;
            ViewUtils.INSTANCE.showSnackbar((Activity) devSettingsActivity, snackbarMessage.getMessageResId(), snackbarMessage.getType());
        }
        return Unit.INSTANCE;
    }

    private final void showRestartHint() {
        ActivityDevSettingsBinding activityDevSettingsBinding = this.dataBinding;
        if (activityDevSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            activityDevSettingsBinding = null;
        }
        Snackbar.make(activityDevSettingsBinding.getRoot(), (CharSequence) "Please restart the app to apply changes!", 0).show();
    }
}
