package com.blueair.core.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(
   d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u001a2\u00020\u0001:\u0013\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001aB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0012\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,¨\u0006-"},
   d2 = {"Lcom/blueair/core/model/OnboardingState;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "NotConnected", "DeviceUnbound", "LinkConnect", "LinkReconnect", "LinkConnected", "ObtainingIPAddress", "IPAddressObtained", "Authenticating", "Authenticated", "BrokerConnecting", "BrokerConnected", "RegisterDevice", "SettingPassword", "DeviceBound", "BrokerDisconnected", "ImageProvisionStart", "ImageProvision", "ImageProvisionEnd", "Companion", "Lcom/blueair/core/model/OnboardingState$Authenticated;", "Lcom/blueair/core/model/OnboardingState$Authenticating;", "Lcom/blueair/core/model/OnboardingState$BrokerConnected;", "Lcom/blueair/core/model/OnboardingState$BrokerConnecting;", "Lcom/blueair/core/model/OnboardingState$BrokerDisconnected;", "Lcom/blueair/core/model/OnboardingState$DeviceBound;", "Lcom/blueair/core/model/OnboardingState$DeviceUnbound;", "Lcom/blueair/core/model/OnboardingState$IPAddressObtained;", "Lcom/blueair/core/model/OnboardingState$ImageProvision;", "Lcom/blueair/core/model/OnboardingState$ImageProvisionEnd;", "Lcom/blueair/core/model/OnboardingState$ImageProvisionStart;", "Lcom/blueair/core/model/OnboardingState$LinkConnect;", "Lcom/blueair/core/model/OnboardingState$LinkConnected;", "Lcom/blueair/core/model/OnboardingState$LinkReconnect;", "Lcom/blueair/core/model/OnboardingState$NotConnected;", "Lcom/blueair/core/model/OnboardingState$ObtainingIPAddress;", "Lcom/blueair/core/model/OnboardingState$RegisterDevice;", "Lcom/blueair/core/model/OnboardingState$SettingPassword;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class OnboardingState {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final String name;

   private OnboardingState(String var1) {
      this.name = var1;
   }

   // $FF: synthetic method
   public OnboardingState(String var1, DefaultConstructorMarker var2) {
      this(var1);
   }

   public final String getName() {
      return this.name;
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$Authenticated;", "Lcom/blueair/core/model/OnboardingState;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Authenticated extends OnboardingState {
      public static final Authenticated INSTANCE = new Authenticated();

      private Authenticated() {
         super("Authenticated", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$Authenticating;", "Lcom/blueair/core/model/OnboardingState;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Authenticating extends OnboardingState {
      public static final Authenticating INSTANCE = new Authenticating();

      private Authenticating() {
         super("Authenticating", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$BrokerConnected;", "Lcom/blueair/core/model/OnboardingState;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BrokerConnected extends OnboardingState {
      public static final BrokerConnected INSTANCE = new BrokerConnected();

      private BrokerConnected() {
         super("BrokerConnected", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$BrokerConnecting;", "Lcom/blueair/core/model/OnboardingState;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BrokerConnecting extends OnboardingState {
      public static final BrokerConnecting INSTANCE = new BrokerConnecting();

      private BrokerConnecting() {
         super("BrokerConnecting", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$BrokerDisconnected;", "Lcom/blueair/core/model/OnboardingState;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BrokerDisconnected extends OnboardingState {
      public static final BrokerDisconnected INSTANCE = new BrokerDisconnected();

      private BrokerDisconnected() {
         super("BrokerDisconnected", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$Companion;", "", "<init>", "()V", "fromName", "Lcom/blueair/core/model/OnboardingState;", "input", "", "core_otherRelease"},
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

      public final OnboardingState fromName(String var1) {
         Intrinsics.checkNotNullParameter(var1, "input");
         Iterable var3 = (Iterable)Reflection.getOrCreateKotlinClass(OnboardingState.class).getSealedSubclasses();
         Collection var2 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var3, 10)));
         Iterator var8 = var3.iterator();

         while(var8.hasNext()) {
            Object var4 = ((KClass)var8.next()).getObjectInstance();
            Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type com.blueair.core.model.OnboardingState");
            var2.add((OnboardingState)var4);
         }

         var8 = ((Iterable)((List)var2)).iterator();

         while(true) {
            if (var8.hasNext()) {
               Object var7 = var8.next();
               if (!Intrinsics.areEqual(((OnboardingState)var7).getName(), var1)) {
                  continue;
               }

               var5 = var7;
               break;
            }

            var5 = null;
            break;
         }

         OnboardingState var6 = (OnboardingState)var5;
         return var6 == null ? (OnboardingState)OnboardingState.NotConnected.INSTANCE : var6;
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$DeviceBound;", "Lcom/blueair/core/model/OnboardingState;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DeviceBound extends OnboardingState {
      public static final DeviceBound INSTANCE = new DeviceBound();

      private DeviceBound() {
         super("DeviceBound", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$DeviceUnbound;", "Lcom/blueair/core/model/OnboardingState;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DeviceUnbound extends OnboardingState {
      public static final DeviceUnbound INSTANCE = new DeviceUnbound();

      private DeviceUnbound() {
         super("DeviceUnbound", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$IPAddressObtained;", "Lcom/blueair/core/model/OnboardingState;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class IPAddressObtained extends OnboardingState {
      public static final IPAddressObtained INSTANCE = new IPAddressObtained();

      private IPAddressObtained() {
         super("IPAddressObtained", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$ImageProvision;", "Lcom/blueair/core/model/OnboardingState;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ImageProvision extends OnboardingState {
      public static final ImageProvision INSTANCE = new ImageProvision();

      private ImageProvision() {
         super("ImageProvision", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$ImageProvisionEnd;", "Lcom/blueair/core/model/OnboardingState;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ImageProvisionEnd extends OnboardingState {
      public static final ImageProvisionEnd INSTANCE = new ImageProvisionEnd();

      private ImageProvisionEnd() {
         super("ImageProvisionEnd", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$ImageProvisionStart;", "Lcom/blueair/core/model/OnboardingState;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ImageProvisionStart extends OnboardingState {
      public static final ImageProvisionStart INSTANCE = new ImageProvisionStart();

      private ImageProvisionStart() {
         super("ImageProvisionStart", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$LinkConnect;", "Lcom/blueair/core/model/OnboardingState;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class LinkConnect extends OnboardingState {
      public static final LinkConnect INSTANCE = new LinkConnect();

      private LinkConnect() {
         super("LinkConnect", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$LinkConnected;", "Lcom/blueair/core/model/OnboardingState;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class LinkConnected extends OnboardingState {
      public static final LinkConnected INSTANCE = new LinkConnected();

      private LinkConnected() {
         super("LinkConnected", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$LinkReconnect;", "Lcom/blueair/core/model/OnboardingState;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class LinkReconnect extends OnboardingState {
      public static final LinkReconnect INSTANCE = new LinkReconnect();

      private LinkReconnect() {
         super("LinkReconnect", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$NotConnected;", "Lcom/blueair/core/model/OnboardingState;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class NotConnected extends OnboardingState {
      public static final NotConnected INSTANCE = new NotConnected();

      private NotConnected() {
         super("NotConnected", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$ObtainingIPAddress;", "Lcom/blueair/core/model/OnboardingState;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ObtainingIPAddress extends OnboardingState {
      public static final ObtainingIPAddress INSTANCE = new ObtainingIPAddress();

      private ObtainingIPAddress() {
         super("ObtainingIPAddress", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$RegisterDevice;", "Lcom/blueair/core/model/OnboardingState;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class RegisterDevice extends OnboardingState {
      public static final RegisterDevice INSTANCE = new RegisterDevice();

      private RegisterDevice() {
         super("RegisterDevice", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/OnboardingState$SettingPassword;", "Lcom/blueair/core/model/OnboardingState;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SettingPassword extends OnboardingState {
      public static final SettingPassword INSTANCE = new SettingPassword();

      private SettingPassword() {
         super("SettingPassword", (DefaultConstructorMarker)null);
      }
   }
}
