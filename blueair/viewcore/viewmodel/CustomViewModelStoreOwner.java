package com.blueair.viewcore.viewmodel;

import android.app.Application;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.HasDefaultViewModelProviderFactory._CC;
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"},
   d2 = {"Lcom/blueair/viewcore/viewmodel/CustomViewModelStoreOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/HasDefaultViewModelProviderFactory;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "defaultViewModelProviderFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getDefaultViewModelProviderFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "Companion", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class CustomViewModelStoreOwner implements ViewModelStoreOwner, HasDefaultViewModelProviderFactory {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final Lazy DEVICE_DETAILS$delegate = LazyKt.lazy(new CustomViewModelStoreOwner$$ExternalSyntheticLambda0());
   public static Application application;
   private final ViewModelProvider.Factory defaultViewModelProviderFactory;
   private final ViewModelStore viewModelStore;

   // $FF: synthetic method
   public static CustomViewModelStoreOwner $r8$lambda$8tzr3JJx2cdu3MBBxoFiB4UsAWk() {
      return DEVICE_DETAILS_delegate$lambda$0();
   }

   public CustomViewModelStoreOwner(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super();
      this.viewModelStore = new ViewModelStore();
      this.defaultViewModelProviderFactory = (ViewModelProvider.Factory)AndroidViewModelFactory.Companion.getInstance(var1);
   }

   private static final CustomViewModelStoreOwner DEVICE_DETAILS_delegate$lambda$0() {
      return new CustomViewModelStoreOwner(Companion.getApplication());
   }

   public CreationExtras getDefaultViewModelCreationExtras() {
      return _CC.$default$getDefaultViewModelCreationExtras(this);
   }

   public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
      return this.defaultViewModelProviderFactory;
   }

   public ViewModelStore getViewModelStore() {
      return this.viewModelStore;
   }

   @Metadata(
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0010"},
      d2 = {"Lcom/blueair/viewcore/viewmodel/CustomViewModelStoreOwner$Companion;", "", "<init>", "()V", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "setApplication", "(Landroid/app/Application;)V", "DEVICE_DETAILS", "Lcom/blueair/viewcore/viewmodel/CustomViewModelStoreOwner;", "getDEVICE_DETAILS", "()Lcom/blueair/viewcore/viewmodel/CustomViewModelStoreOwner;", "DEVICE_DETAILS$delegate", "Lkotlin/Lazy;", "viewcore_otherRelease"},
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

      public final Application getApplication() {
         Application var1 = CustomViewModelStoreOwner.application;
         if (var1 != null) {
            return var1;
         } else {
            Intrinsics.throwUninitializedPropertyAccessException("application");
            return null;
         }
      }

      public final CustomViewModelStoreOwner getDEVICE_DETAILS() {
         return (CustomViewModelStoreOwner)CustomViewModelStoreOwner.DEVICE_DETAILS$delegate.getValue();
      }

      public final void setApplication(Application var1) {
         Intrinsics.checkNotNullParameter(var1, "<set-?>");
         CustomViewModelStoreOwner.application = var1;
      }
   }
}
