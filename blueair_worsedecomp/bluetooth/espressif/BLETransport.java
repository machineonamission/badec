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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

public class BLETransport implements Transport {
    private static final String TAG = "BLETransport";
    /* access modifiers changed from: private */
    public BluetoothGatt bluetoothGatt;
    /* access modifiers changed from: private */
    public ArrayList<String> charUuidList = new ArrayList<>();
    private Context context;
    /* access modifiers changed from: private */
    public BluetoothDevice currentDevice;
    /* access modifiers changed from: private */
    public ResponseListener currentResponseListener;
    public ArrayList<String> deviceCapabilities = new ArrayList<>();
    /* access modifiers changed from: private */
    public ExecutorService dispatcherThreadPool;
    private BluetoothGattCallback gattCallback = new BluetoothGattCallback() {
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onConnectionStateChange(bluetoothGatt, i, i2);
            Timber.d("onConnectionStateChange, New state : " + i2 + ", Status : " + i, new Object[0]);
            if (i != 0) {
                bluetoothGatt.close();
                if (BLETransport.this.transportListener != null) {
                    BLETransport.this.transportListener.onFailure(new Exception("GATT failure in connection"));
                }
            } else if (i2 == 2) {
                Timber.e("Connected to GATT server.", new Object[0]);
                bluetoothGatt.discoverServices();
            } else if (i2 == 0) {
                Timber.e("Disconnected from GATT server.", new Object[0]);
                bluetoothGatt.close();
                if (BLETransport.this.transportListener != null) {
                    BLETransport.this.transportListener.onPeripheralDisconnected(new Exception("Bluetooth device disconnected"));
                }
            }
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            super.onServicesDiscovered(bluetoothGatt, i);
            if (i != 0) {
                Timber.d("Status not success", new Object[0]);
                return;
            }
            BLETransport bLETransport = BLETransport.this;
            BluetoothGattService unused = bLETransport.service = bluetoothGatt.getService(UUID.fromString(bLETransport.serviceUuid));
            if (BLETransport.this.service == null) {
                Timber.e("Service not found!", new Object[0]);
                return;
            }
            for (BluetoothGattCharacteristic next : BLETransport.this.service.getCharacteristics()) {
                if (next == null) {
                    Timber.e("Tx characteristic not found!", new Object[0]);
                    return;
                }
                String uuid = next.getUuid().toString();
                Timber.d("Characteristic UUID : " + uuid, new Object[0]);
                BLETransport.this.charUuidList.add(uuid);
                next.setWriteType(2);
            }
            BLETransport.this.readNextDescriptor();
        }

        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (i == 0) {
                Timber.d("Read Descriptor : " + BLETransport.this.bluetoothGatt.readDescriptor(bluetoothGattDescriptor), new Object[0]);
                return;
            }
            Timber.e("Fail to read descriptor", new Object[0]);
        }

        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            Timber.d("DescriptorRead, : Status " + i + " Data : " + new String(bluetoothGattDescriptor.getValue(), StandardCharsets.UTF_8), new Object[0]);
            if (i != 0) {
                Timber.e("Failed to read descriptor", new Object[0]);
                return;
            }
            String str = new String(bluetoothGattDescriptor.getValue(), StandardCharsets.UTF_8);
            BLETransport.this.uuidMap.put(str, bluetoothGattDescriptor.getCharacteristic().getUuid().toString());
            Timber.d("Value : " + str + " for UUID : " + bluetoothGattDescriptor.getCharacteristic().getUuid().toString(), new Object[0]);
            if (BLETransport.this.isReadingDescriptors) {
                BLETransport.this.readNextDescriptor();
                return;
            }
            BluetoothGattCharacteristic characteristic = BLETransport.this.service.getCharacteristic(UUID.fromString((String) BLETransport.this.uuidMap.get(AppConstants.HANDLER_PROTO_VER)));
            if (characteristic != null) {
                characteristic.setValue("ESP");
                BLETransport.this.bluetoothGatt.writeCharacteristic(characteristic);
            }
        }

        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onMtuChanged(bluetoothGatt, i, i2);
            if (i2 == 0) {
                Timber.d("Supported MTU = " + i, new Object[0]);
            }
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            Timber.d("onCharacteristicChanged", new Object[0]);
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            Timber.d("onCharacteristicRead, status " + i + " UUID : " + bluetoothGattCharacteristic.getUuid().toString(), new Object[0]);
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            if (((String) BLETransport.this.uuidMap.get(AppConstants.HANDLER_PROTO_VER)).equals(bluetoothGattCharacteristic.getUuid().toString())) {
                String str = new String(bluetoothGattCharacteristic.getValue(), StandardCharsets.UTF_8);
                Timber.d("Value : ".concat(str), new Object[0]);
                try {
                    JSONObject jSONObject = new JSONObject(str).getJSONObject("prov");
                    String string = jSONObject.getString("ver");
                    Timber.d("Device Version : " + string, new Object[0]);
                    JSONArray jSONArray = jSONObject.getJSONArray("cap");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        BLETransport.this.deviceCapabilities.add(jSONArray.getString(i2));
                    }
                    Timber.d("Capabilities : " + BLETransport.this.deviceCapabilities, new Object[0]);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Timber.d("Capabilities JSON not available.", new Object[0]);
                }
                if (BLETransport.this.transportListener != null) {
                    if (BLETransport.this.uuidMap.containsKey(AppConstants.HANDLER_PROV_SESSION)) {
                        Timber.d("Session characteristic not NULL " + BLETransport.this.currentDevice.getAddress(), new Object[0]);
                        BLETransport.this.transportListener.onPeripheralConfigured(BLETransport.this.currentDevice);
                    } else {
                        Timber.d("Session characteristic is NULL", new Object[0]);
                        BLETransport.this.transportListener.onPeripheralNotConfigured(BLETransport.this.currentDevice);
                    }
                }
            }
            Timber.d("onCharacteristicRead: status = " + i + ", currentResponseListener = " + BLETransport.this.currentResponseListener, new Object[0]);
            if (BLETransport.this.currentResponseListener != null) {
                if (i == 0) {
                    final ResponseListener access$900 = BLETransport.this.currentResponseListener;
                    Timber.d("onCharacteristicRead: submit responseListener.onSuccess", new Object[0]);
                    BLETransport.this.dispatcherThreadPool.submit(new Runnable() {
                        public void run() {
                            byte[] value = bluetoothGattCharacteristic.getValue();
                            Timber.d("onCharacteristicRead: dispatcherThreadPool.submit : charValue = " + value, new Object[0]);
                            access$900.onSuccess(value);
                        }
                    });
                    ResponseListener unused = BLETransport.this.currentResponseListener = null;
                } else {
                    BLETransport.this.currentResponseListener.onFailure(new Exception("Read from BLE failed"));
                }
            }
            BLETransport.this.transportToken.release();
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            Timber.d("onCharacteristicWrite, status : " + i, new Object[0]);
            Timber.d("UUID : " + bluetoothGattCharacteristic.getUuid().toString(), new Object[0]);
            if (i == 0) {
                BLETransport.this.bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
                return;
            }
            if (BLETransport.this.currentResponseListener != null) {
                BLETransport.this.currentResponseListener.onFailure(new Exception("Write to BLE failed"));
            }
            BLETransport.this.transportToken.release();
        }
    };
    /* access modifiers changed from: private */
    public boolean isReadingDescriptors = false;
    /* access modifiers changed from: private */
    public BluetoothGattService service;
    /* access modifiers changed from: private */
    public String serviceUuid;
    /* access modifiers changed from: private */
    public BLETransportListener transportListener;
    /* access modifiers changed from: private */
    public Semaphore transportToken;
    /* access modifiers changed from: private */
    public HashMap<String, String> uuidMap = new HashMap<>();

    public interface BLETransportListener {
        void onFailure(Exception exc);

        void onPeripheralConfigured(BluetoothDevice bluetoothDevice);

        void onPeripheralDisconnected(Exception exc);

        void onPeripheralNotConfigured(BluetoothDevice bluetoothDevice);
    }

    public BLETransport(Context context2, BLETransportListener bLETransportListener) {
        this.context = context2;
        this.transportListener = bLETransportListener;
        this.transportToken = new Semaphore(1);
        this.dispatcherThreadPool = Executors.newSingleThreadExecutor();
    }

    public void sendSessionData(byte[] bArr, ResponseListener responseListener) {
        Timber.d("sendSessionData: data = " + bArr + ", listener = " + responseListener + ", uuidMap.containsKey(AppConstants.HANDLER_PROV_SESSION) = " + this.uuidMap.containsKey(AppConstants.HANDLER_PROV_SESSION), new Object[0]);
        if (this.uuidMap.containsKey(AppConstants.HANDLER_PROV_SESSION)) {
            BluetoothGattCharacteristic characteristic = this.service.getCharacteristic(UUID.fromString(this.uuidMap.get(AppConstants.HANDLER_PROV_SESSION)));
            Timber.d("sendSessionData: sessionCharacteristic (1) = " + characteristic, new Object[0]);
            if (characteristic == null) {
                characteristic = this.service.getCharacteristic(UUID.fromString("0000ff51-0000-1000-8000-00805f9b34fb"));
            }
            Timber.d("sendSessionData: sessionCharacteristic (2) = " + characteristic, new Object[0]);
            if (characteristic != null) {
                try {
                    this.transportToken.acquire();
                    characteristic.setValue(bArr);
                    this.bluetoothGatt.writeCharacteristic(characteristic);
                    this.currentResponseListener = responseListener;
                    Timber.d("sendSessionData: currentResponseListener = " + this.currentResponseListener, new Object[0]);
                } catch (Exception e) {
                    Timber.e(e, "sendSessionData fail", new Object[0]);
                    responseListener.onFailure(e);
                    this.transportToken.release();
                }
            } else {
                Timber.e("Session Characteristic is not available.", new Object[0]);
            }
        }
    }

    public void sendConfigData(String str, byte[] bArr, ResponseListener responseListener) {
        Timber.d("sendConfigData: path = " + str + ", listenr = " + responseListener + ", uuidMap.containsKey(path) = " + this.uuidMap.containsKey(str), new Object[0]);
        if (this.uuidMap.containsKey(str)) {
            BluetoothGattCharacteristic characteristic = this.service.getCharacteristic(UUID.fromString(this.uuidMap.get(str)));
            Timber.d("sendConfigData: characteristic (1) = " + characteristic, new Object[0]);
            if (characteristic == null) {
                characteristic = this.service.getCharacteristic(UUID.fromString("0000ff52-0000-1000-8000-00805f9b34fb"));
            }
            Timber.d("sendConfigData: characteristic (2) = " + characteristic, new Object[0]);
            if (characteristic != null) {
                try {
                    this.transportToken.acquire();
                    characteristic.setValue(bArr);
                    this.bluetoothGatt.writeCharacteristic(characteristic);
                    this.currentResponseListener = responseListener;
                } catch (Exception e) {
                    Timber.e(e, "sendConfigData failed", new Object[0]);
                    responseListener.onFailure(e);
                    this.transportToken.release();
                }
            } else {
                Timber.e("Characteristic is not available for given path.", new Object[0]);
            }
        }
    }

    public void connect(BluetoothDevice bluetoothDevice, UUID uuid) {
        Timber.d("connect: bluetoothDevice = " + bluetoothDevice.getName() + ", primaryServiceUuid = " + uuid, new Object[0]);
        this.currentDevice = bluetoothDevice;
        this.serviceUuid = uuid.toString();
        this.bluetoothGatt = this.currentDevice.connectGatt(this.context, false, this.gattCallback, 2);
    }

    public void disconnect() {
        BluetoothGatt bluetoothGatt2 = this.bluetoothGatt;
        if (bluetoothGatt2 != null) {
            bluetoothGatt2.disconnect();
            this.bluetoothGatt = null;
        }
    }

    /* access modifiers changed from: private */
    public void readNextDescriptor() {
        for (int i = 0; i < this.charUuidList.size(); i++) {
            String str = this.charUuidList.get(i);
            if (!this.uuidMap.containsValue(str)) {
                BluetoothGattCharacteristic characteristic = this.service.getCharacteristic(UUID.fromString(str));
                if (characteristic == null) {
                    Timber.e("Tx characteristic not found!", new Object[0]);
                    return;
                }
                for (BluetoothGattDescriptor next : characteristic.getDescriptors()) {
                    Timber.d("Descriptor : " + next.getUuid().toString(), new Object[0]);
                    Timber.d("Des read : " + this.bluetoothGatt.readDescriptor(next), new Object[0]);
                }
                this.isReadingDescriptors = true;
                return;
            }
        }
        this.isReadingDescriptors = false;
        BluetoothGattCharacteristic characteristic2 = this.service.getCharacteristic(UUID.fromString(this.uuidMap.get(AppConstants.HANDLER_PROTO_VER)));
        if (characteristic2 != null) {
            characteristic2.setValue("ESP");
            this.bluetoothGatt.writeCharacteristic(characteristic2);
        }
    }
}
