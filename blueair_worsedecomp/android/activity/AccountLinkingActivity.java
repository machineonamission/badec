package com.blueair.android.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.blueair.android.databinding.ActivityAccountLinkingBinding;
import com.blueair.android.fragment.integration.Integration;
import com.blueair.android.viewmodel.AccountLinkingViewModel;
import com.blueair.android.viewmodel.LinkingState;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.LoginPendingAction;
import com.blueair.viewcore.utils.ActivityUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0014J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0014R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/blueair/android/activity/AccountLinkingActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "Lcom/blueair/android/viewmodel/AccountLinkingViewModel;", "getViewModel", "()Lcom/blueair/android/viewmodel/AccountLinkingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/blueair/android/databinding/ActivityAccountLinkingBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "handleIntent", "intent", "Landroid/content/Intent;", "closeClicked", "linked", "", "onNewIntent", "Companion", "LinkingText", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AccountLinkingActivity.kt */
public final class AccountLinkingActivity extends BaseActivity {
    public static final int $stable = 8;
    private static final LinkingText ALEXA_LINKING_TEXT = new LinkingText(R.string.alexa_connect_question, R.string.alexa_connect_hint, R.string.alexa_linking_success, R.string.alexa_linking_start_saying, R.string.alexa_linking_command, R.string.alexa_connect_error, R.string.alexa_disconnect_question, R.string.alexa_disconnect_hint, R.string.alexa_unlink_success, R.string.alexa_unlink_error);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_LINKED = "EXTRA_LINKED";
    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_STATE = "EXTRA_STATE";
    private static final LinkingText GOOGLE_LINKING_TEXT = new LinkingText(R.string.google_connect_question, R.string.google_connect_hint, R.string.google_linking_success, R.string.google_linking_start_saying, R.string.google_linking_command, R.string.google_connect_error, R.string.google_disconnect_question, R.string.google_disconnect_hint, R.string.google_unlink_success, R.string.google_unlink_error);
    public static final String STATE_FAILED = "FAILED";
    public static final String STATE_FETCHING = "FETCHING";
    private ActivityAccountLinkingBinding binding;
    private final String screenName;
    private final Lazy viewModel$delegate;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AccountLinkingActivity.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.blueair.android.fragment.integration.Integration[] r0 = com.blueair.android.fragment.integration.Integration.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.android.fragment.integration.Integration r1 = com.blueair.android.fragment.integration.Integration.AmazonAlexa     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.android.fragment.integration.Integration r1 = com.blueair.android.fragment.integration.Integration.GoogleAssistant     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.activity.AccountLinkingActivity.WhenMappings.<clinit>():void");
        }
    }

    public AccountLinkingActivity() {
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AccountLinkingViewModel.class), new AccountLinkingActivity$special$$inlined$viewModels$default$2(componentActivity), new AccountLinkingActivity$special$$inlined$viewModels$default$1(componentActivity), new AccountLinkingActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    private final AccountLinkingViewModel getViewModel() {
        return (AccountLinkingViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        LinkingText linkingText;
        ActivityAccountLinkingBinding activityAccountLinkingBinding;
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(EXTRA_NAME);
        if (stringExtra == null) {
            stringExtra = "AmazonAlexa";
        }
        boolean booleanExtra = getIntent().getBooleanExtra(EXTRA_LINKED, false);
        if (Intrinsics.areEqual((Object) stringExtra, (Object) "GoogleAssistant")) {
            linkingText = GOOGLE_LINKING_TEXT;
        } else {
            linkingText = ALEXA_LINKING_TEXT;
        }
        LinkingText linkingText2 = linkingText;
        getViewModel().setAccountType(Integration.valueOf(stringExtra));
        getViewModel().setGoogleLinkRequested(false);
        ActivityAccountLinkingBinding inflate = ActivityAccountLinkingBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        ActivityAccountLinkingBinding activityAccountLinkingBinding2 = this.binding;
        if (activityAccountLinkingBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAccountLinkingBinding = null;
        } else {
            activityAccountLinkingBinding = activityAccountLinkingBinding2;
        }
        activityAccountLinkingBinding.btnAllow.setOnClickListener(new AccountLinkingActivity$$ExternalSyntheticLambda0(booleanExtra, this));
        activityAccountLinkingBinding.btnNotNow.setOnClickListener(new AccountLinkingActivity$$ExternalSyntheticLambda1(this));
        if (booleanExtra) {
            activityAccountLinkingBinding.body.setText(linkingText2.getUnlinkBody());
            activityAccountLinkingBinding.txtAllowDescription.setText(linkingText2.getUnlinkHint());
            activityAccountLinkingBinding.btnAllow.setText(R.string.alexa_disconnect);
        } else {
            activityAccountLinkingBinding.body.setText(linkingText2.getLinkBody());
            activityAccountLinkingBinding.txtAllowDescription.setText(linkingText2.getLinkHint());
        }
        FlowKt.launchIn(FlowKt.onEach(getViewModel().getState(), new AccountLinkingActivity$onCreate$1$3(activityAccountLinkingBinding, this, booleanExtra, linkingText2, (Continuation<? super AccountLinkingActivity$onCreate$1$3>) null)), LifecycleOwnerKt.getLifecycleScope(this));
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
        OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, (LifecycleOwner) null, false, new AccountLinkingActivity$$ExternalSyntheticLambda2(this, booleanExtra), 3, (Object) null);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        handleIntent(intent);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$0(boolean z, AccountLinkingActivity accountLinkingActivity, View view) {
        if (z) {
            accountLinkingActivity.getViewModel().unlink();
        } else {
            accountLinkingActivity.getViewModel().startLinking();
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$1(AccountLinkingActivity accountLinkingActivity, View view) {
        accountLinkingActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$3(AccountLinkingActivity accountLinkingActivity, boolean z, OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "$this$addCallback");
        accountLinkingActivity.closeClicked(z);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        String str;
        super.onResume();
        int i = WhenMappings.$EnumSwitchMapping$0[getViewModel().getAccountType().ordinal()];
        if (i == 1) {
            str = AnalyticEvent.ScreenViewEvent.SIDE_MENU_VOICE_ASSISTANT_ALEXA;
        } else if (i != 2) {
            str = null;
        } else {
            str = AnalyticEvent.ScreenViewEvent.SIDE_MENU_VOICE_ASSISTANT_GOOGLE;
        }
        if (str != null) {
            AnalyticsService analytics = getAnalytics();
            String simpleName = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            analytics.event(new AnalyticEvent.ScreenViewEvent(str, simpleName));
        }
        if (getViewModel().getGoogleLinkRequested()) {
            getViewModel().setGoogleLinkRequested(false);
            getViewModel().fetchLinkingStatus(true ^ getIntent().getBooleanExtra(EXTRA_LINKED, false));
        } else if (getViewModel().getAlexaRedirectUrlRequested()) {
            getViewModel().setAlexaRedirectUrlRequested(false);
            getViewModel().fetchLinkingStatus(true);
        }
    }

    private final void handleIntent(Intent intent) {
        String path;
        String stringExtra;
        int i = WhenMappings.$EnumSwitchMapping$0[getViewModel().getAccountType().ordinal()];
        if (i == 1) {
            Uri data = intent.getData();
            if (data != null && (path = data.getPath()) != null) {
                ActivityAccountLinkingBinding activityAccountLinkingBinding = null;
                if (!getViewModel().isUserLoggedIn()) {
                    getViewModel().setLoginPendingAction(LoginPendingAction.Companion.alexaLinking(data));
                    startActivity(Actions.openWelcomeIntent$default(Actions.INSTANCE, this, false, 2, (Object) null));
                } else if (StringsKt.startsWith$default(path, "/app/alexa-linking/start-from-alexa", false, 2, (Object) null)) {
                    ActivityAccountLinkingBinding activityAccountLinkingBinding2 = this.binding;
                    if (activityAccountLinkingBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityAccountLinkingBinding2 = null;
                    }
                    activityAccountLinkingBinding2.btnAllow.setOnClickListener(new AccountLinkingActivity$$ExternalSyntheticLambda3(this, intent));
                    ActivityAccountLinkingBinding activityAccountLinkingBinding3 = this.binding;
                    if (activityAccountLinkingBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityAccountLinkingBinding = activityAccountLinkingBinding3;
                    }
                    activityAccountLinkingBinding.btnNotNow.setOnClickListener(new AccountLinkingActivity$$ExternalSyntheticLambda4(this, intent));
                } else {
                    getViewModel().finishAlexaLinking(intent.getData());
                }
            }
        } else if (i == 2 && (stringExtra = intent.getStringExtra(EXTRA_STATE)) != null) {
            int hashCode = stringExtra.hashCode();
            if (hashCode != 1019825896) {
                if (hashCode == 2066319421 && stringExtra.equals(STATE_FAILED)) {
                    getViewModel().setState(LinkingState.Failed.INSTANCE);
                }
            } else if (stringExtra.equals(STATE_FETCHING)) {
                getViewModel().fetchLinkingStatus(!intent.getBooleanExtra(EXTRA_LINKED, false));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void handleIntent$lambda$5(AccountLinkingActivity accountLinkingActivity, Intent intent, View view) {
        accountLinkingActivity.getViewModel().startAlexaLinking(intent.getData(), true);
    }

    /* access modifiers changed from: private */
    public static final void handleIntent$lambda$6(AccountLinkingActivity accountLinkingActivity, Intent intent, View view) {
        accountLinkingActivity.getViewModel().startAlexaLinking(intent.getData(), false);
    }

    /* access modifiers changed from: private */
    public final void closeClicked(boolean z) {
        setResult(-1, new Intent().putExtra(EXTRA_LINKED, z));
        if (!ActivityUtils.INSTANCE.isActivityInStack(this, HomeActivity.class)) {
            String string = getString(R.string.voice_assistants);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            startActivity(InfoActivity.Companion.gotoIntegrations(this, string));
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/blueair/android/activity/AccountLinkingActivity$Companion;", "", "<init>", "()V", "EXTRA_NAME", "", "EXTRA_LINKED", "EXTRA_STATE", "STATE_FETCHING", "STATE_FAILED", "ALEXA_LINKING_TEXT", "Lcom/blueair/android/activity/AccountLinkingActivity$LinkingText;", "GOOGLE_LINKING_TEXT", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AccountLinkingActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Jm\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006+"}, d2 = {"Lcom/blueair/android/activity/AccountLinkingActivity$LinkingText;", "", "linkBody", "", "linkHint", "linkedTitle", "linkedSubTitle", "linkedBody", "linkFailedTitle", "unlinkBody", "unlinkHint", "unlinkedTitle", "unlinkFailedTitle", "<init>", "(IIIIIIIIII)V", "getLinkBody", "()I", "getLinkHint", "getLinkedTitle", "getLinkedSubTitle", "getLinkedBody", "getLinkFailedTitle", "getUnlinkBody", "getUnlinkHint", "getUnlinkedTitle", "getUnlinkFailedTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AccountLinkingActivity.kt */
    private static final class LinkingText {
        private final int linkBody;
        private final int linkFailedTitle;
        private final int linkHint;
        private final int linkedBody;
        private final int linkedSubTitle;
        private final int linkedTitle;
        private final int unlinkBody;
        private final int unlinkFailedTitle;
        private final int unlinkHint;
        private final int unlinkedTitle;

        public static /* synthetic */ LinkingText copy$default(LinkingText linkingText, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i = linkingText.linkBody;
            }
            if ((i11 & 2) != 0) {
                i2 = linkingText.linkHint;
            }
            if ((i11 & 4) != 0) {
                i3 = linkingText.linkedTitle;
            }
            if ((i11 & 8) != 0) {
                i4 = linkingText.linkedSubTitle;
            }
            if ((i11 & 16) != 0) {
                i5 = linkingText.linkedBody;
            }
            if ((i11 & 32) != 0) {
                i6 = linkingText.linkFailedTitle;
            }
            if ((i11 & 64) != 0) {
                i7 = linkingText.unlinkBody;
            }
            if ((i11 & 128) != 0) {
                i8 = linkingText.unlinkHint;
            }
            if ((i11 & 256) != 0) {
                i9 = linkingText.unlinkedTitle;
            }
            if ((i11 & 512) != 0) {
                i10 = linkingText.unlinkFailedTitle;
            }
            int i12 = i9;
            int i13 = i10;
            int i14 = i7;
            int i15 = i8;
            int i16 = i5;
            int i17 = i6;
            int i18 = i4;
            int i19 = i2;
            return linkingText.copy(i, i19, i3, i18, i16, i17, i14, i15, i12, i13);
        }

        public final int component1() {
            return this.linkBody;
        }

        public final int component10() {
            return this.unlinkFailedTitle;
        }

        public final int component2() {
            return this.linkHint;
        }

        public final int component3() {
            return this.linkedTitle;
        }

        public final int component4() {
            return this.linkedSubTitle;
        }

        public final int component5() {
            return this.linkedBody;
        }

        public final int component6() {
            return this.linkFailedTitle;
        }

        public final int component7() {
            return this.unlinkBody;
        }

        public final int component8() {
            return this.unlinkHint;
        }

        public final int component9() {
            return this.unlinkedTitle;
        }

        public final LinkingText copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            return new LinkingText(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LinkingText)) {
                return false;
            }
            LinkingText linkingText = (LinkingText) obj;
            return this.linkBody == linkingText.linkBody && this.linkHint == linkingText.linkHint && this.linkedTitle == linkingText.linkedTitle && this.linkedSubTitle == linkingText.linkedSubTitle && this.linkedBody == linkingText.linkedBody && this.linkFailedTitle == linkingText.linkFailedTitle && this.unlinkBody == linkingText.unlinkBody && this.unlinkHint == linkingText.unlinkHint && this.unlinkedTitle == linkingText.unlinkedTitle && this.unlinkFailedTitle == linkingText.unlinkFailedTitle;
        }

        public int hashCode() {
            return (((((((((((((((((this.linkBody * 31) + this.linkHint) * 31) + this.linkedTitle) * 31) + this.linkedSubTitle) * 31) + this.linkedBody) * 31) + this.linkFailedTitle) * 31) + this.unlinkBody) * 31) + this.unlinkHint) * 31) + this.unlinkedTitle) * 31) + this.unlinkFailedTitle;
        }

        public String toString() {
            return "LinkingText(linkBody=" + this.linkBody + ", linkHint=" + this.linkHint + ", linkedTitle=" + this.linkedTitle + ", linkedSubTitle=" + this.linkedSubTitle + ", linkedBody=" + this.linkedBody + ", linkFailedTitle=" + this.linkFailedTitle + ", unlinkBody=" + this.unlinkBody + ", unlinkHint=" + this.unlinkHint + ", unlinkedTitle=" + this.unlinkedTitle + ", unlinkFailedTitle=" + this.unlinkFailedTitle + ')';
        }

        public LinkingText(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            this.linkBody = i;
            this.linkHint = i2;
            this.linkedTitle = i3;
            this.linkedSubTitle = i4;
            this.linkedBody = i5;
            this.linkFailedTitle = i6;
            this.unlinkBody = i7;
            this.unlinkHint = i8;
            this.unlinkedTitle = i9;
            this.unlinkFailedTitle = i10;
        }

        public final int getLinkBody() {
            return this.linkBody;
        }

        public final int getLinkHint() {
            return this.linkHint;
        }

        public final int getLinkedTitle() {
            return this.linkedTitle;
        }

        public final int getLinkedSubTitle() {
            return this.linkedSubTitle;
        }

        public final int getLinkedBody() {
            return this.linkedBody;
        }

        public final int getLinkFailedTitle() {
            return this.linkFailedTitle;
        }

        public final int getUnlinkBody() {
            return this.unlinkBody;
        }

        public final int getUnlinkHint() {
            return this.unlinkHint;
        }

        public final int getUnlinkedTitle() {
            return this.unlinkedTitle;
        }

        public final int getUnlinkFailedTitle() {
            return this.unlinkFailedTitle;
        }
    }
}
