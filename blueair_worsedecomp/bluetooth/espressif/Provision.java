package com.blueair.bluetooth.espressif;

import android.util.Log;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import custom.CustomCommands;
import espressif.Constants;
import espressif.WifiConfig;
import espressif.WifiConstants;
import timber.log.Timber;

public class Provision {
    public static final String CONFIG_BASE_URL_KEY = "baseUrl";
    public static final String CONFIG_PROOF_OF_POSSESSION_KEY = "proofOfPossession";
    public static final String CONFIG_SECURITY_KEY = "security";
    public static final String CONFIG_SECURITY_SECURITY0 = "security0";
    public static final String CONFIG_SECURITY_SECURITY1 = "security1";
    public static final String CONFIG_TRANSPORT_BLE = "ble";
    public static final String CONFIG_TRANSPORT_KEY = "transport";
    public static final String CONFIG_TRANSPORT_WIFI = "wifi";
    public static final String CONFIG_WIFI_AP_KEY = "wifiAPPrefix";
    public static final String PROVISIONING_CONFIG_PATH = "prov-config";
    public static final String PROVISIONING_WIFI_SSID = "SSID";
    public static final int REQUEST_PERMISSIONS_CODE = 102;
    public static final int REQUEST_PROVISIONING_CODE = 103;
    private static final String TAG = "Provision";
    public ProvisioningListener provisioningListener;
    private Security security;
    private Session session;
    private Transport transport;

    public interface ProvisionActionListener {
        void onComplete(Constants.Status status, Exception exc);
    }

    public interface ProvisioningListener {
        void OnApplyConfigurationsFailed();

        void OnApplyConfigurationsSucceeded();

        void OnProvisioningFailed(Exception exc);

        void OnWifiConnectionStatusUpdated(WifiConstants.WifiStationState wifiStationState, WifiConstants.WifiConnectFailedReason wifiConnectFailedReason, Exception exc);
    }

    public interface WifiStateListener {
        void onWifiStateUpdated(WifiConstants.WifiStationState wifiStationState, WifiConstants.WifiConnectFailedReason wifiConnectFailedReason, Exception exc);
    }

    public Provision(Session session2) {
        this.session = session2;
        this.security = session2.getSecurity();
        this.transport = session2.getTransport();
    }

    public void configureWifi(String str, String str2, final ProvisionActionListener provisionActionListener) {
        if (this.session.isEstablished()) {
            this.transport.sendConfigData(PROVISIONING_CONFIG_PATH, createSetWifiConfigRequest(str, str2), new ResponseListener() {
                public void onSuccess(byte[] bArr) {
                    Constants.Status access$000 = Provision.this.processSetWifiConfigResponse(bArr);
                    if (!(access$000 == Constants.Status.Success || Provision.this.provisioningListener == null)) {
                        Provision.this.provisioningListener.OnProvisioningFailed(new RuntimeException("Could not sent wifi credentials to device"));
                    }
                    ProvisionActionListener provisionActionListener = provisionActionListener;
                    if (provisionActionListener != null) {
                        provisionActionListener.onComplete(access$000, (Exception) null);
                    }
                }

                public void onFailure(Exception exc) {
                    if (Provision.this.provisioningListener != null) {
                        Provision.this.provisioningListener.OnProvisioningFailed(exc);
                    }
                    ProvisionActionListener provisionActionListener = provisionActionListener;
                    if (provisionActionListener != null) {
                        provisionActionListener.onComplete(Constants.Status.InternalError, exc);
                    }
                }
            });
        }
    }

    public void applyConfigurations(final ProvisionActionListener provisionActionListener) {
        if (this.session.isEstablished()) {
            this.transport.sendConfigData(PROVISIONING_CONFIG_PATH, createApplyConfigRequest(), new ResponseListener() {
                public void onSuccess(byte[] bArr) {
                    Constants.Status access$100 = Provision.this.processApplyConfigResponse(bArr);
                    if (access$100 == Constants.Status.Success) {
                        if (Provision.this.provisioningListener != null) {
                            Provision.this.provisioningListener.OnApplyConfigurationsSucceeded();
                        }
                    } else if (Provision.this.provisioningListener != null) {
                        Provision.this.provisioningListener.OnApplyConfigurationsFailed();
                    }
                    ProvisionActionListener provisionActionListener = provisionActionListener;
                    if (provisionActionListener != null) {
                        provisionActionListener.onComplete(access$100, (Exception) null);
                    }
                }

                public void onFailure(Exception exc) {
                    if (Provision.this.provisioningListener != null) {
                        Provision.this.provisioningListener.OnApplyConfigurationsFailed();
                    }
                    ProvisionActionListener provisionActionListener = provisionActionListener;
                    if (provisionActionListener != null) {
                        provisionActionListener.onComplete(Constants.Status.InternalError, exc);
                    }
                }
            });
        }
    }

    private byte[] createSetWifiConfigRequest(String str, String str2) {
        WifiConfig.CmdSetConfig cmdSetConfig;
        if (str2 != null) {
            cmdSetConfig = (WifiConfig.CmdSetConfig) WifiConfig.CmdSetConfig.newBuilder().setSsid(ByteString.copyFrom(str.getBytes())).setPassphrase(ByteString.copyFrom(str2.getBytes())).build();
        } else {
            cmdSetConfig = (WifiConfig.CmdSetConfig) WifiConfig.CmdSetConfig.newBuilder().setSsid(ByteString.copyFrom(str.getBytes())).build();
        }
        return this.security.encrypt(((WifiConfig.WiFiConfigPayload) WifiConfig.WiFiConfigPayload.newBuilder().setCmdSetConfig(cmdSetConfig).setMsg(WifiConfig.WiFiConfigMsgType.TypeCmdSetConfig).build()).toByteArray());
    }

