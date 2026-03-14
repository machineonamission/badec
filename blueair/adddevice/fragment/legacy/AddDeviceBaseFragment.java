package com.blueair.adddevice.fragment.legacy;

import android.content.Context;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.blueair.adddevice.service.AddDeviceService;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.R;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.fragment.ProgressFragment$_CC;
import com.blueair.viewcore.view.ProgressBlockerView;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.android.DIPropertyDelegateProvider;
import org.kodein.di.android.x.ClosestKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00018B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020-H\u0016J\u0006\u00101\u001a\u00020-J\u0010\u00102\u001a\u00020-2\b\b\u0002\u00103\u001a\u00020\"R\u001b\u0010\u0007\u001a\u00020\b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0012\u00104\u001a\u000205X\u0096\u0005¢\u0006\u0006\u001a\u0004\b6\u00107¨\u00069"},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "Landroidx/fragment/app/Fragment;", "Lorg/kodein/di/DIAware;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "addService", "Lcom/blueair/adddevice/service/AddDeviceService;", "getAddService", "()Lcom/blueair/adddevice/service/AddDeviceService;", "addService$delegate", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "getDeviceManager", "()Lcom/blueair/devicemanager/DeviceManager;", "deviceManager$delegate", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "asyncSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getAsyncSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "isServiceConnected", "", "()Z", "setServiceConnected", "(Z)V", "deviceModelType", "", "getDeviceModelType", "()I", "setDeviceModelType", "(I)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "hideLoading", "showLoading", "shouldShowLoading", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class AddDeviceBaseFragment extends Fragment implements DIAware, ProgressFragment, CoroutineScope {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceBaseFragment.class, "di", "getDi()Lorg/kodein/di/DI;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceBaseFragment.class, "addService", "getAddService()Lcom/blueair/adddevice/service/AddDeviceService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceBaseFragment.class, "deviceManager", "getDeviceManager()Lcom/blueair/devicemanager/DeviceManager;", 0)))};
   public static final String ARG_DEVICE_MODEL_TYPE = "deviceModelType";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final CoroutineScope $$delegate_0 = CoroutineScopeKt.MainScope();
   private final Lazy addService$delegate;
   private final CompositeDisposable asyncSubs;
   private final Lazy deviceManager$delegate;
   private int deviceModelType;
   private final Lazy di$delegate;
   private boolean isServiceConnected;
   private ProgressBlockerView progressBlockerView;

   public AddDeviceBaseFragment() {
      DIPropertyDelegateProvider var2 = ClosestKt.closestDI(this);
      KProperty[] var1 = $$delegatedProperties;
      this.di$delegate = var2.provideDelegate(this, var1[0]);
      DIAware var4 = this;
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.addService$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, AddDeviceService.class)), (Object)null).provideDelegate(this, var1[1]);
      var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.deviceManager$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, DeviceManager.class)), (Object)null).provideDelegate(this, var1[2]);
      this.asyncSubs = new CompositeDisposable();
   }

   // $FF: synthetic method
   public static void showLoading$default(AddDeviceBaseFragment var0, boolean var1, int var2, Object var3) {
      if (var3 == null) {
         if ((var2 & 1) != 0) {
            var1 = true;
         }

         var0.showLoading(var1);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoading");
      }
   }

   public void clearProgressFragment() {
      ProgressFragment$_CC.$default$clearProgressFragment(this);
   }

   protected final AddDeviceService getAddService() {
      return (AddDeviceService)this.addService$delegate.getValue();
   }

   protected final CompositeDisposable getAsyncSubs() {
      return this.asyncSubs;
   }

   public CoroutineContext getCoroutineContext() {
      return this.$$delegate_0.getCoroutineContext();
   }

   protected final DeviceManager getDeviceManager() {
      return (DeviceManager)this.deviceManager$delegate.getValue();
   }

   protected final int getDeviceModelType() {
      return this.deviceModelType;
   }

   public DI getDi() {
      return (DI)this.di$delegate.getValue();
   }

   public DIContext getDiContext() {
      return org.kodein.di.DIAware.DefaultImpls.getDiContext(this);
   }

   public DITrigger getDiTrigger() {
      return org.kodein.di.DIAware.DefaultImpls.getDiTrigger(this);
   }

   public ProgressBlockerView getProgressBlockerView() {
      return this.progressBlockerView;
   }

   public final void hideLoading() {
      this.showLoading(false);
   }

   public void hideProgress(Context var1) {
      ProgressFragment$_CC.$default$hideProgress(this, var1);
   }

   protected final boolean isServiceConnected() {
      return this.isServiceConnected;
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      var1 = this.getArguments();
      if (var1 != null) {
         this.deviceModelType = var1.getInt("deviceModelType");
      }

   }

   public void onPause() {
      this.asyncSubs.clear();
      super.onPause();
   }

   protected final void setDeviceModelType(int var1) {
      this.deviceModelType = var1;
   }

   public void setProgressBlockerView(ProgressBlockerView var1) {
      this.progressBlockerView = var1;
   }

   protected final void setServiceConnected(boolean var1) {
      this.isServiceConnected = var1;
   }

   public final void showLoading(boolean var1) {
      this.showProgress(this.getContext(), var1, ContextCompat.getColor(this.requireContext(), R.color.white));
      ProgressBlockerView var2 = this.getProgressBlockerView();
      if (var2 != null) {
         var2.setAnimationRawRes(R.raw.loading_animation_white);
      }

   }

   public void showProgress(Context var1, boolean var2, Integer var3) {
      ProgressFragment$_CC.$default$showProgress(this, var1, var2, var3);
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment$Companion;", "", "<init>", "()V", "ARG_DEVICE_MODEL_TYPE", "", "adddevice_otherRelease"},
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
   }
}
