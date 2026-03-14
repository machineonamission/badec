package com.blueair.adddevice.fragment.legacy;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.airbnb.lottie.LottieAnimationView;
import com.airboxlab.icp.sdk.BlueAirManager;
import com.blueair.adddevice.R;
import com.blueair.adddevice.databinding.FragmentAddDeviceAutoStepTwoIcpBinding;
import com.blueair.adddevice.dialog.CannotFindIcpDialog;
import com.blueair.adddevice.service.AddDeviceService;
import com.blueair.devicemanager.IcpDevice;
import com.blueair.devicemanager.IcpDeviceConnection;
import com.blueair.devicemanager.IcpDeviceInfo;
import com.blueair.devicemanager.IcpDeviceManager;
import com.google.android.material.button.MaterialButton;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.subjects.BehaviorSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0006H\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010\"\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\b\u0010$\u001a\u00020\u0016H\u0002J\b\u0010%\u001a\u00020\u0016H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006'"},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/IcpPairDeviceFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "reconnectAction", "Lio/reactivex/subjects/BehaviorSubject;", "", "shouldReconnectOnConnect", "Ljava/util/concurrent/atomic/AtomicBoolean;", "blueAirManager", "Lcom/airboxlab/icp/sdk/BlueAirManager;", "getBlueAirManager", "()Lcom/airboxlab/icp/sdk/BlueAirManager;", "blueAirManager$delegate", "Lkotlin/Lazy;", "icpDeviceManager", "Lcom/blueair/devicemanager/IcpDeviceManager;", "binding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceAutoStepTwoIcpBinding;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "showWhiteProgressIndicator", "", "shouldShow", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onCreate", "onResume", "scanAndPair", "pairingFailed", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class IcpPairDeviceFragment extends AddDeviceBaseFragment {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(IcpPairDeviceFragment.class, "blueAirManager", "getBlueAirManager()Lcom/airboxlab/icp/sdk/BlueAirManager;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private FragmentAddDeviceAutoStepTwoIcpBinding binding;
   private final Lazy blueAirManager$delegate;
   private IcpDeviceManager icpDeviceManager;
   private BehaviorSubject reconnectAction;
   private AtomicBoolean shouldReconnectOnConnect;

   // $FF: synthetic method
   public static Unit $r8$lambda$_4c9HT_gIqAF_1Yyl_eM_yVkjg8/* $FF was: $r8$lambda$-4c9HT-gIqAF-1Yyl_eM_yVkjg8*/(IcpPairDeviceFragment var0, IcpDeviceInfo var1) {
      return onResume$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$_VBokCORS_wt5LY6dsVSoZ9ijaU/* $FF was: $r8$lambda$-VBokCORS-wt5LY6dsVSoZ9ijaU*/(IcpPairDeviceFragment var0, IcpDeviceManager.BluetoothClientState var1) {
      return onResume$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$1_Jh6wd3nBzwnvM5IgK99RvXEFY(Function1 var0, Object var1) {
      onResume$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$7UhcnuiYtDL9vjt0YP6uMOEsxHc(Function1 var0, Object var1) {
      scanAndPair$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$FpgTnoVN7CFSL3mH2Uvfxb3gUuM(IcpPairDeviceFragment var0, IcpDeviceConnection var1) {
      return onResume$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$MPhrO9BckUAVuy62YwTgBJ839Ao(IcpPairDeviceFragment var0, View var1) {
      onViewCreated$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$UsxXEpuQ3rEdIV6YJq4D4Vi9aKs(Function1 var0, Object var1) {
      onResume$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$W_8muAum4fIQ_VqyEWM_V2tvITU/* $FF was: $r8$lambda$W_8muAum4fIQ-VqyEWM_V2tvITU*/(Function1 var0, Object var1) {
      onResume$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Yy9S_oA_zVPCMwYJt2HnDqy86Iw(Function1 var0, Object var1) {
      scanAndPair$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$b1_3EUuXZtF7HNjC_RYE4Tjk4_k(Throwable var0) {
      return onResume$lambda$5(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$d_zzQLzLruZaZ2LrT_vm7lDKK2I(IcpPairDeviceFragment var0, Throwable var1) {
      return scanAndPair$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$sDchY0UBMr_fiODz3F_2ldIdfoQ/* $FF was: $r8$lambda$sDchY0UBMr-fiODz3F-2ldIdfoQ*/(IcpPairDeviceFragment var0, IcpDevice var1) {
      return scanAndPair$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$tQe1puCmU1noldW6FlmasqQfMgI(Function1 var0, Object var1) {
      onResume$lambda$8(var0, var1);
   }

   public IcpPairDeviceFragment() {
      BehaviorSubject var1 = BehaviorSubject.create();
      Intrinsics.checkNotNullExpressionValue(var1, "create(...)");
      this.reconnectAction = var1;
      this.shouldReconnectOnConnect = new AtomicBoolean(true);
      DIAware var2 = this;
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.blueAirManager$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, BlueAirManager.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
   }

   private final BlueAirManager getBlueAirManager() {
      return (BlueAirManager)this.blueAirManager$delegate.getValue();
   }

   private static final Unit onResume$lambda$1(IcpPairDeviceFragment var0, IcpDeviceConnection var1) {
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("deviceConnection = ");
      var3.append(var1);
      var4.d(var3.toString(), new Object[0]);
      IcpDeviceManager.IcpDeviceConnectionState var5 = var1.getConnectionState();
      int var2 = IcpPairDeviceFragment.WhenMappings.$EnumSwitchMapping$0[var5.ordinal()];
      if (var2 != 1) {
         if (var2 != 2) {
            if (var2 != 3) {
               var0.pairingFailed();
            } else {
               var0.showWhiteProgressIndicator(false);
               Timber.Forest.i("Pairing failed: Reason Disconnected", new Object[0]);
               var0.pairingFailed();
            }
         } else {
            showWhiteProgressIndicator$default(var0, false, 1, (Object)null);
         }
      } else {
         var0.showWhiteProgressIndicator(false);
         var0.reconnectAction.onNext(true);
      }

      return Unit.INSTANCE;
   }

   private static final void onResume$lambda$2(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final Unit onResume$lambda$3(IcpPairDeviceFragment var0, IcpDeviceInfo var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("deviceInfoObservable: ");
      var3.append(var1);
      var2.d(var3.toString(), new Object[0]);
      var0.shouldReconnectOnConnect.set(false);
      var0.showWhiteProgressIndicator(false);
      AddDeviceService var4 = var0.getAddService();
      Intrinsics.checkNotNull(var1);
      var4.icpPairingCompleted(var1);
      return Unit.INSTANCE;
   }

   private static final void onResume$lambda$4(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final Unit onResume$lambda$5(Throwable var0) {
      return Unit.INSTANCE;
   }

   private static final void onResume$lambda$6(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final Unit onResume$lambda$7(IcpPairDeviceFragment var0, IcpDeviceManager.BluetoothClientState var1) {
      FragmentAddDeviceAutoStepTwoIcpBinding var3 = var0.binding;
      FragmentAddDeviceAutoStepTwoIcpBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      MaterialButton var5 = var4.buttonNext;
      boolean var2;
      if (var1 == IcpDeviceManager.BluetoothClientState.READY) {
         var2 = true;
      } else {
         var2 = false;
      }

      var5.setEnabled(var2);
      return Unit.INSTANCE;
   }

   private static final void onResume$lambda$8(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final void onViewCreated$lambda$0(IcpPairDeviceFragment var0, View var1) {
      Object var2 = null;
      showWhiteProgressIndicator$default(var0, false, 1, (Object)null);
      FragmentAddDeviceAutoStepTwoIcpBinding var3 = var0.binding;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var3 = (FragmentAddDeviceAutoStepTwoIcpBinding)var2;
      }

      var3.buttonNext.setEnabled(false);
      var0.scanAndPair();
   }

   private final void pairingFailed() {
      Timber.Forest.w("Pairing failed...", new Object[0]);
      this.showWhiteProgressIndicator(false);
      FragmentAddDeviceAutoStepTwoIcpBinding var2 = this.binding;
      FragmentAddDeviceAutoStepTwoIcpBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.buttonNext.setEnabled(true);
   }

   private final void scanAndPair() {
      IcpDeviceManager var2 = this.icpDeviceManager;
      IcpDeviceManager var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("icpDeviceManager");
         var1 = null;
      }

      Disposable var3 = var1.pair().subscribeOn(AndroidSchedulers.mainThread()).subscribe(new IcpPairDeviceFragment$$ExternalSyntheticLambda4(new IcpPairDeviceFragment$$ExternalSyntheticLambda0(this)), new IcpPairDeviceFragment$$ExternalSyntheticLambda6(new IcpPairDeviceFragment$$ExternalSyntheticLambda5(this)));
      Intrinsics.checkNotNullExpressionValue(var3, "subscribe(...)");
      DisposableKt.addTo(var3, this.getAsyncSubs());
   }

   private static final void scanAndPair$lambda$10(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final Unit scanAndPair$lambda$12(IcpPairDeviceFragment var0, Throwable var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("Pairing failed, Reason: Scan error: ");
      var3.append(var1);
      var2.e(var3.toString(), new Object[0]);
      var0.pairingFailed();
      FragmentTransaction var5 = var0.getParentFragmentManager().beginTransaction();
      Intrinsics.checkNotNullExpressionValue(var5, "beginTransaction(...)");
      Fragment var4 = var0.getParentFragmentManager().findFragmentByTag("dialog");
      if (var4 != null) {
         var5.remove(var4);
      }

      var5.addToBackStack((String)null);
      CannotFindIcpDialog.Companion.newInstance().show(var5, "dialog");
      return Unit.INSTANCE;
   }

   private static final void scanAndPair$lambda$13(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final Unit scanAndPair$lambda$9(IcpPairDeviceFragment var0, IcpDevice var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("Pairing initiated with icp device: ");
      var3.append(var1);
      var2.d(var3.toString(), new Object[0]);
      if (var1 == null) {
         Timber.Forest.i("Pairing failed: Reason: No icp device found nearby", new Object[0]);
         var0.pairingFailed();
      } else {
         var2 = Timber.Forest;
         StringBuilder var4 = new StringBuilder("Device Paired: ");
         var4.append(var1.getName());
         var4.append("; ");
         var4.append(var1.getMacAddress());
         var4.append(", ");
         var4.append(var1.getUuid());
         var2.d(var4.toString(), new Object[0]);
      }

      return Unit.INSTANCE;
   }

   private final void showWhiteProgressIndicator(boolean var1) {
      FragmentAddDeviceAutoStepTwoIcpBinding var4 = this.binding;
      FragmentAddDeviceAutoStepTwoIcpBinding var3 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var3 = null;
      }

      LottieAnimationView var5 = var3.connectingProgress;
      byte var2;
      if (var1) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      var5.setVisibility(var2);
   }

   // $FF: synthetic method
   static void showWhiteProgressIndicator$default(IcpPairDeviceFragment var0, boolean var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = true;
      }

      var0.showWhiteProgressIndicator(var1);
   }

   public ConstraintLayout getRootView() {
      FragmentAddDeviceAutoStepTwoIcpBinding var2 = this.binding;
      FragmentAddDeviceAutoStepTwoIcpBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      ConstraintLayout var3 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var3, "getRoot(...)");
      return var3;
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.icpDeviceManager = new IcpDeviceManager(this.getBlueAirManager());
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentAddDeviceAutoStepTwoIcpBinding var6 = FragmentAddDeviceAutoStepTwoIcpBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      FragmentAddDeviceAutoStepTwoIcpBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      ConstraintLayout var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return (View)var5;
   }

   public void onResume() {
      super.onResume();
      IcpDeviceManager var3 = this.icpDeviceManager;
      Object var2 = null;
      IcpDeviceManager var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("icpDeviceManager");
         var1 = null;
      }

      Disposable var4 = var1.getConnectionStateObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(new IcpPairDeviceFragment$$ExternalSyntheticLambda9(new IcpPairDeviceFragment$$ExternalSyntheticLambda8(this)));
      var3 = this.icpDeviceManager;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("icpDeviceManager");
         var1 = null;
      }

      Disposable var9 = var1.getDeviceInfoObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(new IcpPairDeviceFragment$$ExternalSyntheticLambda11(new IcpPairDeviceFragment$$ExternalSyntheticLambda10(this)), new IcpPairDeviceFragment$$ExternalSyntheticLambda1(new IcpPairDeviceFragment$$ExternalSyntheticLambda12()));
      var1 = this.icpDeviceManager;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("icpDeviceManager");
         var1 = (IcpDeviceManager)var2;
      }

      Disposable var7 = var1.getBleClientStateObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(new IcpPairDeviceFragment$$ExternalSyntheticLambda3(new IcpPairDeviceFragment$$ExternalSyntheticLambda2(this)));
      this.getAsyncSubs().addAll(new Disposable[]{var4, var9, var7});
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      FragmentAddDeviceAutoStepTwoIcpBinding var3 = this.binding;
      Object var8 = null;
      FragmentAddDeviceAutoStepTwoIcpBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.imageAuto.setBackgroundResource(R.drawable.device_icp_knob);
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      Drawable var6 = var4.imageAuto.getBackground();
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
      ((AnimationDrawable)var6).start();
      FragmentAddDeviceAutoStepTwoIcpBinding var7 = this.binding;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = (FragmentAddDeviceAutoStepTwoIcpBinding)var8;
      }

      var7.buttonNext.setOnClickListener(new IcpPairDeviceFragment$$ExternalSyntheticLambda7(this));
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/IcpPairDeviceFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/IcpPairDeviceFragment;", "deviceModelType", "", "adddevice_otherRelease"},
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

      public final IcpPairDeviceFragment newInstance(int var1) {
         IcpPairDeviceFragment var3 = new IcpPairDeviceFragment();
         Bundle var2 = new Bundle();
         var2.putInt("deviceModelType", var1);
         var3.setArguments(var2);
         return var3;
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
         int[] var0 = new int[IcpDeviceManager.IcpDeviceConnectionState.values().length];

         try {
            var0[IcpDeviceManager.IcpDeviceConnectionState.CONNECTED.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[IcpDeviceManager.IcpDeviceConnectionState.CONNECTING.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[IcpDeviceManager.IcpDeviceConnectionState.DISCONNECTED.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
