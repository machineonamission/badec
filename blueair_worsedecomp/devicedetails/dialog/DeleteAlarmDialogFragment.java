package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.util.TypedValueCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.HasAlarm;
import com.blueair.devicedetails.databinding.DialogDeleteAlarmBinding;
import com.blueair.devicedetails.viewholder.DeletableItem;
import com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.dd.ShadowLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u001a\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u001aH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeleteAlarmDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceAlarmsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogDeleteAlarmBinding;", "itemAdapter", "Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "Lcom/blueair/devicedetails/viewholder/DeletableItem;", "Lcom/blueair/core/model/DeviceAlarm;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceAlarmsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceAlarmsViewModel;)V", "defName", "originAlarms", "", "device", "Lcom/blueair/core/model/HasAlarm;", "searchable", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onViewCreated", "view", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeleteAlarmDialogFragment.kt */
public final class DeleteAlarmDialogFragment extends BaseDialogFragment<DeviceAlarmsViewModel> {
    private static final String ARG_SEARCHABLE = "ARG_SEARCHABLE";
    private static final String ARG_WINDOW_Y = "ARG_WINDOW_Y";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public String defName;
    /* access modifiers changed from: private */
    public HasAlarm device;
    /* access modifiers changed from: private */
    public ItemAdapter<DeletableItem<DeviceAlarm>> itemAdapter;
    /* access modifiers changed from: private */
    public List<DeviceAlarm> originAlarms;
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_DETAILS_ALARM_DELETE;
    /* access modifiers changed from: private */
    public boolean searchable;
    private DialogDeleteAlarmBinding viewDataBinding;
    public DeviceAlarmsViewModel viewModel;

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeleteAlarmDialogFragment$Companion;", "", "<init>", "()V", "ARG_SEARCHABLE", "", "ARG_WINDOW_Y", "newInstance", "Lcom/blueair/devicedetails/dialog/DeleteAlarmDialogFragment;", "device", "Lcom/blueair/core/model/HasAlarm;", "searchable", "", "anchorView", "Landroid/view/View;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeleteAlarmDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DeleteAlarmDialogFragment newInstance$default(Companion companion, HasAlarm hasAlarm, boolean z, View view, int i, Object obj) {
            if ((i & 4) != 0) {
                view = null;
            }
            return companion.newInstance(hasAlarm, z, view);
        }

