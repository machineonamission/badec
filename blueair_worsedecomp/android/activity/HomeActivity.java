package com.blueair.android.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.util.TypedValueCompat;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.activity.InfoListActivity;
import com.blueair.android.adapter.DrawerListAdapter;
import com.blueair.android.adapter.NotificationItem;
import com.blueair.android.adapter.NotificationMsgAdapter;
import com.blueair.android.databinding.ActivityHomeBinding;
import com.blueair.android.dialog.SettingsDialogFragment;
import com.blueair.android.fragment.IndoorFragment;
import com.blueair.android.util.AqiAnimationBackgroundKt;
import com.blueair.android.viewholder.NotificationMsgHolder;
import com.blueair.android.viewmodel.HomeViewModel;
import com.blueair.android.viewmodel.NotificationsViewModel;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.BuildVariant;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceMiniRestful;
import com.blueair.core.model.SimpleEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.util.SkuConfigurationManager;
import com.blueair.login.ProfileActivity;
import com.blueair.push.NotificationPermissionManager;
import com.blueair.push.NotificationService;
import com.blueair.sdk.GooglePlayAppUpdateSdk;
import com.blueair.sdk.KlaviyoSdk;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.dialog.ConfirmationDialogCenteredKt;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.utils.CustomStackLayoutManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.material.R;
import com.google.android.material.divider.MaterialDividerItemDecoration;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import com.kongzue.dialogx.dialogs.CustomDialog;
import com.kongzue.dialogx.interfaces.DialogXRunnable;
import com.kongzue.dialogx.interfaces.OnBindView;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.internal.CardStackSetting;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.subjects.PublishSubject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0014J\b\u00104\u001a\u000201H\u0002J\b\u00105\u001a\u000201H\u0002J\u0010\u00106\u001a\u0002012\u0006\u00107\u001a\u00020\u001cH\u0002J\b\u00108\u001a\u000201H\u0002J\b\u00109\u001a\u000201H\u0002J\b\u0010:\u001a\u000201H\u0014J\b\u0010;\u001a\u000201H\u0014J\b\u0010<\u001a\u000201H\u0003J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0016J\"\u0010A\u001a\u0002012\u0006\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u001c2\b\u0010D\u001a\u0004\u0018\u00010EH\u0015J\u0010\u0010F\u001a\u0002012\u0006\u0010G\u001a\u00020EH\u0014R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R-\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020&0%0$8BX\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u001b\u0010+\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b/\u0010\u000e\u001a\u0004\b-\u0010.¨\u0006I"}, d2 = {"Lcom/blueair/android/activity/HomeActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "notificationService", "Lcom/blueair/push/NotificationService;", "getNotificationService", "()Lcom/blueair/push/NotificationService;", "notificationService$delegate", "Lkotlin/Lazy;", "homeDataBinding", "Lcom/blueair/android/databinding/ActivityHomeBinding;", "viewModel", "Lcom/blueair/android/viewmodel/HomeViewModel;", "getViewModel", "()Lcom/blueair/android/viewmodel/HomeViewModel;", "viewModel$delegate", "notificationsViewModel", "Lcom/blueair/android/viewmodel/NotificationsViewModel;", "getNotificationsViewModel", "()Lcom/blueair/android/viewmodel/NotificationsViewModel;", "notificationsViewModel$delegate", "versionClickCount", "", "cardAdapter", "Lcom/blueair/android/adapter/NotificationMsgAdapter;", "drawerListAdapter", "Lcom/blueair/android/adapter/DrawerListAdapter;", "appUpdateManager", "Lcom/blueair/sdk/GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager;", "clickNotificationPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/core/model/SimpleEvent;", "Lcom/blueair/android/adapter/NotificationItem;", "getClickNotificationPublisher", "()Lio/reactivex/subjects/PublishSubject;", "clickNotificationPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "notificationPermissionManager", "Lcom/blueair/push/NotificationPermissionManager;", "getNotificationPermissionManager", "()Lcom/blueair/push/NotificationPermissionManager;", "notificationPermissionManager$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "prepareCardStack", "observeViewModel", "computeAndUpdateCardPadding", "listSize", "showAddMenuDialog", "bindViewModel", "onStart", "onResume", "updateNavigationView", "onNavigationItemSelected", "", "item", "Landroid/view/MenuItem;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onNewIntent", "intent", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: HomeActivity.kt */
public final class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NAV_VIEW_HEADER_INDEX = 0;
    private static final int REQUEST_CODE_UPDATE = 4095;
    private GooglePlayAppUpdateSdk.GooglePlayAppUpdateManager appUpdateManager;
    /* access modifiers changed from: private */
    public NotificationMsgAdapter cardAdapter;
    private final LazyPublishSubject clickNotificationPublisher$delegate;
    /* access modifiers changed from: private */
    public DrawerListAdapter drawerListAdapter;
    /* access modifiers changed from: private */
    public ActivityHomeBinding homeDataBinding;
    private final Lazy notificationPermissionManager$delegate;
    private final Lazy notificationService$delegate;
    private final Lazy notificationsViewModel$delegate;
    private final String screenName = "home";
    private int versionClickCount;
    private final Lazy viewModel$delegate;

    static {
        Class<HomeActivity> cls = HomeActivity.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "notificationService", "getNotificationService()Lcom/blueair/push/NotificationService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "clickNotificationPublisher", "getClickNotificationPublisher()Lio/reactivex/subjects/PublishSubject;", 0))};
    }

    public HomeActivity() {
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new HomeActivity$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.notificationService$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, NotificationService.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(HomeViewModel.class), new HomeActivity$special$$inlined$viewModels$default$2(componentActivity), new HomeActivity$special$$inlined$viewModels$default$1(componentActivity), new HomeActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
        this.notificationsViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(NotificationsViewModel.class), new HomeActivity$special$$inlined$viewModels$default$5(componentActivity), new HomeActivity$special$$inlined$viewModels$default$4(componentActivity), new HomeActivity$special$$inlined$viewModels$default$6((Function0) null, componentActivity));
        this.clickNotificationPublisher$delegate = new LazyPublishSubject();
        this.notificationPermissionManager$delegate = LazyKt.lazy(new HomeActivity$$ExternalSyntheticLambda10(this));
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    private final NotificationService getNotificationService() {
        return (NotificationService) this.notificationService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final HomeViewModel getViewModel() {
        return (HomeViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final NotificationsViewModel getNotificationsViewModel() {
        return (NotificationsViewModel) this.notificationsViewModel$delegate.getValue();
    }

    private final PublishSubject<SimpleEvent<String, NotificationItem>> getClickNotificationPublisher() {
        return this.clickNotificationPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[1]);
    }

    private final NotificationPermissionManager getNotificationPermissionManager() {
        return (NotificationPermissionManager) this.notificationPermissionManager$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final NotificationPermissionManager notificationPermissionManager_delegate$lambda$0(HomeActivity homeActivity) {
        return new NotificationPermissionManager(homeActivity, homeActivity, false, (Function0) null, 12, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Activity activity = this;
        SplashScreen.Companion.installSplashScreen(activity);
        super.onCreate(bundle);
        ActivityHomeBinding activityHomeBinding = null;
        BaseLokaliseActivity.immersiveStatusBar$default(this, false, 1, (Object) null);
        setStatusMode(true);
        bindViewModel();
        View findViewById = findViewById(R.id.design_navigation_view);
        if (findViewById != null) {
            findViewById.setFocusable(false);
        }
        View findViewById2 = findViewById(com.blueair.android.R.id.rv_drawer);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        LifecycleOwner lifecycleOwner = this;
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new HomeActivity$onCreate$1(this, (Continuation<? super HomeActivity$onCreate$1>) null), 3, (Object) null);
        FlowKt.launchIn(FlowKt.onEach(getViewModel().isUserSignedIn(), new HomeActivity$onCreate$2(this, (Continuation<? super HomeActivity$onCreate$2>) null)), LifecycleOwnerKt.getLifecycleScope(lifecycleOwner));
        ActivityHomeBinding activityHomeBinding2 = this.homeDataBinding;
        if (activityHomeBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding2 = null;
        }
        activityHomeBinding2.btnMenu.setOnClickListener(new HomeActivity$$ExternalSyntheticLambda0(this));
        ActivityHomeBinding activityHomeBinding3 = this.homeDataBinding;
        if (activityHomeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding3 = null;
        }
        activityHomeBinding3.build.setText(getString(com.blueair.viewcore.R.string.menu_app_version) + " 4.4.0 (2272)");
        ActivityHomeBinding activityHomeBinding4 = this.homeDataBinding;
        if (activityHomeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding4 = null;
        }
        activityHomeBinding4.build.setOnClickListener(new HomeActivity$$ExternalSyntheticLambda11(this));
        ActivityHomeBinding activityHomeBinding5 = this.homeDataBinding;
        if (activityHomeBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding5 = null;
        }
        activityHomeBinding5.btnAdd.setOnClickListener(new HomeActivity$$ExternalSyntheticLambda15(this));
        GooglePlayAppUpdateSdk.GooglePlayAppUpdateManager createAppUpdateManager = GooglePlayAppUpdateSdk.INSTANCE.createAppUpdateManager(activity);
        this.appUpdateManager = createAppUpdateManager;
        if (createAppUpdateManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appUpdateManager");
            createAppUpdateManager = null;
        }
        createAppUpdateManager.checkInAppUpdate(REQUEST_CODE_UPDATE);
        getViewModel().updateTimezoneList();
        getViewModel().updateSkuConfiguration(new HomeActivity$$ExternalSyntheticLambda16(this));
        getViewModel().checkUserInfoCollections();
        this.cardAdapter = new NotificationMsgAdapter(getNotificationsViewModel().getLocationService(), getClickNotificationPublisher());
        prepareCardStack();
        observeViewModel();
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        onNewIntent(intent);
        Context context = this;
        Menu menuBuilder = new MenuBuilder(context);
        getMenuInflater().inflate(com.blueair.android.R.menu.home_drawer, menuBuilder);
        DrawerListAdapter drawerListAdapter2 = new DrawerListAdapter(menuBuilder, this);
        this.drawerListAdapter = drawerListAdapter2;
        recyclerView.setAdapter(drawerListAdapter2);
        MaterialDividerItemDecoration materialDividerItemDecoration = new MaterialDividerItemDecoration(context, 1);
        materialDividerItemDecoration.setDividerColorResource(context, com.blueair.viewcore.R.color.white_10);
        materialDividerItemDecoration.setLastItemDecorated(false);
        recyclerView.addItemDecoration(materialDividerItemDecoration);
        ActivityHomeBinding activityHomeBinding6 = this.homeDataBinding;
        if (activityHomeBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
        } else {
            activityHomeBinding = activityHomeBinding6;
        }
        activityHomeBinding.drawerLayout.addDrawerListener(new HomeActivity$onCreate$8(this));
        if (getIntent().getBooleanExtra(Actions.ACTION_REGISTER, false)) {
            ConnectDeviceGuideActivity.Companion.launch(context);
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(HomeActivity homeActivity, View view) {
        ActivityHomeBinding activityHomeBinding = homeActivity.homeDataBinding;
        ActivityHomeBinding activityHomeBinding2 = null;
        if (activityHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding = null;
        }
        if (activityHomeBinding.drawerLayout.getDrawerLockMode((int) GravityCompat.START) != 1) {
            ActivityHomeBinding activityHomeBinding3 = homeActivity.homeDataBinding;
            if (activityHomeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            } else {
                activityHomeBinding2 = activityHomeBinding3;
            }
            activityHomeBinding2.drawerLayout.openDrawer((int) GravityCompat.START);
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2(HomeActivity homeActivity, View view) {
        int i = homeActivity.versionClickCount + 1;
        homeActivity.versionClickCount = i;
        if (i >= 7) {
            homeActivity.versionClickCount = 0;
            homeActivity.startActivity(new Intent(homeActivity, DevSettingsActivity.class));
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$3(HomeActivity homeActivity, View view) {
        if (homeActivity.getViewModel().isInAntiFakeRegion()) {
            homeActivity.showAddMenuDialog();
            return;
        }
        Fragment fragment = homeActivity.getSupportFragmentManager().getFragments().get(1);
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.blueair.android.fragment.IndoorFragment");
        ((IndoorFragment) fragment).connectDevice();
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$5(HomeActivity homeActivity, ApiResult apiResult) {
        Intrinsics.checkNotNullParameter(apiResult, "it");
        homeActivity.getViewModel().checkChinaPrivacyUpdate(new HomeActivity$$ExternalSyntheticLambda1(homeActivity));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$5$lambda$4(HomeActivity homeActivity, boolean z) {
        if (z) {
            homeActivity.startActivity(Actions.INSTANCE.openChinaPrivacyPolicyIntent(homeActivity, SkuConfigurationManager.INSTANCE.getChinaPrivacy()));
            homeActivity.finish();
        }
        return Unit.INSTANCE;
    }

    private final void prepareCardStack() {
        ActivityHomeBinding activityHomeBinding = this.homeDataBinding;
        NotificationMsgAdapter notificationMsgAdapter = null;
        if (activityHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding = null;
        }
        CardStackView cardStackView = activityHomeBinding.csNotification;
        Intrinsics.checkNotNullExpressionValue(cardStackView, "csNotification");
        CustomStackLayoutManager customStackLayoutManager = new CustomStackLayoutManager(cardStackView, new HomeActivity$prepareCardStack$layoutManager$1(this), false, 4, (DefaultConstructorMarker) null);
        CardStackSetting cardStackSetting = customStackLayoutManager.getCardStackSetting();
        cardStackSetting.canScrollVertical = false;
        cardStackSetting.stackFrom = StackFrom.Bottom;
        ActivityHomeBinding activityHomeBinding2 = this.homeDataBinding;
        if (activityHomeBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding2 = null;
        }
        activityHomeBinding2.csNotification.setLayoutManager(customStackLayoutManager);
        ActivityHomeBinding activityHomeBinding3 = this.homeDataBinding;
        if (activityHomeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding3 = null;
        }
        CardStackView cardStackView2 = activityHomeBinding3.csNotification;
        NotificationMsgAdapter notificationMsgAdapter2 = this.cardAdapter;
        if (notificationMsgAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
        } else {
            notificationMsgAdapter = notificationMsgAdapter2;
        }
        cardStackView2.setAdapter(notificationMsgAdapter);
    }

    private final void observeViewModel() {
        LifecycleOwner lifecycleOwner = this;
        getViewModel().getLiveDevices().observe(lifecycleOwner, new HomeActivity$sam$androidx_lifecycle_Observer$0(new HomeActivity$$ExternalSyntheticLambda12(this)));
        MutableFloatState mutableFloatStateOf = PrimitiveSnapshotStateKt.mutableFloatStateOf(50.0f);
        ActivityHomeBinding activityHomeBinding = this.homeDataBinding;
        if (activityHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding = null;
        }
        activityHomeBinding.aqiAnimationBackground.setContent(ComposableLambdaKt.composableLambdaInstance(-1996535943, true, new HomeActivity$$ExternalSyntheticLambda13(mutableFloatStateOf)));
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new HomeActivity$observeViewModel$3(this, mutableFloatStateOf, (Continuation<? super HomeActivity$observeViewModel$3>) null), 3, (Object) null);
        getNotificationsViewModel().getLvNotificationMsgs().observe(lifecycleOwner, new HomeActivity$sam$androidx_lifecycle_Observer$0(new HomeActivity$$ExternalSyntheticLambda14(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$9(HomeActivity homeActivity, List list) {
        boolean z;
        Intrinsics.checkNotNull(list);
        if (!list.isEmpty()) {
            Iterable iterable = list;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!(((Device) it.next()) instanceof DeviceMiniRestful)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                z = false;
            }
            z = true;
        } else {
            z = false;
        }
        ActivityHomeBinding activityHomeBinding = homeActivity.homeDataBinding;
        ActivityHomeBinding activityHomeBinding2 = null;
        if (activityHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding = null;
        }
        ConstraintLayout constraintLayout = activityHomeBinding.clHeader;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "clHeader");
        ViewExtensionsKt.show(constraintLayout, !z);
        float dpToPx = z ? TypedValueCompat.dpToPx(8.0f, homeActivity.getResources().getDisplayMetrics()) : 0.0f;
        ActivityHomeBinding activityHomeBinding3 = homeActivity.homeDataBinding;
        if (activityHomeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
        } else {
            activityHomeBinding2 = activityHomeBinding3;
        }
        CardStackView cardStackView = activityHomeBinding2.csNotification;
        Intrinsics.checkNotNullExpressionValue(cardStackView, "csNotification");
        View view = cardStackView;
        view.setPadding(view.getPaddingLeft(), MathKt.roundToInt(dpToPx), view.getPaddingRight(), view.getPaddingBottom());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$10(MutableFloatState mutableFloatState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C249@10877L47:HomeActivity.kt#zdeadj");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1996535943, i, -1, "com.blueair.android.activity.HomeActivity.observeViewModel.<anonymous> (HomeActivity.kt:249)");
            }
            AqiAnimationBackgroundKt.AqiAnimationBackground(mutableFloatState.getFloatValue(), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$11(HomeActivity homeActivity, List list) {
        NotificationMsgAdapter notificationMsgAdapter = homeActivity.cardAdapter;
        ActivityHomeBinding activityHomeBinding = null;
        if (notificationMsgAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
            notificationMsgAdapter = null;
        }
        Intrinsics.checkNotNull(list);
        notificationMsgAdapter.setNewList(list);
        int size = list.size();
        Integer value = homeActivity.getViewModel().getDeviceNum().getValue();
        if (value == null || size != value.intValue()) {
            homeActivity.getViewModel().getDeviceNum().setValue(Integer.valueOf(size));
        }
        ActivityHomeBinding activityHomeBinding2 = homeActivity.homeDataBinding;
        if (activityHomeBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
        } else {
            activityHomeBinding = activityHomeBinding2;
        }
        CardStackView cardStackView = activityHomeBinding.csNotification;
        Intrinsics.checkNotNullExpressionValue(cardStackView, "csNotification");
        cardStackView.setVisibility(!list.isEmpty() ? 0 : 8);
        homeActivity.computeAndUpdateCardPadding(size);
        return Unit.INSTANCE;
    }

    private final void computeAndUpdateCardPadding(int i) {
        CardStackSetting cardStackSetting;
        ActivityHomeBinding activityHomeBinding = this.homeDataBinding;
        ActivityHomeBinding activityHomeBinding2 = null;
        if (activityHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding = null;
        }
        RecyclerView.LayoutManager layoutManager = activityHomeBinding.csNotification.getLayoutManager();
        CardStackLayoutManager cardStackLayoutManager = layoutManager instanceof CardStackLayoutManager ? (CardStackLayoutManager) layoutManager : null;
        float f = (cardStackLayoutManager == null || (cardStackSetting = cardStackLayoutManager.getCardStackSetting()) == null) ? 0.0f : cardStackSetting.translationInterval;
        int i2 = 1;
        if (i == 1) {
            i2 = 0;
        } else if (i != 2) {
            i2 = 2;
        }
        float dpToPx = ((float) i2) * TypedValueCompat.dpToPx(f, getResources().getDisplayMetrics());
        ActivityHomeBinding activityHomeBinding3 = this.homeDataBinding;
        if (activityHomeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding3 = null;
        }
        float dpToPx2 = TypedValueCompat.dpToPx(32.0f, getResources().getDisplayMetrics()) - RangesKt.coerceAtLeast(((float) activityHomeBinding3.csNotification.getPaddingBottom()) - dpToPx, 0.0f);
        ActivityHomeBinding activityHomeBinding4 = this.homeDataBinding;
        if (activityHomeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
        } else {
            activityHomeBinding2 = activityHomeBinding4;
        }
        FrameLayout frameLayout = activityHomeBinding2.outdoorContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "outdoorContainer");
        View view = frameLayout;
        view.setPadding(view.getPaddingLeft(), (int) dpToPx2, view.getPaddingRight(), view.getPaddingBottom());
    }

    private final void showAddMenuDialog() {
        ActivityHomeBinding activityHomeBinding = this.homeDataBinding;
        ActivityHomeBinding activityHomeBinding2 = null;
        if (activityHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding = null;
        }
        activityHomeBinding.btnAdd.setSelected(true);
        CustomDialog onDismiss = CustomDialog.show((OnBindView<CustomDialog>) new HomeActivity$showAddMenuDialog$1(this, com.blueair.android.R.layout.dialog_layout_add_action)).onDismiss((DialogXRunnable<CustomDialog>) new HomeActivity$$ExternalSyntheticLambda2(this));
        ActivityHomeBinding activityHomeBinding3 = this.homeDataBinding;
        if (activityHomeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
        } else {
            activityHomeBinding2 = activityHomeBinding3;
        }
        onDismiss.setAlignBaseViewGravity(activityHomeBinding2.btnAdd, 81);
    }

    /* access modifiers changed from: private */
    public static final void showAddMenuDialog$lambda$12(HomeActivity homeActivity, CustomDialog customDialog) {
        ActivityHomeBinding activityHomeBinding = homeActivity.homeDataBinding;
        if (activityHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding = null;
        }
        activityHomeBinding.btnAdd.setSelected(false);
    }

    private final void bindViewModel() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, com.blueair.android.R.layout.activity_home);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(...)");
        ActivityHomeBinding activityHomeBinding = (ActivityHomeBinding) contentView;
        this.homeDataBinding = activityHomeBinding;
        if (activityHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding = null;
        }
        activityHomeBinding.setHomeViewModel(getViewModel());
        activityHomeBinding.setLifecycleOwner(this);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (getNotificationService().getEnabled()) {
            getNotificationPermissionManager();
            ActivityHomeBinding activityHomeBinding = this.homeDataBinding;
            if (activityHomeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
                activityHomeBinding = null;
            }
            activityHomeBinding.getRoot().postDelayed(new HomeActivity$$ExternalSyntheticLambda3(this), 1);
        }
    }

    /* access modifiers changed from: private */
    public static final void onStart$lambda$14(HomeActivity homeActivity) {
        homeActivity.getNotificationPermissionManager().checkAndRequest();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        updateNavigationView();
        GooglePlayAppUpdateSdk.GooglePlayAppUpdateManager googlePlayAppUpdateManager = this.appUpdateManager;
        if (googlePlayAppUpdateManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appUpdateManager");
            googlePlayAppUpdateManager = null;
        }
        googlePlayAppUpdateManager.resumeInAppUpdate(REQUEST_CODE_UPDATE);
        getRxSubs().add(RxExtensionsKt.subscribeAndLogE(getClickNotificationPublisher(), new HomeActivity$$ExternalSyntheticLambda6(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$15(HomeActivity homeActivity, SimpleEvent simpleEvent) {
        NotificationItem notificationItem = (NotificationItem) simpleEvent.getData();
        String str = (String) simpleEvent.getEventType();
        boolean z = false;
        NotificationMsgAdapter notificationMsgAdapter = null;
        switch (str.hashCode()) {
            case 146184104:
                if (str.equals(NotificationMsgHolder.EVENT_REPLACE_FILTER)) {
                    homeActivity.getNotificationsViewModel().executeReplaceFilterEvent(notificationItem, homeActivity);
                    break;
                }
                break;
            case 434821139:
                if (str.equals(NotificationMsgHolder.EVENT_CLOSE)) {
                    NotificationMsgAdapter notificationMsgAdapter2 = homeActivity.cardAdapter;
                    if (notificationMsgAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
                        notificationMsgAdapter2 = null;
                    }
                    notificationMsgAdapter2.remove(notificationItem);
                    NotificationsViewModel notificationsViewModel = homeActivity.getNotificationsViewModel();
                    NotificationMsgAdapter notificationMsgAdapter3 = homeActivity.cardAdapter;
                    if (notificationMsgAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
                    } else {
                        notificationMsgAdapter = notificationMsgAdapter3;
                    }
                    if (notificationMsgAdapter.getItemCount() > 0) {
                        z = true;
                    }
                    notificationsViewModel.dismissMsg(notificationItem, z);
                    break;
                }
                break;
            case 529760468:
                if (str.equals(NotificationMsgHolder.EVENT_ADJUST)) {
                    NotificationMsgAdapter notificationMsgAdapter4 = homeActivity.cardAdapter;
                    if (notificationMsgAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
                        notificationMsgAdapter4 = null;
                    }
                    notificationMsgAdapter4.remove(notificationItem);
                    NotificationsViewModel notificationsViewModel2 = homeActivity.getNotificationsViewModel();
                    NotificationMsgAdapter notificationMsgAdapter5 = homeActivity.cardAdapter;
                    if (notificationMsgAdapter5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
                    } else {
                        notificationMsgAdapter = notificationMsgAdapter5;
                    }
                    if (notificationMsgAdapter.getItemCount() > 0) {
                        z = true;
                    }
                    notificationsViewModel2.dismissMsg(notificationItem, z);
                    Fragment fragment = homeActivity.getSupportFragmentManager().getFragments().get(1);
                    Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.blueair.android.fragment.IndoorFragment");
                    ((IndoorFragment) fragment).openDeviceDetails(notificationItem.getMessage().getDevice(), "device_details");
                    break;
                }
                break;
            case 1336284116:
                if (str.equals(NotificationMsgHolder.EVENT_CONTENT)) {
                    homeActivity.startActivity(new Intent(homeActivity, NotificationsActivity.class));
                    break;
                }
                break;
            case 1982146070:
                if (str.equals(NotificationMsgHolder.EVENT_BUY_FILTER)) {
                    homeActivity.getNotificationsViewModel().executeBuyFilterEvent(notificationItem, homeActivity);
                    break;
                }
                break;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void updateNavigationView() {
        ActivityHomeBinding activityHomeBinding = null;
        FlowKt.launchIn(FlowKt.onEach(getViewModel().getSmartIntegrationsAvailable(), new HomeActivity$updateNavigationView$1(this, (Continuation<? super HomeActivity$updateNavigationView$1>) null)), LifecycleOwnerKt.getLifecycleScope(this));
        DrawerListAdapter drawerListAdapter2 = this.drawerListAdapter;
        if (drawerListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("drawerListAdapter");
            drawerListAdapter2 = null;
        }
        drawerListAdapter2.updateMenu(com.blueair.android.R.id.action_dev_settings, BuildEnvironment.INSTANCE.getVariant() == BuildVariant.DEBUG);
        ActivityHomeBinding activityHomeBinding2 = this.homeDataBinding;
        if (activityHomeBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding2 = null;
        }
        activityHomeBinding2.drawerCloseView.setOnClickListener(new HomeActivity$$ExternalSyntheticLambda7(this));
        ActivityHomeBinding activityHomeBinding3 = this.homeDataBinding;
        if (activityHomeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding3 = null;
        }
        activityHomeBinding3.llDrawerHeader.setOnClickListener(new HomeActivity$$ExternalSyntheticLambda8(this));
        ActivityHomeBinding activityHomeBinding4 = this.homeDataBinding;
        if (activityHomeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
        } else {
            activityHomeBinding = activityHomeBinding4;
        }
        activityHomeBinding.drawerSignin.setOnClickListener(new HomeActivity$$ExternalSyntheticLambda9(this));
    }

    /* access modifiers changed from: private */
    public static final void updateNavigationView$lambda$16(HomeActivity homeActivity, View view) {
        ActivityHomeBinding activityHomeBinding = homeActivity.homeDataBinding;
        if (activityHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding = null;
        }
        activityHomeBinding.drawerLayout.closeDrawer((int) GravityCompat.START);
    }

    /* access modifiers changed from: private */
    public static final void updateNavigationView$lambda$17(HomeActivity homeActivity, View view) {
        ActivityHomeBinding activityHomeBinding = homeActivity.homeDataBinding;
        if (activityHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding = null;
        }
        activityHomeBinding.drawerLayout.closeDrawer((int) GravityCompat.START);
        homeActivity.startActivity(InfoActivity.Companion.gotoBlueairStore(homeActivity));
    }

    /* access modifiers changed from: private */
    public static final void updateNavigationView$lambda$20(HomeActivity homeActivity, View view) {
        DialogFragment dialogFragment;
        FragmentManager supportFragmentManager = homeActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<ConfirmationDialogCentered> cls = ConfirmationDialogCentered.class;
        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogCentered", "getSimpleName(...)");
        if ((supportFragmentManager.findFragmentByTag("ConfirmationDialogCentered") instanceof ConfirmationDialogCentered) || supportFragmentManager.isStateSaved()) {
            dialogFragment = null;
        } else {
            dialogFragment = ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, Integer.valueOf(com.blueair.viewcore.R.string.action_log_out), Integer.valueOf(com.blueair.viewcore.R.string.logout_message), com.blueair.viewcore.R.string.yes, Integer.valueOf(com.blueair.viewcore.R.string.f85no), false, false, false, (String[]) null, 240, (Object) null);
            dialogFragment.show(supportFragmentManager, "ConfirmationDialogCentered");
        }
        ConfirmationDialogCentered confirmationDialogCentered = (ConfirmationDialogCentered) dialogFragment;
        if (confirmationDialogCentered != null) {
            FragmentExtensionsKt.setFragmentResultListenerWithClear(confirmationDialogCentered, ConfirmationDialogCenteredKt.CONFIRMATION_REQUEST_KEY, new HomeActivity$$ExternalSyntheticLambda17(homeActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit updateNavigationView$lambda$20$lambda$19(HomeActivity homeActivity, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.getBoolean(ConfirmationDialogCenteredKt.IS_CONFIRMED_KEY)) {
            homeActivity.getViewModel().logout();
            homeActivity.startActivity(Actions.openWelcomeIntent$default(Actions.INSTANCE, homeActivity, false, 2, (Object) null));
            homeActivity.finish();
        }
        return Unit.INSTANCE;
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == com.blueair.android.R.id.action_signin) {
            if (getViewModel().isUserSignedIn().getValue().booleanValue()) {
                getViewModel().logout();
            }
        } else if (itemId == com.blueair.android.R.id.action_profile) {
            startActivity(new Intent(this, ProfileActivity.class));
        } else if (itemId == com.blueair.android.R.id.action_policies) {
            InfoListActivity.Companion.launch(this, InfoListActivity.InfoType.POLICIES);
        } else if (itemId == com.blueair.android.R.id.action_integrations) {
            String string = getString(com.blueair.viewcore.R.string.voice_assistants);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            startActivity(InfoActivity.Companion.gotoIntegrations(this, string));
        } else if (itemId == com.blueair.android.R.id.action_support) {
            String string2 = getString(com.blueair.viewcore.R.string.action_support);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            startActivity(InfoActivity.Companion.gotoSupport(this, string2));
        } else if (itemId == com.blueair.android.R.id.action_dev_settings) {
            startActivity(new Intent(this, DevSettingsActivity.class));
        } else if (itemId == com.blueair.android.R.id.action_settings) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            Class<SettingsDialogFragment> cls = SettingsDialogFragment.class;
            Intrinsics.checkNotNullExpressionValue("SettingsDialogFragment", "getSimpleName(...)");
            if (!(supportFragmentManager.findFragmentByTag("SettingsDialogFragment") instanceof SettingsDialogFragment) && !supportFragmentManager.isStateSaved()) {
                SettingsDialogFragment.Companion.newInstance().show(supportFragmentManager, "SettingsDialogFragment");
            }
        }
        ActivityHomeBinding activityHomeBinding = this.homeDataBinding;
        if (activityHomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            activityHomeBinding = null;
        }
        activityHomeBinding.drawerLayout.closeDrawer((int) GravityCompat.START);
        return true;
    }

    /* access modifiers changed from: protected */
    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == REQUEST_CODE_UPDATE && i2 != -1 && !getViewModel().isAppVersionSupported()) {
            new AlertDialog.Builder(this).setTitle(com.blueair.viewcore.R.string.update_the_app_title).setMessage(com.blueair.viewcore.R.string.update_the_app_msg).setPositiveButton(17039370, new HomeActivity$$ExternalSyntheticLambda4(this)).setCancelable(false).show();
        }
    }

    /* access modifiers changed from: private */
    public static final void onActivityResult$lambda$22(HomeActivity homeActivity, DialogInterface dialogInterface, int i) {
        GooglePlayAppUpdateSdk.GooglePlayAppUpdateManager googlePlayAppUpdateManager = homeActivity.appUpdateManager;
        if (googlePlayAppUpdateManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appUpdateManager");
            googlePlayAppUpdateManager = null;
        }
        googlePlayAppUpdateManager.checkInAppUpdate(REQUEST_CODE_UPDATE);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String str;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        String queryParameter8;
        String str2;
        String queryParameter9;
        String queryParameter10;
        String str3;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        super.onNewIntent(intent);
        Uri data = intent.getData();
        if (data != null) {
            Timber.Forest forest = Timber.Forest;
            forest.d("onNewIntent: uri=\"" + data + '\"', new Object[0]);
            if (Intrinsics.areEqual((Object) data.getScheme(), (Object) "blueair")) {
                KlaviyoSdk.INSTANCE.handlePush(intent);
                String host = data.getHost();
                if (!(host == null || (queryParameter = data.getQueryParameter("type")) == null || (queryParameter2 = data.getQueryParameter("action")) == null)) {
                    switch (queryParameter2.hashCode()) {
                        case -1898415142:
                            if (!(!queryParameter2.equals("view_wick_page") || (queryParameter3 = data.getQueryParameter("did")) == null || (queryParameter4 = data.getQueryParameter(TypedValues.AttributesType.S_TARGET)) == null)) {
                                if (Intrinsics.areEqual((Object) queryParameter4, (Object) "status")) {
                                    str = NotificationService.ACTION_TYPE_WICK_STATUS;
                                } else if (Intrinsics.areEqual((Object) queryParameter4, (Object) FirebaseAnalytics.Event.PURCHASE)) {
                                    str = NotificationService.ACTION_TYPE_WICK_PURCHASE;
                                }
                                onNewIntent$withDevice(this, queryParameter3, new HomeActivity$$ExternalSyntheticLambda19(this, str, data, host, queryParameter, queryParameter2));
                                return;
                            }
                            break;
                        case 1165030963:
                            if (queryParameter2.equals("view_device_details") && (queryParameter5 = data.getQueryParameter("did")) != null) {
                                HomeActivity$$ExternalSyntheticLambda22 homeActivity$$ExternalSyntheticLambda22 = new HomeActivity$$ExternalSyntheticLambda22(this, data, host, queryParameter, queryParameter2);
                                onNewIntent$withDevice(this, queryParameter5, homeActivity$$ExternalSyntheticLambda22);
                                return;
                            }
                            return;
                        case 1196186298:
                            if (queryParameter2.equals("view_web") && (queryParameter6 = data.getQueryParameter("url")) != null) {
                                onNewIntent$sendAnalyticsEvent(this, data, host, queryParameter, queryParameter2, (Device) null);
                                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(queryParameter6)));
                                return;
                            }
                        case 1423852757:
                            if (queryParameter2.equals("view_home_page")) {
                                onNewIntent$sendAnalyticsEvent(this, data, host, queryParameter, queryParameter2, (Device) null);
                                return;
                            }
                            return;
                        case 1437694080:
                            if (!(!queryParameter2.equals("view_refresher_page") || (queryParameter7 = data.getQueryParameter("did")) == null || (queryParameter8 = data.getQueryParameter(TypedValues.AttributesType.S_TARGET)) == null)) {
                                if (Intrinsics.areEqual((Object) queryParameter8, (Object) "status")) {
                                    str2 = NotificationService.ACTION_TYPE_REFRESHER_STATUS;
                                } else if (Intrinsics.areEqual((Object) queryParameter8, (Object) FirebaseAnalytics.Event.PURCHASE)) {
                                    str2 = NotificationService.ACTION_TYPE_REFRESHER_PURCHASE;
                                }
                                onNewIntent$withDevice(this, queryParameter7, new HomeActivity$$ExternalSyntheticLambda21(this, str2, data, host, queryParameter, queryParameter2));
                                return;
                            }
                            break;
                        case 1971487836:
                            if (!(!queryParameter2.equals("view_filter_page") || (queryParameter9 = data.getQueryParameter("did")) == null || (queryParameter10 = data.getQueryParameter(TypedValues.AttributesType.S_TARGET)) == null)) {
                                if (Intrinsics.areEqual((Object) queryParameter10, (Object) "status")) {
                                    str3 = NotificationService.ACTION_TYPE_FILTER_STATUS;
                                } else if (Intrinsics.areEqual((Object) queryParameter10, (Object) FirebaseAnalytics.Event.PURCHASE)) {
                                    str3 = NotificationService.ACTION_TYPE_FILTER_PURCHASE;
                                }
                                HomeActivity$$ExternalSyntheticLambda20 homeActivity$$ExternalSyntheticLambda20 = new HomeActivity$$ExternalSyntheticLambda20(this, str3, data, host, queryParameter, queryParameter2);
                                onNewIntent$withDevice(this, queryParameter9, homeActivity$$ExternalSyntheticLambda20);
                                return;
                            }
                            break;
                    }
                }
            }
        } else {
            Bundle extras = intent.getExtras();
            if (!(extras == null || (string = extras.getString("device_id")) == null || (string2 = extras.getString("action_type")) == null)) {
                onNewIntent$withDevice(this, string, new HomeActivity$$ExternalSyntheticLambda18(this, string2));
                return;
            }
        }
    }

    private static final void onNewIntent$withDevice(HomeActivity homeActivity, String str, Function1<? super Device, Unit> function1) {
        LiveData<Device> device = homeActivity.getViewModel().getDevice(str);
        LiveDataExtensionsKt.observeNonNull(device, homeActivity, new HomeActivity$$ExternalSyntheticLambda5(device, homeActivity, function1));
    }

    /* access modifiers changed from: private */
    public static final Unit onNewIntent$withDevice$lambda$24(LiveData liveData, HomeActivity homeActivity, Function1 function1, Device device) {
        if (device != null) {
            function1.invoke(device);
        }
        liveData.removeObservers(homeActivity);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onNewIntent$lambda$26$lambda$25(HomeActivity homeActivity, String str, Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        Fragment fragment = homeActivity.getSupportFragmentManager().getFragments().get(1);
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.blueair.android.fragment.IndoorFragment");
        ((IndoorFragment) fragment).openDeviceDetails(device, str);
        return Unit.INSTANCE;
    }

    private static final void onNewIntent$sendAnalyticsEvent(HomeActivity homeActivity, Uri uri, String str, String str2, String str3, Device device) {
        AnalyticsService analytics = homeActivity.getAnalytics();
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
        analytics.event(new AnalyticEvent.KlaviyoEvent.Click(uri2, str, str2, str3, device));
    }

    /* access modifiers changed from: private */
    public static final Unit onNewIntent$lambda$27(HomeActivity homeActivity, String str, Uri uri, String str2, String str3, String str4, Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        HomeActivity homeActivity2 = homeActivity;
        Device device2 = device;
        onNewIntent$sendAnalyticsEvent(homeActivity2, uri, str2, str3, str4, device2);
        Fragment fragment = homeActivity2.getSupportFragmentManager().getFragments().get(1);
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.blueair.android.fragment.IndoorFragment");
        ((IndoorFragment) fragment).openDeviceDetails(device2, str);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onNewIntent$lambda$28(HomeActivity homeActivity, String str, Uri uri, String str2, String str3, String str4, Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        HomeActivity homeActivity2 = homeActivity;
        Device device2 = device;
        onNewIntent$sendAnalyticsEvent(homeActivity2, uri, str2, str3, str4, device2);
        Fragment fragment = homeActivity2.getSupportFragmentManager().getFragments().get(1);
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.blueair.android.fragment.IndoorFragment");
        ((IndoorFragment) fragment).openDeviceDetails(device2, str);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onNewIntent$lambda$29(HomeActivity homeActivity, String str, Uri uri, String str2, String str3, String str4, Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        HomeActivity homeActivity2 = homeActivity;
        Device device2 = device;
        onNewIntent$sendAnalyticsEvent(homeActivity2, uri, str2, str3, str4, device2);
        Fragment fragment = homeActivity2.getSupportFragmentManager().getFragments().get(1);
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.blueair.android.fragment.IndoorFragment");
        ((IndoorFragment) fragment).openDeviceDetails(device2, str);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onNewIntent$lambda$30(HomeActivity homeActivity, Uri uri, String str, String str2, String str3, Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        onNewIntent$sendAnalyticsEvent(homeActivity, uri, str, str2, str3, device);
        Fragment fragment = homeActivity.getSupportFragmentManager().getFragments().get(1);
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.blueair.android.fragment.IndoorFragment");
        ((IndoorFragment) fragment).openDeviceDetails(device, "device_details");
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/blueair/android/activity/HomeActivity$Companion;", "", "<init>", "()V", "NAV_VIEW_HEADER_INDEX", "", "REQUEST_CODE_UPDATE", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: HomeActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