    private byte[] getWifiConfigStatusRequest() {
        return this.security.encrypt(((WifiConfig.WiFiConfigPayload) WifiConfig.WiFiConfigPayload.newBuilder().setCmdGetStatus((WifiConfig.CmdGetStatus) WifiConfig.CmdGetStatus.newBuilder().build()).setMsg(WifiConfig.WiFiConfigMsgType.TypeCmdGetStatus).build()).toByteArray());
    }

    /* access modifiers changed from: private */
    public Constants.Status processSetWifiConfigResponse(byte[] bArr) {
        byte[] decrypt = this.security.decrypt(bArr);
        Constants.Status status = Constants.Status.InvalidSession;
        try {
            return WifiConfig.WiFiConfigPayload.parseFrom(decrypt).getRespSetConfig().getStatus();
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return status;
        }
    }

    private Object[] processGetWifiConfigStatusResponse(byte[] bArr) {
        WifiConstants.WifiStationState wifiStationState = WifiConstants.WifiStationState.Connecting;
        WifiConstants.WifiConnectFailedReason wifiConnectFailedReason = WifiConstants.WifiConnectFailedReason.UNRECOGNIZED;
        if (bArr == null) {
            return new Object[]{wifiStationState, wifiConnectFailedReason};
        }
        try {
            CustomCommands.EventResp eventResp = CustomCommands.CommandWrapper.parseFrom(this.security.decrypt(bArr)).getEventResp();
            Log.d(TAG, "EVENT count=" + eventResp.getNumberOfEvents() + ", json=" + eventResp.getJson());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return new Object[]{wifiStationState, wifiConnectFailedReason};
    }

    public void pollForWifiConnectionStatus(final WifiStateListener wifiStateListener) {
        byte[] createGetWifiStatusRequest = createGetWifiStatusRequest();
        Timber.d("pollForWifiConnectionStatus: message = " + createGetWifiStatusRequest + ", wifiStateListener = " + wifiStateListener, new Object[0]);
        this.transport.sendConfigData(PROVISIONING_CONFIG_PATH, createGetWifiStatusRequest, new ResponseListener() {
            public void onSuccess(byte[] bArr) {
                try {
                    WifiConfig.RespGetStatus access$200 = Provision.this.processGetWifiStatusResponse(bArr);
                    if (access$200.getStatus() == Constants.Status.Success) {
                        WifiConstants.WifiStationState staState = access$200.getStaState();
                        WifiConstants.WifiConnectFailedReason failReason = access$200.getFailReason();
                        if (staState == WifiConstants.WifiStationState.Connected) {
                            wifiStateListener.onWifiStateUpdated(staState, failReason, (Exception) null);
                        } else if (staState == WifiConstants.WifiStationState.Connecting) {
                            try {
                                Thread.sleep(500);
                                Provision.this.pollForWifiConnectionStatus(wifiStateListener);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                wifiStateListener.onWifiStateUpdated(staState, failReason, (Exception) null);
                            }
                        } else {
                            wifiStateListener.onWifiStateUpdated(staState, failReason, (Exception) null);
                        }
                    } else {
                        wifiStateListener.onWifiStateUpdated(WifiConstants.WifiStationState.ConnectionFailed, access$200.getFailReason(), (Exception) null);
                    }
                } catch (Exception e2) {
                    wifiStateListener.onWifiStateUpdated((WifiConstants.WifiStationState) null, (WifiConstants.WifiConnectFailedReason) null, e2);
                }
            }

            public void onFailure(Exception exc) {
                Timber.e(exc, "pollForWifiConnectionStatus: onFailure", new Object[0]);
                wifiStateListener.onWifiStateUpdated(WifiConstants.WifiStationState.Disconnected, WifiConstants.WifiConnectFailedReason.UNRECOGNIZED, exc);
            }
        });
    }

    private byte[] createApplyConfigRequest() {
        return this.security.encrypt(((WifiConfig.WiFiConfigPayload) WifiConfig.WiFiConfigPayload.newBuilder().setCmdApplyConfig((WifiConfig.CmdApplyConfig) WifiConfig.CmdApplyConfig.newBuilder().build()).setMsg(WifiConfig.WiFiConfigMsgType.TypeCmdApplyConfig).build()).toByteArray());
    }

    private byte[] createGetWifiStatusRequest() {
        return this.security.encrypt(((WifiConfig.WiFiConfigPayload) WifiConfig.WiFiConfigPayload.newBuilder().setCmdGetStatus((WifiConfig.CmdGetStatus) WifiConfig.CmdGetStatus.newBuilder().build()).setMsg(WifiConfig.WiFiConfigMsgType.TypeCmdGetStatus).build()).toByteArray());
    }

    /* access modifiers changed from: private */
    public Constants.Status processApplyConfigResponse(byte[] bArr) {
        byte[] decrypt = this.security.decrypt(bArr);
        Constants.Status status = Constants.Status.InvalidSession;
        try {
            return WifiConfig.WiFiConfigPayload.parseFrom(decrypt).getRespApplyConfig().getStatus();
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return status;
        }
    }

    /* access modifiers changed from: private */
    public WifiConfig.RespGetStatus processGetWifiStatusResponse(byte[] bArr) throws InvalidProtocolBufferException {
        return WifiConfig.WiFiConfigPayload.parseFrom(this.security.decrypt(bArr)).getRespGetStatus();
    }
}
