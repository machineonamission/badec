package com.blueair.bluetooth.espressif;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

public class BLETransport implements Transport {
   private static final String TAG = "BLETransport";
   private BluetoothGatt bluetoothGatt;
   private ArrayList charUuidList = new ArrayList();
   private Context context;
   private BluetoothDevice currentDevice;
   private ResponseListener currentResponseListener;
   public ArrayList deviceCapabilities = new ArrayList();
   private ExecutorService dispatcherThreadPool;
   private BluetoothGattCallback gattCallback = new BluetoothGattCallback(this) {
      final BLETransport this$0;

      {
         this.this$0 = var1;
      }

      public void onCharacteristicChanged(BluetoothGatt var1, BluetoothGattCharacteristic var2) {
         Timber.d("onCharacteristicChanged", new Object[0]);
         super.onCharacteristicChanged(var1, var2);
      }

      public void onCharacteristicRead(BluetoothGatt var1, BluetoothGattCharacteristic var2, int var3) {
         StringBuilder var5 = new StringBuilder("onCharacteristicRead, status ");
         var5.append(var3);
         var5.append(" UUID : ");
         var5.append(var2.getUuid().toString());
         Timber.d(var5.toString(), new Object[0]);
         super.onCharacteristicRead(var1, var2, var3);
         if (((String)this.this$0.uuidMap.get("proto-ver")).equals(var2.getUuid().toString())) {
            String var10 = new String(var2.getValue(), StandardCharsets.UTF_8);
            Timber.d("Value : ".concat(var10), new Object[0]);

            label50: {
               JSONException var10000;
               label57: {
                  try {
                     JSONObject var18 = new JSONObject(var10);
                     JSONObject var11 = var18.getJSONObject("prov");
                     String var6 = var11.getString("ver");
                     StringBuilder var19 = new StringBuilder("Device Version : ");
                     var19.append(var6);
                     Timber.d(var19.toString(), new Object[0]);
                     var20 = var11.getJSONArray("cap");
                  } catch (JSONException var9) {
                     var10000 = var9;
                     boolean var10001 = false;
                     break label57;
                  }

                  int var4 = 0;

                  while(true) {
                     try {
                        if (var4 >= var20.length()) {
                           break;
                        }

                        var10 = var20.getString(var4);
                        this.this$0.deviceCapabilities.add(var10);
                     } catch (JSONException var8) {
                        var10000 = var8;
                        boolean var21 = false;
                        break label57;
                     }

                     ++var4;
                  }

                  try {
                     StringBuilder var14 = new StringBuilder();
                     var14.append("Capabilities : ");
                     var14.append(this.this$0.deviceCapabilities);
                     Timber.d(var14.toString(), new Object[0]);
                     break label50;
                  } catch (JSONException var7) {
                     var10000 = var7;
                     boolean var22 = false;
                  }
               }

               JSONException var13 = var10000;
               var13.printStackTrace();
               Timber.d("Capabilities JSON not available.", new Object[0]);
            }

            if (this.this$0.transportListener != null) {
               if (this.this$0.uuidMap.containsKey("prov-session")) {
                  StringBuilder var15 = new StringBuilder("Session characteristic not NULL ");
                  var15.append(this.this$0.currentDevice.getAddress());
                  Timber.d(var15.toString(), new Object[0]);
                  this.this$0.transportListener.onPeripheralConfigured(this.this$0.currentDevice);
               } else {
                  Timber.d("Session characteristic is NULL", new Object[0]);
                  this.this$0.transportListener.onPeripheralNotConfigured(this.this$0.currentDevice);
               }
            }
         }

         StringBuilder var16 = new StringBuilder("onCharacteristicRead: status = ");
         var16.append(var3);
         var16.append(", currentResponseListener = ");
         var16.append(this.this$0.currentResponseListener);
         Timber.d(var16.toString(), new Object[0]);
         if (this.this$0.currentResponseListener != null) {
            if (var3 == 0) {
               ResponseListener var17 = this.this$0.currentResponseListener;
               Timber.d("onCharacteristicRead: submit responseListener.onSuccess", new Object[0]);
               this.this$0.dispatcherThreadPool.submit(new Runnable(this, var2, var17) {
                  final <undefinedtype> this$1;
                  final BluetoothGattCharacteristic val$characteristic;
                  final ResponseListener val$responseListener;

                  {
                     this.this$1 = var1;
                     this.val$characteristic = var2;
                     this.val$responseListener = var3;
                  }

                  public void run() {
                     byte[] var2 = this.val$characteristic.getValue();
                     StringBuilder var1 = new StringBuilder("onCharacteristicRead: dispatcherThreadPool.submit : charValue = ");
                     var1.append(var2);
                     Timber.d(var1.toString(), new Object[0]);
                     this.val$responseListener.onSuccess(var2);
                  }
               });
               this.this$0.currentResponseListener = null;
            } else {
               this.this$0.currentResponseListener.onFailure(new Exception("Read from BLE failed"));
            }
         }

         this.this$0.transportToken.release();
      }

      public void onCharacteristicWrite(BluetoothGatt var1, BluetoothGattCharacteristic var2, int var3) {
         StringBuilder var4 = new StringBuilder("onCharacteristicWrite, status : ");
         var4.append(var3);
         Timber.d(var4.toString(), new Object[0]);
         var4 = new StringBuilder("UUID : ");
         var4.append(var2.getUuid().toString());
         Timber.d(var4.toString(), new Object[0]);
         if (var3 == 0) {
            this.this$0.bluetoothGatt.readCharacteristic(var2);
         } else {
            if (this.this$0.currentResponseListener != null) {
               this.this$0.currentResponseListener.onFailure(new Exception("Write to BLE failed"));
            }

            this.this$0.transportToken.release();
         }
      }

      public void onConnectionStateChange(BluetoothGatt var1, int var2, int var3) {
         super.onConnectionStateChange(var1, var2, var3);
         StringBuilder var4 = new StringBuilder("onConnectionStateChange, New state : ");
         var4.append(var3);
         var4.append(", Status : ");
         var4.append(var2);
         Timber.d(var4.toString(), new Object[0]);
         if (var2 != 0) {
            var1.close();
            if (this.this$0.transportListener != null) {
               this.this$0.transportListener.onFailure(new Exception("GATT failure in connection"));
               return;
            }
         } else {
            if (var3 == 2) {
               Timber.e("Connected to GATT server.", new Object[0]);
               var1.discoverServices();
               return;
            }

            if (var3 == 0) {
               Timber.e("Disconnected from GATT server.", new Object[0]);
               var1.close();
               if (this.this$0.transportListener != null) {
                  this.this$0.transportListener.onPeripheralDisconnected(new Exception("Bluetooth device disconnected"));
               }
            }
         }

      }

      public void onDescriptorRead(BluetoothGatt var1, BluetoothGattDescriptor var2, int var3) {
         StringBuilder var5 = new StringBuilder("DescriptorRead, : Status ");
         var5.append(var3);
         var5.append(" Data : ");
         var5.append(new String(var2.getValue(), StandardCharsets.UTF_8));
         Timber.d(var5.toString(), new Object[0]);
         if (var3 != 0) {
            Timber.e("Failed to read descriptor", new Object[0]);
         } else {
            String var4 = new String(var2.getValue(), StandardCharsets.UTF_8);
            this.this$0.uuidMap.put(var4, var2.getCharacteristic().getUuid().toString());
            var5 = new StringBuilder("Value : ");
            var5.append(var4);
            var5.append(" for UUID : ");
            var5.append(var2.getCharacteristic().getUuid().toString());
            Timber.d(var5.toString(), new Object[0]);
            if (this.this$0.isReadingDescriptors) {
               this.this$0.readNextDescriptor();
            } else {
               BluetoothGattCharacteristic var7 = this.this$0.service.getCharacteristic(UUID.fromString((String)this.this$0.uuidMap.get("proto-ver")));
               if (var7 != null) {
                  var7.setValue("ESP");
                  this.this$0.bluetoothGatt.writeCharacteristic(var7);
               }

            }
         }
      }

      public void onDescriptorWrite(BluetoothGatt var1, BluetoothGattDescriptor var2, int var3) {
         if (var3 == 0) {
            StringBuilder var4 = new StringBuilder("Read Descriptor : ");
            var4.append(this.this$0.bluetoothGatt.readDescriptor(var2));
            Timber.d(var4.toString(), new Object[0]);
         } else {
            Timber.e("Fail to read descriptor", new Object[0]);
         }
      }

      public void onMtuChanged(BluetoothGatt var1, int var2, int var3) {
         super.onMtuChanged(var1, var2, var3);
         if (var3 == 0) {
            StringBuilder var4 = new StringBuilder("Supported MTU = ");
            var4.append(var2);
            Timber.d(var4.toString(), new Object[0]);
         }

      }

      public void onServicesDiscovered(BluetoothGatt var1, int var2) {
         super.onServicesDiscovered(var1, var2);
         if (var2 != 0) {
            Timber.d("Status not success", new Object[0]);
         } else {
            BLETransport var3 = this.this$0;
            var3.service = var1.getService(UUID.fromString(var3.serviceUuid));
            if (this.this$0.service == null) {
               Timber.e("Service not found!", new Object[0]);
            } else {
               for(BluetoothGattCharacteristic var6 : this.this$0.service.getCharacteristics()) {
                  if (var6 == null) {
                     Timber.e("Tx characteristic not found!", new Object[0]);
                     return;
                  }

                  String var4 = var6.getUuid().toString();
                  StringBuilder var5 = new StringBuilder("Characteristic UUID : ");
                  var5.append(var4);
                  Timber.d(var5.toString(), new Object[0]);
                  this.this$0.charUuidList.add(var4);
                  var6.setWriteType(2);
               }

               this.this$0.readNextDescriptor();
            }
         }
      }
   };
   private boolean isReadingDescriptors = false;
   private BluetoothGattService service;
   private String serviceUuid;
   private BLETransportListener transportListener;
   private Semaphore transportToken;
   private HashMap uuidMap = new HashMap();

