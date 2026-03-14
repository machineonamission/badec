package com.blueair.auth;

import com.blueair.core.BuildEnvironment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001f"},
   d2 = {"Lcom/blueair/auth/BlueCloudDomain;", "", "host", "", "clientId", "clientSecret", "mqttBroker", "regionCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHost", "()Ljava/lang/String;", "getClientId", "getClientSecret", "getMqttBroker", "getRegionCode", "regionCodeShort", "tag", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BlueCloudDomain {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final BlueCloudDomain INVALID = new BlueCloudDomain("", "", "", "", "");
   public static final String PROVISION_CHINA = "cn-north-1";
   public static final String PROVISION_EUROPE = "eu-west-1";
   public static final String PROVISION_USA = "us-east-2";
   private final String clientId;
   private final String clientSecret;
   private final String host;
   private final String mqttBroker;
   private final String regionCode;

   public BlueCloudDomain(String var1, String var2, String var3, String var4, String var5) {
      Intrinsics.checkNotNullParameter(var1, "host");
      Intrinsics.checkNotNullParameter(var2, "clientId");
      Intrinsics.checkNotNullParameter(var3, "clientSecret");
      Intrinsics.checkNotNullParameter(var4, "mqttBroker");
      Intrinsics.checkNotNullParameter(var5, "regionCode");
      super();
      this.host = var1;
      this.clientId = var2;
      this.clientSecret = var3;
      this.mqttBroker = var4;
      this.regionCode = var5;
   }

   // $FF: synthetic method
   public static BlueCloudDomain copy$default(BlueCloudDomain var0, String var1, String var2, String var3, String var4, String var5, int var6, Object var7) {
      if ((var6 & 1) != 0) {
         var1 = var0.host;
      }

      if ((var6 & 2) != 0) {
         var2 = var0.clientId;
      }

      if ((var6 & 4) != 0) {
         var3 = var0.clientSecret;
      }

      if ((var6 & 8) != 0) {
         var4 = var0.mqttBroker;
      }

      if ((var6 & 16) != 0) {
         var5 = var0.regionCode;
      }

      return var0.copy(var1, var2, var3, var4, var5);
   }

   public final String component1() {
      return this.host;
   }

   public final String component2() {
      return this.clientId;
   }

   public final String component3() {
      return this.clientSecret;
   }

   public final String component4() {
      return this.mqttBroker;
   }

   public final String component5() {
      return this.regionCode;
   }

   public final BlueCloudDomain copy(String var1, String var2, String var3, String var4, String var5) {
      Intrinsics.checkNotNullParameter(var1, "host");
      Intrinsics.checkNotNullParameter(var2, "clientId");
      Intrinsics.checkNotNullParameter(var3, "clientSecret");
      Intrinsics.checkNotNullParameter(var4, "mqttBroker");
      Intrinsics.checkNotNullParameter(var5, "regionCode");
      return new BlueCloudDomain(var1, var2, var3, var4, var5);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof BlueCloudDomain)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.host, var1.host)) {
            return false;
         } else if (!Intrinsics.areEqual(this.clientId, var1.clientId)) {
            return false;
         } else if (!Intrinsics.areEqual(this.clientSecret, var1.clientSecret)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mqttBroker, var1.mqttBroker)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.regionCode, var1.regionCode);
         }
      }
   }

   public final String getClientId() {
      return this.clientId;
   }

   public final String getClientSecret() {
      return this.clientSecret;
   }

   public final String getHost() {
      return this.host;
   }

   public final String getMqttBroker() {
      return this.mqttBroker;
   }

   public final String getRegionCode() {
      return this.regionCode;
   }

   public int hashCode() {
      return (((this.host.hashCode() * 31 + this.clientId.hashCode()) * 31 + this.clientSecret.hashCode()) * 31 + this.mqttBroker.hashCode()) * 31 + this.regionCode.hashCode();
   }

   public final String regionCodeShort() {
      return StringsKt.take(this.regionCode, 2);
   }

   public final String tag() {
      String var2;
      if (StringsKt.endsWith$default(this.host, "prod/", false, 2, (Object)null)) {
         var2 = "prod";
      } else {
         var2 = "qa";
      }

      String var3 = this.regionCode;
      int var1 = var3.hashCode();
      if (var1 != -281577977) {
         if (var1 != 372748112) {
            if (var1 == 1808575601 && var3.equals("us-east-2")) {
               return "us_".concat(var2);
            }
         } else if (var3.equals("eu-west-1")) {
            return "eu_".concat(var2);
         }
      } else if (var3.equals("cn-north-1")) {
         return "cn_".concat(var2);
      }

      return "";
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("BlueCloudDomain(host=");
      var1.append(this.host);
      var1.append(", clientId=");
      var1.append(this.clientId);
      var1.append(", clientSecret=");
      var1.append(this.clientSecret);
      var1.append(", mqttBroker=");
      var1.append(this.mqttBroker);
      var1.append(", regionCode=");
      var1.append(this.regionCode);
      var1.append(')');
      return var1.toString();
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"},
      d2 = {"Lcom/blueair/auth/BlueCloudDomain$Companion;", "", "<init>", "()V", "PROVISION_CHINA", "", "PROVISION_USA", "PROVISION_EUROPE", "INVALID", "Lcom/blueair/auth/BlueCloudDomain;", "getINVALID", "()Lcom/blueair/auth/BlueCloudDomain;", "fromProvisionRegionCode", "provisionRegionCode", "overrideIsRelease", "", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/blueair/auth/BlueCloudDomain;", "getDomainForRegion", "regionCode", "auth_otherRelease"},
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

      // $FF: synthetic method
      public static BlueCloudDomain fromProvisionRegionCode$default(Companion var0, String var1, Boolean var2, int var3, Object var4) {
         if ((var3 & 2) != 0) {
            var2 = null;
         }

         return var0.fromProvisionRegionCode(var1, var2);
      }

      // $FF: synthetic method
      public static BlueCloudDomain getDomainForRegion$default(Companion var0, String var1, Boolean var2, int var3, Object var4) {
         if ((var3 & 2) != 0) {
            var2 = null;
         }

         return var0.getDomainForRegion(var1, var2);
      }

      public final BlueCloudDomain fromProvisionRegionCode(String var1, Boolean var2) {
         Intrinsics.checkNotNullParameter(var1, "provisionRegionCode");
         if (Intrinsics.areEqual(var1, "cn-north-1")) {
            return this.getDomainForRegion("cn", var2);
         } else {
            return Intrinsics.areEqual(var1, "us-east-2") ? this.getDomainForRegion("us", var2) : this.getDomainForRegion("eu", var2);
         }
      }

      public final BlueCloudDomain getDomainForRegion(String var1, Boolean var2) {
         Intrinsics.checkNotNullParameter(var1, "regionCode");
         boolean var3;
         if (var2 != null) {
            var3 = var2;
         } else {
            var3 = BuildEnvironment.INSTANCE.isRelease();
         }

         Timber.Forest var4 = Timber.Forest;
         StringBuilder var8 = new StringBuilder("getDomainForRegion: ");
         var8.append(var1);
         var4.d(var8.toString(), new Object[0]);
         if (Intrinsics.areEqual(var1, "cn")) {
            if (var3) {
               var1 = "https://ftbkyp79si.execute-api.cn-north-1.amazonaws.com.cn/prod/";
            } else {
               var1 = "https://817rqonyaj.execute-api.cn-northwest-1.amazonaws.com.cn/qa/";
            }

            String var11;
            if (var3) {
               var11 = "a2du5f95w7oz2a.ats.iot.cn-north-1.amazonaws.com.cn";
            } else {
               var11 = "a2du5f95w7oz2a-ats.iot.cn-northwest-1.amazonaws.com.cn";
            }

            return new BlueCloudDomain(var1, "2m1pfaga6vdd557fnl7lbn1ljq", "1r152pm64c1ojfdi9acnqpjlop0kl8kocl3kij3qj988p6cem4t8", var11, "cn-north-1");
         } else if (Intrinsics.areEqual(var1, "us")) {
            if (var3) {
               var1 = "https://on1keymlmh.execute-api.us-east-2.amazonaws.com/prod/";
            } else {
               var1 = "https://ychmmhbbi1.execute-api.us-east-2.amazonaws.com/qa/";
            }

            String var10;
            if (var3) {
               var10 = "a3tpdpjvxk6yog-ats.iot.us-east-2.amazonaws.com";
            } else {
               var10 = "a169psisgz8280-ats.iot.us-east-2.amazonaws.com";
            }

            return new BlueCloudDomain(var1, "2m1pfaga6vdd557fnl7lbn1ljq", "1r152pm64c1ojfdi9acnqpjlop0kl8kocl3kij3qj988p6cem4t8", var10, "us-east-2");
         } else {
            if (var3) {
               var1 = "https://hkgmr8v960.execute-api.eu-west-1.amazonaws.com/prod/";
            } else {
               var1 = "https://7474fty4v3.execute-api.eu-west-1.amazonaws.com/qa/";
            }

            String var9;
            if (var3) {
               var9 = "a3tpdpjvxk6yog-ats.iot.eu-west-1.amazonaws.com";
            } else {
               var9 = "a169psisgz8280-ats.iot.eu-west-1.amazonaws.com";
            }

            return new BlueCloudDomain(var1, "2m1pfaga6vdd557fnl7lbn1ljq", "1r152pm64c1ojfdi9acnqpjlop0kl8kocl3kij3qj988p6cem4t8", var9, "eu-west-1");
         }
      }

      public final BlueCloudDomain getINVALID() {
         return BlueCloudDomain.INVALID;
      }
   }
}
