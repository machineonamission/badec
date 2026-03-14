package com.blueair.android.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blueair.android.databinding.ActivityUploadLogBinding;
import com.blueair.android.viewmodel.DevSettingsViewModel;
import com.blueair.core.model.IssueType;
import com.blueair.core.model.LogLength;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.dialog.DialogUtils;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0017"},
   d2 = {"Lcom/blueair/android/activity/UploadLogActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/android/databinding/ActivityUploadLogBinding;", "viewModel", "Lcom/blueair/android/viewmodel/DevSettingsViewModel;", "getViewModel", "()Lcom/blueair/android/viewmodel/DevSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "refreshLogFileSize", "onDestroy", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class UploadLogActivity extends BaseActivity {
   public static final int $stable = 8;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ActivityUploadLogBinding binding;
   private final String screenName = "upload_log";
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$_ypVGiPZALhtkg1tACPVgaVISpY/* $FF was: $r8$lambda$-ypVGiPZALhtkg1tACPVgaVISpY*/(UploadLogActivity var0, View var1) {
      onCreate$lambda$16$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$B1JAgdDGDocXSWBen7ApK2Mc6oE(ActivityUploadLogBinding var0, View var1) {
      onCreate$lambda$16$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$D7aNbyGMA88WdIBBzC1h_3W_cq0/* $FF was: $r8$lambda$D7aNbyGMA88WdIBBzC1h_3W-cq0*/(ActivityUploadLogBinding var0, View var1) {
      onCreate$lambda$16$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$VknpmhT8Q2jTFuwsOqxlbvQOEpw(ActivityUploadLogBinding var0, UploadLogActivity var1, View var2) {
      onCreate$lambda$16$lambda$11(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$d7DTx5Ypxqo8HMM7ax77DDgwd4o(ActivityUploadLogBinding var0, UploadLogActivity var1, Integer var2) {
      return onCreate$lambda$16$lambda$12(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$kPciBY0Y0KK4o3tDqp4cybHRxho(ActivityUploadLogBinding var0, UploadLogActivity var1, String var2) {
      return onCreate$lambda$16$lambda$13(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$lKRbTSeTTrO4BGwGLzKWMR135Os(UploadLogActivity var0, View var1) {
      onCreate$lambda$16$lambda$15(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$oEKC2Egz2G1tuplJZzpGJMEgao0(ActivityUploadLogBinding var0, int var1, String var2) {
      return onCreate$lambda$16$lambda$6$lambda$5(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$uXpcKouRB9OUtha_MOJubK5pmlI/* $FF was: $r8$lambda$uXpcKouRB9OUtha-MOJubK5pmlI*/(ActivityUploadLogBinding var0, int var1, String var2) {
      return onCreate$lambda$16$lambda$3$lambda$2(var0, var1, var2);
   }

   public UploadLogActivity() {
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

   private final DevSettingsViewModel getViewModel() {
      return (DevSettingsViewModel)this.viewModel$delegate.getValue();
   }

   private static final void onCreate$lambda$16$lambda$0(UploadLogActivity var0, View var1) {
      var0.finish();
   }

   private static final void onCreate$lambda$16$lambda$11(ActivityUploadLogBinding var0, UploadLogActivity var1, View var2) {
      var0.btnUpload.setEnabled(false);
      String var6 = var0.dropdownIssueType.getText().toString();
      Iterator var4 = ((Iterable)IssueType.getEntries()).iterator();

      Object var5;
      do {
         boolean var3 = var4.hasNext();
         var5 = null;
         if (!var3) {
            var9 = null;
            break;
         }

         var9 = var4.next();
      } while(!Intrinsics.areEqual(((IssueType)var9).getValue(), var6));

      IssueType var11 = (IssueType)var9;
      IssueType var10 = var11;
      if (var11 == null) {
         var10 = IssueType.OTHER;
      }

      var6 = var0.dropdownLength.getText().toString();
      Iterator var7 = ((Iterable)LogLength.getEntries()).iterator();

      do {
         var12 = var5;
         if (!var7.hasNext()) {
            break;
         }

         var12 = var7.next();
      } while(!Intrinsics.areEqual(((LogLength)var12).getValue(), var6));

      LogLength var14 = (LogLength)var12;
      LogLength var13 = var14;
      if (var14 == null) {
         var13 = LogLength.M5;
      }

      String var8 = String.valueOf(var0.descriptionValue.getText());
      var1.getViewModel().uploadLog(var10, var13, var8);
   }

   private static final Unit onCreate$lambda$16$lambda$12(ActivityUploadLogBinding var0, UploadLogActivity var1, Integer var2) {
      if (var2 > 0) {
         TextView var3 = var0.tvProgress;
         Intrinsics.checkNotNullExpressionValue(var3, "tvProgress");
         ViewExtensionsKt.show$default((View)var3, false, 1, (Object)null);
         var0.tvProgress.setTextColor(var1.getColor(R.color.colorPrimaryText));
         TextView var4 = var0.tvProgress;
         StringBuilder var5 = new StringBuilder();
         var5.append(var2);
         var5.append("% uploaded");
         var4.setText((CharSequence)var5.toString());
      }

      if (var2 >= 100) {
         var0.btnUpload.setEnabled(true);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onCreate$lambda$16$lambda$13(ActivityUploadLogBinding var0, UploadLogActivity var1, String var2) {
      Intrinsics.checkNotNull(var2);
      CharSequence var4 = (CharSequence)var2;
      if (var4.length() > 0) {
         TextView var3 = var0.tvProgress;
         Intrinsics.checkNotNullExpressionValue(var3, "tvProgress");
         ViewExtensionsKt.show$default((View)var3, false, 1, (Object)null);
         var0.tvProgress.setTextColor(var1.getColor(R.color.error_red));
         var0.tvProgress.setText(var4);
         var0.btnUpload.setEnabled(true);
      }

      return Unit.INSTANCE;
   }

   private static final void onCreate$lambda$16$lambda$15(UploadLogActivity var0, View var1) {
      var0.getViewModel().clearLogs();
      var0.refreshLogFileSize();
   }

   private static final void onCreate$lambda$16$lambda$3(ActivityUploadLogBinding var0, View var1) {
      DialogUtils var5 = DialogUtils.INSTANCE;
      TextView var2 = var0.dropdownIssueType;
      Intrinsics.checkNotNullExpressionValue(var2, "dropdownIssueType");
      View var3 = (View)var2;
      Iterable var4 = (Iterable)IssueType.getEntries();
      Collection var6 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var4, 10)));
      Iterator var7 = var4.iterator();

      while(var7.hasNext()) {
         var6.add(((IssueType)var7.next()).getValue());
      }

      DialogUtils.showDropDownList$default(var5, var3, (List)var6, 0, 0, 0, 0, false, new UploadLogActivity$$ExternalSyntheticLambda1(var0), 124, (Object)null);
   }

   private static final Unit onCreate$lambda$16$lambda$3$lambda$2(ActivityUploadLogBinding var0, int var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "v");
      var0.dropdownIssueType.setText((CharSequence)var2);
      return Unit.INSTANCE;
   }

   private static final void onCreate$lambda$16$lambda$6(ActivityUploadLogBinding var0, View var1) {
      DialogUtils var5 = DialogUtils.INSTANCE;
      TextView var2 = var0.dropdownLength;
      Intrinsics.checkNotNullExpressionValue(var2, "dropdownLength");
      View var6 = (View)var2;
      Iterable var4 = (Iterable)LogLength.getEntries();
      Collection var3 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var4, 10)));
      Iterator var7 = var4.iterator();

      while(var7.hasNext()) {
         var3.add(((LogLength)var7.next()).getValue());
      }

      DialogUtils.showDropDownList$default(var5, var6, (List)var3, 0, 0, 0, 0, false, new UploadLogActivity$$ExternalSyntheticLambda0(var0), 124, (Object)null);
   }

   private static final Unit onCreate$lambda$16$lambda$6$lambda$5(ActivityUploadLogBinding var0, int var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "v");
      var0.dropdownLength.setText((CharSequence)var2);
      return Unit.INSTANCE;
   }

   private final void refreshLogFileSize() {
      double var1 = (double)(this.getFileStreamPath("debug_log").length() / (long)1024) / (double)1024.0F;
      ActivityUploadLogBinding var4 = this.binding;
      ActivityUploadLogBinding var3 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var3 = null;
      }

      TextView var6 = var3.tvCurrentLogSize;
      String var5 = String.format("%.2f MB", Arrays.copyOf(new Object[]{var1}, 1));
      Intrinsics.checkNotNullExpressionValue(var5, "format(...)");
      var6.setText((CharSequence)var5);
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      ActivityUploadLogBinding var3 = ActivityUploadLogBinding.inflate(this.getLayoutInflater());
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      this.binding = var3;
      Object var2 = null;
      ActivityUploadLogBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      this.setContentView((View)var4.getRoot());
      this.setStatusMode(true);
      var4 = this.binding;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = (ActivityUploadLogBinding)var2;
      }

      var4.btnBack.setOnClickListener(new UploadLogActivity$$ExternalSyntheticLambda2(this));
      var4.dropdownIssueType.setOnClickListener(new UploadLogActivity$$ExternalSyntheticLambda3(var4));
      var4.dropdownLength.setOnClickListener(new UploadLogActivity$$ExternalSyntheticLambda4(var4));
      var4.btnUpload.setOnClickListener(new UploadLogActivity$$ExternalSyntheticLambda5(var4, this));
      LiveData var6 = this.getViewModel().getLiveLogUploadProgress();
      LifecycleOwner var8 = (LifecycleOwner)this;
      var6.observe(var8, new Observer(new UploadLogActivity$$ExternalSyntheticLambda6(var4, this)) {
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
      this.getViewModel().getLiveLogUploadError().observe(var8, new Observer(new UploadLogActivity$$ExternalSyntheticLambda7(var4, this)) {
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
      var4.etMaxLogSize.setText((CharSequence)String.valueOf(this.getViewModel().getMaxLogFileSizeInMB()));
      EditText var7 = var4.etMaxLogSize;
      Intrinsics.checkNotNullExpressionValue(var7, "etMaxLogSize");
      ((TextView)var7).addTextChangedListener(new TextWatcher(this) {
         final UploadLogActivity this$0;

         public {
            this.this$0 = var1;
         }

         public void afterTextChanged(Editable var1) {
            Timber.Forest var4 = Timber.Forest;
            StringBuilder var3 = new StringBuilder("update max log file size: ");
            var3.append(var1);
            var4.d(var3.toString(), new Object[0]);
            DevSettingsViewModel var6 = this.this$0.getViewModel();
            Integer var5 = StringsKt.toIntOrNull(String.valueOf(var1));
            int var2;
            if (var5 != null) {
               var2 = var5;
            } else {
               var2 = 100;
            }

            var6.setMaxLogFileSizeInMB(var2);
         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }
      });
      var4.btnClear.setOnClickListener(new UploadLogActivity$$ExternalSyntheticLambda8(this));
      this.refreshLogFileSize();
   }

   protected void onDestroy() {
      super.onDestroy();
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/android/activity/UploadLogActivity$Companion;", "", "<init>", "()V", "launch", "", "context", "Landroid/content/Context;", "app_otherRelease"},
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

      public final void launch(Context var1) {
         Intrinsics.checkNotNullParameter(var1, "context");
         var1.startActivity(new Intent(var1, UploadLogActivity.class));
      }
   }
}
