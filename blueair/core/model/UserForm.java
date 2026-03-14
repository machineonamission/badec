package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006%"},
   d2 = {"Lcom/blueair/core/model/UserForm;", "", "deviceid", "", "phoneModel", "systemVersion", "appVersion", "phoneTs", "", "messageType", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getDeviceid", "()Ljava/lang/String;", "getPhoneModel", "getSystemVersion", "getAppVersion", "getPhoneTs", "()J", "getMessageType", "getDescription", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class UserForm {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String TYPE_OFFLINE = "offline";
   private final String appVersion;
   private final String description;
   private final String deviceid;
   private final String messageType;
   private final String phoneModel;
   private final long phoneTs;
   private final String systemVersion;

   public UserForm(String var1, String var2, String var3, String var4, long var5, String var7, String var8) {
      Intrinsics.checkNotNullParameter(var1, "deviceid");
      Intrinsics.checkNotNullParameter(var2, "phoneModel");
      Intrinsics.checkNotNullParameter(var3, "systemVersion");
      Intrinsics.checkNotNullParameter(var4, "appVersion");
      Intrinsics.checkNotNullParameter(var7, "messageType");
      Intrinsics.checkNotNullParameter(var8, "description");
      super();
      this.deviceid = var1;
      this.phoneModel = var2;
      this.systemVersion = var3;
      this.appVersion = var4;
      this.phoneTs = var5;
      this.messageType = var7;
      this.description = var8;
   }

   // $FF: synthetic method
   public UserForm(String var1, String var2, String var3, String var4, long var5, String var7, String var8, int var9, DefaultConstructorMarker var10) {
      if ((var9 & 64) != 0) {
         var8 = "";
      }

      this(var1, var2, var3, var4, var5, var7, var8);
   }

   // $FF: synthetic method
   public static UserForm copy$default(UserForm var0, String var1, String var2, String var3, String var4, long var5, String var7, String var8, int var9, Object var10) {
      if ((var9 & 1) != 0) {
         var1 = var0.deviceid;
      }

      if ((var9 & 2) != 0) {
         var2 = var0.phoneModel;
      }

      if ((var9 & 4) != 0) {
         var3 = var0.systemVersion;
      }

      if ((var9 & 8) != 0) {
         var4 = var0.appVersion;
      }

      if ((var9 & 16) != 0) {
         var5 = var0.phoneTs;
      }

      if ((var9 & 32) != 0) {
         var7 = var0.messageType;
      }

      if ((var9 & 64) != 0) {
         var8 = var0.description;
      }

      return var0.copy(var1, var2, var3, var4, var5, var7, var8);
   }

   public final String component1() {
      return this.deviceid;
   }

   public final String component2() {
      return this.phoneModel;
   }

   public final String component3() {
      return this.systemVersion;
   }

   public final String component4() {
      return this.appVersion;
   }

   public final long component5() {
      return this.phoneTs;
   }

   public final String component6() {
      return this.messageType;
   }

   public final String component7() {
      return this.description;
   }

   public final UserForm copy(String var1, String var2, String var3, String var4, long var5, String var7, String var8) {
      Intrinsics.checkNotNullParameter(var1, "deviceid");
      Intrinsics.checkNotNullParameter(var2, "phoneModel");
      Intrinsics.checkNotNullParameter(var3, "systemVersion");
      Intrinsics.checkNotNullParameter(var4, "appVersion");
      Intrinsics.checkNotNullParameter(var7, "messageType");
      Intrinsics.checkNotNullParameter(var8, "description");
      return new UserForm(var1, var2, var3, var4, var5, var7, var8);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof UserForm)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.deviceid, var1.deviceid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.phoneModel, var1.phoneModel)) {
            return false;
         } else if (!Intrinsics.areEqual(this.systemVersion, var1.systemVersion)) {
            return false;
         } else if (!Intrinsics.areEqual(this.appVersion, var1.appVersion)) {
            return false;
         } else if (this.phoneTs != var1.phoneTs) {
            return false;
         } else if (!Intrinsics.areEqual(this.messageType, var1.messageType)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.description, var1.description);
         }
      }
   }

   public final String getAppVersion() {
      return this.appVersion;
   }

   public final String getDescription() {
      return this.description;
   }

   public final String getDeviceid() {
      return this.deviceid;
   }

   public final String getMessageType() {
      return this.messageType;
   }

   public final String getPhoneModel() {
      return this.phoneModel;
   }

   public final long getPhoneTs() {
      return this.phoneTs;
   }

   public final String getSystemVersion() {
      return this.systemVersion;
   }

   public int hashCode() {
      return (((((this.deviceid.hashCode() * 31 + this.phoneModel.hashCode()) * 31 + this.systemVersion.hashCode()) * 31 + this.appVersion.hashCode()) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.phoneTs)) * 31 + this.messageType.hashCode()) * 31 + this.description.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("UserForm(deviceid=");
      var1.append(this.deviceid);
      var1.append(", phoneModel=");
      var1.append(this.phoneModel);
      var1.append(", systemVersion=");
      var1.append(this.systemVersion);
      var1.append(", appVersion=");
      var1.append(this.appVersion);
      var1.append(", phoneTs=");
      var1.append(this.phoneTs);
      var1.append(", messageType=");
      var1.append(this.messageType);
      var1.append(", description=");
      var1.append(this.description);
      var1.append(')');
      return var1.toString();
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"},
      d2 = {"Lcom/blueair/core/model/UserForm$Companion;", "", "<init>", "()V", "TYPE_OFFLINE", "", "core_otherRelease"},
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
