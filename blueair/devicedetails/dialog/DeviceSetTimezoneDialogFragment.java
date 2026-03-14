package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.core.text.HtmlCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.Device$_CC;
import com.blueair.core.util.TimezoneUtils;
import com.blueair.devicedetails.adapter.DeviceTimezoneAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceSetTimezoneBinding;
import com.blueair.devicedetails.viewmodel.DeviceSetTimezoneViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.List;
import java.util.TimeZone;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceSetTimezoneDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceSetTimezoneViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceSetTimezoneBinding;", "snackbarAnchorView", "Landroid/view/View;", "getSnackbarAnchorView", "()Landroid/view/View;", "snackbarAnchorView$delegate", "Lkotlin/Lazy;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSetTimezoneViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceSetTimezoneViewModel;)V", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceTimezoneAdapter;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onPause", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSetTimezoneDialogFragment extends BaseDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final DeviceTimezoneAdapter adapter = new DeviceTimezoneAdapter();
   private final String screenName = "device_settings_timezone";
   private final Lazy snackbarAnchorView$delegate = LazyKt.lazy(new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda1(this));
   private DialogfragmentDeviceSetTimezoneBinding viewDataBinding;
   public DeviceSetTimezoneViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$6tOZxFLOIThld_Wx_H77J0zmnQ0/* $FF was: $r8$lambda$6tOZxFLOIThld-Wx-H77J0zmnQ0*/(DeviceSetTimezoneDialogFragment var0, View var1) {
      onCreateView$lambda$14$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$BMOcgTQeQ7AiCC3FP3_KERiNpCs/* $FF was: $r8$lambda$BMOcgTQeQ7AiCC3FP3-KERiNpCs*/(DeviceSetTimezoneDialogFragment var0, View var1) {
      onCreateView$lambda$14$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$DkPduve4T1iquHyEjtJTnav_nzU(DeviceSetTimezoneDialogFragment var0, DialogfragmentDeviceSetTimezoneBinding var1, int var2, TimeZone var3) {
      return onCreateView$lambda$14$lambda$7(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static View $r8$lambda$F6Hs_7P7N_YIEOCa8fADefzWrp8/* $FF was: $r8$lambda$F6Hs-7P7N_YIEOCa8fADefzWrp8*/(DeviceSetTimezoneDialogFragment var0) {
      return snackbarAnchorView_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$HfGFijwhcvFjNNkMppYZ9HXbnHA(DialogfragmentDeviceSetTimezoneBinding var0, View var1) {
      onCreateView$lambda$14$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$KWx6_gD8QrigFrefprLlJPpibP0/* $FF was: $r8$lambda$KWx6-gD8QrigFrefprLlJPpibP0*/(DialogfragmentDeviceSetTimezoneBinding var0, DeviceSetTimezoneDialogFragment var1) {
      onCreateView$lambda$14$lambda$10$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$nxbdtqhKhwg5jaPH9UlG_BerRGA(DeviceSetTimezoneDialogFragment var0) {
      return onCreateView$lambda$14$lambda$4$lambda$3(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$u6lLmddq_Luc66LHYEbimHT_EjA/* $FF was: $r8$lambda$u6lLmddq-Luc66LHYEbimHT-EjA*/(DialogfragmentDeviceSetTimezoneBinding var0, DeviceSetTimezoneDialogFragment var1, TimeZone var2, View var3) {
      onCreateView$lambda$14$lambda$10(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$ujJwa_XL4qMjH8olEAGWit3qjLs(DialogfragmentDeviceSetTimezoneBinding var0, DeviceSetTimezoneDialogFragment var1, Boolean var2) {
      return onCreateView$lambda$14$lambda$5(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$zYH75UFX_3FomwM3bz9jnxPLvqU(DeviceSetTimezoneDialogFragment var0, DialogfragmentDeviceSetTimezoneBinding var1, List var2) {
      return onCreateView$lambda$14$lambda$13(var0, var1, var2);
   }

   private static final void onCreateView$lambda$14$lambda$10(DialogfragmentDeviceSetTimezoneBinding var0, DeviceSetTimezoneDialogFragment var1, TimeZone var2, View var3) {
      var0.searchBar.setText((CharSequence)"");
      DeviceTimezoneAdapter var4 = var1.adapter;
      Intrinsics.checkNotNull(var2);
      var4.setSelectedTimezone(var2);
      if (var1.adapter.getSelectedIndex() > 0) {
         var0.timezoneList.scrollToPosition(var1.adapter.getSelectedIndex());
         var0.timezoneList.post(new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda9(var0, var1));
      }

   }

   private static final void onCreateView$lambda$14$lambda$10$lambda$9(DialogfragmentDeviceSetTimezoneBinding var0, DeviceSetTimezoneDialogFragment var1) {
      RecyclerView.LayoutManager var2 = var0.timezoneList.getLayoutManager();
      if (var2 != null) {
         LinearSmoothScroller var3 = new LinearSmoothScroller(var1.requireContext()) {
            public int calculateDtToFit(int var1, int var2, int var3, int var4, int var5) {
               return var3 + (var4 - var3) / 2 - (var1 + (var2 - var1) / 2);
            }
         };
         ((<undefinedtype>)var3).setTargetPosition(var1.adapter.getSelectedIndex());
         var2.startSmoothScroll((RecyclerView.SmoothScroller)var3);
      }

   }

   private static final void onCreateView$lambda$14$lambda$12(DialogfragmentDeviceSetTimezoneBinding var0, View var1) {
      var0.searchBar.setText((CharSequence)"");
   }

   private static final Unit onCreateView$lambda$14$lambda$13(DeviceSetTimezoneDialogFragment var0, DialogfragmentDeviceSetTimezoneBinding var1, List var2) {
      DeviceTimezoneAdapter var3 = var0.adapter;
      Intrinsics.checkNotNull(var2);
      var3.setTimezoneList(var2);
      TextView var4 = var1.noResultsView;
      Intrinsics.checkNotNullExpressionValue(var4, "noResultsView");
      ViewExtensionsKt.show((View)var4, var2.isEmpty());
      return Unit.INSTANCE;
   }

   private static final void onCreateView$lambda$14$lambda$2(DeviceSetTimezoneDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void onCreateView$lambda$14$lambda$4(DeviceSetTimezoneDialogFragment var0, View var1) {
      var0.getViewModel().setDeviceTimezone(var0.adapter.getSelectedTimezone(), new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda0(var0));
   }

   private static final Unit onCreateView$lambda$14$lambda$4$lambda$3(DeviceSetTimezoneDialogFragment var0) {
      var0.dismiss();
      return Unit.INSTANCE;
   }

   private static final Unit onCreateView$lambda$14$lambda$5(DialogfragmentDeviceSetTimezoneBinding var0, DeviceSetTimezoneDialogFragment var1, Boolean var2) {
      var0.saveButton.setEnabled(var2 ^ true);
      Intrinsics.checkNotNull(var2);
      var1.showProgress(var2);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateView$lambda$14$lambda$7(DeviceSetTimezoneDialogFragment var0, DialogfragmentDeviceSetTimezoneBinding var1, int var2, TimeZone var3) {
      Intrinsics.checkNotNullParameter(var3, "timezone");
      StringBuilder var4 = new StringBuilder("<b>");
      var4.append(var0.getString(R.string.dst_current_timezone));
      var4.append("</b> ");
      TimezoneUtils var5 = TimezoneUtils.INSTANCE;
      Context var6 = var0.requireContext();
      Intrinsics.checkNotNullExpressionValue(var6, "requireContext(...)");
      var4.append(var5.getDisplayName(var6, var3));
      Spanned var7 = HtmlCompat.fromHtml(var4.toString(), 0);
      Intrinsics.checkNotNullExpressionValue(var7, "fromHtml(...)");
      var1.currentTimezoneLabel.setText((CharSequence)var7);
      return Unit.INSTANCE;
   }

   private static final View snackbarAnchorView_delegate$lambda$0(DeviceSetTimezoneDialogFragment var0) {
      DialogfragmentDeviceSetTimezoneBinding var1 = var0.viewDataBinding;
      DialogfragmentDeviceSetTimezoneBinding var2 = var1;
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

   public DeviceSetTimezoneViewModel getViewModel() {
      DeviceSetTimezoneViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      Dialog var17 = this.getDialog();
      if (var17 != null) {
         this.setStyle(0, R.style.DialogTheme);
         Window var18 = var17.getWindow();
         if (var18 != null) {
            var18.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
         }

         Dialog var19 = this.getDialog();
         if (var19 != null) {
            Window var20 = var19.getWindow();
            if (var20 != null) {
               var20.setWindowAnimations(R.style.dialog_animation);
            }
         }
      }

      this.setViewModel((DeviceSetTimezoneViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(DeviceSetTimezoneViewModel.class)));
      DeviceSetTimezoneViewModel var21 = this.getViewModel();
      Parcelable var4 = this.requireArguments().getParcelable("device");
      Intrinsics.checkNotNull(var4);
      var21.setDevice((Device)var4);
      DialogfragmentDeviceSetTimezoneBinding var11 = DialogfragmentDeviceSetTimezoneBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var11, "inflate(...)");
      this.viewDataBinding = var11;
      Object var22 = null;
      DialogfragmentDeviceSetTimezoneBinding var8 = var11;
      if (var11 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var8 = null;
      }

      var8.closeButton.setOnClickListener(new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda2(this));
      var8.saveButton.setOnClickListener(new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda3(this));
      this.getViewModel().getRequesting().observe(this.getViewLifecycleOwner(), new Observer(new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda4(var8, this)) {
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
      TextView var23 = var8.currentTimezoneLabel;
      StringBuilder var5 = new StringBuilder("<b>");
      var5.append(this.getString(R.string.dst_current_timezone));
      var5.append("</b> ");
      Device var12 = this.getViewModel().getDevice();
      String var13;
      if (StringsKt.isBlank((CharSequence)var12.getTimeZone())) {
         var13 = "";
      } else {
         TimezoneUtils var7 = TimezoneUtils.INSTANCE;
         Context var6 = this.requireContext();
         Intrinsics.checkNotNullExpressionValue(var6, "requireContext(...)");
         var13 = var7.getDisplayName(var6, Device$_CC.getTimezone$default(var12, (Context)null, 1, (Object)null));
      }

      var5.append(var13);
      var23.setText((CharSequence)HtmlCompat.fromHtml(var5.toString(), 0));
      this.adapter.setSelectedTimezoneListener(new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda5(this, var8));
      TimeZone var14 = TimeZone.getDefault();
      StringBuilder var27 = new StringBuilder("<b>");
      var27.append(this.getString(R.string.dst_local_timezone));
      var27.append("</b> ");
      TimezoneUtils var26 = TimezoneUtils.INSTANCE;
      Context var24 = this.requireContext();
      Intrinsics.checkNotNullExpressionValue(var24, "requireContext(...)");
      Intrinsics.checkNotNull(var14);
      var27.append(var26.getDisplayName(var24, var14));
      Spanned var25 = HtmlCompat.fromHtml(var27.toString(), 0);
      Intrinsics.checkNotNullExpressionValue(var25, "fromHtml(...)");
      var8.localTimezoneLabel.setText((CharSequence)var25);
      var8.localTimezoneLabel.setOnClickListener(new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda6(var8, this, var14));
      EditText var15 = var8.searchBar;
      Intrinsics.checkNotNullExpressionValue(var15, "searchBar");
      ((TextView)var15).addTextChangedListener(new TextWatcher(var8, this) {
         final DialogfragmentDeviceSetTimezoneBinding $this_run$inlined;
         final DeviceSetTimezoneDialogFragment this$0;

         public {
            this.$this_run$inlined = var1;
            this.this$0 = var2;
         }

         public void afterTextChanged(Editable var1) {
            String var3 = this.$this_run$inlined.searchBar.getText().toString();
            this.this$0.getViewModel().setSearchText(var3);
            ImageButton var4 = this.$this_run$inlined.searchClearBtn;
            byte var2;
            if (((CharSequence)var3).length() == 0) {
               var2 = 4;
            } else {
               var2 = 0;
            }

            var4.setVisibility(var2);
         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }
      });
      var8.searchClearBtn.setOnClickListener(new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda7(var8));
      var8.timezoneList.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(this.requireContext())));
      DividerItemDecoration var16 = new DividerItemDecoration(this.requireContext(), 1);
      var8.timezoneList.addItemDecoration((RecyclerView.ItemDecoration)var16);
      var8.timezoneList.setAdapter(this.adapter);
      this.adapter.setSelectedTimezone(this.getViewModel().getDevice().getTimezone(this.requireContext()));
      this.getViewModel().getTimezoneList().observe(this.getViewLifecycleOwner(), new Observer(new DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda8(this, var8)) {
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
      var8 = this.viewDataBinding;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var8 = (DialogfragmentDeviceSetTimezoneBinding)var22;
      }

      View var10 = var8.getRoot();
      Intrinsics.checkNotNullExpressionValue(var10, "getRoot(...)");
      return var10;
   }

   public void onPause() {
      super.onPause();
      this.getRxSubs().clear();
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

   public void setViewModel(DeviceSetTimezoneViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
      DialogfragmentDeviceSetTimezoneBinding var3 = this.viewDataBinding;
      DialogfragmentDeviceSetTimezoneBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      ProgressBlockerView var4 = var2.progressView;
      Intrinsics.checkNotNullExpressionValue(var4, "progressView");
      ViewExtensionsKt.show((View)var4, var1);
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceSetTimezoneDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceSetTimezoneDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final DeviceSetTimezoneDialogFragment newInstance(Device var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceSetTimezoneDialogFragment var2 = new DeviceSetTimezoneDialogFragment();
         var2.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("device", var1)}));
         return var2;
      }
   }
}
