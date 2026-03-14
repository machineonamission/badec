package com.blueair.core.util;

import android.content.res.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rJ\"\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015¨\u0006\u0017"},
   d2 = {"Lcom/blueair/core/util/HttpsTrustUtils;", "", "<init>", "()V", "getTrustSslDetailsFor", "Lkotlin/Triple;", "Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocketFactory;", "", "Ljava/security/cert/Certificate;", "resources", "Landroid/content/res/Resources;", "certificateResId", "", "trustManagerForCertificates", "Lkotlin/Pair;", "inputStream", "Ljava/io/InputStream;", "newEmptyKeyStore", "Ljava/security/KeyStore;", "password", "", "CertificateOnlyHostnameVerifier", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class HttpsTrustUtils {
   public static final HttpsTrustUtils INSTANCE = new HttpsTrustUtils();

   private HttpsTrustUtils() {
   }

   private final Pair trustManagerForCertificates(InputStream var1) throws GeneralSecurityException {
      Collection var7 = CertificateFactory.getInstance("X.509").generateCertificates(var1);
      if (var7.isEmpty()) {
         throw new IllegalArgumentException("expected non-empty set of trusted certificates");
      } else {
         char[] var4 = "password".toCharArray();
         Intrinsics.checkNotNullExpressionValue(var4, "toCharArray(...)");
         KeyStore var3 = this.newEmptyKeyStore(var4);
         Iterator var5 = var7.iterator();

         for(int var2 = 0; var5.hasNext(); ++var2) {
            Certificate var6 = (Certificate)var5.next();
            var3.setCertificateEntry(Integer.toString(var2), var6);
         }

         KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()).init(var3, var4);
         TrustManagerFactory var11 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
         var11.init(var3);
         TrustManager[] var9 = var11.getTrustManagers();
         if (var9.length == 1 && var9[0] instanceof X509TrustManager) {
            var9 = var9[0];
            Intrinsics.checkNotNull(var9, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            return new Pair((X509TrustManager)var9, var7);
         } else {
            StringBuilder var8 = new StringBuilder("Unexpected default trust managers:");
            var8.append(Arrays.toString(var9));
            throw new IllegalStateException(var8.toString());
         }
      }
   }

   public final Triple getTrustSslDetailsFor(Resources var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "resources");

      SSLSocketFactory var8;
      try {
         InputStream var6 = var1.openRawResource(var2);
         Intrinsics.checkNotNullExpressionValue(var6, "openRawResource(...)");
         var7 = this.trustManagerForCertificates(var6);
         SSLContext var3 = SSLContext.getInstance("TLS");
         var3.init((KeyManager[])null, (TrustManager[])(new X509TrustManager[]{(X509TrustManager)var7.getFirst()}), (SecureRandom)null);
         var8 = var3.getSocketFactory();
         Intrinsics.checkNotNullExpressionValue(var8, "getSocketFactory(...)");
      } catch (GeneralSecurityException var4) {
         throw new RuntimeException((Throwable)var4);
      } catch (IllegalArgumentException var5) {
         return new Triple((Object)null, (Object)null, (Object)null);
      }

      return new Triple(var7.getFirst(), var8, var7.getSecond());
   }

   public final KeyStore newEmptyKeyStore(char[] var1) {
      Intrinsics.checkNotNullParameter(var1, "password");

      try {
         KeyStore var2 = KeyStore.getInstance(KeyStore.getDefaultType());
         var2.load((InputStream)null, var1);
         Intrinsics.checkNotNull(var2);
         return var2;
      } catch (IOException var3) {
         throw new AssertionError(var3);
      }
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"},
      d2 = {"Lcom/blueair/core/util/HttpsTrustUtils$CertificateOnlyHostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "localCertificates", "", "Ljava/security/cert/Certificate;", "<init>", "(Ljava/util/Collection;)V", "getLocalCertificates", "()Ljava/util/Collection;", "verify", "", "hostname", "", "session", "Ljavax/net/ssl/SSLSession;", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CertificateOnlyHostnameVerifier implements HostnameVerifier {
      private final Collection localCertificates;

      public CertificateOnlyHostnameVerifier(Collection var1) {
         Intrinsics.checkNotNullParameter(var1, "localCertificates");
         super();
         this.localCertificates = var1;
      }

      public final Collection getLocalCertificates() {
         return this.localCertificates;
      }

      public boolean verify(String var1, SSLSession var2) {
         if (var2 != null) {
            Certificate[] var9 = var2.getPeerCertificates();
            if (var9 != null) {
               for(Certificate var7 : var9) {
                  Iterator var6 = ((Iterable)this.localCertificates).iterator();

                  while(var6.hasNext()) {
                     byte[] var8 = ((Certificate)var6.next()).getEncoded();
                     boolean var5;
                     if (var8 != null) {
                        var5 = Arrays.equals(var8, var7.getEncoded());
                     } else {
                        var5 = false;
                     }

                     if (var5) {
                        Timber.Forest var12 = Timber.Forest;
                        StringBuilder var10 = new StringBuilder("hostname ");
                        var10.append(var1);
                        var10.append(" verified manually");
                        var12.v(var10.toString(), new Object[0]);
                        return true;
                     }
                  }
               }
            }
         }

         Timber.Forest var13 = Timber.Forest;
         StringBuilder var11 = new StringBuilder("hostname ");
         var11.append(var1);
         var11.append(" not successfully verified");
         var13.e(var11.toString(), new Object[0]);
         return false;
      }
   }
}
