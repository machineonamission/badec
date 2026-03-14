package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.blueair.adddevice.databinding.FragmentMigrationOtaBinding;
import com.blueair.adddevice.service.AddDeviceService;
import com.blueair.viewcore.ViewUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceMigrationOtaFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Lcom/blueair/adddevice/databinding/FragmentMigrationOtaBinding;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onPause", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceMigrationOtaFragment extends AddDeviceBaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private FragmentMigrationOtaBinding binding;

   public ConstraintLayout getRootView() {
      FragmentMigrationOtaBinding var2 = this.binding;
      FragmentMigrationOtaBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      ConstraintLayout var3 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var3, "getRoot(...)");
      return var3;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentMigrationOtaBinding var4 = FragmentMigrationOtaBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.binding = var4;
      Context var5 = this.getContext();
      Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
      ActionBar var6 = ((AppCompatActivity)var5).getSupportActionBar();
      if (var6 != null) {
         var6.setDisplayHomeAsUpEnabled(false);
      }

      FragmentMigrationOtaBinding var9 = this.binding;
      FragmentMigrationOtaBinding var7 = var9;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      ConstraintLayout var8 = var7.getRoot();
      Intrinsics.checkNotNullExpressionValue(var8, "getRoot(...)");
      return (View)var8;
   }

   public void onPause() {
      super.onPause();
      this.hideLoading();
   }

   public void onResume() {
      super.onResume();
      AddDeviceBaseFragment.showLoading$default(this, false, 1, (Object)null);
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final AddDeviceMigrationOtaFragment this$0;

         // $FF: synthetic method
         public static Unit $r8$lambda$HOcBth90_bn_bQVW6txq5ISWZL8/* $FF was: $r8$lambda$HOcBth90-bn-bQVW6txq5ISWZL8*/(AddDeviceMigrationOtaFragment var0, String var1) {
            return invokeSuspend$lambda$1(var0, var1);
         }

         {
            this.this$0 = var1;
         }

         private static final Unit invokeSuspend$lambda$1(AddDeviceMigrationOtaFragment var0, String var1) {
            View var2 = var0.getView();
            if (var0.isAdded() && var2 != null) {
               FragmentActivity var3 = var0.getActivity();
               if (var3 != null) {
                  ViewUtils.INSTANCE.showInfo((Activity)var3, var1);
               }
            }

            return Unit.INSTANCE;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, var2));
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
               var1 = new AddDeviceMigrationOtaFragment$onResume$1$$ExternalSyntheticLambda0(this.this$0);
               Continuation var5 = (Continuation)this;
               this.label = 1;
               if (var4.migrationOtaCheck((Function1)var1, (Continuation)var5) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceMigrationOtaFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceMigrationOtaFragment;", "deviceModelType", "", "adddevice_otherRelease"},
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

      public final AddDeviceMigrationOtaFragment newInstance(int var1) {
         AddDeviceMigrationOtaFragment var3 = new AddDeviceMigrationOtaFragment();
         Bundle var2 = new Bundle();
         var2.putInt("deviceModelType", var1);
         var3.setArguments(var2);
         return var3;
      }
   }
}
