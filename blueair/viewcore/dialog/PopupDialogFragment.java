package com.blueair.viewcore.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.widget.AppCompatTextView;
import com.blueair.viewcore.databinding.PopupDialogBinding;
import com.blueair.viewcore.viewmodel.PopupMessage;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"},
   d2 = {"Lcom/blueair/viewcore/dialog/PopupDialogFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "<init>", "()V", "state", "Lcom/blueair/viewcore/viewmodel/PopupMessage;", "getState", "()Lcom/blueair/viewcore/viewmodel/PopupMessage;", "state$delegate", "Lkotlin/Lazy;", "onCreateDialog", "Landroidx/appcompat/app/AppCompatDialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class PopupDialogFragment extends AppCompatDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String KEY_STATE = "state";
   private static final String TAG = "popup_dialog";
   private final Lazy state$delegate = LazyKt.lazy(new PopupDialogFragment$$ExternalSyntheticLambda0(this));

   // $FF: synthetic method
   public static PopupMessage $r8$lambda$YeTVIET3rUAbQo2fgasOf1gSbW8(PopupDialogFragment var0) {
      return state_delegate$lambda$0(var0);
   }

   private final PopupMessage getState() {
      return (PopupMessage)this.state$delegate.getValue();
   }

   private static final PopupMessage state_delegate$lambda$0(PopupDialogFragment var0) {
      Parcelable var1 = var0.requireArguments().getParcelable("state");
      if (var1 != null) {
         return (PopupMessage)var1;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public AppCompatDialog onCreateDialog(Bundle var1) {
      PopupDialogBinding var2 = PopupDialogBinding.inflate(this.getLayoutInflater());
      Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
      AlertDialog var5 = (new AlertDialog.Builder((Context)this.requireActivity())).setView((View)var2.getRoot()).create();
      Intrinsics.checkNotNullExpressionValue(var5, "create(...)");
      var2.titleTextView.setText(this.getState().getTitleResId());
      Integer var3 = this.getState().getSubtitleResId();
      if (var3 == null) {
         AppCompatTextView var6 = var2.subtitleTextView;
         Intrinsics.checkNotNullExpressionValue(var6, "subtitleTextView");
         ViewExtensionsKt.hide((View)var6);
      } else {
         AppCompatTextView var4 = var2.subtitleTextView;
         Intrinsics.checkNotNullExpressionValue(var4, "subtitleTextView");
         ViewExtensionsKt.show$default((View)var4, false, 1, (Object)null);
         var2.subtitleTextView.setText(var3);
      }

      var2.messageTextView.setText(this.getState().getMessageResId());
      return (AppCompatDialog)var5;
   }

   @Metadata(
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"},
      d2 = {"Lcom/blueair/viewcore/dialog/PopupDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "KEY_STATE", "newInstance", "Lcom/blueair/viewcore/dialog/PopupDialogFragment;", "message", "Lcom/blueair/viewcore/viewmodel/PopupMessage;", "viewcore_otherRelease"},
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

      public final String getTAG() {
         return PopupDialogFragment.TAG;
      }

      public final PopupDialogFragment newInstance(PopupMessage var1) {
         Intrinsics.checkNotNullParameter(var1, "message");
         Bundle var2 = new Bundle();
         var2.putParcelable("state", var1);
         PopupDialogFragment var3 = new PopupDialogFragment();
         var3.setArguments(var2);
         return var3;
      }
   }
}
