package com.blueair.auth;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00142\u00020\u0001:\u0005\u0010\u0011\u0012\u0013\u0014B)\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\n\u0082\u0001\u0004\u0015\u0016\u0017\u0018¨\u0006\u0019"},
   d2 = {"Lcom/blueair/auth/GigyaServer;", "", "url", "", "prodApiKey", "qaApiKey", "countryCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getProdApiKey", "getQaApiKey", "getCountryCode", "apiKey", "getApiKey", "USA", "EUROPE", "CHINA", "AUSTRALIA", "Companion", "Lcom/blueair/auth/GigyaServer$AUSTRALIA;", "Lcom/blueair/auth/GigyaServer$CHINA;", "Lcom/blueair/auth/GigyaServer$EUROPE;", "Lcom/blueair/auth/GigyaServer$USA;", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class GigyaServer {
   private static final List ALL_SERVERS;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static boolean useSandbox;
   private final String countryCode;
   private final String prodApiKey;
   private final String qaApiKey;
   private final String url;

   static {
      ALL_SERVERS = CollectionsKt.listOf(new GigyaServer[]{GigyaServer.USA.INSTANCE, GigyaServer.EUROPE.INSTANCE, GigyaServer.CHINA.INSTANCE, GigyaServer.AUSTRALIA.INSTANCE});
   }

   private GigyaServer(String var1, String var2, String var3, String var4) {
      this.url = var1;
      this.prodApiKey = var2;
      this.qaApiKey = var3;
      this.countryCode = var4;
   }

   // $FF: synthetic method
   public GigyaServer(String var1, String var2, String var3, String var4, DefaultConstructorMarker var5) {
      this(var1, var2, var3, var4);
   }

   public final String getApiKey() {
      return useSandbox ? this.qaApiKey : this.prodApiKey;
   }

   public final String getCountryCode() {
      return this.countryCode;
   }

   public final String getProdApiKey() {
      return this.prodApiKey;
   }

   public final String getQaApiKey() {
      return this.qaApiKey;
   }

   public final String getUrl() {
      return this.url;
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/auth/GigyaServer$AUSTRALIA;", "Lcom/blueair/auth/GigyaServer;", "<init>", "()V", "auth_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AUSTRALIA extends GigyaServer {
      public static final AUSTRALIA INSTANCE = new AUSTRALIA();

      private AUSTRALIA() {
         super("https://accounts.au1.gigya.com", "3_Z2N0mIFC6j2fx1z2sq76R3pwkCMaMX2y9btPb0_PgI_3wfjSJoofFnBbxbtuQksN", "3_HbHCcCFE-hZTPX6DbFb0dNV7VvxbCCJ053lSFmDZwfcXuMYTILlAj7lDEbiDhAOw", "au", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/auth/GigyaServer$CHINA;", "Lcom/blueair/auth/GigyaServer;", "<init>", "()V", "auth_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CHINA extends GigyaServer {
      public static final CHINA INSTANCE = new CHINA();

      private CHINA() {
         super("https://accounts.cn1.sapcdm.cn", "3_h3UEfJnA-zDpFPR9L4412HO7Mz2VVeN4wprbWYafPN1gX0kSnLcZ9VSfFi7bEIIU", "3_h3UEfJnA-zDpFPR9L4412HO7Mz2VVeN4wprbWYafPN1gX0kSnLcZ9VSfFi7bEIIU", "cn", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"},
      d2 = {"Lcom/blueair/auth/GigyaServer$Companion;", "", "<init>", "()V", "ALL_SERVERS", "", "Lcom/blueair/auth/GigyaServer;", "getALL_SERVERS", "()Ljava/util/List;", "useSandbox", "", "getUseSandbox", "()Z", "setUseSandbox", "(Z)V", "auth_otherRelease"},
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

      public final List getALL_SERVERS() {
         return GigyaServer.ALL_SERVERS;
      }

      public final boolean getUseSandbox() {
         return GigyaServer.useSandbox;
      }

      public final void setUseSandbox(boolean var1) {
         GigyaServer.useSandbox = var1;
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/auth/GigyaServer$EUROPE;", "Lcom/blueair/auth/GigyaServer;", "<init>", "()V", "auth_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class EUROPE extends GigyaServer {
      public static final EUROPE INSTANCE = new EUROPE();

      private EUROPE() {
         super("https://accounts.eu1.gigya.com", "3_qRseYzrUJl1VyxvSJANalu_kNgQ83swB1B9uzgms58--5w1ClVNmrFdsDnWVQQCl", "3_DzR_syVnsgX7eztiQS4fTui74rty3mK0_79W_bPFiEejqNdXXt5XgsTecjVhy-pB", "eu", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/auth/GigyaServer$USA;", "Lcom/blueair/auth/GigyaServer;", "<init>", "()V", "auth_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class USA extends GigyaServer {
      public static final USA INSTANCE = new USA();

      private USA() {
         super("https://accounts.us1.gigya.com", "3_-xUbbrIY8QCbHDWQs1tLXE-CZBQ50SGElcOY5hF1euE11wCoIlNbjMGAFQ6UwhMY", "3_ySPsrsHSXFGBAm5bIySMyifZ29wt6LFIsiaU4QLEVlaz5MOEhi5cEJrKaWn_Glcv", "us", (DefaultConstructorMarker)null);
      }
   }
}
