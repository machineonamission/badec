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

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rJ\"\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015¨\u0006\u0017"}, d2 = {"Lcom/blueair/core/util/HttpsTrustUtils;", "", "<init>", "()V", "getTrustSslDetailsFor", "Lkotlin/Triple;", "Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocketFactory;", "", "Ljava/security/cert/Certificate;", "resources", "Landroid/content/res/Resources;", "certificateResId", "", "trustManagerForCertificates", "Lkotlin/Pair;", "inputStream", "Ljava/io/InputStream;", "newEmptyKeyStore", "Ljava/security/KeyStore;", "password", "", "CertificateOnlyHostnameVerifier", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: HttpsTrustUtils.kt */
public final class HttpsTrustUtils {
    public static final HttpsTrustUtils INSTANCE = new HttpsTrustUtils();

    private HttpsTrustUtils() {
    }

    public final Triple<X509TrustManager, SSLSocketFactory, Collection<Certificate>> getTrustSslDetailsFor(Resources resources, int i) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        try {
            InputStream openRawResource = resources.openRawResource(i);
            Intrinsics.checkNotNullExpressionValue(openRawResource, "openRawResource(...)");
            Pair<X509TrustManager, Collection<Certificate>> trustManagerForCertificates = trustManagerForCertificates(openRawResource);
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, (TrustManager[]) new X509TrustManager[]{trustManagerForCertificates.getFirst()}, (SecureRandom) null);
            SSLSocketFactory socketFactory = instance.getSocketFactory();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "getSocketFactory(...)");
            return new Triple<>(trustManagerForCertificates.getFirst(), socketFactory, trustManagerForCertificates.getSecond());
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException unused) {
            return new Triple<>(null, null, null);
        }
    }

    private final Pair<X509TrustManager, Collection<Certificate>> trustManagerForCertificates(InputStream inputStream) throws GeneralSecurityException {
        Collection<? extends Certificate> generateCertificates = CertificateFactory.getInstance("X.509").generateCertificates(inputStream);
        if (!generateCertificates.isEmpty()) {
            char[] charArray = "password".toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
            KeyStore newEmptyKeyStore = newEmptyKeyStore(charArray);
            int i = 0;
            for (Certificate certificateEntry : generateCertificates) {
                newEmptyKeyStore.setCertificateEntry(Integer.toString(i), certificateEntry);
                i++;
            }
            KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()).init(newEmptyKeyStore, charArray);
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(newEmptyKeyStore);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            }
            TrustManager trustManager = trustManagers[0];
            Intrinsics.checkNotNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            return new Pair<>((X509TrustManager) trustManager, generateCertificates);
        }
        throw new IllegalArgumentException("expected non-empty set of trusted certificates");
    }

    public final KeyStore newEmptyKeyStore(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "password");
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load((InputStream) null, cArr);
            Intrinsics.checkNotNull(instance);
            return instance;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/blueair/core/util/HttpsTrustUtils$CertificateOnlyHostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "localCertificates", "", "Ljava/security/cert/Certificate;", "<init>", "(Ljava/util/Collection;)V", "getLocalCertificates", "()Ljava/util/Collection;", "verify", "", "hostname", "", "session", "Ljavax/net/ssl/SSLSession;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: HttpsTrustUtils.kt */
    public static final class CertificateOnlyHostnameVerifier implements HostnameVerifier {
        private final Collection<Certificate> localCertificates;

        public CertificateOnlyHostnameVerifier(Collection<? extends Certificate> collection) {
            Intrinsics.checkNotNullParameter(collection, "localCertificates");
            this.localCertificates = collection;
        }

        public final Collection<Certificate> getLocalCertificates() {
            return this.localCertificates;
        }

        public boolean verify(String str, SSLSession sSLSession) {
            Certificate[] peerCertificates;
            boolean z;
            if (!(sSLSession == null || (peerCertificates = sSLSession.getPeerCertificates()) == null)) {
                for (Certificate certificate : peerCertificates) {
                    for (Certificate encoded : this.localCertificates) {
                        byte[] encoded2 = encoded.getEncoded();
                        if (encoded2 != null) {
                            z = Arrays.equals(encoded2, certificate.getEncoded());
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            Timber.Forest.v("hostname " + str + " verified manually", new Object[0]);
                            return true;
                        }
                    }
                }
            }
            Timber.Forest.e("hostname " + str + " not successfully verified", new Object[0]);
            return false;
        }
    }
}
