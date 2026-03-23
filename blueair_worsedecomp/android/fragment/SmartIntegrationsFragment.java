package com.blueair.android.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.android.R;
import com.blueair.android.activity.AccountLinkingActivity;
import com.blueair.android.databinding.FragmentSmartIntegrationsBinding;
import com.blueair.android.dialog.SmartIntegrationsDialogFragment;
import com.blueair.android.fragment.integration.Integration;
import com.blueair.android.fragment.integration.IntegrationItem;
import com.blueair.android.viewmodel.HomeViewModel;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#H\u0002J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0012H\u0002J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020#H\u0016R\u001a\u0010\u0005\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/blueair/android/fragment/SmartIntegrationsFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/android/viewmodel/HomeViewModel;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/blueair/android/viewmodel/HomeViewModel;", "setViewModel", "(Lcom/blueair/android/viewmodel/HomeViewModel;)V", "viewDataBinding", "Lcom/blueair/android/databinding/FragmentSmartIntegrationsBinding;", "getViewDataBinding", "()Lcom/blueair/android/databinding/FragmentSmartIntegrationsBinding;", "setViewDataBinding", "(Lcom/blueair/android/databinding/FragmentSmartIntegrationsBinding;)V", "itemAdapter", "Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "Lcom/blueair/android/fragment/integration/IntegrationItem;", "googleLinkingLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "alexaLinkingLauncher", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getItems", "", "googleLinked", "", "alexaLinked", "onViewCreated", "", "view", "onItemClick", "item", "showProgress", "shouldShowProgress", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SmartIntegrationsFragment.kt */
public final class SmartIntegrationsFragment extends BaseFragment<HomeViewModel> {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ActivityResultLauncher<Intent> alexaLinkingLauncher;
    private final ActivityResultLauncher<Intent> googleLinkingLauncher;
    private final ItemAdapter<IntegrationItem> itemAdapter = new ItemAdapter<>();
    public FragmentSmartIntegrationsBinding viewDataBinding;
    public HomeViewModel viewModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SmartIntegrationsFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Integration.values().length];
            try {
                iArr[Integration.GoogleAssistant.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void showProgress(boolean z) {
    }

    public SmartIntegrationsFragment() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new SmartIntegrationsFragment$$ExternalSyntheticLambda0(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.googleLinkingLauncher = registerForActivityResult;
        ActivityResultLauncher<Intent> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new SmartIntegrationsFragment$$ExternalSyntheticLambda1(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.alexaLinkingLauncher = registerForActivityResult2;
    }

    public HomeViewModel getViewModel() {
        HomeViewModel homeViewModel = this.viewModel;
        if (homeViewModel != null) {
            return homeViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(HomeViewModel homeViewModel) {
        Intrinsics.checkNotNullParameter(homeViewModel, "<set-?>");
        this.viewModel = homeViewModel;
    }

    public final FragmentSmartIntegrationsBinding getViewDataBinding() {
        FragmentSmartIntegrationsBinding fragmentSmartIntegrationsBinding = this.viewDataBinding;
        if (fragmentSmartIntegrationsBinding != null) {
            return fragmentSmartIntegrationsBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        return null;
    }

    public final void setViewDataBinding(FragmentSmartIntegrationsBinding fragmentSmartIntegrationsBinding) {
        Intrinsics.checkNotNullParameter(fragmentSmartIntegrationsBinding, "<set-?>");
        this.viewDataBinding = fragmentSmartIntegrationsBinding;
    }

    /* access modifiers changed from: private */
    public static final void googleLinkingLauncher$lambda$0(SmartIntegrationsFragment smartIntegrationsFragment, ActivityResult activityResult) {
        MutableLiveData<Boolean> googleLinked = smartIntegrationsFragment.getViewModel().getGoogleLinked();
        Intent data = activityResult.getData();
        googleLinked.setValue(data != null ? Boolean.valueOf(data.getBooleanExtra(AccountLinkingActivity.EXTRA_LINKED, false)) : null);
    }

    /* access modifiers changed from: private */
    public static final void alexaLinkingLauncher$lambda$1(SmartIntegrationsFragment smartIntegrationsFragment, ActivityResult activityResult) {
        MutableLiveData<Boolean> alexaLinked = smartIntegrationsFragment.getViewModel().getAlexaLinked();
        Intent data = activityResult.getData();
        alexaLinked.setValue(data != null ? Boolean.valueOf(data.getBooleanExtra(AccountLinkingActivity.EXTRA_LINKED, false)) : null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_smart_integrations, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setViewDataBinding((FragmentSmartIntegrationsBinding) inflate);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        setViewModel((HomeViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(HomeViewModel.class)));
        List items$default = getItems$default(this, false, false, 3, (Object) null);
        TextView textView = getViewDataBinding().txtNoIntegrations;
        Intrinsics.checkNotNullExpressionValue(textView, "txtNoIntegrations");
        textView.setVisibility(items$default.isEmpty() ? 0 : 8);
        this.itemAdapter.add(items$default);
        FastAdapter with = FastAdapter.Companion.with(this.itemAdapter);
        with.setOnClickListener(new SmartIntegrationsFragment$$ExternalSyntheticLambda2(this));
        getViewDataBinding().integrationsRecycler.swapAdapter(with, false);
        View root = getViewDataBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final boolean onCreateView$lambda$2(SmartIntegrationsFragment smartIntegrationsFragment, View view, IAdapter iAdapter, IntegrationItem integrationItem, int i) {
        Intrinsics.checkNotNullParameter(iAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(integrationItem, "item");
        smartIntegrationsFragment.onItemClick(integrationItem);
        return true;
    }

    private final List<IntegrationItem> getItems(boolean z, boolean z2) {
        List createListBuilder = CollectionsKt.createListBuilder();
        if (getViewModel().isInTmallRegion() && (getViewModel().isInB4Region() || getViewModel().isInG4Region())) {
            createListBuilder.add(new IntegrationItem(Integration.Tmall, false, new SmartIntegrationsFragment$getItems$1$1(this)));
        }
        if (getViewModel().isInAlexaRegion()) {
            createListBuilder.addAll(CollectionsKt.listOf(new IntegrationItem(Integration.AmazonAlexa, z2, new SmartIntegrationsFragment$getItems$1$2(this)), new IntegrationItem(Integration.AmazonAlexaOld, false, new SmartIntegrationsFragment$getItems$1$3(this))));
        }
        if (getViewModel().isInGoogleAssistantRegion()) {
            createListBuilder.add(new IntegrationItem(Integration.GoogleAssistant, z, new SmartIntegrationsFragment$getItems$1$4(this)));
        }
        return CollectionsKt.build(createListBuilder);
    }

    static /* synthetic */ List getItems$default(SmartIntegrationsFragment smartIntegrationsFragment, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return smartIntegrationsFragment.getItems(z, z2);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        LiveData<Boolean> fetchingSmartIntegrationStatus = getViewModel().getFetchingSmartIntegrationStatus();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(fetchingSmartIntegrationStatus, viewLifecycleOwner, new SmartIntegrationsFragment$$ExternalSyntheticLambda3(this));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(getViewModel().getGoogleLinked(), viewLifecycleOwner2, new SmartIntegrationsFragment$$ExternalSyntheticLambda4(this));
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(getViewModel().getAlexaLinked(), viewLifecycleOwner3, new SmartIntegrationsFragment$$ExternalSyntheticLambda5(this));
        if (getViewModel().isInGoogleAssistantRegion()) {
            getViewModel().getGoogleLinkStatus();
        }
        if (getViewModel().isInAlexaRegion()) {
            getViewModel().getAlexaLinkStatus();
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$4(SmartIntegrationsFragment smartIntegrationsFragment, boolean z) {
        ProgressBlockerView progressBlockerView = smartIntegrationsFragment.getViewDataBinding().loading;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "loading");
        progressBlockerView.setVisibility(z ? 0 : 8);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$5(SmartIntegrationsFragment smartIntegrationsFragment, Boolean bool) {
        Intrinsics.checkNotNull(bool);
        boolean booleanValue = bool.booleanValue();
        Boolean value = smartIntegrationsFragment.getViewModel().getAlexaLinked().getValue();
        int i = 0;
        List<IntegrationItem> items = smartIntegrationsFragment.getItems(booleanValue, value != null ? value.booleanValue() : false);
        smartIntegrationsFragment.itemAdapter.set((List) items);
        TextView textView = smartIntegrationsFragment.getViewDataBinding().txtNoIntegrations;
        Intrinsics.checkNotNullExpressionValue(textView, "txtNoIntegrations");
        View view = textView;
        if (!items.isEmpty()) {
            i = 8;
        }
        view.setVisibility(i);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$6(SmartIntegrationsFragment smartIntegrationsFragment, Boolean bool) {
        Boolean value = smartIntegrationsFragment.getViewModel().getGoogleLinked().getValue();
        int i = 0;
        boolean booleanValue = value != null ? value.booleanValue() : false;
        Intrinsics.checkNotNull(bool);
        List<IntegrationItem> items = smartIntegrationsFragment.getItems(booleanValue, bool.booleanValue());
        smartIntegrationsFragment.itemAdapter.set((List) items);
        TextView textView = smartIntegrationsFragment.getViewDataBinding().txtNoIntegrations;
        Intrinsics.checkNotNullExpressionValue(textView, "txtNoIntegrations");
        View view = textView;
        if (!items.isEmpty()) {
            i = 8;
        }
        view.setVisibility(i);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void onItemClick(IntegrationItem integrationItem) {
        ActivityResultLauncher<Intent> activityResultLauncher;
        if (SetsKt.setOf(Integration.AmazonAlexa, Integration.GoogleAssistant).contains(integrationItem.getIntegration())) {
            if (WhenMappings.$EnumSwitchMapping$0[integrationItem.getIntegration().ordinal()] == 1) {
                activityResultLauncher = this.googleLinkingLauncher;
            } else {
                activityResultLauncher = this.alexaLinkingLauncher;
            }
            activityResultLauncher.launch(new Intent(requireContext(), AccountLinkingActivity.class).putExtra(AccountLinkingActivity.EXTRA_NAME, integrationItem.getIntegration().name()).putExtra(AccountLinkingActivity.EXTRA_LINKED, integrationItem.getLinked()));
            return;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<SmartIntegrationsDialogFragment> cls = SmartIntegrationsDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("SmartIntegrationsDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("SmartIntegrationsDialogFragment") instanceof SmartIntegrationsDialogFragment) && !childFragmentManager.isStateSaved()) {
            SmartIntegrationsDialogFragment.Companion.newInstance(integrationItem.getIntegration().getIntegrationName()).show(childFragmentManager, "SmartIntegrationsDialogFragment");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/android/fragment/SmartIntegrationsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/android/fragment/SmartIntegrationsFragment;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SmartIntegrationsFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SmartIntegrationsFragment newInstance() {
            return new SmartIntegrationsFragment();
        }
    }
}
