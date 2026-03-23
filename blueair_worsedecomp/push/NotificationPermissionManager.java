package com.blueair.push;

import android.content.Context;
import android.os.Build;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blueair.core.PrefKeys;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.utils.AppSettingsIntent;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.android.ClosestKt;
import org.kodein.di.android.LazyContextDIPropertyDelegateProvider;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010-\u001a\u00020\u0007J\b\u0010.\u001a\u00020\u0007H\u0002J\b\u0010/\u001a\u00020\nH\u0003J\u0006\u00100\u001a\u00020\nJ\b\u00101\u001a\u00020\nH\u0003J\b\u00102\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188VX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b\u001e\u0010\u001fR+\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00078B@BX\u0002¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010(\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010*0*0)8\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/blueair/push/NotificationPermissionManager;", "Lorg/kodein/di/DIAware;", "context", "Landroid/content/Context;", "activityResultCaller", "Landroidx/activity/result/ActivityResultCaller;", "alwaysShowRequest", "", "onPermissionGranted", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;Landroidx/activity/result/ActivityResultCaller;ZLkotlin/jvm/functions/Function0;)V", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity$delegate", "Lkotlin/Lazy;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "getPrefs", "()Lcom/blueair/core/service/UnsecurePrefs;", "prefs$delegate", "<set-?>", "isNotificationPermissionRejected", "()Z", "setNotificationPermissionRejected", "(Z)V", "isNotificationPermissionRejected$delegate", "Lkotlin/properties/ReadWriteProperty;", "notificationPermissionResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "underApi33", "isGranted", "shouldShowRequestPermissionRationale", "requestPermission", "checkAndRequest", "showNotificationPermissionRationaleDialog", "showNotificationPermissionDeniedDialog", "push_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationPermissionManager.kt */
public final class NotificationPermissionManager implements DIAware {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final Lazy activity$delegate;
    private final ActivityResultCaller activityResultCaller;
    private final boolean alwaysShowRequest;
    private final Context context;
    private final Lazy di$delegate;
    private final ReadWriteProperty isNotificationPermissionRejected$delegate;
    private final ActivityResultLauncher<String> notificationPermissionResultLauncher;
    private final Function0<Unit> onPermissionGranted;
    private final Lazy prefs$delegate;
    private final boolean underApi33;

