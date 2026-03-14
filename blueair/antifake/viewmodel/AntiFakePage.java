package com.blueair.antifake.viewmodel;

import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0016\u0017\u0018\u0019\u001a\u001bB9\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0082\u0001\u0006\u001c\u001d\u001e\u001f !¨\u0006\""},
   d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakePage;", "", "title", "", "header", "step", "backBtnEnabled", "", "closeBtnEnabled", "screenName", "", "<init>", "(IIIZZLjava/lang/String;)V", "getTitle", "()I", "getHeader", "getStep", "getBackBtnEnabled", "()Z", "getCloseBtnEnabled", "getScreenName", "()Ljava/lang/String;", "CodeVerifying", "CodeVerifyResult", "SelectDevice", "ResetByWifi", "ScanBluetooth", "ResetByBluetooth", "Lcom/blueair/antifake/viewmodel/AntiFakePage$CodeVerifyResult;", "Lcom/blueair/antifake/viewmodel/AntiFakePage$CodeVerifying;", "Lcom/blueair/antifake/viewmodel/AntiFakePage$ResetByBluetooth;", "Lcom/blueair/antifake/viewmodel/AntiFakePage$ResetByWifi;", "Lcom/blueair/antifake/viewmodel/AntiFakePage$ScanBluetooth;", "Lcom/blueair/antifake/viewmodel/AntiFakePage$SelectDevice;", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class AntiFakePage {
   private final boolean backBtnEnabled;
   private final boolean closeBtnEnabled;
   private final int header;
   private final String screenName;
   private final int step;
   private final int title;

   private AntiFakePage(int var1, int var2, int var3, boolean var4, boolean var5, String var6) {
      this.title = var1;
      this.header = var2;
      this.step = var3;
      this.backBtnEnabled = var4;
      this.closeBtnEnabled = var5;
      this.screenName = var6;
   }

   // $FF: synthetic method
   public AntiFakePage(int var1, int var2, int var3, boolean var4, boolean var5, String var6, DefaultConstructorMarker var7) {
      this(var1, var2, var3, var4, var5, var6);
   }

   public final boolean getBackBtnEnabled() {
      return this.backBtnEnabled;
   }

   public final boolean getCloseBtnEnabled() {
      return this.closeBtnEnabled;
   }

   public final int getHeader() {
      return this.header;
   }

   public final String getScreenName() {
      return this.screenName;
   }

   public final int getStep() {
      return this.step;
   }

   public final int getTitle() {
      return this.title;
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"},
      d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakePage$CodeVerifyResult;", "Lcom/blueair/antifake/viewmodel/AntiFakePage;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "antifake_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CodeVerifyResult extends AntiFakePage {
      public static final CodeVerifyResult INSTANCE = new CodeVerifyResult();

      private CodeVerifyResult() {
         super(R.string.anti_counterfeiting, R.string.scan_results, 0, true, true, "antifake_reset_verify_result", (DefaultConstructorMarker)null);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof CodeVerifyResult)) {
            return false;
         } else {
            var1 = var1;
            return true;
         }
      }

      public int hashCode() {
         return -1347577419;
      }

      public String toString() {
         return "CodeVerifyResult";
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"},
      d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakePage$CodeVerifying;", "Lcom/blueair/antifake/viewmodel/AntiFakePage;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "antifake_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CodeVerifying extends AntiFakePage {
      public static final CodeVerifying INSTANCE = new CodeVerifying();

      private CodeVerifying() {
         super(R.string.anti_counterfeiting, R.string.scan_results, 0, true, true, "antifake_reset_verifying", (DefaultConstructorMarker)null);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof CodeVerifying)) {
            return false;
         } else {
            var1 = var1;
            return true;
         }
      }

      public int hashCode() {
         return -761961110;
      }

      public String toString() {
         return "CodeVerifying";
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"},
      d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakePage$ResetByBluetooth;", "Lcom/blueair/antifake/viewmodel/AntiFakePage;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "antifake_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ResetByBluetooth extends AntiFakePage {
      public static final ResetByBluetooth INSTANCE = new ResetByBluetooth();

      private ResetByBluetooth() {
         super(R.string.reset_filter, R.string.reset_via_bluetooth, 2, false, true, "antifake_reset_reset_by_bluetooth", (DefaultConstructorMarker)null);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof ResetByBluetooth)) {
            return false;
         } else {
            var1 = var1;
            return true;
         }
      }

      public int hashCode() {
         return 11800698;
      }

      public String toString() {
         return "ResetByBluetooth";
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakePage$ResetByWifi;", "Lcom/blueair/antifake/viewmodel/AntiFakePage;", "step", "", "<init>", "(I)V", "antifake_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ResetByWifi extends AntiFakePage {
      public ResetByWifi(int var1) {
         super(R.string.reset_filter, R.string.reset_via_internet, var1, false, true, "antifake_reset_reset_by_wifi", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"},
      d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakePage$ScanBluetooth;", "Lcom/blueair/antifake/viewmodel/AntiFakePage;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "antifake_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ScanBluetooth extends AntiFakePage {
      public static final ScanBluetooth INSTANCE = new ScanBluetooth();

      private ScanBluetooth() {
         super(R.string.find_your_device, R.string.connect_via_bluetooth, 1, true, false, "antifake_reset_scan_bluetooth", (DefaultConstructorMarker)null);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof ScanBluetooth)) {
            return false;
         } else {
            var1 = var1;
            return true;
         }
      }

      public int hashCode() {
         return 281583807;
      }

      public String toString() {
         return "ScanBluetooth";
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"},
      d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakePage$SelectDevice;", "Lcom/blueair/antifake/viewmodel/AntiFakePage;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "antifake_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SelectDevice extends AntiFakePage {
      public static final SelectDevice INSTANCE = new SelectDevice();

      private SelectDevice() {
         super(R.string.reset_filter, R.string.reset_filter_select_device_hint, 1, true, true, "antifake_reset_select_device", (DefaultConstructorMarker)null);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof SelectDevice)) {
            return false;
         } else {
            var1 = var1;
            return true;
         }
      }

      public int hashCode() {
         return 439079076;
      }

      public String toString() {
         return "SelectDevice";
      }
   }
}
