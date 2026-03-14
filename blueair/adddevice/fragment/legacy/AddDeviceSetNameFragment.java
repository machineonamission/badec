package com.blueair.adddevice.fragment.legacy;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceSetNameBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceSetNameClassicBinding;
import com.blueair.adddevice.service.AddDeviceService;
import com.blueair.core.util.KeyboardManager;
import com.blueair.core.util.KeyboardStatus;
import com.blueair.viewcore.R;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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

@Metadata(
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceSetNameFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Landroidx/viewbinding/ViewBinding;", "mBtnNext", "Landroid/view/View;", "textAddDeviceSubtitle", "Landroid/widget/TextView;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "chooseName", "", "deviceName", "", "onResume", "hideSubtitle", "shouldHide", "", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceSetNameFragment extends AddDeviceBaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ViewBinding binding;
   private View mBtnNext;
   private TextView textAddDeviceSubtitle;

   // $FF: synthetic method
   public static Unit $r8$lambda$30O7PkL5VndBpyHjfbrmvfdE7GE(AddDeviceSetNameFragment var0, KeyboardStatus var1) {
      return onResume$lambda$2$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$cSdp5HEjBGB0Jcz2vCG94I2RZX8(EditText var0, AddDeviceSetNameFragment var1, View var2) {
      onCreateView$lambda$0(var0, var1, var2);
   }

   private final void chooseName(String var1) {
      if (!TextUtils.isEmpty((CharSequence)var1)) {
         AddDeviceBaseFragment.showLoading$default(this, false, 1, (Object)null);
         View var3 = this.mBtnNext;
         View var2 = var3;
         if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnNext");
            var2 = null;
         }

         var2.setVisibility(4);
         BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
            final String $deviceName;
            int label;
            final AddDeviceSetNameFragment this$0;

            {
               this.this$0 = var1;
               this.$deviceName = var2;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$deviceName, var2));
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
                  AddDeviceService var4 = this.this$0.getAddService();
                  String var5 = this.$deviceName;
                  Continuation var6 = (Continuation)this;
                  this.label = 1;
                  if (var4.chooseDeviceName(var5, var6) == var3) {
                     return var3;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 3, (Object)null);
      }

   }

   private final void hideSubtitle(boolean var1) {
      TextView var2 = this.textAddDeviceSubtitle;
      if (var2 != null) {
         ViewExtensionsKt.show((View)var2, var1 ^ true);
      }

   }

   private static final void onCreateView$lambda$0(EditText var0, AddDeviceSetNameFragment var1, View var2) {
      String var3 = var0.getText().toString();
      if (!StringsKt.isBlank((CharSequence)var3)) {
         var1.chooseName(var3);
      } else {
         var0.setError((CharSequence)var1.getResources().getString(R.string.device_name_error));
      }
   }

   private static final Unit onResume$lambda$2$lambda$1(AddDeviceSetNameFragment var0, KeyboardStatus var1) {
      boolean var2;
      if (var1 == KeyboardStatus.OPEN) {
         var2 = true;
      } else {
         var2 = false;
      }

      var0.hideSubtitle(var2);
      return Unit.INSTANCE;
   }

   public ConstraintLayout getRootView() {
      ViewBinding var2 = this.binding;
      ViewBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      View var3 = var1.getRoot();
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
      return (ConstraintLayout)var3;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      ViewBinding var6;
      if (this.getDeviceModelType() == 3) {
         FragmentAddDeviceSetNameClassicBinding var5 = FragmentAddDeviceSetNameClassicBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNull(var5);
         var6 = var5;
      } else {
         FragmentAddDeviceSetNameBinding var7 = FragmentAddDeviceSetNameBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNull(var7);
         var6 = var7;
      }

      this.binding = var6;
      Object var16 = null;
      ViewBinding var12 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var12 = null;
      }

      EditText var4 = (EditText)var12.getRoot().findViewById(com.blueair.adddevice.R.id.editTextDeviceName);
      var12 = this.binding;
      var6 = var12;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      this.textAddDeviceSubtitle = (TextView)var6.getRoot().findViewById(com.blueair.adddevice.R.id.textAddDeviceSubtitle);
      var12 = this.binding;
      var6 = var12;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      View var15 = var6.getRoot().findViewById(com.blueair.adddevice.R.id.buttonNext);
      Intrinsics.checkNotNullExpressionValue(var15, "findViewById(...)");
      this.mBtnNext = var15;
      View var10 = var15;
      if (var15 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("mBtnNext");
         var10 = null;
      }

      var10.setOnClickListener(new AddDeviceSetNameFragment$$ExternalSyntheticLambda1(var4, this));
      ViewBinding var11 = this.binding;
      if (var11 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var11 = (ViewBinding)var16;
      }

      return var11.getRoot();
   }

   public void onResume() {
      super.onResume();
      FragmentActivity var1 = this.getActivity();
      if (var1 != null) {
         KeyboardManager var3 = new KeyboardManager(var1);
         CompositeDisposable var2 = this.getAsyncSubs();
         Observable var5 = var3.status().subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
         Intrinsics.checkNotNullExpressionValue(var5, "observeOn(...)");
         var2.add(RxExtensionsKt.subscribeAndLogE(var5, new AddDeviceSetNameFragment$$ExternalSyntheticLambda0(this)));
         if (this.getDeviceModelType() == 3) {
            ActionBar var4 = ((AppCompatActivity)var1).getSupportActionBar();
            if (var4 != null) {
               var4.setTitle((CharSequence)this.getString(R.string.complete));
            }
         }
      }

   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceSetNameFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceSetNameFragment;", "deviceModelType", "", "adddevice_otherRelease"},
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

      public final AddDeviceSetNameFragment newInstance(int var1) {
         AddDeviceSetNameFragment var2 = new AddDeviceSetNameFragment();
         Bundle var3 = new Bundle();
         var3.putInt("deviceModelType", var1);
         var2.setArguments(var3);
         return var2;
      }
   }
}
