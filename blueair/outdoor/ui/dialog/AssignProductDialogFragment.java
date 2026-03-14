package com.blueair.outdoor.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.HasLocation;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.databinding.DialogAssignProductBinding;
import com.blueair.outdoor.ui.adapters.DeviceAdapter;
import com.blueair.outdoor.ui.viewmodels.MapsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.utils.ToastUtils;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

@Metadata(
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "},
   d2 = {"Lcom/blueair/outdoor/ui/dialog/AssignProductDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/outdoor/databinding/DialogAssignProductBinding;", "viewModel", "getViewModel", "()Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel;", "setViewModel", "(Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel;)V", "adapter", "Lcom/blueair/outdoor/ui/adapters/DeviceAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "showProgress", "shouldShowProgress", "", "Companion", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AssignProductDialogFragment extends BaseDialogFragment {
   private static final String ARG_DEVICES = "ARG_DEVICES";
   private static final String ARG_LOCATION = "ARG_LOCATION";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final DeviceAdapter adapter = new DeviceAdapter();
   private DialogAssignProductBinding binding;
   private final String screenName = "outdoor_map_assign_products";
   public MapsViewModel viewModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$9kjqYkQsPobVmpojxLRJ08aiefk(AssignProductDialogFragment var0, Ref.ObjectRef var1, Ref.ObjectRef var2, List var3) {
      return onCreateView$lambda$6(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$PzI4HDqwmzsPlFq6Wqwbpd0tjhw(AssignProductDialogFragment var0, Boolean var1) {
      return onCreateView$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$bwynW0U3Pf0bPrZaVJnwwEQmqpE(AssignProductDialogFragment var0, Ref.ObjectRef var1, View var2) {
      onCreateView$lambda$5(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$v4b_jhSrhBkhJ39L8jmC8p1iuQc/* $FF was: $r8$lambda$v4b-jhSrhBkhJ39L8jmC8p1iuQc*/(AssignProductDialogFragment var0, View var1) {
      onCreateView$lambda$2(var0, var1);
   }

   private static final void onCreateView$lambda$2(AssignProductDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final Unit onCreateView$lambda$3(AssignProductDialogFragment var0, Boolean var1) {
      DialogAssignProductBinding var2 = var0.binding;
      DialogAssignProductBinding var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var3 = null;
      }

      MaterialButton var4 = var3.btnAssign;
      Intrinsics.checkNotNull(var1);
      var4.setEnabled(var1);
      return Unit.INSTANCE;
   }

   private static final void onCreateView$lambda$5(AssignProductDialogFragment var0, Ref.ObjectRef var1, View var2) {
      var0.showProgress(true);
      Map var9 = var0.adapter.getOriginalSelections();
      Map var6 = var0.adapter.getSelections();
      List var4 = (List)(new ArrayList());
      List var5 = (List)(new ArrayList());

      for(Map.Entry var8 : var6.entrySet()) {
         String var10 = (String)var8.getKey();
         Boolean var11 = (Boolean)var8.getValue();
         boolean var3 = var11;
         if (!Intrinsics.areEqual(var11, var9.get(var10))) {
            if (var3) {
               var4.add(var10);
            } else {
               var5.add(var10);
            }
         }
      }

      BuildersKt.launch$default(var0.getViewModel(), (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var0, var1, var4, var5, (Continuation)null) {
         final Ref.ObjectRef $location;
         final List $resetIdList;
         final List $setIdList;
         Object L$0;
         int label;
         final AssignProductDialogFragment this$0;

         {
            this.this$0 = var1;
            this.$location = var2;
            this.$setIdList = var3;
            this.$resetIdList = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$location, this.$setIdList, this.$resetIdList, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  if (var2 != 2) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ApiResult var3 = (ApiResult)this.L$0;
                  ResultKt.throwOnFailure(var1);
                  return Unit.INSTANCE;
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               MapsViewModel var10 = this.this$0.getViewModel();
               String var6 = ((TrackedLocation)this.$location.element).getId();
               List var8 = this.$setIdList;
               List var5 = this.$resetIdList;
               Continuation var7 = (Continuation)this;
               this.label = 1;
               Object var11 = var10.setLocationDevices(var6, var8, var5, var7);
               var1 = var11;
               if (var11 == var4) {
                  return var4;
               }
            }

            ApiResult var9 = (ApiResult)var1;
            CoroutineContext var12 = (CoroutineContext)Dispatchers.getMain();
            Function2 var14 = new Function2(var9, this.this$0, (Continuation)null) {
               final ApiResult $result;
               int label;
               final AssignProductDialogFragment this$0;

               {
                  this.$result = var1;
                  this.this$0 = var2;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.$result, this.this$0, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  if (this.label == 0) {
                     ResultKt.throwOnFailure(var1);
                     if (this.$result.isSuccess()) {
                        this.this$0.dismiss();
                     } else {
                        this.this$0.showProgress(false);
                        var1 = ToastUtils.INSTANCE;
                        Context var2 = this.this$0.requireContext();
                        Intrinsics.checkNotNullExpressionValue(var2, "requireContext(...)");
                        var1.showCenterToast(var2, R.string.request_failed, 1);
                     }

                     return Unit.INSTANCE;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }
            };
            Continuation var13 = (Continuation)this;
            this.L$0 = SpillingKt.nullOutSpilledVariable(var9);
            this.label = 2;
            if (BuildersKt.withContext(var12, var14, var13) == var4) {
               return var4;
            } else {
               return Unit.INSTANCE;
            }
         }
      }, 2, (Object)null);
   }

   private static final Unit onCreateView$lambda$6(AssignProductDialogFragment var0, Ref.ObjectRef var1, Ref.ObjectRef var2, List var3) {
      var0.getViewModel().getDevices().removeObservers((LifecycleOwner)var0);
      Intrinsics.checkNotNull(var3);
      Iterable var4 = (Iterable)var3;
      Collection var6 = (Collection)(new ArrayList());

      for(Object var5 : var4) {
         if (var5 instanceof HasLocation) {
            var6.add(var5);
         }
      }

      List var7 = (List)var6;
      BuildersKt.launch$default(var0.getViewModel(), (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var0, var1, var2, var7, (Continuation)null) {
         final Ref.ObjectRef $assignedDevices;
         final List $hasLocations;
         final Ref.ObjectRef $location;
         Object L$0;
         Object L$1;
         int label;
         final AssignProductDialogFragment this$0;

         {
            this.this$0 = var1;
            this.$location = var2;
            this.$assignedDevices = var3;
            this.$hasLocations = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$location, this.$assignedDevices, this.$hasLocations, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  if (var2 != 2) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  List var4 = (List)this.L$1;
                  ApiResult var13 = (ApiResult)this.L$0;
                  ResultKt.throwOnFailure(var1);
                  return Unit.INSTANCE;
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               MapsViewModel var6 = this.this$0.getViewModel();
               String var9 = ((TrackedLocation)this.$location.element).getId();
               Continuation var14 = (Continuation)this;
               this.label = 1;
               Object var15 = var6.queryLocationDevices(var9, var14);
               var1 = var15;
               if (var15 == var5) {
                  return var5;
               }
            }

            ApiResult var19 = (ApiResult)var1;
            List var10;
            if (var19.isSuccess()) {
               List var16 = (List)var19.getOrNull();
               var10 = var16;
               if (var16 == null) {
                  var10 = CollectionsKt.emptyList();
               }
            } else {
               Object[] var11 = this.$assignedDevices.element;
               Collection var17 = (Collection)(new ArrayList(var11.length));
               int var3 = var11.length;

               for(int var12 = 0; var12 < var3; ++var12) {
                  var17.add(((HasLocation)var11[var12]).getUid());
               }

               var10 = (List)var17;
            }

            CoroutineContext var7 = (CoroutineContext)Dispatchers.getMain();
            Function2 var8 = new Function2(this.this$0, this.$hasLocations, var10, (Continuation)null) {
               final List $assignedDeviceIdList;
               final List $hasLocations;
               int label;
               final AssignProductDialogFragment this$0;

               {
                  this.this$0 = var1;
                  this.$hasLocations = var2;
                  this.$assignedDeviceIdList = var3;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, this.$hasLocations, this.$assignedDeviceIdList, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  if (this.label != 0) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  } else {
                     ResultKt.throwOnFailure(var1);
                     DeviceAdapter var2 = this.this$0.adapter;
                     Iterable var4 = (Iterable)this.$hasLocations;
                     List var6 = this.$assignedDeviceIdList;
                     LinkedHashMap var3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(var4, 10)), 16));

                     for(Object var5 : var4) {
                        ((Map)var3).put(var5, Boxing.boxBoolean(var6.contains(((HasLocation)var5).getUid())));
                     }

                     var2.setData((Map)var3);
                     this.this$0.showProgress(false);
                     return Unit.INSTANCE;
                  }
               }
            };
            Continuation var18 = (Continuation)this;
            this.L$0 = SpillingKt.nullOutSpilledVariable(var19);
            this.L$1 = SpillingKt.nullOutSpilledVariable(var10);
            this.label = 2;
            if (BuildersKt.withContext(var7, var8, var18) == var5) {
               return var5;
            } else {
               return Unit.INSTANCE;
            }
         }
      }, 2, (Object)null);
      return Unit.INSTANCE;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public MapsViewModel getViewModel() {
      MapsViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      Dialog var21 = this.getDialog();
      if (var21 != null) {
         this.setStyle(0, R.style.DialogTheme);
         Window var22 = var21.getWindow();
         if (var22 != null) {
            var22.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
         }

         Dialog var23 = this.getDialog();
         if (var23 != null) {
            Window var24 = var23.getWindow();
            if (var24 != null) {
               var24.setWindowAnimations(R.style.dialog_animation);
            }
         }
      }

      DialogAssignProductBinding var7 = DialogAssignProductBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var7, "inflate(...)");
      this.binding = var7;
      FragmentActivity var8 = ((BaseDialogFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var8, "requireActivity(...)");
      this.setViewModel((MapsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var8)).get(MapsViewModel.class)));
      Ref.ObjectRef var5 = new Ref.ObjectRef();
      Ref.ObjectRef var4 = new Ref.ObjectRef();
      Bundle var9 = this.requireArguments();
      Parcelable var19 = var9.getParcelable("ARG_LOCATION");
      Intrinsics.checkNotNull(var19);
      var5.element = var19;
      Parcelable[] var10 = var9.getParcelableArray("ARG_DEVICES");
      Intrinsics.checkNotNull(var10, "null cannot be cast to non-null type kotlin.Array<com.blueair.core.model.HasLocation>");
      var4.element = (HasLocation[])var10;
      DialogAssignProductBinding var25 = this.binding;
      Object var20 = null;
      DialogAssignProductBinding var11 = var25;
      if (var25 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var11 = null;
      }

      var11.btnClose.setOnClickListener(new AssignProductDialogFragment$$ExternalSyntheticLambda0(this));
      var25 = this.binding;
      var11 = var25;
      if (var25 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var11 = null;
      }

      var11.locationName.setText((CharSequence)((TrackedLocation)var5.element).getLocationName());
      var25 = this.binding;
      var11 = var25;
      if (var25 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var11 = null;
      }

      var11.deviceList.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(this.requireContext(), 1, false)));
      var25 = this.binding;
      var11 = var25;
      if (var25 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var11 = null;
      }

      var11.deviceList.setAdapter(this.adapter);
      LiveData var15 = this.adapter.getSelectionModified();
      LifecycleOwner var6 = (LifecycleOwner)this;
      var15.observe(var6, new Observer(new AssignProductDialogFragment$$ExternalSyntheticLambda1(this)) {
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
      var25 = this.binding;
      DialogAssignProductBinding var16 = var25;
      if (var25 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var16 = null;
      }

      var16.btnAssign.setOnClickListener(new AssignProductDialogFragment$$ExternalSyntheticLambda2(this, var5));
      this.showProgress(true);
      this.getViewModel().getDevices().observe(var6, new Observer(new AssignProductDialogFragment$$ExternalSyntheticLambda3(this, var5, var4)) {
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
      var16 = this.binding;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var16 = (DialogAssignProductBinding)var20;
      }

      LinearLayout var18 = var16.getRoot();
      Intrinsics.checkNotNullExpressionValue(var18, "getRoot(...)");
      return (View)var18;
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

   public void setViewModel(MapsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
      DialogAssignProductBinding var3 = this.binding;
      DialogAssignProductBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      ProgressBlockerView var4 = var2.progressView;
      Intrinsics.checkNotNullExpressionValue(var4, "progressView");
      ViewExtensionsKt.show((View)var4, var1);
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"},
      d2 = {"Lcom/blueair/outdoor/ui/dialog/AssignProductDialogFragment$Companion;", "", "<init>", "()V", "ARG_LOCATION", "", "ARG_DEVICES", "newInstance", "Lcom/blueair/outdoor/ui/dialog/AssignProductDialogFragment;", "location", "Lcom/blueair/core/model/TrackedLocation;", "devices", "", "Lcom/blueair/core/model/HasLocation;", "outdoor_otherRelease"},
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

      public final AssignProductDialogFragment newInstance(TrackedLocation var1, List var2) {
         Intrinsics.checkNotNullParameter(var1, "location");
         Intrinsics.checkNotNullParameter(var2, "devices");
         AssignProductDialogFragment var3 = new AssignProductDialogFragment();
         var3.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("ARG_LOCATION", var1), TuplesKt.to("ARG_DEVICES", ((Collection)var2).toArray(new HasLocation[0]))}));
         return var3;
      }
   }
}
