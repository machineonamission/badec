package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.Filter;
import com.blueair.core.model.FilterKt;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.devicedetails.adapter.FilterPagerAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceFilterSelectionBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsState;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.fragment.BaseFragmentInterface;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.ScrollingPageIndicatorAccessibilityDelegate;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;
import timber.log.Timber;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001?B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0017J\u0012\u0010.\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010/\u001a\u00020+H\u0016J\b\u00100\u001a\u00020+H\u0016J\u0012\u00101\u001a\u0002022\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J$\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u00109\u001a\u00020+2\u0006\u0010:\u001a\u0002042\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020+H\u0002R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006@"}, d2 = {"Lcom/blueair/devicedetails/dialog/FilterSelectionDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceFilterSelectionBinding;", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "pagerAdapter", "Lcom/blueair/devicedetails/adapter/FilterPagerAdapter;", "getPagerAdapter", "()Lcom/blueair/devicedetails/adapter/FilterPagerAdapter;", "pagerAdapter$delegate", "Lkotlin/Lazy;", "toolbarTitleView", "Landroid/widget/TextView;", "getToolbarTitleView", "()Landroid/widget/TextView;", "toolbarTitleView$delegate", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onStart", "onStop", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "showProgress", "shouldShowProgress", "", "bindViewModel", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FilterSelectionDialogFragment.kt */
public final class FilterSelectionDialogFragment extends BaseDialogFragment<DeviceDetailsViewModel> implements ProgressFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Device device;
    private final Lazy pagerAdapter$delegate = LazyKt.lazy(new FilterSelectionDialogFragment$$ExternalSyntheticLambda2(this));
    private ProgressBlockerView progressBlockerView;
    private final String screenName;
    private final Lazy toolbarTitleView$delegate = LazyKt.lazy(new FilterSelectionDialogFragment$$ExternalSyntheticLambda3(this));
    /* access modifiers changed from: private */
    public DialogfragmentDeviceFilterSelectionBinding viewDataBinding;
    public DeviceDetailsViewModel viewModel;

    public void clearProgressFragment() {
        ProgressFragment.CC.$default$clearProgressFragment(this);
    }

    public void hideProgress(Context context) {
        ProgressFragment.CC.$default$hideProgress(this, context);
    }

    public void showProgress(Context context, boolean z, Integer num) {
        ProgressFragment.CC.$default$showProgress(this, context, z, num);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/dialog/FilterSelectionDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/FilterSelectionDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: FilterSelectionDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FilterSelectionDialogFragment newInstance(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            FilterSelectionDialogFragment filterSelectionDialogFragment = new FilterSelectionDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("device", device);
            filterSelectionDialogFragment.setArguments(bundle);
            return filterSelectionDialogFragment;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public DeviceDetailsViewModel getViewModel() {
        DeviceDetailsViewModel deviceDetailsViewModel = this.viewModel;
        if (deviceDetailsViewModel != null) {
            return deviceDetailsViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(DeviceDetailsViewModel deviceDetailsViewModel) {
        Intrinsics.checkNotNullParameter(deviceDetailsViewModel, "<set-?>");
        this.viewModel = deviceDetailsViewModel;
    }

    public final Device getDevice() {
        Device device2 = this.device;
        if (device2 != null) {
            return device2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("device");
        return null;
    }

    public final void setDevice(Device device2) {
        Intrinsics.checkNotNullParameter(device2, "<set-?>");
        this.device = device2;
    }

    /* access modifiers changed from: private */
    public final FilterPagerAdapter getPagerAdapter() {
        return (FilterPagerAdapter) this.pagerAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final FilterPagerAdapter pagerAdapter_delegate$lambda$0(FilterSelectionDialogFragment filterSelectionDialogFragment) {
        return new FilterPagerAdapter(filterSelectionDialogFragment);
    }

    public final TextView getToolbarTitleView() {
        return (TextView) this.toolbarTitleView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final TextView toolbarTitleView_delegate$lambda$1(FilterSelectionDialogFragment filterSelectionDialogFragment) {
        DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding = filterSelectionDialogFragment.viewDataBinding;
        if (dialogfragmentDeviceFilterSelectionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceFilterSelectionBinding = null;
        }
        TextView textView = dialogfragmentDeviceFilterSelectionBinding.title;
        Intrinsics.checkNotNullExpressionValue(textView, "title");
        return textView;
    }

    public ProgressBlockerView getProgressBlockerView() {
        return this.progressBlockerView;
    }

    public void setProgressBlockerView(ProgressBlockerView progressBlockerView2) {
        this.progressBlockerView = progressBlockerView2;
    }

    public ConstraintLayout getRootView() {
        DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding = this.viewDataBinding;
        if (dialogfragmentDeviceFilterSelectionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceFilterSelectionBinding = null;
        }
        ConstraintLayout constraintLayout = dialogfragmentDeviceFilterSelectionBinding.pagerRootLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "pagerRootLayout");
        return constraintLayout;
    }

    @Deprecated(message = "Deprecated in Java")
    public void onActivityCreated(Bundle bundle) {
        Window window;
        WindowManager.LayoutParams attributes;
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null && (attributes = window.getAttributes()) != null) {
            attributes.windowAnimations = R.style.dialog_animation;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.DialogTheme);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r2 = r2.getWindowManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStart() {
        /*
            r3 = this;
            super.onStart()
            android.app.Dialog r0 = r3.getDialog()
            if (r0 == 0) goto L_0x003a
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            android.view.Window r2 = r0.getWindow()
            if (r2 == 0) goto L_0x001f
            android.view.WindowManager r2 = r2.getWindowManager()
            if (r2 == 0) goto L_0x001f
            android.view.Display r2 = r2.getDefaultDisplay()
            goto L_0x0020
        L_0x001f:
            r2 = 0
        L_0x0020:
            if (r2 == 0) goto L_0x0025
            r2.getSize(r1)
        L_0x0025:
            android.view.Window r1 = r0.getWindow()
            if (r1 == 0) goto L_0x002f
            r2 = -1
            r1.setLayout(r2, r2)
        L_0x002f:
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L_0x003a
            r1 = 80
            r0.setGravity(r1)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.dialog.FilterSelectionDialogFragment.onStart():void");
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

    public Dialog onCreateDialog(Bundle bundle) {
        Window window;
        Timber.Forest.d("DialogFragment: onCreateDialog", new Object[0]);
        Dialog dialog = new Dialog(requireContext());
        Bundle arguments = getArguments();
        Device device2 = arguments != null ? (Device) arguments.getParcelable("device") : null;
        if (device2 != null) {
            setDevice(device2);
            Timber.Forest forest = Timber.Forest;
            forest.d("onCreateDialog: dialog = " + dialog, new Object[0]);
            FragmentActivity activity = getActivity();
            if (!(activity == null || (window = dialog.getWindow()) == null)) {
                window.setBackgroundDrawable(ContextCompat.getDrawable(activity, R.drawable.top_rounded_rectangle_white));
            }
            return dialog;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogfragmentDeviceFilterSelectionBinding inflate = DialogfragmentDeviceFilterSelectionBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.setDeviceDetailViewModel((DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DeviceDetailsViewModel.class)));
        inflate.setLifecycleOwner(this);
        this.viewDataBinding = inflate;
        DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            inflate = null;
        }
        DeviceDetailsViewModel deviceDetailViewModel = inflate.getDeviceDetailViewModel();
        if (deviceDetailViewModel != null) {
            setViewModel(deviceDetailViewModel);
            Timber.Forest.d("onViewCreated: viewModel = " + getViewModel() + ",  device = " + getDevice(), new Object[0]);
            getViewModel().setDevice(getDevice());
            DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding2 = this.viewDataBinding;
            if (dialogfragmentDeviceFilterSelectionBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceFilterSelectionBinding2 = null;
            }
            dialogfragmentDeviceFilterSelectionBinding2.toolbar.getMenu().findItem(com.blueair.devicedetails.R.id.action_close).setOnMenuItemClickListener(new FilterSelectionDialogFragment$$ExternalSyntheticLambda6(this));
            DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding3 = this.viewDataBinding;
            if (dialogfragmentDeviceFilterSelectionBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceFilterSelectionBinding3 = null;
            }
            dialogfragmentDeviceFilterSelectionBinding3.filterPager.setAdapter(getPagerAdapter());
            DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding4 = this.viewDataBinding;
            if (dialogfragmentDeviceFilterSelectionBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceFilterSelectionBinding4 = null;
            }
            dialogfragmentDeviceFilterSelectionBinding4.filterPager.registerOnPageChangeCallback(new FilterSelectionDialogFragment$onCreateView$3(this));
            DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding5 = this.viewDataBinding;
            if (dialogfragmentDeviceFilterSelectionBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceFilterSelectionBinding5 = null;
            }
            dialogfragmentDeviceFilterSelectionBinding5.btnLeft.setOnClickListener(new FilterSelectionDialogFragment$$ExternalSyntheticLambda7(this));
            DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding6 = this.viewDataBinding;
            if (dialogfragmentDeviceFilterSelectionBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceFilterSelectionBinding6 = null;
            }
            dialogfragmentDeviceFilterSelectionBinding6.btnRight.setOnClickListener(new FilterSelectionDialogFragment$$ExternalSyntheticLambda8(this));
            DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding7 = this.viewDataBinding;
            if (dialogfragmentDeviceFilterSelectionBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceFilterSelectionBinding7 = null;
            }
            ScrollingPagerIndicator scrollingPagerIndicator = dialogfragmentDeviceFilterSelectionBinding7.dotsIndicator;
            DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding8 = this.viewDataBinding;
            if (dialogfragmentDeviceFilterSelectionBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceFilterSelectionBinding8 = null;
            }
            scrollingPagerIndicator.attachToPager(dialogfragmentDeviceFilterSelectionBinding8.filterPager);
            scrollingPagerIndicator.setFocusable(true);
            scrollingPagerIndicator.setFocusableInTouchMode(false);
            scrollingPagerIndicator.setScreenReaderFocusable(true);
            Intrinsics.checkNotNullExpressionValue(scrollingPagerIndicator, "apply(...)");
            ViewCompat.setAccessibilityDelegate(scrollingPagerIndicator, new ScrollingPageIndicatorAccessibilityDelegate(new FilterSelectionDialogFragment$$ExternalSyntheticLambda9(this), new FilterSelectionDialogFragment$$ExternalSyntheticLambda10(this)));
            DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding9 = this.viewDataBinding;
            if (dialogfragmentDeviceFilterSelectionBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceFilterSelectionBinding9 = null;
            }
            dialogfragmentDeviceFilterSelectionBinding9.buttonSave.setOnClickListener(new FilterSelectionDialogFragment$$ExternalSyntheticLambda1(this));
            DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding10 = this.viewDataBinding;
            if (dialogfragmentDeviceFilterSelectionBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogfragmentDeviceFilterSelectionBinding = dialogfragmentDeviceFilterSelectionBinding10;
            }
            View root = dialogfragmentDeviceFilterSelectionBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            return root;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    public static final boolean onCreateView$lambda$5(FilterSelectionDialogFragment filterSelectionDialogFragment, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "it");
        filterSelectionDialogFragment.dismiss();
        return true;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$6(FilterSelectionDialogFragment filterSelectionDialogFragment, View view) {
        DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding = filterSelectionDialogFragment.viewDataBinding;
        if (dialogfragmentDeviceFilterSelectionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceFilterSelectionBinding = null;
        }
        dialogfragmentDeviceFilterSelectionBinding.filterPager.setCurrentItem(0, true);
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$7(FilterSelectionDialogFragment filterSelectionDialogFragment, View view) {
        DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding = filterSelectionDialogFragment.viewDataBinding;
        if (dialogfragmentDeviceFilterSelectionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceFilterSelectionBinding = null;
        }
        dialogfragmentDeviceFilterSelectionBinding.filterPager.setCurrentItem(filterSelectionDialogFragment.getPagerAdapter().getItemCount() - 1, true);
    }

    /* access modifiers changed from: private */
    public static final int onCreateView$lambda$9(FilterSelectionDialogFragment filterSelectionDialogFragment) {
        DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding = filterSelectionDialogFragment.viewDataBinding;
        if (dialogfragmentDeviceFilterSelectionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceFilterSelectionBinding = null;
        }
        return dialogfragmentDeviceFilterSelectionBinding.filterPager.getCurrentItem() + 1;
    }

    /* access modifiers changed from: private */
    public static final int onCreateView$lambda$10(FilterSelectionDialogFragment filterSelectionDialogFragment) {
        DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding = filterSelectionDialogFragment.viewDataBinding;
        if (dialogfragmentDeviceFilterSelectionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceFilterSelectionBinding = null;
        }
        RecyclerView.Adapter adapter = dialogfragmentDeviceFilterSelectionBinding.filterPager.getAdapter();
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$11(FilterSelectionDialogFragment filterSelectionDialogFragment, View view) {
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("current item: ");
        DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding = filterSelectionDialogFragment.viewDataBinding;
        if (dialogfragmentDeviceFilterSelectionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceFilterSelectionBinding = null;
        }
        sb.append(dialogfragmentDeviceFilterSelectionBinding.filterPager.getCurrentItem());
        sb.append(" & filters in adapter: ");
        sb.append(filterSelectionDialogFragment.getPagerAdapter().getFilters());
        forest.d(sb.toString(), new Object[0]);
        if (!filterSelectionDialogFragment.getPagerAdapter().getFilters().isEmpty()) {
            BaseFragmentInterface.CC.showProgress$default(filterSelectionDialogFragment, false, 1, (Object) null);
            List<Filter> filters = filterSelectionDialogFragment.getPagerAdapter().getFilters();
            DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding2 = filterSelectionDialogFragment.viewDataBinding;
            if (dialogfragmentDeviceFilterSelectionBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceFilterSelectionBinding2 = null;
            }
            Filter filter = filters.get(dialogfragmentDeviceFilterSelectionBinding2.filterPager.getCurrentItem());
            Timber.Forest.d("selected filter: " + filter, new Object[0]);
            LifecycleOwner viewLifecycleOwner = filterSelectionDialogFragment.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getMain(), (CoroutineStart) null, new FilterSelectionDialogFragment$onCreateView$8$1(filterSelectionDialogFragment, filter, (Continuation<? super FilterSelectionDialogFragment$onCreateView$8$1>) null), 2, (Object) null);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        Timber.Forest forest = Timber.Forest;
        forest.d("onViewCreated: viewModel = " + getViewModel() + ",  device = " + getDevice(), new Object[0]);
        getViewModel().setDeviceId(getDevice().getUid());
        bindViewModel();
    }

    public void showProgress(boolean z) {
        ProgressFragment.CC.showProgress$default(this, getContext(), z, (Integer) null, 4, (Object) null);
    }

    private final void bindViewModel() {
        LiveData<DeviceDetailsState> deviceDetailsState = getViewModel().getDeviceDetailsState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(deviceDetailsState, viewLifecycleOwner, new FilterSelectionDialogFragment$$ExternalSyntheticLambda4(this));
        LiveData<Device> liveDevice = getViewModel().getLiveDevice();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(liveDevice, viewLifecycleOwner2, new FilterSelectionDialogFragment$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$13(FilterSelectionDialogFragment filterSelectionDialogFragment, DeviceDetailsState deviceDetailsState) {
        Intrinsics.checkNotNullParameter(deviceDetailsState, "state");
        Timber.Forest forest = Timber.Forest;
        forest.d("device state: " + deviceDetailsState, new Object[0]);
        filterSelectionDialogFragment.setDevice(deviceDetailsState.getDevice());
        Device device2 = filterSelectionDialogFragment.getDevice();
        if (device2 instanceof HasFanSpeed) {
            HasFanSpeed hasFanSpeed = (HasFanSpeed) device2;
            filterSelectionDialogFragment.getPagerAdapter().setDevice(hasFanSpeed);
            filterSelectionDialogFragment.getPagerAdapter().setFilters(FilterKt.getSupportedFilters(hasFanSpeed));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$14(FilterSelectionDialogFragment filterSelectionDialogFragment, Device device2) {
        Timber.Forest forest = Timber.Forest;
        forest.v("liveDevice = " + device2, new Object[0]);
        filterSelectionDialogFragment.getViewModel().setDevice(device2);
        return Unit.INSTANCE;
    }
}
