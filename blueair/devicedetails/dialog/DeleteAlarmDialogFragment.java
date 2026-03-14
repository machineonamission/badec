package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
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
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.HasAlarm;
import com.blueair.devicedetails.databinding.DialogDeleteAlarmBinding;
import com.blueair.devicedetails.viewholder.DeletableItem;
import com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.dd.ShadowLayout;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.adapters.ModelAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

@Metadata(
   d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u001a\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u001aH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeleteAlarmDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceAlarmsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogDeleteAlarmBinding;", "itemAdapter", "Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "Lcom/blueair/devicedetails/viewholder/DeletableItem;", "Lcom/blueair/core/model/DeviceAlarm;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceAlarmsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceAlarmsViewModel;)V", "defName", "originAlarms", "", "device", "Lcom/blueair/core/model/HasAlarm;", "searchable", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onViewCreated", "view", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeleteAlarmDialogFragment extends BaseDialogFragment {
   private static final String ARG_SEARCHABLE = "ARG_SEARCHABLE";
   private static final String ARG_WINDOW_Y = "ARG_WINDOW_Y";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private String defName;
   private HasAlarm device;
   private ItemAdapter itemAdapter;
   private List originAlarms;
   private final String screenName = "device_details_alarm_delete";
   private boolean searchable;
   private DialogDeleteAlarmBinding viewDataBinding;
   public DeviceAlarmsViewModel viewModel;

   // $FF: synthetic method
   public static boolean $r8$lambda$60coVJyQ1TOKbTQcIzIs0eNLoMM(DeleteAlarmDialogFragment var0, View var1, IAdapter var2, DeletableItem var3, int var4) {
      return onViewCreated$lambda$9$lambda$8(var0, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$9WiHdE1Iwn49M19OWjxdpHFhvVg(DeleteAlarmDialogFragment var0, DeletableItem var1, boolean var2) {
      return onViewCreated$lambda$9$lambda$8$lambda$7$lambda$6(var0, var1, var2);
   }

   private static final boolean onViewCreated$lambda$9$lambda$8(DeleteAlarmDialogFragment var0, View var1, IAdapter var2, DeletableItem var3, int var4) {
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      Intrinsics.checkNotNullParameter(var3, "item");
      FragmentManager var5 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var5, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
      if (!(var5.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var5.isStateSaved()) {
         ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.delete_schedule_content, (Integer)null, 0, R.string.confirm, R.string.btn_cancel, false, false, false, false, (String[])null, var0.getString(R.string.delete_confirmation_content, new Object[]{var3.getName()}), (Integer)null, new DeleteAlarmDialogFragment$$ExternalSyntheticLambda0(var0, var3), 2912, (Object)null)).show(var5, "ConfirmationDialogLeftAligned");
      }

      return true;
   }

   private static final Unit onViewCreated$lambda$9$lambda$8$lambda$7$lambda$6(DeleteAlarmDialogFragment var0, DeletableItem var1, boolean var2) {
      if (var2) {
         var0.dismissAllowingStateLoss();
         BuildersKt.launch$default(var0.getViewModel(), (CoroutineContext)null, (CoroutineStart)null, new Function2(var0, var1, (Continuation)null) {
            final DeletableItem $item;
            int label;
            final DeleteAlarmDialogFragment this$0;

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
                  CoroutineContext var4 = (CoroutineContext)Dispatchers.getIO();
                  Function2 var5 = new Function2(this.this$0, this.$item, (Continuation)null) {
                     final DeletableItem $item;
                     int label;
                     final DeleteAlarmDialogFragment this$0;

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
                        Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int var2 = this.label;
                        if (var2 != 0) {
                           if (var2 != 1) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           ResultKt.throwOnFailure(var1);
                        } else {
                           ResultKt.throwOnFailure(var1);
                           DeviceAlarmsViewModel var5 = this.this$0.getViewModel();
                           HasAlarm var3 = this.this$0.device;
                           var1 = var3;
                           if (var3 == null) {
                              Intrinsics.throwUninitializedPropertyAccessException("device");
                              var1 = null;
                           }

                           DeviceAlarm var6 = (DeviceAlarm)this.$item.getData();
                           Continuation var8 = (Continuation)this;
                           this.label = 1;
                           if (var5.delete(var1, var6, var8) == var4) {
                              return var4;
                           }
                        }

                        return Unit.INSTANCE;
                     }
                  };
                  Continuation var6 = (Continuation)this;
                  this.label = 1;
                  if (BuildersKt.withContext(var4, var5, var6) == var3) {
                     return var3;
                  }
               }

               this.this$0.getViewModel().refreshDeviceAlarms();
               return Unit.INSTANCE;
            }
         }, 3, (Object)null);
      }

      return Unit.INSTANCE;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public DeviceAlarmsViewModel getViewModel() {
      DeviceAlarmsViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      DialogDeleteAlarmBinding var4 = DialogDeleteAlarmBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.viewDataBinding = var4;
      FragmentActivity var5 = ((BaseDialogFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var5, "requireActivity(...)");
      this.setViewModel((DeviceAlarmsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var5)).get(DeviceAlarmsViewModel.class)));
      DialogDeleteAlarmBinding var8 = this.viewDataBinding;
      DialogDeleteAlarmBinding var6 = var8;
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
         Window var7 = var2.getWindow();
         if (var7 != null) {
            var7.clearFlags(2);
            var7.setBackgroundDrawableResource(R.color.transparent);
            int var1 = (int)TypedValueCompat.dpToPx(4.0F, this.getResources().getDisplayMetrics());
            var7.getDecorView().setPaddingRelative(0, var1, var1 * 3, 0);
            var7.setDimAmount(0.0F);
            WindowManager.LayoutParams var3 = var7.getAttributes();
            var3.gravity = 8388661;
            var3.width = (int)TypedValueCompat.dpToPx(262.0F, this.getResources().getDisplayMetrics());
            var3.height = -2;
            Bundle var4 = this.getArguments();
            if (var4 != null) {
               var1 = var4.getInt("ARG_WINDOW_Y", 0);
               if (var1 > 0) {
                  DialogUtils var8 = DialogUtils.INSTANCE;
                  Context var5 = var7.getContext();
                  Intrinsics.checkNotNullExpressionValue(var5, "getContext(...)");
                  var3.y = RangesKt.coerceAtLeast(var1 - var8.getStatusBarHeight(var5), 0);
               }
            }

            var7.setAttributes(var3);
         }
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      String var10 = this.getString(R.string.alarm_default_name);
      Intrinsics.checkNotNullExpressionValue(var10, "getString(...)");
      this.defName = var10;
      Bundle var11 = this.getArguments();
      Object var5 = null;
      HasAlarm var12;
      if (var11 != null) {
         var12 = (HasAlarm)var11.getParcelable("device");
      } else {
         var12 = null;
      }

      if (var12 != null) {
         this.device = var12;
         HasAlarm var26 = var12;
         if (var12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var26 = null;
         }

         this.originAlarms = CollectionsKt.sortedWith((Iterable)CollectionsKt.filterNotNull((Iterable)var26.getAlarms()), new Comparator() {
            public final int compare(Object var1, Object var2) {
               return ComparisonsKt.compareValues((Comparable)((DeviceAlarm)var1).getSecondsInDay(), (Comparable)((DeviceAlarm)var2).getSecondsInDay());
            }
         });
         Bundle var13 = this.getArguments();
         boolean var4;
         if (var13 != null) {
            var4 = var13.getBoolean("ARG_SEARCHABLE");
         } else {
            var4 = this.searchable;
         }

         this.searchable = var4;
         DialogDeleteAlarmBinding var27 = this.viewDataBinding;
         DialogDeleteAlarmBinding var14 = var27;
         if (var27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var14 = null;
         }

         AppCompatEditText var15 = var14.etName;
         Intrinsics.checkNotNullExpressionValue(var15, "etName");
         View var16 = (View)var15;
         byte var3;
         if (this.searchable) {
            var3 = 0;
         } else {
            var3 = 8;
         }

         var16.setVisibility(var3);
         var27 = this.viewDataBinding;
         DialogDeleteAlarmBinding var17 = var27;
         if (var27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var17 = null;
         }

         var17.rvList.setHasFixedSize(true);
         ItemAdapter var6 = new ItemAdapter();
         List var29 = this.originAlarms;
         List var18 = var29;
         if (var29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("originAlarms");
            var18 = null;
         }

         Iterable var19 = (Iterable)var18;
         Collection var7 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var19, 10)));

         for(DeviceAlarm var9 : var19) {
            CharSequence var30 = (CharSequence)var9.getName();
            Object var20 = var30;
            if (StringsKt.isBlank(var30)) {
               String var31 = this.defName;
               var20 = var31;
               if (var31 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("defName");
                  var20 = null;
               }
            }

            var7.add(new DeletableItem((String)var20, var9, this.searchable ^ true));
         }

         var6.set((List)var7);
         this.itemAdapter = var6;
         DialogDeleteAlarmBinding var32 = this.viewDataBinding;
         DialogDeleteAlarmBinding var21 = var32;
         if (var32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var21 = null;
         }

         RecyclerView var34 = var21.rvList;
         FastAdapter.Companion var35 = FastAdapter.Companion;
         ItemAdapter var33 = this.itemAdapter;
         ItemAdapter var22 = var33;
         if (var33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
            var22 = null;
         }

         FastAdapter var23 = var35.with((IAdapter)var22);
         var23.setOnClickListener(new DeleteAlarmDialogFragment$$ExternalSyntheticLambda1(this));
         var34.setAdapter((RecyclerView.Adapter)var23);
         DialogDeleteAlarmBinding var24 = this.viewDataBinding;
         if (var24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var24 = (DialogDeleteAlarmBinding)var5;
         }

         AppCompatEditText var25 = var24.etName;
         Intrinsics.checkNotNullExpressionValue(var25, "etName");
         ((TextView)var25).addTextChangedListener(new TextWatcher(this) {
            final DeleteAlarmDialogFragment this$0;

            public {
               this.this$0 = var1;
            }

            public void afterTextChanged(Editable var1) {
               CharSequence var2;
               label59: {
                  if (var1 != null) {
                     CharSequence var7 = StringsKt.trim((CharSequence)var1);
                     var2 = var7;
                     if (var7 != null) {
                        break label59;
                     }
                  }

                  var2 = (CharSequence)"";
               }

               if (var2.length() == 0) {
                  ItemAdapter var18 = this.this$0.itemAdapter;
                  ItemAdapter var12 = var18;
                  if (var18 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
                     var12 = null;
                  }

                  IItemAdapter var24 = (IItemAdapter)var12;
                  List var19 = this.this$0.originAlarms;
                  List var13 = var19;
                  if (var19 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("originAlarms");
                     var13 = null;
                  }

                  Iterable var14 = (Iterable)var13;
                  Collection var25 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var14, 10)));

                  for(DeviceAlarm var27 : var14) {
                     CharSequence var20 = (CharSequence)var27.getName();
                     Object var15 = var20;
                     if (StringsKt.isBlank(var20)) {
                        String var21 = this.this$0.defName;
                        var15 = var21;
                        if (var21 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("defName");
                           var15 = null;
                        }
                     }

                     var25.add(new DeletableItem((String)var15, var27, this.this$0.searchable ^ true));
                  }

                  ModelAdapter var16 = (ModelAdapter)com.mikepenz.fastadapter.IItemAdapter.DefaultImpls.setNewList$default(var24, (List)var25, false, 2, (Object)null);
               } else {
                  List var4 = (List)(new ArrayList());
                  List var3 = this.this$0.originAlarms;
                  List var8 = var3;
                  if (var3 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("originAlarms");
                     var8 = null;
                  }

                  for(DeviceAlarm var6 : (Iterable)var8) {
                     CharSequence var22 = (CharSequence)var6.getName();
                     Object var9 = var22;
                     if (StringsKt.isBlank(var22)) {
                        String var23 = this.this$0.defName;
                        var9 = var23;
                        if (var23 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("defName");
                           var9 = null;
                        }
                     }

                     String var10 = (String)var9;
                     if (StringsKt.contains((CharSequence)var10, var2, true)) {
                        var4.add(new DeletableItem(var10, var6, this.this$0.searchable ^ true));
                     }
                  }

                  ItemAdapter var17 = this.this$0.itemAdapter;
                  ItemAdapter var11 = var17;
                  if (var17 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
                     var11 = null;
                  }

                  ModelAdapter var10000 = (ModelAdapter)com.mikepenz.fastadapter.IItemAdapter.DefaultImpls.setNewList$default((IItemAdapter)var11, var4, false, 2, (Object)null);
               }
            }

            public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
            }

            public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
            }
         });
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public void setViewModel(DeviceAlarmsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeleteAlarmDialogFragment$Companion;", "", "<init>", "()V", "ARG_SEARCHABLE", "", "ARG_WINDOW_Y", "newInstance", "Lcom/blueair/devicedetails/dialog/DeleteAlarmDialogFragment;", "device", "Lcom/blueair/core/model/HasAlarm;", "searchable", "", "anchorView", "Landroid/view/View;", "devicedetails_otherRelease"},
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

      // $FF: synthetic method
      public static DeleteAlarmDialogFragment newInstance$default(Companion var0, HasAlarm var1, boolean var2, View var3, int var4, Object var5) {
         if ((var4 & 4) != 0) {
            var3 = null;
         }

         return var0.newInstance(var1, var2, var3);
      }

      public final DeleteAlarmDialogFragment newInstance(HasAlarm var1, boolean var2, View var3) {
         Intrinsics.checkNotNullParameter(var1, "device");
         Bundle var4 = new Bundle();
         var4.putParcelable("device", var1);
         var4.putBoolean("ARG_SEARCHABLE", var2);
         if (var3 != null) {
            int[] var5 = new int[2];
            var3.getLocationOnScreen(var5);
            var4.putInt("ARG_WINDOW_Y", var5[1]);
         }

         DeleteAlarmDialogFragment var6 = new DeleteAlarmDialogFragment();
         var6.setArguments(var4);
         return var6;
      }
   }
}
