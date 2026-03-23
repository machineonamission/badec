package com.blueair.bluetooth.espressif;

import timber.log.Timber;

public class Session {
    private static final String TAG = "Espressif::Session";
    private boolean isSessionEstablished;
    private Security security;
    public SessionListener sessionListener;
    private Transport transport;

    public interface SessionListener {
        void OnSessionEstablishFailed(Exception exc);

        void OnSessionEstablished();
    }

    public Session(Transport transport2, Security security2) {
        this.transport = transport2;
        this.security = security2;
    }

    public Security getSecurity() {
        return this.security;
    }

    public Transport getTransport() {
        return this.transport;
    }

    public boolean isEstablished() {
        return this.isSessionEstablished;
    }

    public void init(byte[] bArr) throws RuntimeException {
        SessionListener sessionListener2;
        try {
            Timber.d("init: response = " + bArr, new Object[0]);
            byte[] nextRequestInSession = this.security.getNextRequestInSession(bArr);
            Timber.d("init: request = " + nextRequestInSession + ", isSessionEstablished = " + this.isSessionEstablished + ", sessionListener = " + this.sessionListener, new Object[0]);
            if (nextRequestInSession == null) {
                this.isSessionEstablished = true;
                SessionListener sessionListener3 = this.sessionListener;
                if (sessionListener3 != null) {
                    sessionListener3.OnSessionEstablished();
                    return;
                }
                return;
            }
            Timber.d("init: BLETransport.sendSessionData:  request = " + nextRequestInSession + ", isSessionEstablished = " + this.isSessionEstablished + ", sessionListener = " + this.sessionListener, new Object[0]);
            this.transport.sendSessionData(nextRequestInSession, new ResponseListener() {
                public void onSuccess(byte[] bArr) {
                    Timber.d("init: BLETransport.onSuccess : returnData = " + bArr, new Object[0]);
                    if (bArr != null) {
                        Session.this.init(bArr);
                    } else if (Session.this.sessionListener != null) {
                        Session.this.sessionListener.OnSessionEstablishFailed(new Exception("Session could not be established"));
                    }
                }

                public void onFailure(Exception exc) {
                    Timber.e(exc, "init: BLETransport.onFailure", new Object[0]);
                    if (Session.this.sessionListener != null) {
                        Session.this.sessionListener.OnSessionEstablishFailed(exc);
                    }
                }
            });
        } catch (RuntimeException e) {
            Timber.e(e, "init: failed", new Object[0]);
            if (bArr == null && (sessionListener2 = this.sessionListener) != null) {
                sessionListener2.OnSessionEstablishFailed(new RuntimeException("Session could not be established"));
            }
        }
    }
}