    static {
        Class<NotificationPermissionManager> cls = NotificationPermissionManager.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "di", "getDi()Lorg/kodein/di/DI;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "prefs", "getPrefs()Lcom/blueair/core/service/UnsecurePrefs;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "isNotificationPermissionRejected", "isNotificationPermissionRejected()Z", 0))};
    }

    public DIContext<?> getDiContext() {
        return DIAware.DefaultImpls.getDiContext(this);
    }

    public DITrigger getDiTrigger() {
        return DIAware.DefaultImpls.getDiTrigger(this);
    }

    public NotificationPermissionManager(Context context2, ActivityResultCaller activityResultCaller2, boolean z, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(activityResultCaller2, "activityResultCaller");
        this.context = context2;
        this.activityResultCaller = activityResultCaller2;
        this.alwaysShowRequest = z;
        this.onPermissionGranted = function0;
        this.activity$delegate = LazyKt.lazy(new NotificationPermissionManager$$ExternalSyntheticLambda1(this));
        LazyContextDIPropertyDelegateProvider closestDI = ClosestKt.closestDI(context2);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        boolean z2 = false;
        this.di$delegate = closestDI.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new NotificationPermissionManager$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.prefs$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, UnsecurePrefs.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        Prefs prefs = getPrefs();
        this.isNotificationPermissionRejected$delegate = new NotificationPermissionManager$special$$inlined$ObservablePreference$1(prefs, PrefKeys.NOTIFICATION_PERMISSION_REJECTED, false, PreferencesHelper.INSTANCE.get(prefs.getBackend(), PrefKeys.NOTIFICATION_PERMISSION_REJECTED, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        ActivityResultLauncher<String> registerForActivityResult = activityResultCaller2.registerForActivityResult(new ActivityResultContracts.RequestPermission(), new NotificationPermissionManager$$ExternalSyntheticLambda2(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.notificationPermissionResultLauncher = registerForActivityResult;
        this.underApi33 = Build.VERSION.SDK_INT < 33 ? true : z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NotificationPermissionManager(Context context2, ActivityResultCaller activityResultCaller2, boolean z, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, activityResultCaller2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : function0);
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.activity$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final FragmentActivity activity_delegate$lambda$0(NotificationPermissionManager notificationPermissionManager) {
        ActivityResultCaller activityResultCaller2 = notificationPermissionManager.activityResultCaller;
        if (activityResultCaller2 instanceof FragmentActivity) {
            return (FragmentActivity) activityResultCaller2;
        }
        Intrinsics.checkNotNull(activityResultCaller2, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        FragmentActivity requireActivity = ((Fragment) activityResultCaller2).requireActivity();
        Intrinsics.checkNotNull(requireActivity);
        return requireActivity;
    }

    private final FragmentManager getFragmentManager() {
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        return supportFragmentManager;
    }

    public DI getDi() {
        return (DI) this.di$delegate.getValue();
    }

    private final UnsecurePrefs getPrefs() {
        return (UnsecurePrefs) this.prefs$delegate.getValue();
    }

    private final boolean isNotificationPermissionRejected() {
        return ((Boolean) this.isNotificationPermissionRejected$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
    }

    private final void setNotificationPermissionRejected(boolean z) {
        this.isNotificationPermissionRejected$delegate.setValue(this, $$delegatedProperties[2], Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public static final void notificationPermissionResultLauncher$lambda$1(NotificationPermissionManager notificationPermissionManager, Boolean bool) {
        if (bool.booleanValue()) {
            Function0<Unit> function0 = notificationPermissionManager.onPermissionGranted;
            if (function0 != null) {
                function0.invoke();
            }
        } else if (!notificationPermissionManager.shouldShowRequestPermissionRationale()) {
            notificationPermissionManager.showNotificationPermissionDeniedDialog();
        }
    }

    public final boolean isGranted() {
        if (this.underApi33) {
            return NotificationManagerCompat.from(this.context).areNotificationsEnabled();
        }
        return ContextCompat.checkSelfPermission(getActivity(), "android.permission.POST_NOTIFICATIONS") == 0;
    }

    private final boolean shouldShowRequestPermissionRationale() {
        if (this.underApi33) {
            return true;
        }
        return ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), "android.permission.POST_NOTIFICATIONS");
    }

    private final void requestPermission() {
        DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_notification, R.string.permission_request_message_notification);
        this.notificationPermissionResultLauncher.launch("android.permission.POST_NOTIFICATIONS");
    }

    public final void checkAndRequest() {
        if (isGranted()) {
            Function0<Unit> function0 = this.onPermissionGranted;
            if (function0 != null) {
                function0.invoke();
            }
        } else if (shouldShowRequestPermissionRationale()) {
            if (this.underApi33) {
                showNotificationPermissionDeniedDialog();
            } else {
                showNotificationPermissionRationaleDialog();
            }
        } else if (!this.underApi33) {
            requestPermission();
        }
    }

    private final void showNotificationPermissionRationaleDialog() {
        if (this.alwaysShowRequest || !isNotificationPermissionRejected()) {
            FragmentManager fragmentManager = getFragmentManager();
            Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(fragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !fragmentManager.isStateSaved()) {
                ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.notification_permission_dialog_request_title, (Integer) null, R.string.notification_permission_dialog_request_content, Integer.valueOf(R.string.agree), Integer.valueOf(R.string.reject), false, false, true, true, (String[]) null, (String) null, new NotificationPermissionManager$$ExternalSyntheticLambda3(this), 1632, (Object) null).show(fragmentManager, "ConfirmationDialogLeftAligned");
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Unit showNotificationPermissionRationaleDialog$lambda$3$lambda$2(NotificationPermissionManager notificationPermissionManager, boolean z) {
        if (z) {
            notificationPermissionManager.requestPermission();
        } else {
            notificationPermissionManager.setNotificationPermissionRejected(true);
        }
        return Unit.INSTANCE;
    }

    private final void showNotificationPermissionDeniedDialog() {
        if (this.alwaysShowRequest || !isNotificationPermissionRejected()) {
            FragmentManager fragmentManager = getFragmentManager();
            Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(fragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !fragmentManager.isStateSaved()) {
                ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.notification_permission_dialog_denied_title, (Integer) null, R.string.notification_permission_dialog_denied_content, Integer.valueOf(R.string.btn_goto_settings), Integer.valueOf(R.string.reject), false, false, true, true, (String[]) null, (String) null, new NotificationPermissionManager$$ExternalSyntheticLambda0(this), 1632, (Object) null).show(fragmentManager, "ConfirmationDialogLeftAligned");
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Unit showNotificationPermissionDeniedDialog$lambda$5$lambda$4(NotificationPermissionManager notificationPermissionManager, boolean z) {
        if (z) {
            AppSettingsIntent.INSTANCE.start(notificationPermissionManager.getActivity());
        } else {
            notificationPermissionManager.setNotificationPermissionRejected(true);
        }
        return Unit.INSTANCE;
    }
}