        public final DeleteAlarmDialogFragment newInstance(HasAlarm hasAlarm, boolean z, View view) {
            Intrinsics.checkNotNullParameter(hasAlarm, "device");
            Bundle bundle = new Bundle();
            bundle.putParcelable("device", hasAlarm);
            bundle.putBoolean(DeleteAlarmDialogFragment.ARG_SEARCHABLE, z);
            if (view != null) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                bundle.putInt(DeleteAlarmDialogFragment.ARG_WINDOW_Y, iArr[1]);
            }
            DeleteAlarmDialogFragment deleteAlarmDialogFragment = new DeleteAlarmDialogFragment();
            deleteAlarmDialogFragment.setArguments(bundle);
            return deleteAlarmDialogFragment;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public DeviceAlarmsViewModel getViewModel() {
        DeviceAlarmsViewModel deviceAlarmsViewModel = this.viewModel;
        if (deviceAlarmsViewModel != null) {
            return deviceAlarmsViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(DeviceAlarmsViewModel deviceAlarmsViewModel) {
        Intrinsics.checkNotNullParameter(deviceAlarmsViewModel, "<set-?>");
        this.viewModel = deviceAlarmsViewModel;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogDeleteAlarmBinding inflate = DialogDeleteAlarmBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.viewDataBinding = inflate;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        setViewModel((DeviceAlarmsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(DeviceAlarmsViewModel.class)));
        DialogDeleteAlarmBinding dialogDeleteAlarmBinding = this.viewDataBinding;
        if (dialogDeleteAlarmBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogDeleteAlarmBinding = null;
        }
        ShadowLayout root = dialogDeleteAlarmBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onStart() {
        Window window;
        int i;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.clearFlags(2);
            window.setBackgroundDrawableResource(R.color.transparent);
            int dpToPx = (int) TypedValueCompat.dpToPx(4.0f, getResources().getDisplayMetrics());
            window.getDecorView().setPaddingRelative(0, dpToPx, dpToPx * 3, 0);
            window.setDimAmount(0.0f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 8388661;
            attributes.width = (int) TypedValueCompat.dpToPx(262.0f, getResources().getDisplayMetrics());
            attributes.height = -2;
            Bundle arguments = getArguments();
            if (arguments != null && (i = arguments.getInt(ARG_WINDOW_Y, 0)) > 0) {
                DialogUtils dialogUtils = DialogUtils.INSTANCE;
                Context context = window.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                attributes.y = RangesKt.coerceAtLeast(i - dialogUtils.getStatusBarHeight(context), 0);
            }
            window.setAttributes(attributes);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        String string = getString(R.string.alarm_default_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.defName = string;
        Bundle arguments = getArguments();
        DialogDeleteAlarmBinding dialogDeleteAlarmBinding = null;
        HasAlarm hasAlarm = arguments != null ? (HasAlarm) arguments.getParcelable("device") : null;
        if (hasAlarm != null) {
            this.device = hasAlarm;
            if (hasAlarm == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
                hasAlarm = null;
            }
            this.originAlarms = CollectionsKt.sortedWith(CollectionsKt.filterNotNull(hasAlarm.getAlarms()), new DeleteAlarmDialogFragment$onViewCreated$$inlined$sortedBy$1());
            Bundle arguments2 = getArguments();
            this.searchable = arguments2 != null ? arguments2.getBoolean(ARG_SEARCHABLE) : this.searchable;
            DialogDeleteAlarmBinding dialogDeleteAlarmBinding2 = this.viewDataBinding;
            if (dialogDeleteAlarmBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogDeleteAlarmBinding2 = null;
            }
            AppCompatEditText appCompatEditText = dialogDeleteAlarmBinding2.etName;
            Intrinsics.checkNotNullExpressionValue(appCompatEditText, "etName");
            appCompatEditText.setVisibility(this.searchable ? 0 : 8);
            DialogDeleteAlarmBinding dialogDeleteAlarmBinding3 = this.viewDataBinding;
            if (dialogDeleteAlarmBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogDeleteAlarmBinding3 = null;
            }
            dialogDeleteAlarmBinding3.rvList.setHasFixedSize(true);
            ItemAdapter<DeletableItem<DeviceAlarm>> itemAdapter2 = new ItemAdapter<>();
            List<DeviceAlarm> list = this.originAlarms;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("originAlarms");
                list = null;
            }
            Iterable<DeviceAlarm> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (DeviceAlarm deviceAlarm : iterable) {
                CharSequence name = deviceAlarm.getName();
                if (StringsKt.isBlank(name) && (name = this.defName) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("defName");
                    name = null;
                }
                arrayList.add(new DeletableItem((String) name, deviceAlarm, !this.searchable));
            }
            itemAdapter2.set((List) arrayList);
            this.itemAdapter = itemAdapter2;
            DialogDeleteAlarmBinding dialogDeleteAlarmBinding4 = this.viewDataBinding;
            if (dialogDeleteAlarmBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogDeleteAlarmBinding4 = null;
            }
            RecyclerView recyclerView = dialogDeleteAlarmBinding4.rvList;
            FastAdapter.Companion companion = FastAdapter.Companion;
            ItemAdapter<DeletableItem<DeviceAlarm>> itemAdapter3 = this.itemAdapter;
            if (itemAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
                itemAdapter3 = null;
            }
            FastAdapter with = companion.with(itemAdapter3);
            with.setOnClickListener(new DeleteAlarmDialogFragment$$ExternalSyntheticLambda1(this));
            recyclerView.setAdapter(with);
            DialogDeleteAlarmBinding dialogDeleteAlarmBinding5 = this.viewDataBinding;
            if (dialogDeleteAlarmBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogDeleteAlarmBinding = dialogDeleteAlarmBinding5;
            }
            AppCompatEditText appCompatEditText2 = dialogDeleteAlarmBinding.etName;
            Intrinsics.checkNotNullExpressionValue(appCompatEditText2, "etName");
            appCompatEditText2.addTextChangedListener(new DeleteAlarmDialogFragment$onViewCreated$$inlined$addTextChangedListener$default$1(this));
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$9$lambda$8(DeleteAlarmDialogFragment deleteAlarmDialogFragment, View view, IAdapter iAdapter, DeletableItem deletableItem, int i) {
        DeleteAlarmDialogFragment deleteAlarmDialogFragment2 = deleteAlarmDialogFragment;
        DeletableItem deletableItem2 = deletableItem;
        Intrinsics.checkNotNullParameter(iAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(deletableItem2, "item");
        FragmentManager childFragmentManager = deleteAlarmDialogFragment2.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.delete_schedule_content, (Integer) null, 0, Integer.valueOf(R.string.confirm), Integer.valueOf(R.string.btn_cancel), false, false, false, false, (String[]) null, deleteAlarmDialogFragment2.getString(R.string.delete_confirmation_content, deletableItem2.getName()), new DeleteAlarmDialogFragment$$ExternalSyntheticLambda0(deleteAlarmDialogFragment2, deletableItem2), 864, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$9$lambda$8$lambda$7$lambda$6(DeleteAlarmDialogFragment deleteAlarmDialogFragment, DeletableItem deletableItem, boolean z) {
        if (z) {
            deleteAlarmDialogFragment.dismissAllowingStateLoss();
            Job unused = BuildersKt__Builders_commonKt.launch$default(deleteAlarmDialogFragment.getViewModel(), (CoroutineContext) null, (CoroutineStart) null, new DeleteAlarmDialogFragment$onViewCreated$3$1$1$1$1(deleteAlarmDialogFragment, deletableItem, (Continuation<? super DeleteAlarmDialogFragment$onViewCreated$3$1$1$1$1>) null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }
}
