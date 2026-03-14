package com.blueair.sdk;

import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.messaging.FirebaseMessaging;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0004\u0012\u00020\u00050\nH\u0002J \u0010\f\u001a\u00020\u00052\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0004\u0012\u00020\u00050\nJ \u0010\r\u001a\u00020\u00052\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0004\u0012\u00020\u00050\n¨\u0006\u000e"},
   d2 = {"Lcom/blueair/sdk/FirebaseSdk;", "", "<init>", "()V", "handleTask", "", "task", "Lcom/google/android/gms/tasks/Task;", "", "onComplete", "Lkotlin/Function1;", "Lkotlin/Result;", "getMessagingToken", "getInstallationsId", "sdk_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FirebaseSdk {
   public static final FirebaseSdk INSTANCE = new FirebaseSdk();

   // $FF: synthetic method
   public static void $r8$lambda$WRH_0HymZDKK2WMn_BXNP9mKVjA/* $FF was: $r8$lambda$WRH-0HymZDKK2WMn_BXNP9mKVjA*/(Function1 var0, Task var1) {
      getMessagingToken$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Zn6YsyJJF_qrAjmomCYJrqDMcYo(Function1 var0, Task var1) {
      getInstallationsId$lambda$1(var0, var1);
   }

   private FirebaseSdk() {
   }

   private static final void getInstallationsId$lambda$1(Function1 var0, Task var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      INSTANCE.handleTask(var1, var0);
   }

   private static final void getMessagingToken$lambda$0(Function1 var0, Task var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      INSTANCE.handleTask(var1, var0);
   }

   private final void handleTask(Task var1, Function1 var2) {
      if (var1.isSuccessful()) {
         Result.Companion var6 = Result.Companion;
         var2.invoke(Result.box-impl(Result.constructor-impl(var1.getResult())));
      } else {
         Result.Companion var3 = Result.Companion;
         Exception var5 = var1.getException();
         Exception var4 = var5;
         if (var5 == null) {
            var4 = new Exception("unknown");
         }

         var2.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure((Throwable)var4))));
      }
   }

   public final void getInstallationsId(Function1 var1) {
      Intrinsics.checkNotNullParameter(var1, "onComplete");
      FirebaseInstallations.getInstance().getId().addOnCompleteListener(new FirebaseSdk$$ExternalSyntheticLambda1(var1));
   }

   public final void getMessagingToken(Function1 var1) {
      Intrinsics.checkNotNullParameter(var1, "onComplete");
      FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new FirebaseSdk$$ExternalSyntheticLambda0(var1));
   }
}
