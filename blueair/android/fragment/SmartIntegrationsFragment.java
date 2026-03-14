package com.blueair.android.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.R;
import com.blueair.android.activity.AccountLinkingActivity;
import com.blueair.android.databinding.FragmentSmartIntegrationsBinding;
import com.blueair.android.dialog.SmartIntegrationsDialogFragment;
import com.blueair.android.fragment.integration.Integration;
import com.blueair.android.fragment.integration.IntegrationItem;
import com.blueair.android.viewmodel.HomeViewModel;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#H\u0002J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0012H\u0002J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020#H\u0016R\u001a\u0010\u0005\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"},
   d2 = {"Lcom/blueair/android/fragment/SmartIntegrationsFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/android/viewmodel/HomeViewModel;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/blueair/android/viewmodel/HomeViewModel;", "setViewModel", "(Lcom/blueair/android/viewmodel/HomeViewModel;)V", "viewDataBinding", "Lcom/blueair/android/databinding/FragmentSmartIntegrationsBinding;", "getViewDataBinding", "()Lcom/blueair/android/databinding/FragmentSmartIntegrationsBinding;", "setViewDataBinding", "(Lcom/blueair/android/databinding/FragmentSmartIntegrationsBinding;)V", "itemAdapter", "Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "Lcom/blueair/android/fragment/integration/IntegrationItem;", "googleLinkingLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "alexaLinkingLauncher", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getItems", "", "googleLinked", "", "alexaLinked", "onViewCreated", "", "view", "onItemClick", "item", "showProgress", "shouldShowProgress", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SmartIntegrationsFragment extends BaseFragment {
   public static final int $stable = 8;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final ActivityResultLauncher alexaLinkingLauncher;
   private final ActivityResultLauncher googleLinkingLauncher;
   private final ItemAdapter itemAdapter = new ItemAdapter();
   public FragmentSmartIntegrationsBinding viewDataBinding;
   public HomeViewModel viewModel;

   // $FF: synthetic method
   public static boolean $r8$lambda$5XKHqQjROfGe5MZoN_iyY1C4BKo/* $FF was: $r8$lambda$5XKHqQjROfGe5MZoN-iyY1C4BKo*/(SmartIntegrationsFragment var0, View var1, IAdapter var2, IntegrationItem var3, int var4) {
      return onCreateView$lambda$2(var0, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Nn4HtnvnaNbKVogDXHtrHxne8Xc(SmartIntegrationsFragment var0, ActivityResult var1) {
      googleLinkingLauncher$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$UMCEuUc1PClssuzh6z8d9GQzOsE(SmartIntegrationsFragment var0, Boolean var1) {
      return onViewCreated$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$VFUtzo8ZQeJRTGF3ijFc9rRMU_s(SmartIntegrationsFragment var0, Boolean var1) {
      return onViewCreated$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$WvS0fv_m0PFkMKtz_7W_eL1Q0aY/* $FF was: $r8$lambda$WvS0fv_m0PFkMKtz_7W-eL1Q0aY*/(SmartIntegrationsFragment var0, boolean var1) {
      return onViewCreated$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$fjlcOHalk4MwJHlDhhqs5Y7w_7Y(SmartIntegrationsFragment var0, ActivityResult var1) {
      alexaLinkingLauncher$lambda$1(var0, var1);
   }

   public SmartIntegrationsFragment() {
      ActivityResultLauncher var1 = this.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.StartActivityForResult()), new SmartIntegrationsFragment$$ExternalSyntheticLambda0(this));
      Intrinsics.checkNotNullExpressionValue(var1, "registerForActivityResult(...)");
      this.googleLinkingLauncher = var1;
      var1 = this.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.StartActivityForResult()), new SmartIntegrationsFragment$$ExternalSyntheticLambda1(this));
      Intrinsics.checkNotNullExpressionValue(var1, "registerForActivityResult(...)");
      this.alexaLinkingLauncher = var1;
   }

   private static final void alexaLinkingLauncher$lambda$1(SmartIntegrationsFragment var0, ActivityResult var1) {
      MutableLiveData var2 = var0.getViewModel().getAlexaLinked();
      Intent var3 = var1.getData();
      Boolean var4;
      if (var3 != null) {
         var4 = var3.getBooleanExtra("EXTRA_LINKED", false);
      } else {
         var4 = null;
      }

      var2.setValue(var4);
   }

   private final List getItems(boolean var1, boolean var2) {
      List var3 = CollectionsKt.createListBuilder();
      if (this.getViewModel().isInTmallRegion() && (this.getViewModel().isInB4Region() || this.getViewModel().isInG4Region())) {
         var3.add(new IntegrationItem(Integration.Tmall, false, new Function1(this) {
            public final void invoke(IntegrationItem var1) {
               Intrinsics.checkNotNullParameter(var1, "p0");
               ((SmartIntegrationsFragment)this.receiver).onItemClick(var1);
            }
         }));
      }

      if (this.getViewModel().isInAlexaRegion()) {
         var3.addAll((Collection)CollectionsKt.listOf(new IntegrationItem[]{new IntegrationItem(Integration.AmazonAlexa, var2, new Function1(this) {
            public final void invoke(IntegrationItem var1) {
               Intrinsics.checkNotNullParameter(var1, "p0");
               ((SmartIntegrationsFragment)this.receiver).onItemClick(var1);
            }
         }), new IntegrationItem(Integration.AmazonAlexaOld, false, new Function1(this) {
            public final void invoke(IntegrationItem var1) {
               Intrinsics.checkNotNullParameter(var1, "p0");
               ((SmartIntegrationsFragment)this.receiver).onItemClick(var1);
            }
         })}));
      }

      if (this.getViewModel().isInGoogleAssistantRegion()) {
         var3.add(new IntegrationItem(Integration.GoogleAssistant, var1, new Function1(this) {
            public final void invoke(IntegrationItem var1) {
               Intrinsics.checkNotNullParameter(var1, "p0");
               ((SmartIntegrationsFragment)this.receiver).onItemClick(var1);
            }
         }));
      }

      return CollectionsKt.build(var3);
   }

   // $FF: synthetic method
   static List getItems$default(SmartIntegrationsFragment var0, boolean var1, boolean var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = false;
      }

      if ((var3 & 2) != 0) {
         var2 = false;
      }

      return var0.getItems(var1, var2);
   }

   private static final void googleLinkingLauncher$lambda$0(SmartIntegrationsFragment var0, ActivityResult var1) {
      MutableLiveData var2 = var0.getViewModel().getGoogleLinked();
      Intent var3 = var1.getData();
      Boolean var4;
      if (var3 != null) {
         var4 = var3.getBooleanExtra("EXTRA_LINKED", false);
      } else {
         var4 = null;
      }

      var2.setValue(var4);
   }

   private static final boolean onCreateView$lambda$2(SmartIntegrationsFragment var0, View var1, IAdapter var2, IntegrationItem var3, int var4) {
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      Intrinsics.checkNotNullParameter(var3, "item");
      var0.onItemClick(var3);
      return true;
   }

   private final void onItemClick(IntegrationItem var1) {
      if (SetsKt.setOf(new Integration[]{Integration.AmazonAlexa, Integration.GoogleAssistant}).contains(var1.getIntegration())) {
         Integration var3 = var1.getIntegration();
         ActivityResultLauncher var4;
         if (SmartIntegrationsFragment.WhenMappings.$EnumSwitchMapping$0[var3.ordinal()] == 1) {
            var4 = this.googleLinkingLauncher;
         } else {
            var4 = this.alexaLinkingLauncher;
         }

         var4.launch((new Intent(this.requireContext(), AccountLinkingActivity.class)).putExtra("EXTRA_NAME", var1.getIntegration().name()).putExtra("EXTRA_LINKED", var1.getLinked()));
      } else {
         FragmentManager var2 = this.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("SmartIntegrationsDialogFragment", "getSimpleName(...)");
         if (!(var2.findFragmentByTag("SmartIntegrationsDialogFragment") instanceof SmartIntegrationsDialogFragment) && !var2.isStateSaved()) {
            ((DialogFragment)SmartIntegrationsDialogFragment.Companion.newInstance(var1.getIntegration().getIntegrationName())).show(var2, "SmartIntegrationsDialogFragment");
         }

      }
   }

   private static final Unit onViewCreated$lambda$4(SmartIntegrationsFragment var0, boolean var1) {
      ProgressBlockerView var3 = var0.getViewDataBinding().loading;
      Intrinsics.checkNotNullExpressionValue(var3, "loading");
      View var4 = (View)var3;
      byte var2;
      if (var1) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      var4.setVisibility(var2);
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$5(SmartIntegrationsFragment var0, Boolean var1) {
      Intrinsics.checkNotNull(var1);
      boolean var4 = var1;
      var1 = (Boolean)var0.getViewModel().getAlexaLinked().getValue();
      byte var2 = 0;
      boolean var3;
      if (var1 != null) {
         var3 = var1;
      } else {
         var3 = false;
      }

      List var8 = var0.getItems(var4, var3);
      var0.itemAdapter.set(var8);
      TextView var5 = var0.getViewDataBinding().txtNoIntegrations;
      Intrinsics.checkNotNullExpressionValue(var5, "txtNoIntegrations");
      View var6 = (View)var5;
      if (!var8.isEmpty()) {
         var2 = 8;
      }

      var6.setVisibility(var2);
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$6(SmartIntegrationsFragment var0, Boolean var1) {
      Boolean var4 = (Boolean)var0.getViewModel().getGoogleLinked().getValue();
      byte var2 = 0;
      boolean var3;
      if (var4 != null) {
         var3 = var4;
      } else {
         var3 = false;
      }

      Intrinsics.checkNotNull(var1);
      List var7 = var0.getItems(var3, var1);
      var0.itemAdapter.set(var7);
      TextView var5 = var0.getViewDataBinding().txtNoIntegrations;
      Intrinsics.checkNotNullExpressionValue(var5, "txtNoIntegrations");
      View var6 = (View)var5;
      if (!var7.isEmpty()) {
         var2 = 8;
      }

      var6.setVisibility(var2);
      return Unit.INSTANCE;
   }

   public final FragmentSmartIntegrationsBinding getViewDataBinding() {
      FragmentSmartIntegrationsBinding var1 = this.viewDataBinding;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         return null;
      }
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

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      ViewDataBinding var5 = DataBindingUtil.inflate(var1, R.layout.fragment_smart_integrations, var2, false);
      Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
      this.setViewDataBinding((FragmentSmartIntegrationsBinding)var5);
      FragmentActivity var6 = ((BaseFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var6, "requireActivity(...)");
      this.setViewModel((HomeViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var6)).get(HomeViewModel.class)));
      List var7 = getItems$default(this, false, false, 3, (Object)null);
      TextView var10 = this.getViewDataBinding().txtNoIntegrations;
      Intrinsics.checkNotNullExpressionValue(var10, "txtNoIntegrations");
      View var11 = (View)var10;
      byte var4;
      if (var7.isEmpty()) {
         var4 = 0;
      } else {
         var4 = 8;
      }

      var11.setVisibility(var4);
      this.itemAdapter.add(var7);
      FastAdapter var8 = FastAdapter.Companion.with((IAdapter)this.itemAdapter);
      var8.setOnClickListener(new SmartIntegrationsFragment$$ExternalSyntheticLambda2(this));
      this.getViewDataBinding().integrationsRecycler.swapAdapter((RecyclerView.Adapter)var8, false);
      View var9 = this.getViewDataBinding().getRoot();
      Intrinsics.checkNotNullExpressionValue(var9, "getRoot(...)");
      return var9;
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      LiveData var6 = this.getViewModel().getFetchingSmartIntegrationStatus();
      LifecycleOwner var3 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var3, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var6, var3, new SmartIntegrationsFragment$$ExternalSyntheticLambda3(this));
      LiveData var4 = (LiveData)this.getViewModel().getGoogleLinked();
      LifecycleOwner var7 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var7, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var4, var7, new SmartIntegrationsFragment$$ExternalSyntheticLambda4(this));
      LiveData var8 = (LiveData)this.getViewModel().getAlexaLinked();
      LifecycleOwner var5 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var5, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var8, var5, new SmartIntegrationsFragment$$ExternalSyntheticLambda5(this));
      if (this.getViewModel().isInGoogleAssistantRegion()) {
         this.getViewModel().getGoogleLinkStatus();
      }

      if (this.getViewModel().isInAlexaRegion()) {
         this.getViewModel().getAlexaLinkStatus();
      }

   }

   public final void setViewDataBinding(FragmentSmartIntegrationsBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewDataBinding = var1;
   }

   public void setViewModel(HomeViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/android/fragment/SmartIntegrationsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/android/fragment/SmartIntegrationsFragment;", "app_otherRelease"},
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

      public final SmartIntegrationsFragment newInstance() {
         return new SmartIntegrationsFragment();
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[Integration.values().length];

         try {
            var0[Integration.GoogleAssistant.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
