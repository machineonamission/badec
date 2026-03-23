package com.blueair.outdoor.ui.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.HasLocation;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.databinding.DialogAssignProductBinding;
import com.blueair.outdoor.ui.adapters.DeviceAdapter;
import com.blueair.outdoor.ui.viewmodels.MapsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/blueair/outdoor/ui/dialog/AssignProductDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/outdoor/databinding/DialogAssignProductBinding;", "viewModel", "getViewModel", "()Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel;", "setViewModel", "(Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel;)V", "adapter", "Lcom/blueair/outdoor/ui/adapters/DeviceAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "showProgress", "shouldShowProgress", "", "Companion", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AssignProductDialogFragment.kt */
public final class AssignProductDialogFragment extends BaseDialogFragment<MapsViewModel> {
    private static final String ARG_DEVICES = "ARG_DEVICES";
    private static final String ARG_LOCATION = "ARG_LOCATION";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final DeviceAdapter adapter = new DeviceAdapter();
    private DialogAssignProductBinding binding;
    private final String screenName = AnalyticEvent.ScreenViewEvent.OUTDOOR_MAP_ASSIGN_PRODUCTS;
    public MapsViewModel viewModel;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/blueair/outdoor/ui/dialog/AssignProductDialogFragment$Companion;", "", "<init>", "()V", "ARG_LOCATION", "", "ARG_DEVICES", "newInstance", "Lcom/blueair/outdoor/ui/dialog/AssignProductDialogFragment;", "location", "Lcom/blueair/core/model/TrackedLocation;", "devices", "", "Lcom/blueair/core/model/HasLocation;", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AssignProductDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AssignProductDialogFragment newInstance(TrackedLocation trackedLocation, List<? extends HasLocation> list) {
            Intrinsics.checkNotNullParameter(trackedLocation, "location");
            Intrinsics.checkNotNullParameter(list, "devices");
            AssignProductDialogFragment assignProductDialogFragment = new AssignProductDialogFragment();
            assignProductDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(AssignProductDialogFragment.ARG_LOCATION, trackedLocation), TuplesKt.to(AssignProductDialogFragment.ARG_DEVICES, list.toArray(new HasLocation[0]))));
            return assignProductDialogFragment;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public MapsViewModel getViewModel() {
        MapsViewModel mapsViewModel = this.viewModel;
        if (mapsViewModel != null) {
            return mapsViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(MapsViewModel mapsViewModel) {
        Intrinsics.checkNotNullParameter(mapsViewModel, "<set-?>");
        this.viewModel = mapsViewModel;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            setStyle(0, R.style.DialogTheme);
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setBackgroundDrawable(new ColorDrawable(0));
            }
            Dialog dialog2 = getDialog();
            if (!(dialog2 == null || (window = dialog2.getWindow()) == null)) {
                window.setWindowAnimations(R.style.dialog_animation);
            }
        }
        DialogAssignProductBinding inflate = DialogAssignProductBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        setViewModel((MapsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(MapsViewModel.class)));
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Bundle requireArguments = requireArguments();
        T parcelable = requireArguments.getParcelable(ARG_LOCATION);
        Intrinsics.checkNotNull(parcelable);
        objectRef.element = parcelable;
        Parcelable[] parcelableArray = requireArguments.getParcelableArray(ARG_DEVICES);
        Intrinsics.checkNotNull(parcelableArray, "null cannot be cast to non-null type kotlin.Array<com.blueair.core.model.HasLocation>");
        objectRef2.element = (HasLocation[]) parcelableArray;
        DialogAssignProductBinding dialogAssignProductBinding = this.binding;
        DialogAssignProductBinding dialogAssignProductBinding2 = null;
        if (dialogAssignProductBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAssignProductBinding = null;
        }
        dialogAssignProductBinding.btnClose.setOnClickListener(new AssignProductDialogFragment$$ExternalSyntheticLambda0(this));
        DialogAssignProductBinding dialogAssignProductBinding3 = this.binding;
        if (dialogAssignProductBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAssignProductBinding3 = null;
        }
        dialogAssignProductBinding3.locationName.setText(((TrackedLocation) objectRef.element).getLocationName());
        DialogAssignProductBinding dialogAssignProductBinding4 = this.binding;
        if (dialogAssignProductBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAssignProductBinding4 = null;
        }
        dialogAssignProductBinding4.deviceList.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        DialogAssignProductBinding dialogAssignProductBinding5 = this.binding;
        if (dialogAssignProductBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAssignProductBinding5 = null;
        }
        dialogAssignProductBinding5.deviceList.setAdapter(this.adapter);
        LifecycleOwner lifecycleOwner = this;
        this.adapter.getSelectionModified().observe(lifecycleOwner, new AssignProductDialogFragment$sam$androidx_lifecycle_Observer$0(new AssignProductDialogFragment$$ExternalSyntheticLambda1(this)));
        DialogAssignProductBinding dialogAssignProductBinding6 = this.binding;
        if (dialogAssignProductBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAssignProductBinding6 = null;
        }
        dialogAssignProductBinding6.btnAssign.setOnClickListener(new AssignProductDialogFragment$$ExternalSyntheticLambda2(this, objectRef));
        showProgress(true);
        getViewModel().getDevices().observe(lifecycleOwner, new AssignProductDialogFragment$sam$androidx_lifecycle_Observer$0(new AssignProductDialogFragment$$ExternalSyntheticLambda3(this, objectRef, objectRef2)));
        DialogAssignProductBinding dialogAssignProductBinding7 = this.binding;
        if (dialogAssignProductBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogAssignProductBinding2 = dialogAssignProductBinding7;
        }
        LinearLayout root = dialogAssignProductBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$2(AssignProductDialogFragment assignProductDialogFragment, View view) {
        assignProductDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$3(AssignProductDialogFragment assignProductDialogFragment, Boolean bool) {
        DialogAssignProductBinding dialogAssignProductBinding = assignProductDialogFragment.binding;
        if (dialogAssignProductBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAssignProductBinding = null;
        }
        MaterialButton materialButton = dialogAssignProductBinding.btnAssign;
        Intrinsics.checkNotNull(bool);
        materialButton.setEnabled(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$5(AssignProductDialogFragment assignProductDialogFragment, Ref.ObjectRef objectRef, View view) {
        assignProductDialogFragment.showProgress(true);
        Map<String, Boolean> originalSelections = assignProductDialogFragment.adapter.getOriginalSelections();
        Map<String, Boolean> selections = assignProductDialogFragment.adapter.getSelections();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (Map.Entry next : selections.entrySet()) {
            String str = (String) next.getKey();
            Boolean bool = (Boolean) next.getValue();
            boolean booleanValue = bool.booleanValue();
            if (!Intrinsics.areEqual((Object) bool, (Object) originalSelections.get(str))) {
                if (booleanValue) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            }
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(assignProductDialogFragment.getViewModel(), Dispatchers.getIO(), (CoroutineStart) null, new AssignProductDialogFragment$onCreateView$5$2(assignProductDialogFragment, objectRef, arrayList, arrayList2, (Continuation<? super AssignProductDialogFragment$onCreateView$5$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$6(AssignProductDialogFragment assignProductDialogFragment, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, List list) {
        assignProductDialogFragment.getViewModel().getDevices().removeObservers(assignProductDialogFragment);
        Intrinsics.checkNotNull(list);
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof HasLocation) {
                arrayList.add(next);
            }
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(assignProductDialogFragment.getViewModel(), Dispatchers.getIO(), (CoroutineStart) null, new AssignProductDialogFragment$onCreateView$6$1(assignProductDialogFragment, objectRef, objectRef2, (List) arrayList, (Continuation<? super AssignProductDialogFragment$onCreateView$6$1>) null), 2, (Object) null);
        return Unit.INSTANCE;
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }

    public void showProgress(boolean z) {
        DialogAssignProductBinding dialogAssignProductBinding = this.binding;
        if (dialogAssignProductBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogAssignProductBinding = null;
        }
        ProgressBlockerView progressBlockerView = dialogAssignProductBinding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        ViewExtensionsKt.show(progressBlockerView, z);
    }
}
