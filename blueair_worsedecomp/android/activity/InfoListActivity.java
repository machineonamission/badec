package com.blueair.android.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelLazy;
import com.blueair.android.R;
import com.blueair.android.adapter.InfoListItem;
import com.blueair.android.adapter.SimpleInfoItem;
import com.blueair.android.databinding.ActivityInfoListBinding;
import com.blueair.android.viewmodel.HomeViewModel;
import com.blueair.auth.AuthService;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.I18nConfig;
import com.blueair.core.model.UserInfoCollectionGroup;
import com.blueair.core.util.LinkUtils;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0006\u0010 \u001a\u00020\u001dJ\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058TX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006'²\u0006\n\u0010(\u001a\u00020)X\u0002"}, d2 = {"Lcom/blueair/android/activity/InfoListActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/android/databinding/ActivityInfoListBinding;", "viewModel", "Lcom/blueair/android/viewmodel/HomeViewModel;", "getViewModel", "()Lcom/blueair/android/viewmodel/HomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "fastAdapter", "Lcom/mikepenz/fastadapter/FastAdapter;", "Lcom/blueair/android/adapter/SimpleInfoItem;", "getFastAdapter", "()Lcom/mikepenz/fastadapter/FastAdapter;", "fastAdapter$delegate", "infoType", "Lcom/blueair/android/activity/InfoListActivity$InfoType;", "getInfoType", "()Lcom/blueair/android/activity/InfoListActivity$InfoType;", "setInfoType", "(Lcom/blueair/android/activity/InfoListActivity$InfoType;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configure", "initAdapter", "loadInfoListByType", "", "Lcom/blueair/android/adapter/InfoListItem;", "Companion", "InfoType", "app_otherRelease", "authService", "Lcom/blueair/auth/AuthService;"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: InfoListActivity.kt */
public final class InfoListActivity extends BaseActivity {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(InfoListActivity.class, "authService", "<v#0>", 0))};
    public static final int $stable = 8;
    public static final String ARG_INFO_TYPE = "info_type";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ActivityInfoListBinding binding;
    private final Lazy fastAdapter$delegate = LazyKt.lazy(new InfoListActivity$$ExternalSyntheticLambda0(this));
    private InfoType infoType = InfoType.POLICIES;
    private final Lazy viewModel$delegate;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: InfoListActivity.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.blueair.android.activity.InfoListActivity$InfoType[] r0 = com.blueair.android.activity.InfoListActivity.InfoType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.android.activity.InfoListActivity$InfoType r1 = com.blueair.android.activity.InfoListActivity.InfoType.POLICIES     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.android.activity.InfoListActivity$InfoType r1 = com.blueair.android.activity.InfoListActivity.InfoType.USER_INFO_GROUPS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.activity.InfoListActivity.WhenMappings.<clinit>():void");
        }
    }

    public InfoListActivity() {
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(HomeViewModel.class), new InfoListActivity$special$$inlined$viewModels$default$2(componentActivity), new InfoListActivity$special$$inlined$viewModels$default$1(componentActivity), new InfoListActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.infoType.getScreenName();
    }

    private final HomeViewModel getViewModel() {
        return (HomeViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final FastAdapter fastAdapter_delegate$lambda$0(InfoListActivity infoListActivity) {
        return infoListActivity.initAdapter();
    }

    private final FastAdapter<SimpleInfoItem> getFastAdapter() {
        return (FastAdapter) this.fastAdapter$delegate.getValue();
    }

    public final InfoType getInfoType() {
        return this.infoType;
    }

    public final void setInfoType(InfoType infoType2) {
        Intrinsics.checkNotNullParameter(infoType2, "<set-?>");
        this.infoType = infoType2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_info_list);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(...)");
        this.binding = (ActivityInfoListBinding) contentView;
        BaseLokaliseActivity.setStatusBarColor$default(this, getColor(com.blueair.viewcore.R.color.light_sliver), (Boolean) null, 2, (Object) null);
        configure();
    }

    public final void configure() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(ARG_INFO_TYPE);
            if (serializableExtra instanceof InfoType) {
                this.infoType = (InfoType) serializableExtra;
            }
        }
        ActivityInfoListBinding activityInfoListBinding = this.binding;
        ActivityInfoListBinding activityInfoListBinding2 = null;
        if (activityInfoListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInfoListBinding = null;
        }
        activityInfoListBinding.tvTitle.setText(this.infoType.getScreenTitle());
        ActivityInfoListBinding activityInfoListBinding3 = this.binding;
        if (activityInfoListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInfoListBinding3 = null;
        }
        activityInfoListBinding3.btnBack.setOnClickListener(new InfoListActivity$$ExternalSyntheticLambda1(this));
        ActivityInfoListBinding activityInfoListBinding4 = this.binding;
        if (activityInfoListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityInfoListBinding2 = activityInfoListBinding4;
        }
        activityInfoListBinding2.srvList.getRecyclerView().setAdapter(getFastAdapter());
        getFastAdapter().setOnClickListener(new InfoListActivity$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$2(InfoListActivity infoListActivity, View view) {
        infoListActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final boolean configure$lambda$3(InfoListActivity infoListActivity, View view, IAdapter iAdapter, SimpleInfoItem simpleInfoItem, int i) {
        Intrinsics.checkNotNullParameter(iAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(simpleInfoItem, "item");
        InfoListItem infoItem = simpleInfoItem.getInfoItem();
        if (Intrinsics.areEqual((Object) infoItem, (Object) InfoListItem.Companion.getPOLICY_TERMS())) {
            String privacyLinkFromCountryCode = LinkUtils.INSTANCE.getPrivacyLinkFromCountryCode(infoListActivity.getViewModel().getCountry());
            String string = infoListActivity.getString(com.blueair.viewcore.R.string.privacy_and_terms);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            infoListActivity.startActivity(InfoActivity.Companion.gotoWebView(infoListActivity, privacyLinkFromCountryCode, string));
            return true;
        } else if (Intrinsics.areEqual((Object) infoItem, (Object) InfoListItem.Companion.getUSER_INFO_COLLECTIONS())) {
            Companion.launch(infoListActivity, InfoType.USER_INFO_GROUPS);
            return true;
        } else if (Intrinsics.areEqual((Object) infoItem, (Object) InfoListItem.Companion.getSHARED_THIRD_PARTIES())) {
            String sharedSdkInfoLink = LinkUtils.INSTANCE.getSharedSdkInfoLink(infoListActivity.getViewModel().getCountry());
            String string2 = infoListActivity.getString(com.blueair.viewcore.R.string.infomation_shared_with_third_parties);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            infoListActivity.startActivity(InfoActivity.Companion.gotoWebView(infoListActivity, sharedSdkInfoLink, string2));
            return true;
        } else {
            InfoDetailActivity.Companion.launch(infoListActivity, infoItem.getId());
            return true;
        }
    }

    private final FastAdapter<SimpleInfoItem> initAdapter() {
        ItemAdapter itemAdapter = new ItemAdapter();
        Iterable<InfoListItem> loadInfoListByType = loadInfoListByType();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(loadInfoListByType, 10));
        for (InfoListItem simpleInfoItem : loadInfoListByType) {
            arrayList.add(new SimpleInfoItem(simpleInfoItem));
        }
        itemAdapter.add((List) arrayList);
        return FastAdapter.Companion.with(itemAdapter);
    }

    private final List<InfoListItem> loadInfoListByType() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.infoType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new InfoListActivity$loadInfoListByType$$inlined$instance$default$1().getSuperType());
                Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
                UserInfoCollectionsManager.INSTANCE.initializeCollections(loadInfoListByType$lambda$5(DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, AuthService.class), (Object) null).provideDelegate((Object) null, $$delegatedProperties[0])).getUsername(), this);
                Iterable<UserInfoCollectionGroup> collections = UserInfoCollectionsManager.INSTANCE.getCollections();
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collections, 10));
                for (UserInfoCollectionGroup userInfoCollectionGroup : collections) {
                    String id = userInfoCollectionGroup.getId();
                    String value$default = I18nConfig.getValue$default(userInfoCollectionGroup.getName(), (Locale) null, 1, (Object) null);
                    if (value$default == null) {
                        value$default = "/";
                    }
                    arrayList.add(new InfoListItem(id, value$default));
                }
                return (List) arrayList;
            }
            throw new NoWhenBranchMatchedException();
        } else if (!BuildEnvironment.INSTANCE.isChina()) {
            return CollectionsKt.listOf(InfoListItem.Companion.getPOLICY_TERMS());
        } else {
            return CollectionsKt.listOf(InfoListItem.Companion.getPOLICY_TERMS(), InfoListItem.Companion.getUSER_INFO_COLLECTIONS(), InfoListItem.Companion.getSHARED_THIRD_PARTIES());
        }
    }

    private static final AuthService loadInfoListByType$lambda$5(Lazy<AuthService> lazy) {
        return lazy.getValue();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/blueair/android/activity/InfoListActivity$Companion;", "", "<init>", "()V", "ARG_INFO_TYPE", "", "launch", "", "context", "Landroid/content/Context;", "infoType", "Lcom/blueair/android/activity/InfoListActivity$InfoType;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: InfoListActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void launch(Context context, InfoType infoType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(infoType, "infoType");
            Intent intent = new Intent(context, InfoListActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra(InfoListActivity.ARG_INFO_TYPE, infoType);
            context.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/blueair/android/activity/InfoListActivity$InfoType;", "", "screenName", "", "screenTitle", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getScreenName", "()Ljava/lang/String;", "getScreenTitle", "()I", "POLICIES", "USER_INFO_GROUPS", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: InfoListActivity.kt */
    public enum InfoType {
        POLICIES(AnalyticEvent.ScreenViewEvent.SIDE_MENU_POLICY, com.blueair.viewcore.R.string.action_policies),
        USER_INFO_GROUPS(AnalyticEvent.ScreenViewEvent.SIDE_MENU_POLICY_USER_INFO_GROUPS, com.blueair.viewcore.R.string.collected_personal_infomation);
        
        private final String screenName;
        private final int screenTitle;

        public static EnumEntries<InfoType> getEntries() {
            return $ENTRIES;
        }

        private InfoType(String str, int i) {
            this.screenName = str;
            this.screenTitle = i;
        }

        public final String getScreenName() {
            return this.screenName;
        }

        public final int getScreenTitle() {
            return this.screenTitle;
        }

        static {
            InfoType[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }
}
