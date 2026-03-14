package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.util.TypedValueCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.devicedetails.databinding.DialogDeleteScheduleBinding;
import com.blueair.devicedetails.viewholder.DeletableItem;
import com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.dd.ShadowLayout;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.adapters.ModelAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

@Metadata(
   d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006%"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeleteScheduleDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogDeleteScheduleBinding;", "scheduleAdapter", "Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "Lcom/blueair/devicedetails/viewholder/DeletableItem;", "Lcom/blueair/core/model/DeviceScheduleMerged;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;)V", "defName", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onViewCreated", "view", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeleteScheduleDialogFragment extends BaseDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private String defName;
   private ItemAdapter scheduleAdapter;
   private final String screenName;
   private DialogDeleteScheduleBinding viewDataBinding;
   public DeviceSchedulesViewModel viewModel;

   // $FF: synthetic method
   public static boolean $r8$lambda$TCfpAxTTNtBMfOZd6N7wMcjU0uA(DeleteScheduleDialogFragment var0, View var1, IAdapter var2, DeletableItem var3, int var4) {
      return onViewCreated$lambda$8$lambda$7(var0, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$xLyD3fVb2Ahlhpp_OnOgwoaC8FI/* $FF was: $r8$lambda$xLyD3fVb2Ahlhpp-OnOgwoaC8FI*/(DeleteScheduleDialogFragment var0, DeletableItem var1, boolean var2) {
      return onViewCreated$lambda$8$lambda$7$lambda$6$lambda$5(var0, var1, var2);
   }

   private static final boolean onViewCreated$lambda$8$lambda$7(DeleteScheduleDialogFragment var0, View var1, IAdapter var2, DeletableItem var3, int var4) {
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      Intrinsics.checkNotNullParameter(var3, "item");
      FragmentManager var5 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var5, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
      if (!(var5.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var5.isStateSaved()) {
         ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.confirm_delete_schedule, (Integer)null, R.string.delete_schedule_content, R.string.confirm, R.string.btn_cancel, false, false, false, false, (String[])null, (String)null, (Integer)null, new DeleteScheduleDialogFragment$$ExternalSyntheticLambda1(var0, var3), 3936, (Object)null)).show(var5, "ConfirmationDialogLeftAligned");
      }

      return true;
   }

   private static final Unit onViewCreated$lambda$8$lambda$7$lambda$6$lambda$5(DeleteScheduleDialogFragment var0, DeletableItem var1, boolean var2) {
      if (var2) {
         var0.dismissAllowingStateLoss();
         BuildersKt.launch$default(var0.getViewModel(), (CoroutineContext)null, (CoroutineStart)null, new Function2(var0, var1, (Continuation)null) {
            final DeletableItem $item;
            int label;
            final DeleteScheduleDialogFragment this$0;

            {
               this.this$0 = var1;
               this.$item = var2;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$item, var2));
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
                  CoroutineContext var6 = (CoroutineContext)Dispatchers.getIO();
                  Function2 var5 = new Function2(this.this$0, this.$item, (Continuation)null) {
                     final DeletableItem $item;
                     int label;
                     final DeleteScheduleDialogFragment this$0;

                     {
                        this.this$0 = var1;
                        this.$item = var2;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        return (Continuation)(new <anonymous constructor>(this.this$0, this.$item, var2));
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
                           DeviceSchedulesViewModel var5 = this.this$0.getViewModel();
                           DeviceScheduleMerged var4 = (DeviceScheduleMerged)this.$item.getData();
                           Continuation var6 = (Continuation)this;
                           this.label = 1;
                           if (var5.delete(var4, var6) == var3) {
                              return var3;
                           }
                        }

                        return Unit.INSTANCE;
                     }
                  };
                  Continuation var4 = (Continuation)this;
                  this.label = 1;
                  if (BuildersKt.withContext(var6, var5, var4) == var3) {
                     return var3;
                  }
               }

               this.this$0.getViewModel().refreshDeviceSchedule(true);
               return Unit.INSTANCE;
            }
         }, 3, (Object)null);
      }

      return Unit.INSTANCE;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public DeviceSchedulesViewModel getViewModel() {
      DeviceSchedulesViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      DialogDeleteScheduleBinding var4 = DialogDeleteScheduleBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.viewDataBinding = var4;
      FragmentActivity var5 = ((BaseDialogFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var5, "requireActivity(...)");
      this.setViewModel((DeviceSchedulesViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var5)).get(DeviceSchedulesViewModel.class)));
      DialogDeleteScheduleBinding var8 = this.viewDataBinding;
      DialogDeleteScheduleBinding var6 = var8;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      ShadowLayout var7 = var6.getRoot();
      Intrinsics.checkNotNullExpressionValue(var7, "getRoot(...)");
      return (View)var7;
   }

   public void onStart() {
      super.onStart();
      Dialog var2 = this.getDialog();
      if (var2 != null) {
         Window var4 = var2.getWindow();
         if (var4 != null) {
            var4.clearFlags(2);
            var4.setBackgroundDrawableResource(R.color.transparent);
            int var1 = (int)TypedValueCompat.dpToPx(2.0F, this.getResources().getDisplayMetrics());
            var4.getDecorView().setPaddingRelative(0, var1, var1 * 6, 0);
            var4.setDimAmount(0.0F);
            WindowManager.LayoutParams var3 = var4.getAttributes();
            var3.gravity = 8388661;
            var3.width = (int)TypedValueCompat.dpToPx(262.0F, this.getResources().getDisplayMetrics());
            var3.height = -2;
            var4.setAttributes(var3);
         }
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      String var8 = this.getString(R.string.schedule_default_name);
      Intrinsics.checkNotNullExpressionValue(var8, "getString(...)");
      this.defName = var8;
      DialogDeleteScheduleBinding var3 = this.viewDataBinding;
      Object var18 = null;
      DialogDeleteScheduleBinding var9 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var9 = null;
      }

      var9.rvList.setHasFixedSize(true);
      ItemAdapter var4 = new ItemAdapter();
      List var10 = (List)this.getViewModel().getSchedules().getValue();
      if (var10 != null) {
         Iterable var11 = (Iterable)var10;
         Collection var5 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var11, 10)));

         for(DeviceScheduleMerged var7 : var11) {
            CharSequence var19 = (CharSequence)var7.getName();
            Object var12 = var19;
            if (StringsKt.isBlank(var19)) {
               String var20 = this.defName;
               var12 = var20;
               if (var20 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("defName");
                  var12 = null;
               }
            }

            var5.add(new DeletableItem((String)var12, var7, false, 4, (DefaultConstructorMarker)null));
         }

         var4.set((List)var5);
      }

      this.scheduleAdapter = var4;
      var3 = this.viewDataBinding;
      DialogDeleteScheduleBinding var13 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var13 = null;
      }

      RecyclerView var23 = var13.rvList;
      FastAdapter.Companion var24 = FastAdapter.Companion;
      ItemAdapter var22 = this.scheduleAdapter;
      ItemAdapter var14 = var22;
      if (var22 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("scheduleAdapter");
         var14 = null;
      }

      FastAdapter var15 = var24.with((IAdapter)var14);
      var15.setOnClickListener(new DeleteScheduleDialogFragment$$ExternalSyntheticLambda0(this));
      var23.setAdapter((RecyclerView.Adapter)var15);
      DialogDeleteScheduleBinding var16 = this.viewDataBinding;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var16 = (DialogDeleteScheduleBinding)var18;
      }

      AppCompatEditText var17 = var16.etName;
      Intrinsics.checkNotNullExpressionValue(var17, "etName");
      ((TextView)var17).addTextChangedListener(new TextWatcher(this) {
         final DeleteScheduleDialogFragment this$0;

         public {
            this.this$0 = var1;
         }

         public void afterTextChanged(Editable var1) {
            List var3 = (List)this.this$0.getViewModel().getSchedules().getValue();
            if (var3 != null) {
               CharSequence var2;
               label55: {
                  if (var1 != null) {
                     CharSequence var7 = StringsKt.trim((CharSequence)var1);
                     var2 = var7;
                     if (var7 != null) {
                        break label55;
                     }
                  }

                  var2 = (CharSequence)"";
               }

               if (var2.length() == 0) {
                  ItemAdapter var16 = this.this$0.scheduleAdapter;
                  ItemAdapter var11 = var16;
                  if (var16 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("scheduleAdapter");
                     var11 = null;
                  }

                  IItemAdapter var22 = (IItemAdapter)var11;
                  Iterable var12 = (Iterable)var3;
                  Collection var21 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var12, 10)));

                  for(DeviceScheduleMerged var23 : var12) {
                     CharSequence var17 = (CharSequence)var23.getName();
                     Object var13 = var17;
                     if (StringsKt.isBlank(var17)) {
                        String var18 = this.this$0.defName;
                        var13 = var18;
                        if (var18 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("defName");
                           var13 = null;
                        }
                     }

                     var21.add(new DeletableItem((String)var13, var23, false, 4, (DefaultConstructorMarker)null));
                  }

                  ModelAdapter var14 = (ModelAdapter)com.mikepenz.fastadapter.IItemAdapter.DefaultImpls.setNewList$default(var22, (List)var21, false, 2, (Object)null);
                  return;
               }

               List var4 = (List)(new ArrayList());

               for(DeviceScheduleMerged var6 : (Iterable)var3) {
                  CharSequence var19 = (CharSequence)var6.getName();
                  Object var8 = var19;
                  if (StringsKt.isBlank(var19)) {
                     String var20 = this.this$0.defName;
                     var8 = var20;
                     if (var20 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("defName");
                        var8 = null;
                     }
                  }

                  String var9 = (String)var8;
                  if (StringsKt.contains((CharSequence)var9, var2, true)) {
                     var4.add(new DeletableItem(var9, var6, false, 4, (DefaultConstructorMarker)null));
                  }
               }

               ItemAdapter var15 = this.this$0.scheduleAdapter;
               ItemAdapter var10 = var15;
               if (var15 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("scheduleAdapter");
                  var10 = null;
               }

               ModelAdapter var10000 = (ModelAdapter)com.mikepenz.fastadapter.IItemAdapter.DefaultImpls.setNewList$default((IItemAdapter)var10, var4, false, 2, (Object)null);
            }

         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }
      });
   }

   public void setViewModel(DeviceSchedulesViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeleteScheduleDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeleteScheduleDialogFragment;", "devicedetails_otherRelease"},
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

      public final DeleteScheduleDialogFragment newInstance() {
         return new DeleteScheduleDialogFragment();
      }
   }
}