   public BLETransport(Context var1, BLETransportListener var2) {
      this.context = var1;
      this.transportListener = var2;
      this.transportToken = new Semaphore(1);
      this.dispatcherThreadPool = Executors.newSingleThreadExecutor();
   }

   private void readNextDescriptor() {
      for(int var1 = 0; var1 < this.charUuidList.size(); ++var1) {
         String var2 = (String)this.charUuidList.get(var1);
         if (!this.uuidMap.containsValue(var2)) {
            BluetoothGattCharacteristic var5 = this.service.getCharacteristic(UUID.fromString(var2));
            if (var5 == null) {
               Timber.e("Tx characteristic not found!", new Object[0]);
               return;
            }

            for(BluetoothGattDescriptor var3 : var5.getDescriptors()) {
               StringBuilder var4 = new StringBuilder("Descriptor : ");
               var4.append(var3.getUuid().toString());
               Timber.d(var4.toString(), new Object[0]);
               var4 = new StringBuilder("Des read : ");
               var4.append(this.bluetoothGatt.readDescriptor(var3));
               Timber.d(var4.toString(), new Object[0]);
            }

            this.isReadingDescriptors = true;
            return;
         }
      }

      this.isReadingDescriptors = false;
      BluetoothGattCharacteristic var7 = this.service.getCharacteristic(UUID.fromString((String)this.uuidMap.get("proto-ver")));
      if (var7 != null) {
         var7.setValue("ESP");
         this.bluetoothGatt.writeCharacteristic(var7);
      }

   }

