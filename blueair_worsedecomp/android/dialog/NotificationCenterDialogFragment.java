package com.blueair.android.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.adapter.NotificationSettingsAdapter;
import com.blueair.android.databinding.DialogNotificationCenterBinding;
import com.blueair.android.dialog.NotificationEditNumberDialogFragment;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.NotificationSetting;
import com.blueair.core.model.NotificationType;
import com.blueair.push.NotificationPermissionManager;
import com.blueair.sdk.KlaviyoSdk;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J$\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001bH\u0016J\b\u0010'\u001a\u00020\u001bH\u0016J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138TX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/blueair/android/dialog/NotificationCenterDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/android/dialog/NotificationCenterViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "adapter", "Lcom/blueair/android/adapter/NotificationSettingsAdapter;", "viewDataBinding", "Lcom/blueair/android/databinding/DialogNotificationCenterBinding;", "viewModel", "getViewModel", "()Lcom/blueair/android/dialog/NotificationCenterViewModel;", "setViewModel", "(Lcom/blueair/android/dialog/NotificationCenterViewModel;)V", "snackbarAnchorView", "Landroid/view/View;", "getSnackbarAnchorView", "()Landroid/view/View;", "snackbarAnchorView$delegate", "Lkotlin/Lazy;", "notificationPermissionManager", "Lcom/blueair/push/NotificationPermissionManager;", "initNotificationPermissionManager", "", "context", "Landroid/content/Context;", "onAttach", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onResume", "showProgress", "shouldShowProgress", "", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationCenterDialogFragment.kt */
public final class NotificationCenterDialogFragment extends BaseDialogFragment<NotificationCenterViewModel> {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final NotificationSettingsAdapter adapter = new NotificationSettingsAdapter();
    private NotificationPermissionManager notificationPermissionManager;
    private final String screenName = AnalyticEvent.ScreenViewEvent.SIDE_MENU_SETTINGS_NOTIFICATION;
    private final Lazy snackbarAnchorView$delegate = LazyKt.lazy(new NotificationCenterDialogFragment$$ExternalSyntheticLambda8(this));
    private DialogNotificationCenterBinding viewDataBinding;
    public NotificationCenterViewModel viewModel;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/android/dialog/NotificationCenterDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/android/dialog/NotificationCenterDialogFragment;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: NotificationCenterDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NotificationCenterDialogFragment newInstance() {
            return new NotificationCenterDialogFragment();
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public NotificationCenterViewModel getViewModel() {
        NotificationCenterViewModel notificationCenterViewModel = this.viewModel;
        if (notificationCenterViewModel != null) {
            return notificationCenterViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(NotificationCenterViewModel notificationCenterViewModel) {
        Intrinsics.checkNotNullParameter(notificationCenterViewModel, "<set-?>");
        this.viewModel = notificationCenterViewModel;
    }

    /* access modifiers changed from: private */
    public static final View snackbarAnchorView_delegate$lambda$0(NotificationCenterDialogFragment notificationCenterDialogFragment) {
        DialogNotificationCenterBinding dialogNotificationCenterBinding = notificationCenterDialogFragment.viewDataBinding;
        if (dialogNotificationCenterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogNotificationCenterBinding = null;
        }
        return dialogNotificationCenterBinding.getRoot();
    }

    /* access modifiers changed from: protected */
    public View getSnackbarAnchorView() {
        return (View) this.snackbarAnchorView$delegate.getValue();
    }

    public final void initNotificationPermissionManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.notificationPermissionManager = new NotificationPermissionManager(context, this, true, (Function0) null, 8, (DefaultConstructorMarker) null);
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        initNotificationPermissionManager(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        boolean z = false;
        setStyle(0, R.style.DialogTheme);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R.style.dialog_animation_right);
        }
        setViewModel((NotificationCenterViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(NotificationCenterViewModel.class)));
        DialogNotificationCenterBinding inflate = DialogNotificationCenterBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.viewDataBinding = inflate;
        DialogNotificationCenterBinding dialogNotificationCenterBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            inflate = null;
        }
        inflate.closeButton.setOnClickListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda9(this));
        inflate.permissionPromptBar.setOnClickListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda15(this));
        getViewModel().getRequesting().observe(getViewLifecycleOwner(), new NotificationCenterDialogFragment$sam$androidx_lifecycle_Observer$0(new NotificationCenterDialogFragment$$ExternalSyntheticLambda16(this)));
        getViewModel().getFetchFailed().observe(getViewLifecycleOwner(), new NotificationCenterDialogFragment$sam$androidx_lifecycle_Observer$0(new NotificationCenterDialogFragment$$ExternalSyntheticLambda1(inflate)));
        inflate.stateLoadingFailed.getRoot().setOnClickListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda2(this));
        boolean enabled = KlaviyoSdk.INSTANCE.getEnabled();
        getViewModel().getNotificationAllSettings().observe(getViewLifecycleOwner(), new NotificationCenterDialogFragment$sam$androidx_lifecycle_Observer$0(new NotificationCenterDialogFragment$$ExternalSyntheticLambda3(inflate, enabled, this)));
        inflate.tvTypeAll.setText(enabled ? R.string.notification_type_all_new : R.string.notification_type_all);
        inflate.tvTypeAll.setOnClickListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda4(enabled, this));
        inflate.switchTypeAll.setOnCheckedChangeListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda5(this, enabled));
        if (enabled) {
            LinearLayout linearLayout = inflate.groupTypeProductAlerts;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "groupTypeProductAlerts");
            ViewExtensionsKt.show(linearLayout, false);
            RecyclerView recyclerView = inflate.rvSettings;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "rvSettings");
            ViewExtensionsKt.show(recyclerView, true);
            inflate.rvSettings.setAdapter(this.adapter);
            inflate.rvSettings.setLayoutManager(new LinearLayoutManager(requireContext()));
            getViewModel().getNotificationSettings().observe(getViewLifecycleOwner(), new NotificationCenterDialogFragment$sam$androidx_lifecycle_Observer$0(new NotificationCenterDialogFragment$$ExternalSyntheticLambda6(this)));
            this.adapter.setOnShowInfoListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda7(this));
            this.adapter.setOnSettingChangedListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda10(this));
        } else {
            RecyclerView recyclerView2 = inflate.rvSettings;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "rvSettings");
            ViewExtensionsKt.show(recyclerView2, false);
            LinearLayout linearLayout2 = inflate.groupTypeProductAlerts;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "groupTypeProductAlerts");
            View view = linearLayout2;
            NotificationSetting value = getViewModel().getNotificationAllSettings().getValue();
            if (value != null) {
                z = value.isEnabled();
            }
            ViewExtensionsKt.show(view, z);
            getViewModel().getNotificationProductAlertSettings().observe(getViewLifecycleOwner(), new NotificationCenterDialogFragment$sam$androidx_lifecycle_Observer$0(new NotificationCenterDialogFragment$$ExternalSyntheticLambda11(inflate)));
            inflate.tvTypeProductAlerts.setOnClickListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda12(this));
            inflate.switchTypeProductAlerts.setOnCheckedChangeListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda13(this));
            inflate.tvTypeProductAlertsLimit.setOnClickListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda14(this));
        }
        DialogNotificationCenterBinding dialogNotificationCenterBinding2 = this.viewDataBinding;
        if (dialogNotificationCenterBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            dialogNotificationCenterBinding = dialogNotificationCenterBinding2;
        }
        View root = dialogNotificationCenterBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$19$lambda$2(NotificationCenterDialogFragment notificationCenterDialogFragment, View view) {
        notificationCenterDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$19$lambda$3(NotificationCenterDialogFragment notificationCenterDialogFragment, View view) {
        NotificationPermissionManager notificationPermissionManager2 = notificationCenterDialogFragment.notificationPermissionManager;
        if (notificationPermissionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationPermissionManager");
            notificationPermissionManager2 = null;
        }
        notificationPermissionManager2.checkAndRequest();
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$19$lambda$4(NotificationCenterDialogFragment notificationCenterDialogFragment, Boolean bool) {
        Intrinsics.checkNotNull(bool);
        notificationCenterDialogFragment.showProgress(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$19$lambda$5(DialogNotificationCenterBinding dialogNotificationCenterBinding, Boolean bool) {
        ConstraintLayout root = dialogNotificationCenterBinding.stateLoadingFailed.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        Intrinsics.checkNotNull(bool);
        ViewExtensionsKt.show(root, bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$19$lambda$6(NotificationCenterDialogFragment notificationCenterDialogFragment, View view) {
        notificationCenterDialogFragment.getViewModel().fetchNotificationSettings();
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$19$lambda$7(DialogNotificationCenterBinding dialogNotificationCenterBinding, boolean z, NotificationCenterDialogFragment notificationCenterDialogFragment, NotificationSetting notificationSetting) {
        boolean isEnabled = notificationSetting.isEnabled();
        dialogNotificationCenterBinding.switchTypeAll.setCheckedSilence(isEnabled);
        if (z) {
            RecyclerView recyclerView = dialogNotificationCenterBinding.rvSettings;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "rvSettings");
            ViewExtensionsKt.show(recyclerView, isEnabled);
        } else {
            LinearLayout linearLayout = dialogNotificationCenterBinding.groupTypeProductAlerts;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "groupTypeProductAlerts");
            ViewExtensionsKt.show(linearLayout, isEnabled);
        }
        if (isEnabled) {
            NotificationPermissionManager notificationPermissionManager2 = notificationCenterDialogFragment.notificationPermissionManager;
            if (notificationPermissionManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationPermissionManager");
                notificationPermissionManager2 = null;
            }
            notificationPermissionManager2.checkAndRequest();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$19$lambda$8(boolean z, NotificationCenterDialogFragment notificationCenterDialogFragment, View view) {
        int i;
        int i2;
        if (z) {
            i2 = R.string.notification_type_all_new;
            i = R.string.notification_type_desc_all_new;
        } else {
            i2 = R.string.notification_type_all;
            i = R.string.notification_type_all_info;
        }
        ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, i2, (Integer) null, i, Integer.valueOf(R.string.btn_done), (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 4064, (Object) null).show(notificationCenterDialogFragment.getChildFragmentManager(), (String) null);
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$19$lambda$9(NotificationCenterDialogFragment notificationCenterDialogFragment, boolean z, CompoundButton compoundButton, boolean z2) {
        int i;
        NotificationSetting value = notificationCenterDialogFragment.getViewModel().getNotificationAllSettings().getValue();
        if (value != null) {
            if (z) {
                i = null;
            } else {
                i = 0;
            }
            notificationCenterDialogFragment.getViewModel().updateNotificationSetting(value, NotificationSetting.copy$default(value, (String) null, z2 ? 1 : 0, i, 1, (Object) null));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$19$lambda$10(NotificationCenterDialogFragment notificationCenterDialogFragment, List list) {
        NotificationSettingsAdapter notificationSettingsAdapter = notificationCenterDialogFragment.adapter;
        Intrinsics.checkNotNull(list);
        notificationSettingsAdapter.setSettings(list);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$19$lambda$11(NotificationCenterDialogFragment notificationCenterDialogFragment, NotificationSetting notificationSetting) {
        int i;
        int i2;
        NotificationSetting notificationSetting2 = notificationSetting;
        Intrinsics.checkNotNullParameter(notificationSetting2, AnalyticEvent.KEY_SETTING);
        String type = notificationSetting2.getType();
        if (Intrinsics.areEqual((Object) type, (Object) NotificationType.FILTER_REPLACEMENT.getValue())) {
            i = R.string.notification_type_filter_replacement;
            i2 = R.string.notification_type_desc_filter_replacement;
        } else if (Intrinsics.areEqual((Object) type, (Object) NotificationType.QUICK_ALARM_STOP.getValue())) {
            i = R.string.notification_type_quick_alarm_stop;
            i2 = R.string.notification_type_desc_quick_alarm_stop;
        } else if (Intrinsics.areEqual((Object) type, (Object) NotificationType.FILTER_CLEANING.getValue())) {
            i = R.string.notification_type_filter_cleaning;
            i2 = R.string.notification_type_desc_filter_cleaning;
        } else if (Intrinsics.areEqual((Object) type, (Object) NotificationType.WATER_LEVEL.getValue())) {
            i = R.string.notification_type_water_shortage;
            i2 = R.string.notification_type_desc_water_shortage;
        } else if (Intrinsics.areEqual((Object) type, (Object) NotificationType.MARKETING.getValue())) {
            i = R.string.notification_type_marketing;
            i2 = R.string.notification_type_desc_marketing;
        } else if (!Intrinsics.areEqual((Object) type, (Object) NotificationType.TRANSACTIONAL.getValue())) {
            return Unit.INSTANCE;
        } else {
            i = R.string.notification_type_transactional;
            i2 = R.string.notification_type_desc_transactional;
        }
        ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, i, (Integer) null, i2, Integer.valueOf(R.string.btn_done), (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 4064, (Object) null).show(notificationCenterDialogFragment.getChildFragmentManager(), (String) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$19$lambda$12(NotificationCenterDialogFragment notificationCenterDialogFragment, NotificationSetting notificationSetting, NotificationSetting notificationSetting2) {
        Intrinsics.checkNotNullParameter(notificationSetting, "old");
        Intrinsics.checkNotNullParameter(notificationSetting2, "new");
        notificationCenterDialogFragment.getViewModel().updateNotificationSetting(notificationSetting, notificationSetting2);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$19$lambda$13(DialogNotificationCenterBinding dialogNotificationCenterBinding, NotificationSetting notificationSetting) {
        dialogNotificationCenterBinding.switchTypeProductAlerts.setCheckedSilence(notificationSetting.isEnabled());
        LinearLayout linearLayout = dialogNotificationCenterBinding.groupTypeProductAlertsLimit;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "groupTypeProductAlertsLimit");
        ViewExtensionsKt.show(linearLayout, notificationSetting.isEnabled());
        TextView textView = dialogNotificationCenterBinding.tvTypeProductAlertsLimit;
        Integer limit = notificationSetting.getLimit();
        textView.setText(String.valueOf(limit != null ? limit.intValue() : 10));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$19$lambda$14(NotificationCenterDialogFragment notificationCenterDialogFragment, View view) {
        ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.notification_type_product_alerts, (Integer) null, R.string.notification_type_product_alerts_info, Integer.valueOf(R.string.btn_done), (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 4064, (Object) null).show(notificationCenterDialogFragment.getChildFragmentManager(), (String) null);
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$19$lambda$15(NotificationCenterDialogFragment notificationCenterDialogFragment, CompoundButton compoundButton, boolean z) {
        NotificationSetting value = notificationCenterDialogFragment.getViewModel().getNotificationProductAlertSettings().getValue();
        if (value != null) {
            Integer limit = value.getLimit();
            notificationCenterDialogFragment.getViewModel().updateNotificationSetting(value, NotificationSetting.copy$default(value, (String) null, z ? 1 : 0, Integer.valueOf(limit != null ? limit.intValue() : 10), 1, (Object) null));
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$19$lambda$18(NotificationCenterDialogFragment notificationCenterDialogFragment, View view) {
        NotificationSetting value = notificationCenterDialogFragment.getViewModel().getNotificationProductAlertSettings().getValue();
        if (value != null) {
            FragmentManager childFragmentManager = notificationCenterDialogFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<NotificationEditNumberDialogFragment> cls = NotificationEditNumberDialogFragment.class;
            Intrinsics.checkNotNullExpressionValue("NotificationEditNumberDialogFragment", "getSimpleName(...)");
            if (!(childFragmentManager.findFragmentByTag("NotificationEditNumberDialogFragment") instanceof NotificationEditNumberDialogFragment) && !childFragmentManager.isStateSaved()) {
                NotificationEditNumberDialogFragment.Companion companion = NotificationEditNumberDialogFragment.Companion;
                Integer limit = value.getLimit();
                companion.newInstance(limit != null ? limit.intValue() : 10, new NotificationCenterDialogFragment$$ExternalSyntheticLambda0(value, notificationCenterDialogFragment)).show(childFragmentManager, "NotificationEditNumberDialogFragment");
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$19$lambda$18$lambda$17$lambda$16(NotificationSetting notificationSetting, NotificationCenterDialogFragment notificationCenterDialogFragment, NotificationEditNumberDialogFragment notificationEditNumberDialogFragment, int i) {
        Intrinsics.checkNotNullParameter(notificationEditNumberDialogFragment, "dialog");
        NotificationSetting notificationSetting2 = notificationSetting;
        notificationCenterDialogFragment.getViewModel().updateNotificationSetting(notificationSetting2, NotificationSetting.copy$default(notificationSetting2, (String) null, 0, Integer.valueOf(i), 3, (Object) null));
        notificationEditNumberDialogFragment.dismiss();
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

    public void onResume() {
        super.onResume();
        DialogNotificationCenterBinding dialogNotificationCenterBinding = this.viewDataBinding;
        NotificationPermissionManager notificationPermissionManager2 = null;
        if (dialogNotificationCenterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogNotificationCenterBinding = null;
        }
        TextView textView = dialogNotificationCenterBinding.permissionPromptBar;
        Intrinsics.checkNotNullExpressionValue(textView, "permissionPromptBar");
        View view = textView;
        NotificationPermissionManager notificationPermissionManager3 = this.notificationPermissionManager;
        if (notificationPermissionManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationPermissionManager");
        } else {
            notificationPermissionManager2 = notificationPermissionManager3;
        }
        ViewExtensionsKt.show(view, !notificationPermissionManager2.isGranted());
    }

    public void showProgress(boolean z) {
        DialogNotificationCenterBinding dialogNotificationCenterBinding = this.viewDataBinding;
        if (dialogNotificationCenterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogNotificationCenterBinding = null;
        }
        ProgressBlockerView progressBlockerView = dialogNotificationCenterBinding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        ViewExtensionsKt.show(progressBlockerView, z);
    }
}
