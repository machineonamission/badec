package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import com.blueair.core.model.Device;
import com.blueair.core.model.Filter;
import com.blueair.core.model.FilterKt;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.devicedetails.adapter.FilterPagerAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceFilterSelectionBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsState;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.fragment.BaseFragmentInterface$_CC;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.fragment.ProgressFragment$_CC;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.ScrollingPageIndicatorAccessibilityDelegate;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001?B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0017J\u0012\u0010.\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010/\u001a\u00020+H\u0016J\b\u00100\u001a\u00020+H\u0016J\u0012\u00101\u001a\u0002022\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J$\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u00109\u001a\u00020+2\u0006\u0010:\u001a\u0002042\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020+H\u0002R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006@"},
   d2 = {"Lcom/blueair/devicedetails/dialog/FilterSelectionDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceFilterSelectionBinding;", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "pagerAdapter", "Lcom/blueair/devicedetails/adapter/FilterPagerAdapter;", "getPagerAdapter", "()Lcom/blueair/devicedetails/adapter/FilterPagerAdapter;", "pagerAdapter$delegate", "Lkotlin/Lazy;", "toolbarTitleView", "Landroid/widget/TextView;", "getToolbarTitleView", "()Landroid/widget/TextView;", "toolbarTitleView$delegate", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onStart", "onStop", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "showProgress", "shouldShowProgress", "", "bindViewModel", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FilterSelectionDialogFragment extends BaseDialogFragment implements ProgressFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public Device device;
   private final Lazy pagerAdapter$delegate = LazyKt.lazy(new FilterSelectionDialogFragment$$ExternalSyntheticLambda2(this));
   private ProgressBlockerView progressBlockerView;
   private final String screenName;
   private final Lazy toolbarTitleView$delegate = LazyKt.lazy(new FilterSelectionDialogFragment$$ExternalSyntheticLambda3(this));
   private DialogfragmentDeviceFilterSelectionBinding viewDataBinding;
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static TextView $r8$lambda$0AYu1gfBgo50xI55c46Rlx_Sd98(FilterSelectionDialogFragment var0) {
      return toolbarTitleView_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$1hrztmpslteKw_9cfywjJBOP4sY/* $FF was: $r8$lambda$1hrztmpslteKw-9cfywjJBOP4sY*/(FilterSelectionDialogFragment var0, View var1) {
      onCreateView$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static FilterPagerAdapter $r8$lambda$6e1JpUHBQKXPZmuGjhIiZxn62D4(FilterSelectionDialogFragment var0) {
      return pagerAdapter_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$A9F0QC_SI_30Ln5IJKbGEUwy3A8/* $FF was: $r8$lambda$A9F0QC_SI-30Ln5IJKbGEUwy3A8*/(FilterSelectionDialogFragment var0, DeviceDetailsState var1) {
      return bindViewModel$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$ElW3QbdRwtXeyXmkVHepEZobrbI(FilterSelectionDialogFragment var0, View var1) {
      onCreateView$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$PAOgae0w5W7BmEX76cftuBNvh_E(FilterSelectionDialogFragment var0, Device var1) {
      return bindViewModel$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static int $r8$lambda$UVPo_MSvtbeIQlodtCnWMivjl0s/* $FF was: $r8$lambda$UVPo-MSvtbeIQlodtCnWMivjl0s*/(FilterSelectionDialogFragment var0) {
      return onCreateView$lambda$9(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$oiTdKPNnofV7tITdbpmF1A5Itw4(FilterSelectionDialogFragment var0, View var1) {
      onCreateView$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static int $r8$lambda$rq_APWUyS2V9kRNcPgUj_Aqm9F0/* $FF was: $r8$lambda$rq-APWUyS2V9kRNcPgUj-Aqm9F0*/(FilterSelectionDialogFragment var0) {
      return onCreateView$lambda$10(var0);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$x6Jd_5MgTEXpMkpQuQl7nWqmjus/* $FF was: $r8$lambda$x6Jd-5MgTEXpMkpQuQl7nWqmjus*/(FilterSelectionDialogFragment var0, MenuItem var1) {
      return onCreateView$lambda$5(var0, var1);
   }

   private final void bindViewModel() {
      LiveData var2 = this.getViewModel().getDeviceDetailsState();
      LifecycleOwner var1 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var1, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var2, var1, new FilterSelectionDialogFragment$$ExternalSyntheticLambda4(this));
      var2 = this.getViewModel().getLiveDevice();
      var1 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var1, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var2, var1, new FilterSelectionDialogFragment$$ExternalSyntheticLambda5(this));
   }

   private static final Unit bindViewModel$lambda$13(FilterSelectionDialogFragment var0, DeviceDetailsState var1) {
      Intrinsics.checkNotNullParameter(var1, "state");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("device state: ");
      var2.append(var1);
      var3.d(var2.toString(), new Object[0]);
      var0.setDevice(var1.getDevice());
      Device var5 = var0.getDevice();
      if (var5 instanceof HasFanSpeed) {
         FilterPagerAdapter var4 = var0.getPagerAdapter();
         HasFanSpeed var6 = (HasFanSpeed)var5;
         var4.setDevice(var6);
         var0.getPagerAdapter().setFilters(FilterKt.getSupportedFilters(var6));
      }

      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$14(FilterSelectionDialogFragment var0, Device var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("liveDevice = ");
      var3.append(var1);
      var2.v(var3.toString(), new Object[0]);
      var0.getViewModel().setDevice(var1);
      return Unit.INSTANCE;
   }

   private final FilterPagerAdapter getPagerAdapter() {
      return (FilterPagerAdapter)this.pagerAdapter$delegate.getValue();
   }

   private static final int onCreateView$lambda$10(FilterSelectionDialogFragment var0) {
      DialogfragmentDeviceFilterSelectionBinding var1 = var0.viewDataBinding;
      DialogfragmentDeviceFilterSelectionBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      RecyclerView.Adapter var3 = var2.filterPager.getAdapter();
      return var3 != null ? var3.getItemCount() : 0;
   }

   private static final void onCreateView$lambda$11(FilterSelectionDialogFragment var0, View var1) {
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("current item: ");
      DialogfragmentDeviceFilterSelectionBinding var2 = var0.viewDataBinding;
      DialogfragmentDeviceFilterSelectionBinding var5 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var5 = null;
      }

      var3.append(var5.filterPager.getCurrentItem());
      var3.append(" & filters in adapter: ");
      var3.append(var0.getPagerAdapter().getFilters());
      var4.d(var3.toString(), new Object[0]);
      if (!((Collection)var0.getPagerAdapter().getFilters()).isEmpty()) {
         BaseFragmentInterface$_CC.showProgress$default(var0, false, 1, (Object)null);
         List var11 = var0.getPagerAdapter().getFilters();
         var2 = var0.viewDataBinding;
         var5 = var2;
         if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var5 = null;
         }

         Filter var7 = (Filter)var11.get(var5.filterPager.getCurrentItem());
         Timber.Forest var9 = Timber.Forest;
         StringBuilder var12 = new StringBuilder("selected filter: ");
         var12.append(var7);
         var9.d(var12.toString(), new Object[0]);
         LifecycleOwner var10 = var0.getViewLifecycleOwner();
         Intrinsics.checkNotNullExpressionValue(var10, "getViewLifecycleOwner(...)");
         BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var10), (CoroutineContext)Dispatchers.getMain(), (CoroutineStart)null, new Function2(var0, var7, (Continuation)null) {
            final Filter $selectedFilter;
            int label;
            final FilterSelectionDialogFragment this$0;

            {
               this.this$0 = var1;
               this.$selectedFilter = var2;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$selectedFilter, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  DeviceDetailsViewModel var5 = this.this$0.getViewModel();
                  Device var6 = this.this$0.getDevice();
                  var1 = this.$selectedFilter;
                  Continuation var4 = (Continuation)this;
                  this.label = 1;
                  if (var5.setFilter(var6, var1, var4) == var3) {
                     return var3;
                  }
               }

               this.this$0.dismiss();
               return Unit.INSTANCE;
            }
         }, 2, (Object)null);
      }

   }

   private static final boolean onCreateView$lambda$5(FilterSelectionDialogFragment var0, MenuItem var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.dismiss();
      return true;
   }

   private static final void onCreateView$lambda$6(FilterSelectionDialogFragment var0, View var1) {
      DialogfragmentDeviceFilterSelectionBinding var3 = var0.viewDataBinding;
      DialogfragmentDeviceFilterSelectionBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      var2.filterPager.setCurrentItem(0, true);
   }

   private static final void onCreateView$lambda$7(FilterSelectionDialogFragment var0, View var1) {
      DialogfragmentDeviceFilterSelectionBinding var2 = var0.viewDataBinding;
      DialogfragmentDeviceFilterSelectionBinding var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var3 = null;
      }

      var3.filterPager.setCurrentItem(var0.getPagerAdapter().getItemCount() - 1, true);
   }

   private static final int onCreateView$lambda$9(FilterSelectionDialogFragment var0) {
      DialogfragmentDeviceFilterSelectionBinding var1 = var0.viewDataBinding;
      DialogfragmentDeviceFilterSelectionBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      return var2.filterPager.getCurrentItem() + 1;
   }

   private static final FilterPagerAdapter pagerAdapter_delegate$lambda$0(FilterSelectionDialogFragment var0) {
      return new FilterPagerAdapter((Fragment)var0);
   }

   private static final TextView toolbarTitleView_delegate$lambda$1(FilterSelectionDialogFragment var0) {
      DialogfragmentDeviceFilterSelectionBinding var1 = var0.viewDataBinding;
      DialogfragmentDeviceFilterSelectionBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      TextView var3 = var2.title;
      Intrinsics.checkNotNullExpressionValue(var3, "title");
      return var3;
   }

   public void clearProgressFragment() {
      ProgressFragment$_CC.$default$clearProgressFragment(this);
   }

   public final Device getDevice() {
      Device var1 = this.device;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         return null;
      }
   }

   public ProgressBlockerView getProgressBlockerView() {
      return this.progressBlockerView;
   }

   public ConstraintLayout getRootView() {
      DialogfragmentDeviceFilterSelectionBinding var2 = this.viewDataBinding;
      DialogfragmentDeviceFilterSelectionBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      ConstraintLayout var3 = var1.pagerRootLayout;
      Intrinsics.checkNotNullExpressionValue(var3, "pagerRootLayout");
      return var3;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public final TextView getToolbarTitleView() {
      return (TextView)this.toolbarTitleView$delegate.getValue();
   }

   public DeviceDetailsViewModel getViewModel() {
      DeviceDetailsViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public void hideProgress(Context var1) {
      ProgressFragment$_CC.$default$hideProgress(this, var1);
   }

   @Deprecated(
      message = "Deprecated in Java"
   )
   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      Dialog var2 = this.getDialog();
      if (var2 != null) {
         Window var3 = var2.getWindow();
         if (var3 != null) {
            WindowManager.LayoutParams var4 = var3.getAttributes();
            if (var4 != null) {
               var4.windowAnimations = R.style.dialog_animation;
            }
         }
      }

   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setStyle(0, R.style.DialogTheme);
   }

   public Dialog onCreateDialog(Bundle var1) {
      Timber.Forest.d("DialogFragment: onCreateDialog", new Object[0]);
      Dialog var2 = new Dialog(this.requireContext());
      var1 = this.getArguments();
      Device var5;
      if (var1 != null) {
         var5 = (Device)var1.getParcelable("device");
      } else {
         var5 = null;
      }

      if (var5 != null) {
         this.setDevice(var5);
         Timber.Forest var3 = Timber.Forest;
         StringBuilder var6 = new StringBuilder("onCreateDialog: dialog = ");
         var6.append(var2);
         var3.d(var6.toString(), new Object[0]);
         FragmentActivity var7 = this.getActivity();
         if (var7 != null) {
            Window var8 = var2.getWindow();
            if (var8 != null) {
               var8.setBackgroundDrawable(ContextCompat.getDrawable((Context)var7, R.drawable.top_rounded_rectangle_white));
            }
         }

         return var2;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      DialogfragmentDeviceFilterSelectionBinding var19 = DialogfragmentDeviceFilterSelectionBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var19, "inflate(...)");
      var19.setDeviceDetailViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(DeviceDetailsViewModel.class)));
      var19.setLifecycleOwner((LifecycleOwner)this);
      this.viewDataBinding = var19;
      Object var18 = null;
      DialogfragmentDeviceFilterSelectionBinding var5 = var19;
      if (var19 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var5 = null;
      }

      DeviceDetailsViewModel var6 = var5.getDeviceDetailViewModel();
      if (var6 != null) {
         this.setViewModel(var6);
         Timber.Forest var20 = Timber.Forest;
         StringBuilder var7 = new StringBuilder("onViewCreated: viewModel = ");
         var7.append(this.getViewModel());
         var7.append(",  device = ");
         var7.append(this.getDevice());
         var20.d(var7.toString(), new Object[0]);
         this.getViewModel().setDevice(this.getDevice());
         DialogfragmentDeviceFilterSelectionBinding var21 = this.viewDataBinding;
         DialogfragmentDeviceFilterSelectionBinding var8 = var21;
         if (var21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var8 = null;
         }

         var8.toolbar.getMenu().findItem(com.blueair.devicedetails.R.id.action_close).setOnMenuItemClickListener(new FilterSelectionDialogFragment$$ExternalSyntheticLambda6(this));
         var21 = this.viewDataBinding;
         var8 = var21;
         if (var21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var8 = null;
         }

         var8.filterPager.setAdapter((RecyclerView.Adapter)this.getPagerAdapter());
         var21 = this.viewDataBinding;
         var8 = var21;
         if (var21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var8 = null;
         }

         var8.filterPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback(this) {
            final FilterSelectionDialogFragment this$0;

            {
               this.this$0 = var1;
            }

            public void onPageSelected(int var1) {
               DialogfragmentDeviceFilterSelectionBinding var6 = this.this$0.viewDataBinding;
               Object var5 = null;
               DialogfragmentDeviceFilterSelectionBinding var4 = var6;
               if (var6 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                  var4 = null;
               }

               ImageButton var8 = var4.btnLeft;
               boolean var3 = false;
               boolean var2;
               if (var1 != 0) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               var8.setEnabled(var2);
               DialogfragmentDeviceFilterSelectionBinding var9 = this.this$0.viewDataBinding;
               if (var9 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                  var9 = (DialogfragmentDeviceFilterSelectionBinding)var5;
               }

               ImageButton var10 = var9.btnRight;
               var2 = var3;
               if (var1 != this.this$0.getPagerAdapter().getItemCount() - 1) {
                  var2 = true;
               }

               var10.setEnabled(var2);
            }
         });
         var21 = this.viewDataBinding;
         var8 = var21;
         if (var21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var8 = null;
         }

         var8.btnLeft.setOnClickListener(new FilterSelectionDialogFragment$$ExternalSyntheticLambda7(this));
         var21 = this.viewDataBinding;
         var8 = var21;
         if (var21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var8 = null;
         }

         var8.btnRight.setOnClickListener(new FilterSelectionDialogFragment$$ExternalSyntheticLambda8(this));
         var21 = this.viewDataBinding;
         var8 = var21;
         if (var21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var8 = null;
         }

         ScrollingPagerIndicator var4 = var8.dotsIndicator;
         var21 = this.viewDataBinding;
         var8 = var21;
         if (var21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var8 = null;
         }

         var4.attachToPager(var8.filterPager);
         var4.setFocusable(true);
         var4.setFocusableInTouchMode(false);
         BlueairApp$$ExternalSyntheticApiModelOutline0.m(var4, true);
         Intrinsics.checkNotNullExpressionValue(var4, "apply(...)");
         ViewCompat.setAccessibilityDelegate((View)var4, new ScrollingPageIndicatorAccessibilityDelegate(new FilterSelectionDialogFragment$$ExternalSyntheticLambda9(this), new FilterSelectionDialogFragment$$ExternalSyntheticLambda10(this)));
         var21 = this.viewDataBinding;
         var8 = var21;
         if (var21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var8 = null;
         }

         var8.buttonSave.setOnClickListener(new FilterSelectionDialogFragment$$ExternalSyntheticLambda1(this));
         var8 = this.viewDataBinding;
         if (var8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var8 = (DialogfragmentDeviceFilterSelectionBinding)var18;
         }

         View var17 = var8.getRoot();
         Intrinsics.checkNotNullExpressionValue(var17, "getRoot(...)");
         return var17;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public void onStart() {
      super.onStart();
      Dialog var2 = this.getDialog();
      if (var2 != null) {
         Point var3;
         Display var5;
         label24: {
            var3 = new Point();
            Window var1 = var2.getWindow();
            if (var1 != null) {
               WindowManager var4 = var1.getWindowManager();
               if (var4 != null) {
                  var5 = var4.getDefaultDisplay();
                  break label24;
               }
            }

            var5 = null;
         }

         if (var5 != null) {
            var5.getSize(var3);
         }

         Window var6 = var2.getWindow();
         if (var6 != null) {
            var6.setLayout(-1, -1);
         }

         var6 = var2.getWindow();
         if (var6 != null) {
            var6.setGravity(80);
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
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("onViewCreated: viewModel = ");
      var4.append(this.getViewModel());
      var4.append(",  device = ");
      var4.append(this.getDevice());
      var3.d(var4.toString(), new Object[0]);
      this.getViewModel().setDeviceId(this.getDevice().getUid());
      this.bindViewModel();
   }

   public final void setDevice(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.device = var1;
   }

   public void setProgressBlockerView(ProgressBlockerView var1) {
      this.progressBlockerView = var1;
   }

   public void setViewModel(DeviceDetailsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(Context var1, boolean var2, Integer var3) {
      ProgressFragment$_CC.$default$showProgress(this, var1, var2, var3);
   }

   public void showProgress(boolean var1) {
      ProgressFragment$_CC.showProgress$default(this, this.getContext(), var1, (Integer)null, 4, (Object)null);
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/dialog/FilterSelectionDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/FilterSelectionDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final FilterSelectionDialogFragment newInstance(Device var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         FilterSelectionDialogFragment var2 = new FilterSelectionDialogFragment();
         Bundle var3 = new Bundle();
         var3.putParcelable("device", var1);
         var2.setArguments(var3);
         return var2;
      }
   }
}
