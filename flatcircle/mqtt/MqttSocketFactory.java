package io.flatcircle.mqtt;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.security.cert.CertificateException;
import timber.log.Timber;

public class MqttSocketFactory extends SSLSocketFactory {
    private SSLSocketFactory factory;
    private TrustManagerFactory tmf;

    public static class SocketFactoryOptions {
        private InputStream caClientP12InputStream;
        private String caClientP12Password;
        private InputStream caCrtInputStream;

        public SocketFactoryOptions withCaInputStream(InputStream inputStream) {
            this.caCrtInputStream = inputStream;
            return this;
        }

        public SocketFactoryOptions withClientP12InputStream(InputStream inputStream) {
            this.caClientP12InputStream = inputStream;
            return this;
        }

        public SocketFactoryOptions withClientP12Password(String str) {
            this.caClientP12Password = str;
            return this;
        }

        public boolean hasCaCrt() {
            return this.caCrtInputStream != null;
        }

        public boolean hasClientP12Crt() {
            return this.caClientP12Password != null;
        }

        public InputStream getCaCrtInputStream() {
            return this.caCrtInputStream;
        }

        public InputStream getCaClientP12InputStream() {
            return this.caClientP12InputStream;
        }

        public String getCaClientP12Password() {
            return this.caClientP12Password;
        }

        public boolean hasClientP12Password() {
            String str = this.caClientP12Password;
            return str != null && !str.equals("");
        }
    }

    public MqttSocketFactory() throws CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, KeyManagementException, java.security.cert.CertificateException, UnrecoverableKeyException {
        this(new SocketFactoryOptions());
    }

    public MqttSocketFactory(SocketFactoryOptions socketFactoryOptions) throws KeyStoreException, NoSuchAlgorithmException, IOException, KeyManagementException, java.security.cert.CertificateException, UnrecoverableKeyException {
        Log.v(toString(), "initializing CustomSocketFactory");
        this.tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        KeyManagerFactory instance = KeyManagerFactory.getInstance("X509");
        if (socketFactoryOptions.hasCaCrt()) {
            Log.v(toString(), "MQTT_CONNECTION_OPTIONS.hasCaCrt(): true");
            KeyStore instance2 = KeyStore.getInstance(KeyStore.getDefaultType());
            instance2.load((InputStream) null, (char[]) null);
            X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(socketFactoryOptions.getCaCrtInputStream());
            instance2.setCertificateEntry(x509Certificate.getSubjectX500Principal().getName(), x509Certificate);
            this.tmf.init(instance2);
            Timber.v("Certificate Owner: %s", x509Certificate.getSubjectDN().toString());
            Timber.v("Certificate Issuer: %s", x509Certificate.getIssuerDN().toString());
            Timber.v("Certificate Serial Number: %s", x509Certificate.getSerialNumber().toString());
            Timber.v("Certificate Algorithm: %s", x509Certificate.getSigAlgName());
            Timber.v("Certificate Version: %s", Integer.valueOf(x509Certificate.getVersion()));
            Timber.v("Certificate OID: %s", x509Certificate.getSigAlgOID());
            Enumeration<String> aliases = instance2.aliases();
            while (aliases.hasMoreElements()) {
                String nextElement = aliases.nextElement();
                Timber.v("Alias: %s isKeyEntry:%s isCertificateEntry:%s", nextElement, Boolean.valueOf(instance2.isKeyEntry(nextElement)), Boolean.valueOf(instance2.isCertificateEntry(nextElement)));
            }
        } else {
            Timber.v("CA sideload: false, using system keystore", new Object[0]);
            KeyStore instance3 = KeyStore.getInstance("AndroidCAStore");
            instance3.load((KeyStore.LoadStoreParameter) null);
            this.tmf.init(instance3);
        }
        if (socketFactoryOptions.hasClientP12Crt()) {
            Log.v(toString(), "MQTT_CONNECTION_OPTIONS.hasClientP12Crt(): true");
            KeyStore instance4 = KeyStore.getInstance("PKCS12");
            instance4.load(socketFactoryOptions.getCaClientP12InputStream(), socketFactoryOptions.hasClientP12Password() ? socketFactoryOptions.getCaClientP12Password().toCharArray() : new char[0]);
            instance.init(instance4, socketFactoryOptions.hasClientP12Password() ? socketFactoryOptions.getCaClientP12Password().toCharArray() : new char[0]);
            Log.v(toString(), "Client .p12 Keystore content: ");
            Enumeration<String> aliases2 = instance4.aliases();
            while (aliases2.hasMoreElements()) {
                Timber.v("Alias: %s", aliases2.nextElement());
            }
        } else {
            Log.v(toString(), "Client .p12 sideload: false, using null CLIENT cert");
            instance.init((KeyStore) null, (char[]) null);
        }
        SSLContext instance5 = SSLContext.getInstance("TLSv1.2");
        instance5.init(instance.getKeyManagers(), getTrustManagers(), (SecureRandom) null);
        this.factory = instance5.getSocketFactory();
    }

    public TrustManager[] getTrustManagers() {
        return this.tmf.getTrustManagers();
    }

    public String[] getDefaultCipherSuites() {
        return this.factory.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.factory.getSupportedCipherSuites();
    }

    public Socket createSocket() throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.factory.createSocket();
        sSLSocket.setEnabledProtocols(new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"});
        return sSLSocket;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.factory.createSocket(socket, str, i, z);
        sSLSocket.setEnabledProtocols(new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"});
        return sSLSocket;
    }

    public Socket createSocket(String str, int i) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.factory.createSocket(str, i);
        sSLSocket.setEnabledProtocols(new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"});
        return sSLSocket;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.factory.createSocket(str, i, inetAddress, i2);
        sSLSocket.setEnabledProtocols(new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"});
        return sSLSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.factory.createSocket(inetAddress, i);
        sSLSocket.setEnabledProtocols(new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"});
        return sSLSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.factory.createSocket(inetAddress, i, inetAddress2, i2);
        sSLSocket.setEnabledProtocols(new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"});
        return sSLSocket;
    }
}
