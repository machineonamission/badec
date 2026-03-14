package com.blueair.android.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.ActionBar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blueair.android.R;
import com.blueair.android.databinding.ActivityDevSettingsBinding;
import com.blueair.android.dialog.EditGigyaTokenDialogFragment;
import com.blueair.android.viewmodel.DevSettingsViewModel;
import com.blueair.auth.AuthService;
import com.blueair.auth.BlueCloudDomain;
import com.blueair.auth.GigyaServer;
import com.blueair.core.AblEnvironment;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.model.Device;
import com.blueair.core.util.SkuConfigurationManager;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.blueair.sdk.FirebaseSdk;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.viewmodel.BaseViewModelAction;
import com.blueair.viewcore.viewmodel.BaseViewModelEvent;
import com.blueair.viewcore.viewmodel.SnackbarMessage;
import com.google.android.material.snackbar.Snackbar;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import com.jakewharton.rxbinding2.view.RxView;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0014J\b\u0010\u001e\u001a\u00020\u0011H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001f²\u0006\n\u0010 \u001a\u00020!X\u008a\u0084\u0002"},
   d2 = {"Lcom/blueair/android/activity/DevSettingsActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "dataBinding", "Lcom/blueair/android/databinding/ActivityDevSettingsBinding;", "viewModel", "Lcom/blueair/android/viewmodel/DevSettingsViewModel;", "getViewModel", "()Lcom/blueair/android/viewmodel/DevSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "changeForceRegionAction", "region", "isChecked", "", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "bindViewModel", "updateUrls", "onResume", "showRestartHint", "app_otherRelease", "authService", "Lcom/blueair/auth/AuthService;"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DevSettingsActivity extends BaseActivity {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property0((PropertyReference0)(new PropertyReference0Impl(DevSettingsActivity.class, "authService", "<v#0>", 0)))};
   public static final int $stable = 8;
   private ActivityDevSettingsBinding dataBinding;
   private final String screenName = "side_menu_dev_settings";
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$_rR38hH_vXxBbys2OpxRlLR8PUU/* $FF was: $r8$lambda$-rR38hH_vXxBbys2OpxRlLR8PUU*/(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$42(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$02EfCCRNET4tsEJJu4jQ5DKhR_E(DevSettingsActivity var0, Result var1) {
      return onCreate$lambda$28(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$0KmAi4uNfzShpKHJQRFHf4aByQA(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$37(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$2vfMA4vvhe0q8zGUnxBmme0UjpU(DevSettingsActivity var0, View var1) {
      onCreate$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$3StuojH9l0s4z_779sjHkYvjsbo/* $FF was: $r8$lambda$3StuojH9l0s4z-779sjHkYvjsbo*/(DevSettingsActivity var0, View var1) {
      onCreate$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$64sHq_7K_BGcM_K2xIXmMJSjdF4/* $FF was: $r8$lambda$64sHq_7K-BGcM_K2xIXmMJSjdF4*/(LiveData var0, DevSettingsActivity var1, List var2) {
      return bindViewModel$lambda$52$lambda$51(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$6IPXrUHtDtOjorUBKG_hOLRi0nA(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$31(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$8Vc4wLj34oWBTIl686tUZTcDfE4(DevSettingsActivity var0, Boolean var1) {
      return bindViewModel$lambda$49(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$8b5ld96DcxOOw2NxvZ5WR_UHQSU(DevSettingsActivity var0, View var1) {
      onCreate$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$9BYs8cId3wrPBPpvVBEq6HHzu2o(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$20(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$BDU8VjjWpZgiXXxnuDpzAWp0860(DevSettingsActivity var0, View var1) {
      onCreate$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$BFcmbOgEQxThKlWRErgt_hkpDug(DevSettingsActivity var0, View var1) {
      onCreate$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$BoZUdgBPxgM41sKcj_3O2EJNeQk(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$21(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$D2BCmZsCAQNKse4K4aIsqqfxMoY(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$38(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$D4g8q5rQuGu_jUKb1EcMOJeDRbc/* $FF was: $r8$lambda$D4g8q5rQuGu-jUKb1EcMOJeDRbc*/(DevSettingsActivity var0, Result var1) {
      return onCreate$lambda$29(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$EZi_zJa3UjANHrZtxWBmuwn41kA(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$19(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$FsN0LIzw4RfXlR4hbsnLI9FdLpc(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$40(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$JZjeeSXtslqXJBU0K_m__uiz91Y/* $FF was: $r8$lambda$JZjeeSXtslqXJBU0K-m_-uiz91Y*/(DevSettingsActivity var0, View var1) {
      onCreate$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$KOUH2iHAanLWawgJEyIi5_oRcFQ(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$30(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$L6kevBs_dhW9gQj7VDLNOeQ9_Xs(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$32(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$M_L700w5RAwy_BpOIzv4BbUyJxc/* $FF was: $r8$lambda$M-L700w5RAwy-BpOIzv4BbUyJxc*/(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$22(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$M2V_AxEfxla4W8r2F8IGrR5rUOI(DevSettingsActivity var0, View var1) {
      onCreate$lambda$45(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$NJNkDktpV284lcZMfiFkTVfHHNI(DevSettingsActivity var0, View var1) {
      onCreate$lambda$47(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$QyMIlgf_ZJzhiRq_Q8kyrIPV_nU(DevSettingsActivity var0, View var1) {
      onCreate$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$U01YcY4Ya8eBpDfWQ5__qFCmLkM(DevSettingsActivity var0, View var1) {
      onCreate$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Vk66LLD6EwPiX2penD0LDMLBtTY(DevSettingsActivity var0, View var1) {
      onCreate$lambda$36(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$W3VHSg7GMIM_UJO8EaSo0LvFomA(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$23(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$YuBSM4jW0Kk1csp80EXYLc4zpPU(View var0) {
      onCreate$lambda$3(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$YzaommD_VDHdG4VDkW97OuSblxA/* $FF was: $r8$lambda$YzaommD-VDHdG4VDkW97OuSblxA*/(DevSettingsActivity var0, View var1) {
      onCreate$lambda$26(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$_kdsJL6V5cjhuG9kSvFcCAaLijo(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$14(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$dUJCgNYhnPxkyi8d0EZ_0PlQHw8(DevSettingsActivity var0, View var1) {
      onCreate$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$dvN_Z6f4kb7Mur1UXt1fTOvmlH8/* $FF was: $r8$lambda$dvN-Z6f4kb7Mur1UXt1fTOvmlH8*/(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$18(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$g_BzcWnfKAslk96HccD5MqcTZ58/* $FF was: $r8$lambda$g-BzcWnfKAslk96HccD5MqcTZ58*/(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$41(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$jd6GvYuLNWGKdFFxmskKbV1LEsc(DevSettingsActivity var0, View var1) {
      onCreate$lambda$24(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$k7cqVyvB7qd9mlOAWxz_X9t_3_Y/* $FF was: $r8$lambda$k7cqVyvB7qd9mlOAWxz-X9t_3_Y*/(DevSettingsActivity var0) {
      onCreate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$kXC6gYbuHU5GkHb8AE6c_k6FHpY(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$15(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$lFkfj9iORI6YnKBG9RTg4BabjF8(DevSettingsActivity var0, Object var1) {
      return onResume$lambda$53(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$oZyvCAsgGYo8N7tWCkEtpNhVPjc(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$16(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$pfmh_5djNTGEzXLHvXbjKHrEzq8/* $FF was: $r8$lambda$pfmh-5djNTGEzXLHvXbjKHrEzq8*/(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$17(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$qOrwotQ_Up_ypPTYoo_Y_nR2pMI/* $FF was: $r8$lambda$qOrwotQ_Up_ypPTYoo-Y-nR2pMI*/(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$39(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$tFvSDSzBgpY_LFVCOpS3O_1I3fI/* $FF was: $r8$lambda$tFvSDSzBgpY-LFVCOpS3O_1I3fI*/(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$33(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$uESUF4CC0cYxCsoGruUU478XRLE(DevSettingsActivity var0, View var1) {
      onCreate$lambda$46(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$uROunC79i57eCMeihdv9hbKwoBY(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$34(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$wBiuVfMuxW9Qf0gu_t2SPQqEBik(DevSettingsActivity var0, View var1) {
      onCreate$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$xSgw_QirHAUfzZfDPzRGJ_bbBK4/* $FF was: $r8$lambda$xSgw-QirHAUfzZfDPzRGJ-bbBK4*/(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      onCreate$lambda$43(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$xVlnjQRGEv5TaZ_ihdVXGztmJ3g/* $FF was: $r8$lambda$xVlnjQRGEv5TaZ-ihdVXGztmJ3g*/(DevSettingsActivity var0, BaseViewModelEvent var1) {
      return onResume$lambda$54(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$xkt7XmXlGTwJUpb93Tk5T_qc_ZY(DevSettingsActivity var0, View var1) {
      onCreate$lambda$35(var0, var1);
   }

   public DevSettingsActivity() {
      ComponentActivity var2 = (ComponentActivity)this;
      Function0 var1 = new Function0(var2) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
         }
      };
      this.viewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(DevSettingsViewModel.class), new Function0(var2) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
         }
      }, var1, new Function0((Function0)null, var2) {
         final Function0 $extrasProducer;
         final ComponentActivity $this_viewModels;

         public {
            this.$extrasProducer = var1;
            this.$this_viewModels = var2;
         }

         public final CreationExtras invoke() {
            Function0 var1 = this.$extrasProducer;
            if (var1 != null) {
               CreationExtras var2 = (CreationExtras)var1.invoke();
               if (var2 != null) {
                  return var2;
               }
            }

            return this.$this_viewModels.getDefaultViewModelCreationExtras();
         }
      }));
   }

   private final void bindViewModel() {
      ActivityDevSettingsBinding var1 = DataBindingUtil.setContentView((Activity)this, R.layout.activity_dev_settings);
      Intrinsics.checkNotNullExpressionValue(var1, "setContentView(...)");
      ActivityDevSettingsBinding var2 = var1;
      this.dataBinding = var2;
      var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      LifecycleOwner var5 = (LifecycleOwner)this;
      var1.setLifecycleOwner(var5);
      LiveDataExtensionsKt.observeNonNull((LiveData)this.getViewModel().getRemoteConfigUpdated(), var5, new DevSettingsActivity$$ExternalSyntheticLambda0(this));
      LiveData var4 = this.getViewModel().getLiveDevices();
      var4.observe(var5, new Observer(new DevSettingsActivity$$ExternalSyntheticLambda11(var4, this)) {
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
   }

   private static final Unit bindViewModel$lambda$49(DevSettingsActivity var0, Boolean var1) {
      String var2;
      if (var1) {
         var2 = "Remote config successfully updated";
      } else {
         var2 = "Failed to update remote config";
      }

      Toast.makeText((Context)var0, (CharSequence)var2, 0).show();
      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$52$lambda$51(LiveData var0, DevSettingsActivity var1, List var2) {
      var0.removeObservers((LifecycleOwner)var1);
      ActivityDevSettingsBinding var3 = var1.dataBinding;
      ActivityDevSettingsBinding var6 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var6 = null;
      }

      Spinner var7 = var6.welcomeHomeDeviceSpinner;
      Intrinsics.checkNotNullExpressionValue(var7, "welcomeHomeDeviceSpinner");
      Context var4 = (Context)var1;
      Intrinsics.checkNotNull(var2);
      Iterable var5 = (Iterable)var2;
      Collection var8 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var5, 10)));
      Iterator var10 = var5.iterator();

      while(var10.hasNext()) {
         var8.add(((Device)var10.next()).getName());
      }

      ArrayAdapter var9 = new ArrayAdapter(var4, 17367048, (List)var8);
      var9.setDropDownViewResource(17367049);
      var7.setAdapter((SpinnerAdapter)var9);
      var7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(var1, var2) {
         final List $devices;
         final DevSettingsActivity this$0;

         {
            this.this$0 = var1;
            this.$devices = var2;
         }

         public void onItemSelected(AdapterView var1, View var2, int var3, long var4) {
            DevSettingsViewModel var7 = this.this$0.getViewModel();
            List var6 = this.$devices;
            Intrinsics.checkNotNull(var6);
            var7.setWelcomeHomeTestDevice((Device)CollectionsKt.getOrNull(var6, var3));
         }

         public void onNothingSelected(AdapterView var1) {
            this.this$0.getViewModel().setWelcomeHomeTestDevice((Device)null);
         }
      });
      return Unit.INSTANCE;
   }

   private final void changeForceRegionAction(String var1, boolean var2) {
      if (var2) {
         this.getViewModel().setForceRegion(true, var1);
         int var3 = var1.hashCode();
         Object var5 = null;
         Object var6 = null;
         Object var4 = null;
         if (var3 != 3179) {
            if (var3 != 3431) {
               if (var3 == 3742 && var1.equals("us")) {
                  ActivityDevSettingsBinding var15 = this.dataBinding;
                  ActivityDevSettingsBinding var7 = var15;
                  if (var15 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                     var7 = null;
                  }

                  var7.checkChina.setChecked(false);
                  var7 = this.dataBinding;
                  if (var7 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                     var7 = (ActivityDevSettingsBinding)var4;
                  }

                  var7.checkKorea.setChecked(false);
                  return;
               }
            } else if (var1.equals("kr")) {
               ActivityDevSettingsBinding var13 = this.dataBinding;
               ActivityDevSettingsBinding var9 = var13;
               if (var13 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                  var9 = null;
               }

               var9.checkUSA.setChecked(false);
               var9 = this.dataBinding;
               if (var9 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                  var9 = (ActivityDevSettingsBinding)var5;
               }

               var9.checkChina.setChecked(false);
               return;
            }
         } else if (var1.equals("cn")) {
            ActivityDevSettingsBinding var14 = this.dataBinding;
            ActivityDevSettingsBinding var11 = var14;
            if (var14 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
               var11 = null;
            }

            var11.checkUSA.setChecked(false);
            var11 = this.dataBinding;
            if (var11 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
               var11 = (ActivityDevSettingsBinding)var6;
            }

            var11.checkKorea.setChecked(false);
            return;
         }
      } else if (Intrinsics.areEqual(var1, this.getViewModel().getForceRegion())) {
         this.getViewModel().setForceRegion(false, var1);
      }

   }

   private final DevSettingsViewModel getViewModel() {
      return (DevSettingsViewModel)this.viewModel$delegate.getValue();
   }

   private static final void onCreate$lambda$0(DevSettingsActivity var0) {
      ActivityDevSettingsBinding var1 = var0.dataBinding;
      ActivityDevSettingsBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var2 = null;
      }

      var2.buttonSaveUrl.setEnabled(true);
   }

   private static final void onCreate$lambda$1(DevSettingsActivity var0, View var1) {
      var0.getViewModel().showNotification();
   }

   private static final void onCreate$lambda$10(DevSettingsActivity var0, View var1) {
      DevSettingsViewModel.forceBackend$default(var0.getViewModel(), "cn-north-1", false, 2, (Object)null);
      var0.updateUrls();
   }

   private static final void onCreate$lambda$11(DevSettingsActivity var0, View var1) {
      DevSettingsViewModel.forceBackend$default(var0.getViewModel(), (String)null, true, 1, (Object)null);
      var0.updateUrls();
   }

   private static final void onCreate$lambda$12(DevSettingsActivity var0, View var1) {
      DevSettingsViewModel.forceBackend$default(var0.getViewModel(), (String)null, false, 1, (Object)null);
      var0.updateUrls();
   }

   private static final void onCreate$lambda$13(DevSettingsActivity var0, View var1) {
      var0.getViewModel().setBackend(BlueCloudDomain.Companion.getINVALID());
      var0.updateUrls();
   }

   private static final void onCreate$lambda$14(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.changeForceRegionAction("cn", var2);
   }

   private static final void onCreate$lambda$15(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.changeForceRegionAction("us", var2);
   }

   private static final void onCreate$lambda$16(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.changeForceRegionAction("kr", var2);
   }

   private static final void onCreate$lambda$17(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.getViewModel().setForceAwareAvailable(var2);
   }

   private static final void onCreate$lambda$18(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.getViewModel().setForceIcpAvailable(var2);
   }

   private static final void onCreate$lambda$19(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.getViewModel().setForceG4available(var2);
   }

   private static final void onCreate$lambda$2(DevSettingsActivity var0, View var1) {
      var0.getViewModel().resetUserInfoSyncTime();
   }

   private static final void onCreate$lambda$20(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.getViewModel().setForceB4available(var2);
   }

   private static final void onCreate$lambda$21(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.getViewModel().setForceAlexaAvailable(var2);
   }

   private static final void onCreate$lambda$22(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.getViewModel().setForceTmallAvailable(var2);
   }

   private static final void onCreate$lambda$23(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.getViewModel().setForceGAssistantAvailable(var2);
   }

   private static final void onCreate$lambda$24(DevSettingsActivity var0, View var1) {
      UploadLogActivity.Companion.launch((Context)var0);
   }

   private static final void onCreate$lambda$26(DevSettingsActivity var0, View var1) {
      FragmentManager var2 = var0.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("EditGigyaTokenDialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("EditGigyaTokenDialogFragment") instanceof EditGigyaTokenDialogFragment) && !var2.isStateSaved()) {
         ((DialogFragment)EditGigyaTokenDialogFragment.Companion.newInstance(var0.getViewModel().getGigyaToken())).show(var2, "EditGigyaTokenDialogFragment");
      }

   }

   private static final AuthService onCreate$lambda$27(Lazy var0) {
      return (AuthService)var0.getValue();
   }

   private static final Unit onCreate$lambda$28(DevSettingsActivity var0, Result var1) {
      ActivityDevSettingsBinding var3 = var0.dataBinding;
      Object var2 = null;
      ActivityDevSettingsBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var4 = null;
      }

      TextView var7 = var4.textViewFCM;
      CharSequence var6;
      if (Result.isSuccess-impl(var1.unbox-impl())) {
         Object var5 = var1.unbox-impl();
         if (Result.isFailure-impl(var5)) {
            var5 = var2;
         }

         var6 = (CharSequence)var5;
      } else {
         var6 = (CharSequence)"failed";
      }

      var7.setText(var6);
      return Unit.INSTANCE;
   }

   private static final Unit onCreate$lambda$29(DevSettingsActivity var0, Result var1) {
      ActivityDevSettingsBinding var3 = var0.dataBinding;
      Object var2 = null;
      ActivityDevSettingsBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var4 = null;
      }

      TextView var7 = var4.textViewIAM;
      CharSequence var6;
      if (Result.isSuccess-impl(var1.unbox-impl())) {
         Object var5 = var1.unbox-impl();
         if (Result.isFailure-impl(var5)) {
            var5 = var2;
         }

         var6 = (CharSequence)var5;
      } else {
         var6 = (CharSequence)"failed";
      }

      var7.setText(var6);
      return Unit.INSTANCE;
   }

   private static final void onCreate$lambda$3(View var0) {
      StringBuilder var1 = new StringBuilder("Force Crash on ");
      var1.append(new Date());
      throw new RuntimeException(var1.toString());
   }

   private static final void onCreate$lambda$30(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.getViewModel().setAmplitudeDebug(var2);
      var0.getViewModel().reInitAmplitude(var2);
   }

   private static final void onCreate$lambda$31(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.getViewModel().setFacebookLoginEnabled(var2);
   }

   private static final void onCreate$lambda$32(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.getViewModel().setGoogleLoginEnabled(var2);
   }

   private static final void onCreate$lambda$33(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.getViewModel().setWechatQQAppleLoginEnabled(var2);
   }

   private static final void onCreate$lambda$34(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.getViewModel().setForceWelcomeHome(var2);
   }

   private static final void onCreate$lambda$35(DevSettingsActivity var0, View var1) {
      var0.getViewModel().toggleShouldShowRateUsDev();
   }

   private static final void onCreate$lambda$36(DevSettingsActivity var0, View var1) {
      var0.getViewModel().toggleShouldShowWHExploreDev();
   }

   private static final void onCreate$lambda$37(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.getViewModel().setLokalisePreRelease(var2);
   }

   private static final void onCreate$lambda$38(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.getViewModel().setGoogleLive(var2 ^ true);
   }

   private static final void onCreate$lambda$39(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.getViewModel().setAlexaLive(var2 ^ true);
   }

   private static final void onCreate$lambda$4(DevSettingsActivity var0, View var1) {
      var0.getViewModel().forceUpdateRemoteConfig();
   }

   private static final void onCreate$lambda$40(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      if (var0.getViewModel().getInUatMode() != var2) {
         var0.showRestartHint();
      }

      var0.getViewModel().setUatMode(var2);
   }

   private static final void onCreate$lambda$41(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.getViewModel().setUseGigyaSandbox(var2);
      GigyaServer.Companion.setUseSandbox(var2);
   }

   private static final void onCreate$lambda$42(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      if (var0.getViewModel().getUseDevKlaviyo() != var2) {
         var0.showRestartHint();
      }

      var0.getViewModel().setUseDevKlaviyo(var2);
   }

   private static final void onCreate$lambda$43(DevSettingsActivity var0, CompoundButton var1, boolean var2) {
      var0.getViewModel().setShowDetectCat(var2);
   }

   private static final void onCreate$lambda$45(DevSettingsActivity var0, View var1) {
      Device var6 = var0.getViewModel().getWelcomeHomeTestDevice();
      if (var6 != null) {
         DevSettingsViewModel var5 = var0.getViewModel();
         ActivityDevSettingsBinding var4 = var0.dataBinding;
         Object var3 = null;
         ActivityDevSettingsBinding var8 = var4;
         if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            var8 = null;
         }

         boolean var2 = var8.welcomeHomeIsMinRadius.isChecked();
         ActivityDevSettingsBinding var7 = var0.dataBinding;
         if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            var7 = (ActivityDevSettingsBinding)var3;
         }

         var5.testWelcomeHome(var6, var2, var7.welcomeHomeIsEnter.isChecked());
      }

   }

   private static final void onCreate$lambda$46(DevSettingsActivity var0, View var1) {
      var0.getViewModel().revokeAqiDismission();
   }

   private static final void onCreate$lambda$47(DevSettingsActivity var0, View var1) {
      DevSettingsViewModel var4 = var0.getViewModel();
      ActivityDevSettingsBinding var3 = var0.dataBinding;
      Object var2 = null;
      ActivityDevSettingsBinding var7 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var7 = null;
      }

      Editable var8 = var7.etIntermittent.getText();
      Intrinsics.checkNotNullExpressionValue(var8, "getText(...)");
      CharSequence var9 = (CharSequence)var8;
      ActivityDevSettingsBinding var5 = var0.dataBinding;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var5 = (ActivityDevSettingsBinding)var2;
      }

      Editable var6 = var5.etContinuous.getText();
      Intrinsics.checkNotNullExpressionValue(var6, "getText(...)");
      var4.saveAqiThresold(var9, (CharSequence)var6);
   }

   private static final void onCreate$lambda$7(DevSettingsActivity var0, View var1) {
      var0.getViewModel().setHomehost(AblEnvironment.INSTANCE.getBaseUrl());
      var0.showRestartHint();
   }

   private static final void onCreate$lambda$8(DevSettingsActivity var0, View var1) {
      DevSettingsViewModel.forceBackend$default(var0.getViewModel(), "us-east-2", false, 2, (Object)null);
      var0.updateUrls();
   }

   private static final void onCreate$lambda$9(DevSettingsActivity var0, View var1) {
      DevSettingsViewModel.forceBackend$default(var0.getViewModel(), "eu-west-1", false, 2, (Object)null);
      var0.updateUrls();
   }

   private static final Unit onResume$lambda$53(DevSettingsActivity var0, Object var1) {
      DevSettingsViewModel var4 = var0.getViewModel();
      ActivityDevSettingsBinding var3 = var0.dataBinding;
      Object var2 = null;
      ActivityDevSettingsBinding var6 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var6 = null;
      }

      String var7 = StringsKt.trim((CharSequence)var6.editTextBaseUrl.getText().toString()).toString();
      ActivityDevSettingsBinding var5 = var0.dataBinding;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var5 = (ActivityDevSettingsBinding)var2;
      }

      var4.changeBaseUrl(var7, StringsKt.trim((CharSequence)var5.editBrokerBaseURL.getText().toString()).toString());
      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$54(DevSettingsActivity var0, BaseViewModelEvent var1) {
      if (Intrinsics.areEqual(var1.getAction(), BaseViewModelAction.ShowSnackbar.INSTANCE)) {
         Object var2 = var1.getVariable();
         Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type com.blueair.viewcore.viewmodel.SnackbarMessage");
         SnackbarMessage var3 = (SnackbarMessage)var2;
         ViewUtils.INSTANCE.showSnackbar((Activity)var0, var3.getMessageResId(), var3.getType());
      }

      return Unit.INSTANCE;
   }

   private final void showRestartHint() {
      ActivityDevSettingsBinding var2 = this.dataBinding;
      ActivityDevSettingsBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      Snackbar.make(var1.getRoot(), (CharSequence)"Please restart the app to apply changes!", 0).show();
   }

   private final void updateUrls() {
      ActivityDevSettingsBinding var3 = this.dataBinding;
      Object var2 = null;
      ActivityDevSettingsBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      TextView var9 = var1.labelTextBaseUrl;
      StringBuilder var4 = new StringBuilder("Default API:\n");
      var4.append(this.getViewModel().getDefaultUrl());
      var9.setText((CharSequence)var4.toString());
      ActivityDevSettingsBinding var10 = this.dataBinding;
      ActivityDevSettingsBinding var5 = var10;
      if (var10 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var5 = null;
      }

      var5.editTextBaseUrl.setText((CharSequence)this.getViewModel().getBaseUrl());
      var10 = this.dataBinding;
      var5 = var10;
      if (var10 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var5 = null;
      }

      TextView var12 = var5.labelBrokerBaseURL;
      StringBuilder var7 = new StringBuilder("Default Broker:\n");
      var7.append(this.getViewModel().getDefaultBroker());
      var12.setText((CharSequence)var7.toString());
      ActivityDevSettingsBinding var8 = this.dataBinding;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var8 = (ActivityDevSettingsBinding)var2;
      }

      var8.editBrokerBaseURL.setText((CharSequence)this.getViewModel().getBrokerBaseURL());
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.bindViewModel();
      ActivityDevSettingsBinding var3 = this.dataBinding;
      Object var2 = null;
      ActivityDevSettingsBinding var6 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var6 = null;
      }

      this.setSupportActionBar(var6.toolbar);
      ActionBar var7 = this.getSupportActionBar();
      if (var7 != null) {
         var7.setDisplayHomeAsUpEnabled(true);
      }

      this.updateUrls();
      var3 = this.dataBinding;
      ActivityDevSettingsBinding var8 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var8 = null;
      }

      var8.buttonSaveUrl.postDelayed(new DevSettingsActivity$$ExternalSyntheticLambda41(this), 1000L);
      var3 = this.dataBinding;
      var8 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var8 = null;
      }

      var8.showNotification.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda6(this));
      var3 = this.dataBinding;
      var8 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var8 = null;
      }

      var8.resetUserInfoSyncTime.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda18(this));
      var3 = this.dataBinding;
      var8 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var8 = null;
      }

      var8.forceCrash.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda30());
      var3 = this.dataBinding;
      var8 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var8 = null;
      }

      var8.forceUpdate.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda35(this));
      var3 = this.dataBinding;
      var8 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var8 = null;
      }

      TextView var14 = var8.appBuildInfo;
      StringBuilder var64 = new StringBuilder();
      var64.append(BuildEnvironment.INSTANCE.getDisplayVersion());
      var64.append(" | release | other | d22d51a | ");
      SkuConfigurationManager var4 = SkuConfigurationManager.INSTANCE;
      StringBuilder var5 = new StringBuilder("(");
      var5.append(var4.getSeries());
      var5.append(", ");
      var5.append(var4.getVersion());
      var5.append(')');
      var64.append(var5.toString());
      var64.append(" | ");
      UserInfoCollectionsManager var107 = UserInfoCollectionsManager.INSTANCE;
      StringBuilder var106 = new StringBuilder("(");
      var106.append(var107.getSeries());
      var106.append(", ");
      var106.append(var107.getVersion());
      var106.append(')');
      var64.append(var106.toString());
      var14.setText((CharSequence)var64.toString());
      ActivityDevSettingsBinding var65 = this.dataBinding;
      ActivityDevSettingsBinding var15 = var65;
      if (var65 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var15 = null;
      }

      TextView var66 = var15.gigyaUserRegion;
      StringBuilder var16 = new StringBuilder("Gigya dataCenter: ");
      var16.append(this.getViewModel().getGigyaDataCenter());
      var16.append(" | Gigya appRegion: ");
      var16.append(this.getViewModel().getGigyaCloudDomainRegion());
      var16.append(" | Device region: ");
      var16.append(this.getViewModel().getDeviceRegion());
      var16.append(" | IP region: ");
      var16.append(this.getViewModel().getIpRegion());
      var66.setText((CharSequence)var16.toString());
      ActivityDevSettingsBinding var67 = this.dataBinding;
      ActivityDevSettingsBinding var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.legacyHomehost.setText((CharSequence)this.getViewModel().getHomehost());
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.resetHomehost.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda36(this));
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.setUrlUs.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda37(this));
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.setUrlEu.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda38(this));
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.setUrlCn.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda39(this));
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.forceRelease.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda40(this));
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.forceQa.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda42(this));
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.forceReset.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda43(this));
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.checkChina.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda44(this));
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.checkUSA.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda45(this));
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.checkKorea.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda46(this));
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.checkForceAware.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda1(this));
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.checkForceIcp.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda2(this));
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.checkForceG4.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda3(this));
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.checkForceB4.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda4(this));
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.checkForceAlexa.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda5(this));
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.checkForceTmall.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda7(this));
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.checkForceGAssistant.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda8(this));
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.sendLogs.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda9(this));
      var67 = this.dataBinding;
      var17 = var67;
      if (var67 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var17 = null;
      }

      var17.setGigyaToken.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda10(this));
      DIAware var87 = this;
      JVMTypeToken var37 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var37, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      Lazy var38 = DIAwareKt.Instance(var87, (TypeToken)(new GenericJVMTypeTokenDelegate(var37, AuthService.class)), (Object)null).provideDelegate((Object)null, $$delegatedProperties[0]);
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var38, this, (Continuation)null) {
         final Lazy $authService$delegate;
         Object L$0;
         int label;
         final DevSettingsActivity this$0;

         {
            this.$authService$delegate = var1;
            this.this$0 = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$authService$delegate, this.this$0, var2));
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

                  String var3 = (String)this.L$0;
                  ResultKt.throwOnFailure(var1);
                  return Unit.INSTANCE;
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               AuthService var9 = DevSettingsActivity.onCreate$lambda$27(this.$authService$delegate);
               Continuation var7 = (Continuation)this;
               this.label = 1;
               Object var10 = var9.getCloudJwt(var7);
               var1 = var10;
               if (var10 == var4) {
                  return var4;
               }
            }

            String var5 = (String)var1;
            CoroutineContext var6 = (CoroutineContext)Dispatchers.getMain();
            Function2 var8 = new Function2(this.this$0, var5, (Continuation)null) {
               final String $cloudToken;
               int label;
               final DevSettingsActivity this$0;

               {
                  this.this$0 = var1;
                  this.$cloudToken = var2;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, this.$cloudToken, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  if (this.label == 0) {
                     ResultKt.throwOnFailure(var1);
                     ActivityDevSettingsBinding var2 = this.this$0.dataBinding;
                     ActivityDevSettingsBinding var3 = var2;
                     if (var2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                        var3 = null;
                     }

                     var3.textViewAPI.setText((CharSequence)this.$cloudToken);
                     return Unit.INSTANCE;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }
            };
            Continuation var11 = (Continuation)this;
            this.L$0 = SpillingKt.nullOutSpilledVariable(var5);
            this.label = 2;
            if (BuildersKt.withContext(var6, var8, var11) == var4) {
               return var4;
            } else {
               return Unit.INSTANCE;
            }
         }
      }, 2, (Object)null);
      FirebaseSdk.INSTANCE.getMessagingToken(new DevSettingsActivity$$ExternalSyntheticLambda12(this));
      FirebaseSdk.INSTANCE.getInstallationsId(new DevSettingsActivity$$ExternalSyntheticLambda13(this));
      ActivityDevSettingsBinding var88 = this.dataBinding;
      ActivityDevSettingsBinding var39 = var88;
      if (var88 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = null;
      }

      var39.checkAmplitudeDebug.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda14(this));
      var88 = this.dataBinding;
      var39 = var88;
      if (var88 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = null;
      }

      var39.checkFacebookLogin.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda15(this));
      var88 = this.dataBinding;
      var39 = var88;
      if (var88 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = null;
      }

      var39.checkGoogleLogin.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda16(this));
      var88 = this.dataBinding;
      var39 = var88;
      if (var88 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = null;
      }

      var39.checkWeChatQQApple.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda17(this));
      var88 = this.dataBinding;
      var39 = var88;
      if (var88 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = null;
      }

      var39.checkForceWelcomeHome.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda19(this));
      var88 = this.dataBinding;
      var39 = var88;
      if (var88 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = null;
      }

      var39.forceRateUs.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda20(this));
      var88 = this.dataBinding;
      var39 = var88;
      if (var88 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = null;
      }

      var39.forceWelcomeHomeIntro.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda21(this));
      var88 = this.dataBinding;
      var39 = var88;
      if (var88 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = null;
      }

      var39.checkLokalisePreRelease.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda23(this));
      var88 = this.dataBinding;
      var39 = var88;
      if (var88 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = null;
      }

      var39.checkGoogleDev.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda24(this));
      var88 = this.dataBinding;
      var39 = var88;
      if (var88 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = null;
      }

      var39.checkAlexaDev.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda25(this));
      var88 = this.dataBinding;
      var39 = var88;
      if (var88 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = null;
      }

      var39.checkUAT.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda26(this));
      var88 = this.dataBinding;
      var39 = var88;
      if (var88 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = null;
      }

      var39.useGigyaSandbox.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda27(this));
      var88 = this.dataBinding;
      var39 = var88;
      if (var88 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = null;
      }

      var39.checkKlaviyoDev.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda28(this));
      var88 = this.dataBinding;
      var39 = var88;
      if (var88 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = null;
      }

      var39.checkShowDetectCat.setOnCheckedChangeListener(new DevSettingsActivity$$ExternalSyntheticLambda29(this));
      var88 = this.dataBinding;
      var39 = var88;
      if (var88 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = null;
      }

      var39.welcomeHomeTestBtn.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda31(this));
      var88 = this.dataBinding;
      var39 = var88;
      if (var88 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = null;
      }

      var39.etIntermittent.setText((CharSequence)String.valueOf(this.getViewModel().getAqiNotificationIntermittentInSecond()));
      var88 = this.dataBinding;
      var39 = var88;
      if (var88 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = null;
      }

      var39.etContinuous.setText((CharSequence)String.valueOf(this.getViewModel().getAqiNotificationContinuousInSecond()));
      var88 = this.dataBinding;
      var39 = var88;
      if (var88 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = null;
      }

      var39.revokeDismission.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda32(this));
      var39 = this.dataBinding;
      if (var39 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var39 = (ActivityDevSettingsBinding)var2;
      }

      var39.btnSaveAqiThresold.setOnClickListener(new DevSettingsActivity$$ExternalSyntheticLambda34(this));
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      Intrinsics.checkNotNullParameter(var1, "item");
      if (var1.getItemId() == 16908332) {
         this.onBackPressed();
         return true;
      } else {
         return super.onOptionsItemSelected(var1);
      }
   }

   protected void onResume() {
      super.onResume();
      ActivityDevSettingsBinding var3 = this.dataBinding;
      Object var2 = null;
      ActivityDevSettingsBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkChina.setChecked(this.getViewModel().isForceChina());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkUSA.setChecked(this.getViewModel().isForceUSA());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkKorea.setChecked(this.getViewModel().isForceKorea());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkForceAware.setChecked(this.getViewModel().getForceAwareAvailable());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkForceIcp.setChecked(this.getViewModel().getForceIcpAvailable());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkForceG4.setChecked(this.getViewModel().getForceG4available());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkForceB4.setChecked(this.getViewModel().getForceB4available());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkForceAlexa.setChecked(this.getViewModel().getForceAlexaAvailable());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkForceTmall.setChecked(this.getViewModel().getForceTmallAvailable());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkForceGAssistant.setChecked(this.getViewModel().getForceGAssistantAvailable());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkAmplitudeDebug.setChecked(this.getViewModel().getAmplitudeDebug());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkFacebookLogin.setChecked(this.getViewModel().getFacebookLoginEnabled());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkGoogleLogin.setChecked(this.getViewModel().getGoogleLoginEnabled());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkWeChatQQApple.setChecked(this.getViewModel().getWechatQQAppleLoginEnabled());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkForceWelcomeHome.setChecked(this.getViewModel().getForceWelcomeHome());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkLokalisePreRelease.setChecked(this.getViewModel().getLokalisePreRelease());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkGoogleDev.setChecked(this.getViewModel().getGoogleLive() ^ true);
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkAlexaDev.setChecked(this.getViewModel().getAlexaLive() ^ true);
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkUAT.setChecked(this.getViewModel().getInUatMode());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.useGigyaSandbox.setChecked(this.getViewModel().getUseGigyaSandbox());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkKlaviyoDev.setChecked(this.getViewModel().getUseDevKlaviyo());
      var3 = this.dataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = null;
      }

      var1.checkShowDetectCat.setChecked(this.getViewModel().getShowDetectCat());
      CompositeDisposable var48 = this.getRxSubs();
      var1 = this.dataBinding;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
         var1 = (ActivityDevSettingsBinding)var2;
      }

      Observable var26 = RxView.clicks((View)var1.buttonSaveUrl);
      Intrinsics.checkNotNullExpressionValue(var26, "clicks(...)");
      var48.add(RxExtensionsKt.subscribeAndLogE(var26, new DevSettingsActivity$$ExternalSyntheticLambda22(this)));
      this.getRxSubs().add(RxExtensionsKt.subscribeAndLogE((Observable)this.getViewModel().getBaseActionPublisher(), new DevSettingsActivity$$ExternalSyntheticLambda33(this)));
   }
}
