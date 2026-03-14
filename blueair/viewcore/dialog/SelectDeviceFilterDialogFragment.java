package com.blueair.viewcore.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.FilterInfo;
import com.blueair.viewcore.R;
import com.blueair.viewcore.adapter.DeviceFilterAdapter;
import com.blueair.viewcore.databinding.DialogfragmentSelectDeviceFilterBinding;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020\u000fH\u0016J\b\u0010%\u001a\u00020\u000fH\u0016J\b\u0010&\u001a\u00020\u000fH\u0016J\b\u0010'\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"},
   d2 = {"Lcom/blueair/viewcore/dialog/SelectDeviceFilterDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/blueair/viewcore/databinding/DialogfragmentSelectDeviceFilterBinding;", "filterAdapter", "Lcom/blueair/viewcore/adapter/DeviceFilterAdapter;", "getFilterAdapter", "()Lcom/blueair/viewcore/adapter/DeviceFilterAdapter;", "filterAdapter$delegate", "Lkotlin/Lazy;", "onFilterSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FilterInfo;", "", "title", "", "getTitle", "()Ljava/lang/String;", "title$delegate", "filters", "", "getFilters", "()Ljava/util/List;", "filters$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onStart", "onResume", "onPause", "refreshFilterScrollIndicators", "Companion", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SelectDeviceFilterDialogFragment extends DialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String EXTRA_FILTERS = "EXTRA_FILTERS";
   private static final String EXTRA_TITLE = "EXTRA_TITLE";
   private DialogfragmentSelectDeviceFilterBinding binding;
   private final Lazy filterAdapter$delegate = LazyKt.lazy(new SelectDeviceFilterDialogFragment$$ExternalSyntheticLambda1(this));
   private final Lazy filters$delegate = LazyKt.lazy(new SelectDeviceFilterDialogFragment$$ExternalSyntheticLambda3(this));
   private Function1 onFilterSelectedListener;
   private final Lazy title$delegate = LazyKt.lazy(new SelectDeviceFilterDialogFragment$$ExternalSyntheticLambda2(this));

   // $FF: synthetic method
   public static String $r8$lambda$gNAgwzeAdosL9FF_H15om70wEiU/* $FF was: $r8$lambda$gNAgwzeAdosL9FF-H15om70wEiU*/(SelectDeviceFilterDialogFragment var0) {
      return title_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static List $r8$lambda$sgdex_SGFFWuwX1iZKKQ5cS2_vk(SelectDeviceFilterDialogFragment var0) {
      return filters_delegate$lambda$2(var0);
   }

   // $FF: synthetic method
   public static DeviceFilterAdapter $r8$lambda$taUkgNBxmZkJ3p6AO_XJxm3R9cI(SelectDeviceFilterDialogFragment var0) {
      return filterAdapter_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$uphixGUvG1zN7FXBHSd_K5Jcj3s/* $FF was: $r8$lambda$uphixGUvG1zN7FXBHSd-K5Jcj3s*/(SelectDeviceFilterDialogFragment var0, View var1) {
      onViewCreated$lambda$4(var0, var1);
   }

   private static final DeviceFilterAdapter filterAdapter_delegate$lambda$0(SelectDeviceFilterDialogFragment var0) {
      return new DeviceFilterAdapter(var0.onFilterSelectedListener);
   }

   private static final List filters_delegate$lambda$2(SelectDeviceFilterDialogFragment var0) {
      Parcelable[] var2 = var0.requireArguments().getParcelableArray("EXTRA_FILTERS");
      List var1 = null;
      List var3;
      if (var2 != null) {
         var3 = ArraysKt.asList(var2);
      } else {
         var3 = null;
      }

      if (var3 instanceof List) {
         var1 = var3;
      }

      return var1 == null ? CollectionsKt.emptyList() : var1;
   }

   private final DeviceFilterAdapter getFilterAdapter() {
      return (DeviceFilterAdapter)this.filterAdapter$delegate.getValue();
   }

   private final List getFilters() {
      return (List)this.filters$delegate.getValue();
   }

   private final String getTitle() {
      return (String)this.title$delegate.getValue();
   }

   private static final void onViewCreated$lambda$4(SelectDeviceFilterDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private final void refreshFilterScrollIndicators() {
      DialogfragmentSelectDeviceFilterBinding var6 = this.binding;
      Object var5 = null;
      DialogfragmentSelectDeviceFilterBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      ImageView var7 = var4.filterScrollLeft;
      var6 = this.binding;
      var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      boolean var3 = var4.filterList.canScrollHorizontally(-1);
      byte var2 = 0;
      byte var1;
      if (var3) {
         var1 = 0;
      } else {
         var1 = 4;
      }

      var7.setVisibility(var1);
      var6 = this.binding;
      var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      ImageView var14 = var4.filterScrollRight;
      var4 = this.binding;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = (DialogfragmentSelectDeviceFilterBinding)var5;
      }

      if (var4.filterList.canScrollHorizontally(1)) {
         var1 = var2;
      } else {
         var1 = 4;
      }

      var14.setVisibility(var1);
   }

   private static final String title_delegate$lambda$1(SelectDeviceFilterDialogFragment var0) {
      String var1 = var0.requireArguments().getString("EXTRA_TITLE");
      if (var1 == null) {
         String var2 = var0.getString(R.string.select_filter);
         Intrinsics.checkNotNullExpressionValue(var2, "getString(...)");
         return var2;
      } else {
         return var1;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      this.setStyle(0, R.style.DialogTheme);
      Dialog var7 = this.getDialog();
      if (var7 != null) {
         Window var8 = var7.getWindow();
         if (var8 != null) {
            var8.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var8.setWindowAnimations(R.style.dialog_animation);
            var8.setGravity(80);
         }
      }

      DialogfragmentSelectDeviceFilterBinding var6 = DialogfragmentSelectDeviceFilterBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      DialogfragmentSelectDeviceFilterBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      View var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return var5;
   }

   public void onPause() {
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

      super.onPause();
   }

   public void onResume() {
      super.onResume();
      this.refreshFilterScrollIndicators();
   }

   public void onStart() {
      super.onStart();
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            var2.setLayout(-1, -2);
         }
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      DialogfragmentSelectDeviceFilterBinding var3 = this.binding;
      Object var9 = null;
      DialogfragmentSelectDeviceFilterBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.closeBtn.setOnClickListener(new SelectDeviceFilterDialogFragment$$ExternalSyntheticLambda0(this));
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.title.setText((CharSequence)this.getTitle());
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.filterList.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(this.requireContext(), 0, false)));
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.filterList.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
         final SelectDeviceFilterDialogFragment this$0;

         {
            this.this$0 = var1;
         }

         public void onScrolled(RecyclerView var1, int var2, int var3) {
            Intrinsics.checkNotNullParameter(var1, "recyclerView");
            this.this$0.refreshFilterScrollIndicators();
         }
      });
      var4 = this.binding;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = (DialogfragmentSelectDeviceFilterBinding)var9;
      }

      var4.filterList.setAdapter(this.getFilterAdapter());
      this.getFilterAdapter().setFilters(this.getFilters());
   }

   @Metadata(
      d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"},
      d2 = {"Lcom/blueair/viewcore/dialog/SelectDeviceFilterDialogFragment$Companion;", "", "<init>", "()V", "EXTRA_TITLE", "", "EXTRA_FILTERS", "newInstance", "Lcom/blueair/viewcore/dialog/SelectDeviceFilterDialogFragment;", "title", "filters", "", "Lcom/blueair/core/model/FilterInfo;", "onFilterSelectedListener", "Lkotlin/Function1;", "", "viewcore_otherRelease"},
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

      public final SelectDeviceFilterDialogFragment newInstance(String var1, List var2, Function1 var3) {
         Intrinsics.checkNotNullParameter(var1, "title");
         Intrinsics.checkNotNullParameter(var2, "filters");
         Intrinsics.checkNotNullParameter(var3, "onFilterSelectedListener");
         SelectDeviceFilterDialogFragment var4 = new SelectDeviceFilterDialogFragment();
         var4.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("EXTRA_TITLE", var1), TuplesKt.to("EXTRA_FILTERS", ((Collection)var2).toArray(new FilterInfo[0]))}));
         var4.onFilterSelectedListener = var3;
         return var4;
      }
   }
}
