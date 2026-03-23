package com.blueair.devicedetails.dialog;

import android.app.Dialog;
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
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.devicedetails.databinding.DialogDeleteScheduleBinding;
import com.blueair.devicedetails.viewholder.DeletableItem;
import com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeleteScheduleDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogDeleteScheduleBinding;", "scheduleAdapter", "Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "Lcom/blueair/devicedetails/viewholder/DeletableItem;", "Lcom/blueair/core/model/DeviceScheduleMerged;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;)V", "defName", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onViewCreated", "view", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeleteScheduleDialogFragment.kt */
public final class DeleteScheduleDialogFragment extends BaseDialogFragment<DeviceSchedulesViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public String defName;
    /* access modifiers changed from: private */
    public ItemAdapter<DeletableItem<DeviceScheduleMerged>> scheduleAdapter;
    private final String screenName;
    private DialogDeleteScheduleBinding viewDataBinding;
    public DeviceSchedulesViewModel viewModel;

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeleteScheduleDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeleteScheduleDialogFragment;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeleteScheduleDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeleteScheduleDialogFragment newInstance() {
            return new DeleteScheduleDialogFragment();
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public DeviceSchedulesViewModel getViewModel() {
        DeviceSchedulesViewModel deviceSchedulesViewModel = this.viewModel;
        if (deviceSchedulesViewModel != null) {
            return deviceSchedulesViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(DeviceSchedulesViewModel deviceSchedulesViewModel) {
        Intrinsics.checkNotNullParameter(deviceSchedulesViewModel, "<set-?>");
        this.viewModel = deviceSchedulesViewModel;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogDeleteScheduleBinding inflate = DialogDeleteScheduleBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.viewDataBinding = inflate;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        setViewModel((DeviceSchedulesViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(DeviceSchedulesViewModel.class)));
        DialogDeleteScheduleBinding dialogDeleteScheduleBinding = this.viewDataBinding;
        if (dialogDeleteScheduleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogDeleteScheduleBinding = null;
        }
        ShadowLayout root = dialogDeleteScheduleBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.clearFlags(2);
            window.setBackgroundDrawableResource(R.color.transparent);
            int dpToPx = (int) TypedValueCompat.dpToPx(2.0f, getResources().getDisplayMetrics());
            window.getDecorView().setPaddingRelative(0, dpToPx, dpToPx * 6, 0);
            window.setDimAmount(0.0f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 8388661;
            attributes.width = (int) TypedValueCompat.dpToPx(262.0f, getResources().getDisplayMetrics());
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        String string = getString(R.string.schedule_default_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.defName = string;
        DialogDeleteScheduleBinding dialogDeleteScheduleBinding = this.viewDataBinding;
        DialogDeleteScheduleBinding dialogDeleteScheduleBinding2 = null;
        if (dialogDeleteScheduleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogDeleteScheduleBinding = null;
        }
        dialogDeleteScheduleBinding.rvList.setHasFixedSize(true);
        ItemAdapter<DeletableItem<DeviceScheduleMerged>> itemAdapter = new ItemAdapter<>();
        List value = getViewModel().getSchedules().getValue();
        if (value != null) {
            Iterable<DeviceScheduleMerged> iterable = value;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (DeviceScheduleMerged deviceScheduleMerged : iterable) {
                CharSequence name = deviceScheduleMerged.getName();
                if (StringsKt.isBlank(name) && (name = this.defName) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("defName");
                    name = null;
                }
                arrayList.add(new DeletableItem((String) name, deviceScheduleMerged, false, 4, (DefaultConstructorMarker) null));
            }
            itemAdapter.set((List) arrayList);
        }
        this.scheduleAdapter = itemAdapter;
        DialogDeleteScheduleBinding dialogDeleteScheduleBinding3 = this.viewDataBinding;
        if (dialogDeleteScheduleBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogDeleteScheduleBinding3 = null;
        }
        RecyclerView recyclerView = dialogDeleteScheduleBinding3.rvList;
        FastAdapter.Companion companion = FastAdapter.Companion;
        ItemAdapter<DeletableItem<DeviceScheduleMerged>> itemAdapter2 = this.scheduleAdapter;
        if (itemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleAdapter");
            itemAdapter2 = null;
        }
        FastAdapter with = companion.with(itemAdapter2);
        with.setOnClickListener(new DeleteScheduleDialogFragment$$ExternalSyntheticLambda0(this));
        recyclerView.setAdapter(with);
        DialogDeleteScheduleBinding dialogDeleteScheduleBinding4 = this.viewDataBinding;
        if (dialogDeleteScheduleBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            dialogDeleteScheduleBinding2 = dialogDeleteScheduleBinding4;
        }
        AppCompatEditText appCompatEditText = dialogDeleteScheduleBinding2.etName;
        Intrinsics.checkNotNullExpressionValue(appCompatEditText, "etName");
        appCompatEditText.addTextChangedListener(new DeleteScheduleDialogFragment$onViewCreated$$inlined$addTextChangedListener$default$1(this));
    }

    /* access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$8$lambda$7(DeleteScheduleDialogFragment deleteScheduleDialogFragment, View view, IAdapter iAdapter, DeletableItem deletableItem, int i) {
        DeletableItem deletableItem2 = deletableItem;
        Intrinsics.checkNotNullParameter(iAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(deletableItem2, "item");
        FragmentManager childFragmentManager = deleteScheduleDialogFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
        if ((childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) || childFragmentManager.isStateSaved()) {
            return true;
        }
        ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.confirm_delete_schedule, (Integer) null, R.string.delete_schedule_content, Integer.valueOf(R.string.confirm), Integer.valueOf(R.string.btn_cancel), false, false, false, false, (String[]) null, (String) null, new DeleteScheduleDialogFragment$$ExternalSyntheticLambda1(deleteScheduleDialogFragment, deletableItem2), 1888, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
        return true;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$8$lambda$7$lambda$6$lambda$5(DeleteScheduleDialogFragment deleteScheduleDialogFragment, DeletableItem deletableItem, boolean z) {
        if (z) {
            deleteScheduleDialogFragment.dismissAllowingStateLoss();
            Job unused = BuildersKt__Builders_commonKt.launch$default(deleteScheduleDialogFragment.getViewModel(), (CoroutineContext) null, (CoroutineStart) null, new DeleteScheduleDialogFragment$onViewCreated$2$1$1$1$1(deleteScheduleDialogFragment, deletableItem, (Continuation<? super DeleteScheduleDialogFragment$onViewCreated$2$1$1$1$1>) null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }
}
