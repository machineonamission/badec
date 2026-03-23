package com.blueair.android.dialog;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.DividerItemDecoration;
import com.blueair.android.adapter.SmartIntegrationDevicesAdapter;
import com.blueair.android.databinding.DialogfragmentSmartIntegrationsBinding;
import com.blueair.android.fragment.integration.Integration;
import com.blueair.android.fragment.integration.IotDeviceConfig;
import com.blueair.android.viewmodel.HomeViewModel;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J$\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0018\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)*\b\u0012\u0004\u0012\u00020*0)H\u0002J\u0012\u0010+\u001a\u00020,2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010-\u001a\u00020\u001dH\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\b\u0010/\u001a\u00020\u001dH\u0016J\u0010\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u000202H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u00064"}, d2 = {"Lcom/blueair/android/dialog/SmartIntegrationsDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/android/viewmodel/HomeViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/android/databinding/DialogfragmentSmartIntegrationsBinding;", "viewModel", "getViewModel", "()Lcom/blueair/android/viewmodel/HomeViewModel;", "setViewModel", "(Lcom/blueair/android/viewmodel/HomeViewModel;)V", "deviceClickPublisher", "Lio/reactivex/subjects/PublishSubject;", "getDeviceClickPublisher", "()Lio/reactivex/subjects/PublishSubject;", "deviceClickPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "adapter", "Lcom/blueair/android/adapter/SmartIntegrationDevicesAdapter;", "getAdapter", "()Lcom/blueair/android/adapter/SmartIntegrationDevicesAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "configured", "", "Lcom/blueair/android/fragment/integration/IotDeviceConfig;", "onCreateDialog", "Landroid/app/Dialog;", "onStart", "onResume", "onStop", "showProgress", "shouldShowProgress", "", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SmartIntegrationsDialogFragment.kt */
public final class SmartIntegrationsDialogFragment extends BaseDialogFragment<HomeViewModel> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SmartIntegrationsDialogFragment.class, "deviceClickPublisher", "getDeviceClickPublisher()Lio/reactivex/subjects/PublishSubject;", 0))};
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String SMART_INTEGRATION_NAME = "smart_integration_name";
    private final Lazy adapter$delegate = LazyKt.lazy(new SmartIntegrationsDialogFragment$$ExternalSyntheticLambda1(this));
    private final LazyPublishSubject deviceClickPublisher$delegate = new LazyPublishSubject();
    private final String screenName = AnalyticEvent.ScreenViewEvent.SIDE_MENU_VOICE_ASSISTANT_ALEXA_OLD;
    private DialogfragmentSmartIntegrationsBinding viewDataBinding;
    public HomeViewModel viewModel;

    public void showProgress(boolean z) {
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
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

    private final PublishSubject<String> getDeviceClickPublisher() {
        return this.deviceClickPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final SmartIntegrationDevicesAdapter getAdapter() {
        return (SmartIntegrationDevicesAdapter) this.adapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final SmartIntegrationDevicesAdapter adapter_delegate$lambda$0(SmartIntegrationsDialogFragment smartIntegrationsDialogFragment) {
        return new SmartIntegrationDevicesAdapter(smartIntegrationsDialogFragment.getDeviceClickPublisher(), smartIntegrationsDialogFragment.getViewModel().isInG4ProtectRegion());
    }

    public void onViewCreated(View view, Bundle bundle) {
        Window window;
        WindowManager.LayoutParams attributes;
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null && (attributes = window.getAttributes()) != null) {
            attributes.windowAnimations = R.style.dialog_animation;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.DialogTheme);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        List<IotDeviceConfig> list;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogfragmentSmartIntegrationsBinding inflate = DialogfragmentSmartIntegrationsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.viewDataBinding = inflate;
        setViewModel((HomeViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(HomeViewModel.class)));
        Bundle arguments = getArguments();
        DialogfragmentSmartIntegrationsBinding dialogfragmentSmartIntegrationsBinding = null;
        String string = arguments != null ? arguments.getString(SMART_INTEGRATION_NAME) : null;
        if (string != null) {
            DialogfragmentSmartIntegrationsBinding dialogfragmentSmartIntegrationsBinding2 = this.viewDataBinding;
            if (dialogfragmentSmartIntegrationsBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentSmartIntegrationsBinding2 = null;
            }
            dialogfragmentSmartIntegrationsBinding2.toolbar.getMenu().findItem(com.blueair.devicedetails.R.id.action_close).setOnMenuItemClickListener(new SmartIntegrationsDialogFragment$$ExternalSyntheticLambda2(this));
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
            Resources resources = getResources();
            int i = com.blueair.devicedetails.R.drawable.item_decoration;
            FragmentActivity activity = getActivity();
            Drawable drawable = ResourcesCompat.getDrawable(resources, i, activity != null ? activity.getTheme() : null);
            if (drawable != null) {
                dividerItemDecoration.setDrawable(drawable);
            }
            DialogfragmentSmartIntegrationsBinding dialogfragmentSmartIntegrationsBinding3 = this.viewDataBinding;
            if (dialogfragmentSmartIntegrationsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentSmartIntegrationsBinding3 = null;
            }
            dialogfragmentSmartIntegrationsBinding3.recyclerViewDevices.setAdapter(getAdapter());
            SmartIntegrationDevicesAdapter adapter = getAdapter();
            if (Intrinsics.areEqual((Object) string, (Object) Integration.AmazonAlexaOld.getIntegrationName())) {
                list = configured(Integration.AmazonAlexaOld.getDevices());
            } else if (Intrinsics.areEqual((Object) string, (Object) Integration.Tmall.getIntegrationName())) {
                list = configured(Integration.Tmall.getDevices());
            } else {
                list = configured(Integration.GoogleAssistant.getDevices());
            }
            adapter.setDevices(list);
            DialogfragmentSmartIntegrationsBinding dialogfragmentSmartIntegrationsBinding4 = this.viewDataBinding;
            if (dialogfragmentSmartIntegrationsBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentSmartIntegrationsBinding4 = null;
            }
            dialogfragmentSmartIntegrationsBinding4.recyclerViewDevices.addItemDecoration(dividerItemDecoration);
            DialogfragmentSmartIntegrationsBinding dialogfragmentSmartIntegrationsBinding5 = this.viewDataBinding;
            if (dialogfragmentSmartIntegrationsBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogfragmentSmartIntegrationsBinding = dialogfragmentSmartIntegrationsBinding5;
            }
            View root = dialogfragmentSmartIntegrationsBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            return root;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    public static final boolean onCreateView$lambda$1(SmartIntegrationsDialogFragment smartIntegrationsDialogFragment, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "it");
        smartIntegrationsDialogFragment.dismiss();
        return true;
    }

    private final List<IotDeviceConfig> configured(List<IotDeviceConfig> list) {
        List<IotDeviceConfig> mutableList = CollectionsKt.toMutableList(list);
        CollectionsKt.removeAll(mutableList, new SmartIntegrationsDialogFragment$$ExternalSyntheticLambda0(this));
        return mutableList;
    }

    /* access modifiers changed from: private */
    public static final boolean configured$lambda$4$lambda$3(SmartIntegrationsDialogFragment smartIntegrationsDialogFragment, IotDeviceConfig iotDeviceConfig) {
        Intrinsics.checkNotNullParameter(iotDeviceConfig, "it");
        if (smartIntegrationsDialogFragment.getViewModel().isInB4Region() || iotDeviceConfig.getNameRes() != R.string.blueair_b4) {
            return !smartIntegrationsDialogFragment.getViewModel().isInG4Region() && iotDeviceConfig.getNameRes() == R.string.blueair_g4;
        }
        return true;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Window window;
        Timber.Forest.d("DialogFragment: onCreateDialog", new Object[0]);
        Dialog dialog = new Dialog(requireContext());
        Timber.Forest forest = Timber.Forest;
        forest.d("onCreateDialog: dialog = " + dialog, new Object[0]);
        FragmentActivity activity = getActivity();
        if (!(activity == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(ContextCompat.getDrawable(activity, R.drawable.top_rounded_rectangle_white));
        }
        return dialog;
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setLayout(-1, -2);
            }
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setGravity(80);
            }
        }
    }

    public void onResume() {
        super.onResume();
        getRxSubs().add(RxExtensionsKt.subscribeAndLogE(getDeviceClickPublisher(), new SmartIntegrationsDialogFragment$$ExternalSyntheticLambda3(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$7(SmartIntegrationsDialogFragment smartIntegrationsDialogFragment, String str) {
        smartIntegrationsDialogFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        return Unit.INSTANCE;
    }

    public void onStop() {
        Window window;
        WindowManager.LayoutParams attributes;
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null || (attributes = window.getAttributes()) == null)) {
            attributes.windowAnimations = R.style.dialog_animation_exit_only;
        }
        super.onStop();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/blueair/android/dialog/SmartIntegrationsDialogFragment$Companion;", "", "<init>", "()V", "SMART_INTEGRATION_NAME", "", "newInstance", "Lcom/blueair/android/dialog/SmartIntegrationsDialogFragment;", "smartIntegrationName", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SmartIntegrationsDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SmartIntegrationsDialogFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "smartIntegrationName");
            SmartIntegrationsDialogFragment smartIntegrationsDialogFragment = new SmartIntegrationsDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString(SmartIntegrationsDialogFragment.SMART_INTEGRATION_NAME, str);
            smartIntegrationsDialogFragment.setArguments(bundle);
            return smartIntegrationsDialogFragment;
        }
    }
}
