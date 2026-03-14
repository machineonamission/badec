package com.blueair.android.dialog;

import android.app.Dialog;
import android.content.Context;
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
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.adapter.SmartIntegrationDevicesAdapter;
import com.blueair.android.databinding.DialogfragmentSmartIntegrationsBinding;
import com.blueair.android.fragment.integration.Integration;
import com.blueair.android.fragment.integration.IotDeviceConfig;
import com.blueair.android.viewmodel.HomeViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J$\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0018\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)*\b\u0012\u0004\u0012\u00020*0)H\u0002J\u0012\u0010+\u001a\u00020,2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010-\u001a\u00020\u001dH\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\b\u0010/\u001a\u00020\u001dH\u0016J\u0010\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u000202H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u00064"},
   d2 = {"Lcom/blueair/android/dialog/SmartIntegrationsDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/android/viewmodel/HomeViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/android/databinding/DialogfragmentSmartIntegrationsBinding;", "viewModel", "getViewModel", "()Lcom/blueair/android/viewmodel/HomeViewModel;", "setViewModel", "(Lcom/blueair/android/viewmodel/HomeViewModel;)V", "deviceClickPublisher", "Lio/reactivex/subjects/PublishSubject;", "getDeviceClickPublisher", "()Lio/reactivex/subjects/PublishSubject;", "deviceClickPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "adapter", "Lcom/blueair/android/adapter/SmartIntegrationDevicesAdapter;", "getAdapter", "()Lcom/blueair/android/adapter/SmartIntegrationDevicesAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "configured", "", "Lcom/blueair/android/fragment/integration/IotDeviceConfig;", "onCreateDialog", "Landroid/app/Dialog;", "onStart", "onResume", "onStop", "showProgress", "shouldShowProgress", "", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SmartIntegrationsDialogFragment extends BaseDialogFragment {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(SmartIntegrationsDialogFragment.class, "deviceClickPublisher", "getDeviceClickPublisher()Lio/reactivex/subjects/PublishSubject;", 0)))};
   public static final int $stable = 8;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String SMART_INTEGRATION_NAME = "smart_integration_name";
   private final Lazy adapter$delegate = LazyKt.lazy(new SmartIntegrationsDialogFragment$$ExternalSyntheticLambda1(this));
   private final LazyPublishSubject deviceClickPublisher$delegate = new LazyPublishSubject();
   private final String screenName = "side_menu_voice_assistant_alexa_old";
   private DialogfragmentSmartIntegrationsBinding viewDataBinding;
   public HomeViewModel viewModel;

   // $FF: synthetic method
   public static boolean $r8$lambda$1TSsvpQgl7mYeTTStaVrjcOQKUo(SmartIntegrationsDialogFragment var0, IotDeviceConfig var1) {
      return configured$lambda$4$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$7ZzmWm_1ODt1TlyYc_jVCVg4u4I/* $FF was: $r8$lambda$7ZzmWm_1ODt1TlyYc-jVCVg4u4I*/(SmartIntegrationsDialogFragment var0, MenuItem var1) {
      return onCreateView$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$CcZcQOp7sDbphVhFoEPX1p9o6dg(SmartIntegrationsDialogFragment var0, String var1) {
      return onResume$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static SmartIntegrationDevicesAdapter $r8$lambda$Uoqyz0Ukwe1o2jWrELpqMCVoqz0(SmartIntegrationsDialogFragment var0) {
      return adapter_delegate$lambda$0(var0);
   }

   private static final SmartIntegrationDevicesAdapter adapter_delegate$lambda$0(SmartIntegrationsDialogFragment var0) {
      return new SmartIntegrationDevicesAdapter(var0.getDeviceClickPublisher(), var0.getViewModel().isInG4ProtectRegion());
   }

   private final List configured(List var1) {
      var1 = CollectionsKt.toMutableList((Collection)var1);
      CollectionsKt.removeAll(var1, new SmartIntegrationsDialogFragment$$ExternalSyntheticLambda0(this));
      return var1;
   }

   private static final boolean configured$lambda$4$lambda$3(SmartIntegrationsDialogFragment var0, IotDeviceConfig var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      return !var0.getViewModel().isInB4Region() && var1.getNameRes() == R.string.blueair_b4 || !var0.getViewModel().isInG4Region() && var1.getNameRes() == R.string.blueair_g4;
   }

   private final SmartIntegrationDevicesAdapter getAdapter() {
      return (SmartIntegrationDevicesAdapter)this.adapter$delegate.getValue();
   }

   private final PublishSubject getDeviceClickPublisher() {
      return this.deviceClickPublisher$delegate.getValue(this, $$delegatedProperties[0]);
   }

   private static final boolean onCreateView$lambda$1(SmartIntegrationsDialogFragment var0, MenuItem var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.dismiss();
      return true;
   }

   private static final Unit onResume$lambda$7(SmartIntegrationsDialogFragment var0, String var1) {
      var0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var1)));
      return Unit.INSTANCE;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public HomeViewModel getViewModel() {
      HomeViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setStyle(0, R.style.DialogTheme);
   }

   public Dialog onCreateDialog(Bundle var1) {
      Timber.Forest.d("DialogFragment: onCreateDialog", new Object[0]);
      Dialog var4 = new Dialog(this.requireContext());
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("onCreateDialog: dialog = ");
      var2.append(var4);
      var3.d(var2.toString(), new Object[0]);
      FragmentActivity var5 = this.getActivity();
      if (var5 != null) {
         Window var6 = var4.getWindow();
         if (var6 != null) {
            var6.setBackgroundDrawable(ContextCompat.getDrawable((Context)var5, R.drawable.top_rounded_rectangle_white));
         }
      }

      return var4;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      DialogfragmentSmartIntegrationsBinding var7 = DialogfragmentSmartIntegrationsBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var7, "inflate(...)");
      this.viewDataBinding = var7;
      this.setViewModel((HomeViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(HomeViewModel.class)));
      Bundle var8 = this.getArguments();
      Object var21 = null;
      String var9;
      if (var8 != null) {
         var9 = var8.getString("smart_integration_name");
      } else {
         var9 = null;
      }

      if (var9 != null) {
         DialogfragmentSmartIntegrationsBinding var5 = this.viewDataBinding;
         DialogfragmentSmartIntegrationsBinding var14 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var14 = null;
         }

         var14.toolbar.getMenu().findItem(com.blueair.devicedetails.R.id.action_close).setOnMenuItemClickListener(new SmartIntegrationsDialogFragment$$ExternalSyntheticLambda2(this));
         DividerItemDecoration var6 = new DividerItemDecoration(this.getContext(), 1);
         Resources var22 = this.getResources();
         int var4 = com.blueair.devicedetails.R.drawable.item_decoration;
         FragmentActivity var15 = this.getActivity();
         Resources.Theme var16;
         if (var15 != null) {
            var16 = var15.getTheme();
         } else {
            var16 = null;
         }

         Drawable var17 = ResourcesCompat.getDrawable(var22, var4, var16);
         if (var17 != null) {
            var6.setDrawable(var17);
         }

         DialogfragmentSmartIntegrationsBinding var23 = this.viewDataBinding;
         DialogfragmentSmartIntegrationsBinding var18 = var23;
         if (var23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var18 = null;
         }

         var18.recyclerViewDevices.setAdapter(this.getAdapter());
         SmartIntegrationDevicesAdapter var19 = this.getAdapter();
         List var10;
         if (Intrinsics.areEqual(var9, Integration.AmazonAlexaOld.getIntegrationName())) {
            var10 = this.configured(Integration.AmazonAlexaOld.getDevices());
         } else if (Intrinsics.areEqual(var9, Integration.Tmall.getIntegrationName())) {
            var10 = this.configured(Integration.Tmall.getDevices());
         } else {
            var10 = this.configured(Integration.GoogleAssistant.getDevices());
         }

         var19.setDevices(var10);
         DialogfragmentSmartIntegrationsBinding var20 = this.viewDataBinding;
         DialogfragmentSmartIntegrationsBinding var11 = var20;
         if (var20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var11 = null;
         }

         var11.recyclerViewDevices.addItemDecoration((RecyclerView.ItemDecoration)var6);
         var11 = this.viewDataBinding;
         if (var11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var11 = (DialogfragmentSmartIntegrationsBinding)var21;
         }

         View var13 = var11.getRoot();
         Intrinsics.checkNotNullExpressionValue(var13, "getRoot(...)");
         return var13;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public void onResume() {
      super.onResume();
      this.getRxSubs().add(RxExtensionsKt.subscribeAndLogE((Observable)this.getDeviceClickPublisher(), new SmartIntegrationsDialogFragment$$ExternalSyntheticLambda3(this)));
   }

   public void onStart() {
      super.onStart();
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            var2.setLayout(-1, -2);
         }

         Window var3 = var1.getWindow();
         if (var3 != null) {
            var3.setGravity(80);
         }
      }

   }

   public void onStop() {
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            WindowManager.LayoutParams var3 = var2.getAttributes();
            if (var3 != null) {
               var3.windowAnimations = R.style.dialog_animation_exit_only;
            }
         }
      }

      super.onStop();
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      Dialog var3 = this.getDialog();
      if (var3 != null) {
         Window var4 = var3.getWindow();
         if (var4 != null) {
            WindowManager.LayoutParams var5 = var4.getAttributes();
            if (var5 != null) {
               var5.windowAnimations = R.style.dialog_animation;
            }
         }
      }

   }

   public void setViewModel(HomeViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"},
      d2 = {"Lcom/blueair/android/dialog/SmartIntegrationsDialogFragment$Companion;", "", "<init>", "()V", "SMART_INTEGRATION_NAME", "", "newInstance", "Lcom/blueair/android/dialog/SmartIntegrationsDialogFragment;", "smartIntegrationName", "app_otherRelease"},
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

      public final SmartIntegrationsDialogFragment newInstance(String var1) {
         Intrinsics.checkNotNullParameter(var1, "smartIntegrationName");
         SmartIntegrationsDialogFragment var2 = new SmartIntegrationsDialogFragment();
         Bundle var3 = new Bundle();
         var3.putString("smart_integration_name", var1);
         var2.setArguments(var3);
         return var2;
      }
   }
}
