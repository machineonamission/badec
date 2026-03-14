package com.blueair.adddevice.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blueair.adddevice.R;
import com.blueair.auth.LogOutService;
import com.blueair.auth.LogoutReason;
import com.blueair.viewcore.activity.Actions;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.DIAware.DefaultImpls;
import org.kodein.di.android.DIPropertyDelegateProvider;
import org.kodein.di.android.x.ClosestKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"},
   d2 = {"Lcom/blueair/adddevice/fragment/RegionMismatchFragment;", "Landroidx/fragment/app/DialogFragment;", "Lorg/kodein/di/DIAware;", "<init>", "()V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "logOutService", "Lcom/blueair/auth/LogOutService;", "getLogOutService", "()Lcom/blueair/auth/LogOutService;", "logOutService$delegate", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class RegionMismatchFragment extends DialogFragment implements DIAware {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(RegionMismatchFragment.class, "di", "getDi()Lorg/kodein/di/DI;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(RegionMismatchFragment.class, "logOutService", "getLogOutService()Lcom/blueair/auth/LogOutService;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final Lazy di$delegate;
   private final Lazy logOutService$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$7OYTtN8Oqts5LrTia0WaQj_YUGE(RegionMismatchFragment var0, View var1) {
      onCreateDialog$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$MuprtXH5NI0xkof9eboj0RKj23c(RegionMismatchFragment var0, View var1) {
      onCreateDialog$lambda$3(var0, var1);
   }

   public RegionMismatchFragment() {
      DIPropertyDelegateProvider var2 = ClosestKt.closestDI((Fragment)this);
      KProperty[] var1 = $$delegatedProperties;
      this.di$delegate = var2.provideDelegate(this, var1[0]);
      DIAware var4 = this;
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.logOutService$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, LogOutService.class)), (Object)null).provideDelegate(this, var1[1]);
   }

   private final LogOutService getLogOutService() {
      return (LogOutService)this.logOutService$delegate.getValue();
   }

   private static final void onCreateDialog$lambda$3(RegionMismatchFragment var0, View var1) {
      var0.getLogOutService().logOutRegistered(LogoutReason.REGION_MISMATCH);
      FragmentActivity var2 = var0.getActivity();
      if (var2 != null) {
         var0.startActivity(Actions.openWelcomeIntent$default(Actions.INSTANCE, (Context)var2, false, 2, (Object)null));
      }

      var0.dismiss();
   }

   private static final void onCreateDialog$lambda$4(RegionMismatchFragment var0, View var1) {
      var0.dismiss();
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

   public Dialog onCreateDialog(Bundle var1) {
      FragmentActivity var2 = this.getActivity();
      View var5 = null;
      LayoutInflater var7;
      if (var2 != null) {
         var7 = var2.getLayoutInflater();
      } else {
         var7 = null;
      }

      if (var7 != null) {
         var5 = var7.inflate(R.layout.fragment_region_mismatch, (ViewGroup)null);
      }

      Dialog var8 = new Dialog(this.requireContext());
      if (var5 != null) {
         var8.setContentView(var5);
      }

      FragmentActivity var3 = this.getActivity();
      if (var3 != null) {
         Window var4 = var8.getWindow();
         if (var4 != null) {
            var4.setBackgroundDrawable(ContextCompat.getDrawable((Context)var3, com.blueair.viewcore.R.drawable.rounded_rectangle_white));
         }
      }

      if (var5 != null) {
         MaterialButton var9 = (MaterialButton)var5.findViewById(R.id.buttonRegister);
         if (var9 != null) {
            var9.setOnClickListener(new RegionMismatchFragment$$ExternalSyntheticLambda0(this));
         }
      }

      if (var5 != null) {
         MaterialButton var6 = (MaterialButton)var5.findViewById(R.id.buttonClose);
         if (var6 != null) {
            var6.setOnClickListener(new RegionMismatchFragment$$ExternalSyntheticLambda1(this));
         }
      }

      return var8;
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/adddevice/fragment/RegionMismatchFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/RegionMismatchFragment;", "adddevice_otherRelease"},
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

      public final RegionMismatchFragment newInstance() {
         return new RegionMismatchFragment();
      }
   }
}
