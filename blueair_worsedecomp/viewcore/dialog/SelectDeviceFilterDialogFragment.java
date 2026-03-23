package com.blueair.viewcore.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blueair.core.model.FilterInfo;
import com.blueair.viewcore.R;
import com.blueair.viewcore.adapter.DeviceFilterAdapter;
import com.blueair.viewcore.databinding.DialogfragmentSelectDeviceFilterBinding;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020\u000fH\u0016J\b\u0010%\u001a\u00020\u000fH\u0016J\b\u0010&\u001a\u00020\u000fH\u0016J\b\u0010'\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, d2 = {"Lcom/blueair/viewcore/dialog/SelectDeviceFilterDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/blueair/viewcore/databinding/DialogfragmentSelectDeviceFilterBinding;", "filterAdapter", "Lcom/blueair/viewcore/adapter/DeviceFilterAdapter;", "getFilterAdapter", "()Lcom/blueair/viewcore/adapter/DeviceFilterAdapter;", "filterAdapter$delegate", "Lkotlin/Lazy;", "onFilterSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FilterInfo;", "", "title", "", "getTitle", "()Ljava/lang/String;", "title$delegate", "filters", "", "getFilters", "()Ljava/util/List;", "filters$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onStart", "onResume", "onPause", "refreshFilterScrollIndicators", "Companion", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SelectDeviceFilterDialogFragment.kt */
public final class SelectDeviceFilterDialogFragment extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_FILTERS = "EXTRA_FILTERS";
    private static final String EXTRA_TITLE = "EXTRA_TITLE";
    private DialogfragmentSelectDeviceFilterBinding binding;
    private final Lazy filterAdapter$delegate = LazyKt.lazy(new SelectDeviceFilterDialogFragment$$ExternalSyntheticLambda1(this));
    private final Lazy filters$delegate = LazyKt.lazy(new SelectDeviceFilterDialogFragment$$ExternalSyntheticLambda3(this));
    /* access modifiers changed from: private */
    public Function1<? super FilterInfo, Unit> onFilterSelectedListener;
    private final Lazy title$delegate = LazyKt.lazy(new SelectDeviceFilterDialogFragment$$ExternalSyntheticLambda2(this));

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000eR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/blueair/viewcore/dialog/SelectDeviceFilterDialogFragment$Companion;", "", "<init>", "()V", "EXTRA_TITLE", "", "EXTRA_FILTERS", "newInstance", "Lcom/blueair/viewcore/dialog/SelectDeviceFilterDialogFragment;", "title", "filters", "", "Lcom/blueair/core/model/FilterInfo;", "onFilterSelectedListener", "Lkotlin/Function1;", "", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SelectDeviceFilterDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SelectDeviceFilterDialogFragment newInstance(String str, List<FilterInfo> list, Function1<? super FilterInfo, Unit> function1) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, "filters");
            Intrinsics.checkNotNullParameter(function1, "onFilterSelectedListener");
            SelectDeviceFilterDialogFragment selectDeviceFilterDialogFragment = new SelectDeviceFilterDialogFragment();
            selectDeviceFilterDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(SelectDeviceFilterDialogFragment.EXTRA_TITLE, str), TuplesKt.to(SelectDeviceFilterDialogFragment.EXTRA_FILTERS, list.toArray(new FilterInfo[0]))));
            selectDeviceFilterDialogFragment.onFilterSelectedListener = function1;
            return selectDeviceFilterDialogFragment;
        }
    }

    /* access modifiers changed from: private */
    public static final DeviceFilterAdapter filterAdapter_delegate$lambda$0(SelectDeviceFilterDialogFragment selectDeviceFilterDialogFragment) {
        return new DeviceFilterAdapter(selectDeviceFilterDialogFragment.onFilterSelectedListener);
    }

    private final DeviceFilterAdapter getFilterAdapter() {
        return (DeviceFilterAdapter) this.filterAdapter$delegate.getValue();
    }

    private final String getTitle() {
        return (String) this.title$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final String title_delegate$lambda$1(SelectDeviceFilterDialogFragment selectDeviceFilterDialogFragment) {
        String string = selectDeviceFilterDialogFragment.requireArguments().getString(EXTRA_TITLE);
        if (string != null) {
            return string;
        }
        String string2 = selectDeviceFilterDialogFragment.getString(R.string.select_filter);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    private final List<FilterInfo> getFilters() {
        return (List) this.filters$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final List filters_delegate$lambda$2(SelectDeviceFilterDialogFragment selectDeviceFilterDialogFragment) {
        Parcelable[] parcelableArray = selectDeviceFilterDialogFragment.requireArguments().getParcelableArray(EXTRA_FILTERS);
        List list = null;
        List asList = parcelableArray != null ? ArraysKt.asList((T[]) parcelableArray) : null;
        if (asList instanceof List) {
            list = asList;
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        setStyle(0, R.style.DialogTheme);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R.style.dialog_animation);
            window.setGravity(80);
        }
        DialogfragmentSelectDeviceFilterBinding inflate = DialogfragmentSelectDeviceFilterBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        DialogfragmentSelectDeviceFilterBinding dialogfragmentSelectDeviceFilterBinding = this.binding;
        DialogfragmentSelectDeviceFilterBinding dialogfragmentSelectDeviceFilterBinding2 = null;
        if (dialogfragmentSelectDeviceFilterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentSelectDeviceFilterBinding = null;
        }
        dialogfragmentSelectDeviceFilterBinding.closeBtn.setOnClickListener(new SelectDeviceFilterDialogFragment$$ExternalSyntheticLambda0(this));
        DialogfragmentSelectDeviceFilterBinding dialogfragmentSelectDeviceFilterBinding3 = this.binding;
        if (dialogfragmentSelectDeviceFilterBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentSelectDeviceFilterBinding3 = null;
        }
        dialogfragmentSelectDeviceFilterBinding3.title.setText(getTitle());
        DialogfragmentSelectDeviceFilterBinding dialogfragmentSelectDeviceFilterBinding4 = this.binding;
        if (dialogfragmentSelectDeviceFilterBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentSelectDeviceFilterBinding4 = null;
        }
        dialogfragmentSelectDeviceFilterBinding4.filterList.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
        DialogfragmentSelectDeviceFilterBinding dialogfragmentSelectDeviceFilterBinding5 = this.binding;
        if (dialogfragmentSelectDeviceFilterBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentSelectDeviceFilterBinding5 = null;
        }
        dialogfragmentSelectDeviceFilterBinding5.filterList.addOnScrollListener(new SelectDeviceFilterDialogFragment$onViewCreated$2(this));
        DialogfragmentSelectDeviceFilterBinding dialogfragmentSelectDeviceFilterBinding6 = this.binding;
        if (dialogfragmentSelectDeviceFilterBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogfragmentSelectDeviceFilterBinding2 = dialogfragmentSelectDeviceFilterBinding6;
        }
        dialogfragmentSelectDeviceFilterBinding2.filterList.setAdapter(getFilterAdapter());
        getFilterAdapter().setFilters(getFilters());
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(SelectDeviceFilterDialogFragment selectDeviceFilterDialogFragment, View view) {
        selectDeviceFilterDialogFragment.dismiss();
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -2);
        }
    }

    public void onResume() {
        super.onResume();
        refreshFilterScrollIndicators();
    }

    public void onPause() {
        Window window;
        WindowManager.LayoutParams attributes;
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null || (attributes = window.getAttributes()) == null)) {
            attributes.windowAnimations = R.style.dialog_animation_exit_only;
        }
        super.onPause();
    }

    /* access modifiers changed from: private */
    public final void refreshFilterScrollIndicators() {
        DialogfragmentSelectDeviceFilterBinding dialogfragmentSelectDeviceFilterBinding = this.binding;
        DialogfragmentSelectDeviceFilterBinding dialogfragmentSelectDeviceFilterBinding2 = null;
        if (dialogfragmentSelectDeviceFilterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentSelectDeviceFilterBinding = null;
        }
        ImageView imageView = dialogfragmentSelectDeviceFilterBinding.filterScrollLeft;
        DialogfragmentSelectDeviceFilterBinding dialogfragmentSelectDeviceFilterBinding3 = this.binding;
        if (dialogfragmentSelectDeviceFilterBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentSelectDeviceFilterBinding3 = null;
        }
        int i = 0;
        imageView.setVisibility(dialogfragmentSelectDeviceFilterBinding3.filterList.canScrollHorizontally(-1) ? 0 : 4);
        DialogfragmentSelectDeviceFilterBinding dialogfragmentSelectDeviceFilterBinding4 = this.binding;
        if (dialogfragmentSelectDeviceFilterBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentSelectDeviceFilterBinding4 = null;
        }
        ImageView imageView2 = dialogfragmentSelectDeviceFilterBinding4.filterScrollRight;
        DialogfragmentSelectDeviceFilterBinding dialogfragmentSelectDeviceFilterBinding5 = this.binding;
        if (dialogfragmentSelectDeviceFilterBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogfragmentSelectDeviceFilterBinding2 = dialogfragmentSelectDeviceFilterBinding5;
        }
        if (!dialogfragmentSelectDeviceFilterBinding2.filterList.canScrollHorizontally(1)) {
            i = 4;
        }
        imageView2.setVisibility(i);
    }
}
