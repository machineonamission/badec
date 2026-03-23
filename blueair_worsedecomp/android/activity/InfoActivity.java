package com.blueair.android.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelLazy;
import com.blueair.android.databinding.ActivityInfoBinding;
import com.blueair.android.viewmodel.HomeViewModel;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.util.LinkUtils;
import com.blueair.devicedetails.activity.DeviceSettingsActivityKt;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.fragment.WebViewFragment;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import timber.log.Timber;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001aH\u0014J\u0012\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010 \u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\u001aH\u0017R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0016\u0010\u0017¨\u0006("}, d2 = {"Lcom/blueair/android/activity/InfoActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "Lcom/blueair/android/viewmodel/HomeViewModel;", "getViewModel", "()Lcom/blueair/android/viewmodel/HomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "infoActivityDataBinding", "Lcom/blueair/android/databinding/ActivityInfoBinding;", "getInfoActivityDataBinding", "()Lcom/blueair/android/databinding/ActivityInfoBinding;", "setInfoActivityDataBinding", "(Lcom/blueair/android/databinding/ActivityInfoBinding;)V", "display", "", "getDisplay", "()I", "display$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setToolbar", "title", "bindViewModel", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onSupportNavigateUp", "onBackPressed", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: InfoActivity.kt */
public final class InfoActivity extends BaseActivity {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DISPLAY_BLUEAIR_FILTER = 9;
    public static final int DISPLAY_BLUEAIR_STORE = 8;
    public static final int DISPLAY_INTEGRATIONS = 5;
    public static final String DISPLAY_KEY = "display_key";
    public static final int DISPLAY_POLICIES = 4;
    public static final int DISPLAY_SUPPORT = 6;
    public static final int DISPLAY_TROUBLESHOOT_CONNECTION = 7;
    public static final int DISPLAY_WEBVIEW = 2;
    public static final String TOOLBAR_TITLE_KEY = "toolbar_key";
    public static final String URL_KEY = "url_key";
    private final Lazy display$delegate = LazyKt.lazy(new InfoActivity$$ExternalSyntheticLambda1(this));
    public ActivityInfoBinding infoActivityDataBinding;
    private final String screenName;
    private final Lazy viewModel$delegate;

    public InfoActivity() {
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(HomeViewModel.class), new InfoActivity$special$$inlined$viewModels$default$2(componentActivity), new InfoActivity$special$$inlined$viewModels$default$1(componentActivity), new InfoActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    /* access modifiers changed from: private */
    public final HomeViewModel getViewModel() {
        return (HomeViewModel) this.viewModel$delegate.getValue();
    }

    public final ActivityInfoBinding getInfoActivityDataBinding() {
        ActivityInfoBinding activityInfoBinding = this.infoActivityDataBinding;
        if (activityInfoBinding != null) {
            return activityInfoBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("infoActivityDataBinding");
        return null;
    }

    public final void setInfoActivityDataBinding(ActivityInfoBinding activityInfoBinding) {
        Intrinsics.checkNotNullParameter(activityInfoBinding, "<set-?>");
        this.infoActivityDataBinding = activityInfoBinding;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u0016\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005J\u0016\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005J\u0016\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u001dR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/blueair/android/activity/InfoActivity$Companion;", "", "<init>", "()V", "DISPLAY_KEY", "", "DISPLAY_WEBVIEW", "", "DISPLAY_POLICIES", "DISPLAY_INTEGRATIONS", "DISPLAY_SUPPORT", "DISPLAY_TROUBLESHOOT_CONNECTION", "DISPLAY_BLUEAIR_STORE", "DISPLAY_BLUEAIR_FILTER", "TOOLBAR_TITLE_KEY", "URL_KEY", "gotoWebView", "Landroid/content/Intent;", "activity", "Landroid/app/Activity;", "url", "toolbarTitle", "gotoPolicies", "gotoIntegrations", "gotoSupport", "gotoBlueairStore", "gotoBlueairFilter", "gotoInstance", "destinationActivityClass", "Ljava/lang/Class;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: InfoActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent gotoWebView(Activity activity, String str, String str2) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(str2, "toolbarTitle");
            Intent gotoInstance = gotoInstance(activity, InfoActivity.class);
            gotoInstance.putExtra(InfoActivity.DISPLAY_KEY, 2);
            gotoInstance.putExtra(InfoActivity.URL_KEY, str);
            gotoInstance.putExtra(InfoActivity.TOOLBAR_TITLE_KEY, str2);
            return gotoInstance;
        }

        public final Intent gotoPolicies(Activity activity, String str) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(str, "toolbarTitle");
            Intent gotoInstance = gotoInstance(activity, InfoActivity.class);
            gotoInstance.putExtra(InfoActivity.DISPLAY_KEY, 4);
            gotoInstance.putExtra(InfoActivity.TOOLBAR_TITLE_KEY, str);
            return gotoInstance;
        }

        public final Intent gotoIntegrations(Activity activity, String str) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(str, "toolbarTitle");
            Intent gotoInstance = gotoInstance(activity, InfoActivity.class);
            gotoInstance.putExtra(InfoActivity.DISPLAY_KEY, 5);
            gotoInstance.putExtra(InfoActivity.TOOLBAR_TITLE_KEY, str);
            return gotoInstance;
        }

        public final Intent gotoSupport(Activity activity, String str) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(str, "toolbarTitle");
            Intent gotoInstance = gotoInstance(activity, InfoActivity.class);
            gotoInstance.putExtra(InfoActivity.DISPLAY_KEY, 6);
            gotoInstance.putExtra(InfoActivity.TOOLBAR_TITLE_KEY, str);
            return gotoInstance;
        }

        public final Intent gotoBlueairStore(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intent gotoInstance = gotoInstance(activity, InfoActivity.class);
            gotoInstance.putExtra(InfoActivity.DISPLAY_KEY, 8);
            gotoInstance.putExtra(InfoActivity.TOOLBAR_TITLE_KEY, activity.getString(R.string.action_blueair_store));
            return gotoInstance;
        }

        public final Intent gotoBlueairFilter(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intent gotoInstance = gotoInstance(activity, InfoActivity.class);
            gotoInstance.putExtra(InfoActivity.DISPLAY_KEY, 9);
            return gotoInstance;
        }

        public final Intent gotoInstance(Activity activity, Class<? extends Activity> cls) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(cls, "destinationActivityClass");
            return new Intent(activity, cls);
        }
    }

    private final int getDisplay() {
        return ((Number) this.display$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public static final int display_delegate$lambda$0(InfoActivity infoActivity) {
        return infoActivity.getIntent().getIntExtra(DISPLAY_KEY, -1);
    }

    /* JADX WARNING: type inference failed for: r1v5, types: [com.blueair.viewcore.fragment.BaseFragment] */
    /* JADX WARNING: type inference failed for: r1v8, types: [com.blueair.viewcore.fragment.BaseFragment] */
    /* JADX WARNING: type inference failed for: r1v10, types: [com.blueair.viewcore.fragment.BaseFragment] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            int r0 = com.blueair.viewcore.R.style.AppTheme_NoActionBar
            r8.setTheme(r0)
            super.onCreate(r9)
            r8.bindViewModel()
            com.blueair.android.viewmodel.HomeViewModel r9 = r8.getViewModel()
            kotlinx.coroutines.flow.Flow r9 = r9.getUserAblRegionFetchErrorFlow()
            com.blueair.android.activity.InfoActivity$onCreate$1 r0 = new com.blueair.android.activity.InfoActivity$onCreate$1
            r1 = 0
            r0.<init>(r8, r1)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            kotlinx.coroutines.flow.Flow r9 = kotlinx.coroutines.flow.FlowKt.onEach(r9, r0)
            r0 = r8
            androidx.lifecycle.LifecycleOwner r0 = (androidx.lifecycle.LifecycleOwner) r0
            androidx.lifecycle.LifecycleCoroutineScope r0 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r0)
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlinx.coroutines.flow.FlowKt.launchIn(r9, r0)
            android.content.Intent r9 = r8.getIntent()
            if (r9 == 0) goto L_0x0038
            java.lang.String r0 = "toolbar_key"
            java.lang.String r9 = r9.getStringExtra(r0)
            goto L_0x0039
        L_0x0038:
            r9 = r1
        L_0x0039:
            r8.setToolbar(r9)
            int r9 = r8.getDisplay()
            r0 = 6
            if (r9 == r0) goto L_0x005a
            int r9 = r8.getDisplay()
            r0 = 7
            if (r9 == r0) goto L_0x005a
            int r9 = r8.getDisplay()
            r0 = 8
            if (r9 == r0) goto L_0x005a
            int r9 = r8.getDisplay()
            r0 = 9
            if (r9 != r0) goto L_0x0072
        L_0x005a:
            r2 = r8
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlinx.coroutines.CoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.getIO()
            r3 = r9
            kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3
            com.blueair.android.activity.InfoActivity$onCreate$2 r9 = new com.blueair.android.activity.InfoActivity$onCreate$2
            r9.<init>(r8, r1)
            r5 = r9
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = 2
            r7 = 0
            r4 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r2, r3, r4, r5, r6, r7)
        L_0x0072:
            int r9 = r8.getDisplay()
            r0 = 2
            if (r9 == r0) goto L_0x0094
            r0 = 4
            if (r9 == r0) goto L_0x008a
            r0 = 5
            if (r9 == r0) goto L_0x0080
            goto L_0x00ae
        L_0x0080:
            com.blueair.android.fragment.SmartIntegrationsFragment$Companion r9 = com.blueair.android.fragment.SmartIntegrationsFragment.Companion
            com.blueair.android.fragment.SmartIntegrationsFragment r9 = r9.newInstance()
            r1 = r9
            com.blueair.viewcore.fragment.BaseFragment r1 = (com.blueair.viewcore.fragment.BaseFragment) r1
            goto L_0x00ae
        L_0x008a:
            com.blueair.android.fragment.PoliciesFragment$Companion r9 = com.blueair.android.fragment.PoliciesFragment.Companion
            com.blueair.android.fragment.PoliciesFragment r9 = r9.newInstance()
            r1 = r9
            com.blueair.viewcore.fragment.BaseFragment r1 = (com.blueair.viewcore.fragment.BaseFragment) r1
            goto L_0x00ae
        L_0x0094:
            android.content.Intent r9 = r8.getIntent()
            if (r9 == 0) goto L_0x00a0
            java.lang.String r0 = "url_key"
            java.lang.String r1 = r9.getStringExtra(r0)
        L_0x00a0:
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.String"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r9)
            com.blueair.viewcore.fragment.WebViewFragment$Companion r9 = com.blueair.viewcore.fragment.WebViewFragment.Companion
            com.blueair.viewcore.fragment.WebViewFragment r9 = r9.newInstance(r1)
            r1 = r9
            com.blueair.viewcore.fragment.BaseFragment r1 = (com.blueair.viewcore.fragment.BaseFragment) r1
        L_0x00ae:
            if (r1 == 0) goto L_0x00d4
            androidx.fragment.app.FragmentManager r9 = r8.getSupportFragmentManager()
            java.lang.String r0 = "getSupportFragmentManager(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            androidx.fragment.app.FragmentTransaction r9 = r9.beginTransaction()
            java.lang.String r0 = "beginTransaction()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            com.blueair.android.databinding.ActivityInfoBinding r0 = r8.getInfoActivityDataBinding()
            android.widget.FrameLayout r0 = r0.infoContainer
            int r0 = r0.getId()
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            r9.replace(r0, r1)
            r9.commit()
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.activity.InfoActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        String str;
        super.onResume();
        int display = getDisplay();
        if (display == 4) {
            str = AnalyticEvent.ScreenViewEvent.SIDE_MENU_POLICY;
        } else if (display == 5) {
            str = AnalyticEvent.ScreenViewEvent.SIDE_MENU_VOICE_ASSISTANT;
        } else if (display == 6) {
            str = AnalyticEvent.ScreenViewEvent.SIDE_MENU_CUSTOMER_SUPPORT;
        } else if (display != 8) {
            str = null;
        } else {
            str = AnalyticEvent.ScreenViewEvent.SIDE_MENU_STORE;
        }
        if (str != null) {
            AnalyticsService analytics = getAnalytics();
            String simpleName = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            analytics.event(new AnalyticEvent.ScreenViewEvent(str, simpleName));
        }
        getRxSubs().add(RxExtensionsKt.subscribeAndLogE(RxExtensionsKt.uiThread(getViewModel().getUserAblRegionObserver()), new InfoActivity$$ExternalSyntheticLambda2(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$7(InfoActivity infoActivity, String str) {
        Intrinsics.checkNotNullParameter(str, "ablRegion");
        TextView textView = infoActivity.getInfoActivityDataBinding().errorText;
        Intrinsics.checkNotNullExpressionValue(textView, "errorText");
        textView.setVisibility(8);
        Timber.Forest forest = Timber.Forest;
        forest.d("user ablRegion : " + str + " & display = " + infoActivity.getDisplay(), new Object[0]);
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (infoActivity.getDisplay()) {
            case 6:
                WebViewFragment newInstance = WebViewFragment.Companion.newInstance(LinkUtils.INSTANCE.getSupportLink(lowerCase));
                FragmentManager supportFragmentManager = infoActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
                beginTransaction.replace(infoActivity.getInfoActivityDataBinding().infoContainer.getId(), newInstance);
                beginTransaction.commit();
                break;
            case 7:
                WebViewFragment newInstance2 = WebViewFragment.Companion.newInstance(LinkUtils.INSTANCE.getConnectionTroubleShootingLink(lowerCase));
                FragmentManager supportFragmentManager2 = infoActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
                FragmentTransaction beginTransaction2 = supportFragmentManager2.beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction2, "beginTransaction()");
                beginTransaction2.replace(infoActivity.getInfoActivityDataBinding().infoContainer.getId(), newInstance2);
                beginTransaction2.commit();
                break;
            case 8:
                WebViewFragment newInstance3 = WebViewFragment.Companion.newInstance(LinkUtils.INSTANCE.getBlueairStoreLink(lowerCase));
                FragmentManager supportFragmentManager3 = infoActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager3, "getSupportFragmentManager(...)");
                FragmentTransaction beginTransaction3 = supportFragmentManager3.beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction3, "beginTransaction()");
                beginTransaction3.replace(infoActivity.getInfoActivityDataBinding().infoContainer.getId(), newInstance3);
                beginTransaction3.commit();
                break;
            case 9:
                WebViewFragment newInstance4 = WebViewFragment.Companion.newInstance(LinkUtils.INSTANCE.getVisitBlueairLinkFromCountryCode(lowerCase));
                FragmentManager supportFragmentManager4 = infoActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager4, "getSupportFragmentManager(...)");
                FragmentTransaction beginTransaction4 = supportFragmentManager4.beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction4, "beginTransaction()");
                beginTransaction4.replace(infoActivity.getInfoActivityDataBinding().infoContainer.getId(), newInstance4);
                beginTransaction4.commit();
                break;
        }
        return Unit.INSTANCE;
    }

    private final void setToolbar(String str) {
        View view;
        setSupportActionBar(getInfoActivityDataBinding().toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white);
        }
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.setHomeActionContentDescription(R.string.home_as_up_content_description);
        }
        ActionBar supportActionBar4 = getSupportActionBar();
        if (supportActionBar4 != null) {
            supportActionBar4.setDisplayShowTitleEnabled(false);
        }
        Toolbar toolbar = getInfoActivityDataBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        Context context = this;
        DeviceSettingsActivityKt.changeToolbarFont(toolbar, context, R.font.apercu_bold);
        getInfoActivityDataBinding().toolbar.setTitleTextColor(ContextCompat.getColor(context, R.color.colorOnPrimary));
        getInfoActivityDataBinding().toolbar.setTitle((CharSequence) str);
        Toolbar toolbar2 = getInfoActivityDataBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar2, "toolbar");
        Iterator<View> it = ViewGroupKt.getChildren(toolbar2).iterator();
        while (true) {
            if (!it.hasNext()) {
                view = null;
                break;
            }
            view = it.next();
            View view2 = view;
            if ((view2 instanceof TextView) && Intrinsics.areEqual((Object) ((TextView) view2).getText(), (Object) str)) {
                break;
            }
        }
        View view3 = view;
        if (view3 != null) {
            ViewCompat.setAccessibilityHeading(view3, true);
        }
        getInfoActivityDataBinding().toolbar.setNavigationOnClickListener(new InfoActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public static final void setToolbar$lambda$10(InfoActivity infoActivity, View view) {
        infoActivity.finish();
    }

    private final void bindViewModel() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, com.blueair.android.R.layout.activity_info);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(...)");
        setInfoActivityDataBinding((ActivityInfoBinding) contentView);
        ActivityInfoBinding infoActivityDataBinding2 = getInfoActivityDataBinding();
        infoActivityDataBinding2.setHomeViewModel(getViewModel());
        infoActivityDataBinding2.setLifecycleOwner(this);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        Timber.Forest.d("onOptionsItemSelected", new Object[0]);
        if (menuItem.getItemId() == 16908332) {
            onSupportNavigateUp();
            return true;
        }
        super.onOptionsItemSelected(menuItem);
        return true;
    }

    public boolean onSupportNavigateUp() {
        if (super.onSupportNavigateUp()) {
            return true;
        }
        onBackPressed();
        return true;
    }

    @Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        if (supportFragmentManager.getBackStackEntryCount() > 0) {
            supportFragmentManager.popBackStack();
        } else {
            finish();
        }
    }
}