   public void connect(BluetoothDevice var1, UUID var2) {
      StringBuilder var3 = new StringBuilder("connect: bluetoothDevice = ");
      var3.append(var1.getName());
      var3.append(", primaryServiceUuid = ");
      var3.append(var2);
      Timber.d(var3.toString(), new Object[0]);
      this.currentDevice = var1;
      this.serviceUuid = var2.toString();
      this.bluetoothGatt = this.currentDevice.connectGatt(this.context, false, this.gattCallback, 2);
   }

   public void disconnect() {
      BluetoothGatt var1 = this.bluetoothGatt;
      if (var1 != null) {
         var1.disconnect();
         this.bluetoothGatt = null;
      }

   }

   public void sendConfigData(String var1, byte[] var2, ResponseListener var3) {
      StringBuilder var4 = new StringBuilder("sendConfigData: path = ");
      var4.append(var1);
      var4.append(", listenr = ");
      var4.append(var3);
      var4.append(", uuidMap.containsKey(path) = ");
      var4.append(this.uuidMap.containsKey(var1));
      Timber.d(var4.toString(), new Object[0]);
      if (this.uuidMap.containsKey(var1)) {
         BluetoothGattCharacteristic var8 = this.service.getCharacteristic(UUID.fromString((String)this.uuidMap.get(var1)));
         StringBuilder var6 = new StringBuilder("sendConfigData: characteristic (1) = ");
         var6.append(var8);
         Timber.d(var6.toString(), new Object[0]);
         BluetoothGattCharacteristic var7 = var8;
         if (var8 == null) {
            var7 = this.service.getCharacteristic(UUID.fromString("0000ff52-0000-1000-8000-00805f9b34fb"));
         }

         StringBuilder var9 = new StringBuilder("sendConfigData: characteristic (2) = ");
         var9.append(var7);
         Timber.d(var9.toString(), new Object[0]);
         if (var7 != null) {
            try {
               this.transportToken.acquire();
               var7.setValue(var2);
               this.bluetoothGatt.writeCharacteristic(var7);
               this.currentResponseListener = var3;
               return;
            } catch (Exception var5) {
               Timber.e(var5, "sendConfigData failed", new Object[0]);
               var3.onFailure(var5);
               this.transportToken.release();
               return;
            }
         }

         Timber.e("Characteristic is not available for given path.", new Object[0]);
      }

   }

