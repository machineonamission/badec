package com.blueair.viewcore.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.HasSKU;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0018"},
   d2 = {"Lcom/blueair/viewcore/activity/LoginPendingAction;", "", "action", "", "data", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getData", "toIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LoginPendingAction {
   private static final String ALEXA_LINKING = "ALEXA_LINKING";
   private static final String ANTI_FAKE_SCAN = "ANTI_FAKE_SCAN";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final LoginPendingAction EMPTY = new LoginPendingAction("", (String)null, 2, (DefaultConstructorMarker)null);
   private static final String GOOGLE_LINKING = "GOOGLE_LINKING";
   private final String action;
   private final String data;

   public LoginPendingAction(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "action");
      super();
      this.action = var1;
      this.data = var2;
   }

   // $FF: synthetic method
   public LoginPendingAction(String var1, String var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      this(var1, var2);
   }

   // $FF: synthetic method
   public static LoginPendingAction copy$default(LoginPendingAction var0, String var1, String var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.action;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.data;
      }

      return var0.copy(var1, var2);
   }

   public final String component1() {
      return this.action;
   }

   public final String component2() {
      return this.data;
   }

   public final LoginPendingAction copy(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "action");
      return new LoginPendingAction(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof LoginPendingAction)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.action, var1.action)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.data, var1.data);
         }
      }
   }

   public final String getAction() {
      return this.action;
   }

   public final String getData() {
      return this.data;
   }

   public int hashCode() {
      int var2 = this.action.hashCode();
      String var3 = this.data;
      int var1;
      if (var3 == null) {
         var1 = 0;
      } else {
         var1 = var3.hashCode();
      }

      return var2 * 31 + var1;
   }

   public final Intent toIntent(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      String var4 = this.action;
      int var2 = var4.hashCode();
      Object var3 = null;
      if (var2 != -1921754998) {
         if (var2 != 677013890) {
            if (var2 == 1512988460 && var4.equals("ALEXA_LINKING")) {
               var4 = this.data;
               Uri var5 = (Uri)var3;
               if (var4 != null) {
                  var5 = Uri.parse(var4);
               }

               return new Intent("android.intent.action.VIEW", var5);
            }
         } else if (var4.equals("GOOGLE_LINKING")) {
            return new Intent("blueair.action.appflip");
         }
      } else if (var4.equals("ANTI_FAKE_SCAN")) {
         return Actions.openAntiFakeScanIntent$default(Actions.INSTANCE, var1, (HasSKU)null, (DeviceFilterType)null, 6, (Object)null);
      }

      return null;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("LoginPendingAction(action=");
      var1.append(this.action);
      var1.append(", data=");
      var1.append(this.data);
      var1.append(')');
      return var1.toString();
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"},
      d2 = {"Lcom/blueair/viewcore/activity/LoginPendingAction$Companion;", "", "<init>", "()V", "EMPTY", "Lcom/blueair/viewcore/activity/LoginPendingAction;", "getEMPTY", "()Lcom/blueair/viewcore/activity/LoginPendingAction;", "ALEXA_LINKING", "", "GOOGLE_LINKING", "ANTI_FAKE_SCAN", "alexaLinking", "uri", "Landroid/net/Uri;", "googleLinking", "antiFakeScan", "viewcore_otherRelease"},
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

      public final LoginPendingAction alexaLinking(Uri var1) {
         Intrinsics.checkNotNullParameter(var1, "uri");
         return new LoginPendingAction("ALEXA_LINKING", var1.toString());
      }

      public final LoginPendingAction antiFakeScan() {
         return new LoginPendingAction("ANTI_FAKE_SCAN", (String)null, 2, (DefaultConstructorMarker)null);
      }

      public final LoginPendingAction getEMPTY() {
         return LoginPendingAction.EMPTY;
      }

      public final LoginPendingAction googleLinking() {
         return new LoginPendingAction("GOOGLE_LINKING", (String)null, 2, (DefaultConstructorMarker)null);
      }
   }
}
