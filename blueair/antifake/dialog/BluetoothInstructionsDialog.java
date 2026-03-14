package com.blueair.antifake.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blueair.adddevice.utils.AddDeviceUtils;
import com.blueair.antifake.databinding.DialogBluetoothInstructionsBinding;
import com.blueair.bluetooth.utils.BluetoothUtils;
import com.blueair.core.util.LocationPermissionTracker;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.dialog.DialogUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
   d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0019H\u0016J\b\u0010#\u001a\u00020\u0019H\u0016J\b\u0010$\u001a\u00020\u0019H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0013 \u0014*\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00120\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"},
   d2 = {"Lcom/blueair/antifake/dialog/BluetoothInstructionsDialog;", "Landroidx/fragment/app/DialogFragment;", "Lorg/kodein/di/DIAware;", "<init>", "()V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "locationPermissionTracker", "Lcom/blueair/core/util/LocationPermissionTracker;", "getLocationPermissionTracker", "()Lcom/blueair/core/util/LocationPermissionTracker;", "locationPermissionTracker$delegate", "requestBluetoothPermissionsLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "kotlin.jvm.PlatformType", "nextClicked", "", "onNextListener", "Lkotlin/Function0;", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onResume", "ensurePermissionsAndDoAction", "Companion", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BluetoothInstructionsDialog extends DialogFragment implements DIAware {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BluetoothInstructionsDialog.class, "di", "getDi()Lorg/kodein/di/DI;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BluetoothInstructionsDialog.class, "locationPermissionTracker", "getLocationPermissionTracker()Lcom/blueair/core/util/LocationPermissionTracker;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final Lazy di$delegate;
   private final Lazy locationPermissionTracker$delegate;
   private boolean nextClicked;
   private Function0 onNextListener;
   private final ActivityResultLauncher requestBluetoothPermissionsLauncher;

   // $FF: synthetic method
   public static void $r8$lambda$63Apst2AlSYCHveotnTf8_Bas80(BluetoothInstructionsDialog var0, View var1) {
      onCreateView$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$PxXNP5KZyM0bfmIlRPNn2qd7uZE(BluetoothInstructionsDialog var0, Map var1) {
      requestBluetoothPermissionsLauncher$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$lgtSgnv6DDeinPB9wIHSyiDyDF0(BluetoothInstructionsDialog var0, View var1) {
      onCreateView$lambda$5(var0, var1);
   }

   public BluetoothInstructionsDialog() {
      DIPropertyDelegateProvider var2 = ClosestKt.closestDI((Fragment)this);
      KProperty[] var1 = $$delegatedProperties;
      this.di$delegate = var2.provideDelegate(this, var1[0]);
      DIAware var5 = this;
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationPermissionTracker$delegate = DIAwareKt.Instance(var5, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, LocationPermissionTracker.class)), (Object)null).provideDelegate(this, var1[1]);
      ActivityResultLauncher var4 = this.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.RequestMultiplePermissions()), new BluetoothInstructionsDialog$$ExternalSyntheticLambda2(this));
      Intrinsics.checkNotNullExpressionValue(var4, "registerForActivityResult(...)");
      this.requestBluetoothPermissionsLauncher = var4;
   }

   private final void ensurePermissionsAndDoAction() {
      if (!AddDeviceUtils.INSTANCE.showEnableLocationBluetooth((Fragment)this, this.getLocationPermissionTracker(), this.requestBluetoothPermissionsLauncher)) {
         Function0 var1 = this.onNextListener;
         if (var1 != null) {
            var1.invoke();
         }

         this.dismiss();
      }

   }

   private final LocationPermissionTracker getLocationPermissionTracker() {
      return (LocationPermissionTracker)this.locationPermissionTracker$delegate.getValue();
   }

   private static final void onCreateView$lambda$5(BluetoothInstructionsDialog var0, View var1) {
      var0.dismiss();
   }

   private static final void onCreateView$lambda$6(BluetoothInstructionsDialog var0, View var1) {
      var0.nextClicked = true;
      var0.ensurePermissionsAndDoAction();
   }

   private static final void requestBluetoothPermissionsLauncher$lambda$3(BluetoothInstructionsDialog var0, Map var1) {
      DialogUtils.INSTANCE.hideRequestPermissionHints();
      Iterable var21 = (Iterable)var1.values();
      boolean var4 = var21 instanceof Collection;
      boolean var3 = true;
      boolean var2;
      if (var4 && ((Collection)var21).isEmpty()) {
         var2 = var3;
      } else {
         Iterator var22 = var21.iterator();

         while(true) {
            var2 = var3;
            if (!var22.hasNext()) {
               break;
            }

            if (!(Boolean)var22.next()) {
               var2 = false;
               break;
            }
         }
      }

      if (!BluetoothUtils.INSTANCE.shouldShowBluetoothRequestPermissionDialog((Fragment)var0) && !var2) {
         Intent var6 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
         StringBuilder var7 = new StringBuilder("package:");
         Context var23 = var0.getContext();
         ViewUtils var5 = null;
         String var24;
         if (var23 != null) {
            var24 = var23.getPackageName();
         } else {
            var24 = null;
         }

         var7.append(var24);
         var6.setData(Uri.parse(var7.toString()));

         label237: {
            Throwable var10000;
            label257: {
               try {
                  Result.Companion var25 = Result.Companion;
                  var31 = var0.getContext();
               } catch (Throwable var19) {
                  var10000 = var19;
                  boolean var10001 = false;
                  break label257;
               }

               Unit var26 = var5;
               if (var31 != null) {
                  try {
                     var31.startActivity(var6);
                     var26 = Unit.INSTANCE;
                  } catch (Throwable var18) {
                     var10000 = var18;
                     boolean var32 = false;
                     break label257;
                  }
               }

               label229:
               try {
                  var28 = Result.constructor-impl(var26);
                  break label237;
               } catch (Throwable var17) {
                  var10000 = var17;
                  boolean var33 = false;
                  break label229;
               }
            }

            Throwable var27 = var10000;
            Result.Companion var29 = Result.Companion;
            var28 = Result.constructor-impl(ResultKt.createFailure(var27));
         }

         if (Result.exceptionOrNull-impl(var28) != null) {
            var5 = ViewUtils.INSTANCE;
            FragmentActivity var20 = var0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(var20, "requireActivity(...)");
            var5.showSnackbar((Activity)var20, R.string.bluetooth_permission_12, ViewUtils.MessageType.INFO.INSTANCE);
         }

         Result.box-impl(var28);
      } else {
         var0.ensurePermissionsAndDoAction();
      }
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

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      Dialog var6 = this.getDialog();
      if (var6 != null) {
         this.setStyle(0, R.style.DialogTheme);
         Window var7 = var6.getWindow();
         if (var7 != null) {
            var7.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
         }

         Dialog var8 = this.getDialog();
         if (var8 != null) {
            Window var9 = var8.getWindow();
            if (var9 != null) {
               var9.setWindowAnimations(R.style.dialog_animation_right);
            }
         }
      }

      DialogBluetoothInstructionsBinding var4 = DialogBluetoothInstructionsBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      var4.closeButton.setOnClickListener(new BluetoothInstructionsDialog$$ExternalSyntheticLambda0(this));
      var4.nextButton.setOnClickListener(new BluetoothInstructionsDialog$$ExternalSyntheticLambda1(this));
      LinearLayout var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return (View)var5;
   }

   public void onResume() {
      super.onResume();
      if (this.nextClicked) {
         this.ensurePermissionsAndDoAction();
      }

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

   @Metadata(
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"},
      d2 = {"Lcom/blueair/antifake/dialog/BluetoothInstructionsDialog$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/antifake/dialog/BluetoothInstructionsDialog;", "onNextListener", "Lkotlin/Function0;", "", "antifake_otherRelease"},
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

      public final BluetoothInstructionsDialog newInstance(Function0 var1) {
         Intrinsics.checkNotNullParameter(var1, "onNextListener");
         BluetoothInstructionsDialog var2 = new BluetoothInstructionsDialog();
         var2.onNextListener = var1;
         return var2;
      }
   }
}
