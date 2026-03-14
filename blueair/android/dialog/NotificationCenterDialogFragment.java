package com.blueair.android.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.adapter.NotificationSettingsAdapter;
import com.blueair.android.databinding.DialogNotificationCenterBinding;
import com.blueair.core.model.NotificationSetting;
import com.blueair.core.model.NotificationType;
import com.blueair.push.NotificationPermissionManager;
import com.blueair.push.NotificationService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J$\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020 H\u0016J\b\u0010,\u001a\u00020 H\u0016J\u0010\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020/H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000¨\u00061"},
   d2 = {"Lcom/blueair/android/dialog/NotificationCenterDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/android/dialog/NotificationCenterViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "adapter", "Lcom/blueair/android/adapter/NotificationSettingsAdapter;", "viewDataBinding", "Lcom/blueair/android/databinding/DialogNotificationCenterBinding;", "viewModel", "getViewModel", "()Lcom/blueair/android/dialog/NotificationCenterViewModel;", "setViewModel", "(Lcom/blueair/android/dialog/NotificationCenterViewModel;)V", "notificationService", "Lcom/blueair/push/NotificationService;", "getNotificationService", "()Lcom/blueair/push/NotificationService;", "notificationService$delegate", "Lkotlin/Lazy;", "snackbarAnchorView", "Landroid/view/View;", "getSnackbarAnchorView", "()Landroid/view/View;", "snackbarAnchorView$delegate", "notificationPermissionManager", "Lcom/blueair/push/NotificationPermissionManager;", "initNotificationPermissionManager", "", "context", "Landroid/content/Context;", "onAttach", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onResume", "showProgress", "shouldShowProgress", "", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class NotificationCenterDialogFragment extends BaseDialogFragment {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(NotificationCenterDialogFragment.class, "notificationService", "getNotificationService()Lcom/blueair/push/NotificationService;", 0)))};
   public static final int $stable = 8;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final NotificationSettingsAdapter adapter = new NotificationSettingsAdapter();
   private NotificationPermissionManager notificationPermissionManager;
   private final Lazy notificationService$delegate;
   private final String screenName = "side_menu_settings_notification";
   private final Lazy snackbarAnchorView$delegate;
   private DialogNotificationCenterBinding viewDataBinding;
   public NotificationCenterViewModel viewModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$AUo8D1zc_Srcy_7s3c7Nur37W48(NotificationCenterDialogFragment var0, NotificationSetting var1) {
      return onCreateView$lambda$19$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$FGCHcYQq_0ykNRcY5YflYrqlEFc/* $FF was: $r8$lambda$FGCHcYQq-0ykNRcY5YflYrqlEFc*/(DialogNotificationCenterBinding var0, Boolean var1) {
      return onCreateView$lambda$19$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$FGzziHjLxbfImTud2vRSLvc9qkA(NotificationCenterDialogFragment var0, CompoundButton var1, boolean var2) {
      onCreateView$lambda$19$lambda$15(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Ju4KLDolKkOG7lRZBKoYkcitX8Y(NotificationCenterDialogFragment var0, View var1) {
      onCreateView$lambda$19$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$LtpHsKxioBqVlqKtAl9ayIHYdiM(boolean var0, NotificationCenterDialogFragment var1, View var2) {
      onCreateView$lambda$19$lambda$8(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$OntkYYypsvD0w4oIEEWtFq3ApI8(NotificationCenterDialogFragment var0, View var1) {
      onCreateView$lambda$19$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Q8qwWigm2lWMJ503zEAUPh6fVxQ(NotificationCenterDialogFragment var0, boolean var1, CompoundButton var2, boolean var3) {
      onCreateView$lambda$19$lambda$9(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$RrOq4FEUk2sYWM8jMGwGZavHjxM(NotificationCenterDialogFragment var0, View var1) {
      onCreateView$lambda$19$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static View $r8$lambda$VYHPswmxeoJIaLawcdTPlaUyIno(NotificationCenterDialogFragment var0) {
      return snackbarAnchorView_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$cZkjXacU_KkqDZ0GiQaE__W1m2U(NotificationCenterDialogFragment var0, NotificationSetting var1, NotificationSetting var2) {
      return onCreateView$lambda$19$lambda$12(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$de67WeyRIK9_YXp5YIxsYwQLNOQ(NotificationCenterDialogFragment var0, Boolean var1) {
      return onCreateView$lambda$19$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$gi_0ztfax170v8ztvYtXPenhf90/* $FF was: $r8$lambda$gi-0ztfax170v8ztvYtXPenhf90*/(DialogNotificationCenterBinding var0, NotificationSetting var1) {
      return onCreateView$lambda$19$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$kfUSQMRh7Qt8U92PbI9xLxYoGIA(NotificationCenterDialogFragment var0, View var1) {
      onCreateView$lambda$19$lambda$18(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$sBUCVbRrQ6d6jQ0WA7a5zS7Al40(DialogNotificationCenterBinding var0, boolean var1, NotificationCenterDialogFragment var2, NotificationSetting var3) {
      return onCreateView$lambda$19$lambda$7(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$zQety4zWCgvs7IZvganuMmb5SF8(NotificationSetting var0, NotificationCenterDialogFragment var1, NotificationEditNumberDialogFragment var2, int var3) {
      return onCreateView$lambda$19$lambda$18$lambda$17$lambda$16(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$zk0OSE0_nCXc_9Vy3pl_M9gYhWY/* $FF was: $r8$lambda$zk0OSE0-nCXc_9Vy3pl-M9gYhWY*/(NotificationCenterDialogFragment var0, View var1) {
      onCreateView$lambda$19$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$zwrhr6bVyZPBVGhdSXaHy9oq_yw/* $FF was: $r8$lambda$zwrhr6bVyZPBVGhdSXaHy9oq-yw*/(NotificationCenterDialogFragment var0, List var1) {
      return onCreateView$lambda$19$lambda$10(var0, var1);
   }

   public NotificationCenterDialogFragment() {
      DIAware var2 = this;
      JVMTypeToken var1 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.notificationService$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var1, NotificationService.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
      this.snackbarAnchorView$delegate = LazyKt.lazy(new NotificationCenterDialogFragment$$ExternalSyntheticLambda8(this));
   }

   private final NotificationService getNotificationService() {
      return (NotificationService)this.notificationService$delegate.getValue();
   }

   private static final Unit onCreateView$lambda$19$lambda$10(NotificationCenterDialogFragment var0, List var1) {
      NotificationSettingsAdapter var2 = var0.adapter;
      Intrinsics.checkNotNull(var1);
      var2.setSettings(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateView$lambda$19$lambda$11(NotificationCenterDialogFragment var0, NotificationSetting var1) {
      Intrinsics.checkNotNullParameter(var1, "setting");
      String var4 = var1.getType();
      int var2;
      int var3;
      if (Intrinsics.areEqual(var4, NotificationType.FILTER_REPLACEMENT.getValue())) {
         var2 = R.string.notification_type_filter_replacement;
         var3 = R.string.notification_type_desc_filter_replacement;
      } else if (Intrinsics.areEqual(var4, NotificationType.QUICK_ALARM_STOP.getValue())) {
         var2 = R.string.notification_type_quick_alarm_stop;
         var3 = R.string.notification_type_desc_quick_alarm_stop;
      } else if (Intrinsics.areEqual(var4, NotificationType.FILTER_CLEANING.getValue())) {
         var2 = R.string.notification_type_filter_cleaning;
         var3 = R.string.notification_type_desc_filter_cleaning;
      } else if (Intrinsics.areEqual(var4, NotificationType.WATER_LEVEL.getValue())) {
         var2 = R.string.notification_type_water_shortage;
         var3 = R.string.notification_type_desc_water_shortage;
      } else if (Intrinsics.areEqual(var4, NotificationType.MARKETING.getValue())) {
         var2 = R.string.notification_type_marketing;
         var3 = R.string.notification_type_desc_marketing;
      } else {
         if (!Intrinsics.areEqual(var4, NotificationType.TRANSACTIONAL.getValue())) {
            return Unit.INSTANCE;
         }

         var2 = R.string.notification_type_transactional;
         var3 = R.string.notification_type_desc_transactional;
      }

      ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, var2, (Integer)null, var3, R.string.btn_done, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8160, (Object)null).show(var0.getChildFragmentManager(), (String)null);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateView$lambda$19$lambda$12(NotificationCenterDialogFragment var0, NotificationSetting var1, NotificationSetting var2) {
      Intrinsics.checkNotNullParameter(var1, "old");
      Intrinsics.checkNotNullParameter(var2, "new");
      var0.getViewModel().updateNotificationSetting(var1, var2);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateView$lambda$19$lambda$13(DialogNotificationCenterBinding var0, NotificationSetting var1) {
      var0.switchTypeProductAlerts.setCheckedSilence(var1.isEnabled());
      LinearLayout var3 = var0.groupTypeProductAlertsLimit;
      Intrinsics.checkNotNullExpressionValue(var3, "groupTypeProductAlertsLimit");
      ViewExtensionsKt.show((View)var3, var1.isEnabled());
      TextView var4 = var0.tvTypeProductAlertsLimit;
      Integer var5 = var1.getLimit();
      int var2;
      if (var5 != null) {
         var2 = var5;
      } else {
         var2 = 10;
      }

      var4.setText((CharSequence)String.valueOf(var2));
      return Unit.INSTANCE;
   }

   private static final void onCreateView$lambda$19$lambda$14(NotificationCenterDialogFragment var0, View var1) {
      ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.notification_type_product_alerts, (Integer)null, R.string.notification_type_product_alerts_info, R.string.btn_done, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8160, (Object)null).show(var0.getChildFragmentManager(), (String)null);
   }

   private static final void onCreateView$lambda$19$lambda$15(NotificationCenterDialogFragment var0, CompoundButton var1, boolean var2) {
      NotificationSetting var5 = (NotificationSetting)var0.getViewModel().getNotificationProductAlertSettings().getValue();
      if (var5 != null) {
         Integer var4 = var5.getLimit();
         int var3;
         if (var4 != null) {
            var3 = var4;
         } else {
            var3 = 10;
         }

         NotificationSetting var6 = NotificationSetting.copy$default(var5, (String)null, var2, var3, 1, (Object)null);
         var0.getViewModel().updateNotificationSetting(var5, var6);
      }
   }

   private static final void onCreateView$lambda$19$lambda$18(NotificationCenterDialogFragment var0, View var1) {
      NotificationSetting var5 = (NotificationSetting)var0.getViewModel().getNotificationProductAlertSettings().getValue();
      if (var5 != null) {
         FragmentManager var6 = var0.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var6, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("NotificationEditNumberDialogFragment", "getSimpleName(...)");
         if (!(var6.findFragmentByTag("NotificationEditNumberDialogFragment") instanceof NotificationEditNumberDialogFragment) && !var6.isStateSaved()) {
            NotificationEditNumberDialogFragment.Companion var4 = NotificationEditNumberDialogFragment.Companion;
            Integer var3 = var5.getLimit();
            int var2;
            if (var3 != null) {
               var2 = var3;
            } else {
               var2 = 10;
            }

            ((DialogFragment)var4.newInstance(var2, new NotificationCenterDialogFragment$$ExternalSyntheticLambda0(var5, var0))).show(var6, "NotificationEditNumberDialogFragment");
         }
      }

   }

   private static final Unit onCreateView$lambda$19$lambda$18$lambda$17$lambda$16(NotificationSetting var0, NotificationCenterDialogFragment var1, NotificationEditNumberDialogFragment var2, int var3) {
      Intrinsics.checkNotNullParameter(var2, "dialog");
      NotificationSetting var4 = NotificationSetting.copy$default(var0, (String)null, 0, var3, 3, (Object)null);
      var1.getViewModel().updateNotificationSetting(var0, var4);
      var2.dismiss();
      return Unit.INSTANCE;
   }

   private static final void onCreateView$lambda$19$lambda$2(NotificationCenterDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void onCreateView$lambda$19$lambda$3(NotificationCenterDialogFragment var0, View var1) {
      NotificationPermissionManager var3 = var0.notificationPermissionManager;
      NotificationPermissionManager var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("notificationPermissionManager");
         var2 = null;
      }

      var2.checkAndRequest();
   }

   private static final Unit onCreateView$lambda$19$lambda$4(NotificationCenterDialogFragment var0, Boolean var1) {
      Intrinsics.checkNotNull(var1);
      var0.showProgress(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateView$lambda$19$lambda$5(DialogNotificationCenterBinding var0, Boolean var1) {
      ConstraintLayout var2 = var0.stateLoadingFailed.getRoot();
      Intrinsics.checkNotNullExpressionValue(var2, "getRoot(...)");
      View var3 = (View)var2;
      Intrinsics.checkNotNull(var1);
      ViewExtensionsKt.show(var3, var1);
      return Unit.INSTANCE;
   }

   private static final void onCreateView$lambda$19$lambda$6(NotificationCenterDialogFragment var0, View var1) {
      var0.getViewModel().fetchNotificationSettings();
   }

   private static final Unit onCreateView$lambda$19$lambda$7(DialogNotificationCenterBinding var0, boolean var1, NotificationCenterDialogFragment var2, NotificationSetting var3) {
      boolean var4 = var3.isEnabled();
      var0.switchTypeAll.setCheckedSilence(var4);
      if (var1) {
         RecyclerView var5 = var0.rvSettings;
         Intrinsics.checkNotNullExpressionValue(var5, "rvSettings");
         ViewExtensionsKt.show((View)var5, var4);
      } else {
         LinearLayout var6 = var0.groupTypeProductAlerts;
         Intrinsics.checkNotNullExpressionValue(var6, "groupTypeProductAlerts");
         ViewExtensionsKt.show((View)var6, var4);
      }

      if (var4) {
         NotificationPermissionManager var8 = var2.notificationPermissionManager;
         NotificationPermissionManager var7 = var8;
         if (var8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationPermissionManager");
            var7 = null;
         }

         var7.checkAndRequest();
      }

      return Unit.INSTANCE;
   }

   private static final void onCreateView$lambda$19$lambda$8(boolean var0, NotificationCenterDialogFragment var1, View var2) {
      int var3;
      int var4;
      if (var0) {
         var4 = R.string.notification_type_all_new;
         var3 = R.string.notification_type_desc_all_new;
      } else {
         var4 = R.string.notification_type_all;
         var3 = R.string.notification_type_all_info;
      }

      ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, var4, (Integer)null, var3, R.string.btn_done, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8160, (Object)null).show(var1.getChildFragmentManager(), (String)null);
   }

   private static final void onCreateView$lambda$19$lambda$9(NotificationCenterDialogFragment var0, boolean var1, CompoundButton var2, boolean var3) {
      NotificationSetting var4 = (NotificationSetting)var0.getViewModel().getNotificationAllSettings().getValue();
      if (var4 != null) {
         Integer var5;
         if (var1) {
            var5 = null;
         } else {
            var5 = 0;
         }

         NotificationSetting var6 = NotificationSetting.copy$default(var4, (String)null, var3, var5, 1, (Object)null);
         var0.getViewModel().updateNotificationSetting(var4, var6);
      }
   }

   private static final View snackbarAnchorView_delegate$lambda$0(NotificationCenterDialogFragment var0) {
      DialogNotificationCenterBinding var1 = var0.viewDataBinding;
      DialogNotificationCenterBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      return var2.getRoot();
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected View getSnackbarAnchorView() {
      return (View)this.snackbarAnchorView$delegate.getValue();
   }

   public NotificationCenterViewModel getViewModel() {
      NotificationCenterViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public final void initNotificationPermissionManager(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this.notificationPermissionManager = new NotificationPermissionManager(var1, (ActivityResultCaller)this, true, (Function0)null, 8, (DefaultConstructorMarker)null);
   }

   public void onAttach(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super.onAttach(var1);
      this.initNotificationPermissionManager(var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      int var4 = R.style.DialogTheme;
      boolean var6 = false;
      this.setStyle(0, var4);
      Dialog var12 = this.getDialog();
      if (var12 != null) {
         Window var13 = var12.getWindow();
         if (var13 != null) {
            var13.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var13.setWindowAnimations(R.style.dialog_animation_right);
         }
      }

      this.setViewModel((NotificationCenterViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(NotificationCenterViewModel.class)));
      DialogNotificationCenterBinding var14 = DialogNotificationCenterBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var14, "inflate(...)");
      this.viewDataBinding = var14;
      Object var11 = null;
      DialogNotificationCenterBinding var8 = var14;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var8 = null;
      }

      var8.closeButton.setOnClickListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda9(this));
      var8.permissionPromptBar.setOnClickListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda15(this));
      this.getViewModel().getRequesting().observe(this.getViewLifecycleOwner(), new Observer(new NotificationCenterDialogFragment$$ExternalSyntheticLambda16(this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      this.getViewModel().getFetchFailed().observe(this.getViewLifecycleOwner(), new Observer(new NotificationCenterDialogFragment$$ExternalSyntheticLambda1(var8)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      var8.stateLoadingFailed.getRoot().setOnClickListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda2(this));
      boolean var5;
      if (!this.getNotificationService().getUseJPush() && !this.getNotificationService().getUseKlaviyo()) {
         var5 = false;
      } else {
         var5 = true;
      }

      this.getViewModel().getNotificationAllSettings().observe(this.getViewLifecycleOwner(), new Observer(new NotificationCenterDialogFragment$$ExternalSyntheticLambda3(var8, var5, this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      TextView var15 = var8.tvTypeAll;
      if (var5) {
         var4 = R.string.notification_type_all_new;
      } else {
         var4 = R.string.notification_type_all;
      }

      var15.setText(var4);
      var8.tvTypeAll.setOnClickListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda4(var5, this));
      var8.switchTypeAll.setOnCheckedChangeListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda5(this, var5));
      if (var5) {
         LinearLayout var16 = var8.groupTypeProductAlerts;
         Intrinsics.checkNotNullExpressionValue(var16, "groupTypeProductAlerts");
         ViewExtensionsKt.show((View)var16, false);
         RecyclerView var17 = var8.rvSettings;
         Intrinsics.checkNotNullExpressionValue(var17, "rvSettings");
         ViewExtensionsKt.show((View)var17, true);
         var8.rvSettings.setAdapter(this.adapter);
         var8.rvSettings.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(this.requireContext())));
         this.getViewModel().getNotificationSettings().observe(this.getViewLifecycleOwner(), new Observer(new NotificationCenterDialogFragment$$ExternalSyntheticLambda6(this)) {
            private final Function1 function;

            {
               Intrinsics.checkNotNullParameter(var1, "function");
               this.function = var1;
            }

            public final boolean equals(Object var1) {
               return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
            }

            public final Function getFunctionDelegate() {
               return (Function)this.function;
            }

            public final int hashCode() {
               return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
            }

            // $FF: synthetic method
            public final void onChanged(Object var1) {
               this.function.invoke(var1);
            }
         });
         this.adapter.setOnShowInfoListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda7(this));
         this.adapter.setOnSettingChangedListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda10(this));
      } else {
         RecyclerView var18 = var8.rvSettings;
         Intrinsics.checkNotNullExpressionValue(var18, "rvSettings");
         ViewExtensionsKt.show((View)var18, false);
         LinearLayout var19 = var8.groupTypeProductAlerts;
         Intrinsics.checkNotNullExpressionValue(var19, "groupTypeProductAlerts");
         View var7 = (View)var19;
         NotificationSetting var20 = (NotificationSetting)this.getViewModel().getNotificationAllSettings().getValue();
         var5 = var6;
         if (var20 != null) {
            var5 = var20.isEnabled();
         }

         ViewExtensionsKt.show(var7, var5);
         this.getViewModel().getNotificationProductAlertSettings().observe(this.getViewLifecycleOwner(), new Observer(new NotificationCenterDialogFragment$$ExternalSyntheticLambda11(var8)) {
            private final Function1 function;

            {
               Intrinsics.checkNotNullParameter(var1, "function");
               this.function = var1;
            }

            public final boolean equals(Object var1) {
               return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
            }

            public final Function getFunctionDelegate() {
               return (Function)this.function;
            }

            public final int hashCode() {
               return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
            }

            // $FF: synthetic method
            public final void onChanged(Object var1) {
               this.function.invoke(var1);
            }
         });
         var8.tvTypeProductAlerts.setOnClickListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda12(this));
         var8.switchTypeProductAlerts.setOnCheckedChangeListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda13(this));
         var8.tvTypeProductAlertsLimit.setOnClickListener(new NotificationCenterDialogFragment$$ExternalSyntheticLambda14(this));
      }

      var8 = this.viewDataBinding;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var8 = (DialogNotificationCenterBinding)var11;
      }

      View var10 = var8.getRoot();
      Intrinsics.checkNotNullExpressionValue(var10, "getRoot(...)");
      return var10;
   }

   public void onResume() {
      super.onResume();
      DialogNotificationCenterBinding var3 = this.viewDataBinding;
      Object var2 = null;
      DialogNotificationCenterBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      TextView var4 = var1.permissionPromptBar;
      Intrinsics.checkNotNullExpressionValue(var4, "permissionPromptBar");
      View var6 = (View)var4;
      NotificationPermissionManager var5 = this.notificationPermissionManager;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("notificationPermissionManager");
         var5 = (NotificationPermissionManager)var2;
      }

      ViewExtensionsKt.show(var6, var5.isGranted() ^ true);
   }

   public void onStart() {
      super.onStart();
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            var2.setLayout(-1, -1);
         }
      }

   }

   public void setViewModel(NotificationCenterViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
      DialogNotificationCenterBinding var3 = this.viewDataBinding;
      DialogNotificationCenterBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      ProgressBlockerView var4 = var2.progressView;
      Intrinsics.checkNotNullExpressionValue(var4, "progressView");
      ViewExtensionsKt.show((View)var4, var1);
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/android/dialog/NotificationCenterDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/android/dialog/NotificationCenterDialogFragment;", "app_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final NotificationCenterDialogFragment newInstance() {
         return new NotificationCenterDialogFragment();
      }
   }
}
