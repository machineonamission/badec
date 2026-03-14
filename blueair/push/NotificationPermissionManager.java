package com.blueair.push;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blueair.core.service.UnsecurePrefs;
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
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.DIAware.DefaultImpls;
import org.kodein.di.android.ClosestKt;
import org.kodein.di.android.LazyContextDIPropertyDelegateProvider;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010-\u001a\u00020\u0007J\b\u0010.\u001a\u00020\u0007H\u0002J\b\u0010/\u001a\u00020\nH\u0003J\u0006\u00100\u001a\u00020\nJ\b\u00101\u001a\u00020\nH\u0003J\b\u00102\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b\u001e\u0010\u001fR+\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010(\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010*0*0)8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"},
   d2 = {"Lcom/blueair/push/NotificationPermissionManager;", "Lorg/kodein/di/DIAware;", "context", "Landroid/content/Context;", "activityResultCaller", "Landroidx/activity/result/ActivityResultCaller;", "alwaysShowRequest", "", "onPermissionGranted", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;Landroidx/activity/result/ActivityResultCaller;ZLkotlin/jvm/functions/Function0;)V", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity$delegate", "Lkotlin/Lazy;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "getPrefs", "()Lcom/blueair/core/service/UnsecurePrefs;", "prefs$delegate", "<set-?>", "isNotificationPermissionRejected", "()Z", "setNotificationPermissionRejected", "(Z)V", "isNotificationPermissionRejected$delegate", "Lkotlin/properties/ReadWriteProperty;", "notificationPermissionResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "underApi33", "isGranted", "shouldShowRequestPermissionRationale", "requestPermission", "checkAndRequest", "showNotificationPermissionRationaleDialog", "showNotificationPermissionDeniedDialog", "push_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class NotificationPermissionManager implements DIAware {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(NotificationPermissionManager.class, "di", "getDi()Lorg/kodein/di/DI;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(NotificationPermissionManager.class, "prefs", "getPrefs()Lcom/blueair/core/service/UnsecurePrefs;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(NotificationPermissionManager.class, "isNotificationPermissionRejected", "isNotificationPermissionRejected()Z", 0)))};
   private final Lazy activity$delegate;
   private final ActivityResultCaller activityResultCaller;
   private final boolean alwaysShowRequest;
   private final Context context;
   private final Lazy di$delegate;
   private final ReadWriteProperty isNotificationPermissionRejected$delegate;
   private final ActivityResultLauncher notificationPermissionResultLauncher;
   private final Function0 onPermissionGranted;
   private final Lazy prefs$delegate;
   private final boolean underApi33;

   // $FF: synthetic method
   public static Unit $r8$lambda$6kZUJFcxDYBpVDFCdvbFP2t8BOE(NotificationPermissionManager var0, boolean var1) {
      return showNotificationPermissionDeniedDialog$lambda$5$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$KlIdaTQmsEMDEYI4O939yiXC6QI(NotificationPermissionManager var0, Boolean var1) {
      notificationPermissionResultLauncher$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$XvN3wf0bh8Ok65jI_gccX4k07UQ(NotificationPermissionManager var0, boolean var1) {
      return showNotificationPermissionRationaleDialog$lambda$3$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static FragmentActivity $r8$lambda$vkUyFQKS9KZ_k04JZb6Tx3C4bO4/* $FF was: $r8$lambda$vkUyFQKS9KZ-k04JZb6Tx3C4bO4*/(NotificationPermissionManager var0) {
      return activity_delegate$lambda$0(var0);
   }

   public NotificationPermissionManager(Context var1, ActivityResultCaller var2, boolean var3, Function0 var4) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "activityResultCaller");
      super();
      this.context = var1;
      this.activityResultCaller = var2;
      this.alwaysShowRequest = var3;
      this.onPermissionGranted = var4;
      this.activity$delegate = LazyKt.lazy(new NotificationPermissionManager$$ExternalSyntheticLambda1(this));
      LazyContextDIPropertyDelegateProvider var10 = ClosestKt.closestDI(var1);
      KProperty[] var6 = $$delegatedProperties;
      var3 = false;
      this.di$delegate = var10.provideDelegate(this, var6[0]);
      DIAware var5 = this;
      JVMTypeToken var11 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var11, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.prefs$delegate = DIAwareKt.Instance(var5, (TypeToken)(new GenericJVMTypeTokenDelegate(var11, UnsecurePrefs.class)), (Object)null).provideDelegate(this, var6[1]);
      Prefs var7 = this.getPrefs();
      Boolean var12 = false;
      this.isNotificationPermissionRejected$delegate = (ReadWriteProperty)(new ObservableProperty(var7, "KEY_NOTIFICATION_PERMISSION_REJECTED", var12, PreferencesHelper.INSTANCE.get(var7.getBackend(), "KEY_NOTIFICATION_PERMISSION_REJECTED", var12, Reflection.getOrCreateKotlinClass(Boolean.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var5 = this.$prefs;
               String var4 = this.$key;
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      ActivityResultLauncher var8 = var2.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.RequestPermission()), new NotificationPermissionManager$$ExternalSyntheticLambda2(this));
      Intrinsics.checkNotNullExpressionValue(var8, "registerForActivityResult(...)");
      this.notificationPermissionResultLauncher = var8;
      if (VERSION.SDK_INT < 33) {
         var3 = true;
      }

      this.underApi33 = var3;
   }

   // $FF: synthetic method
   public NotificationPermissionManager(Context var1, ActivityResultCaller var2, boolean var3, Function0 var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 4) != 0) {
         var3 = false;
      }

      if ((var5 & 8) != 0) {
         var4 = null;
      }

      this(var1, var2, var3, var4);
   }

   private static final FragmentActivity activity_delegate$lambda$0(NotificationPermissionManager var0) {
      ActivityResultCaller var1 = var0.activityResultCaller;
      if (var1 instanceof FragmentActivity) {
         return (FragmentActivity)var1;
      } else {
         Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
         FragmentActivity var2 = ((Fragment)var1).requireActivity();
         Intrinsics.checkNotNull(var2);
         return var2;
      }
   }

   private final FragmentActivity getActivity() {
      return (FragmentActivity)this.activity$delegate.getValue();
   }

   private final FragmentManager getFragmentManager() {
      FragmentManager var1 = this.getActivity().getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var1, "getSupportFragmentManager(...)");
      return var1;
   }

   private final UnsecurePrefs getPrefs() {
      return (UnsecurePrefs)this.prefs$delegate.getValue();
   }

   private final boolean isNotificationPermissionRejected() {
      return (Boolean)this.isNotificationPermissionRejected$delegate.getValue(this, $$delegatedProperties[2]);
   }

   private static final void notificationPermissionResultLauncher$lambda$1(NotificationPermissionManager var0, Boolean var1) {
      if (var1) {
         Function0 var2 = var0.onPermissionGranted;
         if (var2 != null) {
            var2.invoke();
            return;
         }
      } else if (!var0.shouldShowRequestPermissionRationale()) {
         var0.showNotificationPermissionDeniedDialog();
         return;
      }

   }

   private final void requestPermission() {
      DialogUtils.INSTANCE.showRequestPermissionHint(com.blueair.viewcore.R.string.permission_request_title_notification, com.blueair.viewcore.R.string.permission_request_message_notification);
      this.notificationPermissionResultLauncher.launch("android.permission.POST_NOTIFICATIONS");
   }

   private final void setNotificationPermissionRejected(boolean var1) {
      this.isNotificationPermissionRejected$delegate.setValue(this, $$delegatedProperties[2], var1);
   }

   private final boolean shouldShowRequestPermissionRationale() {
      return this.underApi33 ? true : ActivityCompat.shouldShowRequestPermissionRationale((Activity)this.getActivity(), "android.permission.POST_NOTIFICATIONS");
   }

   private final void showNotificationPermissionDeniedDialog() {
      if (this.alwaysShowRequest || !this.isNotificationPermissionRejected()) {
         FragmentManager var1 = this.getFragmentManager();
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var1.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var1.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, com.blueair.viewcore.R.string.notification_permission_dialog_denied_title, (Integer)null, com.blueair.viewcore.R.string.notification_permission_dialog_denied_content, com.blueair.viewcore.R.string.btn_goto_settings, com.blueair.viewcore.R.string.reject, false, false, true, true, (String[])null, (String)null, (Integer)null, new NotificationPermissionManager$$ExternalSyntheticLambda0(this), 3680, (Object)null)).show(var1, "ConfirmationDialogLeftAligned");
         }
      }

   }

   private static final Unit showNotificationPermissionDeniedDialog$lambda$5$lambda$4(NotificationPermissionManager var0, boolean var1) {
      if (var1) {
         AppSettingsIntent.INSTANCE.start((Context)var0.getActivity());
      } else {
         var0.setNotificationPermissionRejected(true);
      }

      return Unit.INSTANCE;
   }

   private final void showNotificationPermissionRationaleDialog() {
      if (this.alwaysShowRequest || !this.isNotificationPermissionRejected()) {
         FragmentManager var1 = this.getFragmentManager();
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var1.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var1.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, com.blueair.viewcore.R.string.notification_permission_dialog_request_title, (Integer)null, com.blueair.viewcore.R.string.notification_permission_dialog_request_content, com.blueair.viewcore.R.string.agree, com.blueair.viewcore.R.string.reject, false, false, true, true, (String[])null, (String)null, (Integer)null, new NotificationPermissionManager$$ExternalSyntheticLambda3(this), 3680, (Object)null)).show(var1, "ConfirmationDialogLeftAligned");
         }
      }

   }

   private static final Unit showNotificationPermissionRationaleDialog$lambda$3$lambda$2(NotificationPermissionManager var0, boolean var1) {
      if (var1) {
         var0.requestPermission();
      } else {
         var0.setNotificationPermissionRejected(true);
      }

      return Unit.INSTANCE;
   }

   public final void checkAndRequest() {
      if (this.isGranted()) {
         Function0 var1 = this.onPermissionGranted;
         if (var1 != null) {
            var1.invoke();
            return;
         }
      } else {
         if (this.shouldShowRequestPermissionRationale()) {
            if (this.underApi33) {
               this.showNotificationPermissionDeniedDialog();
               return;
            }

            this.showNotificationPermissionRationaleDialog();
            return;
         }

         if (!this.underApi33) {
            this.requestPermission();
         }
      }

   }

   public DI getDi() {
      return (DI)this.di$delegate.getValue();
   }

   public DIContext getDiContext() {
      return DefaultImpls.getDiContext(this);
   }

   public DITrigger getDiTrigger() {
      return DefaultImpls.getDiTrigger(this);
   }

   public final boolean isGranted() {
      if (this.underApi33) {
         return NotificationManagerCompat.from(this.context).areNotificationsEnabled();
      } else {
         return ContextCompat.checkSelfPermission((Context)this.getActivity(), "android.permission.POST_NOTIFICATIONS") == 0;
      }
   }
}