   public void sendSessionData(byte[] var1, ResponseListener var2) {
      StringBuilder var3 = new StringBuilder("sendSessionData: data = ");
      var3.append(var1);
      var3.append(", listener = ");
      var3.append(var2);
      var3.append(", uuidMap.containsKey(AppConstants.HANDLER_PROV_SESSION) = ");
      var3.append(this.uuidMap.containsKey("prov-session"));
      Timber.d(var3.toString(), new Object[0]);
      if (this.uuidMap.containsKey("prov-session")) {
         BluetoothGattCharacteristic var4 = this.service.getCharacteristic(UUID.fromString((String)this.uuidMap.get("prov-session")));
         var3 = new StringBuilder("sendSessionData: sessionCharacteristic (1) = ");
         var3.append(var4);
         Timber.d(var3.toString(), new Object[0]);
         BluetoothGattCharacteristic var8 = var4;
         if (var4 == null) {
            var8 = this.service.getCharacteristic(UUID.fromString("0000ff51-0000-1000-8000-00805f9b34fb"));
         }

         StringBuilder var9 = new StringBuilder("sendSessionData: sessionCharacteristic (2) = ");
         var9.append(var8);
         Timber.d(var9.toString(), new Object[0]);
         if (var8 != null) {
            try {
               this.transportToken.acquire();
               var8.setValue(var1);
               this.bluetoothGatt.writeCharacteristic(var8);
               this.currentResponseListener = var2;
               StringBuilder var6 = new StringBuilder("sendSessionData: currentResponseListener = ");
               var6.append(this.currentResponseListener);
               Timber.d(var6.toString(), new Object[0]);
               return;
            } catch (Exception var5) {
               Timber.e(var5, "sendSessionData fail", new Object[0]);
               var2.onFailure(var5);
               this.transportToken.release();
               return;
            }
         }

         Timber.e("Session Characteristic is not available.", new Object[0]);
      }

   }

   public interface BLETransportListener {
      void onFailure(Exception var1);

      void onPeripheralConfigured(BluetoothDevice var1);

      void onPeripheralDisconnected(Exception var1);

      void onPeripheralNotConfigured(BluetoothDevice var1);
   }
}
