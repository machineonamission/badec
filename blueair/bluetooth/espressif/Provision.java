package com.blueair.bluetooth.espressif;

import android.util.Log;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import custom.CustomCommands;
import custom.CustomCommands.CommandWrapper;
import espressif.Constants;
import espressif.WifiConfig;
import espressif.WifiConstants;
import espressif.Constants.Status;
import espressif.WifiConfig.CmdApplyConfig;
import espressif.WifiConfig.CmdGetStatus;
import espressif.WifiConfig.CmdSetConfig;
import espressif.WifiConfig.WiFiConfigMsgType;
import espressif.WifiConfig.WiFiConfigPayload;
import espressif.WifiConstants.WifiConnectFailedReason;
import espressif.WifiConstants.WifiStationState;
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

   public Provision(Session var1) {
      this.session = var1;
      this.security = var1.getSecurity();
      this.transport = var1.getTransport();
   }

   // $FF: synthetic method
   static WifiConfig.RespGetStatus access$200(Provision var0, byte[] var1) throws InvalidProtocolBufferException {
      return var0.processGetWifiStatusResponse(var1);
   }

   private byte[] createApplyConfigRequest() {
      WifiConfig.CmdApplyConfig var1 = (WifiConfig.CmdApplyConfig)CmdApplyConfig.newBuilder().build();
      WifiConfig.WiFiConfigPayload var2 = (WifiConfig.WiFiConfigPayload)WiFiConfigPayload.newBuilder().setCmdApplyConfig(var1).setMsg(WiFiConfigMsgType.TypeCmdApplyConfig).build();
      return this.security.encrypt(var2.toByteArray());
   }

   private byte[] createGetWifiStatusRequest() {
      WifiConfig.CmdGetStatus var1 = (WifiConfig.CmdGetStatus)CmdGetStatus.newBuilder().build();
      WifiConfig.WiFiConfigPayload var2 = (WifiConfig.WiFiConfigPayload)WiFiConfigPayload.newBuilder().setCmdGetStatus(var1).setMsg(WiFiConfigMsgType.TypeCmdGetStatus).build();
      return this.security.encrypt(var2.toByteArray());
   }

   private byte[] createSetWifiConfigRequest(String var1, String var2) {
      WifiConfig.CmdSetConfig var3;
      if (var2 != null) {
         var3 = (WifiConfig.CmdSetConfig)CmdSetConfig.newBuilder().setSsid(ByteString.copyFrom(var1.getBytes())).setPassphrase(ByteString.copyFrom(var2.getBytes())).build();
      } else {
         var3 = (WifiConfig.CmdSetConfig)CmdSetConfig.newBuilder().setSsid(ByteString.copyFrom(var1.getBytes())).build();
      }

      WifiConfig.WiFiConfigPayload var4 = (WifiConfig.WiFiConfigPayload)WiFiConfigPayload.newBuilder().setCmdSetConfig(var3).setMsg(WiFiConfigMsgType.TypeCmdSetConfig).build();
      return this.security.encrypt(var4.toByteArray());
   }

   private byte[] getWifiConfigStatusRequest() {
      WifiConfig.CmdGetStatus var1 = (WifiConfig.CmdGetStatus)CmdGetStatus.newBuilder().build();
      WifiConfig.WiFiConfigPayload var2 = (WifiConfig.WiFiConfigPayload)WiFiConfigPayload.newBuilder().setCmdGetStatus(var1).setMsg(WiFiConfigMsgType.TypeCmdGetStatus).build();
      return this.security.encrypt(var2.toByteArray());
   }

   private Constants.Status processApplyConfigResponse(byte[] var1) {
      byte[] var2 = this.security.decrypt(var1);
      Constants.Status var4 = Status.InvalidSession;

      try {
         Constants.Status var5 = WiFiConfigPayload.parseFrom(var2).getRespApplyConfig().getStatus();
         return var5;
      } catch (InvalidProtocolBufferException var3) {
         var3.printStackTrace();
         return var4;
      }
   }

   private Object[] processGetWifiConfigStatusResponse(byte[] var1) {
      WifiConstants.WifiStationState var3 = WifiStationState.Connecting;
      WifiConstants.WifiConnectFailedReason var2 = WifiConnectFailedReason.UNRECOGNIZED;
      if (var1 == null) {
         return new Object[]{var3, var2};
      } else {
         var1 = this.security.decrypt(var1);

         try {
            CustomCommands.EventResp var4 = CommandWrapper.parseFrom(var1).getEventResp();
            StringBuilder var7 = new StringBuilder("EVENT count=");
            var7.append(var4.getNumberOfEvents());
            var7.append(", json=");
            var7.append(var4.getJson());
            Log.d("Provision", var7.toString());
         } catch (InvalidProtocolBufferException var5) {
            var5.printStackTrace();
         }

         return new Object[]{var3, var2};
      }
   }

   private WifiConfig.RespGetStatus processGetWifiStatusResponse(byte[] var1) throws InvalidProtocolBufferException {
      return WiFiConfigPayload.parseFrom(this.security.decrypt(var1)).getRespGetStatus();
   }

   private Constants.Status processSetWifiConfigResponse(byte[] var1) {
      byte[] var2 = this.security.decrypt(var1);
      Constants.Status var4 = Status.InvalidSession;

      try {
         Constants.Status var5 = WiFiConfigPayload.parseFrom(var2).getRespSetConfig().getStatus();
         return var5;
      } catch (InvalidProtocolBufferException var3) {
         var3.printStackTrace();
         return var4;
      }
   }

   public void applyConfigurations(ProvisionActionListener var1) {
      if (this.session.isEstablished()) {
         byte[] var2 = this.createApplyConfigRequest();
         this.transport.sendConfigData("prov-config", var2, new ResponseListener(this, var1) {
            final Provision this$0;
            final ProvisionActionListener val$actionListener;

            {
               this.this$0 = var1;
               this.val$actionListener = var2;
            }

            public void onFailure(Exception var1) {
               if (this.this$0.provisioningListener != null) {
                  this.this$0.provisioningListener.OnApplyConfigurationsFailed();
               }

               ProvisionActionListener var2 = this.val$actionListener;
               if (var2 != null) {
                  var2.onComplete(Status.InternalError, var1);
               }

            }

            public void onSuccess(byte[] var1) {
               Constants.Status var2 = this.this$0.processApplyConfigResponse(var1);
               if (var2 == Status.Success) {
                  if (this.this$0.provisioningListener != null) {
                     this.this$0.provisioningListener.OnApplyConfigurationsSucceeded();
                  }
               } else if (this.this$0.provisioningListener != null) {
                  this.this$0.provisioningListener.OnApplyConfigurationsFailed();
               }

               ProvisionActionListener var3 = this.val$actionListener;
               if (var3 != null) {
                  var3.onComplete(var2, (Exception)null);
               }

            }
         });
      }

   }

   public void configureWifi(String var1, String var2, ProvisionActionListener var3) {
      if (this.session.isEstablished()) {
         byte[] var4 = this.createSetWifiConfigRequest(var1, var2);
         this.transport.sendConfigData("prov-config", var4, new ResponseListener(this, var3) {
            final Provision this$0;
            final ProvisionActionListener val$actionListener;

            {
               this.this$0 = var1;
               this.val$actionListener = var2;
            }

            public void onFailure(Exception var1) {
               if (this.this$0.provisioningListener != null) {
                  this.this$0.provisioningListener.OnProvisioningFailed(var1);
               }

               ProvisionActionListener var2 = this.val$actionListener;
               if (var2 != null) {
                  var2.onComplete(Status.InternalError, var1);
               }

            }

            public void onSuccess(byte[] var1) {
               Constants.Status var2 = this.this$0.processSetWifiConfigResponse(var1);
               if (var2 != Status.Success && this.this$0.provisioningListener != null) {
                  this.this$0.provisioningListener.OnProvisioningFailed(new RuntimeException("Could not sent wifi credentials to device"));
               }

               ProvisionActionListener var3 = this.val$actionListener;
               if (var3 != null) {
                  var3.onComplete(var2, (Exception)null);
               }

            }
         });
      }

   }

   public void pollForWifiConnectionStatus(WifiStateListener var1) {
      byte[] var2 = this.createGetWifiStatusRequest();
      StringBuilder var3 = new StringBuilder("pollForWifiConnectionStatus: message = ");
      var3.append(var2);
      var3.append(", wifiStateListener = ");
      var3.append(var1);
      Timber.d(var3.toString(), new Object[0]);
      this.transport.sendConfigData("prov-config", var2, new ResponseListener(this, var1) {
         final Provision this$0;
         final WifiStateListener val$wifiStateListener;

         {
            this.this$0 = var1;
            this.val$wifiStateListener = var2;
         }

         public void onFailure(Exception var1) {
            Timber.e(var1, "pollForWifiConnectionStatus: onFailure", new Object[0]);
            this.val$wifiStateListener.onWifiStateUpdated(WifiStationState.Disconnected, WifiConnectFailedReason.UNRECOGNIZED, var1);
         }

         public void onSuccess(byte[] param1) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   public interface ProvisionActionListener {
      void onComplete(Constants.Status var1, Exception var2);
   }

   public interface ProvisioningListener {
      void OnApplyConfigurationsFailed();

      void OnApplyConfigurationsSucceeded();

      void OnProvisioningFailed(Exception var1);

      void OnWifiConnectionStatusUpdated(WifiConstants.WifiStationState var1, WifiConstants.WifiConnectFailedReason var2, Exception var3);
   }

   public interface WifiStateListener {
      void onWifiStateUpdated(WifiConstants.WifiStationState var1, WifiConstants.WifiConnectFailedReason var2, Exception var3);
   }
}
